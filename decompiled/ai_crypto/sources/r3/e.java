package r3;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r3.c;

/* JADX INFO: loaded from: classes.dex */
public class e implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f22461a;

    public static class a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f22462a;

        public a(Iterator it) {
            this.f22462a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22462a.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            return ((Map.Entry) this.f22462a.next()).getKey();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f22462a.remove();
        }
    }

    public e(List list, Comparator comparator) {
        this.f22461a = c.a.b(list, Collections.emptyMap(), c.a.d(), comparator);
    }

    public Object a() {
        return this.f22461a.g();
    }

    public Object b() {
        return this.f22461a.h();
    }

    public e c(Object obj) {
        return new e(this.f22461a.j(obj, null));
    }

    public boolean contains(Object obj) {
        return this.f22461a.a(obj);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f22461a.equals(((e) obj).f22461a);
        }
        return false;
    }

    public Iterator g(Object obj) {
        return new a(this.f22461a.k(obj));
    }

    public e h(Object obj) {
        c cVarL = this.f22461a.l(obj);
        return cVarL == this.f22461a ? this : new e(cVarL);
    }

    public int hashCode() {
        return this.f22461a.hashCode();
    }

    public int indexOf(Object obj) {
        return this.f22461a.indexOf(obj);
    }

    public boolean isEmpty() {
        return this.f22461a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a(this.f22461a.iterator());
    }

    public e j(e eVar) {
        e eVarC;
        if (size() < eVar.size()) {
            eVarC = eVar;
            eVar = this;
        } else {
            eVarC = this;
        }
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            eVarC = eVarC.c(it.next());
        }
        return eVarC;
    }

    public int size() {
        return this.f22461a.size();
    }

    public e(c cVar) {
        this.f22461a = cVar;
    }
}
