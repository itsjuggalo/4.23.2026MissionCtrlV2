package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 extends v1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f5675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5676b;

    public d1(c cVar, int i10) {
        this.f5675a = cVar;
        this.f5676b = i10;
    }

    @Override // com.google.android.gms.common.internal.m
    public final void h(int i10, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.m
    public final void p(int i10, IBinder iBinder, Bundle bundle) {
        s.l(this.f5675a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f5675a.onPostInitHandler(i10, iBinder, bundle, this.f5676b);
        this.f5675a = null;
    }

    @Override // com.google.android.gms.common.internal.m
    public final void r(int i10, IBinder iBinder, h1 h1Var) {
        c cVar = this.f5675a;
        s.l(cVar, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        s.k(h1Var);
        cVar.zzc(h1Var);
        p(i10, iBinder, h1Var.f5723a);
    }
}
