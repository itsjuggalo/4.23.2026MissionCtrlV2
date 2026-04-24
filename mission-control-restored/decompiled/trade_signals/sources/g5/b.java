package g5;

import P4.r;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C0309b f18237d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f18238e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f18239f = d(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f18240g;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ThreadFactory f18241b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f18242c;

    public static final class a extends r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final W4.d f18243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final S4.a f18244b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final W4.d f18245c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f18246d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f18247e;

        public a(c cVar) {
            this.f18246d = cVar;
            W4.d dVar = new W4.d();
            this.f18243a = dVar;
            S4.a aVar = new S4.a();
            this.f18244b = aVar;
            W4.d dVar2 = new W4.d();
            this.f18245c = dVar2;
            dVar2.a(dVar);
            dVar2.a(aVar);
        }

        @Override // P4.r.b
        public S4.b b(Runnable runnable) {
            return this.f18247e ? W4.c.INSTANCE : this.f18246d.d(runnable, 0L, TimeUnit.MILLISECONDS, this.f18243a);
        }

        @Override // P4.r.b
        public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
            return this.f18247e ? W4.c.INSTANCE : this.f18246d.d(runnable, j8, timeUnit, this.f18244b);
        }

        @Override // S4.b
        public void dispose() {
            if (this.f18247e) {
                return;
            }
            this.f18247e = true;
            this.f18245c.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return this.f18247e;
        }
    }

    /* JADX INFO: renamed from: g5.b$b, reason: collision with other inner class name */
    public static final class C0309b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f18248a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f18249b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f18250c;

        public C0309b(int i8, ThreadFactory threadFactory) {
            this.f18248a = i8;
            this.f18249b = new c[i8];
            for (int i9 = 0; i9 < i8; i9++) {
                this.f18249b[i9] = new c(threadFactory);
            }
        }

        public c a() {
            int i8 = this.f18248a;
            if (i8 == 0) {
                return b.f18240g;
            }
            c[] cVarArr = this.f18249b;
            long j8 = this.f18250c;
            this.f18250c = 1 + j8;
            return cVarArr[(int) (j8 % ((long) i8))];
        }

        public void b() {
            for (c cVar : this.f18249b) {
                cVar.dispose();
            }
        }
    }

    public static final class c extends e {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new f("RxComputationShutdown"));
        f18240g = cVar;
        cVar.dispose();
        f fVar = new f("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f18238e = fVar;
        C0309b c0309b = new C0309b(0, fVar);
        f18237d = c0309b;
        c0309b.b();
    }

    public b() {
        this(f18238e);
    }

    public static int d(int i8, int i9) {
        return (i9 <= 0 || i9 > i8) ? i8 : i9;
    }

    @Override // P4.r
    public r.b a() {
        return new a(((C0309b) this.f18242c.get()).a());
    }

    @Override // P4.r
    public S4.b c(Runnable runnable, long j8, TimeUnit timeUnit) {
        return ((C0309b) this.f18242c.get()).a().e(runnable, j8, timeUnit);
    }

    public void e() {
        C0309b c0309b = new C0309b(f18239f, this.f18241b);
        if (com.amazon.a.a.l.d.a(this.f18242c, f18237d, c0309b)) {
            return;
        }
        c0309b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f18241b = threadFactory;
        this.f18242c = new AtomicReference(f18237d);
        e();
    }
}
