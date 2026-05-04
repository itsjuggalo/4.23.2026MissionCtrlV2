package pc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p extends pc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.e f18543b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f18544c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements cc.l, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18545a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f18546b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f18547c;

        /* JADX INFO: renamed from: pc.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0314a implements cc.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final cc.l f18548a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference f18549b;

            public C0314a(cc.l lVar, AtomicReference atomicReference) {
                this.f18548a = lVar;
                this.f18549b = atomicReference;
            }

            @Override // cc.l
            public void a(fc.b bVar) {
                jc.b.l(this.f18549b, bVar);
            }

            @Override // cc.l
            public void onComplete() {
                this.f18548a.onComplete();
            }

            @Override // cc.l
            public void onError(Throwable th) {
                this.f18548a.onError(th);
            }

            @Override // cc.l
            public void onSuccess(Object obj) {
                this.f18548a.onSuccess(obj);
            }
        }

        public a(cc.l lVar, ic.e eVar, boolean z10) {
            this.f18545a = lVar;
            this.f18546b = eVar;
            this.f18547c = z10;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.l(this, bVar)) {
                this.f18545a.a(this);
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
            this.f18545a.onComplete();
        }

        @Override // cc.l
        public void onError(Throwable th) {
            if (!this.f18547c && !(th instanceof Exception)) {
                this.f18545a.onError(th);
                return;
            }
            try {
                cc.n nVar = (cc.n) kc.b.d(this.f18546b.apply(th), "The resumeFunction returned a null MaybeSource");
                jc.b.h(this, null);
                nVar.a(new C0314a(this.f18545a, this));
            } catch (Throwable th2) {
                gc.b.b(th2);
                this.f18545a.onError(new gc.a(th, th2));
            }
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            this.f18545a.onSuccess(obj);
        }
    }

    public p(cc.n nVar, ic.e eVar, boolean z10) {
        super(nVar);
        this.f18543b = eVar;
        this.f18544c = z10;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18499a.a(new a(lVar, this.f18543b, this.f18544c));
    }
}
