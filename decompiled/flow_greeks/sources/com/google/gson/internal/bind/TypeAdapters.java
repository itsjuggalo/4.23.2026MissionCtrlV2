package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i;
import com.google.gson.internal.f0;
import com.google.gson.internal.x;
import com.google.gson.internal.z;
import com.google.gson.j;
import com.google.gson.p;
import com.google.gson.v;
import gb.c;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Currency;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TypeAdapters {
    public static final TypeAdapter A;
    public static final TypeAdapter B;
    public static final v C;
    public static final TypeAdapter D;
    public static final v E;
    public static final TypeAdapter F;
    public static final v G;
    public static final TypeAdapter H;
    public static final v I;
    public static final TypeAdapter J;
    public static final v K;
    public static final TypeAdapter L;
    public static final v M;
    public static final TypeAdapter N;
    public static final v O;
    public static final TypeAdapter P;
    public static final v Q;
    public static final TypeAdapter R;
    public static final v S;
    public static final TypeAdapter T;
    public static final v U;
    public static final TypeAdapter V;
    public static final v W;
    public static final v X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypeAdapter f6758a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f6759b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TypeAdapter f6760c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f6761d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TypeAdapter f6762e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TypeAdapter f6763f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v f6764g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TypeAdapter f6765h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v f6766i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final TypeAdapter f6767j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v f6768k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final TypeAdapter f6769l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final v f6770m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final TypeAdapter f6771n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final v f6772o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final TypeAdapter f6773p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final v f6774q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final TypeAdapter f6775r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final v f6776s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final TypeAdapter f6777t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final TypeAdapter f6778u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final TypeAdapter f6779v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final TypeAdapter f6780w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final v f6781x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final TypeAdapter f6782y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final TypeAdapter f6783z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f6798a;

        static {
            int[] iArr = new int[gb.b.values().length];
            f6798a = iArr;
            try {
                iArr[gb.b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6798a[gb.b.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6798a[gb.b.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        TypeAdapter typeAdapterB = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Class c(gb.a aVar) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + f0.a("java-lang-class-unsupported"));
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Class cls) {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?\nSee " + f0.a("java-lang-class-unsupported"));
            }
        }.b();
        f6758a = typeAdapterB;
        f6759b = b(Class.class, typeAdapterB);
        TypeAdapter typeAdapterB2 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public BitSet c(gb.a aVar) throws IOException {
                BitSet bitSet = new BitSet();
                aVar.c();
                gb.b bVarN0 = aVar.n0();
                int i10 = 0;
                while (bVarN0 != gb.b.END_ARRAY) {
                    int i11 = a.f6798a[bVarN0.ordinal()];
                    boolean zD0 = true;
                    if (i11 == 1 || i11 == 2) {
                        int iF0 = aVar.f0();
                        if (iF0 == 0) {
                            zD0 = false;
                        } else if (iF0 != 1) {
                            throw new p("Invalid bitset value " + iF0 + ", expected 0 or 1; at path " + aVar.O());
                        }
                    } else {
                        if (i11 != 3) {
                            throw new p("Invalid bitset value type: " + bVarN0 + "; at path " + aVar.K());
                        }
                        zD0 = aVar.d0();
                    }
                    if (zD0) {
                        bitSet.set(i10);
                    }
                    i10++;
                    bVarN0 = aVar.n0();
                }
                aVar.E();
                return bitSet;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, BitSet bitSet) throws IOException {
                cVar.o();
                int length = bitSet.length();
                for (int i10 = 0; i10 < length; i10++) {
                    cVar.l0(bitSet.get(i10) ? 1L : 0L);
                }
                cVar.E();
            }
        }.b();
        f6760c = typeAdapterB2;
        f6761d = b(BitSet.class, typeAdapterB2);
        TypeAdapter typeAdapter = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Boolean c(gb.a aVar) throws IOException {
                gb.b bVarN0 = aVar.n0();
                if (bVarN0 != gb.b.NULL) {
                    return bVarN0 == gb.b.STRING ? Boolean.valueOf(Boolean.parseBoolean(aVar.l0())) : Boolean.valueOf(aVar.d0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Boolean bool) throws IOException {
                cVar.m0(bool);
            }
        };
        f6762e = typeAdapter;
        f6763f = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Boolean c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return Boolean.valueOf(aVar.l0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Boolean bool) throws IOException {
                cVar.o0(bool == null ? "null" : bool.toString());
            }
        };
        f6764g = c(Boolean.TYPE, Boolean.class, typeAdapter);
        TypeAdapter typeAdapter2 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                try {
                    int iF0 = aVar.f0();
                    if (iF0 <= 255 && iF0 >= -128) {
                        return Byte.valueOf((byte) iF0);
                    }
                    throw new p("Lossy conversion from " + iF0 + " to byte; at path " + aVar.O());
                } catch (NumberFormatException e10) {
                    throw new p(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.a0();
                } else {
                    cVar.l0(number.byteValue());
                }
            }
        };
        f6765h = typeAdapter2;
        f6766i = c(Byte.TYPE, Byte.class, typeAdapter2);
        TypeAdapter typeAdapter3 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                try {
                    int iF0 = aVar.f0();
                    if (iF0 <= 65535 && iF0 >= -32768) {
                        return Short.valueOf((short) iF0);
                    }
                    throw new p("Lossy conversion from " + iF0 + " to short; at path " + aVar.O());
                } catch (NumberFormatException e10) {
                    throw new p(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.a0();
                } else {
                    cVar.l0(number.shortValue());
                }
            }
        };
        f6767j = typeAdapter3;
        f6768k = c(Short.TYPE, Short.class, typeAdapter3);
        TypeAdapter typeAdapter4 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                try {
                    return Integer.valueOf(aVar.f0());
                } catch (NumberFormatException e10) {
                    throw new p(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.a0();
                } else {
                    cVar.l0(number.intValue());
                }
            }
        };
        f6769l = typeAdapter4;
        f6770m = c(Integer.TYPE, Integer.class, typeAdapter4);
        TypeAdapter typeAdapterB3 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicInteger c(gb.a aVar) {
                try {
                    return new AtomicInteger(aVar.f0());
                } catch (NumberFormatException e10) {
                    throw new p(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, AtomicInteger atomicInteger) throws IOException {
                cVar.l0(atomicInteger.get());
            }
        }.b();
        f6771n = typeAdapterB3;
        f6772o = b(AtomicInteger.class, typeAdapterB3);
        TypeAdapter typeAdapterB4 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicBoolean c(gb.a aVar) {
                return new AtomicBoolean(aVar.d0());
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, AtomicBoolean atomicBoolean) throws IOException {
                cVar.p0(atomicBoolean.get());
            }
        }.b();
        f6773p = typeAdapterB4;
        f6774q = b(AtomicBoolean.class, typeAdapterB4);
        TypeAdapter typeAdapterB5 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicIntegerArray c(gb.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.c();
                while (aVar.Z()) {
                    try {
                        arrayList.add(Integer.valueOf(aVar.f0()));
                    } catch (NumberFormatException e10) {
                        throw new p(e10);
                    }
                }
                aVar.E();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i10 = 0; i10 < size; i10++) {
                    atomicIntegerArray.set(i10, ((Integer) arrayList.get(i10)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, AtomicIntegerArray atomicIntegerArray) throws IOException {
                cVar.o();
                int length = atomicIntegerArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    cVar.l0(atomicIntegerArray.get(i10));
                }
                cVar.E();
            }
        }.b();
        f6775r = typeAdapterB5;
        f6776s = b(AtomicIntegerArray.class, typeAdapterB5);
        f6777t = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                try {
                    return Long.valueOf(aVar.g0());
                } catch (NumberFormatException e10) {
                    throw new p(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.a0();
                } else {
                    cVar.l0(number.longValue());
                }
            }
        };
        f6778u = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return Float.valueOf((float) aVar.e0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.a0();
                    return;
                }
                if (!(number instanceof Float)) {
                    number = Float.valueOf(number.floatValue());
                }
                cVar.n0(number);
            }
        };
        f6779v = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return Double.valueOf(aVar.e0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.a0();
                } else {
                    cVar.k0(number.doubleValue());
                }
            }
        };
        TypeAdapter typeAdapter5 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Character c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                String strL0 = aVar.l0();
                if (strL0.length() == 1) {
                    return Character.valueOf(strL0.charAt(0));
                }
                throw new p("Expecting character, got: " + strL0 + "; at " + aVar.O());
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Character ch2) throws IOException {
                cVar.o0(ch2 == null ? null : String.valueOf(ch2));
            }
        };
        f6780w = typeAdapter5;
        f6781x = c(Character.TYPE, Character.class, typeAdapter5);
        TypeAdapter typeAdapter6 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public String c(gb.a aVar) throws IOException {
                gb.b bVarN0 = aVar.n0();
                if (bVarN0 != gb.b.NULL) {
                    return bVarN0 == gb.b.BOOLEAN ? Boolean.toString(aVar.d0()) : aVar.l0();
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, String str) throws IOException {
                cVar.o0(str);
            }
        };
        f6782y = typeAdapter6;
        f6783z = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public BigDecimal c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                String strL0 = aVar.l0();
                try {
                    return z.b(strL0);
                } catch (NumberFormatException e10) {
                    throw new p("Failed parsing '" + strL0 + "' as BigDecimal; at path " + aVar.O(), e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, BigDecimal bigDecimal) throws IOException {
                cVar.n0(bigDecimal);
            }
        };
        A = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public BigInteger c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                String strL0 = aVar.l0();
                try {
                    return z.c(strL0);
                } catch (NumberFormatException e10) {
                    throw new p("Failed parsing '" + strL0 + "' as BigInteger; at path " + aVar.O(), e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, BigInteger bigInteger) throws IOException {
                cVar.n0(bigInteger);
            }
        };
        B = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public x c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return new x(aVar.l0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, x xVar) throws IOException {
                cVar.n0(xVar);
            }
        };
        C = b(String.class, typeAdapter6);
        TypeAdapter typeAdapter7 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public StringBuilder c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return new StringBuilder(aVar.l0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, StringBuilder sb2) throws IOException {
                cVar.o0(sb2 == null ? null : sb2.toString());
            }
        };
        D = typeAdapter7;
        E = b(StringBuilder.class, typeAdapter7);
        TypeAdapter typeAdapter8 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public StringBuffer c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return new StringBuffer(aVar.l0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, StringBuffer stringBuffer) throws IOException {
                cVar.o0(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        F = typeAdapter8;
        G = b(StringBuffer.class, typeAdapter8);
        TypeAdapter typeAdapter9 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public URL c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                String strL0 = aVar.l0();
                if (strL0.equals("null")) {
                    return null;
                }
                return new URL(strL0);
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, URL url) throws IOException {
                cVar.o0(url == null ? null : url.toExternalForm());
            }
        };
        H = typeAdapter9;
        I = b(URL.class, typeAdapter9);
        TypeAdapter typeAdapter10 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public URI c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                try {
                    String strL0 = aVar.l0();
                    if (strL0.equals("null")) {
                        return null;
                    }
                    return new URI(strL0);
                } catch (URISyntaxException e10) {
                    throw new j(e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, URI uri) throws IOException {
                cVar.o0(uri == null ? null : uri.toASCIIString());
            }
        };
        J = typeAdapter10;
        K = b(URI.class, typeAdapter10);
        TypeAdapter typeAdapter11 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public InetAddress c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return InetAddress.getByName(aVar.l0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, InetAddress inetAddress) throws IOException {
                cVar.o0(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        L = typeAdapter11;
        M = e(InetAddress.class, typeAdapter11);
        TypeAdapter typeAdapter12 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public UUID c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                String strL0 = aVar.l0();
                try {
                    return UUID.fromString(strL0);
                } catch (IllegalArgumentException e10) {
                    throw new p("Failed parsing '" + strL0 + "' as UUID; at path " + aVar.O(), e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, UUID uuid) throws IOException {
                cVar.o0(uuid == null ? null : uuid.toString());
            }
        };
        N = typeAdapter12;
        O = b(UUID.class, typeAdapter12);
        TypeAdapter typeAdapterB6 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Currency c(gb.a aVar) throws IOException {
                String strL0 = aVar.l0();
                try {
                    return Currency.getInstance(strL0);
                } catch (IllegalArgumentException e10) {
                    throw new p("Failed parsing '" + strL0 + "' as Currency; at path " + aVar.O(), e10);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Currency currency) throws IOException {
                cVar.o0(currency.getCurrencyCode());
            }
        }.b();
        P = typeAdapterB6;
        Q = b(Currency.class, typeAdapterB6);
        TypeAdapter typeAdapter13 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Calendar c(gb.a aVar) throws IOException {
                int iF0;
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                aVar.e();
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                int i14 = 0;
                int i15 = 0;
                while (aVar.n0() != gb.b.END_OBJECT) {
                    String strH0 = aVar.h0();
                    iF0 = aVar.f0();
                    strH0.getClass();
                    switch (strH0) {
                        case "dayOfMonth":
                            i12 = iF0;
                            break;
                        case "minute":
                            i14 = iF0;
                            break;
                        case "second":
                            i15 = iF0;
                            break;
                        case "year":
                            i10 = iF0;
                            break;
                        case "month":
                            i11 = iF0;
                            break;
                        case "hourOfDay":
                            i13 = iF0;
                            break;
                    }
                }
                aVar.G();
                return new GregorianCalendar(i10, i11, i12, i13, i14, i15);
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Calendar calendar) throws IOException {
                if (calendar == null) {
                    cVar.a0();
                    return;
                }
                cVar.u();
                cVar.R("year");
                cVar.l0(calendar.get(1));
                cVar.R("month");
                cVar.l0(calendar.get(2));
                cVar.R("dayOfMonth");
                cVar.l0(calendar.get(5));
                cVar.R("hourOfDay");
                cVar.l0(calendar.get(11));
                cVar.R("minute");
                cVar.l0(calendar.get(12));
                cVar.R("second");
                cVar.l0(calendar.get(13));
                cVar.G();
            }
        };
        R = typeAdapter13;
        S = d(Calendar.class, GregorianCalendar.class, typeAdapter13);
        TypeAdapter typeAdapter14 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Locale c(gb.a aVar) throws IOException {
                if (aVar.n0() == gb.b.NULL) {
                    aVar.j0();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(aVar.l0(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(c cVar, Locale locale) throws IOException {
                cVar.o0(locale == null ? null : locale.toString());
            }
        };
        T = typeAdapter14;
        U = b(Locale.class, typeAdapter14);
        JsonElementTypeAdapter jsonElementTypeAdapter = JsonElementTypeAdapter.f6701a;
        V = jsonElementTypeAdapter;
        W = e(i.class, jsonElementTypeAdapter);
        X = EnumTypeAdapter.f6693d;
    }

    public static v a(final fb.a aVar, final TypeAdapter typeAdapter) {
        return new v() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, fb.a aVar2) {
                if (aVar2.equals(aVar)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static v b(final Class cls, final TypeAdapter typeAdapter) {
        return new v() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, fb.a aVar) {
                if (aVar.c() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static v c(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new v() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, fb.a aVar) {
                Class clsC = aVar.c();
                if (clsC == cls || clsC == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls2.getName() + "+" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static v d(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new v() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, fb.a aVar) {
                Class clsC = aVar.c();
                if (clsC == cls || clsC == cls2) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + "+" + cls2.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static v e(final Class cls, final TypeAdapter typeAdapter) {
        return new v() { // from class: com.google.gson.internal.bind.TypeAdapters.32
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, fb.a aVar) {
                final Class<?> clsC = aVar.c();
                if (cls.isAssignableFrom(clsC)) {
                    return new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.32.1
                        @Override // com.google.gson.TypeAdapter
                        public Object c(gb.a aVar2) {
                            Object objC = typeAdapter.c(aVar2);
                            if (objC == null || clsC.isInstance(objC)) {
                                return objC;
                            }
                            throw new p("Expected a " + clsC.getName() + " but was " + objC.getClass().getName() + "; at path " + aVar2.O());
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void e(c cVar, Object obj) {
                            typeAdapter.e(cVar, obj);
                        }
                    };
                }
                return null;
            }

            public String toString() {
                return "Factory[typeHierarchy=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }
}
