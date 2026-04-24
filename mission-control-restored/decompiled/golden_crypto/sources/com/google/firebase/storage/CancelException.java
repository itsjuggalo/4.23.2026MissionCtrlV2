package com.google.firebase.storage;

import java.io.IOException;

/* JADX INFO: loaded from: classes2.dex */
class CancelException extends IOException {
    CancelException() {
        super("The operation was canceled.");
    }
}
