package com.google.firebase.firestore.remote;

import K2.l0;
import com.google.firebase.firestore.remote.Stream.StreamCallback;

/* JADX INFO: loaded from: classes.dex */
public interface Stream<CallbackType extends StreamCallback> {

    public enum State {
        Initial,
        Starting,
        Open,
        Healthy,
        Error,
        Backoff
    }

    public interface StreamCallback {
        void onClose(l0 l0Var);

        void onOpen();
    }

    void inhibitBackoff();

    boolean isOpen();

    boolean isStarted();

    void start();

    void stop();
}
