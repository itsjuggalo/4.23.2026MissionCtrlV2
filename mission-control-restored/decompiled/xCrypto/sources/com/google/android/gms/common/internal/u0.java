package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzh;
import java.util.HashMap;
import java.util.concurrent.Executor;
import z1.C1984b;

/* JADX INFO: loaded from: classes.dex */
public final class u0 extends AbstractC0931i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f9976g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f9977h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Handler f9978i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final s0 f9979j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final F1.b f9980k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f9981l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f9982m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile Executor f9983n;

    public u0(Context context, Looper looper, Executor executor) {
        s0 s0Var = new s0(this, null);
        this.f9979j = s0Var;
        this.f9977h = context.getApplicationContext();
        this.f9978i = new zzh(looper, s0Var);
        this.f9980k = F1.b.b();
        this.f9981l = 5000L;
        this.f9982m = 300000L;
        this.f9983n = executor;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0931i
    public final C1984b e(q0 q0Var, ServiceConnection serviceConnection, String str, Executor executor) {
        C1984b c1984bD;
        AbstractC0940s.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f9976g) {
            try {
                r0 r0Var = (r0) this.f9976g.get(q0Var);
                if (executor == null) {
                    executor = this.f9983n;
                }
                if (r0Var == null) {
                    r0Var = new r0(this, q0Var);
                    r0Var.e(serviceConnection, serviceConnection, str);
                    c1984bD = r0.d(r0Var, str, executor);
                    this.f9976g.put(q0Var, r0Var);
                } else {
                    this.f9978i.removeMessages(0, q0Var);
                    if (r0Var.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + q0Var.toString());
                    }
                    r0Var.e(serviceConnection, serviceConnection, str);
                    int iA = r0Var.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(r0Var.b(), r0Var.c());
                    } else if (iA == 2) {
                        c1984bD = r0.d(r0Var, str, executor);
                    }
                    c1984bD = null;
                }
                if (r0Var.j()) {
                    return C1984b.f16081e;
                }
                if (c1984bD == null) {
                    c1984bD = new C1984b(-1);
                }
                return c1984bD;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC0931i
    public final void f(q0 q0Var, ServiceConnection serviceConnection, String str) {
        AbstractC0940s.l(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f9976g) {
            try {
                r0 r0Var = (r0) this.f9976g.get(q0Var);
                if (r0Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + q0Var.toString());
                }
                if (!r0Var.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + q0Var.toString());
                }
                r0Var.f(serviceConnection, str);
                if (r0Var.i()) {
                    this.f9978i.sendMessageDelayed(this.f9978i.obtainMessage(0, q0Var), this.f9981l);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
