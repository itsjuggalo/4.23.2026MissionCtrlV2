package q2;

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
import s2.F;
import s2.y;
import t2.C1784a;
import t2.C1785b;
import t2.C1786c;
import t2.C1788e;
import t2.C1792i;
import t2.C1793j;
import t2.C1794k;
import w2.AbstractC1908d;
import x2.C1925a;
import y2.C1946a;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final q2.d f14214A = q2.d.f14209d;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final String f14215B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final q2.c f14216C = EnumC1723b.f14201a;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final v f14217D = u.f14286a;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final v f14218E = u.f14287b;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final t f14219z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f14220a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f14221b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final s2.u f14222c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1788e f14223d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f14224e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s2.v f14225f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final q2.c f14226g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f14227h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f14228i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f14229j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f14230k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f14231l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final q2.d f14232m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t f14233n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f14234o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f14235p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f14236q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f14237r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f14238s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final r f14239t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f14240u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f14241v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v f14242w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final v f14243x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f14244y;

    public class a extends w {
        public a() {
        }

        @Override // q2.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Double c(C1946a c1946a) throws IOException {
            if (c1946a.r0() != y2.b.NULL) {
                return Double.valueOf(c1946a.i0());
            }
            c1946a.n0();
            return null;
        }

        @Override // q2.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(y2.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.e0();
                return;
            }
            double dDoubleValue = number.doubleValue();
            e.d(dDoubleValue);
            cVar.o0(dDoubleValue);
        }
    }

    public class b extends w {
        public b() {
        }

        @Override // q2.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Float c(C1946a c1946a) throws IOException {
            if (c1946a.r0() != y2.b.NULL) {
                return Float.valueOf((float) c1946a.i0());
            }
            c1946a.n0();
            return null;
        }

        @Override // q2.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(y2.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.e0();
                return;
            }
            float fFloatValue = number.floatValue();
            e.d(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            cVar.r0(number);
        }
    }

    public class c extends w {
        @Override // q2.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number c(C1946a c1946a) throws IOException {
            if (c1946a.r0() != y2.b.NULL) {
                return Long.valueOf(c1946a.k0());
            }
            c1946a.n0();
            return null;
        }

        @Override // q2.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(y2.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.e0();
            } else {
                cVar.s0(number.toString());
            }
        }
    }

    public class d extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f14247a;

        public d(w wVar) {
            this.f14247a = wVar;
        }

        @Override // q2.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicLong c(C1946a c1946a) {
            return new AtomicLong(((Number) this.f14247a.c(c1946a)).longValue());
        }

        @Override // q2.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(y2.c cVar, AtomicLong atomicLong) {
            this.f14247a.e(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: renamed from: q2.e$e, reason: collision with other inner class name */
    public class C0230e extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f14248a;

        public C0230e(w wVar) {
            this.f14248a = wVar;
        }

        @Override // q2.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray c(C1946a c1946a) throws IOException {
            ArrayList arrayList = new ArrayList();
            c1946a.f();
            while (c1946a.d0()) {
                arrayList.add(Long.valueOf(((Number) this.f14248a.c(c1946a)).longValue()));
            }
            c1946a.E();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i4 = 0; i4 < size; i4++) {
                atomicLongArray.set(i4, ((Long) arrayList.get(i4)).longValue());
            }
            return atomicLongArray;
        }

        @Override // q2.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(y2.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.p();
            int length = atomicLongArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                this.f14248a.e(cVar, Long.valueOf(atomicLongArray.get(i4)));
            }
            cVar.E();
        }
    }

    public static class f extends t2.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w f14249a = null;

        private w g() {
            w wVar = this.f14249a;
            if (wVar != null) {
                return wVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // q2.w
        public Object c(C1946a c1946a) {
            return g().c(c1946a);
        }

        @Override // q2.w
        public void e(y2.c cVar, Object obj) {
            g().e(cVar, obj);
        }

        @Override // t2.m
        public w f() {
            return g();
        }

        public void h(w wVar) {
            if (this.f14249a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f14249a = wVar;
        }
    }

    public e(s2.v vVar, q2.c cVar, Map map, boolean z4, boolean z5, boolean z6, boolean z7, q2.d dVar, t tVar, boolean z8, boolean z9, r rVar, String str, int i4, int i5, List list, List list2, List list3, v vVar2, v vVar3, List list4) {
        this.f14225f = vVar;
        this.f14226g = cVar;
        this.f14227h = map;
        s2.u uVar = new s2.u(map, z9, list4);
        this.f14222c = uVar;
        this.f14228i = z4;
        this.f14229j = z5;
        this.f14230k = z6;
        this.f14231l = z7;
        this.f14232m = dVar;
        this.f14233n = tVar;
        this.f14234o = z8;
        this.f14235p = z9;
        this.f14239t = rVar;
        this.f14236q = str;
        this.f14237r = i4;
        this.f14238s = i5;
        this.f14240u = list;
        this.f14241v = list2;
        this.f14242w = vVar2;
        this.f14243x = vVar3;
        this.f14244y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(t2.p.f14858W);
        arrayList.add(C1794k.f(vVar2));
        arrayList.add(vVar);
        arrayList.addAll(list3);
        arrayList.add(t2.p.f14838C);
        arrayList.add(t2.p.f14872m);
        arrayList.add(t2.p.f14866g);
        arrayList.add(t2.p.f14868i);
        arrayList.add(t2.p.f14870k);
        w wVarN = n(rVar);
        arrayList.add(t2.p.a(Long.TYPE, Long.class, wVarN));
        arrayList.add(t2.p.a(Double.TYPE, Double.class, e(z8)));
        arrayList.add(t2.p.a(Float.TYPE, Float.class, f(z8)));
        arrayList.add(C1793j.f(vVar3));
        arrayList.add(t2.p.f14874o);
        arrayList.add(t2.p.f14876q);
        arrayList.add(t2.p.b(AtomicLong.class, b(wVarN)));
        arrayList.add(t2.p.b(AtomicLongArray.class, c(wVarN)));
        arrayList.add(t2.p.f14878s);
        arrayList.add(t2.p.f14883x);
        arrayList.add(t2.p.f14840E);
        arrayList.add(t2.p.f14842G);
        arrayList.add(t2.p.b(BigDecimal.class, t2.p.f14885z));
        arrayList.add(t2.p.b(BigInteger.class, t2.p.f14836A));
        arrayList.add(t2.p.b(y.class, t2.p.f14837B));
        arrayList.add(t2.p.f14844I);
        arrayList.add(t2.p.f14846K);
        arrayList.add(t2.p.f14850O);
        arrayList.add(t2.p.f14852Q);
        arrayList.add(t2.p.f14856U);
        arrayList.add(t2.p.f14848M);
        arrayList.add(t2.p.f14863d);
        arrayList.add(C1786c.f14754c);
        arrayList.add(t2.p.f14854S);
        if (AbstractC1908d.f15577a) {
            arrayList.add(AbstractC1908d.f15581e);
            arrayList.add(AbstractC1908d.f15580d);
            arrayList.add(AbstractC1908d.f15582f);
        }
        arrayList.add(C1784a.f14748c);
        arrayList.add(t2.p.f14861b);
        arrayList.add(new C1785b(uVar));
        arrayList.add(new C1792i(uVar, z5));
        C1788e c1788e = new C1788e(uVar);
        this.f14223d = c1788e;
        arrayList.add(c1788e);
        arrayList.add(t2.p.f14859X);
        arrayList.add(new t2.l(uVar, cVar, vVar, c1788e, list4));
        this.f14224e = Collections.unmodifiableList(arrayList);
    }

    public static void a(Object obj, C1946a c1946a) {
        if (obj != null) {
            try {
                if (c1946a.r0() == y2.b.END_DOCUMENT) {
                } else {
                    throw new q("JSON document was not fully consumed.");
                }
            } catch (y2.d e4) {
                throw new q(e4);
            } catch (IOException e5) {
                throw new k(e5);
            }
        }
    }

    public static w b(w wVar) {
        return new d(wVar).b();
    }

    public static w c(w wVar) {
        return new C0230e(wVar).b();
    }

    public static void d(double d4) {
        if (Double.isNaN(d4) || Double.isInfinite(d4)) {
            throw new IllegalArgumentException(d4 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static w n(r rVar) {
        return rVar == r.f14274a ? t2.p.f14879t : new c();
    }

    public final w e(boolean z4) {
        return z4 ? t2.p.f14881v : new a();
    }

    public final w f(boolean z4) {
        return z4 ? t2.p.f14880u : new b();
    }

    public Object g(Reader reader, C1925a c1925a) {
        C1946a c1946aO = o(reader);
        Object objJ = j(c1946aO, c1925a);
        a(objJ, c1946aO);
        return objJ;
    }

    public Object h(String str, Type type) {
        return i(str, C1925a.b(type));
    }

    public Object i(String str, C1925a c1925a) {
        if (str == null) {
            return null;
        }
        return g(new StringReader(str), c1925a);
    }

    public Object j(C1946a c1946a, C1925a c1925a) {
        boolean z4;
        t tVarA0 = c1946a.a0();
        t tVar = this.f14233n;
        if (tVar != null) {
            c1946a.w0(tVar);
        } else if (c1946a.a0() == t.LEGACY_STRICT) {
            c1946a.w0(t.LENIENT);
        }
        try {
            try {
                try {
                    try {
                        c1946a.r0();
                        z4 = false;
                        try {
                            return l(c1925a).c(c1946a);
                        } catch (EOFException e4) {
                            e = e4;
                            if (!z4) {
                                throw new q(e);
                            }
                            c1946a.w0(tVarA0);
                            return null;
                        }
                    } finally {
                        c1946a.w0(tVarA0);
                    }
                } catch (EOFException e5) {
                    e = e5;
                    z4 = true;
                }
            } catch (IOException e6) {
                throw new q(e6);
            }
        } catch (AssertionError e7) {
            throw new AssertionError("AssertionError (GSON 2.12.0): " + e7.getMessage(), e7);
        } catch (IllegalStateException e8) {
            throw new q(e8);
        }
    }

    public w k(Class cls) {
        return l(C1925a.a(cls));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r2.h(r4);
        r0.put(r7, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public q2.w l(x2.C1925a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap r0 = r6.f14221b
            java.lang.Object r0 = r0.get(r7)
            q2.w r0 = (q2.w) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal r0 = r6.f14220a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L26
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal r1 = r6.f14220a
            r1.set(r0)
            r1 = 1
            goto L30
        L26:
            java.lang.Object r1 = r0.get(r7)
            q2.w r1 = (q2.w) r1
            if (r1 == 0) goto L2f
            return r1
        L2f:
            r1 = 0
        L30:
            q2.e$f r2 = new q2.e$f     // Catch: java.lang.Throwable -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r2)     // Catch: java.lang.Throwable -> L58
            java.util.List r3 = r6.f14224e     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L58
            r4 = 0
        L3f:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L5a
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L58
            q2.x r4 = (q2.x) r4     // Catch: java.lang.Throwable -> L58
            q2.w r4 = r4.create(r6, r7)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L3f
            r2.h(r4)     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r4)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r7 = move-exception
            goto L82
        L5a:
            if (r1 == 0) goto L61
            java.lang.ThreadLocal r2 = r6.f14220a
            r2.remove()
        L61:
            if (r4 == 0) goto L6b
            if (r1 == 0) goto L6a
            java.util.concurrent.ConcurrentMap r7 = r6.f14221b
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
            java.lang.ThreadLocal r0 = r6.f14220a
            r0.remove()
        L89:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: q2.e.l(x2.a):q2.w");
    }

    public w m(x xVar, C1925a c1925a) {
        Objects.requireNonNull(xVar, "skipPast must not be null");
        Objects.requireNonNull(c1925a, "type must not be null");
        if (this.f14223d.d(c1925a, xVar)) {
            xVar = this.f14223d;
        }
        boolean z4 = false;
        for (x xVar2 : this.f14224e) {
            if (z4) {
                w wVarCreate = xVar2.create(this, c1925a);
                if (wVarCreate != null) {
                    return wVarCreate;
                }
            } else if (xVar2 == xVar) {
                z4 = true;
            }
        }
        if (!z4) {
            return l(c1925a);
        }
        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + c1925a);
    }

    public C1946a o(Reader reader) {
        C1946a c1946a = new C1946a(reader);
        t tVar = this.f14233n;
        if (tVar == null) {
            tVar = t.LEGACY_STRICT;
        }
        c1946a.w0(tVar);
        return c1946a;
    }

    public y2.c p(Writer writer) throws IOException {
        if (this.f14230k) {
            writer.write(")]}'\n");
        }
        y2.c cVar = new y2.c(writer);
        cVar.j0(this.f14232m);
        cVar.k0(this.f14231l);
        t tVar = this.f14233n;
        if (tVar == null) {
            tVar = t.LEGACY_STRICT;
        }
        cVar.m0(tVar);
        cVar.l0(this.f14228i);
        return cVar;
    }

    public String q(Object obj) {
        return obj == null ? s(l.f14271a) : r(obj, obj.getClass());
    }

    public String r(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        t(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String s(j jVar) {
        StringWriter stringWriter = new StringWriter();
        v(jVar, stringWriter);
        return stringWriter.toString();
    }

    public void t(Object obj, Type type, Appendable appendable) {
        try {
            u(obj, type, p(F.c(appendable)));
        } catch (IOException e4) {
            throw new k(e4);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f14228i + ",factories:" + this.f14224e + ",instanceCreators:" + this.f14222c + "}";
    }

    public void u(Object obj, Type type, y2.c cVar) {
        w wVarL = l(C1925a.b(type));
        t tVarK = cVar.K();
        t tVar = this.f14233n;
        if (tVar != null) {
            cVar.m0(tVar);
        } else if (cVar.K() == t.LEGACY_STRICT) {
            cVar.m0(t.LENIENT);
        }
        boolean zP = cVar.P();
        boolean zJ = cVar.J();
        cVar.k0(this.f14231l);
        cVar.l0(this.f14228i);
        try {
            try {
                try {
                    wVarL.e(cVar, obj);
                } catch (AssertionError e4) {
                    throw new AssertionError("AssertionError (GSON 2.12.0): " + e4.getMessage(), e4);
                }
            } catch (IOException e5) {
                throw new k(e5);
            }
        } finally {
            cVar.m0(tVarK);
            cVar.k0(zP);
            cVar.l0(zJ);
        }
    }

    public void v(j jVar, Appendable appendable) {
        try {
            w(jVar, p(F.c(appendable)));
        } catch (IOException e4) {
            throw new k(e4);
        }
    }

    public void w(j jVar, y2.c cVar) {
        t tVarK = cVar.K();
        boolean zP = cVar.P();
        boolean zJ = cVar.J();
        cVar.k0(this.f14231l);
        cVar.l0(this.f14228i);
        t tVar = this.f14233n;
        if (tVar != null) {
            cVar.m0(tVar);
        } else if (cVar.K() == t.LEGACY_STRICT) {
            cVar.m0(t.LENIENT);
        }
        try {
            try {
                F.b(jVar, cVar);
            } catch (IOException e4) {
                throw new k(e4);
            } catch (AssertionError e5) {
                throw new AssertionError("AssertionError (GSON 2.12.0): " + e5.getMessage(), e5);
            }
        } finally {
            cVar.m0(tVarK);
            cVar.k0(zP);
            cVar.l0(zJ);
        }
    }
}
