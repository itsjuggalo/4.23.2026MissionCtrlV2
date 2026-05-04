package ug;

import cd.h0;
import cd.o;
import com.google.android.gms.common.api.a;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import kotlin.jvm.internal.m0;
import kotlin.jvm.internal.t;
import ng.r0;
import sg.d0;
import sg.y;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a implements Executor, Closeable {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final C0395a f22987h = new C0395a(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f22988i = AtomicLongFieldUpdater.newUpdater(a.class, "parkedWorkersStack$volatile");

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f22989j = AtomicLongFieldUpdater.newUpdater(a.class, "controlState$volatile");

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f22990k = AtomicIntegerFieldUpdater.newUpdater(a.class, "_isTerminated$volatile");

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final d0 f22991l = new d0("NOT_IN_STACK");
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f22993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22994c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ug.d f22996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ug.d f22997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final y f22998g;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    /* JADX INFO: renamed from: ug.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0395a {
        public /* synthetic */ C0395a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public C0395a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f22999a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.f23011c.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.f23010b.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.f23009a.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.f23012d.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.f23013e.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f22999a = iArr;
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f23009a = new d("CPU_ACQUIRED", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f23010b = new d("BLOCKING", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f23011c = new d("PARKING", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f23012d = new d("DORMANT", 3);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f23013e = new d("TERMINATED", 4);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ d[] f23014f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ jd.a f23015g;

        static {
            d[] dVarArrA = a();
            f23014f = dVarArrA;
            f23015g = jd.b.a(dVarArrA);
        }

        public d(String str, int i10) {
        }

        public static final /* synthetic */ d[] a() {
            return new d[]{f23009a, f23010b, f23011c, f23012d, f23013e};
        }

        public static d valueOf(String str) {
            return (d) Enum.valueOf(d.class, str);
        }

        public static d[] values() {
            return (d[]) f23014f.clone();
        }
    }

    public a(int i10, int i11, long j10, String str) {
        this.f22992a = i10;
        this.f22993b = i11;
        this.f22994c = j10;
        this.f22995d = str;
        if (i10 < 1) {
            throw new IllegalArgumentException(("Core pool size " + i10 + " should be at least 1").toString());
        }
        if (i11 < i10) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should be greater than or equals to core pool size " + i10).toString());
        }
        if (i11 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i11 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j10 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j10 + " must be positive").toString());
        }
        this.f22996e = new ug.d();
        this.f22997f = new ug.d();
        this.f22998g = new y((i10 + 1) * 2);
        this.controlState$volatile = ((long) i10) << 42;
        this._isTerminated$volatile = 0;
    }

    public static /* synthetic */ void H(a aVar, Runnable runnable, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        if ((i10 & 4) != 0) {
            z11 = false;
        }
        aVar.E(runnable, z10, z11);
    }

    public static final /* synthetic */ AtomicLongFieldUpdater K() {
        return f22989j;
    }

    public static /* synthetic */ boolean i0(a aVar, long j10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = f22989j.get(aVar);
        }
        return aVar.h0(j10);
    }

    public final c C() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !t.b(a.this, this)) {
            return null;
        }
        return cVar;
    }

    public final void E(Runnable runnable, boolean z10, boolean z11) {
        ng.c.a();
        h hVarU = u(runnable, z10);
        boolean z12 = hVarU.f23026b;
        long jAddAndGet = z12 ? f22989j.addAndGet(this, 2097152L) : 0L;
        c cVarC = C();
        h hVarG0 = g0(cVarC, hVarU, z11);
        if (hVarG0 != null && !e(hVarG0)) {
            throw new RejectedExecutionException(this.f22995d + " was terminated");
        }
        boolean z13 = z11 && cVarC != null;
        if (z12) {
            e0(jAddAndGet, z13);
        } else {
            if (z13) {
                return;
            }
            f0();
        }
    }

    public final int R(c cVar) {
        Object objG = cVar.g();
        while (objG != f22991l) {
            if (objG == null) {
                return 0;
            }
            c cVar2 = (c) objG;
            int iF = cVar2.f();
            if (iF != 0) {
                return iF;
            }
            objG = cVar2.g();
        }
        return -1;
    }

    public final c Z() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f22988i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            c cVar = (c) this.f22998g.b((int) (2097151 & j10));
            if (cVar == null) {
                return null;
            }
            long j11 = (2097152 + j10) & (-2097152);
            int iR = R(cVar);
            if (iR >= 0 && f22988i.compareAndSet(this, j10, ((long) iR) | j11)) {
                cVar.o(f22991l);
                return cVar;
            }
        }
    }

    public final boolean a0(c cVar) {
        long j10;
        int iF;
        if (cVar.g() != f22991l) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f22988i;
        do {
            j10 = atomicLongFieldUpdater.get(this);
            iF = cVar.f();
            cVar.o(this.f22998g.b((int) (2097151 & j10)));
        } while (!f22988i.compareAndSet(this, j10, ((2097152 + j10) & (-2097152)) | ((long) iF)));
        return true;
    }

    public final void b0(c cVar, int i10, int i11) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f22988i;
        while (true) {
            long j10 = atomicLongFieldUpdater.get(this);
            int iR = (int) (2097151 & j10);
            long j11 = (2097152 + j10) & (-2097152);
            if (iR == i10) {
                iR = i11 == 0 ? R(cVar) : i11;
            }
            if (iR >= 0) {
                if (f22988i.compareAndSet(this, j10, j11 | ((long) iR))) {
                    return;
                }
            }
        }
    }

    public final void c0(h hVar) {
        try {
            hVar.run();
        } catch (Throwable th) {
            try {
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
            } finally {
                ng.c.a();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws InterruptedException {
        d0(10000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d0(long r8) throws java.lang.InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = O()
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Ld
            return
        Ld:
            ug.a$c r0 = r7.C()
            sg.y r1 = r7.f22998g
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = b()     // Catch: java.lang.Throwable -> L8f
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L8f
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r3 = (int) r3
            monitor-exit(r1)
            if (r2 > r3) goto L4d
            r1 = r2
        L25:
            sg.y r4 = r7.f22998g
            java.lang.Object r4 = r4.b(r1)
            kotlin.jvm.internal.t.c(r4)
            ug.a$c r4 = (ug.a.c) r4
            if (r4 == r0) goto L48
        L32:
            java.lang.Thread$State r5 = r4.getState()
            java.lang.Thread$State r6 = java.lang.Thread.State.TERMINATED
            if (r5 == r6) goto L41
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r8)
            goto L32
        L41:
            ug.l r4 = r4.f23001a
            ug.d r5 = r7.f22997f
            r4.j(r5)
        L48:
            if (r1 == r3) goto L4d
            int r1 = r1 + 1
            goto L25
        L4d:
            ug.d r8 = r7.f22997f
            r8.b()
            ug.d r8 = r7.f22996e
            r8.b()
        L57:
            if (r0 == 0) goto L5f
            ug.h r8 = r0.e(r2)
            if (r8 != 0) goto L8b
        L5f:
            ug.d r8 = r7.f22996e
            java.lang.Object r8 = r8.e()
            ug.h r8 = (ug.h) r8
            if (r8 != 0) goto L8b
            ug.d r8 = r7.f22997f
            java.lang.Object r8 = r8.e()
            ug.h r8 = (ug.h) r8
            if (r8 != 0) goto L8b
            if (r0 == 0) goto L7a
            ug.a$d r8 = ug.a.d.f23013e
            r0.r(r8)
        L7a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = N()
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = K()
            r8.set(r7, r0)
            return
        L8b:
            r7.c0(r8)
            goto L57
        L8f:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: ug.a.d0(long):void");
    }

    public final boolean e(h hVar) {
        return hVar.f23026b ? this.f22997f.a(hVar) : this.f22996e.a(hVar);
    }

    public final void e0(long j10, boolean z10) {
        if (z10 || j0() || h0(j10)) {
            return;
        }
        j0();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        H(this, runnable, false, false, 6, null);
    }

    public final void f0() {
        if (j0() || i0(this, 0L, 1, null)) {
            return;
        }
        j0();
    }

    public final h g0(c cVar, h hVar, boolean z10) {
        d dVar;
        if (cVar == null || (dVar = cVar.f23003c) == d.f23013e) {
            return hVar;
        }
        if (!hVar.f23026b && dVar == d.f23010b) {
            return hVar;
        }
        cVar.f23007g = true;
        return cVar.f23001a.a(hVar, z10);
    }

    public final boolean h0(long j10) {
        if (vd.l.b(((int) (2097151 & j10)) - ((int) ((j10 & 4398044413952L) >> 21)), 0) < this.f22992a) {
            int iO = o();
            if (iO == 1 && this.f22992a > 1) {
                o();
            }
            if (iO > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean isTerminated() {
        return f22990k.get(this) != 0;
    }

    public final boolean j0() {
        c cVarZ;
        do {
            cVarZ = Z();
            if (cVarZ == null) {
                return false;
            }
        } while (!c.f23000i.compareAndSet(cVarZ, -1, 0));
        LockSupport.unpark(cVarZ);
        return true;
    }

    public final int o() {
        synchronized (this.f22998g) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                long j10 = f22989j.get(this);
                int i10 = (int) (j10 & 2097151);
                int iB = vd.l.b(i10 - ((int) ((j10 & 4398044413952L) >> 21)), 0);
                if (iB >= this.f22992a) {
                    return 0;
                }
                if (i10 >= this.f22993b) {
                    return 0;
                }
                int i11 = ((int) (K().get(this) & 2097151)) + 1;
                if (i11 <= 0 || this.f22998g.b(i11) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                c cVar = new c(this, i11);
                this.f22998g.c(i11, cVar);
                if (i11 != ((int) (2097151 & f22989j.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i12 = iB + 1;
                cVar.start();
                return i12;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        int iA = this.f22998g.a();
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        for (int i15 = 1; i15 < iA; i15++) {
            c cVar = (c) this.f22998g.b(i15);
            if (cVar != null) {
                int i16 = cVar.f23001a.i();
                int i17 = b.f22999a[cVar.f23003c.ordinal()];
                if (i17 == 1) {
                    i12++;
                } else if (i17 == 2) {
                    i11++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i16);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (i17 == 3) {
                    i10++;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(i16);
                    sb3.append('c');
                    arrayList.add(sb3.toString());
                } else if (i17 == 4) {
                    i13++;
                    if (i16 > 0) {
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(i16);
                        sb4.append('d');
                        arrayList.add(sb4.toString());
                    }
                } else {
                    if (i17 != 5) {
                        throw new o();
                    }
                    i14++;
                }
            }
        }
        long j10 = f22989j.get(this);
        return this.f22995d + '@' + r0.b(this) + "[Pool Size {core = " + this.f22992a + ", max = " + this.f22993b + "}, Worker States {CPU = " + i10 + ", blocking = " + i11 + ", parked = " + i12 + ", dormant = " + i13 + ", terminated = " + i14 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f22996e.c() + ", global blocking queue size = " + this.f22997f.c() + ", Control State {created workers= " + ((int) (2097151 & j10)) + ", blocking tasks = " + ((int) ((4398044413952L & j10) >> 21)) + ", CPUs acquired = " + (this.f22992a - ((int) ((9223367638808264704L & j10) >> 42))) + "}]";
    }

    public final h u(Runnable runnable, boolean z10) {
        long jA = j.f23033f.a();
        if (!(runnable instanceof h)) {
            return j.b(runnable, jA, z10);
        }
        h hVar = (h) runnable;
        hVar.f23025a = jA;
        hVar.f23026b = z10;
        return hVar;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c extends Thread {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final /* synthetic */ AtomicIntegerFieldUpdater f23000i = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl$volatile");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f23001a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final m0 f23002b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public d f23003c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f23004d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f23005e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f23006f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f23007g;
        private volatile int indexInArray;
        private volatile Object nextParkedWorker;
        private volatile /* synthetic */ int workerCtl$volatile;

        public c() {
            setDaemon(true);
            setContextClassLoader(a.this.getClass().getClassLoader());
            this.f23001a = new l();
            this.f23002b = new m0();
            this.f23003c = d.f23012d;
            this.nextParkedWorker = a.f22991l;
            int iNanoTime = (int) System.nanoTime();
            this.f23006f = iNanoTime == 0 ? 42 : iNanoTime;
        }

        public final void b(h hVar) {
            this.f23004d = 0L;
            if (this.f23003c == d.f23011c) {
                this.f23003c = d.f23010b;
            }
            if (!hVar.f23026b) {
                a.this.c0(hVar);
                return;
            }
            if (r(d.f23010b)) {
                a.this.f0();
            }
            a.this.c0(hVar);
            a.K().addAndGet(a.this, -2097152L);
            if (this.f23003c != d.f23013e) {
                this.f23003c = d.f23012d;
            }
        }

        public final h c(boolean z10) {
            h hVarL;
            h hVarL2;
            if (z10) {
                boolean z11 = j(a.this.f22992a * 2) == 0;
                if (z11 && (hVarL2 = l()) != null) {
                    return hVarL2;
                }
                h hVarK = this.f23001a.k();
                if (hVarK != null) {
                    return hVarK;
                }
                if (!z11 && (hVarL = l()) != null) {
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
            h hVarL = this.f23001a.l();
            if (hVarL != null) {
                return hVarL;
            }
            h hVar = (h) a.this.f22997f.e();
            return hVar == null ? s(1) : hVar;
        }

        public final h e(boolean z10) {
            return p() ? c(z10) : d();
        }

        public final int f() {
            return this.indexInArray;
        }

        public final Object g() {
            return this.nextParkedWorker;
        }

        public final boolean i() {
            return this.nextParkedWorker != a.f22991l;
        }

        public final int j(int i10) {
            int i11 = this.f23006f;
            int i12 = i11 ^ (i11 << 13);
            int i13 = i12 ^ (i12 >> 17);
            int i14 = i13 ^ (i13 << 5);
            this.f23006f = i14;
            int i15 = i10 - 1;
            return (i15 & i10) == 0 ? i14 & i15 : (i14 & a.e.API_PRIORITY_OTHER) % i10;
        }

        public final void k() {
            if (this.f23004d == 0) {
                this.f23004d = System.nanoTime() + a.this.f22994c;
            }
            LockSupport.parkNanos(a.this.f22994c);
            if (System.nanoTime() - this.f23004d >= 0) {
                this.f23004d = 0L;
                t();
            }
        }

        public final h l() {
            if (j(2) == 0) {
                h hVar = (h) a.this.f22996e.e();
                return hVar != null ? hVar : (h) a.this.f22997f.e();
            }
            h hVar2 = (h) a.this.f22997f.e();
            return hVar2 != null ? hVar2 : (h) a.this.f22996e.e();
        }

        public final void m() {
            loop0: while (true) {
                boolean z10 = false;
                while (!a.this.isTerminated() && this.f23003c != d.f23013e) {
                    h hVarE = e(this.f23007g);
                    if (hVarE != null) {
                        this.f23005e = 0L;
                        b(hVarE);
                    } else {
                        this.f23007g = false;
                        if (this.f23005e == 0) {
                            q();
                        } else if (z10) {
                            r(d.f23011c);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f23005e);
                            this.f23005e = 0L;
                        } else {
                            z10 = true;
                        }
                    }
                }
                break loop0;
            }
            r(d.f23013e);
        }

        public final void n(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(a.this.f22995d);
            sb2.append("-worker-");
            sb2.append(i10 == 0 ? "TERMINATED" : String.valueOf(i10));
            setName(sb2.toString());
            this.indexInArray = i10;
        }

        public final void o(Object obj) {
            this.nextParkedWorker = obj;
        }

        public final boolean p() {
            long j10;
            if (this.f23003c == d.f23009a) {
                return true;
            }
            a aVar = a.this;
            AtomicLongFieldUpdater atomicLongFieldUpdaterK = a.K();
            do {
                j10 = atomicLongFieldUpdaterK.get(aVar);
                if (((int) ((9223367638808264704L & j10) >> 42)) == 0) {
                    return false;
                }
            } while (!a.K().compareAndSet(aVar, j10, j10 - 4398046511104L));
            this.f23003c = d.f23009a;
            return true;
        }

        public final void q() {
            if (!i()) {
                a.this.a0(this);
                return;
            }
            f23000i.set(this, -1);
            while (i() && f23000i.get(this) == -1 && !a.this.isTerminated() && this.f23003c != d.f23013e) {
                r(d.f23011c);
                Thread.interrupted();
                k();
            }
        }

        public final boolean r(d dVar) {
            d dVar2 = this.f23003c;
            boolean z10 = dVar2 == d.f23009a;
            if (z10) {
                a.K().addAndGet(a.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f23003c = dVar;
            }
            return z10;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            m();
        }

        public final h s(int i10) {
            int i11 = (int) (a.K().get(a.this) & 2097151);
            if (i11 < 2) {
                return null;
            }
            int iJ = j(i11);
            a aVar = a.this;
            long jMin = Long.MAX_VALUE;
            for (int i12 = 0; i12 < i11; i12++) {
                iJ++;
                if (iJ > i11) {
                    iJ = 1;
                }
                c cVar = (c) aVar.f22998g.b(iJ);
                if (cVar != null && cVar != this) {
                    long jR = cVar.f23001a.r(i10, this.f23002b);
                    if (jR == -1) {
                        m0 m0Var = this.f23002b;
                        h hVar = (h) m0Var.f14947a;
                        m0Var.f14947a = null;
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
            this.f23005e = jMin;
            return null;
        }

        public final void t() {
            a aVar = a.this;
            synchronized (aVar.f22998g) {
                try {
                    if (aVar.isTerminated()) {
                        return;
                    }
                    if (((int) (a.K().get(aVar) & 2097151)) <= aVar.f22992a) {
                        return;
                    }
                    if (f23000i.compareAndSet(this, -1, 1)) {
                        int i10 = this.indexInArray;
                        n(0);
                        aVar.b0(this, i10, 0);
                        int andDecrement = (int) (a.K().getAndDecrement(aVar) & 2097151);
                        if (andDecrement != i10) {
                            Object objB = aVar.f22998g.b(andDecrement);
                            t.c(objB);
                            c cVar = (c) objB;
                            aVar.f22998g.c(i10, cVar);
                            cVar.n(i10);
                            aVar.b0(cVar, andDecrement, i10);
                        }
                        aVar.f22998g.c(andDecrement, null);
                        h0 h0Var = h0.f3852a;
                        this.f23003c = d.f23013e;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(a aVar, int i10) {
            this();
            n(i10);
        }
    }
}
