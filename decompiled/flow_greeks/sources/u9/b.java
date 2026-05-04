package u9;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22427a;

    public b(bd.a aVar) {
        this.f22427a = aVar;
    }

    public static b a(bd.a aVar) {
        return new b(aVar);
    }

    public static a c(Application application) {
        return new a(application);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a get() {
        return c((Application) this.f22427a.get());
    }
}
