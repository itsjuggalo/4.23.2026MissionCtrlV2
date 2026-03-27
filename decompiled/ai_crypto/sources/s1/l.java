package s1;

import android.content.Context;
import t1.InterfaceC2651b;

/* JADX INFO: loaded from: classes.dex */
public final class l implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f22992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f22993b;

    public l(D5.a aVar, D5.a aVar2) {
        this.f22992a = aVar;
        this.f22993b = aVar2;
    }

    public static l a(D5.a aVar, D5.a aVar2) {
        return new l(aVar, aVar2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c((Context) this.f22992a.get(), this.f22993b.get());
    }
}
