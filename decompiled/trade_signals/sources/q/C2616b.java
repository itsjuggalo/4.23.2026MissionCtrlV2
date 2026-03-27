package q;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: q.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2616b implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f22493a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c f22494b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap f22495c = new WeakHashMap();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f22496d = 0;

    /* JADX INFO: renamed from: q.b$a */
    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // q.C2616b.e
        public c c(c cVar) {
            return cVar.f22500d;
        }

        @Override // q.C2616b.e
        public c d(c cVar) {
            return cVar.f22499c;
        }
    }

    /* JADX INFO: renamed from: q.b$b, reason: collision with other inner class name */
    public static class C0379b extends e {
        public C0379b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override // q.C2616b.e
        public c c(c cVar) {
            return cVar.f22499c;
        }

        @Override // q.C2616b.e
        public c d(c cVar) {
            return cVar.f22500d;
        }
    }

    /* JADX INFO: renamed from: q.b$c */
    public static class c implements Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f22497a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Object f22498b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public c f22499c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public c f22500d;

        public c(Object obj, Object obj2) {
            this.f22497a = obj;
            this.f22498b = obj2;
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
            return this.f22497a.equals(cVar.f22497a) && this.f22498b.equals(cVar.f22498b);
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f22497a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f22498b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f22497a.hashCode() ^ this.f22498b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f22497a + com.amazon.a.a.o.b.f.f14101b + this.f22498b;
        }
    }

    /* JADX INFO: renamed from: q.b$d */
    public class d extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f22501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f22502b = true;

        public d() {
        }

        @Override // q.C2616b.f
        public void b(c cVar) {
            c cVar2 = this.f22501a;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f22500d;
                this.f22501a = cVar3;
                this.f22502b = cVar3 == null;
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar;
            if (this.f22502b) {
                this.f22502b = false;
                cVar = C2616b.this.f22493a;
            } else {
                c cVar2 = this.f22501a;
                cVar = cVar2 != null ? cVar2.f22499c : null;
            }
            this.f22501a = cVar;
            return this.f22501a;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f22502b) {
                return C2616b.this.f22493a != null;
            }
            c cVar = this.f22501a;
            return (cVar == null || cVar.f22499c == null) ? false : true;
        }
    }

    /* JADX INFO: renamed from: q.b$e */
    public static abstract class e extends f implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f22504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public c f22505b;

        public e(c cVar, c cVar2) {
            this.f22504a = cVar2;
            this.f22505b = cVar;
        }

        @Override // q.C2616b.f
        public void b(c cVar) {
            if (this.f22504a == cVar && cVar == this.f22505b) {
                this.f22505b = null;
                this.f22504a = null;
            }
            c cVar2 = this.f22504a;
            if (cVar2 == cVar) {
                this.f22504a = c(cVar2);
            }
            if (this.f22505b == cVar) {
                this.f22505b = f();
            }
        }

        public abstract c c(c cVar);

        public abstract c d(c cVar);

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            c cVar = this.f22505b;
            this.f22505b = f();
            return cVar;
        }

        public final c f() {
            c cVar = this.f22505b;
            c cVar2 = this.f22504a;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return d(cVar);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22505b != null;
        }
    }

    /* JADX INFO: renamed from: q.b$f */
    public static abstract class f {
        public abstract void b(c cVar);
    }

    public Object C(Object obj) {
        c cVarD = d(obj);
        if (cVarD == null) {
            return null;
        }
        this.f22496d--;
        if (!this.f22495c.isEmpty()) {
            Iterator it = this.f22495c.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(cVarD);
            }
        }
        c cVar = cVarD.f22500d;
        c cVar2 = cVarD.f22499c;
        if (cVar != null) {
            cVar.f22499c = cVar2;
        } else {
            this.f22493a = cVar2;
        }
        c cVar3 = cVarD.f22499c;
        if (cVar3 != null) {
            cVar3.f22500d = cVar;
        } else {
            this.f22494b = cVar;
        }
        cVarD.f22499c = null;
        cVarD.f22500d = null;
        return cVarD.f22498b;
    }

    public Map.Entry a() {
        return this.f22493a;
    }

    public c d(Object obj) {
        c cVar = this.f22493a;
        while (cVar != null && !cVar.f22497a.equals(obj)) {
            cVar = cVar.f22499c;
        }
        return cVar;
    }

    public Iterator descendingIterator() {
        C0379b c0379b = new C0379b(this.f22494b, this.f22493a);
        this.f22495c.put(c0379b, Boolean.FALSE);
        return c0379b;
    }

    public d e() {
        d dVar = new d();
        this.f22495c.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2616b)) {
            return false;
        }
        C2616b c2616b = (C2616b) obj;
        if (size() != c2616b.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c2616b.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public Map.Entry f() {
        return this.f22494b;
    }

    public c h(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f22496d++;
        c cVar2 = this.f22494b;
        if (cVar2 == null) {
            this.f22493a = cVar;
        } else {
            cVar2.f22499c = cVar;
            cVar.f22500d = cVar2;
        }
        this.f22494b = cVar;
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
        a aVar = new a(this.f22493a, this.f22494b);
        this.f22495c.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Object n(Object obj, Object obj2) {
        c cVarD = d(obj);
        if (cVarD != null) {
            return cVarD.f22498b;
        }
        h(obj, obj2);
        return null;
    }

    public int size() {
        return this.f22496d;
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
