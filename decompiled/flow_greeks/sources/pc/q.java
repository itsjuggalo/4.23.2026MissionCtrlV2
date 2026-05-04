package pc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends pc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.d f18550b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.d f18551c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ic.d f18552d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ic.a f18553e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ic.a f18554f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ic.a f18555g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.l, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18556a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f18557b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public fc.b f18558c;

        public a(cc.l lVar, q qVar) {
            this.f18556a = lVar;
            this.f18557b = qVar;
        }

        @Override // cc.l
        public void a(fc.b bVar) {
            if (jc.b.m(this.f18558c, bVar)) {
                try {
                    this.f18557b.f18550b.accept(bVar);
                    this.f18558c = bVar;
                    this.f18556a.a(this);
                } catch (Throwable th) {
                    gc.b.b(th);
                    bVar.dispose();
                    this.f18558c = jc.b.DISPOSED;
                    jc.c.l(th, this.f18556a);
                }
            }
        }

        public void b() {
            try {
                this.f18557b.f18554f.run();
            } catch (Throwable th) {
                gc.b.b(th);
                yc.a.q(th);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f18558c.c();
        }

        public void d(Throwable th) {
            try {
                this.f18557b.f18552d.accept(th);
            } catch (Throwable th2) {
                gc.b.b(th2);
                th = new gc.a(th, th2);
            }
            this.f18558c = jc.b.DISPOSED;
            this.f18556a.onError(th);
            b();
        }

        @Override // fc.b
        public void dispose() {
            try {
                this.f18557b.f18555g.run();
            } catch (Throwable th) {
                gc.b.b(th);
                yc.a.q(th);
            }
            this.f18558c.dispose();
            this.f18558c = jc.b.DISPOSED;
        }

        @Override // cc.l
        public void onComplete() {
            fc.b bVar = this.f18558c;
            jc.b bVar2 = jc.b.DISPOSED;
            if (bVar == bVar2) {
                return;
            }
            try {
                this.f18557b.f18553e.run();
                this.f18558c = bVar2;
                this.f18556a.onComplete();
                b();
            } catch (Throwable th) {
                gc.b.b(th);
                d(th);
            }
        }

        @Override // cc.l
        public void onError(Throwable th) {
            if (this.f18558c == jc.b.DISPOSED) {
                yc.a.q(th);
            } else {
                d(th);
            }
        }

        @Override // cc.l
        public void onSuccess(Object obj) {
            fc.b bVar = this.f18558c;
            jc.b bVar2 = jc.b.DISPOSED;
            if (bVar == bVar2) {
                return;
            }
            try {
                this.f18557b.f18551c.accept(obj);
                this.f18558c = bVar2;
                this.f18556a.onSuccess(obj);
                b();
            } catch (Throwable th) {
                gc.b.b(th);
                d(th);
            }
        }
    }

    public q(cc.n nVar, ic.d dVar, ic.d dVar2, ic.d dVar3, ic.a aVar, ic.a aVar2, ic.a aVar3) {
        super(nVar);
        this.f18550b = dVar;
        this.f18551c = dVar2;
        this.f18552d = dVar3;
        this.f18553e = aVar;
        this.f18554f = aVar2;
        this.f18555g = aVar3;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        this.f18499a.a(new a(lVar, this));
    }
}
