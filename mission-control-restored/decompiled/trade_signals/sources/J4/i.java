package J4;

/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4636a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f4637b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4638c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f4639d = new int[10];

    public int a(int i8) {
        return this.f4639d[i8];
    }

    public int b() {
        if ((this.f4636a & 2) != 0) {
            return this.f4639d[1];
        }
        return -1;
    }

    public int c(int i8) {
        return (this.f4636a & 32) != 0 ? this.f4639d[5] : i8;
    }

    public boolean d(int i8) {
        return ((1 << i8) & this.f4636a) != 0;
    }

    public i e(int i8, int i9, int i10) {
        int[] iArr = this.f4639d;
        if (i8 >= iArr.length) {
            return this;
        }
        int i11 = 1 << i8;
        this.f4636a |= i11;
        this.f4637b = (i9 & 1) != 0 ? this.f4637b | i11 : this.f4637b & (~i11);
        this.f4638c = (i9 & 2) != 0 ? this.f4638c | i11 : this.f4638c & (~i11);
        iArr[i8] = i10;
        return this;
    }

    public int f() {
        return Integer.bitCount(this.f4636a);
    }
}
