package zd;

import gf.i;
import java.util.Collection;
import qf.k;
import zd.c1;
import zd.z2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u1 extends c1 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class f25846d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final cd.k f25847e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a extends c1.b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ wd.m[] f25848j = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(a.class, "members", "getMembers()Ljava/util/Collection;", 0))};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final z2.a f25849d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final z2.a f25850e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final cd.k f25851f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final cd.k f25852g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final z2.a f25853h;

        public a() {
            super();
            this.f25849d = z2.c(new p1(u1.this));
            this.f25850e = z2.c(new q1(this));
            cd.n nVar = cd.n.f3864b;
            this.f25851f = cd.l.a(nVar, new r1(this, u1.this));
            this.f25852g = cd.l.a(nVar, new s1(this));
            this.f25853h = z2.c(new t1(u1.this, this));
        }

        public static final ke.f m(u1 u1Var) {
            return ke.f.f14831c.a(u1Var.e());
        }

        public static final Collection n(u1 u1Var, a aVar) {
            return u1Var.I(aVar.l(), c1.d.f25696a);
        }

        public static final cd.v o(a aVar) {
            ye.a aVarB;
            ke.f fVarI = aVar.i();
            if (fVarI != null && (aVarB = fVarI.b()) != null) {
                String[] strArrA = aVarB.a();
                String[] strArrG = aVarB.g();
                if (strArrA != null && strArrG != null) {
                    cd.q qVarM = df.i.m(strArrA, strArrG);
                    return new cd.v((df.f) qVarM.a(), (ze.l) qVarM.b(), aVarB.d());
                }
            }
            return null;
        }

        public static final Class p(a aVar, u1 u1Var) {
            ye.a aVarB;
            ke.f fVarI = aVar.i();
            String strE = (fVarI == null || (aVarB = fVarI.b()) == null) ? null : aVarB.e();
            if (strE == null || strE.length() <= 0) {
                return null;
            }
            return u1Var.e().getClassLoader().loadClass(kg.z.E(strE, '/', com.amazon.a.a.o.c.a.b.f4610a, false, 4, null));
        }

        public static final qf.k q(a aVar) {
            ke.f fVarI = aVar.i();
            return fVarI != null ? aVar.b().c().a(fVarI) : k.b.f19087b;
        }

        public final ke.f i() {
            return (ke.f) this.f25849d.b(this, f25848j[0]);
        }

        public final cd.v j() {
            return (cd.v) this.f25852g.getValue();
        }

        public final Class k() {
            return (Class) this.f25851f.getValue();
        }

        public final qf.k l() {
            Object objB = this.f25850e.b(this, f25848j[1]);
            kotlin.jvm.internal.t.e(objB, "getValue(...)");
            return (qf.k) objB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b extends kotlin.jvm.internal.q implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25855a = new b();

        public b() {
            super(2, tf.k0.class, "loadProperty", "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", 0);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final fe.y0 invoke(tf.k0 p02, ze.n p12) {
            kotlin.jvm.internal.t.f(p02, "p0");
            kotlin.jvm.internal.t.f(p12, "p1");
            return p02.u(p12);
        }
    }

    public u1(Class jClass) {
        kotlin.jvm.internal.t.f(jClass, "jClass");
        this.f25846d = jClass;
        this.f25847e = cd.l.a(cd.n.f3864b, new o1(this));
    }

    public static final a R(u1 u1Var) {
        return u1Var.new a();
    }

    @Override // zd.c1
    public Collection F() {
        return dd.r.k();
    }

    @Override // zd.c1
    public Collection G(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        return S().c(name, ne.d.f17041h);
    }

    @Override // zd.c1
    public fe.y0 H(int i10) {
        cd.v vVarJ = ((a) this.f25847e.getValue()).j();
        if (vVarJ != null) {
            df.f fVar = (df.f) vVarJ.a();
            ze.l lVar = (ze.l) vVarJ.b();
            df.e eVar = (df.e) vVarJ.c();
            i.f packageLocalVariable = cf.a.f4063n;
            kotlin.jvm.internal.t.e(packageLocalVariable, "packageLocalVariable");
            ze.n nVar = (ze.n) bf.e.b(lVar, packageLocalVariable, i10);
            if (nVar != null) {
                Class clsE = e();
                ze.t tVarV = lVar.V();
                kotlin.jvm.internal.t.e(tVarV, "getTypeTable(...)");
                return (fe.y0) i3.h(clsE, nVar, fVar, new bf.g(tVarV), eVar, b.f25855a);
            }
        }
        return null;
    }

    @Override // zd.c1
    public Class J() {
        Class clsK = ((a) this.f25847e.getValue()).k();
        return clsK == null ? e() : clsK;
    }

    @Override // zd.c1
    public Collection K(ef.f name) {
        kotlin.jvm.internal.t.f(name, "name");
        return S().a(name, ne.d.f17041h);
    }

    public final qf.k S() {
        return ((a) this.f25847e.getValue()).l();
    }

    @Override // kotlin.jvm.internal.h
    public Class e() {
        return this.f25846d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof u1) && kotlin.jvm.internal.t.b(e(), ((u1) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return "file class " + le.f.e(e()).a();
    }
}
