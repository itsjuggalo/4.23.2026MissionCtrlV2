package oc;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.d f17741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ic.d f17742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ic.a f17743e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ic.a f17744f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends vc.a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ic.d f17745f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ic.d f17746g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ic.a f17747h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ic.a f17748i;

        public a(lc.a aVar, ic.d dVar, ic.d dVar2, ic.a aVar2, ic.a aVar3) {
            super(aVar);
            this.f17745f = dVar;
            this.f17746g = dVar2;
            this.f17747h = aVar2;
            this.f17748i = aVar3;
        }

        @Override // lc.a
        public boolean d(Object obj) {
            if (this.f23359d) {
                return false;
            }
            try {
                this.f17745f.accept(obj);
                return this.f23356a.d(obj);
            } catch (Throwable th) {
                e(th);
                return false;
            }
        }

        @Override // lc.e
        public int h(int i10) {
            return f(i10);
        }

        @Override // vc.a, kh.b
        public void onComplete() {
            if (this.f23359d) {
                return;
            }
            try {
                this.f17747h.run();
                this.f23359d = true;
                this.f23356a.onComplete();
                try {
                    this.f17748i.run();
                } catch (Throwable th) {
                    gc.b.b(th);
                    yc.a.q(th);
                }
            } catch (Throwable th2) {
                e(th2);
            }
        }

        @Override // vc.a, kh.b
        public void onError(Throwable th) {
            if (this.f23359d) {
                yc.a.q(th);
                return;
            }
            this.f23359d = true;
            try {
                this.f17746g.accept(th);
                this.f23356a.onError(th);
            } catch (Throwable th2) {
                gc.b.b(th2);
                this.f23356a.onError(new gc.a(th, th2));
            }
            try {
                this.f17748i.run();
            } catch (Throwable th3) {
                gc.b.b(th3);
                yc.a.q(th3);
            }
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
                this.f17745f.accept(obj);
                this.f23356a.onNext(obj);
            } catch (Throwable th) {
                e(th);
            }
        }

        @Override // lc.i
        public Object poll() throws Exception {
            gc.a aVar;
            try {
                Object objPoll = this.f23358c.poll();
                if (objPoll == null) {
                    if (this.f23360e == 1) {
                        this.f17747h.run();
                        this.f17748i.run();
                    }
                    return objPoll;
                }
                try {
                    this.f17745f.accept(objPoll);
                    this.f17748i.run();
                    return objPoll;
                } catch (Throwable th) {
                    try {
                        gc.b.b(th);
                        try {
                            this.f17746g.accept(th);
                            throw xc.g.c(th);
                        } finally {
                        }
                    } catch (Throwable th2) {
                        this.f17748i.run();
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                gc.b.b(th3);
                try {
                    this.f17746g.accept(th3);
                    throw xc.g.c(th3);
                } finally {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends vc.b {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final ic.d f17749f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final ic.d f17750g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ic.a f17751h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final ic.a f17752i;

        public b(kh.b bVar, ic.d dVar, ic.d dVar2, ic.a aVar, ic.a aVar2) {
            super(bVar);
            this.f17749f = dVar;
            this.f17750g = dVar2;
            this.f17751h = aVar;
            this.f17752i = aVar2;
        }

        @Override // lc.e
        public int h(int i10) {
            return f(i10);
        }

        @Override // vc.b, kh.b
        public void onComplete() {
            if (this.f23364d) {
                return;
            }
            try {
                this.f17751h.run();
                this.f23364d = true;
                this.f23361a.onComplete();
                try {
                    this.f17752i.run();
                } catch (Throwable th) {
                    gc.b.b(th);
                    yc.a.q(th);
                }
            } catch (Throwable th2) {
                e(th2);
            }
        }

        @Override // vc.b, kh.b
        public void onError(Throwable th) {
            if (this.f23364d) {
                yc.a.q(th);
                return;
            }
            this.f23364d = true;
            try {
                this.f17750g.accept(th);
                this.f23361a.onError(th);
            } catch (Throwable th2) {
                gc.b.b(th2);
                this.f23361a.onError(new gc.a(th, th2));
            }
            try {
                this.f17752i.run();
            } catch (Throwable th3) {
                gc.b.b(th3);
                yc.a.q(th3);
            }
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
                this.f17749f.accept(obj);
                this.f23361a.onNext(obj);
            } catch (Throwable th) {
                e(th);
            }
        }

        @Override // lc.i
        public Object poll() throws Exception {
            gc.a aVar;
            try {
                Object objPoll = this.f23363c.poll();
                if (objPoll == null) {
                    if (this.f23365e == 1) {
                        this.f17751h.run();
                        this.f17752i.run();
                    }
                    return objPoll;
                }
                try {
                    this.f17749f.accept(objPoll);
                    this.f17752i.run();
                    return objPoll;
                } catch (Throwable th) {
                    try {
                        gc.b.b(th);
                        try {
                            this.f17750g.accept(th);
                            throw xc.g.c(th);
                        } finally {
                        }
                    } catch (Throwable th2) {
                        this.f17752i.run();
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                gc.b.b(th3);
                try {
                    this.f17750g.accept(th3);
                    throw xc.g.c(th3);
                } finally {
                }
            }
        }
    }

    public d(cc.f fVar, ic.d dVar, ic.d dVar2, ic.a aVar, ic.a aVar2) {
        super(fVar);
        this.f17741c = dVar;
        this.f17742d = dVar2;
        this.f17743e = aVar;
        this.f17744f = aVar2;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        if (bVar instanceof lc.a) {
            this.f17703b.H(new a((lc.a) bVar, this.f17741c, this.f17742d, this.f17743e, this.f17744f));
        } else {
            this.f17703b.H(new b(bVar, this.f17741c, this.f17742d, this.f17743e, this.f17744f));
        }
    }
}
