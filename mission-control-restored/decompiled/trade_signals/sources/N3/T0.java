package N3;

import android.app.Application;
import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class T0 implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f5634a;

    public T0(InterfaceC2426a interfaceC2426a) {
        this.f5634a = interfaceC2426a;
    }

    public static T0 a(InterfaceC2426a interfaceC2426a) {
        return new T0(interfaceC2426a);
    }

    public static S0 c(Application application) {
        return new S0(application);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public S0 get() {
        return c((Application) this.f5634a.get());
    }
}
