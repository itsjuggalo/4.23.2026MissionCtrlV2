package p3;

import k3.AbstractC2279m;

/* JADX INFO: renamed from: p3.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2556j extends AbstractC2554h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2556j f22294a = new C2556j();

    public static C2556j j() {
        return f22294a;
    }

    @Override // p3.AbstractC2554h
    public String c() {
        return ".key";
    }

    @Override // p3.AbstractC2554h
    public boolean e(InterfaceC2560n interfaceC2560n) {
        return true;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof C2556j;
    }

    @Override // p3.AbstractC2554h
    public C2559m f(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        AbstractC2279m.f(interfaceC2560n instanceof C2566t);
        return new C2559m(C2548b.i((String) interfaceC2560n.getValue()), C2553g.M());
    }

    @Override // p3.AbstractC2554h
    public C2559m g() {
        return C2559m.a();
    }

    public int hashCode() {
        return 37;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compare(C2559m c2559m, C2559m c2559m2) {
        return c2559m.c().compareTo(c2559m2.c());
    }

    public String toString() {
        return "KeyIndex";
    }
}
