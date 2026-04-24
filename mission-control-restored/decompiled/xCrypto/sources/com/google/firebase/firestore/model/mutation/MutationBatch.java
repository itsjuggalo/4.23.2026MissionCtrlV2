package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.local.OverlayedDocument;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class MutationBatch {
    public static final int UNKNOWN = -1;
    private final List<Mutation> baseMutations;
    private final int batchId;
    private final Timestamp localWriteTime;
    private final List<Mutation> mutations;

    public MutationBatch(int i4, Timestamp timestamp, List<Mutation> list, List<Mutation> list2) {
        Assert.hardAssert(!list2.isEmpty(), "Cannot create an empty mutation batch", new Object[0]);
        this.batchId = i4;
        this.localWriteTime = timestamp;
        this.baseMutations = list;
        this.mutations = list2;
    }

    public Map<DocumentKey, Mutation> applyToLocalDocumentSet(Map<DocumentKey, OverlayedDocument> map, Set<DocumentKey> set) {
        HashMap map2 = new HashMap();
        for (DocumentKey documentKey : getKeys()) {
            MutableDocument mutableDocument = (MutableDocument) map.get(documentKey).getDocument();
            FieldMask fieldMaskApplyToLocalView = applyToLocalView(mutableDocument, map.get(documentKey).getMutatedFields());
            if (set.contains(documentKey)) {
                fieldMaskApplyToLocalView = null;
            }
            Mutation mutationCalculateOverlayMutation = Mutation.calculateOverlayMutation(mutableDocument, fieldMaskApplyToLocalView);
            if (mutationCalculateOverlayMutation != null) {
                map2.put(documentKey, mutationCalculateOverlayMutation);
            }
            if (!mutableDocument.isValidDocument()) {
                mutableDocument.convertToNoDocument(SnapshotVersion.NONE);
            }
        }
        return map2;
    }

    public FieldMask applyToLocalView(MutableDocument mutableDocument, FieldMask fieldMask) {
        for (int i4 = 0; i4 < this.baseMutations.size(); i4++) {
            Mutation mutation = this.baseMutations.get(i4);
            if (mutation.getKey().equals(mutableDocument.getKey())) {
                fieldMask = mutation.applyToLocalView(mutableDocument, fieldMask, this.localWriteTime);
            }
        }
        for (int i5 = 0; i5 < this.mutations.size(); i5++) {
            Mutation mutation2 = this.mutations.get(i5);
            if (mutation2.getKey().equals(mutableDocument.getKey())) {
                fieldMask = mutation2.applyToLocalView(mutableDocument, fieldMask, this.localWriteTime);
            }
        }
        return fieldMask;
    }

    public void applyToRemoteDocument(MutableDocument mutableDocument, MutationBatchResult mutationBatchResult) {
        int size = this.mutations.size();
        List<MutationResult> mutationResults = mutationBatchResult.getMutationResults();
        Assert.hardAssert(mutationResults.size() == size, "Mismatch between mutations length (%d) and results length (%d)", Integer.valueOf(size), Integer.valueOf(mutationResults.size()));
        for (int i4 = 0; i4 < size; i4++) {
            Mutation mutation = this.mutations.get(i4);
            if (mutation.getKey().equals(mutableDocument.getKey())) {
                mutation.applyToRemoteDocument(mutableDocument, mutationResults.get(i4));
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MutationBatch.class == obj.getClass()) {
            MutationBatch mutationBatch = (MutationBatch) obj;
            if (this.batchId == mutationBatch.batchId && this.localWriteTime.equals(mutationBatch.localWriteTime) && this.baseMutations.equals(mutationBatch.baseMutations) && this.mutations.equals(mutationBatch.mutations)) {
                return true;
            }
        }
        return false;
    }

    public List<Mutation> getBaseMutations() {
        return this.baseMutations;
    }

    public int getBatchId() {
        return this.batchId;
    }

    public Set<DocumentKey> getKeys() {
        HashSet hashSet = new HashSet();
        Iterator<Mutation> it = this.mutations.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getKey());
        }
        return hashSet;
    }

    public Timestamp getLocalWriteTime() {
        return this.localWriteTime;
    }

    public List<Mutation> getMutations() {
        return this.mutations;
    }

    public int hashCode() {
        return (((((this.batchId * 31) + this.localWriteTime.hashCode()) * 31) + this.baseMutations.hashCode()) * 31) + this.mutations.hashCode();
    }

    public String toString() {
        return "MutationBatch(batchId=" + this.batchId + ", localWriteTime=" + this.localWriteTime + ", baseMutations=" + this.baseMutations + ", mutations=" + this.mutations + ')';
    }
}
