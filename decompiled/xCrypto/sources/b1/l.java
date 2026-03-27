package b1;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class l implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f8264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V2.a f8265b;

    public l(V2.a aVar, V2.a aVar2) {
        this.f8264a = aVar;
        this.f8265b = aVar2;
    }

    public static l a(V2.a aVar, V2.a aVar2) {
        return new l(aVar, aVar2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c((Context) this.f8264a.get(), this.f8265b.get());
    }
}
