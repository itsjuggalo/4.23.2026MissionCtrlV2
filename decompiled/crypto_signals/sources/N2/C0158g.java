package N2;

/* JADX INFO: renamed from: N2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0158g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EnumC0157f f1999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Q2.k f2000b;

    public C0158g(EnumC0157f enumC0157f, Q2.k kVar) {
        this.f1999a = enumC0157f;
        this.f2000b = kVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0158g)) {
            return false;
        }
        C0158g c0158g = (C0158g) obj;
        return this.f1999a.equals(c0158g.f1999a) && this.f2000b.equals(c0158g.f2000b);
    }

    public final int hashCode() {
        int iHashCode = (this.f1999a.hashCode() + 1891) * 31;
        Q2.k kVar = this.f2000b;
        return kVar.e.hashCode() + ((kVar.f2679a.f2674a.hashCode() + iHashCode) * 31);
    }

    public final String toString() {
        return "DocumentViewChange(" + this.f2000b + "," + this.f1999a + ")";
    }
}
