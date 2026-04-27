package q5;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2585g;

/* JADX INFO: renamed from: q5.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2639f extends AbstractC2585g implements Set, C5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2637d f22642a;

    public C2639f(C2637d backing) {
        AbstractC2304t.f(backing, "backing");
        this.f22642a = backing;
    }

    @Override // p5.AbstractC2585g
    public int a() {
        return this.f22642a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f22642a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.f22642a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f22642a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f22642a.E();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        return this.f22642a.N(obj);
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        this.f22642a.m();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        this.f22642a.m();
        return super.retainAll(elements);
    }
}
