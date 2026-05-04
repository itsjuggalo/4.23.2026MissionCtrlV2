package wb;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f23881a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f23882b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23883c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int[] f23884d = new int[10];

    public int a(int i10) {
        return this.f23884d[i10];
    }

    public int b() {
        if ((this.f23881a & 2) != 0) {
            return this.f23884d[1];
        }
        return -1;
    }

    public int c(int i10) {
        return (this.f23881a & 32) != 0 ? this.f23884d[5] : i10;
    }

    public boolean d(int i10) {
        return ((1 << i10) & this.f23881a) != 0;
    }

    public i e(int i10, int i11, int i12) {
        int[] iArr = this.f23884d;
        if (i10 >= iArr.length) {
            return this;
        }
        int i13 = 1 << i10;
        this.f23881a |= i13;
        if ((i11 & 1) != 0) {
            this.f23882b |= i13;
        } else {
            this.f23882b &= ~i13;
        }
        if ((i11 & 2) != 0) {
            this.f23883c |= i13;
        } else {
            this.f23883c &= ~i13;
        }
        iArr[i10] = i12;
        return this;
    }

    public int f() {
        return Integer.bitCount(this.f23881a);
    }
}
