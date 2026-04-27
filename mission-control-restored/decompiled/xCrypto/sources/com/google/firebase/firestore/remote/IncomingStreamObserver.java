package com.google.firebase.firestore.remote;

import K2.Z;
import K2.l0;

/* JADX INFO: loaded from: classes.dex */
interface IncomingStreamObserver<RespT> {
    void onClose(l0 l0Var);

    void onHeaders(Z z4);

    void onNext(RespT respt);

    void onOpen();
}
