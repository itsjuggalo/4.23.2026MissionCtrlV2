package oc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends cc.j implements lc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.f f17762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f17763b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.i, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f17764a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f17765b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public kh.c f17766c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f17767d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f17768e;

        public a(cc.l lVar, long j10) {
            this.f17764a = lVar;
            this.f17765b = j10;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17766c, cVar)) {
                this.f17766c = cVar;
                this.f17764a.a(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f17766c == wc.g.CANCELLED;
        }

        @Override // fc.b
        public void dispose() {
            this.f17766c.cancel();
            this.f17766c = wc.g.CANCELLED;
        }

        @Override // kh.b
        public void onComplete() {
            this.f17766c = wc.g.CANCELLED;
            if (this.f17768e) {
                return;
            }
            this.f17768e = true;
            this.f17764a.onComplete();
        }

        @Override // kh.b
        public void onError(Throwable th) {
            if (this.f17768e) {
                yc.a.q(th);
                return;
            }
            this.f17768e = true;
            this.f17766c = wc.g.CANCELLED;
            this.f17764a.onError(th);
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f17768e) {
                return;
            }
            long j10 = this.f17767d;
            if (j10 != this.f17765b) {
                this.f17767d = j10 + 1;
                return;
            }
            this.f17768e = true;
            this.f17766c.cancel();
            this.f17766c = wc.g.CANCELLED;
            this.f17764a.onSuccess(obj);
        }
    }

    public f(cc.f fVar, long j10) {
        this.f17762a = fVar;
        this.f17763b = j10;
    }

    @Override // lc.b
    public cc.f c() {
        return yc.a.k(new e(this.f17762a, this.f17763b, null, false));
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f17762a.H(new a(lVar, this.f17763b));
    }
}
