package com.amazon.device.iap.internal.util;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    LEGACY(0),
    V1(1),
    V2(2),
    V3(3);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f14548e;

    d(int i8) {
        this.f14548e = i8;
    }

    public int a() {
        return this.f14548e;
    }

    public boolean a(d dVar) {
        return dVar != null && this.f14548e < dVar.f14548e;
    }
}
