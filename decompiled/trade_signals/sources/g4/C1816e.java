package g4;

import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: g4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1816e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC1815d f18187a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnumC1815d f18188b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f18189c;

    public C1816e(EnumC1815d performance, EnumC1815d crashlytics, double d8) {
        AbstractC2304t.f(performance, "performance");
        AbstractC2304t.f(crashlytics, "crashlytics");
        this.f18187a = performance;
        this.f18188b = crashlytics;
        this.f18189c = d8;
    }

    public final EnumC1815d a() {
        return this.f18188b;
    }

    public final EnumC1815d b() {
        return this.f18187a;
    }

    public final double c() {
        return this.f18189c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1816e)) {
            return false;
        }
        C1816e c1816e = (C1816e) obj;
        return this.f18187a == c1816e.f18187a && this.f18188b == c1816e.f18188b && Double.compare(this.f18189c, c1816e.f18189c) == 0;
    }

    public int hashCode() {
        return (((this.f18187a.hashCode() * 31) + this.f18188b.hashCode()) * 31) + Double.hashCode(this.f18189c);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.f18187a + ", crashlytics=" + this.f18188b + ", sessionSamplingRate=" + this.f18189c + ')';
    }
}
