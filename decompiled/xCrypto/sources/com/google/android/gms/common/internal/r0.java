package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class r0 implements ServiceConnection, v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f9960a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f9961b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9962c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f9963d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f9964e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f9965f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ u0 f9966g;

    public r0(u0 u0Var, q0 q0Var) {
        this.f9966g = u0Var;
        this.f9964e = q0Var;
    }

    public static /* bridge */ /* synthetic */ C1984b d(r0 r0Var, String str, Executor executor) {
        try {
            Intent intentB = r0Var.f9964e.b(r0Var.f9966g.f9977h);
            r0Var.f9961b = 3;
            StrictMode.VmPolicy vmPolicyA = G1.w.a();
            try {
                u0 u0Var = r0Var.f9966g;
                boolean zD = u0Var.f9980k.d(u0Var.f9977h, str, intentB, r0Var, 4225, executor);
                r0Var.f9962c = zD;
                if (zD) {
                    r0Var.f9966g.f9978i.sendMessageDelayed(r0Var.f9966g.f9978i.obtainMessage(1, r0Var.f9964e), r0Var.f9966g.f9982m);
                    C1984b c1984b = C1984b.f16081e;
                    StrictMode.setVmPolicy(vmPolicyA);
                    return c1984b;
                }
                r0Var.f9961b = 2;
                try {
                    u0 u0Var2 = r0Var.f9966g;
                    u0Var2.f9980k.c(u0Var2.f9977h, r0Var);
                } catch (IllegalArgumentException unused) {
                }
                C1984b c1984b2 = new C1984b(16);
                StrictMode.setVmPolicy(vmPolicyA);
                return c1984b2;
            } catch (Throwable th) {
                StrictMode.setVmPolicy(vmPolicyA);
                throw th;
            }
        } catch (e0 e4) {
            return e4.f9893a;
        }
    }

    public final int a() {
        return this.f9961b;
    }

    public final ComponentName b() {
        return this.f9965f;
    }

    public final IBinder c() {
        return this.f9963d;
    }

    public final void e(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f9960a.put(serviceConnection, serviceConnection2);
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f9960a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f9966g.f9978i.removeMessages(1, this.f9964e);
        u0 u0Var = this.f9966g;
        u0Var.f9980k.c(u0Var.f9977h, this);
        this.f9962c = false;
        this.f9961b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f9960a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f9960a.isEmpty();
    }

    public final boolean j() {
        return this.f9962c;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f9966g.f9976g) {
            try {
                this.f9966g.f9978i.removeMessages(1, this.f9964e);
                this.f9963d = iBinder;
                this.f9965f = componentName;
                Iterator it = this.f9960a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f9961b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f9966g.f9976g) {
            try {
                this.f9966g.f9978i.removeMessages(1, this.f9964e);
                this.f9963d = null;
                this.f9965f = componentName;
                Iterator it = this.f9960a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f9961b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
