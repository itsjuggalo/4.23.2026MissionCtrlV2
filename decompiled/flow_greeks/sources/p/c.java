package p;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile c f18150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f18151d = new Executor() { // from class: p.a
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().c(runnable);
        }
    };

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Executor f18152e = new Executor() { // from class: p.b
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            c.f().a(runnable);
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f18153a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final e f18154b;

    public c() {
        d dVar = new d();
        this.f18154b = dVar;
        this.f18153a = dVar;
    }

    public static c f() {
        if (f18150c != null) {
            return f18150c;
        }
        synchronized (c.class) {
            try {
                if (f18150c == null) {
                    f18150c = new c();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f18150c;
    }

    @Override // p.e
    public void a(Runnable runnable) {
        this.f18153a.a(runnable);
    }

    @Override // p.e
    public boolean b() {
        return this.f18153a.b();
    }

    @Override // p.e
    public void c(Runnable runnable) {
        this.f18153a.c(runnable);
    }
}
