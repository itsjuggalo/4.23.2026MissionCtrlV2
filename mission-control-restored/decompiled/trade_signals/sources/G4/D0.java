package G4;

import java.util.Set;
import v2.AbstractC2842h;
import v2.AbstractC2844j;

/* JADX INFO: loaded from: classes2.dex */
public final class D0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f2477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f2478d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f2479e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f2480f;

    public D0(int i8, long j8, long j9, double d8, Long l8, Set set) {
        this.f2475a = i8;
        this.f2476b = j8;
        this.f2477c = j9;
        this.f2478d = d8;
        this.f2479e = l8;
        this.f2480f = w2.m.H(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof D0)) {
            return false;
        }
        D0 d02 = (D0) obj;
        return this.f2475a == d02.f2475a && this.f2476b == d02.f2476b && this.f2477c == d02.f2477c && Double.compare(this.f2478d, d02.f2478d) == 0 && AbstractC2844j.a(this.f2479e, d02.f2479e) && AbstractC2844j.a(this.f2480f, d02.f2480f);
    }

    public int hashCode() {
        return AbstractC2844j.b(Integer.valueOf(this.f2475a), Long.valueOf(this.f2476b), Long.valueOf(this.f2477c), Double.valueOf(this.f2478d), this.f2479e, this.f2480f);
    }

    public String toString() {
        return AbstractC2842h.b(this).b("maxAttempts", this.f2475a).c("initialBackoffNanos", this.f2476b).c("maxBackoffNanos", this.f2477c).a("backoffMultiplier", this.f2478d).d("perAttemptRecvTimeoutNanos", this.f2479e).d("retryableStatusCodes", this.f2480f).toString();
    }
}
