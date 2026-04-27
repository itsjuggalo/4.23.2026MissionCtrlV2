package d7;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public class M {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f17034b = AtomicIntegerFieldUpdater.newUpdater(M.class, "_size$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public N[] f17035a;

    public final void a(N n8) {
        n8.k(this);
        N[] nArrG = g();
        int iC = c();
        k(iC + 1);
        nArrG[iC] = n8;
        n8.i(iC);
        m(iC);
    }

    public final N b() {
        N[] nArr = this.f17035a;
        if (nArr != null) {
            return nArr[0];
        }
        return null;
    }

    public final int c() {
        return f17034b.get(this);
    }

    public final boolean e() {
        return c() == 0;
    }

    public final N f() {
        N nB;
        synchronized (this) {
            nB = b();
        }
        return nB;
    }

    public final N[] g() {
        N[] nArr = this.f17035a;
        if (nArr == null) {
            N[] nArr2 = new N[4];
            this.f17035a = nArr2;
            return nArr2;
        }
        if (c() < nArr.length) {
            return nArr;
        }
        Object[] objArrCopyOf = Arrays.copyOf(nArr, c() * 2);
        AbstractC2304t.e(objArrCopyOf, "copyOf(...)");
        N[] nArr3 = (N[]) objArrCopyOf;
        this.f17035a = nArr3;
        return nArr3;
    }

    public final boolean h(N n8) {
        boolean z7;
        synchronized (this) {
            if (n8.b() == null) {
                z7 = false;
            } else {
                i(n8.g());
                z7 = true;
            }
        }
        return z7;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x003a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final d7.N i(int r6) {
        /*
            r5 = this;
            d7.N[] r0 = r5.f17035a
            kotlin.jvm.internal.AbstractC2304t.c(r0)
            int r1 = r5.c()
            r2 = -1
            int r1 = r1 + r2
            r5.k(r1)
            int r1 = r5.c()
            if (r6 >= r1) goto L3d
            int r1 = r5.c()
            r5.n(r6, r1)
            int r1 = r6 + (-1)
            int r1 = r1 / 2
            if (r6 <= 0) goto L3a
            r3 = r0[r6]
            kotlin.jvm.internal.AbstractC2304t.c(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r0[r1]
            kotlin.jvm.internal.AbstractC2304t.c(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L3a
            r5.n(r6, r1)
            r5.m(r1)
            goto L3d
        L3a:
            r5.l(r6)
        L3d:
            int r6 = r5.c()
            r6 = r0[r6]
            kotlin.jvm.internal.AbstractC2304t.c(r6)
            r1 = 0
            r6.k(r1)
            r6.i(r2)
            int r2 = r5.c()
            r0[r2] = r1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.M.i(int):d7.N");
    }

    public final N j() {
        N nI;
        synchronized (this) {
            nI = c() > 0 ? i(0) : null;
        }
        return nI;
    }

    public final void k(int i8) {
        f17034b.set(this, i8);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r6) {
        /*
            r5 = this;
        L0:
            int r0 = r6 * 2
            int r1 = r0 + 1
            int r2 = r5.c()
            if (r1 < r2) goto Lb
            return
        Lb:
            d7.N[] r2 = r5.f17035a
            kotlin.jvm.internal.AbstractC2304t.c(r2)
            int r0 = r0 + 2
            int r3 = r5.c()
            if (r0 >= r3) goto L2b
            r3 = r2[r0]
            kotlin.jvm.internal.AbstractC2304t.c(r3)
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            r4 = r2[r1]
            kotlin.jvm.internal.AbstractC2304t.c(r4)
            int r3 = r3.compareTo(r4)
            if (r3 >= 0) goto L2b
            goto L2c
        L2b:
            r0 = r1
        L2c:
            r1 = r2[r6]
            kotlin.jvm.internal.AbstractC2304t.c(r1)
            java.lang.Comparable r1 = (java.lang.Comparable) r1
            r2 = r2[r0]
            kotlin.jvm.internal.AbstractC2304t.c(r2)
            int r1 = r1.compareTo(r2)
            if (r1 > 0) goto L3f
            return
        L3f:
            r5.n(r6, r0)
            r6 = r0
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: d7.M.l(int):void");
    }

    public final void m(int i8) {
        while (i8 > 0) {
            N[] nArr = this.f17035a;
            AbstractC2304t.c(nArr);
            int i9 = (i8 - 1) / 2;
            N n8 = nArr[i9];
            AbstractC2304t.c(n8);
            N n9 = nArr[i8];
            AbstractC2304t.c(n9);
            if (((Comparable) n8).compareTo(n9) <= 0) {
                return;
            }
            n(i8, i9);
            i8 = i9;
        }
    }

    public final void n(int i8, int i9) {
        N[] nArr = this.f17035a;
        AbstractC2304t.c(nArr);
        N n8 = nArr[i9];
        AbstractC2304t.c(n8);
        N n9 = nArr[i8];
        AbstractC2304t.c(n9);
        nArr[i8] = n8;
        nArr[i9] = n9;
        n8.i(i8);
        n9.i(i9);
    }
}
