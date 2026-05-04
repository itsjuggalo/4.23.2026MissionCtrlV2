package t4;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f20803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f20804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f20805c;

    public w0(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        this.f20803a = aVar;
        this.f20804b = aVar2;
        this.f20805c = aVar3;
    }

    public static w0 a(bd.a aVar, bd.a aVar2, bd.a aVar3) {
        return new w0(aVar, aVar2, aVar3);
    }

    public static v0 c(Context context, String str, int i10) {
        return new v0(context, str, i10);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v0 get() {
        return c((Context) this.f20803a.get(), (String) this.f20804b.get(), ((Integer) this.f20805c.get()).intValue());
    }
}
