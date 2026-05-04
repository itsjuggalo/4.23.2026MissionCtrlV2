package x9;

import android.app.Application;
import android.util.DisplayMetrics;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f24693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f24694b;

    public l(g gVar, bd.a aVar) {
        this.f24693a = gVar;
        this.f24694b = aVar;
    }

    public static l a(g gVar, bd.a aVar) {
        return new l(gVar, aVar);
    }

    public static DisplayMetrics c(g gVar, Application application) {
        return (DisplayMetrics) t9.d.d(gVar.f(application));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DisplayMetrics get() {
        return c(this.f24693a, (Application) this.f24694b.get());
    }
}
