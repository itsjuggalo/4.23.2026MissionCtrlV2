package t3;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import o3.AbstractC1681l;
import t3.V;

/* JADX INFO: renamed from: t3.h0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1817h0 extends AbstractC1819i0 implements V {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15008f = AtomicReferenceFieldUpdater.newUpdater(AbstractC1817h0.class, Object.class, "_queue");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f15009g = AtomicReferenceFieldUpdater.newUpdater(AbstractC1817h0.class, Object.class, "_delayed");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f15010h = AtomicIntegerFieldUpdater.newUpdater(AbstractC1817h0.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* JADX INFO: renamed from: t3.h0$a */
    public final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InterfaceC1830o f15011c;

        public a(long j4, InterfaceC1830o interfaceC1830o) {
            super(j4);
            this.f15011c = interfaceC1830o;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15011c.j(AbstractC1817h0.this, W2.E.f5463a);
        }

        @Override // t3.AbstractC1817h0.c
        public String toString() {
            return super.toString() + this.f15011c;
        }
    }

    /* JADX INFO: renamed from: t3.h0$b */
    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f15013c;

        public b(long j4, Runnable runnable) {
            super(j4);
            this.f15013c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f15013c.run();
        }

        @Override // t3.AbstractC1817h0.c
        public String toString() {
            return super.toString() + this.f15013c;
        }
    }

    /* JADX INFO: renamed from: t3.h0$c */
    public static abstract class c implements Runnable, Comparable, InterfaceC1807c0, y3.M {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f15014a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15015b = -1;

        public c(long j4) {
            this.f15014a = j4;
        }

        @Override // y3.M
        public void a(y3.L l4) {
            if (this._heap == AbstractC1823k0.f15017a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = l4;
        }

        @Override // t3.InterfaceC1807c0
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == AbstractC1823k0.f15017a) {
                        return;
                    }
                    d dVar = obj instanceof d ? (d) obj : null;
                    if (dVar != null) {
                        dVar.g(this);
                    }
                    this._heap = AbstractC1823k0.f15017a;
                    W2.E e4 = W2.E.f5463a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // y3.M
        public y3.L g() {
            Object obj = this._heap;
            if (obj instanceof y3.L) {
                return (y3.L) obj;
            }
            return null;
        }

        @Override // y3.M
        public void h(int i4) {
            this.f15015b = i4;
        }

        @Override // y3.M
        public int i() {
            return this.f15015b;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            long j4 = this.f15014a - cVar.f15014a;
            if (j4 > 0) {
                return 1;
            }
            return j4 < 0 ? -1 : 0;
        }

        public final int l(long j4, d dVar, AbstractC1817h0 abstractC1817h0) {
            synchronized (this) {
                if (this._heap == AbstractC1823k0.f15017a) {
                    return 2;
                }
                synchronized (dVar) {
                    try {
                        c cVar = (c) dVar.b();
                        if (abstractC1817h0.isCompleted()) {
                            return 1;
                        }
                        if (cVar == null) {
                            dVar.f15016c = j4;
                        } else {
                            long j5 = cVar.f15014a;
                            if (j5 - j4 < 0) {
                                j4 = j5;
                            }
                            if (j4 - dVar.f15016c > 0) {
                                dVar.f15016c = j4;
                            }
                        }
                        long j6 = this.f15014a;
                        long j7 = dVar.f15016c;
                        if (j6 - j7 < 0) {
                            this.f15014a = j7;
                        }
                        dVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean m(long j4) {
            return j4 - this.f15014a >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f15014a + ']';
        }
    }

    /* JADX INFO: renamed from: t3.h0$d */
    public static final class d extends y3.L {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f15016c;

        public d(long j4) {
            this.f15016c = j4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        return f15010h.get(this) != 0;
    }

    public boolean A0() {
        if (!o0()) {
            return false;
        }
        d dVar = (d) f15009g.get(this);
        if (dVar != null && !dVar.d()) {
            return false;
        }
        Object obj = f15008f.get(this);
        if (obj == null) {
            return true;
        }
        return obj instanceof y3.s ? ((y3.s) obj).g() : obj == AbstractC1823k0.f15018b;
    }

    public final void B0() {
        c cVar;
        AbstractC1806c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) f15009g.get(this);
            if (dVar == null || (cVar = (c) dVar.i()) == null) {
                return;
            } else {
                t0(jNanoTime, cVar);
            }
        }
    }

    public final void C0() {
        f15008f.set(this, null);
        f15009g.set(this, null);
    }

    public final void D0(long j4, c cVar) {
        int iE0 = E0(j4, cVar);
        if (iE0 == 0) {
            if (H0(cVar)) {
                u0();
            }
        } else if (iE0 == 1) {
            t0(j4, cVar);
        } else if (iE0 != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    public final int E0(long j4, c cVar) {
        if (isCompleted()) {
            return 1;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15009g;
        d dVar = (d) atomicReferenceFieldUpdater.get(this);
        if (dVar == null) {
            androidx.concurrent.futures.b.a(atomicReferenceFieldUpdater, this, null, new d(j4));
            Object obj = atomicReferenceFieldUpdater.get(this);
            kotlin.jvm.internal.r.c(obj);
            dVar = (d) obj;
        }
        return cVar.l(j4, dVar, this);
    }

    public final InterfaceC1807c0 F0(long j4, Runnable runnable) {
        long jC = AbstractC1823k0.c(j4);
        if (jC >= 4611686018427387903L) {
            return K0.f14951a;
        }
        AbstractC1806c.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jC + jNanoTime, runnable);
        D0(jNanoTime, bVar);
        return bVar;
    }

    public final void G0(boolean z4) {
        f15010h.set(this, z4 ? 1 : 0);
    }

    public final boolean H0(c cVar) {
        d dVar = (d) f15009g.get(this);
        return (dVar != null ? (c) dVar.e() : null) == cVar;
    }

    public InterfaceC1807c0 a0(long j4, Runnable runnable, Z2.i iVar) {
        return V.a.a(this, j4, runnable, iVar);
    }

    @Override // t3.I
    public final void d0(Z2.i iVar, Runnable runnable) {
        y0(runnable);
    }

    @Override // t3.AbstractC1815g0
    public long k0() {
        c cVar;
        if (super.k0() == 0) {
            return 0L;
        }
        Object obj = f15008f.get(this);
        if (obj != null) {
            if (!(obj instanceof y3.s)) {
                return obj == AbstractC1823k0.f15018b ? Long.MAX_VALUE : 0L;
            }
            if (!((y3.s) obj).g()) {
                return 0L;
            }
        }
        d dVar = (d) f15009g.get(this);
        if (dVar == null || (cVar = (c) dVar.e()) == null) {
            return Long.MAX_VALUE;
        }
        long j4 = cVar.f15014a;
        AbstractC1806c.a();
        return AbstractC1681l.c(j4 - System.nanoTime(), 0L);
    }

    @Override // t3.V
    public void p(long j4, InterfaceC1830o interfaceC1830o) {
        long jC = AbstractC1823k0.c(j4);
        if (jC < 4611686018427387903L) {
            AbstractC1806c.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, interfaceC1830o);
            D0(jNanoTime, aVar);
            r.a(interfaceC1830o, aVar);
        }
    }

    @Override // t3.AbstractC1815g0
    public long p0() {
        y3.M mH;
        if (q0()) {
            return 0L;
        }
        d dVar = (d) f15009g.get(this);
        if (dVar != null && !dVar.d()) {
            AbstractC1806c.a();
            long jNanoTime = System.nanoTime();
            do {
                synchronized (dVar) {
                    try {
                        y3.M mB = dVar.b();
                        if (mB != null) {
                            c cVar = (c) mB;
                            mH = cVar.m(jNanoTime) ? z0(cVar) : false ? dVar.h(0) : null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            } while (((c) mH) != null);
        }
        Runnable runnableX0 = x0();
        if (runnableX0 == null) {
            return k0();
        }
        runnableX0.run();
        return 0L;
    }

    @Override // t3.AbstractC1815g0
    public void shutdown() {
        U0.f14966a.c();
        G0(true);
        w0();
        while (p0() <= 0) {
        }
        B0();
    }

    public final void w0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15008f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (androidx.concurrent.futures.b.a(f15008f, this, null, AbstractC1823k0.f15018b)) {
                    return;
                }
            } else if (obj instanceof y3.s) {
                ((y3.s) obj).d();
                return;
            } else {
                if (obj == AbstractC1823k0.f15018b) {
                    return;
                }
                y3.s sVar = new y3.s(8, true);
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar.a((Runnable) obj);
                if (androidx.concurrent.futures.b.a(f15008f, this, obj, sVar)) {
                    return;
                }
            }
        }
    }

    public final Runnable x0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15008f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof y3.s) {
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                y3.s sVar = (y3.s) obj;
                Object objJ = sVar.j();
                if (objJ != y3.s.f16008h) {
                    return (Runnable) objJ;
                }
                androidx.concurrent.futures.b.a(f15008f, this, obj, sVar.i());
            } else {
                if (obj == AbstractC1823k0.f15018b) {
                    return null;
                }
                if (androidx.concurrent.futures.b.a(f15008f, this, obj, null)) {
                    kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void y0(Runnable runnable) {
        if (z0(runnable)) {
            u0();
        } else {
            Q.f14962i.y0(runnable);
        }
    }

    public final boolean z0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f15008f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (androidx.concurrent.futures.b.a(f15008f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof y3.s) {
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                y3.s sVar = (y3.s) obj;
                int iA = sVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    androidx.concurrent.futures.b.a(f15008f, this, obj, sVar.i());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == AbstractC1823k0.f15018b) {
                    return false;
                }
                y3.s sVar2 = new y3.s(8, true);
                kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                sVar2.a((Runnable) obj);
                sVar2.a(runnable);
                if (androidx.concurrent.futures.b.a(f15008f, this, obj, sVar2)) {
                    return true;
                }
            }
        }
    }
}
