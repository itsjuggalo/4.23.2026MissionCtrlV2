package zd;

import ce.o;
import cf.a;
import df.d;
import gf.i;
import java.lang.reflect.Method;
import zd.n;
import zd.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e3 f25716a = new e3();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ef.b f25717b = ef.b.f8779d.c(new ef.c("java.lang.Void"));

    public final ce.l a(Class cls) {
        if (cls.isPrimitive()) {
            return of.e.c(cls.getSimpleName()).k();
        }
        return null;
    }

    public final boolean b(fe.z zVar) {
        if (jf.h.p(zVar) || jf.h.q(zVar)) {
            return true;
        }
        return kotlin.jvm.internal.t.b(zVar.getName(), ee.a.f8677e.a()) && zVar.i().isEmpty();
    }

    public final ef.b c(Class klass) {
        ef.b bVarM;
        kotlin.jvm.internal.t.f(klass, "klass");
        if (klass.isArray()) {
            Class<?> componentType = klass.getComponentType();
            kotlin.jvm.internal.t.e(componentType, "getComponentType(...)");
            ce.l lVarA = a(componentType);
            return lVarA != null ? new ef.b(ce.o.A, lVarA.k()) : ef.b.f8779d.c(o.a.f3989i.m());
        }
        if (kotlin.jvm.internal.t.b(klass, Void.TYPE)) {
            return f25717b;
        }
        ce.l lVarA2 = a(klass);
        if (lVarA2 != null) {
            return new ef.b(ce.o.A, lVarA2.m());
        }
        ef.b bVarE = le.f.e(klass);
        return (bVarE.i() || (bVarM = ee.c.f8681a.m(bVarE.a())) == null) ? bVarE : bVarM;
    }

    public final n.e d(fe.z zVar) {
        return new n.e(new d.b(e(zVar), xe.c0.c(zVar, false, false, 1, null)));
    }

    public final String e(fe.b bVar) {
        String strE = oe.s0.e(bVar);
        if (strE != null) {
            return strE;
        }
        if (bVar instanceof fe.z0) {
            String strB = nf.e.w(bVar).getName().b();
            kotlin.jvm.internal.t.e(strB, "asString(...)");
            return oe.h0.b(strB);
        }
        if (bVar instanceof fe.a1) {
            String strB2 = nf.e.w(bVar).getName().b();
            kotlin.jvm.internal.t.e(strB2, "asString(...)");
            return oe.h0.e(strB2);
        }
        String strB3 = bVar.getName().b();
        kotlin.jvm.internal.t.e(strB3, "asString(...)");
        return strB3;
    }

    public final p f(fe.y0 possiblyOverriddenProperty) {
        kotlin.jvm.internal.t.f(possiblyOverriddenProperty, "possiblyOverriddenProperty");
        fe.y0 y0VarA = ((fe.y0) jf.i.L(possiblyOverriddenProperty)).a();
        kotlin.jvm.internal.t.e(y0VarA, "getOriginal(...)");
        if (y0VarA instanceof vf.n0) {
            vf.n0 n0Var = (vf.n0) y0VarA;
            ze.n nVarF1 = n0Var.F();
            i.f propertySignature = cf.a.f4053d;
            kotlin.jvm.internal.t.e(propertySignature, "propertySignature");
            a.d dVar = (a.d) bf.e.a(nVarF1, propertySignature);
            if (dVar != null) {
                return new p.c(y0VarA, nVarF1, dVar, n0Var.a0(), n0Var.U());
            }
        } else if (y0VarA instanceof qe.f) {
            qe.f fVar = (qe.f) y0VarA;
            fe.g1 g1VarJ = fVar.j();
            ue.a aVar = g1VarJ instanceof ue.a ? (ue.a) g1VarJ : null;
            ve.l lVarB = aVar != null ? aVar.b() : null;
            if (lVarB instanceof le.w) {
                return new p.a(((le.w) lVarB).R());
            }
            if (lVarB instanceof le.z) {
                Method methodR = ((le.z) lVarB).R();
                fe.a1 a1VarG = fVar.g();
                fe.g1 g1VarJ2 = a1VarG != null ? a1VarG.j() : null;
                ue.a aVar2 = g1VarJ2 instanceof ue.a ? (ue.a) g1VarJ2 : null;
                ve.l lVarB2 = aVar2 != null ? aVar2.b() : null;
                le.z zVar = lVarB2 instanceof le.z ? (le.z) lVarB2 : null;
                return new p.b(methodR, zVar != null ? zVar.R() : null);
            }
            throw new x2("Incorrect resolution sequence for Java field " + y0VarA + " (source = " + lVarB + ')');
        }
        fe.z0 z0VarD = y0VarA.d();
        kotlin.jvm.internal.t.c(z0VarD);
        n.e eVarD = d(z0VarD);
        fe.a1 a1VarG2 = y0VarA.g();
        return new p.d(eVarD, a1VarG2 != null ? d(a1VarG2) : null);
    }

    public final n g(fe.z possiblySubstitutedFunction) {
        Method methodR;
        d.b bVarB;
        d.b bVarE;
        kotlin.jvm.internal.t.f(possiblySubstitutedFunction, "possiblySubstitutedFunction");
        fe.z zVarA = ((fe.z) jf.i.L(possiblySubstitutedFunction)).a();
        kotlin.jvm.internal.t.e(zVarA, "getOriginal(...)");
        if (!(zVarA instanceof vf.b)) {
            if (zVarA instanceof qe.e) {
                fe.g1 g1VarJ = ((qe.e) zVarA).j();
                ue.a aVar = g1VarJ instanceof ue.a ? (ue.a) g1VarJ : null;
                ve.l lVarB = aVar != null ? aVar.b() : null;
                le.z zVar = lVarB instanceof le.z ? (le.z) lVarB : null;
                if (zVar != null && (methodR = zVar.R()) != null) {
                    return new n.c(methodR);
                }
                throw new x2("Incorrect resolution sequence for Java method " + zVarA);
            }
            if (!(zVarA instanceof qe.b)) {
                if (b(zVarA)) {
                    return d(zVarA);
                }
                throw new x2("Unknown origin of " + zVarA + " (" + zVarA.getClass() + ')');
            }
            fe.g1 g1VarJ2 = ((qe.b) zVarA).j();
            ue.a aVar2 = g1VarJ2 instanceof ue.a ? (ue.a) g1VarJ2 : null;
            ve.l lVarB2 = aVar2 != null ? aVar2.b() : null;
            if (lVarB2 instanceof le.t) {
                return new n.b(((le.t) lVarB2).R());
            }
            if (lVarB2 instanceof le.q) {
                le.q qVar = (le.q) lVarB2;
                if (qVar.q()) {
                    return new n.a(qVar.v());
                }
            }
            throw new x2("Incorrect resolution sequence for Java constructor " + zVarA + " (" + lVarB2 + ')');
        }
        vf.t tVar = (vf.t) zVarA;
        gf.p pVarF = tVar.F();
        if ((pVarF instanceof ze.i) && (bVarE = df.i.f8111a.e((ze.i) pVarF, tVar.a0(), tVar.U())) != null) {
            return new n.e(bVarE);
        }
        if (!(pVarF instanceof ze.d) || (bVarB = df.i.f8111a.b((ze.d) pVarF, tVar.a0(), tVar.U())) == null) {
            return d(zVarA);
        }
        fe.m mVarB = possiblySubstitutedFunction.b();
        kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
        if (jf.k.b(mVarB)) {
            return new n.e(bVarB);
        }
        fe.m mVarB2 = possiblySubstitutedFunction.b();
        kotlin.jvm.internal.t.e(mVarB2, "getContainingDeclaration(...)");
        if (!jf.k.d(mVarB2)) {
            return new n.d(bVarB);
        }
        fe.l lVar = (fe.l) possiblySubstitutedFunction;
        if (lVar.C()) {
            if (!kotlin.jvm.internal.t.b(bVarB.e(), "constructor-impl") || !kg.z.x(bVarB.d(), ")V", false, 2, null)) {
                throw new IllegalArgumentException(("Invalid signature: " + bVarB).toString());
            }
        } else {
            if (!kotlin.jvm.internal.t.b(bVarB.e(), "constructor-impl")) {
                throw new IllegalArgumentException(("Invalid signature: " + bVarB).toString());
            }
            fe.e eVarD = lVar.D();
            kotlin.jvm.internal.t.e(eVarD, "getConstructedClass(...)");
            String strU = ae.o.u(eVarD);
            if (kg.z.x(bVarB.d(), ")V", false, 2, null)) {
                bVarB = d.b.c(bVarB, null, kg.c0.z0(bVarB.d(), "V") + strU, 1, null);
            } else if (!kg.z.x(bVarB.d(), strU, false, 2, null)) {
                throw new IllegalArgumentException(("Invalid signature: " + bVarB).toString());
            }
        }
        return new n.e(bVarB);
    }
}
