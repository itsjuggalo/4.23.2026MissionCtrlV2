package w6;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: renamed from: w6.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2796i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f25111a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f25112b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f25114d = c0.b();

    /* JADX INFO: renamed from: w6.i$a */
    public static final class a implements X {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2796i f25115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f25116b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f25117c;

        public a(AbstractC2796i fileHandle, long j7) {
            kotlin.jvm.internal.r.f(fileHandle, "fileHandle");
            this.f25115a = fileHandle;
            this.f25116b = j7;
        }

        @Override // w6.X
        public void L(C2792e source, long j7) {
            kotlin.jvm.internal.r.f(source, "source");
            if (this.f25117c) {
                throw new IllegalStateException("closed");
            }
            this.f25115a.B0(this.f25116b, source, j7);
            this.f25116b += j7;
        }

        @Override // w6.X, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25117c) {
                return;
            }
            this.f25117c = true;
            ReentrantLock reentrantLockK = this.f25115a.K();
            reentrantLockK.lock();
            try {
                AbstractC2796i abstractC2796i = this.f25115a;
                abstractC2796i.f25113c--;
                if (this.f25115a.f25113c == 0 && this.f25115a.f25112b) {
                    E5.E e7 = E5.E.f1657a;
                    reentrantLockK.unlock();
                    this.f25115a.M();
                }
            } finally {
                reentrantLockK.unlock();
            }
        }

        @Override // w6.X
        public a0 f() {
            return a0.f25070e;
        }

        @Override // w6.X, java.io.Flushable
        public void flush() {
            if (this.f25117c) {
                throw new IllegalStateException("closed");
            }
            this.f25115a.O();
        }
    }

    /* JADX INFO: renamed from: w6.i$b */
    public static final class b implements Z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2796i f25118a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f25119b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f25120c;

        public b(AbstractC2796i fileHandle, long j7) {
            kotlin.jvm.internal.r.f(fileHandle, "fileHandle");
            this.f25118a = fileHandle;
            this.f25119b = j7;
        }

        @Override // w6.Z, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f25120c) {
                return;
            }
            this.f25120c = true;
            ReentrantLock reentrantLockK = this.f25118a.K();
            reentrantLockK.lock();
            try {
                AbstractC2796i abstractC2796i = this.f25118a;
                abstractC2796i.f25113c--;
                if (this.f25118a.f25113c == 0 && this.f25118a.f25112b) {
                    E5.E e7 = E5.E.f1657a;
                    reentrantLockK.unlock();
                    this.f25118a.M();
                }
            } finally {
                reentrantLockK.unlock();
            }
        }

        @Override // w6.Z
        public a0 f() {
            return a0.f25070e;
        }

        @Override // w6.Z
        public long z(C2792e sink, long j7) {
            kotlin.jvm.internal.r.f(sink, "sink");
            if (this.f25120c) {
                throw new IllegalStateException("closed");
            }
            long jC0 = this.f25118a.c0(this.f25119b, sink, j7);
            if (jC0 != -1) {
                this.f25119b += jC0;
            }
            return jC0;
        }
    }

    public AbstractC2796i(boolean z7) {
        this.f25111a = z7;
    }

    public static /* synthetic */ X y0(AbstractC2796i abstractC2796i, long j7, int i7, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i7 & 1) != 0) {
            j7 = 0;
        }
        return abstractC2796i.i0(j7);
    }

    public final Z A0(long j7) {
        ReentrantLock reentrantLock = this.f25114d;
        reentrantLock.lock();
        try {
            if (this.f25112b) {
                throw new IllegalStateException("closed");
            }
            this.f25113c++;
            reentrantLock.unlock();
            return new b(this, j7);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void B0(long j7, C2792e c2792e, long j8) {
        AbstractC2789b.b(c2792e.E0(), 0L, j8);
        long j9 = j8 + j7;
        while (j7 < j9) {
            U u7 = c2792e.f25095a;
            kotlin.jvm.internal.r.c(u7);
            int iMin = (int) Math.min(j9 - j7, u7.f25054c - u7.f25053b);
            X(j7, u7.f25052a, u7.f25053b, iMin);
            u7.f25053b += iMin;
            long j10 = iMin;
            j7 += j10;
            c2792e.D0(c2792e.E0() - j10);
            if (u7.f25053b == u7.f25054c) {
                c2792e.f25095a = u7.b();
                V.b(u7);
            }
        }
    }

    public final ReentrantLock K() {
        return this.f25114d;
    }

    public abstract void M();

    public abstract void O();

    public abstract int T(long j7, byte[] bArr, int i7, int i8);

    public abstract long V();

    public abstract void X(long j7, byte[] bArr, int i7, int i8);

    public final long c0(long j7, C2792e c2792e, long j8) {
        if (j8 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j8).toString());
        }
        long j9 = j8 + j7;
        long j10 = j7;
        while (true) {
            if (j10 >= j9) {
                break;
            }
            U uH0 = c2792e.H0(1);
            int iT = T(j10, uH0.f25052a, uH0.f25054c, (int) Math.min(j9 - j10, 8192 - r7));
            if (iT == -1) {
                if (uH0.f25053b == uH0.f25054c) {
                    c2792e.f25095a = uH0.b();
                    V.b(uH0);
                }
                if (j7 == j10) {
                    return -1L;
                }
            } else {
                uH0.f25054c += iT;
                long j11 = iT;
                j10 += j11;
                c2792e.D0(c2792e.E0() + j11);
            }
        }
        return j10 - j7;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f25114d;
        reentrantLock.lock();
        try {
            if (this.f25112b) {
                return;
            }
            this.f25112b = true;
            if (this.f25113c != 0) {
                return;
            }
            E5.E e7 = E5.E.f1657a;
            reentrantLock.unlock();
            M();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() {
        if (!this.f25111a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.f25114d;
        reentrantLock.lock();
        try {
            if (this.f25112b) {
                throw new IllegalStateException("closed");
            }
            E5.E e7 = E5.E.f1657a;
            reentrantLock.unlock();
            O();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final X i0(long j7) {
        if (!this.f25111a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.f25114d;
        reentrantLock.lock();
        try {
            if (this.f25112b) {
                throw new IllegalStateException("closed");
            }
            this.f25113c++;
            reentrantLock.unlock();
            return new a(this, j7);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long z0() {
        ReentrantLock reentrantLock = this.f25114d;
        reentrantLock.lock();
        try {
            if (this.f25112b) {
                throw new IllegalStateException("closed");
            }
            E5.E e7 = E5.E.f1657a;
            reentrantLock.unlock();
            return V();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
