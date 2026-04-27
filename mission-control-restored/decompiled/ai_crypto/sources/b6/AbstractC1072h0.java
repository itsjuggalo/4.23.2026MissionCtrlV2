package b6;

import b6.V;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import v.AbstractC2759b;

/* JADX INFO: renamed from: b6.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1072h0 extends AbstractC1074i0 implements V {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9066f = AtomicReferenceFieldUpdater.newUpdater(AbstractC1072h0.class, Object.class, "_queue");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f9067g = AtomicReferenceFieldUpdater.newUpdater(AbstractC1072h0.class, Object.class, "_delayed");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f9068h = AtomicIntegerFieldUpdater.newUpdater(AbstractC1072h0.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* JADX INFO: renamed from: b6.h0$a */
    public final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InterfaceC1085o f9069c;

        public a(long j7, InterfaceC1085o interfaceC1085o) {
            super(j7);
            this.f9069c = interfaceC1085o;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9069c.i(AbstractC1072h0.this, E5.E.f1657a);
        }

        @Override // b6.AbstractC1072h0.c
        public String toString() {
            return super.toString() + this.f9069c;
        }
    }

    /* JADX INFO: renamed from: b6.h0$b */
    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f9071c;

        public b(long j7, Runnable runnable) {
            super(j7);
            this.f9071c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9071c.run();
        }

        @Override // b6.AbstractC1072h0.c
        public String toString() {
            return super.toString() + this.f9071c;
        }
    }

    /* JADX INFO: renamed from: b6.h0$c */
    public static abstract class c implements Runnable, Comparable, InterfaceC1062c0, g6.M {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9072a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9073b = -1;

        public c(long j7) {
            this.f9072a = j7;
        }

        @Override // b6.InterfaceC1062c0
        public final void a() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == AbstractC1078k0.f9075a) {
                        return;
                    }
                    d dVar = obj instanceof d ? (d) obj : null;
                    if (dVar != null) {
                        dVar.g(this);
                    }
                    this._heap = AbstractC1078k0.f9075a;
                    E5.E e7 = E5.E.f1657a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // g6.M
        public g6.L b() {
            Object obj = this._heap;
            if (obj instanceof g6.L) {
                return (g6.L) obj;
            }
            return null;
        }

        @Override // g6.M
        public void h(int i7) {
            this.f9073b = i7;
        }

        @Override // g6.M
        public void i(g6.L l7) {
            if (this._heap == AbstractC1078k0.f9075a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = l7;
        }

        @Override // g6.M
        public int j() {
            return this.f9073b;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            long j7 = this.f9072a - cVar.f9072a;
            if (j7 > 0) {
                return 1;
            }
            return j7 < 0 ? -1 : 0;
        }

        public final int l(long j7, d dVar, AbstractC1072h0 abstractC1072h0) {
            synchronized (this) {
                if (this._heap == AbstractC1078k0.f9075a) {
                    return 2;
                }
                synchronized (dVar) {
                    try {
                        c cVar = (c) dVar.b();
                        if (abstractC1072h0.isCompleted()) {
                            return 1;
                        }
                        if (cVar == null) {
                            dVar.f9074c = j7;
                        } else {
                            long j8 = cVar.f9072a;
                            if (j8 - j7 < 0) {
                                j7 = j8;
                            }
                            if (j7 - dVar.f9074c > 0) {
                                dVar.f9074c = j7;
                            }
                        }
                        long j9 = this.f9072a;
                        long j10 = dVar.f9074c;
                        if (j9 - j10 < 0) {
                            this.f9072a = j10;
                        }
                        dVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean m(long j7) {
            return j7 - this.f9072a >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f9072a + ']';
        }
    }

    /* JADX INFO: renamed from: b6.h0$d */
    public static final class d extends g6.L {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9074c;

        public d(long j7) {
            this.f9074c = j7;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        return f9068h.get(this) != 0;
    }

    @Override // b6.AbstractC1070g0
    public long F0() {
        c cVar;
        if (super.F0() == 0) {
            return 0L;
        }
        Object obj = f9066f.get(this);
        if (obj != null) {
            if (!(obj instanceof g6.s)) {
                return obj == AbstractC1078k0.f9076b ? Long.MAX_VALUE : 0L;
            }
            if (!((g6.s) obj).g()) {
                return 0L;
            }
        }
        d dVar = (d) f9067g.get(this);
        if (dVar == null || (cVar = (c) dVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j7 = cVar.f9072a;
        AbstractC1061c.a();
        return W5.l.c(j7 - System.nanoTime(), 0L);
    }

    @Override // b6.V
    public void G(long j7, InterfaceC1085o interfaceC1085o) {
        long jC = AbstractC1078k0.c(j7);
        if (jC < 4611686018427387903L) {
            AbstractC1061c.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, interfaceC1085o);
            Y0(jNanoTime, aVar);
            r.a(interfaceC1085o, aVar);
        }
    }

    @Override // b6.AbstractC1070g0
    public long K0() {
        g6.M mH;
        if (L0()) {
            return 0L;
        }
        d dVar = (d) f9067g.get(this);
        if (dVar != null && !dVar.d()) {
            AbstractC1061c.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    try {
                        g6.M mB = dVar.b();
                        if (mB != null) {
                            c cVar = (c) mB;
                            mH = cVar.m(jNanoTime) ? U0(cVar) : false ? dVar.h(0) : null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (((c) mH) != null);
        }
        Runnable runnableS0 = S0();
        if (runnableS0 == null) {
            return F0();
        }
        runnableS0.run();
        return 0L;
    }

    public final void R0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9066f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (AbstractC2759b.a(f9066f, this, null, AbstractC1078k0.f9076b)) {
                    return;
                }
            } else if (obj instanceof g6.s) {
                ((g6.s) obj).d();
                return;
            } else {
                if (obj == AbstractC1078k0.f9076b) {
                    return;
                }
                g6.s sVar = new g6.s(8, true);
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar.a((Runnable) obj);
                if (AbstractC2759b.a(f9066f, this, obj, sVar)) {
                    return;
                }
            }
        }
    }

    public final Runnable S0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9066f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof g6.s) {
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                g6.s sVar = (g6.s) obj;
                Object objJ = sVar.j();
                if (objJ != g6.s.f14322h) {
                    return (Runnable) objJ;
                }
                AbstractC2759b.a(f9066f, this, obj, sVar.i());
            } else {
                if (obj == AbstractC1078k0.f9076b) {
                    return null;
                }
                if (AbstractC2759b.a(f9066f, this, obj, null)) {
                    kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void T0(Runnable runnable) {
        if (U0(runnable)) {
            P0();
        } else {
            Q.f9020i.T0(runnable);
        }
    }

    public final boolean U0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9066f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (AbstractC2759b.a(f9066f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof g6.s) {
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                g6.s sVar = (g6.s) obj;
                int iA = sVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    AbstractC2759b.a(f9066f, this, obj, sVar.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == AbstractC1078k0.f9076b) {
                    return false;
                }
                g6.s sVar2 = new g6.s(8, true);
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar2.a((Runnable) obj);
                sVar2.a(runnable);
                if (AbstractC2759b.a(f9066f, this, obj, sVar2)) {
                    return true;
                }
            }
        }
    }

    public boolean V0() {
        if (!J0()) {
            return false;
        }
        d dVar = (d) f9067g.get(this);
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = f9066f.get(this);
        if (obj != null) {
            if (obj instanceof g6.s) {
                return ((g6.s) obj).g();
            }
            if (obj != AbstractC1078k0.f9076b) {
                return false;
            }
        }
        return true;
    }

    public final void W0() {
        c cVar;
        AbstractC1061c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) f9067g.get(this);
            if (dVar == null || (cVar = (c) dVar.i()) == null) {
                return;
            } else {
                O0(jNanoTime, cVar);
            }
        }
    }

    public final void X0() {
        f9066f.set(this, null);
        f9067g.set(this, null);
    }

    public final void Y0(long j7, c cVar) {
        int iZ0 = Z0(j7, cVar);
        if (iZ0 == 0) {
            if (c1(cVar)) {
                P0();
            }
        } else if (iZ0 == 1) {
            O0(j7, cVar);
        } else if (iZ0 != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    public final int Z0(long j7, c cVar) {
        if (isCompleted()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9067g;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        if (dVar == null) {
            AbstractC2759b.a(atomicReferenceFieldUpdater, this, null, new d(j7));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kotlin.jvm.internal.r.c(obj);
            dVar = (d) obj;
        }
        return cVar.l(j7, dVar, this);
    }

    public final InterfaceC1062c0 a1(long j7, Runnable runnable) {
        long jC = AbstractC1078k0.c(j7);
        if (jC >= 4611686018427387903L) {
            return K0.f9009a;
        }
        AbstractC1061c.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jC + jNanoTime, runnable);
        Y0(jNanoTime, bVar);
        return bVar;
    }

    public final void b1(boolean z7) {
        f9068h.set(this, z7 ? 1 : 0);
    }

    public final boolean c1(c cVar) {
        d dVar = (d) f9067g.get(this);
        return (dVar != null ? (c) dVar.e() : null) == cVar;
    }

    public InterfaceC1062c0 i(long j7, Runnable runnable, H5.g gVar) {
        return V.a.a(this, j7, runnable, gVar);
    }

    @Override // b6.AbstractC1070g0
    public void shutdown() {
        U0.f9024a.c();
        b1(true);
        R0();
        while (K0() <= 0) {
        }
        W0();
    }

    @Override // b6.I
    public final void y0(H5.g gVar, Runnable runnable) {
        T0(runnable);
    }
}
