package oc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends oc.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ic.e f17804c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f17805d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f17806e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends AtomicInteger implements cc.i, kh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17807a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f17808b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f17809c;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final ic.e f17814h;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public kh.c f17816j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public volatile boolean f17817k;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicLong f17810d = new AtomicLong();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final fc.a f17811e = new fc.a();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final xc.c f17813g = new xc.c();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicInteger f17812f = new AtomicInteger(1);

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final AtomicReference f17815i = new AtomicReference();

        /* JADX INFO: renamed from: oc.j$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class C0308a extends AtomicReference implements cc.l, fc.b {
            public C0308a() {
            }

            @Override // cc.l
            public void a(fc.b bVar) {
                jc.b.l(this, bVar);
            }

            @Override // fc.b
            public boolean c() {
                return jc.b.b((fc.b) get());
            }

            @Override // fc.b
            public void dispose() {
                jc.b.a(this);
            }

            @Override // cc.l
            public void onComplete() {
                a.this.g(this);
            }

            @Override // cc.l
            public void onError(Throwable th) {
                a.this.h(this, th);
            }

            @Override // cc.l
            public void onSuccess(Object obj) {
                a.this.i(this, obj);
            }
        }

        public a(kh.b bVar, ic.e eVar, boolean z10, int i10) {
            this.f17807a = bVar;
            this.f17814h = eVar;
            this.f17808b = z10;
            this.f17809c = i10;
        }

        public void a() {
            tc.b bVar = (tc.b) this.f17815i.get();
            if (bVar != null) {
                bVar.clear();
            }
        }

        @Override // cc.i, kh.b
        public void b(kh.c cVar) {
            if (wc.g.m(this.f17816j, cVar)) {
                this.f17816j = cVar;
                this.f17807a.b(this);
                int i10 = this.f17809c;
                if (i10 == Integer.MAX_VALUE) {
                    cVar.request(Long.MAX_VALUE);
                } else {
                    cVar.request(i10);
                }
            }
        }

        public void c() {
            if (getAndIncrement() == 0) {
                e();
            }
        }

        @Override // kh.c
        public void cancel() {
            this.f17817k = true;
            this.f17816j.cancel();
            this.f17811e.dispose();
        }

        /* JADX WARN: Code restructure failed: missing block: B:38:0x0077, code lost:
        
            if (r10 != r6) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x007b, code lost:
        
            if (r17.f17817k == false) goto L43;
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x007d, code lost:
        
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0080, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
        
            if (r17.f17808b != false) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x008d, code lost:
        
            if (((java.lang.Throwable) r17.f17813g.get()) == null) goto L49;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x008f, code lost:
        
            r2 = r17.f17813g.b();
            a();
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x009b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
        
            if (r2.get() != 0) goto L52;
         */
        /* JADX WARN: Code restructure failed: missing block: B:51:0x00a2, code lost:
        
            r6 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x00a4, code lost:
        
            r6 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a5, code lost:
        
            r7 = (tc.b) r3.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00ab, code lost:
        
            if (r7 == null) goto L57;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00b1, code lost:
        
            if (r7.isEmpty() == false) goto L58;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00b3, code lost:
        
            r13 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x00b4, code lost:
        
            if (r6 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00b6, code lost:
        
            if (r13 == false) goto L66;
         */
        /* JADX WARN: Code restructure failed: missing block: B:60:0x00b8, code lost:
        
            r2 = r17.f17813g.b();
         */
        /* JADX WARN: Code restructure failed: missing block: B:61:0x00be, code lost:
        
            if (r2 == null) goto L64;
         */
        /* JADX WARN: Code restructure failed: missing block: B:62:0x00c0, code lost:
        
            r1.onError(r2);
         */
        /* JADX WARN: Code restructure failed: missing block: B:63:0x00c3, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x00c4, code lost:
        
            r1.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:65:0x00c7, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:67:0x00ca, code lost:
        
            if (r10 == 0) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:68:0x00cc, code lost:
        
            xc.d.d(r17.f17810d, r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:69:0x00d6, code lost:
        
            if (r17.f17809c == Integer.MAX_VALUE) goto L71;
         */
        /* JADX WARN: Code restructure failed: missing block: B:70:0x00d8, code lost:
        
            r17.f17816j.request(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:71:0x00dd, code lost:
        
            r5 = addAndGet(-r5);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void e() {
            /*
                Method dump skipped, instruction units count: 229
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.j.a.e():void");
        }

        public tc.b f() {
            tc.b bVar;
            do {
                tc.b bVar2 = (tc.b) this.f17815i.get();
                if (bVar2 != null) {
                    return bVar2;
                }
                bVar = new tc.b(cc.f.b());
            } while (!com.amazon.a.a.l.d.a(this.f17815i, null, bVar));
            return bVar;
        }

        public void g(C0308a c0308a) {
            this.f17811e.b(c0308a);
            if (get() == 0) {
                if (compareAndSet(0, 1)) {
                    boolean z10 = this.f17812f.decrementAndGet() == 0;
                    tc.b bVar = (tc.b) this.f17815i.get();
                    if (z10 && (bVar == null || bVar.isEmpty())) {
                        Throwable thB = this.f17813g.b();
                        if (thB != null) {
                            this.f17807a.onError(thB);
                            return;
                        } else {
                            this.f17807a.onComplete();
                            return;
                        }
                    }
                    if (this.f17809c != Integer.MAX_VALUE) {
                        this.f17816j.request(1L);
                    }
                    if (decrementAndGet() == 0) {
                        return;
                    }
                    e();
                    return;
                }
            }
            this.f17812f.decrementAndGet();
            if (this.f17809c != Integer.MAX_VALUE) {
                this.f17816j.request(1L);
            }
            c();
        }

        public void h(C0308a c0308a, Throwable th) {
            this.f17811e.b(c0308a);
            if (!this.f17813g.a(th)) {
                yc.a.q(th);
                return;
            }
            if (!this.f17808b) {
                this.f17816j.cancel();
                this.f17811e.dispose();
            } else if (this.f17809c != Integer.MAX_VALUE) {
                this.f17816j.request(1L);
            }
            this.f17812f.decrementAndGet();
            c();
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x007a  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void i(oc.j.a.C0308a r5, java.lang.Object r6) {
            /*
                r4 = this;
                fc.a r0 = r4.f17811e
                r0.b(r5)
                int r5 = r4.get()
                if (r5 != 0) goto L7a
                r5 = 0
                r0 = 1
                boolean r1 = r4.compareAndSet(r5, r0)
                if (r1 == 0) goto L7a
                java.util.concurrent.atomic.AtomicInteger r1 = r4.f17812f
                int r1 = r1.decrementAndGet()
                if (r1 != 0) goto L1c
                r5 = r0
            L1c:
                java.util.concurrent.atomic.AtomicLong r0 = r4.f17810d
                long r0 = r0.get()
                r2 = 0
                int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r0 == 0) goto L67
                kh.b r0 = r4.f17807a
                r0.onNext(r6)
                java.util.concurrent.atomic.AtomicReference r6 = r4.f17815i
                java.lang.Object r6 = r6.get()
                tc.b r6 = (tc.b) r6
                if (r5 == 0) goto L53
                if (r6 == 0) goto L3f
                boolean r5 = r6.isEmpty()
                if (r5 == 0) goto L53
            L3f:
                xc.c r5 = r4.f17813g
                java.lang.Throwable r5 = r5.b()
                if (r5 == 0) goto L4d
                kh.b r6 = r4.f17807a
                r6.onError(r5)
                return
            L4d:
                kh.b r5 = r4.f17807a
                r5.onComplete()
                return
            L53:
                java.util.concurrent.atomic.AtomicLong r5 = r4.f17810d
                r0 = 1
                xc.d.d(r5, r0)
                int r5 = r4.f17809c
                r6 = 2147483647(0x7fffffff, float:NaN)
                if (r5 == r6) goto L70
                kh.c r5 = r4.f17816j
                r5.request(r0)
                goto L70
            L67:
                tc.b r5 = r4.f()
                monitor-enter(r5)
                r5.offer(r6)     // Catch: java.lang.Throwable -> L77
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
            L70:
                int r5 = r4.decrementAndGet()
                if (r5 != 0) goto L8f
                goto L8e
            L77:
                r6 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L77
                throw r6
            L7a:
                tc.b r5 = r4.f()
                monitor-enter(r5)
                r5.offer(r6)     // Catch: java.lang.Throwable -> L93
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L93
                java.util.concurrent.atomic.AtomicInteger r5 = r4.f17812f
                r5.decrementAndGet()
                int r5 = r4.getAndIncrement()
                if (r5 == 0) goto L8f
            L8e:
                return
            L8f:
                r4.e()
                return
            L93:
                r6 = move-exception
                monitor-exit(r5)     // Catch: java.lang.Throwable -> L93
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.j.a.i(oc.j$a$a, java.lang.Object):void");
        }

        @Override // kh.b
        public void onComplete() {
            this.f17812f.decrementAndGet();
            c();
        }

        @Override // kh.b
        public void onError(Throwable th) {
            this.f17812f.decrementAndGet();
            if (!this.f17813g.a(th)) {
                yc.a.q(th);
                return;
            }
            if (!this.f17808b) {
                this.f17811e.dispose();
            }
            c();
        }

        @Override // kh.b
        public void onNext(Object obj) {
            try {
                cc.n nVar = (cc.n) kc.b.d(this.f17814h.apply(obj), "The mapper returned a null MaybeSource");
                this.f17812f.getAndIncrement();
                C0308a c0308a = new C0308a();
                if (this.f17817k || !this.f17811e.d(c0308a)) {
                    return;
                }
                nVar.a(c0308a);
            } catch (Throwable th) {
                gc.b.b(th);
                this.f17816j.cancel();
                onError(th);
            }
        }

        @Override // kh.c
        public void request(long j10) {
            if (wc.g.l(j10)) {
                xc.d.a(this.f17810d, j10);
                c();
            }
        }
    }

    public j(cc.f fVar, ic.e eVar, boolean z10, int i10) {
        super(fVar);
        this.f17804c = eVar;
        this.f17805d = z10;
        this.f17806e = i10;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        this.f17703b.H(new a(bVar, this.f17804c, this.f17805d, this.f17806e));
    }
}
