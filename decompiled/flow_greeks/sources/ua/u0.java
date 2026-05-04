package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class u0 implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22706a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f22707b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f22708c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f22709d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f22710e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bd.a f22711f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bd.a f22712g;

    public u0(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7) {
        this.f22706a = aVar;
        this.f22707b = aVar2;
        this.f22708c = aVar3;
        this.f22709d = aVar4;
        this.f22710e = aVar5;
        this.f22711f = aVar6;
        this.f22712g = aVar7;
    }

    public static u0 a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7) {
        return new u0(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static t0 c(xa.j jVar, n0 n0Var, k0 k0Var, w0 w0Var, l1.i iVar, w wVar, gd.i iVar2) {
        return new t0(jVar, n0Var, k0Var, w0Var, iVar, wVar, iVar2);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public t0 get() {
        return c((xa.j) this.f22706a.get(), (n0) this.f22707b.get(), (k0) this.f22708c.get(), (w0) this.f22709d.get(), (l1.i) this.f22710e.get(), (w) this.f22711f.get(), (gd.i) this.f22712g.get());
    }
}
