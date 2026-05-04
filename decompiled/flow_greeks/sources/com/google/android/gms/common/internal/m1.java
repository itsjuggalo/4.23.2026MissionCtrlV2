package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m1 implements ServiceConnection, p1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f5746a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f5747b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5748c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public IBinder f5749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l1 f5750e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ComponentName f5751f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ o1 f5752g;

    public m1(o1 o1Var, l1 l1Var) {
        Objects.requireNonNull(o1Var);
        this.f5752g = o1Var;
        this.f5750e = l1Var;
        this.f5746a = new HashMap();
        this.f5747b = 2;
    }

    public final void a(String str) {
        l1 l1Var = this.f5750e;
        o1 o1Var = this.f5752g;
        o1Var.h().removeMessages(1, l1Var);
        o1Var.i().c(o1Var.g(), this);
        this.f5748c = false;
        this.f5747b = 2;
    }

    public final void b(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f5746a.put(serviceConnection, serviceConnection2);
    }

    public final void c(ServiceConnection serviceConnection, String str) {
        this.f5746a.remove(serviceConnection);
    }

    public final boolean d() {
        return this.f5748c;
    }

    public final int e() {
        return this.f5747b;
    }

    public final boolean f(ServiceConnection serviceConnection) {
        return this.f5746a.containsKey(serviceConnection);
    }

    public final boolean g() {
        return this.f5746a.isEmpty();
    }

    public final IBinder h() {
        return this.f5749d;
    }

    public final ComponentName i() {
        return this.f5751f;
    }

    public final /* synthetic */ m5.b j(String str, Executor executor) throws Throwable {
        o1 o1Var;
        s5.a aVarI;
        Context contextG;
        l1 l1Var;
        try {
            Intent intentA = a1.a(this.f5752g.g(), this.f5750e);
            this.f5747b = 3;
            StrictMode.VmPolicy vmPolicyA = t5.u.a();
            try {
                o1Var = this.f5752g;
                aVarI = o1Var.i();
                contextG = o1Var.g();
                l1Var = this.f5750e;
            } catch (Throwable th) {
                th = th;
            }
            try {
                boolean zD = aVarI.d(contextG, str, intentA, this, 4225, executor);
                this.f5748c = zD;
                if (zD) {
                    o1Var.h().sendMessageDelayed(o1Var.h().obtainMessage(1, l1Var), o1Var.j());
                    m5.b bVar = m5.b.f15883e;
                    StrictMode.setVmPolicy(vmPolicyA);
                    return bVar;
                }
                this.f5747b = 2;
                try {
                    o1Var.i().c(o1Var.g(), this);
                } catch (IllegalArgumentException unused) {
                }
                m5.b bVar2 = new m5.b(16);
                StrictMode.setVmPolicy(vmPolicyA);
                return bVar2;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                StrictMode.setVmPolicy(vmPolicyA);
                throw th3;
            }
        } catch (y0 e10) {
            return e10.f5809a;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        o1 o1Var = this.f5752g;
        synchronized (o1Var.f()) {
            try {
                o1Var.h().removeMessages(1, this.f5750e);
                this.f5749d = iBinder;
                this.f5751f = componentName;
                Iterator it = this.f5746a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f5747b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        o1 o1Var = this.f5752g;
        synchronized (o1Var.f()) {
            try {
                o1Var.h().removeMessages(1, this.f5750e);
                this.f5749d = null;
                this.f5751f = componentName;
                Iterator it = this.f5746a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f5747b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
