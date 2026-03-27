package com.google.android.gms.common.internal;

import P1.C0648b;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends V {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f11115g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AbstractC1192c f11116h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(AbstractC1192c abstractC1192c, int i7, IBinder iBinder, Bundle bundle) {
        super(abstractC1192c, i7, bundle);
        this.f11116h = abstractC1192c;
        this.f11115g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.V
    public final void f(C0648b c0648b) {
        if (this.f11116h.zzx != null) {
            this.f11116h.zzx.c(c0648b);
        }
        this.f11116h.onConnectionFailed(c0648b);
    }

    @Override // com.google.android.gms.common.internal.V
    public final boolean g() {
        try {
            IBinder iBinder = this.f11115g;
            AbstractC1207s.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f11116h.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f11116h.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = this.f11116h.createServiceInterface(this.f11115g);
            if (iInterfaceCreateServiceInterface == null || !(AbstractC1192c.zzn(this.f11116h, 2, 4, iInterfaceCreateServiceInterface) || AbstractC1192c.zzn(this.f11116h, 3, 4, iInterfaceCreateServiceInterface))) {
                return false;
            }
            this.f11116h.zzC = null;
            AbstractC1192c abstractC1192c = this.f11116h;
            Bundle connectionHint = abstractC1192c.getConnectionHint();
            if (abstractC1192c.zzw == null) {
                return true;
            }
            this.f11116h.zzw.f(connectionHint);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
