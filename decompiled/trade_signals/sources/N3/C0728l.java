package N3;

import android.app.Application;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: N3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0728l implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f5703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f5704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f5705c;

    public C0728l(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f5703a = interfaceC2426a;
        this.f5704b = interfaceC2426a2;
        this.f5705c = interfaceC2426a3;
    }

    public static C0728l a(InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new C0728l(interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static C0726k c(R0 r02, Application application, Q3.a aVar) {
        return new C0726k(r02, application, aVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0726k get() {
        return c((R0) this.f5703a.get(), (Application) this.f5704b.get(), (Q3.a) this.f5705c.get());
    }
}
