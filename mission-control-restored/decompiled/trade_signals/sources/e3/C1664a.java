package e3;

import e3.AbstractC1666c;
import e3.h;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: e3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1664a extends AbstractC1666c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f17146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f17147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparator f17148c;

    /* JADX INFO: renamed from: e3.a$a, reason: collision with other inner class name */
    public class C0292a implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f17150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f17151c;

        public C0292a(int i8, boolean z7) {
            this.f17150b = i8;
            this.f17151c = z7;
            this.f17149a = i8;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            Object obj = C1664a.this.f17146a[this.f17149a];
            Object[] objArr = C1664a.this.f17147b;
            int i8 = this.f17149a;
            Object obj2 = objArr[i8];
            this.f17149a = this.f17151c ? i8 - 1 : i8 + 1;
            return new AbstractMap.SimpleImmutableEntry(obj, obj2);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f17151c) {
                if (this.f17149a < 0) {
                    return false;
                }
            } else if (this.f17149a >= C1664a.this.f17146a.length) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Can't remove elements from ImmutableSortedMap");
        }
    }

    public C1664a(Comparator comparator) {
        this.f17146a = new Object[0];
        this.f17147b = new Object[0];
        this.f17148c = comparator;
    }

    public static Object[] K(Object[] objArr, int i8, Object obj) {
        Object[] objArr2 = new Object[objArr.length + 1];
        System.arraycopy(objArr, 0, objArr2, 0, i8);
        objArr2[i8] = obj;
        System.arraycopy(objArr, i8, objArr2, i8 + 1, (r0 - i8) - 1);
        return objArr2;
    }

    public static C1664a L(List list, Map map, AbstractC1666c.a.InterfaceC0293a interfaceC0293a, Comparator comparator) {
        Collections.sort(list, comparator);
        int size = list.size();
        Object[] objArr = new Object[size];
        Object[] objArr2 = new Object[size];
        int i8 = 0;
        for (Object obj : list) {
            objArr[i8] = obj;
            objArr2[i8] = map.get(interfaceC0293a.a(obj));
            i8++;
        }
        return new C1664a(comparator, objArr, objArr2);
    }

    public static C1664a O(Map map, Comparator comparator) {
        return L(new ArrayList(map.keySet()), map, AbstractC1666c.a.e(), comparator);
    }

    public static Object[] Q(Object[] objArr, int i8) {
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, i8);
        System.arraycopy(objArr, i8 + 1, objArr2, i8, length - i8);
        return objArr2;
    }

    public static Object[] R(Object[] objArr, int i8, Object obj) {
        int length = objArr.length;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        objArr2[i8] = obj;
        return objArr2;
    }

    @Override // e3.AbstractC1666c
    public void C(h.b bVar) {
        int i8 = 0;
        while (true) {
            Object[] objArr = this.f17146a;
            if (i8 >= objArr.length) {
                return;
            }
            bVar.a(objArr[i8], this.f17147b[i8]);
            i8++;
        }
    }

    @Override // e3.AbstractC1666c
    public Iterator E() {
        return P(this.f17146a.length - 1, true);
    }

    @Override // e3.AbstractC1666c
    public AbstractC1666c F(Object obj, Object obj2) {
        int iM = M(obj);
        if (iM != -1) {
            Object[] objArr = this.f17146a;
            if (objArr[iM] == obj && this.f17147b[iM] == obj2) {
                return this;
            }
            return new C1664a(this.f17148c, R(objArr, iM, obj), R(this.f17147b, iM, obj2));
        }
        if (this.f17146a.length <= 25) {
            int iN = N(obj);
            return new C1664a(this.f17148c, K(this.f17146a, iN, obj), K(this.f17147b, iN, obj2));
        }
        HashMap map = new HashMap(this.f17146a.length + 1);
        int i8 = 0;
        while (true) {
            Object[] objArr2 = this.f17146a;
            if (i8 >= objArr2.length) {
                map.put(obj, obj2);
                return k.J(map, this.f17148c);
            }
            map.put(objArr2[i8], this.f17147b[i8]);
            i8++;
        }
    }

    @Override // e3.AbstractC1666c
    public AbstractC1666c H(Object obj) {
        int iM = M(obj);
        if (iM == -1) {
            return this;
        }
        return new C1664a(this.f17148c, Q(this.f17146a, iM), Q(this.f17147b, iM));
    }

    public final int M(Object obj) {
        int i8 = 0;
        for (Object obj2 : this.f17146a) {
            if (this.f17148c.compare(obj, obj2) == 0) {
                return i8;
            }
            i8++;
        }
        return -1;
    }

    public final int N(Object obj) {
        int i8 = 0;
        while (true) {
            Object[] objArr = this.f17146a;
            if (i8 >= objArr.length || this.f17148c.compare(objArr[i8], obj) >= 0) {
                break;
            }
            i8++;
        }
        return i8;
    }

    public final Iterator P(int i8, boolean z7) {
        return new C0292a(i8, z7);
    }

    @Override // e3.AbstractC1666c
    public boolean a(Object obj) {
        return M(obj) != -1;
    }

    @Override // e3.AbstractC1666c
    public Object d(Object obj) {
        int iM = M(obj);
        if (iM != -1) {
            return this.f17147b[iM];
        }
        return null;
    }

    @Override // e3.AbstractC1666c
    public Comparator e() {
        return this.f17148c;
    }

    @Override // e3.AbstractC1666c
    public Object f() {
        Object[] objArr = this.f17146a;
        if (objArr.length > 0) {
            return objArr[objArr.length - 1];
        }
        return null;
    }

    @Override // e3.AbstractC1666c
    public Object h() {
        Object[] objArr = this.f17146a;
        if (objArr.length > 0) {
            return objArr[0];
        }
        return null;
    }

    @Override // e3.AbstractC1666c
    public boolean isEmpty() {
        return this.f17146a.length == 0;
    }

    @Override // e3.AbstractC1666c, java.lang.Iterable
    public Iterator iterator() {
        return P(0, false);
    }

    @Override // e3.AbstractC1666c
    public Object n(Object obj) {
        int iM = M(obj);
        if (iM == -1) {
            throw new IllegalArgumentException("Can't find predecessor of nonexistent key");
        }
        if (iM > 0) {
            return this.f17146a[iM - 1];
        }
        return null;
    }

    @Override // e3.AbstractC1666c
    public int size() {
        return this.f17146a.length;
    }

    public C1664a(Comparator comparator, Object[] objArr, Object[] objArr2) {
        this.f17146a = objArr;
        this.f17147b = objArr2;
        this.f17148c = comparator;
    }
}
