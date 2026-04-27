package c5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class h extends AbstractC1254a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.e f13494b;

    public static final class a extends AtomicReference implements P4.l, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13495a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V4.e f13496b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S4.b f13497c;

        /* JADX INFO: renamed from: c5.h$a$a, reason: collision with other inner class name */
        public final class C0231a implements P4.l {
            public C0231a() {
            }

            @Override // P4.l
            public void a() {
                a.this.f13495a.a();
            }

            @Override // P4.l
            public void b(S4.b bVar) {
                W4.b.m(a.this, bVar);
            }

            @Override // P4.l
            public void onError(Throwable th) {
                a.this.f13495a.onError(th);
            }

            @Override // P4.l
            public void onSuccess(Object obj) {
                a.this.f13495a.onSuccess(obj);
            }
        }

        public a(P4.l lVar, V4.e eVar) {
            this.f13495a = lVar;
            this.f13496b = eVar;
        }

        @Override // P4.l
        public void a() {
            this.f13495a.a();
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.n(this.f13497c, bVar)) {
                this.f13497c = bVar;
                this.f13495a.b(this);
            }
        }

        @Override // S4.b
        public void dispose() {
            W4.b.a(this);
            this.f13497c.dispose();
        }

        @Override // S4.b
        public boolean g() {
            return W4.b.b((S4.b) get());
        }

        @Override // P4.l
        public void onError(Throwable th) {
            this.f13495a.onError(th);
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            try {
                P4.n nVar = (P4.n) X4.b.d(this.f13496b.apply(obj), "The mapper returned a null MaybeSource");
                if (g()) {
                    return;
                }
                nVar.a(new C0231a());
            } catch (Exception e8) {
                T4.b.b(e8);
                this.f13495a.onError(e8);
            }
        }
    }

    public h(P4.n nVar, V4.e eVar) {
        super(nVar);
        this.f13494b = eVar;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13474a.a(new a(lVar, this.f13494b));
    }
}
