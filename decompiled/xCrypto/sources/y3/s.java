package y3;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f16005e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f16006f = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_next");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f16007g = AtomicLongFieldUpdater.newUpdater(s.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F f16008h = new F("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16009a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f16010b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f16011c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f16012d;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final int a(long j4) {
            return (j4 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j4, int i4) {
            return d(j4, 1073741823L) | ((long) i4);
        }

        public final long c(long j4, int i4) {
            return d(j4, 1152921503533105152L) | (((long) i4) << 30);
        }

        public final long d(long j4, long j5) {
            return j4 & (~j5);
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f16013a;

        public b(int i4) {
            this.f16013a = i4;
        }
    }

    public s(int i4, boolean z4) {
        this.f16009a = i4;
        this.f16010b = z4;
        int i5 = i4 - 1;
        this.f16011c = i5;
        this.f16012d = new AtomicReferenceArray(i4);
        if (i5 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i4 & i5) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int a(java.lang.Object r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = y3.s.f16007g
        L2:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L16
            y3.s$a r13 = y3.s.f16005e
            int r13 = r13.a(r3)
            return r13
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.f16011c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L30
            return r6
        L30:
            boolean r2 = r12.f16010b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f16012d
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L4f
            int r2 = r12.f16009a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L2
        L4e:
            return r6
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            r2 = r1
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = y3.s.f16007g
            y3.s$a r5 = y3.s.f16005e
            long r5 = r5.c(r3, r2)
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r2.f16012d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r2
        L6a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = y3.s.f16007g
            long r3 = r1.get(r0)
            r5 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r3 = r3 & r5
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 == 0) goto L81
            y3.s r0 = r0.i()
            y3.s r0 = r0.e(r9, r13)
            if (r0 != 0) goto L6a
        L81:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: y3.s.a(java.lang.Object):int");
    }

    public final s b(long j4) {
        s sVar = new s(this.f16009a * 2, this.f16010b);
        int i4 = (int) (1073741823 & j4);
        int i5 = (int) ((1152921503533105152L & j4) >> 30);
        while (true) {
            int i6 = this.f16011c;
            if ((i4 & i6) == (i5 & i6)) {
                f16007g.set(sVar, f16005e.d(j4, 1152921504606846976L));
                return sVar;
            }
            Object bVar = this.f16012d.get(i6 & i4);
            if (bVar == null) {
                bVar = new b(i4);
            }
            sVar.f16012d.set(sVar.f16011c & i4, bVar);
            i4++;
        }
    }

    public final s c(long j4) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f16006f;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            if (sVar != null) {
                return sVar;
            }
            androidx.concurrent.futures.b.a(f16006f, this, null, b(j4));
        }
    }

    public final boolean d() {
        long j4;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f16007g;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j4) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, 2305843009213693952L | j4));
        return true;
    }

    public final s e(int i4, Object obj) {
        Object obj2 = this.f16012d.get(this.f16011c & i4);
        if (!(obj2 instanceof b) || ((b) obj2).f16013a != i4) {
            return null;
        }
        this.f16012d.set(i4 & this.f16011c, obj);
        return this;
    }

    public final int f() {
        long j4 = f16007g.get(this);
        return (((int) ((j4 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j4))) & 1073741823;
    }

    public final boolean g() {
        long j4 = f16007g.get(this);
        return ((int) (1073741823 & j4)) == ((int) ((j4 & 1152921503533105152L) >> 30));
    }

    public final long h() {
        long j4;
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f16007g;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 1152921504606846976L) != 0) {
                return j4;
            }
            j5 = 1152921504606846976L | j4;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j4, j5));
        return j5;
    }

    public final s i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f16007g;
        while (true) {
            long j4 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j4) != 0) {
                return f16008h;
            }
            int i4 = (int) (1073741823 & j4);
            int i5 = this.f16011c;
            if ((((int) ((1152921503533105152L & j4) >> 30)) & i5) == (i4 & i5)) {
                return null;
            }
            Object obj = this.f16012d.get(i5 & i4);
            if (obj == null) {
                if (this.f16010b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i6 = (i4 + 1) & 1073741823;
                if (f16007g.compareAndSet(this, j4, f16005e.b(j4, i6))) {
                    this.f16012d.set(this.f16011c & i4, null);
                    return obj;
                }
                if (this.f16010b) {
                    s sVarK = this;
                    do {
                        sVarK = sVarK.k(i4, i6);
                    } while (sVarK != null);
                    return obj;
                }
            }
        }
    }

    public final s k(int i4, int i5) {
        long j4;
        int i6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f16007g;
        do {
            j4 = atomicLongFieldUpdater.get(this);
            i6 = (int) (1073741823 & j4);
            if ((1152921504606846976L & j4) != 0) {
                return i();
            }
        } while (!f16007g.compareAndSet(this, j4, f16005e.b(j4, i5)));
        this.f16012d.set(this.f16011c & i6, null);
        return null;
    }
}
