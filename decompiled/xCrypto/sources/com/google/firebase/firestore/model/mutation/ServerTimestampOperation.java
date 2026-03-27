package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.ServerTimestamps;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public class ServerTimestampOperation implements TransformOperation {
    private static final ServerTimestampOperation SHARED_INSTANCE = new ServerTimestampOperation();

    private ServerTimestampOperation() {
    }

    public static ServerTimestampOperation getInstance() {
        return SHARED_INSTANCE;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public C1698D applyToLocalView(C1698D c1698d, Timestamp timestamp) {
        return ServerTimestamps.valueOf(timestamp, c1698d);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public C1698D computeBaseValue(C1698D c1698d) {
        return null;
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public C1698D applyToRemoteDocument(C1698D c1698d, C1698D c1698d2) {
        return c1698d2;
    }
}
