package rc;

import cc.p;
import cc.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends rc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.g f19791b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends mc.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ic.g f19792f;

        public a(q qVar, ic.g gVar) {
            super(qVar);
            this.f19792f = gVar;
        }

        @Override // cc.q
        public void onNext(Object obj) {
            if (this.f16421e != 0) {
                this.f16417a.onNext(null);
                return;
            }
            try {
                if (this.f19792f.test(obj)) {
                    this.f16417a.onNext(obj);
                }
            } catch (Throwable th) {
                e(th);
            }
        }

        @Override // lc.i
        public Object poll() {
            Object objPoll;
            do {
                objPoll = this.f16419c.poll();
                if (objPoll == null) {
                    break;
                }
            } while (!this.f19792f.test(objPoll));
            return objPoll;
        }
    }

    public c(p pVar, ic.g gVar) {
        super(pVar);
        this.f19791b = gVar;
    }

    @Override // cc.o
    public void k(q qVar) {
        this.f19784a.b(new a(qVar, this.f19791b));
    }
}
