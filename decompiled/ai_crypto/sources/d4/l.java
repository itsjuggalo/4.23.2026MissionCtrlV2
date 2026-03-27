package d4;

import c0.InterfaceC1119h;
import c4.InterfaceC1143b;

/* JADX INFO: loaded from: classes.dex */
public final class l implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f13413a;

    public l(D5.a aVar) {
        this.f13413a = aVar;
    }

    public static l a(D5.a aVar) {
        return new l(aVar);
    }

    public static k c(InterfaceC1119h interfaceC1119h) {
        return new k(interfaceC1119h);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public k get() {
        return c((InterfaceC1119h) this.f13413a.get());
    }
}
