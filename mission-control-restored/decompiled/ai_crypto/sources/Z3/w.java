package Z3;

import c0.InterfaceC1119h;
import c4.InterfaceC1143b;

/* JADX INFO: loaded from: classes.dex */
public final class w implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f6003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f6004b;

    public w(D5.a aVar, D5.a aVar2) {
        this.f6003a = aVar;
        this.f6004b = aVar2;
    }

    public static w a(D5.a aVar, D5.a aVar2) {
        return new w(aVar, aVar2);
    }

    public static v c(H5.g gVar, InterfaceC1119h interfaceC1119h) {
        return new v(gVar, interfaceC1119h);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v get() {
        return c((H5.g) this.f6003a.get(), (InterfaceC1119h) this.f6004b.get());
    }
}
