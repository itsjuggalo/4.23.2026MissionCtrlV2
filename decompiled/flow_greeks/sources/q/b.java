package q;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f18688a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f18689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap f18690c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18691d = 0;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // q.b.e
        public c c(c cVar) {
            return cVar.f18695d;
        }

        @Override // q.b.e
        public c d(c cVar) {
            return cVar.f18694c;
        }
    }

    /* JADX INFO: renamed from: q.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0318b extends e {
        public C0318b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // q.b.e
        public c c(c cVar) {
            return cVar.f18694c;
        }

        @Override // q.b.e
        public c d(c cVar) {
            return cVar.f18695d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class c implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18692a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f18693b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f18694c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f18695d;

        public c(Object obj, Object obj2) {
            this.f18692a = obj;
            this.f18693b = obj2;
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
            return this.f18692a.equals(cVar.f18692a) && this.f18693b.equals(cVar.f18693b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f18692a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f18693b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f18692a.hashCode() ^ this.f18693b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f18692a + com.amazon.a.a.o.b.f.f4599b + this.f18693b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f18696a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f18697b = true;

        public d() {
        }

        @Override // q.b.f
        public void b(c cVar) {
            c cVar2 = this.f18696a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f18695d;
                this.f18696a = cVar3;
                this.f18697b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (this.f18697b) {
                this.f18697b = false;
                this.f18696a = b.this.f18688a;
            } else {
                c cVar = this.f18696a;
                this.f18696a = cVar != null ? cVar.f18694c : null;
            }
            return this.f18696a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f18697b) {
                return b.this.f18688a != null;
            }
            c cVar = this.f18696a;
            return (cVar == null || cVar.f18694c == null) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class e extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f18699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f18700b;

        public e(c cVar, c cVar2) {
            this.f18699a = cVar2;
            this.f18700b = cVar;
        }

        @Override // q.b.f
        public void b(c cVar) {
            if (this.f18699a == cVar && cVar == this.f18700b) {
                this.f18700b = null;
                this.f18699a = null;
            }
            c cVar2 = this.f18699a;
            if (cVar2 == cVar) {
                this.f18699a = c(cVar2);
            }
            if (this.f18700b == cVar) {
                this.f18700b = f();
            }
        }

        public abstract c c(c cVar);

        public abstract c d(c cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f18700b;
            this.f18700b = f();
            return cVar;
        }

        public final c f() {
            c cVar = this.f18700b;
            c cVar2 = this.f18699a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f18700b != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class f {
        public abstract void b(c cVar);
    }

    public Map.Entry a() {
        return this.f18688a;
    }

    public c c(Object obj) {
        c cVar = this.f18688a;
        while (cVar != null && !cVar.f18692a.equals(obj)) {
            cVar = cVar.f18694c;
        }
        return cVar;
    }

    public d d() {
        d dVar = new d();
        this.f18690c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Iterator descendingIterator() {
        C0318b c0318b = new C0318b(this.f18689b, this.f18688a);
        this.f18690c.put(c0318b, Boolean.FALSE);
        return c0318b;
    }

    public Map.Entry e() {
        return this.f18689b;
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

    public c f(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f18691d++;
        c cVar2 = this.f18689b;
        if (cVar2 == null) {
            this.f18688a = cVar;
            this.f18689b = cVar;
            return cVar;
        }
        cVar2.f18694c = cVar;
        cVar.f18695d = cVar2;
        this.f18689b = cVar;
        return cVar;
    }

    public Object g(Object obj, Object obj2) {
        c cVarC = c(obj);
        if (cVarC != null) {
            return cVarC.f18693b;
        }
        f(obj, obj2);
        return null;
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
        a aVar = new a(this.f18688a, this.f18689b);
        this.f18690c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Object p(Object obj) {
        c cVarC = c(obj);
        if (cVarC == null) {
            return null;
        }
        this.f18691d--;
        if (!this.f18690c.isEmpty()) {
            Iterator it = this.f18690c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(cVarC);
            }
        }
        c cVar = cVarC.f18695d;
        if (cVar != null) {
            cVar.f18694c = cVarC.f18694c;
        } else {
            this.f18688a = cVarC.f18694c;
        }
        c cVar2 = cVarC.f18694c;
        if (cVar2 != null) {
            cVar2.f18695d = cVar;
        } else {
            this.f18689b = cVar;
        }
        cVarC.f18694c = null;
        cVarC.f18695d = null;
        return cVarC.f18693b;
    }

    public int size() {
        return this.f18691d;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb2.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }
}
