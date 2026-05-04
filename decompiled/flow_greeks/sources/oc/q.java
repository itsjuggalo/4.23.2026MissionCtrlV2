package oc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.e f17852c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends vc.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ic.e f17853f;

        public a(lc.a aVar, ic.e eVar) {
            super(aVar);
            this.f17853f = eVar;
        }

        @Override // lc.a
        public boolean d(Object obj) {
            if (this.f23359d) {
                return false;
            }
            try {
                return this.f23356a.d(kc.b.d(this.f17853f.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                e(th);
                return true;
            }
        }

        @Override // lc.e
        public int h(int i10) {
            return f(i10);
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f23359d) {
                return;
            }
            if (this.f23360e != 0) {
                this.f23356a.onNext(null);
                return;
            }
            try {
                this.f23356a.onNext(kc.b.d(this.f17853f.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                e(th);
            }
        }

        @Override // lc.i
        public Object poll() {
            Object objPoll = this.f23358c.poll();
            if (objPoll != null) {
                return kc.b.d(this.f17853f.apply(objPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends vc.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ic.e f17854f;

        public b(kh.b bVar, ic.e eVar) {
            super(bVar);
            this.f17854f = eVar;
        }

        @Override // lc.e
        public int h(int i10) {
            return f(i10);
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f23364d) {
                return;
            }
            if (this.f23365e != 0) {
                this.f23361a.onNext(null);
                return;
            }
            try {
                this.f23361a.onNext(kc.b.d(this.f17854f.apply(obj), "The mapper function returned a null value."));
            } catch (Throwable th) {
                e(th);
            }
        }

        @Override // lc.i
        public Object poll() {
            Object objPoll = this.f23363c.poll();
            if (objPoll != null) {
                return kc.b.d(this.f17854f.apply(objPoll), "The mapper function returned a null value.");
            }
            return null;
        }
    }

    public q(cc.f fVar, ic.e eVar) {
        super(fVar);
        this.f17852c = eVar;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        if (bVar instanceof lc.a) {
            this.f17703b.H(new a((lc.a) bVar, this.f17852c));
        } else {
            this.f17703b.H(new b(bVar, this.f17852c));
        }
    }
}
