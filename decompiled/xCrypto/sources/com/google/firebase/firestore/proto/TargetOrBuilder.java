package com.google.firebase.firestore.proto;

import com.google.firebase.firestore.proto.Target;
import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.W;
import com.google.protobuf.X;
import com.google.protobuf.u0;
import p2.C1695A;

/* JADX INFO: loaded from: classes.dex */
public interface TargetOrBuilder extends X {
    @Override // com.google.protobuf.X
    /* synthetic */ W getDefaultInstanceForType();

    C1695A.c getDocuments();

    u0 getLastLimboFreeSnapshotVersion();

    long getLastListenSequenceNumber();

    C1695A.d getQuery();

    AbstractC1062i getResumeToken();

    u0 getSnapshotVersion();

    int getTargetId();

    Target.TargetTypeCase getTargetTypeCase();

    boolean hasDocuments();

    boolean hasLastLimboFreeSnapshotVersion();

    boolean hasQuery();

    boolean hasSnapshotVersion();

    @Override // com.google.protobuf.X
    /* synthetic */ boolean isInitialized();
}
