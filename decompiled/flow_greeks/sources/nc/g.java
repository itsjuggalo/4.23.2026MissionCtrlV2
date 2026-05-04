package nc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends cc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.d f17021a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ic.e f17022b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements cc.c, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.c f17023a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f17024b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17025c;

        public a(cc.c cVar, ic.e eVar) {
            this.f17023a = cVar;
            this.f17024b = eVar;
        }

        @Override // cc.c
        public void a(fc.b bVar) {
            jc.b.h(this, bVar);
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
            this.f17023a.onComplete();
        }

        @Override // cc.c
        public void onError(Throwable th) {
            if (this.f17025c) {
                this.f17023a.onError(th);
                return;
            }
            this.f17025c = true;
            try {
                ((cc.d) kc.b.d(this.f17024b.apply(th), "The errorMapper returned a null CompletableSource")).a(this);
            } catch (Throwable th2) {
                gc.b.b(th2);
                this.f17023a.onError(new gc.a(th, th2));
            }
        }
    }

    public g(cc.d dVar, ic.e eVar) {
        this.f17021a = dVar;
        this.f17022b = eVar;
    }

    @Override // cc.b
    public void m(cc.c cVar) {
        a aVar = new a(cVar, this.f17022b);
        cVar.a(aVar);
        this.f17021a.a(aVar);
    }
}
