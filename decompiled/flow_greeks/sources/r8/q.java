package r8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f19436a = new q();

    public static q j() {
        return f19436a;
    }

    @Override // r8.h
    public String c() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }

    @Override // r8.h
    public boolean e(n nVar) {
        return !nVar.n().isEmpty();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof q;
    }

    @Override // r8.h
    public m f(b bVar, n nVar) {
        return new m(bVar, new t("[PRIORITY-POST]", nVar));
    }

    @Override // r8.h
    public m g() {
        return f(b.k(), n.P);
    }

    public int hashCode() {
        return 3155577;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compare(m mVar, m mVar2) {
        return o.c(mVar.c(), mVar.d().n(), mVar2.c(), mVar2.d().n());
    }

    public String toString() {
        return "PriorityIndex";
    }
}
