package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.bundle.BundleCallback;
import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.NamedQuery;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.core.TargetIdGenerator;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.PatchMutation;
import com.google.firebase.firestore.model.mutation.Precondition;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Supplier;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.AbstractC1062i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class LocalStore implements BundleCallback {
    private static final long RESUME_TOKEN_MAX_AGE_SECONDS = TimeUnit.MINUTES.toSeconds(5);
    private final BundleCache bundleCache;
    private DocumentOverlayCache documentOverlayCache;
    private GlobalsCache globalsCache;
    private IndexManager indexManager;
    private LocalDocumentsView localDocuments;
    private final ReferenceSet localViewReferences;
    private MutationQueue mutationQueue;
    private final Persistence persistence;
    private final SparseArray<TargetData> queryDataByTarget;
    private final QueryEngine queryEngine;
    private final RemoteDocumentCache remoteDocuments;
    private final TargetCache targetCache;
    private final Map<Target, Integer> targetIdByTarget;
    private final TargetIdGenerator targetIdGenerator;

    public static class AllocateQueryHolder {
        TargetData cached;
        int targetId;

        private AllocateQueryHolder() {
        }
    }

    public static class DocumentChangeResult {
        private final Map<DocumentKey, MutableDocument> changedDocuments;
        private final Set<DocumentKey> existenceChangedKeys;

        private DocumentChangeResult(Map<DocumentKey, MutableDocument> map, Set<DocumentKey> set) {
            this.changedDocuments = map;
            this.existenceChangedKeys = set;
        }
    }

    public LocalStore(Persistence persistence, QueryEngine queryEngine, User user) {
        Assert.hardAssert(persistence.isStarted(), "LocalStore was passed an unstarted persistence implementation", new Object[0]);
        this.persistence = persistence;
        this.queryEngine = queryEngine;
        this.globalsCache = persistence.getGlobalsCache();
        TargetCache targetCache = persistence.getTargetCache();
        this.targetCache = targetCache;
        this.bundleCache = persistence.getBundleCache();
        this.targetIdGenerator = TargetIdGenerator.forTargetCache(targetCache.getHighestTargetId());
        this.remoteDocuments = persistence.getRemoteDocumentCache();
        ReferenceSet referenceSet = new ReferenceSet();
        this.localViewReferences = referenceSet;
        this.queryDataByTarget = new SparseArray<>();
        this.targetIdByTarget = new HashMap();
        persistence.getReferenceDelegate().setInMemoryPins(referenceSet);
        initializeUserComponents(user);
    }

    public static /* synthetic */ ImmutableSortedMap a(LocalStore localStore, int i4) {
        MutationBatch mutationBatchLookupMutationBatch = localStore.mutationQueue.lookupMutationBatch(i4);
        Assert.hardAssert(mutationBatchLookupMutationBatch != null, "Attempt to reject nonexistent batch!", new Object[0]);
        localStore.mutationQueue.removeMutationBatch(mutationBatchLookupMutationBatch);
        localStore.mutationQueue.performConsistencyCheck();
        localStore.documentOverlayCache.removeOverlaysForBatchId(i4);
        localStore.localDocuments.recalculateAndSaveOverlays(mutationBatchLookupMutationBatch.getKeys());
        return localStore.localDocuments.getDocuments(mutationBatchLookupMutationBatch.getKeys());
    }

    private void applyWriteToRemoteDocuments(MutationBatchResult mutationBatchResult) {
        MutationBatch batch = mutationBatchResult.getBatch();
        for (DocumentKey documentKey : batch.getKeys()) {
            MutableDocument mutableDocument = this.remoteDocuments.get(documentKey);
            SnapshotVersion snapshotVersion = mutationBatchResult.getDocVersions().get(documentKey);
            Assert.hardAssert(snapshotVersion != null, "docVersions should contain every doc in the write.", new Object[0]);
            if (mutableDocument.getVersion().compareTo(snapshotVersion) < 0) {
                batch.applyToRemoteDocument(mutableDocument, mutationBatchResult);
                if (mutableDocument.isValidDocument()) {
                    this.remoteDocuments.add(mutableDocument, mutationBatchResult.getCommitVersion());
                }
            }
        }
        this.mutationQueue.removeMutationBatch(batch);
    }

    public static /* synthetic */ void b(LocalStore localStore, int i4) {
        TargetData targetData = localStore.queryDataByTarget.get(i4);
        Assert.hardAssert(targetData != null, "Tried to release nonexistent target: %s", Integer.valueOf(i4));
        Iterator<DocumentKey> it = localStore.localViewReferences.removeReferencesForId(i4).iterator();
        while (it.hasNext()) {
            localStore.persistence.getReferenceDelegate().removeReference(it.next());
        }
        localStore.persistence.getReferenceDelegate().removeTarget(targetData);
        localStore.queryDataByTarget.remove(i4);
        localStore.targetIdByTarget.remove(targetData.getTarget());
    }

    public static /* synthetic */ void c(LocalStore localStore, List list) {
        localStore.getClass();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LocalViewChanges localViewChanges = (LocalViewChanges) it.next();
            int targetId = localViewChanges.getTargetId();
            localStore.localViewReferences.addReferences(localViewChanges.getAdded(), targetId);
            ImmutableSortedSet<DocumentKey> removed = localViewChanges.getRemoved();
            Iterator<DocumentKey> it2 = removed.iterator();
            while (it2.hasNext()) {
                localStore.persistence.getReferenceDelegate().removeReference(it2.next());
            }
            localStore.localViewReferences.removeReferences(removed, targetId);
            if (!localViewChanges.isFromCache()) {
                TargetData targetData = localStore.queryDataByTarget.get(targetId);
                Assert.hardAssert(targetData != null, "Can't set limbo-free snapshot version for unknown target: %s", Integer.valueOf(targetId));
                TargetData targetDataWithLastLimboFreeSnapshotVersion = targetData.withLastLimboFreeSnapshotVersion(targetData.getSnapshotVersion());
                localStore.queryDataByTarget.put(targetId, targetDataWithLastLimboFreeSnapshotVersion);
                if (shouldPersistTargetData(targetData, targetDataWithLastLimboFreeSnapshotVersion, null)) {
                    localStore.targetCache.updateTargetData(targetDataWithLastLimboFreeSnapshotVersion);
                }
            }
        }
    }

    public static /* synthetic */ LocalDocumentsResult d(LocalStore localStore, Set set, List list, Timestamp timestamp) {
        Map<DocumentKey, MutableDocument> all = localStore.remoteDocuments.getAll(set);
        HashSet hashSet = new HashSet();
        for (Map.Entry<DocumentKey, MutableDocument> entry : all.entrySet()) {
            if (!entry.getValue().isValidDocument()) {
                hashSet.add(entry.getKey());
            }
        }
        Map<DocumentKey, OverlayedDocument> overlayedDocuments = localStore.localDocuments.getOverlayedDocuments(all);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Mutation mutation = (Mutation) it.next();
            ObjectValue objectValueExtractTransformBaseValue = mutation.extractTransformBaseValue(overlayedDocuments.get(mutation.getKey()).getDocument());
            if (objectValueExtractTransformBaseValue != null) {
                arrayList.add(new PatchMutation(mutation.getKey(), objectValueExtractTransformBaseValue, objectValueExtractTransformBaseValue.getFieldMask(), Precondition.exists(true)));
            }
        }
        MutationBatch mutationBatchAddMutationBatch = localStore.mutationQueue.addMutationBatch(timestamp, arrayList, list);
        localStore.documentOverlayCache.saveOverlays(mutationBatchAddMutationBatch.getBatchId(), mutationBatchAddMutationBatch.applyToLocalDocumentSet(overlayedDocuments, hashSet));
        return LocalDocumentsResult.fromOverlayedDocuments(mutationBatchAddMutationBatch.getBatchId(), overlayedDocuments);
    }

    public static /* synthetic */ Boolean f(LocalStore localStore, BundleMetadata bundleMetadata) {
        BundleMetadata bundleMetadata2 = localStore.bundleCache.getBundleMetadata(bundleMetadata.getBundleId());
        return Boolean.valueOf(bundleMetadata2 != null && bundleMetadata2.getCreateTime().compareTo(bundleMetadata.getCreateTime()) >= 0);
    }

    public static /* synthetic */ ImmutableSortedMap g(LocalStore localStore, RemoteEvent remoteEvent, SnapshotVersion snapshotVersion) {
        localStore.getClass();
        Map<Integer, TargetChange> targetChanges = remoteEvent.getTargetChanges();
        long currentSequenceNumber = localStore.persistence.getReferenceDelegate().getCurrentSequenceNumber();
        for (Map.Entry<Integer, TargetChange> entry : targetChanges.entrySet()) {
            Integer key = entry.getKey();
            int iIntValue = key.intValue();
            TargetChange value = entry.getValue();
            TargetData targetData = localStore.queryDataByTarget.get(iIntValue);
            if (targetData != null) {
                localStore.targetCache.removeMatchingKeys(value.getRemovedDocuments(), iIntValue);
                localStore.targetCache.addMatchingKeys(value.getAddedDocuments(), iIntValue);
                TargetData targetDataWithSequenceNumber = targetData.withSequenceNumber(currentSequenceNumber);
                if (remoteEvent.getTargetMismatches().containsKey(key)) {
                    AbstractC1062i abstractC1062i = AbstractC1062i.f11025b;
                    SnapshotVersion snapshotVersion2 = SnapshotVersion.NONE;
                    targetDataWithSequenceNumber = targetDataWithSequenceNumber.withResumeToken(abstractC1062i, snapshotVersion2).withLastLimboFreeSnapshotVersion(snapshotVersion2);
                } else if (!value.getResumeToken().isEmpty()) {
                    targetDataWithSequenceNumber = targetDataWithSequenceNumber.withResumeToken(value.getResumeToken(), remoteEvent.getSnapshotVersion());
                }
                localStore.queryDataByTarget.put(iIntValue, targetDataWithSequenceNumber);
                if (shouldPersistTargetData(targetData, targetDataWithSequenceNumber, value)) {
                    localStore.targetCache.updateTargetData(targetDataWithSequenceNumber);
                }
            }
        }
        Map<DocumentKey, MutableDocument> documentUpdates = remoteEvent.getDocumentUpdates();
        Set<DocumentKey> resolvedLimboDocuments = remoteEvent.getResolvedLimboDocuments();
        for (DocumentKey documentKey : documentUpdates.keySet()) {
            if (resolvedLimboDocuments.contains(documentKey)) {
                localStore.persistence.getReferenceDelegate().updateLimboDocument(documentKey);
            }
        }
        DocumentChangeResult documentChangeResultPopulateDocumentChanges = localStore.populateDocumentChanges(documentUpdates);
        Map<DocumentKey, MutableDocument> map = documentChangeResultPopulateDocumentChanges.changedDocuments;
        SnapshotVersion lastRemoteSnapshotVersion = localStore.targetCache.getLastRemoteSnapshotVersion();
        if (!snapshotVersion.equals(SnapshotVersion.NONE)) {
            Assert.hardAssert(snapshotVersion.compareTo(lastRemoteSnapshotVersion) >= 0, "Watch stream reverted to previous snapshot?? (%s < %s)", snapshotVersion, lastRemoteSnapshotVersion);
            localStore.targetCache.setLastRemoteSnapshotVersion(snapshotVersion);
        }
        return localStore.localDocuments.getLocalViewOfDocuments(map, documentChangeResultPopulateDocumentChanges.existenceChangedKeys);
    }

    private Set<DocumentKey> getKeysWithTransformResults(MutationBatchResult mutationBatchResult) {
        HashSet hashSet = new HashSet();
        for (int i4 = 0; i4 < mutationBatchResult.getMutationResults().size(); i4++) {
            if (!mutationBatchResult.getMutationResults().get(i4).getTransformResults().isEmpty()) {
                hashSet.add(mutationBatchResult.getBatch().getMutations().get(i4).getKey());
            }
        }
        return hashSet;
    }

    public static /* synthetic */ void i(LocalStore localStore, NamedQuery namedQuery, TargetData targetData, int i4, ImmutableSortedSet immutableSortedSet) {
        localStore.getClass();
        if (namedQuery.getReadTime().compareTo(targetData.getSnapshotVersion()) > 0) {
            TargetData targetDataWithResumeToken = targetData.withResumeToken(AbstractC1062i.f11025b, namedQuery.getReadTime());
            localStore.queryDataByTarget.append(i4, targetDataWithResumeToken);
            localStore.targetCache.updateTargetData(targetDataWithResumeToken);
            localStore.targetCache.removeMatchingKeysForTargetId(i4);
            localStore.targetCache.addMatchingKeys(immutableSortedSet, i4);
        }
        localStore.bundleCache.saveNamedQuery(namedQuery);
    }

    private void initializeUserComponents(User user) {
        IndexManager indexManager = this.persistence.getIndexManager(user);
        this.indexManager = indexManager;
        this.mutationQueue = this.persistence.getMutationQueue(user, indexManager);
        DocumentOverlayCache documentOverlayCache = this.persistence.getDocumentOverlayCache(user);
        this.documentOverlayCache = documentOverlayCache;
        this.localDocuments = new LocalDocumentsView(this.remoteDocuments, this.mutationQueue, documentOverlayCache, this.indexManager);
        this.remoteDocuments.setIndexManager(this.indexManager);
        this.queryEngine.initialize(this.localDocuments, this.indexManager);
    }

    public static /* synthetic */ ImmutableSortedMap j(LocalStore localStore, ImmutableSortedMap immutableSortedMap, TargetData targetData) {
        localStore.getClass();
        ImmutableSortedSet<DocumentKey> immutableSortedSetEmptyKeySet = DocumentKey.emptyKeySet();
        HashMap map = new HashMap();
        Iterator it = immutableSortedMap.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            DocumentKey documentKey = (DocumentKey) entry.getKey();
            MutableDocument mutableDocument = (MutableDocument) entry.getValue();
            if (mutableDocument.isFoundDocument()) {
                immutableSortedSetEmptyKeySet = immutableSortedSetEmptyKeySet.insert(documentKey);
            }
            map.put(documentKey, mutableDocument);
        }
        localStore.targetCache.removeMatchingKeysForTargetId(targetData.getTargetId());
        localStore.targetCache.addMatchingKeys(immutableSortedSetEmptyKeySet, targetData.getTargetId());
        DocumentChangeResult documentChangeResultPopulateDocumentChanges = localStore.populateDocumentChanges(map);
        return localStore.localDocuments.getLocalViewOfDocuments(documentChangeResultPopulateDocumentChanges.changedDocuments, documentChangeResultPopulateDocumentChanges.existenceChangedKeys);
    }

    public static /* synthetic */ ImmutableSortedMap l(LocalStore localStore, MutationBatchResult mutationBatchResult) {
        localStore.getClass();
        MutationBatch batch = mutationBatchResult.getBatch();
        localStore.mutationQueue.acknowledgeBatch(batch, mutationBatchResult.getStreamToken());
        localStore.applyWriteToRemoteDocuments(mutationBatchResult);
        localStore.mutationQueue.performConsistencyCheck();
        localStore.documentOverlayCache.removeOverlaysForBatchId(mutationBatchResult.getBatch().getBatchId());
        localStore.localDocuments.recalculateAndSaveOverlays(localStore.getKeysWithTransformResults(mutationBatchResult));
        return localStore.localDocuments.getDocuments(batch.getKeys());
    }

    public static /* synthetic */ void n(LocalStore localStore, AllocateQueryHolder allocateQueryHolder, Target target) {
        int iNextId = localStore.targetIdGenerator.nextId();
        allocateQueryHolder.targetId = iNextId;
        TargetData targetData = new TargetData(target, iNextId, localStore.persistence.getReferenceDelegate().getCurrentSequenceNumber(), QueryPurpose.LISTEN);
        allocateQueryHolder.cached = targetData;
        localStore.targetCache.addTargetData(targetData);
    }

    private static Target newUmbrellaTarget(String str) {
        return Query.atPath(ResourcePath.fromString("__bundle__/docs/" + str)).toTarget();
    }

    public static /* synthetic */ void p(LocalStore localStore, List list) {
        Collection<FieldIndex> fieldIndexes = localStore.indexManager.getFieldIndexes();
        Comparator<FieldIndex> comparator = FieldIndex.SEMANTIC_COMPARATOR;
        final IndexManager indexManager = localStore.indexManager;
        Objects.requireNonNull(indexManager);
        Consumer consumer = new Consumer() { // from class: com.google.firebase.firestore.local.g
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                indexManager.addFieldIndex((FieldIndex) obj);
            }
        };
        final IndexManager indexManager2 = localStore.indexManager;
        Objects.requireNonNull(indexManager2);
        Util.diffCollections(fieldIndexes, list, comparator, consumer, new Consumer() { // from class: com.google.firebase.firestore.local.r
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                indexManager2.deleteFieldIndex((FieldIndex) obj);
            }
        });
    }

    private DocumentChangeResult populateDocumentChanges(Map<DocumentKey, MutableDocument> map) {
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Map<DocumentKey, MutableDocument> all = this.remoteDocuments.getAll(map.keySet());
        for (Map.Entry<DocumentKey, MutableDocument> entry : map.entrySet()) {
            DocumentKey key = entry.getKey();
            MutableDocument value = entry.getValue();
            MutableDocument mutableDocument = all.get(key);
            if (value.isFoundDocument() != mutableDocument.isFoundDocument()) {
                hashSet.add(key);
            }
            if (value.isNoDocument() && value.getVersion().equals(SnapshotVersion.NONE)) {
                arrayList.add(value.getKey());
                map2.put(key, value);
            } else if (!mutableDocument.isValidDocument() || value.getVersion().compareTo(mutableDocument.getVersion()) > 0 || (value.getVersion().compareTo(mutableDocument.getVersion()) == 0 && mutableDocument.hasPendingWrites())) {
                Assert.hardAssert(!SnapshotVersion.NONE.equals(value.getReadTime()), "Cannot add a document when the remote version is zero", new Object[0]);
                this.remoteDocuments.add(value, value.getReadTime());
                map2.put(key, value);
            } else {
                Logger.debug("LocalStore", "Ignoring outdated watch update for %s.Current version: %s  Watch version: %s", key, mutableDocument.getVersion(), value.getVersion());
            }
        }
        this.remoteDocuments.removeAll(arrayList);
        return new DocumentChangeResult(map2, hashSet);
    }

    private static boolean shouldPersistTargetData(TargetData targetData, TargetData targetData2, TargetChange targetChange) {
        if (targetData.getResumeToken().isEmpty()) {
            return true;
        }
        long seconds = targetData2.getSnapshotVersion().getTimestamp().getSeconds() - targetData.getSnapshotVersion().getTimestamp().getSeconds();
        long j4 = RESUME_TOKEN_MAX_AGE_SECONDS;
        if (seconds < j4 && targetData2.getLastLimboFreeSnapshotVersion().getTimestamp().getSeconds() - targetData.getLastLimboFreeSnapshotVersion().getTimestamp().getSeconds() < j4) {
            return targetChange != null && (targetChange.getAddedDocuments().size() + targetChange.getModifiedDocuments().size()) + targetChange.getRemovedDocuments().size() > 0;
        }
        return true;
    }

    private void startIndexManager() {
        this.persistence.runTransaction("Start IndexManager", new Runnable() { // from class: com.google.firebase.firestore.local.i
            @Override // java.lang.Runnable
            public final void run() {
                this.f10579a.indexManager.start();
            }
        });
    }

    private void startMutationQueue() {
        this.persistence.runTransaction("Start MutationQueue", new Runnable() { // from class: com.google.firebase.firestore.local.m
            @Override // java.lang.Runnable
            public final void run() {
                this.f10593a.mutationQueue.start();
            }
        });
    }

    public ImmutableSortedMap<DocumentKey, Document> acknowledgeBatch(final MutationBatchResult mutationBatchResult) {
        return (ImmutableSortedMap) this.persistence.runTransaction("Acknowledge batch", new Supplier() { // from class: com.google.firebase.firestore.local.l
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return LocalStore.l(this.f10590a, mutationBatchResult);
            }
        });
    }

    public TargetData allocateTarget(final Target target) {
        int targetId;
        TargetData targetData = this.targetCache.getTargetData(target);
        if (targetData != null) {
            targetId = targetData.getTargetId();
        } else {
            final AllocateQueryHolder allocateQueryHolder = new AllocateQueryHolder();
            this.persistence.runTransaction("Allocate target", new Runnable() { // from class: com.google.firebase.firestore.local.n
                @Override // java.lang.Runnable
                public final void run() {
                    LocalStore.n(this.f10597a, allocateQueryHolder, target);
                }
            });
            targetId = allocateQueryHolder.targetId;
            targetData = allocateQueryHolder.cached;
        }
        if (this.queryDataByTarget.get(targetId) == null) {
            this.queryDataByTarget.put(targetId, targetData);
            this.targetIdByTarget.put(target, Integer.valueOf(targetId));
        }
        return targetData;
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public ImmutableSortedMap<DocumentKey, Document> applyBundledDocuments(final ImmutableSortedMap<DocumentKey, MutableDocument> immutableSortedMap, String str) {
        final TargetData targetDataAllocateTarget = allocateTarget(newUmbrellaTarget(str));
        return (ImmutableSortedMap) this.persistence.runTransaction("Apply bundle documents", new Supplier() { // from class: com.google.firebase.firestore.local.v
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return LocalStore.j(this.f10631a, immutableSortedMap, targetDataAllocateTarget);
            }
        });
    }

    public ImmutableSortedMap<DocumentKey, Document> applyRemoteEvent(final RemoteEvent remoteEvent) {
        final SnapshotVersion snapshotVersion = remoteEvent.getSnapshotVersion();
        return (ImmutableSortedMap) this.persistence.runTransaction("Apply remote event", new Supplier() { // from class: com.google.firebase.firestore.local.u
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return LocalStore.g(this.f10623a, remoteEvent, snapshotVersion);
            }
        });
    }

    public LruGarbageCollector.Results collectGarbage(final LruGarbageCollector lruGarbageCollector) {
        return (LruGarbageCollector.Results) this.persistence.runTransaction("Collect garbage", new Supplier() { // from class: com.google.firebase.firestore.local.t
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return lruGarbageCollector.collect(this.f10615a.queryDataByTarget);
            }
        });
    }

    public void configureFieldIndexes(final List<FieldIndex> list) {
        this.persistence.runTransaction("Configure indexes", new Runnable() { // from class: com.google.firebase.firestore.local.y
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.p(this.f10643a, list);
            }
        });
    }

    public void deleteAllFieldIndexes() {
        this.persistence.runTransaction("Delete All Indexes", new Runnable() { // from class: com.google.firebase.firestore.local.w
            @Override // java.lang.Runnable
            public final void run() {
                this.f10637a.indexManager.deleteAllFieldIndexes();
            }
        });
    }

    public QueryResult executeQuery(Query query, boolean z4) {
        ImmutableSortedSet<DocumentKey> matchingKeysForTargetId;
        SnapshotVersion lastLimboFreeSnapshotVersion;
        TargetData targetData = getTargetData(query.toTarget());
        SnapshotVersion snapshotVersion = SnapshotVersion.NONE;
        ImmutableSortedSet<DocumentKey> immutableSortedSetEmptyKeySet = DocumentKey.emptyKeySet();
        if (targetData != null) {
            lastLimboFreeSnapshotVersion = targetData.getLastLimboFreeSnapshotVersion();
            matchingKeysForTargetId = this.targetCache.getMatchingKeysForTargetId(targetData.getTargetId());
        } else {
            matchingKeysForTargetId = immutableSortedSetEmptyKeySet;
            lastLimboFreeSnapshotVersion = snapshotVersion;
        }
        QueryEngine queryEngine = this.queryEngine;
        if (z4) {
            snapshotVersion = lastLimboFreeSnapshotVersion;
        }
        return new QueryResult(queryEngine.getDocumentsMatchingQuery(query, snapshotVersion, matchingKeysForTargetId), matchingKeysForTargetId);
    }

    public Collection<FieldIndex> getFieldIndexes() {
        return (Collection) this.persistence.runTransaction("Get indexes", new Supplier() { // from class: com.google.firebase.firestore.local.A
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return this.f10488a.indexManager.getFieldIndexes();
            }
        });
    }

    public int getHighestUnacknowledgedBatchId() {
        return this.mutationQueue.getHighestUnacknowledgedBatchId();
    }

    public IndexManager getIndexManagerForCurrentUser() {
        return this.indexManager;
    }

    public SnapshotVersion getLastRemoteSnapshotVersion() {
        return this.targetCache.getLastRemoteSnapshotVersion();
    }

    public AbstractC1062i getLastStreamToken() {
        return this.mutationQueue.getLastStreamToken();
    }

    public LocalDocumentsView getLocalDocumentsForCurrentUser() {
        return this.localDocuments;
    }

    public NamedQuery getNamedQuery(final String str) {
        return (NamedQuery) this.persistence.runTransaction("Get named query", new Supplier() { // from class: com.google.firebase.firestore.local.h
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return this.f10575a.bundleCache.getNamedQuery(str);
            }
        });
    }

    public MutationBatch getNextMutationBatch(int i4) {
        return this.mutationQueue.getNextMutationBatchAfterBatchId(i4);
    }

    public ImmutableSortedSet<DocumentKey> getRemoteDocumentKeys(int i4) {
        return this.targetCache.getMatchingKeysForTargetId(i4);
    }

    public AbstractC1062i getSessionToken() {
        return this.globalsCache.getSessionsToken();
    }

    public TargetData getTargetData(Target target) {
        Integer num = this.targetIdByTarget.get(target);
        return num != null ? this.queryDataByTarget.get(num.intValue()) : this.targetCache.getTargetData(target);
    }

    public ImmutableSortedMap<DocumentKey, Document> handleUserChange(User user) {
        List<MutationBatch> allMutationBatches = this.mutationQueue.getAllMutationBatches();
        initializeUserComponents(user);
        startIndexManager();
        startMutationQueue();
        List<MutationBatch> allMutationBatches2 = this.mutationQueue.getAllMutationBatches();
        ImmutableSortedSet<DocumentKey> immutableSortedSetEmptyKeySet = DocumentKey.emptyKeySet();
        Iterator it = Arrays.asList(allMutationBatches, allMutationBatches2).iterator();
        while (it.hasNext()) {
            Iterator it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                Iterator<Mutation> it3 = ((MutationBatch) it2.next()).getMutations().iterator();
                while (it3.hasNext()) {
                    immutableSortedSetEmptyKeySet = immutableSortedSetEmptyKeySet.insert(it3.next().getKey());
                }
            }
        }
        return this.localDocuments.getDocuments(immutableSortedSetEmptyKeySet);
    }

    public boolean hasNewerBundle(final BundleMetadata bundleMetadata) {
        return ((Boolean) this.persistence.runTransaction("Has newer bundle", new Supplier() { // from class: com.google.firebase.firestore.local.x
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return LocalStore.f(this.f10640a, bundleMetadata);
            }
        })).booleanValue();
    }

    public void notifyLocalViewChanges(final List<LocalViewChanges> list) {
        this.persistence.runTransaction("notifyLocalViewChanges", new Runnable() { // from class: com.google.firebase.firestore.local.q
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.c(this.f10607a, list);
            }
        });
    }

    public Document readDocument(DocumentKey documentKey) {
        return this.localDocuments.getDocument(documentKey);
    }

    public ImmutableSortedMap<DocumentKey, Document> rejectBatch(final int i4) {
        return (ImmutableSortedMap) this.persistence.runTransaction("Reject batch", new Supplier() { // from class: com.google.firebase.firestore.local.p
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return LocalStore.a(this.f10604a, i4);
            }
        });
    }

    public void releaseTarget(final int i4) {
        this.persistence.runTransaction("Release target", new Runnable() { // from class: com.google.firebase.firestore.local.j
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.b(this.f10581a, i4);
            }
        });
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void saveBundle(final BundleMetadata bundleMetadata) {
        this.persistence.runTransaction("Save bundle", new Runnable() { // from class: com.google.firebase.firestore.local.o
            @Override // java.lang.Runnable
            public final void run() {
                this.f10601a.bundleCache.saveBundleMetadata(bundleMetadata);
            }
        });
    }

    @Override // com.google.firebase.firestore.bundle.BundleCallback
    public void saveNamedQuery(final NamedQuery namedQuery, final ImmutableSortedSet<DocumentKey> immutableSortedSet) {
        final TargetData targetDataAllocateTarget = allocateTarget(namedQuery.getBundledQuery().getTarget());
        final int targetId = targetDataAllocateTarget.getTargetId();
        this.persistence.runTransaction("Saved named query", new Runnable() { // from class: com.google.firebase.firestore.local.k
            @Override // java.lang.Runnable
            public final void run() {
                LocalStore.i(this.f10584a, namedQuery, targetDataAllocateTarget, targetId, immutableSortedSet);
            }
        });
    }

    public void setIndexAutoCreationEnabled(boolean z4) {
        this.queryEngine.setIndexAutoCreationEnabled(z4);
    }

    public void setLastStreamToken(final AbstractC1062i abstractC1062i) {
        this.persistence.runTransaction("Set stream token", new Runnable() { // from class: com.google.firebase.firestore.local.z
            @Override // java.lang.Runnable
            public final void run() {
                this.f10647a.mutationQueue.setLastStreamToken(abstractC1062i);
            }
        });
    }

    public void setSessionsToken(AbstractC1062i abstractC1062i) {
        this.globalsCache.setSessionToken(abstractC1062i);
    }

    public void start() {
        this.persistence.getOverlayMigrationManager().run();
        startIndexManager();
        startMutationQueue();
    }

    public LocalDocumentsResult writeLocally(final List<Mutation> list) {
        final Timestamp timestampNow = Timestamp.now();
        final HashSet hashSet = new HashSet();
        Iterator<Mutation> it = list.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getKey());
        }
        return (LocalDocumentsResult) this.persistence.runTransaction("Locally write mutations", new Supplier() { // from class: com.google.firebase.firestore.local.s
            @Override // com.google.firebase.firestore.util.Supplier
            public final Object get() {
                return LocalStore.d(this.f10610a, hashSet, list, timestampNow);
            }
        });
    }
}
