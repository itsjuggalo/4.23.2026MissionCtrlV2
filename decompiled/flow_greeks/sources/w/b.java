package w;

import dd.a0;
import dd.l;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Collection, Set, qd.a, qd.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f23560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f23561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23562c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a extends e {
        public a() {
            super(b.this.g());
        }

        @Override // w.e
        public Object c(int i10) {
            return b.this.u(i10);
        }

        @Override // w.e
        public void e(int i10) {
            b.this.p(i10);
        }
    }

    public b() {
        this(0, 1, null);
    }

    public final void a(int i10) {
        int iG = g();
        if (e().length < i10) {
            int[] iArrE = e();
            Object[] objArrC = c();
            d.a(this, i10);
            if (g() > 0) {
                l.j(iArrE, e(), 0, 0, g(), 6, null);
                l.k(objArrC, c(), 0, 0, g(), 6, null);
            }
        }
        if (g() != iG) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i10;
        int iC;
        int iG = g();
        if (obj == null) {
            iC = d.d(this);
            i10 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i10 = iHashCode;
            iC = d.c(this, obj, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i11 = ~iC;
        if (iG >= e().length) {
            int i12 = 8;
            if (iG >= 8) {
                i12 = (iG >> 1) + iG;
            } else if (iG < 4) {
                i12 = 4;
            }
            int[] iArrE = e();
            Object[] objArrC = c();
            d.a(this, i12);
            if (iG != g()) {
                throw new ConcurrentModificationException();
            }
            if (!(e().length == 0)) {
                l.j(iArrE, e(), 0, 0, iArrE.length, 6, null);
                l.k(objArrC, c(), 0, 0, objArrC.length, 6, null);
            }
        }
        if (i11 < iG) {
            int i13 = i11 + 1;
            l.f(e(), e(), i13, i11, iG);
            l.h(c(), c(), i13, i11, iG);
        }
        if (iG != g() || i11 >= e().length) {
            throw new ConcurrentModificationException();
        }
        e()[i11] = i10;
        c()[i11] = obj;
        s(g() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        t.f(elements, "elements");
        a(g() + elements.size());
        Iterator it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final Object[] c() {
        return this.f23561b;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (g() != 0) {
            r(x.a.f24120a);
            q(x.a.f24122c);
            s(0);
        }
        if (g() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        t.f(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int[] e() {
        return this.f23560a;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int iG = g();
            for (int i10 = 0; i10 < iG; i10++) {
                if (!((Set) obj).contains(u(i10))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public int f() {
        return this.f23562c;
    }

    public final int g() {
        return this.f23562c;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArrE = e();
        int iG = g();
        int i10 = 0;
        for (int i11 = 0; i11 < iG; i11++) {
            i10 += iArrE[i11];
        }
        return i10;
    }

    public final int indexOf(Object obj) {
        return obj == null ? d.d(this) : d.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return g() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new a();
    }

    public final Object p(int i10) {
        int i11;
        Object[] objArr;
        int iG = g();
        Object obj = c()[i10];
        if (iG <= 1) {
            clear();
            return obj;
        }
        int i12 = iG - 1;
        if (e().length <= 8 || g() >= e().length / 3) {
            if (i10 < i12) {
                int i13 = i10 + 1;
                l.f(e(), e(), i10, i13, iG);
                l.h(c(), c(), i10, i13, iG);
            }
            c()[i12] = null;
        } else {
            int iG2 = g() > 8 ? g() + (g() >> 1) : 8;
            int[] iArrE = e();
            Object[] objArrC = c();
            d.a(this, iG2);
            if (i10 > 0) {
                l.j(iArrE, e(), 0, 0, i10, 6, null);
                objArr = objArrC;
                l.k(objArr, c(), 0, 0, i10, 6, null);
                i11 = i10;
            } else {
                i11 = i10;
                objArr = objArrC;
            }
            if (i11 < i12) {
                int i14 = i11 + 1;
                l.f(iArrE, e(), i11, i14, iG);
                l.h(objArr, c(), i11, i14, iG);
            }
        }
        if (iG != g()) {
            throw new ConcurrentModificationException();
        }
        s(i12);
        return obj;
    }

    public final void q(Object[] objArr) {
        t.f(objArr, "<set-?>");
        this.f23561b = objArr;
    }

    public final void r(int[] iArr) {
        t.f(iArr, "<set-?>");
        this.f23560a = iArr;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        p(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        t.f(elements, "elements");
        Iterator it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        t.f(elements, "elements");
        boolean z10 = false;
        for (int iG = g() - 1; -1 < iG; iG--) {
            if (!a0.R(elements, c()[iG])) {
                p(iG);
                z10 = true;
            }
        }
        return z10;
    }

    public final void s(int i10) {
        this.f23562c = i10;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return l.m(this.f23561b, 0, this.f23562c);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb2 = new StringBuilder(g() * 14);
        sb2.append('{');
        int iG = g();
        for (int i10 = 0; i10 < iG; i10++) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            Object objU = u(i10);
            if (objU != this) {
                sb2.append(objU);
            } else {
                sb2.append("(this Set)");
            }
        }
        sb2.append('}');
        String string = sb2.toString();
        t.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public final Object u(int i10) {
        return c()[i10];
    }

    public b(int i10) {
        this.f23560a = x.a.f24120a;
        this.f23561b = x.a.f24122c;
        if (i10 > 0) {
            d.a(this, i10);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] array) {
        t.f(array, "array");
        Object[] result = c.a(array, this.f23562c);
        l.h(this.f23561b, result, 0, 0, this.f23562c);
        t.e(result, "result");
        return result;
    }

    public /* synthetic */ b(int i10, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? 0 : i10);
    }
}
