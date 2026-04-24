package com.google.gson.internal.bind;

import com.google.gson.f;
import com.google.gson.i;
import com.google.gson.k;
import com.google.gson.l;
import com.google.gson.n;
import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import p4.C2568a;
import p4.C2571d;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
public final class a extends C2568a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final Reader f16187u = new C0261a();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final Object f16188v = new Object();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Object[] f16189q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f16190r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public String[] f16191s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int[] f16192t;

    /* JADX INFO: renamed from: com.google.gson.internal.bind.a$a, reason: collision with other inner class name */
    public class C0261a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i8, int i9) {
            throw new AssertionError();
        }
    }

    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16193a;

        static {
            int[] iArr = new int[EnumC2569b.values().length];
            f16193a = iArr;
            try {
                iArr[EnumC2569b.NAME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16193a[EnumC2569b.END_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16193a[EnumC2569b.END_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16193a[EnumC2569b.END_DOCUMENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public a(i iVar) {
        super(f16187u);
        this.f16189q = new Object[32];
        this.f16190r = 0;
        this.f16191s = new String[32];
        this.f16192t = new int[32];
        Q0(iVar);
    }

    private String T() {
        return " at path " + K();
    }

    @Override // p4.C2568a
    public void B() {
        K0(EnumC2569b.END_ARRAY);
        O0();
        O0();
        int i8 = this.f16190r;
        if (i8 > 0) {
            int[] iArr = this.f16192t;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
    }

    @Override // p4.C2568a
    public void D() {
        K0(EnumC2569b.END_OBJECT);
        this.f16191s[this.f16190r - 1] = null;
        O0();
        O0();
        int i8 = this.f16190r;
        if (i8 > 0) {
            int[] iArr = this.f16192t;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
    }

    @Override // p4.C2568a
    public void H0() throws C2571d {
        int i8 = b.f16193a[x0().ordinal()];
        if (i8 == 1) {
            M0(true);
            return;
        }
        if (i8 == 2) {
            B();
            return;
        }
        if (i8 == 3) {
            D();
            return;
        }
        if (i8 != 4) {
            O0();
            int i9 = this.f16190r;
            if (i9 > 0) {
                int[] iArr = this.f16192t;
                int i10 = i9 - 1;
                iArr[i10] = iArr[i10] + 1;
            }
        }
    }

    @Override // p4.C2568a
    public String K() {
        return M(false);
    }

    public final void K0(EnumC2569b enumC2569b) {
        if (x0() == enumC2569b) {
            return;
        }
        throw new IllegalStateException("Expected " + enumC2569b + " but was " + x0() + T());
    }

    public i L0() throws C2571d {
        EnumC2569b enumC2569bX0 = x0();
        if (enumC2569bX0 != EnumC2569b.NAME && enumC2569bX0 != EnumC2569b.END_ARRAY && enumC2569bX0 != EnumC2569b.END_OBJECT && enumC2569bX0 != EnumC2569b.END_DOCUMENT) {
            i iVar = (i) N0();
            H0();
            return iVar;
        }
        throw new IllegalStateException("Unexpected " + enumC2569bX0 + " when reading a JsonElement.");
    }

    public final String M(boolean z7) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i8 = 0;
        while (true) {
            int i9 = this.f16190r;
            if (i8 >= i9) {
                return sb.toString();
            }
            Object[] objArr = this.f16189q;
            Object obj = objArr[i8];
            if (obj instanceof f) {
                i8++;
                if (i8 < i9 && (objArr[i8] instanceof Iterator)) {
                    int i10 = this.f16192t[i8];
                    if (z7 && i10 > 0 && (i8 == i9 - 1 || i8 == i9 - 2)) {
                        i10--;
                    }
                    sb.append('[');
                    sb.append(i10);
                    sb.append(']');
                }
            } else if ((obj instanceof l) && (i8 = i8 + 1) < i9 && (objArr[i8] instanceof Iterator)) {
                sb.append(com.amazon.a.a.o.c.a.b.f14112a);
                String str = this.f16191s[i8];
                if (str != null) {
                    sb.append(str);
                }
            }
            i8++;
        }
    }

    public final String M0(boolean z7) {
        K0(EnumC2569b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) N0()).next();
        String str = (String) entry.getKey();
        this.f16191s[this.f16190r - 1] = z7 ? "<skipped>" : str;
        Q0(entry.getValue());
        return str;
    }

    @Override // p4.C2568a
    public String N() {
        return M(true);
    }

    public final Object N0() {
        return this.f16189q[this.f16190r - 1];
    }

    public final Object O0() {
        Object[] objArr = this.f16189q;
        int i8 = this.f16190r - 1;
        this.f16190r = i8;
        Object obj = objArr[i8];
        objArr[i8] = null;
        return obj;
    }

    public void P0() {
        K0(EnumC2569b.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) N0()).next();
        Q0(entry.getValue());
        Q0(new n((String) entry.getKey()));
    }

    @Override // p4.C2568a
    public boolean Q() throws C2571d {
        EnumC2569b enumC2569bX0 = x0();
        return (enumC2569bX0 == EnumC2569b.END_OBJECT || enumC2569bX0 == EnumC2569b.END_ARRAY || enumC2569bX0 == EnumC2569b.END_DOCUMENT) ? false : true;
    }

    public final void Q0(Object obj) {
        int i8 = this.f16190r;
        Object[] objArr = this.f16189q;
        if (i8 == objArr.length) {
            int i9 = i8 * 2;
            this.f16189q = Arrays.copyOf(objArr, i9);
            this.f16192t = Arrays.copyOf(this.f16192t, i9);
            this.f16191s = (String[]) Arrays.copyOf(this.f16191s, i9);
        }
        Object[] objArr2 = this.f16189q;
        int i10 = this.f16190r;
        this.f16190r = i10 + 1;
        objArr2[i10] = obj;
    }

    @Override // p4.C2568a
    public boolean U() {
        K0(EnumC2569b.BOOLEAN);
        boolean zA = ((n) O0()).a();
        int i8 = this.f16190r;
        if (i8 > 0) {
            int[] iArr = this.f16192t;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
        return zA;
    }

    @Override // p4.C2568a
    public double W() throws C2571d {
        EnumC2569b enumC2569bX0 = x0();
        EnumC2569b enumC2569b = EnumC2569b.NUMBER;
        if (enumC2569bX0 != enumC2569b && enumC2569bX0 != EnumC2569b.STRING) {
            throw new IllegalStateException("Expected " + enumC2569b + " but was " + enumC2569bX0 + T());
        }
        double dK = ((n) N0()).K();
        if (!R() && (Double.isNaN(dK) || Double.isInfinite(dK))) {
            throw new C2571d("JSON forbids NaN and infinities: " + dK);
        }
        O0();
        int i8 = this.f16190r;
        if (i8 > 0) {
            int[] iArr = this.f16192t;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
        return dK;
    }

    @Override // p4.C2568a
    public int X() throws C2571d {
        EnumC2569b enumC2569bX0 = x0();
        EnumC2569b enumC2569b = EnumC2569b.NUMBER;
        if (enumC2569bX0 != enumC2569b && enumC2569bX0 != EnumC2569b.STRING) {
            throw new IllegalStateException("Expected " + enumC2569b + " but was " + enumC2569bX0 + T());
        }
        int iL = ((n) N0()).L();
        O0();
        int i8 = this.f16190r;
        if (i8 > 0) {
            int[] iArr = this.f16192t;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
        return iL;
    }

    @Override // p4.C2568a
    public long b0() throws C2571d {
        EnumC2569b enumC2569bX0 = x0();
        EnumC2569b enumC2569b = EnumC2569b.NUMBER;
        if (enumC2569bX0 != enumC2569b && enumC2569bX0 != EnumC2569b.STRING) {
            throw new IllegalStateException("Expected " + enumC2569b + " but was " + enumC2569bX0 + T());
        }
        long jM = ((n) N0()).M();
        O0();
        int i8 = this.f16190r;
        if (i8 > 0) {
            int[] iArr = this.f16192t;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
        return jM;
    }

    @Override // p4.C2568a
    public void c() {
        K0(EnumC2569b.BEGIN_ARRAY);
        Q0(((f) N0()).iterator());
        this.f16192t[this.f16190r - 1] = 0;
    }

    @Override // p4.C2568a, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f16189q = new Object[]{f16188v};
        this.f16190r = 1;
    }

    @Override // p4.C2568a
    public void e() {
        K0(EnumC2569b.BEGIN_OBJECT);
        Q0(((l) N0()).J().iterator());
    }

    @Override // p4.C2568a
    public String i0() {
        return M0(false);
    }

    @Override // p4.C2568a
    public void r0() {
        K0(EnumC2569b.NULL);
        O0();
        int i8 = this.f16190r;
        if (i8 > 0) {
            int[] iArr = this.f16192t;
            int i9 = i8 - 1;
            iArr[i9] = iArr[i9] + 1;
        }
    }

    @Override // p4.C2568a
    public String toString() {
        return a.class.getSimpleName() + T();
    }

    @Override // p4.C2568a
    public String v0() throws C2571d {
        EnumC2569b enumC2569bX0 = x0();
        EnumC2569b enumC2569b = EnumC2569b.STRING;
        if (enumC2569bX0 == enumC2569b || enumC2569bX0 == EnumC2569b.NUMBER) {
            String strH = ((n) O0()).h();
            int i8 = this.f16190r;
            if (i8 > 0) {
                int[] iArr = this.f16192t;
                int i9 = i8 - 1;
                iArr[i9] = iArr[i9] + 1;
            }
            return strH;
        }
        throw new IllegalStateException("Expected " + enumC2569b + " but was " + enumC2569bX0 + T());
    }

    @Override // p4.C2568a
    public EnumC2569b x0() throws C2571d {
        if (this.f16190r == 0) {
            return EnumC2569b.END_DOCUMENT;
        }
        Object objN0 = N0();
        if (objN0 instanceof Iterator) {
            boolean z7 = this.f16189q[this.f16190r - 2] instanceof l;
            Iterator it = (Iterator) objN0;
            if (!it.hasNext()) {
                return z7 ? EnumC2569b.END_OBJECT : EnumC2569b.END_ARRAY;
            }
            if (z7) {
                return EnumC2569b.NAME;
            }
            Q0(it.next());
            return x0();
        }
        if (objN0 instanceof l) {
            return EnumC2569b.BEGIN_OBJECT;
        }
        if (objN0 instanceof f) {
            return EnumC2569b.BEGIN_ARRAY;
        }
        if (objN0 instanceof n) {
            n nVar = (n) objN0;
            if (nVar.R()) {
                return EnumC2569b.STRING;
            }
            if (nVar.O()) {
                return EnumC2569b.BOOLEAN;
            }
            if (nVar.Q()) {
                return EnumC2569b.NUMBER;
            }
            throw new AssertionError();
        }
        if (objN0 instanceof k) {
            return EnumC2569b.NULL;
        }
        if (objN0 == f16188v) {
            throw new IllegalStateException("JsonReader is closed");
        }
        throw new C2571d("Custom JsonElement subclass " + objN0.getClass().getName() + " is not supported");
    }
}
