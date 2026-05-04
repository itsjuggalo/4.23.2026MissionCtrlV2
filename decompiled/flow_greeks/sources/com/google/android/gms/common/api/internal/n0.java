package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends b0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.android.gms.common.api.f f5607c;

    public n0(com.google.android.gms.common.api.f fVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f5607c = fVar;
    }

    @Override // com.google.android.gms.common.api.g
    public final d a(d dVar) {
        return this.f5607c.doRead(dVar);
    }

    @Override // com.google.android.gms.common.api.g
    public final d b(d dVar) {
        return this.f5607c.doWrite(dVar);
    }

    @Override // com.google.android.gms.common.api.g
    public final Context e() {
        return this.f5607c.getApplicationContext();
    }

    @Override // com.google.android.gms.common.api.g
    public final Looper f() {
        return this.f5607c.getLooper();
    }
}
