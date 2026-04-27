package q5;

import H5.i;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2582d;

/* JADX INFO: renamed from: q5.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2637d implements Map, Serializable, C5.b {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final a f22619n = new a(null);

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final C2637d f22620o;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f22621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object[] f22622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int[] f22623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int[] f22624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f22625e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f22626f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f22627g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f22628h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f22629i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public C2639f f22630j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public C2640g f22631k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public C2638e f22632l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f22633m;

    /* JADX INFO: renamed from: q5.d$a */
    public static final class a {
        public a() {
        }

        public final int c(int i8) {
            return Integer.highestOneBit(i.b(i8, 1) * 3);
        }

        public final int d(int i8) {
            return Integer.numberOfLeadingZeros(i8) + 1;
        }

        public final C2637d e() {
            return C2637d.f22620o;
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: q5.d$b */
    public static final class b extends C0388d implements Iterator, C5.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C2637d map) {
            super(map);
            AbstractC2304t.f(map, "map");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public c next() {
            c();
            if (d() >= f().f22626f) {
                throw new NoSuchElementException();
            }
            int iD = d();
            h(iD + 1);
            i(iD);
            c cVar = new c(f(), e());
            g();
            return cVar;
        }

        public final void k(StringBuilder sb) {
            AbstractC2304t.f(sb, "sb");
            if (d() >= f().f22626f) {
                throw new NoSuchElementException();
            }
            int iD = d();
            h(iD + 1);
            i(iD);
            Object obj = f().f22621a[e()];
            if (obj == f()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = f().f22622b;
            AbstractC2304t.c(objArr);
            Object obj2 = objArr[e()];
            if (obj2 == f()) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            g();
        }

        public final int l() {
            if (d() >= f().f22626f) {
                throw new NoSuchElementException();
            }
            int iD = d();
            h(iD + 1);
            i(iD);
            Object obj = f().f22621a[e()];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = f().f22622b;
            AbstractC2304t.c(objArr);
            Object obj2 = objArr[e()];
            int iHashCode2 = iHashCode ^ (obj2 != null ? obj2.hashCode() : 0);
            g();
            return iHashCode2;
        }
    }

    /* JADX INFO: renamed from: q5.d$c */
    public static final class c implements Map.Entry, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2637d f22634a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f22635b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f22636c;

        public c(C2637d map, int i8) {
            AbstractC2304t.f(map, "map");
            this.f22634a = map;
            this.f22635b = i8;
            this.f22636c = map.f22628h;
        }

        private final void a() {
            if (this.f22634a.f22628h != this.f22636c) {
                throw new ConcurrentModificationException("The backing map has been modified after this entry was obtained.");
            }
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (AbstractC2304t.b(entry.getKey(), getKey()) && AbstractC2304t.b(entry.getValue(), getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            a();
            return this.f22634a.f22621a[this.f22635b];
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            a();
            Object[] objArr = this.f22634a.f22622b;
            AbstractC2304t.c(objArr);
            return objArr[this.f22635b];
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
            this.f22634a.m();
            Object[] objArrK = this.f22634a.k();
            int i8 = this.f22635b;
            Object obj2 = objArrK[i8];
            objArrK[i8] = obj;
            return obj2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(getKey());
            sb.append('=');
            sb.append(getValue());
            return sb.toString();
        }
    }

    /* JADX INFO: renamed from: q5.d$d, reason: collision with other inner class name */
    public static class C0388d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C2637d f22637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f22638b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22639c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22640d;

        public C0388d(C2637d map) {
            AbstractC2304t.f(map, "map");
            this.f22637a = map;
            this.f22639c = -1;
            this.f22640d = map.f22628h;
            g();
        }

        public final void c() {
            if (this.f22637a.f22628h != this.f22640d) {
                throw new ConcurrentModificationException();
            }
        }

        public final int d() {
            return this.f22638b;
        }

        public final int e() {
            return this.f22639c;
        }

        public final C2637d f() {
            return this.f22637a;
        }

        public final void g() {
            while (this.f22638b < this.f22637a.f22626f) {
                int[] iArr = this.f22637a.f22623c;
                int i8 = this.f22638b;
                if (iArr[i8] >= 0) {
                    return;
                } else {
                    this.f22638b = i8 + 1;
                }
            }
        }

        public final void h(int i8) {
            this.f22638b = i8;
        }

        public final boolean hasNext() {
            return this.f22638b < this.f22637a.f22626f;
        }

        public final void i(int i8) {
            this.f22639c = i8;
        }

        public final void remove() {
            c();
            if (this.f22639c == -1) {
                throw new IllegalStateException("Call next() before removing element from the iterator.".toString());
            }
            this.f22637a.m();
            this.f22637a.L(this.f22639c);
            this.f22639c = -1;
            this.f22640d = this.f22637a.f22628h;
        }
    }

    /* JADX INFO: renamed from: q5.d$e */
    public static final class e extends C0388d implements Iterator, C5.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(C2637d map) {
            super(map);
            AbstractC2304t.f(map, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            if (d() >= f().f22626f) {
                throw new NoSuchElementException();
            }
            int iD = d();
            h(iD + 1);
            i(iD);
            Object obj = f().f22621a[e()];
            g();
            return obj;
        }
    }

    /* JADX INFO: renamed from: q5.d$f */
    public static final class f extends C0388d implements Iterator, C5.a {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(C2637d map) {
            super(map);
            AbstractC2304t.f(map, "map");
        }

        @Override // java.util.Iterator
        public Object next() {
            c();
            if (d() >= f().f22626f) {
                throw new NoSuchElementException();
            }
            int iD = d();
            h(iD + 1);
            i(iD);
            Object[] objArr = f().f22622b;
            AbstractC2304t.c(objArr);
            Object obj = objArr[e()];
            g();
            return obj;
        }
    }

    static {
        C2637d c2637d = new C2637d(0);
        c2637d.f22633m = true;
        f22620o = c2637d;
    }

    public C2637d() {
        this(8);
    }

    private final void I() {
        this.f22628h++;
    }

    private final void s(int i8) {
        if (i8 < 0) {
            throw new OutOfMemoryError();
        }
        if (i8 > x()) {
            int iE = AbstractC2582d.f22376a.e(x(), i8);
            this.f22621a = AbstractC2636c.e(this.f22621a, iE);
            Object[] objArr = this.f22622b;
            this.f22622b = objArr != null ? AbstractC2636c.e(objArr, iE) : null;
            int[] iArrCopyOf = Arrays.copyOf(this.f22623c, iE);
            AbstractC2304t.e(iArrCopyOf, "copyOf(...)");
            this.f22623c = iArrCopyOf;
            int iC = f22619n.c(iE);
            if (iC > z()) {
                J(iC);
            }
        }
    }

    private final void t(int i8) {
        if (P(i8)) {
            n(true);
        } else {
            s(this.f22626f + i8);
        }
    }

    public Set A() {
        C2639f c2639f = this.f22630j;
        if (c2639f != null) {
            return c2639f;
        }
        C2639f c2639f2 = new C2639f(this);
        this.f22630j = c2639f2;
        return c2639f2;
    }

    public int B() {
        return this.f22629i;
    }

    public Collection C() {
        C2640g c2640g = this.f22631k;
        if (c2640g != null) {
            return c2640g;
        }
        C2640g c2640g2 = new C2640g(this);
        this.f22631k = c2640g2;
        return c2640g2;
    }

    public final int D(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f22627g;
    }

    public final e E() {
        return new e(this);
    }

    public final boolean F(Collection collection) {
        boolean z7 = false;
        if (collection.isEmpty()) {
            return false;
        }
        t(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (G((Map.Entry) it.next())) {
                z7 = true;
            }
        }
        return z7;
    }

    public final boolean G(Map.Entry entry) {
        int iJ = j(entry.getKey());
        Object[] objArrK = k();
        if (iJ >= 0) {
            objArrK[iJ] = entry.getValue();
            return true;
        }
        int i8 = (-iJ) - 1;
        if (AbstractC2304t.b(entry.getValue(), objArrK[i8])) {
            return false;
        }
        objArrK[i8] = entry.getValue();
        return true;
    }

    public final boolean H(int i8) {
        int iD = D(this.f22621a[i8]);
        int i9 = this.f22625e;
        while (true) {
            int[] iArr = this.f22624d;
            if (iArr[iD] == 0) {
                iArr[iD] = i8 + 1;
                this.f22623c[i8] = iD;
                return true;
            }
            i9--;
            if (i9 < 0) {
                return false;
            }
            iD = iD == 0 ? z() - 1 : iD - 1;
        }
    }

    public final void J(int i8) {
        I();
        int i9 = 0;
        if (this.f22626f > size()) {
            n(false);
        }
        this.f22624d = new int[i8];
        this.f22627g = f22619n.d(i8);
        while (i9 < this.f22626f) {
            int i10 = i9 + 1;
            if (!H(i9)) {
                throw new IllegalStateException("This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?");
            }
            i9 = i10;
        }
    }

    public final boolean K(Map.Entry entry) {
        AbstractC2304t.f(entry, "entry");
        m();
        int iV = v(entry.getKey());
        if (iV < 0) {
            return false;
        }
        Object[] objArr = this.f22622b;
        AbstractC2304t.c(objArr);
        if (!AbstractC2304t.b(objArr[iV], entry.getValue())) {
            return false;
        }
        L(iV);
        return true;
    }

    public final void L(int i8) {
        AbstractC2636c.f(this.f22621a, i8);
        Object[] objArr = this.f22622b;
        if (objArr != null) {
            AbstractC2636c.f(objArr, i8);
        }
        M(this.f22623c[i8]);
        this.f22623c[i8] = -1;
        this.f22629i = size() - 1;
        I();
    }

    public final void M(int i8) {
        int iD = i.d(this.f22625e * 2, z() / 2);
        int i9 = 0;
        int i10 = i8;
        do {
            i8 = i8 == 0 ? z() - 1 : i8 - 1;
            i9++;
            if (i9 > this.f22625e) {
                this.f22624d[i10] = 0;
                return;
            }
            int[] iArr = this.f22624d;
            int i11 = iArr[i8];
            if (i11 == 0) {
                iArr[i10] = 0;
                return;
            }
            if (i11 < 0) {
                iArr[i10] = -1;
            } else {
                int i12 = i11 - 1;
                if (((D(this.f22621a[i12]) - i8) & (z() - 1)) >= i9) {
                    this.f22624d[i10] = i11;
                    this.f22623c[i12] = i10;
                }
                iD--;
            }
            i10 = i8;
            i9 = 0;
            iD--;
        } while (iD >= 0);
        this.f22624d[i10] = -1;
    }

    public final boolean N(Object obj) {
        m();
        int iV = v(obj);
        if (iV < 0) {
            return false;
        }
        L(iV);
        return true;
    }

    public final boolean O(Object obj) {
        m();
        int iW = w(obj);
        if (iW < 0) {
            return false;
        }
        L(iW);
        return true;
    }

    public final boolean P(int i8) {
        int iX = x();
        int i9 = this.f22626f;
        int i10 = iX - i9;
        int size = i9 - size();
        return i10 < i8 && i10 + size >= i8 && size >= x() / 4;
    }

    public final f Q() {
        return new f(this);
    }

    @Override // java.util.Map
    public void clear() {
        m();
        int i8 = this.f22626f - 1;
        if (i8 >= 0) {
            int i9 = 0;
            while (true) {
                int[] iArr = this.f22623c;
                int i10 = iArr[i9];
                if (i10 >= 0) {
                    this.f22624d[i10] = 0;
                    iArr[i9] = -1;
                }
                if (i9 == i8) {
                    break;
                } else {
                    i9++;
                }
            }
        }
        AbstractC2636c.g(this.f22621a, 0, this.f22626f);
        Object[] objArr = this.f22622b;
        if (objArr != null) {
            AbstractC2636c.g(objArr, 0, this.f22626f);
        }
        this.f22629i = 0;
        this.f22626f = 0;
        I();
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
        return obj == this || ((obj instanceof Map) && q((Map) obj));
    }

    @Override // java.util.Map
    public Object get(Object obj) {
        int iV = v(obj);
        if (iV < 0) {
            return null;
        }
        Object[] objArr = this.f22622b;
        AbstractC2304t.c(objArr);
        return objArr[iV];
    }

    @Override // java.util.Map
    public int hashCode() {
        b bVarU = u();
        int iL = 0;
        while (bVarU.hasNext()) {
            iL += bVarU.l();
        }
        return iL;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    public final int j(Object obj) {
        m();
        while (true) {
            int iD = D(obj);
            int iD2 = i.d(this.f22625e * 2, z() / 2);
            int i8 = 0;
            while (true) {
                int i9 = this.f22624d[iD];
                if (i9 <= 0) {
                    if (this.f22626f < x()) {
                        int i10 = this.f22626f;
                        int i11 = i10 + 1;
                        this.f22626f = i11;
                        this.f22621a[i10] = obj;
                        this.f22623c[i10] = iD;
                        this.f22624d[iD] = i11;
                        this.f22629i = size() + 1;
                        I();
                        if (i8 > this.f22625e) {
                            this.f22625e = i8;
                        }
                        return i10;
                    }
                    t(1);
                } else {
                    if (AbstractC2304t.b(this.f22621a[i9 - 1], obj)) {
                        return -i9;
                    }
                    i8++;
                    if (i8 > iD2) {
                        J(z() * 2);
                        break;
                    }
                    iD = iD == 0 ? z() - 1 : iD - 1;
                }
            }
        }
    }

    public final Object[] k() {
        Object[] objArr = this.f22622b;
        if (objArr != null) {
            return objArr;
        }
        Object[] objArrD = AbstractC2636c.d(x());
        this.f22622b = objArrD;
        return objArrD;
    }

    @Override // java.util.Map
    public final /* bridge */ Set keySet() {
        return A();
    }

    public final Map l() {
        m();
        this.f22633m = true;
        if (size() > 0) {
            return this;
        }
        C2637d c2637d = f22620o;
        AbstractC2304t.d(c2637d, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return c2637d;
    }

    public final void m() {
        if (this.f22633m) {
            throw new UnsupportedOperationException();
        }
    }

    public final void n(boolean z7) {
        int i8;
        Object[] objArr = this.f22622b;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            i8 = this.f22626f;
            if (i9 >= i8) {
                break;
            }
            int[] iArr = this.f22623c;
            int i11 = iArr[i9];
            if (i11 >= 0) {
                Object[] objArr2 = this.f22621a;
                objArr2[i10] = objArr2[i9];
                if (objArr != null) {
                    objArr[i10] = objArr[i9];
                }
                if (z7) {
                    iArr[i10] = i11;
                    this.f22624d[i11] = i10 + 1;
                }
                i10++;
            }
            i9++;
        }
        AbstractC2636c.g(this.f22621a, i10, i8);
        if (objArr != null) {
            AbstractC2636c.g(objArr, i10, this.f22626f);
        }
        this.f22626f = i10;
    }

    public final boolean o(Collection m8) {
        AbstractC2304t.f(m8, "m");
        for (Object obj : m8) {
            if (obj != null) {
                try {
                    if (!p((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final boolean p(Map.Entry entry) {
        AbstractC2304t.f(entry, "entry");
        int iV = v(entry.getKey());
        if (iV < 0) {
            return false;
        }
        Object[] objArr = this.f22622b;
        AbstractC2304t.c(objArr);
        return AbstractC2304t.b(objArr[iV], entry.getValue());
    }

    @Override // java.util.Map
    public Object put(Object obj, Object obj2) {
        m();
        int iJ = j(obj);
        Object[] objArrK = k();
        if (iJ >= 0) {
            objArrK[iJ] = obj2;
            return null;
        }
        int i8 = (-iJ) - 1;
        Object obj3 = objArrK[i8];
        objArrK[i8] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public void putAll(Map from) {
        AbstractC2304t.f(from, "from");
        m();
        F(from.entrySet());
    }

    public final boolean q(Map map) {
        return size() == map.size() && o(map.entrySet());
    }

    @Override // java.util.Map
    public Object remove(Object obj) {
        m();
        int iV = v(obj);
        if (iV < 0) {
            return null;
        }
        Object[] objArr = this.f22622b;
        AbstractC2304t.c(objArr);
        Object obj2 = objArr[iV];
        L(iV);
        return obj2;
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return B();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((size() * 3) + 2);
        sb.append("{");
        b bVarU = u();
        int i8 = 0;
        while (bVarU.hasNext()) {
            if (i8 > 0) {
                sb.append(", ");
            }
            bVarU.k(sb);
            i8++;
        }
        sb.append("}");
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }

    public final b u() {
        return new b(this);
    }

    public final int v(Object obj) {
        int iD = D(obj);
        int i8 = this.f22625e;
        while (true) {
            int i9 = this.f22624d[iD];
            if (i9 == 0) {
                return -1;
            }
            if (i9 > 0) {
                int i10 = i9 - 1;
                if (AbstractC2304t.b(this.f22621a[i10], obj)) {
                    return i10;
                }
            }
            i8--;
            if (i8 < 0) {
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
        int i8 = this.f22626f;
        while (true) {
            i8--;
            if (i8 < 0) {
                return -1;
            }
            if (this.f22623c[i8] >= 0) {
                Object[] objArr = this.f22622b;
                AbstractC2304t.c(objArr);
                if (AbstractC2304t.b(objArr[i8], obj)) {
                    return i8;
                }
            }
        }
    }

    public final int x() {
        return this.f22621a.length;
    }

    public Set y() {
        C2638e c2638e = this.f22632l;
        if (c2638e != null) {
            return c2638e;
        }
        C2638e c2638e2 = new C2638e(this);
        this.f22632l = c2638e2;
        return c2638e2;
    }

    public final int z() {
        return this.f22624d.length;
    }

    public C2637d(int i8) {
        this(AbstractC2636c.d(i8), null, new int[i8], new int[f22619n.c(i8)], 2, 0);
    }

    public C2637d(Object[] objArr, Object[] objArr2, int[] iArr, int[] iArr2, int i8, int i9) {
        this.f22621a = objArr;
        this.f22622b = objArr2;
        this.f22623c = iArr;
        this.f22624d = iArr2;
        this.f22625e = i8;
        this.f22626f = i9;
        this.f22627g = f22619n.d(z());
    }
}
