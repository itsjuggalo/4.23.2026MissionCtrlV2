package pc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends pc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.e f18519b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements cc.l, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f18521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fc.b f18522c;

        /* JADX INFO: renamed from: pc.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class C0313a implements cc.l {
            public C0313a() {
            }

            @Override // cc.l
            public void a(fc.b bVar) {
                jc.b.l(a.this, bVar);
            }

            @Override // cc.l
            public void onComplete() {
                a.this.f18520a.onComplete();
            }

            @Override // cc.l
            public void onError(Throwable th) {
                a.this.f18520a.onError(th);
            }

            @Override // cc.l
            public void onSuccess(Object obj) {
                a.this.f18520a.onSuccess(obj);
            }
        }

        public a(cc.l lVar, ic.e eVar) {
            this.f18520a = lVar;
            this.f18521b = eVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.m(this.f18522c, bVar)) {
                this.f18522c = bVar;
                this.f18520a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return jc.b.b((fc.b) get());
        }

        @Override // fc.b
        public void dispose() {
            jc.b.a(this);
            this.f18522c.dispose();
        }

        @Override // cc.l
        public void onComplete() {
            this.f18520a.onComplete();
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18520a.onError(th);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            try {
                cc.n nVar = (cc.n) kc.b.d(this.f18521b.apply(obj), "The mapper returned a null MaybeSource");
                if (c()) {
                    return;
                }
                nVar.a(new C0313a());
            } catch (Exception e10) {
                gc.b.b(e10);
                this.f18520a.onError(e10);
            }
        }
    }

    public h(cc.n nVar, ic.e eVar) {
        super(nVar);
        this.f18519b = eVar;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18499a.a(new a(lVar, this.f18519b));
    }
}
