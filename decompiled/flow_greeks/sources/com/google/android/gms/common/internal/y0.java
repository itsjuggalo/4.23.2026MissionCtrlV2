package com.google.android.gms.common.internal;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y0 extends Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m5.b f5809a;

    public y0(m5.b bVar) {
        s.b(bVar.U(), "ResolvableConnectionException can only be created with a connection result containing a resolution.");
        this.f5809a = bVar;
    }
}
