package M2;

import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public final class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2028a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2029b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f2030c;

    public U(int i4, long j4, Set set) {
        this.f2028a = i4;
        this.f2029b = j4;
        this.f2030c = a2.m.p(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && U.class == obj.getClass()) {
            U u4 = (U) obj;
            if (this.f2028a == u4.f2028a && this.f2029b == u4.f2029b && Z1.i.a(this.f2030c, u4.f2030c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Z1.i.b(Integer.valueOf(this.f2028a), Long.valueOf(this.f2029b), this.f2030c);
    }

    public String toString() {
        return Z1.g.b(this).b("maxAttempts", this.f2028a).c("hedgingDelayNanos", this.f2029b).d("nonFatalStatusCodes", this.f2030c).toString();
    }
}
