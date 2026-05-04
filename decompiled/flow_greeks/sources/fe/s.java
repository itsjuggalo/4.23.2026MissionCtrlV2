package fe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s {
    public static final h a(m mVar) {
        kotlin.jvm.internal.t.f(mVar, "<this>");
        m mVarB = mVar.b();
        if (mVarB != null && !(mVar instanceof n0)) {
            if (!b(mVarB)) {
                return a(mVarB);
            }
            if (mVarB instanceof h) {
                return (h) mVarB;
            }
        }
        return null;
    }

    public static final boolean b(m mVar) {
        kotlin.jvm.internal.t.f(mVar, "<this>");
        return mVar.b() instanceof n0;
    }

    public static final boolean c(z zVar) {
        xf.c1 c1VarS;
        xf.r0 r0VarD;
        xf.r0 returnType;
        kotlin.jvm.internal.t.f(zVar, "<this>");
        m mVarB = zVar.b();
        e eVar = mVarB instanceof e ? (e) mVarB : null;
        if (eVar != null) {
            e eVar2 = jf.k.g(eVar) ? eVar : null;
            if (eVar2 != null && (c1VarS = eVar2.s()) != null && (r0VarD = cg.d.D(c1VarS)) != null && (returnType = zVar.getReturnType()) != null && kotlin.jvm.internal.t.b(zVar.getName(), eg.t.f8925e) && ((cg.d.s(returnType) || cg.d.t(returnType)) && zVar.i().size() == 1)) {
                xf.r0 type = ((s1) zVar.i().get(0)).getType();
                kotlin.jvm.internal.t.e(type, "getType(...)");
                if (kotlin.jvm.internal.t.b(cg.d.D(type), r0VarD) && zVar.p0().isEmpty() && zVar.k0() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final e d(h0 h0Var, ef.c fqName, ne.b lookupLocation) {
        qf.k kVarX0;
        kotlin.jvm.internal.t.f(h0Var, "<this>");
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(lookupLocation, "lookupLocation");
        if (fqName.c()) {
            return null;
        }
        h hVarE = h0Var.I0(fqName.d()).q().e(fqName.f(), lookupLocation);
        e eVar = hVarE instanceof e ? (e) hVarE : null;
        if (eVar != null) {
            return eVar;
        }
        e eVarD = d(h0Var, fqName.d(), lookupLocation);
        h hVarE2 = (eVarD == null || (kVarX0 = eVarD.x0()) == null) ? null : kVarX0.e(fqName.f(), lookupLocation);
        if (hVarE2 instanceof e) {
            return (e) hVarE2;
        }
        return null;
    }
}
