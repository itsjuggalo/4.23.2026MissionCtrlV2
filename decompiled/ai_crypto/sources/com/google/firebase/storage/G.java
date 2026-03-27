package com.google.firebase.storage;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static G f12343a = new G();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Executor f12344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Executor f12345c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Executor f12346d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Executor f12347e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Executor f12348f;

    public static G b() {
        return f12343a;
    }

    public static void d(Executor executor, Executor executor2) {
        f12344b = c3.z.a(executor, 5);
        f12346d = c3.z.a(executor, 3);
        f12345c = c3.z.a(executor, 2);
        f12347e = c3.z.b(executor);
        f12348f = executor2;
    }

    public Executor a() {
        return f12344b;
    }

    public Executor c() {
        return f12348f;
    }

    public void e(Runnable runnable) {
        f12347e.execute(runnable);
    }

    public void f(Runnable runnable) {
        f12344b.execute(runnable);
    }

    public void g(Runnable runnable) {
        f12346d.execute(runnable);
    }

    public void h(Runnable runnable) {
        f12345c.execute(runnable);
    }
}
