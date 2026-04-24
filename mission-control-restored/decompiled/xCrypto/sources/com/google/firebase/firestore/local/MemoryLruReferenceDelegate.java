package com.google.firebase.firestore.local;

import android.util.SparseArray;
import com.google.firebase.firestore.core.ListenSequence;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
class MemoryLruReferenceDelegate implements ReferenceDelegate, LruDelegate {
    private final LruGarbageCollector garbageCollector;
    private ReferenceSet inMemoryPins;
    private final ListenSequence listenSequence;
    private final MemoryPersistence persistence;
    private final LocalSerializer serializer;
    private final Map<DocumentKey, Long> orphanedSequenceNumbers = new HashMap();
    private long currentSequenceNumber = -1;

    public MemoryLruReferenceDelegate(MemoryPersistence memoryPersistence, LruGarbageCollector.Params params, LocalSerializer localSerializer) {
        this.persistence = memoryPersistence;
        this.serializer = localSerializer;
        this.listenSequence = new ListenSequence(memoryPersistence.getTargetCache().getHighestListenSequenceNumber());
        this.garbageCollector = new LruGarbageCollector(this, params);
    }

    public static /* synthetic */ void a(long[] jArr, Long l4) {
        jArr[0] = jArr[0] + 1;
    }

    private boolean isPinned(DocumentKey documentKey, long j4) {
        if (mutationQueuesContainsKey(documentKey) || this.inMemoryPins.containsKey(documentKey) || this.persistence.getTargetCache().containsKey(documentKey)) {
            return true;
        }
        Long l4 = this.orphanedSequenceNumbers.get(documentKey);
        return l4 != null && l4.longValue() > j4;
    }

    private boolean mutationQueuesContainsKey(DocumentKey documentKey) {
        Iterator<MemoryMutationQueue> it = this.persistence.getMutationQueues().iterator();
        while (it.hasNext()) {
            if (it.next().containsKey(documentKey)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void addReference(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachOrphanedDocumentSequenceNumber(Consumer<Long> consumer) {
        for (Map.Entry<DocumentKey, Long> entry : this.orphanedSequenceNumbers.entrySet()) {
            if (!isPinned(entry.getKey(), entry.getValue().longValue())) {
                consumer.accept(entry.getValue());
            }
        }
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public void forEachTarget(Consumer<TargetData> consumer) {
        this.persistence.getTargetCache().forEachTarget(consumer);
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public long getByteSize() {
        long byteSize = this.persistence.getTargetCache().getByteSize(this.serializer) + this.persistence.getRemoteDocumentCache().getByteSize(this.serializer);
        Iterator<MemoryMutationQueue> it = this.persistence.getMutationQueues().iterator();
        while (it.hasNext()) {
            byteSize += it.next().getByteSize(this.serializer);
        }
        return byteSize;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public long getCurrentSequenceNumber() {
        Assert.hardAssert(this.currentSequenceNumber != -1, "Attempting to get a sequence number outside of a transaction", new Object[0]);
        return this.currentSequenceNumber;
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public LruGarbageCollector getGarbageCollector() {
        return this.garbageCollector;
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public long getSequenceNumberCount() {
        long targetCount = this.persistence.getTargetCache().getTargetCount();
        final long[] jArr = new long[1];
        forEachOrphanedDocumentSequenceNumber(new Consumer() { // from class: com.google.firebase.firestore.local.F
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                MemoryLruReferenceDelegate.a(jArr, (Long) obj);
            }
        });
        return targetCount + jArr[0];
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionCommitted() {
        Assert.hardAssert(this.currentSequenceNumber != -1, "Committing a transaction without having started one", new Object[0]);
        this.currentSequenceNumber = -1L;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void onTransactionStarted() {
        Assert.hardAssert(this.currentSequenceNumber == -1, "Starting a transaction without committing the previous one", new Object[0]);
        this.currentSequenceNumber = this.listenSequence.next();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeMutationReference(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public int removeOrphanedDocuments(long j4) {
        MemoryRemoteDocumentCache remoteDocumentCache = this.persistence.getRemoteDocumentCache();
        ArrayList arrayList = new ArrayList();
        Iterator<Document> it = remoteDocumentCache.getDocuments().iterator();
        while (it.hasNext()) {
            DocumentKey key = it.next().getKey();
            if (!isPinned(key, j4)) {
                arrayList.add(key);
                this.orphanedSequenceNumbers.remove(key);
            }
        }
        remoteDocumentCache.removeAll(arrayList);
        return arrayList.size();
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeReference(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void removeTarget(TargetData targetData) {
        this.persistence.getTargetCache().updateTargetData(targetData.withSequenceNumber(getCurrentSequenceNumber()));
    }

    @Override // com.google.firebase.firestore.local.LruDelegate
    public int removeTargets(long j4, SparseArray<?> sparseArray) {
        return this.persistence.getTargetCache().removeQueries(j4, sparseArray);
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void setInMemoryPins(ReferenceSet referenceSet) {
        this.inMemoryPins = referenceSet;
    }

    @Override // com.google.firebase.firestore.local.ReferenceDelegate
    public void updateLimboDocument(DocumentKey documentKey) {
        this.orphanedSequenceNumbers.put(documentKey, Long.valueOf(getCurrentSequenceNumber()));
    }
}
