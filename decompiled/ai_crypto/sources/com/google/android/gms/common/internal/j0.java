package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class j0 implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11113a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC1192c f11114b;

    public j0(AbstractC1192c abstractC1192c, int i7) {
        this.f11114b = abstractC1192c;
        this.f11113a = i7;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AbstractC1192c abstractC1192c = this.f11114b;
        if (iBinder == null) {
            AbstractC1192c.zzk(abstractC1192c, 16);
            return;
        }
        synchronized (abstractC1192c.zzq) {
            try {
                AbstractC1192c abstractC1192c2 = this.f11114b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC1192c2.zzr = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC1203n)) ? new Y(iBinder) : (InterfaceC1203n) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f11114b.zzl(0, null, this.f11113a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f11114b.zzq) {
            this.f11114b.zzr = null;
        }
        AbstractC1192c abstractC1192c = this.f11114b;
        int i7 = this.f11113a;
        Handler handler = abstractC1192c.zzb;
        handler.sendMessage(handler.obtainMessage(6, i7, 1));
    }
}
