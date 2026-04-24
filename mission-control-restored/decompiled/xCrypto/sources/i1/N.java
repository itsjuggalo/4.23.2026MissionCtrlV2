package i1;

import k1.InterfaceC1567a;

/* JADX INFO: loaded from: classes.dex */
public final class N implements c1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final V2.a f12195a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V2.a f12196b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V2.a f12197c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V2.a f12198d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final V2.a f12199e;

    public N(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5) {
        this.f12195a = aVar;
        this.f12196b = aVar2;
        this.f12197c = aVar3;
        this.f12198d = aVar4;
        this.f12199e = aVar5;
    }

    public static N a(V2.a aVar, V2.a aVar2, V2.a aVar3, V2.a aVar4, V2.a aVar5) {
        return new N(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static M c(InterfaceC1567a interfaceC1567a, InterfaceC1567a interfaceC1567a2, Object obj, Object obj2, V2.a aVar) {
        return new M(interfaceC1567a, interfaceC1567a2, (AbstractC1298e) obj, (W) obj2, aVar);
    }

    @Override // V2.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public M get() {
        return c((InterfaceC1567a) this.f12195a.get(), (InterfaceC1567a) this.f12196b.get(), this.f12197c.get(), this.f12198d.get(), this.f12199e);
    }
}
