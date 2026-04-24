package Q2;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2670b;

    public f(String str, String str2) {
        this.f2669a = str;
        this.f2670b = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        f fVar = (f) obj;
        int iCompareTo = this.f2669a.compareTo(fVar.f2669a);
        return iCompareTo != 0 ? iCompareTo : this.f2670b.compareTo(fVar.f2670b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && f.class == obj.getClass()) {
            f fVar = (f) obj;
            if (this.f2669a.equals(fVar.f2669a) && this.f2670b.equals(fVar.f2670b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f2670b.hashCode() + (this.f2669a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("DatabaseId(");
        sb.append(this.f2669a);
        sb.append(", ");
        return AbstractC1024h.d(sb, this.f2670b, ")");
    }
}
