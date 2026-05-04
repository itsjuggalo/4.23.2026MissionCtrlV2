package hh;

import cd.h0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class c extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f11456i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReentrantLock f11457j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Condition f11458k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f11459l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f11460m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static c f11461n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f11462f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f11463g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f11464h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final c c() throws InterruptedException {
            c cVar = c.f11461n;
            kotlin.jvm.internal.t.c(cVar);
            c cVar2 = cVar.f11463g;
            if (cVar2 == null) {
                long jNanoTime = System.nanoTime();
                e().await(c.f11459l, TimeUnit.MILLISECONDS);
                c cVar3 = c.f11461n;
                kotlin.jvm.internal.t.c(cVar3);
                if (cVar3.f11463g != null || System.nanoTime() - jNanoTime < c.f11460m) {
                    return null;
                }
                return c.f11461n;
            }
            long jU = cVar2.u(System.nanoTime());
            if (jU > 0) {
                e().await(jU, TimeUnit.NANOSECONDS);
                return null;
            }
            c cVar4 = c.f11461n;
            kotlin.jvm.internal.t.c(cVar4);
            cVar4.f11463g = cVar2.f11463g;
            cVar2.f11463g = null;
            return cVar2;
        }

        public final boolean d(c cVar) {
            ReentrantLock reentrantLockF = c.f11456i.f();
            reentrantLockF.lock();
            try {
                if (!cVar.f11462f) {
                    return false;
                }
                cVar.f11462f = false;
                for (c cVar2 = c.f11461n; cVar2 != null; cVar2 = cVar2.f11463g) {
                    if (cVar2.f11463g == cVar) {
                        cVar2.f11463g = cVar.f11463g;
                        cVar.f11463g = null;
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
            return c.f11458k;
        }

        public final ReentrantLock f() {
            return c.f11457j;
        }

        public final void g(c cVar, long j10, boolean z10) {
            ReentrantLock reentrantLockF = c.f11456i.f();
            reentrantLockF.lock();
            try {
                if (cVar.f11462f) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                cVar.f11462f = true;
                if (c.f11461n == null) {
                    c.f11461n = new c();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j10 != 0 && z10) {
                    cVar.f11464h = Math.min(j10, cVar.a() - jNanoTime) + jNanoTime;
                } else if (j10 != 0) {
                    cVar.f11464h = j10 + jNanoTime;
                } else {
                    if (!z10) {
                        throw new AssertionError();
                    }
                    cVar.f11464h = cVar.a();
                }
                long jU = cVar.u(jNanoTime);
                c cVar2 = c.f11461n;
                kotlin.jvm.internal.t.c(cVar2);
                while (cVar2.f11463g != null) {
                    c cVar3 = cVar2.f11463g;
                    kotlin.jvm.internal.t.c(cVar3);
                    if (jU < cVar3.u(jNanoTime)) {
                        break;
                    }
                    cVar2 = cVar2.f11463g;
                    kotlin.jvm.internal.t.c(cVar2);
                }
                cVar.f11463g = cVar2.f11463g;
                cVar2.f11463g = cVar;
                if (cVar2 == c.f11461n) {
                    c.f11456i.e().signal();
                }
                h0 h0Var = h0.f3852a;
                reentrantLockF.unlock();
            } catch (Throwable th) {
                reentrantLockF.unlock();
                throw th;
            }
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLockF;
            c cVarC;
            while (true) {
                try {
                    a aVar = c.f11456i;
                    reentrantLockF = aVar.f();
                    reentrantLockF.lock();
                    try {
                        cVarC = aVar.c();
                    } finally {
                        reentrantLockF.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (cVarC == c.f11461n) {
                    c.f11461n = null;
                    return;
                }
                h0 h0Var = h0.f3852a;
                reentrantLockF.unlock();
                if (cVarC != null) {
                    cVarC.x();
                }
            }
        }
    }

    /* JADX INFO: renamed from: hh.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0213c implements r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f11466b;

        public C0213c(r rVar) {
            this.f11466b = rVar;
        }

        @Override // hh.r
        public void L(hh.d source, long j10) throws IOException {
            kotlin.jvm.internal.t.f(source, "source");
            hh.b.b(source.size(), 0L, j10);
            while (true) {
                long j11 = 0;
                if (j10 <= 0) {
                    return;
                }
                o oVar = source.f11469a;
                kotlin.jvm.internal.t.c(oVar);
                while (true) {
                    if (j11 >= 65536) {
                        break;
                    }
                    j11 += (long) (oVar.f11497c - oVar.f11496b);
                    if (j11 >= j10) {
                        j11 = j10;
                        break;
                    } else {
                        oVar = oVar.f11500f;
                        kotlin.jvm.internal.t.c(oVar);
                    }
                }
                c cVar = c.this;
                r rVar = this.f11466b;
                cVar.r();
                try {
                    try {
                        rVar.L(source, j11);
                        h0 h0Var = h0.f3852a;
                        if (cVar.s()) {
                            throw cVar.l(null);
                        }
                        j10 -= j11;
                    } catch (IOException e10) {
                        if (!cVar.s()) {
                            throw e10;
                        }
                        throw cVar.l(e10);
                    }
                } catch (Throwable th) {
                    cVar.s();
                    throw th;
                }
            }
        }

        @Override // hh.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            r rVar = this.f11466b;
            cVar.r();
            try {
                rVar.close();
                h0 h0Var = h0.f3852a;
                if (cVar.s()) {
                    throw cVar.l(null);
                }
            } catch (IOException e10) {
                if (!cVar.s()) {
                    throw e10;
                }
                throw cVar.l(e10);
            } finally {
                cVar.s();
            }
        }

        @Override // hh.r, java.io.Flushable
        public void flush() throws IOException {
            c cVar = c.this;
            r rVar = this.f11466b;
            cVar.r();
            try {
                rVar.flush();
                h0 h0Var = h0.f3852a;
                if (cVar.s()) {
                    throw cVar.l(null);
                }
            } catch (IOException e10) {
                if (!cVar.s()) {
                    throw e10;
                }
                throw cVar.l(e10);
            } finally {
                cVar.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f11466b + ')';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d implements t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f11468b;

        public d(t tVar) {
            this.f11468b = tVar;
        }

        @Override // hh.t
        public long B(hh.d sink, long j10) throws IOException {
            kotlin.jvm.internal.t.f(sink, "sink");
            c cVar = c.this;
            t tVar = this.f11468b;
            cVar.r();
            try {
                long jB = tVar.B(sink, j10);
                if (cVar.s()) {
                    throw cVar.l(null);
                }
                return jB;
            } catch (IOException e10) {
                if (cVar.s()) {
                    throw cVar.l(e10);
                }
                throw e10;
            } finally {
                cVar.s();
            }
        }

        @Override // hh.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            t tVar = this.f11468b;
            cVar.r();
            try {
                tVar.close();
                h0 h0Var = h0.f3852a;
                if (cVar.s()) {
                    throw cVar.l(null);
                }
            } catch (IOException e10) {
                if (!cVar.s()) {
                    throw e10;
                }
                throw cVar.l(e10);
            } finally {
                cVar.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f11468b + ')';
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f11457j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.t.e(conditionNewCondition, "lock.newCondition()");
        f11458k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f11459l = millis;
        f11460m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final IOException l(IOException iOException) {
        return t(iOException);
    }

    public final void r() {
        long jD = d();
        boolean zB = b();
        if (jD != 0 || zB) {
            f11456i.g(this, jD, zB);
        }
    }

    public final boolean s() {
        return f11456i.d(this);
    }

    public IOException t(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long u(long j10) {
        return this.f11464h - j10;
    }

    public final r v(r sink) {
        kotlin.jvm.internal.t.f(sink, "sink");
        return new C0213c(sink);
    }

    public final t w(t source) {
        kotlin.jvm.internal.t.f(source, "source");
        return new d(source);
    }

    public void x() {
    }
}
