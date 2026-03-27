package w;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;
import p5.z;
import x.AbstractC2939a;

/* JADX INFO: loaded from: classes.dex */
public final class b implements Collection, Set, C5.a, C5.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int[] f23957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f23958b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23959c;

    public final class a extends e {
        public a() {
            super(b.this.h());
        }

        @Override // w.e
        public Object c(int i8) {
            return b.this.I(i8);
        }

        @Override // w.e
        public void d(int i8) {
            b.this.n(i8);
        }
    }

    public b() {
        this(0, 1, null);
    }

    public final void C(Object[] objArr) {
        AbstractC2304t.f(objArr, "<set-?>");
        this.f23958b = objArr;
    }

    public final void F(int[] iArr) {
        AbstractC2304t.f(iArr, "<set-?>");
        this.f23957a = iArr;
    }

    public final void H(int i8) {
        this.f23959c = i8;
    }

    public final Object I(int i8) {
        return d()[i8];
    }

    public final void a(int i8) {
        int iH = h();
        if (e().length < i8) {
            int[] iArrE = e();
            Object[] objArrD = d();
            d.a(this, i8);
            if (h() > 0) {
                AbstractC2590l.j(iArrE, e(), 0, 0, h(), 6, null);
                AbstractC2590l.k(objArrD, d(), 0, 0, h(), 6, null);
            }
        }
        if (h() != iH) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i8;
        int iC;
        int iH = h();
        if (obj == null) {
            iC = d.d(this);
            i8 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i8 = iHashCode;
            iC = d.c(this, obj, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i9 = ~iC;
        if (iH >= e().length) {
            int i10 = 8;
            if (iH >= 8) {
                i10 = (iH >> 1) + iH;
            } else if (iH < 4) {
                i10 = 4;
            }
            int[] iArrE = e();
            Object[] objArrD = d();
            d.a(this, i10);
            if (iH != h()) {
                throw new ConcurrentModificationException();
            }
            if (!(e().length == 0)) {
                AbstractC2590l.j(iArrE, e(), 0, 0, iArrE.length, 6, null);
                AbstractC2590l.k(objArrD, d(), 0, 0, objArrD.length, 6, null);
            }
        }
        if (i9 < iH) {
            int i11 = i9 + 1;
            AbstractC2590l.f(e(), e(), i11, i9, iH);
            AbstractC2590l.h(d(), d(), i11, i9, iH);
        }
        if (iH != h() || i9 >= e().length) {
            throw new ConcurrentModificationException();
        }
        e()[i9] = i8;
        d()[i9] = obj;
        H(h() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        a(h() + elements.size());
        Iterator it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (h() != 0) {
            F(AbstractC2939a.f24102a);
            C(AbstractC2939a.f24104c);
            H(0);
        }
        if (h() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object[] d() {
        return this.f23958b;
    }

    public final int[] e() {
        return this.f23957a;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Set) && size() == ((Set) obj).size()) {
            try {
                int iH = h();
                for (int i8 = 0; i8 < iH; i8++) {
                    if (((Set) obj).contains(I(i8))) {
                    }
                }
                return true;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public int f() {
        return this.f23959c;
    }

    public final int h() {
        return this.f23959c;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArrE = e();
        int iH = h();
        int i8 = 0;
        for (int i9 = 0; i9 < iH; i9++) {
            i8 += iArrE[i9];
        }
        return i8;
    }

    public final int indexOf(Object obj) {
        return obj == null ? d.d(this) : d.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return h() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new a();
    }

    public final Object n(int i8) {
        int iH = h();
        Object obj = d()[i8];
        if (iH <= 1) {
            clear();
        } else {
            int i9 = iH - 1;
            if (e().length <= 8 || h() >= e().length / 3) {
                if (i8 < i9) {
                    int i10 = i8 + 1;
                    AbstractC2590l.f(e(), e(), i8, i10, iH);
                    AbstractC2590l.h(d(), d(), i8, i10, iH);
                }
                d()[i9] = null;
            } else {
                int iH2 = h() > 8 ? h() + (h() >> 1) : 8;
                int[] iArrE = e();
                Object[] objArrD = d();
                d.a(this, iH2);
                if (i8 > 0) {
                    AbstractC2590l.j(iArrE, e(), 0, 0, i8, 6, null);
                    AbstractC2590l.k(objArrD, d(), 0, 0, i8, 6, null);
                }
                if (i8 < i9) {
                    int i11 = i8 + 1;
                    AbstractC2590l.f(iArrE, e(), i8, i11, iH);
                    AbstractC2590l.h(objArrD, d(), i8, i11, iH);
                }
            }
            if (iH != h()) {
                throw new ConcurrentModificationException();
            }
            H(i9);
        }
        return obj;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        n(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        Iterator it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        AbstractC2304t.f(elements, "elements");
        boolean z7 = false;
        for (int iH = h() - 1; -1 < iH; iH--) {
            if (!z.Q(elements, d()[iH])) {
                n(iH);
                z7 = true;
            }
        }
        return z7;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return f();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return AbstractC2590l.m(this.f23958b, 0, this.f23959c);
    }

    public String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(h() * 14);
        sb.append('{');
        int iH = h();
        for (int i8 = 0; i8 < iH; i8++) {
            if (i8 > 0) {
                sb.append(", ");
            }
            Object objI = I(i8);
            if (objI != this) {
                sb.append(objI);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        AbstractC2304t.e(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public b(int i8) {
        this.f23957a = AbstractC2939a.f24102a;
        this.f23958b = AbstractC2939a.f24104c;
        if (i8 > 0) {
            d.a(this, i8);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] array) {
        AbstractC2304t.f(array, "array");
        Object[] result = c.a(array, this.f23959c);
        AbstractC2590l.h(this.f23958b, result, 0, 0, this.f23959c);
        AbstractC2304t.e(result, "result");
        return result;
    }

    public /* synthetic */ b(int i8, int i9, AbstractC2296k abstractC2296k) {
        this((i9 & 1) != 0 ? 0 : i8);
    }
}
