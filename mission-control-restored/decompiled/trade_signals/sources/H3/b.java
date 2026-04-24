package H3;

import android.app.Application;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class b implements G3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f3661a;

    public b(InterfaceC2426a interfaceC2426a) {
        this.f3661a = interfaceC2426a;
    }

    public static b a(InterfaceC2426a interfaceC2426a) {
        return new b(interfaceC2426a);
    }

    public static a c(Application application) {
        return new a(application);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public a get() {
        return c((Application) this.f3661a.get());
    }
}
