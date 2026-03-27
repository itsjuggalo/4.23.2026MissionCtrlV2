package p;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: p.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2536c extends AbstractC2538e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile C2536c f22240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f22241d = new Executor() { // from class: p.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C2536c.g(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f22242e = new Executor() { // from class: p.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C2536c.h(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC2538e f22243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2538e f22244b;

    public C2536c() {
        C2537d c2537d = new C2537d();
        this.f22244b = c2537d;
        this.f22243a = c2537d;
    }

    public static C2536c f() {
        if (f22240c != null) {
            return f22240c;
        }
        synchronized (C2536c.class) {
            try {
                if (f22240c == null) {
                    f22240c = new C2536c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f22240c;
    }

    public static /* synthetic */ void g(Runnable runnable) {
        f().c(runnable);
    }

    public static /* synthetic */ void h(Runnable runnable) {
        f().a(runnable);
    }

    @Override // p.AbstractC2538e
    public void a(Runnable runnable) {
        this.f22243a.a(runnable);
    }

    @Override // p.AbstractC2538e
    public boolean b() {
        return this.f22243a.b();
    }

    @Override // p.AbstractC2538e
    public void c(Runnable runnable) {
        this.f22243a.c(runnable);
    }
}
