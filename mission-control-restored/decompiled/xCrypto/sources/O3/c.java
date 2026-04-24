package O3;

import W2.E;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: loaded from: classes3.dex */
public class c extends u {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f3308i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReentrantLock f3309j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Condition f3310k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f3311l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f3312m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static c f3313n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f3314f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public c f3315g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f3316h;

    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final c c() throws InterruptedException {
            c cVar = c.f3313n;
            kotlin.jvm.internal.r.c(cVar);
            c cVar2 = cVar.f3315g;
            if (cVar2 == null) {
                long jNanoTime = System.nanoTime();
                e().await(c.f3311l, TimeUnit.MILLISECONDS);
                c cVar3 = c.f3313n;
                kotlin.jvm.internal.r.c(cVar3);
                if (cVar3.f3315g != null || System.nanoTime() - jNanoTime < c.f3312m) {
                    return null;
                }
                return c.f3313n;
            }
            long jU = cVar2.u(System.nanoTime());
            if (jU > 0) {
                e().await(jU, TimeUnit.NANOSECONDS);
                return null;
            }
            c cVar4 = c.f3313n;
            kotlin.jvm.internal.r.c(cVar4);
            cVar4.f3315g = cVar2.f3315g;
            cVar2.f3315g = null;
            return cVar2;
        }

        public final boolean d(c cVar) {
            ReentrantLock reentrantLockF = c.f3308i.f();
            reentrantLockF.lock();
            try {
                if (!cVar.f3314f) {
                    return false;
                }
                cVar.f3314f = false;
                for (c cVar2 = c.f3313n; cVar2 != null; cVar2 = cVar2.f3315g) {
                    if (cVar2.f3315g == cVar) {
                        cVar2.f3315g = cVar.f3315g;
                        cVar.f3315g = null;
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
            return c.f3310k;
        }

        public final ReentrantLock f() {
            return c.f3309j;
        }

        public final void g(c cVar, long j4, boolean z4) {
            ReentrantLock reentrantLockF = c.f3308i.f();
            reentrantLockF.lock();
            try {
                if (cVar.f3314f) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                cVar.f3314f = true;
                if (c.f3313n == null) {
                    c.f3313n = new c();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j4 != 0 && z4) {
                    cVar.f3316h = Math.min(j4, cVar.a() - jNanoTime) + jNanoTime;
                } else if (j4 != 0) {
                    cVar.f3316h = j4 + jNanoTime;
                } else {
                    if (!z4) {
                        throw new AssertionError();
                    }
                    cVar.f3316h = cVar.a();
                }
                long jU = cVar.u(jNanoTime);
                c cVar2 = c.f3313n;
                kotlin.jvm.internal.r.c(cVar2);
                while (cVar2.f3315g != null) {
                    c cVar3 = cVar2.f3315g;
                    kotlin.jvm.internal.r.c(cVar3);
                    if (jU < cVar3.u(jNanoTime)) {
                        break;
                    }
                    cVar2 = cVar2.f3315g;
                    kotlin.jvm.internal.r.c(cVar2);
                }
                cVar.f3315g = cVar2.f3315g;
                cVar2.f3315g = cVar;
                if (cVar2 == c.f3313n) {
                    c.f3308i.e().signal();
                }
                E e4 = E.f5463a;
                reentrantLockF.unlock();
            } catch (Throwable th) {
                reentrantLockF.unlock();
                throw th;
            }
        }

        public a() {
        }
    }

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
                    a aVar = c.f3308i;
                    reentrantLockF = aVar.f();
                    reentrantLockF.lock();
                    try {
                        cVarC = aVar.c();
                    } finally {
                        reentrantLockF.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (cVarC == c.f3313n) {
                    c.f3313n = null;
                    return;
                }
                E e4 = E.f5463a;
                reentrantLockF.unlock();
                if (cVarC != null) {
                    cVarC.x();
                }
            }
        }
    }

    /* JADX INFO: renamed from: O3.c$c, reason: collision with other inner class name */
    public static final class C0055c implements r {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ r f3318b;

        public C0055c(r rVar) {
            this.f3318b = rVar;
        }

        @Override // O3.r
        public void c0(O3.d source, long j4) throws IOException {
            kotlin.jvm.internal.r.f(source, "source");
            O3.b.b(source.i0(), 0L, j4);
            while (true) {
                long j5 = 0;
                if (j4 <= 0) {
                    return;
                }
                o oVar = source.f3321a;
                kotlin.jvm.internal.r.c(oVar);
                while (true) {
                    if (j5 >= 65536) {
                        break;
                    }
                    j5 += (long) (oVar.f3349c - oVar.f3348b);
                    if (j5 >= j4) {
                        j5 = j4;
                        break;
                    } else {
                        oVar = oVar.f3352f;
                        kotlin.jvm.internal.r.c(oVar);
                    }
                }
                c cVar = c.this;
                r rVar = this.f3318b;
                cVar.r();
                try {
                    try {
                        rVar.c0(source, j5);
                        E e4 = E.f5463a;
                        if (cVar.s()) {
                            throw cVar.l(null);
                        }
                        j4 -= j5;
                    } catch (IOException e5) {
                        if (!cVar.s()) {
                            throw e5;
                        }
                        throw cVar.l(e5);
                    }
                } catch (Throwable th) {
                    cVar.s();
                    throw th;
                }
            }
        }

        @Override // O3.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            r rVar = this.f3318b;
            cVar.r();
            try {
                rVar.close();
                E e4 = E.f5463a;
                if (cVar.s()) {
                    throw cVar.l(null);
                }
            } catch (IOException e5) {
                if (!cVar.s()) {
                    throw e5;
                }
                throw cVar.l(e5);
            } finally {
                cVar.s();
            }
        }

        @Override // O3.r, java.io.Flushable
        public void flush() throws IOException {
            c cVar = c.this;
            r rVar = this.f3318b;
            cVar.r();
            try {
                rVar.flush();
                E e4 = E.f5463a;
                if (cVar.s()) {
                    throw cVar.l(null);
                }
            } catch (IOException e5) {
                if (!cVar.s()) {
                    throw e5;
                }
                throw cVar.l(e5);
            } finally {
                cVar.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f3318b + ')';
        }
    }

    public static final class d implements t {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ t f3320b;

        public d(t tVar) {
            this.f3320b = tVar;
        }

        @Override // O3.t, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            c cVar = c.this;
            t tVar = this.f3320b;
            cVar.r();
            try {
                tVar.close();
                E e4 = E.f5463a;
                if (cVar.s()) {
                    throw cVar.l(null);
                }
            } catch (IOException e5) {
                if (!cVar.s()) {
                    throw e5;
                }
                throw cVar.l(e5);
            } finally {
                cVar.s();
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f3320b + ')';
        }

        @Override // O3.t
        public long v(O3.d sink, long j4) throws IOException {
            kotlin.jvm.internal.r.f(sink, "sink");
            c cVar = c.this;
            t tVar = this.f3320b;
            cVar.r();
            try {
                long jV = tVar.v(sink, j4);
                if (cVar.s()) {
                    throw cVar.l(null);
                }
                return jV;
            } catch (IOException e4) {
                if (cVar.s()) {
                    throw cVar.l(e4);
                }
                throw e4;
            } finally {
                cVar.s();
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f3309j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.r.e(conditionNewCondition, "lock.newCondition()");
        f3310k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f3311l = millis;
        f3312m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final IOException l(IOException iOException) {
        return t(iOException);
    }

    public final void r() {
        long jD = d();
        boolean zB = b();
        if (jD != 0 || zB) {
            f3308i.g(this, jD, zB);
        }
    }

    public final boolean s() {
        return f3308i.d(this);
    }

    public IOException t(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long u(long j4) {
        return this.f3316h - j4;
    }

    public final r v(r sink) {
        kotlin.jvm.internal.r.f(sink, "sink");
        return new C0055c(sink);
    }

    public final t w(t source) {
        kotlin.jvm.internal.r.f(source, "source");
        return new d(source);
    }

    public void x() {
    }
}
