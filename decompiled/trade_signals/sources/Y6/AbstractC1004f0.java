package Y6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import s5.InterfaceC2711i;
import y.AbstractC2965b;

/* JADX INFO: renamed from: Y6.f0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC1004f0 extends AbstractC1006g0 implements V {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9664f = AtomicReferenceFieldUpdater.newUpdater(AbstractC1004f0.class, Object.class, "_queue$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f9665g = AtomicReferenceFieldUpdater.newUpdater(AbstractC1004f0.class, Object.class, "_delayed$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f9666h = AtomicIntegerFieldUpdater.newUpdater(AbstractC1004f0.class, "_isCompleted$volatile");
    private volatile /* synthetic */ Object _delayed$volatile;
    private volatile /* synthetic */ int _isCompleted$volatile = 0;
    private volatile /* synthetic */ Object _queue$volatile;

    /* JADX INFO: renamed from: Y6.f0$a */
    public final class a extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final InterfaceC1015l f9667c;

        public a(long j8, InterfaceC1015l interfaceC1015l) {
            super(j8);
            this.f9667c = interfaceC1015l;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f9667c.g(AbstractC1004f0.this, C2470H.f21956a);
        }

        @Override // Y6.AbstractC1004f0.b
        public String toString() {
            return super.toString() + this.f9667c;
        }
    }

    /* JADX INFO: renamed from: Y6.f0$b */
    public static abstract class b implements Runnable, Comparable, InterfaceC0996b0, d7.N {
        private volatile Object _heap;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f9669a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f9670b = -1;

        public b(long j8) {
            this.f9669a = j8;
        }

        @Override // d7.N
        public d7.M b() {
            Object obj = this._heap;
            if (obj instanceof d7.M) {
                return (d7.M) obj;
            }
            return null;
        }

        @Override // Y6.InterfaceC0996b0
        public final void dispose() {
            synchronized (this) {
                try {
                    Object obj = this._heap;
                    if (obj == AbstractC1010i0.f9672a) {
                        return;
                    }
                    c cVar = obj instanceof c ? (c) obj : null;
                    if (cVar != null) {
                        cVar.h(this);
                    }
                    this._heap = AbstractC1010i0.f9672a;
                    C2470H c2470h = C2470H.f21956a;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // d7.N
        public int g() {
            return this.f9670b;
        }

        @Override // d7.N
        public void i(int i8) {
            this.f9670b = i8;
        }

        @Override // d7.N
        public void k(d7.M m8) {
            if (this._heap == AbstractC1010i0.f9672a) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            this._heap = m8;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            long j8 = this.f9669a - bVar.f9669a;
            if (j8 > 0) {
                return 1;
            }
            return j8 < 0 ? -1 : 0;
        }

        /* JADX WARN: Removed duplicated region for block: B:31:0x0044 A[Catch: all -> 0x0026, TryCatch #0 {all -> 0x0026, blocks: (B:9:0x000d, B:19:0x0023, B:29:0x003b, B:31:0x0044, B:32:0x0046, B:22:0x0028, B:26:0x0032), top: B:41:0x000d, outer: #1 }] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final int m(long r8, Y6.AbstractC1004f0.c r10, Y6.AbstractC1004f0 r11) {
            /*
                r7 = this;
                monitor-enter(r7)
                java.lang.Object r0 = r7._heap     // Catch: java.lang.Throwable -> L1d
                d7.D r1 = Y6.AbstractC1010i0.b()     // Catch: java.lang.Throwable -> L1d
                if (r0 != r1) goto Lc
                monitor-exit(r7)
                r8 = 2
                return r8
            Lc:
                monitor-enter(r10)     // Catch: java.lang.Throwable -> L1d
                d7.N r0 = r10.b()     // Catch: java.lang.Throwable -> L26
                Y6.f0$b r0 = (Y6.AbstractC1004f0.b) r0     // Catch: java.lang.Throwable -> L26
                boolean r11 = Y6.AbstractC1004f0.O0(r11)     // Catch: java.lang.Throwable -> L26
                if (r11 == 0) goto L1f
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1d
                monitor-exit(r7)
                r8 = 1
                return r8
            L1d:
                r8 = move-exception
                goto L4f
            L1f:
                r1 = 0
                if (r0 != 0) goto L28
            L23:
                r10.f9671c = r8     // Catch: java.lang.Throwable -> L26
                goto L3b
            L26:
                r8 = move-exception
                goto L4d
            L28:
                long r3 = r0.f9669a     // Catch: java.lang.Throwable -> L26
                long r5 = r3 - r8
                int r11 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
                if (r11 < 0) goto L31
                goto L32
            L31:
                r8 = r3
            L32:
                long r3 = r10.f9671c     // Catch: java.lang.Throwable -> L26
                long r3 = r8 - r3
                int r11 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
                if (r11 <= 0) goto L3b
                goto L23
            L3b:
                long r8 = r7.f9669a     // Catch: java.lang.Throwable -> L26
                long r3 = r10.f9671c     // Catch: java.lang.Throwable -> L26
                long r8 = r8 - r3
                int r8 = (r8 > r1 ? 1 : (r8 == r1 ? 0 : -1))
                if (r8 >= 0) goto L46
                r7.f9669a = r3     // Catch: java.lang.Throwable -> L26
            L46:
                r10.a(r7)     // Catch: java.lang.Throwable -> L26
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1d
                monitor-exit(r7)
                r8 = 0
                return r8
            L4d:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> L1d
                throw r8     // Catch: java.lang.Throwable -> L1d
            L4f:
                monitor-exit(r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: Y6.AbstractC1004f0.b.m(long, Y6.f0$c, Y6.f0):int");
        }

        public final boolean n(long j8) {
            return j8 - this.f9669a >= 0;
        }

        public String toString() {
            return "Delayed[nanos=" + this.f9669a + ']';
        }
    }

    /* JADX INFO: renamed from: Y6.f0$c */
    public static final class c extends d7.M {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f9671c;

        public c(long j8) {
            this.f9671c = j8;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean i0() {
        return f9666h.get(this) != 0;
    }

    @Override // Y6.AbstractC1002e0
    public long D0() {
        b bVar;
        if (super.D0() == 0) {
            return 0L;
        }
        Object obj = f9664f.get(this);
        if (obj != null) {
            if (!(obj instanceof d7.q)) {
                return obj == AbstractC1010i0.f9673b ? Long.MAX_VALUE : 0L;
            }
            if (!((d7.q) obj).j()) {
                return 0L;
            }
        }
        c cVar = (c) f9665g.get(this);
        if (cVar == null || (bVar = (b) cVar.f()) == null) {
            return Long.MAX_VALUE;
        }
        long j8 = bVar.f9669a;
        AbstractC0997c.a();
        return H5.i.c(j8 - System.nanoTime(), 0L);
    }

    @Override // Y6.AbstractC1002e0
    public long I0() {
        if (J0()) {
            return 0L;
        }
        S0();
        Runnable runnableQ0 = Q0();
        if (runnableQ0 == null) {
            return D0();
        }
        runnableQ0.run();
        return 0L;
    }

    public final void P0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9664f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (AbstractC2965b.a(f9664f, this, null, AbstractC1010i0.f9673b)) {
                    return;
                }
            } else if (obj instanceof d7.q) {
                ((d7.q) obj).d();
                return;
            } else {
                if (obj == AbstractC1010i0.f9673b) {
                    return;
                }
                d7.q qVar = new d7.q(8, true);
                AbstractC2304t.d(obj, "null cannot be cast to non-null type java.lang.Runnable");
                qVar.a((Runnable) obj);
                if (AbstractC2965b.a(f9664f, this, obj, qVar)) {
                    return;
                }
            }
        }
    }

    public final Runnable Q0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9664f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof d7.q) {
                AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                d7.q qVar = (d7.q) obj;
                Object objM = qVar.m();
                if (objM != d7.q.f17070h) {
                    return (Runnable) objM;
                }
                AbstractC2965b.a(f9664f, this, obj, qVar.l());
            } else {
                if (obj == AbstractC1010i0.f9673b) {
                    return null;
                }
                if (AbstractC2965b.a(f9664f, this, obj, null)) {
                    AbstractC2304t.d(obj, "null cannot be cast to non-null type java.lang.Runnable");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void R0(Runnable runnable) {
        S0();
        if (T0(runnable)) {
            N0();
        } else {
            Q.f9641i.R0(runnable);
        }
    }

    public final void S0() {
        d7.N nI;
        c cVar = (c) f9665g.get(this);
        if (cVar == null || cVar.e()) {
            return;
        }
        AbstractC0997c.a();
        long jNanoTime = System.nanoTime();
        do {
            synchronized (cVar) {
                try {
                    d7.N nB = cVar.b();
                    nI = null;
                    if (nB != null) {
                        b bVar = (b) nB;
                        if (bVar.n(jNanoTime) ? T0(bVar) : false) {
                            nI = cVar.i(0);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } while (((b) nI) != null);
    }

    public final boolean T0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f9664f;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (i0()) {
                return false;
            }
            if (obj == null) {
                if (AbstractC2965b.a(f9664f, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof d7.q) {
                AbstractC2304t.d(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable>");
                d7.q qVar = (d7.q) obj;
                int iA = qVar.a(runnable);
                if (iA == 0) {
                    return true;
                }
                if (iA == 1) {
                    AbstractC2965b.a(f9664f, this, obj, qVar.l());
                } else if (iA == 2) {
                    return false;
                }
            } else {
                if (obj == AbstractC1010i0.f9673b) {
                    return false;
                }
                d7.q qVar2 = new d7.q(8, true);
                AbstractC2304t.d(obj, "null cannot be cast to non-null type java.lang.Runnable");
                qVar2.a((Runnable) obj);
                qVar2.a(runnable);
                if (AbstractC2965b.a(f9664f, this, obj, qVar2)) {
                    return true;
                }
            }
        }
    }

    @Override // Y6.V
    public void U(long j8, InterfaceC1015l interfaceC1015l) {
        long jC = AbstractC1010i0.c(j8);
        if (jC < 4611686018427387903L) {
            AbstractC0997c.a();
            long jNanoTime = System.nanoTime();
            a aVar = new a(jC + jNanoTime, interfaceC1015l);
            a1(jNanoTime, aVar);
            AbstractC1023p.a(interfaceC1015l, aVar);
        }
    }

    public boolean X0() {
        if (!H0()) {
            return false;
        }
        c cVar = (c) f9665g.get(this);
        if (cVar != null && !cVar.e()) {
            return false;
        }
        Object obj = f9664f.get(this);
        if (obj != null) {
            if (obj instanceof d7.q) {
                return ((d7.q) obj).j();
            }
            if (obj != AbstractC1010i0.f9673b) {
                return false;
            }
        }
        return true;
    }

    public final void Y0() {
        b bVar;
        AbstractC0997c.a();
        long jNanoTime = System.nanoTime();
        while (true) {
            c cVar = (c) f9665g.get(this);
            if (cVar == null || (bVar = (b) cVar.j()) == null) {
                return;
            } else {
                M0(jNanoTime, bVar);
            }
        }
    }

    public final void Z0() {
        f9664f.set(this, null);
        f9665g.set(this, null);
    }

    public final void a1(long j8, b bVar) {
        int iB1 = b1(j8, bVar);
        if (iB1 == 0) {
            if (d1(bVar)) {
                N0();
            }
        } else if (iB1 == 1) {
            M0(j8, bVar);
        } else if (iB1 != 2) {
            throw new IllegalStateException("unexpected result".toString());
        }
    }

    public final int b1(long j8, b bVar) {
        if (i0()) {
            return 1;
        }
        c cVar = (c) f9665g.get(this);
        if (cVar == null) {
            AbstractC2965b.a(f9665g, this, null, new c(j8));
            Object obj = f9665g.get(this);
            AbstractC2304t.c(obj);
            cVar = (c) obj;
        }
        return bVar.m(j8, cVar, this);
    }

    public final void c1(boolean z7) {
        f9666h.set(this, z7 ? 1 : 0);
    }

    public final boolean d1(b bVar) {
        c cVar = (c) f9665g.get(this);
        return (cVar != null ? (b) cVar.f() : null) == bVar;
    }

    @Override // Y6.AbstractC1002e0
    public void shutdown() {
        P0.f9639a.c();
        c1(true);
        P0();
        while (I0() <= 0) {
        }
        Y0();
    }

    @Override // Y6.I
    public final void v0(InterfaceC2711i interfaceC2711i, Runnable runnable) {
        R0(runnable);
    }
}
