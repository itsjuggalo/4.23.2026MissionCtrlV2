package x9;

import android.app.Application;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f24676a;

    public b(a aVar) {
        this.f24676a = aVar;
    }

    public static b a(a aVar) {
        return new b(aVar);
    }

    public static Application c(a aVar) {
        return (Application) t9.d.d(aVar.a());
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Application get() {
        return c(this.f24676a);
    }
}
