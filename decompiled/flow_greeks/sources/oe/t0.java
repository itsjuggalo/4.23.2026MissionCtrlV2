package oe;

import dd.v0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18060a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List f18061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List f18062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List f18063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map f18064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map f18065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set f18066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set f18067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a.C0309a f18068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Map f18069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Map f18070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final Set f18071l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final Set f18072m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final Map f18073n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: oe.t0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0309a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f18074a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ef.f f18075b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final String f18076c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final String f18077d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final String f18078e;

            public C0309a(String classInternalName, ef.f name, String parameters, String returnType) {
                kotlin.jvm.internal.t.f(classInternalName, "classInternalName");
                kotlin.jvm.internal.t.f(name, "name");
                kotlin.jvm.internal.t.f(parameters, "parameters");
                kotlin.jvm.internal.t.f(returnType, "returnType");
                this.f18074a = classInternalName;
                this.f18075b = name;
                this.f18076c = parameters;
                this.f18077d = returnType;
                this.f18078e = xe.f0.f24840a.l(classInternalName, name + '(' + parameters + ')' + returnType);
            }

            public static /* synthetic */ C0309a b(C0309a c0309a, String str, ef.f fVar, String str2, String str3, int i10, Object obj) {
                if ((i10 & 1) != 0) {
                    str = c0309a.f18074a;
                }
                if ((i10 & 2) != 0) {
                    fVar = c0309a.f18075b;
                }
                if ((i10 & 4) != 0) {
                    str2 = c0309a.f18076c;
                }
                if ((i10 & 8) != 0) {
                    str3 = c0309a.f18077d;
                }
                return c0309a.a(str, fVar, str2, str3);
            }

            public final C0309a a(String classInternalName, ef.f name, String parameters, String returnType) {
                kotlin.jvm.internal.t.f(classInternalName, "classInternalName");
                kotlin.jvm.internal.t.f(name, "name");
                kotlin.jvm.internal.t.f(parameters, "parameters");
                kotlin.jvm.internal.t.f(returnType, "returnType");
                return new C0309a(classInternalName, name, parameters, returnType);
            }

            public final ef.f c() {
                return this.f18075b;
            }

            public final String d() {
                return this.f18078e;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C0309a)) {
                    return false;
                }
                C0309a c0309a = (C0309a) obj;
                return kotlin.jvm.internal.t.b(this.f18074a, c0309a.f18074a) && kotlin.jvm.internal.t.b(this.f18075b, c0309a.f18075b) && kotlin.jvm.internal.t.b(this.f18076c, c0309a.f18076c) && kotlin.jvm.internal.t.b(this.f18077d, c0309a.f18077d);
            }

            public int hashCode() {
                return (((((this.f18074a.hashCode() * 31) + this.f18075b.hashCode()) * 31) + this.f18076c.hashCode()) * 31) + this.f18077d.hashCode();
            }

            public String toString() {
                return "NameAndSignature(classInternalName=" + this.f18074a + ", name=" + this.f18075b + ", parameters=" + this.f18076c + ", returnType=" + this.f18077d + ')';
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final ef.f b(ef.f name) {
            kotlin.jvm.internal.t.f(name, "name");
            return (ef.f) f().get(name);
        }

        public final List c() {
            return t0.f18062c;
        }

        public final Set d() {
            return t0.f18066g;
        }

        public final Set e() {
            return t0.f18067h;
        }

        public final Map f() {
            return t0.f18073n;
        }

        public final Set g() {
            return t0.f18072m;
        }

        public final C0309a h() {
            return t0.f18068i;
        }

        public final Map i() {
            return t0.f18065f;
        }

        public final Map j() {
            return t0.f18070k;
        }

        public final boolean k(ef.f fVar) {
            kotlin.jvm.internal.t.f(fVar, "<this>");
            return g().contains(fVar);
        }

        public final b l(String builtinSignature) {
            kotlin.jvm.internal.t.f(builtinSignature, "builtinSignature");
            return c().contains(builtinSignature) ? b.f18079c : ((c) dd.o0.i(i(), builtinSignature)) == c.f18086b ? b.f18081e : b.f18080d;
        }

        public final C0309a m(String str, String str2, String str3, String str4) {
            ef.f fVarK = ef.f.k(str2);
            kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
            return new C0309a(str, fVarK, str3, str4);
        }

        public a() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final b f18079c = new b("ONE_COLLECTION_PARAMETER", 0, "Ljava/util/Collection<+Ljava/lang/Object;>;", false);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final b f18080d = new b("OBJECT_PARAMETER_NON_GENERIC", 1, null, true);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final b f18081e = new b("OBJECT_PARAMETER_GENERIC", 2, "Ljava/lang/Object;", true);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ b[] f18082f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ jd.a f18083g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18084a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f18085b;

        static {
            b[] bVarArrA = a();
            f18082f = bVarArrA;
            f18083g = jd.b.a(bVarArrA);
        }

        public b(String str, int i10, String str2, boolean z10) {
            this.f18084a = str2;
            this.f18085b = z10;
        }

        public static final /* synthetic */ b[] a() {
            return new b[]{f18079c, f18080d, f18081e};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) f18082f.clone();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f18086b = new c("NULL", 0, null);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f18087c = new c("INDEX", 1, -1);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f18088d = new c("FALSE", 2, Boolean.FALSE);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f18089e = new a("MAP_GET_OR_DEFAULT", 3);

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final /* synthetic */ c[] f18090f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final /* synthetic */ jd.a f18091g;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f18092a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends c {
            /* JADX WARN: Illegal instructions before constructor call */
            public a(String str, int i10) {
                kotlin.jvm.internal.k kVar = null;
                super(str, i10, kVar, kVar);
            }
        }

        static {
            c[] cVarArrA = a();
            f18090f = cVarArrA;
            f18091g = jd.b.a(cVarArrA);
        }

        public /* synthetic */ c(String str, int i10, Object obj, kotlin.jvm.internal.k kVar) {
            this(str, i10, obj);
        }

        public static final /* synthetic */ c[] a() {
            return new c[]{f18086b, f18087c, f18088d, f18089e};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f18090f.clone();
        }

        public c(String str, int i10, Object obj) {
            this.f18092a = obj;
        }
    }

    static {
        Set<String> setH = dd.u0.h("containsAll", "removeAll", "retainAll");
        ArrayList arrayList = new ArrayList(dd.s.u(setH, 10));
        for (String str : setH) {
            a aVar = f18060a;
            String strH = of.e.BOOLEAN.h();
            kotlin.jvm.internal.t.e(strH, "getDesc(...)");
            arrayList.add(aVar.m("java/util/Collection", str, "Ljava/util/Collection;", strH));
        }
        f18061b = arrayList;
        ArrayList arrayList2 = new ArrayList(dd.s.u(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((a.C0309a) it.next()).d());
        }
        f18062c = arrayList2;
        List list = f18061b;
        ArrayList arrayList3 = new ArrayList(dd.s.u(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList3.add(((a.C0309a) it2.next()).c().b());
        }
        f18063d = arrayList3;
        xe.f0 f0Var = xe.f0.f24840a;
        a aVar2 = f18060a;
        String strI = f0Var.i("Collection");
        of.e eVar = of.e.BOOLEAN;
        String strH2 = eVar.h();
        kotlin.jvm.internal.t.e(strH2, "getDesc(...)");
        a.C0309a c0309aM = aVar2.m(strI, "contains", "Ljava/lang/Object;", strH2);
        c cVar = c.f18088d;
        cd.q qVarA = cd.w.a(c0309aM, cVar);
        String strI2 = f0Var.i("Collection");
        String strH3 = eVar.h();
        kotlin.jvm.internal.t.e(strH3, "getDesc(...)");
        cd.q qVarA2 = cd.w.a(aVar2.m(strI2, "remove", "Ljava/lang/Object;", strH3), cVar);
        String strI3 = f0Var.i("Map");
        String strH4 = eVar.h();
        kotlin.jvm.internal.t.e(strH4, "getDesc(...)");
        cd.q qVarA3 = cd.w.a(aVar2.m(strI3, "containsKey", "Ljava/lang/Object;", strH4), cVar);
        String strI4 = f0Var.i("Map");
        String strH5 = eVar.h();
        kotlin.jvm.internal.t.e(strH5, "getDesc(...)");
        cd.q qVarA4 = cd.w.a(aVar2.m(strI4, "containsValue", "Ljava/lang/Object;", strH5), cVar);
        String strI5 = f0Var.i("Map");
        String strH6 = eVar.h();
        kotlin.jvm.internal.t.e(strH6, "getDesc(...)");
        cd.q qVarA5 = cd.w.a(aVar2.m(strI5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", strH6), cVar);
        cd.q qVarA6 = cd.w.a(aVar2.m(f0Var.i("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), c.f18089e);
        a.C0309a c0309aM2 = aVar2.m(f0Var.i("Map"), com.amazon.a.a.o.b.au, "Ljava/lang/Object;", "Ljava/lang/Object;");
        c cVar2 = c.f18086b;
        cd.q qVarA7 = cd.w.a(c0309aM2, cVar2);
        cd.q qVarA8 = cd.w.a(aVar2.m(f0Var.i("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), cVar2);
        String strI6 = f0Var.i("List");
        of.e eVar2 = of.e.INT;
        String strH7 = eVar2.h();
        kotlin.jvm.internal.t.e(strH7, "getDesc(...)");
        a.C0309a c0309aM3 = aVar2.m(strI6, "indexOf", "Ljava/lang/Object;", strH7);
        c cVar3 = c.f18087c;
        cd.q qVarA9 = cd.w.a(c0309aM3, cVar3);
        String strI7 = f0Var.i("List");
        String strH8 = eVar2.h();
        kotlin.jvm.internal.t.e(strH8, "getDesc(...)");
        Map mapL = dd.o0.l(qVarA, qVarA2, qVarA3, qVarA4, qVarA5, qVarA6, qVarA7, qVarA8, qVarA9, cd.w.a(aVar2.m(strI7, "lastIndexOf", "Ljava/lang/Object;", strH8), cVar3));
        f18064e = mapL;
        LinkedHashMap linkedHashMap = new LinkedHashMap(dd.n0.d(mapL.size()));
        for (Map.Entry entry : mapL.entrySet()) {
            linkedHashMap.put(((a.C0309a) entry.getKey()).d(), entry.getValue());
        }
        f18065f = linkedHashMap;
        Set setL = v0.l(f18064e.keySet(), f18061b);
        ArrayList arrayList4 = new ArrayList(dd.s.u(setL, 10));
        Iterator it3 = setL.iterator();
        while (it3.hasNext()) {
            arrayList4.add(((a.C0309a) it3.next()).c());
        }
        f18066g = dd.a0.N0(arrayList4);
        ArrayList arrayList5 = new ArrayList(dd.s.u(setL, 10));
        Iterator it4 = setL.iterator();
        while (it4.hasNext()) {
            arrayList5.add(((a.C0309a) it4.next()).d());
        }
        f18067h = dd.a0.N0(arrayList5);
        a aVar3 = f18060a;
        of.e eVar3 = of.e.INT;
        String strH9 = eVar3.h();
        kotlin.jvm.internal.t.e(strH9, "getDesc(...)");
        a.C0309a c0309aM4 = aVar3.m("java/util/List", "removeAt", strH9, "Ljava/lang/Object;");
        f18068i = c0309aM4;
        xe.f0 f0Var2 = xe.f0.f24840a;
        String strH10 = f0Var2.h("Number");
        String strH11 = of.e.BYTE.h();
        kotlin.jvm.internal.t.e(strH11, "getDesc(...)");
        cd.q qVarA10 = cd.w.a(aVar3.m(strH10, "toByte", "", strH11), ef.f.k("byteValue"));
        String strH12 = f0Var2.h("Number");
        String strH13 = of.e.SHORT.h();
        kotlin.jvm.internal.t.e(strH13, "getDesc(...)");
        cd.q qVarA11 = cd.w.a(aVar3.m(strH12, "toShort", "", strH13), ef.f.k("shortValue"));
        String strH14 = f0Var2.h("Number");
        String strH15 = eVar3.h();
        kotlin.jvm.internal.t.e(strH15, "getDesc(...)");
        cd.q qVarA12 = cd.w.a(aVar3.m(strH14, "toInt", "", strH15), ef.f.k("intValue"));
        String strH16 = f0Var2.h("Number");
        String strH17 = of.e.LONG.h();
        kotlin.jvm.internal.t.e(strH17, "getDesc(...)");
        cd.q qVarA13 = cd.w.a(aVar3.m(strH16, "toLong", "", strH17), ef.f.k("longValue"));
        String strH18 = f0Var2.h("Number");
        String strH19 = of.e.FLOAT.h();
        kotlin.jvm.internal.t.e(strH19, "getDesc(...)");
        cd.q qVarA14 = cd.w.a(aVar3.m(strH18, "toFloat", "", strH19), ef.f.k("floatValue"));
        String strH20 = f0Var2.h("Number");
        String strH21 = of.e.DOUBLE.h();
        kotlin.jvm.internal.t.e(strH21, "getDesc(...)");
        cd.q qVarA15 = cd.w.a(aVar3.m(strH20, "toDouble", "", strH21), ef.f.k("doubleValue"));
        cd.q qVarA16 = cd.w.a(c0309aM4, ef.f.k("remove"));
        String strH22 = f0Var2.h("CharSequence");
        String strH23 = eVar3.h();
        kotlin.jvm.internal.t.e(strH23, "getDesc(...)");
        String strH24 = of.e.CHAR.h();
        kotlin.jvm.internal.t.e(strH24, "getDesc(...)");
        Map mapL2 = dd.o0.l(qVarA10, qVarA11, qVarA12, qVarA13, qVarA14, qVarA15, qVarA16, cd.w.a(aVar3.m(strH22, com.amazon.a.a.o.b.au, strH23, strH24), ef.f.k("charAt")));
        f18069j = mapL2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(dd.n0.d(mapL2.size()));
        for (Map.Entry entry2 : mapL2.entrySet()) {
            linkedHashMap2.put(((a.C0309a) entry2.getKey()).d(), entry2.getValue());
        }
        f18070k = linkedHashMap2;
        Map map = f18069j;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (Map.Entry entry3 : map.entrySet()) {
            linkedHashSet.add(a.C0309a.b((a.C0309a) entry3.getKey(), null, (ef.f) entry3.getValue(), null, null, 13, null).d());
        }
        f18071l = linkedHashSet;
        Set setKeySet = f18069j.keySet();
        HashSet hashSet = new HashSet();
        Iterator it5 = setKeySet.iterator();
        while (it5.hasNext()) {
            hashSet.add(((a.C0309a) it5.next()).c());
        }
        f18072m = hashSet;
        Set<Map.Entry> setEntrySet = f18069j.entrySet();
        ArrayList<cd.q> arrayList6 = new ArrayList(dd.s.u(setEntrySet, 10));
        for (Map.Entry entry4 : setEntrySet) {
            arrayList6.add(new cd.q(((a.C0309a) entry4.getKey()).c(), entry4.getValue()));
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(arrayList6, 10)), 16));
        for (cd.q qVar : arrayList6) {
            linkedHashMap3.put((ef.f) qVar.d(), (ef.f) qVar.c());
        }
        f18073n = linkedHashMap3;
    }
}
