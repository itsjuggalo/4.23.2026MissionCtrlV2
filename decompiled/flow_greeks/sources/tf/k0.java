package tf;

import bf.b;
import fe.a;
import fe.b;
import fe.b1;
import fe.f1;
import fe.g1;
import fe.k1;
import fe.s1;
import ge.h;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tf.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f21978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f21979b;

    public k0(p c10) {
        kotlin.jvm.internal.t.f(c10, "c");
        this.f21978a = c10;
        this.f21979b = new g(c10.c().q(), c10.c().r());
    }

    public static final List C(k0 k0Var, n0 n0Var, gf.p pVar, d dVar, int i10, ze.u uVar) {
        return dd.a0.I0(k0Var.f21978a.c().d().a(n0Var, pVar, dVar, i10, uVar));
    }

    public static final List k(k0 k0Var, gf.p pVar, d dVar) {
        n0 n0VarI = k0Var.i(k0Var.f21978a.e());
        List listI0 = n0VarI != null ? dd.a0.I0(k0Var.f21978a.c().d().d(n0VarI, pVar, dVar)) : null;
        return listI0 == null ? dd.r.k() : listI0;
    }

    public static final List n(k0 k0Var, boolean z10, ze.n nVar) {
        n0 n0VarI = k0Var.i(k0Var.f21978a.e());
        List listI0 = n0VarI != null ? z10 ? dd.a0.I0(k0Var.f21978a.c().d().i(n0VarI, nVar)) : dd.a0.I0(k0Var.f21978a.c().d().k(n0VarI, nVar)) : null;
        return listI0 == null ? dd.r.k() : listI0;
    }

    public static final List p(k0 k0Var, gf.p pVar, d dVar) {
        n0 n0VarI = k0Var.i(k0Var.f21978a.e());
        List listL = n0VarI != null ? k0Var.f21978a.c().d().l(n0VarI, pVar, dVar) : null;
        return listL == null ? dd.r.k() : listL;
    }

    public static final wf.j v(k0 k0Var, ze.n nVar, vf.n0 n0Var) {
        return k0Var.f21978a.h().g(new i0(k0Var, nVar, n0Var));
    }

    public static final lf.g w(k0 k0Var, ze.n nVar, vf.n0 n0Var) {
        n0 n0VarI = k0Var.i(k0Var.f21978a.e());
        kotlin.jvm.internal.t.c(n0VarI);
        e eVarD = k0Var.f21978a.c().d();
        xf.r0 returnType = n0Var.getReturnType();
        kotlin.jvm.internal.t.e(returnType, "getReturnType(...)");
        return (lf.g) eVarD.j(n0VarI, nVar, returnType);
    }

    public static final wf.j x(k0 k0Var, ze.n nVar, vf.n0 n0Var) {
        return k0Var.f21978a.h().g(new j0(k0Var, nVar, n0Var));
    }

    public static final lf.g y(k0 k0Var, ze.n nVar, vf.n0 n0Var) {
        n0 n0VarI = k0Var.i(k0Var.f21978a.e());
        kotlin.jvm.internal.t.c(n0VarI);
        e eVarD = k0Var.f21978a.c().d();
        xf.r0 returnType = n0Var.getReturnType();
        kotlin.jvm.internal.t.e(returnType, "getReturnType(...)");
        return (lf.g) eVarD.h(n0VarI, nVar, returnType);
    }

    public final b1 A(ze.q qVar, p pVar, fe.a aVar, int i10) {
        return jf.h.b(aVar, pVar.i().u(qVar), null, ge.h.L.b(), i10);
    }

    public final List B(List list, gf.p pVar, d dVar) {
        fe.m mVarE = this.f21978a.e();
        kotlin.jvm.internal.t.d(mVarE, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.CallableDescriptor");
        fe.a aVar = (fe.a) mVarE;
        fe.m mVarB = aVar.b();
        kotlin.jvm.internal.t.e(mVarB, "getContainingDeclaration(...)");
        n0 n0VarI = i(mVarB);
        ArrayList arrayList = new ArrayList(dd.s.u(list, 10));
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                dd.r.t();
            }
            ze.u uVar = (ze.u) obj;
            int iK = uVar.Q() ? uVar.K() : 0;
            ge.h hVarB = (n0VarI == null || !bf.b.f3317c.d(iK).booleanValue()) ? ge.h.L.b() : new vf.s0(this.f21978a.h(), new h0(this, n0VarI, pVar, dVar, i10, uVar));
            ef.f fVarB = l0.b(this.f21978a.g(), uVar.L());
            xf.r0 r0VarU = this.f21978a.i().u(bf.f.q(uVar, this.f21978a.j()));
            Boolean boolD = bf.b.H.d(iK);
            kotlin.jvm.internal.t.e(boolD, "get(...)");
            boolean zBooleanValue = boolD.booleanValue();
            Boolean boolD2 = bf.b.I.d(iK);
            kotlin.jvm.internal.t.e(boolD2, "get(...)");
            boolean zBooleanValue2 = boolD2.booleanValue();
            Boolean boolD3 = bf.b.J.d(iK);
            kotlin.jvm.internal.t.e(boolD3, "get(...)");
            boolean zBooleanValue3 = boolD3.booleanValue();
            ze.q qVarT = bf.f.t(uVar, this.f21978a.j());
            xf.r0 r0VarU2 = qVarT != null ? this.f21978a.i().u(qVarT) : null;
            g1 NO_SOURCE = g1.f9483a;
            kotlin.jvm.internal.t.e(NO_SOURCE, "NO_SOURCE");
            fe.a aVar2 = aVar;
            arrayList.add(new ie.u0(aVar2, null, i10, hVarB, fVarB, r0VarU, zBooleanValue, zBooleanValue2, zBooleanValue3, r0VarU2, NO_SOURCE));
            aVar = aVar2;
            i10 = i11;
        }
        return dd.a0.I0(arrayList);
    }

    public final n0 i(fe.m mVar) {
        if (mVar instanceof fe.n0) {
            return new n0.b(((fe.n0) mVar).e(), this.f21978a.g(), this.f21978a.j(), this.f21978a.d());
        }
        if (mVar instanceof vf.m) {
            return ((vf.m) mVar).i1();
        }
        return null;
    }

    public final ge.h j(gf.p pVar, int i10, d dVar) {
        return !bf.b.f3317c.d(i10).booleanValue() ? ge.h.L.b() : new vf.s0(this.f21978a.h(), new e0(this, pVar, dVar));
    }

    public final b1 l() {
        fe.m mVarE = this.f21978a.e();
        fe.e eVar = mVarE instanceof fe.e ? (fe.e) mVarE : null;
        if (eVar != null) {
            return eVar.J0();
        }
        return null;
    }

    public final ge.h m(ze.n nVar, boolean z10) {
        return !bf.b.f3317c.d(nVar.a0()).booleanValue() ? ge.h.L.b() : new vf.s0(this.f21978a.h(), new f0(this, z10, nVar));
    }

    public final ge.h o(gf.p pVar, d dVar) {
        return new vf.a(this.f21978a.h(), new g0(this, pVar, dVar));
    }

    public final void q(vf.o0 o0Var, b1 b1Var, b1 b1Var2, List list, List list2, List list3, xf.r0 r0Var, fe.e0 e0Var, fe.u uVar, Map map) {
        o0Var.o1(b1Var, b1Var2, list, list2, list3, r0Var, e0Var, uVar, map);
    }

    public final fe.d r(ze.d proto, boolean z10) {
        kotlin.jvm.internal.t.f(proto, "proto");
        fe.m mVarE = this.f21978a.e();
        kotlin.jvm.internal.t.d(mVarE, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.ClassDescriptor");
        fe.e eVar = (fe.e) mVarE;
        int iJ = proto.J();
        d dVar = d.FUNCTION;
        vf.c cVar = new vf.c(eVar, null, j(proto, iJ, dVar), z10, b.a.DECLARATION, proto, this.f21978a.g(), this.f21978a.j(), this.f21978a.k(), this.f21978a.d(), null, 1024, null);
        k0 k0VarF = p.b(this.f21978a, cVar, dd.r.k(), null, null, null, null, 60, null).f();
        List listM = proto.M();
        kotlin.jvm.internal.t.e(listM, "getValueParameterList(...)");
        cVar.q1(k0VarF.B(listM, proto, dVar), p0.a(o0.f22025a, (ze.x) bf.b.f3318d.d(proto.J())));
        cVar.g1(eVar.s());
        cVar.W0(eVar.N());
        cVar.Y0(!bf.b.f3329o.d(proto.J()).booleanValue());
        return cVar;
    }

    public final f1 s(ze.i proto) {
        xf.r0 r0VarU;
        kotlin.jvm.internal.t.f(proto, "proto");
        int iC0 = proto.s0() ? proto.c0() : t(proto.e0());
        d dVar = d.FUNCTION;
        ge.h hVarJ = j(proto, iC0, dVar);
        ge.h hVarO = bf.f.g(proto) ? o(proto, dVar) : ge.h.L.b();
        vf.o0 o0Var = new vf.o0(this.f21978a.e(), null, hVarJ, l0.b(this.f21978a.g(), proto.d0()), p0.b(o0.f22025a, (ze.j) bf.b.f3330p.d(iC0)), proto, this.f21978a.g(), this.f21978a.j(), kotlin.jvm.internal.t.b(nf.e.o(this.f21978a.e()).b(l0.b(this.f21978a.g(), proto.d0())), q0.f22047a) ? bf.h.f3348b.b() : this.f21978a.k(), this.f21978a.d(), null, 1024, null);
        p pVar = this.f21978a;
        List listL0 = proto.l0();
        kotlin.jvm.internal.t.e(listL0, "getTypeParameterList(...)");
        p pVarB = p.b(pVar, o0Var, listL0, null, null, null, null, 60, null);
        ze.q qVarK = bf.f.k(proto, this.f21978a.j());
        b1 b1VarI = (qVarK == null || (r0VarU = pVarB.i().u(qVarK)) == null) ? null : jf.h.i(o0Var, r0VarU, hVarO);
        b1 b1VarL = l();
        List listC = bf.f.c(proto, this.f21978a.j());
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        for (Object obj : listC) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                dd.r.t();
            }
            b1 b1VarA = A((ze.q) obj, pVarB, o0Var, i10);
            if (b1VarA != null) {
                arrayList.add(b1VarA);
            }
            i10 = i11;
        }
        List listM = pVarB.i().m();
        k0 k0VarF = pVarB.f();
        List listP0 = proto.p0();
        kotlin.jvm.internal.t.e(listP0, "getValueParameterList(...)");
        List listB = k0VarF.B(listP0, proto, d.FUNCTION);
        xf.r0 r0VarU2 = pVarB.i().u(bf.f.m(proto, this.f21978a.j()));
        o0 o0Var2 = o0.f22025a;
        q(o0Var, b1VarI, b1VarL, arrayList, listM, listB, r0VarU2, o0Var2.b((ze.k) bf.b.f3319e.d(iC0)), p0.a(o0Var2, (ze.x) bf.b.f3318d.d(iC0)), dd.o0.h());
        o0Var.f1(bf.b.f3331q.d(iC0).booleanValue());
        o0Var.c1(bf.b.f3332r.d(iC0).booleanValue());
        o0Var.X0(bf.b.f3335u.d(iC0).booleanValue());
        o0Var.e1(bf.b.f3333s.d(iC0).booleanValue());
        o0Var.i1(bf.b.f3334t.d(iC0).booleanValue());
        o0Var.h1(bf.b.f3336v.d(iC0).booleanValue());
        o0Var.W0(bf.b.f3337w.d(iC0).booleanValue());
        o0Var.Y0(!bf.b.f3338x.d(iC0).booleanValue());
        cd.q qVarA = this.f21978a.c().h().a(proto, o0Var, this.f21978a.j(), pVarB.i());
        if (qVarA != null) {
            o0Var.U0((a.InterfaceC0175a) qVarA.c(), qVarA.d());
        }
        return o0Var;
    }

    public final int t(int i10) {
        return (i10 & 63) + ((i10 >> 8) << 6);
    }

    public final fe.y0 u(ze.n proto) {
        p pVar;
        b.d dVar;
        b.d dVar2;
        ie.l0 l0VarD;
        ie.l0 l0Var;
        boolean z10;
        ie.m0 m0Var;
        xf.r0 r0VarU;
        kotlin.jvm.internal.t.f(proto, "proto");
        int iA0 = proto.o0() ? proto.a0() : t(proto.d0());
        fe.m mVarE = this.f21978a.e();
        ge.h hVarJ = j(proto, iA0, d.PROPERTY);
        o0 o0Var = o0.f22025a;
        fe.e0 e0VarB = o0Var.b((ze.k) bf.b.f3319e.d(iA0));
        fe.u uVarA = p0.a(o0Var, (ze.x) bf.b.f3318d.d(iA0));
        Boolean boolD = bf.b.f3339y.d(iA0);
        kotlin.jvm.internal.t.e(boolD, "get(...)");
        boolean zBooleanValue = boolD.booleanValue();
        ef.f fVarB = l0.b(this.f21978a.g(), proto.c0());
        b.a aVarB = p0.b(o0Var, (ze.j) bf.b.f3330p.d(iA0));
        Boolean boolD2 = bf.b.C.d(iA0);
        kotlin.jvm.internal.t.e(boolD2, "get(...)");
        boolean zBooleanValue2 = boolD2.booleanValue();
        Boolean boolD3 = bf.b.B.d(iA0);
        kotlin.jvm.internal.t.e(boolD3, "get(...)");
        boolean zBooleanValue3 = boolD3.booleanValue();
        Boolean boolD4 = bf.b.E.d(iA0);
        kotlin.jvm.internal.t.e(boolD4, "get(...)");
        boolean zBooleanValue4 = boolD4.booleanValue();
        Boolean boolD5 = bf.b.F.d(iA0);
        kotlin.jvm.internal.t.e(boolD5, "get(...)");
        boolean zBooleanValue5 = boolD5.booleanValue();
        Boolean boolD6 = bf.b.G.d(iA0);
        kotlin.jvm.internal.t.e(boolD6, "get(...)");
        int i10 = iA0;
        vf.n0 n0Var = new vf.n0(mVarE, null, hVarJ, e0VarB, uVarA, zBooleanValue, fVarB, aVarB, zBooleanValue2, zBooleanValue3, zBooleanValue4, zBooleanValue5, boolD6.booleanValue(), proto, this.f21978a.g(), this.f21978a.j(), this.f21978a.k(), this.f21978a.d());
        p pVar2 = this.f21978a;
        List listM0 = proto.m0();
        kotlin.jvm.internal.t.e(listM0, "getTypeParameterList(...)");
        p pVarB = p.b(pVar2, n0Var, listM0, null, null, null, null, 60, null);
        Boolean boolD7 = bf.b.f3340z.d(i10);
        kotlin.jvm.internal.t.e(boolD7, "get(...)");
        boolean zBooleanValue6 = boolD7.booleanValue();
        ge.h hVarO = (zBooleanValue6 && bf.f.h(proto)) ? o(proto, d.PROPERTY_GETTER) : ge.h.L.b();
        xf.r0 r0VarU2 = pVarB.i().u(bf.f.n(proto, this.f21978a.j()));
        List listM = pVarB.i().m();
        b1 b1VarL = l();
        ze.q qVarL = bf.f.l(proto, this.f21978a.j());
        b1 b1VarI = (qVarL == null || (r0VarU = pVarB.i().u(qVarL)) == null) ? null : jf.h.i(n0Var, r0VarU, hVarO);
        List listD = bf.f.d(proto, this.f21978a.j());
        ArrayList arrayList = new ArrayList(dd.s.u(listD, 10));
        int i11 = 0;
        for (Object obj : listD) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                dd.r.t();
            }
            arrayList.add(A((ze.q) obj, pVarB, n0Var, i11));
            i11 = i12;
        }
        n0Var.b1(r0VarU2, listM, b1VarL, b1VarI, arrayList);
        Boolean boolD8 = bf.b.f3317c.d(i10);
        kotlin.jvm.internal.t.e(boolD8, "get(...)");
        boolean zBooleanValue7 = boolD8.booleanValue();
        b.d dVar3 = bf.b.f3318d;
        ze.x xVar = (ze.x) dVar3.d(i10);
        b.d dVar4 = bf.b.f3319e;
        int iB = bf.b.b(zBooleanValue7, xVar, (ze.k) dVar4.d(i10), false, false, false);
        if (zBooleanValue6) {
            int iB0 = proto.p0() ? proto.b0() : iB;
            Boolean boolD9 = bf.b.K.d(iB0);
            kotlin.jvm.internal.t.e(boolD9, "get(...)");
            boolean zBooleanValue8 = boolD9.booleanValue();
            Boolean boolD10 = bf.b.L.d(iB0);
            kotlin.jvm.internal.t.e(boolD10, "get(...)");
            boolean zBooleanValue9 = boolD10.booleanValue();
            Boolean boolD11 = bf.b.M.d(iB0);
            kotlin.jvm.internal.t.e(boolD11, "get(...)");
            boolean zBooleanValue10 = boolD11.booleanValue();
            ge.h hVarJ2 = j(proto, iB0, d.PROPERTY_GETTER);
            if (zBooleanValue8) {
                o0 o0Var2 = o0.f22025a;
                dVar = dVar3;
                pVar = pVarB;
                dVar2 = dVar4;
                l0VarD = new ie.l0(n0Var, hVarJ2, o0Var2.b((ze.k) dVar4.d(iB0)), p0.a(o0Var2, (ze.x) dVar3.d(iB0)), !zBooleanValue8, zBooleanValue9, zBooleanValue10, n0Var.h(), null, g1.f9483a);
            } else {
                pVar = pVarB;
                dVar = dVar3;
                dVar2 = dVar4;
                l0VarD = jf.h.d(n0Var, hVarJ2);
                kotlin.jvm.internal.t.c(l0VarD);
            }
            l0VarD.P0(n0Var.getReturnType());
        } else {
            pVar = pVarB;
            dVar = dVar3;
            dVar2 = dVar4;
            l0VarD = null;
        }
        if (bf.b.A.d(i10).booleanValue()) {
            if (proto.w0()) {
                iB = proto.i0();
            }
            int i13 = iB;
            Boolean boolD12 = bf.b.K.d(i13);
            kotlin.jvm.internal.t.e(boolD12, "get(...)");
            boolean zBooleanValue11 = boolD12.booleanValue();
            Boolean boolD13 = bf.b.L.d(i13);
            kotlin.jvm.internal.t.e(boolD13, "get(...)");
            boolean zBooleanValue12 = boolD13.booleanValue();
            Boolean boolD14 = bf.b.M.d(i13);
            kotlin.jvm.internal.t.e(boolD14, "get(...)");
            boolean zBooleanValue13 = boolD14.booleanValue();
            d dVar5 = d.PROPERTY_SETTER;
            ge.h hVarJ3 = j(proto, i13, dVar5);
            if (zBooleanValue11) {
                o0 o0Var3 = o0.f22025a;
                l0Var = l0VarD;
                z10 = true;
                ie.m0 m0Var2 = new ie.m0(n0Var, hVarJ3, o0Var3.b((ze.k) dVar2.d(i13)), p0.a(o0Var3, (ze.x) dVar.d(i13)), !zBooleanValue11, zBooleanValue12, zBooleanValue13, n0Var.h(), null, g1.f9483a);
                m0Var = m0Var2;
                m0Var.Q0((s1) dd.a0.v0(p.b(pVar, m0Var2, dd.r.k(), null, null, null, null, 60, null).f().B(dd.q.e(proto.j0()), proto, dVar5)));
            } else {
                l0Var = l0VarD;
                z10 = true;
                ie.m0 m0VarE = jf.h.e(n0Var, hVarJ3, ge.h.L.b());
                kotlin.jvm.internal.t.c(m0VarE);
                m0Var = m0VarE;
            }
        } else {
            l0Var = l0VarD;
            z10 = true;
            m0Var = null;
        }
        if (bf.b.D.d(i10).booleanValue()) {
            n0Var.L0(new c0(this, proto, n0Var));
        }
        fe.m mVarE2 = this.f21978a.e();
        fe.e eVar = mVarE2 instanceof fe.e ? (fe.e) mVarE2 : null;
        if ((eVar != null ? eVar.h() : null) == fe.f.f9477f) {
            n0Var.L0(new d0(this, proto, n0Var));
        }
        n0Var.V0(l0Var, m0Var, new ie.r(m(proto, false), n0Var), new ie.r(m(proto, z10), n0Var));
        return n0Var;
    }

    public final k1 z(ze.r proto) {
        kotlin.jvm.internal.t.f(proto, "proto");
        h.a aVar = ge.h.L;
        List<ze.b> listQ = proto.Q();
        kotlin.jvm.internal.t.e(listQ, "getAnnotationList(...)");
        ArrayList arrayList = new ArrayList(dd.s.u(listQ, 10));
        for (ze.b bVar : listQ) {
            g gVar = this.f21979b;
            kotlin.jvm.internal.t.c(bVar);
            arrayList.add(gVar.a(bVar, this.f21978a.g()));
        }
        vf.p0 p0Var = new vf.p0(this.f21978a.h(), this.f21978a.e(), aVar.a(arrayList), l0.b(this.f21978a.g(), proto.W()), p0.a(o0.f22025a, (ze.x) bf.b.f3318d.d(proto.V())), proto, this.f21978a.g(), this.f21978a.j(), this.f21978a.k(), this.f21978a.d());
        p pVar = this.f21978a;
        List listZ = proto.Z();
        kotlin.jvm.internal.t.e(listZ, "getTypeParameterList(...)");
        p pVarB = p.b(pVar, p0Var, listZ, null, null, null, null, 60, null);
        p0Var.W0(pVarB.i().m(), pVarB.i().o(bf.f.r(proto, this.f21978a.j()), false), pVarB.i().o(bf.f.e(proto, this.f21978a.j()), false));
        return p0Var;
    }
}
