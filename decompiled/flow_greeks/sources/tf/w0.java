package tf;

import fe.k1;
import fe.l1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import xf.a2;
import xf.c1;
import xf.c2;
import xf.g1;
import xf.h1;
import xf.j1;
import xf.m2;
import xf.p1;
import xf.q1;
import xf.u1;
import xf.y;
import ze.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f22066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0 f22067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f22068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f22069d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final pd.k f22070e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final pd.k f22071f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map f22072g;

    public w0(p c10, w0 w0Var, List typeParameterProtos, String debugName, String containerPresentableName) {
        Map linkedHashMap;
        kotlin.jvm.internal.t.f(c10, "c");
        kotlin.jvm.internal.t.f(typeParameterProtos, "typeParameterProtos");
        kotlin.jvm.internal.t.f(debugName, "debugName");
        kotlin.jvm.internal.t.f(containerPresentableName, "containerPresentableName");
        this.f22066a = c10;
        this.f22067b = w0Var;
        this.f22068c = debugName;
        this.f22069d = containerPresentableName;
        this.f22070e = c10.h().h(new r0(this));
        this.f22071f = c10.h().h(new s0(this));
        if (typeParameterProtos.isEmpty()) {
            linkedHashMap = dd.o0.h();
        } else {
            linkedHashMap = new LinkedHashMap();
            Iterator it = typeParameterProtos.iterator();
            int i10 = 0;
            while (it.hasNext()) {
                ze.s sVar = (ze.s) it.next();
                linkedHashMap.put(Integer.valueOf(sVar.M()), new vf.r0(this.f22066a, sVar, i10));
                i10++;
            }
        }
        this.f22072g = linkedHashMap;
    }

    public static final int A(ze.q it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it.U();
    }

    public static final fe.h f(w0 w0Var, int i10) {
        return w0Var.g(i10);
    }

    public static final List p(ze.q qVar, w0 w0Var) {
        List listV = qVar.V();
        kotlin.jvm.internal.t.e(listV, "getArgumentList(...)");
        ze.q qVarJ = bf.f.j(qVar, w0Var.f22066a.j());
        List listP = qVarJ != null ? p(qVarJ, w0Var) : null;
        if (listP == null) {
            listP = dd.r.k();
        }
        return dd.a0.s0(listV, listP);
    }

    public static /* synthetic */ c1 q(w0 w0Var, ze.q qVar, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return w0Var.o(qVar, z10);
    }

    public static final List r(w0 w0Var, ze.q qVar) {
        return w0Var.f22066a.c().d().g(qVar, w0Var.f22066a.g());
    }

    public static final fe.h v(w0 w0Var, int i10) {
        return w0Var.i(i10);
    }

    public static final fe.e y(w0 w0Var, ze.q qVar, int i10) {
        ef.b bVarA = l0.a(w0Var.f22066a.g(), i10);
        List listN = jg.t.N(jg.t.E(jg.q.n(qVar, new u0(w0Var)), v0.f22064a));
        int iV = jg.t.v(jg.q.n(bVarA, new kotlin.jvm.internal.g0() { // from class: tf.w0.a
            @Override // kotlin.jvm.internal.g0, wd.o
            public Object get(Object obj) {
                return ((ef.b) obj).e();
            }
        }));
        while (listN.size() < iV) {
            listN.add(0);
        }
        return w0Var.f22066a.c().r().d(bVarA, listN);
    }

    public static final ze.q z(w0 w0Var, ze.q it) {
        kotlin.jvm.internal.t.f(it, "it");
        return bf.f.j(it, w0Var.f22066a.j());
    }

    public final fe.h g(int i10) {
        ef.b bVarA = l0.a(this.f22066a.g(), i10);
        return bVarA.i() ? this.f22066a.c().b(bVarA) : fe.y.c(this.f22066a.c().q(), bVarA);
    }

    public final c1 h(int i10) {
        if (l0.a(this.f22066a.g(), i10).i()) {
            return this.f22066a.c().o().a();
        }
        return null;
    }

    public final fe.h i(int i10) {
        ef.b bVarA = l0.a(this.f22066a.g(), i10);
        if (bVarA.i()) {
            return null;
        }
        return fe.y.f(this.f22066a.c().q(), bVarA);
    }

    public final c1 j(xf.r0 r0Var, xf.r0 r0Var2) {
        ce.i iVarN = cg.d.n(r0Var);
        ge.h annotations = r0Var.getAnnotations();
        xf.r0 r0VarK = ce.h.k(r0Var);
        List listE = ce.h.e(r0Var);
        List listU = dd.a0.U(ce.h.m(r0Var), 1);
        ArrayList arrayList = new ArrayList(dd.s.u(listU, 10));
        Iterator it = listU.iterator();
        while (it.hasNext()) {
            arrayList.add(((a2) it.next()).getType());
        }
        return ce.h.b(iVarN, annotations, r0VarK, listE, arrayList, null, r0Var2, true).R0(r0Var.O0());
    }

    public final c1 k(q1 q1Var, u1 u1Var, List list, boolean z10) {
        List list2;
        c1 c1VarL;
        int size;
        int size2 = u1Var.getParameters().size() - list.size();
        if (size2 != 0) {
            c1VarL = null;
            if (size2 == 1 && (size = list.size() - 1) >= 0) {
                u1 u1VarK = u1Var.p().Y(size).k();
                kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
                list2 = list;
                c1VarL = xf.u0.k(q1Var, u1VarK, list2, z10, null, 16, null);
            } else {
                list2 = list;
            }
        } else {
            list2 = list;
            c1VarL = l(q1Var, u1Var, list2, z10);
        }
        return c1VarL == null ? zf.l.f26552a.f(zf.k.W, list2, u1Var, new String[0]) : c1VarL;
    }

    public final c1 l(q1 q1Var, u1 u1Var, List list, boolean z10) {
        c1 c1VarK = xf.u0.k(q1Var, u1Var, list, z10, null, 16, null);
        if (ce.h.q(c1VarK)) {
            return t(c1VarK);
        }
        return null;
    }

    public final List m() {
        return dd.a0.I0(this.f22072g.values());
    }

    public final l1 n(int i10) {
        l1 l1Var = (l1) this.f22072g.get(Integer.valueOf(i10));
        if (l1Var != null) {
            return l1Var;
        }
        w0 w0Var = this.f22067b;
        if (w0Var != null) {
            return w0Var.n(i10);
        }
        return null;
    }

    public final c1 o(ze.q proto, boolean z10) {
        c1 c1VarC;
        c1 c1VarJ;
        kotlin.jvm.internal.t.f(proto, "proto");
        c1 c1VarH = proto.l0() ? h(proto.W()) : proto.t0() ? h(proto.g0()) : null;
        if (c1VarH != null) {
            return c1VarH;
        }
        u1 u1VarX = x(proto);
        if (zf.l.m(u1VarX.b())) {
            return zf.l.f26552a.c(zf.k.B0, u1VarX, u1VarX.toString());
        }
        vf.a aVar = new vf.a(this.f22066a.h(), new t0(this, proto));
        q1 q1VarS = s(this.f22066a.c().v(), aVar, u1VarX, this.f22066a.e());
        List listP = p(proto, this);
        ArrayList arrayList = new ArrayList(dd.s.u(listP, 10));
        int i10 = 0;
        for (Object obj : listP) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                dd.r.t();
            }
            List parameters = u1VarX.getParameters();
            kotlin.jvm.internal.t.e(parameters, "getParameters(...)");
            arrayList.add(w((l1) dd.a0.c0(parameters, i10), (q.b) obj));
            i10 = i11;
        }
        List listI0 = dd.a0.I0(arrayList);
        fe.h hVarB = u1VarX.b();
        if (z10 && (hVarB instanceof k1)) {
            c1 c1VarC2 = xf.u0.c((k1) hVarB, listI0);
            c1VarC = c1VarC2.R0(xf.v0.b(c1VarC2) || proto.d0()).T0(s(this.f22066a.c().v(), ge.h.L.a(dd.a0.q0(aVar, c1VarC2.getAnnotations())), u1VarX, this.f22066a.e()));
        } else if (bf.b.f3315a.d(proto.Z()).booleanValue()) {
            c1VarC = k(q1VarS, u1VarX, listI0, proto.d0());
        } else {
            c1 c1VarK = xf.u0.k(q1VarS, u1VarX, listI0, proto.d0(), null, 16, null);
            if (bf.b.f3316b.d(proto.Z()).booleanValue()) {
                c1VarC = y.a.c(xf.y.f25097d, c1VarK, true, false, 4, null);
                if (c1VarC == null) {
                    throw new IllegalStateException(("null DefinitelyNotNullType for '" + c1VarK + '\'').toString());
                }
            } else {
                c1VarC = c1VarK;
            }
        }
        ze.q qVarA = bf.f.a(proto, this.f22066a.j());
        return (qVarA == null || (c1VarJ = g1.j(c1VarC, o(qVarA, false))) == null) ? c1VarC : c1VarJ;
    }

    public final q1 s(List list, ge.h hVar, u1 u1Var, fe.m mVar) {
        ArrayList arrayList = new ArrayList(dd.s.u(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((p1) it.next()).a(hVar, u1Var, mVar));
        }
        return q1.f25042b.j(dd.s.w(arrayList));
    }

    public final c1 t(xf.r0 r0Var) {
        xf.r0 type;
        a2 a2Var = (a2) dd.a0.m0(ce.h.m(r0Var));
        if (a2Var == null || (type = a2Var.getType()) == null) {
            return null;
        }
        fe.h hVarB = type.N0().b();
        ef.c cVarO = hVarB != null ? nf.e.o(hVarB) : null;
        if (type.L0().size() != 1 || (!kotlin.jvm.internal.t.b(cVarO, ce.o.f3968v) && !kotlin.jvm.internal.t.b(cVarO, x0.f22075a))) {
            return (c1) r0Var;
        }
        xf.r0 type2 = ((a2) dd.a0.v0(type.L0())).getType();
        kotlin.jvm.internal.t.e(type2, "getType(...)");
        fe.m mVarE = this.f22066a.e();
        fe.a aVar = mVarE instanceof fe.a ? (fe.a) mVarE : null;
        return kotlin.jvm.internal.t.b(aVar != null ? nf.e.k(aVar) : null, q0.f22047a) ? j(r0Var, type2) : j(r0Var, type2);
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f22068c);
        if (this.f22067b == null) {
            str = "";
        } else {
            str = ". Child of " + this.f22067b.f22068c;
        }
        sb2.append(str);
        return sb2.toString();
    }

    public final xf.r0 u(ze.q proto) {
        kotlin.jvm.internal.t.f(proto, "proto");
        if (!proto.n0()) {
            return o(proto, true);
        }
        String string = this.f22066a.g().getString(proto.a0());
        c1 c1VarQ = q(this, proto, false, 2, null);
        ze.q qVarF = bf.f.f(proto, this.f22066a.j());
        kotlin.jvm.internal.t.c(qVarF);
        return this.f22066a.c().m().a(proto, string, c1VarQ, q(this, qVarF, false, 2, null));
    }

    public final a2 w(l1 l1Var, q.b bVar) {
        if (bVar.x() == q.b.c.STAR) {
            return l1Var == null ? new h1(this.f22066a.c().q().p()) : new j1(l1Var);
        }
        o0 o0Var = o0.f22025a;
        q.b.c cVarX = bVar.x();
        kotlin.jvm.internal.t.e(cVarX, "getProjection(...)");
        m2 m2VarC = o0Var.c(cVarX);
        ze.q qVarP = bf.f.p(bVar, this.f22066a.j());
        return qVarP == null ? new c2(zf.l.d(zf.k.G0, bVar.toString())) : new c2(m2VarC, u(qVarP));
    }

    public final u1 x(ze.q qVar) {
        fe.h hVarY;
        Object next;
        if (qVar.l0()) {
            hVarY = (fe.h) this.f22070e.invoke(Integer.valueOf(qVar.W()));
            if (hVarY == null) {
                hVarY = y(this, qVar, qVar.W());
            }
        } else if (qVar.u0()) {
            hVarY = n(qVar.h0());
            if (hVarY == null) {
                return zf.l.f26552a.e(zf.k.U, String.valueOf(qVar.h0()), this.f22069d);
            }
        } else if (qVar.v0()) {
            String string = this.f22066a.g().getString(qVar.i0());
            Iterator it = m().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if (kotlin.jvm.internal.t.b(((l1) next).getName().b(), string)) {
                    break;
                }
            }
            hVarY = (l1) next;
            if (hVarY == null) {
                return zf.l.f26552a.e(zf.k.V, string, this.f22066a.e().toString());
            }
        } else {
            if (!qVar.t0()) {
                return zf.l.f26552a.e(zf.k.Y, new String[0]);
            }
            hVarY = (fe.h) this.f22071f.invoke(Integer.valueOf(qVar.g0()));
            if (hVarY == null) {
                hVarY = y(this, qVar, qVar.g0());
            }
        }
        u1 u1VarK = hVarY.k();
        kotlin.jvm.internal.t.e(u1VarK, "getTypeConstructor(...)");
        return u1VarK;
    }
}
