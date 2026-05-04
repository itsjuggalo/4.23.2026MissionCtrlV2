package pc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o extends pc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cc.r f18538b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements cc.l, fc.b, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18539a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final cc.r f18540b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f18541c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f18542d;

        public a(cc.l lVar, cc.r rVar) {
            this.f18539a = lVar;
            this.f18540b = rVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.l(this, bVar)) {
                this.f18539a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return jc.b.b((fc.b) get());
        }

        @Override // fc.b
        public void dispose() {
            jc.b.a(this);
        }

        @Override // cc.l
        public void onComplete() {
            jc.b.h(this, this.f18540b.c(this));
        }

        @Override // cc.l
        public void onError(Throwable th) {
            this.f18542d = th;
            jc.b.h(this, this.f18540b.c(this));
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            this.f18541c = obj;
            jc.b.h(this, this.f18540b.c(this));
        }

        @Override // java.lang.Runnable
        public void run() {
            Throwable th = this.f18542d;
            if (th != null) {
                this.f18542d = null;
                this.f18539a.onError(th);
                return;
            }
            Object obj = this.f18541c;
            if (obj == null) {
                this.f18539a.onComplete();
            } else {
                this.f18541c = null;
                this.f18539a.onSuccess(obj);
            }
        }
    }

    public o(cc.n nVar, cc.r rVar) {
        super(nVar);
        this.f18538b = rVar;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18499a.a(new a(lVar, this.f18538b));
    }
}
