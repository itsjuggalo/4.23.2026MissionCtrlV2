package Z3;

import c4.InterfaceC1143b;

/* JADX INFO: renamed from: Z3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0789i implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f5938a;

    public C0789i(D5.a aVar) {
        this.f5938a = aVar;
    }

    public static C0789i a(D5.a aVar) {
        return new C0789i(aVar);
    }

    public static C0787g c(N3.b bVar) {
        return new C0787g(bVar);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public C0787g get() {
        return c((N3.b) this.f5938a.get());
    }
}
