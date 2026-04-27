package com.google.firebase.firestore.proto;

import com.google.protobuf.W;
import com.google.protobuf.X;
import com.google.protobuf.u0;

/* JADX INFO: loaded from: classes.dex */
public interface TargetGlobalOrBuilder extends X {
    @Override // com.google.protobuf.X
    /* synthetic */ W getDefaultInstanceForType();

    long getHighestListenSequenceNumber();

    int getHighestTargetId();

    u0 getLastRemoteSnapshotVersion();

    int getTargetCount();

    boolean hasLastRemoteSnapshotVersion();

    @Override // com.google.protobuf.X
    /* synthetic */ boolean isInitialized();
}
