package r4;

import android.content.Context;
import s4.x;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements n4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final bd.a f19314a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f19315b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f19316c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bd.a f19317d;

    public i(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4) {
        this.f19314a = aVar;
        this.f19315b = aVar2;
        this.f19316c = aVar3;
        this.f19317d = aVar4;
    }

    public static i a(bd.a aVar, bd.a aVar2, bd.a aVar3, bd.a aVar4) {
        return new i(aVar, aVar2, aVar3, aVar4);
    }

    public static x c(Context context, t4.d dVar, s4.f fVar, v4.a aVar) {
        return (x) n4.d.d(h.a(context, dVar, fVar, aVar));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public x get() {
        return c((Context) this.f19314a.get(), (t4.d) this.f19315b.get(), (s4.f) this.f19316c.get(), (v4.a) this.f19317d.get());
    }
}
