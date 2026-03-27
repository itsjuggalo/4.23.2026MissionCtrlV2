package Q2;

/* JADX INFO: loaded from: classes.dex */
public final class d implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f2666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f2667b;

    public d(int i, j jVar) {
        if (jVar == null) {
            throw new NullPointerException("Null fieldPath");
        }
        this.f2666a = jVar;
        if (i == 0) {
            throw new NullPointerException("Null kind");
        }
        this.f2667b = i;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        d dVar = (d) obj;
        int iCompareTo = this.f2666a.compareTo(dVar.f2666a);
        return iCompareTo != 0 ? iCompareTo : S.i.a(this.f2667b, dVar.f2667b);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f2666a.equals(dVar.f2666a) && S.i.b(this.f2667b, dVar.f2667b);
    }

    public final int hashCode() {
        return ((this.f2666a.hashCode() ^ 1000003) * 1000003) ^ S.i.c(this.f2667b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Segment{fieldPath=");
        sb.append(this.f2666a);
        sb.append(", kind=");
        int i = this.f2667b;
        sb.append(i != 1 ? i != 2 ? i != 3 ? "null" : "CONTAINS" : "DESCENDING" : "ASCENDING");
        sb.append("}");
        return sb.toString();
    }
}
