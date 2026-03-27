package com.google.android.gms.common.internal;

import Q1.C0790b;
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
public final class h0 implements ServiceConnection, l0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f15011a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f15012b = 2;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f15014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final g0 f15015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f15016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ k0 f15017g;

    public h0(k0 k0Var, g0 g0Var) {
        this.f15017g = k0Var;
        this.f15015e = g0Var;
    }

    public static /* bridge */ /* synthetic */ C0790b d(h0 h0Var, String str, Executor executor) {
        C0790b c0790b;
        try {
            Intent intentB = h0Var.f15015e.b(h0Var.f15017g.f15020h);
            h0Var.f15012b = 3;
            StrictMode.VmPolicy vmPolicyA = W1.v.a();
            try {
                k0 k0Var = h0Var.f15017g;
                boolean zD = k0Var.f15023k.d(k0Var.f15020h, str, intentB, h0Var, 4225, executor);
                h0Var.f15013c = zD;
                if (zD) {
                    h0Var.f15017g.f15021i.sendMessageDelayed(h0Var.f15017g.f15021i.obtainMessage(1, h0Var.f15015e), h0Var.f15017g.f15025m);
                    c0790b = C0790b.f6678e;
                } else {
                    h0Var.f15012b = 2;
                    try {
                        k0 k0Var2 = h0Var.f15017g;
                        k0Var2.f15023k.c(k0Var2.f15020h, h0Var);
                    } catch (IllegalArgumentException unused) {
                    }
                    c0790b = new C0790b(16);
                }
                return c0790b;
            } finally {
                StrictMode.setVmPolicy(vmPolicyA);
            }
        } catch (U e8) {
            return e8.f14942a;
        }
    }

    public final int a() {
        return this.f15012b;
    }

    public final ComponentName b() {
        return this.f15016f;
    }

    public final IBinder c() {
        return this.f15014d;
    }

    public final void e(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f15011a.put(serviceConnection, serviceConnection2);
    }

    public final void f(ServiceConnection serviceConnection, String str) {
        this.f15011a.remove(serviceConnection);
    }

    public final void g(String str) {
        this.f15017g.f15021i.removeMessages(1, this.f15015e);
        k0 k0Var = this.f15017g;
        k0Var.f15023k.c(k0Var.f15020h, this);
        this.f15013c = false;
        this.f15012b = 2;
    }

    public final boolean h(ServiceConnection serviceConnection) {
        return this.f15011a.containsKey(serviceConnection);
    }

    public final boolean i() {
        return this.f15011a.isEmpty();
    }

    public final boolean j() {
        return this.f15013c;
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f15017g.f15019g) {
            try {
                this.f15017g.f15021i.removeMessages(1, this.f15015e);
                this.f15014d = iBinder;
                this.f15016f = componentName;
                Iterator it = this.f15011a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f15012b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f15017g.f15019g) {
            try {
                this.f15017g.f15021i.removeMessages(1, this.f15015e);
                this.f15014d = null;
                this.f15016f = componentName;
                Iterator it = this.f15011a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f15012b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
