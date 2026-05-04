package oc;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.e f17773c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17774d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17775e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f17776f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicReference implements cc.i, fc.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f17777a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final b f17778b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17779c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f17780d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f17781e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile lc.i f17782f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public long f17783g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f17784h;

        public a(b bVar, long j10) {
            this.f17777a = j10;
            this.f17778b = bVar;
            int i10 = bVar.f17791e;
            this.f17780d = i10;
            this.f17779c = i10 >> 2;
        }

        public void a(long j10) {
            if (this.f17784h != 1) {
                long j11 = this.f17783g + j10;
                if (j11 < this.f17779c) {
                    this.f17783g = j11;
                } else {
                    this.f17783g = 0L;
                    ((kh.c) get()).request(j11);
                }
            }
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.k(this, cVar)) {
                if (cVar instanceof lc.f) {
                    lc.f fVar = (lc.f) cVar;
                    int iH = fVar.h(7);
                    if (iH == 1) {
                        this.f17784h = iH;
                        this.f17782f = fVar;
                        this.f17781e = true;
                        this.f17778b.g();
                        return;
                    }
                    if (iH == 2) {
                        this.f17784h = iH;
                        this.f17782f = fVar;
                    }
                }
                cVar.request(this.f17780d);
            }
        }

        @Override // fc.b
        public boolean c() {
            return get() == wc.g.CANCELLED;
        }

        @Override // fc.b
        public void dispose() {
            wc.g.a(this);
        }

        @Override // kh.b
        public void onComplete() {
            this.f17781e = true;
            this.f17778b.g();
        }

        @Override // kh.b
        public void onError(Throwable th) {
            lazySet(wc.g.CANCELLED);
            this.f17778b.k(this, th);
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f17784h != 2) {
                this.f17778b.m(obj, this);
            } else {
                this.f17778b.g();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends AtomicInteger implements cc.i, kh.c {

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public static final a[] f17785r = new a[0];

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public static final a[] f17786s = new a[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17787a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ic.e f17788b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f17789c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f17790d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f17791e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile lc.h f17792f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public volatile boolean f17793g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final xc.c f17794h = new xc.c();

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public volatile boolean f17795i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final AtomicReference f17796j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final AtomicLong f17797k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public kh.c f17798l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public long f17799m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public long f17800n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public int f17801o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f17802p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public final int f17803q;

        public b(kh.b bVar, ic.e eVar, boolean z10, int i10, int i11) {
            AtomicReference atomicReference = new AtomicReference();
            this.f17796j = atomicReference;
            this.f17797k = new AtomicLong();
            this.f17787a = bVar;
            this.f17788b = eVar;
            this.f17789c = z10;
            this.f17790d = i10;
            this.f17791e = i11;
            this.f17803q = Math.max(1, i10 >> 1);
            atomicReference.lazySet(f17785r);
        }

        public boolean a(a aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.f17796j.get();
                if (aVarArr == f17786s) {
                    aVar.dispose();
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!com.amazon.a.a.l.d.a(this.f17796j, aVarArr, aVarArr2));
            return true;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17798l, cVar)) {
                this.f17798l = cVar;
                this.f17787a.b(this);
                if (this.f17795i) {
                    return;
                }
                int i10 = this.f17790d;
                if (i10 == Integer.MAX_VALUE) {
                    cVar.request(Long.MAX_VALUE);
                } else {
                    cVar.request(i10);
                }
            }
        }

        public boolean c() {
            if (this.f17795i) {
                e();
                return true;
            }
            if (this.f17789c || this.f17794h.get() == null) {
                return false;
            }
            e();
            Throwable thB = this.f17794h.b();
            if (thB != xc.g.f24803a) {
                this.f17787a.onError(thB);
            }
            return true;
        }

        @Override // kh.c
        public void cancel() {
            lc.h hVar;
            if (this.f17795i) {
                return;
            }
            this.f17795i = true;
            this.f17798l.cancel();
            f();
            if (getAndIncrement() != 0 || (hVar = this.f17792f) == null) {
                return;
            }
            hVar.clear();
        }

        public void e() {
            lc.h hVar = this.f17792f;
            if (hVar != null) {
                hVar.clear();
            }
        }

        public void f() {
            a[] aVarArr;
            a[] aVarArr2 = (a[]) this.f17796j.get();
            a[] aVarArr3 = f17786s;
            if (aVarArr2 == aVarArr3 || (aVarArr = (a[]) this.f17796j.getAndSet(aVarArr3)) == aVarArr3) {
                return;
            }
            for (a aVar : aVarArr) {
                aVar.dispose();
            }
            Throwable thB = this.f17794h.b();
            if (thB == null || thB == xc.g.f24803a) {
                return;
            }
            yc.a.q(thB);
        }

        public void g() {
            if (getAndIncrement() == 0) {
                h();
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:155:0x018d A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:66:0x00db  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h() {
            /*
                Method dump skipped, instruction units count: 441
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.i.b.h():void");
        }

        public lc.i i(a aVar) {
            lc.i iVar = aVar.f17782f;
            if (iVar != null) {
                return iVar;
            }
            tc.a aVar2 = new tc.a(this.f17791e);
            aVar.f17782f = aVar2;
            return aVar2;
        }

        public lc.i j() {
            lc.h bVar = this.f17792f;
            if (bVar == null) {
                bVar = this.f17790d == Integer.MAX_VALUE ? new tc.b(this.f17791e) : new tc.a(this.f17790d);
                this.f17792f = bVar;
            }
            return bVar;
        }

        public void k(a aVar, Throwable th) {
            if (!this.f17794h.a(th)) {
                yc.a.q(th);
                return;
            }
            aVar.f17781e = true;
            if (!this.f17789c) {
                this.f17798l.cancel();
                for (a aVar2 : (a[]) this.f17796j.getAndSet(f17786s)) {
                    aVar2.dispose();
                }
            }
            g();
        }

        public void l(a aVar) {
            a[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = (a[]) this.f17796j.get();
                int length = aVarArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (aVarArr[i10] == aVar) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f17785r;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i10);
                    System.arraycopy(aVarArr, i10 + 1, aVarArr3, i10, (length - i10) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!com.amazon.a.a.l.d.a(this.f17796j, aVarArr, aVarArr2));
        }

        public void m(Object obj, a aVar) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j10 = this.f17797k.get();
                lc.i iVarI = aVar.f17782f;
                if (j10 == 0 || !(iVarI == null || iVarI.isEmpty())) {
                    if (iVarI == null) {
                        iVarI = i(aVar);
                    }
                    if (!iVarI.offer(obj)) {
                        onError(new gc.c("Inner queue full?!"));
                        return;
                    }
                } else {
                    this.f17787a.onNext(obj);
                    if (j10 != Long.MAX_VALUE) {
                        this.f17797k.decrementAndGet();
                    }
                    aVar.a(1L);
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else {
                lc.i aVar2 = aVar.f17782f;
                if (aVar2 == null) {
                    aVar2 = new tc.a(this.f17791e);
                    aVar.f17782f = aVar2;
                }
                if (!aVar2.offer(obj)) {
                    onError(new gc.c("Inner queue full?!"));
                    return;
                } else if (getAndIncrement() != 0) {
                    return;
                }
            }
            h();
        }

        public void n(Object obj) {
            if (get() == 0 && compareAndSet(0, 1)) {
                long j10 = this.f17797k.get();
                lc.i iVarJ = this.f17792f;
                if (j10 == 0 || !(iVarJ == null || iVarJ.isEmpty())) {
                    if (iVarJ == null) {
                        iVarJ = j();
                    }
                    if (!iVarJ.offer(obj)) {
                        onError(new IllegalStateException("Scalar queue full?!"));
                        return;
                    }
                } else {
                    this.f17787a.onNext(obj);
                    if (j10 != Long.MAX_VALUE) {
                        this.f17797k.decrementAndGet();
                    }
                    if (this.f17790d != Integer.MAX_VALUE && !this.f17795i) {
                        int i10 = this.f17802p + 1;
                        this.f17802p = i10;
                        int i11 = this.f17803q;
                        if (i10 == i11) {
                            this.f17802p = 0;
                            this.f17798l.request(i11);
                        }
                    }
                }
                if (decrementAndGet() == 0) {
                    return;
                }
            } else if (!j().offer(obj)) {
                onError(new IllegalStateException("Scalar queue full?!"));
                return;
            } else if (getAndIncrement() != 0) {
                return;
            }
            h();
        }

        @Override // kh.b
        public void onComplete() {
            if (this.f17793g) {
                return;
            }
            this.f17793g = true;
            g();
        }

        @Override // kh.b
        public void onError(Throwable th) {
            if (this.f17793g) {
                yc.a.q(th);
                return;
            }
            if (!this.f17794h.a(th)) {
                yc.a.q(th);
                return;
            }
            this.f17793g = true;
            if (!this.f17789c) {
                for (a aVar : (a[]) this.f17796j.getAndSet(f17786s)) {
                    aVar.dispose();
                }
            }
            g();
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f17793g) {
                return;
            }
            try {
                kh.a aVar = (kh.a) kc.b.d(this.f17788b.apply(obj), "The mapper returned a null Publisher");
                if (!(aVar instanceof Callable)) {
                    long j10 = this.f17799m;
                    this.f17799m = 1 + j10;
                    a aVar2 = new a(this, j10);
                    if (a(aVar2)) {
                        aVar.a(aVar2);
                        return;
                    }
                    return;
                }
                try {
                    Object objCall = ((Callable) aVar).call();
                    if (objCall != null) {
                        n(objCall);
                        return;
                    }
                    if (this.f17790d == Integer.MAX_VALUE || this.f17795i) {
                        return;
                    }
                    int i10 = this.f17802p + 1;
                    this.f17802p = i10;
                    int i11 = this.f17803q;
                    if (i10 == i11) {
                        this.f17802p = 0;
                        this.f17798l.request(i11);
                    }
                } catch (Throwable th) {
                    gc.b.b(th);
                    this.f17794h.a(th);
                    g();
                }
            } catch (Throwable th2) {
                gc.b.b(th2);
                this.f17798l.cancel();
                onError(th2);
            }
        }

        @Override // kh.c
        public void request(long j10) {
            if (wc.g.l(j10)) {
                xc.d.a(this.f17797k, j10);
                g();
            }
        }
    }

    public i(cc.f fVar, ic.e eVar, boolean z10, int i10, int i11) {
        super(fVar);
        this.f17773c = eVar;
        this.f17774d = z10;
        this.f17775e = i10;
        this.f17776f = i11;
    }

    public static cc.i K(kh.b bVar, ic.e eVar, boolean z10, int i10, int i11) {
        return new b(bVar, eVar, z10, i10, i11);
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        if (x.b(this.f17703b, bVar, this.f17773c)) {
            return;
        }
        this.f17703b.H(K(bVar, this.f17773c, this.f17774d, this.f17775e, this.f17776f));
    }
}
