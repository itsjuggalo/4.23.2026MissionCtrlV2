package n6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 extends i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f16662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f16663b;

    public h0(int i10, long j10) {
        this.f16662a = i10;
        this.f16663b = j10;
    }

    @Override // n6.i0
    public final int a() {
        return this.f16662a;
    }

    @Override // n6.i0
    public final long b() {
        return this.f16663b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i0) {
            i0 i0Var = (i0) obj;
            if (this.f16662a == i0Var.a() && this.f16663b == i0Var.b()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j10 = this.f16663b;
        return ((int) (j10 ^ (j10 >>> 32))) ^ ((this.f16662a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "EventRecord{eventType=" + this.f16662a + ", eventTimestamp=" + this.f16663b + "}";
    }
}
