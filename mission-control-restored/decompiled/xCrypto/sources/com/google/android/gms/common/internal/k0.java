package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends V {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f9932g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AbstractC0925c f9933h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k0(AbstractC0925c abstractC0925c, int i4, IBinder iBinder, Bundle bundle) {
        super(abstractC0925c, i4, bundle);
        this.f9933h = abstractC0925c;
        this.f9932g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.V
    public final void f(C1984b c1984b) {
        if (this.f9933h.zzx != null) {
            this.f9933h.zzx.b(c1984b);
        }
        this.f9933h.onConnectionFailed(c1984b);
    }

    @Override // com.google.android.gms.common.internal.V
    public final boolean g() {
        try {
            IBinder iBinder = this.f9932g;
            AbstractC0940s.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            if (!this.f9933h.getServiceDescriptor().equals(interfaceDescriptor)) {
                Log.w("GmsClient", "service descriptor mismatch: " + this.f9933h.getServiceDescriptor() + " vs. " + interfaceDescriptor);
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = this.f9933h.createServiceInterface(this.f9932g);
            if (iInterfaceCreateServiceInterface == null || !(AbstractC0925c.zzn(this.f9933h, 2, 4, iInterfaceCreateServiceInterface) || AbstractC0925c.zzn(this.f9933h, 3, 4, iInterfaceCreateServiceInterface))) {
                return false;
            }
            this.f9933h.zzC = null;
            AbstractC0925c abstractC0925c = this.f9933h;
            Bundle connectionHint = abstractC0925c.getConnectionHint();
            if (abstractC0925c.zzw == null) {
                return true;
            }
            this.f9933h.zzw.f(connectionHint);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }
}
