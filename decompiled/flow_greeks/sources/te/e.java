package te;

import dd.q;
import dd.s;
import fe.l1;
import ge.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import re.p;
import ve.a0;
import ve.c0;
import ve.v;
import ve.x;
import ve.y;
import xf.a2;
import xf.c1;
import xf.c2;
import xf.h2;
import xf.i2;
import xf.m2;
import xf.q1;
import xf.r0;
import xf.r1;
import xf.u0;
import xf.u1;
import xf.x0;
import xf.z1;
import zf.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final re.k f21912a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f21913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f21914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z1 f21915d;

    /* JADX WARN: Multi-variable type inference failed */
    public e(re.k c10, p typeParameterResolver) {
        t.f(c10, "c");
        t.f(typeParameterResolver, "typeParameterResolver");
        this.f21912a = c10;
        this.f21913b = typeParameterResolver;
        g gVar = new g();
        this.f21914c = gVar;
        this.f21915d = new z1(gVar, null, 2, 0 == true ? 1 : 0);
    }

    public static final r0 e(e eVar, l1 l1Var, a aVar, u1 u1Var, ve.j jVar) {
        z1 z1Var = eVar.f21915d;
        fe.h hVarB = u1Var.b();
        return z1Var.e(l1Var, aVar.k(hVarB != null ? hVarB.s() : null).j(jVar.w()));
    }

    public static /* synthetic */ r0 m(e eVar, ve.f fVar, a aVar, boolean z10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z10 = false;
        }
        return eVar.l(fVar, aVar, z10);
    }

    public static final zf.i o(ve.j jVar) {
        return l.d(zf.k.f26508f, jVar.p());
    }

    public final boolean b(ve.j jVar, fe.e eVar) {
        m2 m2VarO;
        if (!a0.a((x) dd.a0.m0(jVar.E()))) {
            return false;
        }
        List parameters = ee.d.f8701a.b(eVar).k().getParameters();
        t.e(parameters, "getParameters(...)");
        l1 l1Var = (l1) dd.a0.m0(parameters);
        return (l1Var == null || (m2VarO = l1Var.o()) == null || m2VarO == m2.f25017g) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List c(ve.j r10, te.a r11, xf.u1 r12) {
        /*
            Method dump skipped, instruction units count: 201
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: te.e.c(ve.j, te.a, xf.u1):java.util.List");
    }

    public final List d(ve.j jVar, List list, u1 u1Var, a aVar) {
        ve.j jVar2;
        u1 u1Var2;
        a aVar2;
        a2 a2VarA;
        ArrayList arrayList = new ArrayList(s.u(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            l1 l1Var = (l1) it.next();
            if (cg.d.q(l1Var, null, aVar.c())) {
                a2VarA = i2.t(l1Var, aVar);
                jVar2 = jVar;
                u1Var2 = u1Var;
                aVar2 = aVar;
            } else {
                jVar2 = jVar;
                u1Var2 = u1Var;
                aVar2 = aVar;
                a2VarA = this.f21914c.a(l1Var, aVar2.j(jVar2.w()), this.f21915d, new x0(this.f21912a.e(), new d(this, l1Var, aVar2, u1Var2, jVar2)));
            }
            arrayList.add(a2VarA);
            aVar = aVar2;
            u1Var = u1Var2;
            jVar = jVar2;
        }
        return arrayList;
    }

    public final c1 f(ve.j jVar, a aVar, c1 c1Var) {
        ve.j jVar2;
        q1 q1VarB;
        if (c1Var == null || (q1VarB = c1Var.M0()) == null) {
            jVar2 = jVar;
            q1VarB = r1.b(new re.g(this.f21912a, jVar2, false, 4, null));
        } else {
            jVar2 = jVar;
        }
        q1 q1Var = q1VarB;
        u1 u1VarG = g(jVar2, aVar);
        if (u1VarG == null) {
            return null;
        }
        boolean zJ = j(aVar);
        return (t.b(c1Var != null ? c1Var.N0() : null, u1VarG) && !jVar2.w() && zJ) ? c1Var.R0(true) : u0.k(q1Var, u1VarG, c(jVar2, aVar, u1VarG), zJ, null, 16, null);
    }

    public final u1 g(ve.j jVar, a aVar) {
        u1 u1VarK;
        ve.i iVarJ = jVar.j();
        if (iVarJ == null) {
            return h(jVar);
        }
        if (!(iVarJ instanceof ve.g)) {
            if (iVarJ instanceof y) {
                l1 l1VarA = this.f21913b.a((y) iVarJ);
                if (l1VarA != null) {
                    return l1VarA.k();
                }
                return null;
            }
            throw new IllegalStateException("Unknown classifier kind: " + iVarJ);
        }
        ve.g gVar = (ve.g) iVarJ;
        ef.c cVarE = gVar.e();
        if (cVarE != null) {
            fe.e eVarK = k(jVar, aVar, cVarE);
            if (eVarK == null) {
                eVarK = this.f21912a.a().n().a(gVar);
            }
            return (eVarK == null || (u1VarK = eVarK.k()) == null) ? h(jVar) : u1VarK;
        }
        throw new AssertionError("Class type should have a FQ name: " + iVarJ);
    }

    public final u1 h(ve.j jVar) {
        u1 u1VarK = this.f21912a.a().b().f().r().d(ef.b.f8779d.c(new ef.c(jVar.x())), q.e(0)).k();
        t.e(u1VarK, "getTypeConstructor(...)");
        return u1VarK;
    }

    public final boolean i(m2 m2Var, l1 l1Var) {
        return (l1Var.o() == m2.f25015e || m2Var == l1Var.o()) ? false : true;
    }

    public final boolean j(a aVar) {
        return (aVar.g() == c.f21904c || aVar.h() || aVar.b() == h2.f24978a) ? false : true;
    }

    public final fe.e k(ve.j jVar, a aVar, ef.c cVar) {
        if (aVar.h() && t.b(cVar, f.f21916a)) {
            return this.f21912a.a().p().d();
        }
        ee.d dVar = ee.d.f8701a;
        fe.e eVarF = ee.d.f(dVar, cVar, this.f21912a.d().p(), null, 4, null);
        if (eVarF == null) {
            return null;
        }
        return (dVar.d(eVarF) && (aVar.g() == c.f21904c || aVar.b() == h2.f24978a || b(jVar, eVarF))) ? dVar.b(eVarF) : eVarF;
    }

    public final r0 l(ve.f arrayType, a attr, boolean z10) {
        t.f(arrayType, "arrayType");
        t.f(attr, "attr");
        x xVarO = arrayType.o();
        v vVar = xVarO instanceof v ? (v) xVarO : null;
        ce.l type = vVar != null ? vVar.getType() : null;
        re.g gVar = new re.g(this.f21912a, arrayType, true);
        if (type != null) {
            c1 c1VarP = this.f21912a.d().p().P(type);
            t.c(c1VarP);
            r0 r0VarC = cg.d.C(c1VarP, new o(c1VarP.getAnnotations(), gVar));
            t.d(r0VarC, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
            c1 c1Var = (c1) r0VarC;
            return attr.h() ? c1Var : u0.e(c1Var, c1Var.R0(true));
        }
        r0 r0VarP = p(xVarO, b.b(h2.f24979b, attr.h(), false, null, 6, null));
        if (attr.h()) {
            c1 c1VarN = this.f21912a.d().p().n(z10 ? m2.f25017g : m2.f25015e, r0VarP, gVar);
            t.e(c1VarN, "getArrayType(...)");
            return c1VarN;
        }
        c1 c1VarN2 = this.f21912a.d().p().n(m2.f25015e, r0VarP, gVar);
        t.e(c1VarN2, "getArrayType(...)");
        return u0.e(c1VarN2, this.f21912a.d().p().n(m2.f25017g, r0VarP, gVar).R0(true));
    }

    public final r0 n(ve.j jVar, a aVar) {
        boolean z10 = (aVar.h() || aVar.b() == h2.f24978a) ? false : true;
        boolean zW = jVar.w();
        if (!zW && !z10) {
            c1 c1VarF = f(jVar, aVar, null);
            return c1VarF != null ? c1VarF : o(jVar);
        }
        c1 c1VarF2 = f(jVar, aVar.l(c.f21904c), null);
        if (c1VarF2 == null) {
            return o(jVar);
        }
        c1 c1VarF3 = f(jVar, aVar.l(c.f21903b), c1VarF2);
        return c1VarF3 == null ? o(jVar) : zW ? new k(c1VarF2, c1VarF3) : u0.e(c1VarF2, c1VarF3);
    }

    public final r0 p(x xVar, a attr) {
        r0 r0VarP;
        t.f(attr, "attr");
        if (xVar instanceof v) {
            ce.l type = ((v) xVar).getType();
            c1 c1VarS = type != null ? this.f21912a.d().p().S(type) : this.f21912a.d().p().a0();
            t.c(c1VarS);
            return c1VarS;
        }
        if (xVar instanceof ve.j) {
            return n((ve.j) xVar, attr);
        }
        if (xVar instanceof ve.f) {
            return m(this, (ve.f) xVar, attr, false, 4, null);
        }
        if (xVar instanceof c0) {
            x xVarB = ((c0) xVar).B();
            if (xVarB != null && (r0VarP = p(xVarB, attr)) != null) {
                return r0VarP;
            }
            c1 c1VarZ = this.f21912a.d().p().z();
            t.e(c1VarZ, "getDefaultBound(...)");
            return c1VarZ;
        }
        if (xVar == null) {
            c1 c1VarZ2 = this.f21912a.d().p().z();
            t.e(c1VarZ2, "getDefaultBound(...)");
            return c1VarZ2;
        }
        throw new UnsupportedOperationException("Unsupported type: " + xVar);
    }

    public final a2 q(x xVar, a aVar, l1 l1Var) {
        if (!(xVar instanceof c0)) {
            return new c2(m2.f25015e, p(xVar, aVar));
        }
        c0 c0Var = (c0) xVar;
        x xVarB = c0Var.B();
        m2 m2Var = c0Var.I() ? m2.f25017g : m2.f25016f;
        if (xVarB == null || i(m2Var, l1Var)) {
            a2 a2VarT = i2.t(l1Var, aVar);
            t.e(a2VarT, "makeStarProjection(...)");
            return a2VarT;
        }
        ge.c cVarA = oe.u0.a(this.f21912a, c0Var);
        r0 r0VarP = p(xVarB, b.b(h2.f24979b, false, false, null, 7, null));
        if (cVarA != null) {
            r0VarP = cg.d.C(r0VarP, ge.h.L.a(dd.a0.r0(r0VarP.getAnnotations(), cVarA)));
        }
        return cg.d.k(r0VarP, m2Var, l1Var);
    }
}
