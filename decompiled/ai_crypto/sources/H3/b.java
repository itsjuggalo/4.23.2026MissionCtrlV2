package H3;

/* JADX INFO: loaded from: classes.dex */
public final class b extends k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f2632b;

    public b(int i7, f fVar) {
        this.f2631a = i7;
        if (fVar == null) {
            throw new NullPointerException("Null mutation");
        }
        this.f2632b = fVar;
    }

    @Override // H3.k
    public int c() {
        return this.f2631a;
    }

    @Override // H3.k
    public f d() {
        return this.f2632b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        return this.f2631a == kVar.c() && this.f2632b.equals(kVar.d());
    }

    public int hashCode() {
        return ((this.f2631a ^ 1000003) * 1000003) ^ this.f2632b.hashCode();
    }

    public String toString() {
        return "Overlay{largestBatchId=" + this.f2631a + ", mutation=" + this.f2632b + "}";
    }
}
