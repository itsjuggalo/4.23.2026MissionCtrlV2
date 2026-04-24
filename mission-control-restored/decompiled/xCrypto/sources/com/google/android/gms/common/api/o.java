package com.google.android.gms.common.api;

import z1.C1986d;

/* JADX INFO: loaded from: classes.dex */
public final class o extends UnsupportedOperationException {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1986d f9841a;

    public o(C1986d c1986d) {
        this.f9841a = c1986d;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return "Missing ".concat(String.valueOf(this.f9841a));
    }
}
