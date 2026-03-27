package q5;

import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2583e;

/* JADX INFO: renamed from: q5.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2640g extends AbstractC2583e implements Collection, C5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2637d f22643a;

    public C2640g(C2637d backing) {
        AbstractC2304t.f(backing, "backing");
        this.f22643a = backing;
    }

    @Override // p5.AbstractC2583e
    public int a() {
        return this.f22643a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.f22643a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.f22643a.containsValue(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.f22643a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f22643a.Q();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean remove(Object obj) {
        return this.f22643a.O(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean removeAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        this.f22643a.m();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean retainAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        this.f22643a.m();
        return super.retainAll(elements);
    }
}
