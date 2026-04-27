package P3;

import N3.R0;
import android.app.Application;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class I implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H f6375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2426a f6376b;

    public I(H h8, InterfaceC2426a interfaceC2426a) {
        this.f6375a = h8;
        this.f6376b = interfaceC2426a;
    }

    public static I a(H h8, InterfaceC2426a interfaceC2426a) {
        return new I(h8, interfaceC2426a);
    }

    public static R0 c(H h8, Application application) {
        return (R0) E3.d.e(h8.a(application));
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public R0 get() {
        return c(this.f6375a, (Application) this.f6376b.get());
    }
}
