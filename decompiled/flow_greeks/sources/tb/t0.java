package tb;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f21729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f21730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set f21731c;

    public t0(int i10, long j10, Set set) {
        this.f21729a = i10;
        this.f21730b = j10;
        this.f21731c = q6.m.r(set);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && t0.class == obj.getClass()) {
            t0 t0Var = (t0) obj;
            if (this.f21729a == t0Var.f21729a && this.f21730b == t0Var.f21730b && p6.j.a(this.f21731c, t0Var.f21731c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return p6.j.b(Integer.valueOf(this.f21729a), Long.valueOf(this.f21730b), this.f21731c);
    }

    public String toString() {
        return p6.h.b(this).b("maxAttempts", this.f21729a).c("hedgingDelayNanos", this.f21730b).d("nonFatalStatusCodes", this.f21731c).toString();
    }
}
