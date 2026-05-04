package oe;

import fe.s1;
import java.util.List;
import jf.j;
import oe.t0;
import xe.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z implements jf.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18109a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final boolean a(fe.a superDescriptor, fe.a subDescriptor) {
            kotlin.jvm.internal.t.f(superDescriptor, "superDescriptor");
            kotlin.jvm.internal.t.f(subDescriptor, "subDescriptor");
            if ((subDescriptor instanceof qe.e) && (superDescriptor instanceof fe.z)) {
                qe.e eVar = (qe.e) subDescriptor;
                eVar.i().size();
                fe.z zVar = (fe.z) superDescriptor;
                zVar.i().size();
                List listI = eVar.a().i();
                kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
                List listI2 = zVar.a().i();
                kotlin.jvm.internal.t.e(listI2, "getValueParameters(...)");
                for (cd.q qVar : dd.a0.S0(listI, listI2)) {
                    s1 s1Var = (s1) qVar.a();
                    s1 s1Var2 = (s1) qVar.b();
                    kotlin.jvm.internal.t.c(s1Var);
                    boolean z10 = c((fe.z) subDescriptor, s1Var) instanceof s.d;
                    kotlin.jvm.internal.t.c(s1Var2);
                    if (z10 != (c(zVar, s1Var2) instanceof s.d)) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final boolean b(fe.z zVar) {
            if (zVar.i().size() != 1) {
                return false;
            }
            fe.m mVarB = zVar.b();
            fe.e eVar = mVarB instanceof fe.e ? (fe.e) mVarB : null;
            if (eVar == null) {
                return false;
            }
            List listI = zVar.i();
            kotlin.jvm.internal.t.e(listI, "getValueParameters(...)");
            fe.h hVarB = ((s1) dd.a0.v0(listI)).getType().N0().b();
            fe.e eVar2 = hVarB instanceof fe.e ? (fe.e) hVarB : null;
            return eVar2 != null && ce.i.s0(eVar) && kotlin.jvm.internal.t.b(nf.e.o(eVar), nf.e.o(eVar2));
        }

        public final xe.s c(fe.z zVar, s1 s1Var) {
            if (xe.c0.e(zVar) || b(zVar)) {
                xf.r0 type = s1Var.getType();
                kotlin.jvm.internal.t.e(type, "getType(...)");
                return xe.c0.g(cg.d.B(type));
            }
            xf.r0 type2 = s1Var.getType();
            kotlin.jvm.internal.t.e(type2, "getType(...)");
            return xe.c0.g(type2);
        }

        public a() {
        }
    }

    @Override // jf.j
    public j.a a() {
        return j.a.CONFLICTS_ONLY;
    }

    @Override // jf.j
    public j.b b(fe.a superDescriptor, fe.a subDescriptor, fe.e eVar) {
        kotlin.jvm.internal.t.f(superDescriptor, "superDescriptor");
        kotlin.jvm.internal.t.f(subDescriptor, "subDescriptor");
        return c(superDescriptor, subDescriptor, eVar) ? j.b.INCOMPATIBLE : f18109a.a(superDescriptor, subDescriptor) ? j.b.INCOMPATIBLE : j.b.UNKNOWN;
    }

    public final boolean c(fe.a aVar, fe.a aVar2, fe.e eVar) {
        if ((aVar instanceof fe.b) && (aVar2 instanceof fe.z) && !ce.i.h0(aVar2)) {
            i iVar = i.f17980o;
            fe.z zVar = (fe.z) aVar2;
            ef.f name = zVar.getName();
            kotlin.jvm.internal.t.e(name, "getName(...)");
            if (!iVar.n(name)) {
                t0.a aVar3 = t0.f18060a;
                ef.f name2 = zVar.getName();
                kotlin.jvm.internal.t.e(name2, "getName(...)");
                if (!aVar3.k(name2)) {
                    return false;
                }
            }
            fe.b bVarJ = s0.j((fe.b) aVar);
            boolean z10 = aVar instanceof fe.z;
            fe.z zVar2 = z10 ? (fe.z) aVar : null;
            if (!(zVar2 != null && zVar.v0() == zVar2.v0()) && (bVarJ == null || !zVar.v0())) {
                return true;
            }
            if ((eVar instanceof qe.c) && zVar.d0() == null && bVarJ != null && !s0.l(eVar, bVarJ)) {
                if ((bVarJ instanceof fe.z) && z10 && i.l((fe.z) bVarJ) != null) {
                    String strC = xe.c0.c(zVar, false, false, 2, null);
                    fe.z zVarA = ((fe.z) aVar).a();
                    kotlin.jvm.internal.t.e(zVarA, "getOriginal(...)");
                    if (kotlin.jvm.internal.t.b(strC, xe.c0.c(zVarA, false, false, 2, null))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
