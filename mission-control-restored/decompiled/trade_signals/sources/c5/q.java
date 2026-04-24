package c5;

import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public final class q extends AbstractC1254a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final V4.d f13525b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final V4.d f13526c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final V4.d f13527d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final V4.a f13528e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final V4.a f13529f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final V4.a f13530g;

    public static final class a implements P4.l, S4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P4.l f13531a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f13532b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public S4.b f13533c;

        public a(P4.l lVar, q qVar) {
            this.f13531a = lVar;
            this.f13532b = qVar;
        }

        @Override // P4.l
        public void a() {
            S4.b bVar = this.f13533c;
            W4.b bVar2 = W4.b.DISPOSED;
            if (bVar == bVar2) {
                return;
            }
            try {
                this.f13532b.f13528e.run();
                this.f13533c = bVar2;
                this.f13531a.a();
                c();
            } catch (Throwable th) {
                T4.b.b(th);
                d(th);
            }
        }

        @Override // P4.l
        public void b(S4.b bVar) {
            if (W4.b.n(this.f13533c, bVar)) {
                try {
                    this.f13532b.f13525b.accept(bVar);
                    this.f13533c = bVar;
                    this.f13531a.b(this);
                } catch (Throwable th) {
                    T4.b.b(th);
                    bVar.dispose();
                    this.f13533c = W4.b.DISPOSED;
                    W4.c.m(th, this.f13531a);
                }
            }
        }

        public void c() {
            try {
                this.f13532b.f13529f.run();
            } catch (Throwable th) {
                T4.b.b(th);
                AbstractC2283a.q(th);
            }
        }

        public void d(Throwable th) {
            try {
                this.f13532b.f13527d.accept(th);
            } catch (Throwable th2) {
                T4.b.b(th2);
                th = new T4.a(th, th2);
            }
            this.f13533c = W4.b.DISPOSED;
            this.f13531a.onError(th);
            c();
        }

        @Override // S4.b
        public void dispose() {
            try {
                this.f13532b.f13530g.run();
            } catch (Throwable th) {
                T4.b.b(th);
                AbstractC2283a.q(th);
            }
            this.f13533c.dispose();
            this.f13533c = W4.b.DISPOSED;
        }

        @Override // S4.b
        public boolean g() {
            return this.f13533c.g();
        }

        @Override // P4.l
        public void onError(Throwable th) {
            if (this.f13533c == W4.b.DISPOSED) {
                AbstractC2283a.q(th);
            } else {
                d(th);
            }
        }

        @Override // P4.l
        public void onSuccess(Object obj) {
            S4.b bVar = this.f13533c;
            W4.b bVar2 = W4.b.DISPOSED;
            if (bVar == bVar2) {
                return;
            }
            try {
                this.f13532b.f13526c.accept(obj);
                this.f13533c = bVar2;
                this.f13531a.onSuccess(obj);
                c();
            } catch (Throwable th) {
                T4.b.b(th);
                d(th);
            }
        }
    }

    public q(P4.n nVar, V4.d dVar, V4.d dVar2, V4.d dVar3, V4.a aVar, V4.a aVar2, V4.a aVar3) {
        super(nVar);
        this.f13525b = dVar;
        this.f13526c = dVar2;
        this.f13527d = dVar3;
        this.f13528e = aVar;
        this.f13529f = aVar2;
        this.f13530g = aVar3;
    }

    @Override // P4.j
    public void u(P4.l lVar) {
        this.f13474a.a(new a(lVar, this));
    }
}
