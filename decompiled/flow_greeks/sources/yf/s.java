package yf;

import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.n0;
import xf.c1;
import xf.t1;
import yf.b;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f25429a = new s();

    @Override // bg.p
    public boolean A(bg.j jVar) {
        kotlin.jvm.internal.t.f(jVar, "<this>");
        return C0(f(jVar));
    }

    @Override // bg.p
    public bg.t A0(bg.o oVar) {
        return b.a.z(this, oVar);
    }

    @Override // bg.p
    public bg.n B(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        bg.j jVarH = h(iVar);
        if (jVarH == null) {
            jVarH = m(iVar);
        }
        return f(jVarH);
    }

    @Override // yf.b
    public bg.i B0(bg.j jVar, bg.j jVar2) {
        return b.a.l(this, jVar, jVar2);
    }

    @Override // bg.p
    public bg.f C(bg.g gVar) {
        b.a.f(this, gVar);
        return null;
    }

    @Override // bg.p
    public boolean C0(bg.n nVar) {
        return b.a.F(this, nVar);
    }

    @Override // bg.p
    public boolean D(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        bg.g gVarK0 = k0(iVar);
        if (gVarK0 == null) {
            return false;
        }
        C(gVarK0);
        return false;
    }

    @Override // bg.p
    public boolean D0(bg.i iVar) {
        return b.a.Q(this, iVar);
    }

    @Override // bg.p
    public bg.o E(bg.n nVar, int i10) {
        return b.a.p(this, nVar, i10);
    }

    @Override // bg.p
    public bg.k E0(bg.j jVar) {
        bg.k kVarF0;
        kotlin.jvm.internal.t.f(jVar, "<this>");
        bg.e eVarT0 = t0(jVar);
        return (eVarT0 == null || (kVarF0 = F0(eVarT0)) == null) ? (bg.k) jVar : kVarF0;
    }

    @Override // bg.p
    public t1.c F(bg.j jVar) {
        return b.a.k0(this, jVar);
    }

    @Override // bg.p
    public bg.k F0(bg.e eVar) {
        return b.a.g0(this, eVar);
    }

    @Override // bg.p
    public bg.m G(bg.l lVar, int i10) {
        kotlin.jvm.internal.t.f(lVar, "<this>");
        if (lVar instanceof bg.k) {
            return S((bg.i) lVar, i10);
        }
        if (lVar instanceof bg.a) {
            E e10 = ((bg.a) lVar).get(i10);
            kotlin.jvm.internal.t.e(e10, "get(...)");
            return (bg.m) e10;
        }
        throw new IllegalStateException(("unknown type argument list type: " + lVar + ", " + n0.b(lVar.getClass())).toString());
    }

    @Override // bg.p
    public bg.i G0(bg.d dVar) {
        return b.a.d0(this, dVar);
    }

    @Override // bg.p
    public bg.i H(bg.m mVar) {
        return b.a.u(this, mVar);
    }

    @Override // xf.g2
    public bg.i H0(bg.i iVar) {
        bg.j jVarA;
        kotlin.jvm.internal.t.f(iVar, "<this>");
        bg.j jVarH = h(iVar);
        return (jVarH == null || (jVarA = a(jVarH, true)) == null) ? iVar : jVarA;
    }

    @Override // bg.p
    public boolean I(bg.j jVar) {
        kotlin.jvm.internal.t.f(jVar, "<this>");
        return o0(f(jVar));
    }

    @Override // bg.p
    public bg.l I0(bg.j jVar) {
        return b.a.c(this, jVar);
    }

    @Override // xf.g2
    public boolean J(bg.n nVar) {
        return b.a.b0(this, nVar);
    }

    @Override // bg.p
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public c1 k(bg.j jVar, bg.b bVar) {
        return b.a.j(this, jVar, bVar);
    }

    @Override // bg.p
    public boolean K(bg.n nVar, bg.n nVar2) {
        return b.a.a(this, nVar, nVar2);
    }

    public t1 K0(boolean z10, boolean z11) {
        return b.a.f0(this, z10, z11);
    }

    @Override // bg.p
    public int L(bg.n nVar) {
        return b.a.h0(this, nVar);
    }

    @Override // bg.p
    public boolean M(bg.d dVar) {
        return b.a.R(this, dVar);
    }

    @Override // bg.p
    public boolean N(bg.j jVar) {
        return b.a.Y(this, jVar);
    }

    @Override // xf.g2
    public boolean O(bg.i iVar, ef.c cVar) {
        return b.a.A(this, iVar, cVar);
    }

    @Override // xf.g2
    public bg.i P(bg.o oVar) {
        return b.a.t(this, oVar);
    }

    @Override // bg.p
    public boolean Q(bg.i iVar) {
        return b.a.U(this, iVar);
    }

    @Override // bg.p
    public List R(bg.i iVar) {
        return b.a.n(this, iVar);
    }

    @Override // bg.p
    public bg.m S(bg.i iVar, int i10) {
        return b.a.m(this, iVar, i10);
    }

    @Override // bg.p
    public bg.t T(bg.m mVar) {
        return b.a.y(this, mVar);
    }

    @Override // bg.p
    public bg.i U(bg.i iVar, boolean z10) {
        return b.a.e0(this, iVar, z10);
    }

    @Override // xf.g2
    public ef.d V(bg.n nVar) {
        return b.a.o(this, nVar);
    }

    @Override // xf.g2
    public ce.l W(bg.n nVar) {
        return b.a.r(this, nVar);
    }

    @Override // bg.p
    public bg.i X(bg.i iVar, boolean z10) {
        return b.a.p0(this, iVar, z10);
    }

    @Override // bg.p
    public boolean Y(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        bg.j jVarH = h(iVar);
        return (jVarH != null ? t0(jVarH) : null) != null;
    }

    @Override // bg.p
    public Collection Z(bg.j jVar) {
        return b.a.i0(this, jVar);
    }

    @Override // bg.p
    public Collection a0(bg.n nVar) {
        return b.a.l0(this, nVar);
    }

    @Override // yf.b, bg.p
    public boolean b(bg.j jVar) {
        return b.a.V(this, jVar);
    }

    @Override // bg.p
    public boolean b0(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        return n(m(iVar)) != n(z0(iVar));
    }

    @Override // yf.b, bg.p
    public boolean c(bg.m mVar) {
        return b.a.X(this, mVar);
    }

    @Override // bg.p
    public boolean c0(bg.n nVar) {
        return b.a.E(this, nVar);
    }

    @Override // bg.p
    public bg.i d0(Collection collection) {
        return b.a.D(this, collection);
    }

    @Override // bg.p
    public boolean e0(bg.n nVar) {
        return b.a.H(this, nVar);
    }

    @Override // yf.b, bg.p
    public bg.n f(bg.j jVar) {
        return b.a.n0(this, jVar);
    }

    @Override // bg.p
    public boolean f0(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        return !kotlin.jvm.internal.t.b(f(m(iVar)), f(z0(iVar)));
    }

    @Override // yf.b, bg.p
    public bg.d g(bg.k kVar) {
        return b.a.d(this, kVar);
    }

    @Override // bg.p
    public boolean g0(bg.n nVar) {
        return b.a.G(this, nVar);
    }

    @Override // bg.p
    public boolean h0(bg.n nVar) {
        return b.a.L(this, nVar);
    }

    @Override // bg.p
    public bg.d i(bg.j jVar) {
        kotlin.jvm.internal.t.f(jVar, "<this>");
        return g(E0(jVar));
    }

    @Override // xf.g2
    public bg.i i0(bg.i iVar) {
        return b.a.w(this, iVar);
    }

    @Override // xf.g2
    public ce.l j(bg.n nVar) {
        return b.a.s(this, nVar);
    }

    @Override // bg.r
    public boolean j0() {
        return b.a.M(this);
    }

    @Override // bg.p
    public bg.g k0(bg.i iVar) {
        return b.a.g(this, iVar);
    }

    @Override // bg.p
    public boolean l(bg.i iVar) {
        return b.a.O(this, iVar);
    }

    @Override // bg.p
    public List l0(bg.j jVar, bg.n constructor) {
        kotlin.jvm.internal.t.f(jVar, "<this>");
        kotlin.jvm.internal.t.f(constructor, "constructor");
        return null;
    }

    @Override // bg.p
    public bg.j m(bg.i iVar) {
        bg.j jVarD;
        kotlin.jvm.internal.t.f(iVar, "<this>");
        bg.g gVarK0 = k0(iVar);
        if (gVarK0 != null && (jVarD = d(gVarK0)) != null) {
            return jVarD;
        }
        bg.j jVarH = h(iVar);
        kotlin.jvm.internal.t.c(jVarH);
        return jVarH;
    }

    @Override // bg.p
    public boolean m0(bg.d dVar) {
        return b.a.T(this, dVar);
    }

    @Override // bg.p
    public boolean n(bg.i iVar) {
        return b.a.N(this, iVar);
    }

    @Override // bg.p
    public boolean n0(bg.n nVar) {
        return b.a.P(this, nVar);
    }

    @Override // bg.p
    public boolean o(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        bg.j jVarH = h(iVar);
        return (jVarH != null ? i(jVarH) : null) != null;
    }

    @Override // bg.p
    public boolean o0(bg.n nVar) {
        return b.a.K(this, nVar);
    }

    @Override // bg.p
    public boolean p(bg.j jVar) {
        kotlin.jvm.internal.t.f(jVar, "<this>");
        return t0(jVar) != null;
    }

    @Override // bg.p
    public bg.o p0(bg.n nVar) {
        return b.a.v(this, nVar);
    }

    @Override // bg.p
    public boolean q(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        return n0(B(iVar)) && !D0(iVar);
    }

    @Override // bg.p
    public bg.m q0(bg.c cVar) {
        return b.a.j0(this, cVar);
    }

    @Override // bg.p
    public List r(bg.o oVar) {
        return b.a.x(this, oVar);
    }

    @Override // bg.p
    public bg.m r0(bg.i iVar) {
        return b.a.i(this, iVar);
    }

    @Override // bg.p
    public bg.b s(bg.d dVar) {
        return b.a.k(this, dVar);
    }

    @Override // bg.p
    public boolean s0(bg.o oVar, bg.n nVar) {
        return b.a.B(this, oVar, nVar);
    }

    @Override // bg.p
    public List t(bg.n nVar) {
        return b.a.q(this, nVar);
    }

    @Override // bg.p
    public bg.e t0(bg.j jVar) {
        return b.a.e(this, jVar);
    }

    @Override // bg.s
    public boolean u(bg.j jVar, bg.j jVar2) {
        return b.a.C(this, jVar, jVar2);
    }

    @Override // bg.p
    public boolean u0(bg.k kVar) {
        return b.a.S(this, kVar);
    }

    @Override // bg.p
    public int v(bg.l lVar) {
        kotlin.jvm.internal.t.f(lVar, "<this>");
        if (lVar instanceof bg.j) {
            return y0((bg.i) lVar);
        }
        if (lVar instanceof bg.a) {
            return ((bg.a) lVar).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + lVar + ", " + n0.b(lVar.getClass())).toString());
    }

    @Override // bg.p
    public bg.i v0(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        return U(iVar, false);
    }

    @Override // xf.g2
    public boolean w(bg.n nVar) {
        return b.a.J(this, nVar);
    }

    @Override // bg.p
    public boolean w0(bg.i iVar) {
        return b.a.I(this, iVar);
    }

    @Override // bg.p
    public bg.c x(bg.d dVar) {
        return b.a.m0(this, dVar);
    }

    @Override // bg.p
    public boolean x0(bg.i iVar) {
        return b.a.a0(this, iVar);
    }

    @Override // bg.p
    public boolean y(bg.j jVar) {
        return b.a.Z(this, jVar);
    }

    @Override // bg.p
    public int y0(bg.i iVar) {
        return b.a.b(this, iVar);
    }

    @Override // bg.p
    public bg.m z(bg.j jVar, int i10) {
        kotlin.jvm.internal.t.f(jVar, "<this>");
        if (i10 < 0 || i10 >= y0(jVar)) {
            return null;
        }
        return S(jVar, i10);
    }

    @Override // bg.p
    public bg.j z0(bg.i iVar) {
        bg.j jVarE;
        kotlin.jvm.internal.t.f(iVar, "<this>");
        bg.g gVarK0 = k0(iVar);
        if (gVarK0 != null && (jVarE = e(gVarK0)) != null) {
            return jVarE;
        }
        bg.j jVarH = h(iVar);
        kotlin.jvm.internal.t.c(jVarH);
        return jVarH;
    }

    @Override // bg.p
    public bg.k a(bg.j jVar, boolean z10) {
        return b.a.q0(this, jVar, z10);
    }

    @Override // bg.p
    public bg.k d(bg.g gVar) {
        return b.a.c0(this, gVar);
    }

    @Override // bg.p
    public bg.k e(bg.g gVar) {
        return b.a.o0(this, gVar);
    }

    @Override // bg.p
    public bg.k h(bg.i iVar) {
        return b.a.h(this, iVar);
    }
}
