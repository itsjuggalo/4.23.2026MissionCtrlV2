package g6;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.AbstractC2148j;
import v.AbstractC2759b;

/* JADX INFO: loaded from: classes2.dex */
public final class s {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f14319e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f14320f = AtomicReferenceFieldUpdater.newUpdater(s.class, Object.class, "_next");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AtomicLongFieldUpdater f14321g = AtomicLongFieldUpdater.newUpdater(s.class, "_state");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final F f14322h = new F("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f14324b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f14325c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReferenceArray f14326d;

    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final int a(long j7) {
            return (j7 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long b(long j7, int i7) {
            return d(j7, 1073741823L) | ((long) i7);
        }

        public final long c(long j7, int i7) {
            return d(j7, 1152921503533105152L) | (((long) i7) << 30);
        }

        public final long d(long j7, long j8) {
            return j7 & (~j8);
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f14327a;

        public b(int i7) {
            this.f14327a = i7;
        }
    }

    public s(int i7, boolean z7) {
        this.f14323a = i7;
        this.f14324b = z7;
        int i8 = i7 - 1;
        this.f14325c = i8;
        this.f14326d = new AtomicReferenceArray(i7);
        if (i8 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i7 & i8) != 0) {
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = g6.s.f14321g
        L2:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L16
            g6.s$a r13 = g6.s.f14319e
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
            int r10 = r12.f14325c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L30
            return r6
        L30:
            boolean r2 = r12.f14324b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f14326d
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L4f
            int r2 = r12.f14323a
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
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = g6.s.f14321g
            g6.s$a r5 = g6.s.f14319e
            long r5 = r5.c(r3, r1)
            r1 = r2
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f14326d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L6a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = g6.s.f14321g
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L81
            g6.s r0 = r0.i()
            g6.s r0 = r0.e(r9, r13)
            if (r0 != 0) goto L6a
        L81:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: g6.s.a(java.lang.Object):int");
    }

    public final s b(long j7) {
        s sVar = new s(this.f14323a * 2, this.f14324b);
        int i7 = (int) (1073741823 & j7);
        int i8 = (int) ((1152921503533105152L & j7) >> 30);
        while (true) {
            int i9 = this.f14325c;
            if ((i7 & i9) == (i8 & i9)) {
                f14321g.set(sVar, f14319e.d(j7, 1152921504606846976L));
                return sVar;
            }
            Object bVar = this.f14326d.get(i9 & i7);
            if (bVar == null) {
                bVar = new b(i7);
            }
            sVar.f14326d.set(sVar.f14325c & i7, bVar);
            i7++;
        }
    }

    public final s c(long j7) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f14320f;
        while (true) {
            s sVar = (s) atomicReferenceFieldUpdater.get(this);
            if (sVar != null) {
                return sVar;
            }
            AbstractC2759b.a(f14320f, this, null, b(j7));
        }
    }

    public final boolean d() {
        long j7;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14321g;
        do {
            j7 = atomicLongFieldUpdater.get(this);
            if ((j7 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j7) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j7, j7 | 2305843009213693952L));
        return true;
    }

    public final s e(int i7, Object obj) {
        Object obj2 = this.f14326d.get(this.f14325c & i7);
        if (!(obj2 instanceof b) || ((b) obj2).f14327a != i7) {
            return null;
        }
        this.f14326d.set(i7 & this.f14325c, obj);
        return this;
    }

    public final int f() {
        long j7 = f14321g.get(this);
        return (((int) ((j7 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j7))) & 1073741823;
    }

    public final boolean g() {
        long j7 = f14321g.get(this);
        return ((int) (1073741823 & j7)) == ((int) ((j7 & 1152921503533105152L) >> 30));
    }

    public final long h() {
        long j7;
        long j8;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14321g;
        do {
            j7 = atomicLongFieldUpdater.get(this);
            if ((j7 & 1152921504606846976L) != 0) {
                return j7;
            }
            j8 = j7 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j7, j8));
        return j8;
    }

    public final s i() {
        return c(h());
    }

    public final Object j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14321g;
        while (true) {
            long j7 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j7) != 0) {
                return f14322h;
            }
            int i7 = (int) (1073741823 & j7);
            int i8 = this.f14325c;
            if ((((int) ((1152921503533105152L & j7) >> 30)) & i8) == (i7 & i8)) {
                return null;
            }
            Object obj = this.f14326d.get(i8 & i7);
            if (obj == null) {
                if (this.f14324b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i9 = (i7 + 1) & 1073741823;
                if (f14321g.compareAndSet(this, j7, f14319e.b(j7, i9))) {
                    this.f14326d.set(this.f14325c & i7, null);
                    return obj;
                }
                if (this.f14324b) {
                    s sVarK = this;
                    do {
                        sVarK = sVarK.k(i7, i9);
                    } while (sVarK != null);
                    return obj;
                }
            }
        }
    }

    public final s k(int i7, int i8) {
        long j7;
        int i9;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f14321g;
        do {
            j7 = atomicLongFieldUpdater.get(this);
            i9 = (int) (1073741823 & j7);
            if ((1152921504606846976L & j7) != 0) {
                return i();
            }
        } while (!f14321g.compareAndSet(this, j7, f14319e.b(j7, i8)));
        this.f14326d.set(this.f14325c & i9, null);
        return null;
    }
}
