package M2;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class D0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f1890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f1891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f1892f;

    public D0(int i4, long j4, long j5, double d4, Long l4, Set set) {
        this.f1887a = i4;
        this.f1888b = j4;
        this.f1889c = j5;
        this.f1890d = d4;
        this.f1891e = l4;
        this.f1892f = a2.m.p(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof D0)) {
            return false;
        }
        D0 d02 = (D0) obj;
        return this.f1887a == d02.f1887a && this.f1888b == d02.f1888b && this.f1889c == d02.f1889c && Double.compare(this.f1890d, d02.f1890d) == 0 && Z1.i.a(this.f1891e, d02.f1891e) && Z1.i.a(this.f1892f, d02.f1892f);
    }

    public int hashCode() {
        return Z1.i.b(Integer.valueOf(this.f1887a), Long.valueOf(this.f1888b), Long.valueOf(this.f1889c), Double.valueOf(this.f1890d), this.f1891e, this.f1892f);
    }

    public String toString() {
        return Z1.g.b(this).b("maxAttempts", this.f1887a).c("initialBackoffNanos", this.f1888b).c("maxBackoffNanos", this.f1889c).a("backoffMultiplier", this.f1890d).d("perAttemptRecvTimeoutNanos", this.f1891e).d("retryableStatusCodes", this.f1892f).toString();
    }
}
