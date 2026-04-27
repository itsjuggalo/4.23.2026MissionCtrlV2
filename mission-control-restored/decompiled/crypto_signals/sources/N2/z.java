package N2;

/* JADX INFO: loaded from: classes.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final y f2062a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q2.h f2063b;

    public z(y yVar, Q2.h hVar) {
        this.f2062a = yVar;
        this.f2063b = hVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof z)) {
            return false;
        }
        z zVar = (z) obj;
        return this.f2062a.equals(zVar.f2062a) && this.f2063b.equals(zVar.f2063b);
    }

    public final int hashCode() {
        return this.f2063b.f2674a.hashCode() + ((this.f2062a.hashCode() + 2077) * 31);
    }
}
