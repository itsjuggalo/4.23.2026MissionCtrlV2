package A3;

import W2.E;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import m3.AbstractC1608c;
import o3.AbstractC1681l;
import t3.AbstractC1806c;
import t3.P;
import y3.A;
import y3.F;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0006a f54h = new C0006a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f55i = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f56j = AtomicLongFieldUpdater.newUpdater(a.class, "controlState");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AtomicIntegerFieldUpdater f57k = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final F f58l = new F("NOT_IN_STACK");
    private volatile int _isTerminated;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f59a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f60b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f61c;
    private volatile long controlState;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f62d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final A3.d f63e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final A3.d f64f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final A f65g;
    private volatile long parkedWorkersStack;

    /* JADX INFO: renamed from: A3.a$a, reason: collision with other inner class name */
    public static final class C0006a {
        public /* synthetic */ C0006a(AbstractC1585j abstractC1585j) {
            this();
        }

        public C0006a() {
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f66a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f66a = iArr;
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public a(int i4, int i5, long j4, String str) {
        this.f59a = i4;
        this.f60b = i5;
        this.f61c = j4;
        this.f62d = str;
        if (i4 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i4 + " should be at least 1").toString());
        }
        if (i5 < i4) {
            throw new IllegalArgumentException(("Max pool size " + i5 + " should be greater than or equals to core pool size " + i4).toString());
        }
        if (i5 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i5 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j4 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j4 + " must be positive").toString());
        }
        this.f63e = new A3.d();
        this.f64f = new A3.d();
        this.f65g = new A((i4 + 1) * 2);
        this.controlState = ((long) i4) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void J(a aVar, Runnable runnable, i iVar, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            iVar = l.f101g;
        }
        if ((i4 & 4) != 0) {
            z4 = false;
        }
        aVar.G(runnable, iVar, z4);
    }

    public static /* synthetic */ boolean j0(a aVar, long j4, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = f56j.get(aVar);
        }
        return aVar.i0(j4);
    }

    public final c A() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !r.b(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public final void G(Runnable runnable, i iVar, boolean z4) {
        AbstractC1806c.a();
        h hVarX = x(runnable, iVar);
        boolean z5 = false;
        boolean z6 = hVarX.f92b.b() == 1;
        long jAddAndGet = z6 ? f56j.addAndGet(this, 2097152L) : 0L;
        c cVarA = A();
        h hVarH0 = h0(cVarA, hVarX, z4);
        if (hVarH0 != null && !f(hVarH0)) {
            throw new RejectedExecutionException(this.f62d + " was terminated");
        }
        if (z4 && cVarA != null) {
            z5 = true;
        }
        if (z6) {
            f0(jAddAndGet, z5);
        } else {
            if (z5) {
                return;
            }
            g0();
        }
    }

    public final int K(c cVar) {
        Object objI = cVar.i();
        while (objI != f58l) {
            if (objI == null) {
                return 0;
            }
            c cVar2 = (c) objI;
            int iH = cVar2.h();
            if (iH != 0) {
                return iH;
            }
            objI = cVar2.i();
        }
        return -1;
    }

    public final c P() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f55i;
        while (true) {
            long j4 = atomicLongFieldUpdater.get(this);
            c cVar = (c) this.f65g.b((int) (2097151 & j4));
            if (cVar == null) {
                return null;
            }
            long j5 = (2097152 + j4) & (-2097152);
            int iK = K(cVar);
            if (iK >= 0 && f55i.compareAndSet(this, j4, ((long) iK) | j5)) {
                cVar.r(f58l);
                return cVar;
            }
        }
    }

    public final boolean S(c cVar) {
        long j4;
        int iH;
        if (cVar.i() != f58l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f55i;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            iH = cVar.h();
            cVar.r(this.f65g.b((int) (2097151 & j4)));
        } while (!f55i.compareAndSet(this, j4, ((2097152 + j4) & (-2097152)) | ((long) iH)));
        return true;
    }

    public final void a0(c cVar, int i4, int i5) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f55i;
        while (true) {
            long j4 = atomicLongFieldUpdater.get(this);
            int iK = (int) (2097151 & j4);
            long j5 = (2097152 + j4) & (-2097152);
            if (iK == i4) {
                iK = i5 == 0 ? K(cVar) : i5;
            }
            if (iK >= 0) {
                if (f55i.compareAndSet(this, j4, j5 | ((long) iK))) {
                    return;
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        e0(10000L);
    }

    public final void d0(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            } finally {
                AbstractC1806c.a();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e0(long r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = A3.a.f57k
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            A3.a$c r0 = r7.A()
            y3.A r1 = r7.f65g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = e()     // Catch: java.lang.Throwable -> L87
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L87
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r3 = (int) r3
            monitor-exit(r1)
            if (r2 > r3) goto L49
            r1 = r2
        L23:
            y3.A r4 = r7.f65g
            java.lang.Object r4 = r4.b(r1)
            kotlin.jvm.internal.r.c(r4)
            A3.a$c r4 = (A3.a.c) r4
            if (r4 == r0) goto L44
        L30:
            boolean r5 = r4.isAlive()
            if (r5 == 0) goto L3d
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r8)
            goto L30
        L3d:
            A3.n r4 = r4.f68a
            A3.d r5 = r7.f64f
            r4.f(r5)
        L44:
            if (r1 == r3) goto L49
            int r1 = r1 + 1
            goto L23
        L49:
            A3.d r8 = r7.f64f
            r8.b()
            A3.d r8 = r7.f63e
            r8.b()
        L53:
            if (r0 == 0) goto L5b
            A3.h r8 = r0.g(r2)
            if (r8 != 0) goto L83
        L5b:
            A3.d r8 = r7.f63e
            java.lang.Object r8 = r8.d()
            A3.h r8 = (A3.h) r8
            if (r8 != 0) goto L83
            A3.d r8 = r7.f64f
            java.lang.Object r8 = r8.d()
            A3.h r8 = (A3.h) r8
            if (r8 != 0) goto L83
            if (r0 == 0) goto L76
            A3.a$d r8 = A3.a.d.TERMINATED
            r0.u(r8)
        L76:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = A3.a.f55i
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = A3.a.f56j
            r8.set(r7, r0)
            return
        L83:
            r7.d0(r8)
            goto L53
        L87:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: A3.a.e0(long):void");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        J(this, runnable, null, false, 6, null);
    }

    public final boolean f(h hVar) {
        return hVar.f92b.b() == 1 ? this.f64f.a(hVar) : this.f63e.a(hVar);
    }

    public final void f0(long j4, boolean z4) {
        if (z4 || k0() || i0(j4)) {
            return;
        }
        k0();
    }

    public final void g0() {
        if (k0() || j0(this, 0L, 1, null)) {
            return;
        }
        k0();
    }

    public final h h0(c cVar, h hVar, boolean z4) {
        if (cVar == null || cVar.f70c == d.TERMINATED) {
            return hVar;
        }
        if (hVar.f92b.b() == 0 && cVar.f70c == d.BLOCKING) {
            return hVar;
        }
        cVar.f74g = true;
        return cVar.f68a.a(hVar, z4);
    }

    public final boolean i0(long j4) {
        if (AbstractC1681l.b(((int) (2097151 & j4)) - ((int) ((j4 & 4398044413952L) >> 21)), 0) < this.f59a) {
            int iP = p();
            if (iP == 1 && this.f59a > 1) {
                p();
            }
            if (iP > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isTerminated() {
        return f57k.get(this) != 0;
    }

    public final boolean k0() {
        c cVarP;
        do {
            cVarP = P();
            if (cVarP == null) {
                return false;
            }
        } while (!c.j().compareAndSet(cVarP, -1, 0));
        LockSupport.unpark(cVarP);
        return true;
    }

    public final int p() {
        synchronized (this.f65g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f56j;
                long j4 = atomicLongFieldUpdater.get(this);
                int i4 = (int) (j4 & 2097151);
                int iB = AbstractC1681l.b(i4 - ((int) ((j4 & 4398044413952L) >> 21)), 0);
                if (iB >= this.f59a) {
                    return 0;
                }
                if (i4 >= this.f60b) {
                    return 0;
                }
                int i5 = ((int) (f56j.get(this) & 2097151)) + 1;
                if (i5 <= 0 || this.f65g.b(i5) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i5);
                this.f65g.c(i5, cVar);
                if (i5 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i6 = iB + 1;
                cVar.start();
                return i6;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f65g.a();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 1; i9 < iA; i9++) {
            c cVar = (c) this.f65g.b(i9);
            if (cVar != null) {
                int iE = cVar.f68a.e();
                int i10 = b.f66a[cVar.f70c.ordinal()];
                if (i10 == 1) {
                    i6++;
                } else if (i10 == 2) {
                    i5++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(iE);
                    sb.append('b');
                    arrayList.add(sb.toString());
                } else if (i10 == 3) {
                    i4++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(iE);
                    sb2.append('c');
                    arrayList.add(sb2.toString());
                } else if (i10 == 4) {
                    i7++;
                    if (iE > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(iE);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (i10 == 5) {
                    i8++;
                }
            }
        }
        long j4 = f56j.get(this);
        return this.f62d + '@' + P.b(this) + "[Pool Size {core = " + this.f59a + ", max = " + this.f60b + "}, Worker States {CPU = " + i4 + ", blocking = " + i5 + ", parked = " + i6 + ", dormant = " + i7 + ", terminated = " + i8 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f63e.c() + ", global blocking queue size = " + this.f64f.c() + ", Control State {created workers= " + ((int) (2097151 & j4)) + ", blocking tasks = " + ((int) ((4398044413952L & j4) >> 21)) + ", CPUs acquired = " + (this.f59a - ((int) ((9223367638808264704L & j4) >> 42))) + "}]";
    }

    public final h x(Runnable runnable, i iVar) {
        long jA = l.f100f.a();
        if (!(runnable instanceof h)) {
            return new k(runnable, jA, iVar);
        }
        h hVar = (h) runnable;
        hVar.f91a = jA;
        hVar.f92b = iVar;
        return hVar;
    }

    public final class c extends Thread {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final AtomicIntegerFieldUpdater f67i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f68a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final kotlin.jvm.internal.F f69b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f70c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f71d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f72e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f73f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f74g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile int workerCtl;

        public c() {
            setDaemon(true);
            this.f68a = new n();
            this.f69b = new kotlin.jvm.internal.F();
            this.f70c = d.DORMANT;
            this.nextParkedWorker = a.f58l;
            this.f73f = AbstractC1608c.f13542a.c();
        }

        public static final AtomicIntegerFieldUpdater j() {
            return f67i;
        }

        public final void b(int i4) {
            if (i4 == 0) {
                return;
            }
            a.f56j.addAndGet(a.this, -2097152L);
            if (this.f70c != d.TERMINATED) {
                this.f70c = d.DORMANT;
            }
        }

        public final void c(int i4) {
            if (i4 != 0 && u(d.BLOCKING)) {
                a.this.g0();
            }
        }

        public final void d(h hVar) {
            int iB = hVar.f92b.b();
            k(iB);
            c(iB);
            a.this.d0(hVar);
            b(iB);
        }

        public final h e(boolean z4) {
            h hVarO;
            h hVarO2;
            if (z4) {
                boolean z5 = m(a.this.f59a * 2) == 0;
                if (z5 && (hVarO2 = o()) != null) {
                    return hVarO2;
                }
                h hVarG = this.f68a.g();
                if (hVarG != null) {
                    return hVarG;
                }
                if (!z5 && (hVarO = o()) != null) {
                    return hVarO;
                }
            } else {
                h hVarO3 = o();
                if (hVarO3 != null) {
                    return hVarO3;
                }
            }
            return v(3);
        }

        public final h f() {
            h hVarH = this.f68a.h();
            if (hVarH != null) {
                return hVarH;
            }
            h hVar = (h) a.this.f64f.d();
            return hVar == null ? v(1) : hVar;
        }

        public final h g(boolean z4) {
            return s() ? e(z4) : f();
        }

        public final int h() {
            return this.indexInArray;
        }

        public final Object i() {
            return this.nextParkedWorker;
        }

        public final void k(int i4) {
            this.f71d = 0L;
            if (this.f70c == d.PARKING) {
                this.f70c = d.BLOCKING;
            }
        }

        public final boolean l() {
            return this.nextParkedWorker != a.f58l;
        }

        public final int m(int i4) {
            int i5 = this.f73f;
            int i6 = i5 ^ (i5 << 13);
            int i7 = i6 ^ (i6 >> 17);
            int i8 = i7 ^ (i7 << 5);
            this.f73f = i8;
            int i9 = i4 - 1;
            return (i9 & i4) == 0 ? i8 & i9 : (i8 & Integer.MAX_VALUE) % i4;
        }

        public final void n() {
            if (this.f71d == 0) {
                this.f71d = System.nanoTime() + a.this.f61c;
            }
            LockSupport.parkNanos(a.this.f61c);
            if (System.nanoTime() - this.f71d >= 0) {
                this.f71d = 0L;
                w();
            }
        }

        public final h o() {
            if (m(2) == 0) {
                h hVar = (h) a.this.f63e.d();
                return hVar != null ? hVar : (h) a.this.f64f.d();
            }
            h hVar2 = (h) a.this.f64f.d();
            return hVar2 != null ? hVar2 : (h) a.this.f63e.d();
        }

        public final void p() {
            loop0: while (true) {
                boolean z4 = false;
                while (!a.this.isTerminated() && this.f70c != d.TERMINATED) {
                    h hVarG = g(this.f74g);
                    if (hVarG != null) {
                        this.f72e = 0L;
                        d(hVarG);
                    } else {
                        this.f74g = false;
                        if (this.f72e == 0) {
                            t();
                        } else if (z4) {
                            u(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f72e);
                            this.f72e = 0L;
                        } else {
                            z4 = true;
                        }
                    }
                }
                break loop0;
            }
            u(d.TERMINATED);
        }

        public final void q(int i4) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f62d);
            sb.append("-worker-");
            sb.append(i4 == 0 ? "TERMINATED" : String.valueOf(i4));
            setName(sb.toString());
            this.indexInArray = i4;
        }

        public final void r(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            p();
        }

        public final boolean s() {
            long j4;
            if (this.f70c == d.CPU_ACQUIRED) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = a.f56j;
            do {
                j4 = atomicLongFieldUpdater.get(aVar);
                if (((int) ((9223367638808264704L & j4) >> 42)) == 0) {
                    return false;
                }
            } while (!a.f56j.compareAndSet(aVar, j4, j4 - 4398046511104L));
            this.f70c = d.CPU_ACQUIRED;
            return true;
        }

        public final void t() {
            if (!l()) {
                a.this.S(this);
                return;
            }
            f67i.set(this, -1);
            while (l() && f67i.get(this) == -1 && !a.this.isTerminated() && this.f70c != d.TERMINATED) {
                u(d.PARKING);
                Thread.interrupted();
                n();
            }
        }

        public final boolean u(d dVar) {
            d dVar2 = this.f70c;
            boolean z4 = dVar2 == d.CPU_ACQUIRED;
            if (z4) {
                a.f56j.addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f70c = dVar;
            }
            return z4;
        }

        public final h v(int i4) {
            int i5 = (int) (a.f56j.get(a.this) & 2097151);
            if (i5 < 2) {
                return null;
            }
            int iM = m(i5);
            a aVar = a.this;
            long jMin = Long.MAX_VALUE;
            for (int i6 = 0; i6 < i5; i6++) {
                iM++;
                if (iM > i5) {
                    iM = 1;
                }
                c cVar = (c) aVar.f65g.b(iM);
                if (cVar != null && cVar != this) {
                    long jN = cVar.f68a.n(i4, this.f69b);
                    if (jN == -1) {
                        kotlin.jvm.internal.F f4 = this.f69b;
                        h hVar = (h) f4.f13410a;
                        f4.f13410a = null;
                        return hVar;
                    }
                    if (jN > 0) {
                        jMin = Math.min(jMin, jN);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f72e = jMin;
            return null;
        }

        public final void w() {
            a aVar = a.this;
            synchronized (aVar.f65g) {
                try {
                    if (aVar.isTerminated()) {
                        return;
                    }
                    if (((int) (a.f56j.get(aVar) & 2097151)) <= aVar.f59a) {
                        return;
                    }
                    if (f67i.compareAndSet(this, -1, 1)) {
                        int i4 = this.indexInArray;
                        q(0);
                        aVar.a0(this, i4, 0);
                        int andDecrement = (int) (a.f56j.getAndDecrement(aVar) & 2097151);
                        if (andDecrement != i4) {
                            Object objB = aVar.f65g.b(andDecrement);
                            r.c(objB);
                            c cVar = (c) objB;
                            aVar.f65g.c(i4, cVar);
                            cVar.q(i4);
                            aVar.a0(cVar, andDecrement, i4);
                        }
                        aVar.f65g.c(andDecrement, null);
                        E e4 = E.f5463a;
                        this.f70c = d.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(a aVar, int i4) {
            this();
            q(i4);
        }
    }
}
