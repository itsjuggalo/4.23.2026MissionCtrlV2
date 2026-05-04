package oc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends oc.a {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicInteger implements cc.i, kh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17896a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public kh.c f17897b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f17898c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f17899d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f17900e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicLong f17901f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicReference f17902g = new AtomicReference();

        public a(kh.b bVar) {
            this.f17896a = bVar;
        }

        public boolean a(boolean z10, boolean z11, kh.b bVar, AtomicReference atomicReference) {
            if (this.f17900e) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z10) {
                return false;
            }
            Throwable th = this.f17899d;
            if (th != null) {
                atomicReference.lazySet(null);
                bVar.onError(th);
                return true;
            }
            if (!z11) {
                return false;
            }
            bVar.onComplete();
            return true;
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17897b, cVar)) {
                this.f17897b = cVar;
                this.f17896a.b(this);
                cVar.request(Long.MAX_VALUE);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            if (r7 != r1.get()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r9 = r13.f17898c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (a(r9, r10, r0, r2) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        
            if (r7 == 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        
            xc.d.d(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r4 = addAndGet(-r4);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:?, code lost:
        
            return;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void c() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                goto L5e
            L7:
                kh.b r0 = r13.f17896a
                java.util.concurrent.atomic.AtomicLong r1 = r13.f17901f
                java.util.concurrent.atomic.AtomicReference r2 = r13.f17902g
                r3 = 1
                r4 = r3
            Lf:
                r5 = 0
                r7 = r5
            L12:
                long r9 = r1.get()
                int r9 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
                r10 = 0
                if (r9 == 0) goto L38
                boolean r9 = r13.f17898c
                r11 = 0
                java.lang.Object r11 = r2.getAndSet(r11)
                if (r11 != 0) goto L26
                r12 = r3
                goto L27
            L26:
                r12 = r10
            L27:
                boolean r9 = r13.a(r9, r12, r0, r2)
                if (r9 == 0) goto L2e
                goto L5e
            L2e:
                if (r12 == 0) goto L31
                goto L38
            L31:
                r0.onNext(r11)
                r9 = 1
                long r7 = r7 + r9
                goto L12
            L38:
                long r11 = r1.get()
                int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r9 != 0) goto L50
                boolean r9 = r13.f17898c
                java.lang.Object r11 = r2.get()
                if (r11 != 0) goto L49
                r10 = r3
            L49:
                boolean r9 = r13.a(r9, r10, r0, r2)
                if (r9 == 0) goto L50
                goto L5e
            L50:
                int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r5 == 0) goto L57
                xc.d.d(r1, r7)
            L57:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto Lf
            L5e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.v.a.c():void");
        }

        @Override // kh.c
        public void cancel() {
            if (this.f17900e) {
                return;
            }
            this.f17900e = true;
            this.f17897b.cancel();
            if (getAndIncrement() == 0) {
                this.f17902g.lazySet(null);
            }
        }

        @Override // kh.b
        public void onComplete() {
            this.f17898c = true;
            c();
        }

        @Override // kh.b
        public void onError(Throwable th) {
            this.f17899d = th;
            this.f17898c = true;
            c();
        }

        @Override // kh.b
        public void onNext(Object obj) {
            this.f17902g.lazySet(obj);
            c();
        }

        @Override // kh.c
        public void request(long j10) {
            if (wc.g.l(j10)) {
                xc.d.a(this.f17901f, j10);
                c();
            }
        }
    }

    public v(cc.f fVar) {
        super(fVar);
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f17703b.H(new a(bVar));
    }
}
