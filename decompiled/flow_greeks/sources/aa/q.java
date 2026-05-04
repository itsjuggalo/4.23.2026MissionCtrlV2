package aa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f553a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f554b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f555c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f556d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f557e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bd.a f558f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bd.a f559g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final bd.a f560h;

    public q(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7, bd.a aVar8) {
        this.f553a = aVar;
        this.f554b = aVar2;
        this.f555c = aVar3;
        this.f556d = aVar4;
        this.f557e = aVar5;
        this.f558f = aVar6;
        this.f559g = aVar7;
        this.f560h = aVar8;
    }

    public static q a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7, bd.a aVar8) {
        return new q(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8);
    }

    public static p c(s0 s0Var, da.a aVar, k3 k3Var, i3 i3Var, k kVar, ea.m mVar, m2 m2Var, n nVar) {
        return new p(s0Var, aVar, k3Var, i3Var, kVar, mVar, m2Var, nVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public p get() {
        return c((s0) this.f553a.get(), (da.a) this.f554b.get(), (k3) this.f555c.get(), (i3) this.f556d.get(), (k) this.f557e.get(), (ea.m) this.f558f.get(), (m2) this.f559g.get(), (n) this.f560h.get());
    }
}
