package A2;

import e3.w;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object[] f46a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f47b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Comparator f48c;

    public b() {
        A.d dVar = Q2.h.f2672b;
        this.f46a = new Object[0];
        this.f47b = new Object[0];
        this.f48c = dVar;
    }

    @Override // A2.c
    public final boolean a(Object obj) {
        return o(obj) != -1;
    }

    @Override // A2.c
    public final Object b(Q2.h hVar) {
        int iO = o(hVar);
        if (iO != -1) {
            return this.f47b[iO];
        }
        return null;
    }

    @Override // A2.c
    public final Comparator c() {
        return this.f48c;
    }

    @Override // A2.c
    public final Object f() {
        Object[] objArr = this.f46a;
        if (objArr.length > 0) {
            return objArr[objArr.length - 1];
        }
        return null;
    }

    @Override // A2.c
    public final Object h() {
        Object[] objArr = this.f46a;
        if (objArr.length > 0) {
            return objArr[0];
        }
        return null;
    }

    @Override // A2.c
    public final boolean isEmpty() {
        return this.f46a.length == 0;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new a(this, 0);
    }

    @Override // A2.c
    public final int k(Q2.k kVar) {
        return o(kVar);
    }

    @Override // A2.c
    public final c l(Object obj, Object obj2) {
        int iO = o(obj);
        Comparator comparator = this.f48c;
        Object[] objArr = this.f47b;
        Object[] objArr2 = this.f46a;
        if (iO != -1) {
            if (objArr2[iO] == obj && objArr[iO] == obj2) {
                return this;
            }
            int length = objArr2.length;
            Object[] objArr3 = new Object[length];
            System.arraycopy(objArr2, 0, objArr3, 0, length);
            objArr3[iO] = obj;
            int length2 = objArr.length;
            Object[] objArr4 = new Object[length2];
            System.arraycopy(objArr, 0, objArr4, 0, length2);
            objArr4[iO] = obj2;
            return new b(comparator, objArr3, objArr4);
        }
        if (objArr2.length > 25) {
            HashMap map = new HashMap(objArr2.length + 1);
            for (int i = 0; i < objArr2.length; i++) {
                map.put(objArr2[i], objArr[i]);
            }
            map.put(obj, obj2);
            return w.f(new ArrayList(map.keySet()), map, comparator);
        }
        int i6 = 0;
        while (i6 < objArr2.length && comparator.compare(objArr2[i6], obj) < 0) {
            i6++;
        }
        Object[] objArr5 = new Object[objArr2.length + 1];
        System.arraycopy(objArr2, 0, objArr5, 0, i6);
        objArr5[i6] = obj;
        int i7 = i6 + 1;
        System.arraycopy(objArr2, i6, objArr5, i7, (r5 - i6) - 1);
        Object[] objArr6 = new Object[objArr.length + 1];
        System.arraycopy(objArr, 0, objArr6, 0, i6);
        objArr6[i6] = obj2;
        System.arraycopy(objArr, i6, objArr6, i7, (r3 - i6) - 1);
        return new b(comparator, objArr5, objArr6);
    }

    @Override // A2.c
    public final Iterator m(Object obj) {
        int i = 0;
        while (true) {
            Object[] objArr = this.f46a;
            if (i >= objArr.length || this.f48c.compare(objArr[i], obj) >= 0) {
                break;
            }
            i++;
        }
        return new a(this, i);
    }

    @Override // A2.c
    public final c n(Object obj) {
        int iO = o(obj);
        if (iO == -1) {
            return this;
        }
        Object[] objArr = this.f46a;
        int length = objArr.length - 1;
        Object[] objArr2 = new Object[length];
        System.arraycopy(objArr, 0, objArr2, 0, iO);
        int i = iO + 1;
        System.arraycopy(objArr, i, objArr2, iO, length - iO);
        Object[] objArr3 = this.f47b;
        int length2 = objArr3.length - 1;
        Object[] objArr4 = new Object[length2];
        System.arraycopy(objArr3, 0, objArr4, 0, iO);
        System.arraycopy(objArr3, i, objArr4, iO, length2 - iO);
        return new b(this.f48c, objArr2, objArr4);
    }

    public final int o(Object obj) {
        int i = 0;
        for (Object obj2 : this.f46a) {
            if (this.f48c.compare(obj, obj2) == 0) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override // A2.c
    public final int size() {
        return this.f46a.length;
    }

    public b(Comparator comparator, Object[] objArr, Object[] objArr2) {
        this.f46a = objArr;
        this.f47b = objArr2;
        this.f48c = comparator;
    }
}
