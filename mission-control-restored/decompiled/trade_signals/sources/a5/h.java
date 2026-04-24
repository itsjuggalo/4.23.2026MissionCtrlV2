package a5;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends P4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P4.d f9988a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.e f9989b;

    public final class a implements P4.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.c f9990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final W4.e f9991b;

        /* JADX INFO: renamed from: a5.h$a$a, reason: collision with other inner class name */
        public final class C0169a implements P4.c {
            public C0169a() {
            }

            @Override // P4.c
            public void a() {
                a.this.f9990a.a();
            }

            @Override // P4.c
            public void b(S4.b bVar) {
                a.this.f9991b.b(bVar);
            }

            @Override // P4.c
            public void onError(Throwable th) {
                a.this.f9990a.onError(th);
            }
        }

        public a(P4.c cVar, W4.e eVar) {
            this.f9990a = cVar;
            this.f9991b = eVar;
        }

        @Override // P4.c
        public void a() {
            this.f9990a.a();
        }

        @Override // P4.c
        public void b(S4.b bVar) {
            this.f9991b.b(bVar);
        }

        @Override // P4.c
        public void onError(Throwable th) {
            try {
                P4.d dVar = (P4.d) h.this.f9989b.apply(th);
                if (dVar != null) {
                    dVar.b(new C0169a());
                    return;
                }
                NullPointerException nullPointerException = new NullPointerException("The CompletableConsumable returned is null");
                nullPointerException.initCause(th);
                this.f9990a.onError(nullPointerException);
            } catch (Throwable th2) {
                T4.b.b(th2);
                this.f9990a.onError(new T4.a(th2, th));
            }
        }
    }

    public h(P4.d dVar, V4.e eVar) {
        this.f9988a = dVar;
        this.f9989b = eVar;
    }

    @Override // P4.b
    public void p(P4.c cVar) {
        W4.e eVar = new W4.e();
        cVar.b(eVar);
        this.f9988a.b(new a(cVar, eVar));
    }
}
