package G4;

import java.util.Set;
import v2.AbstractC2842h;
import v2.AbstractC2844j;

/* JADX INFO: loaded from: classes2.dex */
public final class U {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2616a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f2617b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f2618c;

    public U(int i8, long j8, Set set) {
        this.f2616a = i8;
        this.f2617b = j8;
        this.f2618c = w2.m.H(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || U.class != obj.getClass()) {
            return false;
        }
        U u8 = (U) obj;
        return this.f2616a == u8.f2616a && this.f2617b == u8.f2617b && AbstractC2844j.a(this.f2618c, u8.f2618c);
    }

    public int hashCode() {
        return AbstractC2844j.b(Integer.valueOf(this.f2616a), Long.valueOf(this.f2617b), this.f2618c);
    }

    public String toString() {
        return AbstractC2842h.b(this).b("maxAttempts", this.f2616a).c("hedgingDelayNanos", this.f2617b).d("nonFatalStatusCodes", this.f2618c).toString();
    }
}
