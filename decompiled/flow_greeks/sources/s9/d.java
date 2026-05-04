package s9;

import android.app.Application;
import java.util.Map;
import q9.q;
import u9.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements t9.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f20144a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f20145b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f20146c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f20147d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f20148e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bd.a f20149f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bd.a f20150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final bd.a f20151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final bd.a f20152i;

    public d(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7, bd.a aVar8, bd.a aVar9) {
        this.f20144a = aVar;
        this.f20145b = aVar2;
        this.f20146c = aVar3;
        this.f20147d = aVar4;
        this.f20148e = aVar5;
        this.f20149f = aVar6;
        this.f20150g = aVar7;
        this.f20151h = aVar8;
        this.f20152i = aVar9;
    }

    public static d a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7, bd.a aVar8, bd.a aVar9) {
        return new d(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static b c(q qVar, Map map, u9.e eVar, m mVar, m mVar2, u9.g gVar, Application application, u9.a aVar, u9.c cVar) {
        return new b(qVar, map, eVar, mVar, mVar2, gVar, application, aVar, cVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b get() {
        return c((q) this.f20144a.get(), (Map) this.f20145b.get(), (u9.e) this.f20146c.get(), (m) this.f20147d.get(), (m) this.f20148e.get(), (u9.g) this.f20149f.get(), (Application) this.f20150g.get(), (u9.a) this.f20151h.get(), (u9.c) this.f20152i.get());
    }
}
