package Z3;

/* JADX INFO: renamed from: Z3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0785e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0784d f5932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnumC0784d f5933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f5934c;

    public C0785e(EnumC0784d performance, EnumC0784d crashlytics, double d7) {
        kotlin.jvm.internal.r.f(performance, "performance");
        kotlin.jvm.internal.r.f(crashlytics, "crashlytics");
        this.f5932a = performance;
        this.f5933b = crashlytics;
        this.f5934c = d7;
    }

    public final EnumC0784d a() {
        return this.f5933b;
    }

    public final EnumC0784d b() {
        return this.f5932a;
    }

    public final double c() {
        return this.f5934c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0785e)) {
            return false;
        }
        C0785e c0785e = (C0785e) obj;
        return this.f5932a == c0785e.f5932a && this.f5933b == c0785e.f5933b && Double.compare(this.f5934c, c0785e.f5934c) == 0;
    }

    public int hashCode() {
        return (((this.f5932a.hashCode() * 31) + this.f5933b.hashCode()) * 31) + Double.hashCode(this.f5934c);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.f5932a + ", crashlytics=" + this.f5933b + ", sessionSamplingRate=" + this.f5934c + ')';
    }
}
