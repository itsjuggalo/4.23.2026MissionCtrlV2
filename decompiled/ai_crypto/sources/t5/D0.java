package t5;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class D0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23438a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f23440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f23441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f23442e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f23443f;

    public D0(int i7, long j7, long j8, double d7, Long l7, Set set) {
        this.f23438a = i7;
        this.f23439b = j7;
        this.f23440c = j8;
        this.f23441d = d7;
        this.f23442e = l7;
        this.f23443f = I2.m.m(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof D0)) {
            return false;
        }
        D0 d02 = (D0) obj;
        return this.f23438a == d02.f23438a && this.f23439b == d02.f23439b && this.f23440c == d02.f23440c && Double.compare(this.f23441d, d02.f23441d) == 0 && H2.i.a(this.f23442e, d02.f23442e) && H2.i.a(this.f23443f, d02.f23443f);
    }

    public int hashCode() {
        return H2.i.b(Integer.valueOf(this.f23438a), Long.valueOf(this.f23439b), Long.valueOf(this.f23440c), Double.valueOf(this.f23441d), this.f23442e, this.f23443f);
    }

    public String toString() {
        return H2.g.b(this).b("maxAttempts", this.f23438a).c("initialBackoffNanos", this.f23439b).c("maxBackoffNanos", this.f23440c).a("backoffMultiplier", this.f23441d).d("perAttemptRecvTimeoutNanos", this.f23442e).d("retryableStatusCodes", this.f23443f).toString();
    }
}
