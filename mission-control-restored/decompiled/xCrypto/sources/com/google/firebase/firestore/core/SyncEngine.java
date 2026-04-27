package com.google.firebase.firestore.core;

import K2.l0;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.LoadBundleTask;
import com.google.firebase.firestore.LoadBundleTaskProgress;
import com.google.firebase.firestore.TransactionOptions;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.bundle.BundleElement;
import com.google.firebase.firestore.bundle.BundleLoader;
import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.BundleReader;
import com.google.firebase.firestore.core.LimboDocumentChange;
import com.google.firebase.firestore.core.View;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.local.LocalDocumentsResult;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LocalViewChanges;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.QueryResult;
import com.google.firebase.firestore.local.ReferenceSet;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.remote.TargetChange;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Function;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import com.google.protobuf.AbstractC1062i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class SyncEngine implements RemoteStore.RemoteStoreCallback {
    private static final String TAG = "SyncEngine";
    private User currentUser;
    private final LocalStore localStore;
    private final int maxConcurrentLimboResolutions;
    private final RemoteStore remoteStore;
    private SyncEngineCallback syncEngineListener;
    private final Map<Query, QueryView> queryViewsByQuery = new HashMap();
    private final Map<Integer, List<Query>> queriesByTarget = new HashMap();
    private final LinkedHashSet<DocumentKey> enqueuedLimboResolutions = new LinkedHashSet<>();
    private final Map<DocumentKey, Integer> activeLimboTargetsByKey = new HashMap();
    private final Map<Integer, LimboResolution> activeLimboResolutionsByTarget = new HashMap();
    private final ReferenceSet limboDocumentRefs = new ReferenceSet();
    private final Map<User, Map<Integer, TaskCompletionSource<Void>>> mutationUserCallbacks = new HashMap();
    private final TargetIdGenerator targetIdGenerator = TargetIdGenerator.forSyncEngine();
    private final Map<Integer, List<TaskCompletionSource<Void>>> pendingWritesCallbacks = new HashMap();

    /* JADX INFO: renamed from: com.google.firebase.firestore.core.SyncEngine$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type;

        static {
            int[] iArr = new int[LimboDocumentChange.Type.values().length];
            $SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type = iArr;
            try {
                iArr[LimboDocumentChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type[LimboDocumentChange.Type.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static class LimboResolution {
        private final DocumentKey key;
        private boolean receivedDocument;

        public LimboResolution(DocumentKey documentKey) {
            this.key = documentKey;
        }
    }

    public interface SyncEngineCallback {
        void handleOnlineStateChange(OnlineState onlineState);

        void onError(Query query, l0 l0Var);

        void onViewSnapshots(List<ViewSnapshot> list);
    }

    public SyncEngine(LocalStore localStore, RemoteStore remoteStore, User user, int i4) {
        this.localStore = localStore;
        this.remoteStore = remoteStore;
        this.maxConcurrentLimboResolutions = i4;
        this.currentUser = user;
    }

    private void addUserCallback(int i4, TaskCompletionSource<Void> taskCompletionSource) {
        Map<Integer, TaskCompletionSource<Void>> map = this.mutationUserCallbacks.get(this.currentUser);
        if (map == null) {
            map = new HashMap<>();
            this.mutationUserCallbacks.put(this.currentUser, map);
        }
        map.put(Integer.valueOf(i4), taskCompletionSource);
    }

    private void assertCallback(String str) {
        Assert.hardAssert(this.syncEngineListener != null, "Trying to call %s before setting callback", str);
    }

    private void emitNewSnapsAndNotifyLocalStore(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap, RemoteEvent remoteEvent) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<Query, QueryView>> it = this.queryViewsByQuery.entrySet().iterator();
        while (it.hasNext()) {
            QueryView value = it.next().getValue();
            View view = value.getView();
            View.DocumentChanges documentChangesComputeDocChanges = view.computeDocChanges(immutableSortedMap);
            boolean z4 = false;
            if (documentChangesComputeDocChanges.needsRefill()) {
                documentChangesComputeDocChanges = view.computeDocChanges(this.localStore.executeQuery(value.getQuery(), false).getDocuments(), documentChangesComputeDocChanges);
            }
            TargetChange targetChange = remoteEvent == null ? null : remoteEvent.getTargetChanges().get(Integer.valueOf(value.getTargetId()));
            if (remoteEvent != null && remoteEvent.getTargetMismatches().get(Integer.valueOf(value.getTargetId())) != null) {
                z4 = true;
            }
            ViewChange viewChangeApplyChanges = value.getView().applyChanges(documentChangesComputeDocChanges, targetChange, z4);
            updateTrackedLimboDocuments(viewChangeApplyChanges.getLimboChanges(), value.getTargetId());
            if (viewChangeApplyChanges.getSnapshot() != null) {
                arrayList.add(viewChangeApplyChanges.getSnapshot());
                arrayList2.add(LocalViewChanges.fromViewSnapshot(value.getTargetId(), viewChangeApplyChanges.getSnapshot()));
            }
        }
        this.syncEngineListener.onViewSnapshots(arrayList);
        this.localStore.notifyLocalViewChanges(arrayList2);
    }

    private boolean errorIsInteresting(l0 l0Var) {
        l0.b bVarM = l0Var.m();
        return (bVarM == l0.b.FAILED_PRECONDITION && (l0Var.n() != null ? l0Var.n() : "").contains("requires an index")) || bVarM == l0.b.PERMISSION_DENIED;
    }

    private void failOutstandingPendingWritesAwaitingTasks() {
        Iterator<Map.Entry<Integer, List<TaskCompletionSource<Void>>>> it = this.pendingWritesCallbacks.entrySet().iterator();
        while (it.hasNext()) {
            Iterator<TaskCompletionSource<Void>> it2 = it.next().getValue().iterator();
            while (it2.hasNext()) {
                it2.next().setException(new FirebaseFirestoreException("'waitForPendingWrites' task is cancelled due to User change.", FirebaseFirestoreException.Code.CANCELLED));
            }
        }
        this.pendingWritesCallbacks.clear();
    }

    private ViewSnapshot initializeViewAndComputeSnapshot(Query query, int i4, AbstractC1062i abstractC1062i) {
        QueryResult queryResultExecuteQuery = this.localStore.executeQuery(query, true);
        ViewSnapshot.SyncState syncState = ViewSnapshot.SyncState.NONE;
        if (this.queriesByTarget.get(Integer.valueOf(i4)) != null) {
            syncState = this.queryViewsByQuery.get(this.queriesByTarget.get(Integer.valueOf(i4)).get(0)).getView().getSyncState();
        }
        TargetChange targetChangeCreateSynthesizedTargetChangeForCurrentChange = TargetChange.createSynthesizedTargetChangeForCurrentChange(syncState == ViewSnapshot.SyncState.SYNCED, abstractC1062i);
        View view = new View(query, queryResultExecuteQuery.getRemoteKeys());
        ViewChange viewChangeApplyChanges = view.applyChanges(view.computeDocChanges(queryResultExecuteQuery.getDocuments()), targetChangeCreateSynthesizedTargetChangeForCurrentChange);
        updateTrackedLimboDocuments(viewChangeApplyChanges.getLimboChanges(), i4);
        this.queryViewsByQuery.put(query, new QueryView(query, i4, view));
        if (!this.queriesByTarget.containsKey(Integer.valueOf(i4))) {
            this.queriesByTarget.put(Integer.valueOf(i4), new ArrayList(1));
        }
        this.queriesByTarget.get(Integer.valueOf(i4)).add(query);
        return viewChangeApplyChanges.getSnapshot();
    }

    private void logErrorIfInteresting(l0 l0Var, String str, Object... objArr) {
        if (errorIsInteresting(l0Var)) {
            Logger.warn("Firestore", "%s: %s", String.format(str, objArr), l0Var);
        }
    }

    private void notifyUser(int i4, l0 l0Var) {
        Integer numValueOf;
        TaskCompletionSource<Void> taskCompletionSource;
        Map<Integer, TaskCompletionSource<Void>> map = this.mutationUserCallbacks.get(this.currentUser);
        if (map == null || (taskCompletionSource = map.get((numValueOf = Integer.valueOf(i4)))) == null) {
            return;
        }
        if (l0Var != null) {
            taskCompletionSource.setException(Util.exceptionFromStatus(l0Var));
        } else {
            taskCompletionSource.setResult(null);
        }
        map.remove(numValueOf);
    }

    private void pumpEnqueuedLimboResolutions() {
        while (!this.enqueuedLimboResolutions.isEmpty() && this.activeLimboTargetsByKey.size() < this.maxConcurrentLimboResolutions) {
            Iterator<DocumentKey> it = this.enqueuedLimboResolutions.iterator();
            DocumentKey next = it.next();
            it.remove();
            int iNextId = this.targetIdGenerator.nextId();
            this.activeLimboResolutionsByTarget.put(Integer.valueOf(iNextId), new LimboResolution(next));
            this.activeLimboTargetsByKey.put(next, Integer.valueOf(iNextId));
            this.remoteStore.listen(new TargetData(Query.atPath(next.getPath()).toTarget(), iNextId, -1L, QueryPurpose.LIMBO_RESOLUTION));
        }
    }

    private void removeAndCleanupTarget(int i4, l0 l0Var) {
        for (Query query : this.queriesByTarget.get(Integer.valueOf(i4))) {
            this.queryViewsByQuery.remove(query);
            if (!l0Var.o()) {
                this.syncEngineListener.onError(query, l0Var);
                logErrorIfInteresting(l0Var, "Listen for %s failed", query);
            }
        }
        this.queriesByTarget.remove(Integer.valueOf(i4));
        ImmutableSortedSet<DocumentKey> immutableSortedSetReferencesForId = this.limboDocumentRefs.referencesForId(i4);
        this.limboDocumentRefs.removeReferencesForId(i4);
        for (DocumentKey documentKey : immutableSortedSetReferencesForId) {
            if (!this.limboDocumentRefs.containsKey(documentKey)) {
                removeLimboTarget(documentKey);
            }
        }
    }

    private void removeLimboTarget(DocumentKey documentKey) {
        this.enqueuedLimboResolutions.remove(documentKey);
        Integer num = this.activeLimboTargetsByKey.get(documentKey);
        if (num != null) {
            this.remoteStore.stopListening(num.intValue());
            this.activeLimboTargetsByKey.remove(documentKey);
            this.activeLimboResolutionsByTarget.remove(num);
            pumpEnqueuedLimboResolutions();
        }
    }

    private void resolvePendingWriteTasks(int i4) {
        if (this.pendingWritesCallbacks.containsKey(Integer.valueOf(i4))) {
            Iterator<TaskCompletionSource<Void>> it = this.pendingWritesCallbacks.get(Integer.valueOf(i4)).iterator();
            while (it.hasNext()) {
                it.next().setResult(null);
            }
            this.pendingWritesCallbacks.remove(Integer.valueOf(i4));
        }
    }

    private void trackLimboChange(LimboDocumentChange limboDocumentChange) {
        DocumentKey key = limboDocumentChange.getKey();
        if (this.activeLimboTargetsByKey.containsKey(key) || this.enqueuedLimboResolutions.contains(key)) {
            return;
        }
        Logger.debug(TAG, "New document in limbo: %s", key);
        this.enqueuedLimboResolutions.add(key);
        pumpEnqueuedLimboResolutions();
    }

    private void updateTrackedLimboDocuments(List<LimboDocumentChange> list, int i4) {
        for (LimboDocumentChange limboDocumentChange : list) {
            int i5 = AnonymousClass1.$SwitchMap$com$google$firebase$firestore$core$LimboDocumentChange$Type[limboDocumentChange.getType().ordinal()];
            if (i5 == 1) {
                this.limboDocumentRefs.addReference(limboDocumentChange.getKey(), i4);
                trackLimboChange(limboDocumentChange);
            } else {
                if (i5 != 2) {
                    throw Assert.fail("Unknown limbo change type: %s", limboDocumentChange.getType());
                }
                Logger.debug(TAG, "Document no longer in limbo: %s", limboDocumentChange.getKey());
                DocumentKey key = limboDocumentChange.getKey();
                this.limboDocumentRefs.removeReference(key, i4);
                if (!this.limboDocumentRefs.containsKey(key)) {
                    removeLimboTarget(key);
                }
            }
        }
    }

    public Map<DocumentKey, Integer> getActiveLimboDocumentResolutions() {
        return new HashMap(this.activeLimboTargetsByKey);
    }

    public List<DocumentKey> getEnqueuedLimboDocumentResolutions() {
        return new ArrayList(this.enqueuedLimboResolutions);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i4) {
        LimboResolution limboResolution = this.activeLimboResolutionsByTarget.get(Integer.valueOf(i4));
        if (limboResolution != null && limboResolution.receivedDocument) {
            return DocumentKey.emptyKeySet().insert(limboResolution.key);
        }
        ImmutableSortedSet<DocumentKey> immutableSortedSetEmptyKeySet = DocumentKey.emptyKeySet();
        if (this.queriesByTarget.containsKey(Integer.valueOf(i4))) {
            for (Query query : this.queriesByTarget.get(Integer.valueOf(i4))) {
                if (this.queryViewsByQuery.containsKey(query)) {
                    immutableSortedSetEmptyKeySet = immutableSortedSetEmptyKeySet.unionWith(this.queryViewsByQuery.get(query).getView().getSyncedDocuments());
                }
            }
        }
        return immutableSortedSetEmptyKeySet;
    }

    public void handleCredentialChange(User user) {
        boolean zEquals = this.currentUser.equals(user);
        this.currentUser = user;
        if (!zEquals) {
            failOutstandingPendingWritesAwaitingTasks();
            emitNewSnapsAndNotifyLocalStore(this.localStore.handleUserChange(user), null);
        }
        this.remoteStore.handleCredentialChange();
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleOnlineStateChange(OnlineState onlineState) {
        assertCallback("handleOnlineStateChange");
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<Query, QueryView>> it = this.queryViewsByQuery.entrySet().iterator();
        while (it.hasNext()) {
            ViewChange viewChangeApplyOnlineStateChange = it.next().getValue().getView().applyOnlineStateChange(onlineState);
            Assert.hardAssert(viewChangeApplyOnlineStateChange.getLimboChanges().isEmpty(), "OnlineState should not affect limbo documents.", new Object[0]);
            if (viewChangeApplyOnlineStateChange.getSnapshot() != null) {
                arrayList.add(viewChangeApplyOnlineStateChange.getSnapshot());
            }
        }
        this.syncEngineListener.onViewSnapshots(arrayList);
        this.syncEngineListener.handleOnlineStateChange(onlineState);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleRejectedListen(int i4, l0 l0Var) {
        assertCallback("handleRejectedListen");
        LimboResolution limboResolution = this.activeLimboResolutionsByTarget.get(Integer.valueOf(i4));
        DocumentKey documentKey = limboResolution != null ? limboResolution.key : null;
        if (documentKey == null) {
            this.localStore.releaseTarget(i4);
            removeAndCleanupTarget(i4, l0Var);
            return;
        }
        this.activeLimboTargetsByKey.remove(documentKey);
        this.activeLimboResolutionsByTarget.remove(Integer.valueOf(i4));
        pumpEnqueuedLimboResolutions();
        SnapshotVersion snapshotVersion = SnapshotVersion.NONE;
        Map mapSingletonMap = Collections.singletonMap(documentKey, MutableDocument.newNoDocument(documentKey, snapshotVersion));
        Set setSingleton = Collections.singleton(documentKey);
        Map map = Collections.EMPTY_MAP;
        handleRemoteEvent(new RemoteEvent(snapshotVersion, map, map, mapSingletonMap, setSingleton));
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleRejectedWrite(int i4, l0 l0Var) {
        assertCallback("handleRejectedWrite");
        ImmutableSortedMap<DocumentKey, Document> immutableSortedMapRejectBatch = this.localStore.rejectBatch(i4);
        if (!immutableSortedMapRejectBatch.isEmpty()) {
            logErrorIfInteresting(l0Var, "Write failed at %s", immutableSortedMapRejectBatch.getMinKey().getPath());
        }
        notifyUser(i4, l0Var);
        resolvePendingWriteTasks(i4);
        emitNewSnapsAndNotifyLocalStore(immutableSortedMapRejectBatch, null);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleRemoteEvent(RemoteEvent remoteEvent) {
        assertCallback("handleRemoteEvent");
        for (Map.Entry<Integer, TargetChange> entry : remoteEvent.getTargetChanges().entrySet()) {
            Integer key = entry.getKey();
            TargetChange value = entry.getValue();
            LimboResolution limboResolution = this.activeLimboResolutionsByTarget.get(key);
            if (limboResolution != null) {
                Assert.hardAssert((value.getAddedDocuments().size() + value.getModifiedDocuments().size()) + value.getRemovedDocuments().size() <= 1, "Limbo resolution for single document contains multiple changes.", new Object[0]);
                if (value.getAddedDocuments().size() > 0) {
                    limboResolution.receivedDocument = true;
                } else if (value.getModifiedDocuments().size() > 0) {
                    Assert.hardAssert(limboResolution.receivedDocument, "Received change for limbo target document without add.", new Object[0]);
                } else if (value.getRemovedDocuments().size() > 0) {
                    Assert.hardAssert(limboResolution.receivedDocument, "Received remove for limbo target document without add.", new Object[0]);
                    limboResolution.receivedDocument = false;
                }
            }
        }
        emitNewSnapsAndNotifyLocalStore(this.localStore.applyRemoteEvent(remoteEvent), remoteEvent);
    }

    @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
    public void handleSuccessfulWrite(MutationBatchResult mutationBatchResult) {
        assertCallback("handleSuccessfulWrite");
        notifyUser(mutationBatchResult.getBatch().getBatchId(), null);
        resolvePendingWriteTasks(mutationBatchResult.getBatch().getBatchId());
        emitNewSnapsAndNotifyLocalStore(this.localStore.acknowledgeBatch(mutationBatchResult), null);
    }

    public int listen(Query query, boolean z4) {
        assertCallback("listen");
        Assert.hardAssert(!this.queryViewsByQuery.containsKey(query), "We already listen to query: %s", query);
        TargetData targetDataAllocateTarget = this.localStore.allocateTarget(query.toTarget());
        this.syncEngineListener.onViewSnapshots(Collections.singletonList(initializeViewAndComputeSnapshot(query, targetDataAllocateTarget.getTargetId(), targetDataAllocateTarget.getResumeToken())));
        if (z4) {
            this.remoteStore.listen(targetDataAllocateTarget);
        }
        return targetDataAllocateTarget.getTargetId();
    }

    public void listenToRemoteStore(Query query) {
        assertCallback("listenToRemoteStore");
        Assert.hardAssert(this.queryViewsByQuery.containsKey(query), "This is the first listen to query: %s", query);
        this.remoteStore.listen(this.localStore.allocateTarget(query.toTarget()));
    }

    public void loadBundle(BundleReader bundleReader, LoadBundleTask loadBundleTask) {
        try {
            try {
                BundleMetadata bundleMetadata = bundleReader.getBundleMetadata();
                if (this.localStore.hasNewerBundle(bundleMetadata)) {
                    loadBundleTask.setResult(LoadBundleTaskProgress.forSuccess(bundleMetadata));
                    try {
                        return;
                    } catch (IOException e4) {
                        return;
                    }
                }
                loadBundleTask.updateProgress(LoadBundleTaskProgress.forInitial(bundleMetadata));
                BundleLoader bundleLoader = new BundleLoader(this.localStore, bundleMetadata);
                long j4 = 0;
                while (true) {
                    BundleElement nextElement = bundleReader.getNextElement();
                    if (nextElement == null) {
                        emitNewSnapsAndNotifyLocalStore(bundleLoader.applyChanges(), null);
                        this.localStore.saveBundle(bundleMetadata);
                        loadBundleTask.setResult(LoadBundleTaskProgress.forSuccess(bundleMetadata));
                        try {
                            bundleReader.close();
                            return;
                        } catch (IOException e5) {
                            Logger.warn("SyncEngine", "Exception while closing bundle", e5);
                            return;
                        }
                    }
                    long bytesRead = bundleReader.getBytesRead();
                    LoadBundleTaskProgress loadBundleTaskProgressAddElement = bundleLoader.addElement(nextElement, bytesRead - j4);
                    if (loadBundleTaskProgressAddElement != null) {
                        loadBundleTask.updateProgress(loadBundleTaskProgressAddElement);
                    }
                    j4 = bytesRead;
                }
            } catch (Exception e6) {
                Logger.warn("Firestore", "Loading bundle failed : %s", e6);
                loadBundleTask.setException(new FirebaseFirestoreException("Bundle failed to load", FirebaseFirestoreException.Code.INVALID_ARGUMENT, e6));
                try {
                    bundleReader.close();
                } catch (IOException e7) {
                    Logger.warn("SyncEngine", "Exception while closing bundle", e7);
                }
            }
        } finally {
            try {
                bundleReader.close();
            } catch (IOException e42) {
                Logger.warn("SyncEngine", "Exception while closing bundle", e42);
            }
        }
    }

    public void registerPendingWritesTask(TaskCompletionSource<Void> taskCompletionSource) {
        if (!this.remoteStore.canUseNetwork()) {
            Logger.debug(TAG, "The network is disabled. The task returned by 'awaitPendingWrites()' will not complete until the network is enabled.", new Object[0]);
        }
        int highestUnacknowledgedBatchId = this.localStore.getHighestUnacknowledgedBatchId();
        if (highestUnacknowledgedBatchId == -1) {
            taskCompletionSource.setResult(null);
            return;
        }
        if (!this.pendingWritesCallbacks.containsKey(Integer.valueOf(highestUnacknowledgedBatchId))) {
            this.pendingWritesCallbacks.put(Integer.valueOf(highestUnacknowledgedBatchId), new ArrayList());
        }
        this.pendingWritesCallbacks.get(Integer.valueOf(highestUnacknowledgedBatchId)).add(taskCompletionSource);
    }

    public Task<Map<String, C1698D>> runAggregateQuery(Query query, List<AggregateField> list) {
        return this.remoteStore.runAggregateQuery(query, list);
    }

    public void setCallback(SyncEngineCallback syncEngineCallback) {
        this.syncEngineListener = syncEngineCallback;
    }

    public void stopListening(Query query, boolean z4) {
        assertCallback("stopListening");
        QueryView queryView = this.queryViewsByQuery.get(query);
        Assert.hardAssert(queryView != null, "Trying to stop listening to a query not found", new Object[0]);
        this.queryViewsByQuery.remove(query);
        int targetId = queryView.getTargetId();
        List<Query> list = this.queriesByTarget.get(Integer.valueOf(targetId));
        list.remove(query);
        if (list.isEmpty()) {
            this.localStore.releaseTarget(targetId);
            if (z4) {
                this.remoteStore.stopListening(targetId);
            }
            removeAndCleanupTarget(targetId, l0.f1215e);
        }
    }

    public void stopListeningToRemoteStore(Query query) {
        assertCallback("stopListeningToRemoteStore");
        QueryView queryView = this.queryViewsByQuery.get(query);
        Assert.hardAssert(queryView != null, "Trying to stop listening to a query not found", new Object[0]);
        int targetId = queryView.getTargetId();
        List<Query> list = this.queriesByTarget.get(Integer.valueOf(targetId));
        list.remove(query);
        if (list.isEmpty()) {
            this.remoteStore.stopListening(targetId);
        }
    }

    public <TResult> Task<TResult> transaction(AsyncQueue asyncQueue, TransactionOptions transactionOptions, Function<Transaction, Task<TResult>> function) {
        return new TransactionRunner(asyncQueue, this.remoteStore, transactionOptions, function).run();
    }

    public void writeMutations(List<Mutation> list, TaskCompletionSource<Void> taskCompletionSource) {
        assertCallback("writeMutations");
        LocalDocumentsResult localDocumentsResultWriteLocally = this.localStore.writeLocally(list);
        addUserCallback(localDocumentsResultWriteLocally.getBatchId(), taskCompletionSource);
        emitNewSnapsAndNotifyLocalStore(localDocumentsResultWriteLocally.getDocuments(), null);
        this.remoteStore.fillWritePipeline();
    }
}
