package r;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: r.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2571b implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f22340a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f22341b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap f22342c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22343d = 0;

    /* JADX INFO: renamed from: r.b$a */
    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // r.C2571b.e
        public c c(c cVar) {
            return cVar.f22347d;
        }

        @Override // r.C2571b.e
        public c d(c cVar) {
            return cVar.f22346c;
        }
    }

    /* JADX INFO: renamed from: r.b$b, reason: collision with other inner class name */
    public static class C0340b extends e {
        public C0340b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // r.C2571b.e
        public c c(c cVar) {
            return cVar.f22346c;
        }

        @Override // r.C2571b.e
        public c d(c cVar) {
            return cVar.f22347d;
        }
    }

    /* JADX INFO: renamed from: r.b$c */
    public static class c implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f22344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f22345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f22346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f22347d;

        public c(Object obj, Object obj2) {
            this.f22344a = obj;
            this.f22345b = obj2;
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
            return this.f22344a.equals(cVar.f22344a) && this.f22345b.equals(cVar.f22345b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f22344a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f22345b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f22344a.hashCode() ^ this.f22345b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f22344a + com.amazon.a.a.o.b.f.f9990b + this.f22345b;
        }
    }

    /* JADX INFO: renamed from: r.b$d */
    public class d extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f22348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22349b = true;

        public d() {
        }

        @Override // r.C2571b.f
        public void b(c cVar) {
            c cVar2 = this.f22348a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f22347d;
                this.f22348a = cVar3;
                this.f22349b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f22349b) {
                this.f22349b = false;
                this.f22348a = C2571b.this.f22340a;
            } else {
                c cVar = this.f22348a;
                this.f22348a = cVar != null ? cVar.f22346c : null;
            }
            return this.f22348a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f22349b) {
                return C2571b.this.f22340a != null;
            }
            c cVar = this.f22348a;
            return (cVar == null || cVar.f22346c == null) ? false : true;
        }
    }

    /* JADX INFO: renamed from: r.b$e */
    public static abstract class e extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f22351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f22352b;

        public e(c cVar, c cVar2) {
            this.f22351a = cVar2;
            this.f22352b = cVar;
        }

        @Override // r.C2571b.f
        public void b(c cVar) {
            if (this.f22351a == cVar && cVar == this.f22352b) {
                this.f22352b = null;
                this.f22351a = null;
            }
            c cVar2 = this.f22351a;
            if (cVar2 == cVar) {
                this.f22351a = c(cVar2);
            }
            if (this.f22352b == cVar) {
                this.f22352b = f();
            }
        }

        public abstract c c(c cVar);

        public abstract c d(c cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f22352b;
            this.f22352b = f();
            return cVar;
        }

        public final c f() {
            c cVar = this.f22352b;
            c cVar2 = this.f22351a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22352b != null;
        }
    }

    /* JADX INFO: renamed from: r.b$f */
    public static abstract class f {
        public abstract void b(c cVar);
    }

    public Map.Entry a() {
        return this.f22340a;
    }

    public c b(Object obj) {
        c cVar = this.f22340a;
        while (cVar != null && !cVar.f22344a.equals(obj)) {
            cVar = cVar.f22346c;
        }
        return cVar;
    }

    public d c() {
        d dVar = new d();
        this.f22342c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Iterator descendingIterator() {
        C0340b c0340b = new C0340b(this.f22341b, this.f22340a);
        this.f22342c.put(c0340b, Boolean.FALSE);
        return c0340b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2571b)) {
            return false;
        }
        C2571b c2571b = (C2571b) obj;
        if (size() != c2571b.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c2571b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Map.Entry g() {
        return this.f22341b;
    }

    public c h(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f22343d++;
        c cVar2 = this.f22341b;
        if (cVar2 == null) {
            this.f22340a = cVar;
            this.f22341b = cVar;
            return cVar;
        }
        cVar2.f22346c = cVar;
        cVar.f22347d = cVar2;
        this.f22341b = cVar;
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

    @Override // java.lang.Iterable
    public Iterator iterator() {
        a aVar = new a(this.f22340a, this.f22341b);
        this.f22342c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Object j(Object obj, Object obj2) {
        c cVarB = b(obj);
        if (cVarB != null) {
            return cVarB.f22345b;
        }
        h(obj, obj2);
        return null;
    }

    public Object k(Object obj) {
        c cVarB = b(obj);
        if (cVarB == null) {
            return null;
        }
        this.f22343d--;
        if (!this.f22342c.isEmpty()) {
            Iterator it = this.f22342c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(cVarB);
            }
        }
        c cVar = cVarB.f22347d;
        if (cVar != null) {
            cVar.f22346c = cVarB.f22346c;
        } else {
            this.f22340a = cVarB.f22346c;
        }
        c cVar2 = cVarB.f22346c;
        if (cVar2 != null) {
            cVar2.f22347d = cVar;
        } else {
            this.f22341b = cVar;
        }
        cVarB.f22346c = null;
        cVarB.f22347d = null;
        return cVarB.f22345b;
    }

    public int size() {
        return this.f22343d;
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
