package d;

import E5.E;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f13112a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f13113b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13114c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13115d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f13116e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f13117f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List f13118g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Runnable f13119h;

    public t(Executor executor, Function0 reportFullyDrawn) {
        kotlin.jvm.internal.r.f(executor, "executor");
        kotlin.jvm.internal.r.f(reportFullyDrawn, "reportFullyDrawn");
        this.f13112a = executor;
        this.f13113b = reportFullyDrawn;
        this.f13114c = new Object();
        this.f13118g = new ArrayList();
        this.f13119h = new Runnable() { // from class: d.s
            @Override // java.lang.Runnable
            public final void run() {
                t.d(this.f13111a);
            }
        };
    }

    public static final void d(t this$0) {
        kotlin.jvm.internal.r.f(this$0, "this$0");
        synchronized (this$0.f13114c) {
            try {
                this$0.f13116e = false;
                if (this$0.f13115d == 0 && !this$0.f13117f) {
                    this$0.f13113b.invoke();
                    this$0.b();
                }
                E e7 = E.f1657a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        synchronized (this.f13114c) {
            try {
                this.f13117f = true;
                Iterator it = this.f13118g.iterator();
                while (it.hasNext()) {
                    ((Function0) it.next()).invoke();
                }
                this.f13118g.clear();
                E e7 = E.f1657a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean c() {
        boolean z7;
        synchronized (this.f13114c) {
            z7 = this.f13117f;
        }
        return z7;
    }
}
