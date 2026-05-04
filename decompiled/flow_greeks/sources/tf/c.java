package tf;

import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c implements fe.t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final wf.n f21932a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a0 f21933b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fe.h0 f21934c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public n f21935d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.h f21936e;

    public c(wf.n storageManager, a0 finder, fe.h0 moduleDescriptor) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(finder, "finder");
        kotlin.jvm.internal.t.f(moduleDescriptor, "moduleDescriptor");
        this.f21932a = storageManager;
        this.f21933b = finder;
        this.f21934c = moduleDescriptor;
        this.f21936e = storageManager.h(new b(this));
    }

    public static final fe.n0 f(c cVar, ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        r rVarE = cVar.e(fqName);
        if (rVarE == null) {
            return null;
        }
        rVarE.L0(cVar.g());
        return rVarE;
    }

    @Override // fe.t0
    public boolean a(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return (this.f21936e.i(fqName) ? (fe.n0) this.f21936e.invoke(fqName) : e(fqName)) == null;
    }

    @Override // fe.t0
    public void b(ef.c fqName, Collection packageFragments) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(packageFragments, "packageFragments");
        hg.a.a(packageFragments, this.f21936e.invoke(fqName));
    }

    @Override // fe.o0
    public List c(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        return dd.r.o(this.f21936e.invoke(fqName));
    }

    public abstract r e(ef.c cVar);

    public final n g() {
        n nVar = this.f21935d;
        if (nVar != null) {
            return nVar;
        }
        kotlin.jvm.internal.t.s("components");
        return null;
    }

    public final a0 h() {
        return this.f21933b;
    }

    public final fe.h0 i() {
        return this.f21934c;
    }

    public final wf.n j() {
        return this.f21932a;
    }

    public final void k(n nVar) {
        kotlin.jvm.internal.t.f(nVar, "<set-?>");
        this.f21935d = nVar;
    }

    @Override // fe.o0
    public Collection t(ef.c fqName, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        return dd.u0.d();
    }
}
