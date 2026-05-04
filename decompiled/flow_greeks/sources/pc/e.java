package pc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends pc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.g f18506b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.l, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18507a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.g f18508b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fc.b f18509c;

        public a(cc.l lVar, ic.g gVar) {
            this.f18507a = lVar;
            this.f18508b = gVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.m(this.f18509c, bVar)) {
                this.f18509c = bVar;
                this.f18507a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f18509c.c();
        }

        @Override // fc.b
        public void dispose() {
            fc.b bVar = this.f18509c;
            this.f18509c = jc.b.DISPOSED;
            bVar.dispose();
        }

        @Override // cc.l
        public void onComplete() {
            this.f18507a.onComplete();
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18507a.onError(th);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            try {
                if (this.f18508b.test(obj)) {
                    this.f18507a.onSuccess(obj);
                } else {
                    this.f18507a.onComplete();
                }
            } catch (Throwable th) {
                gc.b.b(th);
                this.f18507a.onError(th);
            }
        }
    }

    public e(cc.n nVar, ic.g gVar) {
        super(nVar);
        this.f18506b = gVar;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18499a.a(new a(lVar, this.f18506b));
    }
}
