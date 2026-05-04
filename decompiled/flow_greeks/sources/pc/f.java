package pc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends cc.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.u f18510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.g f18511b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.t, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18512a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.g f18513b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fc.b f18514c;

        public a(cc.l lVar, ic.g gVar) {
            this.f18512a = lVar;
            this.f18513b = gVar;
        }

        @Override // cc.t
        public void a(fc.b bVar) {
            if (jc.b.m(this.f18514c, bVar)) {
                this.f18514c = bVar;
                this.f18512a.a(this);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f18514c.c();
        }

        @Override // fc.b
        public void dispose() {
            fc.b bVar = this.f18514c;
            this.f18514c = jc.b.DISPOSED;
            bVar.dispose();
        }

        @Override // cc.t
        public void onError(Throwable th) {
            this.f18512a.onError(th);
        }

        @Override // cc.t
        public void onSuccess(Object obj) {
            try {
                if (this.f18513b.test(obj)) {
                    this.f18512a.onSuccess(obj);
                } else {
                    this.f18512a.onComplete();
                }
            } catch (Throwable th) {
                gc.b.b(th);
                this.f18512a.onError(th);
            }
        }
    }

    public f(cc.u uVar, ic.g gVar) {
        this.f18510a = uVar;
        this.f18511b = gVar;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18510a.b(new a(lVar, this.f18511b));
    }
}
