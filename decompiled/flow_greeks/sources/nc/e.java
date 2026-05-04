package nc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends cc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.d f17007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.g f17008b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a implements cc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.c f17009a;

        public a(cc.c cVar) {
            this.f17009a = cVar;
        }

        @Override // cc.c
        public void a(fc.b bVar) {
            this.f17009a.a(bVar);
        }

        @Override // cc.c
        public void onComplete() {
            this.f17009a.onComplete();
        }

        @Override // cc.c
        public void onError(Throwable th) {
            try {
                if (e.this.f17008b.test(th)) {
                    this.f17009a.onComplete();
                } else {
                    this.f17009a.onError(th);
                }
            } catch (Throwable th2) {
                gc.b.b(th2);
                this.f17009a.onError(new gc.a(th, th2));
            }
        }
    }

    public e(cc.d dVar, ic.g gVar) {
        this.f17007a = dVar;
        this.f17008b = gVar;
    }

    @Override // cc.b
    public void m(cc.c cVar) {
        this.f17007a.a(new a(cVar));
    }
}
