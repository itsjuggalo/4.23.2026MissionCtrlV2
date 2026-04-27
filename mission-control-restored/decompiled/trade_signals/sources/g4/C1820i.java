package g4;

import i4.InterfaceC1923b;
import n5.InterfaceC2426a;

/* JADX INFO: renamed from: g4.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1820i implements InterfaceC1923b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2426a f18193a;

    public C1820i(InterfaceC2426a interfaceC2426a) {
        this.f18193a = interfaceC2426a;
    }

    public static C1820i a(InterfaceC2426a interfaceC2426a) {
        return new C1820i(interfaceC2426a);
    }

    public static C1818g c(S3.b bVar) {
        return new C1818g(bVar);
    }

    @Override // n5.InterfaceC2426a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C1818g get() {
        return c((S3.b) this.f18193a.get());
    }
}
