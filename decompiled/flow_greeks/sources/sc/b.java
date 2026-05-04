package sc;

import cc.s;
import cc.t;
import cc.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f20200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.d f20201b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f20202a;

        public a(t tVar) {
            this.f20202a = tVar;
        }

        @Override // cc.t
        public void a(fc.b bVar) {
            this.f20202a.a(bVar);
        }

        @Override // cc.t
        public void onError(Throwable th) {
            this.f20202a.onError(th);
        }

        @Override // cc.t
        public void onSuccess(Object obj) {
            try {
                b.this.f20201b.accept(obj);
                this.f20202a.onSuccess(obj);
            } catch (Throwable th) {
                gc.b.b(th);
                this.f20202a.onError(th);
            }
        }
    }

    public b(u uVar, ic.d dVar) {
        this.f20200a = uVar;
        this.f20201b = dVar;
    }

    @Override // cc.s
    public void j(t tVar) {
        this.f20200a.b(new a(tVar));
    }
}
