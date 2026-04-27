package K2;

/* JADX INFO: loaded from: classes.dex */
public final class U {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final U f875g = new U(0, 0, 0, 0, null, 3);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f876a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f877b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f878c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f879d;
    public final int e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final K f880f;

    public U(int i, int i6, long j4, long j6, K k6, int i7) {
        this.f876a = i;
        this.f877b = i6;
        this.f878c = j4;
        this.f879d = j6;
        this.e = i7;
        this.f880f = k6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || U.class != obj.getClass()) {
            return false;
        }
        U u6 = (U) obj;
        if (this.f876a != u6.f876a || this.f877b != u6.f877b || this.f878c != u6.f878c || this.f879d != u6.f879d || this.e != u6.e) {
            return false;
        }
        K k6 = u6.f880f;
        K k7 = this.f880f;
        return k7 != null ? k7.equals(k6) : k6 == null;
    }

    public final int hashCode() {
        int i = ((this.f876a * 31) + this.f877b) * 31;
        long j4 = this.f878c;
        int i6 = (i + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        long j6 = this.f879d;
        int iC = (S.i.c(this.e) + ((i6 + ((int) (j6 ^ (j6 >>> 32)))) * 31)) * 31;
        K k6 = this.f880f;
        return iC + (k6 != null ? k6.hashCode() : 0);
    }
}
