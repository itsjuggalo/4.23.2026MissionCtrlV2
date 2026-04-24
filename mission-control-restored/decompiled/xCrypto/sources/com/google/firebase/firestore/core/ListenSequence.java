package com.google.firebase.firestore.core;

/* JADX INFO: loaded from: classes.dex */
public class ListenSequence {
    public static final long INVALID = -1;
    private long previousSequenceNumber;

    public ListenSequence(long j4) {
        this.previousSequenceNumber = j4;
    }

    public long next() {
        long j4 = this.previousSequenceNumber + 1;
        this.previousSequenceNumber = j4;
        return j4;
    }
}
