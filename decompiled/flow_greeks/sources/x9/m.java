package x9;

import android.util.DisplayMetrics;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f24695a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f24696b;

    public m(g gVar, bd.a aVar) {
        this.f24695a = gVar;
        this.f24696b = aVar;
    }

    public static m a(g gVar, bd.a aVar) {
        return new m(gVar, aVar);
    }

    public static u9.k c(g gVar, DisplayMetrics displayMetrics) {
        return (u9.k) t9.d.d(gVar.g(displayMetrics));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u9.k get() {
        return c(this.f24695a, (DisplayMetrics) this.f24696b.get());
    }
}
