package g6;

import b6.InterfaceC1062c0;
import b6.InterfaceC1085o;
import b6.S;
import b6.V;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: renamed from: g6.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1653m extends b6.I implements V {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f14304h = AtomicIntegerFieldUpdater.newUpdater(C1653m.class, "runningWorkers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b6.I f14305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f14306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ V f14307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f14308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f14309g;
    private volatile int runningWorkers;

    /* JADX INFO: renamed from: g6.m$a */
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f14310a;

        public a(Runnable runnable) {
            this.f14310a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i7 = 0;
            while (true) {
                try {
                    this.f14310a.run();
                } catch (Throwable th) {
                    b6.K.a(H5.h.f2671a, th);
                }
                Runnable runnableD0 = C1653m.this.D0();
                if (runnableD0 == null) {
                    return;
                }
                this.f14310a = runnableD0;
                i7++;
                if (i7 >= 16 && C1653m.this.f14305c.z0(C1653m.this)) {
                    C1653m.this.f14305c.y0(C1653m.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1653m(b6.I i7, int i8) {
        this.f14305c = i7;
        this.f14306d = i8;
        V v7 = i7 instanceof V ? (V) i7 : null;
        this.f14307e = v7 == null ? S.a() : v7;
        this.f14308f = new r(false);
        this.f14309g = new Object();
    }

    public final Runnable D0() {
        while (true) {
            Runnable runnable = (Runnable) this.f14308f.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f14309g) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14304h;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f14308f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean E0() {
        synchronized (this.f14309g) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f14304h;
            if (atomicIntegerFieldUpdater.get(this) >= this.f14306d) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // b6.V
    public void G(long j7, InterfaceC1085o interfaceC1085o) {
        this.f14307e.G(j7, interfaceC1085o);
    }

    @Override // b6.V
    public InterfaceC1062c0 i(long j7, Runnable runnable, H5.g gVar) {
        return this.f14307e.i(j7, runnable, gVar);
    }

    @Override // b6.I
    public void y0(H5.g gVar, Runnable runnable) {
        Runnable runnableD0;
        this.f14308f.a(runnable);
        if (f14304h.get(this) >= this.f14306d || !E0() || (runnableD0 = D0()) == null) {
            return;
        }
        this.f14305c.y0(this, new a(runnableD0));
    }
}
