package R2;

/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f2775b;

    public d(int i, h hVar) {
        this.f2774a = i;
        this.f2775b = hVar;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f2774a == dVar.f2774a && this.f2775b.equals(dVar.f2775b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f2774a ^ 1000003) * 1000003) ^ this.f2775b.hashCode();
    }

    public final String toString() {
        return "Overlay{largestBatchId=" + this.f2774a + ", mutation=" + this.f2775b + "}";
    }
}
