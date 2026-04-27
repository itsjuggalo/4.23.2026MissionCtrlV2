package c5;

/* JADX INFO: loaded from: classes2.dex */
public final class k extends AbstractC1254a {

    public static final class a implements P4.l, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13503a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public S4.b f13504b;

        public a(P4.l lVar) {
            this.f13503a = lVar;
        }

        @Override // P4.l
        public void a() {
            this.f13503a.onSuccess(Boolean.TRUE);
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.n(this.f13504b, bVar)) {
                this.f13504b = bVar;
                this.f13503a.b(this);
            }
        }

        @Override // S4.b
        public void dispose() {
            this.f13504b.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return this.f13504b.g();
        }

        @Override // P4.l
        public void onError(Throwable th) {
            this.f13503a.onError(th);
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            this.f13503a.onSuccess(Boolean.FALSE);
        }
    }

    public k(P4.n nVar) {
        super(nVar);
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13474a.a(new a(lVar));
    }
}
