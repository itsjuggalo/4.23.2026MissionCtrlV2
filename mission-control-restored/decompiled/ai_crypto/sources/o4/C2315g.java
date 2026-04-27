package o4;

import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import l4.AbstractC2177j;
import l4.C2174g;
import t4.C2657a;

/* JADX INFO: renamed from: o4.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2315g extends C2657a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Reader f20078u = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Object f20079v = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Object[] f20080q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20081r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String[] f20082s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int[] f20083t;

    /* JADX INFO: renamed from: o4.g$a */
    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i7, int i8) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: o4.g$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f20084a;

        static {
            int[] iArr = new int[t4.b.values().length];
            f20084a = iArr;
            try {
                iArr[t4.b.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20084a[t4.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20084a[t4.b.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20084a[t4.b.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C2315g(AbstractC2177j abstractC2177j) {
        super(f20078u);
        this.f20080q = new Object[32];
        this.f20081r = 0;
        this.f20082s = new String[32];
        this.f20083t = new int[32];
        f1(abstractC2177j);
    }

    private String B0() {
        return " at path " + V();
    }

    @Override // t4.C2657a
    public void A() {
        Z0(t4.b.BEGIN_OBJECT);
        f1(((l4.m) c1()).p().iterator());
    }

    @Override // t4.C2657a
    public boolean C0() {
        Z0(t4.b.BOOLEAN);
        boolean zA = ((l4.o) d1()).a();
        int i7 = this.f20081r;
        if (i7 > 0) {
            int[] iArr = this.f20083t;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return zA;
    }

    @Override // t4.C2657a
    public double D0() throws t4.d {
        t4.b bVarM0 = M0();
        t4.b bVar = t4.b.NUMBER;
        if (bVarM0 != bVar && bVarM0 != t4.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarM0 + B0());
        }
        double dQ = ((l4.o) c1()).q();
        if (!z0() && (Double.isNaN(dQ) || Double.isInfinite(dQ))) {
            throw new t4.d("JSON forbids NaN and infinities: " + dQ);
        }
        d1();
        int i7 = this.f20081r;
        if (i7 > 0) {
            int[] iArr = this.f20083t;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return dQ;
    }

    @Override // t4.C2657a
    public int E0() throws t4.d {
        t4.b bVarM0 = M0();
        t4.b bVar = t4.b.NUMBER;
        if (bVarM0 != bVar && bVarM0 != t4.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarM0 + B0());
        }
        int iR = ((l4.o) c1()).r();
        d1();
        int i7 = this.f20081r;
        if (i7 > 0) {
            int[] iArr = this.f20083t;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return iR;
    }

    @Override // t4.C2657a
    public long F0() throws t4.d {
        t4.b bVarM0 = M0();
        t4.b bVar = t4.b.NUMBER;
        if (bVarM0 != bVar && bVarM0 != t4.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarM0 + B0());
        }
        long jS = ((l4.o) c1()).s();
        d1();
        int i7 = this.f20081r;
        if (i7 > 0) {
            int[] iArr = this.f20083t;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
        return jS;
    }

    @Override // t4.C2657a
    public String G0() {
        return b1(false);
    }

    @Override // t4.C2657a
    public void I0() {
        Z0(t4.b.NULL);
        d1();
        int i7 = this.f20081r;
        if (i7 > 0) {
            int[] iArr = this.f20083t;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
    }

    @Override // t4.C2657a
    public String K0() throws t4.d {
        t4.b bVarM0 = M0();
        t4.b bVar = t4.b.STRING;
        if (bVarM0 == bVar || bVarM0 == t4.b.NUMBER) {
            String strH = ((l4.o) d1()).h();
            int i7 = this.f20081r;
            if (i7 > 0) {
                int[] iArr = this.f20083t;
                int i8 = i7 - 1;
                iArr[i8] = iArr[i8] + 1;
            }
            return strH;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarM0 + B0());
    }

    @Override // t4.C2657a
    public void M() {
        Z0(t4.b.END_ARRAY);
        d1();
        d1();
        int i7 = this.f20081r;
        if (i7 > 0) {
            int[] iArr = this.f20083t;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
    }

    @Override // t4.C2657a
    public t4.b M0() throws t4.d {
        if (this.f20081r == 0) {
            return t4.b.END_DOCUMENT;
        }
        Object objC1 = c1();
        if (objC1 instanceof Iterator) {
            boolean z7 = this.f20080q[this.f20081r - 2] instanceof l4.m;
            Iterator it = (Iterator) objC1;
            if (!it.hasNext()) {
                return z7 ? t4.b.END_OBJECT : t4.b.END_ARRAY;
            }
            if (z7) {
                return t4.b.NAME;
            }
            f1(it.next());
            return M0();
        }
        if (objC1 instanceof l4.m) {
            return t4.b.BEGIN_OBJECT;
        }
        if (objC1 instanceof C2174g) {
            return t4.b.BEGIN_ARRAY;
        }
        if (objC1 instanceof l4.o) {
            l4.o oVar = (l4.o) objC1;
            if (oVar.y()) {
                return t4.b.STRING;
            }
            if (oVar.u()) {
                return t4.b.BOOLEAN;
            }
            if (oVar.x()) {
                return t4.b.NUMBER;
            }
            throw new AssertionError();
        }
        if (objC1 instanceof l4.l) {
            return t4.b.NULL;
        }
        if (objC1 == f20079v) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new t4.d("Custom JsonElement subclass " + objC1.getClass().getName() + " is not supported");
    }

    @Override // t4.C2657a
    public void O() {
        Z0(t4.b.END_OBJECT);
        this.f20082s[this.f20081r - 1] = null;
        d1();
        d1();
        int i7 = this.f20081r;
        if (i7 > 0) {
            int[] iArr = this.f20083t;
            int i8 = i7 - 1;
            iArr[i8] = iArr[i8] + 1;
        }
    }

    @Override // t4.C2657a
    public String V() {
        return X(false);
    }

    @Override // t4.C2657a
    public void W0() throws t4.d {
        int i7 = b.f20084a[M0().ordinal()];
        if (i7 == 1) {
            b1(true);
            return;
        }
        if (i7 == 2) {
            M();
            return;
        }
        if (i7 == 3) {
            O();
            return;
        }
        if (i7 != 4) {
            d1();
            int i8 = this.f20081r;
            if (i8 > 0) {
                int[] iArr = this.f20083t;
                int i9 = i8 - 1;
                iArr[i9] = iArr[i9] + 1;
            }
        }
    }

    public final String X(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i7 = 0;
        while (true) {
            int i8 = this.f20081r;
            if (i7 >= i8) {
                return sb.toString();
            }
            Object[] objArr = this.f20080q;
            Object obj = objArr[i7];
            if (obj instanceof C2174g) {
                i7++;
                if (i7 < i8 && (objArr[i7] instanceof Iterator)) {
                    int i9 = this.f20083t[i7];
                    if (z7 && i9 > 0 && (i7 == i8 - 1 || i7 == i8 - 2)) {
                        i9--;
                    }
                    sb.append('[');
                    sb.append(i9);
                    sb.append(']');
                }
            } else if ((obj instanceof l4.m) && (i7 = i7 + 1) < i8 && (objArr[i7] instanceof Iterator)) {
                sb.append(com.amazon.a.a.o.c.a.b.f10001a);
                String str = this.f20082s[i7];
                if (str != null) {
                    sb.append(str);
                }
            }
            i7++;
        }
    }

    public final void Z0(t4.b bVar) {
        if (M0() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + M0() + B0());
    }

    public AbstractC2177j a1() throws t4.d {
        t4.b bVarM0 = M0();
        if (bVarM0 != t4.b.NAME && bVarM0 != t4.b.END_ARRAY && bVarM0 != t4.b.END_OBJECT && bVarM0 != t4.b.END_DOCUMENT) {
            AbstractC2177j abstractC2177j = (AbstractC2177j) c1();
            W0();
            return abstractC2177j;
        }
        throw new IllegalStateException("Unexpected " + bVarM0 + " when reading a JsonElement.");
    }

    public final String b1(boolean z7) {
        Z0(t4.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) c1()).next();
        String str = (String) entry.getKey();
        this.f20082s[this.f20081r - 1] = z7 ? "<skipped>" : str;
        f1(entry.getValue());
        return str;
    }

    @Override // t4.C2657a
    public String c0() {
        return X(true);
    }

    public final Object c1() {
        return this.f20080q[this.f20081r - 1];
    }

    @Override // t4.C2657a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f20080q = new Object[]{f20079v};
        this.f20081r = 1;
    }

    public final Object d1() {
        Object[] objArr = this.f20080q;
        int i7 = this.f20081r - 1;
        this.f20081r = i7;
        Object obj = objArr[i7];
        objArr[i7] = null;
        return obj;
    }

    public void e1() {
        Z0(t4.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) c1()).next();
        f1(entry.getValue());
        f1(new l4.o((String) entry.getKey()));
    }

    public final void f1(Object obj) {
        int i7 = this.f20081r;
        Object[] objArr = this.f20080q;
        if (i7 == objArr.length) {
            int i8 = i7 * 2;
            this.f20080q = Arrays.copyOf(objArr, i8);
            this.f20083t = Arrays.copyOf(this.f20083t, i8);
            this.f20082s = (String[]) Arrays.copyOf(this.f20082s, i8);
        }
        Object[] objArr2 = this.f20080q;
        int i9 = this.f20081r;
        this.f20081r = i9 + 1;
        objArr2[i9] = obj;
    }

    @Override // t4.C2657a
    public void i() {
        Z0(t4.b.BEGIN_ARRAY);
        f1(((C2174g) c1()).iterator());
        this.f20083t[this.f20081r - 1] = 0;
    }

    @Override // t4.C2657a
    public String toString() {
        return C2315g.class.getSimpleName() + B0();
    }

    @Override // t4.C2657a
    public boolean y0() throws t4.d {
        t4.b bVarM0 = M0();
        return (bVarM0 == t4.b.END_OBJECT || bVarM0 == t4.b.END_ARRAY || bVarM0 == t4.b.END_DOCUMENT) ? false : true;
    }
}
