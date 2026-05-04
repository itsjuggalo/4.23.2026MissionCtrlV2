package oc;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class s extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f17874c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17875d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f17876e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ic.a f17877f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends wc.a implements cc.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17878a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final lc.h f17879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ic.a f17881d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public kh.c f17882e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile boolean f17883f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f17884g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Throwable f17885h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AtomicLong f17886i = new AtomicLong();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f17887j;

        public a(kh.b bVar, int i10, boolean z10, boolean z11, ic.a aVar) {
            this.f17878a = bVar;
            this.f17881d = aVar;
            this.f17880c = z11;
            this.f17879b = z10 ? new tc.b(i10) : new tc.a(i10);
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17882e, cVar)) {
                this.f17882e = cVar;
                this.f17878a.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        public boolean c(boolean z10, boolean z11, kh.b bVar) {
            if (this.f17883f) {
                this.f17879b.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.f17880c) {
                if (!z11) {
                    return false;
                }
                Throwable th = this.f17885h;
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.onComplete();
                }
                return true;
            }
            Throwable th2 = this.f17885h;
            if (th2 != null) {
                this.f17879b.clear();
                bVar.onError(th2);
                return true;
            }
            if (!z11) {
                return false;
            }
            bVar.onComplete();
            return true;
        }

        @Override // kh.c
        public void cancel() {
            if (this.f17883f) {
                return;
            }
            this.f17883f = true;
            this.f17882e.cancel();
            if (this.f17887j || getAndIncrement() != 0) {
                return;
            }
            this.f17879b.clear();
        }

        @Override // lc.i
        public void clear() {
            this.f17879b.clear();
        }

        public void e() {
            if (getAndIncrement() == 0) {
                lc.h hVar = this.f17879b;
                kh.b bVar = this.f17878a;
                int iAddAndGet = 1;
                while (!c(this.f17884g, hVar.isEmpty(), bVar)) {
                    long j10 = this.f17886i.get();
                    long j11 = 0;
                    while (j11 != j10) {
                        boolean z10 = this.f17884g;
                        Object objPoll = hVar.poll();
                        boolean z11 = objPoll == null;
                        if (c(z10, z11, bVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        bVar.onNext(objPoll);
                        j11++;
                    }
                    if (j11 == j10 && c(this.f17884g, hVar.isEmpty(), bVar)) {
                        return;
                    }
                    if (j11 != 0 && j10 != Long.MAX_VALUE) {
                        this.f17886i.addAndGet(-j11);
                    }
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
        }

        @Override // lc.e
        public int h(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.f17887j = true;
            return 2;
        }

        @Override // lc.i
        public boolean isEmpty() {
            return this.f17879b.isEmpty();
        }

        @Override // kh.b
        public void onComplete() {
            this.f17884g = true;
            if (this.f17887j) {
                this.f17878a.onComplete();
            } else {
                e();
            }
        }

        @Override // kh.b
        public void onError(Throwable th) {
            this.f17885h = th;
            this.f17884g = true;
            if (this.f17887j) {
                this.f17878a.onError(th);
            } else {
                e();
            }
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f17879b.offer(obj)) {
                if (this.f17887j) {
                    this.f17878a.onNext(null);
                    return;
                } else {
                    e();
                    return;
                }
            }
            this.f17882e.cancel();
            gc.c cVar = new gc.c("Buffer is full");
            try {
                this.f17881d.run();
            } catch (Throwable th) {
                gc.b.b(th);
                cVar.initCause(th);
            }
            onError(cVar);
        }

        @Override // lc.i
        public Object poll() {
            return this.f17879b.poll();
        }

        @Override // kh.c
        public void request(long j10) {
            if (this.f17887j || !wc.g.l(j10)) {
                return;
            }
            xc.d.a(this.f17886i, j10);
            e();
        }
    }

    public s(cc.f fVar, int i10, boolean z10, boolean z11, ic.a aVar) {
        super(fVar);
        this.f17874c = i10;
        this.f17875d = z10;
        this.f17876e = z11;
        this.f17877f = aVar;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f17703b.H(new a(bVar, this.f17874c, this.f17875d, this.f17876e, this.f17877f));
    }
}
