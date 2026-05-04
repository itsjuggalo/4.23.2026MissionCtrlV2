package pc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends pc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.e f18534b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.l, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18535a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f18536b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fc.b f18537c;

        public a(cc.l lVar, ic.e eVar) {
            this.f18535a = lVar;
            this.f18536b = eVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.m(this.f18537c, bVar)) {
                this.f18537c = bVar;
                this.f18535a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f18537c.c();
        }

        @Override // fc.b
        public void dispose() {
            fc.b bVar = this.f18537c;
            this.f18537c = jc.b.DISPOSED;
            bVar.dispose();
        }

        @Override // cc.l
        public void onComplete() {
            this.f18535a.onComplete();
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18535a.onError(th);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            try {
                this.f18535a.onSuccess(kc.b.d(this.f18536b.apply(obj), "The mapper returned a null item"));
            } catch (Throwable th) {
                gc.b.b(th);
                this.f18535a.onError(th);
            }
        }
    }

    public n(cc.n nVar, ic.e eVar) {
        super(nVar);
        this.f18534b = eVar;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18499a.a(new a(lVar, this.f18534b));
    }
}
