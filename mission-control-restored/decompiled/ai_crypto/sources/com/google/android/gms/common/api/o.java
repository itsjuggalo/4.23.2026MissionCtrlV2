package com.google.android.gms.common.api;

import P1.C0650d;

/* JADX INFO: loaded from: classes.dex */
public final class o extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0650d f11024a;

    public o(C0650d c0650d) {
        this.f11024a = c0650d;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f11024a));
    }
}
