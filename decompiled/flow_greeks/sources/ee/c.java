package ee;

import ce.o;
import de.f;
import ef.b;
import java.lang.annotation.Annotation;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kg.c0;
import kg.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f8682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f8683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String f8684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final String f8685e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final ef.b f8686f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ef.c f8687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final ef.b f8688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final ef.b f8689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ef.b f8690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final HashMap f8691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final HashMap f8692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final HashMap f8693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final HashMap f8694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final HashMap f8695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final HashMap f8696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final List f8697q;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ef.b f8698a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ef.b f8699b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ef.b f8700c;

        public a(ef.b javaClass, ef.b kotlinReadOnly, ef.b kotlinMutable) {
            kotlin.jvm.internal.t.f(javaClass, "javaClass");
            kotlin.jvm.internal.t.f(kotlinReadOnly, "kotlinReadOnly");
            kotlin.jvm.internal.t.f(kotlinMutable, "kotlinMutable");
            this.f8698a = javaClass;
            this.f8699b = kotlinReadOnly;
            this.f8700c = kotlinMutable;
        }

        public final ef.b a() {
            return this.f8698a;
        }

        public final ef.b b() {
            return this.f8699b;
        }

        public final ef.b c() {
            return this.f8700c;
        }

        public final ef.b d() {
            return this.f8698a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return kotlin.jvm.internal.t.b(this.f8698a, aVar.f8698a) && kotlin.jvm.internal.t.b(this.f8699b, aVar.f8699b) && kotlin.jvm.internal.t.b(this.f8700c, aVar.f8700c);
        }

        public int hashCode() {
            return (((this.f8698a.hashCode() * 31) + this.f8699b.hashCode()) * 31) + this.f8700c.hashCode();
        }

        public String toString() {
            return "PlatformMutabilityMapping(javaClass=" + this.f8698a + ", kotlinReadOnly=" + this.f8699b + ", kotlinMutable=" + this.f8700c + ')';
        }
    }

    static {
        c cVar = new c();
        f8681a = cVar;
        StringBuilder sb2 = new StringBuilder();
        f.a aVar = f.a.f8069e;
        sb2.append(aVar.b());
        sb2.append(com.amazon.a.a.o.c.a.b.f4610a);
        sb2.append(aVar.a());
        f8682b = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        f.b bVar = f.b.f8070e;
        sb3.append(bVar.b());
        sb3.append(com.amazon.a.a.o.c.a.b.f4610a);
        sb3.append(bVar.a());
        f8683c = sb3.toString();
        StringBuilder sb4 = new StringBuilder();
        f.d dVar = f.d.f8072e;
        sb4.append(dVar.b());
        sb4.append(com.amazon.a.a.o.c.a.b.f4610a);
        sb4.append(dVar.a());
        f8684d = sb4.toString();
        StringBuilder sb5 = new StringBuilder();
        f.c cVar2 = f.c.f8071e;
        sb5.append(cVar2.b());
        sb5.append(com.amazon.a.a.o.c.a.b.f4610a);
        sb5.append(cVar2.a());
        f8685e = sb5.toString();
        b.a aVar2 = ef.b.f8779d;
        ef.b bVarC = aVar2.c(new ef.c("kotlin.jvm.functions.FunctionN"));
        f8686f = bVarC;
        f8687g = bVarC.a();
        ef.i iVar = ef.i.f8818a;
        f8688h = iVar.k();
        f8689i = iVar.j();
        f8690j = cVar.g(Class.class);
        f8691k = new HashMap();
        f8692l = new HashMap();
        f8693m = new HashMap();
        f8694n = new HashMap();
        f8695o = new HashMap();
        f8696p = new HashMap();
        ef.b bVarC2 = aVar2.c(o.a.W);
        a aVar3 = new a(cVar.g(Iterable.class), bVarC2, new ef.b(bVarC2.f(), ef.e.g(o.a.f3982e0, bVarC2.f()), false));
        ef.b bVarC3 = aVar2.c(o.a.V);
        a aVar4 = new a(cVar.g(Iterator.class), bVarC3, new ef.b(bVarC3.f(), ef.e.g(o.a.f3980d0, bVarC3.f()), false));
        ef.b bVarC4 = aVar2.c(o.a.X);
        a aVar5 = new a(cVar.g(Collection.class), bVarC4, new ef.b(bVarC4.f(), ef.e.g(o.a.f3984f0, bVarC4.f()), false));
        ef.b bVarC5 = aVar2.c(o.a.Y);
        a aVar6 = new a(cVar.g(List.class), bVarC5, new ef.b(bVarC5.f(), ef.e.g(o.a.f3986g0, bVarC5.f()), false));
        ef.b bVarC6 = aVar2.c(o.a.f3974a0);
        a aVar7 = new a(cVar.g(Set.class), bVarC6, new ef.b(bVarC6.f(), ef.e.g(o.a.f3990i0, bVarC6.f()), false));
        ef.b bVarC7 = aVar2.c(o.a.Z);
        a aVar8 = new a(cVar.g(ListIterator.class), bVarC7, new ef.b(bVarC7.f(), ef.e.g(o.a.f3988h0, bVarC7.f()), false));
        ef.c cVar3 = o.a.f3976b0;
        ef.b bVarC8 = aVar2.c(cVar3);
        a aVar9 = new a(cVar.g(Map.class), bVarC8, new ef.b(bVarC8.f(), ef.e.g(o.a.f3992j0, bVarC8.f()), false));
        ef.b bVarD = aVar2.c(cVar3).d(o.a.f3978c0.f());
        List listN = dd.r.n(aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9, new a(cVar.g(Map.Entry.class), bVarD, new ef.b(bVarD.f(), ef.e.g(o.a.f3994k0, bVarD.f()), false)));
        f8697q = listN;
        cVar.f(Object.class, o.a.f3975b);
        cVar.f(String.class, o.a.f3987h);
        cVar.f(CharSequence.class, o.a.f3985g);
        cVar.e(Throwable.class, o.a.f4013u);
        cVar.f(Cloneable.class, o.a.f3979d);
        cVar.f(Number.class, o.a.f4007r);
        cVar.e(Comparable.class, o.a.f4015v);
        cVar.f(Enum.class, o.a.f4009s);
        cVar.e(Annotation.class, o.a.G);
        Iterator it = listN.iterator();
        while (it.hasNext()) {
            f8681a.d((a) it.next());
        }
        for (of.e eVar : of.e.values()) {
            c cVar4 = f8681a;
            b.a aVar10 = ef.b.f8779d;
            ef.c cVarL = eVar.l();
            kotlin.jvm.internal.t.e(cVarL, "getWrapperFqName(...)");
            ef.b bVarC9 = aVar10.c(cVarL);
            ce.l lVarK = eVar.k();
            kotlin.jvm.internal.t.e(lVarK, "getPrimitiveType(...)");
            cVar4.a(bVarC9, aVar10.c(ce.o.c(lVarK)));
        }
        for (ef.b bVar2 : ce.d.f3895a.a()) {
            f8681a.a(ef.b.f8779d.c(new ef.c("kotlin.jvm.internal." + bVar2.h().b() + "CompanionObject")), bVar2.d(ef.h.f8803d));
        }
        for (int i10 = 0; i10 < 23; i10++) {
            c cVar5 = f8681a;
            cVar5.a(ef.b.f8779d.c(new ef.c("kotlin.jvm.functions.Function" + i10)), ce.o.a(i10));
            cVar5.c(new ef.c(f8683c + i10), f8688h);
        }
        for (int i11 = 0; i11 < 22; i11++) {
            f.c cVar6 = f.c.f8071e;
            f8681a.c(new ef.c((cVar6.b() + com.amazon.a.a.o.c.a.b.f4610a + cVar6.a()) + i11), f8688h);
        }
        c cVar7 = f8681a;
        cVar7.c(o.a.f3977c.m(), cVar7.g(Void.class));
    }

    public final void a(ef.b bVar, ef.b bVar2) {
        b(bVar, bVar2);
        c(bVar2.a(), bVar);
    }

    public final void b(ef.b bVar, ef.b bVar2) {
        f8691k.put(bVar.a().i(), bVar2);
    }

    public final void c(ef.c cVar, ef.b bVar) {
        f8692l.put(cVar.i(), bVar);
    }

    public final void d(a aVar) {
        ef.b bVarA = aVar.a();
        ef.b bVarB = aVar.b();
        ef.b bVarC = aVar.c();
        a(bVarA, bVarB);
        c(bVarC.a(), bVarA);
        f8695o.put(bVarC, bVarB);
        f8696p.put(bVarB, bVarC);
        ef.c cVarA = bVarB.a();
        ef.c cVarA2 = bVarC.a();
        f8693m.put(bVarC.a().i(), cVarA);
        f8694n.put(cVarA.i(), cVarA2);
    }

    public final void e(Class cls, ef.c cVar) {
        a(g(cls), ef.b.f8779d.c(cVar));
    }

    public final void f(Class cls, ef.d dVar) {
        e(cls, dVar.m());
    }

    public final ef.b g(Class cls) {
        if (!cls.isPrimitive()) {
            cls.isArray();
        }
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            b.a aVar = ef.b.f8779d;
            String canonicalName = cls.getCanonicalName();
            kotlin.jvm.internal.t.e(canonicalName, "getCanonicalName(...)");
            return aVar.c(new ef.c(canonicalName));
        }
        ef.b bVarG = g(declaringClass);
        ef.f fVarK = ef.f.k(cls.getSimpleName());
        kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
        return bVarG.d(fVarK);
    }

    public final ef.c h() {
        return f8687g;
    }

    public final List i() {
        return f8697q;
    }

    public final boolean j(ef.d dVar, String str) {
        Integer numO;
        String strA = dVar.a();
        if (!z.J(strA, str, false, 2, null)) {
            return false;
        }
        String strSubstring = strA.substring(str.length());
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return (c0.J0(strSubstring, '0', false, 2, null) || (numO = kg.y.o(strSubstring)) == null || numO.intValue() < 23) ? false : true;
    }

    public final boolean k(ef.d dVar) {
        return f8693m.containsKey(dVar);
    }

    public final boolean l(ef.d dVar) {
        return f8694n.containsKey(dVar);
    }

    public final ef.b m(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return (ef.b) f8691k.get(fqName.i());
    }

    public final ef.b n(ef.d kotlinFqName) {
        kotlin.jvm.internal.t.f(kotlinFqName, "kotlinFqName");
        return j(kotlinFqName, f8682b) ? f8686f : j(kotlinFqName, f8684d) ? f8686f : j(kotlinFqName, f8683c) ? f8688h : j(kotlinFqName, f8685e) ? f8688h : (ef.b) f8692l.get(kotlinFqName);
    }

    public final ef.c o(ef.d dVar) {
        return (ef.c) f8693m.get(dVar);
    }

    public final ef.c p(ef.d dVar) {
        return (ef.c) f8694n.get(dVar);
    }
}
