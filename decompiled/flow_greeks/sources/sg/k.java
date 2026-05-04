package sg;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import ng.e1;
import ng.t0;
import ng.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends ng.k0 implements w0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f20396i = AtomicIntegerFieldUpdater.newUpdater(k.class, "runningWorkers$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ w0 f20397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ng.k0 f20398d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f20399e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f20400f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p f20401g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f20402h;
    private volatile /* synthetic */ int runningWorkers$volatile;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f20403a;

        public a(Runnable runnable) {
            this.f20403a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10 = 0;
            while (true) {
                try {
                    this.f20403a.run();
                } catch (Throwable th) {
                    ng.m0.a(gd.j.f10531a, th);
                }
                Runnable runnableH0 = k.this.h0();
                if (runnableH0 == null) {
                    return;
                }
                this.f20403a = runnableH0;
                i10++;
                if (i10 >= 16 && k.this.f20398d.a0(k.this)) {
                    k.this.f20398d.Z(k.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(ng.k0 k0Var, int i10, String str) {
        w0 w0Var = k0Var instanceof w0 ? (w0) k0Var : null;
        this.f20397c = w0Var == null ? t0.a() : w0Var;
        this.f20398d = k0Var;
        this.f20399e = i10;
        this.f20400f = str;
        this.f20401g = new p(false);
        this.f20402h = new Object();
    }

    @Override // ng.w0
    public e1 K(long j10, Runnable runnable, gd.i iVar) {
        return this.f20397c.K(j10, runnable, iVar);
    }

    @Override // ng.k0
    public void Z(gd.i iVar, Runnable runnable) {
        Runnable runnableH0;
        this.f20401g.a(runnable);
        if (f20396i.get(this) >= this.f20399e || !i0() || (runnableH0 = h0()) == null) {
            return;
        }
        this.f20398d.Z(this, new a(runnableH0));
    }

    @Override // ng.w0
    public void b(long j10, ng.n nVar) {
        this.f20397c.b(j10, nVar);
    }

    @Override // ng.k0
    public ng.k0 c0(int i10, String str) {
        l.a(i10);
        return i10 >= this.f20399e ? l.b(this, str) : super.c0(i10, str);
    }

    public final Runnable h0() {
        while (true) {
            Runnable runnable = (Runnable) this.f20401g.e();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f20402h) {
                f20396i.decrementAndGet(this);
                if (this.f20401g.c() == 0) {
                    return null;
                }
                f20396i.incrementAndGet(this);
            }
        }
    }

    public final boolean i0() {
        synchronized (this.f20402h) {
            if (f20396i.get(this) >= this.f20399e) {
                return false;
            }
            f20396i.incrementAndGet(this);
            return true;
        }
    }

    @Override // ng.k0
    public String toString() {
        String str = this.f20400f;
        if (str != null) {
            return str;
        }
        return this.f20398d + ".limitedParallelism(" + this.f20399e + ')';
    }
}
