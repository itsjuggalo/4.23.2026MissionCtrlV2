package tb;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f21152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f21153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final double f21154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Long f21155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set f21156f;

    public c2(int i10, long j10, long j11, double d10, Long l10, Set set) {
        this.f21151a = i10;
        this.f21152b = j10;
        this.f21153c = j11;
        this.f21154d = d10;
        this.f21155e = l10;
        this.f21156f = q6.m.r(set);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c2)) {
            return false;
        }
        c2 c2Var = (c2) obj;
        return this.f21151a == c2Var.f21151a && this.f21152b == c2Var.f21152b && this.f21153c == c2Var.f21153c && Double.compare(this.f21154d, c2Var.f21154d) == 0 && p6.j.a(this.f21155e, c2Var.f21155e) && p6.j.a(this.f21156f, c2Var.f21156f);
    }

    public int hashCode() {
        return p6.j.b(Integer.valueOf(this.f21151a), Long.valueOf(this.f21152b), Long.valueOf(this.f21153c), Double.valueOf(this.f21154d), this.f21155e, this.f21156f);
    }

    public String toString() {
        return p6.h.b(this).b("maxAttempts", this.f21151a).c("initialBackoffNanos", this.f21152b).c("maxBackoffNanos", this.f21153c).a("backoffMultiplier", this.f21154d).d("perAttemptRecvTimeoutNanos", this.f21155e).d("retryableStatusCodes", this.f21156f).toString();
    }
}
