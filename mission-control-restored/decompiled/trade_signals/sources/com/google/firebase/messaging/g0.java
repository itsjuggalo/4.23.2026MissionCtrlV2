package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static WeakReference f15731d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SharedPreferences f15732a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0 f15733b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f15734c;

    public g0(SharedPreferences sharedPreferences, Executor executor) {
        this.f15734c = executor;
        this.f15732a = sharedPreferences;
    }

    public static synchronized g0 b(Context context, Executor executor) {
        g0 g0Var;
        try {
            WeakReference weakReference = f15731d;
            g0Var = weakReference != null ? (g0) weakReference.get() : null;
            if (g0Var == null) {
                g0Var = new g0(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                g0Var.d();
                f15731d = new WeakReference(g0Var);
            }
        } catch (Throwable th) {
            throw th;
        }
        return g0Var;
    }

    public synchronized boolean a(f0 f0Var) {
        return this.f15733b.b(f0Var.e());
    }

    public synchronized f0 c() {
        return f0.a(this.f15733b.f());
    }

    public final synchronized void d() {
        this.f15733b = c0.d(this.f15732a, "topic_operation_queue", com.amazon.a.a.o.b.f.f14100a, this.f15734c);
    }

    public synchronized boolean e(f0 f0Var) {
        return this.f15733b.g(f0Var.e());
    }
}
