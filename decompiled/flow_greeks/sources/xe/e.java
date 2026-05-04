package xe;

import cf.a;
import df.d;
import ef.b;
import fe.g1;
import gf.i;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tf.n0;
import xe.a0;
import xe.x;
import ze.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e implements tf.h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f24829b = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f24830a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a {
        public abstract Map a();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final x a(n0 container, boolean z10, boolean z11, Boolean bool, boolean z12, v kotlinClassFinder, df.e jvmMetadataVersion) {
            n0.a aVarH;
            kotlin.jvm.internal.t.f(container, "container");
            kotlin.jvm.internal.t.f(kotlinClassFinder, "kotlinClassFinder");
            kotlin.jvm.internal.t.f(jvmMetadataVersion, "jvmMetadataVersion");
            if (z10) {
                if (bool == null) {
                    throw new IllegalStateException(("isConst should not be null for property (container=" + container + ')').toString());
                }
                if (container instanceof n0.a) {
                    n0.a aVar = (n0.a) container;
                    if (aVar.g() == c.EnumC0494c.INTERFACE) {
                        ef.b bVarE = aVar.e();
                        ef.f fVarK = ef.f.k("DefaultImpls");
                        kotlin.jvm.internal.t.e(fVarK, "identifier(...)");
                        return w.a(kotlinClassFinder, bVarE.d(fVarK), jvmMetadataVersion);
                    }
                }
                if (bool.booleanValue() && (container instanceof n0.b)) {
                    g1 g1VarC = container.c();
                    r rVar = g1VarC instanceof r ? (r) g1VarC : null;
                    of.d dVarF = rVar != null ? rVar.f() : null;
                    if (dVarF != null) {
                        b.a aVar2 = ef.b.f8779d;
                        String strF = dVarF.f();
                        kotlin.jvm.internal.t.e(strF, "getInternalName(...)");
                        return w.a(kotlinClassFinder, aVar2.c(new ef.c(kg.z.E(strF, '/', com.amazon.a.a.o.c.a.b.f4610a, false, 4, null))), jvmMetadataVersion);
                    }
                }
            }
            if (z11 && (container instanceof n0.a)) {
                n0.a aVar3 = (n0.a) container;
                if (aVar3.g() == c.EnumC0494c.COMPANION_OBJECT && (aVarH = aVar3.h()) != null && (aVarH.g() == c.EnumC0494c.CLASS || aVarH.g() == c.EnumC0494c.ENUM_CLASS || (z12 && (aVarH.g() == c.EnumC0494c.INTERFACE || aVarH.g() == c.EnumC0494c.ANNOTATION_CLASS)))) {
                    g1 g1VarC2 = aVarH.c();
                    z zVar = g1VarC2 instanceof z ? (z) g1VarC2 : null;
                    if (zVar != null) {
                        return zVar.d();
                    }
                    return null;
                }
            }
            if (!(container instanceof n0.b) || !(container.c() instanceof r)) {
                return null;
            }
            g1 g1VarC3 = container.c();
            kotlin.jvm.internal.t.d(g1VarC3, "null cannot be cast to non-null type org.jetbrains.kotlin.load.kotlin.JvmPackagePartSource");
            r rVar2 = (r) g1VarC3;
            x xVarG = rVar2.g();
            return xVarG == null ? w.a(kotlinClassFinder, rVar2.d(), jvmMetadataVersion) : xVarG;
        }

        public b() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f24831a = new c("PROPERTY", 0);

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f24832b = new c("BACKING_FIELD", 1);

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f24833c = new c("DELEGATE_FIELD", 2);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ c[] f24834d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final /* synthetic */ jd.a f24835e;

        static {
            c[] cVarArrA = a();
            f24834d = cVarArrA;
            f24835e = jd.b.a(cVarArrA);
        }

        public c(String str, int i10) {
        }

        public static final /* synthetic */ c[] a() {
            return new c[]{f24831a, f24832b, f24833c};
        }

        public static c valueOf(String str) {
            return (c) Enum.valueOf(c.class, str);
        }

        public static c[] values() {
            return (c[]) f24834d.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24836a;

        static {
            int[] iArr = new int[tf.d.values().length];
            try {
                iArr[tf.d.PROPERTY_GETTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[tf.d.PROPERTY_SETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[tf.d.PROPERTY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f24836a = iArr;
        }
    }

    public e(v kotlinClassFinder) {
        kotlin.jvm.internal.t.f(kotlinClassFinder, "kotlinClassFinder");
        this.f24830a = kotlinClassFinder;
    }

    public static /* synthetic */ List o(e eVar, n0 n0Var, a0 a0Var, boolean z10, boolean z11, Boolean bool, boolean z12, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: findClassAndLoadMemberAnnotations");
        }
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        if ((i10 & 8) != 0) {
            z11 = false;
        }
        if ((i10 & 16) != 0) {
            bool = null;
        }
        if ((i10 & 32) != 0) {
            z12 = false;
        }
        return eVar.n(n0Var, a0Var, z10, z11, bool, z12);
    }

    public static /* synthetic */ a0 t(e eVar, gf.p pVar, bf.c cVar, bf.g gVar, tf.d dVar, boolean z10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCallableSignature");
        }
        if ((i10 & 16) != 0) {
            z10 = false;
        }
        return eVar.s(pVar, cVar, gVar, dVar, z10);
    }

    public final x A(n0.a aVar) {
        g1 g1VarC = aVar.c();
        z zVar = g1VarC instanceof z ? (z) g1VarC : null;
        if (zVar != null) {
            return zVar.d();
        }
        return null;
    }

    @Override // tf.h
    public List a(n0 container, gf.p callableProto, tf.d kind, int i10, ze.u proto) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(callableProto, "callableProto");
        kotlin.jvm.internal.t.f(kind, "kind");
        kotlin.jvm.internal.t.f(proto, "proto");
        a0 a0VarT = t(this, callableProto, container.b(), container.d(), kind, false, 16, null);
        if (a0VarT == null) {
            return dd.r.k();
        }
        return o(this, container, a0.f24814b.e(a0VarT, i10 + m(container, callableProto)), false, false, null, false, 60, null);
    }

    @Override // tf.h
    public List b(ze.s proto, bf.c nameResolver) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        Object objT = proto.t(cf.a.f4057h);
        kotlin.jvm.internal.t.e(objT, "getExtension(...)");
        Iterable<ze.b> iterable = (Iterable) objT;
        ArrayList arrayList = new ArrayList(dd.s.u(iterable, 10));
        for (ze.b bVar : iterable) {
            kotlin.jvm.internal.t.c(bVar);
            arrayList.add(f(bVar, nameResolver));
        }
        return arrayList;
    }

    @Override // tf.h
    public List c(n0 container, ze.g proto) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        return o(this, container, a0.f24814b.a(container.b().getString(proto.F()), df.b.b(((n0.a) container).e().b())), false, false, null, false, 60, null);
    }

    @Override // tf.h
    public List d(n0 container, gf.p proto, tf.d kind) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(kind, "kind");
        if (kind == tf.d.PROPERTY) {
            return z(container, (ze.n) proto, c.f24831a);
        }
        a0 a0VarT = t(this, proto, container.b(), container.d(), kind, false, 16, null);
        return a0VarT == null ? dd.r.k() : o(this, container, a0VarT, false, false, null, false, 60, null);
    }

    @Override // tf.h
    public List e(n0.a container) {
        kotlin.jvm.internal.t.f(container, "container");
        x xVarA = A(container);
        if (xVarA != null) {
            ArrayList arrayList = new ArrayList(1);
            xVarA.d(new C0454e(arrayList), r(xVarA));
            return arrayList;
        }
        throw new IllegalStateException(("Class for loading annotations is not found: " + container.a()).toString());
    }

    @Override // tf.h
    public abstract Object f(ze.b bVar, bf.c cVar);

    @Override // tf.h
    public List g(ze.q proto, bf.c nameResolver) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        Object objT = proto.t(cf.a.f4055f);
        kotlin.jvm.internal.t.e(objT, "getExtension(...)");
        Iterable<ze.b> iterable = (Iterable) objT;
        ArrayList arrayList = new ArrayList(dd.s.u(iterable, 10));
        for (ze.b bVar : iterable) {
            kotlin.jvm.internal.t.c(bVar);
            arrayList.add(f(bVar, nameResolver));
        }
        return arrayList;
    }

    @Override // tf.h
    public List i(n0 container, ze.n proto) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        return z(container, proto, c.f24833c);
    }

    @Override // tf.h
    public List k(n0 container, ze.n proto) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        return z(container, proto, c.f24832b);
    }

    @Override // tf.h
    public List l(n0 container, gf.p proto, tf.d kind) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(kind, "kind");
        a0 a0VarT = t(this, proto, container.b(), container.d(), kind, false, 16, null);
        return a0VarT != null ? o(this, container, a0.f24814b.e(a0VarT, 0), false, false, null, false, 60, null) : dd.r.k();
    }

    public final int m(n0 n0Var, gf.p pVar) {
        if (pVar instanceof ze.i) {
            return bf.f.g((ze.i) pVar) ? 1 : 0;
        }
        if (pVar instanceof ze.n) {
            return bf.f.h((ze.n) pVar) ? 1 : 0;
        }
        if (!(pVar instanceof ze.d)) {
            throw new UnsupportedOperationException("Unsupported message: " + pVar.getClass());
        }
        kotlin.jvm.internal.t.d(n0Var, "null cannot be cast to non-null type org.jetbrains.kotlin.serialization.deserialization.ProtoContainer.Class");
        n0.a aVar = (n0.a) n0Var;
        if (aVar.g() == c.EnumC0494c.ENUM_CLASS) {
            return 2;
        }
        return aVar.i() ? 1 : 0;
    }

    public final List n(n0 n0Var, a0 a0Var, boolean z10, boolean z11, Boolean bool, boolean z12) {
        x xVarP = p(n0Var, f24829b.a(n0Var, z10, z11, bool, z12, this.f24830a, u()));
        if (xVarP == null) {
            return dd.r.k();
        }
        List list = (List) q(xVarP).a().get(a0Var);
        return list == null ? dd.r.k() : list;
    }

    public final x p(n0 container, x xVar) {
        kotlin.jvm.internal.t.f(container, "container");
        if (xVar != null) {
            return xVar;
        }
        if (container instanceof n0.a) {
            return A((n0.a) container);
        }
        return null;
    }

    public abstract a q(x xVar);

    public byte[] r(x kotlinClass) {
        kotlin.jvm.internal.t.f(kotlinClass, "kotlinClass");
        return null;
    }

    public final a0 s(gf.p proto, bf.c nameResolver, bf.g typeTable, tf.d kind, boolean z10) {
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(nameResolver, "nameResolver");
        kotlin.jvm.internal.t.f(typeTable, "typeTable");
        kotlin.jvm.internal.t.f(kind, "kind");
        if (proto instanceof ze.d) {
            a0.a aVar = a0.f24814b;
            d.b bVarB = df.i.f8111a.b((ze.d) proto, nameResolver, typeTable);
            if (bVarB == null) {
                return null;
            }
            return aVar.b(bVarB);
        }
        if (proto instanceof ze.i) {
            a0.a aVar2 = a0.f24814b;
            d.b bVarE = df.i.f8111a.e((ze.i) proto, nameResolver, typeTable);
            if (bVarE == null) {
                return null;
            }
            return aVar2.b(bVarE);
        }
        if (proto instanceof ze.n) {
            i.f propertySignature = cf.a.f4053d;
            kotlin.jvm.internal.t.e(propertySignature, "propertySignature");
            a.d dVar = (a.d) bf.e.a((i.d) proto, propertySignature);
            if (dVar == null) {
                return null;
            }
            int i10 = d.f24836a[kind.ordinal()];
            if (i10 != 1) {
                if (i10 != 2) {
                    if (i10 != 3) {
                        return null;
                    }
                    return f.a((ze.n) proto, nameResolver, typeTable, true, true, z10);
                }
                if (!dVar.H()) {
                    return null;
                }
                a0.a aVar3 = a0.f24814b;
                a.c cVarC = dVar.C();
                kotlin.jvm.internal.t.e(cVarC, "getSetter(...)");
                return aVar3.c(nameResolver, cVarC);
            }
            if (dVar.G()) {
                a0.a aVar4 = a0.f24814b;
                a.c cVarB = dVar.B();
                kotlin.jvm.internal.t.e(cVarB, "getGetter(...)");
                return aVar4.c(nameResolver, cVarB);
            }
        }
        return null;
    }

    public abstract df.e u();

    public final v v() {
        return this.f24830a;
    }

    public final boolean w(ef.b classId) {
        x xVarA;
        kotlin.jvm.internal.t.f(classId, "classId");
        return classId.e() != null && kotlin.jvm.internal.t.b(classId.h().b(), "Container") && (xVarA = w.a(this.f24830a, classId, u())) != null && be.a.f3305a.c(xVarA);
    }

    public abstract x.a x(ef.b bVar, g1 g1Var, List list);

    public final x.a y(ef.b annotationClassId, g1 source, List result) {
        kotlin.jvm.internal.t.f(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.t.f(source, "source");
        kotlin.jvm.internal.t.f(result, "result");
        if (be.a.f3305a.b().contains(annotationClassId)) {
            return null;
        }
        return x(annotationClassId, source, result);
    }

    public final List z(n0 n0Var, ze.n nVar, c cVar) {
        Boolean boolD = bf.b.B.d(nVar.a0());
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        boolD.booleanValue();
        boolean zF = df.i.f(nVar);
        if (cVar == c.f24831a) {
            a0 a0VarB = f.b(nVar, n0Var.b(), n0Var.d(), false, true, false, 40, null);
            return a0VarB == null ? dd.r.k() : o(this, n0Var, a0VarB, true, false, boolD, zF, 8, null);
        }
        a0 a0VarB2 = f.b(nVar, n0Var.b(), n0Var.d(), true, false, false, 48, null);
        if (a0VarB2 == null) {
            return dd.r.k();
        }
        return kg.c0.P(a0VarB2.a(), "$delegate", false, 2, null) != (cVar == c.f24833c) ? dd.r.k() : n(n0Var, a0VarB2, true, true, boolD, zF);
    }

    /* JADX INFO: renamed from: xe.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0454e implements x.c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ ArrayList f24838b;

        public C0454e(ArrayList arrayList) {
            this.f24838b = arrayList;
        }

        @Override // xe.x.c
        public x.a b(ef.b classId, g1 source) {
            kotlin.jvm.internal.t.f(classId, "classId");
            kotlin.jvm.internal.t.f(source, "source");
            return e.this.y(classId, source, this.f24838b);
        }

        @Override // xe.x.c
        public void a() {
        }
    }
}
