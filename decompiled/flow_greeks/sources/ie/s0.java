package ie;

import fe.b;
import fe.b1;
import fe.g1;
import fe.k1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xf.c1;
import xf.f2;
import xf.m2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s0 extends s implements q0 {
    public final wf.n E;
    public final k1 F;
    public final wf.j G;
    public fe.d H;
    public static final /* synthetic */ wd.m[] Q = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(s0.class, "withDispatchReceiver", "getWithDispatchReceiver()Lorg/jetbrains/kotlin/descriptors/impl/TypeAliasConstructorDescriptor;", 0))};
    public static final a I = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final q0 b(wf.n storageManager, k1 typeAliasDescriptor, fe.d constructor) {
            fe.d dVarC;
            List listK;
            kotlin.jvm.internal.t.f(storageManager, "storageManager");
            kotlin.jvm.internal.t.f(typeAliasDescriptor, "typeAliasDescriptor");
            kotlin.jvm.internal.t.f(constructor, "constructor");
            f2 f2VarC = c(typeAliasDescriptor);
            if (f2VarC == null || (dVarC = constructor.c(f2VarC)) == null) {
                return null;
            }
            ge.h annotations = constructor.getAnnotations();
            b.a aVarH = constructor.h();
            kotlin.jvm.internal.t.e(aVarH, "getKind(...)");
            g1 g1VarJ = typeAliasDescriptor.j();
            kotlin.jvm.internal.t.e(g1VarJ, "getSource(...)");
            s0 s0Var = new s0(storageManager, typeAliasDescriptor, dVarC, null, annotations, aVarH, g1VarJ, null);
            List listO0 = s.O0(s0Var, constructor.i(), f2VarC);
            if (listO0 == null) {
                return null;
            }
            c1 c1VarC = xf.l0.c(dVarC.getReturnType().Q0());
            c1 c1VarS = typeAliasDescriptor.s();
            kotlin.jvm.internal.t.e(c1VarS, "getDefaultType(...)");
            c1 c1VarJ = xf.g1.j(c1VarC, c1VarS);
            b1 b1VarE0 = constructor.e0();
            b1 b1VarI = b1VarE0 != null ? jf.h.i(s0Var, f2VarC.n(b1VarE0.getType(), m2.f25015e), ge.h.L.b()) : null;
            fe.e eVarR = typeAliasDescriptor.r();
            if (eVarR != null) {
                List listP0 = constructor.p0();
                kotlin.jvm.internal.t.e(listP0, "getContextReceiverParameters(...)");
                listK = new ArrayList(dd.s.u(listP0, 10));
                int i10 = 0;
                for (Object obj : listP0) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        dd.r.t();
                    }
                    b1 b1Var = (b1) obj;
                    xf.r0 r0VarN = f2VarC.n(b1Var.getType(), m2.f25015e);
                    rf.g value = b1Var.getValue();
                    kotlin.jvm.internal.t.d(value, "null cannot be cast to non-null type org.jetbrains.kotlin.resolve.scopes.receivers.ImplicitContextReceiver");
                    listK.add(jf.h.c(eVarR, r0VarN, ((rf.f) value).a(), ge.h.L.b(), i10));
                    i10 = i11;
                }
            } else {
                listK = dd.r.k();
            }
            s0Var.R0(b1VarI, null, listK, typeAliasDescriptor.v(), listO0, c1VarJ, fe.e0.f9461b, typeAliasDescriptor.getVisibility());
            return s0Var;
        }

        public final f2 c(k1 k1Var) {
            if (k1Var.r() == null) {
                return null;
            }
            return f2.f(k1Var.X());
        }

        public a() {
        }
    }

    public /* synthetic */ s0(wf.n nVar, k1 k1Var, fe.d dVar, q0 q0Var, ge.h hVar, b.a aVar, g1 g1Var, kotlin.jvm.internal.k kVar) {
        this(nVar, k1Var, dVar, q0Var, hVar, aVar, g1Var);
    }

    public static final s0 r1(s0 s0Var, fe.d dVar) {
        wf.n nVar = s0Var.E;
        k1 k1VarP1 = s0Var.p1();
        ge.h annotations = dVar.getAnnotations();
        b.a aVarH = dVar.h();
        kotlin.jvm.internal.t.e(aVarH, "getKind(...)");
        g1 g1VarJ = s0Var.p1().j();
        kotlin.jvm.internal.t.e(g1VarJ, "getSource(...)");
        s0 s0Var2 = new s0(nVar, k1VarP1, dVar, s0Var, annotations, aVarH, g1VarJ);
        f2 f2VarC = I.c(s0Var.p1());
        if (f2VarC == null) {
            return null;
        }
        b1 b1VarE0 = dVar.e0();
        b1 b1VarC = b1VarE0 != null ? b1VarE0.c(f2VarC) : null;
        List listP0 = dVar.p0();
        kotlin.jvm.internal.t.e(listP0, "getContextReceiverParameters(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(listP0, 10));
        Iterator it = listP0.iterator();
        while (it.hasNext()) {
            arrayList.add(((b1) it.next()).c(f2VarC));
        }
        s0Var2.R0(null, b1VarC, arrayList, s0Var.p1().v(), s0Var.i(), s0Var.getReturnType(), fe.e0.f9461b, s0Var.p1().getVisibility());
        return s0Var2;
    }

    @Override // fe.l
    public boolean C() {
        return n0().C();
    }

    @Override // fe.l
    public fe.e D() {
        fe.e eVarD = n0().D();
        kotlin.jvm.internal.t.e(eVarD, "getConstructedClass(...)");
        return eVarD;
    }

    @Override // ie.s, fe.a
    public xf.r0 getReturnType() {
        xf.r0 returnType = super.getReturnType();
        kotlin.jvm.internal.t.c(returnType);
        return returnType;
    }

    @Override // fe.b
    /* JADX INFO: renamed from: l1, reason: merged with bridge method [inline-methods] */
    public q0 L(fe.m newOwner, fe.e0 modality, fe.u visibility, b.a kind, boolean z10) {
        kotlin.jvm.internal.t.f(newOwner, "newOwner");
        kotlin.jvm.internal.t.f(modality, "modality");
        kotlin.jvm.internal.t.f(visibility, "visibility");
        kotlin.jvm.internal.t.f(kind, "kind");
        fe.z zVarBuild = u().p(newOwner).s(modality).d(visibility).m(kind).i(z10).build();
        kotlin.jvm.internal.t.d(zVarBuild, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (q0) zVarBuild;
    }

    @Override // ie.s
    /* JADX INFO: renamed from: m1, reason: merged with bridge method [inline-methods] */
    public s0 L0(fe.m newOwner, fe.z zVar, b.a kind, ef.f fVar, ge.h annotations, g1 source) {
        kotlin.jvm.internal.t.f(newOwner, "newOwner");
        kotlin.jvm.internal.t.f(kind, "kind");
        kotlin.jvm.internal.t.f(annotations, "annotations");
        kotlin.jvm.internal.t.f(source, "source");
        b.a aVar = b.a.DECLARATION;
        if (kind != aVar) {
            b.a aVar2 = b.a.SYNTHESIZED;
        }
        return new s0(this.E, p1(), n0(), this, annotations, aVar, source);
    }

    @Override // ie.q0
    public fe.d n0() {
        return this.H;
    }

    @Override // ie.n, fe.m
    /* JADX INFO: renamed from: n1, reason: merged with bridge method [inline-methods] */
    public k1 b() {
        return p1();
    }

    @Override // ie.n
    /* JADX INFO: renamed from: o1, reason: merged with bridge method [inline-methods] */
    public q0 a() {
        fe.z zVarA = super.a();
        kotlin.jvm.internal.t.d(zVarA, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptor");
        return (q0) zVarA;
    }

    public k1 p1() {
        return this.F;
    }

    @Override // ie.s, fe.z, fe.i1
    /* JADX INFO: renamed from: q1, reason: merged with bridge method [inline-methods] */
    public q0 c(f2 substitutor) {
        kotlin.jvm.internal.t.f(substitutor, "substitutor");
        fe.z zVarC = super.c(substitutor);
        kotlin.jvm.internal.t.d(zVarC, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.impl.TypeAliasConstructorDescriptorImpl");
        s0 s0Var = (s0) zVarC;
        f2 f2VarF = f2.f(s0Var.getReturnType());
        kotlin.jvm.internal.t.e(f2VarF, "create(...)");
        fe.d dVarC = n0().a().c(f2VarF);
        if (dVarC == null) {
            return null;
        }
        s0Var.H = dVarC;
        return s0Var;
    }

    public s0(wf.n nVar, k1 k1Var, fe.d dVar, q0 q0Var, ge.h hVar, b.a aVar, g1 g1Var) {
        super(k1Var, q0Var, hVar, ef.h.f8809j, aVar, g1Var);
        this.E = nVar;
        this.F = k1Var;
        V0(p1().E0());
        this.G = nVar.g(new r0(this, dVar));
        this.H = dVar;
    }
}
