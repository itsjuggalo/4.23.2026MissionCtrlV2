package l4;

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
import n4.F;
import n4.y;
import o4.C2309a;
import o4.C2310b;
import o4.C2311c;
import o4.C2313e;
import s4.C2645a;
import t4.C2657a;

/* JADX INFO: renamed from: l4.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2172e {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final C2171d f18322A = C2171d.f18317d;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final String f18323B = null;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final InterfaceC2170c f18324C = EnumC2169b.f18309a;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static final v f18325D = u.f18394a;

    /* JADX INFO: renamed from: E, reason: collision with root package name */
    public static final v f18326E = u.f18395b;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final t f18327z = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadLocal f18328a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentMap f18329b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final n4.u f18330c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2313e f18331d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List f18332e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final n4.v f18333f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final InterfaceC2170c f18334g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f18335h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f18336i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f18337j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f18338k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f18339l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final C2171d f18340m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final t f18341n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f18342o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final boolean f18343p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final String f18344q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f18345r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final int f18346s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final r f18347t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final List f18348u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final List f18349v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final v f18350w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final v f18351x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final List f18352y;

    /* JADX INFO: renamed from: l4.e$a */
    public class a extends w {
        public a() {
        }

        @Override // l4.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Double c(C2657a c2657a) throws IOException {
            if (c2657a.M0() != t4.b.NULL) {
                return Double.valueOf(c2657a.D0());
            }
            c2657a.I0();
            return null;
        }

        @Override // l4.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(t4.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.z0();
                return;
            }
            double dDoubleValue = number.doubleValue();
            C2172e.d(dDoubleValue);
            cVar.J0(dDoubleValue);
        }
    }

    /* JADX INFO: renamed from: l4.e$b */
    public class b extends w {
        public b() {
        }

        @Override // l4.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Float c(C2657a c2657a) throws IOException {
            if (c2657a.M0() != t4.b.NULL) {
                return Float.valueOf((float) c2657a.D0());
            }
            c2657a.I0();
            return null;
        }

        @Override // l4.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(t4.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.z0();
                return;
            }
            float fFloatValue = number.floatValue();
            C2172e.d(fFloatValue);
            if (!(number instanceof Float)) {
                number = Float.valueOf(fFloatValue);
            }
            cVar.M0(number);
        }
    }

    /* JADX INFO: renamed from: l4.e$c */
    public class c extends w {
        @Override // l4.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Number c(C2657a c2657a) throws IOException {
            if (c2657a.M0() != t4.b.NULL) {
                return Long.valueOf(c2657a.F0());
            }
            c2657a.I0();
            return null;
        }

        @Override // l4.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(t4.c cVar, Number number) throws IOException {
            if (number == null) {
                cVar.z0();
            } else {
                cVar.N0(number.toString());
            }
        }
    }

    /* JADX INFO: renamed from: l4.e$d */
    public class d extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f18355a;

        public d(w wVar) {
            this.f18355a = wVar;
        }

        @Override // l4.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicLong c(C2657a c2657a) {
            return new AtomicLong(((Number) this.f18355a.c(c2657a)).longValue());
        }

        @Override // l4.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(t4.c cVar, AtomicLong atomicLong) {
            this.f18355a.e(cVar, Long.valueOf(atomicLong.get()));
        }
    }

    /* JADX INFO: renamed from: l4.e$e, reason: collision with other inner class name */
    public class C0303e extends w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ w f18356a;

        public C0303e(w wVar) {
            this.f18356a = wVar;
        }

        @Override // l4.w
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public AtomicLongArray c(C2657a c2657a) throws IOException {
            ArrayList arrayList = new ArrayList();
            c2657a.i();
            while (c2657a.y0()) {
                arrayList.add(Long.valueOf(((Number) this.f18356a.c(c2657a)).longValue()));
            }
            c2657a.M();
            int size = arrayList.size();
            AtomicLongArray atomicLongArray = new AtomicLongArray(size);
            for (int i7 = 0; i7 < size; i7++) {
                atomicLongArray.set(i7, ((Long) arrayList.get(i7)).longValue());
            }
            return atomicLongArray;
        }

        @Override // l4.w
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void e(t4.c cVar, AtomicLongArray atomicLongArray) throws IOException {
            cVar.G();
            int length = atomicLongArray.length();
            for (int i7 = 0; i7 < length; i7++) {
                this.f18356a.e(cVar, Long.valueOf(atomicLongArray.get(i7)));
            }
            cVar.M();
        }
    }

    /* JADX INFO: renamed from: l4.e$f */
    public static class f extends o4.m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public w f18357a = null;

        private w g() {
            w wVar = this.f18357a;
            if (wVar != null) {
                return wVar;
            }
            throw new IllegalStateException("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }

        @Override // l4.w
        public Object c(C2657a c2657a) {
            return g().c(c2657a);
        }

        @Override // l4.w
        public void e(t4.c cVar, Object obj) {
            g().e(cVar, obj);
        }

        @Override // o4.m
        public w f() {
            return g();
        }

        public void h(w wVar) {
            if (this.f18357a != null) {
                throw new AssertionError("Delegate is already set");
            }
            this.f18357a = wVar;
        }
    }

    public C2172e(n4.v vVar, InterfaceC2170c interfaceC2170c, Map map, boolean z7, boolean z8, boolean z9, boolean z10, C2171d c2171d, t tVar, boolean z11, boolean z12, r rVar, String str, int i7, int i8, List list, List list2, List list3, v vVar2, v vVar3, List list4) {
        this.f18333f = vVar;
        this.f18334g = interfaceC2170c;
        this.f18335h = map;
        n4.u uVar = new n4.u(map, z12, list4);
        this.f18330c = uVar;
        this.f18336i = z7;
        this.f18337j = z8;
        this.f18338k = z9;
        this.f18339l = z10;
        this.f18340m = c2171d;
        this.f18341n = tVar;
        this.f18342o = z11;
        this.f18343p = z12;
        this.f18347t = rVar;
        this.f18344q = str;
        this.f18345r = i7;
        this.f18346s = i8;
        this.f18348u = list;
        this.f18349v = list2;
        this.f18350w = vVar2;
        this.f18351x = vVar3;
        this.f18352y = list4;
        ArrayList arrayList = new ArrayList();
        arrayList.add(o4.p.f20167W);
        arrayList.add(o4.k.f(vVar2));
        arrayList.add(vVar);
        arrayList.addAll(list3);
        arrayList.add(o4.p.f20147C);
        arrayList.add(o4.p.f20181m);
        arrayList.add(o4.p.f20175g);
        arrayList.add(o4.p.f20177i);
        arrayList.add(o4.p.f20179k);
        w wVarN = n(rVar);
        arrayList.add(o4.p.a(Long.TYPE, Long.class, wVarN));
        arrayList.add(o4.p.a(Double.TYPE, Double.class, e(z11)));
        arrayList.add(o4.p.a(Float.TYPE, Float.class, f(z11)));
        arrayList.add(o4.j.f(vVar3));
        arrayList.add(o4.p.f20183o);
        arrayList.add(o4.p.f20185q);
        arrayList.add(o4.p.b(AtomicLong.class, b(wVarN)));
        arrayList.add(o4.p.b(AtomicLongArray.class, c(wVarN)));
        arrayList.add(o4.p.f20187s);
        arrayList.add(o4.p.f20192x);
        arrayList.add(o4.p.f20149E);
        arrayList.add(o4.p.f20151G);
        arrayList.add(o4.p.b(BigDecimal.class, o4.p.f20194z));
        arrayList.add(o4.p.b(BigInteger.class, o4.p.f20145A));
        arrayList.add(o4.p.b(y.class, o4.p.f20146B));
        arrayList.add(o4.p.f20153I);
        arrayList.add(o4.p.f20155K);
        arrayList.add(o4.p.f20159O);
        arrayList.add(o4.p.f20161Q);
        arrayList.add(o4.p.f20165U);
        arrayList.add(o4.p.f20157M);
        arrayList.add(o4.p.f20172d);
        arrayList.add(C2311c.f20063c);
        arrayList.add(o4.p.f20163S);
        if (r4.d.f22491a) {
            arrayList.add(r4.d.f22495e);
            arrayList.add(r4.d.f22494d);
            arrayList.add(r4.d.f22496f);
        }
        arrayList.add(C2309a.f20057c);
        arrayList.add(o4.p.f20170b);
        arrayList.add(new C2310b(uVar));
        arrayList.add(new o4.i(uVar, z8));
        C2313e c2313e = new C2313e(uVar);
        this.f18331d = c2313e;
        arrayList.add(c2313e);
        arrayList.add(o4.p.f20168X);
        arrayList.add(new o4.l(uVar, interfaceC2170c, vVar, c2313e, list4));
        this.f18332e = Collections.unmodifiableList(arrayList);
    }

    public static void a(Object obj, C2657a c2657a) {
        if (obj != null) {
            try {
                if (c2657a.M0() == t4.b.END_DOCUMENT) {
                } else {
                    throw new q("JSON document was not fully consumed.");
                }
            } catch (t4.d e7) {
                throw new q(e7);
            } catch (IOException e8) {
                throw new C2178k(e8);
            }
        }
    }

    public static w b(w wVar) {
        return new d(wVar).b();
    }

    public static w c(w wVar) {
        return new C0303e(wVar).b();
    }

    public static void d(double d7) {
        if (Double.isNaN(d7) || Double.isInfinite(d7)) {
            throw new IllegalArgumentException(d7 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    public static w n(r rVar) {
        return rVar == r.f18382a ? o4.p.f20188t : new c();
    }

    public final w e(boolean z7) {
        return z7 ? o4.p.f20190v : new a();
    }

    public final w f(boolean z7) {
        return z7 ? o4.p.f20189u : new b();
    }

    public Object g(Reader reader, C2645a c2645a) {
        C2657a c2657aO = o(reader);
        Object objJ = j(c2657aO, c2645a);
        a(objJ, c2657aO);
        return objJ;
    }

    public Object h(String str, Type type) {
        return i(str, C2645a.b(type));
    }

    public Object i(String str, C2645a c2645a) {
        if (str == null) {
            return null;
        }
        return g(new StringReader(str), c2645a);
    }

    public Object j(C2657a c2657a, C2645a c2645a) {
        boolean z7;
        t tVarI0 = c2657a.i0();
        t tVar = this.f18341n;
        if (tVar != null) {
            c2657a.R0(tVar);
        } else if (c2657a.i0() == t.LEGACY_STRICT) {
            c2657a.R0(t.LENIENT);
        }
        try {
            try {
                try {
                    try {
                        c2657a.M0();
                        z7 = false;
                        try {
                            return l(c2645a).c(c2657a);
                        } catch (EOFException e7) {
                            e = e7;
                            if (!z7) {
                                throw new q(e);
                            }
                            c2657a.R0(tVarI0);
                            return null;
                        }
                    } finally {
                        c2657a.R0(tVarI0);
                    }
                } catch (EOFException e8) {
                    e = e8;
                    z7 = true;
                }
            } catch (IOException e9) {
                throw new q(e9);
            }
        } catch (AssertionError e10) {
            throw new AssertionError("AssertionError (GSON 2.12.0): " + e10.getMessage(), e10);
        } catch (IllegalStateException e11) {
            throw new q(e11);
        }
    }

    public w k(Class cls) {
        return l(C2645a.a(cls));
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0051, code lost:
    
        r2.h(r4);
        r0.put(r7, r4);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public l4.w l(s4.C2645a r7) {
        /*
            r6 = this;
            java.lang.String r0 = "type must not be null"
            java.util.Objects.requireNonNull(r7, r0)
            java.util.concurrent.ConcurrentMap r0 = r6.f18329b
            java.lang.Object r0 = r0.get(r7)
            l4.w r0 = (l4.w) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            java.lang.ThreadLocal r0 = r6.f18328a
            java.lang.Object r0 = r0.get()
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L26
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.lang.ThreadLocal r1 = r6.f18328a
            r1.set(r0)
            r1 = 1
            goto L30
        L26:
            java.lang.Object r1 = r0.get(r7)
            l4.w r1 = (l4.w) r1
            if (r1 == 0) goto L2f
            return r1
        L2f:
            r1 = 0
        L30:
            l4.e$f r2 = new l4.e$f     // Catch: java.lang.Throwable -> L58
            r2.<init>()     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r2)     // Catch: java.lang.Throwable -> L58
            java.util.List r3 = r6.f18332e     // Catch: java.lang.Throwable -> L58
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.Throwable -> L58
            r4 = 0
        L3f:
            boolean r5 = r3.hasNext()     // Catch: java.lang.Throwable -> L58
            if (r5 == 0) goto L5a
            java.lang.Object r4 = r3.next()     // Catch: java.lang.Throwable -> L58
            l4.x r4 = (l4.x) r4     // Catch: java.lang.Throwable -> L58
            l4.w r4 = r4.create(r6, r7)     // Catch: java.lang.Throwable -> L58
            if (r4 == 0) goto L3f
            r2.h(r4)     // Catch: java.lang.Throwable -> L58
            r0.put(r7, r4)     // Catch: java.lang.Throwable -> L58
            goto L5a
        L58:
            r7 = move-exception
            goto L82
        L5a:
            if (r1 == 0) goto L61
            java.lang.ThreadLocal r2 = r6.f18328a
            r2.remove()
        L61:
            if (r4 == 0) goto L6b
            if (r1 == 0) goto L6a
            java.util.concurrent.ConcurrentMap r7 = r6.f18329b
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
            java.lang.ThreadLocal r0 = r6.f18328a
            r0.remove()
        L89:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: l4.C2172e.l(s4.a):l4.w");
    }

    public w m(x xVar, C2645a c2645a) {
        Objects.requireNonNull(xVar, "skipPast must not be null");
        Objects.requireNonNull(c2645a, "type must not be null");
        if (this.f18331d.d(c2645a, xVar)) {
            xVar = this.f18331d;
        }
        boolean z7 = false;
        for (x xVar2 : this.f18332e) {
            if (z7) {
                w wVarCreate = xVar2.create(this, c2645a);
                if (wVarCreate != null) {
                    return wVarCreate;
                }
            } else if (xVar2 == xVar) {
                z7 = true;
            }
        }
        if (!z7) {
            return l(c2645a);
        }
        throw new IllegalArgumentException("GSON cannot serialize or deserialize " + c2645a);
    }

    public C2657a o(Reader reader) {
        C2657a c2657a = new C2657a(reader);
        t tVar = this.f18341n;
        if (tVar == null) {
            tVar = t.LEGACY_STRICT;
        }
        c2657a.R0(tVar);
        return c2657a;
    }

    public t4.c p(Writer writer) throws IOException {
        if (this.f18338k) {
            writer.write(")]}'\n");
        }
        t4.c cVar = new t4.c(writer);
        cVar.E0(this.f18340m);
        cVar.F0(this.f18339l);
        t tVar = this.f18341n;
        if (tVar == null) {
            tVar = t.LEGACY_STRICT;
        }
        cVar.H0(tVar);
        cVar.G0(this.f18336i);
        return cVar;
    }

    public String q(Object obj) {
        return obj == null ? s(l.f18379a) : r(obj, obj.getClass());
    }

    public String r(Object obj, Type type) {
        StringWriter stringWriter = new StringWriter();
        t(obj, type, stringWriter);
        return stringWriter.toString();
    }

    public String s(AbstractC2177j abstractC2177j) {
        StringWriter stringWriter = new StringWriter();
        v(abstractC2177j, stringWriter);
        return stringWriter.toString();
    }

    public void t(Object obj, Type type, Appendable appendable) {
        try {
            u(obj, type, p(F.c(appendable)));
        } catch (IOException e7) {
            throw new C2178k(e7);
        }
    }

    public String toString() {
        return "{serializeNulls:" + this.f18336i + ",factories:" + this.f18332e + ",instanceCreators:" + this.f18330c + "}";
    }

    public void u(Object obj, Type type, t4.c cVar) {
        w wVarL = l(C2645a.b(type));
        t tVarV = cVar.V();
        t tVar = this.f18341n;
        if (tVar != null) {
            cVar.H0(tVar);
        } else if (cVar.V() == t.LEGACY_STRICT) {
            cVar.H0(t.LENIENT);
        }
        boolean zX = cVar.X();
        boolean zT = cVar.T();
        cVar.F0(this.f18339l);
        cVar.G0(this.f18336i);
        try {
            try {
                try {
                    wVarL.e(cVar, obj);
                } catch (AssertionError e7) {
                    throw new AssertionError("AssertionError (GSON 2.12.0): " + e7.getMessage(), e7);
                }
            } catch (IOException e8) {
                throw new C2178k(e8);
            }
        } finally {
            cVar.H0(tVarV);
            cVar.F0(zX);
            cVar.G0(zT);
        }
    }

    public void v(AbstractC2177j abstractC2177j, Appendable appendable) {
        try {
            w(abstractC2177j, p(F.c(appendable)));
        } catch (IOException e7) {
            throw new C2178k(e7);
        }
    }

    public void w(AbstractC2177j abstractC2177j, t4.c cVar) {
        t tVarV = cVar.V();
        boolean zX = cVar.X();
        boolean zT = cVar.T();
        cVar.F0(this.f18339l);
        cVar.G0(this.f18336i);
        t tVar = this.f18341n;
        if (tVar != null) {
            cVar.H0(tVar);
        } else if (cVar.V() == t.LEGACY_STRICT) {
            cVar.H0(t.LENIENT);
        }
        try {
            try {
                F.b(abstractC2177j, cVar);
            } catch (IOException e7) {
                throw new C2178k(e7);
            } catch (AssertionError e8) {
                throw new AssertionError("AssertionError (GSON 2.12.0): " + e8.getMessage(), e8);
            }
        } finally {
            cVar.H0(tVarV);
            cVar.F0(zX);
            cVar.G0(zT);
        }
    }
}
