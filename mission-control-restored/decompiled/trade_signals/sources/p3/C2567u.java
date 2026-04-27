package p3;

/* JADX INFO: renamed from: p3.u, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2567u extends AbstractC2554h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2567u f22319a = new C2567u();

    public static C2567u j() {
        return f22319a;
    }

    @Override // p3.AbstractC2554h
    public String c() {
        return ".value";
    }

    @Override // p3.AbstractC2554h
    public boolean e(InterfaceC2560n interfaceC2560n) {
        return true;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof C2567u;
    }

    @Override // p3.AbstractC2554h
    public C2559m f(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        return new C2559m(c2548b, interfaceC2560n);
    }

    @Override // p3.AbstractC2554h
    public C2559m g() {
        return new C2559m(C2548b.l(), InterfaceC2560n.f22308N);
    }

    public int hashCode() {
        return 4;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compare(C2559m c2559m, C2559m c2559m2) {
        int iCompareTo = c2559m.d().compareTo(c2559m2.d());
        return iCompareTo == 0 ? c2559m.c().compareTo(c2559m2.c()) : iCompareTo;
    }

    public String toString() {
        return "ValueIndex";
    }
}
