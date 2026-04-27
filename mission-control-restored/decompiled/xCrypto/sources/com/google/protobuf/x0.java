package com.google.protobuf;

import com.google.protobuf.D;
import com.google.protobuf.D0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class x0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final x0 f11249f = new x0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11250a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f11251b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f11252c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11253d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11254e;

    public x0() {
        this(0, new int[8], new Object[8], true);
    }

    public static x0 c() {
        return f11249f;
    }

    public static int f(int[] iArr, int i4) {
        int i5 = 17;
        for (int i6 = 0; i6 < i4; i6++) {
            i5 = (i5 * 31) + iArr[i6];
        }
        return i5;
    }

    public static int g(Object[] objArr, int i4) {
        int iHashCode = 17;
        for (int i5 = 0; i5 < i4; i5++) {
            iHashCode = (iHashCode * 31) + objArr[i5].hashCode();
        }
        return iHashCode;
    }

    public static x0 n(x0 x0Var, x0 x0Var2) {
        int i4 = x0Var.f11250a + x0Var2.f11250a;
        int[] iArrCopyOf = Arrays.copyOf(x0Var.f11251b, i4);
        System.arraycopy(x0Var2.f11251b, 0, iArrCopyOf, x0Var.f11250a, x0Var2.f11250a);
        Object[] objArrCopyOf = Arrays.copyOf(x0Var.f11252c, i4);
        System.arraycopy(x0Var2.f11252c, 0, objArrCopyOf, x0Var.f11250a, x0Var2.f11250a);
        return new x0(i4, iArrCopyOf, objArrCopyOf, true);
    }

    public static x0 o() {
        return new x0();
    }

    public static boolean p(Object[] objArr, Object[] objArr2, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (!objArr[i5].equals(objArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    public static boolean s(int[] iArr, int[] iArr2, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (iArr[i5] != iArr2[i5]) {
                return false;
            }
        }
        return true;
    }

    public static void u(int i4, Object obj, D0 d02) {
        int iA = C0.a(i4);
        int iB = C0.b(i4);
        if (iB == 0) {
            d02.n(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            d02.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            d02.N(iA, (AbstractC1062i) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(D.e());
            }
            d02.d(iA, ((Integer) obj).intValue());
        } else if (d02.i() == D0.a.ASCENDING) {
            d02.q(iA);
            ((x0) obj).v(d02);
            d02.B(iA);
        } else {
            d02.B(iA);
            ((x0) obj).v(d02);
            d02.q(iA);
        }
    }

    public void a() {
        if (!this.f11254e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i4) {
        int[] iArr = this.f11251b;
        if (i4 > iArr.length) {
            int i5 = this.f11250a;
            int i6 = i5 + (i5 / 2);
            if (i6 >= i4) {
                i4 = i6;
            }
            if (i4 < 8) {
                i4 = 8;
            }
            this.f11251b = Arrays.copyOf(iArr, i4);
            this.f11252c = Arrays.copyOf(this.f11252c, i4);
        }
    }

    public int d() {
        int iV;
        int i4 = this.f11253d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f11250a; i6++) {
            int i7 = this.f11251b[i6];
            int iA = C0.a(i7);
            int iB = C0.b(i7);
            if (iB == 0) {
                iV = AbstractC1065l.V(iA, ((Long) this.f11252c[i6]).longValue());
            } else if (iB == 1) {
                iV = AbstractC1065l.p(iA, ((Long) this.f11252c[i6]).longValue());
            } else if (iB == 2) {
                iV = AbstractC1065l.h(iA, (AbstractC1062i) this.f11252c[i6]);
            } else if (iB == 3) {
                iV = (AbstractC1065l.S(iA) * 2) + ((x0) this.f11252c[i6]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(D.e());
                }
                iV = AbstractC1065l.n(iA, ((Integer) this.f11252c[i6]).intValue());
            }
            i5 += iV;
        }
        this.f11253d = i5;
        return i5;
    }

    public int e() {
        int i4 = this.f11253d;
        if (i4 != -1) {
            return i4;
        }
        int iH = 0;
        for (int i5 = 0; i5 < this.f11250a; i5++) {
            iH += AbstractC1065l.H(C0.a(this.f11251b[i5]), (AbstractC1062i) this.f11252c[i5]);
        }
        this.f11253d = iH;
        return iH;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        int i4 = this.f11250a;
        return i4 == x0Var.f11250a && s(this.f11251b, x0Var.f11251b, i4) && p(this.f11252c, x0Var.f11252c, this.f11250a);
    }

    public void h() {
        if (this.f11254e) {
            this.f11254e = false;
        }
    }

    public int hashCode() {
        int i4 = this.f11250a;
        return ((((527 + i4) * 31) + f(this.f11251b, i4)) * 31) + g(this.f11252c, this.f11250a);
    }

    public boolean i(int i4, AbstractC1063j abstractC1063j) throws D.a {
        a();
        int iA = C0.a(i4);
        int iB = C0.b(i4);
        if (iB == 0) {
            r(i4, Long.valueOf(abstractC1063j.y()));
            return true;
        }
        if (iB == 1) {
            r(i4, Long.valueOf(abstractC1063j.v()));
            return true;
        }
        if (iB == 2) {
            r(i4, abstractC1063j.r());
            return true;
        }
        if (iB == 3) {
            x0 x0Var = new x0();
            x0Var.j(abstractC1063j);
            abstractC1063j.a(C0.c(iA, 4));
            r(i4, x0Var);
            return true;
        }
        if (iB == 4) {
            return false;
        }
        if (iB != 5) {
            throw D.e();
        }
        r(i4, Integer.valueOf(abstractC1063j.u()));
        return true;
    }

    public final x0 j(AbstractC1063j abstractC1063j) {
        int iG;
        do {
            iG = abstractC1063j.G();
            if (iG == 0) {
                break;
            }
        } while (i(iG, abstractC1063j));
        return this;
    }

    public x0 k(x0 x0Var) {
        if (x0Var.equals(c())) {
            return this;
        }
        a();
        int i4 = this.f11250a + x0Var.f11250a;
        b(i4);
        System.arraycopy(x0Var.f11251b, 0, this.f11251b, this.f11250a, x0Var.f11250a);
        System.arraycopy(x0Var.f11252c, 0, this.f11252c, this.f11250a, x0Var.f11250a);
        this.f11250a = i4;
        return this;
    }

    public x0 l(int i4, AbstractC1062i abstractC1062i) {
        a();
        if (i4 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        r(C0.c(i4, 2), abstractC1062i);
        return this;
    }

    public x0 m(int i4, int i5) {
        a();
        if (i4 == 0) {
            throw new IllegalArgumentException("Zero is not a valid field number.");
        }
        r(C0.c(i4, 0), Long.valueOf(i5));
        return this;
    }

    public final void q(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < this.f11250a; i5++) {
            Y.d(sb, i4, String.valueOf(C0.a(this.f11251b[i5])), this.f11252c[i5]);
        }
    }

    public void r(int i4, Object obj) {
        a();
        b(this.f11250a + 1);
        int[] iArr = this.f11251b;
        int i5 = this.f11250a;
        iArr[i5] = i4;
        this.f11252c[i5] = obj;
        this.f11250a = i5 + 1;
    }

    public void t(D0 d02) {
        if (d02.i() == D0.a.DESCENDING) {
            for (int i4 = this.f11250a - 1; i4 >= 0; i4--) {
                d02.c(C0.a(this.f11251b[i4]), this.f11252c[i4]);
            }
            return;
        }
        for (int i5 = 0; i5 < this.f11250a; i5++) {
            d02.c(C0.a(this.f11251b[i5]), this.f11252c[i5]);
        }
    }

    public void v(D0 d02) {
        if (this.f11250a == 0) {
            return;
        }
        if (d02.i() == D0.a.ASCENDING) {
            for (int i4 = 0; i4 < this.f11250a; i4++) {
                u(this.f11251b[i4], this.f11252c[i4], d02);
            }
            return;
        }
        for (int i5 = this.f11250a - 1; i5 >= 0; i5--) {
            u(this.f11251b[i5], this.f11252c[i5], d02);
        }
    }

    public x0(int i4, int[] iArr, Object[] objArr, boolean z4) {
        this.f11253d = -1;
        this.f11250a = i4;
        this.f11251b = iArr;
        this.f11252c = objArr;
        this.f11254e = z4;
    }
}
