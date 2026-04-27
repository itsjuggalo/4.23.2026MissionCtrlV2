package X2;

import j3.InterfaceC1564a;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC1577b;
import kotlin.jvm.internal.AbstractC1584i;

/* JADX INFO: renamed from: X2.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0759f implements Collection, InterfaceC1564a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f5612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f5613b;

    public C0759f(Object[] values, boolean z4) {
        kotlin.jvm.internal.r.f(values, "values");
        this.f5612a = values;
        this.f5613b = z4;
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
        return AbstractC0765l.q(this.f5612a, obj);
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

    public int f() {
        return this.f5612a.length;
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return this.f5612a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return AbstractC1577b.a(this.f5612a);
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
        return f();
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC1584i.b(this, array);
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        return AbstractC0768o.a(this.f5612a, this.f5613b);
    }
}
