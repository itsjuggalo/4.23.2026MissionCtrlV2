package G6;

import B6.d;
import E6.C0477p;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0856m;
import R5.Z;
import R5.g0;
import R5.l0;
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
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;
import p5.AbstractC2595q;
import s6.AbstractC2714a;
import u6.C2797l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w extends B6.l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ I5.m[] f3359f = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(w.class, "classNames", "getClassNames$deserialization()Ljava/util/Set;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(w.class, "classifierNamesLazy", "getClassifierNamesLazy()Ljava/util/Set;", 0))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0477p f3360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f3361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final H6.i f3362d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final H6.j f3363e;

    public interface a {
        Collection a(q6.f fVar, Z5.b bVar);

        Set b();

        Set c();

        Collection d(q6.f fVar, Z5.b bVar);

        void e(Collection collection, B6.d dVar, B5.k kVar, Z5.b bVar);

        Set f();

        l0 g(q6.f fVar);
    }

    public final class b implements a {

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public static final /* synthetic */ I5.m[] f3364o = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "declaredFunctions", "getDeclaredFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "declaredProperties", "getDeclaredProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "allTypeAliases", "getAllTypeAliases()Ljava/util/List;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "allFunctions", "getAllFunctions()Ljava/util/List;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "allProperties", "getAllProperties()Ljava/util/List;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "typeAliasesByName", "getTypeAliasesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "functionsByName", "getFunctionsByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "propertiesByName", "getPropertiesByName()Ljava/util/Map;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(b.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List f3365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f3366b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final List f3367c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final H6.i f3368d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final H6.i f3369e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final H6.i f3370f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final H6.i f3371g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final H6.i f3372h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final H6.i f3373i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final H6.i f3374j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final H6.i f3375k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final H6.i f3376l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final H6.i f3377m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final /* synthetic */ w f3378n;

        public b(w wVar, List functionList, List propertyList, List typeAliasList) {
            AbstractC2304t.f(functionList, "functionList");
            AbstractC2304t.f(propertyList, "propertyList");
            AbstractC2304t.f(typeAliasList, "typeAliasList");
            this.f3378n = wVar;
            this.f3365a = functionList;
            this.f3366b = propertyList;
            this.f3367c = wVar.s().c().g().g() ? typeAliasList : AbstractC2595q.i();
            this.f3368d = wVar.s().h().e(new x(this));
            this.f3369e = wVar.s().h().e(new y(this));
            this.f3370f = wVar.s().h().e(new z(this));
            this.f3371g = wVar.s().h().e(new A(this));
            this.f3372h = wVar.s().h().e(new B(this));
            this.f3373i = wVar.s().h().e(new C(this));
            this.f3374j = wVar.s().h().e(new D(this));
            this.f3375k = wVar.s().h().e(new E(this));
            this.f3376l = wVar.s().h().e(new F(this, wVar));
            this.f3377m = wVar.s().h().e(new G(this, wVar));
        }

        public static final List B(b bVar) {
            return bVar.w();
        }

        public static final List C(b bVar) {
            return bVar.z();
        }

        public static final Set D(b bVar, w wVar) {
            List list = bVar.f3365a;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            w wVar2 = bVar.f3378n;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(E6.L.b(wVar2.s().g(), ((l6.i) ((s6.p) it.next())).e0()));
            }
            return p5.T.l(linkedHashSet, wVar.w());
        }

        public static final Map E(b bVar) {
            List listF = bVar.F();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : listF) {
                q6.f name = ((g0) obj).getName();
                AbstractC2304t.e(name, "getName(...)");
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
                q6.f name = ((Z) obj).getName();
                AbstractC2304t.e(name, "getName(...)");
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
            LinkedHashMap linkedHashMap = new LinkedHashMap(H5.i.b(p5.L.d(p5.r.s(listH, 10)), 16));
            for (Object obj : listH) {
                q6.f name = ((l0) obj).getName();
                AbstractC2304t.e(name, "getName(...)");
                linkedHashMap.put(name, obj);
            }
            return linkedHashMap;
        }

        public static final Set P(b bVar, w wVar) {
            List list = bVar.f3366b;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            w wVar2 = bVar.f3378n;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(E6.L.b(wVar2.s().g(), ((l6.n) ((s6.p) it.next())).d0()));
            }
            return p5.T.l(linkedHashSet, wVar.x());
        }

        public static final List r(b bVar) {
            return p5.z.r0(bVar.I(), bVar.u());
        }

        public static final List s(b bVar) {
            return p5.z.r0(bVar.J(), bVar.v());
        }

        public static final List t(b bVar) {
            return bVar.A();
        }

        public final List A() {
            List list = this.f3367c;
            w wVar = this.f3378n;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                l0 l0VarZ = wVar.s().f().z((l6.r) ((s6.p) it.next()));
                if (l0VarZ != null) {
                    arrayList.add(l0VarZ);
                }
            }
            return arrayList;
        }

        public final List F() {
            return (List) H6.m.a(this.f3371g, this, f3364o[3]);
        }

        public final List G() {
            return (List) H6.m.a(this.f3372h, this, f3364o[4]);
        }

        public final List H() {
            return (List) H6.m.a(this.f3370f, this, f3364o[2]);
        }

        public final List I() {
            return (List) H6.m.a(this.f3368d, this, f3364o[0]);
        }

        public final List J() {
            return (List) H6.m.a(this.f3369e, this, f3364o[1]);
        }

        public final Map K() {
            return (Map) H6.m.a(this.f3374j, this, f3364o[6]);
        }

        public final Map L() {
            return (Map) H6.m.a(this.f3375k, this, f3364o[7]);
        }

        public final Map M() {
            return (Map) H6.m.a(this.f3373i, this, f3364o[5]);
        }

        @Override // G6.w.a
        public Collection a(q6.f name, Z5.b location) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(location, "location");
            if (!c().contains(name)) {
                return AbstractC2595q.i();
            }
            Collection collection = (Collection) L().get(name);
            return collection == null ? AbstractC2595q.i() : collection;
        }

        @Override // G6.w.a
        public Set b() {
            return (Set) H6.m.a(this.f3376l, this, f3364o[8]);
        }

        @Override // G6.w.a
        public Set c() {
            return (Set) H6.m.a(this.f3377m, this, f3364o[9]);
        }

        @Override // G6.w.a
        public Collection d(q6.f name, Z5.b location) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(location, "location");
            if (!b().contains(name)) {
                return AbstractC2595q.i();
            }
            Collection collection = (Collection) K().get(name);
            return collection == null ? AbstractC2595q.i() : collection;
        }

        @Override // G6.w.a
        public void e(Collection result, B6.d kindFilter, B5.k nameFilter, Z5.b location) {
            AbstractC2304t.f(result, "result");
            AbstractC2304t.f(kindFilter, "kindFilter");
            AbstractC2304t.f(nameFilter, "nameFilter");
            AbstractC2304t.f(location, "location");
            if (kindFilter.a(B6.d.f178c.i())) {
                for (Object obj : G()) {
                    q6.f name = ((Z) obj).getName();
                    AbstractC2304t.e(name, "getName(...)");
                    if (((Boolean) nameFilter.invoke(name)).booleanValue()) {
                        result.add(obj);
                    }
                }
            }
            if (kindFilter.a(B6.d.f178c.d())) {
                for (Object obj2 : F()) {
                    q6.f name2 = ((g0) obj2).getName();
                    AbstractC2304t.e(name2, "getName(...)");
                    if (((Boolean) nameFilter.invoke(name2)).booleanValue()) {
                        result.add(obj2);
                    }
                }
            }
        }

        @Override // G6.w.a
        public Set f() {
            List list = this.f3367c;
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            w wVar = this.f3378n;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                linkedHashSet.add(E6.L.b(wVar.s().g(), ((l6.r) ((s6.p) it.next())).X()));
            }
            return linkedHashSet;
        }

        @Override // G6.w.a
        public l0 g(q6.f name) {
            AbstractC2304t.f(name, "name");
            return (l0) M().get(name);
        }

        public final List u() {
            Set setW = this.f3378n.w();
            ArrayList arrayList = new ArrayList();
            Iterator it = setW.iterator();
            while (it.hasNext()) {
                p5.v.x(arrayList, x((q6.f) it.next()));
            }
            return arrayList;
        }

        public final List v() {
            Set setX = this.f3378n.x();
            ArrayList arrayList = new ArrayList();
            Iterator it = setX.iterator();
            while (it.hasNext()) {
                p5.v.x(arrayList, y((q6.f) it.next()));
            }
            return arrayList;
        }

        public final List w() {
            List list = this.f3365a;
            w wVar = this.f3378n;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                g0 g0VarS = wVar.s().f().s((l6.i) ((s6.p) it.next()));
                if (!wVar.A(g0VarS)) {
                    g0VarS = null;
                }
                if (g0VarS != null) {
                    arrayList.add(g0VarS);
                }
            }
            return arrayList;
        }

        public final List x(q6.f fVar) {
            List listI = I();
            w wVar = this.f3378n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listI) {
                if (AbstractC2304t.b(((InterfaceC0856m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            wVar.n(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        public final List y(q6.f fVar) {
            List listJ = J();
            w wVar = this.f3378n;
            ArrayList arrayList = new ArrayList();
            for (Object obj : listJ) {
                if (AbstractC2304t.b(((InterfaceC0856m) obj).getName(), fVar)) {
                    arrayList.add(obj);
                }
            }
            int size = arrayList.size();
            wVar.o(fVar, arrayList);
            return arrayList.subList(size, arrayList.size());
        }

        public final List z() {
            List list = this.f3366b;
            w wVar = this.f3378n;
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Z zU = wVar.s().f().u((l6.n) ((s6.p) it.next()));
                if (zU != null) {
                    arrayList.add(zU);
                }
            }
            return arrayList;
        }
    }

    public final class c implements a {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ I5.m[] f3379j = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(c.class, "functionNames", "getFunctionNames()Ljava/util/Set;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(c.class, "variableNames", "getVariableNames()Ljava/util/Set;", 0))};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map f3380a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map f3381b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Map f3382c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final H6.g f3383d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final H6.g f3384e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final H6.h f3385f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final H6.i f3386g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final H6.i f3387h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ w f3388i;

        public static final class a implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ s6.r f3389a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ ByteArrayInputStream f3390b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ w f3391c;

            public a(s6.r rVar, ByteArrayInputStream byteArrayInputStream, w wVar) {
                this.f3389a = rVar;
                this.f3390b = byteArrayInputStream;
                this.f3391c = wVar;
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final s6.p invoke() {
                return (s6.p) this.f3389a.a(this.f3390b, this.f3391c.s().c().k());
            }
        }

        public c(w wVar, List functionList, List propertyList, List typeAliasList) throws IOException {
            Map mapH;
            AbstractC2304t.f(functionList, "functionList");
            AbstractC2304t.f(propertyList, "propertyList");
            AbstractC2304t.f(typeAliasList, "typeAliasList");
            this.f3388i = wVar;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Object obj : functionList) {
                q6.f fVarB = E6.L.b(wVar.s().g(), ((l6.i) ((s6.p) obj)).e0());
                Object arrayList = linkedHashMap.get(fVarB);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    linkedHashMap.put(fVarB, arrayList);
                }
                ((List) arrayList).add(obj);
            }
            this.f3380a = r(linkedHashMap);
            w wVar2 = this.f3388i;
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj2 : propertyList) {
                q6.f fVarB2 = E6.L.b(wVar2.s().g(), ((l6.n) ((s6.p) obj2)).d0());
                Object arrayList2 = linkedHashMap2.get(fVarB2);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                    linkedHashMap2.put(fVarB2, arrayList2);
                }
                ((List) arrayList2).add(obj2);
            }
            this.f3381b = r(linkedHashMap2);
            if (this.f3388i.s().c().g().g()) {
                w wVar3 = this.f3388i;
                LinkedHashMap linkedHashMap3 = new LinkedHashMap();
                for (Object obj3 : typeAliasList) {
                    q6.f fVarB3 = E6.L.b(wVar3.s().g(), ((l6.r) ((s6.p) obj3)).X());
                    Object arrayList3 = linkedHashMap3.get(fVarB3);
                    if (arrayList3 == null) {
                        arrayList3 = new ArrayList();
                        linkedHashMap3.put(fVarB3, arrayList3);
                    }
                    ((List) arrayList3).add(obj3);
                }
                mapH = r(linkedHashMap3);
            } else {
                mapH = p5.M.h();
            }
            this.f3382c = mapH;
            this.f3383d = this.f3388i.s().h().g(new H(this));
            this.f3384e = this.f3388i.s().h().g(new I(this));
            this.f3385f = this.f3388i.s().h().d(new J(this));
            this.f3386g = this.f3388i.s().h().e(new K(this, this.f3388i));
            this.f3387h = this.f3388i.s().h().e(new L(this, this.f3388i));
        }

        public static final Set p(c cVar, w wVar) {
            return p5.T.l(cVar.f3380a.keySet(), wVar.w());
        }

        public static final Collection q(c cVar, q6.f it) {
            AbstractC2304t.f(it, "it");
            return cVar.m(it);
        }

        public static final Collection s(c cVar, q6.f it) {
            AbstractC2304t.f(it, "it");
            return cVar.n(it);
        }

        public static final l0 t(c cVar, q6.f it) {
            AbstractC2304t.f(it, "it");
            return cVar.o(it);
        }

        public static final Set u(c cVar, w wVar) {
            return p5.T.l(cVar.f3381b.keySet(), wVar.x());
        }

        @Override // G6.w.a
        public Collection a(q6.f name, Z5.b location) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(location, "location");
            return !c().contains(name) ? AbstractC2595q.i() : (Collection) this.f3384e.invoke(name);
        }

        @Override // G6.w.a
        public Set b() {
            return (Set) H6.m.a(this.f3386g, this, f3379j[0]);
        }

        @Override // G6.w.a
        public Set c() {
            return (Set) H6.m.a(this.f3387h, this, f3379j[1]);
        }

        @Override // G6.w.a
        public Collection d(q6.f name, Z5.b location) {
            AbstractC2304t.f(name, "name");
            AbstractC2304t.f(location, "location");
            return !b().contains(name) ? AbstractC2595q.i() : (Collection) this.f3383d.invoke(name);
        }

        @Override // G6.w.a
        public void e(Collection result, B6.d kindFilter, B5.k nameFilter, Z5.b location) {
            AbstractC2304t.f(result, "result");
            AbstractC2304t.f(kindFilter, "kindFilter");
            AbstractC2304t.f(nameFilter, "nameFilter");
            AbstractC2304t.f(location, "location");
            if (kindFilter.a(B6.d.f178c.i())) {
                Set<q6.f> setC = c();
                ArrayList arrayList = new ArrayList();
                for (q6.f fVar : setC) {
                    if (((Boolean) nameFilter.invoke(fVar)).booleanValue()) {
                        arrayList.addAll(a(fVar, location));
                    }
                }
                C2797l INSTANCE = C2797l.f23549a;
                AbstractC2304t.e(INSTANCE, "INSTANCE");
                p5.u.w(arrayList, INSTANCE);
                result.addAll(arrayList);
            }
            if (kindFilter.a(B6.d.f178c.d())) {
                Set<q6.f> setB = b();
                ArrayList arrayList2 = new ArrayList();
                for (q6.f fVar2 : setB) {
                    if (((Boolean) nameFilter.invoke(fVar2)).booleanValue()) {
                        arrayList2.addAll(d(fVar2, location));
                    }
                }
                C2797l INSTANCE2 = C2797l.f23549a;
                AbstractC2304t.e(INSTANCE2, "INSTANCE");
                p5.u.w(arrayList2, INSTANCE2);
                result.addAll(arrayList2);
            }
        }

        @Override // G6.w.a
        public Set f() {
            return this.f3382c.keySet();
        }

        @Override // G6.w.a
        public l0 g(q6.f name) {
            AbstractC2304t.f(name, "name");
            return (l0) this.f3385f.invoke(name);
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.Collection m(q6.f r6) {
            /*
                r5 = this;
                java.util.Map r0 = r5.f3380a
                s6.r r1 = l6.i.f20840w
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.AbstractC2304t.e(r1, r2)
                G6.w r2 = r5.f3388i
                java.lang.Object r0 = r0.get(r6)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L2a
                G6.w r3 = r5.f3388i
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r0)
                G6.w$c$a r0 = new G6.w$c$a
                r0.<init>(r1, r4, r3)
                U6.h r0 = U6.o.m(r0)
                java.util.List r0 = U6.r.J(r0)
                if (r0 == 0) goto L2a
                goto L2e
            L2a:
                java.util.List r0 = p5.AbstractC2595q.i()
            L2e:
                java.util.ArrayList r1 = new java.util.ArrayList
                int r3 = r0.size()
                r1.<init>(r3)
                java.util.Iterator r0 = r0.iterator()
            L3b:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L64
                java.lang.Object r3 = r0.next()
                l6.i r3 = (l6.i) r3
                E6.p r4 = r2.s()
                E6.K r4 = r4.f()
                kotlin.jvm.internal.AbstractC2304t.c(r3)
                R5.g0 r3 = r4.s(r3)
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
                java.util.List r6 = S6.a.c(r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: G6.w.c.m(q6.f):java.util.Collection");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x002a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.util.Collection n(q6.f r6) {
            /*
                r5 = this;
                java.util.Map r0 = r5.f3381b
                s6.r r1 = l6.n.f20922w
                java.lang.String r2 = "PARSER"
                kotlin.jvm.internal.AbstractC2304t.e(r1, r2)
                G6.w r2 = r5.f3388i
                java.lang.Object r0 = r0.get(r6)
                byte[] r0 = (byte[]) r0
                if (r0 == 0) goto L2a
                G6.w r3 = r5.f3388i
                java.io.ByteArrayInputStream r4 = new java.io.ByteArrayInputStream
                r4.<init>(r0)
                G6.w$c$a r0 = new G6.w$c$a
                r0.<init>(r1, r4, r3)
                U6.h r0 = U6.o.m(r0)
                java.util.List r0 = U6.r.J(r0)
                if (r0 == 0) goto L2a
                goto L2e
            L2a:
                java.util.List r0 = p5.AbstractC2595q.i()
            L2e:
                java.util.ArrayList r1 = new java.util.ArrayList
                int r3 = r0.size()
                r1.<init>(r3)
                java.util.Iterator r0 = r0.iterator()
            L3b:
                boolean r3 = r0.hasNext()
                if (r3 == 0) goto L5c
                java.lang.Object r3 = r0.next()
                l6.n r3 = (l6.n) r3
                E6.p r4 = r2.s()
                E6.K r4 = r4.f()
                kotlin.jvm.internal.AbstractC2304t.c(r3)
                R5.Z r3 = r4.u(r3)
                if (r3 == 0) goto L3b
                r1.add(r3)
                goto L3b
            L5c:
                r2.o(r6, r1)
                java.util.List r6 = S6.a.c(r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: G6.w.c.n(q6.f):java.util.Collection");
        }

        public final l0 o(q6.f fVar) {
            l6.r rVarO0;
            byte[] bArr = (byte[]) this.f3382c.get(fVar);
            if (bArr == null || (rVarO0 = l6.r.o0(new ByteArrayInputStream(bArr), this.f3388i.s().c().k())) == null) {
                return null;
            }
            return this.f3388i.s().f().z(rVarO0);
        }

        public final Map r(Map map) throws IOException {
            LinkedHashMap linkedHashMap = new LinkedHashMap(p5.L.d(map.size()));
            for (Map.Entry entry : map.entrySet()) {
                Object key = entry.getKey();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                Iterable iterable = (Iterable) entry.getValue();
                ArrayList arrayList = new ArrayList(p5.r.s(iterable, 10));
                Iterator it = iterable.iterator();
                while (it.hasNext()) {
                    ((AbstractC2714a) it.next()).i(byteArrayOutputStream);
                    arrayList.add(C2470H.f21956a);
                }
                linkedHashMap.put(key, byteArrayOutputStream.toByteArray());
            }
            return linkedHashMap;
        }
    }

    public w(C0477p c8, List functionList, List propertyList, List typeAliasList, Function0 classNames) {
        AbstractC2304t.f(c8, "c");
        AbstractC2304t.f(functionList, "functionList");
        AbstractC2304t.f(propertyList, "propertyList");
        AbstractC2304t.f(typeAliasList, "typeAliasList");
        AbstractC2304t.f(classNames, "classNames");
        this.f3360b = c8;
        this.f3361c = q(functionList, propertyList, typeAliasList);
        this.f3362d = c8.h().e(new u(classNames));
        this.f3363e = c8.h().h(new v(this));
    }

    public static final Set k(Function0 function0) {
        return p5.z.K0((Iterable) function0.invoke());
    }

    public static final Set l(w wVar) {
        Set setV = wVar.v();
        if (setV == null) {
            return null;
        }
        return p5.T.l(p5.T.l(wVar.t(), wVar.f3361c.f()), setV);
    }

    public boolean A(g0 function) {
        AbstractC2304t.f(function, "function");
        return true;
    }

    @Override // B6.l, B6.k
    public Collection a(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return this.f3361c.a(name, location);
    }

    @Override // B6.l, B6.k
    public Set b() {
        return this.f3361c.b();
    }

    @Override // B6.l, B6.k
    public Set c() {
        return this.f3361c.c();
    }

    @Override // B6.l, B6.k
    public Collection d(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        return this.f3361c.d(name, location);
    }

    @Override // B6.l, B6.n
    public InterfaceC0851h e(q6.f name, Z5.b location) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(location, "location");
        if (z(name)) {
            return r(name);
        }
        if (this.f3361c.f().contains(name)) {
            return y(name);
        }
        return null;
    }

    @Override // B6.l, B6.k
    public Set f() {
        return u();
    }

    public abstract void j(Collection collection, B5.k kVar);

    public final Collection m(B6.d kindFilter, B5.k nameFilter, Z5.b location) {
        AbstractC2304t.f(kindFilter, "kindFilter");
        AbstractC2304t.f(nameFilter, "nameFilter");
        AbstractC2304t.f(location, "location");
        ArrayList arrayList = new ArrayList(0);
        d.a aVar = B6.d.f178c;
        if (kindFilter.a(aVar.g())) {
            j(arrayList, nameFilter);
        }
        this.f3361c.e(arrayList, kindFilter, nameFilter, location);
        if (kindFilter.a(aVar.c())) {
            for (q6.f fVar : t()) {
                if (((Boolean) nameFilter.invoke(fVar)).booleanValue()) {
                    S6.a.a(arrayList, r(fVar));
                }
            }
        }
        if (kindFilter.a(B6.d.f178c.h())) {
            for (q6.f fVar2 : this.f3361c.f()) {
                if (((Boolean) nameFilter.invoke(fVar2)).booleanValue()) {
                    S6.a.a(arrayList, this.f3361c.g(fVar2));
                }
            }
        }
        return S6.a.c(arrayList);
    }

    public void n(q6.f name, List functions) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(functions, "functions");
    }

    public void o(q6.f name, List descriptors) {
        AbstractC2304t.f(name, "name");
        AbstractC2304t.f(descriptors, "descriptors");
    }

    public abstract q6.b p(q6.f fVar);

    public final a q(List list, List list2, List list3) {
        return this.f3360b.c().g().a() ? new b(this, list, list2, list3) : new c(this, list, list2, list3);
    }

    public final InterfaceC0848e r(q6.f fVar) {
        return this.f3360b.c().b(p(fVar));
    }

    public final C0477p s() {
        return this.f3360b;
    }

    public final Set t() {
        return (Set) H6.m.a(this.f3362d, this, f3359f[0]);
    }

    public final Set u() {
        return (Set) H6.m.b(this.f3363e, this, f3359f[1]);
    }

    public abstract Set v();

    public abstract Set w();

    public abstract Set x();

    public final l0 y(q6.f fVar) {
        return this.f3361c.g(fVar);
    }

    public boolean z(q6.f name) {
        AbstractC2304t.f(name, "name");
        return t().contains(name);
    }
}
