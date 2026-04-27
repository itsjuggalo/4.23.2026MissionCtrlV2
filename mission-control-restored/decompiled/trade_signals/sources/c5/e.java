package c5;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends AbstractC1254a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.g f13481b;

    public static final class a implements P4.l, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13482a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V4.g f13483b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S4.b f13484c;

        public a(P4.l lVar, V4.g gVar) {
            this.f13482a = lVar;
            this.f13483b = gVar;
        }

        @Override // P4.l
        public void a() {
            this.f13482a.a();
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.n(this.f13484c, bVar)) {
                this.f13484c = bVar;
                this.f13482a.b(this);
            }
        }

        @Override // S4.b
        public void dispose() {
            S4.b bVar = this.f13484c;
            this.f13484c = W4.b.DISPOSED;
            bVar.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return this.f13484c.g();
        }

        @Override // P4.l
        public void onError(Throwable th) {
            this.f13482a.onError(th);
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            try {
                if (this.f13483b.test(obj)) {
                    this.f13482a.onSuccess(obj);
                } else {
                    this.f13482a.a();
                }
            } catch (Throwable th) {
                T4.b.b(th);
                this.f13482a.onError(th);
            }
        }
    }

    public e(P4.n nVar, V4.g gVar) {
        super(nVar);
        this.f13481b = gVar;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13474a.a(new a(lVar, this.f13481b));
    }
}
