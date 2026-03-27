package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.l0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g0 f7028f = new g0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7029a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f7030b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f7031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7033e;

    public g0() {
        this(0, new int[8], new Object[8], true);
    }

    public static g0 c() {
        return f7028f;
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

    public static g0 j(g0 g0Var, g0 g0Var2) {
        int i4 = g0Var.f7029a + g0Var2.f7029a;
        int[] iArrCopyOf = Arrays.copyOf(g0Var.f7030b, i4);
        System.arraycopy(g0Var2.f7030b, 0, iArrCopyOf, g0Var.f7029a, g0Var2.f7029a);
        Object[] objArrCopyOf = Arrays.copyOf(g0Var.f7031c, i4);
        System.arraycopy(g0Var2.f7031c, 0, objArrCopyOf, g0Var.f7029a, g0Var2.f7029a);
        return new g0(i4, iArrCopyOf, objArrCopyOf, true);
    }

    public static g0 k() {
        return new g0();
    }

    public static boolean l(Object[] objArr, Object[] objArr2, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (!objArr[i5].equals(objArr2[i5])) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(int[] iArr, int[] iArr2, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            if (iArr[i5] != iArr2[i5]) {
                return false;
            }
        }
        return true;
    }

    public static void q(int i4, Object obj, l0 l0Var) {
        int iA = k0.a(i4);
        int iB = k0.b(i4);
        if (iB == 0) {
            l0Var.n(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            l0Var.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            l0Var.L(iA, (AbstractC0793f) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(C0808v.e());
            }
            l0Var.d(iA, ((Integer) obj).intValue());
        } else if (l0Var.i() == l0.a.ASCENDING) {
            l0Var.q(iA);
            ((g0) obj).r(l0Var);
            l0Var.B(iA);
        } else {
            l0Var.B(iA);
            ((g0) obj).r(l0Var);
            l0Var.q(iA);
        }
    }

    public void a() {
        if (!this.f7033e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i4) {
        int[] iArr = this.f7030b;
        if (i4 > iArr.length) {
            int i5 = this.f7029a;
            int i6 = i5 + (i5 / 2);
            if (i6 >= i4) {
                i4 = i6;
            }
            if (i4 < 8) {
                i4 = 8;
            }
            this.f7030b = Arrays.copyOf(iArr, i4);
            this.f7031c = Arrays.copyOf(this.f7031c, i4);
        }
    }

    public int d() {
        int iR;
        int i4 = this.f7032d;
        if (i4 != -1) {
            return i4;
        }
        int i5 = 0;
        for (int i6 = 0; i6 < this.f7029a; i6++) {
            int i7 = this.f7030b[i6];
            int iA = k0.a(i7);
            int iB = k0.b(i7);
            if (iB == 0) {
                iR = AbstractC0796i.R(iA, ((Long) this.f7031c[i6]).longValue());
            } else if (iB == 1) {
                iR = AbstractC0796i.n(iA, ((Long) this.f7031c[i6]).longValue());
            } else if (iB == 2) {
                iR = AbstractC0796i.f(iA, (AbstractC0793f) this.f7031c[i6]);
            } else if (iB == 3) {
                iR = (AbstractC0796i.O(iA) * 2) + ((g0) this.f7031c[i6]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(C0808v.e());
                }
                iR = AbstractC0796i.l(iA, ((Integer) this.f7031c[i6]).intValue());
            }
            i5 += iR;
        }
        this.f7032d = i5;
        return i5;
    }

    public int e() {
        int i4 = this.f7032d;
        if (i4 != -1) {
            return i4;
        }
        int iD = 0;
        for (int i5 = 0; i5 < this.f7029a; i5++) {
            iD += AbstractC0796i.D(k0.a(this.f7030b[i5]), (AbstractC0793f) this.f7031c[i5]);
        }
        this.f7032d = iD;
        return iD;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof g0)) {
            return false;
        }
        g0 g0Var = (g0) obj;
        int i4 = this.f7029a;
        return i4 == g0Var.f7029a && o(this.f7030b, g0Var.f7030b, i4) && l(this.f7031c, g0Var.f7031c, this.f7029a);
    }

    public void h() {
        if (this.f7033e) {
            this.f7033e = false;
        }
    }

    public int hashCode() {
        int i4 = this.f7029a;
        return ((((527 + i4) * 31) + f(this.f7030b, i4)) * 31) + g(this.f7031c, this.f7029a);
    }

    public g0 i(g0 g0Var) {
        if (g0Var.equals(c())) {
            return this;
        }
        a();
        int i4 = this.f7029a + g0Var.f7029a;
        b(i4);
        System.arraycopy(g0Var.f7030b, 0, this.f7030b, this.f7029a, g0Var.f7029a);
        System.arraycopy(g0Var.f7031c, 0, this.f7031c, this.f7029a, g0Var.f7029a);
        this.f7029a = i4;
        return this;
    }

    public final void m(StringBuilder sb, int i4) {
        for (int i5 = 0; i5 < this.f7029a; i5++) {
            L.d(sb, i4, String.valueOf(k0.a(this.f7030b[i5])), this.f7031c[i5]);
        }
    }

    public void n(int i4, Object obj) {
        a();
        b(this.f7029a + 1);
        int[] iArr = this.f7030b;
        int i5 = this.f7029a;
        iArr[i5] = i4;
        this.f7031c[i5] = obj;
        this.f7029a = i5 + 1;
    }

    public void p(l0 l0Var) {
        if (l0Var.i() == l0.a.DESCENDING) {
            for (int i4 = this.f7029a - 1; i4 >= 0; i4--) {
                l0Var.c(k0.a(this.f7030b[i4]), this.f7031c[i4]);
            }
            return;
        }
        for (int i5 = 0; i5 < this.f7029a; i5++) {
            l0Var.c(k0.a(this.f7030b[i5]), this.f7031c[i5]);
        }
    }

    public void r(l0 l0Var) {
        if (this.f7029a == 0) {
            return;
        }
        if (l0Var.i() == l0.a.ASCENDING) {
            for (int i4 = 0; i4 < this.f7029a; i4++) {
                q(this.f7030b[i4], this.f7031c[i4], l0Var);
            }
            return;
        }
        for (int i5 = this.f7029a - 1; i5 >= 0; i5--) {
            q(this.f7030b[i5], this.f7031c[i5], l0Var);
        }
    }

    public g0(int i4, int[] iArr, Object[] objArr, boolean z4) {
        this.f7032d = -1;
        this.f7029a = i4;
        this.f7030b = iArr;
        this.f7031c = objArr;
        this.f7033e = z4;
    }
}
