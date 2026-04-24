package r3;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import r3.c;

/* JADX INFO: renamed from: r3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2579a extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f22451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f22452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparator f22453c;

    /* JADX INFO: renamed from: r3.a$a, reason: collision with other inner class name */
    public class C0343a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22454a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f22455b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f22456c;

        public C0343a(int i7, boolean z7) {
            this.f22455b = i7;
            this.f22456c = z7;
            this.f22454a = i7;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Object obj = C2579a.this.f22451a[this.f22454a];
            Object[] objArr = C2579a.this.f22452b;
            int i7 = this.f22454a;
            Object obj2 = objArr[i7];
            this.f22454a = this.f22456c ? i7 - 1 : i7 + 1;
            return new AbstractMap.SimpleImmutableEntry(obj, obj2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f22456c) {
                if (this.f22454a < 0) {
                    return false;
                }
            } else if (this.f22454a >= C2579a.this.f22451a.length) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
        }
    }

    public C2579a(Comparator comparator) {
        this.f22451a = new Object[0];
        this.f22452b = new Object[0];
        this.f22453c = comparator;
    }

    public static Object[] p(Object[] objArr, int i7, Object obj) {
        Object[] objArr2 = new Object[objArr.length + 1];
        System.arraycopy(objArr, 0, objArr2, 0, i7);
        objArr2[i7] = obj;
        System.arraycopy(objArr, i7, objArr2, i7 + 1, (r0 - i7) - 1);
        return objArr2;
    }

    public static C2579a q(List list, Map map, c.a.InterfaceC0344a interfaceC0344a, Comparator comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i7 = 0;
        for (Object obj : list) {
            objArr[i7] = obj;
            objArr2[i7] = map.get(interfaceC0344a.a(obj));
            i7++;
        }
        return new C2579a(comparator, objArr, objArr2);
    }

    public static Object[] u(Object[] objArr, int i7) {
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, i7);
        System.arraycopy(objArr, i7 + 1, objArr2, i7, length - i7);
        return objArr2;
    }

    public static Object[] w(Object[] objArr, int i7, Object obj) {
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        objArr2[i7] = obj;
        return objArr2;
    }

    @Override // r3.c
    public boolean a(Object obj) {
        return r(obj) != -1;
    }

    @Override // r3.c
    public Object b(Object obj) {
        int iR = r(obj);
        if (iR != -1) {
            return this.f22452b[iR];
        }
        return null;
    }

    @Override // r3.c
    public Comparator c() {
        return this.f22453c;
    }

    @Override // r3.c
    public Object g() {
        Object[] objArr = this.f22451a;
        if (objArr.length > 0) {
            return objArr[objArr.length - 1];
        }
        return null;
    }

    @Override // r3.c
    public Object h() {
        Object[] objArr = this.f22451a;
        if (objArr.length > 0) {
            return objArr[0];
        }
        return null;
    }

    @Override // r3.c
    public int indexOf(Object obj) {
        return r(obj);
    }

    @Override // r3.c
    public boolean isEmpty() {
        return this.f22451a.length == 0;
    }

    @Override // r3.c, java.lang.Iterable
    public Iterator iterator() {
        return t(0, false);
    }

    @Override // r3.c
    public c j(Object obj, Object obj2) {
        int iR = r(obj);
        if (iR != -1) {
            Object[] objArr = this.f22451a;
            if (objArr[iR] == obj && this.f22452b[iR] == obj2) {
                return this;
            }
            return new C2579a(this.f22453c, w(objArr, iR, obj), w(this.f22452b, iR, obj2));
        }
        if (this.f22451a.length <= 25) {
            int iS = s(obj);
            return new C2579a(this.f22453c, p(this.f22451a, iS, obj), p(this.f22452b, iS, obj2));
        }
        HashMap map = new HashMap(this.f22451a.length + 1);
        int i7 = 0;
        while (true) {
            Object[] objArr2 = this.f22451a;
            if (i7 >= objArr2.length) {
                map.put(obj, obj2);
                return k.n(map, this.f22453c);
            }
            map.put(objArr2[i7], this.f22452b[i7]);
            i7++;
        }
    }

    @Override // r3.c
    public Iterator k(Object obj) {
        return t(s(obj), false);
    }

    @Override // r3.c
    public c l(Object obj) {
        int iR = r(obj);
        if (iR == -1) {
            return this;
        }
        return new C2579a(this.f22453c, u(this.f22451a, iR), u(this.f22452b, iR));
    }

    public final int r(Object obj) {
        int i7 = 0;
        for (Object obj2 : this.f22451a) {
            if (this.f22453c.compare(obj, obj2) == 0) {
                return i7;
            }
            i7++;
        }
        return -1;
    }

    public final int s(Object obj) {
        int i7 = 0;
        while (true) {
            Object[] objArr = this.f22451a;
            if (i7 >= objArr.length || this.f22453c.compare(objArr[i7], obj) >= 0) {
                break;
            }
            i7++;
        }
        return i7;
    }

    @Override // r3.c
    public int size() {
        return this.f22451a.length;
    }

    public final Iterator t(int i7, boolean z7) {
        return new C0343a(i7, z7);
    }

    public C2579a(Comparator comparator, Object[] objArr, Object[] objArr2) {
        this.f22451a = objArr;
        this.f22452b = objArr2;
        this.f22453c = comparator;
    }
}
