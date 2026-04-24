package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class Y extends M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC1283c f14947a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f14948b;

    public Y(AbstractC1283c abstractC1283c, int i8) {
        this.f14947a = abstractC1283c;
        this.f14948b = i8;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1290j
    public final void i(int i8, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1290j
    public final void m(int i8, IBinder iBinder, Bundle bundle) {
        AbstractC1294n.k(this.f14947a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f14947a.onPostInitHandler(i8, iBinder, bundle, this.f14948b);
        this.f14947a = null;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1290j
    public final void x(int i8, IBinder iBinder, c0 c0Var) {
        AbstractC1283c abstractC1283c = this.f14947a;
        AbstractC1294n.k(abstractC1283c, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        AbstractC1294n.j(c0Var);
        AbstractC1283c.zzj(abstractC1283c, c0Var);
        m(i8, iBinder, c0Var.f14955a);
    }
}
