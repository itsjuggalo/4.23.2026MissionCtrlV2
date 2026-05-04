package q9;

import aa.e2;
import aa.n2;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f18949a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f18950b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f18951c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f18952d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f18953e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bd.a f18954f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bd.a f18955g;

    public t(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7) {
        this.f18949a = aVar;
        this.f18950b = aVar2;
        this.f18951c = aVar3;
        this.f18952d = aVar4;
        this.f18953e = aVar5;
        this.f18954f = aVar6;
        this.f18955g = aVar7;
    }

    public static t a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7) {
        return new t(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7);
    }

    public static q c(e2 e2Var, n2 n2Var, aa.n nVar, ga.h hVar, aa.p pVar, aa.o oVar, Executor executor) {
        return new q(e2Var, n2Var, nVar, hVar, pVar, oVar, executor);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public q get() {
        return c((e2) this.f18949a.get(), (n2) this.f18950b.get(), (aa.n) this.f18951c.get(), (ga.h) this.f18952d.get(), (aa.p) this.f18953e.get(), (aa.o) this.f18954f.get(), (Executor) this.f18955g.get());
    }
}
