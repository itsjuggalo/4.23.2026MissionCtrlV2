package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.i;
import com.google.gson.internal.F;
import com.google.gson.internal.x;
import com.google.gson.internal.z;
import com.google.gson.j;
import com.google.gson.p;
import com.google.gson.v;
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
import o4.C2462a;
import p4.C2568a;
import p4.C2570c;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
public abstract class TypeAdapters {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final TypeAdapter f16122A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final TypeAdapter f16123B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final v f16124C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final TypeAdapter f16125D;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final v f16126E;

    /* JADX INFO: renamed from: F, reason: collision with root package name */
    public static final TypeAdapter f16127F;

    /* JADX INFO: renamed from: G, reason: collision with root package name */
    public static final v f16128G;

    /* JADX INFO: renamed from: H, reason: collision with root package name */
    public static final TypeAdapter f16129H;

    /* JADX INFO: renamed from: I, reason: collision with root package name */
    public static final v f16130I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public static final TypeAdapter f16131J;

    /* JADX INFO: renamed from: K, reason: collision with root package name */
    public static final v f16132K;

    /* JADX INFO: renamed from: L, reason: collision with root package name */
    public static final TypeAdapter f16133L;

    /* JADX INFO: renamed from: M, reason: collision with root package name */
    public static final v f16134M;

    /* JADX INFO: renamed from: N, reason: collision with root package name */
    public static final TypeAdapter f16135N;

    /* JADX INFO: renamed from: O, reason: collision with root package name */
    public static final v f16136O;

    /* JADX INFO: renamed from: P, reason: collision with root package name */
    public static final TypeAdapter f16137P;

    /* JADX INFO: renamed from: Q, reason: collision with root package name */
    public static final v f16138Q;

    /* JADX INFO: renamed from: R, reason: collision with root package name */
    public static final TypeAdapter f16139R;

    /* JADX INFO: renamed from: S, reason: collision with root package name */
    public static final v f16140S;

    /* JADX INFO: renamed from: T, reason: collision with root package name */
    public static final TypeAdapter f16141T;

    /* JADX INFO: renamed from: U, reason: collision with root package name */
    public static final v f16142U;

    /* JADX INFO: renamed from: V, reason: collision with root package name */
    public static final TypeAdapter f16143V;

    /* JADX INFO: renamed from: W, reason: collision with root package name */
    public static final v f16144W;

    /* JADX INFO: renamed from: X, reason: collision with root package name */
    public static final v f16145X;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TypeAdapter f16146a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final v f16147b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final TypeAdapter f16148c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final v f16149d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final TypeAdapter f16150e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final TypeAdapter f16151f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final v f16152g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final TypeAdapter f16153h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final v f16154i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final TypeAdapter f16155j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final v f16156k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final TypeAdapter f16157l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final v f16158m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final TypeAdapter f16159n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final v f16160o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final TypeAdapter f16161p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final v f16162q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final TypeAdapter f16163r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final v f16164s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final TypeAdapter f16165t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final TypeAdapter f16166u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final TypeAdapter f16167v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final TypeAdapter f16168w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final v f16169x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final TypeAdapter f16170y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final TypeAdapter f16171z;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f16186a;

        static {
            int[] iArr = new int[EnumC2569b.values().length];
            f16186a = iArr;
            try {
                iArr[EnumC2569b.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16186a[EnumC2569b.STRING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16186a[EnumC2569b.BOOLEAN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        TypeAdapter typeAdapterB = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.1
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Class c(C2568a c2568a) {
                throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?\nSee " + F.a("java-lang-class-unsupported"));
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Class cls) {
                throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + cls.getName() + ". Forgot to register a type adapter?\nSee " + F.a("java-lang-class-unsupported"));
            }
        }.b();
        f16146a = typeAdapterB;
        f16147b = a(Class.class, typeAdapterB);
        TypeAdapter typeAdapterB2 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.2
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public BitSet c(C2568a c2568a) throws IOException {
                BitSet bitSet = new BitSet();
                c2568a.c();
                EnumC2569b enumC2569bX0 = c2568a.x0();
                int i8 = 0;
                while (enumC2569bX0 != EnumC2569b.END_ARRAY) {
                    int i9 = a.f16186a[enumC2569bX0.ordinal()];
                    boolean zU = true;
                    if (i9 == 1 || i9 == 2) {
                        int iX = c2568a.X();
                        if (iX == 0) {
                            zU = false;
                        } else if (iX != 1) {
                            throw new p("Invalid bitset value " + iX + ", expected 0 or 1; at path " + c2568a.N());
                        }
                    } else {
                        if (i9 != 3) {
                            throw new p("Invalid bitset value type: " + enumC2569bX0 + "; at path " + c2568a.K());
                        }
                        zU = c2568a.U();
                    }
                    if (zU) {
                        bitSet.set(i8);
                    }
                    i8++;
                    enumC2569bX0 = c2568a.x0();
                }
                c2568a.B();
                return bitSet;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, BitSet bitSet) throws IOException {
                c2570c.f();
                int length = bitSet.length();
                for (int i8 = 0; i8 < length; i8++) {
                    c2570c.v0(bitSet.get(i8) ? 1L : 0L);
                }
                c2570c.B();
            }
        }.b();
        f16148c = typeAdapterB2;
        f16149d = a(BitSet.class, typeAdapterB2);
        TypeAdapter typeAdapter = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.3
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Boolean c(C2568a c2568a) throws IOException {
                EnumC2569b enumC2569bX0 = c2568a.x0();
                if (enumC2569bX0 != EnumC2569b.NULL) {
                    return enumC2569bX0 == EnumC2569b.STRING ? Boolean.valueOf(Boolean.parseBoolean(c2568a.v0())) : Boolean.valueOf(c2568a.U());
                }
                c2568a.r0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Boolean bool) throws IOException {
                c2570c.w0(bool);
            }
        };
        f16150e = typeAdapter;
        f16151f = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.4
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Boolean c(C2568a c2568a) throws IOException {
                if (c2568a.x0() != EnumC2569b.NULL) {
                    return Boolean.valueOf(c2568a.v0());
                }
                c2568a.r0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Boolean bool) throws IOException {
                c2570c.y0(bool == null ? "null" : bool.toString());
            }
        };
        f16152g = b(Boolean.TYPE, Boolean.class, typeAdapter);
        TypeAdapter typeAdapter2 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.5
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                try {
                    int iX = c2568a.X();
                    if (iX <= 255 && iX >= -128) {
                        return Byte.valueOf((byte) iX);
                    }
                    throw new p("Lossy conversion from " + iX + " to byte; at path " + c2568a.N());
                } catch (NumberFormatException e8) {
                    throw new p(e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Number number) throws IOException {
                if (number == null) {
                    c2570c.R();
                } else {
                    c2570c.v0(number.byteValue());
                }
            }
        };
        f16153h = typeAdapter2;
        f16154i = b(Byte.TYPE, Byte.class, typeAdapter2);
        TypeAdapter typeAdapter3 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.6
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                try {
                    int iX = c2568a.X();
                    if (iX <= 65535 && iX >= -32768) {
                        return Short.valueOf((short) iX);
                    }
                    throw new p("Lossy conversion from " + iX + " to short; at path " + c2568a.N());
                } catch (NumberFormatException e8) {
                    throw new p(e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Number number) throws IOException {
                if (number == null) {
                    c2570c.R();
                } else {
                    c2570c.v0(number.shortValue());
                }
            }
        };
        f16155j = typeAdapter3;
        f16156k = b(Short.TYPE, Short.class, typeAdapter3);
        TypeAdapter typeAdapter4 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.7
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                try {
                    return Integer.valueOf(c2568a.X());
                } catch (NumberFormatException e8) {
                    throw new p(e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Number number) throws IOException {
                if (number == null) {
                    c2570c.R();
                } else {
                    c2570c.v0(number.intValue());
                }
            }
        };
        f16157l = typeAdapter4;
        f16158m = b(Integer.TYPE, Integer.class, typeAdapter4);
        TypeAdapter typeAdapterB3 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.8
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicInteger c(C2568a c2568a) {
                try {
                    return new AtomicInteger(c2568a.X());
                } catch (NumberFormatException e8) {
                    throw new p(e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, AtomicInteger atomicInteger) throws IOException {
                c2570c.v0(atomicInteger.get());
            }
        }.b();
        f16159n = typeAdapterB3;
        f16160o = a(AtomicInteger.class, typeAdapterB3);
        TypeAdapter typeAdapterB4 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.9
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicBoolean c(C2568a c2568a) {
                return new AtomicBoolean(c2568a.U());
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, AtomicBoolean atomicBoolean) throws IOException {
                c2570c.z0(atomicBoolean.get());
            }
        }.b();
        f16161p = typeAdapterB4;
        f16162q = a(AtomicBoolean.class, typeAdapterB4);
        TypeAdapter typeAdapterB5 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.10
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicIntegerArray c(C2568a c2568a) throws IOException {
                ArrayList arrayList = new ArrayList();
                c2568a.c();
                while (c2568a.Q()) {
                    try {
                        arrayList.add(Integer.valueOf(c2568a.X()));
                    } catch (NumberFormatException e8) {
                        throw new p(e8);
                    }
                }
                c2568a.B();
                int size = arrayList.size();
                AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(size);
                for (int i8 = 0; i8 < size; i8++) {
                    atomicIntegerArray.set(i8, ((Integer) arrayList.get(i8)).intValue());
                }
                return atomicIntegerArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, AtomicIntegerArray atomicIntegerArray) throws IOException {
                c2570c.f();
                int length = atomicIntegerArray.length();
                for (int i8 = 0; i8 < length; i8++) {
                    c2570c.v0(atomicIntegerArray.get(i8));
                }
                c2570c.B();
            }
        }.b();
        f16163r = typeAdapterB5;
        f16164s = a(AtomicIntegerArray.class, typeAdapterB5);
        f16165t = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.11
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                try {
                    return Long.valueOf(c2568a.b0());
                } catch (NumberFormatException e8) {
                    throw new p(e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Number number) throws IOException {
                if (number == null) {
                    c2570c.R();
                } else {
                    c2570c.v0(number.longValue());
                }
            }
        };
        f16166u = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.12
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(C2568a c2568a) throws IOException {
                if (c2568a.x0() != EnumC2569b.NULL) {
                    return Float.valueOf((float) c2568a.W());
                }
                c2568a.r0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Number number) throws IOException {
                if (number == null) {
                    c2570c.R();
                    return;
                }
                if (!(number instanceof Float)) {
                    number = Float.valueOf(number.floatValue());
                }
                c2570c.x0(number);
            }
        };
        f16167v = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.13
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(C2568a c2568a) throws IOException {
                if (c2568a.x0() != EnumC2569b.NULL) {
                    return Double.valueOf(c2568a.W());
                }
                c2568a.r0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Number number) throws IOException {
                if (number == null) {
                    c2570c.R();
                } else {
                    c2570c.s0(number.doubleValue());
                }
            }
        };
        TypeAdapter typeAdapter5 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.14
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Character c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                String strV0 = c2568a.v0();
                if (strV0.length() == 1) {
                    return Character.valueOf(strV0.charAt(0));
                }
                throw new p("Expecting character, got: " + strV0 + "; at " + c2568a.N());
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Character ch) throws IOException {
                c2570c.y0(ch == null ? null : String.valueOf(ch));
            }
        };
        f16168w = typeAdapter5;
        f16169x = b(Character.TYPE, Character.class, typeAdapter5);
        TypeAdapter typeAdapter6 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.15
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public String c(C2568a c2568a) throws IOException {
                EnumC2569b enumC2569bX0 = c2568a.x0();
                if (enumC2569bX0 != EnumC2569b.NULL) {
                    return enumC2569bX0 == EnumC2569b.BOOLEAN ? Boolean.toString(c2568a.U()) : c2568a.v0();
                }
                c2568a.r0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, String str) throws IOException {
                c2570c.y0(str);
            }
        };
        f16170y = typeAdapter6;
        f16171z = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.16
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public BigDecimal c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                String strV0 = c2568a.v0();
                try {
                    return z.b(strV0);
                } catch (NumberFormatException e8) {
                    throw new p("Failed parsing '" + strV0 + "' as BigDecimal; at path " + c2568a.N(), e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, BigDecimal bigDecimal) throws IOException {
                c2570c.x0(bigDecimal);
            }
        };
        f16122A = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.17
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public BigInteger c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                String strV0 = c2568a.v0();
                try {
                    return z.c(strV0);
                } catch (NumberFormatException e8) {
                    throw new p("Failed parsing '" + strV0 + "' as BigInteger; at path " + c2568a.N(), e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, BigInteger bigInteger) throws IOException {
                c2570c.x0(bigInteger);
            }
        };
        f16123B = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.18
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public x c(C2568a c2568a) throws IOException {
                if (c2568a.x0() != EnumC2569b.NULL) {
                    return new x(c2568a.v0());
                }
                c2568a.r0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, x xVar) throws IOException {
                c2570c.x0(xVar);
            }
        };
        f16124C = a(String.class, typeAdapter6);
        TypeAdapter typeAdapter7 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.19
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public StringBuilder c(C2568a c2568a) throws IOException {
                if (c2568a.x0() != EnumC2569b.NULL) {
                    return new StringBuilder(c2568a.v0());
                }
                c2568a.r0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, StringBuilder sb) throws IOException {
                c2570c.y0(sb == null ? null : sb.toString());
            }
        };
        f16125D = typeAdapter7;
        f16126E = a(StringBuilder.class, typeAdapter7);
        TypeAdapter typeAdapter8 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.20
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public StringBuffer c(C2568a c2568a) throws IOException {
                if (c2568a.x0() != EnumC2569b.NULL) {
                    return new StringBuffer(c2568a.v0());
                }
                c2568a.r0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, StringBuffer stringBuffer) throws IOException {
                c2570c.y0(stringBuffer == null ? null : stringBuffer.toString());
            }
        };
        f16127F = typeAdapter8;
        f16128G = a(StringBuffer.class, typeAdapter8);
        TypeAdapter typeAdapter9 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.21
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public URL c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                String strV0 = c2568a.v0();
                if (strV0.equals("null")) {
                    return null;
                }
                return new URL(strV0);
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, URL url) throws IOException {
                c2570c.y0(url == null ? null : url.toExternalForm());
            }
        };
        f16129H = typeAdapter9;
        f16130I = a(URL.class, typeAdapter9);
        TypeAdapter typeAdapter10 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.22
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public URI c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                try {
                    String strV0 = c2568a.v0();
                    if (strV0.equals("null")) {
                        return null;
                    }
                    return new URI(strV0);
                } catch (URISyntaxException e8) {
                    throw new j(e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, URI uri) throws IOException {
                c2570c.y0(uri == null ? null : uri.toASCIIString());
            }
        };
        f16131J = typeAdapter10;
        f16132K = a(URI.class, typeAdapter10);
        TypeAdapter typeAdapter11 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.23
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public InetAddress c(C2568a c2568a) throws IOException {
                if (c2568a.x0() != EnumC2569b.NULL) {
                    return InetAddress.getByName(c2568a.v0());
                }
                c2568a.r0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, InetAddress inetAddress) throws IOException {
                c2570c.y0(inetAddress == null ? null : inetAddress.getHostAddress());
            }
        };
        f16133L = typeAdapter11;
        f16134M = e(InetAddress.class, typeAdapter11);
        TypeAdapter typeAdapter12 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.24
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public UUID c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                String strV0 = c2568a.v0();
                try {
                    return UUID.fromString(strV0);
                } catch (IllegalArgumentException e8) {
                    throw new p("Failed parsing '" + strV0 + "' as UUID; at path " + c2568a.N(), e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, UUID uuid) throws IOException {
                c2570c.y0(uuid == null ? null : uuid.toString());
            }
        };
        f16135N = typeAdapter12;
        f16136O = a(UUID.class, typeAdapter12);
        TypeAdapter typeAdapterB6 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.25
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Currency c(C2568a c2568a) throws IOException {
                String strV0 = c2568a.v0();
                try {
                    return Currency.getInstance(strV0);
                } catch (IllegalArgumentException e8) {
                    throw new p("Failed parsing '" + strV0 + "' as Currency; at path " + c2568a.N(), e8);
                }
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Currency currency) throws IOException {
                c2570c.y0(currency.getCurrencyCode());
            }
        }.b();
        f16137P = typeAdapterB6;
        f16138Q = a(Currency.class, typeAdapterB6);
        TypeAdapter typeAdapter13 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.26
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Calendar c(C2568a c2568a) throws IOException {
                int iX;
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                c2568a.e();
                int i8 = 0;
                int i9 = 0;
                int i10 = 0;
                int i11 = 0;
                int i12 = 0;
                int i13 = 0;
                while (c2568a.x0() != EnumC2569b.END_OBJECT) {
                    String strI0 = c2568a.i0();
                    iX = c2568a.X();
                    strI0.hashCode();
                    switch (strI0) {
                        case "dayOfMonth":
                            i10 = iX;
                            break;
                        case "minute":
                            i12 = iX;
                            break;
                        case "second":
                            i13 = iX;
                            break;
                        case "year":
                            i8 = iX;
                            break;
                        case "month":
                            i9 = iX;
                            break;
                        case "hourOfDay":
                            i11 = iX;
                            break;
                    }
                }
                c2568a.D();
                return new GregorianCalendar(i8, i9, i10, i11, i12, i13);
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Calendar calendar) throws IOException {
                if (calendar == null) {
                    c2570c.R();
                    return;
                }
                c2570c.n();
                c2570c.O("year");
                c2570c.v0(calendar.get(1));
                c2570c.O("month");
                c2570c.v0(calendar.get(2));
                c2570c.O("dayOfMonth");
                c2570c.v0(calendar.get(5));
                c2570c.O("hourOfDay");
                c2570c.v0(calendar.get(11));
                c2570c.O("minute");
                c2570c.v0(calendar.get(12));
                c2570c.O("second");
                c2570c.v0(calendar.get(13));
                c2570c.D();
            }
        };
        f16139R = typeAdapter13;
        f16140S = d(Calendar.class, GregorianCalendar.class, typeAdapter13);
        TypeAdapter typeAdapter14 = new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.27
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Locale c(C2568a c2568a) throws IOException {
                if (c2568a.x0() == EnumC2569b.NULL) {
                    c2568a.r0();
                    return null;
                }
                StringTokenizer stringTokenizer = new StringTokenizer(c2568a.v0(), "_");
                String strNextToken = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken2 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                String strNextToken3 = stringTokenizer.hasMoreElements() ? stringTokenizer.nextToken() : null;
                return (strNextToken2 == null && strNextToken3 == null) ? new Locale(strNextToken) : strNextToken3 == null ? new Locale(strNextToken, strNextToken2) : new Locale(strNextToken, strNextToken2, strNextToken3);
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, Locale locale) throws IOException {
                c2570c.y0(locale == null ? null : locale.toString());
            }
        };
        f16141T = typeAdapter14;
        f16142U = a(Locale.class, typeAdapter14);
        JsonElementTypeAdapter jsonElementTypeAdapter = JsonElementTypeAdapter.f16065a;
        f16143V = jsonElementTypeAdapter;
        f16144W = e(i.class, jsonElementTypeAdapter);
        f16145X = EnumTypeAdapter.f16057d;
    }

    public static v a(final Class cls, final TypeAdapter typeAdapter) {
        return new v() { // from class: com.google.gson.internal.bind.TypeAdapters.29
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, C2462a c2462a) {
                if (c2462a.c() == cls) {
                    return typeAdapter;
                }
                return null;
            }

            public String toString() {
                return "Factory[type=" + cls.getName() + ",adapter=" + typeAdapter + "]";
            }
        };
    }

    public static v b(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new v() { // from class: com.google.gson.internal.bind.TypeAdapters.30
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, C2462a c2462a) {
                Class clsC = c2462a.c();
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

    public static v c(final C2462a c2462a, final TypeAdapter typeAdapter) {
        return new v() { // from class: com.google.gson.internal.bind.TypeAdapters.28
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, C2462a c2462a2) {
                if (c2462a2.equals(c2462a)) {
                    return typeAdapter;
                }
                return null;
            }
        };
    }

    public static v d(final Class cls, final Class cls2, final TypeAdapter typeAdapter) {
        return new v() { // from class: com.google.gson.internal.bind.TypeAdapters.31
            @Override // com.google.gson.v
            public TypeAdapter create(Gson gson, C2462a c2462a) {
                Class clsC = c2462a.c();
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
            public TypeAdapter create(Gson gson, C2462a c2462a) {
                final Class<?> clsC = c2462a.c();
                if (cls.isAssignableFrom(clsC)) {
                    return new TypeAdapter() { // from class: com.google.gson.internal.bind.TypeAdapters.32.1
                        @Override // com.google.gson.TypeAdapter
                        public Object c(C2568a c2568a) {
                            Object objC = typeAdapter.c(c2568a);
                            if (objC == null || clsC.isInstance(objC)) {
                                return objC;
                            }
                            throw new p("Expected a " + clsC.getName() + " but was " + objC.getClass().getName() + "; at path " + c2568a.N());
                        }

                        @Override // com.google.gson.TypeAdapter
                        public void e(C2570c c2570c, Object obj) {
                            typeAdapter.e(c2570c, obj);
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
