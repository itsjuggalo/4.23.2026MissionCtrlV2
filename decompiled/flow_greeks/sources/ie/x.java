package ie;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qf.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class x extends m implements fe.u0 {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ wd.m[] f12499h = {kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(x.class, "fragments", "getFragments()Ljava/util/List;", 0)), kotlin.jvm.internal.n0.g(new kotlin.jvm.internal.g0(x.class, "empty", "getEmpty()Z", 0))};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f0 f12500c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ef.c f12501d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final wf.i f12502e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final wf.i f12503f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final qf.k f12504g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(f0 module, ef.c fqName, wf.n storageManager) {
        super(ge.h.L.b(), fqName.g());
        kotlin.jvm.internal.t.f(module, "module");
        kotlin.jvm.internal.t.f(fqName, "fqName");
        kotlin.jvm.internal.t.f(storageManager, "storageManager");
        this.f12500c = module;
        this.f12501d = fqName;
        this.f12502e = storageManager.e(new u(this));
        this.f12503f = storageManager.e(new v(this));
        this.f12504g = new qf.i(storageManager, new w(this));
    }

    public static final boolean L0(x xVar) {
        return fe.s0.b(xVar.u0().M0(), xVar.e());
    }

    public static final List M0(x xVar) {
        return fe.s0.c(xVar.u0().M0(), xVar.e());
    }

    public static final qf.k Q0(x xVar) {
        if (xVar.isEmpty()) {
            return k.b.f19087b;
        }
        List listJ = xVar.J();
        ArrayList arrayList = new ArrayList(dd.s.u(listJ, 10));
        Iterator it = listJ.iterator();
        while (it.hasNext()) {
            arrayList.add(((fe.n0) it.next()).q());
        }
        List listT0 = dd.a0.t0(arrayList, new p0(xVar.u0(), xVar.e()));
        return qf.b.f19040d.a("package view scope for " + xVar.e() + " in " + xVar.u0().getName(), listT0);
    }

    @Override // fe.u0
    public List J() {
        return (List) wf.m.a(this.f12502e, this, f12499h[0]);
    }

    @Override // fe.m
    /* JADX INFO: renamed from: N0, reason: merged with bridge method [inline-methods] */
    public fe.u0 b() {
        if (e().c()) {
            return null;
        }
        return u0().I0(e().d());
    }

    public final boolean O0() {
        return ((Boolean) wf.m.a(this.f12503f, this, f12499h[1])).booleanValue();
    }

    @Override // fe.u0
    /* JADX INFO: renamed from: P0, reason: merged with bridge method [inline-methods] */
    public f0 u0() {
        return this.f12500c;
    }

    @Override // fe.u0
    public ef.c e() {
        return this.f12501d;
    }

    public boolean equals(Object obj) {
        fe.u0 u0Var = obj instanceof fe.u0 ? (fe.u0) obj : null;
        return u0Var != null && kotlin.jvm.internal.t.b(e(), u0Var.e()) && kotlin.jvm.internal.t.b(u0(), u0Var.u0());
    }

    public int hashCode() {
        return (u0().hashCode() * 31) + e().hashCode();
    }

    @Override // fe.u0
    public boolean isEmpty() {
        return O0();
    }

    @Override // fe.u0
    public qf.k q() {
        return this.f12504g;
    }

    @Override // fe.m
    public Object t0(fe.o visitor, Object obj) {
        kotlin.jvm.internal.t.f(visitor, "visitor");
        return visitor.j(this, obj);
    }
}
