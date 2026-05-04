package n9;

import java.util.concurrent.Executor;
import java.util.concurrent.Semaphore;
import ng.c1;
import ng.r1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f16940b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f16941c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Executor f16942d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f16943a = new b.C0300b();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f16944a = new a();
        }

        /* JADX INFO: renamed from: n9.m$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0300b implements b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Semaphore f16945a = new Semaphore(0);

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f16946b;

            public final Semaphore a() {
                return this.f16945a;
            }

            public final int b() {
                return this.f16946b;
            }

            public final void c(int i10) {
                this.f16946b = i10;
            }
        }
    }

    static {
        int iB = vd.l.b(Runtime.getRuntime().availableProcessors(), 2);
        f16941c = iB;
        f16942d = r1.a(c1.b().c0(iB, "firestore.BackgroundQueue"));
    }

    public static final void d(Runnable runnable, b bVar) {
        try {
            runnable.run();
        } finally {
            ((b.C0300b) bVar).a().release();
        }
    }

    public final void b() {
        b bVar = this.f16943a;
        if (!(bVar instanceof b.C0300b)) {
            throw new IllegalStateException("drain() may not be called more than once");
        }
        this.f16943a = b.a.f16944a;
        b.C0300b c0300b = (b.C0300b) bVar;
        c0300b.a().acquire(c0300b.b());
    }

    public final void c(final Runnable runnable) {
        kotlin.jvm.internal.t.f(runnable, "runnable");
        final b bVar = this.f16943a;
        if (!(bVar instanceof b.C0300b)) {
            throw new IllegalStateException("submit() may not be called after drain()");
        }
        b.C0300b c0300b = (b.C0300b) bVar;
        c0300b.c(c0300b.b() + 1);
        f16942d.execute(new Runnable() { // from class: n9.l
            @Override // java.lang.Runnable
            public final void run() {
                m.d(runnable, bVar);
            }
        });
    }
}
