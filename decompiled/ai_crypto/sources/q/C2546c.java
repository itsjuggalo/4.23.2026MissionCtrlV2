package q;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: q.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2546c extends AbstractC2548e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile C2546c f22098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f22099d = new Executor() { // from class: q.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C2546c.g(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f22100e = new Executor() { // from class: q.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C2546c.h(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AbstractC2548e f22101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2548e f22102b;

    public C2546c() {
        C2547d c2547d = new C2547d();
        this.f22102b = c2547d;
        this.f22101a = c2547d;
    }

    public static C2546c f() {
        if (f22098c != null) {
            return f22098c;
        }
        synchronized (C2546c.class) {
            try {
                if (f22098c == null) {
                    f22098c = new C2546c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f22098c;
    }

    public static /* synthetic */ void g(Runnable runnable) {
        f().c(runnable);
    }

    public static /* synthetic */ void h(Runnable runnable) {
        f().a(runnable);
    }

    @Override // q.AbstractC2548e
    public void a(Runnable runnable) {
        this.f22101a.a(runnable);
    }

    @Override // q.AbstractC2548e
    public boolean b() {
        return this.f22101a.b();
    }

    @Override // q.AbstractC2548e
    public void c(Runnable runnable) {
        this.f22101a.c(runnable);
    }
}
