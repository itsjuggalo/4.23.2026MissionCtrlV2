package oc;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z extends cc.s implements lc.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.f f17926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Callable f17927b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements cc.i, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.t f17928a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public kh.c f17929b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Collection f17930c;

        public a(cc.t tVar, Collection collection) {
            this.f17928a = tVar;
            this.f17930c = collection;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17929b, cVar)) {
                this.f17929b = cVar;
                this.f17928a.a(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f17929b == wc.g.CANCELLED;
        }

        @Override // fc.b
        public void dispose() {
            this.f17929b.cancel();
            this.f17929b = wc.g.CANCELLED;
        }

        @Override // kh.b
        public void onComplete() {
            this.f17929b = wc.g.CANCELLED;
            this.f17928a.onSuccess(this.f17930c);
        }

        @Override // kh.b
        public void onError(Throwable th) {
            this.f17930c = null;
            this.f17929b = wc.g.CANCELLED;
            this.f17928a.onError(th);
        }

        @Override // kh.b
        public void onNext(Object obj) {
            this.f17930c.add(obj);
        }
    }

    public z(cc.f fVar) {
        this(fVar, xc.b.b());
    }

    @Override // lc.b
    public cc.f c() {
        return yc.a.k(new y(this.f17926a, this.f17927b));
    }

    @Override // cc.s
    public void j(cc.t tVar) {
        try {
            this.f17926a.H(new a(tVar, (Collection) kc.b.d(this.f17927b.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            gc.b.b(th);
            jc.c.o(th, tVar);
        }
    }

    public z(cc.f fVar, Callable callable) {
        this.f17926a = fVar;
        this.f17927b = callable;
    }
}
