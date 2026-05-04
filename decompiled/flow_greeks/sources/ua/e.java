package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f22569a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f22570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f22571c;

    public e(d performance, d crashlytics, double d10) {
        kotlin.jvm.internal.t.f(performance, "performance");
        kotlin.jvm.internal.t.f(crashlytics, "crashlytics");
        this.f22569a = performance;
        this.f22570b = crashlytics;
        this.f22571c = d10;
    }

    public final d a() {
        return this.f22570b;
    }

    public final d b() {
        return this.f22569a;
    }

    public final double c() {
        return this.f22571c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f22569a == eVar.f22569a && this.f22570b == eVar.f22570b && Double.compare(this.f22571c, eVar.f22571c) == 0;
    }

    public int hashCode() {
        return (((this.f22569a.hashCode() * 31) + this.f22570b.hashCode()) * 31) + Double.hashCode(this.f22571c);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.f22569a + ", crashlytics=" + this.f22570b + ", sessionSamplingRate=" + this.f22571c + ')';
    }
}
