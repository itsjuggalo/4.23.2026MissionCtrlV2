package com.google.android.gms.common.internal;

import Q1.C0790b;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final class a0 extends K {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f14951g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ AbstractC1283c f14952h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a0(AbstractC1283c abstractC1283c, int i8, IBinder iBinder, Bundle bundle) {
        super(abstractC1283c, i8, bundle);
        this.f14952h = abstractC1283c;
        this.f14951g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.K
    public final void f(C0790b c0790b) {
        if (this.f14952h.zzx != null) {
            this.f14952h.zzx.onConnectionFailed(c0790b);
        }
        this.f14952h.onConnectionFailed(c0790b);
    }

    @Override // com.google.android.gms.common.internal.K
    public final boolean g() {
        String str;
        String interfaceDescriptor;
        try {
            IBinder iBinder = this.f14951g;
            AbstractC1294n.j(iBinder);
            interfaceDescriptor = iBinder.getInterfaceDescriptor();
        } catch (RemoteException unused) {
            str = "service probably died";
        }
        if (!this.f14952h.getServiceDescriptor().equals(interfaceDescriptor)) {
            str = "service descriptor mismatch: " + this.f14952h.getServiceDescriptor() + " vs. " + interfaceDescriptor;
            Log.w("GmsClient", str);
            return false;
        }
        IInterface iInterfaceCreateServiceInterface = this.f14952h.createServiceInterface(this.f14951g);
        if (iInterfaceCreateServiceInterface == null || !(AbstractC1283c.zzn(this.f14952h, 2, 4, iInterfaceCreateServiceInterface) || AbstractC1283c.zzn(this.f14952h, 3, 4, iInterfaceCreateServiceInterface))) {
            return false;
        }
        this.f14952h.zzC = null;
        AbstractC1283c abstractC1283c = this.f14952h;
        Bundle connectionHint = abstractC1283c.getConnectionHint();
        if (abstractC1283c.zzw == null) {
            return true;
        }
        this.f14952h.zzw.onConnected(connectionHint);
        return true;
    }
}
