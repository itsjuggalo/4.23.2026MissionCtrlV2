package A1;

import android.content.Context;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class l implements B1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f38a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f39b;

    public l(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        this.f38a = interfaceC2426a;
        this.f39b = interfaceC2426a2;
    }

    public static l a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2) {
        return new l(interfaceC2426a, interfaceC2426a2);
    }

    public static k c(Context context, Object obj) {
        return new k(context, (i) obj);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c((Context) this.f38a.get(), this.f39b.get());
    }
}
