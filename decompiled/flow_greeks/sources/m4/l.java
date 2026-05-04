package m4;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f15878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f15879b;

    public l(bd.a aVar, bd.a aVar2) {
        this.f15878a = aVar;
        this.f15879b = aVar2;
    }

    public static l a(bd.a aVar, bd.a aVar2) {
        return new l(aVar, aVar2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c((Context) this.f15878a.get(), this.f15879b.get());
    }
}
