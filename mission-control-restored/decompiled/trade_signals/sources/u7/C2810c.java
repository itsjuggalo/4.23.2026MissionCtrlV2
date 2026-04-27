package u7;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: renamed from: u7.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2810c extends W {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f23625i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReentrantLock f23626j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Condition f23627k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f23628l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f23629m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static C2810c f23630n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f23631f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C2810c f23632g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f23633h;

    /* JADX INFO: renamed from: u7.c$a */
    public static final class a {
        public a() {
        }

        public final C2810c c() throws InterruptedException {
            C2810c c2810c = C2810c.f23630n;
            AbstractC2304t.c(c2810c);
            C2810c c2810c2 = c2810c.f23632g;
            long jNanoTime = System.nanoTime();
            if (c2810c2 == null) {
                e().await(C2810c.f23628l, TimeUnit.MILLISECONDS);
                C2810c c2810c3 = C2810c.f23630n;
                AbstractC2304t.c(c2810c3);
                if (c2810c3.f23632g != null || System.nanoTime() - jNanoTime < C2810c.f23629m) {
                    return null;
                }
                return C2810c.f23630n;
            }
            long jU = c2810c2.u(jNanoTime);
            if (jU > 0) {
                e().await(jU, TimeUnit.NANOSECONDS);
                return null;
            }
            C2810c c2810c4 = C2810c.f23630n;
            AbstractC2304t.c(c2810c4);
            c2810c4.f23632g = c2810c2.f23632g;
            c2810c2.f23632g = null;
            return c2810c2;
        }

        public final boolean d(C2810c c2810c) {
            ReentrantLock reentrantLockF = C2810c.f23625i.f();
            reentrantLockF.lock();
            try {
                if (!c2810c.f23631f) {
                    return false;
                }
                c2810c.f23631f = false;
                for (C2810c c2810c2 = C2810c.f23630n; c2810c2 != null; c2810c2 = c2810c2.f23632g) {
                    if (c2810c2.f23632g == c2810c) {
                        c2810c2.f23632g = c2810c.f23632g;
                        c2810c.f23632g = null;
                        return false;
                    }
                }
                reentrantLockF.unlock();
                return true;
            } finally {
                reentrantLockF.unlock();
            }
        }

        public final Condition e() {
            return C2810c.f23627k;
        }

        public final ReentrantLock f() {
            return C2810c.f23626j;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x001a, B:10:0x002e, B:13:0x003a, B:14:0x0043, B:19:0x0054, B:20:0x005c, B:22:0x0065, B:25:0x0075, B:26:0x007a, B:28:0x008a, B:29:0x0093, B:18:0x004d, B:32:0x0099, B:33:0x009e, B:34:0x009f, B:35:0x00aa), top: B:38:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x008a A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:3:0x0009, B:5:0x0011, B:7:0x001a, B:10:0x002e, B:13:0x003a, B:14:0x0043, B:19:0x0054, B:20:0x005c, B:22:0x0065, B:25:0x0075, B:26:0x007a, B:28:0x008a, B:29:0x0093, B:18:0x004d, B:32:0x0099, B:33:0x009e, B:34:0x009f, B:35:0x00aa), top: B:38:0x0009 }] */
        /* JADX WARN: Removed duplicated region for block: B:39:0x007a A[EDGE_INSN: B:39:0x007a->B:26:0x007a BREAK  A[LOOP:0: B:20:0x005c->B:25:0x0075], SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void g(u7.C2810c r6, long r7, boolean r9) {
            /*
                r5 = this;
                u7.c$a r0 = u7.C2810c.f23625i
                java.util.concurrent.locks.ReentrantLock r0 = r0.f()
                r0.lock()
                boolean r1 = u7.C2810c.i(r6)     // Catch: java.lang.Throwable -> L2b
                r2 = 1
                r1 = r1 ^ r2
                if (r1 == 0) goto L9f
                u7.C2810c.o(r6, r2)     // Catch: java.lang.Throwable -> L2b
                u7.c r1 = u7.C2810c.f()     // Catch: java.lang.Throwable -> L2b
                if (r1 != 0) goto L2e
                u7.c r1 = new u7.c     // Catch: java.lang.Throwable -> L2b
                r1.<init>()     // Catch: java.lang.Throwable -> L2b
                u7.C2810c.n(r1)     // Catch: java.lang.Throwable -> L2b
                u7.c$b r1 = new u7.c$b     // Catch: java.lang.Throwable -> L2b
                r1.<init>()     // Catch: java.lang.Throwable -> L2b
                r1.start()     // Catch: java.lang.Throwable -> L2b
                goto L2e
            L2b:
                r6 = move-exception
                goto Lab
            L2e:
                long r1 = java.lang.System.nanoTime()     // Catch: java.lang.Throwable -> L2b
                r3 = 0
                int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r3 == 0) goto L48
                if (r9 == 0) goto L48
                long r3 = r6.a()     // Catch: java.lang.Throwable -> L2b
                long r3 = r3 - r1
                long r7 = java.lang.Math.min(r7, r3)     // Catch: java.lang.Throwable -> L2b
            L43:
                long r7 = r7 + r1
                u7.C2810c.q(r6, r7)     // Catch: java.lang.Throwable -> L2b
                goto L54
            L48:
                if (r3 == 0) goto L4b
                goto L43
            L4b:
                if (r9 == 0) goto L99
                long r7 = r6.a()     // Catch: java.lang.Throwable -> L2b
                u7.C2810c.q(r6, r7)     // Catch: java.lang.Throwable -> L2b
            L54:
                long r7 = u7.C2810c.m(r6, r1)     // Catch: java.lang.Throwable -> L2b
                u7.c r9 = u7.C2810c.f()     // Catch: java.lang.Throwable -> L2b
            L5c:
                kotlin.jvm.internal.AbstractC2304t.c(r9)     // Catch: java.lang.Throwable -> L2b
                u7.c r3 = u7.C2810c.k(r9)     // Catch: java.lang.Throwable -> L2b
                if (r3 == 0) goto L7a
                u7.c r3 = u7.C2810c.k(r9)     // Catch: java.lang.Throwable -> L2b
                kotlin.jvm.internal.AbstractC2304t.c(r3)     // Catch: java.lang.Throwable -> L2b
                long r3 = u7.C2810c.m(r3, r1)     // Catch: java.lang.Throwable -> L2b
                int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
                if (r3 >= 0) goto L75
                goto L7a
            L75:
                u7.c r9 = u7.C2810c.k(r9)     // Catch: java.lang.Throwable -> L2b
                goto L5c
            L7a:
                u7.c r7 = u7.C2810c.k(r9)     // Catch: java.lang.Throwable -> L2b
                u7.C2810c.p(r6, r7)     // Catch: java.lang.Throwable -> L2b
                u7.C2810c.p(r9, r6)     // Catch: java.lang.Throwable -> L2b
                u7.c r6 = u7.C2810c.f()     // Catch: java.lang.Throwable -> L2b
                if (r9 != r6) goto L93
                u7.c$a r6 = u7.C2810c.f23625i     // Catch: java.lang.Throwable -> L2b
                java.util.concurrent.locks.Condition r6 = r6.e()     // Catch: java.lang.Throwable -> L2b
                r6.signal()     // Catch: java.lang.Throwable -> L2b
            L93:
                o5.H r6 = o5.C2470H.f21956a     // Catch: java.lang.Throwable -> L2b
                r0.unlock()
                return
            L99:
                java.lang.AssertionError r6 = new java.lang.AssertionError     // Catch: java.lang.Throwable -> L2b
                r6.<init>()     // Catch: java.lang.Throwable -> L2b
                throw r6     // Catch: java.lang.Throwable -> L2b
            L9f:
                java.lang.String r6 = "Unbalanced enter/exit"
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L2b
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Throwable -> L2b
                r7.<init>(r6)     // Catch: java.lang.Throwable -> L2b
                throw r7     // Catch: java.lang.Throwable -> L2b
            Lab:
                r0.unlock()
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: u7.C2810c.a.g(u7.c, long, boolean):void");
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    /* JADX INFO: renamed from: u7.c$b */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLockF;
            C2810c c2810cC;
            while (true) {
                try {
                    a aVar = C2810c.f23625i;
                    reentrantLockF = aVar.f();
                    reentrantLockF.lock();
                    try {
                        c2810cC = aVar.c();
                    } finally {
                        reentrantLockF.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (c2810cC == C2810c.f23630n) {
                    C2810c.f23630n = null;
                    return;
                }
                C2470H c2470h = C2470H.f21956a;
                reentrantLockF.unlock();
                if (c2810cC != null) {
                    c2810cC.x();
                }
            }
        }
    }

    /* JADX INFO: renamed from: u7.c$c, reason: collision with other inner class name */
    public static final class C0411c implements T {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ T f23635b;

        public C0411c(T t8) {
            this.f23635b = t8;
        }

        @Override // u7.T
        public void H(C2811d source, long j8) throws IOException {
            AbstractC2304t.f(source, "source");
            AbstractC2809b.b(source.s0(), 0L, j8);
            while (true) {
                long j9 = 0;
                if (j8 <= 0) {
                    return;
                }
                P p8 = source.f23638a;
                while (true) {
                    AbstractC2304t.c(p8);
                    if (j9 >= 65536) {
                        break;
                    }
                    j9 += (long) (p8.f23597c - p8.f23596b);
                    if (j9 >= j8) {
                        j9 = j8;
                        break;
                    }
                    p8 = p8.f23600f;
                }
                C2810c c2810c = C2810c.this;
                T t8 = this.f23635b;
                c2810c.r();
                try {
                    t8.H(source, j9);
                    C2470H c2470h = C2470H.f21956a;
                    if (c2810c.s()) {
                        throw c2810c.l(null);
                    }
                    j8 -= j9;
                } catch (IOException e8) {
                    if (!c2810c.s()) {
                        throw e8;
                    }
                    throw c2810c.l(e8);
                } finally {
                    c2810c.s();
                }
            }
        }

        @Override // u7.T, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C2810c c2810c = C2810c.this;
            T t8 = this.f23635b;
            c2810c.r();
            try {
                t8.close();
                C2470H c2470h = C2470H.f21956a;
                if (c2810c.s()) {
                    throw c2810c.l(null);
                }
            } catch (IOException e8) {
                if (!c2810c.s()) {
                    throw e8;
                }
                throw c2810c.l(e8);
            } finally {
                c2810c.s();
            }
        }

        @Override // u7.T, java.io.Flushable
        public void flush() throws IOException {
            C2810c c2810c = C2810c.this;
            T t8 = this.f23635b;
            c2810c.r();
            try {
                t8.flush();
                C2470H c2470h = C2470H.f21956a;
                if (c2810c.s()) {
                    throw c2810c.l(null);
                }
            } catch (IOException e8) {
                if (!c2810c.s()) {
                    throw e8;
                }
                throw c2810c.l(e8);
            } finally {
                c2810c.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f23635b + ')';
        }
    }

    /* JADX INFO: renamed from: u7.c$d */
    public static final class d implements V {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ V f23637b;

        public d(V v8) {
            this.f23637b = v8;
        }

        @Override // u7.V, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C2810c c2810c = C2810c.this;
            V v8 = this.f23637b;
            c2810c.r();
            try {
                v8.close();
                C2470H c2470h = C2470H.f21956a;
                if (c2810c.s()) {
                    throw c2810c.l(null);
                }
            } catch (IOException e8) {
                if (!c2810c.s()) {
                    throw e8;
                }
                throw c2810c.l(e8);
            } finally {
                c2810c.s();
            }
        }

        @Override // u7.V
        public long o0(C2811d sink, long j8) throws IOException {
            AbstractC2304t.f(sink, "sink");
            C2810c c2810c = C2810c.this;
            V v8 = this.f23637b;
            c2810c.r();
            try {
                long jO0 = v8.o0(sink, j8);
                if (c2810c.s()) {
                    throw c2810c.l(null);
                }
                return jO0;
            } catch (IOException e8) {
                if (c2810c.s()) {
                    throw c2810c.l(e8);
                }
                throw e8;
            } finally {
                c2810c.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f23637b + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f23626j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        AbstractC2304t.e(conditionNewCondition, "lock.newCondition()");
        f23627k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f23628l = millis;
        f23629m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final IOException l(IOException iOException) {
        return t(iOException);
    }

    public final void r() {
        long jD = d();
        boolean zB = b();
        if (jD != 0 || zB) {
            f23625i.g(this, jD, zB);
        }
    }

    public final boolean s() {
        return f23625i.d(this);
    }

    public IOException t(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long u(long j8) {
        return this.f23633h - j8;
    }

    public final T v(T sink) {
        AbstractC2304t.f(sink, "sink");
        return new C0411c(sink);
    }

    public final V w(V source) {
        AbstractC2304t.f(source, "source");
        return new d(source);
    }

    public void x() {
    }
}
