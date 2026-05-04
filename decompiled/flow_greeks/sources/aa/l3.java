package aa;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l3 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f512c;

    public l3(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f510a = aVar;
        this.f511b = aVar2;
        this.f512c = aVar3;
    }

    public static l3 a(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new l3(aVar, aVar2, aVar3);
    }

    public static k3 c(cc.r rVar, cc.r rVar2, cc.r rVar3) {
        return new k3(rVar, rVar2, rVar3);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k3 get() {
        return c((cc.r) this.f510a.get(), (cc.r) this.f511b.get(), (cc.r) this.f512c.get());
    }
}
