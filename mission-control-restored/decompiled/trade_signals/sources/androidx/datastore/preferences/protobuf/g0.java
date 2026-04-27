package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.l0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final g0 f11248f = new g0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f11250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f11251c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11252d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f11253e;

    public g0() {
        this(0, new int[8], new Object[8], true);
    }

    public static g0 c() {
        return f11248f;
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
        int i8 = g0Var.f11249a + g0Var2.f11249a;
        int[] iArrCopyOf = Arrays.copyOf(g0Var.f11250b, i8);
        System.arraycopy(g0Var2.f11250b, 0, iArrCopyOf, g0Var.f11249a, g0Var2.f11249a);
        Object[] objArrCopyOf = Arrays.copyOf(g0Var.f11251c, i8);
        System.arraycopy(g0Var2.f11251c, 0, objArrCopyOf, g0Var.f11249a, g0Var2.f11249a);
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

    public static void q(int i8, Object obj, l0 l0Var) {
        int iA = k0.a(i8);
        int iB = k0.b(i8);
        if (iB == 0) {
            l0Var.n(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            l0Var.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            l0Var.L(iA, (AbstractC1104f) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(C1119v.e());
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
        if (!this.f11253e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i8) {
        int[] iArr = this.f11250b;
        if (i8 > iArr.length) {
            int i9 = this.f11249a;
            int i10 = i9 + (i9 / 2);
            if (i10 >= i8) {
                i8 = i10;
            }
            if (i8 < 8) {
                i8 = 8;
            }
            this.f11250b = Arrays.copyOf(iArr, i8);
            this.f11251c = Arrays.copyOf(this.f11251c, i8);
        }
    }

    public int d() {
        int iR;
        int i8 = this.f11252d;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f11249a; i10++) {
            int i11 = this.f11250b[i10];
            int iA = k0.a(i11);
            int iB = k0.b(i11);
            if (iB == 0) {
                iR = AbstractC1107i.R(iA, ((Long) this.f11251c[i10]).longValue());
            } else if (iB == 1) {
                iR = AbstractC1107i.n(iA, ((Long) this.f11251c[i10]).longValue());
            } else if (iB == 2) {
                iR = AbstractC1107i.f(iA, (AbstractC1104f) this.f11251c[i10]);
            } else if (iB == 3) {
                iR = (AbstractC1107i.O(iA) * 2) + ((g0) this.f11251c[i10]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(C1119v.e());
                }
                iR = AbstractC1107i.l(iA, ((Integer) this.f11251c[i10]).intValue());
            }
            i9 += iR;
        }
        this.f11252d = i9;
        return i9;
    }

    public int e() {
        int i8 = this.f11252d;
        if (i8 != -1) {
            return i8;
        }
        int iD = 0;
        for (int i9 = 0; i9 < this.f11249a; i9++) {
            iD += AbstractC1107i.D(k0.a(this.f11250b[i9]), (AbstractC1104f) this.f11251c[i9]);
        }
        this.f11252d = iD;
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
        int i8 = this.f11249a;
        return i8 == g0Var.f11249a && o(this.f11250b, g0Var.f11250b, i8) && l(this.f11251c, g0Var.f11251c, this.f11249a);
    }

    public void h() {
        if (this.f11253e) {
            this.f11253e = false;
        }
    }

    public int hashCode() {
        int i8 = this.f11249a;
        return ((((527 + i8) * 31) + f(this.f11250b, i8)) * 31) + g(this.f11251c, this.f11249a);
    }

    public g0 i(g0 g0Var) {
        if (g0Var.equals(c())) {
            return this;
        }
        a();
        int i8 = this.f11249a + g0Var.f11249a;
        b(i8);
        System.arraycopy(g0Var.f11250b, 0, this.f11250b, this.f11249a, g0Var.f11249a);
        System.arraycopy(g0Var.f11251c, 0, this.f11251c, this.f11249a, g0Var.f11249a);
        this.f11249a = i8;
        return this;
    }

    public final void m(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < this.f11249a; i9++) {
            L.d(sb, i8, String.valueOf(k0.a(this.f11250b[i9])), this.f11251c[i9]);
        }
    }

    public void n(int i8, Object obj) {
        a();
        b(this.f11249a + 1);
        int[] iArr = this.f11250b;
        int i9 = this.f11249a;
        iArr[i9] = i8;
        this.f11251c[i9] = obj;
        this.f11249a = i9 + 1;
    }

    public void p(l0 l0Var) {
        if (l0Var.i() == l0.a.DESCENDING) {
            for (int i8 = this.f11249a - 1; i8 >= 0; i8--) {
                l0Var.c(k0.a(this.f11250b[i8]), this.f11251c[i8]);
            }
            return;
        }
        for (int i9 = 0; i9 < this.f11249a; i9++) {
            l0Var.c(k0.a(this.f11250b[i9]), this.f11251c[i9]);
        }
    }

    public void r(l0 l0Var) {
        if (this.f11249a == 0) {
            return;
        }
        if (l0Var.i() == l0.a.ASCENDING) {
            for (int i8 = 0; i8 < this.f11249a; i8++) {
                q(this.f11250b[i8], this.f11251c[i8], l0Var);
            }
            return;
        }
        for (int i9 = this.f11249a - 1; i9 >= 0; i9--) {
            q(this.f11250b[i9], this.f11251c[i9], l0Var);
        }
    }

    public g0(int i8, int[] iArr, Object[] objArr, boolean z7) {
        this.f11252d = -1;
        this.f11249a = i8;
        this.f11250b = iArr;
        this.f11251c = objArr;
        this.f11253e = z7;
    }
}
