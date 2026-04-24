package c5;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends P4.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P4.n f13546a;

    public static final class a extends Z4.d implements P4.l {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S4.b f13547c;

        public a(P4.q qVar) {
            super(qVar);
        }

        @Override // P4.l
        public void a() {
            d();
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.n(this.f13547c, bVar)) {
                this.f13547c = bVar;
                this.f9765a.b(this);
            }
        }

        @Override // Z4.d, S4.b
        public void dispose() {
            super.dispose();
            this.f13547c.dispose();
        }

        @Override // P4.l
        public void onError(Throwable th) {
            f(th);
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            e(obj);
        }
    }

    public u(P4.n nVar) {
        this.f13546a = nVar;
    }

    public static P4.l v(P4.q qVar) {
        return new a(qVar);
    }

    @Override // P4.o
    public void s(P4.q qVar) {
        this.f13546a.a(v(qVar));
    }
}
