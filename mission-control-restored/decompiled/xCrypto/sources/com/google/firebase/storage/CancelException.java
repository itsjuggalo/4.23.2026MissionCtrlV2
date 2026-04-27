package com.google.firebase.storage;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
class CancelException extends IOException {
    public CancelException() {
        super("The operation was canceled.");
    }
}
