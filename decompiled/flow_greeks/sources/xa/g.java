package xa;

import ua.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f24741a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f24742b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f24743c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f24744d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f24745e;

    public g(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        this.f24741a = aVar;
        this.f24742b = aVar2;
        this.f24743c = aVar3;
        this.f24744d = aVar4;
        this.f24745e = aVar5;
    }

    public static g a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        return new g(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static d c(w0 w0Var, ga.h hVar, ua.b bVar, a aVar, l lVar) {
        return new d(w0Var, hVar, bVar, aVar, lVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d get() {
        return c((w0) this.f24741a.get(), (ga.h) this.f24742b.get(), (ua.b) this.f24743c.get(), (a) this.f24744d.get(), (l) this.f24745e.get());
    }
}
