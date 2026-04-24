package g1;

import k1.InterfaceC1567a;

/* JADX INFO: renamed from: g1.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1261g implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f11916a;

    public C1261g(V2.a aVar) {
        this.f11916a = aVar;
    }

    public static h1.f a(InterfaceC1567a interfaceC1567a) {
        return (h1.f) c1.d.d(AbstractC1260f.a(interfaceC1567a));
    }

    public static C1261g b(V2.a aVar) {
        return new C1261g(aVar);
    }

    @Override // V2.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public h1.f get() {
        return a((InterfaceC1567a) this.f11916a.get());
    }
}
