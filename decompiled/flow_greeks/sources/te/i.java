package te;

import cd.q;
import cd.w;
import dd.s;
import fe.l1;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import xf.a2;
import xf.c1;
import xf.c2;
import xf.d2;
import xf.f0;
import xf.h2;
import xf.l0;
import xf.m2;
import xf.q1;
import xf.r0;
import xf.u0;
import xf.u1;
import xf.v0;
import xf.z1;
import zf.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends d2 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f21922e = new a(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final te.a f21923f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final te.a f21924g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f21925c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final z1 f21926d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    static {
        h2 h2Var = h2.f24979b;
        f21923f = b.b(h2Var, false, true, null, 5, null).l(c.f21904c);
        f21924g = b.b(h2Var, false, true, null, 5, null).l(c.f21903b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(z1 z1Var) {
        g gVar = new g();
        this.f21925c = gVar;
        if (z1Var == null) {
            z1Var = new z1(gVar, null, 2, 0 == true ? 1 : 0);
        }
        this.f21926d = z1Var;
    }

    public static final c1 k(fe.e eVar, i iVar, c1 c1Var, te.a aVar, yf.g kotlinTypeRefiner) {
        fe.e eVarB;
        t.f(kotlinTypeRefiner, "kotlinTypeRefiner");
        ef.b bVarN = nf.e.n(eVar);
        if (bVarN == null || (eVarB = kotlinTypeRefiner.b(bVarN)) == null || t.b(eVarB, eVar)) {
            return null;
        }
        return (c1) iVar.j(c1Var, eVarB, aVar).c();
    }

    public static /* synthetic */ r0 m(i iVar, r0 r0Var, te.a aVar, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            aVar = new te.a(h2.f24979b, null, false, false, null, null, 62, null);
        }
        return iVar.l(r0Var, aVar);
    }

    @Override // xf.d2
    public boolean f() {
        return false;
    }

    public final q j(c1 c1Var, fe.e eVar, te.a aVar) {
        if (c1Var.N0().getParameters().isEmpty()) {
            return w.a(c1Var, Boolean.FALSE);
        }
        if (ce.i.d0(c1Var)) {
            a2 a2Var = (a2) c1Var.L0().get(0);
            m2 m2VarB = a2Var.b();
            r0 type = a2Var.getType();
            t.e(type, "getType(...)");
            return w.a(u0.k(c1Var.M0(), c1Var.N0(), dd.q.e(new c2(m2VarB, l(type, aVar))), c1Var.O0(), null, 16, null), Boolean.FALSE);
        }
        if (v0.a(c1Var)) {
            return w.a(l.d(zf.k.R, c1Var.N0().toString()), Boolean.FALSE);
        }
        qf.k kVarH0 = eVar.h0(this);
        t.e(kVarH0, "getMemberScope(...)");
        q1 q1VarM0 = c1Var.M0();
        u1 u1VarK = eVar.k();
        t.e(u1VarK, "getTypeConstructor(...)");
        List<l1> parameters = eVar.k().getParameters();
        t.e(parameters, "getParameters(...)");
        ArrayList arrayList = new ArrayList(s.u(parameters, 10));
        for (l1 l1Var : parameters) {
            g gVar = this.f21925c;
            t.c(l1Var);
            arrayList.add(f0.b(gVar, l1Var, aVar, this.f21926d, null, 8, null));
        }
        return w.a(u0.n(q1VarM0, u1VarK, arrayList, c1Var.O0(), kVarH0, new h(eVar, this, c1Var, aVar)), Boolean.TRUE);
    }

    public final r0 l(r0 r0Var, te.a aVar) {
        fe.h hVarB = r0Var.N0().b();
        if (hVarB instanceof l1) {
            return l(this.f21926d.e((l1) hVarB, aVar.j(true)), aVar);
        }
        if (!(hVarB instanceof fe.e)) {
            throw new IllegalStateException(("Unexpected declaration kind: " + hVarB).toString());
        }
        fe.h hVarB2 = l0.d(r0Var).N0().b();
        if (hVarB2 instanceof fe.e) {
            q qVarJ = j(l0.c(r0Var), (fe.e) hVarB, f21923f);
            c1 c1Var = (c1) qVarJ.a();
            boolean zBooleanValue = ((Boolean) qVarJ.b()).booleanValue();
            q qVarJ2 = j(l0.d(r0Var), (fe.e) hVarB2, f21924g);
            c1 c1Var2 = (c1) qVarJ2.a();
            return (zBooleanValue || ((Boolean) qVarJ2.b()).booleanValue()) ? new k(c1Var, c1Var2) : u0.e(c1Var, c1Var2);
        }
        throw new IllegalStateException(("For some reason declaration for upper bound is not a class but \"" + hVarB2 + "\" while for lower it's \"" + hVarB + '\"').toString());
    }

    @Override // xf.d2
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public c2 e(r0 key) {
        t.f(key, "key");
        return new c2(m(this, key, null, 2, null));
    }

    public /* synthetic */ i(z1 z1Var, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : z1Var);
    }
}
