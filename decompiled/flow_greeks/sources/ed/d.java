package ed;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import vd.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements Map, Serializable, qd.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f8649n = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final d f8650o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f8651a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f8652b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f8653c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f8654d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f8655e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f8656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f8657g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f8658h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f8659i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public ed.f f8660j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public g f8661k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ed.e f8662l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f8663m;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(k kVar) {
            this();
        }

        public final int c(int i10) {
            return Integer.highestOneBit(l.b(i10, 1) * 3);
        }

        public final int d(int i10) {
            return Integer.numberOfLeadingZeros(i10) + 1;
        }

        public final d e() {
            return d.f8650o;
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends C0165d implements Iterator, qd.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(d map) {
            super(map);
            t.f(map, "map");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
        public c next() {
            c();
            if (e() >= g().f8656f) {
                throw new NoSuchElementException();
            }
            int iE = e();
            i(iE + 1);
            j(iE);
            c cVar = new c(g(), f());
            h();
            return cVar;
        }

        public final void l(StringBuilder sb2) {
            t.f(sb2, "sb");
            if (e() >= g().f8656f) {
                throw new NoSuchElementException();
            }
            int iE = e();
            i(iE + 1);
            j(iE);
            Object obj = g().f8651a[f()];
            if (obj == g()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj);
            }
            sb2.append('=');
            Object[] objArr = g().f8652b;
            t.c(objArr);
            Object obj2 = objArr[f()];
            if (obj2 == g()) {
                sb2.append("(this Map)");
            } else {
                sb2.append(obj2);
            }
            h();
        }

        public final int m() {
            if (e() >= g().f8656f) {
                throw new NoSuchElementException();
            }
            int iE = e();
            i(iE + 1);
            j(iE);
            Object obj = g().f8651a[f()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = g().f8652b;
            t.c(objArr);
            Object obj2 = objArr[f()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            h();
            return iHashCode2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements Map.Entry, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f8664a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8665b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f8666c;

        public c(d map, int i10) {
            t.f(map, "map");
            this.f8664a = map;
            this.f8665b = i10;
            this.f8666c = map.f8658h;
        }

        private final void a() {
            if (this.f8664a.f8658h != this.f8666c) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return t.b(entry.getKey(), getKey()) && t.b(entry.getValue(), getValue());
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            a();
            return this.f8664a.f8651a[this.f8665b];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            a();
            Object[] objArr = this.f8664a.f8652b;
            t.c(objArr);
            return objArr[this.f8665b];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            Object key = getKey();
            int iHashCode = key != null ? key.hashCode() : 0;
            Object value = getValue();
            return iHashCode ^ (value != null ? value.hashCode() : 0);
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            a();
            this.f8664a.n();
            Object[] objArrL = this.f8664a.l();
            int i10 = this.f8665b;
            Object obj2 = objArrL[i10];
            objArrL[i10] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getKey());
            sb2.append('=');
            sb2.append(getValue());
            return sb2.toString();
        }
    }

    /* JADX INFO: renamed from: ed.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class C0165d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f8667a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f8668b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f8669c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f8670d;

        public C0165d(d map) {
            t.f(map, "map");
            this.f8667a = map;
            this.f8669c = -1;
            this.f8670d = map.f8658h;
            h();
        }

        public final void c() {
            if (this.f8667a.f8658h != this.f8670d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int e() {
            return this.f8668b;
        }

        public final int f() {
            return this.f8669c;
        }

        public final d g() {
            return this.f8667a;
        }

        public final void h() {
            while (this.f8668b < this.f8667a.f8656f) {
                int[] iArr = this.f8667a.f8653c;
                int i10 = this.f8668b;
                if (iArr[i10] >= 0) {
                    return;
                } else {
                    this.f8668b = i10 + 1;
                }
            }
        }

        public final boolean hasNext() {
            return this.f8668b < this.f8667a.f8656f;
        }

        public final void i(int i10) {
            this.f8668b = i10;
        }

        public final void j(int i10) {
            this.f8669c = i10;
        }

        public final void remove() {
            c();
            if (this.f8669c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.");
            }
            this.f8667a.n();
            this.f8667a.M(this.f8669c);
            this.f8669c = -1;
            this.f8670d = this.f8667a.f8658h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends C0165d implements Iterator, qd.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(d map) {
            super(map);
            t.f(map, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            if (e() >= g().f8656f) {
                throw new NoSuchElementException();
            }
            int iE = e();
            i(iE + 1);
            j(iE);
            Object obj = g().f8651a[f()];
            h();
            return obj;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends C0165d implements Iterator, qd.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(d map) {
            super(map);
            t.f(map, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            if (e() >= g().f8656f) {
                throw new NoSuchElementException();
            }
            int iE = e();
            i(iE + 1);
            j(iE);
            Object[] objArr = g().f8652b;
            t.c(objArr);
            Object obj = objArr[f()];
            h();
            return obj;
        }
    }

    static {
        d dVar = new d(0);
        dVar.f8663m = true;
        f8650o = dVar;
    }

    public d(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i10, int i11) {
        this.f8651a = objArr;
        this.f8652b = objArr2;
        this.f8653c = iArr;
        this.f8654d = iArr2;
        this.f8655e = i10;
        this.f8656f = i11;
        this.f8657g = f8649n.d(z());
    }

    private final void J() {
        this.f8658h++;
    }

    private final void s(int i10) {
        if (i10 < 0) {
            throw new OutOfMemoryError();
        }
        if (i10 > x()) {
            int iE = dd.d.f7994a.e(x(), i10);
            this.f8651a = ed.c.e(this.f8651a, iE);
            Object[] objArr = this.f8652b;
            this.f8652b = objArr != null ? ed.c.e(objArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.f8653c, iE);
            t.e(iArrCopyOf, "copyOf(...)");
            this.f8653c = iArrCopyOf;
            int iC = f8649n.c(iE);
            if (iC > z()) {
                K(iC);
            }
        }
    }

    private final void t(int i10) {
        if (Q(i10)) {
            o(true);
        } else {
            s(this.f8656f + i10);
        }
    }

    public Set A() {
        ed.f fVar = this.f8660j;
        if (fVar != null) {
            return fVar;
        }
        ed.f fVar2 = new ed.f(this);
        this.f8660j = fVar2;
        return fVar2;
    }

    public int B() {
        return this.f8659i;
    }

    public Collection C() {
        g gVar = this.f8661k;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this);
        this.f8661k = gVar2;
        return gVar2;
    }

    public final int D(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f8657g;
    }

    public final e F() {
        return new e(this);
    }

    public final boolean G(Collection collection) {
        boolean z10 = false;
        if (collection.isEmpty()) {
            return false;
        }
        t(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (H((Map.Entry) it.next())) {
                z10 = true;
            }
        }
        return z10;
    }

    public final boolean H(Map.Entry entry) {
        int iK = k(entry.getKey());
        Object[] objArrL = l();
        if (iK >= 0) {
            objArrL[iK] = entry.getValue();
            return true;
        }
        int i10 = (-iK) - 1;
        if (t.b(entry.getValue(), objArrL[i10])) {
            return false;
        }
        objArrL[i10] = entry.getValue();
        return true;
    }

    public final boolean I(int i10) {
        int iD = D(this.f8651a[i10]);
        int i11 = this.f8655e;
        while (true) {
            int[] iArr = this.f8654d;
            if (iArr[iD] == 0) {
                iArr[iD] = i10 + 1;
                this.f8653c[i10] = iD;
                return true;
            }
            i11--;
            if (i11 < 0) {
                return false;
            }
            iD = iD == 0 ? z() - 1 : iD - 1;
        }
    }

    public final void K(int i10) {
        J();
        int i11 = 0;
        if (this.f8656f > size()) {
            o(false);
        }
        this.f8654d = new int[i10];
        this.f8657g = f8649n.d(i10);
        while (i11 < this.f8656f) {
            int i12 = i11 + 1;
            if (!I(i11)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i11 = i12;
        }
    }

    public final boolean L(Map.Entry entry) {
        t.f(entry, "entry");
        n();
        int iV = v(entry.getKey());
        if (iV < 0) {
            return false;
        }
        Object[] objArr = this.f8652b;
        t.c(objArr);
        if (!t.b(objArr[iV], entry.getValue())) {
            return false;
        }
        M(iV);
        return true;
    }

    public final void M(int i10) {
        ed.c.f(this.f8651a, i10);
        Object[] objArr = this.f8652b;
        if (objArr != null) {
            ed.c.f(objArr, i10);
        }
        N(this.f8653c[i10]);
        this.f8653c[i10] = -1;
        this.f8659i = size() - 1;
        J();
    }

    public final void N(int i10) {
        int iD = l.d(this.f8655e * 2, z() / 2);
        int i11 = 0;
        int i12 = i10;
        do {
            i10 = i10 == 0 ? z() - 1 : i10 - 1;
            i11++;
            if (i11 > this.f8655e) {
                this.f8654d[i12] = 0;
                return;
            }
            int[] iArr = this.f8654d;
            int i13 = iArr[i10];
            if (i13 == 0) {
                iArr[i12] = 0;
                return;
            }
            if (i13 < 0) {
                iArr[i12] = -1;
            } else {
                int i14 = i13 - 1;
                if (((D(this.f8651a[i14]) - i10) & (z() - 1)) >= i11) {
                    this.f8654d[i12] = i13;
                    this.f8653c[i14] = i12;
                }
                iD--;
            }
            i12 = i10;
            i11 = 0;
            iD--;
        } while (iD >= 0);
        this.f8654d[i12] = -1;
    }

    public final boolean O(Object obj) {
        n();
        int iV = v(obj);
        if (iV < 0) {
            return false;
        }
        M(iV);
        return true;
    }

    public final boolean P(Object obj) {
        n();
        int iW = w(obj);
        if (iW < 0) {
            return false;
        }
        M(iW);
        return true;
    }

    public final boolean Q(int i10) {
        int iX = x();
        int i11 = this.f8656f;
        int i12 = iX - i11;
        int size = i11 - size();
        return i12 < i10 && i12 + size >= i10 && size >= x() / 4;
    }

    public final f R() {
        return new f(this);
    }

    @Override // java.util.Map
    public void clear() {
        n();
        int i10 = this.f8656f - 1;
        if (i10 >= 0) {
            int i11 = 0;
            while (true) {
                int[] iArr = this.f8653c;
                int i12 = iArr[i11];
                if (i12 >= 0) {
                    this.f8654d[i12] = 0;
                    iArr[i11] = -1;
                }
                if (i11 == i10) {
                    break;
                } else {
                    i11++;
                }
            }
        }
        ed.c.g(this.f8651a, 0, this.f8656f);
        Object[] objArr = this.f8652b;
        if (objArr != null) {
            ed.c.g(objArr, 0, this.f8656f);
        }
        this.f8659i = 0;
        this.f8656f = 0;
        J();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return v(obj) >= 0;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return w(obj) >= 0;
    }

    @Override // java.util.Map
    public final /* bridge */ Set entrySet() {
        return y();
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof Map) && r((Map) obj);
        }
        return true;
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int iV = v(obj);
        if (iV < 0) {
            return null;
        }
        Object[] objArr = this.f8652b;
        t.c(objArr);
        return objArr[iV];
    }

    @Override // java.util.Map
    public int hashCode() {
        b bVarU = u();
        int iM = 0;
        while (bVarU.hasNext()) {
            iM += bVarU.m();
        }
        return iM;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int k(Object obj) {
        n();
        while (true) {
            int iD = D(obj);
            int iD2 = l.d(this.f8655e * 2, z() / 2);
            int i10 = 0;
            while (true) {
                int i11 = this.f8654d[iD];
                if (i11 <= 0) {
                    if (this.f8656f < x()) {
                        int i12 = this.f8656f;
                        int i13 = i12 + 1;
                        this.f8656f = i13;
                        this.f8651a[i12] = obj;
                        this.f8653c[i12] = iD;
                        this.f8654d[iD] = i13;
                        this.f8659i = size() + 1;
                        J();
                        if (i10 > this.f8655e) {
                            this.f8655e = i10;
                        }
                        return i12;
                    }
                    t(1);
                } else {
                    if (t.b(this.f8651a[i11 - 1], obj)) {
                        return -i11;
                    }
                    i10++;
                    if (i10 > iD2) {
                        K(z() * 2);
                        break;
                    }
                    iD = iD == 0 ? z() - 1 : iD - 1;
                }
            }
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return A();
    }

    public final Object[] l() {
        Object[] objArr = this.f8652b;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArrD = ed.c.d(x());
        this.f8652b = objArrD;
        return objArrD;
    }

    public final Map m() {
        n();
        this.f8663m = true;
        if (size() > 0) {
            return this;
        }
        d dVar = f8650o;
        t.d(dVar, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return dVar;
    }

    public final void n() {
        if (this.f8663m) {
            throw new UnsupportedOperationException();
        }
    }

    public final void o(boolean z10) {
        int i10;
        Object[] objArr = this.f8652b;
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i10 = this.f8656f;
            if (i11 >= i10) {
                break;
            }
            int[] iArr = this.f8653c;
            int i13 = iArr[i11];
            if (i13 >= 0) {
                Object[] objArr2 = this.f8651a;
                objArr2[i12] = objArr2[i11];
                if (objArr != null) {
                    objArr[i12] = objArr[i11];
                }
                if (z10) {
                    iArr[i12] = i13;
                    this.f8654d[i13] = i12 + 1;
                }
                i12++;
            }
            i11++;
        }
        ed.c.g(this.f8651a, i12, i10);
        if (objArr != null) {
            ed.c.g(objArr, i12, this.f8656f);
        }
        this.f8656f = i12;
    }

    public final boolean p(Collection m10) {
        t.f(m10, "m");
        for (Object obj : m10) {
            if (obj != null) {
                try {
                    if (!q((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        n();
        int iK = k(obj);
        Object[] objArrL = l();
        if (iK >= 0) {
            objArrL[iK] = obj2;
            return null;
        }
        int i10 = (-iK) - 1;
        Object obj3 = objArrL[i10];
        objArrL[i10] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public void putAll(Map from) {
        t.f(from, "from");
        n();
        G(from.entrySet());
    }

    public final boolean q(Map.Entry entry) {
        t.f(entry, "entry");
        int iV = v(entry.getKey());
        if (iV < 0) {
            return false;
        }
        Object[] objArr = this.f8652b;
        t.c(objArr);
        return t.b(objArr[iV], entry.getValue());
    }

    public final boolean r(Map map) {
        return size() == map.size() && p(map.entrySet());
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        n();
        int iV = v(obj);
        if (iV < 0) {
            return null;
        }
        Object[] objArr = this.f8652b;
        t.c(objArr);
        Object obj2 = objArr[iV];
        M(iV);
        return obj2;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return B();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder((size() * 3) + 2);
        sb2.append("{");
        b bVarU = u();
        int i10 = 0;
        while (bVarU.hasNext()) {
            if (i10 > 0) {
                sb2.append(", ");
            }
            bVarU.l(sb2);
            i10++;
        }
        sb2.append("}");
        String string = sb2.toString();
        t.e(string, "toString(...)");
        return string;
    }

    public final b u() {
        return new b(this);
    }

    public final int v(Object obj) {
        int iD = D(obj);
        int i10 = this.f8655e;
        while (true) {
            int i11 = this.f8654d[iD];
            if (i11 == 0) {
                return -1;
            }
            if (i11 > 0) {
                int i12 = i11 - 1;
                if (t.b(this.f8651a[i12], obj)) {
                    return i12;
                }
            }
            i10--;
            if (i10 < 0) {
                return -1;
            }
            iD = iD == 0 ? z() - 1 : iD - 1;
        }
    }

    @Override // java.util.Map
    public final /* bridge */ Collection values() {
        return C();
    }

    public final int w(Object obj) {
        int i10 = this.f8656f;
        while (true) {
            i10--;
            if (i10 < 0) {
                return -1;
            }
            if (this.f8653c[i10] >= 0) {
                Object[] objArr = this.f8652b;
                t.c(objArr);
                if (t.b(objArr[i10], obj)) {
                    return i10;
                }
            }
        }
    }

    public final int x() {
        return this.f8651a.length;
    }

    public Set y() {
        ed.e eVar = this.f8662l;
        if (eVar != null) {
            return eVar;
        }
        ed.e eVar2 = new ed.e(this);
        this.f8662l = eVar2;
        return eVar2;
    }

    public final int z() {
        return this.f8654d.length;
    }

    public d() {
        this(8);
    }

    public d(int i10) {
        this(ed.c.d(i10), null, new int[i10], new int[f8649n.c(i10)], 2, 0);
    }
}
