package com.google.firebase.firestore.model.mutation;

import com.google.firebase.firestore.model.DocumentKey;

/* JADX INFO: loaded from: classes.dex */
public abstract class Overlay {
    public static Overlay create(int i4, Mutation mutation) {
        return new AutoValue_Overlay(i4, mutation);
    }

    public DocumentKey getKey() {
        return getMutation().getKey();
    }

    public abstract int getLargestBatchId();

    public abstract Mutation getMutation();
}
