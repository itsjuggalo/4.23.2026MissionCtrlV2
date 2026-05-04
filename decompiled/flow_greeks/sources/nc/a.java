package nc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class a extends cc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.d f16998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cc.d f16999b;

    /* JADX INFO: renamed from: nc.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0302a implements cc.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference f17000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final cc.c f17001b;

        public C0302a(AtomicReference atomicReference, cc.c cVar) {
            this.f17000a = atomicReference;
            this.f17001b = cVar;
        }

        @Override // cc.c
        public void a(fc.b bVar) {
            jc.b.h(this.f17000a, bVar);
        }

        @Override // cc.c
        public void onComplete() {
            this.f17001b.onComplete();
        }

        @Override // cc.c
        public void onError(Throwable th) {
            this.f17001b.onError(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends AtomicReference implements cc.c, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.c f17002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final cc.d f17003b;

        public b(cc.c cVar, cc.d dVar) {
            this.f17002a = cVar;
            this.f17003b = dVar;
        }

        @Override // cc.c
        public void a(fc.b bVar) {
            if (jc.b.l(this, bVar)) {
                this.f17002a.a(this);
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

        @Override // cc.c
        public void onComplete() {
            this.f17003b.a(new C0302a(this, this.f17002a));
        }

        @Override // cc.c
        public void onError(Throwable th) {
            this.f17002a.onError(th);
        }
    }

    public a(cc.d dVar, cc.d dVar2) {
        this.f16998a = dVar;
        this.f16999b = dVar2;
    }

    @Override // cc.b
    public void m(cc.c cVar) {
        this.f16998a.a(new b(cVar, this.f16999b));
    }
}
