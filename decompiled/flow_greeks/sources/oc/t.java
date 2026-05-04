package oc;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class t extends oc.a implements ic.d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.d f17888c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicLong implements cc.i, kh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17889a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.d f17890b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public kh.c f17891c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f17892d;

        public a(kh.b bVar, ic.d dVar) {
            this.f17889a = bVar;
            this.f17890b = dVar;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17891c, cVar)) {
                this.f17891c = cVar;
                this.f17889a.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // kh.c
        public void cancel() {
            this.f17891c.cancel();
        }

        @Override // kh.b
        public void onComplete() {
            if (this.f17892d) {
                return;
            }
            this.f17892d = true;
            this.f17889a.onComplete();
        }

        @Override // kh.b
        public void onError(Throwable th) {
            if (this.f17892d) {
                yc.a.q(th);
            } else {
                this.f17892d = true;
                this.f17889a.onError(th);
            }
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f17892d) {
                return;
            }
            if (get() != 0) {
                this.f17889a.onNext(obj);
                xc.d.d(this, 1L);
                return;
            }
            try {
                this.f17890b.accept(obj);
            } catch (Throwable th) {
                gc.b.b(th);
                cancel();
                onError(th);
            }
        }

        @Override // kh.c
        public void request(long j10) {
            if (wc.g.l(j10)) {
                xc.d.a(this, j10);
            }
        }
    }

    public t(cc.f fVar) {
        super(fVar);
        this.f17888c = this;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f17703b.H(new a(bVar, this.f17888c));
    }

    @Override // ic.d
    public void accept(Object obj) {
    }
}
