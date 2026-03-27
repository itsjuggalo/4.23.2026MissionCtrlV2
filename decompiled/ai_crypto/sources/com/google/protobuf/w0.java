package com.google.protobuf;

import com.google.protobuf.C0;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class w0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final w0 f12860f = new w0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f12861a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f12862b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f12863c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12864d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12865e;

    public w0() {
        this(0, new int[8], new Object[8], true);
    }

    public static w0 c() {
        return f12860f;
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

    public static w0 j(w0 w0Var, w0 w0Var2) {
        int i7 = w0Var.f12861a + w0Var2.f12861a;
        int[] iArrCopyOf = Arrays.copyOf(w0Var.f12862b, i7);
        System.arraycopy(w0Var2.f12862b, 0, iArrCopyOf, w0Var.f12861a, w0Var2.f12861a);
        Object[] objArrCopyOf = Arrays.copyOf(w0Var.f12863c, i7);
        System.arraycopy(w0Var2.f12863c, 0, objArrCopyOf, w0Var.f12861a, w0Var2.f12861a);
        return new w0(i7, iArrCopyOf, objArrCopyOf, true);
    }

    public static w0 k() {
        return new w0();
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

    public static void q(int i7, Object obj, C0 c02) {
        int iA = B0.a(i7);
        int iB = B0.b(i7);
        if (iB == 0) {
            c02.n(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 1) {
            c02.h(iA, ((Long) obj).longValue());
            return;
        }
        if (iB == 2) {
            c02.N(iA, (AbstractC1240i) obj);
            return;
        }
        if (iB != 3) {
            if (iB != 5) {
                throw new RuntimeException(D.e());
            }
            c02.d(iA, ((Integer) obj).intValue());
        } else if (c02.i() == C0.a.ASCENDING) {
            c02.q(iA);
            ((w0) obj).r(c02);
            c02.B(iA);
        } else {
            c02.B(iA);
            ((w0) obj).r(c02);
            c02.q(iA);
        }
    }

    public void a() {
        if (!this.f12865e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void b(int i7) {
        int[] iArr = this.f12862b;
        if (i7 > iArr.length) {
            int i8 = this.f12861a;
            int i9 = i8 + (i8 / 2);
            if (i9 >= i7) {
                i7 = i9;
            }
            if (i7 < 8) {
                i7 = 8;
            }
            this.f12862b = Arrays.copyOf(iArr, i7);
            this.f12863c = Arrays.copyOf(this.f12863c, i7);
        }
    }

    public int d() {
        int iT;
        int i7 = this.f12864d;
        if (i7 != -1) {
            return i7;
        }
        int i8 = 0;
        for (int i9 = 0; i9 < this.f12861a; i9++) {
            int i10 = this.f12862b[i9];
            int iA = B0.a(i10);
            int iB = B0.b(i10);
            if (iB == 0) {
                iT = AbstractC1243l.T(iA, ((Long) this.f12863c[i9]).longValue());
            } else if (iB == 1) {
                iT = AbstractC1243l.p(iA, ((Long) this.f12863c[i9]).longValue());
            } else if (iB == 2) {
                iT = AbstractC1243l.h(iA, (AbstractC1240i) this.f12863c[i9]);
            } else if (iB == 3) {
                iT = (AbstractC1243l.Q(iA) * 2) + ((w0) this.f12863c[i9]).d();
            } else {
                if (iB != 5) {
                    throw new IllegalStateException(D.e());
                }
                iT = AbstractC1243l.n(iA, ((Integer) this.f12863c[i9]).intValue());
            }
            i8 += iT;
        }
        this.f12864d = i8;
        return i8;
    }

    public int e() {
        int i7 = this.f12864d;
        if (i7 != -1) {
            return i7;
        }
        int iF = 0;
        for (int i8 = 0; i8 < this.f12861a; i8++) {
            iF += AbstractC1243l.F(B0.a(this.f12862b[i8]), (AbstractC1240i) this.f12863c[i8]);
        }
        this.f12864d = iF;
        return iF;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof w0)) {
            return false;
        }
        w0 w0Var = (w0) obj;
        int i7 = this.f12861a;
        return i7 == w0Var.f12861a && o(this.f12862b, w0Var.f12862b, i7) && l(this.f12863c, w0Var.f12863c, this.f12861a);
    }

    public void h() {
        if (this.f12865e) {
            this.f12865e = false;
        }
    }

    public int hashCode() {
        int i7 = this.f12861a;
        return ((((527 + i7) * 31) + f(this.f12862b, i7)) * 31) + g(this.f12863c, this.f12861a);
    }

    public w0 i(w0 w0Var) {
        if (w0Var.equals(c())) {
            return this;
        }
        a();
        int i7 = this.f12861a + w0Var.f12861a;
        b(i7);
        System.arraycopy(w0Var.f12862b, 0, this.f12862b, this.f12861a, w0Var.f12861a);
        System.arraycopy(w0Var.f12863c, 0, this.f12863c, this.f12861a, w0Var.f12861a);
        this.f12861a = i7;
        return this;
    }

    public final void m(StringBuilder sb, int i7) {
        for (int i8 = 0; i8 < this.f12861a; i8++) {
            X.d(sb, i7, String.valueOf(B0.a(this.f12862b[i8])), this.f12863c[i8]);
        }
    }

    public void n(int i7, Object obj) {
        a();
        b(this.f12861a + 1);
        int[] iArr = this.f12862b;
        int i8 = this.f12861a;
        iArr[i8] = i7;
        this.f12863c[i8] = obj;
        this.f12861a = i8 + 1;
    }

    public void p(C0 c02) {
        if (c02.i() == C0.a.DESCENDING) {
            for (int i7 = this.f12861a - 1; i7 >= 0; i7--) {
                c02.c(B0.a(this.f12862b[i7]), this.f12863c[i7]);
            }
            return;
        }
        for (int i8 = 0; i8 < this.f12861a; i8++) {
            c02.c(B0.a(this.f12862b[i8]), this.f12863c[i8]);
        }
    }

    public void r(C0 c02) {
        if (this.f12861a == 0) {
            return;
        }
        if (c02.i() == C0.a.ASCENDING) {
            for (int i7 = 0; i7 < this.f12861a; i7++) {
                q(this.f12862b[i7], this.f12863c[i7], c02);
            }
            return;
        }
        for (int i8 = this.f12861a - 1; i8 >= 0; i8--) {
            q(this.f12862b[i8], this.f12863c[i8], c02);
        }
    }

    public w0(int i7, int[] iArr, Object[] objArr, boolean z7) {
        this.f12864d = -1;
        this.f12861a = i7;
        this.f12862b = iArr;
        this.f12863c = objArr;
        this.f12865e = z7;
    }
}
