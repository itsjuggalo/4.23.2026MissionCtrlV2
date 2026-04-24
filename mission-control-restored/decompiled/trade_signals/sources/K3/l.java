package K3;

import android.app.Application;
import android.util.DisplayMetrics;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class l implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f4752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f4753b;

    public l(g gVar, InterfaceC2426a interfaceC2426a) {
        this.f4752a = gVar;
        this.f4753b = interfaceC2426a;
    }

    public static l a(g gVar, InterfaceC2426a interfaceC2426a) {
        return new l(gVar, interfaceC2426a);
    }

    public static DisplayMetrics c(g gVar, Application application) {
        return (DisplayMetrics) G3.d.d(gVar.f(application));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public DisplayMetrics get() {
        return c(this.f4752a, (Application) this.f4753b.get());
    }
}
