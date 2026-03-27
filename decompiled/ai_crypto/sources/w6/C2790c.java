package w6;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: w6.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2790c extends a0 {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f25082i = new a(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final ReentrantLock f25083j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Condition f25084k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final long f25085l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final long f25086m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static C2790c f25087n;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f25088f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public C2790c f25089g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f25090h;

    /* JADX INFO: renamed from: w6.c$a */
    public static final class a {
        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final C2790c c() throws InterruptedException {
            C2790c c2790c = C2790c.f25087n;
            kotlin.jvm.internal.r.c(c2790c);
            C2790c c2790c2 = c2790c.f25089g;
            if (c2790c2 == null) {
                long jNanoTime = System.nanoTime();
                e().await(C2790c.f25085l, TimeUnit.MILLISECONDS);
                C2790c c2790c3 = C2790c.f25087n;
                kotlin.jvm.internal.r.c(c2790c3);
                if (c2790c3.f25089g != null || System.nanoTime() - jNanoTime < C2790c.f25086m) {
                    return null;
                }
                return C2790c.f25087n;
            }
            long jZ = c2790c2.z(System.nanoTime());
            if (jZ > 0) {
                e().await(jZ, TimeUnit.NANOSECONDS);
                return null;
            }
            C2790c c2790c4 = C2790c.f25087n;
            kotlin.jvm.internal.r.c(c2790c4);
            c2790c4.f25089g = c2790c2.f25089g;
            c2790c2.f25089g = null;
            return c2790c2;
        }

        public final boolean d(C2790c c2790c) {
            ReentrantLock reentrantLockF = C2790c.f25082i.f();
            reentrantLockF.lock();
            try {
                if (!c2790c.f25088f) {
                    return false;
                }
                c2790c.f25088f = false;
                for (C2790c c2790c2 = C2790c.f25087n; c2790c2 != null; c2790c2 = c2790c2.f25089g) {
                    if (c2790c2.f25089g == c2790c) {
                        c2790c2.f25089g = c2790c.f25089g;
                        c2790c.f25089g = null;
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
            return C2790c.f25084k;
        }

        public final ReentrantLock f() {
            return C2790c.f25083j;
        }

        public final void g(C2790c c2790c, long j7, boolean z7) {
            ReentrantLock reentrantLockF = C2790c.f25082i.f();
            reentrantLockF.lock();
            try {
                if (c2790c.f25088f) {
                    throw new IllegalStateException("Unbalanced enter/exit");
                }
                c2790c.f25088f = true;
                if (C2790c.f25087n == null) {
                    C2790c.f25087n = new C2790c();
                    new b().start();
                }
                long jNanoTime = System.nanoTime();
                if (j7 != 0 && z7) {
                    c2790c.f25090h = Math.min(j7, c2790c.c() - jNanoTime) + jNanoTime;
                } else if (j7 != 0) {
                    c2790c.f25090h = j7 + jNanoTime;
                } else {
                    if (!z7) {
                        throw new AssertionError();
                    }
                    c2790c.f25090h = c2790c.c();
                }
                long jZ = c2790c.z(jNanoTime);
                C2790c c2790c2 = C2790c.f25087n;
                kotlin.jvm.internal.r.c(c2790c2);
                while (c2790c2.f25089g != null) {
                    C2790c c2790c3 = c2790c2.f25089g;
                    kotlin.jvm.internal.r.c(c2790c3);
                    if (jZ < c2790c3.z(jNanoTime)) {
                        break;
                    }
                    c2790c2 = c2790c2.f25089g;
                    kotlin.jvm.internal.r.c(c2790c2);
                }
                c2790c.f25089g = c2790c2.f25089g;
                c2790c2.f25089g = c2790c;
                if (c2790c2 == C2790c.f25087n) {
                    C2790c.f25082i.e().signal();
                }
                E5.E e7 = E5.E.f1657a;
                reentrantLockF.unlock();
            } catch (Throwable th) {
                reentrantLockF.unlock();
                throw th;
            }
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: w6.c$b */
    public static final class b extends Thread {
        public b() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            ReentrantLock reentrantLockF;
            C2790c c2790cC;
            while (true) {
                try {
                    a aVar = C2790c.f25082i;
                    reentrantLockF = aVar.f();
                    reentrantLockF.lock();
                    try {
                        c2790cC = aVar.c();
                    } finally {
                        reentrantLockF.unlock();
                    }
                } catch (InterruptedException unused) {
                }
                if (c2790cC == C2790c.f25087n) {
                    C2790c.f25087n = null;
                    return;
                }
                E5.E e7 = E5.E.f1657a;
                reentrantLockF.unlock();
                if (c2790cC != null) {
                    c2790cC.C();
                }
            }
        }
    }

    /* JADX INFO: renamed from: w6.c$c, reason: collision with other inner class name */
    public static final class C0390c implements X {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ X f25092b;

        public C0390c(X x7) {
            this.f25092b = x7;
        }

        @Override // w6.X
        public void L(C2792e source, long j7) throws IOException {
            kotlin.jvm.internal.r.f(source, "source");
            AbstractC2789b.b(source.E0(), 0L, j7);
            while (true) {
                long j8 = 0;
                if (j7 <= 0) {
                    return;
                }
                U u7 = source.f25095a;
                kotlin.jvm.internal.r.c(u7);
                while (true) {
                    if (j8 >= 65536) {
                        break;
                    }
                    j8 += (long) (u7.f25054c - u7.f25053b);
                    if (j8 >= j7) {
                        j8 = j7;
                        break;
                    } else {
                        u7 = u7.f25057f;
                        kotlin.jvm.internal.r.c(u7);
                    }
                }
                C2790c c2790c = C2790c.this;
                X x7 = this.f25092b;
                c2790c.w();
                try {
                    x7.L(source, j8);
                    E5.E e7 = E5.E.f1657a;
                    if (c2790c.x()) {
                        throw c2790c.q(null);
                    }
                    j7 -= j8;
                } catch (IOException e8) {
                    if (!c2790c.x()) {
                        throw e8;
                    }
                    throw c2790c.q(e8);
                } finally {
                    c2790c.x();
                }
            }
        }

        @Override // w6.X, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C2790c c2790c = C2790c.this;
            X x7 = this.f25092b;
            c2790c.w();
            try {
                x7.close();
                E5.E e7 = E5.E.f1657a;
                if (c2790c.x()) {
                    throw c2790c.q(null);
                }
            } catch (IOException e8) {
                if (!c2790c.x()) {
                    throw e8;
                }
                throw c2790c.q(e8);
            } finally {
                c2790c.x();
            }
        }

        @Override // w6.X, java.io.Flushable
        public void flush() throws IOException {
            C2790c c2790c = C2790c.this;
            X x7 = this.f25092b;
            c2790c.w();
            try {
                x7.flush();
                E5.E e7 = E5.E.f1657a;
                if (c2790c.x()) {
                    throw c2790c.q(null);
                }
            } catch (IOException e8) {
                if (!c2790c.x()) {
                    throw e8;
                }
                throw c2790c.q(e8);
            } finally {
                c2790c.x();
            }
        }

        @Override // w6.X
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public C2790c f() {
            return C2790c.this;
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.f25092b + ')';
        }
    }

    /* JADX INFO: renamed from: w6.c$d */
    public static final class d implements Z {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Z f25094b;

        public d(Z z7) {
            this.f25094b = z7;
        }

        @Override // w6.Z, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            C2790c c2790c = C2790c.this;
            Z z7 = this.f25094b;
            c2790c.w();
            try {
                z7.close();
                E5.E e7 = E5.E.f1657a;
                if (c2790c.x()) {
                    throw c2790c.q(null);
                }
            } catch (IOException e8) {
                if (!c2790c.x()) {
                    throw e8;
                }
                throw c2790c.q(e8);
            } finally {
                c2790c.x();
            }
        }

        @Override // w6.Z
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public C2790c f() {
            return C2790c.this;
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.f25094b + ')';
        }

        @Override // w6.Z
        public long z(C2792e sink, long j7) throws IOException {
            kotlin.jvm.internal.r.f(sink, "sink");
            C2790c c2790c = C2790c.this;
            Z z7 = this.f25094b;
            c2790c.w();
            try {
                long jZ = z7.z(sink, j7);
                if (c2790c.x()) {
                    throw c2790c.q(null);
                }
                return jZ;
            } catch (IOException e7) {
                if (c2790c.x()) {
                    throw c2790c.q(e7);
                }
                throw e7;
            } finally {
                c2790c.x();
            }
        }
    }

    static {
        ReentrantLock reentrantLock = new ReentrantLock();
        f25083j = reentrantLock;
        Condition conditionNewCondition = reentrantLock.newCondition();
        kotlin.jvm.internal.r.e(conditionNewCondition, "lock.newCondition()");
        f25084k = conditionNewCondition;
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f25085l = millis;
        f25086m = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    public final X A(X sink) {
        kotlin.jvm.internal.r.f(sink, "sink");
        return new C0390c(sink);
    }

    public final Z B(Z source) {
        kotlin.jvm.internal.r.f(source, "source");
        return new d(source);
    }

    public final IOException q(IOException iOException) {
        return y(iOException);
    }

    public final void w() {
        long jH = h();
        boolean zE = e();
        if (jH != 0 || zE) {
            f25082i.g(this, jH, zE);
        }
    }

    public final boolean x() {
        return f25082i.d(this);
    }

    public IOException y(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final long z(long j7) {
        return this.f25090h - j7;
    }

    public void C() {
    }
}
