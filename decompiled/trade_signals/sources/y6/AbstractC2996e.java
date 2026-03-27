package y6;

import B5.k;
import I6.S;
import J6.g;
import O5.i;
import R5.A;
import R5.H;
import R5.I;
import R5.InterfaceC0845b;
import R5.InterfaceC0848e;
import R5.InterfaceC0851h;
import R5.InterfaceC0852i;
import R5.InterfaceC0856m;
import R5.Y;
import R5.Z;
import R5.r0;
import R5.t0;
import S6.b;
import U6.h;
import U6.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.N;
import p5.AbstractC2594p;
import p5.AbstractC2595q;
import p5.r;
import p5.z;
import q6.f;
import u6.AbstractC2794i;

/* JADX INFO: renamed from: y6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2996e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f f24517a;

    /* JADX INFO: renamed from: y6.e$a */
    public /* synthetic */ class a extends AbstractC2302q implements k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f24518a = new a();

        public a() {
            super(1, t0.class, "declaresDefaultValue", "declaresDefaultValue()Z", 0);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(t0 p02) {
            AbstractC2304t.f(p02, "p0");
            return Boolean.valueOf(p02.w0());
        }
    }

    /* JADX INFO: renamed from: y6.e$b */
    public static final class b extends b.AbstractC0110b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ N f24519a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ k f24520b;

        public b(N n8, k kVar) {
            this.f24519a = n8;
            this.f24520b = kVar;
        }

        @Override // S6.b.AbstractC0110b, S6.b.d
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(InterfaceC0845b current) {
            AbstractC2304t.f(current, "current");
            if (this.f24519a.f20469a == null && ((Boolean) this.f24520b.invoke(current)).booleanValue()) {
                this.f24519a.f20469a = current;
            }
        }

        @Override // S6.b.d
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public boolean c(InterfaceC0845b current) {
            AbstractC2304t.f(current, "current");
            return this.f24519a.f20469a == null;
        }

        @Override // S6.b.d
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public InterfaceC0845b a() {
            return (InterfaceC0845b) this.f24519a.f20469a;
        }
    }

    static {
        f fVarL = f.l("value");
        AbstractC2304t.e(fVarL, "identifier(...)");
        f24517a = fVarL;
    }

    public static final h A(boolean z7, InterfaceC0845b interfaceC0845b) {
        AbstractC2304t.c(interfaceC0845b);
        return z(interfaceC0845b, z7);
    }

    public static final InterfaceC0848e B(H h8, q6.c topLevelClassFqName, Z5.b location) {
        AbstractC2304t.f(h8, "<this>");
        AbstractC2304t.f(topLevelClassFqName, "topLevelClassFqName");
        AbstractC2304t.f(location, "location");
        topLevelClassFqName.c();
        InterfaceC0851h interfaceC0851hE = h8.u0(topLevelClassFqName.d()).r().e(topLevelClassFqName.f(), location);
        if (interfaceC0851hE instanceof InterfaceC0848e) {
            return (InterfaceC0848e) interfaceC0851hE;
        }
        return null;
    }

    public static final InterfaceC0856m a(InterfaceC0856m it) {
        AbstractC2304t.f(it, "it");
        return it.b();
    }

    public static final boolean f(t0 t0Var) {
        AbstractC2304t.f(t0Var, "<this>");
        Boolean boolE = S6.b.e(AbstractC2594p.e(t0Var), C2992a.f24513a, a.f24518a);
        AbstractC2304t.e(boolE, "ifAny(...)");
        return boolE.booleanValue();
    }

    public static final Iterable g(t0 t0Var) {
        Collection collectionF = t0Var.f();
        ArrayList arrayList = new ArrayList(r.s(collectionF, 10));
        Iterator it = collectionF.iterator();
        while (it.hasNext()) {
            arrayList.add(((t0) it.next()).a());
        }
        return arrayList;
    }

    public static final InterfaceC0845b h(InterfaceC0845b interfaceC0845b, boolean z7, k predicate) {
        AbstractC2304t.f(interfaceC0845b, "<this>");
        AbstractC2304t.f(predicate, "predicate");
        return (InterfaceC0845b) S6.b.b(AbstractC2594p.e(interfaceC0845b), new C2994c(z7), new b(new N(), predicate));
    }

    public static /* synthetic */ InterfaceC0845b i(InterfaceC0845b interfaceC0845b, boolean z7, k kVar, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            z7 = false;
        }
        return h(interfaceC0845b, z7, kVar);
    }

    public static final Iterable j(boolean z7, InterfaceC0845b interfaceC0845b) {
        Collection collectionF;
        if (z7) {
            interfaceC0845b = interfaceC0845b != null ? interfaceC0845b.a() : null;
        }
        return (interfaceC0845b == null || (collectionF = interfaceC0845b.f()) == null) ? AbstractC2595q.i() : collectionF;
    }

    public static final q6.c k(InterfaceC0856m interfaceC0856m) {
        AbstractC2304t.f(interfaceC0856m, "<this>");
        q6.d dVarP = p(interfaceC0856m);
        if (!dVarP.f()) {
            dVarP = null;
        }
        if (dVarP != null) {
            return dVarP.m();
        }
        return null;
    }

    public static final InterfaceC0848e l(S5.c cVar) {
        AbstractC2304t.f(cVar, "<this>");
        InterfaceC0851h interfaceC0851hS = cVar.getType().O0().s();
        if (interfaceC0851hS instanceof InterfaceC0848e) {
            return (InterfaceC0848e) interfaceC0851hS;
        }
        return null;
    }

    public static final i m(InterfaceC0856m interfaceC0856m) {
        AbstractC2304t.f(interfaceC0856m, "<this>");
        return s(interfaceC0856m).q();
    }

    public static final q6.b n(InterfaceC0851h interfaceC0851h) {
        InterfaceC0856m interfaceC0856mB;
        q6.b bVarN;
        if (interfaceC0851h == null || (interfaceC0856mB = interfaceC0851h.b()) == null) {
            return null;
        }
        if (interfaceC0856mB instanceof R5.N) {
            q6.c cVarE = ((R5.N) interfaceC0856mB).e();
            f name = interfaceC0851h.getName();
            AbstractC2304t.e(name, "getName(...)");
            return new q6.b(cVarE, name);
        }
        if (!(interfaceC0856mB instanceof InterfaceC0852i) || (bVarN = n((InterfaceC0851h) interfaceC0856mB)) == null) {
            return null;
        }
        f name2 = interfaceC0851h.getName();
        AbstractC2304t.e(name2, "getName(...)");
        return bVarN.d(name2);
    }

    public static final q6.c o(InterfaceC0856m interfaceC0856m) {
        AbstractC2304t.f(interfaceC0856m, "<this>");
        q6.c cVarN = AbstractC2794i.n(interfaceC0856m);
        AbstractC2304t.e(cVarN, "getFqNameSafe(...)");
        return cVarN;
    }

    public static final q6.d p(InterfaceC0856m interfaceC0856m) {
        AbstractC2304t.f(interfaceC0856m, "<this>");
        q6.d dVarM = AbstractC2794i.m(interfaceC0856m);
        AbstractC2304t.e(dVarM, "getFqName(...)");
        return dVarM;
    }

    public static final A q(InterfaceC0848e interfaceC0848e) {
        r0 r0VarB0 = interfaceC0848e != null ? interfaceC0848e.B0() : null;
        if (r0VarB0 instanceof A) {
            return (A) r0VarB0;
        }
        return null;
    }

    public static final g r(H h8) {
        AbstractC2304t.f(h8, "<this>");
        android.support.v4.media.session.b.a(h8.f0(J6.h.a()));
        return g.a.f4645a;
    }

    public static final H s(InterfaceC0856m interfaceC0856m) {
        AbstractC2304t.f(interfaceC0856m, "<this>");
        H hG = AbstractC2794i.g(interfaceC0856m);
        AbstractC2304t.e(hG, "getContainingModule(...)");
        return hG;
    }

    public static final I t(InterfaceC0848e interfaceC0848e) {
        r0 r0VarB0 = interfaceC0848e != null ? interfaceC0848e.B0() : null;
        if (r0VarB0 instanceof I) {
            return (I) r0VarB0;
        }
        return null;
    }

    public static final h u(InterfaceC0856m interfaceC0856m) {
        AbstractC2304t.f(interfaceC0856m, "<this>");
        return U6.r.t(v(interfaceC0856m), 1);
    }

    public static final h v(InterfaceC0856m interfaceC0856m) {
        AbstractC2304t.f(interfaceC0856m, "<this>");
        return o.l(interfaceC0856m, C2993b.f24514a);
    }

    public static final InterfaceC0845b w(InterfaceC0845b interfaceC0845b) {
        AbstractC2304t.f(interfaceC0845b, "<this>");
        if (!(interfaceC0845b instanceof Y)) {
            return interfaceC0845b;
        }
        Z zD0 = ((Y) interfaceC0845b).D0();
        AbstractC2304t.e(zD0, "getCorrespondingProperty(...)");
        return zD0;
    }

    public static final InterfaceC0848e x(InterfaceC0848e interfaceC0848e) {
        AbstractC2304t.f(interfaceC0848e, "<this>");
        for (S s8 : interfaceC0848e.t().O0().r()) {
            if (!i.c0(s8)) {
                InterfaceC0851h interfaceC0851hS = s8.O0().s();
                if (AbstractC2794i.w(interfaceC0851hS)) {
                    AbstractC2304t.d(interfaceC0851hS, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    return (InterfaceC0848e) interfaceC0851hS;
                }
            }
        }
        return null;
    }

    public static final boolean y(H h8) {
        AbstractC2304t.f(h8, "<this>");
        android.support.v4.media.session.b.a(h8.f0(J6.h.a()));
        return false;
    }

    public static final h z(InterfaceC0845b interfaceC0845b, boolean z7) {
        AbstractC2304t.f(interfaceC0845b, "<this>");
        if (z7) {
            interfaceC0845b = interfaceC0845b.a();
        }
        h hVarP = o.p(interfaceC0845b);
        Collection collectionF = interfaceC0845b.f();
        AbstractC2304t.e(collectionF, "getOverriddenDescriptors(...)");
        return U6.r.D(hVarP, U6.r.z(z.P(collectionF), new C2995d(z7)));
    }
}
