package c5;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends P4.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P4.u f13485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.g f13486b;

    public static final class a implements P4.t, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13487a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V4.g f13488b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S4.b f13489c;

        public a(P4.l lVar, V4.g gVar) {
            this.f13487a = lVar;
            this.f13488b = gVar;
        }

        @Override // P4.t
        public void b(S4.b bVar) {
            if (W4.b.n(this.f13489c, bVar)) {
                this.f13489c = bVar;
                this.f13487a.b(this);
            }
        }

        @Override // S4.b
        public void dispose() {
            S4.b bVar = this.f13489c;
            this.f13489c = W4.b.DISPOSED;
            bVar.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return this.f13489c.g();
        }

        @Override // P4.t
        public void onError(Throwable th) {
            this.f13487a.onError(th);
        }

        @Override // P4.t
        public void onSuccess(Object obj) {
            try {
                if (this.f13488b.test(obj)) {
                    this.f13487a.onSuccess(obj);
                } else {
                    this.f13487a.a();
                }
            } catch (Throwable th) {
                T4.b.b(th);
                this.f13487a.onError(th);
            }
        }
    }

    public f(P4.u uVar, V4.g gVar) {
        this.f13485a = uVar;
        this.f13486b = gVar;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13485a.d(new a(lVar, this.f13486b));
    }
}
