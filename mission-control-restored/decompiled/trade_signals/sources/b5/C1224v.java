package b5;

import i5.EnumC1933g;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b5.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C1224v extends AbstractC1203a {

    /* JADX INFO: renamed from: b5.v$a */
    public static final class a extends AtomicInteger implements P4.i, x7.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final x7.b f13146a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public x7.c f13147b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public volatile boolean f13148c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Throwable f13149d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public volatile boolean f13150e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final AtomicLong f13151f = new AtomicLong();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final AtomicReference f13152g = new AtomicReference();

        public a(x7.b bVar) {
            this.f13146a = bVar;
        }

        @Override // x7.b
        public void a() {
            this.f13148c = true;
            f();
        }

        public boolean b(boolean z7, boolean z8, x7.b bVar, AtomicReference atomicReference) {
            if (this.f13150e) {
                atomicReference.lazySet(null);
                return true;
            }
            if (!z7) {
                return false;
            }
            Throwable th = this.f13149d;
            if (th != null) {
                atomicReference.lazySet(null);
                bVar.onError(th);
                return true;
            }
            if (!z8) {
                return false;
            }
            bVar.a();
            return true;
        }

        @Override // x7.b
        public void c(Object obj) {
            this.f13152g.lazySet(obj);
            f();
        }

        @Override // x7.c
        public void cancel() {
            if (this.f13150e) {
                return;
            }
            this.f13150e = true;
            this.f13147b.cancel();
            if (getAndIncrement() == 0) {
                this.f13152g.lazySet(null);
            }
        }

        @Override // P4.i, x7.b
        public void d(x7.c cVar) {
            if (EnumC1933g.q(this.f13147b, cVar)) {
                this.f13147b = cVar;
                this.f13146a.d(this);
                cVar.i(Long.MAX_VALUE);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
        
            if (r7 != r1.get()) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0040, code lost:
        
            r9 = r13.f13148c;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0046, code lost:
        
            if (r2.get() != null) goto L24;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0048, code lost:
        
            r10 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
        
            if (b(r9, r10, r0, r2) == false) goto L27;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0052, code lost:
        
            if (r7 == 0) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
        
            j5.d.d(r1, r7);
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0057, code lost:
        
            r4 = addAndGet(-r4);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void f() {
            /*
                r13 = this;
                int r0 = r13.getAndIncrement()
                if (r0 == 0) goto L7
                return
            L7:
                x7.b r0 = r13.f13146a
                java.util.concurrent.atomic.AtomicLong r1 = r13.f13151f
                java.util.concurrent.atomic.AtomicReference r2 = r13.f13152g
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
                boolean r9 = r13.f13148c
                r11 = 0
                java.lang.Object r11 = r2.getAndSet(r11)
                if (r11 != 0) goto L26
                r12 = r3
                goto L27
            L26:
                r12 = r10
            L27:
                boolean r9 = r13.b(r9, r12, r0, r2)
                if (r9 == 0) goto L2e
                return
            L2e:
                if (r12 == 0) goto L31
                goto L38
            L31:
                r0.c(r11)
                r9 = 1
                long r7 = r7 + r9
                goto L12
            L38:
                long r11 = r1.get()
                int r9 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r9 != 0) goto L50
                boolean r9 = r13.f13148c
                java.lang.Object r11 = r2.get()
                if (r11 != 0) goto L49
                r10 = r3
            L49:
                boolean r9 = r13.b(r9, r10, r0, r2)
                if (r9 == 0) goto L50
                return
            L50:
                int r5 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
                if (r5 == 0) goto L57
                j5.d.d(r1, r7)
            L57:
                int r4 = -r4
                int r4 = r13.addAndGet(r4)
                if (r4 != 0) goto Lf
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: b5.C1224v.a.f():void");
        }

        @Override // x7.c
        public void i(long j8) {
            if (EnumC1933g.n(j8)) {
                j5.d.a(this.f13151f, j8);
                f();
            }
        }

        @Override // x7.b
        public void onError(Throwable th) {
            this.f13149d = th;
            this.f13148c = true;
            f();
        }
    }

    public C1224v(P4.f fVar) {
        super(fVar);
    }

    @Override // P4.f
    public void I(x7.b bVar) {
        this.f12952b.H(new a(bVar));
    }
}
