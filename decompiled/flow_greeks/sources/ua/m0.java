package ua;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f22626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f22627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f22628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f22629e;

    public m0(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        this.f22625a = aVar;
        this.f22626b = aVar2;
        this.f22627c = aVar3;
        this.f22628d = aVar4;
        this.f22629e = aVar5;
    }

    public static m0 a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        return new m0(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static l0 c(a7.g gVar, ga.h hVar, xa.j jVar, h hVar2, gd.i iVar) {
        return new l0(gVar, hVar, jVar, hVar2, iVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public l0 get() {
        return c((a7.g) this.f22625a.get(), (ga.h) this.f22626b.get(), (xa.j) this.f22627c.get(), (h) this.f22628d.get(), (gd.i) this.f22629e.get());
    }
}
