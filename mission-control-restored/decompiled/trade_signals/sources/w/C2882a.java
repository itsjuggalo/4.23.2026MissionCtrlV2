package w;

import java.lang.reflect.Array;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import x.AbstractC2939a;

/* JADX INFO: renamed from: w.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2882a extends i implements Map {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public C0418a f23945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public c f23946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f23947f;

    /* JADX INFO: renamed from: w.a$a, reason: collision with other inner class name */
    public final class C0418a extends AbstractSet {
        public C0418a() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return C2882a.this.new d();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return C2882a.this.size();
        }
    }

    /* JADX INFO: renamed from: w.a$b */
    public final class b extends w.e {
        public b() {
            super(C2882a.this.size());
        }

        @Override // w.e
        public Object c(int i8) {
            return C2882a.this.f(i8);
        }

        @Override // w.e
        public void d(int i8) {
            C2882a.this.h(i8);
        }
    }

    /* JADX INFO: renamed from: w.a$c */
    public final class c implements Set {
        public c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            C2882a.this.clear();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return C2882a.this.containsKey(obj);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection collection) {
            return C2882a.this.k(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return C2882a.l(this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int iHashCode = 0;
            for (int size = C2882a.this.size() - 1; size >= 0; size--) {
                Object objF = C2882a.this.f(size);
                iHashCode += objF == null ? 0 : objF.hashCode();
            }
            return iHashCode;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return C2882a.this.isEmpty();
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return C2882a.this.new b();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int iD = C2882a.this.d(obj);
            if (iD < 0) {
                return false;
            }
            C2882a.this.h(iD);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection collection) {
            return C2882a.this.m(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection collection) {
            return C2882a.this.n(collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return C2882a.this.size();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            int size = C2882a.this.size();
            Object[] objArr = new Object[size];
            for (int i8 = 0; i8 < size; i8++) {
                objArr[i8] = C2882a.this.f(i8);
            }
            return objArr;
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i8 = 0; i8 < size; i8++) {
                objArr[i8] = C2882a.this.f(i8);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    /* JADX INFO: renamed from: w.a$d */
    public final class d implements Iterator, Map.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23951a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f23952b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f23953c;

        public d() {
            this.f23951a = C2882a.this.size() - 1;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f23952b++;
            this.f23953c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!this.f23953c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractC2939a.c(entry.getKey(), C2882a.this.f(this.f23952b)) && AbstractC2939a.c(entry.getValue(), C2882a.this.j(this.f23952b));
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            if (this.f23953c) {
                return C2882a.this.f(this.f23952b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            if (this.f23953c) {
                return C2882a.this.j(this.f23952b);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f23952b < this.f23951a;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.f23953c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objF = C2882a.this.f(this.f23952b);
            Object objJ = C2882a.this.j(this.f23952b);
            return (objF == null ? 0 : objF.hashCode()) ^ (objJ != null ? objJ.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f23953c) {
                throw new IllegalStateException();
            }
            C2882a.this.h(this.f23952b);
            this.f23952b--;
            this.f23951a--;
            this.f23953c = false;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            if (this.f23953c) {
                return C2882a.this.i(this.f23952b, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + com.amazon.a.a.o.b.f.f14101b + getValue();
        }
    }

    /* JADX INFO: renamed from: w.a$e */
    public final class e implements Collection {
        public e() {
        }

        @Override // java.util.Collection
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            C2882a.this.clear();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return C2882a.this.a(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return C2882a.this.isEmpty();
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return C2882a.this.new f();
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int iA = C2882a.this.a(obj);
            if (iA < 0) {
                return false;
            }
            C2882a.this.h(iA);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection collection) {
            int size = C2882a.this.size();
            int i8 = 0;
            boolean z7 = false;
            while (i8 < size) {
                if (collection.contains(C2882a.this.j(i8))) {
                    C2882a.this.h(i8);
                    i8--;
                    size--;
                    z7 = true;
                }
                i8++;
            }
            return z7;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection collection) {
            int size = C2882a.this.size();
            int i8 = 0;
            boolean z7 = false;
            while (i8 < size) {
                if (!collection.contains(C2882a.this.j(i8))) {
                    C2882a.this.h(i8);
                    i8--;
                    size--;
                    z7 = true;
                }
                i8++;
            }
            return z7;
        }

        @Override // java.util.Collection
        public int size() {
            return C2882a.this.size();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            int size = C2882a.this.size();
            Object[] objArr = new Object[size];
            for (int i8 = 0; i8 < size; i8++) {
                objArr[i8] = C2882a.this.j(i8);
            }
            return objArr;
        }

        @Override // java.util.Collection
        public Object[] toArray(Object[] objArr) {
            int size = size();
            if (objArr.length < size) {
                objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
            }
            for (int i8 = 0; i8 < size; i8++) {
                objArr[i8] = C2882a.this.j(i8);
            }
            if (objArr.length > size) {
                objArr[size] = null;
            }
            return objArr;
        }
    }

    /* JADX INFO: renamed from: w.a$f */
    public final class f extends w.e {
        public f() {
            super(C2882a.this.size());
        }

        @Override // w.e
        public Object c(int i8) {
            return C2882a.this.j(i8);
        }

        @Override // w.e
        public void d(int i8) {
            C2882a.this.h(i8);
        }
    }

    public C2882a() {
    }

    public static boolean l(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // w.i, java.util.Map
    public boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // w.i, java.util.Map
    public boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // java.util.Map
    public Set entrySet() {
        C0418a c0418a = this.f23945d;
        if (c0418a != null) {
            return c0418a;
        }
        C0418a c0418a2 = new C0418a();
        this.f23945d = c0418a2;
        return c0418a2;
    }

    @Override // w.i, java.util.Map
    public Object get(Object obj) {
        return super.get(obj);
    }

    public boolean k(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Map
    public Set keySet() {
        c cVar = this.f23946e;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        this.f23946e = cVar2;
        return cVar2;
    }

    public boolean m(Collection collection) {
        int size = size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return size != size();
    }

    public boolean n(Collection collection) {
        int size = size();
        for (int size2 = size() - 1; size2 >= 0; size2--) {
            if (!collection.contains(f(size2))) {
                h(size2);
            }
        }
        return size != size();
    }

    @Override // java.util.Map
    public void putAll(Map map) {
        b(size() + map.size());
        for (Map.Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // w.i, java.util.Map
    public Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // java.util.Map
    public Collection values() {
        e eVar = this.f23947f;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e();
        this.f23947f = eVar2;
        return eVar2;
    }

    public C2882a(int i8) {
        super(i8);
    }

    public C2882a(i iVar) {
        super(iVar);
    }
}
