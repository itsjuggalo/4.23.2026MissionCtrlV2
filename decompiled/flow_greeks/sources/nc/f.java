package nc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends cc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.d f17011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.d f17012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.d f17013c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ic.a f17014d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ic.a f17015e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ic.a f17016f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final ic.a f17017g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class a implements cc.c, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.c f17018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public fc.b f17019b;

        public a(cc.c cVar) {
            this.f17018a = cVar;
        }

        @Override // cc.c
        public void a(fc.b bVar) {
            try {
                f.this.f17012b.accept(bVar);
                if (jc.b.m(this.f17019b, bVar)) {
                    this.f17019b = bVar;
                    this.f17018a.a(this);
                }
            } catch (Throwable th) {
                gc.b.b(th);
                bVar.dispose();
                this.f17019b = jc.b.DISPOSED;
                jc.c.k(th, this.f17018a);
            }
        }

        public void b() {
            try {
                f.this.f17016f.run();
            } catch (Throwable th) {
                gc.b.b(th);
                yc.a.q(th);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f17019b.c();
        }

        @Override // fc.b
        public void dispose() {
            try {
                f.this.f17017g.run();
            } catch (Throwable th) {
                gc.b.b(th);
                yc.a.q(th);
            }
            this.f17019b.dispose();
        }

        @Override // cc.c
        public void onComplete() {
            if (this.f17019b == jc.b.DISPOSED) {
                return;
            }
            try {
                f.this.f17014d.run();
                f.this.f17015e.run();
                this.f17018a.onComplete();
                b();
            } catch (Throwable th) {
                gc.b.b(th);
                this.f17018a.onError(th);
            }
        }

        @Override // cc.c
        public void onError(Throwable th) {
            if (this.f17019b == jc.b.DISPOSED) {
                yc.a.q(th);
                return;
            }
            try {
                f.this.f17013c.accept(th);
                f.this.f17015e.run();
            } catch (Throwable th2) {
                gc.b.b(th2);
                th = new gc.a(th, th2);
            }
            this.f17018a.onError(th);
            b();
        }
    }

    public f(cc.d dVar, ic.d dVar2, ic.d dVar3, ic.a aVar, ic.a aVar2, ic.a aVar3, ic.a aVar4) {
        this.f17011a = dVar;
        this.f17012b = dVar2;
        this.f17013c = dVar3;
        this.f17014d = aVar;
        this.f17015e = aVar2;
        this.f17016f = aVar3;
        this.f17017g = aVar4;
    }

    @Override // cc.b
    public void m(cc.c cVar) {
        this.f17011a.a(new a(cVar));
    }
}
