package oc;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class e extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f17753c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f17754d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17755e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends wc.c implements cc.i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f17756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Object f17757d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f17758e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public kh.c f17759f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f17760g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f17761h;

        public a(kh.b bVar, long j10, Object obj, boolean z10) {
            super(bVar);
            this.f17756c = j10;
            this.f17757d = obj;
            this.f17758e = z10;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17759f, cVar)) {
                this.f17759f = cVar;
                this.f23885a.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        @Override // wc.c, kh.c
        public void cancel() {
            super.cancel();
            this.f17759f.cancel();
        }

        @Override // kh.b
        public void onComplete() {
            if (this.f17761h) {
                return;
            }
            this.f17761h = true;
            Object obj = this.f17757d;
            if (obj != null) {
                c(obj);
            } else if (this.f17758e) {
                this.f23885a.onError(new NoSuchElementException());
            } else {
                this.f23885a.onComplete();
            }
        }

        @Override // kh.b
        public void onError(Throwable th) {
            if (this.f17761h) {
                yc.a.q(th);
            } else {
                this.f17761h = true;
                this.f23885a.onError(th);
            }
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f17761h) {
                return;
            }
            long j10 = this.f17760g;
            if (j10 != this.f17756c) {
                this.f17760g = j10 + 1;
                return;
            }
            this.f17761h = true;
            this.f17759f.cancel();
            c(obj);
        }
    }

    public e(cc.f fVar, long j10, Object obj, boolean z10) {
        super(fVar);
        this.f17753c = j10;
        this.f17754d = obj;
        this.f17755e = z10;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f17703b.H(new a(bVar, this.f17753c, this.f17754d, this.f17755e));
    }
}
