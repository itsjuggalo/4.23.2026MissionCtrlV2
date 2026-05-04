package rc;

import cc.p;
import cc.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends rc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.e f19812b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends mc.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ic.e f19813f;

        public a(q qVar, ic.e eVar) {
            super(qVar);
            this.f19813f = eVar;
        }

        @Override // cc.q
        public void onNext(Object obj) {
            if (this.f16420d) {
                return;
            }
            if (this.f16421e != 0) {
                this.f16417a.onNext(null);
                return;
            }
            try {
                this.f16417a.onNext(kc.b.d(this.f19813f.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                e(th);
            }
        }

        @Override // lc.i
        public Object poll() {
            Object objPoll = this.f16419c.poll();
            if (objPoll != null) {
                return kc.b.d(this.f19813f.apply(objPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public g(p pVar, ic.e eVar) {
        super(pVar);
        this.f19812b = eVar;
    }

    @Override // cc.o
    public void k(q qVar) {
        this.f19784a.b(new a(qVar, this.f19812b));
    }
}
