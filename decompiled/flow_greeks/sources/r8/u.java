package r8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u f19442a = new u();

    public static u j() {
        return f19442a;
    }

    @Override // r8.h
    public String c() {
        return ".value";
    }

    @Override // r8.h
    public boolean e(n nVar) {
        return true;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof u;
    }

    @Override // r8.h
    public m f(b bVar, n nVar) {
        return new m(bVar, nVar);
    }

    @Override // r8.h
    public m g() {
        return new m(b.k(), n.P);
    }

    public int hashCode() {
        return 4;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compare(m mVar, m mVar2) {
        int iCompareTo = mVar.d().compareTo(mVar2.d());
        return iCompareTo == 0 ? mVar.c().compareTo(mVar2.c()) : iCompareTo;
    }

    public String toString() {
        return "ValueIndex";
    }
}
