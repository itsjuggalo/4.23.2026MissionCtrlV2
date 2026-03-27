package com.google.protobuf;

import com.google.protobuf.m0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g0 f16397f = new g0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f16398a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f16399b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f16400c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f16401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f16402e;

    public g0() {
        this(0, new int[8], new Object[8], true);
    }

    public static g0 c() {
        return f16397f;
    }

    public static int f(int[] iArr, int i8) {
        int i9 = 17;
        for (int i10 = 0; i10 < i8; i10++) {
            i9 = (i9 * 31) + iArr[i10];
        }
        return i9;
    }

    public static int g(Object[] objArr, int i8) {
        int iHashCode = 17;
        for (int i9 = 0; i9 < i8; i9++) {
            iHashCode = (iHashCode * 31) + objArr[i9].hashCode();
        }
        return iHashCode;
    }

    public static g0 j(g0 g0Var, g0 g0Var2) {
        int i8 = g0Var.f16398a + g0Var2.f16398a;
        int[] iArrCopyOf = Arrays.copyOf(g0Var.f16399b, i8);
        System.arraycopy(g0Var2.f16399b, 0, iArrCopyOf, g0Var.f16398a, g0Var2.f16398a);
        Object[] objArrCopyOf = Arrays.copyOf(g0Var.f16400c, i8);
        System.arraycopy(g0Var2.f16400c, 0, objArrCopyOf, g0Var.f16398a, g0Var2.f16398a);
        return new g0(i8, iArrCopyOf, objArrCopyOf, true);
    }

    public static g0 k() {
        return new g0();
    }

    public static boolean l(Object[] objArr, Object[] objArr2, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (!objArr[i9].equals(objArr2[i9])) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(int[] iArr, int[] iArr2, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            if (iArr[i9] != iArr2[i9]) {
                return false;
            }
        }
        return true;
    }

    public static void q(int i8, Object obj, m0 m0Var) {
        int iA = l0.a(i8);
        int iB = l0.b(i8);
        if (iB == 0) {
            m0Var.n(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            m0Var.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            m0Var.N(iA, (AbstractC1467f) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(C1482v.e());
            }
            m0Var.d(iA, ((Integer) obj).intValue());
        } else if (m0Var.i() == m0.a.ASCENDING) {
            m0Var.q(iA);
            ((g0) obj).r(m0Var);
            m0Var.B(iA);
        } else {
            m0Var.B(iA);
            ((g0) obj).r(m0Var);
            m0Var.q(iA);
        }
    }

    public void a() {
        if (!this.f16402e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i8) {
        int[] iArr = this.f16399b;
        if (i8 > iArr.length) {
            int i9 = this.f16398a;
            int i10 = i9 + (i9 / 2);
            if (i10 >= i8) {
                i8 = i10;
            }
            if (i8 < 8) {
                i8 = 8;
            }
            this.f16399b = Arrays.copyOf(iArr, i8);
            this.f16400c = Arrays.copyOf(this.f16400c, i8);
        }
    }

    public int d() {
        int iS;
        int i8 = this.f16401d;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f16398a; i10++) {
            int i11 = this.f16399b[i10];
            int iA = l0.a(i11);
            int iB = l0.b(i11);
            if (iB == 0) {
                iS = AbstractC1470i.S(iA, ((Long) this.f16400c[i10]).longValue());
            } else if (iB == 1) {
                iS = AbstractC1470i.o(iA, ((Long) this.f16400c[i10]).longValue());
            } else if (iB == 2) {
                iS = AbstractC1470i.g(iA, (AbstractC1467f) this.f16400c[i10]);
            } else if (iB == 3) {
                iS = (AbstractC1470i.P(iA) * 2) + ((g0) this.f16400c[i10]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(C1482v.e());
                }
                iS = AbstractC1470i.m(iA, ((Integer) this.f16400c[i10]).intValue());
            }
            i9 += iS;
        }
        this.f16401d = i9;
        return i9;
    }

    public int e() {
        int i8 = this.f16401d;
        if (i8 != -1) {
            return i8;
        }
        int iE = 0;
        for (int i9 = 0; i9 < this.f16398a; i9++) {
            iE += AbstractC1470i.E(l0.a(this.f16399b[i9]), (AbstractC1467f) this.f16400c[i9]);
        }
        this.f16401d = iE;
        return iE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        int i8 = this.f16398a;
        return i8 == g0Var.f16398a && o(this.f16399b, g0Var.f16399b, i8) && l(this.f16400c, g0Var.f16400c, this.f16398a);
    }

    public void h() {
        if (this.f16402e) {
            this.f16402e = false;
        }
    }

    public int hashCode() {
        int i8 = this.f16398a;
        return ((((527 + i8) * 31) + f(this.f16399b, i8)) * 31) + g(this.f16400c, this.f16398a);
    }

    public g0 i(g0 g0Var) {
        if (g0Var.equals(c())) {
            return this;
        }
        a();
        int i8 = this.f16398a + g0Var.f16398a;
        b(i8);
        System.arraycopy(g0Var.f16399b, 0, this.f16399b, this.f16398a, g0Var.f16398a);
        System.arraycopy(g0Var.f16400c, 0, this.f16400c, this.f16398a, g0Var.f16398a);
        this.f16398a = i8;
        return this;
    }

    public final void m(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < this.f16398a; i9++) {
            L.d(sb, i8, String.valueOf(l0.a(this.f16399b[i9])), this.f16400c[i9]);
        }
    }

    public void n(int i8, Object obj) {
        a();
        b(this.f16398a + 1);
        int[] iArr = this.f16399b;
        int i9 = this.f16398a;
        iArr[i9] = i8;
        this.f16400c[i9] = obj;
        this.f16398a = i9 + 1;
    }

    public void p(m0 m0Var) {
        if (m0Var.i() == m0.a.DESCENDING) {
            for (int i8 = this.f16398a - 1; i8 >= 0; i8--) {
                m0Var.c(l0.a(this.f16399b[i8]), this.f16400c[i8]);
            }
            return;
        }
        for (int i9 = 0; i9 < this.f16398a; i9++) {
            m0Var.c(l0.a(this.f16399b[i9]), this.f16400c[i9]);
        }
    }

    public void r(m0 m0Var) {
        if (this.f16398a == 0) {
            return;
        }
        if (m0Var.i() == m0.a.ASCENDING) {
            for (int i8 = 0; i8 < this.f16398a; i8++) {
                q(this.f16399b[i8], this.f16400c[i8], m0Var);
            }
            return;
        }
        for (int i9 = this.f16398a - 1; i9 >= 0; i9--) {
            q(this.f16399b[i9], this.f16400c[i9], m0Var);
        }
    }

    public g0(int i8, int[] iArr, Object[] objArr, boolean z7) {
        this.f16401d = -1;
        this.f16398a = i8;
        this.f16399b = iArr;
        this.f16400c = objArr;
        this.f16402e = z7;
    }
}
