package i3;

/* JADX INFO: renamed from: i3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0684k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0683j f6975a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnumC0683j f6976b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f6977c;

    public C0684k(EnumC0683j enumC0683j, EnumC0683j enumC0683j2, double d4) {
        this.f6975a = enumC0683j;
        this.f6976b = enumC0683j2;
        this.f6977c = d4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0684k)) {
            return false;
        }
        C0684k c0684k = (C0684k) obj;
        return this.f6975a == c0684k.f6975a && this.f6976b == c0684k.f6976b && Double.compare(this.f6977c, c0684k.f6977c) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.f6977c) + ((this.f6976b.hashCode() + (this.f6975a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "DataCollectionStatus(performance=" + this.f6975a + ", crashlytics=" + this.f6976b + ", sessionSamplingRate=" + this.f6977c + ')';
    }
}
