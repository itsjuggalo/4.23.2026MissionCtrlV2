package q6;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class z extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object f18862c;

    public z(Object obj) {
        this.f18862c = p6.n.n(obj);
    }

    @Override // q6.m, q6.j
    public k a() {
        return k.G(this.f18862c);
    }

    @Override // q6.j
    public int c(Object[] objArr, int i10) {
        objArr[i10] = this.f18862c;
        return i10 + 1;
    }

    @Override // q6.j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f18862c.equals(obj);
    }

    @Override // q6.j
    public boolean g() {
        return false;
    }

    @Override // q6.m, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f18862c.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f18862c.toString() + ']';
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: v */
    public b0 iterator() {
        return n.b(this.f18862c);
    }
}
