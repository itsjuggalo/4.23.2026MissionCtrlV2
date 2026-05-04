package sc;

import cc.s;
import cc.t;
import cc.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u f20196a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.d f20197b;

    /* JADX INFO: renamed from: sc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class C0359a implements t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t f20198a;

        public C0359a(t tVar) {
            this.f20198a = tVar;
        }

        @Override // cc.t
        public void a(fc.b bVar) {
            this.f20198a.a(bVar);
        }

        @Override // cc.t
        public void onError(Throwable th) {
            try {
                a.this.f20197b.accept(th);
            } catch (Throwable th2) {
                gc.b.b(th2);
                th = new gc.a(th, th2);
            }
            this.f20198a.onError(th);
        }

        @Override // cc.t
        public void onSuccess(Object obj) {
            this.f20198a.onSuccess(obj);
        }
    }

    public a(u uVar, ic.d dVar) {
        this.f20196a = uVar;
        this.f20197b = dVar;
    }

    @Override // cc.s
    public void j(t tVar) {
        this.f20196a.b(new C0359a(tVar));
    }
}
