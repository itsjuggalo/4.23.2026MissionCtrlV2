package androidx.activity;

import W2.E;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f6284a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f6285b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f6286c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6287d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f6288e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f6289f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f6290g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f6291h;

    public n(Executor executor, Function0 reportFullyDrawn) {
        kotlin.jvm.internal.r.f(executor, "executor");
        kotlin.jvm.internal.r.f(reportFullyDrawn, "reportFullyDrawn");
        this.f6284a = executor;
        this.f6285b = reportFullyDrawn;
        this.f6286c = new Object();
        this.f6290g = new ArrayList();
        this.f6291h = new Runnable() { // from class: androidx.activity.m
            @Override // java.lang.Runnable
            public final void run() {
                n.d(this.f6283a);
            }
        };
    }

    public static final void d(n this$0) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        synchronized (this$0.f6286c) {
            try {
                this$0.f6288e = false;
                if (this$0.f6287d == 0 && !this$0.f6289f) {
                    this$0.f6285b.invoke();
                    this$0.b();
                }
                E e4 = E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f6286c) {
            try {
                this.f6289f = true;
                Iterator it = this.f6290g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f6290g.clear();
                E e4 = E.f5463a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z4;
        synchronized (this.f6286c) {
            z4 = this.f6289f;
        }
        return z4;
    }
}
