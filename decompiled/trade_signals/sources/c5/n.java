package c5;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends AbstractC1254a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.e f13509b;

    public static final class a implements P4.l, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13510a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V4.e f13511b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S4.b f13512c;

        public a(P4.l lVar, V4.e eVar) {
            this.f13510a = lVar;
            this.f13511b = eVar;
        }

        @Override // P4.l
        public void a() {
            this.f13510a.a();
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.n(this.f13512c, bVar)) {
                this.f13512c = bVar;
                this.f13510a.b(this);
            }
        }

        @Override // S4.b
        public void dispose() {
            S4.b bVar = this.f13512c;
            this.f13512c = W4.b.DISPOSED;
            bVar.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return this.f13512c.g();
        }

        @Override // P4.l
        public void onError(Throwable th) {
            this.f13510a.onError(th);
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            try {
                this.f13510a.onSuccess(X4.b.d(this.f13511b.apply(obj), "The mapper returned a null item"));
            } catch (Throwable th) {
                T4.b.b(th);
                this.f13510a.onError(th);
            }
        }
    }

    public n(P4.n nVar, V4.e eVar) {
        super(nVar);
        this.f13509b = eVar;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13474a.a(new a(lVar, this.f13509b));
    }
}
