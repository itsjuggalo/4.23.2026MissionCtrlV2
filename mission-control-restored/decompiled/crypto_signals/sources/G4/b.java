package G4;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Comparable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f526b = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f527a = 131328;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        b other = (b) obj;
        kotlin.jvm.internal.j.e(other, "other");
        return this.f527a - other.f527a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        b bVar = obj instanceof b ? (b) obj : null;
        return bVar != null && this.f527a == bVar.f527a;
    }

    public final int hashCode() {
        return this.f527a;
    }

    public final String toString() {
        return "2.1.0";
    }
}
