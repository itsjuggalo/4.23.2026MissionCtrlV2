package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f5695b;

    public e1(c cVar, int i10) {
        Objects.requireNonNull(cVar);
        this.f5695b = cVar;
        this.f5694a = i10;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        c cVar = this.f5695b;
        if (iBinder == null) {
            cVar.zzf(16);
            return;
        }
        synchronized (cVar.zzh()) {
            try {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                cVar.zzi((iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof n)) ? new t0(iBinder) : (n) iInterfaceQueryLocalInterface);
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5695b.zzb(0, null, this.f5694a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        c cVar = this.f5695b;
        synchronized (cVar.zzh()) {
            cVar.zzi(null);
        }
        c cVar2 = this.f5695b;
        int i10 = this.f5694a;
        Handler handler = cVar2.zzb;
        handler.sendMessage(handler.obtainMessage(6, i10, 1));
    }
}
