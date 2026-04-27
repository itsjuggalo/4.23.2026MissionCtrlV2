package w2;

import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class z extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object f24062c;

    public z(Object obj) {
        this.f24062c = AbstractC2848n.n(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: K */
    public AbstractC2910B iterator() {
        return n.b(this.f24062c);
    }

    @Override // w2.m, w2.AbstractC2921j
    public k a() {
        return k.O(this.f24062c);
    }

    @Override // w2.AbstractC2921j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f24062c.equals(obj);
    }

    @Override // w2.AbstractC2921j
    public int d(Object[] objArr, int i8) {
        objArr[i8] = this.f24062c;
        return i8 + 1;
    }

    @Override // w2.m, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f24062c.hashCode();
    }

    @Override // w2.AbstractC2921j
    public boolean n() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f24062c.toString() + ']';
    }
}
