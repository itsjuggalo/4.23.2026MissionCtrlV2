package pc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends cc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.n f18515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.e f18516b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements cc.l, cc.c, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.c f18517a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f18518b;

        public a(cc.c cVar, ic.e eVar) {
            this.f18517a = cVar;
            this.f18518b = eVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            jc.b.h(this, bVar);
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
            this.f18517a.onComplete();
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18517a.onError(th);
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            try {
                cc.d dVar = (cc.d) kc.b.d(this.f18518b.apply(obj), "The mapper returned a null CompletableSource");
                if (c()) {
                    return;
                }
                dVar.a(this);
            } catch (Throwable th) {
                gc.b.b(th);
                onError(th);
            }
        }
    }

    public g(cc.n nVar, ic.e eVar) {
        this.f18515a = nVar;
        this.f18516b = eVar;
    }

    @Override // cc.b
    public void m(cc.c cVar) {
        a aVar = new a(cVar, this.f18516b);
        cVar.a(aVar);
        this.f18515a.a(aVar);
    }
}
