package K3;

import j3.InterfaceC1564a;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.jvm.internal.AbstractC1584i;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends h implements List<h>, InterfaceC1564a {
    public static final a Companion = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f1330a;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final F3.b serializer() {
            return c.f1331a;
        }

        public a() {
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(List content) {
        super(null);
        kotlin.jvm.internal.r.f(content, "content");
        this.f1330a = content;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i4, h hVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i4, Collection<? extends h> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof h) {
            return f((h) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection elements) {
        kotlin.jvm.internal.r.f(elements, "elements");
        return this.f1330a.containsAll(elements);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        return kotlin.jvm.internal.r.b(this.f1330a, obj);
    }

    public boolean f(h element) {
        kotlin.jvm.internal.r.f(element, "element");
        return this.f1330a.contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        return this.f1330a.hashCode();
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public h get(int i4) {
        return (h) this.f1330a.get(i4);
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof h) {
            return l((h) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f1330a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f1330a.iterator();
    }

    public int k() {
        return this.f1330a.size();
    }

    public int l(h element) {
        kotlin.jvm.internal.r.f(element, "element");
        return this.f1330a.indexOf(element);
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof h) {
            return m((h) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<h> listIterator() {
        return this.f1330a.listIterator();
    }

    public int m(h element) {
        kotlin.jvm.internal.r.f(element, "element");
        return this.f1330a.lastIndexOf(element);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ h remove(int i4) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<h> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ h set(int i4, h hVar) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return k();
    }

    @Override // java.util.List
    public void sort(Comparator<? super h> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<h> subList(int i4, int i5) {
        return this.f1330a.subList(i4, i5);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return AbstractC1584i.a(this);
    }

    public String toString() {
        return X2.x.Q(this.f1330a, com.amazon.a.a.o.b.f.f8804a, "[", "]", 0, null, null, 56, null);
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public ListIterator<h> listIterator(int i4) {
        return this.f1330a.listIterator(i4);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] array) {
        kotlin.jvm.internal.r.f(array, "array");
        return AbstractC1584i.b(this, array);
    }
}
