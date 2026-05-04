package oc;

import cc.r;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cc.r f17855c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17856d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17857e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a extends wc.a implements cc.i, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r.b f17858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f17861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicLong f17862e = new AtomicLong();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public kh.c f17863f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public lc.i f17864g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile boolean f17865h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f17866i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public Throwable f17867j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f17868k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public long f17869l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public boolean f17870m;

        public a(r.b bVar, boolean z10, int i10) {
            this.f17858a = bVar;
            this.f17859b = z10;
            this.f17860c = i10;
            this.f17861d = i10 - (i10 >> 2);
        }

        public final boolean c(boolean z10, boolean z11, kh.b bVar) {
            if (this.f17865h) {
                clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (this.f17859b) {
                if (!z11) {
                    return false;
                }
                this.f17865h = true;
                Throwable th = this.f17867j;
                if (th != null) {
                    bVar.onError(th);
                } else {
                    bVar.onComplete();
                }
                this.f17858a.dispose();
                return true;
            }
            Throwable th2 = this.f17867j;
            if (th2 != null) {
                this.f17865h = true;
                clear();
                bVar.onError(th2);
                this.f17858a.dispose();
                return true;
            }
            if (!z11) {
                return false;
            }
            this.f17865h = true;
            bVar.onComplete();
            this.f17858a.dispose();
            return true;
        }

        @Override // kh.c
        public final void cancel() {
            if (this.f17865h) {
                return;
            }
            this.f17865h = true;
            this.f17863f.cancel();
            this.f17858a.dispose();
            if (this.f17870m || getAndIncrement() != 0) {
                return;
            }
            this.f17864g.clear();
        }

        @Override // lc.i
        public final void clear() {
            this.f17864g.clear();
        }

        public abstract void e();

        public abstract void f();

        public abstract void g();

        @Override // lc.e
        public final int h(int i10) {
            if ((i10 & 2) == 0) {
                return 0;
            }
            this.f17870m = true;
            return 2;
        }

        public final void i() {
            if (getAndIncrement() != 0) {
                return;
            }
            this.f17858a.b(this);
        }

        @Override // lc.i
        public final boolean isEmpty() {
            return this.f17864g.isEmpty();
        }

        @Override // kh.b
        public final void onComplete() {
            if (this.f17866i) {
                return;
            }
            this.f17866i = true;
            i();
        }

        @Override // kh.b
        public final void onError(Throwable th) {
            if (this.f17866i) {
                yc.a.q(th);
                return;
            }
            this.f17867j = th;
            this.f17866i = true;
            i();
        }

        @Override // kh.b
        public final void onNext(Object obj) {
            if (this.f17866i) {
                return;
            }
            if (this.f17868k == 2) {
                i();
                return;
            }
            if (!this.f17864g.offer(obj)) {
                this.f17863f.cancel();
                this.f17867j = new gc.c("Queue is full?!");
                this.f17866i = true;
            }
            i();
        }

        @Override // kh.c
        public final void request(long j10) {
            if (wc.g.l(j10)) {
                xc.d.a(this.f17862e, j10);
                i();
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.f17870m) {
                f();
            } else if (this.f17868k == 1) {
                g();
            } else {
                e();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends a {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final lc.a f17871n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public long f17872o;

        public b(lc.a aVar, r.b bVar, boolean z10, int i10) {
            super(bVar, z10, i10);
            this.f17871n = aVar;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17863f, cVar)) {
                this.f17863f = cVar;
                if (cVar instanceof lc.f) {
                    lc.f fVar = (lc.f) cVar;
                    int iH = fVar.h(7);
                    if (iH == 1) {
                        this.f17868k = 1;
                        this.f17864g = fVar;
                        this.f17866i = true;
                        this.f17871n.b(this);
                        return;
                    }
                    if (iH == 2) {
                        this.f17868k = 2;
                        this.f17864g = fVar;
                        this.f17871n.b(this);
                        cVar.request(this.f17860c);
                        return;
                    }
                }
                this.f17864g = new tc.a(this.f17860c);
                this.f17871n.b(this);
                cVar.request(this.f17860c);
            }
        }

        @Override // oc.r.a
        public void e() {
            lc.a aVar = this.f17871n;
            lc.i iVar = this.f17864g;
            long j10 = this.f17869l;
            long j11 = this.f17872o;
            int iAddAndGet = 1;
            while (true) {
                long j12 = this.f17862e.get();
                while (j10 != j12) {
                    boolean z10 = this.f17866i;
                    try {
                        Object objPoll = iVar.poll();
                        boolean z11 = objPoll == null;
                        if (c(z10, z11, aVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        if (aVar.d(objPoll)) {
                            j10++;
                        }
                        j11++;
                        if (j11 == this.f17861d) {
                            this.f17863f.request(j11);
                            j11 = 0;
                        }
                    } catch (Throwable th) {
                        gc.b.b(th);
                        this.f17865h = true;
                        this.f17863f.cancel();
                        iVar.clear();
                        aVar.onError(th);
                        this.f17858a.dispose();
                        return;
                    }
                }
                if (j10 == j12 && c(this.f17866i, iVar.isEmpty(), aVar)) {
                    return;
                }
                int i10 = get();
                if (iAddAndGet == i10) {
                    this.f17869l = j10;
                    this.f17872o = j11;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i10;
                }
            }
        }

        @Override // oc.r.a
        public void f() {
            int iAddAndGet = 1;
            while (!this.f17865h) {
                boolean z10 = this.f17866i;
                this.f17871n.onNext(null);
                if (z10) {
                    this.f17865h = true;
                    Throwable th = this.f17867j;
                    if (th != null) {
                        this.f17871n.onError(th);
                    } else {
                        this.f17871n.onComplete();
                    }
                    this.f17858a.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // oc.r.a
        public void g() {
            lc.a aVar = this.f17871n;
            lc.i iVar = this.f17864g;
            long j10 = this.f17869l;
            int iAddAndGet = 1;
            while (true) {
                long j11 = this.f17862e.get();
                while (j10 != j11) {
                    try {
                        Object objPoll = iVar.poll();
                        if (this.f17865h) {
                            return;
                        }
                        if (objPoll == null) {
                            this.f17865h = true;
                            aVar.onComplete();
                            this.f17858a.dispose();
                            return;
                        } else if (aVar.d(objPoll)) {
                            j10++;
                        }
                    } catch (Throwable th) {
                        gc.b.b(th);
                        this.f17865h = true;
                        this.f17863f.cancel();
                        aVar.onError(th);
                        this.f17858a.dispose();
                        return;
                    }
                }
                if (this.f17865h) {
                    return;
                }
                if (iVar.isEmpty()) {
                    this.f17865h = true;
                    aVar.onComplete();
                    this.f17858a.dispose();
                    return;
                } else {
                    int i10 = get();
                    if (iAddAndGet == i10) {
                        this.f17869l = j10;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i10;
                    }
                }
            }
        }

        @Override // lc.i
        public Object poll() {
            Object objPoll = this.f17864g.poll();
            if (objPoll != null && this.f17868k != 1) {
                long j10 = this.f17872o + 1;
                if (j10 == this.f17861d) {
                    this.f17872o = 0L;
                    this.f17863f.request(j10);
                    return objPoll;
                }
                this.f17872o = j10;
            }
            return objPoll;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends a implements cc.i {

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final kh.b f17873n;

        public c(kh.b bVar, r.b bVar2, boolean z10, int i10) {
            super(bVar2, z10, i10);
            this.f17873n = bVar;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17863f, cVar)) {
                this.f17863f = cVar;
                if (cVar instanceof lc.f) {
                    lc.f fVar = (lc.f) cVar;
                    int iH = fVar.h(7);
                    if (iH == 1) {
                        this.f17868k = 1;
                        this.f17864g = fVar;
                        this.f17866i = true;
                        this.f17873n.b(this);
                        return;
                    }
                    if (iH == 2) {
                        this.f17868k = 2;
                        this.f17864g = fVar;
                        this.f17873n.b(this);
                        cVar.request(this.f17860c);
                        return;
                    }
                }
                this.f17864g = new tc.a(this.f17860c);
                this.f17873n.b(this);
                cVar.request(this.f17860c);
            }
        }

        @Override // oc.r.a
        public void e() {
            kh.b bVar = this.f17873n;
            lc.i iVar = this.f17864g;
            long j10 = this.f17869l;
            int iAddAndGet = 1;
            while (true) {
                long jAddAndGet = this.f17862e.get();
                while (j10 != jAddAndGet) {
                    boolean z10 = this.f17866i;
                    try {
                        Object objPoll = iVar.poll();
                        boolean z11 = objPoll == null;
                        if (c(z10, z11, bVar)) {
                            return;
                        }
                        if (z11) {
                            break;
                        }
                        bVar.onNext(objPoll);
                        j10++;
                        if (j10 == this.f17861d) {
                            if (jAddAndGet != Long.MAX_VALUE) {
                                jAddAndGet = this.f17862e.addAndGet(-j10);
                            }
                            this.f17863f.request(j10);
                            j10 = 0;
                        }
                    } catch (Throwable th) {
                        gc.b.b(th);
                        this.f17865h = true;
                        this.f17863f.cancel();
                        iVar.clear();
                        bVar.onError(th);
                        this.f17858a.dispose();
                        return;
                    }
                }
                if (j10 == jAddAndGet && c(this.f17866i, iVar.isEmpty(), bVar)) {
                    return;
                }
                int i10 = get();
                if (iAddAndGet == i10) {
                    this.f17869l = j10;
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    iAddAndGet = i10;
                }
            }
        }

        @Override // oc.r.a
        public void f() {
            int iAddAndGet = 1;
            while (!this.f17865h) {
                boolean z10 = this.f17866i;
                this.f17873n.onNext(null);
                if (z10) {
                    this.f17865h = true;
                    Throwable th = this.f17867j;
                    if (th != null) {
                        this.f17873n.onError(th);
                    } else {
                        this.f17873n.onComplete();
                    }
                    this.f17858a.dispose();
                    return;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }

        @Override // oc.r.a
        public void g() {
            kh.b bVar = this.f17873n;
            lc.i iVar = this.f17864g;
            long j10 = this.f17869l;
            int iAddAndGet = 1;
            while (true) {
                long j11 = this.f17862e.get();
                while (j10 != j11) {
                    try {
                        Object objPoll = iVar.poll();
                        if (this.f17865h) {
                            return;
                        }
                        if (objPoll == null) {
                            this.f17865h = true;
                            bVar.onComplete();
                            this.f17858a.dispose();
                            return;
                        }
                        bVar.onNext(objPoll);
                        j10++;
                    } catch (Throwable th) {
                        gc.b.b(th);
                        this.f17865h = true;
                        this.f17863f.cancel();
                        bVar.onError(th);
                        this.f17858a.dispose();
                        return;
                    }
                }
                if (this.f17865h) {
                    return;
                }
                if (iVar.isEmpty()) {
                    this.f17865h = true;
                    bVar.onComplete();
                    this.f17858a.dispose();
                    return;
                } else {
                    int i10 = get();
                    if (iAddAndGet == i10) {
                        this.f17869l = j10;
                        iAddAndGet = addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    } else {
                        iAddAndGet = i10;
                    }
                }
            }
        }

        @Override // lc.i
        public Object poll() {
            Object objPoll = this.f17864g.poll();
            if (objPoll != null && this.f17868k != 1) {
                long j10 = this.f17869l + 1;
                if (j10 == this.f17861d) {
                    this.f17869l = 0L;
                    this.f17863f.request(j10);
                    return objPoll;
                }
                this.f17869l = j10;
            }
            return objPoll;
        }
    }

    public r(cc.f fVar, cc.r rVar, boolean z10, int i10) {
        super(fVar);
        this.f17855c = rVar;
        this.f17856d = z10;
        this.f17857e = i10;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        r.b bVarB = this.f17855c.b();
        if (bVar instanceof lc.a) {
            this.f17703b.H(new b((lc.a) bVar, bVarB, this.f17856d, this.f17857e));
        } else {
            this.f17703b.H(new c(bVar, bVarB, this.f17856d, this.f17857e));
        }
    }
}
