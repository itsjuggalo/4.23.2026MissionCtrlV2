package qf;

import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import dd.a0;
import fe.f1;
import fe.y0;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends l {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f19090f = {n0.g(new g0(q.class, "functions", "getFunctions()Ljava/util/List;", 0)), n0.g(new g0(q.class, DiagnosticsEntry.PROPERTIES_KEY, "getProperties()Ljava/util/List;", 0))};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final fe.e f19091b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19092c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final wf.i f19093d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.i f19094e;

    public q(wf.n storageManager, fe.e containingClass, boolean z10) {
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        kotlin.jvm.internal.t.f(containingClass, "containingClass");
        this.f19091b = containingClass;
        this.f19092c = z10;
        containingClass.h();
        fe.f fVar = fe.f.f9473b;
        this.f19093d = storageManager.e(new o(this));
        this.f19094e = storageManager.e(new p(this));
    }

    public static final List j(q qVar) {
        return dd.r.n(jf.h.g(qVar.f19091b), jf.h.h(qVar.f19091b));
    }

    public static final List p(q qVar) {
        return qVar.f19092c ? dd.r.o(jf.h.f(qVar.f19091b)) : dd.r.k();
    }

    @Override // qf.l, qf.k
    public Collection a(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        List listO = o();
        hg.k kVar = new hg.k();
        for (Object obj : listO) {
            if (kotlin.jvm.internal.t.b(((y0) obj).getName(), name)) {
                kVar.add(obj);
            }
        }
        return kVar;
    }

    @Override // qf.l, qf.n
    public /* bridge */ /* synthetic */ fe.h e(ef.f fVar, ne.b bVar) {
        return (fe.h) k(fVar, bVar);
    }

    public Void k(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        return null;
    }

    @Override // qf.l, qf.n
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public List g(d kindFilter, pd.k nameFilter) {
        kotlin.jvm.internal.t.f(kindFilter, "kindFilter");
        kotlin.jvm.internal.t.f(nameFilter, "nameFilter");
        return a0.s0(n(), o());
    }

    @Override // qf.l, qf.k
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public hg.k c(ef.f name, ne.b location) {
        kotlin.jvm.internal.t.f(name, "name");
        kotlin.jvm.internal.t.f(location, "location");
        List listN = n();
        hg.k kVar = new hg.k();
        for (Object obj : listN) {
            if (kotlin.jvm.internal.t.b(((f1) obj).getName(), name)) {
                kVar.add(obj);
            }
        }
        return kVar;
    }

    public final List n() {
        return (List) wf.m.a(this.f19093d, this, f19090f[0]);
    }

    public final List o() {
        return (List) wf.m.a(this.f19094e, this, f19090f[1]);
    }
}
