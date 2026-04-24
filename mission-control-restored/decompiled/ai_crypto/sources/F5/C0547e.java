package F5;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2140b;
import kotlin.jvm.internal.AbstractC2147i;

/* JADX INFO: renamed from: F5.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0547e implements Collection, R5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f2374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f2375b;

    public C0547e(Object[] values, boolean z7) {
        kotlin.jvm.internal.r.f(values, "values");
        this.f2374a = values;
        this.f2375b = z7;
    }

    public int a() {
        return this.f2374a.length;
    }

    @Override // java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean contains(Object obj) {
        return AbstractC0552j.p(this.f2374a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        if (elements.isEmpty()) {
            return true;
        }
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f2374a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return AbstractC2140b.a(this.f2374a);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC2147i.b(this, array);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return AbstractC0555m.a(this.f2374a, this.f2375b);
    }
}
