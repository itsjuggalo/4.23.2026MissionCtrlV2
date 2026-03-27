package z1;

import t1.InterfaceC2651b;

/* JADX INFO: loaded from: classes.dex */
public final class N implements InterfaceC2651b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final D5.a f25971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final D5.a f25972b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final D5.a f25973c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final D5.a f25974d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final D5.a f25975e;

    public N(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4, D5.a aVar5) {
        this.f25971a = aVar;
        this.f25972b = aVar2;
        this.f25973c = aVar3;
        this.f25974d = aVar4;
        this.f25975e = aVar5;
    }

    public static N a(D5.a aVar, D5.a aVar2, D5.a aVar3, D5.a aVar4, D5.a aVar5) {
        return new N(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static M c(B1.a aVar, B1.a aVar2, Object obj, Object obj2, D5.a aVar3) {
        return new M(aVar, aVar2, (AbstractC2860e) obj, (W) obj2, aVar3);
    }

    @Override // D5.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public M get() {
        return c((B1.a) this.f25971a.get(), (B1.a) this.f25972b.get(), this.f25973c.get(), this.f25974d.get(), this.f25975e);
    }
}
