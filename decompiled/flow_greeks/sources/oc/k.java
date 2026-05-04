package oc;

import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.e f17819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17820d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends wc.a implements cc.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f17822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17823c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f17824d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public kh.c f17826f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public lc.i f17827g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile boolean f17828h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f17829i;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Iterator f17831k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f17832l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public int f17833m;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final AtomicReference f17830j = new AtomicReference();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicLong f17825e = new AtomicLong();

        public a(kh.b bVar, ic.e eVar, int i10) {
            this.f17821a = bVar;
            this.f17822b = eVar;
            this.f17823c = i10;
            this.f17824d = i10 - (i10 >> 2);
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17826f, cVar)) {
                this.f17826f = cVar;
                if (cVar instanceof lc.f) {
                    lc.f fVar = (lc.f) cVar;
                    int iH = fVar.h(3);
                    if (iH == 1) {
                        this.f17833m = iH;
                        this.f17827g = fVar;
                        this.f17828h = true;
                        this.f17821a.b(this);
                        return;
                    }
                    if (iH == 2) {
                        this.f17833m = iH;
                        this.f17827g = fVar;
                        this.f17821a.b(this);
                        cVar.request(this.f17823c);
                        return;
                    }
                }
                this.f17827g = new tc.a(this.f17823c);
                this.f17821a.b(this);
                cVar.request(this.f17823c);
            }
        }

        public boolean c(boolean z10, boolean z11, kh.b bVar, lc.i iVar) {
            if (this.f17829i) {
                this.f17831k = null;
                iVar.clear();
                return true;
            }
            if (!z10) {
                return false;
            }
            if (((Throwable) this.f17830j.get()) == null) {
                if (!z11) {
                    return false;
                }
                bVar.onComplete();
                return true;
            }
            Throwable thB = xc.g.b(this.f17830j);
            this.f17831k = null;
            iVar.clear();
            bVar.onError(thB);
            return true;
        }

        @Override // kh.c
        public void cancel() {
            if (this.f17829i) {
                return;
            }
            this.f17829i = true;
            this.f17826f.cancel();
            if (getAndIncrement() == 0) {
                this.f17827g.clear();
            }
        }

        @Override // lc.i
        public void clear() {
            this.f17831k = null;
            this.f17827g.clear();
        }

        public void e(boolean z10) {
            if (z10) {
                int i10 = this.f17832l + 1;
                if (i10 != this.f17824d) {
                    this.f17832l = i10;
                } else {
                    this.f17832l = 0;
                    this.f17826f.request(i10);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:70:0x0128 A[PHI: r6
          0x0128: PHI (r6v4 java.util.Iterator) = (r6v3 java.util.Iterator), (r6v6 java.util.Iterator) binds: [B:31:0x0081, B:68:0x0123] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void f() {
            /*
                Method dump skipped, instruction units count: 304
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.k.a.f():void");
        }

        @Override // lc.e
        public int h(int i10) {
            return ((i10 & 1) == 0 || this.f17833m != 1) ? 0 : 1;
        }

        @Override // lc.i
        public boolean isEmpty() {
            return this.f17831k == null && this.f17827g.isEmpty();
        }

        @Override // kh.b
        public void onComplete() {
            if (this.f17828h) {
                return;
            }
            this.f17828h = true;
            f();
        }

        @Override // kh.b
        public void onError(Throwable th) {
            if (this.f17828h || !xc.g.a(this.f17830j, th)) {
                yc.a.q(th);
            } else {
                this.f17828h = true;
                f();
            }
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f17828h) {
                return;
            }
            if (this.f17833m != 0 || this.f17827g.offer(obj)) {
                f();
            } else {
                onError(new gc.c("Queue is full?!"));
            }
        }

        @Override // lc.i
        public Object poll() {
            Iterator it = this.f17831k;
            while (true) {
                if (it == null) {
                    Object objPoll = this.f17827g.poll();
                    if (objPoll != null) {
                        it = ((Iterable) this.f17822b.apply(objPoll)).iterator();
                        if (it.hasNext()) {
                            this.f17831k = it;
                            break;
                        }
                        it = null;
                    } else {
                        return null;
                    }
                } else {
                    break;
                }
            }
            Object objD = kc.b.d(it.next(), "The iterator returned a null value");
            if (!it.hasNext()) {
                this.f17831k = null;
            }
            return objD;
        }

        @Override // kh.c
        public void request(long j10) {
            if (wc.g.l(j10)) {
                xc.d.a(this.f17825e, j10);
                f();
            }
        }
    }

    public k(cc.f fVar, ic.e eVar, int i10) {
        super(fVar);
        this.f17819c = eVar;
        this.f17820d = i10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // cc.f
    public void I(kh.b bVar) {
        cc.f fVar = this.f17703b;
        if (!(fVar instanceof Callable)) {
            fVar.H(new a(bVar, this.f17819c, this.f17820d));
            return;
        }
        try {
            Object objCall = ((Callable) fVar).call();
            if (objCall == null) {
                wc.d.a(bVar);
                return;
            }
            try {
                m.K(bVar, ((Iterable) this.f17819c.apply(objCall)).iterator());
            } catch (Throwable th) {
                gc.b.b(th);
                wc.d.b(th, bVar);
            }
        } catch (Throwable th2) {
            gc.b.b(th2);
            wc.d.b(th2, bVar);
        }
    }
}
