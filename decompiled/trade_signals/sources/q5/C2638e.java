package q5;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: q5.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2638e extends AbstractC2634a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2637d f22641a;

    public C2638e(C2637d backing) {
        AbstractC2304t.f(backing, "backing");
        this.f22641a = backing;
    }

    @Override // p5.AbstractC2585g
    public int a() {
        return this.f22641a.size();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.f22641a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        return this.f22641a.o(elements);
    }

    @Override // q5.AbstractC2634a
    public boolean e(Map.Entry element) {
        AbstractC2304t.f(element, "element");
        return this.f22641a.p(element);
    }

    @Override // q5.AbstractC2634a
    public boolean f(Map.Entry element) {
        AbstractC2304t.f(element, "element");
        return this.f22641a.K(element);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean add(Map.Entry element) {
        AbstractC2304t.f(element, "element");
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this.f22641a.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return this.f22641a.u();
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        this.f22641a.m();
        return super.removeAll(elements);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        this.f22641a.m();
        return super.retainAll(elements);
    }
}
