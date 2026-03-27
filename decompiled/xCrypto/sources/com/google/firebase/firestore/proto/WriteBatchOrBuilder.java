package com.google.firebase.firestore.proto;

import com.google.protobuf.W;
import com.google.protobuf.X;
import com.google.protobuf.u0;
import java.util.List;
import p2.C1699E;

/* JADX INFO: loaded from: classes.dex */
public interface WriteBatchOrBuilder extends X {
    C1699E getBaseWrites(int i4);

    int getBaseWritesCount();

    List<C1699E> getBaseWritesList();

    int getBatchId();

    @Override // com.google.protobuf.X
    /* synthetic */ W getDefaultInstanceForType();

    u0 getLocalWriteTime();

    C1699E getWrites(int i4);

    int getWritesCount();

    List<C1699E> getWritesList();

    boolean hasLocalWriteTime();

    @Override // com.google.protobuf.X
    /* synthetic */ boolean isInitialized();
}
