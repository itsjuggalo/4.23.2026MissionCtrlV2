package com.amazon.device.iap.internal.util;

/* JADX INFO: loaded from: classes.dex */
public enum d {
    LEGACY(0),
    V1(1),
    V2(2),
    V3(3);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f10437e;

    d(int i7) {
        this.f10437e = i7;
    }

    public int a() {
        return this.f10437e;
    }

    public boolean a(d dVar) {
        return dVar != null && this.f10437e < dVar.f10437e;
    }
}
