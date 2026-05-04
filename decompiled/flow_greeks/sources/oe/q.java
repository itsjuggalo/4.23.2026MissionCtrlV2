package oe;

import fe.b1;
import fe.f1;
import fe.s1;
import java.util.List;
import jf.j;
import jf.o;
import xf.z1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements jf.j {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f18054a;

        static {
            int[] iArr = new int[o.i.a.values().length];
            try {
                iArr[o.i.a.OVERRIDABLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f18054a = iArr;
        }
    }

    public static final xf.r0 d(s1 s1Var) {
        return s1Var.getType();
    }

    @Override // jf.j
    public j.a a() {
        return j.a.SUCCESS_ONLY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // jf.j
    public j.b b(fe.a superDescriptor, fe.a subDescriptor, fe.e eVar) {
        kotlin.jvm.internal.t.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.t.f(subDescriptor, "subDescriptor");
        if (subDescriptor instanceof qe.e) {
            qe.e eVar2 = (qe.e) subDescriptor;
            List typeParameters = eVar2.getTypeParameters();
            kotlin.jvm.internal.t.e(typeParameters, "getTypeParameters(...)");
            if (typeParameters.isEmpty()) {
                o.i iVarW = jf.o.w(superDescriptor, subDescriptor);
                z1 z1Var = null;
                Object[] objArr = 0;
                if ((iVarW != null ? iVarW.c() : null) != null) {
                    return j.b.UNKNOWN;
                }
                List listI = eVar2.i();
                kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
                jg.h hVarE = jg.t.E(dd.a0.Q(listI), p.f18052a);
                xf.r0 returnType = eVar2.getReturnType();
                kotlin.jvm.internal.t.c(returnType);
                jg.h hVarH = jg.t.H(hVarE, returnType);
                b1 b1VarK0 = eVar2.k0();
                for (xf.r0 r0Var : jg.t.G(hVarH, dd.r.o(b1VarK0 != null ? b1VarK0.getType() : null))) {
                    if (!r0Var.L0().isEmpty() && !(r0Var.Q0() instanceof te.k)) {
                        return j.b.UNKNOWN;
                    }
                }
                fe.a aVarBuild = (fe.a) superDescriptor.c(new te.i(z1Var, 1, objArr == true ? 1 : 0).c());
                if (aVarBuild == null) {
                    return j.b.UNKNOWN;
                }
                if (aVarBuild instanceof f1) {
                    f1 f1Var = (f1) aVarBuild;
                    List typeParameters2 = f1Var.getTypeParameters();
                    kotlin.jvm.internal.t.e(typeParameters2, "getTypeParameters(...)");
                    if (!typeParameters2.isEmpty()) {
                        aVarBuild = f1Var.u().l(dd.r.k()).build();
                        kotlin.jvm.internal.t.c(aVarBuild);
                    }
                }
                o.i.a aVarC = jf.o.f14337f.F(aVarBuild, subDescriptor, false).c();
                kotlin.jvm.internal.t.e(aVarC, "getResult(...)");
                return a.f18054a[aVarC.ordinal()] == 1 ? j.b.OVERRIDABLE : j.b.UNKNOWN;
            }
        }
        return j.b.UNKNOWN;
    }
}
