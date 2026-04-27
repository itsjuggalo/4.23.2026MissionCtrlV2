package L5;

import B6.k;
import L5.AbstractC0654d0;
import L5.a1;
import X5.AbstractC0990f;
import java.util.Collection;
import k6.C2284a;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.C2489q;
import o5.EnumC2486n;
import o5.InterfaceC2483k;
import o6.AbstractC2492a;
import p5.AbstractC2595q;
import p6.C2602e;
import p6.C2603f;
import p6.C2606i;
import s6.AbstractC2722i;

/* JADX INFO: renamed from: L5.v0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0689v0 extends AbstractC0654d0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Class f5241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final InterfaceC2483k f5242e;

    /* JADX INFO: renamed from: L5.v0$a */
    public final class a extends AbstractC0654d0.b {

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final /* synthetic */ I5.m[] f5243j = {kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(a.class, "kotlinClass", "getKotlinClass()Lorg/jetbrains/kotlin/descriptors/runtime/components/ReflectKotlinClass;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(a.class, "scope", "getScope()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;", 0)), kotlin.jvm.internal.O.g(new kotlin.jvm.internal.G(a.class, "members", "getMembers()Ljava/util/Collection;", 0))};

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final a1.a f5244d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final a1.a f5245e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final InterfaceC2483k f5246f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final InterfaceC2483k f5247g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final a1.a f5248h;

        public a() {
            super();
            this.f5244d = a1.c(new C0680q0(C0689v0.this));
            this.f5245e = a1.c(new C0681r0(this));
            EnumC2486n enumC2486n = EnumC2486n.f21975b;
            this.f5246f = AbstractC2484l.b(enumC2486n, new C0683s0(this, C0689v0.this));
            this.f5247g = AbstractC2484l.b(enumC2486n, new C0685t0(this));
            this.f5248h = a1.c(new C0687u0(C0689v0.this, this));
        }

        public static final W5.f m(C0689v0 c0689v0) {
            return W5.f.f9293c.a(c0689v0.e());
        }

        public static final Collection n(C0689v0 c0689v0, a aVar) {
            return c0689v0.J(aVar.l(), AbstractC0654d0.d.f5157a);
        }

        public static final o5.v o(a aVar) {
            C2284a c2284aB;
            W5.f fVarI = aVar.i();
            if (fVarI == null || (c2284aB = fVarI.b()) == null) {
                return null;
            }
            String[] strArrA = c2284aB.a();
            String[] strArrG = c2284aB.g();
            if (strArrA == null || strArrG == null) {
                return null;
            }
            C2489q c2489qM = C2606i.m(strArrA, strArrG);
            return new o5.v((C2603f) c2489qM.a(), (l6.l) c2489qM.b(), c2284aB.d());
        }

        public static final Class p(a aVar, C0689v0 c0689v0) {
            C2284a c2284aB;
            W5.f fVarI = aVar.i();
            String strE = (fVarI == null || (c2284aB = fVarI.b()) == null) ? null : c2284aB.e();
            if (strE == null || strE.length() <= 0) {
                return null;
            }
            return c0689v0.e().getClassLoader().loadClass(V6.A.D(strE, '/', com.amazon.a.a.o.c.a.b.f14112a, false, 4, null));
        }

        public static final B6.k q(a aVar) {
            W5.f fVarI = aVar.i();
            return fVarI != null ? aVar.b().c().a(fVarI) : k.b.f219b;
        }

        public final W5.f i() {
            return (W5.f) this.f5244d.b(this, f5243j[0]);
        }

        public final o5.v j() {
            return (o5.v) this.f5247g.getValue();
        }

        public final Class k() {
            return (Class) this.f5246f.getValue();
        }

        public final B6.k l() {
            Object objB = this.f5245e.b(this, f5243j[1]);
            AbstractC2304t.e(objB, "getValue(...)");
            return (B6.k) objB;
        }
    }

    /* JADX INFO: renamed from: L5.v0$b */
    public /* synthetic */ class b extends AbstractC2302q implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f5250a = new b();

        public b() {
            super(2, E6.K.class, "loadProperty", "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;", 0);
        }

        @Override // B5.o
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final R5.Z invoke(E6.K p02, l6.n p12) {
            AbstractC2304t.f(p02, "p0");
            AbstractC2304t.f(p12, "p1");
            return p02.u(p12);
        }
    }

    public C0689v0(Class jClass) {
        AbstractC2304t.f(jClass, "jClass");
        this.f5241d = jClass;
        this.f5242e = AbstractC2484l.b(EnumC2486n.f21975b, new C0678p0(this));
    }

    public static final a S(C0689v0 c0689v0) {
        return c0689v0.new a();
    }

    @Override // L5.AbstractC0654d0
    public Collection G() {
        return AbstractC2595q.i();
    }

    @Override // L5.AbstractC0654d0
    public Collection H(q6.f name) {
        AbstractC2304t.f(name, "name");
        return T().d(name, Z5.d.f9777h);
    }

    @Override // L5.AbstractC0654d0
    public R5.Z I(int i8) {
        o5.v vVarJ = ((a) this.f5242e.getValue()).j();
        if (vVarJ == null) {
            return null;
        }
        C2603f c2603f = (C2603f) vVarJ.a();
        l6.l lVar = (l6.l) vVarJ.b();
        C2602e c2602e = (C2602e) vVarJ.c();
        AbstractC2722i.f packageLocalVariable = AbstractC2492a.f22015n;
        AbstractC2304t.e(packageLocalVariable, "packageLocalVariable");
        l6.n nVar = (l6.n) n6.e.b(lVar, packageLocalVariable, i8);
        if (nVar == null) {
            return null;
        }
        Class clsE = e();
        l6.t tVarW = lVar.W();
        AbstractC2304t.e(tVarW, "getTypeTable(...)");
        return (R5.Z) j1.h(clsE, nVar, c2603f, new n6.g(tVarW), c2602e, b.f5250a);
    }

    @Override // L5.AbstractC0654d0
    public Class K() {
        Class clsK = ((a) this.f5242e.getValue()).k();
        return clsK == null ? e() : clsK;
    }

    @Override // L5.AbstractC0654d0
    public Collection L(q6.f name) {
        AbstractC2304t.f(name, "name");
        return T().a(name, Z5.d.f9777h);
    }

    public final B6.k T() {
        return ((a) this.f5242e.getValue()).l();
    }

    @Override // kotlin.jvm.internal.InterfaceC2293h
    public Class e() {
        return this.f5241d;
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0689v0) && AbstractC2304t.b(e(), ((C0689v0) obj).e());
    }

    public int hashCode() {
        return e().hashCode();
    }

    public String toString() {
        return "file class " + AbstractC0990f.e(e()).a();
    }
}
