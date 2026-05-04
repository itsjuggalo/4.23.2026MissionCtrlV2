package pc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends pc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cc.r f18559b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements cc.l, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final jc.e f18560a = new jc.e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final cc.l f18561b;

        public a(cc.l lVar) {
            this.f18561b = lVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            jc.b.l(this, bVar);
        }

        @Override // fc.b
        public boolean c() {
            return jc.b.b((fc.b) get());
        }

        @Override // fc.b
        public void dispose() {
            jc.b.a(this);
            this.f18560a.dispose();
        }

        @Override // cc.l
        public void onComplete() {
            this.f18561b.onComplete();
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18561b.onError(th);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            this.f18561b.onSuccess(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18562a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final cc.n f18563b;

        public b(cc.l lVar, cc.n nVar) {
            this.f18562a = lVar;
            this.f18563b = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f18563b.a(this.f18562a);
        }
    }

    public r(cc.n nVar, cc.r rVar) {
        super(nVar);
        this.f18559b = rVar;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        a aVar = new a(lVar);
        lVar.a(aVar);
        aVar.f18560a.a(this.f18559b.c(new b(aVar, this.f18499a)));
    }
}
