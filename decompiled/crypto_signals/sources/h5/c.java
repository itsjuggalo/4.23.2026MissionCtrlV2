package h5;

import a5.C;
import f5.p;
import f5.t;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.LockSupport;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class c implements Executor, Closeable {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f6673l = AtomicLongFieldUpdater.newUpdater(c.class, "parkedWorkersStack$volatile");

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f6674m = AtomicLongFieldUpdater.newUpdater(c.class, "controlState$volatile");

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f6675n = AtomicIntegerFieldUpdater.newUpdater(c.class, "_isTerminated$volatile");

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final t f6676o = new t("NOT_IN_STACK", 0);
    private volatile /* synthetic */ int _isTerminated$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6679c;
    private volatile /* synthetic */ long controlState$volatile;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f6680d;
    public final f e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final f f6681f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final p f6682k;
    private volatile /* synthetic */ long parkedWorkersStack$volatile;

    public c(int i, int i6, long j4, String str) {
        this.f6677a = i;
        this.f6678b = i6;
        this.f6679c = j4;
        this.f6680d = str;
        if (i < 1) {
            throw new IllegalArgumentException(a3.d.i("Core pool size ", i, " should be at least 1").toString());
        }
        if (i6 < i) {
            throw new IllegalArgumentException(a3.d.h("Max pool size ", i6, i, " should be greater than or equals to core pool size ").toString());
        }
        if (i6 > 2097150) {
            throw new IllegalArgumentException(a3.d.i("Max pool size ", i6, " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j4 <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j4 + " must be positive").toString());
        }
        this.e = new f();
        this.f6681f = new f();
        this.f6682k = new p((i + 1) * 2);
        this.controlState$volatile = ((long) i) << 42;
        this._isTerminated$volatile = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008a  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = h5.c.f6675n
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof h5.a
            r3 = 0
            if (r1 == 0) goto L17
            h5.a r0 = (h5.a) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            h5.c r1 = r0.f6667l
            boolean r1 = kotlin.jvm.internal.j.a(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            f5.p r1 = r8.f6682k
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = h5.c.f6674m     // Catch: java.lang.Throwable -> Lc3
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc3
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r4 = (int) r4
            monitor-exit(r1)
            if (r2 > r4) goto L78
            r1 = r2
        L36:
            f5.p r5 = r8.f6682k
            java.lang.Object r5 = r5.b(r1)
            kotlin.jvm.internal.j.b(r5)
            h5.a r5 = (h5.a) r5
            if (r5 == r0) goto L73
        L43:
            java.lang.Thread$State r6 = r5.getState()
            java.lang.Thread$State r7 = java.lang.Thread.State.TERMINATED
            if (r6 == r7) goto L54
            java.util.concurrent.locks.LockSupport.unpark(r5)
            r6 = 10000(0x2710, double:4.9407E-320)
            r5.join(r6)
            goto L43
        L54:
            h5.m r5 = r5.f6661a
            h5.f r6 = r8.f6681f
            r5.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = h5.m.f6697b
            java.lang.Object r7 = r7.getAndSet(r5, r3)
            h5.i r7 = (h5.i) r7
            if (r7 == 0) goto L68
            r6.a(r7)
        L68:
            h5.i r7 = r5.a()
            if (r7 != 0) goto L6f
            goto L73
        L6f:
            r6.a(r7)
            goto L68
        L73:
            if (r1 == r4) goto L78
            int r1 = r1 + 1
            goto L36
        L78:
            h5.f r1 = r8.f6681f
            r1.b()
            h5.f r1 = r8.e
            r1.b()
        L82:
            if (r0 == 0) goto L8a
            h5.i r1 = r0.a(r2)
            if (r1 != 0) goto Lb2
        L8a:
            h5.f r1 = r8.e
            java.lang.Object r1 = r1.d()
            h5.i r1 = (h5.i) r1
            if (r1 != 0) goto Lb2
            h5.f r1 = r8.f6681f
            java.lang.Object r1 = r1.d()
            h5.i r1 = (h5.i) r1
            if (r1 != 0) goto Lb2
            if (r0 == 0) goto La5
            h5.b r1 = h5.b.e
            r0.h(r1)
        La5:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = h5.c.f6673l
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = h5.c.f6674m
            r0.set(r8, r1)
            return
        Lb2:
            r1.run()     // Catch: java.lang.Throwable -> Lb6
            goto L82
        Lb6:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L82
        Lc3:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h5.c.close():void");
    }

    public final int d() {
        synchronized (this.f6682k) {
            try {
                if (f6675n.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f6674m;
                long j4 = atomicLongFieldUpdater.get(this);
                int i = (int) (j4 & 2097151);
                int i6 = i - ((int) ((j4 & 4398044413952L) >> 21));
                if (i6 < 0) {
                    i6 = 0;
                }
                if (i6 >= this.f6677a) {
                    return 0;
                }
                if (i >= this.f6678b) {
                    return 0;
                }
                int i7 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i7 <= 0 || this.f6682k.b(i7) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                a aVar = new a(this, i7);
                this.f6682k.c(i7, aVar);
                if (i7 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i8 = i6 + 1;
                aVar.start();
                return i8;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        f(runnable, false);
    }

    public final void f(Runnable runnable, boolean z6) {
        i jVar;
        b bVar;
        AtomicReferenceArray atomicReferenceArray;
        k.f6695f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof i) {
            jVar = (i) runnable;
            jVar.f6688a = jNanoTime;
            jVar.f6689b = z6;
        } else {
            jVar = new j(runnable, jNanoTime, z6);
        }
        boolean z7 = jVar.f6689b;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f6674m;
        long jAddAndGet = z7 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        a aVar = threadCurrentThread instanceof a ? (a) threadCurrentThread : null;
        if (aVar == null || !kotlin.jvm.internal.j.a(aVar.f6667l, this)) {
            aVar = null;
        }
        if (aVar != null && (bVar = aVar.f6663c) != b.e && (jVar.f6689b || bVar != b.f6669b)) {
            aVar.f6666k = true;
            m mVar = aVar.f6661a;
            mVar.getClass();
            jVar = (i) m.f6697b.getAndSet(mVar, jVar);
            if (jVar == null) {
                jVar = null;
            } else {
                mVar.getClass();
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = m.f6698c;
                if (atomicIntegerFieldUpdater.get(mVar) - m.f6699d.get(mVar) != 127) {
                    if (jVar.f6689b) {
                        m.e.incrementAndGet(mVar);
                    }
                    int i = atomicIntegerFieldUpdater.get(mVar) & 127;
                    while (true) {
                        atomicReferenceArray = mVar.f6700a;
                        if (atomicReferenceArray.get(i) == null) {
                            break;
                        } else {
                            Thread.yield();
                        }
                    }
                    atomicReferenceArray.lazySet(i, jVar);
                    atomicIntegerFieldUpdater.incrementAndGet(mVar);
                    jVar = null;
                }
            }
        }
        if (jVar != null) {
            if (!(jVar.f6689b ? this.f6681f.a(jVar) : this.e.a(jVar))) {
                throw new RejectedExecutionException(AbstractC1024h.d(new StringBuilder(), this.f6680d, " was terminated"));
            }
        }
        if (z7) {
            if (i() || h(jAddAndGet)) {
                return;
            }
            i();
            return;
        }
        if (i() || h(atomicLongFieldUpdater.get(this))) {
            return;
        }
        i();
    }

    public final void g(a aVar, int i, int i6) {
        while (true) {
            long j4 = f6673l.get(this);
            int i7 = (int) (2097151 & j4);
            long j6 = (2097152 + j4) & (-2097152);
            if (i7 == i) {
                if (i6 == 0) {
                    Object objC = aVar.c();
                    while (true) {
                        if (objC == f6676o) {
                            i7 = -1;
                            break;
                        }
                        if (objC == null) {
                            i7 = 0;
                            break;
                        }
                        a aVar2 = (a) objC;
                        int iB = aVar2.b();
                        if (iB != 0) {
                            i7 = iB;
                            break;
                        }
                        objC = aVar2.c();
                    }
                } else {
                    i7 = i6;
                }
            }
            if (i7 >= 0) {
                if (f6673l.compareAndSet(this, j4, ((long) i7) | j6)) {
                    return;
                }
            }
        }
    }

    public final boolean h(long j4) {
        int i = ((int) (2097151 & j4)) - ((int) ((j4 & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i6 = this.f6677a;
        if (i < i6) {
            int iD = d();
            if (iD == 1 && i6 > 1) {
                d();
            }
            if (iD > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean i() {
        t tVar;
        int iB;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f6673l;
            long j4 = atomicLongFieldUpdater.get(this);
            a aVar = (a) this.f6682k.b((int) (2097151 & j4));
            if (aVar == null) {
                aVar = null;
            } else {
                long j6 = (2097152 + j4) & (-2097152);
                Object objC = aVar.c();
                while (true) {
                    tVar = f6676o;
                    if (objC == tVar) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    a aVar2 = (a) objC;
                    iB = aVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = aVar2.c();
                }
                if (iB >= 0 && atomicLongFieldUpdater.compareAndSet(this, j4, j6 | ((long) iB))) {
                    aVar.g(tVar);
                }
            }
            if (aVar == null) {
                return false;
            }
            if (a.f6660m.compareAndSet(aVar, -1, 0)) {
                LockSupport.unpark(aVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        p pVar = this.f6682k;
        int iA = pVar.a();
        int i = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        for (int i10 = 1; i10 < iA; i10++) {
            a aVar = (a) pVar.b(i10);
            if (aVar != null) {
                m mVar = aVar.f6661a;
                mVar.getClass();
                int i11 = m.f6697b.get(mVar) != null ? (m.f6698c.get(mVar) - m.f6699d.get(mVar)) + 1 : m.f6698c.get(mVar) - m.f6699d.get(mVar);
                int iOrdinal = aVar.f6663c.ordinal();
                if (iOrdinal == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i11);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iOrdinal == 1) {
                    i6++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i11);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iOrdinal == 2) {
                    i7++;
                } else if (iOrdinal == 3) {
                    i8++;
                    if (i11 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i11);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else {
                    if (iOrdinal != 4) {
                        throw new G4.e();
                    }
                    i9++;
                }
            }
        }
        long j4 = f6674m.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.f6680d);
        sb4.append('@');
        sb4.append(C.j(this));
        sb4.append("[Pool Size {core = ");
        int i12 = this.f6677a;
        sb4.append(i12);
        sb4.append(", max = ");
        sb4.append(this.f6678b);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i6);
        sb4.append(", parked = ");
        sb4.append(i7);
        sb4.append(", dormant = ");
        sb4.append(i8);
        sb4.append(", terminated = ");
        sb4.append(i9);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.e.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.f6681f.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j4));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j4) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i12 - ((int) ((j4 & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
