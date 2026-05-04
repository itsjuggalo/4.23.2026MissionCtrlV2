package we;

import xf.i2;
import xf.k2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n1 extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ge.a f24017a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f24018b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final re.k f24019c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final oe.c f24020d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f24021e;

    public /* synthetic */ n1(ge.a aVar, boolean z10, re.k kVar, oe.c cVar, boolean z11, int i10, kotlin.jvm.internal.k kVar2) {
        this(aVar, z10, kVar, cVar, (i10 & 16) != 0 ? false : z11);
    }

    @Override // we.d
    public boolean B(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        return ce.i.f0((xf.r0) iVar);
    }

    @Override // we.d
    public boolean C() {
        return this.f24018b;
    }

    @Override // we.d
    public boolean D(bg.i iVar, bg.i other) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        kotlin.jvm.internal.t.f(other, "other");
        return this.f24019c.a().k().b((xf.r0) iVar, (xf.r0) other);
    }

    @Override // we.d
    public boolean E(bg.o oVar) {
        kotlin.jvm.internal.t.f(oVar, "<this>");
        return oVar instanceof se.b1;
    }

    @Override // we.d
    public boolean F(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        return ((xf.r0) iVar).Q0() instanceof j;
    }

    @Override // we.d
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public boolean l(ge.c cVar, bg.i iVar) {
        kotlin.jvm.internal.t.f(cVar, "<this>");
        if ((cVar instanceof qe.g) && ((qe.g) cVar).d()) {
            return true;
        }
        if ((cVar instanceof se.j) && !u() && (((se.j) cVar).m() || q() == oe.c.f17948f)) {
            return true;
        }
        return iVar != null && ce.i.r0((xf.r0) iVar) && m().p(cVar) && !this.f24019c.a().q().c();
    }

    @Override // we.d
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public oe.d m() {
        return this.f24019c.a().a();
    }

    @Override // we.d
    /* JADX INFO: renamed from: L, reason: merged with bridge method [inline-methods] */
    public xf.r0 v(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        return k2.a((xf.r0) iVar);
    }

    @Override // we.d
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public bg.r A() {
        return yf.s.f25429a;
    }

    @Override // we.d
    public Iterable n(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        return ((xf.r0) iVar).getAnnotations();
    }

    @Override // we.d
    public Iterable p() {
        ge.h annotations;
        ge.a aVar = this.f24017a;
        return (aVar == null || (annotations = aVar.getAnnotations()) == null) ? dd.r.k() : annotations;
    }

    @Override // we.d
    public oe.c q() {
        return this.f24020d;
    }

    @Override // we.d
    public oe.e0 r() {
        return this.f24019c.b();
    }

    @Override // we.d
    public boolean s() {
        ge.a aVar = this.f24017a;
        return (aVar instanceof fe.s1) && ((fe.s1) aVar).j0() != null;
    }

    @Override // we.d
    public l t(l lVar, oe.w wVar) {
        l lVarB;
        if (lVar != null && (lVarB = l.b(lVar, k.f23994c, false, 2, null)) != null) {
            return lVarB;
        }
        if (wVar != null) {
            return wVar.d();
        }
        return null;
    }

    @Override // we.d
    public boolean u() {
        return this.f24019c.a().q().d();
    }

    @Override // we.d
    public ef.d x(bg.i iVar) {
        kotlin.jvm.internal.t.f(iVar, "<this>");
        fe.e eVarF = i2.f((xf.r0) iVar);
        if (eVarF != null) {
            return jf.i.m(eVarF);
        }
        return null;
    }

    @Override // we.d
    public boolean z() {
        return this.f24021e;
    }

    public n1(ge.a aVar, boolean z10, re.k containerContext, oe.c containerApplicabilityType, boolean z11) {
        kotlin.jvm.internal.t.f(containerContext, "containerContext");
        kotlin.jvm.internal.t.f(containerApplicabilityType, "containerApplicabilityType");
        this.f24017a = aVar;
        this.f24018b = z10;
        this.f24019c = containerContext;
        this.f24020d = containerApplicabilityType;
        this.f24021e = z11;
    }
}
