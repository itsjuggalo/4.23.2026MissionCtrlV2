package aa;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f505c;

    public l(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f503a = aVar;
        this.f504b = aVar2;
        this.f505c = aVar3;
    }

    public static l a(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new l(aVar, aVar2, aVar3);
    }

    public static k c(q2 q2Var, Application application, da.a aVar) {
        return new k(q2Var, application, aVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c((q2) this.f503a.get(), (Application) this.f504b.get(), (da.a) this.f505c.get());
    }
}
