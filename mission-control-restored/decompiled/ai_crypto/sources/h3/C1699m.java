package h3;

import a4.InterfaceC0892b;
import e3.C1478g;

/* JADX INFO: renamed from: h3.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1699m implements InterfaceC0892b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1678I f14846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1698l f14847b;

    public C1699m(C1678I c1678i, n3.g gVar) {
        this.f14846a = c1678i;
        this.f14847b = new C1698l(gVar);
    }

    @Override // a4.InterfaceC0892b
    public void a(InterfaceC0892b.C0114b c0114b) {
        C1478g.f().b("App Quality Sessions session changed: " + c0114b);
        this.f14847b.h(c0114b.a());
    }

    @Override // a4.InterfaceC0892b
    public boolean b() {
        return this.f14846a.d();
    }

    @Override // a4.InterfaceC0892b
    public InterfaceC0892b.a c() {
        return InterfaceC0892b.a.CRASHLYTICS;
    }

    public String d(String str) {
        return this.f14847b.c(str);
    }

    public void e(String str) {
        this.f14847b.i(str);
    }
}
