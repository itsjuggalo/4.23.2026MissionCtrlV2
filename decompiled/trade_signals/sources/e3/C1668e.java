package e3;

import e3.AbstractC1666c;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: e3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1668e implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1666c f17156a;

    /* JADX INFO: renamed from: e3.e$a */
    public static class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f17157a;

        public a(Iterator it) {
            this.f17157a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f17157a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return ((Map.Entry) this.f17157a.next()).getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f17157a.remove();
        }
    }

    public C1668e(AbstractC1666c abstractC1666c) {
        this.f17156a = abstractC1666c;
    }

    public Iterator E() {
        return new a(this.f17156a.E());
    }

    public Object a() {
        return this.f17156a.f();
    }

    public Object d() {
        return this.f17156a.h();
    }

    public Object e(Object obj) {
        return this.f17156a.n(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C1668e) {
            return this.f17156a.equals(((C1668e) obj).f17156a);
        }
        return false;
    }

    public C1668e f(Object obj) {
        return new C1668e(this.f17156a.F(obj, null));
    }

    public C1668e h(Object obj) {
        AbstractC1666c abstractC1666cH = this.f17156a.H(obj);
        return abstractC1666cH == this.f17156a ? this : new C1668e(abstractC1666cH);
    }

    public int hashCode() {
        return this.f17156a.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a(this.f17156a.iterator());
    }

    public C1668e(List list, Comparator comparator) {
        this.f17156a = AbstractC1666c.a.b(list, Collections.emptyMap(), AbstractC1666c.a.e(), comparator);
    }
}
