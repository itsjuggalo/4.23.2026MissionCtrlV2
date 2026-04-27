package f5;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class m {
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(m.class, Object.class, "_next$volatile");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ AtomicLongFieldUpdater f6521f = AtomicLongFieldUpdater.newUpdater(m.class, "_state$volatile");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final t f6522g = new t("REMOVE_FROZEN", 0);
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f6523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f6524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6525c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f6526d;

    public m(int i, boolean z6) {
        this.f6523a = i;
        this.f6524b = z6;
        int i6 = i - 1;
        this.f6525c = i6;
        this.f6526d = new AtomicReferenceArray(i);
        if (i6 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i6) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f6521f;
            long j4 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j4) != 0) {
                return (2305843009213693952L & j4) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j4);
            int i6 = (int) ((1152921503533105152L & j4) >> 30);
            int i7 = this.f6525c;
            if (((i6 + 2) & i7) == (i & i7)) {
                return 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.f6526d;
            if (!this.f6524b && atomicReferenceArray.get(i6 & i7) != null) {
                int i8 = this.f6523a;
                if (i8 < 1024 || ((i6 - i) & 1073741823) > (i8 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j4, ((-1152921503533105153L) & j4) | (((long) ((i6 + 1) & 1073741823)) << 30))) {
                atomicReferenceArray.set(i6 & i7, runnable);
                m mVarC = this;
                while ((atomicLongFieldUpdater.get(mVarC) & 1152921504606846976L) != 0) {
                    mVarC = mVarC.c();
                    AtomicReferenceArray atomicReferenceArray2 = mVarC.f6526d;
                    int i9 = mVarC.f6525c & i6;
                    Object obj = atomicReferenceArray2.get(i9);
                    if ((obj instanceof l) && ((l) obj).f6520a == i6) {
                        atomicReferenceArray2.set(i9, runnable);
                    } else {
                        mVarC = null;
                    }
                    if (mVarC == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j4;
        do {
            atomicLongFieldUpdater = f6521f;
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

    public final m c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j4;
        m mVar;
        while (true) {
            atomicLongFieldUpdater = f6521f;
            j4 = atomicLongFieldUpdater.get(this);
            if ((j4 & 1152921504606846976L) != 0) {
                mVar = this;
                break;
            }
            long j6 = 1152921504606846976L | j4;
            mVar = this;
            if (atomicLongFieldUpdater.compareAndSet(mVar, j4, j6)) {
                j4 = j6;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            m mVar2 = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar2 != null) {
                return mVar2;
            }
            m mVar3 = new m(mVar.f6523a * 2, mVar.f6524b);
            int i = (int) (1073741823 & j4);
            int i6 = (int) ((1152921503533105152L & j4) >> 30);
            while (true) {
                int i7 = mVar.f6525c;
                int i8 = i & i7;
                if (i8 == (i7 & i6)) {
                    break;
                }
                Object lVar = mVar.f6526d.get(i8);
                if (lVar == null) {
                    lVar = new l(i);
                }
                mVar3.f6526d.set(mVar3.f6525c & i, lVar);
                i++;
            }
            atomicLongFieldUpdater.set(mVar3, (-1152921504606846977L) & j4);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, mVar3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d() {
        /*
            r30 = this;
            r1 = r30
        L2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f5.m.f6521f
            long r2 = r0.get(r1)
            r6 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r6
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 == 0) goto L15
            f5.t r0 = f5.m.f6522g
            return r0
        L15:
            r10 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r2 & r10
            int r4 = (int) r4
            r12 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r12 = r12 & r2
            r5 = 30
            long r12 = r12 >> r5
            int r5 = (int) r12
            int r12 = r1.f6525c
            r5 = r5 & r12
            r12 = r12 & r4
            r13 = 0
            if (r5 != r12) goto L2d
            goto L40
        L2d:
            java.util.concurrent.atomic.AtomicReferenceArray r14 = r1.f6526d
            java.lang.Object r15 = r14.get(r12)
            boolean r5 = r1.f6524b
            if (r15 != 0) goto L3a
            if (r5 == 0) goto L2
            goto L40
        L3a:
            r16 = r6
            boolean r6 = r15 instanceof f5.l
            if (r6 == 0) goto L41
        L40:
            return r13
        L41:
            int r4 = r4 + 1
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            r4 = r4 & r6
            r6 = -1073741824(0xffffffffc0000000, double:NaN)
            long r18 = r2 & r6
            r20 = r6
            long r6 = (long) r4
            long r18 = r18 | r6
            r28 = r18
            r18 = r5
            r4 = r28
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L61
            r14.set(r12, r13)
            return r15
        L61:
            r1 = r30
            if (r18 == 0) goto L2
        L65:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = f5.m.f6521f
            long r24 = r0.get(r1)
            long r2 = r24 & r10
            int r2 = (int) r2
            long r3 = r24 & r16
            int r3 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r3 == 0) goto L7a
            f5.m r0 = r1.c()
            r1 = r0
            goto L93
        L7a:
            long r3 = r24 & r20
            long r26 = r3 | r6
            r22 = r0
            r23 = r1
            boolean r0 = r22.compareAndSet(r23, r24, r26)
            r1 = r23
            if (r0 == 0) goto L65
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.f6526d
            int r1 = r1.f6525c
            r1 = r1 & r2
            r0.set(r1, r13)
            r1 = r13
        L93:
            if (r1 != 0) goto L65
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: f5.m.d():java.lang.Object");
    }
}
