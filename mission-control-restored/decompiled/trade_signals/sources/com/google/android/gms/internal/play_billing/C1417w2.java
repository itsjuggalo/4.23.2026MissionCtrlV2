package com.google.android.gms.internal.play_billing;

import java.util.Arrays;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.w2, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1417w2 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C1417w2 f15534f = new C1417w2(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f15535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f15536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f15537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f15538d = -1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f15539e;

    public C1417w2(int i8, int[] iArr, Object[] objArr, boolean z7) {
        this.f15535a = i8;
        this.f15536b = iArr;
        this.f15537c = objArr;
        this.f15539e = z7;
    }

    public static C1417w2 c() {
        return f15534f;
    }

    public static C1417w2 e(C1417w2 c1417w2, C1417w2 c1417w22) {
        int i8 = c1417w2.f15535a + c1417w22.f15535a;
        int[] iArrCopyOf = Arrays.copyOf(c1417w2.f15536b, i8);
        System.arraycopy(c1417w22.f15536b, 0, iArrCopyOf, c1417w2.f15535a, c1417w22.f15535a);
        Object[] objArrCopyOf = Arrays.copyOf(c1417w2.f15537c, i8);
        System.arraycopy(c1417w22.f15537c, 0, objArrCopyOf, c1417w2.f15535a, c1417w22.f15535a);
        return new C1417w2(i8, iArrCopyOf, objArrCopyOf, true);
    }

    public static C1417w2 f() {
        return new C1417w2(0, new int[8], new Object[8], true);
    }

    public final int a() {
        int iC;
        int iD;
        int iC2;
        int i8 = this.f15538d;
        if (i8 != -1) {
            return i8;
        }
        int i9 = 0;
        for (int i10 = 0; i10 < this.f15535a; i10++) {
            int i11 = this.f15536b[i10];
            int i12 = i11 >>> 3;
            int i13 = i11 & 7;
            if (i13 != 0) {
                if (i13 == 1) {
                    ((Long) this.f15537c[i10]).longValue();
                    iC2 = AbstractC1412v1.c(i12 << 3) + 8;
                } else if (i13 == 2) {
                    int i14 = i12 << 3;
                    AbstractC1378o1 abstractC1378o1 = (AbstractC1378o1) this.f15537c[i10];
                    int iC3 = AbstractC1412v1.c(i14);
                    int iE = abstractC1378o1.e();
                    iC2 = iC3 + AbstractC1412v1.c(iE) + iE;
                } else if (i13 == 3) {
                    int iC4 = AbstractC1412v1.c(i12 << 3);
                    iC = iC4 + iC4;
                    iD = ((C1417w2) this.f15537c[i10]).a();
                } else {
                    if (i13 != 5) {
                        throw new IllegalStateException(new Q1("Protocol message tag had invalid wire type."));
                    }
                    ((Integer) this.f15537c[i10]).intValue();
                    iC2 = AbstractC1412v1.c(i12 << 3) + 4;
                }
                i9 += iC2;
            } else {
                int i15 = i12 << 3;
                long jLongValue = ((Long) this.f15537c[i10]).longValue();
                iC = AbstractC1412v1.c(i15);
                iD = AbstractC1412v1.d(jLongValue);
            }
            iC2 = iC + iD;
            i9 += iC2;
        }
        this.f15538d = i9;
        return i9;
    }

    public final int b() {
        int i8 = this.f15538d;
        if (i8 != -1) {
            return i8;
        }
        int iC = 0;
        for (int i9 = 0; i9 < this.f15535a; i9++) {
            int i10 = this.f15536b[i9] >>> 3;
            AbstractC1378o1 abstractC1378o1 = (AbstractC1378o1) this.f15537c[i9];
            int iC2 = AbstractC1412v1.c(8);
            int iC3 = AbstractC1412v1.c(16) + AbstractC1412v1.c(i10);
            int iC4 = AbstractC1412v1.c(24);
            int iE = abstractC1378o1.e();
            iC += iC2 + iC2 + iC3 + iC4 + AbstractC1412v1.c(iE) + iE;
        }
        this.f15538d = iC;
        return iC;
    }

    public final C1417w2 d(C1417w2 c1417w2) {
        if (c1417w2.equals(f15534f)) {
            return this;
        }
        g();
        int i8 = this.f15535a + c1417w2.f15535a;
        l(i8);
        System.arraycopy(c1417w2.f15536b, 0, this.f15536b, this.f15535a, c1417w2.f15535a);
        System.arraycopy(c1417w2.f15537c, 0, this.f15537c, this.f15535a, c1417w2.f15535a);
        this.f15535a = i8;
        return this;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C1417w2)) {
            return false;
        }
        C1417w2 c1417w2 = (C1417w2) obj;
        int i8 = this.f15535a;
        if (i8 == c1417w2.f15535a) {
            int[] iArr = this.f15536b;
            int[] iArr2 = c1417w2.f15536b;
            int i9 = 0;
            while (true) {
                if (i9 >= i8) {
                    Object[] objArr = this.f15537c;
                    Object[] objArr2 = c1417w2.f15537c;
                    int i10 = this.f15535a;
                    for (int i11 = 0; i11 < i10; i11++) {
                        if (objArr[i11].equals(objArr2[i11])) {
                        }
                    }
                    return true;
                }
                if (iArr[i9] != iArr2[i9]) {
                    break;
                }
                i9++;
            }
        }
        return false;
    }

    public final void g() {
        if (!this.f15539e) {
            throw new UnsupportedOperationException();
        }
    }

    public final void h() {
        if (this.f15539e) {
            this.f15539e = false;
        }
    }

    public final int hashCode() {
        int i8 = this.f15535a;
        int i9 = i8 + 527;
        int[] iArr = this.f15536b;
        int iHashCode = 17;
        int i10 = 17;
        for (int i11 = 0; i11 < i8; i11++) {
            i10 = (i10 * 31) + iArr[i11];
        }
        int i12 = ((i9 * 31) + i10) * 31;
        Object[] objArr = this.f15537c;
        int i13 = this.f15535a;
        for (int i14 = 0; i14 < i13; i14++) {
            iHashCode = (iHashCode * 31) + objArr[i14].hashCode();
        }
        return i12 + iHashCode;
    }

    public final void i(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < this.f15535a; i9++) {
            AbstractC1344h2.b(sb, i8, String.valueOf(this.f15536b[i9] >>> 3), this.f15537c[i9]);
        }
    }

    public final void j(int i8, Object obj) {
        g();
        l(this.f15535a + 1);
        int[] iArr = this.f15536b;
        int i9 = this.f15535a;
        iArr[i9] = i8;
        this.f15537c[i9] = obj;
        this.f15535a = i9 + 1;
    }

    public final void k(G2 g22) {
        if (this.f15535a != 0) {
            for (int i8 = 0; i8 < this.f15535a; i8++) {
                int i9 = this.f15536b[i8];
                Object obj = this.f15537c[i8];
                int i10 = i9 & 7;
                int i11 = i9 >>> 3;
                if (i10 == 0) {
                    g22.g(i11, ((Long) obj).longValue());
                } else if (i10 == 1) {
                    g22.w(i11, ((Long) obj).longValue());
                } else if (i10 == 2) {
                    g22.f(i11, (AbstractC1378o1) obj);
                } else if (i10 == 3) {
                    g22.A(i11);
                    ((C1417w2) obj).k(g22);
                    g22.z(i11);
                } else {
                    if (i10 != 5) {
                        throw new RuntimeException(new Q1("Protocol message tag had invalid wire type."));
                    }
                    g22.zzk(i11, ((Integer) obj).intValue());
                }
            }
        }
    }

    public final void l(int i8) {
        int[] iArr = this.f15536b;
        if (i8 > iArr.length) {
            int i9 = this.f15535a;
            int i10 = i9 + (i9 / 2);
            if (i10 >= i8) {
                i8 = i10;
            }
            if (i8 < 8) {
                i8 = 8;
            }
            this.f15536b = Arrays.copyOf(iArr, i8);
            this.f15537c = Arrays.copyOf(this.f15537c, i8);
        }
    }
}
