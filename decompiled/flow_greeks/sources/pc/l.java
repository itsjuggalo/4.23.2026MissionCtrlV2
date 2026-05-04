package pc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l extends cc.s implements lc.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.n f18530a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.l, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.t f18531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fc.b f18532b;

        public a(cc.t tVar) {
            this.f18531a = tVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.m(this.f18532b, bVar)) {
                this.f18532b = bVar;
                this.f18531a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f18532b.c();
        }

        @Override // fc.b
        public void dispose() {
            this.f18532b.dispose();
            this.f18532b = jc.b.DISPOSED;
        }

        @Override // cc.l
        public void onComplete() {
            this.f18532b = jc.b.DISPOSED;
            this.f18531a.onSuccess(Boolean.TRUE);
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18532b = jc.b.DISPOSED;
            this.f18531a.onError(th);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            this.f18532b = jc.b.DISPOSED;
            this.f18531a.onSuccess(Boolean.FALSE);
        }
    }

    public l(cc.n nVar) {
        this.f18530a = nVar;
    }

    @Override // lc.c
    public cc.j a() {
        return yc.a.l(new k(this.f18530a));
    }

    @Override // cc.s
    public void j(cc.t tVar) {
        this.f18530a.a(new a(tVar));
    }
}
