package Q2;

import Z1.r;

/* JADX INFO: loaded from: classes.dex */
public final class n implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final n f2687b = new n(new r(0, 0));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f2688a;

    public n(r rVar) {
        this.f2688a = rVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(n nVar) {
        return this.f2688a.compareTo(nVar.f2688a);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof n) && compareTo((n) obj) == 0;
    }

    public final int hashCode() {
        return this.f2688a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("SnapshotVersion(seconds=");
        r rVar = this.f2688a;
        sb.append(rVar.f3982a);
        sb.append(", nanos=");
        sb.append(rVar.f3983b);
        sb.append(")");
        return sb.toString();
    }
}
