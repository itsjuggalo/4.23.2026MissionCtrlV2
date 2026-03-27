package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class i0 extends X {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC0925c f9926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f9927b;

    public i0(AbstractC0925c abstractC0925c, int i4) {
        this.f9926a = abstractC0925c;
        this.f9927b = i4;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0935m
    public final void H(int i4, IBinder iBinder, Bundle bundle) {
        AbstractC0940s.l(this.f9926a, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f9926a.onPostInitHandler(i4, iBinder, bundle, this.f9927b);
        this.f9926a = null;
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0935m
    public final void U(int i4, IBinder iBinder, m0 m0Var) {
        AbstractC0925c abstractC0925c = this.f9926a;
        AbstractC0940s.l(abstractC0925c, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        AbstractC0940s.k(m0Var);
        AbstractC0925c.zzj(abstractC0925c, m0Var);
        H(i4, iBinder, m0Var.f9935a);
    }

    @Override // com.google.android.gms.common.internal.InterfaceC0935m
    public final void w(int i4, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
