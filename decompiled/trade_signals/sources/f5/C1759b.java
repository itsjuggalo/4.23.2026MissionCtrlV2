package f5;

import Y4.i;
import j5.k;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: renamed from: f5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1759b implements i {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f17555i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f17556j = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f17558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f17559c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17560d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AtomicReferenceArray f17561e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17562f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public AtomicReferenceArray f17563g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicLong f17557a = new AtomicLong();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicLong f17564h = new AtomicLong();

    public C1759b(int i8) {
        int iA = k.a(Math.max(8, i8));
        int i9 = iA - 1;
        AtomicReferenceArray atomicReferenceArray = new AtomicReferenceArray(iA + 1);
        this.f17561e = atomicReferenceArray;
        this.f17560d = i9;
        a(iA);
        this.f17563g = atomicReferenceArray;
        this.f17562f = i9;
        this.f17559c = iA - 2;
        p(0L);
    }

    public static int c(long j8, int i8) {
        return b(((int) j8) & i8);
    }

    public static Object g(AtomicReferenceArray atomicReferenceArray, int i8) {
        return atomicReferenceArray.get(i8);
    }

    private void m(long j8) {
        this.f17564h.lazySet(j8);
    }

    public static void n(AtomicReferenceArray atomicReferenceArray, int i8, Object obj) {
        atomicReferenceArray.lazySet(i8, obj);
    }

    private void p(long j8) {
        this.f17557a.lazySet(j8);
    }

    public final void a(int i8) {
        this.f17558b = Math.min(i8 / 4, f17555i);
    }

    @Override // Y4.j
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final long d() {
        return this.f17564h.get();
    }

    public final long e() {
        return this.f17557a.get();
    }

    public final long f() {
        return this.f17564h.get();
    }

    public final AtomicReferenceArray h(AtomicReferenceArray atomicReferenceArray, int i8) {
        int iB = b(i8);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray) g(atomicReferenceArray, iB);
        n(atomicReferenceArray, iB, null);
        return atomicReferenceArray2;
    }

    public final long i() {
        return this.f17557a.get();
    }

    @Override // Y4.j
    public boolean isEmpty() {
        return i() == f();
    }

    public final Object j(AtomicReferenceArray atomicReferenceArray, long j8, int i8) {
        this.f17563g = atomicReferenceArray;
        int iC = c(j8, i8);
        Object objG = g(atomicReferenceArray, iC);
        if (objG != null) {
            n(atomicReferenceArray, iC, null);
            m(j8 + 1);
        }
        return objG;
    }

    public final void l(AtomicReferenceArray atomicReferenceArray, long j8, int i8, Object obj, long j9) {
        AtomicReferenceArray atomicReferenceArray2 = new AtomicReferenceArray(atomicReferenceArray.length());
        this.f17561e = atomicReferenceArray2;
        this.f17559c = (j9 + j8) - 1;
        n(atomicReferenceArray2, i8, obj);
        o(atomicReferenceArray, atomicReferenceArray2);
        n(atomicReferenceArray, i8, f17556j);
        p(j8 + 1);
    }

    public final void o(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        n(atomicReferenceArray, b(atomicReferenceArray.length() - 1), atomicReferenceArray2);
    }

    @Override // Y4.j
    public boolean offer(Object obj) {
        if (obj == null) {
            throw new NullPointerException("Null is not a valid element");
        }
        AtomicReferenceArray atomicReferenceArray = this.f17561e;
        long jE = e();
        int i8 = this.f17560d;
        int iC = c(jE, i8);
        if (jE < this.f17559c) {
            return q(atomicReferenceArray, obj, jE, iC);
        }
        long j8 = ((long) this.f17558b) + jE;
        if (g(atomicReferenceArray, c(j8, i8)) == null) {
            this.f17559c = j8 - 1;
            return q(atomicReferenceArray, obj, jE, iC);
        }
        if (g(atomicReferenceArray, c(1 + jE, i8)) == null) {
            return q(atomicReferenceArray, obj, jE, iC);
        }
        l(atomicReferenceArray, jE, iC, obj, i8);
        return true;
    }

    @Override // Y4.i, Y4.j
    public Object poll() {
        AtomicReferenceArray atomicReferenceArray = this.f17563g;
        long jD = d();
        int i8 = this.f17562f;
        int iC = c(jD, i8);
        Object objG = g(atomicReferenceArray, iC);
        boolean z7 = objG == f17556j;
        if (objG == null || z7) {
            if (z7) {
                return j(h(atomicReferenceArray, i8 + 1), jD, i8);
            }
            return null;
        }
        n(atomicReferenceArray, iC, null);
        m(jD + 1);
        return objG;
    }

    public final boolean q(AtomicReferenceArray atomicReferenceArray, Object obj, long j8, int i8) {
        n(atomicReferenceArray, i8, obj);
        p(j8 + 1);
        return true;
    }

    public static int b(int i8) {
        return i8;
    }
}
