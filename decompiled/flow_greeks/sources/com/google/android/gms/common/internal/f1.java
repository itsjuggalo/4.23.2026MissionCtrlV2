package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.c;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 extends s0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IBinder f5702g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ c f5703h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f1(c cVar, int i10, IBinder iBinder, Bundle bundle) {
        super(cVar, i10, bundle);
        Objects.requireNonNull(cVar);
        this.f5703h = cVar;
        this.f5702g = iBinder;
    }

    @Override // com.google.android.gms.common.internal.s0
    public final boolean e() {
        try {
            IBinder iBinder = this.f5702g;
            s.k(iBinder);
            String interfaceDescriptor = iBinder.getInterfaceDescriptor();
            c cVar = this.f5703h;
            if (!cVar.getServiceDescriptor().equals(interfaceDescriptor)) {
                String serviceDescriptor = cVar.getServiceDescriptor();
                StringBuilder sb2 = new StringBuilder(String.valueOf(serviceDescriptor).length() + 34 + String.valueOf(interfaceDescriptor).length());
                sb2.append("service descriptor mismatch: ");
                sb2.append(serviceDescriptor);
                sb2.append(" vs. ");
                sb2.append(interfaceDescriptor);
                Log.w("GmsClient", sb2.toString());
                return false;
            }
            IInterface iInterfaceCreateServiceInterface = cVar.createServiceInterface(this.f5702g);
            if (iInterfaceCreateServiceInterface == null || !(cVar.zze(2, 4, iInterfaceCreateServiceInterface) || cVar.zze(3, 4, iInterfaceCreateServiceInterface))) {
                return false;
            }
            cVar.zzn(null);
            c.a aVarZzk = cVar.zzk();
            Bundle connectionHint = cVar.getConnectionHint();
            if (aVarZzk == null) {
                return true;
            }
            cVar.zzk().onConnected(connectionHint);
            return true;
        } catch (RemoteException unused) {
            Log.w("GmsClient", "service probably died");
            return false;
        }
    }

    @Override // com.google.android.gms.common.internal.s0
    public final void f(m5.b bVar) {
        c cVar = this.f5703h;
        if (cVar.zzl() != null) {
            cVar.zzl().onConnectionFailed(bVar);
        }
        cVar.onConnectionFailed(bVar);
    }
}
