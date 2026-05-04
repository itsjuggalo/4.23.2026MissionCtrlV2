package s4;

import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class w implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f20033a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f20034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f20035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f20036d;

    public w(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4) {
        this.f20033a = aVar;
        this.f20034b = aVar2;
        this.f20035c = aVar3;
        this.f20036d = aVar4;
    }

    public static w a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4) {
        return new w(aVar, aVar2, aVar3, aVar4);
    }

    public static v c(Executor executor, t4.d dVar, x xVar, u4.b bVar) {
        return new v(executor, dVar, xVar, bVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public v get() {
        return c((Executor) this.f20033a.get(), (t4.d) this.f20034b.get(), (x) this.f20035c.get(), (u4.b) this.f20036d.get());
    }
}
