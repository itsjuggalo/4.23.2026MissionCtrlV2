package V1;

import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class k extends g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final transient n f3211d;
    public final transient Object[] e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final transient int f3212f;

    public k(n nVar, Object[] objArr, int i) {
        this.f3211d = nVar;
        this.e = objArr;
        this.f3212f = i;
    }

    @Override // V1.a
    public final int b(int i, Object[] objArr) {
        return a().b(i, objArr);
    }

    @Override // V1.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.f3211d.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // V1.a
    public final boolean k() {
        return true;
    }

    @Override // V1.g
    public final e n() {
        return new j(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public final s iterator() {
        return a().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f3212f;
    }
}
