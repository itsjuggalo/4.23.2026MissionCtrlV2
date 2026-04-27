package com.google.gson;

import com.google.gson.internal.E;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.internal.x;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;
import o4.C2462a;
import p4.C2568a;
import p4.C2570c;
import p4.C2571d;
import p4.EnumC2569b;

/* JADX INFO: loaded from: classes.dex */
public final class Gson {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final d f15942A = d.f15988d;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final String f15943B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final c f15944C = b.f15980a;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final u f15945D = t.f16267a;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final u f15946E = t.f16268b;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final s f15947z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f15948a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f15949b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.gson.internal.u f15950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f15951d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f15952e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Excluder f15953f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f15954g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f15955h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f15956i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f15957j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f15958k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f15959l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f15960m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final s f15961n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f15962o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f15963p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f15964q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f15965r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f15966s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final q f15967t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f15968u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f15969v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u f15970w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final u f15971x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f15972y;

    public static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TypeAdapter f15977a = null;

        private TypeAdapter g() {
            TypeAdapter typeAdapter = this.f15977a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public Object c(C2568a c2568a) {
            return g().c(c2568a);
        }

        @Override // com.google.gson.TypeAdapter
        public void e(C2570c c2570c, Object obj) {
            g().e(c2570c, obj);
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter f() {
            return g();
        }

        public void h(TypeAdapter typeAdapter) {
            if (this.f15977a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f15977a = typeAdapter;
        }
    }

    public Gson(Excluder excluder, c cVar, Map map, boolean z7, boolean z8, boolean z9, boolean z10, d dVar, s sVar, boolean z11, boolean z12, q qVar, String str, int i8, int i9, List list, List list2, List list3, u uVar, u uVar2, List list4) {
        this.f15953f = excluder;
        this.f15954g = cVar;
        this.f15955h = map;
        com.google.gson.internal.u uVar3 = new com.google.gson.internal.u(map, z12, list4);
        this.f15950c = uVar3;
        this.f15956i = z7;
        this.f15957j = z8;
        this.f15958k = z9;
        this.f15959l = z10;
        this.f15960m = dVar;
        this.f15961n = sVar;
        this.f15962o = z11;
        this.f15963p = z12;
        this.f15967t = qVar;
        this.f15964q = str;
        this.f15965r = i8;
        this.f15966s = i9;
        this.f15968u = list;
        this.f15969v = list2;
        this.f15970w = uVar;
        this.f15971x = uVar2;
        this.f15972y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.f16144W);
        arrayList.add(ObjectTypeAdapter.f(uVar));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.f16124C);
        arrayList.add(TypeAdapters.f16158m);
        arrayList.add(TypeAdapters.f16152g);
        arrayList.add(TypeAdapters.f16154i);
        arrayList.add(TypeAdapters.f16156k);
        TypeAdapter typeAdapterN = n(qVar);
        arrayList.add(TypeAdapters.b(Long.TYPE, Long.class, typeAdapterN));
        arrayList.add(TypeAdapters.b(Double.TYPE, Double.class, e(z11)));
        arrayList.add(TypeAdapters.b(Float.TYPE, Float.class, f(z11)));
        arrayList.add(NumberTypeAdapter.f(uVar2));
        arrayList.add(TypeAdapters.f16160o);
        arrayList.add(TypeAdapters.f16162q);
        arrayList.add(TypeAdapters.a(AtomicLong.class, b(typeAdapterN)));
        arrayList.add(TypeAdapters.a(AtomicLongArray.class, c(typeAdapterN)));
        arrayList.add(TypeAdapters.f16164s);
        arrayList.add(TypeAdapters.f16169x);
        arrayList.add(TypeAdapters.f16126E);
        arrayList.add(TypeAdapters.f16128G);
        arrayList.add(TypeAdapters.a(BigDecimal.class, TypeAdapters.f16171z));
        arrayList.add(TypeAdapters.a(BigInteger.class, TypeAdapters.f16122A));
        arrayList.add(TypeAdapters.a(x.class, TypeAdapters.f16123B));
        arrayList.add(TypeAdapters.f16130I);
        arrayList.add(TypeAdapters.f16132K);
        arrayList.add(TypeAdapters.f16136O);
        arrayList.add(TypeAdapters.f16138Q);
        arrayList.add(TypeAdapters.f16142U);
        arrayList.add(TypeAdapters.f16134M);
        arrayList.add(TypeAdapters.f16149d);
        arrayList.add(DefaultDateTypeAdapter.f16052c);
        arrayList.add(TypeAdapters.f16140S);
        if (com.google.gson.internal.sql.a.f16214a) {
            arrayList.add(com.google.gson.internal.sql.a.f16218e);
            arrayList.add(com.google.gson.internal.sql.a.f16217d);
            arrayList.add(com.google.gson.internal.sql.a.f16219f);
        }
        arrayList.add(ArrayTypeAdapter.f16046c);
        arrayList.add(TypeAdapters.f16147b);
        arrayList.add(new CollectionTypeAdapterFactory(uVar3));
        arrayList.add(new MapTypeAdapterFactory(uVar3, z8));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(uVar3);
        this.f15951d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.f16145X);
        arrayList.add(new ReflectiveTypeAdapterFactory(uVar3, cVar, excluder, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.f15952e = Collections.unmodifiableList(arrayList);
    }

    public static void a(Object obj, C2568a c2568a) {
        if (obj != null) {
            try {
                if (c2568a.x0() == EnumC2569b.END_DOCUMENT) {
                } else {
                    throw new p("JSON document was not fully consumed.");
                }
            } catch (C2571d e8) {
                throw new p(e8);
            } catch (IOException e9) {
                throw new j(e9);
            }
        }
    }

    public static TypeAdapter b(final TypeAdapter typeAdapter) {
        return new TypeAdapter() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicLong c(C2568a c2568a) {
                return new AtomicLong(((Number) typeAdapter.c(c2568a)).longValue());
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, AtomicLong atomicLong) {
                typeAdapter.e(c2570c, Long.valueOf(atomicLong.get()));
            }
        }.b();
    }

    public static TypeAdapter c(final TypeAdapter typeAdapter) {
        return new TypeAdapter() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicLongArray c(C2568a c2568a) throws IOException {
                ArrayList arrayList = new ArrayList();
                c2568a.c();
                while (c2568a.Q()) {
                    arrayList.add(Long.valueOf(((Number) typeAdapter.c(c2568a)).longValue()));
                }
                c2568a.B();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i8 = 0; i8 < size; i8++) {
                    atomicLongArray.set(i8, ((Long) arrayList.get(i8)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(C2570c c2570c, AtomicLongArray atomicLongArray) throws IOException {
                c2570c.f();
                int length = atomicLongArray.length();
                for (int i8 = 0; i8 < length; i8++) {
                    typeAdapter.e(c2570c, Long.valueOf(atomicLongArray.get(i8)));
                }
                c2570c.B();
            }
        }.b();
    }

    public static void d(double d8) {
        if (Double.isNaN(d8) || Double.isInfinite(d8)) {
            throw new IllegalArgumentException(d8 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static TypeAdapter n(q qVar) {
        return qVar == q.f16255a ? TypeAdapters.f16165t : new TypeAdapter() { // from class: com.google.gson.Gson.3
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(C2568a c2568a) throws IOException {
                if (c2568a.x0() != EnumC2569b.NULL) {
                    return Long.valueOf(c2568a.b0());
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
                    c2570c.y0(number.toString());
                }
            }
        };
    }

    public final TypeAdapter e(boolean z7) {
        return z7 ? TypeAdapters.f16167v : new TypeAdapter() { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Double c(C2568a c2568a) throws IOException {
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
                    return;
                }
                double dDoubleValue = number.doubleValue();
                Gson.d(dDoubleValue);
                c2570c.s0(dDoubleValue);
            }
        };
    }

    public final TypeAdapter f(boolean z7) {
        return z7 ? TypeAdapters.f16166u : new TypeAdapter() { // from class: com.google.gson.Gson.2
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Float c(C2568a c2568a) throws IOException {
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
                float fFloatValue = number.floatValue();
                Gson.d(fFloatValue);
                if (!(number instanceof Float)) {
                    number = Float.valueOf(fFloatValue);
                }
                c2570c.x0(number);
            }
        };
    }

    public Object g(Reader reader, C2462a c2462a) {
        C2568a c2568aO = o(reader);
        Object objJ = j(c2568aO, c2462a);
        a(objJ, c2568aO);
        return objJ;
    }

    public Object h(String str, Type type) {
        return i(str, C2462a.b(type));
    }

    public Object i(String str, C2462a c2462a) {
        if (str == null) {
            return null;
        }
        return g(new StringReader(str), c2462a);
    }

    public Object j(C2568a c2568a, C2462a c2462a) {
        boolean z7;
        s sVarO = c2568a.O();
        s sVar = this.f15961n;
        if (sVar != null) {
            c2568a.C0(sVar);
        } else if (c2568a.O() == s.LEGACY_STRICT) {
            sVar = s.LENIENT;
            c2568a.C0(sVar);
        }
        try {
            try {
                try {
                    try {
                        c2568a.x0();
                        z7 = false;
                        try {
                            return l(c2462a).c(c2568a);
                        } catch (EOFException e8) {
                            e = e8;
                            if (!z7) {
                                throw new p(e);
                            }
                            c2568a.C0(sVarO);
                            return null;
                        }
                    } finally {
                        c2568a.C0(sVarO);
                    }
                } catch (EOFException e9) {
                    e = e9;
                    z7 = true;
                }
            } catch (IllegalStateException e10) {
                throw new p(e10);
            }
        } catch (IOException e11) {
            throw new p(e11);
        } catch (AssertionError e12) {
            throw new AssertionError("AssertionError (GSON 2.12.0): " + e12.getMessage(), e12);
        }
    }

    public TypeAdapter k(Class cls) {
        return l(C2462a.a(cls));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r2.h(r4);
        r0.put(r7, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.gson.TypeAdapter l(o4.C2462a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap r0 = r6.f15949b
            java.lang.Object r0 = r0.get(r7)
            com.google.gson.TypeAdapter r0 = (com.google.gson.TypeAdapter) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal r0 = r6.f15948a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L26
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal r1 = r6.f15948a
            r1.set(r0)
            r1 = 1
            goto L30
        L26:
            java.lang.Object r1 = r0.get(r7)
            com.google.gson.TypeAdapter r1 = (com.google.gson.TypeAdapter) r1
            if (r1 == 0) goto L2f
            return r1
        L2f:
            r1 = 0
        L30:
            com.google.gson.Gson$FutureTypeAdapter r2 = new com.google.gson.Gson$FutureTypeAdapter     // Catch: java.lang.Throwable -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r2)     // Catch: java.lang.Throwable -> L58
            java.util.List r3 = r6.f15952e     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L58
            r4 = 0
        L3f:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L5a
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L58
            com.google.gson.v r4 = (com.google.gson.v) r4     // Catch: java.lang.Throwable -> L58
            com.google.gson.TypeAdapter r4 = r4.create(r6, r7)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L3f
            r2.h(r4)     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r4)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r7 = move-exception
            goto L82
        L5a:
            if (r1 == 0) goto L61
            java.lang.ThreadLocal r2 = r6.f15948a
            r2.remove()
        L61:
            if (r4 == 0) goto L6b
            if (r1 == 0) goto L6a
            java.util.concurrent.ConcurrentMap r7 = r6.f15949b
            r7.putAll(r0)
        L6a:
            return r4
        L6b:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "GSON (2.12.0) cannot handle "
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L82:
            if (r1 == 0) goto L89
            java.lang.ThreadLocal r0 = r6.f15948a
            r0.remove()
        L89:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.l(o4.a):com.google.gson.TypeAdapter");
    }

    public TypeAdapter m(v vVar, C2462a c2462a) {
        Objects.requireNonNull(vVar, "skipPast must not be null");
        Objects.requireNonNull(c2462a, "type must not be null");
        if (this.f15951d.d(c2462a, vVar)) {
            vVar = this.f15951d;
        }
        boolean z7 = false;
        for (v vVar2 : this.f15952e) {
            if (z7) {
                TypeAdapter typeAdapterCreate = vVar2.create(this, c2462a);
                if (typeAdapterCreate != null) {
                    return typeAdapterCreate;
                }
            } else if (vVar2 == vVar) {
                z7 = true;
            }
        }
        if (!z7) {
            return l(c2462a);
        }
        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + c2462a);
    }

    public C2568a o(Reader reader) {
        C2568a c2568a = new C2568a(reader);
        s sVar = this.f15961n;
        if (sVar == null) {
            sVar = s.LEGACY_STRICT;
        }
        c2568a.C0(sVar);
        return c2568a;
    }

    public C2570c p(Writer writer) throws IOException {
        if (this.f15958k) {
            writer.write(")]}'\n");
        }
        C2570c c2570c = new C2570c(writer);
        c2570c.X(this.f15960m);
        c2570c.b0(this.f15959l);
        s sVar = this.f15961n;
        if (sVar == null) {
            sVar = s.LEGACY_STRICT;
        }
        c2570c.m0(sVar);
        c2570c.i0(this.f15956i);
        return c2570c;
    }

    public String q(i iVar) {
        StringWriter stringWriter = new StringWriter();
        t(iVar, stringWriter);
        return stringWriter.toString();
    }

    public String r(Object obj) {
        return obj == null ? q(k.f16252a) : s(obj, obj.getClass());
    }

    public String s(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        v(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void t(i iVar, Appendable appendable) {
        try {
            u(iVar, p(E.c(appendable)));
        } catch (IOException e8) {
            throw new j(e8);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f15956i + ",factories:" + this.f15952e + ",instanceCreators:" + this.f15950c + "}";
    }

    public void u(i iVar, C2570c c2570c) {
        s sVarK = c2570c.K();
        boolean zM = c2570c.M();
        boolean zE = c2570c.E();
        c2570c.b0(this.f15959l);
        c2570c.i0(this.f15956i);
        s sVar = this.f15961n;
        if (sVar != null) {
            c2570c.m0(sVar);
        } else if (c2570c.K() == s.LEGACY_STRICT) {
            sVar = s.LENIENT;
            c2570c.m0(sVar);
        }
        try {
            try {
                E.b(iVar, c2570c);
            } catch (IOException e8) {
                throw new j(e8);
            } catch (AssertionError e9) {
                throw new AssertionError("AssertionError (GSON 2.12.0): " + e9.getMessage(), e9);
            }
        } finally {
            c2570c.m0(sVarK);
            c2570c.b0(zM);
            c2570c.i0(zE);
        }
    }

    public void v(Object obj, Type type, Appendable appendable) {
        try {
            w(obj, type, p(E.c(appendable)));
        } catch (IOException e8) {
            throw new j(e8);
        }
    }

    public void w(Object obj, Type type, C2570c c2570c) {
        TypeAdapter typeAdapterL = l(C2462a.b(type));
        s sVarK = c2570c.K();
        s sVar = this.f15961n;
        if (sVar != null) {
            c2570c.m0(sVar);
        } else if (c2570c.K() == s.LEGACY_STRICT) {
            sVar = s.LENIENT;
            c2570c.m0(sVar);
        }
        boolean zM = c2570c.M();
        boolean zE = c2570c.E();
        c2570c.b0(this.f15959l);
        c2570c.i0(this.f15956i);
        try {
            try {
                typeAdapterL.e(c2570c, obj);
            } catch (IOException e8) {
                throw new j(e8);
            } catch (AssertionError e9) {
                throw new AssertionError("AssertionError (GSON 2.12.0): " + e9.getMessage(), e9);
            }
        } finally {
            c2570c.m0(sVarK);
            c2570c.b0(zM);
            c2570c.i0(zE);
        }
    }
}
