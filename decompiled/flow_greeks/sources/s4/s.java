package s4;

import android.content.Context;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f20018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f20019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f20020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f20021d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final bd.a f20022e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final bd.a f20023f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final bd.a f20024g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final bd.a f20025h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final bd.a f20026i;

    public s(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7, bd.a aVar8, bd.a aVar9) {
        this.f20018a = aVar;
        this.f20019b = aVar2;
        this.f20020c = aVar3;
        this.f20021d = aVar4;
        this.f20022e = aVar5;
        this.f20023f = aVar6;
        this.f20024g = aVar7;
        this.f20025h = aVar8;
        this.f20026i = aVar9;
    }

    public static s a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4, bd.a aVar5, bd.a aVar6, bd.a aVar7, bd.a aVar8, bd.a aVar9) {
        return new s(aVar, aVar2, aVar3, aVar4, aVar5, aVar6, aVar7, aVar8, aVar9);
    }

    public static r c(Context context, m4.e eVar, t4.d dVar, x xVar, Executor executor, u4.b bVar, v4.a aVar, v4.a aVar2, t4.c cVar) {
        return new r(context, eVar, dVar, xVar, executor, bVar, aVar, aVar2, cVar);
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public r get() {
        return c((Context) this.f20018a.get(), (m4.e) this.f20019b.get(), (t4.d) this.f20020c.get(), (x) this.f20021d.get(), (Executor) this.f20022e.get(), (u4.b) this.f20023f.get(), (v4.a) this.f20024g.get(), (v4.a) this.f20025h.get(), (t4.c) this.f20026i.get());
    }
}
