package J6;

import I6.AbstractC0613d0;
import I6.u0;
import J6.b;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f4670a = new s();

    @Override // M6.p
    public M6.g A(M6.i iVar) {
        return b.a.g(this, iVar);
    }

    @Override // M6.p
    public boolean A0(M6.j jVar) {
        return b.a.Z(this, jVar);
    }

    @Override // M6.p
    public M6.m B(M6.i iVar, int i8) {
        return b.a.m(this, iVar, i8);
    }

    @Override // M6.p
    public boolean B0(M6.i iVar) {
        AbstractC2304t.f(iVar, "<this>");
        M6.j jVarB = b(iVar);
        return (jVarB != null ? X(jVarB) : null) != null;
    }

    @Override // M6.p
    public int C(M6.l lVar) {
        AbstractC2304t.f(lVar, "<this>");
        if (lVar instanceof M6.j) {
            return F((M6.i) lVar);
        }
        if (lVar instanceof M6.a) {
            return ((M6.a) lVar).size();
        }
        throw new IllegalStateException(("unknown type argument list type: " + lVar + ", " + O.b(lVar.getClass())).toString());
    }

    @Override // M6.p
    public M6.k C0(M6.e eVar) {
        return b.a.g0(this, eVar);
    }

    @Override // M6.p
    public M6.i D(M6.i iVar) {
        AbstractC2304t.f(iVar, "<this>");
        return O(iVar, false);
    }

    @Override // M6.p
    public boolean D0(M6.i iVar) {
        AbstractC2304t.f(iVar, "<this>");
        M6.g gVarA = A(iVar);
        if (gVarA == null) {
            return false;
        }
        H(gVarA);
        return false;
    }

    @Override // M6.p
    public List E(M6.j jVar, M6.n constructor) {
        AbstractC2304t.f(jVar, "<this>");
        AbstractC2304t.f(constructor, "constructor");
        return null;
    }

    @Override // M6.p
    public boolean E0(M6.j jVar) {
        AbstractC2304t.f(jVar, "<this>");
        return P(a(jVar));
    }

    @Override // M6.p
    public int F(M6.i iVar) {
        return b.a.b(this, iVar);
    }

    @Override // I6.H0
    public M6.i F0(M6.o oVar) {
        return b.a.t(this, oVar);
    }

    @Override // M6.p
    public boolean G(M6.i iVar) {
        return b.a.I(this, iVar);
    }

    @Override // M6.p
    public M6.i G0(M6.d dVar) {
        return b.a.d0(this, dVar);
    }

    @Override // M6.p
    public M6.f H(M6.g gVar) {
        b.a.f(this, gVar);
        return null;
    }

    @Override // M6.p
    public M6.j H0(M6.i iVar) {
        M6.j jVarD;
        AbstractC2304t.f(iVar, "<this>");
        M6.g gVarA = A(iVar);
        if (gVarA != null && (jVarD = d(gVarA)) != null) {
            return jVarD;
        }
        M6.j jVarB = b(iVar);
        AbstractC2304t.c(jVarB);
        return jVarB;
    }

    @Override // M6.p
    public Collection I(M6.n nVar) {
        return b.a.l0(this, nVar);
    }

    @Override // M6.p
    public boolean I0(M6.i iVar) {
        AbstractC2304t.f(iVar, "<this>");
        return w(J(iVar)) && !l(iVar);
    }

    @Override // M6.p
    public M6.n J(M6.i iVar) {
        AbstractC2304t.f(iVar, "<this>");
        M6.j jVarB = b(iVar);
        if (jVarB == null) {
            jVarB = H0(iVar);
        }
        return a(jVarB);
    }

    @Override // M6.p
    /* JADX INFO: renamed from: J0, reason: merged with bridge method [inline-methods] */
    public AbstractC0613d0 u0(M6.j jVar, M6.b bVar) {
        return b.a.j(this, jVar, bVar);
    }

    @Override // I6.H0
    public M6.i K(M6.i iVar) {
        return b.a.w(this, iVar);
    }

    public u0 K0(boolean z7, boolean z8) {
        return b.a.f0(this, z7, z8);
    }

    @Override // M6.p
    public M6.i L(M6.m mVar) {
        return b.a.u(this, mVar);
    }

    @Override // M6.p
    public int M(M6.n nVar) {
        return b.a.h0(this, nVar);
    }

    @Override // M6.p
    public M6.i N(M6.i iVar, boolean z7) {
        return b.a.p0(this, iVar, z7);
    }

    @Override // M6.p
    public M6.i O(M6.i iVar, boolean z7) {
        return b.a.e0(this, iVar, z7);
    }

    @Override // M6.p
    public boolean P(M6.n nVar) {
        return b.a.F(this, nVar);
    }

    @Override // M6.p
    public boolean Q(M6.n nVar, M6.n nVar2) {
        return b.a.a(this, nVar, nVar2);
    }

    @Override // M6.p
    public boolean R(M6.j jVar) {
        AbstractC2304t.f(jVar, "<this>");
        return k0(jVar) != null;
    }

    @Override // M6.p
    public M6.l S(M6.j jVar) {
        return b.a.c(this, jVar);
    }

    @Override // M6.p
    public M6.t T(M6.m mVar) {
        return b.a.y(this, mVar);
    }

    @Override // M6.p
    public M6.i U(Collection collection) {
        return b.a.D(this, collection);
    }

    @Override // M6.p
    public boolean V(M6.i iVar) {
        return b.a.O(this, iVar);
    }

    @Override // M6.p
    public boolean W(M6.n nVar) {
        return b.a.L(this, nVar);
    }

    @Override // M6.p
    public M6.d X(M6.j jVar) {
        AbstractC2304t.f(jVar, "<this>");
        return g(e0(jVar));
    }

    @Override // M6.p
    public List Y(M6.i iVar) {
        return b.a.n(this, iVar);
    }

    @Override // M6.p
    public M6.t Z(M6.o oVar) {
        return b.a.z(this, oVar);
    }

    @Override // J6.b, M6.p
    public M6.n a(M6.j jVar) {
        return b.a.n0(this, jVar);
    }

    @Override // M6.p
    public boolean a0(M6.i iVar) {
        return b.a.N(this, iVar);
    }

    @Override // M6.p
    public boolean b0(M6.d dVar) {
        return b.a.R(this, dVar);
    }

    @Override // M6.p
    public M6.o c0(M6.n nVar) {
        return b.a.v(this, nVar);
    }

    @Override // I6.H0
    public M6.i d0(M6.i iVar) {
        M6.j jVarH;
        AbstractC2304t.f(iVar, "<this>");
        M6.j jVarB = b(iVar);
        return (jVarB == null || (jVarH = h(jVarB, true)) == null) ? iVar : jVarH;
    }

    @Override // J6.b, M6.p
    public boolean e(M6.j jVar) {
        return b.a.V(this, jVar);
    }

    @Override // M6.p
    public M6.k e0(M6.j jVar) {
        M6.k kVarC0;
        AbstractC2304t.f(jVar, "<this>");
        M6.e eVarK0 = k0(jVar);
        return (eVarK0 == null || (kVarC0 = C0(eVarK0)) == null) ? (M6.k) jVar : kVarC0;
    }

    @Override // J6.b, M6.p
    public boolean f(M6.m mVar) {
        return b.a.X(this, mVar);
    }

    @Override // M6.r
    public boolean f0() {
        return b.a.M(this);
    }

    @Override // J6.b, M6.p
    public M6.d g(M6.k kVar) {
        return b.a.d(this, kVar);
    }

    @Override // M6.p
    public boolean g0(M6.n nVar) {
        return b.a.E(this, nVar);
    }

    @Override // M6.p
    public List h0(M6.o oVar) {
        return b.a.x(this, oVar);
    }

    @Override // M6.p
    public boolean i(M6.i iVar) {
        AbstractC2304t.f(iVar, "<this>");
        return !AbstractC2304t.b(a(H0(iVar)), a(w0(iVar)));
    }

    @Override // M6.p
    public M6.c i0(M6.d dVar) {
        return b.a.m0(this, dVar);
    }

    @Override // I6.H0
    public O5.l j(M6.n nVar) {
        return b.a.r(this, nVar);
    }

    @Override // M6.p
    public boolean j0(M6.n nVar) {
        return b.a.G(this, nVar);
    }

    @Override // M6.p
    public M6.o k(M6.n nVar, int i8) {
        return b.a.p(this, nVar, i8);
    }

    @Override // M6.p
    public M6.e k0(M6.j jVar) {
        return b.a.e(this, jVar);
    }

    @Override // M6.p
    public boolean l(M6.i iVar) {
        return b.a.Q(this, iVar);
    }

    @Override // M6.p
    public u0.c l0(M6.j jVar) {
        return b.a.k0(this, jVar);
    }

    @Override // M6.p
    public M6.m m(M6.c cVar) {
        return b.a.j0(this, cVar);
    }

    @Override // M6.p
    public boolean m0(M6.n nVar) {
        return b.a.H(this, nVar);
    }

    @Override // M6.p
    public boolean n(M6.i iVar) {
        AbstractC2304t.f(iVar, "<this>");
        M6.j jVarB = b(iVar);
        return (jVarB != null ? k0(jVarB) : null) != null;
    }

    @Override // M6.p
    public boolean n0(M6.i iVar) {
        return b.a.a0(this, iVar);
    }

    @Override // M6.p
    public boolean o(M6.j jVar) {
        AbstractC2304t.f(jVar, "<this>");
        return x(a(jVar));
    }

    @Override // M6.p
    public boolean o0(M6.k kVar) {
        return b.a.S(this, kVar);
    }

    @Override // M6.p
    public M6.m p(M6.l lVar, int i8) {
        AbstractC2304t.f(lVar, "<this>");
        if (lVar instanceof M6.k) {
            return B((M6.i) lVar, i8);
        }
        if (lVar instanceof M6.a) {
            E e8 = ((M6.a) lVar).get(i8);
            AbstractC2304t.e(e8, "get(...)");
            return (M6.m) e8;
        }
        throw new IllegalStateException(("unknown type argument list type: " + lVar + ", " + O.b(lVar.getClass())).toString());
    }

    @Override // I6.H0
    public boolean p0(M6.i iVar, q6.c cVar) {
        return b.a.A(this, iVar, cVar);
    }

    @Override // I6.H0
    public O5.l q(M6.n nVar) {
        return b.a.s(this, nVar);
    }

    @Override // M6.p
    public M6.b q0(M6.d dVar) {
        return b.a.k(this, dVar);
    }

    @Override // M6.p
    public boolean r(M6.i iVar) {
        AbstractC2304t.f(iVar, "<this>");
        return a0(H0(iVar)) != a0(w0(iVar));
    }

    @Override // M6.p
    public M6.m r0(M6.j jVar, int i8) {
        AbstractC2304t.f(jVar, "<this>");
        if (i8 < 0 || i8 >= F(jVar)) {
            return null;
        }
        return B(jVar, i8);
    }

    @Override // I6.H0
    public boolean s(M6.n nVar) {
        return b.a.b0(this, nVar);
    }

    @Override // M6.p
    public boolean s0(M6.i iVar) {
        return b.a.U(this, iVar);
    }

    @Override // M6.p
    public boolean t(M6.o oVar, M6.n nVar) {
        return b.a.B(this, oVar, nVar);
    }

    @Override // M6.p
    public M6.m t0(M6.i iVar) {
        return b.a.i(this, iVar);
    }

    @Override // M6.s
    public boolean u(M6.j jVar, M6.j jVar2) {
        return b.a.C(this, jVar, jVar2);
    }

    @Override // J6.b
    public M6.i v(M6.j jVar, M6.j jVar2) {
        return b.a.l(this, jVar, jVar2);
    }

    @Override // M6.p
    public Collection v0(M6.j jVar) {
        return b.a.i0(this, jVar);
    }

    @Override // M6.p
    public boolean w(M6.n nVar) {
        return b.a.P(this, nVar);
    }

    @Override // M6.p
    public M6.j w0(M6.i iVar) {
        M6.j jVarC;
        AbstractC2304t.f(iVar, "<this>");
        M6.g gVarA = A(iVar);
        if (gVarA != null && (jVarC = c(gVarA)) != null) {
            return jVarC;
        }
        M6.j jVarB = b(iVar);
        AbstractC2304t.c(jVarB);
        return jVarB;
    }

    @Override // M6.p
    public boolean x(M6.n nVar) {
        return b.a.K(this, nVar);
    }

    @Override // M6.p
    public boolean x0(M6.d dVar) {
        return b.a.T(this, dVar);
    }

    @Override // I6.H0
    public q6.d y(M6.n nVar) {
        return b.a.o(this, nVar);
    }

    @Override // I6.H0
    public boolean y0(M6.n nVar) {
        return b.a.J(this, nVar);
    }

    @Override // M6.p
    public List z(M6.n nVar) {
        return b.a.q(this, nVar);
    }

    @Override // M6.p
    public boolean z0(M6.j jVar) {
        return b.a.Y(this, jVar);
    }

    @Override // M6.p
    public M6.k b(M6.i iVar) {
        return b.a.h(this, iVar);
    }

    @Override // M6.p
    public M6.k c(M6.g gVar) {
        return b.a.o0(this, gVar);
    }

    @Override // M6.p
    public M6.k d(M6.g gVar) {
        return b.a.c0(this, gVar);
    }

    @Override // M6.p
    public M6.k h(M6.j jVar, boolean z7) {
        return b.a.q0(this, jVar, z7);
    }
}
