package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.util.Preconditions;
import java.util.List;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public final class MutationResult {
    private final List<C1698D> transformResults;
    private final SnapshotVersion version;

    public MutationResult(SnapshotVersion snapshotVersion, List<C1698D> list) {
        this.version = (SnapshotVersion) Preconditions.checkNotNull(snapshotVersion);
        this.transformResults = list;
    }

    public List<C1698D> getTransformResults() {
        return this.transformResults;
    }

    public SnapshotVersion getVersion() {
        return this.version;
    }
}
