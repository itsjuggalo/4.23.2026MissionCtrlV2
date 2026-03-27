package P3;

import N3.C0712d;
import N3.S0;
import android.app.Application;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: P3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0769e implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0768d f6400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2426a f6402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final InterfaceC2426a f6403d;

    public C0769e(C0768d c0768d, InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        this.f6400a = c0768d;
        this.f6401b = interfaceC2426a;
        this.f6402c = interfaceC2426a2;
        this.f6403d = interfaceC2426a3;
    }

    public static C0769e a(C0768d c0768d, InterfaceC2426a interfaceC2426a, InterfaceC2426a interfaceC2426a2, InterfaceC2426a interfaceC2426a3) {
        return new C0769e(c0768d, interfaceC2426a, interfaceC2426a2, interfaceC2426a3);
    }

    public static C0712d c(C0768d c0768d, InterfaceC2426a interfaceC2426a, Application application, S0 s02) {
        return (C0712d) E3.d.e(c0768d.a(interfaceC2426a, application, s02));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0712d get() {
        return c(this.f6400a, this.f6401b, (Application) this.f6402c.get(), (S0) this.f6403d.get());
    }
}
