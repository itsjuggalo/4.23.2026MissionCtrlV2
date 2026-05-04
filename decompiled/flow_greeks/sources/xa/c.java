package xa;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f24711a;

    public c(bd.a aVar) {
        this.f24711a = aVar;
    }

    public static c a(bd.a aVar) {
        return new c(aVar);
    }

    public static b c(Context context) {
        return new b(context);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b get() {
        return c((Context) this.f24711a.get());
    }
}
