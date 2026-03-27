package G3;

/* JADX INFO: loaded from: classes.dex */
public final class v implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f2475b = new v(new Q2.s(0, 0));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Q2.s f2476a;

    public v(Q2.s sVar) {
        this.f2476a = sVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(v vVar) {
        return this.f2476a.compareTo(vVar.f2476a);
    }

    public Q2.s b() {
        return this.f2476a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof v) && compareTo((v) obj) == 0;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public String toString() {
        return "SnapshotVersion(seconds=" + this.f2476a.h() + ", nanos=" + this.f2476a.c() + ")";
    }
}
