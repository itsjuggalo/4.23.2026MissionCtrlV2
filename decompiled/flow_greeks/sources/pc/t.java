package pc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends cc.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cc.n f18569b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends wc.c implements cc.l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fc.b f18570c;

        public a(kh.b bVar) {
            super(bVar);
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.m(this.f18570c, bVar)) {
                this.f18570c = bVar;
                this.f23885a.b(this);
            }
        }

        @Override // wc.c, kh.c
        public void cancel() {
            super.cancel();
            this.f18570c.dispose();
        }

        @Override // cc.l
        public void onComplete() {
            this.f23885a.onComplete();
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f23885a.onError(th);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            c(obj);
        }
    }

    public t(cc.n nVar) {
        this.f18569b = nVar;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f18569b.a(new a(bVar));
    }
}
