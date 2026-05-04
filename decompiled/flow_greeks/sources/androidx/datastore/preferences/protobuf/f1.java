package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.k1;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f1 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f1 f1692f = new f1(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f1694b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f1695c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f1696d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f1697e;

    public f1() {
        this(0, new int[8], new Object[8], true);
    }

    public static f1 c() {
        return f1692f;
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

    public static f1 j(f1 f1Var, f1 f1Var2) {
        int i10 = f1Var.f1693a + f1Var2.f1693a;
        int[] iArrCopyOf = Arrays.copyOf(f1Var.f1694b, i10);
        System.arraycopy(f1Var2.f1694b, 0, iArrCopyOf, f1Var.f1693a, f1Var2.f1693a);
        Object[] objArrCopyOf = Arrays.copyOf(f1Var.f1695c, i10);
        System.arraycopy(f1Var2.f1695c, 0, objArrCopyOf, f1Var.f1693a, f1Var2.f1693a);
        return new f1(i10, iArrCopyOf, objArrCopyOf, true);
    }

    public static f1 k() {
        return new f1();
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

    public static void q(int i10, Object obj, k1 k1Var) {
        int iA = j1.a(i10);
        int iB = j1.b(i10);
        if (iB == 0) {
            k1Var.n(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            k1Var.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            k1Var.L(iA, (f) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(v.e());
            }
            k1Var.d(iA, ((Integer) obj).intValue());
        } else if (k1Var.i() == k1.a.ASCENDING) {
            k1Var.q(iA);
            ((f1) obj).r(k1Var);
            k1Var.B(iA);
        } else {
            k1Var.B(iA);
            ((f1) obj).r(k1Var);
            k1Var.q(iA);
        }
    }

    public void a() {
        if (!this.f1697e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i10) {
        int[] iArr = this.f1694b;
        if (i10 > iArr.length) {
            int i11 = this.f1693a;
            int i12 = i11 + (i11 / 2);
            if (i12 >= i10) {
                i10 = i12;
            }
            if (i10 < 8) {
                i10 = 8;
            }
            this.f1694b = Arrays.copyOf(iArr, i10);
            this.f1695c = Arrays.copyOf(this.f1695c, i10);
        }
    }

    public int d() {
        int iR;
        int i10 = this.f1696d;
        if (i10 != -1) {
            return i10;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < this.f1693a; i12++) {
            int i13 = this.f1694b[i12];
            int iA = j1.a(i13);
            int iB = j1.b(i13);
            if (iB == 0) {
                iR = i.R(iA, ((Long) this.f1695c[i12]).longValue());
            } else if (iB == 1) {
                iR = i.n(iA, ((Long) this.f1695c[i12]).longValue());
            } else if (iB == 2) {
                iR = i.f(iA, (f) this.f1695c[i12]);
            } else if (iB == 3) {
                iR = (i.O(iA) * 2) + ((f1) this.f1695c[i12]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(v.e());
                }
                iR = i.l(iA, ((Integer) this.f1695c[i12]).intValue());
            }
            i11 += iR;
        }
        this.f1696d = i11;
        return i11;
    }

    public int e() {
        int i10 = this.f1696d;
        if (i10 != -1) {
            return i10;
        }
        int iD = 0;
        for (int i11 = 0; i11 < this.f1693a; i11++) {
            iD += i.D(j1.a(this.f1694b[i11]), (f) this.f1695c[i11]);
        }
        this.f1696d = iD;
        return iD;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof f1)) {
            return false;
        }
        f1 f1Var = (f1) obj;
        int i10 = this.f1693a;
        return i10 == f1Var.f1693a && o(this.f1694b, f1Var.f1694b, i10) && l(this.f1695c, f1Var.f1695c, this.f1693a);
    }

    public void h() {
        if (this.f1697e) {
            this.f1697e = false;
        }
    }

    public int hashCode() {
        int i10 = this.f1693a;
        return ((((527 + i10) * 31) + f(this.f1694b, i10)) * 31) + g(this.f1695c, this.f1693a);
    }

    public f1 i(f1 f1Var) {
        if (f1Var.equals(c())) {
            return this;
        }
        a();
        int i10 = this.f1693a + f1Var.f1693a;
        b(i10);
        System.arraycopy(f1Var.f1694b, 0, this.f1694b, this.f1693a, f1Var.f1693a);
        System.arraycopy(f1Var.f1695c, 0, this.f1695c, this.f1693a, f1Var.f1693a);
        this.f1693a = i10;
        return this;
    }

    public final void m(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < this.f1693a; i11++) {
            l0.d(sb2, i10, String.valueOf(j1.a(this.f1694b[i11])), this.f1695c[i11]);
        }
    }

    public void n(int i10, Object obj) {
        a();
        b(this.f1693a + 1);
        int[] iArr = this.f1694b;
        int i11 = this.f1693a;
        iArr[i11] = i10;
        this.f1695c[i11] = obj;
        this.f1693a = i11 + 1;
    }

    public void p(k1 k1Var) {
        if (k1Var.i() == k1.a.DESCENDING) {
            for (int i10 = this.f1693a - 1; i10 >= 0; i10--) {
                k1Var.c(j1.a(this.f1694b[i10]), this.f1695c[i10]);
            }
            return;
        }
        for (int i11 = 0; i11 < this.f1693a; i11++) {
            k1Var.c(j1.a(this.f1694b[i11]), this.f1695c[i11]);
        }
    }

    public void r(k1 k1Var) {
        if (this.f1693a == 0) {
            return;
        }
        if (k1Var.i() == k1.a.ASCENDING) {
            for (int i10 = 0; i10 < this.f1693a; i10++) {
                q(this.f1694b[i10], this.f1695c[i10], k1Var);
            }
            return;
        }
        for (int i11 = this.f1693a - 1; i11 >= 0; i11--) {
            q(this.f1694b[i11], this.f1695c[i11], k1Var);
        }
    }

    public f1(int i10, int[] iArr, Object[] objArr, boolean z10) {
        this.f1696d = -1;
        this.f1693a = i10;
        this.f1694b = iArr;
        this.f1695c = objArr;
        this.f1697e = z10;
    }
}
