package pc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends pc.a {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.l, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18528a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fc.b f18529b;

        public a(cc.l lVar) {
            this.f18528a = lVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.m(this.f18529b, bVar)) {
                this.f18529b = bVar;
                this.f18528a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f18529b.c();
        }

        @Override // fc.b
        public void dispose() {
            this.f18529b.dispose();
        }

        @Override // cc.l
        public void onComplete() {
            this.f18528a.onSuccess(Boolean.TRUE);
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18528a.onError(th);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            this.f18528a.onSuccess(Boolean.FALSE);
        }
    }

    public k(cc.n nVar) {
        super(nVar);
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18499a.a(new a(lVar));
    }
}
