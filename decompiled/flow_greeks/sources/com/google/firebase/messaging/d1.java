package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference f6305d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f6306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z0 f6307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f6308c;

    public d1(SharedPreferences sharedPreferences, Executor executor) {
        this.f6308c = executor;
        this.f6306a = sharedPreferences;
    }

    public static synchronized d1 b(Context context, Executor executor) {
        d1 d1Var;
        try {
            WeakReference weakReference = f6305d;
            d1Var = weakReference != null ? (d1) weakReference.get() : null;
            if (d1Var == null) {
                d1Var = new d1(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                d1Var.d();
                f6305d = new WeakReference(d1Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return d1Var;
    }

    public synchronized boolean a(c1 c1Var) {
        return this.f6307b.b(c1Var.e());
    }

    public synchronized c1 c() {
        return c1.a(this.f6307b.f());
    }

    public final synchronized void d() {
        this.f6307b = z0.d(this.f6306a, "topic_operation_queue", com.amazon.a.a.o.b.f.f4598a, this.f6308c);
    }

    public synchronized boolean e(c1 c1Var) {
        return this.f6307b.g(c1Var.e());
    }
}
