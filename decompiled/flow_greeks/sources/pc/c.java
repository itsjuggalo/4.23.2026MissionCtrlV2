package pc;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends cc.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final cc.m f18503a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements cc.k, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final cc.l f18504a;

        public a(cc.l lVar) {
            this.f18504a = lVar;
        }

        public boolean a(Throwable th) {
            fc.b bVar;
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            Object obj = get();
            jc.b bVar2 = jc.b.DISPOSED;
            if (obj == bVar2 || (bVar = (fc.b) getAndSet(bVar2)) == bVar2) {
                return false;
            }
            try {
                this.f18504a.onError(th);
            } finally {
                if (bVar != null) {
                    bVar.dispose();
                }
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

        @Override // cc.k
        public void onComplete() {
            fc.b bVar;
            Object obj = get();
            jc.b bVar2 = jc.b.DISPOSED;
            if (obj == bVar2 || (bVar = (fc.b) getAndSet(bVar2)) == bVar2) {
                return;
            }
            try {
                this.f18504a.onComplete();
            } finally {
                if (bVar != null) {
                    bVar.dispose();
                }
            }
        }

        @Override // cc.k
        public void onError(Throwable th) {
            if (a(th)) {
                return;
            }
            yc.a.q(th);
        }

        @Override // cc.k
        public void onSuccess(Object obj) {
            fc.b bVar;
            Object obj2 = get();
            jc.b bVar2 = jc.b.DISPOSED;
            if (obj2 == bVar2 || (bVar = (fc.b) getAndSet(bVar2)) == bVar2) {
                return;
            }
            try {
                if (obj == null) {
                    this.f18504a.onError(new NullPointerException("onSuccess called with null. Null values are generally not allowed in 2.x operators and sources."));
                } else {
                    this.f18504a.onSuccess(obj);
                }
                if (bVar != null) {
                    bVar.dispose();
                }
            } catch (Throwable th) {
                if (bVar != null) {
                    bVar.dispose();
                }
                throw th;
            }
        }

        @Override // java.util.concurrent.atomic.AtomicReference
        public String toString() {
            return String.format("%s{%s}", a.class.getSimpleName(), super.toString());
        }
    }

    public c(cc.m mVar) {
        this.f18503a = mVar;
    }

    @Override // cc.j
    public void u(cc.l lVar) {
        a aVar = new a(lVar);
        lVar.a(aVar);
        try {
            this.f18503a.a(aVar);
        } catch (Throwable th) {
            gc.b.b(th);
            aVar.onError(th);
        }
    }
}
