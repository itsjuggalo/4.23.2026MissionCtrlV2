package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import gb.d;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends gb.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Reader f6799u = new C0110a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Object f6800v = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Object[] f6801q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f6802r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String[] f6803s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int[] f6804t;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0110a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i10, int i11) {
            throw new AssertionError();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6805a;

        static {
            int[] iArr = new int[gb.b.values().length];
            f6805a = iArr;
            try {
                iArr[gb.b.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6805a[gb.b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6805a[gb.b.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f6805a[gb.b.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(i iVar) {
        super(f6799u);
        this.f6801q = new Object[32];
        this.f6802r = 0;
        this.f6803s = new String[32];
        this.f6804t = new int[32];
        G0(iVar);
    }

    private String c0() {
        return " at path " + K();
    }

    public final void A0(gb.b bVar) {
        if (n0() == bVar) {
            return;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + n0() + c0());
    }

    public i B0() throws d {
        gb.b bVarN0 = n0();
        if (bVarN0 != gb.b.NAME && bVarN0 != gb.b.END_ARRAY && bVarN0 != gb.b.END_OBJECT && bVarN0 != gb.b.END_DOCUMENT) {
            i iVar = (i) D0();
            x0();
            return iVar;
        }
        throw new IllegalStateException("Unexpected " + bVarN0 + " when reading a JsonElement.");
    }

    public final String C0(boolean z10) {
        A0(gb.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) D0()).next();
        String str = (String) entry.getKey();
        this.f6803s[this.f6802r - 1] = z10 ? "<skipped>" : str;
        G0(entry.getValue());
        return str;
    }

    public final Object D0() {
        return this.f6801q[this.f6802r - 1];
    }

    @Override // gb.a
    public void E() {
        A0(gb.b.END_ARRAY);
        E0();
        E0();
        int i10 = this.f6802r;
        if (i10 > 0) {
            int[] iArr = this.f6804t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public final Object E0() {
        Object[] objArr = this.f6801q;
        int i10 = this.f6802r - 1;
        this.f6802r = i10;
        Object obj = objArr[i10];
        objArr[i10] = null;
        return obj;
    }

    public void F0() {
        A0(gb.b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) D0()).next();
        G0(entry.getValue());
        G0(new n((String) entry.getKey()));
    }

    @Override // gb.a
    public void G() {
        A0(gb.b.END_OBJECT);
        this.f6803s[this.f6802r - 1] = null;
        E0();
        E0();
        int i10 = this.f6802r;
        if (i10 > 0) {
            int[] iArr = this.f6804t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    public final void G0(Object obj) {
        int i10 = this.f6802r;
        Object[] objArr = this.f6801q;
        if (i10 == objArr.length) {
            int i11 = i10 * 2;
            this.f6801q = Arrays.copyOf(objArr, i11);
            this.f6804t = Arrays.copyOf(this.f6804t, i11);
            this.f6803s = (String[]) Arrays.copyOf(this.f6803s, i11);
        }
        Object[] objArr2 = this.f6801q;
        int i12 = this.f6802r;
        this.f6802r = i12 + 1;
        objArr2[i12] = obj;
    }

    @Override // gb.a
    public String K() {
        return N(false);
    }

    public final String N(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('$');
        int i10 = 0;
        while (true) {
            int i11 = this.f6802r;
            if (i10 >= i11) {
                return sb2.toString();
            }
            Object[] objArr = this.f6801q;
            Object obj = objArr[i10];
            if (obj instanceof f) {
                i10++;
                if (i10 < i11 && (objArr[i10] instanceof Iterator)) {
                    int i12 = this.f6804t[i10];
                    if (z10 && i12 > 0 && (i10 == i11 - 1 || i10 == i11 - 2)) {
                        i12--;
                    }
                    sb2.append('[');
                    sb2.append(i12);
                    sb2.append(']');
                }
            } else if ((obj instanceof l) && (i10 = i10 + 1) < i11 && (objArr[i10] instanceof Iterator)) {
                sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
                String str = this.f6803s[i10];
                if (str != null) {
                    sb2.append(str);
                }
            }
            i10++;
        }
    }

    @Override // gb.a
    public String O() {
        return N(true);
    }

    @Override // gb.a
    public boolean Z() throws d {
        gb.b bVarN0 = n0();
        return (bVarN0 == gb.b.END_OBJECT || bVarN0 == gb.b.END_ARRAY || bVarN0 == gb.b.END_DOCUMENT) ? false : true;
    }

    @Override // gb.a
    public void c() {
        A0(gb.b.BEGIN_ARRAY);
        G0(((f) D0()).iterator());
        this.f6804t[this.f6802r - 1] = 0;
    }

    @Override // gb.a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f6801q = new Object[]{f6800v};
        this.f6802r = 1;
    }

    @Override // gb.a
    public boolean d0() {
        A0(gb.b.BOOLEAN);
        boolean zA = ((n) E0()).a();
        int i10 = this.f6802r;
        if (i10 > 0) {
            int[] iArr = this.f6804t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return zA;
    }

    @Override // gb.a
    public void e() {
        A0(gb.b.BEGIN_OBJECT);
        G0(((l) D0()).u().iterator());
    }

    @Override // gb.a
    public double e0() throws d {
        gb.b bVarN0 = n0();
        gb.b bVar = gb.b.NUMBER;
        if (bVarN0 != bVar && bVarN0 != gb.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarN0 + c0());
        }
        double dV = ((n) D0()).v();
        if (!a0() && (Double.isNaN(dV) || Double.isInfinite(dV))) {
            throw new d("JSON forbids NaN and infinities: " + dV);
        }
        E0();
        int i10 = this.f6802r;
        if (i10 > 0) {
            int[] iArr = this.f6804t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return dV;
    }

    @Override // gb.a
    public int f0() throws d {
        gb.b bVarN0 = n0();
        gb.b bVar = gb.b.NUMBER;
        if (bVarN0 != bVar && bVarN0 != gb.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarN0 + c0());
        }
        int iW = ((n) D0()).w();
        E0();
        int i10 = this.f6802r;
        if (i10 > 0) {
            int[] iArr = this.f6804t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return iW;
    }

    @Override // gb.a
    public long g0() throws d {
        gb.b bVarN0 = n0();
        gb.b bVar = gb.b.NUMBER;
        if (bVarN0 != bVar && bVarN0 != gb.b.STRING) {
            throw new IllegalStateException("Expected " + bVar + " but was " + bVarN0 + c0());
        }
        long jY = ((n) D0()).y();
        E0();
        int i10 = this.f6802r;
        if (i10 > 0) {
            int[] iArr = this.f6804t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
        return jY;
    }

    @Override // gb.a
    public String h0() {
        return C0(false);
    }

    @Override // gb.a
    public void j0() {
        A0(gb.b.NULL);
        E0();
        int i10 = this.f6802r;
        if (i10 > 0) {
            int[] iArr = this.f6804t;
            int i11 = i10 - 1;
            iArr[i11] = iArr[i11] + 1;
        }
    }

    @Override // gb.a
    public String l0() throws d {
        gb.b bVarN0 = n0();
        gb.b bVar = gb.b.STRING;
        if (bVarN0 == bVar || bVarN0 == gb.b.NUMBER) {
            String strF = ((n) E0()).f();
            int i10 = this.f6802r;
            if (i10 > 0) {
                int[] iArr = this.f6804t;
                int i11 = i10 - 1;
                iArr[i11] = iArr[i11] + 1;
            }
            return strF;
        }
        throw new IllegalStateException("Expected " + bVar + " but was " + bVarN0 + c0());
    }

    @Override // gb.a
    public gb.b n0() throws d {
        if (this.f6802r == 0) {
            return gb.b.END_DOCUMENT;
        }
        Object objD0 = D0();
        if (objD0 instanceof Iterator) {
            boolean z10 = this.f6801q[this.f6802r - 2] instanceof l;
            Iterator it = (Iterator) objD0;
            if (!it.hasNext()) {
                return z10 ? gb.b.END_OBJECT : gb.b.END_ARRAY;
            }
            if (z10) {
                return gb.b.NAME;
            }
            G0(it.next());
            return n0();
        }
        if (objD0 instanceof l) {
            return gb.b.BEGIN_OBJECT;
        }
        if (objD0 instanceof f) {
            return gb.b.BEGIN_ARRAY;
        }
        if (objD0 instanceof n) {
            n nVar = (n) objD0;
            if (nVar.R()) {
                return gb.b.STRING;
            }
            if (nVar.G()) {
                return gb.b.BOOLEAN;
            }
            if (nVar.L()) {
                return gb.b.NUMBER;
            }
            throw new AssertionError();
        }
        if (objD0 instanceof k) {
            return gb.b.NULL;
        }
        if (objD0 == f6800v) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new d("Custom JsonElement subclass " + objD0.getClass().getName() + " is not supported");
    }

    @Override // gb.a
    public String toString() {
        return a.class.getSimpleName() + c0();
    }

    @Override // gb.a
    public void x0() throws d {
        int i10 = b.f6805a[n0().ordinal()];
        if (i10 == 1) {
            C0(true);
            return;
        }
        if (i10 == 2) {
            E();
            return;
        }
        if (i10 == 3) {
            G();
            return;
        }
        if (i10 != 4) {
            E0();
            int i11 = this.f6802r;
            if (i11 > 0) {
                int[] iArr = this.f6804t;
                int i12 = i11 - 1;
                iArr[i12] = iArr[i12] + 1;
            }
        }
    }
}
