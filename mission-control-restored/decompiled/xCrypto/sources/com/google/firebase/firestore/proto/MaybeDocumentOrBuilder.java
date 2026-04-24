package com.google.firebase.firestore.proto;

import com.google.firebase.firestore.proto.MaybeDocument;
import com.google.protobuf.W;
import com.google.protobuf.X;
import p2.k;

/* JADX INFO: loaded from: classes.dex */
public interface MaybeDocumentOrBuilder extends X {
    @Override // com.google.protobuf.X
    /* synthetic */ W getDefaultInstanceForType();

    k getDocument();

    MaybeDocument.DocumentTypeCase getDocumentTypeCase();

    boolean getHasCommittedMutations();

    NoDocument getNoDocument();

    UnknownDocument getUnknownDocument();

    boolean hasDocument();

    boolean hasNoDocument();

    boolean hasUnknownDocument();

    @Override // com.google.protobuf.X
    /* synthetic */ boolean isInitialized();
}
