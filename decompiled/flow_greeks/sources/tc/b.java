package tc;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import lc.h;
import xc.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b implements h {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f21883i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f21884j = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f21886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f21887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f21888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicReferenceArray f21889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f21890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicReferenceArray f21891g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f21885a = new AtomicLong();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f21892h = new AtomicLong();

    public b(int i10) {
        int iA = k.a(Math.max(8, i10));
        int i11 = iA - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iA + 1);
        this.f21889e = atomicReferenceArray;
        this.f21888d = i11;
        a(iA);
        this.f21891g = atomicReferenceArray;
        this.f21890f = i11;
        this.f21887c = iA - 2;
        p(0L);
    }

    public static int c(long j10, int i10) {
        return b(((int) j10) & i10);
    }

    public static Object g(AtomicReferenceArray atomicReferenceArray, int i10) {
        return atomicReferenceArray.get(i10);
    }

    private void m(long j10) {
        this.f21892h.lazySet(j10);
    }

    public static void n(AtomicReferenceArray atomicReferenceArray, int i10, Object obj) {
        atomicReferenceArray.lazySet(i10, obj);
    }

    private void p(long j10) {
        this.f21885a.lazySet(j10);
    }

    public final void a(int i10) {
        this.f21886b = Math.min(i10 / 4, f21883i);
    }

    @Override // lc.i
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.f21892h.get();
    }

    public final long e() {
        return this.f21885a.get();
    }

    public final long f() {
        return this.f21892h.get();
    }

    public final AtomicReferenceArray i(AtomicReferenceArray atomicReferenceArray, int i10) {
        int iB = b(i10);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, iB);
        n(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    @Override // lc.i
    public boolean isEmpty() {
        return j() == f();
    }

    public final long j() {
        return this.f21885a.get();
    }

    public final Object k(AtomicReferenceArray atomicReferenceArray, long j10, int i10) {
        this.f21891g = atomicReferenceArray;
        int iC = c(j10, i10);
        Object objG = g(atomicReferenceArray, iC);
        if (objG != null) {
            n(atomicReferenceArray, iC, null);
            m(j10 + 1);
        }
        return objG;
    }

    public final void l(AtomicReferenceArray atomicReferenceArray, long j10, int i10, Object obj, long j11) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f21889e = atomicReferenceArray2;
        this.f21887c = (j11 + j10) - 1;
        n(atomicReferenceArray2, i10, obj);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, i10, f21884j);
        p(j10 + 1);
    }

    public final void o(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        n(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    @Override // lc.i
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f21889e;
        long jE = e();
        int i10 = this.f21888d;
        int iC = c(jE, i10);
        if (jE < this.f21887c) {
            return q(atomicReferenceArray, obj, jE, iC);
        }
        long j10 = ((long) this.f21886b) + jE;
        if (g(atomicReferenceArray, c(j10, i10)) == null) {
            this.f21887c = j10 - 1;
            return q(atomicReferenceArray, obj, jE, iC);
        }
        if (g(atomicReferenceArray, c(jE + 1, i10)) == null) {
            return q(atomicReferenceArray, obj, jE, iC);
        }
        l(atomicReferenceArray, jE, iC, obj, i10);
        return true;
    }

    @Override // lc.h, lc.i
    public Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.f21891g;
        long jD = d();
        int i10 = this.f21890f;
        int iC = c(jD, i10);
        Object objG = g(atomicReferenceArray, iC);
        boolean z10 = objG == f21884j;
        if (objG == null || z10) {
            if (z10) {
                return k(i(atomicReferenceArray, i10 + 1), jD, i10);
            }
            return null;
        }
        n(atomicReferenceArray, iC, null);
        m(jD + 1);
        return objG;
    }

    public final boolean q(AtomicReferenceArray atomicReferenceArray, Object obj, long j10, int i10) {
        n(atomicReferenceArray, i10, obj);
        p(j10 + 1);
        return true;
    }

    public static int b(int i10) {
        return i10;
    }
}
