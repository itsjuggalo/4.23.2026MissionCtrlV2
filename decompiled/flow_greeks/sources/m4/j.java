package m4;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class j implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f15870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f15871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f15872c;

    public j(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f15870a = aVar;
        this.f15871b = aVar2;
        this.f15872c = aVar3;
    }

    public static j a(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new j(aVar, aVar2, aVar3);
    }

    public static i c(Context context, v4.a aVar, v4.a aVar2) {
        return new i(context, aVar, aVar2);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public i get() {
        return c((Context) this.f15870a.get(), (v4.a) this.f15871b.get(), (v4.a) this.f15872c.get());
    }
}
