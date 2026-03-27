package g4;

import i4.InterfaceC1923b;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: g4.S, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1803S implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f18075a;

    public C1803S(InterfaceC2426a interfaceC2426a) {
        this.f18075a = interfaceC2426a;
    }

    public static C1803S a(InterfaceC2426a interfaceC2426a) {
        return new C1803S(interfaceC2426a);
    }

    public static C1802Q c(InterfaceC1804T interfaceC1804T) {
        return new C1802Q(interfaceC1804T);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1802Q get() {
        return c((InterfaceC1804T) this.f18075a.get());
    }
}
