package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

/* JADX INFO: loaded from: classes.dex */
public final class M implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractC0428f f5205b;

    public M(AbstractC0428f abstractC0428f, int i) {
        this.f5205b = abstractC0428f;
        this.f5204a = i;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AbstractC0428f abstractC0428f = this.f5205b;
        if (iBinder == null) {
            AbstractC0428f.zzk(abstractC0428f, 16);
            return;
        }
        synchronized (abstractC0428f.zzq) {
            try {
                AbstractC0428f abstractC0428f2 = this.f5205b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC0428f2.zzr = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0438p)) ? new E(iBinder) : (InterfaceC0438p) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f5205b.zzl(0, null, this.f5204a);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f5205b.zzq) {
            this.f5205b.zzr = null;
        }
        AbstractC0428f abstractC0428f = this.f5205b;
        int i = this.f5204a;
        Handler handler = abstractC0428f.zzb;
        handler.sendMessage(handler.obtainMessage(6, i, 1));
    }
}
