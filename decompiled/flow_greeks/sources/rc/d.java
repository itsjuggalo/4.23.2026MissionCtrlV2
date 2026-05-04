package rc;

import cc.p;
import cc.q;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends cc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f19793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.e f19794b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f19795c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicInteger implements fc.b, q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.c f19796a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ic.e f19798c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f19799d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public fc.b f19801f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f19802g;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final xc.c f19797b = new xc.c();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final fc.a f19800e = new fc.a();

        /* JADX INFO: renamed from: rc.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class C0346a extends AtomicReference implements cc.c, fc.b {
            public C0346a() {
            }

            @Override // cc.c
            public void a(fc.b bVar) {
                jc.b.l(this, bVar);
            }

            @Override // fc.b
            public boolean c() {
                return jc.b.b((fc.b) get());
            }

            @Override // fc.b
            public void dispose() {
                jc.b.a(this);
            }

            @Override // cc.c
            public void onComplete() {
                a.this.b(this);
            }

            @Override // cc.c
            public void onError(Throwable th) {
                a.this.d(this, th);
            }
        }

        public a(cc.c cVar, ic.e eVar, boolean z10) {
            this.f19796a = cVar;
            this.f19798c = eVar;
            this.f19799d = z10;
            lazySet(1);
        }

        @Override // cc.q
        public void a(fc.b bVar) {
            if (jc.b.m(this.f19801f, bVar)) {
                this.f19801f = bVar;
                this.f19796a.a(this);
            }
        }

        public void b(C0346a c0346a) {
            this.f19800e.b(c0346a);
            onComplete();
        }

        @Override // fc.b
        public boolean c() {
            return this.f19801f.c();
        }

        public void d(C0346a c0346a, Throwable th) {
            this.f19800e.b(c0346a);
            onError(th);
        }

        @Override // fc.b
        public void dispose() {
            this.f19802g = true;
            this.f19801f.dispose();
            this.f19800e.dispose();
        }

        @Override // cc.q
        public void onComplete() {
            if (decrementAndGet() == 0) {
                Throwable thB = this.f19797b.b();
                if (thB != null) {
                    this.f19796a.onError(thB);
                } else {
                    this.f19796a.onComplete();
                }
            }
        }

        @Override // cc.q
        public void onError(Throwable th) {
            if (!this.f19797b.a(th)) {
                yc.a.q(th);
                return;
            }
            if (this.f19799d) {
                if (decrementAndGet() == 0) {
                    this.f19796a.onError(this.f19797b.b());
                    return;
                }
                return;
            }
            dispose();
            if (getAndSet(0) > 0) {
                this.f19796a.onError(this.f19797b.b());
            }
        }

        @Override // cc.q
        public void onNext(Object obj) {
            try {
                cc.d dVar = (cc.d) kc.b.d(this.f19798c.apply(obj), "The mapper returned a null CompletableSource");
                getAndIncrement();
                C0346a c0346a = new C0346a();
                if (this.f19802g || !this.f19800e.d(c0346a)) {
                    return;
                }
                dVar.a(c0346a);
            } catch (Throwable th) {
                gc.b.b(th);
                this.f19801f.dispose();
                onError(th);
            }
        }
    }

    public d(p pVar, ic.e eVar, boolean z10) {
        this.f19793a = pVar;
        this.f19794b = eVar;
        this.f19795c = z10;
    }

    @Override // cc.b
    public void m(cc.c cVar) {
        this.f19793a.b(new a(cVar, this.f19794b, this.f19795c));
    }
}
