package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Looper;
import com.google.android.gms.internal.common.zzh;
import java.util.HashMap;
import java.util.concurrent.Executor;
import u1.C1200b;

/* JADX INFO: loaded from: classes.dex */
public final class V extends AbstractC0434l {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap f5225d = new HashMap();
    public final Context e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile zzh f5226f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final A1.b f5227g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f5228h;
    public final long i;

    public V(Context context, Looper looper) {
        U u6 = new U(this);
        this.e = context.getApplicationContext();
        this.f5226f = new zzh(looper, u6);
        this.f5227g = A1.b.b();
        this.f5228h = 5000L;
        this.i = 300000L;
    }

    @Override // com.google.android.gms.common.internal.AbstractC0434l
    public final C1200b b(S s6, ServiceConnection serviceConnection, String str, Executor executor) {
        synchronized (this.f5225d) {
            try {
                T t6 = (T) this.f5225d.get(s6);
                C1200b c1200bA = null;
                if (executor == null) {
                    executor = null;
                }
                if (t6 == null) {
                    t6 = new T(this, s6);
                    t6.f5218a.put(serviceConnection, serviceConnection);
                    c1200bA = T.a(t6, str, executor);
                    this.f5225d.put(s6, t6);
                } else {
                    this.f5226f.removeMessages(0, s6);
                    if (t6.f5218a.containsKey(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + s6.toString());
                    }
                    t6.f5218a.put(serviceConnection, serviceConnection);
                    int i = t6.f5219b;
                    if (i == 1) {
                        serviceConnection.onServiceConnected(t6.f5222f, t6.f5221d);
                    } else if (i == 2) {
                        c1200bA = T.a(t6, str, executor);
                    }
                }
                if (t6.f5220c) {
                    return C1200b.e;
                }
                if (c1200bA == null) {
                    c1200bA = new C1200b(-1);
                }
                return c1200bA;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.AbstractC0434l
    public final void c(S s6, ServiceConnection serviceConnection) {
        I.h(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f5225d) {
            try {
                T t6 = (T) this.f5225d.get(s6);
                if (t6 == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + s6.toString());
                }
                if (!t6.f5218a.containsKey(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + s6.toString());
                }
                t6.f5218a.remove(serviceConnection);
                if (t6.f5218a.isEmpty()) {
                    this.f5226f.sendMessageDelayed(this.f5226f.obtainMessage(0, s6), this.f5228h);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
