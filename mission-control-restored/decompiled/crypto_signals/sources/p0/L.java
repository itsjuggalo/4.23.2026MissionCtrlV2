package p0;

/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f8989a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f8990b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f8991c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f8992d;
    public int e;

    public final boolean a() {
        int i = this.f8989a;
        int i6 = 2;
        if ((i & 7) != 0) {
            int i7 = this.f8992d;
            int i8 = this.f8990b;
            if (((i7 > i8 ? 1 : i7 == i8 ? 2 : 4) & i) == 0) {
                return false;
            }
        }
        if ((i & 112) != 0) {
            int i9 = this.f8992d;
            int i10 = this.f8991c;
            if ((((i9 > i10 ? 1 : i9 == i10 ? 2 : 4) << 4) & i) == 0) {
                return false;
            }
        }
        if ((i & 1792) != 0) {
            int i11 = this.e;
            int i12 = this.f8990b;
            if ((((i11 > i12 ? 1 : i11 == i12 ? 2 : 4) << 8) & i) == 0) {
                return false;
            }
        }
        if ((i & 28672) != 0) {
            int i13 = this.e;
            int i14 = this.f8991c;
            if (i13 > i14) {
                i6 = 1;
            } else if (i13 != i14) {
                i6 = 4;
            }
            if ((i & (i6 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
