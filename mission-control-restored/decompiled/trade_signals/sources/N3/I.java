package N3;

import n5.InterfaceC2426a;
import r4.g;

/* JADX INFO: loaded from: classes.dex */
public final class I implements E3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f5592a;

    public I(InterfaceC2426a interfaceC2426a) {
        this.f5592a = interfaceC2426a;
    }

    public static I a(InterfaceC2426a interfaceC2426a) {
        return new I(interfaceC2426a);
    }

    public static H c(g.b bVar) {
        return new H(bVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public H get() {
        return c((g.b) this.f5592a.get());
    }
}
