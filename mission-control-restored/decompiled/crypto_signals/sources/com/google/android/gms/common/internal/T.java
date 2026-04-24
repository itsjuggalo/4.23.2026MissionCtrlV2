package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Executor;
import u1.C1200b;

/* JADX INFO: loaded from: classes.dex */
public final class T implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f5218a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5219b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5220c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f5221d;
    public final S e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f5222f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ V f5223g;

    public T(V v2, S s6) {
        this.f5223g = v2;
        this.e = s6;
    }

    public static C1200b a(T t6, String str, Executor executor) {
        try {
            Intent intentA = t6.e.a(t6.f5223g.e);
            t6.f5219b = 3;
            StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
            if (Build.VERSION.SDK_INT >= 31) {
                StrictMode.setVmPolicy(B1.h.a(new StrictMode.VmPolicy.Builder(vmPolicy)).build());
            }
            try {
                V v2 = t6.f5223g;
                boolean zD = v2.f5227g.d(v2.e, str, intentA, t6, 4225, executor);
                t6.f5220c = zD;
                if (zD) {
                    t6.f5223g.f5226f.sendMessageDelayed(t6.f5223g.f5226f.obtainMessage(1, t6.e), t6.f5223g.i);
                    C1200b c1200b = C1200b.e;
                    StrictMode.setVmPolicy(vmPolicy);
                    return c1200b;
                }
                t6.f5219b = 2;
                try {
                    V v6 = t6.f5223g;
                    v6.f5227g.c(v6.e, t6);
                } catch (IllegalArgumentException unused) {
                }
                C1200b c1200b2 = new C1200b(16);
                StrictMode.setVmPolicy(vmPolicy);
                return c1200b2;
            } catch (Throwable th) {
                StrictMode.setVmPolicy(vmPolicy);
                throw th;
            }
        } catch (J e) {
            return e.f5200a;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f5223g.f5225d) {
            try {
                this.f5223g.f5226f.removeMessages(1, this.e);
                this.f5221d = iBinder;
                this.f5222f = componentName;
                Iterator it = this.f5218a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f5219b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f5223g.f5225d) {
            try {
                this.f5223g.f5226f.removeMessages(1, this.e);
                this.f5221d = null;
                this.f5222f = componentName;
                Iterator it = this.f5218a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f5219b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
