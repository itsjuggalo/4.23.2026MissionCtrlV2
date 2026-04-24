package p3;

/* JADX INFO: renamed from: p3.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2563q extends AbstractC2554h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2563q f22313a = new C2563q();

    public static C2563q j() {
        return f22313a;
    }

    @Override // p3.AbstractC2554h
    public String c() {
        throw new IllegalArgumentException("Can't get query definition on priority index!");
    }

    @Override // p3.AbstractC2554h
    public boolean e(InterfaceC2560n interfaceC2560n) {
        return !interfaceC2560n.o().isEmpty();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return obj instanceof C2563q;
    }

    @Override // p3.AbstractC2554h
    public C2559m f(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        return new C2559m(c2548b, new C2566t("[PRIORITY-POST]", interfaceC2560n));
    }

    @Override // p3.AbstractC2554h
    public C2559m g() {
        return f(C2548b.l(), InterfaceC2560n.f22308N);
    }

    public int hashCode() {
        return 3155577;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compare(C2559m c2559m, C2559m c2559m2) {
        return AbstractC2561o.c(c2559m.c(), c2559m.d().o(), c2559m2.c(), c2559m2.d().o());
    }

    public String toString() {
        return "PriorityIndex";
    }
}
