package p5;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2288c;
import kotlin.jvm.internal.AbstractC2295j;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p5.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2586h implements Collection, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f22383a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f22384b;

    public C2586h(Object[] values, boolean z7) {
        AbstractC2304t.f(values, "values");
        this.f22383a = values;
        this.f22384b = z7;
    }

    public int a() {
        return this.f22383a.length;
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
        return AbstractC2592n.x(this.f22383a, obj);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
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
        return this.f22383a.length == 0;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return AbstractC2288c.a(this.f22383a);
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
    public final Object[] toArray() {
        return AbstractC2594p.b(this.f22383a, this.f22384b);
    }

    @Override // java.util.Collection
    public Object[] toArray(Object[] array) {
        AbstractC2304t.f(array, "array");
        return AbstractC2295j.b(this, array);
    }
}
