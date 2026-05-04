package pc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends pc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cc.n f18564b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements cc.l, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18565a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final cc.n f18566b;

        /* JADX INFO: renamed from: pc.s$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0315a implements cc.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final cc.l f18567a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference f18568b;

            public C0315a(cc.l lVar, AtomicReference atomicReference) {
                this.f18567a = lVar;
                this.f18568b = atomicReference;
            }

            @Override // cc.l
            public void a(fc.b bVar) {
                jc.b.l(this.f18568b, bVar);
            }

            @Override // cc.l
            public void onComplete() {
                this.f18567a.onComplete();
            }

            @Override // cc.l
            public void onError(Throwable th) {
                this.f18567a.onError(th);
            }

            @Override // cc.l
            public void onSuccess(Object obj) {
                this.f18567a.onSuccess(obj);
            }
        }

        public a(cc.l lVar, cc.n nVar) {
            this.f18565a = lVar;
            this.f18566b = nVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.l(this, bVar)) {
                this.f18565a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return jc.b.b((fc.b) get());
        }

        @Override // fc.b
        public void dispose() {
            jc.b.a(this);
        }

        @Override // cc.l
        public void onComplete() {
            fc.b bVar = (fc.b) get();
            if (bVar == jc.b.DISPOSED || !compareAndSet(bVar, null)) {
                return;
            }
            this.f18566b.a(new C0315a(this.f18565a, this));
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18565a.onError(th);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            this.f18565a.onSuccess(obj);
        }
    }

    public s(cc.n nVar, cc.n nVar2) {
        super(nVar);
        this.f18564b = nVar2;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18499a.a(new a(lVar, this.f18564b));
    }
}
