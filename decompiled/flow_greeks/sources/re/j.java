package re;

import dd.r;
import fe.t0;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.t;
import re.p;
import se.d0;
import ve.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j implements t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f19857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wf.a f19858b;

    public j(d components) {
        t.f(components, "components");
        k kVar = new k(components, p.a.f19870a, cd.m.c(null));
        this.f19857a = kVar;
        this.f19858b = kVar.e().c();
    }

    public static final d0 f(j jVar, u uVar) {
        return new d0(jVar.f19857a, uVar);
    }

    @Override // fe.t0
    public boolean a(ef.c fqName) {
        t.f(fqName, "fqName");
        return oe.t.a(this.f19857a.a().d(), fqName, false, 2, null) == null;
    }

    @Override // fe.t0
    public void b(ef.c fqName, Collection packageFragments) {
        t.f(fqName, "fqName");
        t.f(packageFragments, "packageFragments");
        hg.a.a(packageFragments, e(fqName));
    }

    @Override // fe.o0
    public List c(ef.c fqName) {
        t.f(fqName, "fqName");
        return r.o(e(fqName));
    }

    public final d0 e(ef.c cVar) {
        u uVarA = oe.t.a(this.f19857a.a().d(), cVar, false, 2, null);
        if (uVarA == null) {
            return null;
        }
        return (d0) this.f19858b.a(cVar, new i(this, uVarA));
    }

    @Override // fe.o0
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public List t(ef.c fqName, pd.k nameFilter) {
        t.f(fqName, "fqName");
        t.f(nameFilter, "nameFilter");
        d0 d0VarE = e(fqName);
        List listQ0 = d0VarE != null ? d0VarE.Q0() : null;
        return listQ0 == null ? r.k() : listQ0;
    }

    public String toString() {
        return "LazyJavaPackageFragmentProvider of module " + this.f19857a.a().m();
    }
}
