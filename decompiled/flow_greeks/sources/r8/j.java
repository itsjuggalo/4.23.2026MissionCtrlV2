package r8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f19418a = new j();

    public static j j() {
        return f19418a;
    }

    @Override // r8.h
    public String c() {
        return ".key";
    }

    @Override // r8.h
    public boolean e(n nVar) {
        return true;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof j;
    }

    @Override // r8.h
    public m f(b bVar, n nVar) {
        m8.m.f(nVar instanceof t);
        return new m(b.h((String) nVar.getValue()), g.y());
    }

    @Override // r8.h
    public m g() {
        return m.a();
    }

    public int hashCode() {
        return 37;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compare(m mVar, m mVar2) {
        return mVar.c().compareTo(mVar2.c());
    }

    public String toString() {
        return "KeyIndex";
    }
}
