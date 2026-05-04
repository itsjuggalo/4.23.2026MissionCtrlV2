package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.common.api.internal.n f5722a;

    public h0(com.google.android.gms.common.api.internal.n nVar) {
        this.f5722a = nVar;
    }

    @Override // com.google.android.gms.common.internal.c.b
    public final void onConnectionFailed(m5.b bVar) {
        this.f5722a.onConnectionFailed(bVar);
    }
}
