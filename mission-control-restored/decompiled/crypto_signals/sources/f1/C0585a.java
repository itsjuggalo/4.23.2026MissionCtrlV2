package f1;

/* JADX INFO: renamed from: f1.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0585a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final C0585a f6398f = new C0585a(10485760, 200, 10000, 604800000, 81920);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f6399a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f6400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f6401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f6402d;
    public final int e;

    public C0585a(long j4, int i, int i6, long j6, int i7) {
        this.f6399a = j4;
        this.f6400b = i;
        this.f6401c = i6;
        this.f6402d = j6;
        this.e = i7;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0585a) {
            C0585a c0585a = (C0585a) obj;
            if (this.f6399a == c0585a.f6399a && this.f6400b == c0585a.f6400b && this.f6401c == c0585a.f6401c && this.f6402d == c0585a.f6402d && this.e == c0585a.e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.f6399a;
        int i = (((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ this.f6400b) * 1000003) ^ this.f6401c) * 1000003;
        long j6 = this.f6402d;
        return ((i ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.e;
    }

    public final String toString() {
        return "EventStoreConfig{maxStorageSizeInBytes=" + this.f6399a + ", loadBatchSize=" + this.f6400b + ", criticalSectionEnterTimeoutMs=" + this.f6401c + ", eventCleanUpAge=" + this.f6402d + ", maxBlobByteSizePerRow=" + this.e + "}";
    }
}
