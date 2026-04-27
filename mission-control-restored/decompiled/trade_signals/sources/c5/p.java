package c5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class p extends AbstractC1254a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.e f13518b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f13519c;

    public static final class a extends AtomicReference implements P4.l, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13520a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final V4.e f13521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f13522c;

        /* JADX INFO: renamed from: c5.p$a$a, reason: collision with other inner class name */
        public static final class C0232a implements P4.l {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final P4.l f13523a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AtomicReference f13524b;

            public C0232a(P4.l lVar, AtomicReference atomicReference) {
                this.f13523a = lVar;
                this.f13524b = atomicReference;
            }

            @Override // P4.l
            public void a() {
                this.f13523a.a();
            }

            @Override // P4.l
            public void b(S4.b bVar) {
                W4.b.m(this.f13524b, bVar);
            }

            @Override // P4.l
            public void onError(Throwable th) {
                this.f13523a.onError(th);
            }

            @Override // P4.l
            public void onSuccess(Object obj) {
                this.f13523a.onSuccess(obj);
            }
        }

        public a(P4.l lVar, V4.e eVar, boolean z7) {
            this.f13520a = lVar;
            this.f13521b = eVar;
            this.f13522c = z7;
        }

        @Override // P4.l
        public void a() {
            this.f13520a.a();
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.m(this, bVar)) {
                this.f13520a.b(this);
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
            if (!this.f13522c && !(th instanceof Exception)) {
                this.f13520a.onError(th);
                return;
            }
            try {
                P4.n nVar = (P4.n) X4.b.d(this.f13521b.apply(th), "The resumeFunction returned a null MaybeSource");
                W4.b.i(this, null);
                nVar.a(new C0232a(this.f13520a, this));
            } catch (Throwable th2) {
                T4.b.b(th2);
                this.f13520a.onError(new T4.a(th, th2));
            }
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            this.f13520a.onSuccess(obj);
        }
    }

    public p(P4.n nVar, V4.e eVar, boolean z7) {
        super(nVar);
        this.f13518b = eVar;
        this.f13519c = z7;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13474a.a(new a(lVar, this.f13518b, this.f13519c));
    }
}
