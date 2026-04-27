package com.google.firebase.firestore.local;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.Mutation;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.protobuf.AbstractC1062i;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
interface MutationQueue {
    void acknowledgeBatch(MutationBatch mutationBatch, AbstractC1062i abstractC1062i);

    MutationBatch addMutationBatch(Timestamp timestamp, List<Mutation> list, List<Mutation> list2);

    List<MutationBatch> getAllMutationBatches();

    List<MutationBatch> getAllMutationBatchesAffectingDocumentKey(DocumentKey documentKey);

    List<MutationBatch> getAllMutationBatchesAffectingDocumentKeys(Iterable<DocumentKey> iterable);

    List<MutationBatch> getAllMutationBatchesAffectingQuery(Query query);

    int getHighestUnacknowledgedBatchId();

    AbstractC1062i getLastStreamToken();

    MutationBatch getNextMutationBatchAfterBatchId(int i4);

    boolean isEmpty();

    MutationBatch lookupMutationBatch(int i4);

    void performConsistencyCheck();

    void removeMutationBatch(MutationBatch mutationBatch);

    void setLastStreamToken(AbstractC1062i abstractC1062i);

    void start();
}
