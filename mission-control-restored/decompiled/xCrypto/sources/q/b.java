package q;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class b implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f14151a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f14152b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap f14153c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f14154d = 0;

    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // q.b.e
        public c c(c cVar) {
            return cVar.f14158d;
        }

        @Override // q.b.e
        public c d(c cVar) {
            return cVar.f14157c;
        }
    }

    /* JADX INFO: renamed from: q.b$b, reason: collision with other inner class name */
    public static class C0228b extends e {
        public C0228b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // q.b.e
        public c c(c cVar) {
            return cVar.f14157c;
        }

        @Override // q.b.e
        public c d(c cVar) {
            return cVar.f14158d;
        }
    }

    public static class c implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f14155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f14156b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f14157c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f14158d;

        public c(Object obj, Object obj2) {
            this.f14155a = obj;
            this.f14156b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f14155a.equals(cVar.f14155a) && this.f14156b.equals(cVar.f14156b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f14155a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f14156b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f14155a.hashCode() ^ this.f14156b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f14155a + com.amazon.a.a.o.b.f.f8805b + this.f14156b;
        }
    }

    public class d extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f14159a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f14160b = true;

        public d() {
        }

        @Override // q.b.f
        public void b(c cVar) {
            c cVar2 = this.f14159a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f14158d;
                this.f14159a = cVar3;
                this.f14160b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f14160b) {
                this.f14160b = false;
                this.f14159a = b.this.f14151a;
            } else {
                c cVar = this.f14159a;
                this.f14159a = cVar != null ? cVar.f14157c : null;
            }
            return this.f14159a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f14160b) {
                return b.this.f14151a != null;
            }
            c cVar = this.f14159a;
            return (cVar == null || cVar.f14157c == null) ? false : true;
        }
    }

    public static abstract class e extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f14162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f14163b;

        public e(c cVar, c cVar2) {
            this.f14162a = cVar2;
            this.f14163b = cVar;
        }

        @Override // q.b.f
        public void b(c cVar) {
            if (this.f14162a == cVar && cVar == this.f14163b) {
                this.f14163b = null;
                this.f14162a = null;
            }
            c cVar2 = this.f14162a;
            if (cVar2 == cVar) {
                this.f14162a = c(cVar2);
            }
            if (this.f14163b == cVar) {
                this.f14163b = f();
            }
        }

        public abstract c c(c cVar);

        public abstract c d(c cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f14163b;
            this.f14163b = f();
            return cVar;
        }

        public final c f() {
            c cVar = this.f14163b;
            c cVar2 = this.f14162a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14163b != null;
        }
    }

    public static abstract class f {
        public abstract void b(c cVar);
    }

    public Map.Entry c() {
        return this.f14151a;
    }

    public Iterator descendingIterator() {
        C0228b c0228b = new C0228b(this.f14152b, this.f14151a);
        this.f14153c.put(c0228b, Boolean.FALSE);
        return c0228b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (size() != bVar.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = bVar.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public c f(Object obj) {
        c cVar = this.f14151a;
        while (cVar != null && !cVar.f14155a.equals(obj)) {
            cVar = cVar.f14157c;
        }
        return cVar;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    public d i() {
        d dVar = new d();
        this.f14153c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f14151a, this.f14152b);
        this.f14153c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Map.Entry k() {
        return this.f14152b;
    }

    public c l(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f14154d++;
        c cVar2 = this.f14152b;
        if (cVar2 == null) {
            this.f14151a = cVar;
            this.f14152b = cVar;
            return cVar;
        }
        cVar2.f14157c = cVar;
        cVar.f14158d = cVar2;
        this.f14152b = cVar;
        return cVar;
    }

    public Object m(Object obj, Object obj2) {
        c cVarF = f(obj);
        if (cVarF != null) {
            return cVarF.f14156b;
        }
        l(obj, obj2);
        return null;
    }

    public Object n(Object obj) {
        c cVarF = f(obj);
        if (cVarF == null) {
            return null;
        }
        this.f14154d--;
        if (!this.f14153c.isEmpty()) {
            Iterator it = this.f14153c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(cVarF);
            }
        }
        c cVar = cVarF.f14158d;
        if (cVar != null) {
            cVar.f14157c = cVarF.f14157c;
        } else {
            this.f14151a = cVarF.f14157c;
        }
        c cVar2 = cVarF.f14157c;
        if (cVar2 != null) {
            cVar2.f14158d = cVar;
        } else {
            this.f14152b = cVar;
        }
        cVarF.f14157c = null;
        cVarF.f14158d = null;
        return cVarF.f14156b;
    }

    public int size() {
        return this.f14154d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
