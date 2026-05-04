package oc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends cc.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cc.o f17846b;

    public n(cc.o oVar) {
        this.f17846b = oVar;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f17846b.b(new a(bVar));
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.q, kh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fc.b f17848b;

        public a(kh.b bVar) {
            this.f17847a = bVar;
        }

        @Override // cc.q
        public void a(fc.b bVar) {
            this.f17848b = bVar;
            this.f17847a.b(this);
        }

        @Override // kh.c
        public void cancel() {
            this.f17848b.dispose();
        }

        @Override // cc.q
        public void onComplete() {
            this.f17847a.onComplete();
        }

        @Override // cc.q
        public void onError(Throwable th) {
            this.f17847a.onError(th);
        }

        @Override // cc.q
        public void onNext(Object obj) {
            this.f17847a.onNext(obj);
        }

        @Override // kh.c
        public void request(long j10) {
        }
    }
}
