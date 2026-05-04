package j9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f14278b = new v(new a7.s(0, 0));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.s f14279a;

    public v(a7.s sVar) {
        this.f14279a = sVar;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(v vVar) {
        return this.f14279a.compareTo(vVar.f14279a);
    }

    public a7.s b() {
        return this.f14279a;
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
        return "SnapshotVersion(seconds=" + this.f14279a.h() + ", nanos=" + this.f14279a.b() + ")";
    }
}
