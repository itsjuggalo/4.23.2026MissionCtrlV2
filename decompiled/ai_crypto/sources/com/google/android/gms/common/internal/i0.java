package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC1192c f11109a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f11110b;

    public i0(AbstractC1192c abstractC1192c, int i7) {
        this.f11109a = abstractC1192c;
        this.f11110b = i7;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1202m
    public final void D(int i7, IBinder iBinder, Bundle bundle) {
        AbstractC1207s.l(this.f11109a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f11109a.onPostInitHandler(i7, iBinder, bundle, this.f11110b);
        this.f11109a = null;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1202m
    public final void W(int i7, IBinder iBinder, m0 m0Var) {
        AbstractC1192c abstractC1192c = this.f11109a;
        AbstractC1207s.l(abstractC1192c, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        AbstractC1207s.k(m0Var);
        AbstractC1192c.zzj(abstractC1192c, m0Var);
        D(i7, iBinder, m0Var.f11118a);
    }

    @Override // com.google.android.gms.common.internal.InterfaceC1202m
    public final void v(int i7, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
