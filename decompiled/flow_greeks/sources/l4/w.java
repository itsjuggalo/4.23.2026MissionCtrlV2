package l4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f15425a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f15426b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f15427c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f15428d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f15429e;

    public w(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        this.f15425a = aVar;
        this.f15426b = aVar2;
        this.f15427c = aVar3;
        this.f15428d = aVar4;
        this.f15429e = aVar5;
    }

    public static w a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        return new w(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static u c(v4.a aVar, v4.a aVar2, r4.e eVar, s4.r rVar, s4.v vVar) {
        return new u(aVar, aVar2, eVar, rVar, vVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c((v4.a) this.f15425a.get(), (v4.a) this.f15426b.get(), (r4.e) this.f15427c.get(), (s4.r) this.f15428d.get(), (s4.v) this.f15429e.get());
    }
}
