package c5;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends P4.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P4.d f13500a;

    public static final class a implements P4.c, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13501a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public S4.b f13502b;

        public a(P4.l lVar) {
            this.f13501a = lVar;
        }

        @Override // P4.c
        public void a() {
            this.f13502b = W4.b.DISPOSED;
            this.f13501a.a();
        }

        @Override // P4.c
        public void b(S4.b bVar) {
            if (W4.b.n(this.f13502b, bVar)) {
                this.f13502b = bVar;
                this.f13501a.b(this);
            }
        }

        @Override // S4.b
        public void dispose() {
            this.f13502b.dispose();
            this.f13502b = W4.b.DISPOSED;
        }

        @Override // S4.b
        public boolean g() {
            return this.f13502b.g();
        }

        @Override // P4.c
        public void onError(Throwable th) {
            this.f13502b = W4.b.DISPOSED;
            this.f13501a.onError(th);
        }
    }

    public j(P4.d dVar) {
        this.f13500a = dVar;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13500a.b(new a(lVar));
    }
}
