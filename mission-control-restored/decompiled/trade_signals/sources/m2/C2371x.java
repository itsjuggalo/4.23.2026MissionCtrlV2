package m2;

import n2.InterfaceC2400g;

/* JADX INFO: renamed from: m2.x, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2371x implements InterfaceC2400g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2400g f21394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2400g f21395b;

    public C2371x(InterfaceC2400g interfaceC2400g, InterfaceC2400g interfaceC2400g2) {
        this.f21394a = interfaceC2400g;
        this.f21395b = interfaceC2400g2;
    }

    @Override // n2.InterfaceC2400g
    public final /* bridge */ /* synthetic */ Object zza() {
        return new C2370w(((C2363p) this.f21394a).a(), (C2372y) this.f21395b.zza());
    }
}
