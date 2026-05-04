package ua;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements wa.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f22517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f22518b;

    public b0(bd.a aVar, bd.a aVar2) {
        this.f22517a = aVar;
        this.f22518b = aVar2;
    }

    public static b0 a(bd.a aVar, bd.a aVar2) {
        return new b0(aVar, aVar2);
    }

    public static a0 c(Context context, y0 y0Var) {
        return new a0(context, y0Var);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a0 get() {
        return c((Context) this.f22517a.get(), (y0) this.f22518b.get());
    }
}
