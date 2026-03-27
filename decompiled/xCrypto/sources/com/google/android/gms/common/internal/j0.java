package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f9930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0925c f9931b;

    public j0(AbstractC0925c abstractC0925c, int i4) {
        this.f9931b = abstractC0925c;
        this.f9930a = i4;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AbstractC0925c abstractC0925c = this.f9931b;
        if (iBinder == null) {
            AbstractC0925c.zzk(abstractC0925c, 16);
            return;
        }
        synchronized (abstractC0925c.zzq) {
            try {
                AbstractC0925c abstractC0925c2 = this.f9931b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC0925c2.zzr = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0936n)) ? new Y(iBinder) : (InterfaceC0936n) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f9931b.zzl(0, null, this.f9930a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f9931b.zzq) {
            this.f9931b.zzr = null;
        }
        AbstractC0925c abstractC0925c = this.f9931b;
        int i4 = this.f9930a;
        Handler handler = abstractC0925c.zzb;
        handler.sendMessage(handler.obtainMessage(6, i4, 1));
    }
}
