package oc;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends oc.a {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicLong implements cc.i, kh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17893a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public kh.c f17894b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f17895c;

        public a(kh.b bVar) {
            this.f17893a = bVar;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17894b, cVar)) {
                this.f17894b = cVar;
                this.f17893a.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // kh.c
        public void cancel() {
            this.f17894b.cancel();
        }

        @Override // kh.b
        public void onComplete() {
            if (this.f17895c) {
                return;
            }
            this.f17895c = true;
            this.f17893a.onComplete();
        }

        @Override // kh.b
        public void onError(Throwable th) {
            if (this.f17895c) {
                yc.a.q(th);
            } else {
                this.f17895c = true;
                this.f17893a.onError(th);
            }
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f17895c) {
                return;
            }
            if (get() != 0) {
                this.f17893a.onNext(obj);
                xc.d.d(this, 1L);
            } else {
                this.f17894b.cancel();
                onError(new gc.c("could not emit value due to lack of requests"));
            }
        }

        @Override // kh.c
        public void request(long j10) {
            if (wc.g.l(j10)) {
                xc.d.a(this, j10);
            }
        }
    }

    public u(cc.f fVar) {
        super(fVar);
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f17703b.H(new a(bVar));
    }
}
