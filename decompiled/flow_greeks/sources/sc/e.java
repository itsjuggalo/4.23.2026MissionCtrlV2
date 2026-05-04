package sc;

import cc.f;
import cc.t;
import cc.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f20209b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends wc.c implements t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fc.b f20210c;

        public a(kh.b bVar) {
            super(bVar);
        }

        @Override // cc.t
        public void a(fc.b bVar) {
            if (jc.b.m(this.f20210c, bVar)) {
                this.f20210c = bVar;
                this.f23885a.b(this);
            }
        }

        @Override // wc.c, kh.c
        public void cancel() {
            super.cancel();
            this.f20210c.dispose();
        }

        @Override // cc.t
        public void onError(Throwable th) {
            this.f23885a.onError(th);
        }

        @Override // cc.t
        public void onSuccess(Object obj) {
            c(obj);
        }
    }

    public e(u uVar) {
        this.f20209b = uVar;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f20209b.b(new a(bVar));
    }
}
