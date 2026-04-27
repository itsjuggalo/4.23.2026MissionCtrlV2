package K3;

import android.util.DisplayMetrics;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class k implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4750a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f4751b;

    public k(g gVar, InterfaceC2426a interfaceC2426a) {
        this.f4750a = gVar;
        this.f4751b = interfaceC2426a;
    }

    public static k a(g gVar, InterfaceC2426a interfaceC2426a) {
        return new k(gVar, interfaceC2426a);
    }

    public static H3.k c(g gVar, DisplayMetrics displayMetrics) {
        return (H3.k) G3.d.d(gVar.e(displayMetrics));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public H3.k get() {
        return c(this.f4750a, (DisplayMetrics) this.f4751b.get());
    }
}
