package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.l0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g0 f7436f = new g0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f7438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f7439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f7440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f7441e;

    public g0() {
        this(0, new int[8], new Object[8], true);
    }

    public static g0 c() {
        return f7436f;
    }

    public static int f(int[] iArr, int i7) {
        int i8 = 17;
        for (int i9 = 0; i9 < i7; i9++) {
            i8 = (i8 * 31) + iArr[i9];
        }
        return i8;
    }

    public static int g(Object[] objArr, int i7) {
        int iHashCode = 17;
        for (int i8 = 0; i8 < i7; i8++) {
            iHashCode = (iHashCode * 31) + objArr[i8].hashCode();
        }
        return iHashCode;
    }

    public static g0 j(g0 g0Var, g0 g0Var2) {
        int i7 = g0Var.f7437a + g0Var2.f7437a;
        int[] iArrCopyOf = Arrays.copyOf(g0Var.f7438b, i7);
        System.arraycopy(g0Var2.f7438b, 0, iArrCopyOf, g0Var.f7437a, g0Var2.f7437a);
        Object[] objArrCopyOf = Arrays.copyOf(g0Var.f7439c, i7);
        System.arraycopy(g0Var2.f7439c, 0, objArrCopyOf, g0Var.f7437a, g0Var2.f7437a);
        return new g0(i7, iArrCopyOf, objArrCopyOf, true);
    }

    public static g0 k() {
        return new g0();
    }

    public static boolean l(Object[] objArr, Object[] objArr2, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (!objArr[i8].equals(objArr2[i8])) {
                return false;
            }
        }
        return true;
    }

    public static boolean o(int[] iArr, int[] iArr2, int i7) {
        for (int i8 = 0; i8 < i7; i8++) {
            if (iArr[i8] != iArr2[i8]) {
                return false;
            }
        }
        return true;
    }

    public static void q(int i7, Object obj, l0 l0Var) {
        int iA = k0.a(i7);
        int iB = k0.b(i7);
        if (iB == 0) {
            l0Var.n(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            l0Var.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            l0Var.L(iA, (AbstractC0935f) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(C0950v.e());
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
        if (!this.f7441e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i7) {
        int[] iArr = this.f7438b;
        if (i7 > iArr.length) {
            int i8 = this.f7437a;
            int i9 = i8 + (i8 / 2);
            if (i9 >= i7) {
                i7 = i9;
            }
            if (i7 < 8) {
                i7 = 8;
            }
            this.f7438b = Arrays.copyOf(iArr, i7);
            this.f7439c = Arrays.copyOf(this.f7439c, i7);
        }
    }

    public int d() {
        int iR;
        int i7 = this.f7440d;
        if (i7 != -1) {
            return i7;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.f7437a; i9++) {
            int i10 = this.f7438b[i9];
            int iA = k0.a(i10);
            int iB = k0.b(i10);
            if (iB == 0) {
                iR = AbstractC0938i.R(iA, ((Long) this.f7439c[i9]).longValue());
            } else if (iB == 1) {
                iR = AbstractC0938i.n(iA, ((Long) this.f7439c[i9]).longValue());
            } else if (iB == 2) {
                iR = AbstractC0938i.f(iA, (AbstractC0935f) this.f7439c[i9]);
            } else if (iB == 3) {
                iR = (AbstractC0938i.O(iA) * 2) + ((g0) this.f7439c[i9]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(C0950v.e());
                }
                iR = AbstractC0938i.l(iA, ((Integer) this.f7439c[i9]).intValue());
            }
            i8 += iR;
        }
        this.f7440d = i8;
        return i8;
    }

    public int e() {
        int i7 = this.f7440d;
        if (i7 != -1) {
            return i7;
        }
        int iD = 0;
        for (int i8 = 0; i8 < this.f7437a; i8++) {
            iD += AbstractC0938i.D(k0.a(this.f7438b[i8]), (AbstractC0935f) this.f7439c[i8]);
        }
        this.f7440d = iD;
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
        int i7 = this.f7437a;
        return i7 == g0Var.f7437a && o(this.f7438b, g0Var.f7438b, i7) && l(this.f7439c, g0Var.f7439c, this.f7437a);
    }

    public void h() {
        if (this.f7441e) {
            this.f7441e = false;
        }
    }

    public int hashCode() {
        int i7 = this.f7437a;
        return ((((527 + i7) * 31) + f(this.f7438b, i7)) * 31) + g(this.f7439c, this.f7437a);
    }

    public g0 i(g0 g0Var) {
        if (g0Var.equals(c())) {
            return this;
        }
        a();
        int i7 = this.f7437a + g0Var.f7437a;
        b(i7);
        System.arraycopy(g0Var.f7438b, 0, this.f7438b, this.f7437a, g0Var.f7437a);
        System.arraycopy(g0Var.f7439c, 0, this.f7439c, this.f7437a, g0Var.f7437a);
        this.f7437a = i7;
        return this;
    }

    public final void m(StringBuilder sb, int i7) {
        for (int i8 = 0; i8 < this.f7437a; i8++) {
            L.d(sb, i7, String.valueOf(k0.a(this.f7438b[i8])), this.f7439c[i8]);
        }
    }

    public void n(int i7, Object obj) {
        a();
        b(this.f7437a + 1);
        int[] iArr = this.f7438b;
        int i8 = this.f7437a;
        iArr[i8] = i7;
        this.f7439c[i8] = obj;
        this.f7437a = i8 + 1;
    }

    public void p(l0 l0Var) {
        if (l0Var.i() == l0.a.DESCENDING) {
            for (int i7 = this.f7437a - 1; i7 >= 0; i7--) {
                l0Var.c(k0.a(this.f7438b[i7]), this.f7439c[i7]);
            }
            return;
        }
        for (int i8 = 0; i8 < this.f7437a; i8++) {
            l0Var.c(k0.a(this.f7438b[i8]), this.f7439c[i8]);
        }
    }

    public void r(l0 l0Var) {
        if (this.f7437a == 0) {
            return;
        }
        if (l0Var.i() == l0.a.ASCENDING) {
            for (int i7 = 0; i7 < this.f7437a; i7++) {
                q(this.f7438b[i7], this.f7439c[i7], l0Var);
            }
            return;
        }
        for (int i8 = this.f7437a - 1; i8 >= 0; i8--) {
            q(this.f7438b[i8], this.f7439c[i8], l0Var);
        }
    }

    public g0(int i7, int[] iArr, Object[] objArr, boolean z7) {
        this.f7440d = -1;
        this.f7437a = i7;
        this.f7438b = iArr;
        this.f7439c = objArr;
        this.f7441e = z7;
    }
}
