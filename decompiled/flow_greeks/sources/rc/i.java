package rc;

import cc.p;
import cc.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends rc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f19816b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f19817a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final p f19818b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f19820d = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final jc.e f19819c = new jc.e();

        public a(q qVar, p pVar) {
            this.f19817a = qVar;
            this.f19818b = pVar;
        }

        @Override // cc.q
        public void a(fc.b bVar) {
            this.f19819c.b(bVar);
        }

        @Override // cc.q
        public void onComplete() {
            if (!this.f19820d) {
                this.f19817a.onComplete();
            } else {
                this.f19820d = false;
                this.f19818b.b(this);
            }
        }

        @Override // cc.q
        public void onError(Throwable th) {
            this.f19817a.onError(th);
        }

        @Override // cc.q
        public void onNext(Object obj) {
            if (this.f19820d) {
                this.f19820d = false;
            }
            this.f19817a.onNext(obj);
        }
    }

    public i(p pVar, p pVar2) {
        super(pVar);
        this.f19816b = pVar2;
    }

    @Override // cc.o
    public void k(q qVar) {
        a aVar = new a(qVar, this.f19816b);
        qVar.a(aVar.f19819c);
        this.f19784a.b(aVar);
    }
}
