package com.amazon.device.iap.internal.util;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public enum d {
    LEGACY(0),
    V1(1),
    V2(2),
    V3(3);


    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f5028e;

    d(int i10) {
        this.f5028e = i10;
    }

    public int a() {
        return this.f5028e;
    }

    public boolean a(d dVar) {
        return dVar != null && this.f5028e < dVar.f5028e;
    }
}
