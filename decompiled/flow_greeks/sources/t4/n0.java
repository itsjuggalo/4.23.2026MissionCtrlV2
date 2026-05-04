package t4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f20772a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f20773b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f20774c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f20775d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f20776e;

    public n0(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        this.f20772a = aVar;
        this.f20773b = aVar2;
        this.f20774c = aVar3;
        this.f20775d = aVar4;
        this.f20776e = aVar5;
    }

    public static n0 a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        return new n0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static m0 c(v4.a aVar, v4.a aVar2, Object obj, Object obj2, bd.a aVar3) {
        return new m0(aVar, aVar2, (e) obj, (v0) obj2, aVar3);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public m0 get() {
        return c((v4.a) this.f20772a.get(), (v4.a) this.f20773b.get(), this.f20774c.get(), this.f20775d.get(), this.f20776e);
    }
}
