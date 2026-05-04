package l4;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements i4.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f15415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f15416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i4.c f15417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i4.h f15418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final t f15419e;

    public s(p pVar, String str, i4.c cVar, i4.h hVar, t tVar) {
        this.f15415a = pVar;
        this.f15416b = str;
        this.f15417c = cVar;
        this.f15418d = hVar;
        this.f15419e = tVar;
    }

    @Override // i4.i
    public void a(i4.d dVar) {
        b(dVar, new i4.k() { // from class: l4.r
            @Override // i4.k
            public final void a(Exception exc) {
                s.c(exc);
            }
        });
    }

    @Override // i4.i
    public void b(i4.d dVar, i4.k kVar) {
        this.f15419e.a(o.a().e(this.f15415a).c(dVar).f(this.f15416b).d(this.f15418d).b(this.f15417c).a(), kVar);
    }

    public p d() {
        return this.f15415a;
    }

    public static /* synthetic */ void c(Exception exc) {
    }
}
