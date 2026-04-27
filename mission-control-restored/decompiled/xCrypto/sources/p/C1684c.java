package p;

import java.util.concurrent.Executor;

/* JADX INFO: renamed from: p.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1684c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile C1684c f13957c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f13958d = new Executor() { // from class: p.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C1684c.f().c(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f13959e = new Executor() { // from class: p.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            C1684c.f().a(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f13960a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f13961b;

    public C1684c() {
        d dVar = new d();
        this.f13961b = dVar;
        this.f13960a = dVar;
    }

    public static C1684c f() {
        if (f13957c != null) {
            return f13957c;
        }
        synchronized (C1684c.class) {
            try {
                if (f13957c == null) {
                    f13957c = new C1684c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f13957c;
    }

    @Override // p.e
    public void a(Runnable runnable) {
        this.f13960a.a(runnable);
    }

    @Override // p.e
    public boolean b() {
        return this.f13960a.b();
    }

    @Override // p.e
    public void c(Runnable runnable) {
        this.f13960a.c(runnable);
    }
}
