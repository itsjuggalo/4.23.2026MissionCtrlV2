package S2;

import h4.InterfaceC1883c;

/* JADX INFO: renamed from: S2.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0907n implements InterfaceC1883c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f7568a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C0906m f7569b;

    public C0907n(E e8, Y2.g gVar) {
        this.f7568a = e8;
        this.f7569b = new C0906m(gVar);
    }

    @Override // h4.InterfaceC1883c
    public boolean a() {
        return this.f7568a.d();
    }

    @Override // h4.InterfaceC1883c
    public InterfaceC1883c.a b() {
        return InterfaceC1883c.a.f18684a;
    }

    @Override // h4.InterfaceC1883c
    public void c(InterfaceC1883c.b bVar) {
        P2.g.f().b("App Quality Sessions session changed: " + bVar);
        this.f7569b.h(bVar.a());
    }

    public String d(String str) {
        return this.f7569b.c(str);
    }

    public void e(String str) {
        this.f7569b.i(str);
    }
}
