package c5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class g extends P4.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P4.n f13490a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.e f13491b;

    public static final class a extends AtomicReference implements P4.l, P4.c, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.c f13492a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V4.e f13493b;

        public a(P4.c cVar, V4.e eVar) {
            this.f13492a = cVar;
            this.f13493b = eVar;
        }

        @Override // P4.l
        public void a() {
            this.f13492a.a();
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            W4.b.i(this, bVar);
        }

        @Override // S4.b
        public void dispose() {
            W4.b.a(this);
        }

        @Override // S4.b
        public boolean g() {
            return W4.b.b((S4.b) get());
        }

        @Override // P4.l
        public void onError(Throwable th) {
            this.f13492a.onError(th);
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            try {
                P4.d dVar = (P4.d) X4.b.d(this.f13493b.apply(obj), "The mapper returned a null CompletableSource");
                if (g()) {
                    return;
                }
                dVar.b(this);
            } catch (Throwable th) {
                T4.b.b(th);
                onError(th);
            }
        }
    }

    public g(P4.n nVar, V4.e eVar) {
        this.f13490a = nVar;
        this.f13491b = eVar;
    }

    @Override // P4.b
    public void p(P4.c cVar) {
        a aVar = new a(cVar, this.f13491b);
        cVar.b(aVar);
        this.f13490a.a(aVar);
    }
}
