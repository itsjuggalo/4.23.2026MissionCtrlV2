package com.google.android.gms.common.api;

import u1.C1202d;

/* JADX INFO: loaded from: classes.dex */
public final class w extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1202d f5180a;

    public w(C1202d c1202d) {
        this.f5180a = c1202d;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return "Missing ".concat(String.valueOf(this.f5180a));
    }
}
