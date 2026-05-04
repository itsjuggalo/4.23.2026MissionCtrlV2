package ng;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ng.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j1 extends k1 implements w0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17143f = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_queue$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17144g = AtomicReferenceFieldUpdater.newUpdater(j1.class, Object.class, "_delayed$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17145h = AtomicIntegerFieldUpdater.newUpdater(j1.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final n f17146c;

        public a(long j10, n nVar) {
            super(j10);
            this.f17146c = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17146c.j(j1.this, cd.h0.f3852a);
        }

        @Override // ng.j1.c
        public String toString() {
            return super.toString() + this.f17146c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Runnable f17148c;

        public b(long j10, Runnable runnable) {
            super(j10);
            this.f17148c = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f17148c.run();
        }

        @Override // ng.j1.c
        public String toString() {
            return super.toString() + this.f17148c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class c implements Runnable, Comparable, e1, sg.n0 {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f17149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f17150b = -1;

        public c(long j10) {
            this.f17149a = j10;
        }

        @Override // sg.n0
        public sg.m0 b() {
            Object obj = this._heap;
            if (obj instanceof sg.m0) {
                return (sg.m0) obj;
            }
            return null;
        }

        @Override // sg.n0
        public void c(sg.m0 m0Var) {
            if (this._heap == m1.f17158a) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            this._heap = m0Var;
        }

        @Override // ng.e1
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == m1.f17158a) {
                        return;
                    }
                    d dVar = obj instanceof d ? (d) obj : null;
                    if (dVar != null) {
                        dVar.h(this);
                    }
                    this._heap = m1.f17158a;
                    cd.h0 h0Var = cd.h0.f3852a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // sg.n0
        public int getIndex() {
            return this.f17150b;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compareTo(c cVar) {
            long j10 = this.f17149a - cVar.f17149a;
            if (j10 > 0) {
                return 1;
            }
            return j10 < 0 ? -1 : 0;
        }

        public final int i(long j10, d dVar, j1 j1Var) {
            synchronized (this) {
                if (this._heap == m1.f17158a) {
                    return 2;
                }
                synchronized (dVar) {
                    try {
                        c cVar = (c) dVar.b();
                        if (j1Var.isCompleted()) {
                            return 1;
                        }
                        if (cVar == null) {
                            dVar.f17151c = j10;
                        } else {
                            long j11 = cVar.f17149a;
                            if (j11 - j10 < 0) {
                                j10 = j11;
                            }
                            if (j10 - dVar.f17151c > 0) {
                                dVar.f17151c = j10;
                            }
                        }
                        long j12 = this.f17149a;
                        long j13 = dVar.f17151c;
                        if (j12 - j13 < 0) {
                            this.f17149a = j13;
                        }
                        dVar.a(this);
                        return 0;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        }

        public final boolean k(long j10) {
            return j10 - this.f17149a >= 0;
        }

        @Override // sg.n0
        public void setIndex(int i10) {
            this.f17150b = i10;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f17149a + ']';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends sg.m0 {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f17151c;

        public d(long j10) {
            this.f17151c = j10;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isCompleted() {
        return f17145h.get(this) != 0;
    }

    public boolean C0() {
        if (!m0()) {
            return false;
        }
        d dVar = (d) f17144g.get(this);
        if (dVar != null && !dVar.e()) {
            return false;
        }
        Object obj = f17143f.get(this);
        if (obj == null) {
            return true;
        }
        return obj instanceof sg.q ? ((sg.q) obj).j() : obj == m1.f17159b;
    }

    public final void D0() {
        c cVar;
        ng.c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            d dVar = (d) f17144g.get(this);
            if (dVar == null || (cVar = (c) dVar.j()) == null) {
                return;
            } else {
                r0(jNanoTime, cVar);
            }
        }
    }

    public final void E0() {
        f17143f.set(this, null);
        f17144g.set(this, null);
    }

    public final void F0(long j10, c cVar) {
        int iG0 = G0(j10, cVar);
        if (iG0 == 0) {
            if (J0(cVar)) {
                s0();
            }
        } else if (iG0 == 1) {
            r0(j10, cVar);
        } else if (iG0 != 2) {
            throw new IllegalStateException("unexpected result");
        }
    }

    public final int G0(long j10, c cVar) {
        if (isCompleted()) {
            return 1;
        }
        d dVar = (d) f17144g.get(this);
        if (dVar == null) {
            y.b.a(f17144g, this, null, new d(j10));
            Object obj = f17144g.get(this);
            kotlin.jvm.internal.t.c(obj);
            dVar = (d) obj;
        }
        return cVar.i(j10, dVar, this);
    }

    public final e1 H0(long j10, Runnable runnable) {
        long jC = m1.c(j10);
        if (jC >= 4611686018427387903L) {
            return l2.f17156a;
        }
        ng.c.a();
        long jNanoTime = System.nanoTime();
        b bVar = new b(jC + jNanoTime, runnable);
        F0(jNanoTime, bVar);
        return bVar;
    }

    public final void I0(boolean z10) {
        f17145h.set(this, z10 ? 1 : 0);
    }

    public final boolean J0(c cVar) {
        d dVar = (d) f17144g.get(this);
        return (dVar != null ? (c) dVar.f() : null) == cVar;
    }

    @Override // ng.w0
    public e1 K(long j10, Runnable runnable, gd.i iVar) {
        return w0.a.a(this, j10, runnable, iVar);
    }

    @Override // ng.k0
    public final void Z(gd.i iVar, Runnable runnable) {
        w0(runnable);
    }

    @Override // ng.w0
    public void b(long j10, n nVar) {
        long jC = m1.c(j10);
        if (jC < 4611686018427387903L) {
            ng.c.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, nVar);
            F0(jNanoTime, aVar);
            r.a(nVar, aVar);
        }
    }

    @Override // ng.i1
    public long i0() {
        c cVar;
        if (super.i0() == 0) {
            return 0L;
        }
        Object obj = f17143f.get(this);
        if (obj != null) {
            if (!(obj instanceof sg.q)) {
                return obj == m1.f17159b ? Long.MAX_VALUE : 0L;
            }
            if (!((sg.q) obj).j()) {
                return 0L;
            }
        }
        d dVar = (d) f17144g.get(this);
        if (dVar == null || (cVar = (c) dVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j10 = cVar.f17149a;
        ng.c.a();
        return vd.l.c(j10 - System.nanoTime(), 0L);
    }

    @Override // ng.i1
    public long n0() {
        if (o0()) {
            return 0L;
        }
        x0();
        Runnable runnableV0 = v0();
        if (runnableV0 == null) {
            return i0();
        }
        runnableV0.run();
        return 0L;
    }

    @Override // ng.i1
    public void shutdown() {
        v2.f17190a.c();
        I0(true);
        u0();
        while (n0() <= 0) {
        }
        D0();
    }

    public final void u0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17143f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (y.b.a(f17143f, this, null, m1.f17159b)) {
                    return;
                }
            } else if (obj instanceof sg.q) {
                ((sg.q) obj).d();
                return;
            } else {
                if (obj == m1.f17159b) {
                    return;
                }
                sg.q qVar = new sg.q(8, true);
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type java.lang.Runnable");
                qVar.a((Runnable) obj);
                if (y.b.a(f17143f, this, obj, qVar)) {
                    return;
                }
            }
        }
    }

    public final Runnable v0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17143f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof sg.q) {
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                sg.q qVar = (sg.q) obj;
                Object objM = qVar.m();
                if (objM != sg.q.f20423h) {
                    return (Runnable) objM;
                }
                y.b.a(f17143f, this, obj, qVar.l());
            } else {
                if (obj == m1.f17159b) {
                    return null;
                }
                if (y.b.a(f17143f, this, obj, null)) {
                    kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type java.lang.Runnable");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void w0(Runnable runnable) {
        x0();
        if (y0(runnable)) {
            s0();
        } else {
            s0.f17181i.w0(runnable);
        }
    }

    public final void x0() {
        sg.n0 n0VarI;
        d dVar = (d) f17144g.get(this);
        if (dVar == null || dVar.e()) {
            return;
        }
        ng.c.a();
        long jNanoTime = System.nanoTime();
        do {
            synchronized (dVar) {
                try {
                    sg.n0 n0VarB = dVar.b();
                    if (n0VarB != null) {
                        c cVar = (c) n0VarB;
                        n0VarI = cVar.k(jNanoTime) ? y0(cVar) : false ? dVar.i(0) : null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (((c) n0VarI) != null);
    }

    public final boolean y0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17143f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (isCompleted()) {
                return false;
            }
            if (obj == null) {
                if (y.b.a(f17143f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof sg.q) {
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                sg.q qVar = (sg.q) obj;
                int iA = qVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    y.b.a(f17143f, this, obj, qVar.l());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == m1.f17159b) {
                    return false;
                }
                sg.q qVar2 = new sg.q(8, true);
                kotlin.jvm.internal.t.d(obj, "null cannot be cast to non-null type java.lang.Runnable");
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (y.b.a(f17143f, this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }
}
