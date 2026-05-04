package com.google.protobuf;

import com.google.protobuf.b2;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final v1 f7209f = new v1(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f7211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f7212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7214e;

    public v1() {
        this(0, new int[8], new Object[8], true);
    }

    public static v1 c() {
        return f7209f;
    }

    public static int f(int[] iArr, int i10) {
        int i11 = 17;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 = (i11 * 31) + iArr[i12];
        }
        return i11;
    }

    public static int g(Object[] objArr, int i10) {
        int iHashCode = 17;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return iHashCode;
    }

    public static v1 j(v1 v1Var, v1 v1Var2) {
        int i10 = v1Var.f7210a + v1Var2.f7210a;
        int[] iArrCopyOf = Arrays.copyOf(v1Var.f7211b, i10);
        System.arraycopy(v1Var2.f7211b, 0, iArrCopyOf, v1Var.f7210a, v1Var2.f7210a);
        Object[] objArrCopyOf = Arrays.copyOf(v1Var.f7212c, i10);
        System.arraycopy(v1Var2.f7212c, 0, objArrCopyOf, v1Var.f7210a, v1Var2.f7210a);
        return new v1(i10, iArrCopyOf, objArrCopyOf, true);
    }

    public static v1 k() {
        return new v1();
    }

    public static boolean l(Object[] objArr, Object[] objArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (!objArr[i11].equals(objArr2[i11])) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(int[] iArr, int[] iArr2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            if (iArr[i11] != iArr2[i11]) {
                return false;
            }
        }
        return true;
    }

    public static void q(int i10, Object obj, b2 b2Var) {
        int iA = a2.a(i10);
        int iB = a2.b(i10);
        if (iB == 0) {
            b2Var.n(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            b2Var.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            b2Var.N(iA, (i) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(d0.e());
            }
            b2Var.d(iA, ((Integer) obj).intValue());
        } else if (b2Var.i() == b2.a.ASCENDING) {
            b2Var.q(iA);
            ((v1) obj).r(b2Var);
            b2Var.B(iA);
        } else {
            b2Var.B(iA);
            ((v1) obj).r(b2Var);
            b2Var.q(iA);
        }
    }

    public void a() {
        if (!this.f7214e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i10) {
        int[] iArr = this.f7211b;
        if (i10 > iArr.length) {
            int i11 = this.f7210a;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.f7211b = Arrays.copyOf(iArr, i10);
            this.f7212c = Arrays.copyOf(this.f7212c, i10);
        }
    }

    public int d() {
        int iT;
        int i10 = this.f7213d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f7210a; i12++) {
            int i13 = this.f7211b[i12];
            int iA = a2.a(i13);
            int iB = a2.b(i13);
            if (iB == 0) {
                iT = l.T(iA, ((Long) this.f7212c[i12]).longValue());
            } else if (iB == 1) {
                iT = l.p(iA, ((Long) this.f7212c[i12]).longValue());
            } else if (iB == 2) {
                iT = l.h(iA, (i) this.f7212c[i12]);
            } else if (iB == 3) {
                iT = (l.Q(iA) * 2) + ((v1) this.f7212c[i12]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(d0.e());
                }
                iT = l.n(iA, ((Integer) this.f7212c[i12]).intValue());
            }
            i11 += iT;
        }
        this.f7213d = i11;
        return i11;
    }

    public int e() {
        int i10 = this.f7213d;
        if (i10 != -1) {
            return i10;
        }
        int iF = 0;
        for (int i11 = 0; i11 < this.f7210a; i11++) {
            iF += l.F(a2.a(this.f7211b[i11]), (i) this.f7212c[i11]);
        }
        this.f7213d = iF;
        return iF;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof v1)) {
            return false;
        }
        v1 v1Var = (v1) obj;
        int i10 = this.f7210a;
        return i10 == v1Var.f7210a && o(this.f7211b, v1Var.f7211b, i10) && l(this.f7212c, v1Var.f7212c, this.f7210a);
    }

    public void h() {
        if (this.f7214e) {
            this.f7214e = false;
        }
    }

    public int hashCode() {
        int i10 = this.f7210a;
        return ((((527 + i10) * 31) + f(this.f7211b, i10)) * 31) + g(this.f7212c, this.f7210a);
    }

    public v1 i(v1 v1Var) {
        if (v1Var.equals(c())) {
            return this;
        }
        a();
        int i10 = this.f7210a + v1Var.f7210a;
        b(i10);
        System.arraycopy(v1Var.f7211b, 0, this.f7211b, this.f7210a, v1Var.f7210a);
        System.arraycopy(v1Var.f7212c, 0, this.f7212c, this.f7210a, v1Var.f7210a);
        this.f7210a = i10;
        return this;
    }

    public final void m(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f7210a; i11++) {
            w0.d(sb2, i10, String.valueOf(a2.a(this.f7211b[i11])), this.f7212c[i11]);
        }
    }

    public void n(int i10, Object obj) {
        a();
        b(this.f7210a + 1);
        int[] iArr = this.f7211b;
        int i11 = this.f7210a;
        iArr[i11] = i10;
        this.f7212c[i11] = obj;
        this.f7210a = i11 + 1;
    }

    public void p(b2 b2Var) {
        if (b2Var.i() == b2.a.DESCENDING) {
            for (int i10 = this.f7210a - 1; i10 >= 0; i10--) {
                b2Var.c(a2.a(this.f7211b[i10]), this.f7212c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f7210a; i11++) {
            b2Var.c(a2.a(this.f7211b[i11]), this.f7212c[i11]);
        }
    }

    public void r(b2 b2Var) {
        if (this.f7210a == 0) {
            return;
        }
        if (b2Var.i() == b2.a.ASCENDING) {
            for (int i10 = 0; i10 < this.f7210a; i10++) {
                q(this.f7211b[i10], this.f7212c[i10], b2Var);
            }
            return;
        }
        for (int i11 = this.f7210a - 1; i11 >= 0; i11--) {
            q(this.f7211b[i11], this.f7212c[i11], b2Var);
        }
    }

    public v1(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f7213d = -1;
        this.f7210a = i10;
        this.f7211b = iArr;
        this.f7212c = objArr;
        this.f7214e = z10;
    }
}
