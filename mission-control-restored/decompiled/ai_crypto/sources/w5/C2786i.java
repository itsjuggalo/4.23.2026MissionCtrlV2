package w5;

/* JADX INFO: renamed from: w5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2786i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f25033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f25034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f25036d = new int[10];

    public int a(int i7) {
        return this.f25036d[i7];
    }

    public int b() {
        if ((this.f25033a & 2) != 0) {
            return this.f25036d[1];
        }
        return -1;
    }

    public int c(int i7) {
        return (this.f25033a & 32) != 0 ? this.f25036d[5] : i7;
    }

    public boolean d(int i7) {
        return ((1 << i7) & this.f25033a) != 0;
    }

    public C2786i e(int i7, int i8, int i9) {
        int[] iArr = this.f25036d;
        if (i7 >= iArr.length) {
            return this;
        }
        int i10 = 1 << i7;
        this.f25033a |= i10;
        if ((i8 & 1) != 0) {
            this.f25034b |= i10;
        } else {
            this.f25034b &= ~i10;
        }
        if ((i8 & 2) != 0) {
            this.f25035c |= i10;
        } else {
            this.f25035c &= ~i10;
        }
        iArr[i7] = i9;
        return this;
    }

    public int f() {
        return Integer.bitCount(this.f25033a);
    }
}
