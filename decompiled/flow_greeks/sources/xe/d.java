package xe;

import fe.g1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lf.s;
import tf.n0;
import xe.a0;
import xe.x;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends e implements tf.e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final wf.g f24818c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements x.d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ HashMap f24820b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x f24821c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ HashMap f24822d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ HashMap f24823e;

        /* JADX INFO: renamed from: xe.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class C0453a extends b implements x.e {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final /* synthetic */ a f24824d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0453a(a aVar, a0 signature) {
                super(aVar, signature);
                kotlin.jvm.internal.t.f(signature, "signature");
                this.f24824d = aVar;
            }

            @Override // xe.x.e
            public x.a c(int i10, ef.b classId, g1 source) {
                kotlin.jvm.internal.t.f(classId, "classId");
                kotlin.jvm.internal.t.f(source, "source");
                a0 a0VarE = a0.f24814b.e(d(), i10);
                List arrayList = (List) this.f24824d.f24820b.get(a0VarE);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f24824d.f24820b.put(a0VarE, arrayList);
                }
                return d.this.y(classId, source, arrayList);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements x.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final a0 f24825a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final ArrayList f24826b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ a f24827c;

            public b(a aVar, a0 signature) {
                kotlin.jvm.internal.t.f(signature, "signature");
                this.f24827c = aVar;
                this.f24825a = signature;
                this.f24826b = new ArrayList();
            }

            @Override // xe.x.c
            public void a() {
                if (this.f24826b.isEmpty()) {
                    return;
                }
                this.f24827c.f24820b.put(this.f24825a, this.f24826b);
            }

            @Override // xe.x.c
            public x.a b(ef.b classId, g1 source) {
                kotlin.jvm.internal.t.f(classId, "classId");
                kotlin.jvm.internal.t.f(source, "source");
                return d.this.y(classId, source, this.f24826b);
            }

            public final a0 d() {
                return this.f24825a;
            }
        }

        public a(HashMap map, x xVar, HashMap map2, HashMap map3) {
            this.f24820b = map;
            this.f24821c = xVar;
            this.f24822d = map2;
            this.f24823e = map3;
        }

        @Override // xe.x.d
        public x.e a(ef.f name, String desc) {
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(desc, "desc");
            a0.a aVar = a0.f24814b;
            String strB = name.b();
            kotlin.jvm.internal.t.e(strB, "asString(...)");
            return new C0453a(this, aVar.d(strB, desc));
        }

        @Override // xe.x.d
        public x.c b(ef.f name, String desc, Object obj) {
            Object objI;
            kotlin.jvm.internal.t.f(name, "name");
            kotlin.jvm.internal.t.f(desc, "desc");
            a0.a aVar = a0.f24814b;
            String strB = name.b();
            kotlin.jvm.internal.t.e(strB, "asString(...)");
            a0 a0VarA = aVar.a(strB, desc);
            if (obj != null && (objI = d.this.I(desc, obj)) != null) {
                this.f24823e.put(a0VarA, objI);
            }
            return new b(this, a0VarA);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(wf.n storageManager, v kotlinClassFinder) {
        super(kotlinClassFinder);
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(kotlinClassFinder, "kotlinClassFinder");
        this.f24818c = storageManager.i(new xe.a(this));
    }

    public static final Object G(g loadConstantFromProperty, a0 it) {
        kotlin.jvm.internal.t.f(loadConstantFromProperty, "$this$loadConstantFromProperty");
        kotlin.jvm.internal.t.f(it, "it");
        return loadConstantFromProperty.b().get(it);
    }

    public static final Object K(g loadConstantFromProperty, a0 it) {
        kotlin.jvm.internal.t.f(loadConstantFromProperty, "$this$loadConstantFromProperty");
        kotlin.jvm.internal.t.f(it, "it");
        return loadConstantFromProperty.c().get(it);
    }

    public static final g L(d dVar, x kotlinClass) {
        kotlin.jvm.internal.t.f(kotlinClass, "kotlinClass");
        return dVar.H(kotlinClass);
    }

    @Override // xe.e
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public g q(x binaryClass) {
        kotlin.jvm.internal.t.f(binaryClass, "binaryClass");
        return (g) this.f24818c.invoke(binaryClass);
    }

    public final boolean F(ef.b annotationClassId, Map arguments) {
        kotlin.jvm.internal.t.f(annotationClassId, "annotationClassId");
        kotlin.jvm.internal.t.f(arguments, "arguments");
        if (!kotlin.jvm.internal.t.b(annotationClassId, be.a.f3305a.a())) {
            return false;
        }
        Object obj = arguments.get(ef.f.k("value"));
        lf.s sVar = obj instanceof lf.s ? (lf.s) obj : null;
        if (sVar == null) {
            return false;
        }
        Object objB = sVar.b();
        s.b.C0281b c0281b = objB instanceof s.b.C0281b ? (s.b.C0281b) objB : null;
        if (c0281b == null) {
            return false;
        }
        return w(c0281b.b());
    }

    public final g H(x xVar) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        xVar.c(new a(map, xVar, map3, map2), r(xVar));
        return new g(map, map2, map3);
    }

    public abstract Object I(String str, Object obj);

    public final Object J(n0 n0Var, ze.n nVar, tf.d dVar, r0 r0Var, pd.o oVar) {
        Object objInvoke;
        x xVarP = p(n0Var, e.f24829b.a(n0Var, true, true, bf.b.B.d(nVar.a0()), df.i.f(nVar), v(), u()));
        if (xVarP == null) {
            return null;
        }
        a0 a0VarS = s(nVar, n0Var.b(), n0Var.d(), dVar, xVarP.b().d().d(n.f24895b.a()));
        if (a0VarS == null || (objInvoke = oVar.invoke(this.f24818c.invoke(xVarP), a0VarS)) == null) {
            return null;
        }
        return ce.s.d(r0Var) ? M(objInvoke) : objInvoke;
    }

    public abstract Object M(Object obj);

    @Override // tf.e
    public Object h(n0 container, ze.n proto, r0 expectedType) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(expectedType, "expectedType");
        return J(container, proto, tf.d.PROPERTY_GETTER, expectedType, b.f24816a);
    }

    @Override // tf.e
    public Object j(n0 container, ze.n proto, r0 expectedType) {
        kotlin.jvm.internal.t.f(container, "container");
        kotlin.jvm.internal.t.f(proto, "proto");
        kotlin.jvm.internal.t.f(expectedType, "expectedType");
        return J(container, proto, tf.d.PROPERTY, expectedType, c.f24817a);
    }
}
