package com.google.firebase.firestore.proto;

import com.google.protobuf.AbstractC1062i;
import com.google.protobuf.W;
import com.google.protobuf.X;

/* JADX INFO: loaded from: classes.dex */
public interface MutationQueueOrBuilder extends X {
    @Override // com.google.protobuf.X
    /* synthetic */ W getDefaultInstanceForType();

    int getLastAcknowledgedBatchId();

    AbstractC1062i getLastStreamToken();

    @Override // com.google.protobuf.X
    /* synthetic */ boolean isInitialized();
}
