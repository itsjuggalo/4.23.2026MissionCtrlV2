package d4;

import Z3.C0782b;
import c4.InterfaceC1143b;

/* JADX INFO: loaded from: classes.dex */
public final class f implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f13373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f13374b;

    public f(D5.a aVar, D5.a aVar2) {
        this.f13373a = aVar;
        this.f13374b = aVar2;
    }

    public static f a(D5.a aVar, D5.a aVar2) {
        return new f(aVar, aVar2);
    }

    public static e c(C0782b c0782b, H5.g gVar) {
        return new e(c0782b, gVar);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public e get() {
        return c((C0782b) this.f13373a.get(), (H5.g) this.f13374b.get());
    }
}
