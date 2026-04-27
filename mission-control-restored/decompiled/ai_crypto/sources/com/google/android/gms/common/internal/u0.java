package com.google.android.gms.common.internal;

import P1.C0648b;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzh;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class u0 extends AbstractC1198i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f11159g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f11160h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Handler f11161i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s0 f11162j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final V1.b f11163k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f11164l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f11165m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile Executor f11166n;

    public u0(Context context, Looper looper, Executor executor) {
        s0 s0Var = new s0(this, null);
        this.f11162j = s0Var;
        this.f11160h = context.getApplicationContext();
        this.f11161i = new zzh(looper, s0Var);
        this.f11163k = V1.b.b();
        this.f11164l = 5000L;
        this.f11165m = 300000L;
        this.f11166n = executor;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1198i
    public final C0648b e(q0 q0Var, ServiceConnection serviceConnection, String str, Executor executor) {
        C0648b c0648bD;
        AbstractC1207s.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f11159g) {
            try {
                r0 r0Var = (r0) this.f11159g.get(q0Var);
                if (executor == null) {
                    executor = this.f11166n;
                }
                if (r0Var == null) {
                    r0Var = new r0(this, q0Var);
                    r0Var.e(serviceConnection, serviceConnection, str);
                    c0648bD = r0.d(r0Var, str, executor);
                    this.f11159g.put(q0Var, r0Var);
                } else {
                    this.f11161i.removeMessages(0, q0Var);
                    if (r0Var.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + q0Var.toString());
                    }
                    r0Var.e(serviceConnection, serviceConnection, str);
                    int iA = r0Var.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(r0Var.b(), r0Var.c());
                    } else if (iA == 2) {
                        c0648bD = r0.d(r0Var, str, executor);
                    }
                    c0648bD = null;
                }
                if (r0Var.j()) {
                    return C0648b.f4284e;
                }
                if (c0648bD == null) {
                    c0648bD = new C0648b(-1);
                }
                return c0648bD;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC1198i
    public final void f(q0 q0Var, ServiceConnection serviceConnection, String str) {
        AbstractC1207s.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f11159g) {
            try {
                r0 r0Var = (r0) this.f11159g.get(q0Var);
                if (r0Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + q0Var.toString());
                }
                if (!r0Var.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + q0Var.toString());
                }
                r0Var.f(serviceConnection, str);
                if (r0Var.i()) {
                    this.f11161i.sendMessageDelayed(this.f11161i.obtainMessage(0, q0Var), this.f11164l);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
