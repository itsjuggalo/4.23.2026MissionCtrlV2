package c5;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes2.dex */
public final class o extends AbstractC1254a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final P4.r f13513b;

    public static final class a extends AtomicReference implements P4.l, S4.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final P4.r f13515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f13516c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f13517d;

        public a(P4.l lVar, P4.r rVar) {
            this.f13514a = lVar;
            this.f13515b = rVar;
        }

        @Override // P4.l
        public void a() {
            W4.b.i(this, this.f13515b.b(this));
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.m(this, bVar)) {
                this.f13514a.b(this);
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
            this.f13517d = th;
            W4.b.i(this, this.f13515b.b(this));
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            this.f13516c = obj;
            W4.b.i(this, this.f13515b.b(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f13517d;
            if (th != null) {
                this.f13517d = null;
                this.f13514a.onError(th);
                return;
            }
            Object obj = this.f13516c;
            if (obj == null) {
                this.f13514a.a();
            } else {
                this.f13516c = null;
                this.f13514a.onSuccess(obj);
            }
        }
    }

    public o(P4.n nVar, P4.r rVar) {
        super(nVar);
        this.f13513b = rVar;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13474a.a(new a(lVar, this.f13513b));
    }
}
