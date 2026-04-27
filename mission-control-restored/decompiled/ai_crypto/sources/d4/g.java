package d4;

import Z3.C0782b;
import b4.InterfaceC0994a;
import c4.C1142a;
import c4.InterfaceC1143b;

/* JADX INFO: loaded from: classes.dex */
public final class g implements InterfaceC1143b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f13375a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f13376b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D5.a f13377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D5.a f13378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final D5.a f13379e;

    public g(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4, D5.a aVar5) {
        this.f13375a = aVar;
        this.f13376b = aVar2;
        this.f13377c = aVar3;
        this.f13378d = aVar4;
        this.f13379e = aVar5;
    }

    public static g a(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4, D5.a aVar5) {
        return new g(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static d c(H5.g gVar, O3.h hVar, C0782b c0782b, InterfaceC1463a interfaceC1463a, InterfaceC0994a interfaceC0994a) {
        return new d(gVar, hVar, c0782b, interfaceC1463a, interfaceC0994a);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public d get() {
        return c((H5.g) this.f13375a.get(), (O3.h) this.f13376b.get(), (C0782b) this.f13377c.get(), (InterfaceC1463a) this.f13378d.get(), C1142a.a(this.f13379e));
    }
}
