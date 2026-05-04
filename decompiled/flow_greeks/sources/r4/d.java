package r4;

import java.util.concurrent.Executor;
import s4.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f19308a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f19309b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f19310c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f19311d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f19312e;

    public d(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        this.f19308a = aVar;
        this.f19309b = aVar2;
        this.f19310c = aVar3;
        this.f19311d = aVar4;
        this.f19312e = aVar5;
    }

    public static d a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static c c(Executor executor, m4.e eVar, x xVar, t4.d dVar, u4.b bVar) {
        return new c(executor, eVar, xVar, dVar, bVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c get() {
        return c((Executor) this.f19308a.get(), (m4.e) this.f19309b.get(), (x) this.f19310c.get(), (t4.d) this.f19311d.get(), (u4.b) this.f19312e.get());
    }
}
