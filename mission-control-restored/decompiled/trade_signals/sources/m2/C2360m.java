package m2;

import n2.InterfaceC2400g;

/* JADX INFO: renamed from: m2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2360m implements InterfaceC2400g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2400g f21370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2400g f21371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2400g f21372c;

    public C2360m(InterfaceC2400g interfaceC2400g, InterfaceC2400g interfaceC2400g2, InterfaceC2400g interfaceC2400g3) {
        this.f21370a = interfaceC2400g;
        this.f21371b = interfaceC2400g2;
        this.f21372c = interfaceC2400g3;
    }

    @Override // n2.InterfaceC2400g
    public final /* bridge */ /* synthetic */ Object zza() {
        return new C2359l((C2370w) this.f21370a.zza(), (C2356i) this.f21371b.zza(), ((C2363p) this.f21372c).a());
    }
}
