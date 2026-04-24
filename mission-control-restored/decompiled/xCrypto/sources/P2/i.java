package P2;

/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f3532a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3533b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f3534c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f3535d = new int[10];

    public int a(int i4) {
        return this.f3535d[i4];
    }

    public int b() {
        if ((this.f3532a & 2) != 0) {
            return this.f3535d[1];
        }
        return -1;
    }

    public int c(int i4) {
        return (this.f3532a & 32) != 0 ? this.f3535d[5] : i4;
    }

    public boolean d(int i4) {
        return ((1 << i4) & this.f3532a) != 0;
    }

    public i e(int i4, int i5, int i6) {
        int[] iArr = this.f3535d;
        if (i4 >= iArr.length) {
            return this;
        }
        int i7 = 1 << i4;
        this.f3532a |= i7;
        if ((i5 & 1) != 0) {
            this.f3533b |= i7;
        } else {
            this.f3533b &= ~i7;
        }
        if ((i5 & 2) != 0) {
            this.f3534c |= i7;
        } else {
            this.f3534c &= ~i7;
        }
        iArr[i4] = i6;
        return this;
    }

    public int f() {
        return Integer.bitCount(this.f3532a);
    }
}
