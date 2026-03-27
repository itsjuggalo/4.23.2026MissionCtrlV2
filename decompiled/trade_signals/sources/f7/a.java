package f7;

import Y6.AbstractC0997c;
import Y6.P;
import d7.D;
import d7.y;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.N;
import o5.C2470H;
import o5.C2487o;
import v5.AbstractC2875b;
import v5.InterfaceC2874a;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0304a f17597h = new C0304a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f17598i = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack$volatile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f17599j = AtomicLongFieldUpdater.newUpdater(a.class, "controlState$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17600k = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final D f17601l = new D("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17602a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17603b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17604c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f17605d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final f7.d f17606e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f7.d f17607f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y f17608g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: renamed from: f7.a$a, reason: collision with other inner class name */
    public static final class C0304a {
        public C0304a() {
        }

        public /* synthetic */ C0304a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17609a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.f17621c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.f17620b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.f17619a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.f17622d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.f17623e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f17609a = iArr;
        }
    }

    public final class c extends Thread {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f17610i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f17611a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final N f17612b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f17613c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f17614d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f17615e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f17616f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f17617g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        public c() {
            setDaemon(true);
            setContextClassLoader(a.this.getClass().getClassLoader());
            this.f17611a = new l();
            this.f17612b = new N();
            this.f17613c = d.f17622d;
            this.nextParkedWorker = a.f17601l;
            int iNanoTime = (int) System.nanoTime();
            this.f17616f = iNanoTime == 0 ? 42 : iNanoTime;
        }

        public final void b(h hVar) {
            this.f17614d = 0L;
            if (this.f17613c == d.f17621c) {
                this.f17613c = d.f17620b;
            }
            if (!hVar.f17636b) {
                a.this.T(hVar);
                return;
            }
            if (r(d.f17620b)) {
                a.this.X();
            }
            a.this.T(hVar);
            a.E().addAndGet(a.this, -2097152L);
            if (this.f17613c != d.f17623e) {
                this.f17613c = d.f17622d;
            }
        }

        public final h c(boolean z7) {
            h hVarL;
            h hVarL2;
            if (z7) {
                boolean z8 = j(a.this.f17602a * 2) == 0;
                if (z8 && (hVarL2 = l()) != null) {
                    return hVarL2;
                }
                h hVarK = this.f17611a.k();
                if (hVarK != null) {
                    return hVarK;
                }
                if (!z8 && (hVarL = l()) != null) {
                    return hVarL;
                }
            } else {
                h hVarL3 = l();
                if (hVarL3 != null) {
                    return hVarL3;
                }
            }
            return s(3);
        }

        public final h d() {
            h hVarL = this.f17611a.l();
            if (hVarL != null) {
                return hVarL;
            }
            h hVar = (h) a.this.f17607f.e();
            return hVar == null ? s(1) : hVar;
        }

        public final h e(boolean z7) {
            return p() ? c(z7) : d();
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final boolean i() {
            return this.nextParkedWorker != a.f17601l;
        }

        public final int j(int i8) {
            int i9 = this.f17616f;
            int i10 = i9 ^ (i9 << 13);
            int i11 = i10 ^ (i10 >> 17);
            int i12 = i11 ^ (i11 << 5);
            this.f17616f = i12;
            int i13 = i8 - 1;
            return (i13 & i8) == 0 ? i12 & i13 : (i12 & Integer.MAX_VALUE) % i8;
        }

        public final void k() {
            if (this.f17614d == 0) {
                this.f17614d = System.nanoTime() + a.this.f17604c;
            }
            LockSupport.parkNanos(a.this.f17604c);
            if (System.nanoTime() - this.f17614d >= 0) {
                this.f17614d = 0L;
                t();
            }
        }

        public final h l() {
            f7.d dVar;
            if (j(2) == 0) {
                h hVar = (h) a.this.f17606e.e();
                if (hVar != null) {
                    return hVar;
                }
                dVar = a.this.f17607f;
            } else {
                h hVar2 = (h) a.this.f17607f.e();
                if (hVar2 != null) {
                    return hVar2;
                }
                dVar = a.this.f17606e;
            }
            return (h) dVar.e();
        }

        public final void m() {
            loop0: while (true) {
                boolean z7 = false;
                while (!a.this.isTerminated() && this.f17613c != d.f17623e) {
                    h hVarE = e(this.f17617g);
                    if (hVarE != null) {
                        this.f17615e = 0L;
                        b(hVarE);
                    } else {
                        this.f17617g = false;
                        if (this.f17615e == 0) {
                            q();
                        } else if (z7) {
                            r(d.f17621c);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f17615e);
                            this.f17615e = 0L;
                        } else {
                            z7 = true;
                        }
                    }
                }
                break loop0;
            }
            r(d.f17623e);
        }

        public final void n(int i8) {
            StringBuilder sb = new StringBuilder();
            sb.append(a.this.f17605d);
            sb.append("-worker-");
            sb.append(i8 == 0 ? "TERMINATED" : String.valueOf(i8));
            setName(sb.toString());
            this.indexInArray = i8;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean p() {
            long j8;
            if (this.f17613c == d.f17619a) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater atomicLongFieldUpdaterE = a.E();
            do {
                j8 = atomicLongFieldUpdaterE.get(aVar);
                if (((int) ((9223367638808264704L & j8) >> 42)) == 0) {
                    return false;
                }
            } while (!a.E().compareAndSet(aVar, j8, j8 - 4398046511104L));
            this.f17613c = d.f17619a;
            return true;
        }

        public final void q() {
            if (!i()) {
                a.this.Q(this);
                return;
            }
            f17610i.set(this, -1);
            while (i() && f17610i.get(this) == -1 && !a.this.isTerminated() && this.f17613c != d.f17623e) {
                r(d.f17621c);
                Thread.interrupted();
                k();
            }
        }

        public final boolean r(d dVar) {
            d dVar2 = this.f17613c;
            boolean z7 = dVar2 == d.f17619a;
            if (z7) {
                a.E().addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f17613c = dVar;
            }
            return z7;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }

        public final h s(int i8) {
            int i9 = (int) (a.E().get(a.this) & 2097151);
            if (i9 < 2) {
                return null;
            }
            int iJ = j(i9);
            a aVar = a.this;
            long jMin = Long.MAX_VALUE;
            for (int i10 = 0; i10 < i9; i10++) {
                iJ++;
                if (iJ > i9) {
                    iJ = 1;
                }
                c cVar = (c) aVar.f17608g.b(iJ);
                if (cVar != null && cVar != this) {
                    long jR = cVar.f17611a.r(i8, this.f17612b);
                    if (jR == -1) {
                        N n8 = this.f17612b;
                        h hVar = (h) n8.f20469a;
                        n8.f20469a = null;
                        return hVar;
                    }
                    if (jR > 0) {
                        jMin = Math.min(jMin, jR);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f17615e = jMin;
            return null;
        }

        public final void t() {
            a aVar = a.this;
            synchronized (aVar.f17608g) {
                try {
                    if (aVar.isTerminated()) {
                        return;
                    }
                    if (((int) (a.E().get(aVar) & 2097151)) <= aVar.f17602a) {
                        return;
                    }
                    if (f17610i.compareAndSet(this, -1, 1)) {
                        int i8 = this.indexInArray;
                        n(0);
                        aVar.R(this, i8, 0);
                        int andDecrement = (int) (a.E().getAndDecrement(aVar) & 2097151);
                        if (andDecrement != i8) {
                            Object objB = aVar.f17608g.b(andDecrement);
                            AbstractC2304t.c(objB);
                            c cVar = (c) objB;
                            aVar.f17608g.c(i8, cVar);
                            cVar.n(i8);
                            aVar.R(cVar, andDecrement, i8);
                        }
                        aVar.f17608g.c(andDecrement, null);
                        C2470H c2470h = C2470H.f21956a;
                        this.f17613c = d.f17623e;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(a aVar, int i8) {
            this();
            n(i8);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f17619a = new d("CPU_ACQUIRED", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f17620b = new d("BLOCKING", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f17621c = new d("PARKING", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f17622d = new d("DORMANT", 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f17623e = new d("TERMINATED", 4);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ d[] f17624f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ InterfaceC2874a f17625g;

        static {
            d[] dVarArrA = a();
            f17624f = dVarArrA;
            f17625g = AbstractC2875b.a(dVarArrA);
        }

        public d(String str, int i8) {
        }

        public static final /* synthetic */ d[] a() {
            return new d[]{f17619a, f17620b, f17621c, f17622d, f17623e};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f17624f.clone();
        }
    }

    public a(int i8, int i9, long j8, String str) {
        this.f17602a = i8;
        this.f17603b = i9;
        this.f17604c = j8;
        this.f17605d = str;
        if (i8 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i8 + " should be at least 1").toString());
        }
        if (i9 < i8) {
            throw new IllegalArgumentException(("Max pool size " + i9 + " should be greater than or equals to core pool size " + i8).toString());
        }
        if (i9 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i9 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j8 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j8 + " must be positive").toString());
        }
        this.f17606e = new f7.d();
        this.f17607f = new f7.d();
        this.f17608g = new y((i8 + 1) * 2);
        this.controlState$volatile = ((long) i8) << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void D(a aVar, Runnable runnable, boolean z7, boolean z8, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            z8 = false;
        }
        aVar.B(runnable, z7, z8);
    }

    public static final /* synthetic */ AtomicLongFieldUpdater E() {
        return f17599j;
    }

    public static /* synthetic */ boolean m0(a aVar, long j8, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j8 = f17599j.get(aVar);
        }
        return aVar.i0(j8);
    }

    public final void B(Runnable runnable, boolean z7, boolean z8) {
        AbstractC0997c.a();
        h hVarF = f(runnable, z7);
        boolean z9 = hVarF.f17636b;
        long jAddAndGet = z9 ? f17599j.addAndGet(this, 2097152L) : 0L;
        c cVarR = r();
        h hVarB0 = b0(cVarR, hVarF, z8);
        if (hVarB0 != null && !c(hVarB0)) {
            throw new RejectedExecutionException(this.f17605d + " was terminated");
        }
        boolean z10 = z8 && cVarR != null;
        if (z9) {
            W(jAddAndGet, z10);
        } else {
            if (z10) {
                return;
            }
            X();
        }
    }

    public final int N(c cVar) {
        int iF;
        do {
            Object objG = cVar.g();
            if (objG == f17601l) {
                return -1;
            }
            if (objG == null) {
                return 0;
            }
            cVar = (c) objG;
            iF = cVar.f();
        } while (iF == 0);
        return iF;
    }

    public final c O() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17598i;
        while (true) {
            long j8 = atomicLongFieldUpdater.get(this);
            c cVar = (c) this.f17608g.b((int) (2097151 & j8));
            if (cVar == null) {
                return null;
            }
            long j9 = (2097152 + j8) & (-2097152);
            int iN = N(cVar);
            if (iN >= 0 && f17598i.compareAndSet(this, j8, ((long) iN) | j9)) {
                cVar.o(f17601l);
                return cVar;
            }
        }
    }

    public final boolean Q(c cVar) {
        long j8;
        int iF;
        if (cVar.g() != f17601l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17598i;
        do {
            j8 = atomicLongFieldUpdater.get(this);
            iF = cVar.f();
            cVar.o(this.f17608g.b((int) (2097151 & j8)));
        } while (!f17598i.compareAndSet(this, j8, ((2097152 + j8) & (-2097152)) | ((long) iF)));
        return true;
    }

    public final void R(c cVar, int i8, int i9) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17598i;
        while (true) {
            long j8 = atomicLongFieldUpdater.get(this);
            int iN = (int) (2097151 & j8);
            long j9 = (2097152 + j8) & (-2097152);
            if (iN == i8) {
                iN = i9 == 0 ? N(cVar) : i9;
            }
            if (iN >= 0 && f17598i.compareAndSet(this, j8, j9 | ((long) iN))) {
                return;
            }
        }
    }

    public final void T(h hVar) {
        try {
            hVar.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void U(long r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = M()
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Ld
            return
        Ld:
            f7.a$c r0 = r7.r()
            d7.y r1 = r7.f17608g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = a()     // Catch: java.lang.Throwable -> L8f
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L8f
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r3 = (int) r3
            monitor-exit(r1)
            if (r2 > r3) goto L4d
            r1 = r2
        L25:
            d7.y r4 = r7.f17608g
            java.lang.Object r4 = r4.b(r1)
            kotlin.jvm.internal.AbstractC2304t.c(r4)
            f7.a$c r4 = (f7.a.c) r4
            if (r4 == r0) goto L48
        L32:
            java.lang.Thread$State r5 = r4.getState()
            java.lang.Thread$State r6 = java.lang.Thread.State.TERMINATED
            if (r5 == r6) goto L41
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r8)
            goto L32
        L41:
            f7.l r4 = r4.f17611a
            f7.d r5 = r7.f17607f
            r4.j(r5)
        L48:
            if (r1 == r3) goto L4d
            int r1 = r1 + 1
            goto L25
        L4d:
            f7.d r8 = r7.f17607f
            r8.b()
            f7.d r8 = r7.f17606e
            r8.b()
        L57:
            if (r0 == 0) goto L5f
            f7.h r8 = r0.e(r2)
            if (r8 != 0) goto L8b
        L5f:
            f7.d r8 = r7.f17606e
            java.lang.Object r8 = r8.e()
            f7.h r8 = (f7.h) r8
            if (r8 != 0) goto L8b
            f7.d r8 = r7.f17607f
            java.lang.Object r8 = r8.e()
            f7.h r8 = (f7.h) r8
            if (r8 != 0) goto L8b
            if (r0 == 0) goto L7a
            f7.a$d r8 = f7.a.d.f17623e
            r0.r(r8)
        L7a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = K()
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = E()
            r8.set(r7, r0)
            return
        L8b:
            r7.T(r8)
            goto L57
        L8f:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: f7.a.U(long):void");
    }

    public final void W(long j8, boolean z7) {
        if (z7 || r0() || i0(j8)) {
            return;
        }
        r0();
    }

    public final void X() {
        if (r0() || m0(this, 0L, 1, null)) {
            return;
        }
        r0();
    }

    public final h b0(c cVar, h hVar, boolean z7) {
        d dVar;
        if (cVar == null || (dVar = cVar.f17613c) == d.f17623e) {
            return hVar;
        }
        if (!hVar.f17636b && dVar == d.f17620b) {
            return hVar;
        }
        cVar.f17617g = true;
        return cVar.f17611a.a(hVar, z7);
    }

    public final boolean c(h hVar) {
        return (hVar.f17636b ? this.f17607f : this.f17606e).a(hVar);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        U(10000L);
    }

    public final int e() {
        synchronized (this.f17608g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j8 = f17599j.get(this);
                int i8 = (int) (j8 & 2097151);
                int iB = H5.i.b(i8 - ((int) ((j8 & 4398044413952L) >> 21)), 0);
                if (iB >= this.f17602a) {
                    return 0;
                }
                if (i8 >= this.f17603b) {
                    return 0;
                }
                int i9 = ((int) (E().get(this) & 2097151)) + 1;
                if (i9 <= 0 || this.f17608g.b(i9) != null) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                c cVar = new c(this, i9);
                this.f17608g.c(i9, cVar);
                if (i9 != ((int) (2097151 & f17599j.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                int i10 = iB + 1;
                cVar.start();
                return i10;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        D(this, runnable, false, false, 6, null);
    }

    public final h f(Runnable runnable, boolean z7) {
        long jA = j.f17643f.a();
        if (!(runnable instanceof h)) {
            return j.b(runnable, jA, z7);
        }
        h hVar = (h) runnable;
        hVar.f17635a = jA;
        hVar.f17636b = z7;
        return hVar;
    }

    public final boolean i0(long j8) {
        if (H5.i.b(((int) (2097151 & j8)) - ((int) ((j8 & 4398044413952L) >> 21)), 0) < this.f17602a) {
            int iE = e();
            if (iE == 1 && this.f17602a > 1) {
                e();
            }
            if (iE > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isTerminated() {
        return f17600k.get(this) != 0;
    }

    public final c r() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !AbstractC2304t.b(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public final boolean r0() {
        c cVarO;
        do {
            cVarO = O();
            if (cVarO == null) {
                return false;
            }
        } while (!c.f17610i.compareAndSet(cVarO, -1, 0));
        LockSupport.unpark(cVarO);
        return true;
    }

    public String toString() {
        StringBuilder sb;
        char c8;
        ArrayList arrayList = new ArrayList();
        int iA = this.f17608g.a();
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 1; i13 < iA; i13++) {
            c cVar = (c) this.f17608g.b(i13);
            if (cVar != null) {
                int i14 = cVar.f17611a.i();
                int i15 = b.f17609a[cVar.f17613c.ordinal()];
                if (i15 != 1) {
                    if (i15 == 2) {
                        i9++;
                        sb = new StringBuilder();
                        sb.append(i14);
                        c8 = 'b';
                    } else if (i15 == 3) {
                        i8++;
                        sb = new StringBuilder();
                        sb.append(i14);
                        c8 = 'c';
                    } else if (i15 == 4) {
                        i11++;
                        if (i14 > 0) {
                            sb = new StringBuilder();
                            sb.append(i14);
                            c8 = 'd';
                        }
                    } else {
                        if (i15 != 5) {
                            throw new C2487o();
                        }
                        i12++;
                    }
                    sb.append(c8);
                    arrayList.add(sb.toString());
                } else {
                    i10++;
                }
            }
        }
        long j8 = f17599j.get(this);
        return this.f17605d + '@' + P.b(this) + "[Pool Size {core = " + this.f17602a + ", max = " + this.f17603b + "}, Worker States {CPU = " + i8 + ", blocking = " + i9 + ", parked = " + i10 + ", dormant = " + i11 + ", terminated = " + i12 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f17606e.c() + ", global blocking queue size = " + this.f17607f.c() + ", Control State {created workers= " + ((int) (2097151 & j8)) + ", blocking tasks = " + ((int) ((4398044413952L & j8) >> 21)) + ", CPUs acquired = " + (this.f17602a - ((int) ((9223367638808264704L & j8) >> 42))) + "}]";
    }
}
