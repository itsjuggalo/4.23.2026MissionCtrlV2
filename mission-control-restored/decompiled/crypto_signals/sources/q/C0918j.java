package q;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: q.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0918j implements Collection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0909a f9132a;

    public C0918j(C0909a c0909a) {
        this.f9132a = c0909a;
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        this.f9132a.a();
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        return this.f9132a.f(obj) >= 0;
    }

    @Override // java.util.Collection
    public final boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        return this.f9132a.d() == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return new C0915g(this.f9132a, 1);
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        C0909a c0909a = this.f9132a;
        int iF = c0909a.f(obj);
        if (iF < 0) {
            return false;
        }
        c0909a.g(iF);
        return true;
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection collection) {
        C0909a c0909a = this.f9132a;
        int iD = c0909a.d();
        int i = 0;
        boolean z6 = false;
        while (i < iD) {
            if (collection.contains(c0909a.b(i, 1))) {
                c0909a.g(i);
                i--;
                iD--;
                z6 = true;
            }
            i++;
        }
        return z6;
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection collection) {
        C0909a c0909a = this.f9132a;
        int iD = c0909a.d();
        int i = 0;
        boolean z6 = false;
        while (i < iD) {
            if (!collection.contains(c0909a.b(i, 1))) {
                c0909a.g(i);
                i--;
                iD--;
                z6 = true;
            }
            i++;
        }
        return z6;
    }

    @Override // java.util.Collection
    public final int size() {
        return this.f9132a.d();
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        C0909a c0909a = this.f9132a;
        int iD = c0909a.d();
        Object[] objArr = new Object[iD];
        for (int i = 0; i < iD; i++) {
            objArr[i] = c0909a.b(i, 1);
        }
        return objArr;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return this.f9132a.i(1, objArr);
    }
}
