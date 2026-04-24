package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class Z implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC1283c f14950b;

    public Z(AbstractC1283c abstractC1283c, int i8) {
        this.f14950b = abstractC1283c;
        this.f14949a = i8;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AbstractC1283c abstractC1283c = this.f14950b;
        if (iBinder == null) {
            AbstractC1283c.zzk(abstractC1283c, 16);
            return;
        }
        synchronized (abstractC1283c.zzq) {
            try {
                AbstractC1283c abstractC1283c2 = this.f14950b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC1283c2.zzr = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1291k)) ? new N(iBinder) : (InterfaceC1291k) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f14950b.zzl(0, null, this.f14949a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f14950b.zzq) {
            this.f14950b.zzr = null;
        }
        AbstractC1283c abstractC1283c = this.f14950b;
        int i8 = this.f14949a;
        Handler handler = abstractC1283c.zzb;
        handler.sendMessage(handler.obtainMessage(6, i8, 1));
    }
}
