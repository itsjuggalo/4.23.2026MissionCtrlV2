package aa;

import ib.g;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i0 implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f477a;

    public i0(bd.a aVar) {
        this.f477a = aVar;
    }

    public static i0 a(bd.a aVar) {
        return new i0(aVar);
    }

    public static h0 c(g.b bVar) {
        return new h0(bVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public h0 get() {
        return c((g.b) this.f477a.get());
    }
}
