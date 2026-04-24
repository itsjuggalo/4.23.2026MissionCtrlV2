package y3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import t3.InterfaceC1807c0;
import t3.InterfaceC1830o;
import t3.S;
import t3.V;

/* JADX INFO: renamed from: y3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1959m extends t3.I implements V {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15990h = AtomicIntegerFieldUpdater.newUpdater(C1959m.class, "runningWorkers");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t3.I f15991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f15992d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ V f15993e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final r f15994f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f15995g;
    private volatile int runningWorkers;

    /* JADX INFO: renamed from: y3.m$a */
    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f15996a;

        public a(Runnable runnable) {
            this.f15996a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i4 = 0;
            while (true) {
                try {
                    this.f15996a.run();
                } catch (Throwable th) {
                    t3.K.a(Z2.j.f6012a, th);
                }
                Runnable runnableI0 = C1959m.this.i0();
                if (runnableI0 == null) {
                    return;
                }
                this.f15996a = runnableI0;
                i4++;
                if (i4 >= 16 && C1959m.this.f15991c.e0(C1959m.this)) {
                    C1959m.this.f15991c.d0(C1959m.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C1959m(t3.I i4, int i5) {
        this.f15991c = i4;
        this.f15992d = i5;
        V v4 = i4 instanceof V ? (V) i4 : null;
        this.f15993e = v4 == null ? S.a() : v4;
        this.f15994f = new r(false);
        this.f15995g = new Object();
    }

    @Override // t3.V
    public InterfaceC1807c0 a0(long j4, Runnable runnable, Z2.i iVar) {
        return this.f15993e.a0(j4, runnable, iVar);
    }

    @Override // t3.I
    public void d0(Z2.i iVar, Runnable runnable) {
        Runnable runnableI0;
        this.f15994f.a(runnable);
        if (f15990h.get(this) >= this.f15992d || !j0() || (runnableI0 = i0()) == null) {
            return;
        }
        this.f15991c.d0(this, new a(runnableI0));
    }

    @Override // t3.I
    public t3.I f0(int i4) {
        AbstractC1960n.a(i4);
        return i4 >= this.f15992d ? this : super.f0(i4);
    }

    public final Runnable i0() {
        while (true) {
            Runnable runnable = (Runnable) this.f15994f.d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f15995g) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15990h;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f15994f.c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean j0() {
        synchronized (this.f15995g) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f15990h;
            if (atomicIntegerFieldUpdater.get(this) >= this.f15992d) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }

    @Override // t3.V
    public void p(long j4, InterfaceC1830o interfaceC1830o) {
        this.f15993e.p(j4, interfaceC1830o);
    }
}
