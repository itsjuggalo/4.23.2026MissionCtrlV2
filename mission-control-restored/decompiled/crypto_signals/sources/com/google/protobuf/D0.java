package com.google.protobuf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class D0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final D0 f5638f = new D0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f5639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f5640b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f5641c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f5642d = -1;
    public boolean e;

    public D0(int i, int[] iArr, Object[] objArr, boolean z6) {
        this.f5639a = i;
        this.f5640b = iArr;
        this.f5641c = objArr;
        this.e = z6;
    }

    public static D0 c() {
        return new D0(0, new int[8], new Object[8], true);
    }

    public final void a(int i) {
        int[] iArr = this.f5640b;
        if (i > iArr.length) {
            int i6 = this.f5639a;
            int i7 = (i6 / 2) + i6;
            if (i7 >= i) {
                i = i7;
            }
            if (i < 8) {
                i = 8;
            }
            this.f5640b = Arrays.copyOf(iArr, i);
            this.f5641c = Arrays.copyOf(this.f5641c, i);
        }
    }

    public final int b() {
        int iC;
        int iE;
        int iC2;
        int i = this.f5642d;
        if (i != -1) {
            return i;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f5639a; i7++) {
            int i8 = this.f5640b[i7];
            int i9 = i8 >>> 3;
            int i10 = i8 & 7;
            if (i10 != 0) {
                if (i10 == 1) {
                    ((Long) this.f5641c[i7]).getClass();
                    iC2 = AbstractC0485s.C(i9) + 8;
                } else if (i10 == 2) {
                    iC2 = AbstractC0485s.y(i9, (AbstractC0472l) this.f5641c[i7]);
                } else if (i10 == 3) {
                    iC = AbstractC0485s.C(i9) * 2;
                    iE = ((D0) this.f5641c[i7]).b();
                } else {
                    if (i10 != 5) {
                        throw new IllegalStateException(O.d());
                    }
                    ((Integer) this.f5641c[i7]).getClass();
                    iC2 = AbstractC0485s.C(i9) + 4;
                }
                i6 = iC2 + i6;
            } else {
                long jLongValue = ((Long) this.f5641c[i7]).longValue();
                iC = AbstractC0485s.C(i9);
                iE = AbstractC0485s.E(jLongValue);
            }
            i6 = iE + iC + i6;
        }
        this.f5642d = i6;
        return i6;
    }

    public final void d(int i, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        a(this.f5639a + 1);
        int[] iArr = this.f5640b;
        int i6 = this.f5639a;
        iArr[i6] = i;
        this.f5641c[i6] = obj;
        this.f5639a = i6 + 1;
    }

    public final void e(Z z6) {
        if (this.f5639a == 0) {
            return;
        }
        z6.getClass();
        for (int i = 0; i < this.f5639a; i++) {
            int i6 = this.f5640b[i];
            Object obj = this.f5641c[i];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            AbstractC0485s abstractC0485s = (AbstractC0485s) z6.f5702a;
            if (i8 == 0) {
                abstractC0485s.Y(i7, ((Long) obj).longValue());
            } else if (i8 == 1) {
                abstractC0485s.N(i7, ((Long) obj).longValue());
            } else if (i8 == 2) {
                abstractC0485s.J(i7, (AbstractC0472l) obj);
            } else if (i8 == 3) {
                abstractC0485s.V(i7, 3);
                ((D0) obj).e(z6);
                abstractC0485s.V(i7, 4);
            } else {
                if (i8 != 5) {
                    throw new RuntimeException(O.d());
                }
                abstractC0485s.L(i7, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof D0)) {
            return false;
        }
        D0 d02 = (D0) obj;
        int i = this.f5639a;
        if (i == d02.f5639a) {
            int[] iArr = this.f5640b;
            int[] iArr2 = d02.f5640b;
            int i6 = 0;
            while (true) {
                if (i6 >= i) {
                    Object[] objArr = this.f5641c;
                    Object[] objArr2 = d02.f5641c;
                    int i7 = this.f5639a;
                    for (int i8 = 0; i8 < i7; i8++) {
                        if (objArr[i8].equals(objArr2[i8])) {
                        }
                    }
                    return true;
                }
                if (iArr[i6] != iArr2[i6]) {
                    break;
                }
                i6++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.f5639a;
        int i6 = (527 + i) * 31;
        int[] iArr = this.f5640b;
        int iHashCode = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = (i6 + i7) * 31;
        Object[] objArr = this.f5641c;
        int i10 = this.f5639a;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return i9 + iHashCode;
    }
}
