package com.amazon.device.iap.internal.util;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    LEGACY(0),
    V1(1),
    V2(2),
    V3(3);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f9252e;

    d(int i4) {
        this.f9252e = i4;
    }

    public int a() {
        return this.f9252e;
    }

    public boolean a(d dVar) {
        return dVar != null && this.f9252e < dVar.f9252e;
    }
}
