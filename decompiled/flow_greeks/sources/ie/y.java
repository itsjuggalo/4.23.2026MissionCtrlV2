package ie;

import fe.b1;
import fe.g1;
import fe.l1;
import fe.q1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import xf.c1;
import xf.d2;
import xf.f2;
import xf.i2;
import xf.m2;
import xf.u1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class y extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final z f12508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f2 f12509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public f2 f12510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f12511e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List f12512f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public u1 f12513g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements pd.k {
        public a() {
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Boolean invoke(l1 l1Var) {
            return Boolean.valueOf(!l1Var.m0());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements pd.k {
        public b() {
        }

        @Override // pd.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public c1 invoke(c1 c1Var) {
            return y.this.M0(c1Var);
        }
    }

    public y(z zVar, f2 f2Var) {
        this.f12508b = zVar;
        this.f12509c = f2Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static /* synthetic */ void z0(int r15) {
        /*
            Method dump skipped, instruction units count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ie.y.z0(int):void");
    }

    @Override // fe.e
    public qf.k D0() {
        qf.k kVarI = I(nf.e.r(jf.i.g(this.f12508b)));
        if (kVarI == null) {
            z0(12);
        }
        return kVarI;
    }

    @Override // fe.e
    public boolean E() {
        return this.f12508b.E();
    }

    @Override // fe.d0
    public boolean E0() {
        return this.f12508b.E0();
    }

    @Override // fe.e
    public List G0() {
        List list = Collections.EMPTY_LIST;
        if (list == null) {
            z0(17);
        }
        return list;
    }

    @Override // fe.e
    public boolean H0() {
        return this.f12508b.H0();
    }

    @Override // ie.z
    public qf.k I(yf.g gVar) {
        if (gVar == null) {
            z0(13);
        }
        qf.k kVarI = this.f12508b.I(gVar);
        if (!this.f12509c.k()) {
            return new qf.t(kVarI, K0());
        }
        if (kVarI == null) {
            z0(14);
        }
        return kVarI;
    }

    @Override // fe.e
    public b1 J0() {
        throw new UnsupportedOperationException();
    }

    @Override // fe.e
    public Collection K() {
        Collection collectionK = this.f12508b.K();
        if (collectionK == null) {
            z0(31);
        }
        return collectionK;
    }

    public final f2 K0() {
        if (this.f12510d == null) {
            if (this.f12509c.k()) {
                this.f12510d = this.f12509c;
            } else {
                List parameters = this.f12508b.k().getParameters();
                this.f12511e = new ArrayList(parameters.size());
                this.f12510d = xf.c0.b(parameters, this.f12509c.j(), this, this.f12511e);
                this.f12512f = dd.a0.V(this.f12511e, new a());
            }
        }
        return this.f12510d;
    }

    @Override // fe.i1
    /* JADX INFO: renamed from: L0, reason: merged with bridge method [inline-methods] */
    public fe.e c(f2 f2Var) {
        if (f2Var == null) {
            z0(23);
        }
        return f2Var.k() ? this : new y(this, f2.h(f2Var.j(), K0().j()));
    }

    public final c1 M0(c1 c1Var) {
        return (c1Var == null || this.f12509c.k()) ? c1Var : (c1) K0().p(c1Var, m2.f25015e);
    }

    @Override // fe.d0
    public boolean N() {
        return this.f12508b.N();
    }

    @Override // fe.i
    public boolean P() {
        return this.f12508b.P();
    }

    @Override // fe.e
    public fe.d S() {
        return this.f12508b.S();
    }

    @Override // fe.e
    public qf.k T() {
        qf.k kVarT = this.f12508b.T();
        if (kVarT == null) {
            z0(15);
        }
        return kVarT;
    }

    @Override // fe.e
    public fe.e V() {
        return this.f12508b.V();
    }

    @Override // fe.e, fe.n, fe.m
    public fe.m b() {
        fe.m mVarB = this.f12508b.b();
        if (mVarB == null) {
            z0(22);
        }
        return mVarB;
    }

    @Override // ge.a
    public ge.h getAnnotations() {
        ge.h annotations = this.f12508b.getAnnotations();
        if (annotations == null) {
            z0(19);
        }
        return annotations;
    }

    @Override // fe.j0
    public ef.f getName() {
        ef.f name = this.f12508b.getName();
        if (name == null) {
            z0(20);
        }
        return name;
    }

    @Override // fe.e, fe.d0, fe.q
    public fe.u getVisibility() {
        fe.u visibility = this.f12508b.getVisibility();
        if (visibility == null) {
            z0(27);
        }
        return visibility;
    }

    @Override // fe.e
    public fe.f h() {
        fe.f fVarH = this.f12508b.h();
        if (fVarH == null) {
            z0(25);
        }
        return fVarH;
    }

    @Override // fe.e
    public qf.k h0(d2 d2Var) {
        if (d2Var == null) {
            z0(10);
        }
        qf.k kVarW = w(d2Var, nf.e.r(jf.i.g(this)));
        if (kVarW == null) {
            z0(11);
        }
        return kVarW;
    }

    @Override // fe.d0
    public boolean isExternal() {
        return this.f12508b.isExternal();
    }

    @Override // fe.e
    public boolean isInline() {
        return this.f12508b.isInline();
    }

    @Override // fe.p
    public g1 j() {
        g1 g1Var = g1.f9483a;
        if (g1Var == null) {
            z0(29);
        }
        return g1Var;
    }

    @Override // fe.h
    public u1 k() {
        u1 u1VarK = this.f12508b.k();
        if (this.f12509c.k()) {
            if (u1VarK == null) {
                z0(0);
            }
            return u1VarK;
        }
        if (this.f12513g == null) {
            f2 f2VarK0 = K0();
            Collection collectionC = u1VarK.c();
            ArrayList arrayList = new ArrayList(collectionC.size());
            Iterator it = collectionC.iterator();
            while (it.hasNext()) {
                arrayList.add(f2VarK0.p((xf.r0) it.next(), m2.f25015e));
            }
            this.f12513g = new xf.u(this, this.f12511e, arrayList, wf.f.f24060e);
        }
        u1 u1Var = this.f12513g;
        if (u1Var == null) {
            z0(1);
        }
        return u1Var;
    }

    @Override // fe.e, fe.d0
    public fe.e0 l() {
        fe.e0 e0VarL = this.f12508b.l();
        if (e0VarL == null) {
            z0(26);
        }
        return e0VarL;
    }

    @Override // fe.e
    public Collection m() {
        Collection<fe.d> collectionM = this.f12508b.m();
        ArrayList arrayList = new ArrayList(collectionM.size());
        for (fe.d dVar : collectionM) {
            arrayList.add(((fe.d) dVar.u().r(dVar.a()).s(dVar.l()).d(dVar.getVisibility()).m(dVar.h()).i(false).build()).c(K0()));
        }
        return arrayList;
    }

    @Override // fe.e
    public boolean n() {
        return this.f12508b.n();
    }

    @Override // fe.e, fe.h
    public c1 s() {
        c1 c1VarM = xf.u0.m(xf.x.f25092a.a(getAnnotations(), null, null), k(), i2.g(k().getParameters()), false, D0());
        if (c1VarM == null) {
            z0(16);
        }
        return c1VarM;
    }

    @Override // fe.m
    public Object t0(fe.o oVar, Object obj) {
        return oVar.h(this, obj);
    }

    @Override // fe.e, fe.i
    public List v() {
        K0();
        List list = this.f12512f;
        if (list == null) {
            z0(30);
        }
        return list;
    }

    @Override // ie.z
    public qf.k w(d2 d2Var, yf.g gVar) {
        if (d2Var == null) {
            z0(5);
        }
        if (gVar == null) {
            z0(6);
        }
        qf.k kVarW = this.f12508b.w(d2Var, gVar);
        if (!this.f12509c.k()) {
            return new qf.t(kVarW, K0());
        }
        if (kVarW == null) {
            z0(7);
        }
        return kVarW;
    }

    @Override // fe.e
    public qf.k x0() {
        qf.k kVarX0 = this.f12508b.x0();
        if (kVarX0 == null) {
            z0(28);
        }
        return kVarX0;
    }

    @Override // fe.e
    public boolean y() {
        return this.f12508b.y();
    }

    @Override // fe.e
    public q1 y0() {
        q1 q1VarY0 = this.f12508b.y0();
        if (q1VarY0 == null) {
            return null;
        }
        return q1VarY0.b(new b());
    }

    @Override // fe.m
    public fe.e a() {
        fe.e eVarA = this.f12508b.a();
        if (eVarA == null) {
            z0(21);
        }
        return eVarA;
    }
}
