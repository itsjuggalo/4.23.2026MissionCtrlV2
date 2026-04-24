package androidx.datastore.preferences.protobuf;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class c0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final c0 f4539f = new c0(0, new int[0], new Object[0], false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4540a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int[] f4541b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Object[] f4542c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f4543d = -1;
    public boolean e;

    public c0(int i, int[] iArr, Object[] objArr, boolean z6) {
        this.f4540a = i;
        this.f4541b = iArr;
        this.f4542c = objArr;
        this.e = z6;
    }

    public final void a(int i) {
        int[] iArr = this.f4541b;
        if (i > iArr.length) {
            int i6 = this.f4540a;
            int i7 = (i6 / 2) + i6;
            if (i7 >= i) {
                i = i7;
            }
            if (i < 8) {
                i = 8;
            }
            this.f4541b = Arrays.copyOf(iArr, i);
            this.f4542c = Arrays.copyOf(this.f4542c, i);
        }
    }

    public final int b() {
        int iW;
        int iY;
        int iW2;
        int i = this.f4543d;
        if (i != -1) {
            return i;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < this.f4540a; i7++) {
            int i8 = this.f4541b[i7];
            int i9 = i8 >>> 3;
            int i10 = i8 & 7;
            if (i10 != 0) {
                if (i10 == 1) {
                    ((Long) this.f4542c[i7]).getClass();
                    iW2 = C0330l.W(i9) + 8;
                } else if (i10 == 2) {
                    iW2 = C0330l.U(i9, (C0325g) this.f4542c[i7]);
                } else if (i10 == 3) {
                    iW = C0330l.W(i9) * 2;
                    iY = ((c0) this.f4542c[i7]).b();
                } else {
                    if (i10 != 5) {
                        throw new IllegalStateException(C0343z.b());
                    }
                    ((Integer) this.f4542c[i7]).getClass();
                    iW2 = C0330l.W(i9) + 4;
                }
                i6 = iW2 + i6;
            } else {
                long jLongValue = ((Long) this.f4542c[i7]).longValue();
                iW = C0330l.W(i9);
                iY = C0330l.Y(jLongValue);
            }
            i6 = iY + iW + i6;
        }
        this.f4543d = i6;
        return i6;
    }

    public final void c(int i, Object obj) {
        if (!this.e) {
            throw new UnsupportedOperationException();
        }
        a(this.f4540a + 1);
        int[] iArr = this.f4541b;
        int i6 = this.f4540a;
        iArr[i6] = i;
        this.f4542c[i6] = obj;
        this.f4540a = i6 + 1;
    }

    public final void d(E e) {
        if (this.f4540a == 0) {
            return;
        }
        e.getClass();
        for (int i = 0; i < this.f4540a; i++) {
            int i6 = this.f4541b[i];
            Object obj = this.f4542c[i];
            int i7 = i6 >>> 3;
            int i8 = i6 & 7;
            C0330l c0330l = (C0330l) e.f4481a;
            if (i8 == 0) {
                c0330l.s0(i7, ((Long) obj).longValue());
            } else if (i8 == 1) {
                c0330l.i0(i7, ((Long) obj).longValue());
            } else if (i8 == 2) {
                c0330l.e0(i7, (C0325g) obj);
            } else if (i8 == 3) {
                c0330l.p0(i7, 3);
                ((c0) obj).d(e);
                c0330l.p0(i7, 4);
            } else {
                if (i8 != 5) {
                    throw new RuntimeException(C0343z.b());
                }
                c0330l.g0(i7, ((Integer) obj).intValue());
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof c0)) {
            return false;
        }
        c0 c0Var = (c0) obj;
        int i = this.f4540a;
        if (i == c0Var.f4540a) {
            int[] iArr = this.f4541b;
            int[] iArr2 = c0Var.f4541b;
            int i6 = 0;
            while (true) {
                if (i6 >= i) {
                    Object[] objArr = this.f4542c;
                    Object[] objArr2 = c0Var.f4542c;
                    int i7 = this.f4540a;
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
        int i = this.f4540a;
        int i6 = (527 + i) * 31;
        int[] iArr = this.f4541b;
        int iHashCode = 17;
        int i7 = 17;
        for (int i8 = 0; i8 < i; i8++) {
            i7 = (i7 * 31) + iArr[i8];
        }
        int i9 = (i6 + i7) * 31;
        Object[] objArr = this.f4542c;
        int i10 = this.f4540a;
        for (int i11 = 0; i11 < i10; i11++) {
            iHashCode = (iHashCode * 31) + objArr[i11].hashCode();
        }
        return i9 + iHashCode;
    }
}
