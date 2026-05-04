package com.google.gson;

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
import com.google.gson.internal.e0;
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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class Gson {
    public static final d A = d.f6636d;
    public static final String B = null;
    public static final c C = b.f6628a;
    public static final u D = t.f6891a;
    public static final u E = t.f6892b;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final s f6595z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f6596a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f6597b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.google.gson.internal.u f6598c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f6599d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f6600e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Excluder f6601f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f6602g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f6603h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f6604i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f6605j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f6606k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f6607l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d f6608m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final s f6609n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f6610o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f6611p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f6612q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f6613r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f6614s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final q f6615t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f6616u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f6617v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u f6618w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final u f6619x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f6620y;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public TypeAdapter f6625a = null;

        private TypeAdapter g() {
            TypeAdapter typeAdapter = this.f6625a;
            if (typeAdapter != null) {
                return typeAdapter;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // com.google.gson.TypeAdapter
        public Object c(gb.a aVar) {
            return g().c(aVar);
        }

        @Override // com.google.gson.TypeAdapter
        public void e(gb.c cVar, Object obj) {
            g().e(cVar, obj);
        }

        @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
        public TypeAdapter f() {
            return g();
        }

        public void h(TypeAdapter typeAdapter) {
            if (this.f6625a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f6625a = typeAdapter;
        }
    }

    public Gson(Excluder excluder, c cVar, Map map, boolean z10, boolean z11, boolean z12, boolean z13, d dVar, s sVar, boolean z14, boolean z15, q qVar, String str, int i10, int i11, List list, List list2, List list3, u uVar, u uVar2, List list4) {
        this.f6601f = excluder;
        this.f6602g = cVar;
        this.f6603h = map;
        com.google.gson.internal.u uVar3 = new com.google.gson.internal.u(map, z15, list4);
        this.f6598c = uVar3;
        this.f6604i = z10;
        this.f6605j = z11;
        this.f6606k = z12;
        this.f6607l = z13;
        this.f6608m = dVar;
        this.f6609n = sVar;
        this.f6610o = z14;
        this.f6611p = z15;
        this.f6615t = qVar;
        this.f6612q = str;
        this.f6613r = i10;
        this.f6614s = i11;
        this.f6616u = list;
        this.f6617v = list2;
        this.f6618w = uVar;
        this.f6619x = uVar2;
        this.f6620y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(TypeAdapters.W);
        arrayList.add(ObjectTypeAdapter.f(uVar));
        arrayList.add(excluder);
        arrayList.addAll(list3);
        arrayList.add(TypeAdapters.C);
        arrayList.add(TypeAdapters.f6770m);
        arrayList.add(TypeAdapters.f6764g);
        arrayList.add(TypeAdapters.f6766i);
        arrayList.add(TypeAdapters.f6768k);
        TypeAdapter typeAdapterN = n(qVar);
        arrayList.add(TypeAdapters.c(Long.TYPE, Long.class, typeAdapterN));
        arrayList.add(TypeAdapters.c(Double.TYPE, Double.class, e(z14)));
        arrayList.add(TypeAdapters.c(Float.TYPE, Float.class, f(z14)));
        arrayList.add(NumberTypeAdapter.f(uVar2));
        arrayList.add(TypeAdapters.f6772o);
        arrayList.add(TypeAdapters.f6774q);
        arrayList.add(TypeAdapters.b(AtomicLong.class, b(typeAdapterN)));
        arrayList.add(TypeAdapters.b(AtomicLongArray.class, c(typeAdapterN)));
        arrayList.add(TypeAdapters.f6776s);
        arrayList.add(TypeAdapters.f6781x);
        arrayList.add(TypeAdapters.E);
        arrayList.add(TypeAdapters.G);
        arrayList.add(TypeAdapters.b(BigDecimal.class, TypeAdapters.f6783z));
        arrayList.add(TypeAdapters.b(BigInteger.class, TypeAdapters.A));
        arrayList.add(TypeAdapters.b(x.class, TypeAdapters.B));
        arrayList.add(TypeAdapters.I);
        arrayList.add(TypeAdapters.K);
        arrayList.add(TypeAdapters.O);
        arrayList.add(TypeAdapters.Q);
        arrayList.add(TypeAdapters.U);
        arrayList.add(TypeAdapters.M);
        arrayList.add(TypeAdapters.f6761d);
        arrayList.add(DefaultDateTypeAdapter.f6688c);
        arrayList.add(TypeAdapters.S);
        if (com.google.gson.internal.sql.a.f6838a) {
            arrayList.add(com.google.gson.internal.sql.a.f6842e);
            arrayList.add(com.google.gson.internal.sql.a.f6841d);
            arrayList.add(com.google.gson.internal.sql.a.f6843f);
        }
        arrayList.add(ArrayTypeAdapter.f6682c);
        arrayList.add(TypeAdapters.f6759b);
        arrayList.add(new CollectionTypeAdapterFactory(uVar3));
        arrayList.add(new MapTypeAdapterFactory(uVar3, z11));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(uVar3);
        this.f6599d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(TypeAdapters.X);
        arrayList.add(new ReflectiveTypeAdapterFactory(uVar3, cVar, excluder, jsonAdapterAnnotationTypeAdapterFactory, list4));
        this.f6600e = Collections.unmodifiableList(arrayList);
    }

    public static void a(Object obj, gb.a aVar) {
        if (obj != null) {
            try {
                if (aVar.n0() == gb.b.END_DOCUMENT) {
                } else {
                    throw new p("JSON document was not fully consumed.");
                }
            } catch (gb.d e10) {
                throw new p(e10);
            } catch (IOException e11) {
                throw new j(e11);
            }
        }
    }

    public static TypeAdapter b(final TypeAdapter typeAdapter) {
        return new TypeAdapter() { // from class: com.google.gson.Gson.4
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicLong c(gb.a aVar) {
                return new AtomicLong(((Number) typeAdapter.c(aVar)).longValue());
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(gb.c cVar, AtomicLong atomicLong) {
                typeAdapter.e(cVar, Long.valueOf(atomicLong.get()));
            }
        }.b();
    }

    public static TypeAdapter c(final TypeAdapter typeAdapter) {
        return new TypeAdapter() { // from class: com.google.gson.Gson.5
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public AtomicLongArray c(gb.a aVar) throws IOException {
                ArrayList arrayList = new ArrayList();
                aVar.c();
                while (aVar.Z()) {
                    arrayList.add(Long.valueOf(((Number) typeAdapter.c(aVar)).longValue()));
                }
                aVar.E();
                int size = arrayList.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i10 = 0; i10 < size; i10++) {
                    atomicLongArray.set(i10, ((Long) arrayList.get(i10)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(gb.c cVar, AtomicLongArray atomicLongArray) throws IOException {
                cVar.o();
                int length = atomicLongArray.length();
                for (int i10 = 0; i10 < length; i10++) {
                    typeAdapter.e(cVar, Long.valueOf(atomicLongArray.get(i10)));
                }
                cVar.E();
            }
        }.b();
    }

    public static void d(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static TypeAdapter n(q qVar) {
        return qVar == q.f6879a ? TypeAdapters.f6777t : new TypeAdapter() { // from class: com.google.gson.Gson.3
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Number c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return Long.valueOf(aVar.g0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(gb.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.a0();
                } else {
                    cVar.o0(number.toString());
                }
            }
        };
    }

    public final TypeAdapter e(boolean z10) {
        return z10 ? TypeAdapters.f6779v : new TypeAdapter() { // from class: com.google.gson.Gson.1
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Double c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return Double.valueOf(aVar.e0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(gb.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.a0();
                    return;
                }
                double dDoubleValue = number.doubleValue();
                Gson.d(dDoubleValue);
                cVar.k0(dDoubleValue);
            }
        };
    }

    public final TypeAdapter f(boolean z10) {
        return z10 ? TypeAdapters.f6778u : new TypeAdapter() { // from class: com.google.gson.Gson.2
            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public Float c(gb.a aVar) throws IOException {
                if (aVar.n0() != gb.b.NULL) {
                    return Float.valueOf((float) aVar.e0());
                }
                aVar.j0();
                return null;
            }

            @Override // com.google.gson.TypeAdapter
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public void e(gb.c cVar, Number number) throws IOException {
                if (number == null) {
                    cVar.a0();
                    return;
                }
                float fFloatValue = number.floatValue();
                Gson.d(fFloatValue);
                if (!(number instanceof Float)) {
                    number = Float.valueOf(fFloatValue);
                }
                cVar.n0(number);
            }
        };
    }

    public Object g(gb.a aVar, fb.a aVar2) {
        boolean z10;
        s sVarR = aVar.R();
        s sVar = this.f6609n;
        if (sVar != null) {
            aVar.s0(sVar);
        } else if (aVar.R() == s.LEGACY_STRICT) {
            aVar.s0(s.LENIENT);
        }
        try {
            try {
                try {
                    try {
                        aVar.n0();
                        z10 = false;
                        try {
                            return k(aVar2).c(aVar);
                        } catch (EOFException e10) {
                            e = e10;
                            if (!z10) {
                                throw new p(e);
                            }
                            aVar.s0(sVarR);
                            return null;
                        }
                    } finally {
                        aVar.s0(sVarR);
                    }
                } catch (EOFException e11) {
                    e = e11;
                    z10 = true;
                }
            } catch (IOException e12) {
                throw new p(e12);
            }
        } catch (AssertionError e13) {
            throw new AssertionError("AssertionError (GSON 2.12.0): " + e13.getMessage(), e13);
        } catch (IllegalStateException e14) {
            throw new p(e14);
        }
    }

    public Object h(Reader reader, fb.a aVar) {
        gb.a aVarO = o(reader);
        Object objG = g(aVarO, aVar);
        a(objG, aVarO);
        return objG;
    }

    public Object i(String str, fb.a aVar) {
        if (str == null) {
            return null;
        }
        return h(new StringReader(str), aVar);
    }

    public Object j(String str, Type type) {
        return i(str, fb.a.b(type));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r2.h(r4);
        r0.put(r7, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public com.google.gson.TypeAdapter k(fb.a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap r0 = r6.f6597b
            java.lang.Object r0 = r0.get(r7)
            com.google.gson.TypeAdapter r0 = (com.google.gson.TypeAdapter) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal r0 = r6.f6596a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L26
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal r1 = r6.f6596a
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
            java.util.List r3 = r6.f6600e     // Catch: java.lang.Throwable -> L58
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
            java.lang.ThreadLocal r2 = r6.f6596a
            r2.remove()
        L61:
            if (r4 == 0) goto L6b
            if (r1 == 0) goto L6a
            java.util.concurrent.ConcurrentMap r7 = r6.f6597b
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
            java.lang.ThreadLocal r0 = r6.f6596a
            r0.remove()
        L89:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.Gson.k(fb.a):com.google.gson.TypeAdapter");
    }

    public TypeAdapter l(Class cls) {
        return k(fb.a.a(cls));
    }

    public TypeAdapter m(v vVar, fb.a aVar) {
        Objects.requireNonNull(vVar, "skipPast must not be null");
        Objects.requireNonNull(aVar, "type must not be null");
        if (this.f6599d.d(aVar, vVar)) {
            vVar = this.f6599d;
        }
        boolean z10 = false;
        for (v vVar2 : this.f6600e) {
            if (z10) {
                TypeAdapter typeAdapterCreate = vVar2.create(this, aVar);
                if (typeAdapterCreate != null) {
                    return typeAdapterCreate;
                }
            } else if (vVar2 == vVar) {
                z10 = true;
            }
        }
        if (!z10) {
            return k(aVar);
        }
        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + aVar);
    }

    public gb.a o(Reader reader) {
        gb.a aVar = new gb.a(reader);
        s sVar = this.f6609n;
        if (sVar == null) {
            sVar = s.LEGACY_STRICT;
        }
        aVar.s0(sVar);
        return aVar;
    }

    public gb.c p(Writer writer) throws IOException {
        if (this.f6606k) {
            writer.write(")]}'\n");
        }
        gb.c cVar = new gb.c(writer);
        cVar.f0(this.f6608m);
        cVar.g0(this.f6607l);
        s sVar = this.f6609n;
        if (sVar == null) {
            sVar = s.LEGACY_STRICT;
        }
        cVar.i0(sVar);
        cVar.h0(this.f6604i);
        return cVar;
    }

    public String q(i iVar) {
        StringWriter stringWriter = new StringWriter();
        u(iVar, stringWriter);
        return stringWriter.toString();
    }

    public String r(Object obj) {
        return obj == null ? q(k.f6876a) : s(obj, obj.getClass());
    }

    public String s(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        w(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public void t(i iVar, gb.c cVar) {
        s sVarK = cVar.K();
        boolean zN = cVar.N();
        boolean zH = cVar.H();
        cVar.g0(this.f6607l);
        cVar.h0(this.f6604i);
        s sVar = this.f6609n;
        if (sVar != null) {
            cVar.i0(sVar);
        } else if (cVar.K() == s.LEGACY_STRICT) {
            cVar.i0(s.LENIENT);
        }
        try {
            try {
                e0.b(iVar, cVar);
            } catch (IOException e10) {
                throw new j(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.12.0): " + e11.getMessage(), e11);
            }
        } finally {
            cVar.i0(sVarK);
            cVar.g0(zN);
            cVar.h0(zH);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f6604i + ",factories:" + this.f6600e + ",instanceCreators:" + this.f6598c + "}";
    }

    public void u(i iVar, Appendable appendable) {
        try {
            t(iVar, p(e0.c(appendable)));
        } catch (IOException e10) {
            throw new j(e10);
        }
    }

    public void v(Object obj, Type type, gb.c cVar) {
        TypeAdapter typeAdapterK = k(fb.a.b(type));
        s sVarK = cVar.K();
        s sVar = this.f6609n;
        if (sVar != null) {
            cVar.i0(sVar);
        } else if (cVar.K() == s.LEGACY_STRICT) {
            cVar.i0(s.LENIENT);
        }
        boolean zN = cVar.N();
        boolean zH = cVar.H();
        cVar.g0(this.f6607l);
        cVar.h0(this.f6604i);
        try {
            try {
                try {
                    typeAdapterK.e(cVar, obj);
                } catch (AssertionError e10) {
                    throw new AssertionError("AssertionError (GSON 2.12.0): " + e10.getMessage(), e10);
                }
            } catch (IOException e11) {
                throw new j(e11);
            }
        } finally {
            cVar.i0(sVarK);
            cVar.g0(zN);
            cVar.h0(zH);
        }
    }

    public void w(Object obj, Type type, Appendable appendable) {
        try {
            v(obj, type, p(e0.c(appendable)));
        } catch (IOException e10) {
            throw new j(e10);
        }
    }
}
