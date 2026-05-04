package ca;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class v implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f3805a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3806b;

    public v(u uVar, bd.a aVar) {
        this.f3805a = uVar;
        this.f3806b = aVar;
    }

    public static v a(u uVar, bd.a aVar) {
        return new v(uVar, aVar);
    }

    public static hc.a c(u uVar, Application application) {
        return (hc.a) r9.d.e(uVar.a(application));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public hc.a get() {
        return c(this.f3805a, (Application) this.f3806b.get());
    }
}
