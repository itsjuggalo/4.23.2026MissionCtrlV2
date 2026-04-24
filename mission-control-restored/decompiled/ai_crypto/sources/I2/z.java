package I2;

/* JADX INFO: loaded from: classes.dex */
public final class z extends m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final transient Object f3014c;

    public z(Object obj) {
        this.f3014c = H2.m.n(obj);
    }

    @Override // I2.m, I2.j
    public k a() {
        return k.u(this.f3014c);
    }

    @Override // I2.j
    public int b(Object[] objArr, int i7) {
        objArr[i7] = this.f3014c;
        return i7 + 1;
    }

    @Override // I2.j, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f3014c.equals(obj);
    }

    @Override // I2.m, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f3014c.hashCode();
    }

    @Override // I2.j
    public boolean j() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: q */
    public B iterator() {
        return n.b(this.f3014c);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return '[' + this.f3014c.toString() + ']';
    }
}
