package xe;

import fe.k1;
import fe.l1;
import fe.n0;
import fe.z0;
import xf.a2;
import xf.i2;
import xf.m2;
import xf.q0;
import xf.r0;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j {
    public static final String a(fe.e klass, g0 typeMappingConfiguration) {
        kotlin.jvm.internal.t.f(klass, "klass");
        kotlin.jvm.internal.t.f(typeMappingConfiguration, "typeMappingConfiguration");
        String strE = typeMappingConfiguration.e(klass);
        if (strE != null) {
            return strE;
        }
        fe.m mVarB = klass.b();
        kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
        String strH = ef.h.b(klass.getName()).h();
        kotlin.jvm.internal.t.e(strH, "getIdentifier(...)");
        if (mVarB instanceof n0) {
            ef.c cVarE = ((n0) mVarB).e();
            if (cVarE.c()) {
                return strH;
            }
            return kg.z.E(cVarE.a(), com.amazon.a.a.o.c.a.b.f4610a, '/', false, 4, null) + '/' + strH;
        }
        fe.e eVar = mVarB instanceof fe.e ? (fe.e) mVarB : null;
        if (eVar == null) {
            throw new IllegalArgumentException("Unexpected container: " + mVarB + " for " + klass);
        }
        String strF = typeMappingConfiguration.f(eVar);
        if (strF == null) {
            strF = a(eVar, typeMappingConfiguration);
        }
        return strF + '$' + strH;
    }

    public static /* synthetic */ String b(fe.e eVar, g0 g0Var, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            g0Var = h0.f24868a;
        }
        return a(eVar, g0Var);
    }

    public static final boolean c(fe.a descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        if (descriptor instanceof fe.l) {
            return true;
        }
        r0 returnType = descriptor.getReturnType();
        kotlin.jvm.internal.t.c(returnType);
        if (!ce.i.D0(returnType)) {
            return false;
        }
        r0 returnType2 = descriptor.getReturnType();
        kotlin.jvm.internal.t.c(returnType2);
        return (i2.l(returnType2) || (descriptor instanceof z0)) ? false : true;
    }

    public static final Object d(r0 kotlinType, t factory, i0 mode, g0 typeMappingConfiguration, q qVar, pd.p writeGenericType) {
        Object objA;
        r0 r0Var;
        Object objD;
        kotlin.jvm.internal.t.f(kotlinType, "kotlinType");
        kotlin.jvm.internal.t.f(factory, "factory");
        kotlin.jvm.internal.t.f(mode, "mode");
        kotlin.jvm.internal.t.f(typeMappingConfiguration, "typeMappingConfiguration");
        kotlin.jvm.internal.t.f(writeGenericType, "writeGenericType");
        r0 r0VarB = typeMappingConfiguration.b(kotlinType);
        if (r0VarB != null) {
            return d(r0VarB, factory, mode, typeMappingConfiguration, qVar, writeGenericType);
        }
        if (ce.h.r(kotlinType)) {
            return d(ce.p.a(kotlinType), factory, mode, typeMappingConfiguration, qVar, writeGenericType);
        }
        yf.s sVar = yf.s.f25429a;
        Object objB = j0.b(sVar, kotlinType, factory, mode);
        if (objB != null) {
            Object objA2 = j0.a(factory, objB, mode.d());
            writeGenericType.invoke(kotlinType, objA2, mode);
            return objA2;
        }
        u1 u1VarN0 = kotlinType.N0();
        if (u1VarN0 instanceof q0) {
            q0 q0Var = (q0) u1VarN0;
            r0 r0VarL = q0Var.l();
            if (r0VarL == null) {
                r0VarL = typeMappingConfiguration.c(q0Var.c());
            }
            return d(cg.d.D(r0VarL), factory, mode, typeMappingConfiguration, qVar, writeGenericType);
        }
        fe.h hVarB = u1VarN0.b();
        if (hVarB == null) {
            throw new UnsupportedOperationException("no descriptor for type constructor of " + kotlinType);
        }
        if (zf.l.m(hVarB)) {
            Object objC = factory.c("error/NonExistentClass");
            typeMappingConfiguration.d(kotlinType, (fe.e) hVarB);
            return objC;
        }
        boolean z10 = hVarB instanceof fe.e;
        if (z10 && ce.i.d0(kotlinType)) {
            if (kotlinType.L0().size() != 1) {
                throw new UnsupportedOperationException("arrays must have one type argument");
            }
            a2 a2Var = (a2) kotlinType.L0().get(0);
            r0 type = a2Var.getType();
            kotlin.jvm.internal.t.e(type, "getType(...)");
            if (a2Var.b() == m2.f25016f) {
                objD = factory.c("java/lang/Object");
            } else {
                m2 m2VarB = a2Var.b();
                kotlin.jvm.internal.t.e(m2VarB, "getProjectionKind(...)");
                objD = d(type, factory, mode.f(m2VarB, true), typeMappingConfiguration, qVar, writeGenericType);
            }
            return factory.b('[' + factory.a(objD));
        }
        if (!z10) {
            if (hVarB instanceof l1) {
                r0 r0VarO = cg.d.o((l1) hVarB);
                if (kotlinType.O0()) {
                    r0VarO = cg.d.B(r0VarO);
                }
                return d(r0VarO, factory, mode, typeMappingConfiguration, null, hg.j.l());
            }
            if ((hVarB instanceof k1) && mode.b()) {
                return d(((k1) hVarB).X(), factory, mode, typeMappingConfiguration, qVar, writeGenericType);
            }
            throw new UnsupportedOperationException("Unknown type " + kotlinType);
        }
        if (jf.k.b(hVarB) && !mode.c() && (r0Var = (r0) xf.h0.a(sVar, kotlinType)) != null) {
            return d(r0Var, factory, mode.g(), typeMappingConfiguration, qVar, writeGenericType);
        }
        if (mode.e() && ce.i.m0((fe.e) hVarB)) {
            objA = factory.f();
        } else {
            fe.e eVar = (fe.e) hVarB;
            fe.e eVarA = eVar.a();
            kotlin.jvm.internal.t.e(eVarA, "getOriginal(...)");
            objA = typeMappingConfiguration.a(eVarA);
            if (objA == null) {
                if (eVar.h() == fe.f.f9476e) {
                    fe.m mVarB = eVar.b();
                    kotlin.jvm.internal.t.d(mVarB, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
                    eVar = (fe.e) mVarB;
                }
                fe.e eVarA2 = eVar.a();
                kotlin.jvm.internal.t.e(eVarA2, "getOriginal(...)");
                objA = factory.c(a(eVarA2, typeMappingConfiguration));
            }
        }
        writeGenericType.invoke(kotlinType, objA, mode);
        return objA;
    }

    public static /* synthetic */ Object e(r0 r0Var, t tVar, i0 i0Var, g0 g0Var, q qVar, pd.p pVar, int i10, Object obj) {
        if ((i10 & 32) != 0) {
            pVar = hg.j.l();
        }
        return d(r0Var, tVar, i0Var, g0Var, qVar, pVar);
    }
}
