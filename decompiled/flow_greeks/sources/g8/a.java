package g8;

import g8.c;
import g8.h;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f10104a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f10105b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparator f10106c;

    /* JADX INFO: renamed from: g8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0182a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10107a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f10108b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f10109c;

        public C0182a(int i10, boolean z10) {
            this.f10108b = i10;
            this.f10109c = z10;
            this.f10107a = i10;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Object obj = a.this.f10104a[this.f10107a];
            Object[] objArr = a.this.f10105b;
            int i10 = this.f10107a;
            Object obj2 = objArr[i10];
            this.f10107a = this.f10109c ? i10 - 1 : i10 + 1;
            return new AbstractMap.SimpleImmutableEntry(obj, obj2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f10109c ? this.f10107a >= 0 : this.f10107a < a.this.f10104a.length;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
        }
    }

    public a(Comparator comparator) {
        this.f10104a = new Object[0];
        this.f10105b = new Object[0];
        this.f10106c = comparator;
    }

    public static a K(Map map, Comparator comparator) {
        return y(new ArrayList(map.keySet()), map, c.a.e(), comparator);
    }

    public static Object[] R(Object[] objArr, int i10) {
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        System.arraycopy(objArr, i10 + 1, objArr2, i10, length - i10);
        return objArr2;
    }

    public static Object[] S(Object[] objArr, int i10, Object obj) {
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        objArr2[i10] = obj;
        return objArr2;
    }

    public static Object[] w(Object[] objArr, int i10, Object obj) {
        Object[] objArr2 = new Object[objArr.length + 1];
        System.arraycopy(objArr, 0, objArr2, 0, i10);
        objArr2[i10] = obj;
        System.arraycopy(objArr, i10, objArr2, i10 + 1, (r0 - i10) - 1);
        return objArr2;
    }

    public static a y(List list, Map map, c.a.InterfaceC0183a interfaceC0183a, Comparator comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i10 = 0;
        for (Object obj : list) {
            objArr[i10] = obj;
            objArr2[i10] = map.get(interfaceC0183a.a(obj));
            i10++;
        }
        return new a(comparator, objArr, objArr2);
    }

    public final int A(Object obj) {
        int i10 = 0;
        for (Object obj2 : this.f10104a) {
            if (this.f10106c.compare(obj, obj2) == 0) {
                return i10;
            }
            i10++;
        }
        return -1;
    }

    public final int G(Object obj) {
        int i10 = 0;
        while (true) {
            Object[] objArr = this.f10104a;
            if (i10 >= objArr.length || this.f10106c.compare(objArr[i10], obj) >= 0) {
                break;
            }
            i10++;
        }
        return i10;
    }

    public final Iterator L(int i10, boolean z10) {
        return new C0182a(i10, z10);
    }

    @Override // g8.c
    public Iterator P() {
        return L(this.f10104a.length - 1, true);
    }

    @Override // g8.c
    public boolean a(Object obj) {
        return A(obj) != -1;
    }

    @Override // g8.c
    public Object c(Object obj) {
        int iA = A(obj);
        if (iA != -1) {
            return this.f10105b[iA];
        }
        return null;
    }

    @Override // g8.c
    public Comparator d() {
        return this.f10106c;
    }

    @Override // g8.c
    public Object e() {
        Object[] objArr = this.f10104a;
        if (objArr.length > 0) {
            return objArr[objArr.length - 1];
        }
        return null;
    }

    @Override // g8.c
    public Object f() {
        Object[] objArr = this.f10104a;
        if (objArr.length > 0) {
            return objArr[0];
        }
        return null;
    }

    @Override // g8.c
    public Object g(Object obj) {
        int iA = A(obj);
        if (iA == -1) {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        }
        if (iA > 0) {
            return this.f10104a[iA - 1];
        }
        return null;
    }

    @Override // g8.c
    public int indexOf(Object obj) {
        return A(obj);
    }

    @Override // g8.c
    public boolean isEmpty() {
        return this.f10104a.length == 0;
    }

    @Override // g8.c, java.lang.Iterable
    public Iterator iterator() {
        return L(0, false);
    }

    @Override // g8.c
    public void p(h.b bVar) {
        int i10 = 0;
        while (true) {
            Object[] objArr = this.f10104a;
            if (i10 >= objArr.length) {
                return;
            }
            bVar.a(objArr[i10], this.f10105b[i10]);
            i10++;
        }
    }

    @Override // g8.c
    public c q(Object obj, Object obj2) {
        int iA = A(obj);
        if (iA != -1) {
            Object[] objArr = this.f10104a;
            if (objArr[iA] == obj && this.f10105b[iA] == obj2) {
                return this;
            }
            return new a(this.f10106c, S(objArr, iA, obj), S(this.f10105b, iA, obj2));
        }
        if (this.f10104a.length <= 25) {
            int iG = G(obj);
            return new a(this.f10106c, w(this.f10104a, iG, obj), w(this.f10105b, iG, obj2));
        }
        HashMap map = new HashMap(this.f10104a.length + 1);
        int i10 = 0;
        while (true) {
            Object[] objArr2 = this.f10104a;
            if (i10 >= objArr2.length) {
                map.put(obj, obj2);
                return k.v(map, this.f10106c);
            }
            map.put(objArr2[i10], this.f10105b[i10]);
            i10++;
        }
    }

    @Override // g8.c
    public Iterator r(Object obj) {
        return L(G(obj), false);
    }

    @Override // g8.c
    public c s(Object obj) {
        int iA = A(obj);
        if (iA == -1) {
            return this;
        }
        return new a(this.f10106c, R(this.f10104a, iA), R(this.f10105b, iA));
    }

    @Override // g8.c
    public int size() {
        return this.f10104a.length;
    }

    public a(Comparator comparator, Object[] objArr, Object[] objArr2) {
        this.f10104a = objArr;
        this.f10105b = objArr2;
        this.f10106c = comparator;
    }
}
