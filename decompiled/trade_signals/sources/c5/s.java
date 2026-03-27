package c5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class s extends AbstractC1254a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P4.n f13539b;

    public static final class a extends AtomicReference implements P4.l, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13540a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final P4.n f13541b;

        /* JADX INFO: renamed from: c5.s$a$a, reason: collision with other inner class name */
        public static final class C0233a implements P4.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final P4.l f13542a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference f13543b;

            public C0233a(P4.l lVar, AtomicReference atomicReference) {
                this.f13542a = lVar;
                this.f13543b = atomicReference;
            }

            @Override // P4.l
            public void a() {
                this.f13542a.a();
            }

            @Override // P4.l
            public void b(S4.b bVar) {
                W4.b.m(this.f13543b, bVar);
            }

            @Override // P4.l
            public void onError(Throwable th) {
                this.f13542a.onError(th);
            }

            @Override // P4.l
            public void onSuccess(Object obj) {
                this.f13542a.onSuccess(obj);
            }
        }

        public a(P4.l lVar, P4.n nVar) {
            this.f13540a = lVar;
            this.f13541b = nVar;
        }

        @Override // P4.l
        public void a() {
            S4.b bVar = (S4.b) get();
            if (bVar == W4.b.DISPOSED || !compareAndSet(bVar, null)) {
                return;
            }
            this.f13541b.a(new C0233a(this.f13540a, this));
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.m(this, bVar)) {
                this.f13540a.b(this);
            }
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
            this.f13540a.onError(th);
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            this.f13540a.onSuccess(obj);
        }
    }

    public s(P4.n nVar, P4.n nVar2) {
        super(nVar);
        this.f13539b = nVar2;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13474a.a(new a(lVar, this.f13539b));
    }
}
