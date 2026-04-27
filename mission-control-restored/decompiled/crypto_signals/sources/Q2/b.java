package Q2;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Comparable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f2660d = new b(n.f2687b, h.b(), -1);
    public static final A.d e = new A.d(8);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f2661a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f2662b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2663c;

    public b(n nVar, h hVar, int i) {
        if (nVar == null) {
            throw new NullPointerException("Null readTime");
        }
        this.f2661a = nVar;
        if (hVar == null) {
            throw new NullPointerException("Null documentKey");
        }
        this.f2662b = hVar;
        this.f2663c = i;
    }

    public static b b(k kVar) {
        return new b(kVar.f2682d, kVar.f2679a, -1);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(b bVar) {
        int iCompareTo = this.f2661a.compareTo(bVar.f2661a);
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = this.f2662b.compareTo(bVar.f2662b);
        return iCompareTo2 != 0 ? iCompareTo2 : Integer.compare(this.f2663c, bVar.f2663c);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f2661a.equals(bVar.f2661a) && this.f2662b.equals(bVar.f2662b) && this.f2663c == bVar.f2663c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((this.f2661a.f2688a.hashCode() ^ 1000003) * 1000003) ^ this.f2662b.f2674a.hashCode()) * 1000003) ^ this.f2663c;
    }

    public final String toString() {
        return "IndexOffset{readTime=" + this.f2661a + ", documentKey=" + this.f2662b + ", largestBatchId=" + this.f2663c + "}";
    }
}
