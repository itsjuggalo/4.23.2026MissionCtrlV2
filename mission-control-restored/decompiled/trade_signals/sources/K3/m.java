package K3;

import android.util.DisplayMetrics;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class m implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4754a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f4755b;

    public m(g gVar, InterfaceC2426a interfaceC2426a) {
        this.f4754a = gVar;
        this.f4755b = interfaceC2426a;
    }

    public static m a(g gVar, InterfaceC2426a interfaceC2426a) {
        return new m(gVar, interfaceC2426a);
    }

    public static H3.k c(g gVar, DisplayMetrics displayMetrics) {
        return (H3.k) G3.d.d(gVar.g(displayMetrics));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public H3.k get() {
        return c(this.f4754a, (DisplayMetrics) this.f4755b.get());
    }
}
