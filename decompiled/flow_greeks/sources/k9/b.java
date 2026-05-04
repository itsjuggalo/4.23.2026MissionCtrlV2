package k9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f14770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f14771b;

    public b(int i10, f fVar) {
        this.f14770a = i10;
        if (fVar == null) {
            throw new NullPointerException("Null mutation");
        }
        this.f14771b = fVar;
    }

    @Override // k9.k
    public int c() {
        return this.f14770a;
    }

    @Override // k9.k
    public f d() {
        return this.f14771b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f14770a == kVar.c() && this.f14771b.equals(kVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f14770a ^ 1000003) * 1000003) ^ this.f14771b.hashCode();
    }

    public String toString() {
        return "Overlay{largestBatchId=" + this.f14770a + ", mutation=" + this.f14771b + "}";
    }
}
