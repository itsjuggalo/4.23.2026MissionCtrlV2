package com.google.android.gms.common.internal;

import P1.C0648b;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class r0 implements ServiceConnection, v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f11143a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f11144b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11145c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f11146d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q0 f11147e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f11148f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ u0 f11149g;

    public r0(u0 u0Var, q0 q0Var) {
        this.f11149g = u0Var;
        this.f11147e = q0Var;
    }

    public static /* bridge */ /* synthetic */ C0648b d(r0 r0Var, String str, Executor executor) {
        C0648b c0648b;
        try {
            Intent intentB = r0Var.f11147e.b(r0Var.f11149g.f11160h);
            r0Var.f11144b = 3;
            StrictMode.VmPolicy vmPolicyA = W1.w.a();
            try {
                u0 u0Var = r0Var.f11149g;
                boolean zD = u0Var.f11163k.d(u0Var.f11160h, str, intentB, r0Var, 4225, executor);
                r0Var.f11145c = zD;
                if (zD) {
                    r0Var.f11149g.f11161i.sendMessageDelayed(r0Var.f11149g.f11161i.obtainMessage(1, r0Var.f11147e), r0Var.f11149g.f11165m);
                    c0648b = C0648b.f4284e;
                } else {
                    r0Var.f11144b = 2;
                    try {
                        u0 u0Var2 = r0Var.f11149g;
                        u0Var2.f11163k.c(u0Var2.f11160h, r0Var);
                    } catch (IllegalArgumentException unused) {
                    }
                    c0648b = new C0648b(16);
                }
                return c0648b;
            } finally {
                StrictMode.setVmPolicy(vmPolicyA);
            }
        } catch (e0 e7) {
            return e7.f11076a;
        }
    }

    public final int a() {
        return this.f11144b;
    }

    public final ComponentName b() {
        return this.f11148f;
    }

    public final IBinder c() {
        return this.f11146d;
    }

    public final void e(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f11143a.put(serviceConnection, serviceConnection2);
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f11143a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f11149g.f11161i.removeMessages(1, this.f11147e);
        u0 u0Var = this.f11149g;
        u0Var.f11163k.c(u0Var.f11160h, this);
        this.f11145c = false;
        this.f11144b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f11143a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f11143a.isEmpty();
    }

    public final boolean j() {
        return this.f11145c;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f11149g.f11159g) {
            try {
                this.f11149g.f11161i.removeMessages(1, this.f11147e);
                this.f11146d = iBinder;
                this.f11148f = componentName;
                Iterator it = this.f11143a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f11144b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f11149g.f11159g) {
            try {
                this.f11149g.f11161i.removeMessages(1, this.f11147e);
                this.f11146d = null;
                this.f11148f = componentName;
                Iterator it = this.f11143a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f11144b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
