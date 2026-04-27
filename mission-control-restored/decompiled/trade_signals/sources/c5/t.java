package c5;

import i5.AbstractC1929c;

/* JADX INFO: loaded from: classes2.dex */
public final class t extends P4.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P4.n f13544b;

    public static final class a extends AbstractC1929c implements P4.l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S4.b f13545c;

        public a(x7.b bVar) {
            super(bVar);
        }

        @Override // P4.l
        public void a() {
            this.f18805a.a();
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.n(this.f13545c, bVar)) {
                this.f13545c = bVar;
                this.f18805a.d(this);
            }
        }

        @Override // i5.AbstractC1929c, x7.c
        public void cancel() {
            super.cancel();
            this.f13545c.dispose();
        }

        @Override // P4.l
        public void onError(Throwable th) {
            this.f18805a.onError(th);
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            f(obj);
        }
    }

    public t(P4.n nVar) {
        this.f13544b = nVar;
    }

    @Override // P4.f
    public void I(x7.b bVar) {
        this.f13544b.a(new a(bVar));
    }
}
