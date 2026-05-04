package uc;

import cc.r;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends r {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final C0393b f22912e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f f22913f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f22914g = e(Runtime.getRuntime().availableProcessors(), Integer.getInteger("rx2.computation-threads", 0).intValue());

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final c f22915h;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ThreadFactory f22916c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f22917d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends r.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jc.d f22918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final fc.a f22919b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jc.d f22920c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final c f22921d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f22922e;

        public a(c cVar) {
            this.f22921d = cVar;
            jc.d dVar = new jc.d();
            this.f22918a = dVar;
            fc.a aVar = new fc.a();
            this.f22919b = aVar;
            jc.d dVar2 = new jc.d();
            this.f22920c = dVar2;
            dVar2.d(dVar);
            dVar2.d(aVar);
        }

        @Override // cc.r.b
        public fc.b b(Runnable runnable) {
            return this.f22922e ? jc.c.INSTANCE : this.f22921d.e(runnable, 0L, TimeUnit.MILLISECONDS, this.f22918a);
        }

        @Override // fc.b
        public boolean c() {
            return this.f22922e;
        }

        @Override // cc.r.b
        public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
            return this.f22922e ? jc.c.INSTANCE : this.f22921d.e(runnable, j10, timeUnit, this.f22919b);
        }

        @Override // fc.b
        public void dispose() {
            if (this.f22922e) {
                return;
            }
            this.f22922e = true;
            this.f22920c.dispose();
        }
    }

    /* JADX INFO: renamed from: uc.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0393b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f22923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c[] f22924b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f22925c;

        public C0393b(int i10, ThreadFactory threadFactory) {
            this.f22923a = i10;
            this.f22924b = new c[i10];
            for (int i11 = 0; i11 < i10; i11++) {
                this.f22924b[i11] = new c(threadFactory);
            }
        }

        public c a() {
            int i10 = this.f22923a;
            if (i10 == 0) {
                return b.f22915h;
            }
            c[] cVarArr = this.f22924b;
            long j10 = this.f22925c;
            this.f22925c = 1 + j10;
            return cVarArr[(int) (j10 % ((long) i10))];
        }

        public void b() {
            for (c cVar : this.f22924b) {
                cVar.dispose();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends e {
        public c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        c cVar = new c(new f("RxComputationShutdown"));
        f22915h = cVar;
        cVar.dispose();
        f fVar = new f("RxComputationThreadPool", Math.max(1, Math.min(10, Integer.getInteger("rx2.computation-priority", 5).intValue())), true);
        f22913f = fVar;
        C0393b c0393b = new C0393b(0, fVar);
        f22912e = c0393b;
        c0393b.b();
    }

    public b() {
        this(f22913f);
    }

    public static int e(int i10, int i11) {
        return (i11 <= 0 || i11 > i10) ? i10 : i11;
    }

    @Override // cc.r
    public r.b b() {
        return new a(((C0393b) this.f22917d.get()).a());
    }

    @Override // cc.r
    public fc.b d(Runnable runnable, long j10, TimeUnit timeUnit) {
        return ((C0393b) this.f22917d.get()).a().f(runnable, j10, timeUnit);
    }

    public void f() {
        C0393b c0393b = new C0393b(f22914g, this.f22916c);
        if (com.amazon.a.a.l.d.a(this.f22917d, f22912e, c0393b)) {
            return;
        }
        c0393b.b();
    }

    public b(ThreadFactory threadFactory) {
        this.f22916c = threadFactory;
        this.f22917d = new AtomicReference(f22912e);
        f();
    }
}
