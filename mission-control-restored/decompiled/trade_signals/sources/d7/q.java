package d7;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC2296k;
import y.AbstractC2965b;

/* JADX INFO: loaded from: classes2.dex */
public final class q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f17067e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f17068f = AtomicReferenceFieldUpdater.newUpdater(q.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f17069g = AtomicLongFieldUpdater.newUpdater(q.class, "_state$volatile");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final D f17070h = new D("REMOVE_FROZEN");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f17071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f17072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f17074d;

    public static final class a {
        public a() {
        }

        public final int a(long j8) {
            return (j8 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j8, int i8) {
            return d(j8, 1073741823L) | ((long) i8);
        }

        public final long c(long j8, int i8) {
            return d(j8, 1152921503533105152L) | (((long) i8) << 30);
        }

        public final long d(long j8, long j9) {
            return j8 & (~j9);
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f17075a;

        public b(int i8) {
            this.f17075a = i8;
        }
    }

    public q(int i8, boolean z7) {
        this.f17071a = i8;
        this.f17072b = z7;
        int i9 = i8 - 1;
        this.f17073c = i9;
        this.f17074d = new AtomicReferenceArray(i8);
        if (i9 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((i8 & i9) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0052, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = i()
        L4:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L18
            d7.q$a r13 = d7.q.f17067e
            int r13 = r13.a(r3)
            return r13
        L18:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.f17073c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L32
            return r6
        L32:
            boolean r2 = r12.f17072b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L53
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f()
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L53
            int r2 = r12.f17071a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L52
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L4
        L52:
            return r6
        L53:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = i()
            d7.q$a r5 = d7.q.f17067e
            long r5 = r5.c(r3, r1)
            r1 = r2
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L4
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f()
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L72:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = i()
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L8b
            d7.q r0 = r0.l()
            d7.q r0 = r0.e(r9, r13)
            if (r0 != 0) goto L72
        L8b:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.q.a(java.lang.Object):int");
    }

    public final q b(long j8) {
        q qVar = new q(this.f17071a * 2, this.f17072b);
        int i8 = (int) (1073741823 & j8);
        int i9 = (int) ((1152921503533105152L & j8) >> 30);
        while (true) {
            int i10 = this.f17073c;
            if ((i8 & i10) == (i10 & i9)) {
                f17069g.set(qVar, f17067e.d(j8, 1152921504606846976L));
                return qVar;
            }
            Object bVar = f().get(this.f17073c & i8);
            if (bVar == null) {
                bVar = new b(i8);
            }
            qVar.f().set(qVar.f17073c & i8, bVar);
            i8++;
        }
    }

    public final q c(long j8) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f17068f;
        while (true) {
            q qVar = (q) atomicReferenceFieldUpdater.get(this);
            if (qVar != null) {
                return qVar;
            }
            AbstractC2965b.a(f17068f, this, null, b(j8));
        }
    }

    public final boolean d() {
        long j8;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17069g;
        do {
            j8 = atomicLongFieldUpdater.get(this);
            if ((j8 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j8) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j8, j8 | 2305843009213693952L));
        return true;
    }

    public final q e(int i8, Object obj) {
        Object obj2 = f().get(this.f17073c & i8);
        if (!(obj2 instanceof b) || ((b) obj2).f17075a != i8) {
            return null;
        }
        f().set(i8 & this.f17073c, obj);
        return this;
    }

    public final /* synthetic */ AtomicReferenceArray f() {
        return this.f17074d;
    }

    public final int g() {
        long j8 = f17069g.get(this);
        return (((int) ((j8 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j8))) & 1073741823;
    }

    public final boolean j() {
        long j8 = f17069g.get(this);
        return ((int) (1073741823 & j8)) == ((int) ((j8 & 1152921503533105152L) >> 30));
    }

    public final long k() {
        long j8;
        long j9;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17069g;
        do {
            j8 = atomicLongFieldUpdater.get(this);
            if ((j8 & 1152921504606846976L) != 0) {
                return j8;
            }
            j9 = j8 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j8, j9));
        return j9;
    }

    public final q l() {
        return c(k());
    }

    public final Object m() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17069g;
        while (true) {
            long j8 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j8) != 0) {
                return f17070h;
            }
            int i8 = (int) (1073741823 & j8);
            int i9 = this.f17073c;
            if ((((int) ((1152921503533105152L & j8) >> 30)) & i9) == (i9 & i8)) {
                return null;
            }
            Object obj = f().get(this.f17073c & i8);
            if (obj == null) {
                if (this.f17072b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i10 = (i8 + 1) & 1073741823;
                if (f17069g.compareAndSet(this, j8, f17067e.b(j8, i10))) {
                    f().set(this.f17073c & i8, null);
                    return obj;
                }
                if (this.f17072b) {
                    q qVarN = this;
                    do {
                        qVarN = qVarN.n(i8, i10);
                    } while (qVarN != null);
                    return obj;
                }
            }
        }
    }

    public final q n(int i8, int i9) {
        long j8;
        int i10;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f17069g;
        do {
            j8 = atomicLongFieldUpdater.get(this);
            i10 = (int) (1073741823 & j8);
            if ((1152921504606846976L & j8) != 0) {
                return l();
            }
        } while (!f17069g.compareAndSet(this, j8, f17067e.b(j8, i9)));
        f().set(this.f17073c & i10, null);
        return null;
    }
}
