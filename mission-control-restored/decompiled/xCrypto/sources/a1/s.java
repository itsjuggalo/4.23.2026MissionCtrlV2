package a1;

/* JADX INFO: loaded from: classes.dex */
public final class s implements X0.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f6101a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6102b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final X0.c f6103c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final X0.h f6104d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f6105e;

    public s(p pVar, String str, X0.c cVar, X0.h hVar, t tVar) {
        this.f6101a = pVar;
        this.f6102b = str;
        this.f6103c = cVar;
        this.f6104d = hVar;
        this.f6105e = tVar;
    }

    public static /* synthetic */ void c(Exception exc) {
    }

    @Override // X0.i
    public void a(X0.d dVar) {
        b(dVar, new X0.k() { // from class: a1.r
            @Override // X0.k
            public final void a(Exception exc) {
                s.c(exc);
            }
        });
    }

    @Override // X0.i
    public void b(X0.d dVar, X0.k kVar) {
        this.f6105e.a(o.a().e(this.f6101a).c(dVar).f(this.f6102b).d(this.f6104d).b(this.f6103c).a(), kVar);
    }

    public p d() {
        return this.f6101a;
    }
}
