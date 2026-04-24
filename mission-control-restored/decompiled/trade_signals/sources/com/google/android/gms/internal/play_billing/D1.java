package com.google.android.gms.internal.play_billing;

/* JADX INFO: loaded from: classes.dex */
public final class D1 extends Throwable {
    public D1(String str) {
        super("Failure occurred while trying to finish a future.");
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return this;
    }
}
