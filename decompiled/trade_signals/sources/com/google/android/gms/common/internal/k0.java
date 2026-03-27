package com.google.android.gms.common.internal;

import Q1.C0790b;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class k0 extends AbstractC1288h {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f15019g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f15020h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Handler f15021i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final i0 f15022j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final V1.a f15023k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f15024l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f15025m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile Executor f15026n;

    public k0(Context context, Looper looper, Executor executor) {
        i0 i0Var = new i0(this, null);
        this.f15022j = i0Var;
        this.f15020h = context.getApplicationContext();
        this.f15021i = new e2.f(looper, i0Var);
        this.f15023k = V1.a.b();
        this.f15024l = 5000L;
        this.f15025m = 300000L;
        this.f15026n = executor;
    }

    @Override // com.google.android.gms.common.internal.AbstractC1288h
    public final C0790b c(g0 g0Var, ServiceConnection serviceConnection, String str, Executor executor) {
        C0790b c0790bD;
        AbstractC1294n.k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f15019g) {
            try {
                h0 h0Var = (h0) this.f15019g.get(g0Var);
                if (executor == null) {
                    executor = this.f15026n;
                }
                if (h0Var == null) {
                    h0Var = new h0(this, g0Var);
                    h0Var.e(serviceConnection, serviceConnection, str);
                    c0790bD = h0.d(h0Var, str, executor);
                    this.f15019g.put(g0Var, h0Var);
                } else {
                    this.f15021i.removeMessages(0, g0Var);
                    if (h0Var.h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + g0Var.toString());
                    }
                    h0Var.e(serviceConnection, serviceConnection, str);
                    int iA = h0Var.a();
                    if (iA == 1) {
                        serviceConnection.onServiceConnected(h0Var.b(), h0Var.c());
                    } else if (iA == 2) {
                        c0790bD = h0.d(h0Var, str, executor);
                    }
                    c0790bD = null;
                }
                if (h0Var.j()) {
                    return C0790b.f6678e;
                }
                if (c0790bD == null) {
                    c0790bD = new C0790b(-1);
                }
                return c0790bD;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC1288h
    public final void d(g0 g0Var, ServiceConnection serviceConnection, String str) {
        AbstractC1294n.k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f15019g) {
            try {
                h0 h0Var = (h0) this.f15019g.get(g0Var);
                if (h0Var == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + g0Var.toString());
                }
                if (!h0Var.h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + g0Var.toString());
                }
                h0Var.f(serviceConnection, str);
                if (h0Var.i()) {
                    this.f15021i.sendMessageDelayed(this.f15021i.obtainMessage(0, g0Var), this.f15024l);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
