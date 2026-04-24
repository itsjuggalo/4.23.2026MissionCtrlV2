package t2;

import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import y2.C1946a;

/* JADX INFO: renamed from: t2.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1790g extends C1946a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Reader f14769u = new a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Object f14770v = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Object[] f14771q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f14772r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String[] f14773s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int[] f14774t;

    /* JADX INFO: renamed from: t2.g$a */
    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i4, int i5) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: renamed from: t2.g$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14775a;

        static {
            int[] iArr = new int[y2.b.values().length];
            f14775a = iArr;
            try {
                iArr[y2.b.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14775a[y2.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14775a[y2.b.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14775a[y2.b.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public C1790g(q2.j jVar) {
        super(f14769u);
        this.f14771q = new Object[32];
        this.f14772r = 0;
        this.f14773s = new String[32];
        this.f14774t = new int[32];
        K0(jVar);
    }

    private String g0() {
        return " at path " + K();
    }

    @Override // y2.C1946a
    public void B0() throws y2.d {
        int i4 = b.f14775a[r0().ordinal()];
        if (i4 == 1) {
            G0(true);
            return;
        }
        if (i4 == 2) {
            E();
            return;
        }
        if (i4 == 3) {
            G();
            return;
        }
        if (i4 != 4) {
            I0();
            int i5 = this.f14772r;
            if (i5 > 0) {
                int[] iArr = this.f14774t;
                int i6 = i5 - 1;
                iArr[i6] = iArr[i6] + 1;
            }
        }
    }

    @Override // y2.C1946a
    public void E() {
        E0(y2.b.END_ARRAY);
        I0();
        I0();
        int i4 = this.f14772r;
        if (i4 > 0) {
            int[] iArr = this.f14774t;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    public final void E0(y2.b bVar) {
        if (r0() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + r0() + g0());
    }

    public q2.j F0() throws y2.d {
        y2.b bVarR0 = r0();
        if (bVarR0 != y2.b.NAME && bVarR0 != y2.b.END_ARRAY && bVarR0 != y2.b.END_OBJECT && bVarR0 != y2.b.END_DOCUMENT) {
            q2.j jVar = (q2.j) H0();
            B0();
            return jVar;
        }
        throw new IllegalStateException("Unexpected " + bVarR0 + " when reading a JsonElement.");
    }

    @Override // y2.C1946a
    public void G() {
        E0(y2.b.END_OBJECT);
        this.f14773s[this.f14772r - 1] = null;
        I0();
        I0();
        int i4 = this.f14772r;
        if (i4 > 0) {
            int[] iArr = this.f14774t;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    public final String G0(boolean z4) {
        E0(y2.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) H0()).next();
        String str = (String) entry.getKey();
        this.f14773s[this.f14772r - 1] = z4 ? "<skipped>" : str;
        K0(entry.getValue());
        return str;
    }

    public final Object H0() {
        return this.f14771q[this.f14772r - 1];
    }

    public final Object I0() {
        Object[] objArr = this.f14771q;
        int i4 = this.f14772r - 1;
        this.f14772r = i4;
        Object obj = objArr[i4];
        objArr[i4] = null;
        return obj;
    }

    public void J0() {
        E0(y2.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) H0()).next();
        K0(entry.getValue());
        K0(new q2.o((String) entry.getKey()));
    }

    @Override // y2.C1946a
    public String K() {
        return P(false);
    }

    public final void K0(Object obj) {
        int i4 = this.f14772r;
        Object[] objArr = this.f14771q;
        if (i4 == objArr.length) {
            int i5 = i4 * 2;
            this.f14771q = Arrays.copyOf(objArr, i5);
            this.f14774t = Arrays.copyOf(this.f14774t, i5);
            this.f14773s = (String[]) Arrays.copyOf(this.f14773s, i5);
        }
        Object[] objArr2 = this.f14771q;
        int i6 = this.f14772r;
        this.f14772r = i6 + 1;
        objArr2[i6] = obj;
    }

    public final String P(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i4 = 0;
        while (true) {
            int i5 = this.f14772r;
            if (i4 >= i5) {
                return sb.toString();
            }
            Object[] objArr = this.f14771q;
            Object obj = objArr[i4];
            if (obj instanceof q2.g) {
                i4++;
                if (i4 < i5 && (objArr[i4] instanceof Iterator)) {
                    int i6 = this.f14774t[i4];
                    if (z4 && i6 > 0 && (i4 == i5 - 1 || i4 == i5 - 2)) {
                        i6--;
                    }
                    sb.append('[');
                    sb.append(i6);
                    sb.append(']');
                }
            } else if ((obj instanceof q2.m) && (i4 = i4 + 1) < i5 && (objArr[i4] instanceof Iterator)) {
                sb.append(com.amazon.a.a.o.c.a.b.f8816a);
                String str = this.f14773s[i4];
                if (str != null) {
                    sb.append(str);
                }
            }
            i4++;
        }
    }

    @Override // y2.C1946a
    public String S() {
        return P(true);
    }

    @Override // y2.C1946a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f14771q = new Object[]{f14770v};
        this.f14772r = 1;
    }

    @Override // y2.C1946a
    public boolean d0() throws y2.d {
        y2.b bVarR0 = r0();
        return (bVarR0 == y2.b.END_OBJECT || bVarR0 == y2.b.END_ARRAY || bVarR0 == y2.b.END_DOCUMENT) ? false : true;
    }

    @Override // y2.C1946a
    public void f() {
        E0(y2.b.BEGIN_ARRAY);
        K0(((q2.g) H0()).iterator());
        this.f14774t[this.f14772r - 1] = 0;
    }

    @Override // y2.C1946a
    public void g() {
        E0(y2.b.BEGIN_OBJECT);
        K0(((q2.m) H0()).r().iterator());
    }

    @Override // y2.C1946a
    public boolean h0() {
        E0(y2.b.BOOLEAN);
        boolean zC = ((q2.o) I0()).c();
        int i4 = this.f14772r;
        if (i4 > 0) {
            int[] iArr = this.f14774t;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return zC;
    }

    @Override // y2.C1946a
    public double i0() throws y2.d {
        y2.b bVarR0 = r0();
        y2.b bVar = y2.b.NUMBER;
        if (bVarR0 != bVar && bVarR0 != y2.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarR0 + g0());
        }
        double dS = ((q2.o) H0()).s();
        if (!e0() && (Double.isNaN(dS) || Double.isInfinite(dS))) {
            throw new y2.d("JSON forbids NaN and infinities: " + dS);
        }
        I0();
        int i4 = this.f14772r;
        if (i4 > 0) {
            int[] iArr = this.f14774t;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return dS;
    }

    @Override // y2.C1946a
    public int j0() throws y2.d {
        y2.b bVarR0 = r0();
        y2.b bVar = y2.b.NUMBER;
        if (bVarR0 != bVar && bVarR0 != y2.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarR0 + g0());
        }
        int iT = ((q2.o) H0()).t();
        I0();
        int i4 = this.f14772r;
        if (i4 > 0) {
            int[] iArr = this.f14774t;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return iT;
    }

    @Override // y2.C1946a
    public long k0() throws y2.d {
        y2.b bVarR0 = r0();
        y2.b bVar = y2.b.NUMBER;
        if (bVarR0 != bVar && bVarR0 != y2.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarR0 + g0());
        }
        long jU = ((q2.o) H0()).u();
        I0();
        int i4 = this.f14772r;
        if (i4 > 0) {
            int[] iArr = this.f14774t;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
        return jU;
    }

    @Override // y2.C1946a
    public String l0() {
        return G0(false);
    }

    @Override // y2.C1946a
    public void n0() {
        E0(y2.b.NULL);
        I0();
        int i4 = this.f14772r;
        if (i4 > 0) {
            int[] iArr = this.f14774t;
            int i5 = i4 - 1;
            iArr[i5] = iArr[i5] + 1;
        }
    }

    @Override // y2.C1946a
    public String p0() throws y2.d {
        y2.b bVarR0 = r0();
        y2.b bVar = y2.b.STRING;
        if (bVarR0 == bVar || bVarR0 == y2.b.NUMBER) {
            String strL = ((q2.o) I0()).l();
            int i4 = this.f14772r;
            if (i4 > 0) {
                int[] iArr = this.f14774t;
                int i5 = i4 - 1;
                iArr[i5] = iArr[i5] + 1;
            }
            return strL;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarR0 + g0());
    }

    @Override // y2.C1946a
    public y2.b r0() throws y2.d {
        if (this.f14772r == 0) {
            return y2.b.END_DOCUMENT;
        }
        Object objH0 = H0();
        if (objH0 instanceof Iterator) {
            boolean z4 = this.f14771q[this.f14772r - 2] instanceof q2.m;
            Iterator it = (Iterator) objH0;
            if (!it.hasNext()) {
                return z4 ? y2.b.END_OBJECT : y2.b.END_ARRAY;
            }
            if (z4) {
                return y2.b.NAME;
            }
            K0(it.next());
            return r0();
        }
        if (objH0 instanceof q2.m) {
            return y2.b.BEGIN_OBJECT;
        }
        if (objH0 instanceof q2.g) {
            return y2.b.BEGIN_ARRAY;
        }
        if (objH0 instanceof q2.o) {
            q2.o oVar = (q2.o) objH0;
            if (oVar.z()) {
                return y2.b.STRING;
            }
            if (oVar.w()) {
                return y2.b.BOOLEAN;
            }
            if (oVar.y()) {
                return y2.b.NUMBER;
            }
            throw new AssertionError();
        }
        if (objH0 instanceof q2.l) {
            return y2.b.NULL;
        }
        if (objH0 == f14770v) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new y2.d("Custom JsonElement subclass " + objH0.getClass().getName() + " is not supported");
    }

    @Override // y2.C1946a
    public String toString() {
        return C1790g.class.getSimpleName() + g0();
    }
}
