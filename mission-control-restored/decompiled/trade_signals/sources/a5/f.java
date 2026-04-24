package a5;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends P4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P4.d f9974a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.g f9975b;

    public final class a implements P4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.c f9976a;

        public a(P4.c cVar) {
            this.f9976a = cVar;
        }

        @Override // P4.c
        public void a() {
            this.f9976a.a();
        }

        @Override // P4.c
        public void b(S4.b bVar) {
            this.f9976a.b(bVar);
        }

        @Override // P4.c
        public void onError(Throwable th) {
            try {
                if (f.this.f9975b.test(th)) {
                    this.f9976a.a();
                } else {
                    this.f9976a.onError(th);
                }
            } catch (Throwable th2) {
                T4.b.b(th2);
                this.f9976a.onError(new T4.a(th, th2));
            }
        }
    }

    public f(P4.d dVar, V4.g gVar) {
        this.f9974a = dVar;
        this.f9975b = gVar;
    }

    @Override // P4.b
    public void p(P4.c cVar) {
        this.f9974a.b(new a(cVar));
    }
}
