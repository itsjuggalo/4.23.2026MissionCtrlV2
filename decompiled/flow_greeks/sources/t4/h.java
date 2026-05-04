package t4;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f20750a;

    public h(bd.a aVar) {
        this.f20750a = aVar;
    }

    public static h a(bd.a aVar) {
        return new h(aVar);
    }

    public static String c(Context context) {
        return (String) n4.d.d(f.b(context));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public String get() {
        return c((Context) this.f20750a.get());
    }
}
