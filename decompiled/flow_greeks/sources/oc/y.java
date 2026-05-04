package oc;

import java.util.Collection;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class y extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Callable f17924c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends wc.c implements cc.i, kh.c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public kh.c f17925c;

        public a(kh.b bVar, Collection collection) {
            super(bVar);
            this.f23886b = collection;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17925c, cVar)) {
                this.f17925c = cVar;
                this.f23885a.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // wc.c, kh.c
        public void cancel() {
            super.cancel();
            this.f17925c.cancel();
        }

        @Override // kh.b
        public void onComplete() {
            c(this.f23886b);
        }

        @Override // kh.b
        public void onError(Throwable th) {
            this.f23886b = null;
            this.f23885a.onError(th);
        }

        @Override // kh.b
        public void onNext(Object obj) {
            Collection collection = (Collection) this.f23886b;
            if (collection != null) {
                collection.add(obj);
            }
        }
    }

    public y(cc.f fVar, Callable callable) {
        super(fVar);
        this.f17924c = callable;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        try {
            this.f17703b.H(new a(bVar, (Collection) kc.b.d(this.f17924c.call(), "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
        } catch (Throwable th) {
            gc.b.b(th);
            wc.d.b(th, bVar);
        }
    }
}
