package N3;

import n5.InterfaceC2426a;

/* JADX INFO: loaded from: classes.dex */
public final class U implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f5635a;

    public U(InterfaceC2426a interfaceC2426a) {
        this.f5635a = interfaceC2426a;
    }

    public static U a(InterfaceC2426a interfaceC2426a) {
        return new U(interfaceC2426a);
    }

    public static T c(R0 r02) {
        return new T(r02);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public T get() {
        return c((R0) this.f5635a.get());
    }
}
