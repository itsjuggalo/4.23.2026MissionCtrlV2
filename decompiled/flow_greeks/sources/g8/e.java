package g8;

import g8.c;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f10114a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f10115a;

        public a(Iterator it) {
            this.f10115a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10115a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return ((Map.Entry) this.f10115a.next()).getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f10115a.remove();
        }
    }

    public e(List list, Comparator comparator) {
        this.f10114a = c.a.b(list, Collections.EMPTY_MAP, c.a.e(), comparator);
    }

    public Iterator P() {
        return new a(this.f10114a.P());
    }

    public Object a() {
        return this.f10114a.e();
    }

    public Object c() {
        return this.f10114a.f();
    }

    public boolean contains(Object obj) {
        return this.f10114a.a(obj);
    }

    public Object d(Object obj) {
        return this.f10114a.g(obj);
    }

    public e e(Object obj) {
        return new e(this.f10114a.q(obj, null));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f10114a.equals(((e) obj).f10114a);
        }
        return false;
    }

    public Iterator f(Object obj) {
        return new a(this.f10114a.r(obj));
    }

    public e g(Object obj) {
        c cVarS = this.f10114a.s(obj);
        return cVarS == this.f10114a ? this : new e(cVarS);
    }

    public int hashCode() {
        return this.f10114a.hashCode();
    }

    public int indexOf(Object obj) {
        return this.f10114a.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.f10114a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a(this.f10114a.iterator());
    }

    public e p(e eVar) {
        e eVarE;
        if (size() < eVar.size()) {
            eVarE = eVar;
            eVar = this;
        } else {
            eVarE = this;
        }
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            eVarE = eVarE.e(it.next());
        }
        return eVarE;
    }

    public int size() {
        return this.f10114a.size();
    }

    public e(c cVar) {
        this.f10114a = cVar;
    }
}
