package oc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.g f17770c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends vc.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ic.g f17771f;

        public a(lc.a aVar, ic.g gVar) {
            super(aVar);
            this.f17771f = gVar;
        }

        @Override // lc.a
        public boolean d(Object obj) {
            if (this.f23359d) {
                return false;
            }
            if (this.f23360e != 0) {
                return this.f23356a.d(null);
            }
            try {
                return this.f17771f.test(obj) && this.f23356a.d(obj);
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
            if (d(obj)) {
                return;
            }
            this.f23357b.request(1L);
        }

        @Override // lc.i
        public Object poll() {
            lc.f fVar = this.f23358c;
            ic.g gVar = this.f17771f;
            while (true) {
                Object objPoll = fVar.poll();
                if (objPoll == null) {
                    return null;
                }
                if (gVar.test(objPoll)) {
                    return objPoll;
                }
                if (this.f23360e == 2) {
                    fVar.request(1L);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends vc.b implements lc.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ic.g f17772f;

        public b(kh.b bVar, ic.g gVar) {
            super(bVar);
            this.f17772f = gVar;
        }

        @Override // lc.a
        public boolean d(Object obj) {
            if (this.f23364d) {
                return false;
            }
            if (this.f23365e != 0) {
                this.f23361a.onNext(null);
                return true;
            }
            try {
                boolean zTest = this.f17772f.test(obj);
                if (zTest) {
                    this.f23361a.onNext(obj);
                }
                return zTest;
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
            if (d(obj)) {
                return;
            }
            this.f23362b.request(1L);
        }

        @Override // lc.i
        public Object poll() {
            lc.f fVar = this.f23363c;
            ic.g gVar = this.f17772f;
            while (true) {
                Object objPoll = fVar.poll();
                if (objPoll == null) {
                    return null;
                }
                if (gVar.test(objPoll)) {
                    return objPoll;
                }
                if (this.f23365e == 2) {
                    fVar.request(1L);
                }
            }
        }
    }

    public h(cc.f fVar, ic.g gVar) {
        super(fVar);
        this.f17770c = gVar;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        if (bVar instanceof lc.a) {
            this.f17703b.H(new a((lc.a) bVar, this.f17770c));
        } else {
            this.f17703b.H(new b(bVar, this.f17770c));
        }
    }
}
