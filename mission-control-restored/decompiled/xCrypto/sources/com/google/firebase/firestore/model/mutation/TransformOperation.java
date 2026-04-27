package com.google.firebase.firestore.model.mutation;

import com.google.firebase.Timestamp;
import p2.C1698D;

/* JADX INFO: loaded from: classes.dex */
public interface TransformOperation {
    C1698D applyToLocalView(C1698D c1698d, Timestamp timestamp);

    C1698D applyToRemoteDocument(C1698D c1698d, C1698D c1698d2);

    C1698D computeBaseValue(C1698D c1698d);
}
