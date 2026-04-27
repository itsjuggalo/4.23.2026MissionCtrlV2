package a2;

/* JADX INFO: loaded from: classes.dex */
public final class z extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object f6185c;

    public z(Object obj) {
        this.f6185c = Z1.m.n(obj);
    }

    @Override // a2.m, a2.j
    public k c() {
        return k.w(this.f6185c);
    }

    @Override // a2.j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f6185c.equals(obj);
    }

    @Override // a2.j
    public int f(Object[] objArr, int i4) {
        objArr[i4] = this.f6185c;
        return i4 + 1;
    }

    @Override // a2.m, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f6185c.hashCode();
    }

    @Override // a2.j
    public boolean m() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: s */
    public B iterator() {
        return n.b(this.f6185c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f6185c.toString() + ']';
    }
}
