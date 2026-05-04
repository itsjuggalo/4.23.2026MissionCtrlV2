package vf;

import dd.v0;
import fe.f1;
import fe.k1;
import fe.y0;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function0;
import qf.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class w extends qf.l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f23497f = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(w.class, "classNames", "getClassNames$deserialization()Ljava/util/Set;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(w.class, "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;", 0))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tf.p f23498b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f23499c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.i f23500d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.j f23501e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a {
        Collection a(ef.f fVar, ne.b bVar);

        Set b();

        Collection c(ef.f fVar, ne.b bVar);

        Set d();

        k1 e(ef.f fVar);

        void f(Collection collection, qf.d dVar, pd.k kVar, ne.b bVar);

        Set g();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b implements a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ wd.m[] f23502o = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "declaredProperties", "getDeclaredProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "allTypeAliases", "getAllTypeAliases()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "allFunctions", "getAllFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "allProperties", "getAllProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "functionsByName", "getFunctionsByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "propertiesByName", "getPropertiesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(b.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f23503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f23504b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f23505c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final wf.i f23506d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final wf.i f23507e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final wf.i f23508f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final wf.i f23509g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final wf.i f23510h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final wf.i f23511i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final wf.i f23512j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final wf.i f23513k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final wf.i f23514l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final wf.i f23515m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ w f23516n;

        public b(w wVar, List functionList, List propertyList, List typeAliasList) {
            kotlin.jvm.internal.t.f(functionList, "functionList");
            kotlin.jvm.internal.t.f(propertyList, "propertyList");
            kotlin.jvm.internal.t.f(typeAliasList, "typeAliasList");
            this.f23516n = wVar;
            this.f23503a = functionList;
            this.f23504b = propertyList;
            this.f23505c = wVar.s().c().g().g() ? typeAliasList : dd.r.k();
            this.f23506d = wVar.s().h().e(new x(this));
            this.f23507e = wVar.s().h().e(new y(this));
            this.f23508f = wVar.s().h().e(new z(this));
            this.f23509g = wVar.s().h().e(new a0(this));
            this.f23510h = wVar.s().h().e(new b0(this));
            this.f23511i = wVar.s().h().e(new c0(this));
            this.f23512j = wVar.s().h().e(new d0(this));
            this.f23513k = wVar.s().h().e(new e0(this));
            this.f23514l = wVar.s().h().e(new f0(this, wVar));
            this.f23515m = wVar.s().h().e(new g0(this, wVar));
        }

        public static final List B(b bVar) {
            return bVar.w();
        }

        public static final List C(b bVar) {
            return bVar.z();
        }

        public static final Set D(b bVar, w wVar) {
            List list = bVar.f23503a;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            w wVar2 = bVar.f23516n;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(tf.l0.b(wVar2.s().g(), ((ze.i) ((gf.p) it.next())).d0()));
            }
            return v0.l(linkedHashSet, wVar.w());
        }

        public static final Map E(b bVar) {
            List listF = bVar.F();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : listF) {
                ef.f name = ((f1) obj).getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                Object arrayList = linkedHashMap.get(name);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(name, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            return linkedHashMap;
        }

        public static final Map N(b bVar) {
            List listG = bVar.G();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : listG) {
                ef.f name = ((y0) obj).getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                Object arrayList = linkedHashMap.get(name);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(name, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            return linkedHashMap;
        }

        public static final Map O(b bVar) {
            List listH = bVar.H();
            LinkedHashMap linkedHashMap = new LinkedHashMap(vd.l.b(dd.n0.d(dd.s.u(listH, 10)), 16));
            for (Object obj : listH) {
                ef.f name = ((k1) obj).getName();
                kotlin.jvm.internal.t.e(name, "getName(...)");
                linkedHashMap.put(name, obj);
            }
            return linkedHashMap;
        }

        public static final Set P(b bVar, w wVar) {
            List list = bVar.f23504b;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            w wVar2 = bVar.f23516n;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(tf.l0.b(wVar2.s().g(), ((ze.n) ((gf.p) it.next())).c0()));
            }
            return v0.l(linkedHashSet, wVar.x());
        }

        public static final List r(b bVar) {
            return dd.a0.s0(bVar.I(), bVar.u());
        }

        public static final List s(b bVar) {
            return dd.a0.s0(bVar.J(), bVar.v());
        }

        public static final List t(b bVar) {
            return bVar.A();
        }

        public final List A() {
            List list = this.f23505c;
            w wVar = this.f23516n;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                k1 k1VarZ = wVar.s().f().z((ze.r) ((gf.p) it.next()));
                if (k1VarZ != null) {
                    arrayList.add(k1VarZ);
                }
            }
            return arrayList;
        }

        public final List F() {
            return (List) wf.m.a(this.f23509g, this, f23502o[3]);
        }

        public final List G() {
            return (List) wf.m.a(this.f23510h, this, f23502o[4]);
        }

        public final List H() {
            return (List) wf.m.a(this.f23508f, this, f23502o[2]);
        }

        public final List I() {
            return (List) wf.m.a(this.f23506d, this, f23502o[0]);
        }

        public final List J() {
            return (List) wf.m.a(this.f23507e, this, f23502o[1]);
        }

        public final Map K() {
            return (Map) wf.m.a(this.f23512j, this, f23502o[6]);
        }

        public final Map L() {
            return (Map) wf.m.a(this.f23513k, this, f23502o[7]);
        }

        public final Map M() {
            return (Map) wf.m.a(this.f23511i, this, f23502o[5]);
        }

        @Override // vf.w.a
        public Collection a(ef.f name, ne.b location) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(location, "location");
            if (!d().contains(name)) {
                return dd.r.k();
            }
            Collection collection = (Collection) L().get(name);
            return collection == null ? dd.r.k() : collection;
        }

        @Override // vf.w.a
        public Set b() {
            return (Set) wf.m.a(this.f23514l, this, f23502o[8]);
        }

        @Override // vf.w.a
        public Collection c(ef.f name, ne.b location) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(location, "location");
            if (!b().contains(name)) {
                return dd.r.k();
            }
            Collection collection = (Collection) K().get(name);
            return collection == null ? dd.r.k() : collection;
        }

        @Override // vf.w.a
        public Set d() {
            return (Set) wf.m.a(this.f23515m, this, f23502o[9]);
        }

        @Override // vf.w.a
        public k1 e(ef.f name) {
            kotlin.jvm.internal.t.f(name, "name");
            return (k1) M().get(name);
        }

        @Override // vf.w.a
        public void f(Collection result, qf.d kindFilter, pd.k nameFilter, ne.b location) {
            kotlin.jvm.internal.t.f(result, "result");
            kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
            kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
            kotlin.jvm.internal.t.f(location, "location");
            if (kindFilter.a(qf.d.f19046c.i())) {
                for (Object obj : G()) {
                    ef.f name = ((y0) obj).getName();
                    kotlin.jvm.internal.t.e(name, "getName(...)");
                    if (((Boolean) nameFilter.invoke(name)).booleanValue()) {
                        result.add(obj);
                    }
                }
            }
            if (kindFilter.a(qf.d.f19046c.d())) {
                for (Object obj2 : F()) {
                    ef.f name2 = ((f1) obj2).getName();
                    kotlin.jvm.internal.t.e(name2, "getName(...)");
                    if (((Boolean) nameFilter.invoke(name2)).booleanValue()) {
                        result.add(obj2);
                    }
                }
            }
        }

        @Override // vf.w.a
        public Set g() {
            List list = this.f23505c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            w wVar = this.f23516n;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(tf.l0.b(wVar.s().g(), ((ze.r) ((gf.p) it.next())).W()));
            }
            return linkedHashSet;
        }

        public final List u() {
            Set setW = this.f23516n.w();
            ArrayList arrayList = new ArrayList();
            Iterator it = setW.iterator();
            while (it.hasNext()) {
                dd.w.z(arrayList, x((ef.f) it.next()));
            }
            return arrayList;
        }

        public final List v() {
            Set setX = this.f23516n.x();
            ArrayList arrayList = new ArrayList();
            Iterator it = setX.iterator();
            while (it.hasNext()) {
                dd.w.z(arrayList, y((ef.f) it.next()));
            }
            return arrayList;
        }

        public final List w() {
            List list = this.f23503a;
            w wVar = this.f23516n;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                f1 f1VarS = wVar.s().f().s((ze.i) ((gf.p) it.next()));
                if (!wVar.A(f1VarS)) {
                    f1VarS = null;
                }
                if (f1VarS != null) {
                    arrayList.add(f1VarS);
                }
            }
            return arrayList;
        }

        public final List x(ef.f fVar) {
            List listI = I();
            w wVar = this.f23516n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listI) {
                if (kotlin.jvm.internal.t.b(((fe.m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            wVar.n(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        public final List y(ef.f fVar) {
            List listJ = J();
            w wVar = this.f23516n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listJ) {
                if (kotlin.jvm.internal.t.b(((fe.m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            wVar.o(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        public final List z() {
            List list = this.f23504b;
            w wVar = this.f23516n;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                y0 y0VarU = wVar.s().f().u((ze.n) ((gf.p) it.next()));
                if (y0VarU != null) {
                    arrayList.add(y0VarU);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class c implements a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ wd.m[] f23517j = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(c.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(c.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f23518a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f23519b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map f23520c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final wf.g f23521d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final wf.g f23522e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final wf.h f23523f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final wf.i f23524g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final wf.i f23525h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ w f23526i;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ gf.r f23527a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ByteArrayInputStream f23528b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ w f23529c;

            public a(gf.r rVar, ByteArrayInputStream byteArrayInputStream, w wVar) {
                this.f23527a = rVar;
                this.f23528b = byteArrayInputStream;
                this.f23529c = wVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final gf.p invoke() {
                return (gf.p) this.f23527a.b(this.f23528b, this.f23529c.s().c().k());
            }
        }

        public c(w wVar, List functionList, List propertyList, List typeAliasList) throws IOException {
            Map mapH;
            kotlin.jvm.internal.t.f(functionList, "functionList");
            kotlin.jvm.internal.t.f(propertyList, "propertyList");
            kotlin.jvm.internal.t.f(typeAliasList, "typeAliasList");
            this.f23526i = wVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : functionList) {
                ef.f fVarB = tf.l0.b(wVar.s().g(), ((ze.i) ((gf.p) obj)).d0());
                Object arrayList = linkedHashMap.get(fVarB);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(fVarB, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.f23518a = r(linkedHashMap);
            w wVar2 = this.f23526i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : propertyList) {
                ef.f fVarB2 = tf.l0.b(wVar2.s().g(), ((ze.n) ((gf.p) obj2)).c0());
                Object arrayList2 = linkedHashMap2.get(fVarB2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(fVarB2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.f23519b = r(linkedHashMap2);
            if (this.f23526i.s().c().g().g()) {
                w wVar3 = this.f23526i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : typeAliasList) {
                    ef.f fVarB3 = tf.l0.b(wVar3.s().g(), ((ze.r) ((gf.p) obj3)).W());
                    Object arrayList3 = linkedHashMap3.get(fVarB3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(fVarB3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapH = r(linkedHashMap3);
            } else {
                mapH = dd.o0.h();
            }
            this.f23520c = mapH;
            this.f23521d = this.f23526i.s().h().i(new h0(this));
            this.f23522e = this.f23526i.s().h().i(new i0(this));
            this.f23523f = this.f23526i.s().h().h(new j0(this));
            this.f23524g = this.f23526i.s().h().e(new k0(this, this.f23526i));
            this.f23525h = this.f23526i.s().h().e(new l0(this, this.f23526i));
        }

        public static final Set p(c cVar, w wVar) {
            return v0.l(cVar.f23518a.keySet(), wVar.w());
        }

        public static final Collection q(c cVar, ef.f it) {
            kotlin.jvm.internal.t.f(it, "it");
            return cVar.m(it);
        }

        public static final Collection s(c cVar, ef.f it) {
            kotlin.jvm.internal.t.f(it, "it");
            return cVar.n(it);
        }

        public static final k1 t(c cVar, ef.f it) {
            kotlin.jvm.internal.t.f(it, "it");
            return cVar.o(it);
        }

        public static final Set u(c cVar, w wVar) {
            return v0.l(cVar.f23519b.keySet(), wVar.x());
        }

        @Override // vf.w.a
        public Collection a(ef.f name, ne.b location) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(location, "location");
            return !d().contains(name) ? dd.r.k() : (Collection) this.f23522e.invoke(name);
        }

        @Override // vf.w.a
        public Set b() {
            return (Set) wf.m.a(this.f23524g, this, f23517j[0]);
        }

        @Override // vf.w.a
        public Collection c(ef.f name, ne.b location) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(location, "location");
            return !b().contains(name) ? dd.r.k() : (Collection) this.f23521d.invoke(name);
        }

        @Override // vf.w.a
        public Set d() {
            return (Set) wf.m.a(this.f23525h, this, f23517j[1]);
        }

        @Override // vf.w.a
        public k1 e(ef.f name) {
            kotlin.jvm.internal.t.f(name, "name");
            return (k1) this.f23523f.invoke(name);
        }

        @Override // vf.w.a
        public void f(Collection result, qf.d kindFilter, pd.k nameFilter, ne.b location) {
            kotlin.jvm.internal.t.f(result, "result");
            kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
            kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
            kotlin.jvm.internal.t.f(location, "location");
            if (kindFilter.a(qf.d.f19046c.i())) {
                Set<ef.f> setD = d();
                ArrayList arrayList = new ArrayList();
                for (ef.f fVar : setD) {
                    if (((Boolean) nameFilter.invoke(fVar)).booleanValue()) {
                        arrayList.addAll(a(fVar, location));
                    }
                }
                jf.l INSTANCE = jf.l.f14335a;
                kotlin.jvm.internal.t.e(INSTANCE, "INSTANCE");
                dd.v.y(arrayList, INSTANCE);
                result.addAll(arrayList);
            }
            if (kindFilter.a(qf.d.f19046c.d())) {
                Set<ef.f> setB = b();
                ArrayList arrayList2 = new ArrayList();
                for (ef.f fVar2 : setB) {
                    if (((Boolean) nameFilter.invoke(fVar2)).booleanValue()) {
                        arrayList2.addAll(c(fVar2, location));
                    }
                }
                jf.l INSTANCE2 = jf.l.f14335a;
                kotlin.jvm.internal.t.e(INSTANCE2, "INSTANCE");
                dd.v.y(arrayList2, INSTANCE2);
                result.addAll(arrayList2);
            }
        }

        @Override // vf.w.a
        public Set g() {
            return this.f23520c.keySet();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.Collection m(ef.f r6) {
            /*
                r5 = this;
                java.util.Map r0 = r5.f23518a
                gf.r r1 = ze.i.f26120w
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.t.e(r1, r2)
                vf.w r2 = r5.f23526i
                java.lang.Object r0 = r0.get(r6)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L2a
                vf.w r3 = r5.f23526i
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r0)
                vf.w$c$a r0 = new vf.w$c$a
                r0.<init>(r1, r4, r3)
                jg.h r0 = jg.q.o(r0)
                java.util.List r0 = jg.t.M(r0)
                if (r0 == 0) goto L2a
                goto L2e
            L2a:
                java.util.List r0 = dd.r.k()
            L2e:
                java.util.ArrayList r1 = new java.util.ArrayList
                int r3 = r0.size()
                r1.<init>(r3)
                java.util.Iterator r0 = r0.iterator()
            L3b:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L64
                java.lang.Object r3 = r0.next()
                ze.i r3 = (ze.i) r3
                tf.p r4 = r2.s()
                tf.k0 r4 = r4.f()
                kotlin.jvm.internal.t.c(r3)
                fe.f1 r3 = r4.s(r3)
                boolean r4 = r2.A(r3)
                if (r4 == 0) goto L5d
                goto L5e
            L5d:
                r3 = 0
            L5e:
                if (r3 == 0) goto L3b
                r1.add(r3)
                goto L3b
            L64:
                r2.n(r6, r1)
                java.util.List r6 = hg.a.c(r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: vf.w.c.m(ef.f):java.util.Collection");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.Collection n(ef.f r6) {
            /*
                r5 = this;
                java.util.Map r0 = r5.f23519b
                gf.r r1 = ze.n.f26202w
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.t.e(r1, r2)
                vf.w r2 = r5.f23526i
                java.lang.Object r0 = r0.get(r6)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L2a
                vf.w r3 = r5.f23526i
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r0)
                vf.w$c$a r0 = new vf.w$c$a
                r0.<init>(r1, r4, r3)
                jg.h r0 = jg.q.o(r0)
                java.util.List r0 = jg.t.M(r0)
                if (r0 == 0) goto L2a
                goto L2e
            L2a:
                java.util.List r0 = dd.r.k()
            L2e:
                java.util.ArrayList r1 = new java.util.ArrayList
                int r3 = r0.size()
                r1.<init>(r3)
                java.util.Iterator r0 = r0.iterator()
            L3b:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L5c
                java.lang.Object r3 = r0.next()
                ze.n r3 = (ze.n) r3
                tf.p r4 = r2.s()
                tf.k0 r4 = r4.f()
                kotlin.jvm.internal.t.c(r3)
                fe.y0 r3 = r4.u(r3)
                if (r3 == 0) goto L3b
                r1.add(r3)
                goto L3b
            L5c:
                r2.o(r6, r1)
                java.util.List r6 = hg.a.c(r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: vf.w.c.n(ef.f):java.util.Collection");
        }

        public final k1 o(ef.f fVar) {
            ze.r rVarN0;
            byte[] bArr = (byte[]) this.f23520c.get(fVar);
            if (bArr == null || (rVarN0 = ze.r.n0(new ByteArrayInputStream(bArr), this.f23526i.s().c().k())) == null) {
                return null;
            }
            return this.f23526i.s().f().z(rVarN0);
        }

        public final Map r(Map map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(dd.n0.d(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(dd.s.u(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    ((gf.a) it.next()).h(byteArrayOutputStream);
                    arrayList.add(cd.h0.f3852a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }
    }

    public w(tf.p c10, List functionList, List propertyList, List typeAliasList, Function0 classNames) {
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(functionList, "functionList");
        kotlin.jvm.internal.t.f(propertyList, "propertyList");
        kotlin.jvm.internal.t.f(typeAliasList, "typeAliasList");
        kotlin.jvm.internal.t.f(classNames, "classNames");
        this.f23498b = c10;
        this.f23499c = q(functionList, propertyList, typeAliasList);
        this.f23500d = c10.h().e(new u(classNames));
        this.f23501e = c10.h().g(new v(this));
    }

    public static final Set k(Function0 function0) {
        return dd.a0.N0((Iterable) function0.invoke());
    }

    public static final Set l(w wVar) {
        Set setV = wVar.v();
        if (setV == null) {
            return null;
        }
        return v0.l(v0.l(wVar.t(), wVar.f23499c.g()), setV);
    }

    public boolean A(f1 function) {
        kotlin.jvm.internal.t.f(function, "function");
        return true;
    }

    @Override // qf.l, qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return this.f23499c.a(name, location);
    }

    @Override // qf.l, qf.k
    public Set b() {
        return this.f23499c.b();
    }

    @Override // qf.l, qf.k
    public Collection c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return this.f23499c.c(name, location);
    }

    @Override // qf.l, qf.k
    public Set d() {
        return this.f23499c.d();
    }

    @Override // qf.l, qf.n
    public fe.h e(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        if (z(name)) {
            return r(name);
        }
        if (this.f23499c.g().contains(name)) {
            return y(name);
        }
        return null;
    }

    @Override // qf.l, qf.k
    public Set f() {
        return u();
    }

    public abstract void j(Collection collection, pd.k kVar);

    public final Collection m(qf.d kindFilter, pd.k nameFilter, ne.b location) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        kotlin.jvm.internal.t.f(location, "location");
        ArrayList arrayList = new ArrayList(0);
        d.a aVar = qf.d.f19046c;
        if (kindFilter.a(aVar.g())) {
            j(arrayList, nameFilter);
        }
        this.f23499c.f(arrayList, kindFilter, nameFilter, location);
        if (kindFilter.a(aVar.c())) {
            for (ef.f fVar : t()) {
                if (((Boolean) nameFilter.invoke(fVar)).booleanValue()) {
                    hg.a.a(arrayList, r(fVar));
                }
            }
        }
        if (kindFilter.a(qf.d.f19046c.h())) {
            for (ef.f fVar2 : this.f23499c.g()) {
                if (((Boolean) nameFilter.invoke(fVar2)).booleanValue()) {
                    hg.a.a(arrayList, this.f23499c.e(fVar2));
                }
            }
        }
        return hg.a.c(arrayList);
    }

    public void n(ef.f name, List functions) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(functions, "functions");
    }

    public void o(ef.f name, List descriptors) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(descriptors, "descriptors");
    }

    public abstract ef.b p(ef.f fVar);

    public final a q(List list, List list2, List list3) {
        return this.f23498b.c().g().a() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
    }

    public final fe.e r(ef.f fVar) {
        return this.f23498b.c().b(p(fVar));
    }

    public final tf.p s() {
        return this.f23498b;
    }

    public final Set t() {
        return (Set) wf.m.a(this.f23500d, this, f23497f[0]);
    }

    public final Set u() {
        return (Set) wf.m.b(this.f23501e, this, f23497f[1]);
    }

    public abstract Set v();

    public abstract Set w();

    public abstract Set x();

    public final k1 y(ef.f fVar) {
        return this.f23499c.e(fVar);
    }

    public boolean z(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        return t().contains(name);
    }
}
