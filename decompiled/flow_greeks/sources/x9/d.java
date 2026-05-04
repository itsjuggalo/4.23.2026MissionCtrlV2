package x9;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f24677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f24678b;

    public d(c cVar, bd.a aVar) {
        this.f24677a = cVar;
        this.f24678b = aVar;
    }

    public static d a(c cVar, bd.a aVar) {
        return new d(cVar, aVar);
    }

    public static com.bumptech.glide.k c(c cVar, Application application) {
        return (com.bumptech.glide.k) t9.d.d(cVar.a(application));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.bumptech.glide.k get() {
        return c(this.f24677a, (Application) this.f24678b.get());
    }
}
