package V1;

/* JADX INFO: loaded from: classes.dex */
public final class l extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient n f3213d;
    public final transient m e;

    public l(n nVar, m mVar) {
        this.f3213d = nVar;
        this.e = mVar;
    }

    @Override // V1.g, V1.a
    public final e a() {
        return this.e;
    }

    @Override // V1.a
    public final int b(int i, Object[] objArr) {
        return this.e.b(i, objArr);
    }

    @Override // V1.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f3213d.get(obj) != null;
    }

    @Override // V1.a
    public final boolean k() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final s iterator() {
        return this.e.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f3213d.f3221f;
    }
}
