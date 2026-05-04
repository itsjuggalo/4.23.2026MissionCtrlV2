package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zzg;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class o1 extends i {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final HashMap f5761g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Context f5762h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile Handler f5763i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final n1 f5764j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final s5.a f5765k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f5766l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f5767m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public volatile Executor f5768n;

    public o1(Context context, Looper looper, Executor executor) {
        n1 n1Var = new n1(this, null);
        this.f5764j = n1Var;
        this.f5762h = context.getApplicationContext();
        this.f5763i = new zzg(looper, n1Var);
        this.f5765k = s5.a.b();
        this.f5766l = 5000L;
        this.f5767m = 300000L;
        this.f5768n = executor;
    }

    @Override // com.google.android.gms.common.internal.i
    public final m5.b c(l1 l1Var, ServiceConnection serviceConnection, String str, Executor executor) {
        m5.b bVarJ;
        s.l(serviceConnection, "ServiceConnection must not be null");
        HashMap map = this.f5761g;
        synchronized (map) {
            try {
                m1 m1Var = (m1) map.get(l1Var);
                if (executor == null) {
                    executor = this.f5768n;
                }
                if (m1Var == null) {
                    m1Var = new m1(this, l1Var);
                    m1Var.b(serviceConnection, serviceConnection, str);
                    bVarJ = m1Var.j(str, executor);
                    map.put(l1Var, m1Var);
                } else {
                    this.f5763i.removeMessages(0, l1Var);
                    if (m1Var.f(serviceConnection)) {
                        String string = l1Var.toString();
                        StringBuilder sb2 = new StringBuilder(string.length() + 81);
                        sb2.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb2.append(string);
                        throw new IllegalStateException(sb2.toString());
                    }
                    m1Var.b(serviceConnection, serviceConnection, str);
                    int iE = m1Var.e();
                    if (iE == 1) {
                        serviceConnection.onServiceConnected(m1Var.i(), m1Var.h());
                    } else if (iE == 2) {
                        bVarJ = m1Var.j(str, executor);
                    }
                    bVarJ = null;
                }
                if (m1Var.d()) {
                    return m5.b.f15883e;
                }
                if (bVarJ == null) {
                    bVarJ = new m5.b(-1);
                }
                return bVarJ;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.i
    public final void e(l1 l1Var, ServiceConnection serviceConnection, String str) {
        s.l(serviceConnection, "ServiceConnection must not be null");
        HashMap map = this.f5761g;
        synchronized (map) {
            try {
                m1 m1Var = (m1) map.get(l1Var);
                if (m1Var == null) {
                    String string = l1Var.toString();
                    StringBuilder sb2 = new StringBuilder(string.length() + 50);
                    sb2.append("Nonexistent connection status for service config: ");
                    sb2.append(string);
                    throw new IllegalStateException(sb2.toString());
                }
                if (!m1Var.f(serviceConnection)) {
                    String string2 = l1Var.toString();
                    StringBuilder sb3 = new StringBuilder(string2.length() + 76);
                    sb3.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb3.append(string2);
                    throw new IllegalStateException(sb3.toString());
                }
                m1Var.c(serviceConnection, str);
                if (m1Var.g()) {
                    this.f5763i.sendMessageDelayed(this.f5763i.obtainMessage(0, l1Var), this.f5766l);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ HashMap f() {
        return this.f5761g;
    }

    public final /* synthetic */ Context g() {
        return this.f5762h;
    }

    public final /* synthetic */ Handler h() {
        return this.f5763i;
    }

    public final /* synthetic */ s5.a i() {
        return this.f5765k;
    }

    public final /* synthetic */ long j() {
        return this.f5767m;
    }
}
