package ca;

import aa.m3;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements r9.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f3770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bd.a f3771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bd.a f3772c;

    public f(d dVar, bd.a aVar, bd.a aVar2) {
        this.f3770a = dVar;
        this.f3771b = aVar;
        this.f3772c = aVar2;
    }

    public static f a(d dVar, bd.a aVar, bd.a aVar2) {
        return new f(dVar, aVar, aVar2);
    }

    public static aa.n c(d dVar, m3 m3Var, c9.d dVar2) {
        return (aa.n) r9.d.e(dVar.b(m3Var, dVar2));
    }

    @Override // bd.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public aa.n get() {
        return c(this.f3770a, (m3) this.f3771b.get(), (c9.d) this.f3772c.get());
    }
}
