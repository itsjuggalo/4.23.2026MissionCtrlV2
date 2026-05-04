package oc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends cc.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final cc.h f17728b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cc.a f17729c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f17730a;

        static {
            int[] iArr = new int[cc.a.values().length];
            f17730a = iArr;
            try {
                iArr[cc.a.MISSING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f17730a[cc.a.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f17730a[cc.a.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f17730a[cc.a.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: oc.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0307c extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final tc.b f17733c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f17734d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f17735e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicInteger f17736f;

        public C0307c(kh.b bVar, int i10) {
            super(bVar);
            this.f17733c = new tc.b(i10);
            this.f17736f = new AtomicInteger();
        }

        @Override // oc.c.b
        public void e() {
            h();
        }

        @Override // oc.c.b
        public void f() {
            if (this.f17736f.getAndIncrement() == 0) {
                this.f17733c.clear();
            }
        }

        @Override // oc.c.b
        public boolean g(Throwable th) {
            if (this.f17735e || c()) {
                return false;
            }
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            this.f17734d = th;
            this.f17735e = true;
            h();
            return true;
        }

        public void h() {
            if (this.f17736f.getAndIncrement() != 0) {
                return;
            }
            kh.b bVar = this.f17731a;
            tc.b bVar2 = this.f17733c;
            int iAddAndGet = 1;
            do {
                long j10 = get();
                long j11 = 0;
                while (j11 != j10) {
                    if (c()) {
                        bVar2.clear();
                        return;
                    }
                    boolean z10 = this.f17735e;
                    Object objPoll = bVar2.poll();
                    boolean z11 = objPoll == null;
                    if (z10 && z11) {
                        Throwable th = this.f17734d;
                        if (th != null) {
                            b(th);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                    if (z11) {
                        break;
                    }
                    bVar.onNext(objPoll);
                    j11++;
                }
                if (j11 == j10) {
                    if (c()) {
                        bVar2.clear();
                        return;
                    }
                    boolean z12 = this.f17735e;
                    boolean zIsEmpty = bVar2.isEmpty();
                    if (z12 && zIsEmpty) {
                        Throwable th2 = this.f17734d;
                        if (th2 != null) {
                            b(th2);
                            return;
                        } else {
                            a();
                            return;
                        }
                    }
                }
                if (j11 != 0) {
                    xc.d.d(this, j11);
                }
                iAddAndGet = this.f17736f.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // cc.e
        public void onNext(Object obj) {
            if (this.f17735e || c()) {
                return;
            }
            if (obj == null) {
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f17733c.offer(obj);
                h();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends h {
        public e(kh.b bVar) {
            super(bVar);
        }

        @Override // oc.c.h
        public void h() {
            d(new gc.c("create: could not emit value due to lack of requests"));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReference f17737c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f17738d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f17739e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicInteger f17740f;

        public f(kh.b bVar) {
            super(bVar);
            this.f17737c = new AtomicReference();
            this.f17740f = new AtomicInteger();
        }

        @Override // oc.c.b
        public void e() {
            h();
        }

        @Override // oc.c.b
        public void f() {
            if (this.f17740f.getAndIncrement() == 0) {
                this.f17737c.lazySet(null);
            }
        }

        @Override // oc.c.b
        public boolean g(Throwable th) {
            if (this.f17739e || c()) {
                return false;
            }
            if (th == null) {
                d(new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources."));
            }
            this.f17738d = th;
            this.f17739e = true;
            h();
            return true;
        }

        /* JADX WARN: Code restructure failed: missing block: B:28:0x0050, code lost:
        
            if (r9 != r5) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0056, code lost:
        
            if (c() == false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0058, code lost:
        
            r2.lazySet(null);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x005b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x005c, code lost:
        
            r5 = r17.f17739e;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0062, code lost:
        
            if (r2.get() != null) goto L36;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x0064, code lost:
        
            r12 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0065, code lost:
        
            if (r5 == false) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x0067, code lost:
        
            if (r12 == false) goto L44;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x0069, code lost:
        
            r1 = r17.f17738d;
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x006b, code lost:
        
            if (r1 == null) goto L42;
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x006d, code lost:
        
            b(r1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x0070, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x0071, code lost:
        
            a();
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0074, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x0077, code lost:
        
            if (r9 == 0) goto L47;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x0079, code lost:
        
            xc.d.d(r17, r9);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x007c, code lost:
        
            r4 = r17.f17740f.addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h() {
            /*
                r17 = this;
                r0 = r17
                java.util.concurrent.atomic.AtomicInteger r1 = r0.f17740f
                int r1 = r1.getAndIncrement()
                if (r1 == 0) goto Lc
                goto L85
            Lc:
                kh.b r1 = r0.f17731a
                java.util.concurrent.atomic.AtomicReference r2 = r0.f17737c
                r3 = 1
                r4 = r3
            L12:
                long r5 = r0.get()
                r7 = 0
                r9 = r7
            L19:
                int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
                r12 = 0
                r13 = 0
                if (r11 == 0) goto L50
                boolean r14 = r0.c()
                if (r14 == 0) goto L29
                r2.lazySet(r13)
                return
            L29:
                boolean r14 = r0.f17739e
                java.lang.Object r15 = r2.getAndSet(r13)
                if (r15 != 0) goto L34
                r16 = r3
                goto L36
            L34:
                r16 = r12
            L36:
                if (r14 == 0) goto L46
                if (r16 == 0) goto L46
                java.lang.Throwable r1 = r0.f17738d
                if (r1 == 0) goto L42
                r0.b(r1)
                return
            L42:
                r0.a()
                return
            L46:
                if (r16 == 0) goto L49
                goto L50
            L49:
                r1.onNext(r15)
                r11 = 1
                long r9 = r9 + r11
                goto L19
            L50:
                if (r11 != 0) goto L75
                boolean r5 = r0.c()
                if (r5 == 0) goto L5c
                r2.lazySet(r13)
                return
            L5c:
                boolean r5 = r0.f17739e
                java.lang.Object r6 = r2.get()
                if (r6 != 0) goto L65
                r12 = r3
            L65:
                if (r5 == 0) goto L75
                if (r12 == 0) goto L75
                java.lang.Throwable r1 = r0.f17738d
                if (r1 == 0) goto L71
                r0.b(r1)
                return
            L71:
                r0.a()
                return
            L75:
                int r5 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
                if (r5 == 0) goto L7c
                xc.d.d(r0, r9)
            L7c:
                java.util.concurrent.atomic.AtomicInteger r5 = r0.f17740f
                int r4 = -r4
                int r4 = r5.addAndGet(r4)
                if (r4 != 0) goto L12
            L85:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: oc.c.f.h():void");
        }

        @Override // cc.e
        public void onNext(Object obj) {
            if (this.f17739e || c()) {
                return;
            }
            if (obj == null) {
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else {
                this.f17737c.set(obj);
                h();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends b {
        public g(kh.b bVar) {
            super(bVar);
        }

        @Override // cc.e
        public void onNext(Object obj) {
            long j10;
            if (c()) {
                return;
            }
            if (obj == null) {
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
                return;
            }
            this.f17731a.onNext(obj);
            do {
                j10 = get();
                if (j10 == 0) {
                    return;
                }
            } while (!compareAndSet(j10, j10 - 1));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class h extends b {
        public h(kh.b bVar) {
            super(bVar);
        }

        public abstract void h();

        @Override // cc.e
        public final void onNext(Object obj) {
            if (c()) {
                return;
            }
            if (obj == null) {
                d(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            } else if (get() == 0) {
                h();
            } else {
                this.f17731a.onNext(obj);
                xc.d.d(this, 1L);
            }
        }
    }

    public c(cc.h hVar, cc.a aVar) {
        this.f17728b = hVar;
        this.f17729c = aVar;
    }

    @Override // cc.f
    public void I(kh.b bVar) {
        int i10 = a.f17730a[this.f17729c.ordinal()];
        b c0307c = i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? new C0307c(bVar, cc.f.b()) : new f(bVar) : new d(bVar) : new e(bVar) : new g(bVar);
        bVar.b(c0307c);
        try {
            this.f17728b.a(c0307c);
        } catch (Throwable th) {
            gc.b.b(th);
            c0307c.d(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b extends AtomicLong implements cc.g, kh.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kh.b f17731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final jc.e f17732b = new jc.e();

        public b(kh.b bVar) {
            this.f17731a = bVar;
        }

        public void a() {
            if (c()) {
                return;
            }
            try {
                this.f17731a.onComplete();
            } finally {
                this.f17732b.dispose();
            }
        }

        public boolean b(Throwable th) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            if (c()) {
                return false;
            }
            try {
                this.f17731a.onError(th);
                this.f17732b.dispose();
                return true;
            } catch (Throwable th2) {
                this.f17732b.dispose();
                throw th2;
            }
        }

        public final boolean c() {
            return this.f17732b.c();
        }

        @Override // kh.c
        public final void cancel() {
            this.f17732b.dispose();
            f();
        }

        public final void d(Throwable th) {
            if (g(th)) {
                return;
            }
            yc.a.q(th);
        }

        public boolean g(Throwable th) {
            return b(th);
        }

        @Override // kh.c
        public final void request(long j10) {
            if (wc.g.l(j10)) {
                xc.d.a(this, j10);
                e();
            }
        }

        @Override // java.util.concurrent.atomic.AtomicLong
        public String toString() {
            return String.format("%s{%s}", getClass().getSimpleName(), super.toString());
        }

        public void e() {
        }

        public void f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends h {
        public d(kh.b bVar) {
            super(bVar);
        }

        @Override // oc.c.h
        public void h() {
        }
    }
}
