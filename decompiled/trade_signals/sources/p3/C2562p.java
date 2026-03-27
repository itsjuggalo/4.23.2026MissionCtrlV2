package p3;

import h3.C1875k;

/* JADX INFO: renamed from: p3.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2562p extends AbstractC2554h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1875k f22312a;

    public C2562p(C1875k c1875k) {
        if (c1875k.size() == 1 && c1875k.P().t()) {
            throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
        }
        this.f22312a = c1875k;
    }

    @Override // p3.AbstractC2554h
    public String c() {
        return this.f22312a.T();
    }

    @Override // p3.AbstractC2554h
    public boolean e(InterfaceC2560n interfaceC2560n) {
        return !interfaceC2560n.s(this.f22312a).isEmpty();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && C2562p.class == obj.getClass() && this.f22312a.equals(((C2562p) obj).f22312a);
    }

    @Override // p3.AbstractC2554h
    public C2559m f(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        return new C2559m(c2548b, C2553g.M().y(this.f22312a, interfaceC2560n));
    }

    @Override // p3.AbstractC2554h
    public C2559m g() {
        return new C2559m(C2548b.l(), C2553g.M().y(this.f22312a, InterfaceC2560n.f22308N));
    }

    public int hashCode() {
        return this.f22312a.hashCode();
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compare(C2559m c2559m, C2559m c2559m2) {
        int iCompareTo = c2559m.d().s(this.f22312a).compareTo(c2559m2.d().s(this.f22312a));
        return iCompareTo == 0 ? c2559m.c().compareTo(c2559m2.c()) : iCompareTo;
    }
}
