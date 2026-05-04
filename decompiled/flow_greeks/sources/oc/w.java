package oc;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w extends hc.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cc.f f17903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicReference f17904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f17905d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final kh.a f17906e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements kh.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference f17907a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17908b;

        public a(AtomicReference atomicReference, int i10) {
            this.f17907a = atomicReference;
            this.f17908b = i10;
        }

        @Override // kh.a
        public void a(kh.b bVar) {
            c cVar;
            b bVar2 = new b(bVar);
            bVar.b(bVar2);
            while (true) {
                cVar = (c) this.f17907a.get();
                if (cVar == null || cVar.c()) {
                    c cVar2 = new c(this.f17907a, this.f17908b);
                    if (com.amazon.a.a.l.d.a(this.f17907a, cVar, cVar2)) {
                        cVar = cVar2;
                    } else {
                        continue;
                    }
                }
                if (cVar.a(bVar2)) {
                    break;
                }
            }
            if (bVar2.get() == Long.MIN_VALUE) {
                cVar.g(bVar2);
            } else {
                bVar2.f17910b = cVar;
            }
            cVar.f();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends AtomicLong implements kh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile c f17910b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f17911c;

        public b(kh.b bVar) {
            this.f17909a = bVar;
        }

        @Override // kh.c
        public void cancel() {
            c cVar;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (cVar = this.f17910b) == null) {
                return;
            }
            cVar.g(this);
            cVar.f();
        }

        @Override // kh.c
        public void request(long j10) {
            if (wc.g.l(j10)) {
                xc.d.b(this, j10);
                c cVar = this.f17910b;
                if (cVar != null) {
                    cVar.f();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends AtomicInteger implements cc.i, fc.b {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final b[] f17912i = new b[0];

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static final b[] f17913j = new b[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReference f17914a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17915b;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public volatile Object f17919f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f17920g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public volatile lc.i f17921h;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReference f17918e = new AtomicReference();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReference f17916c = new AtomicReference(f17912i);

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicBoolean f17917d = new AtomicBoolean();

        public c(AtomicReference atomicReference, int i10) {
            this.f17914a = atomicReference;
            this.f17915b = i10;
        }

        public boolean a(b bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = (b[]) this.f17916c.get();
                if (bVarArr == f17913j) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!com.amazon.a.a.l.d.a(this.f17916c, bVarArr, bVarArr2));
            return true;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.k(this.f17918e, cVar)) {
                if (cVar instanceof lc.f) {
                    lc.f fVar = (lc.f) cVar;
                    int iH = fVar.h(7);
                    if (iH == 1) {
                        this.f17920g = iH;
                        this.f17921h = fVar;
                        this.f17919f = xc.i.b();
                        f();
                        return;
                    }
                    if (iH == 2) {
                        this.f17920g = iH;
                        this.f17921h = fVar;
                        cVar.request(this.f17915b);
                        return;
                    }
                }
                this.f17921h = new tc.a(this.f17915b);
                cVar.request(this.f17915b);
            }
        }

        @Override // fc.b
        public boolean c() {
            return this.f17916c.get() == f17913j;
        }

        @Override // fc.b
        public void dispose() {
            Object obj = this.f17916c.get();
            Object obj2 = f17913j;
            if (obj == obj2 || ((b[]) this.f17916c.getAndSet(obj2)) == obj2) {
                return;
            }
            com.amazon.a.a.l.d.a(this.f17914a, this, null);
            wc.g.a(this.f17918e);
        }

        public boolean e(Object obj, boolean z10) {
            int i10 = 0;
            if (obj != null) {
                if (!xc.i.k(obj)) {
                    Throwable thH = xc.i.h(obj);
                    com.amazon.a.a.l.d.a(this.f17914a, this, null);
                    b[] bVarArr = (b[]) this.f17916c.getAndSet(f17913j);
                    if (bVarArr.length != 0) {
                        int length = bVarArr.length;
                        while (i10 < length) {
                            bVarArr[i10].f17909a.onError(thH);
                            i10++;
                        }
                    } else {
                        yc.a.q(thH);
                    }
                    return true;
                }
                if (z10) {
                    com.amazon.a.a.l.d.a(this.f17914a, this, null);
                    b[] bVarArr2 = (b[]) this.f17916c.getAndSet(f17913j);
                    int length2 = bVarArr2.length;
                    while (i10 < length2) {
                        bVarArr2[i10].f17909a.onComplete();
                        i10++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:75:0x0125, code lost:
        
            if (r11 == 0) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:77:0x012a, code lost:
        
            if (r26.f17920g == 1) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x012c, code lost:
        
            ((kh.c) r26.f17918e.get()).request(r11);
         */
        /* JADX WARN: Code restructure failed: missing block: B:79:0x0138, code lost:
        
            r4 = r0;
            r3 = true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void f() {
            /*
                Method dump skipped, instruction units count: 365
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.w.c.f():void");
        }

        public void g(b bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = (b[]) this.f17916c.get();
                int length = bVarArr.length;
                if (length == 0) {
                    return;
                }
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        i10 = -1;
                        break;
                    } else if (bVarArr[i10].equals(bVar)) {
                        break;
                    } else {
                        i10++;
                    }
                }
                if (i10 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f17912i;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i10);
                    System.arraycopy(bVarArr, i10 + 1, bVarArr3, i10, (length - i10) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!com.amazon.a.a.l.d.a(this.f17916c, bVarArr, bVarArr2));
        }

        @Override // kh.b
        public void onComplete() {
            if (this.f17919f == null) {
                this.f17919f = xc.i.b();
                f();
            }
        }

        @Override // kh.b
        public void onError(Throwable th) {
            if (this.f17919f != null) {
                yc.a.q(th);
            } else {
                this.f17919f = xc.i.c(th);
                f();
            }
        }

        @Override // kh.b
        public void onNext(Object obj) {
            if (this.f17920g != 0 || this.f17921h.offer(obj)) {
                f();
            } else {
                onError(new gc.c("Prefetch queue is full?!"));
            }
        }
    }

    public w(kh.a aVar, cc.f fVar, AtomicReference atomicReference, int i10) {
        this.f17906e = aVar;
        this.f17903b = fVar;
        this.f17904c = atomicReference;
        this.f17905d = i10;
    }

    public static hc.a M(cc.f fVar, int i10) {
        AtomicReference atomicReference = new AtomicReference();
        return yc.a.o(new w(new a(atomicReference, i10), fVar, atomicReference, i10));
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f17906e.a(bVar);
    }

    @Override // hc.a
    public void L(ic.d dVar) {
        c cVar;
        while (true) {
            cVar = (c) this.f17904c.get();
            if (cVar != null && !cVar.c()) {
                break;
            }
            c cVar2 = new c(this.f17904c, this.f17905d);
            if (com.amazon.a.a.l.d.a(this.f17904c, cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z10 = false;
        if (!cVar.f17917d.get() && cVar.f17917d.compareAndSet(false, true)) {
            z10 = true;
        }
        try {
            dVar.accept(cVar);
            if (z10) {
                this.f17903b.H(cVar);
            }
        } catch (Throwable th) {
            gc.b.b(th);
            throw xc.g.d(th);
        }
    }
}
