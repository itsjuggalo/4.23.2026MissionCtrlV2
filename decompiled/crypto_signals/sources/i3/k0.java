package i3;

/* JADX INFO: loaded from: classes.dex */
public final class k0 {
    public static final j0 Companion = new j0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f6979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f6980c;

    public /* synthetic */ k0(int i, long j4, long j6, long j7) {
        if (1 != (i & 1)) {
            p5.k.a(i, 1, i0.f6970a.d());
            throw null;
        }
        this.f6978a = j4;
        this.f6979b = (i & 2) == 0 ? ((long) 1000) * j4 : j6;
        if ((i & 4) == 0) {
            this.f6980c = j4 / ((long) 1000);
        } else {
            this.f6980c = j7;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k0) && this.f6978a == ((k0) obj).f6978a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f6978a);
    }

    public final String toString() {
        return "Time(ms=" + this.f6978a + ')';
    }

    public k0(long j4) {
        this.f6978a = j4;
        long j6 = 1000;
        this.f6979b = j4 * j6;
        this.f6980c = j4 / j6;
    }
}
