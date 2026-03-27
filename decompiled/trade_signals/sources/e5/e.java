package e5;

import P4.f;
import P4.t;
import P4.u;
import i5.AbstractC1929c;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u f17194b;

    public static final class a extends AbstractC1929c implements t {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S4.b f17195c;

        public a(x7.b bVar) {
            super(bVar);
        }

        @Override // P4.t
        public void b(S4.b bVar) {
            if (W4.b.n(this.f17195c, bVar)) {
                this.f17195c = bVar;
                this.f18805a.d(this);
            }
        }

        @Override // i5.AbstractC1929c, x7.c
        public void cancel() {
            super.cancel();
            this.f17195c.dispose();
        }

        @Override // P4.t
        public void onError(Throwable th) {
            this.f18805a.onError(th);
        }

        @Override // P4.t
        public void onSuccess(Object obj) {
            f(obj);
        }
    }

    public e(u uVar) {
        this.f17194b = uVar;
    }

    @Override // P4.f
    public void I(x7.b bVar) {
        this.f17194b.d(new a(bVar));
    }
}
