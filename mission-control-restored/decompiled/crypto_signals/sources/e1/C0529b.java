package e1;

import h1.InterfaceC0618a;
import java.util.HashMap;

/* JADX INFO: renamed from: e1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0529b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0618a f6043a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap f6044b;

    public C0529b(InterfaceC0618a interfaceC0618a, HashMap map) {
        this.f6043a = interfaceC0618a;
        this.f6044b = map;
    }

    public final long a(V0.d dVar, long j4, int i) {
        long jD = j4 - this.f6043a.d();
        C0530c c0530c = (C0530c) this.f6044b.get(dVar);
        long j6 = c0530c.f6045a;
        return Math.min(Math.max((long) (Math.pow(3.0d, i - 1) * j6 * Math.max(1.0d, Math.log(10000.0d) / Math.log((j6 > 1 ? j6 : 2L) * ((long) r12)))), jD), c0530c.f6046b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0529b)) {
            return false;
        }
        C0529b c0529b = (C0529b) obj;
        return this.f6043a.equals(c0529b.f6043a) && this.f6044b.equals(c0529b.f6044b);
    }

    public final int hashCode() {
        return ((this.f6043a.hashCode() ^ 1000003) * 1000003) ^ this.f6044b.hashCode();
    }

    public final String toString() {
        return "SchedulerConfig{clock=" + this.f6043a + ", values=" + this.f6044b + "}";
    }
}
