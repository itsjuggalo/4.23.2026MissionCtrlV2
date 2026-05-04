package i9;

import g9.b1;
import i9.m;
import j9.p;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o f11991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f11992b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f11993c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f11994d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11995e = 100;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public double f11996f = 2.0d;

    public final g8.c a(Iterable iterable, g9.b1 b1Var, p.a aVar) {
        g8.c cVarH = this.f11991a.h(b1Var, aVar);
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            j9.h hVar = (j9.h) it.next();
            cVarH = cVarH.q(hVar.getKey(), hVar);
        }
        return cVarH;
    }

    public final g8.e b(g9.b1 b1Var, g8.c cVar) {
        g8.e eVar = new g8.e(Collections.EMPTY_LIST, b1Var.c());
        Iterator it = cVar.iterator();
        while (it.hasNext()) {
            j9.h hVar = (j9.h) ((Map.Entry) it.next()).getValue();
            if (b1Var.u(hVar)) {
                eVar = eVar.e(hVar);
            }
        }
        return eVar;
    }

    public final void c(g9.b1 b1Var, i1 i1Var, int i10) {
        if (i1Var.a() < this.f11995e) {
            n9.v.a("QueryEngine", "SDK will not create cache indexes for query: %s, since it only creates cache indexes for collection contains more than or equal to %s documents.", b1Var.toString(), Integer.valueOf(this.f11995e));
            return;
        }
        n9.v.a("QueryEngine", "Query: %s, scans %s local documents and returns %s documents as results.", b1Var.toString(), Integer.valueOf(i1Var.a()), Integer.valueOf(i10));
        if (i1Var.a() > this.f11996f * ((double) i10)) {
            this.f11992b.n(b1Var.D());
            n9.v.a("QueryEngine", "The SDK decides to create cache indexes for query: %s, as using cache indexes may help improve performance.", b1Var.toString());
        }
    }

    public final g8.c d(g9.b1 b1Var, i1 i1Var) {
        if (n9.v.c()) {
            n9.v.a("QueryEngine", "Using full collection scan to execute query: %s", b1Var.toString());
        }
        return this.f11991a.i(b1Var, p.a.f14250a, i1Var);
    }

    public g8.c e(g9.b1 b1Var, j9.v vVar, g8.e eVar) {
        n9.b.d(this.f11993c, "initialize() not called", new Object[0]);
        g8.c cVarH = h(b1Var);
        if (cVarH != null) {
            return cVarH;
        }
        g8.c cVarI = i(b1Var, eVar, vVar);
        if (cVarI != null) {
            return cVarI;
        }
        i1 i1Var = new i1();
        g8.c cVarD = d(b1Var, i1Var);
        if (cVarD != null && this.f11994d) {
            c(b1Var, i1Var, cVarD.size());
        }
        return cVarD;
    }

    public void f(o oVar, m mVar) {
        this.f11991a = oVar;
        this.f11992b = mVar;
        this.f11993c = true;
    }

    public final boolean g(g9.b1 b1Var, int i10, g8.e eVar, j9.v vVar) {
        if (!b1Var.p()) {
            return false;
        }
        if (i10 != eVar.size()) {
            return true;
        }
        j9.h hVar = b1Var.l() == b1.a.LIMIT_TO_FIRST ? (j9.h) eVar.a() : (j9.h) eVar.c();
        if (hVar == null) {
            return false;
        }
        return hVar.e() || hVar.k().compareTo(vVar) > 0;
    }

    public final g8.c h(g9.b1 b1Var) {
        if (b1Var.v()) {
            return null;
        }
        g9.g1 g1VarD = b1Var.D();
        m.a aVarA = this.f11992b.a(g1VarD);
        if (aVarA.equals(m.a.NONE)) {
            return null;
        }
        if (b1Var.p() && aVarA.equals(m.a.PARTIAL)) {
            return h(b1Var.s(-1L));
        }
        List listM = this.f11992b.m(g1VarD);
        n9.b.d(listM != null, "index manager must return results for partial and full indexes.", new Object[0]);
        g8.c cVarD = this.f11991a.d(listM);
        p.a aVarC = this.f11992b.c(g1VarD);
        g8.e eVarB = b(b1Var, cVarD);
        return g(b1Var, listM.size(), eVarB, aVarC.m()) ? h(b1Var.s(-1L)) : a(eVarB, b1Var, aVarC);
    }

    public final g8.c i(g9.b1 b1Var, g8.e eVar, j9.v vVar) {
        if (b1Var.v() || vVar.equals(j9.v.f14278b)) {
            return null;
        }
        g8.e eVarB = b(b1Var, this.f11991a.d(eVar));
        if (g(b1Var, eVar.size(), eVarB, vVar)) {
            return null;
        }
        if (n9.v.c()) {
            n9.v.a("QueryEngine", "Re-using previous result from %s to execute query: %s", vVar.toString(), b1Var.toString());
        }
        return a(eVarB, b1Var, p.a.h(vVar, -1));
    }

    public void j(boolean z10) {
        this.f11994d = z10;
    }
}
