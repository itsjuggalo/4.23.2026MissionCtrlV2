package pc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends cc.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.d f18525a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.c, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18526a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fc.b f18527b;

        public a(cc.l lVar) {
            this.f18526a = lVar;
        }

        @Override // cc.c
        public void a(fc.b bVar) {
            if (jc.b.m(this.f18527b, bVar)) {
                this.f18527b = bVar;
                this.f18526a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f18527b.c();
        }

        @Override // fc.b
        public void dispose() {
            this.f18527b.dispose();
            this.f18527b = jc.b.DISPOSED;
        }

        @Override // cc.c
        public void onComplete() {
            this.f18527b = jc.b.DISPOSED;
            this.f18526a.onComplete();
        }

        @Override // cc.c
        public void onError(Throwable th) {
            this.f18527b = jc.b.DISPOSED;
            this.f18526a.onError(th);
        }
    }

    public j(cc.d dVar) {
        this.f18525a = dVar;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18525a.a(new a(lVar));
    }
}
