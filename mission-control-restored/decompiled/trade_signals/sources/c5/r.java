package c5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends AbstractC1254a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P4.r f13534b;

    public static final class a extends AtomicReference implements P4.l, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final W4.e f13535a = new W4.e();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final P4.l f13536b;

        public a(P4.l lVar) {
            this.f13536b = lVar;
        }

        @Override // P4.l
        public void a() {
            this.f13536b.a();
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            W4.b.m(this, bVar);
        }

        @Override // S4.b
        public void dispose() {
            W4.b.a(this);
            this.f13535a.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return W4.b.b((S4.b) get());
        }

        @Override // P4.l
        public void onError(Throwable th) {
            this.f13536b.onError(th);
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            this.f13536b.onSuccess(obj);
        }
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13537a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final P4.n f13538b;

        public b(P4.l lVar, P4.n nVar) {
            this.f13537a = lVar;
            this.f13538b = nVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f13538b.a(this.f13537a);
        }
    }

    public r(P4.n nVar, P4.r rVar) {
        super(nVar);
        this.f13534b = rVar;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        a aVar = new a(lVar);
        lVar.b(aVar);
        aVar.f13535a.a(this.f13534b.b(new b(aVar, this.f13474a)));
    }
}
