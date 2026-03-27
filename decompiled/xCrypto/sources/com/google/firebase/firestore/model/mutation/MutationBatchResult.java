package com.google.firebase.firestore.model.mutation;

import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.AbstractC1062i;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class MutationBatchResult {
    private final MutationBatch batch;
    private final SnapshotVersion commitVersion;
    private final ImmutableSortedMap<DocumentKey, SnapshotVersion> docVersions;
    private final List<MutationResult> mutationResults;
    private final AbstractC1062i streamToken;

    private MutationBatchResult(MutationBatch mutationBatch, SnapshotVersion snapshotVersion, List<MutationResult> list, AbstractC1062i abstractC1062i, ImmutableSortedMap<DocumentKey, SnapshotVersion> immutableSortedMap) {
        this.batch = mutationBatch;
        this.commitVersion = snapshotVersion;
        this.mutationResults = list;
        this.streamToken = abstractC1062i;
        this.docVersions = immutableSortedMap;
    }

    public static MutationBatchResult create(MutationBatch mutationBatch, SnapshotVersion snapshotVersion, List<MutationResult> list, AbstractC1062i abstractC1062i) {
        Assert.hardAssert(mutationBatch.getMutations().size() == list.size(), "Mutations sent %d must equal results received %d", Integer.valueOf(mutationBatch.getMutations().size()), Integer.valueOf(list.size()));
        ImmutableSortedMap<DocumentKey, SnapshotVersion> immutableSortedMapEmptyVersionMap = DocumentCollections.emptyVersionMap();
        List<Mutation> mutations = mutationBatch.getMutations();
        ImmutableSortedMap<DocumentKey, SnapshotVersion> immutableSortedMapInsert = immutableSortedMapEmptyVersionMap;
        for (int i4 = 0; i4 < mutations.size(); i4++) {
            immutableSortedMapInsert = immutableSortedMapInsert.insert(mutations.get(i4).getKey(), list.get(i4).getVersion());
        }
        return new MutationBatchResult(mutationBatch, snapshotVersion, list, abstractC1062i, immutableSortedMapInsert);
    }

    public MutationBatch getBatch() {
        return this.batch;
    }

    public SnapshotVersion getCommitVersion() {
        return this.commitVersion;
    }

    public ImmutableSortedMap<DocumentKey, SnapshotVersion> getDocVersions() {
        return this.docVersions;
    }

    public List<MutationResult> getMutationResults() {
        return this.mutationResults;
    }

    public AbstractC1062i getStreamToken() {
        return this.streamToken;
    }
}
