package r8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class p extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j8.l f19435a;

    public p(j8.l lVar) {
        if (lVar.size() == 1 && lVar.K().s()) {
            throw new IllegalArgumentException("Can't create PathIndex with '.priority' as key. Please use PriorityIndex instead!");
        }
        this.f19435a = lVar;
    }

    @Override // r8.h
    public String c() {
        return this.f19435a.T();
    }

    @Override // r8.h
    public boolean e(n nVar) {
        return !nVar.O(this.f19435a).isEmpty();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && p.class == obj.getClass() && this.f19435a.equals(((p) obj).f19435a);
    }

    @Override // r8.h
    public m f(b bVar, n nVar) {
        return new m(bVar, g.y().I(this.f19435a, nVar));
    }

    @Override // r8.h
    public m g() {
        return new m(b.k(), g.y().I(this.f19435a, n.P));
    }

    public int hashCode() {
        return this.f19435a.hashCode();
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public int compare(m mVar, m mVar2) {
        int iCompareTo = mVar.d().O(this.f19435a).compareTo(mVar2.d().O(this.f19435a));
        return iCompareTo == 0 ? mVar.c().compareTo(mVar2.c()) : iCompareTo;
    }
}
