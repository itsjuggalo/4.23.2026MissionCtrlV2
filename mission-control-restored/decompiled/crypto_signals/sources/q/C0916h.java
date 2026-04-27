package q;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: renamed from: q.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0916h implements Set {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9126a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0909a f9127b;

    public /* synthetic */ C0916h(C0909a c0909a, int i) {
        this.f9126a = i;
        this.f9127b = c0909a;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.f9126a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.f9126a) {
            case 0:
                C0909a c0909a = this.f9127b;
                int iD = c0909a.d();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    switch (c0909a.f9105d) {
                        case 0:
                            ((C0910b) c0909a.e).put(key, value);
                            break;
                        default:
                            ((C0911c) c0909a.e).add(key);
                            break;
                    }
                }
                return iD != c0909a.d();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final void clear() {
        switch (this.f9126a) {
            case 0:
                this.f9127b.a();
                break;
            default:
                this.f9127b.a();
                break;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean contains(Object obj) {
        switch (this.f9126a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                C0909a c0909a = this.f9127b;
                int iE = c0909a.e(key);
                if (iE < 0) {
                    return false;
                }
                Object objB = c0909a.b(iE, 1);
                Object value = entry.getValue();
                return objB == value || (objB != null && objB.equals(value));
            default:
                return this.f9127b.e(obj) >= 0;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean containsAll(Collection collection) {
        switch (this.f9126a) {
            case 0:
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    if (!contains(it.next())) {
                        break;
                    }
                }
                break;
            default:
                Map mapC = this.f9127b.c();
                Iterator it2 = collection.iterator();
                while (it2.hasNext()) {
                    if (!mapC.containsKey(it2.next())) {
                        break;
                    }
                }
                break;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean equals(Object obj) {
        switch (this.f9126a) {
        }
        return C0909a.h(this, obj);
    }

    @Override // java.util.Set, java.util.Collection
    public final int hashCode() {
        switch (this.f9126a) {
            case 0:
                C0909a c0909a = this.f9127b;
                int iHashCode = 0;
                for (int iD = c0909a.d() - 1; iD >= 0; iD--) {
                    Object objB = c0909a.b(iD, 0);
                    Object objB2 = c0909a.b(iD, 1);
                    iHashCode += (objB == null ? 0 : objB.hashCode()) ^ (objB2 == null ? 0 : objB2.hashCode());
                }
                return iHashCode;
            default:
                C0909a c0909a2 = this.f9127b;
                int iHashCode2 = 0;
                for (int iD2 = c0909a2.d() - 1; iD2 >= 0; iD2--) {
                    Object objB3 = c0909a2.b(iD2, 0);
                    iHashCode2 += objB3 == null ? 0 : objB3.hashCode();
                }
                return iHashCode2;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean isEmpty() {
        switch (this.f9126a) {
            case 0:
                if (this.f9127b.d() == 0) {
                }
                break;
            default:
                if (this.f9127b.d() == 0) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f9126a) {
            case 0:
                return new C0917i(this.f9127b);
            default:
                return new C0915g(this.f9127b, 0);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.f9126a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                C0909a c0909a = this.f9127b;
                int iE = c0909a.e(obj);
                if (iE < 0) {
                    return false;
                }
                c0909a.g(iE);
                return true;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.f9126a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Map mapC = this.f9127b.c();
                int size = mapC.size();
                Iterator it = collection.iterator();
                while (it.hasNext()) {
                    mapC.remove(it.next());
                }
                return size != mapC.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.f9126a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                Map mapC = this.f9127b.c();
                int size = mapC.size();
                Iterator it = mapC.keySet().iterator();
                while (it.hasNext()) {
                    if (!collection.contains(it.next())) {
                        it.remove();
                    }
                }
                return size != mapC.size();
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final int size() {
        switch (this.f9126a) {
        }
        return this.f9127b.d();
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.f9126a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                return this.f9127b.i(0, objArr);
        }
    }

    @Override // java.util.Set, java.util.Collection
    public final Object[] toArray() {
        switch (this.f9126a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                C0909a c0909a = this.f9127b;
                int iD = c0909a.d();
                Object[] objArr = new Object[iD];
                for (int i = 0; i < iD; i++) {
                    objArr[i] = c0909a.b(i, 0);
                }
                return objArr;
        }
    }
}
