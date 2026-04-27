package t5;

import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f23579a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23580b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f23581c;

    public U(int i7, long j7, Set set) {
        this.f23579a = i7;
        this.f23580b = j7;
        this.f23581c = I2.m.m(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || U.class != obj.getClass()) {
            return false;
        }
        U u7 = (U) obj;
        return this.f23579a == u7.f23579a && this.f23580b == u7.f23580b && H2.i.a(this.f23581c, u7.f23581c);
    }

    public int hashCode() {
        return H2.i.b(Integer.valueOf(this.f23579a), Long.valueOf(this.f23580b), this.f23581c);
    }

    public String toString() {
        return H2.g.b(this).b("maxAttempts", this.f23579a).c("hedgingDelayNanos", this.f23580b).d("nonFatalStatusCodes", this.f23581c).toString();
    }
}
