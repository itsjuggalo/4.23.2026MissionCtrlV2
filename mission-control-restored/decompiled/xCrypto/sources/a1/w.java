package a1;

import g1.InterfaceC1259e;
import k1.InterfaceC1567a;

/* JADX INFO: loaded from: classes.dex */
public final class w implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f6111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V2.a f6112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V2.a f6113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V2.a f6114d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final V2.a f6115e;

    public w(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5) {
        this.f6111a = aVar;
        this.f6112b = aVar2;
        this.f6113c = aVar3;
        this.f6114d = aVar4;
        this.f6115e = aVar5;
    }

    public static w a(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5) {
        return new w(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static u c(InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2, InterfaceC1259e interfaceC1259e, h1.r rVar, h1.v vVar) {
        return new u(interfaceC1567a, interfaceC1567a2, interfaceC1259e, rVar, vVar);
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public u get() {
        return c((InterfaceC1567a) this.f6111a.get(), (InterfaceC1567a) this.f6112b.get(), (InterfaceC1259e) this.f6113c.get(), (h1.r) this.f6114d.get(), (h1.v) this.f6115e.get());
    }
}
