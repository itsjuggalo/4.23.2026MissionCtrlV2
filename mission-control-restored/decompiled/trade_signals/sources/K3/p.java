package K3;

import android.util.DisplayMetrics;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class p implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f4761b;

    public p(g gVar, InterfaceC2426a interfaceC2426a) {
        this.f4760a = gVar;
        this.f4761b = interfaceC2426a;
    }

    public static p a(g gVar, InterfaceC2426a interfaceC2426a) {
        return new p(gVar, interfaceC2426a);
    }

    public static H3.k c(g gVar, DisplayMetrics displayMetrics) {
        return (H3.k) G3.d.d(gVar.j(displayMetrics));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public H3.k get() {
        return c(this.f4760a, (DisplayMetrics) this.f4761b.get());
    }
}
