package u7;

import java.io.Closeable;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2470H;

/* JADX INFO: renamed from: u7.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2815h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f23653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f23654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f23655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f23656d = Y.b();

    /* JADX INFO: renamed from: u7.h$a */
    public static final class a implements T {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2815h f23657a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f23658b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f23659c;

        public a(AbstractC2815h fileHandle, long j8) {
            AbstractC2304t.f(fileHandle, "fileHandle");
            this.f23657a = fileHandle;
            this.f23658b = j8;
        }

        @Override // u7.T
        public void H(C2811d source, long j8) {
            AbstractC2304t.f(source, "source");
            if (!(!this.f23659c)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f23657a.T(this.f23658b, source, j8);
            this.f23658b += j8;
        }

        @Override // u7.T, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f23659c) {
                return;
            }
            this.f23659c = true;
            ReentrantLock reentrantLockR = this.f23657a.r();
            reentrantLockR.lock();
            try {
                AbstractC2815h abstractC2815h = this.f23657a;
                abstractC2815h.f23655c--;
                if (this.f23657a.f23655c == 0 && this.f23657a.f23654b) {
                    C2470H c2470h = C2470H.f21956a;
                    reentrantLockR.unlock();
                    this.f23657a.B();
                }
            } finally {
                reentrantLockR.unlock();
            }
        }

        @Override // u7.T, java.io.Flushable
        public void flush() {
            if (!(!this.f23659c)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f23657a.D();
        }
    }

    /* JADX INFO: renamed from: u7.h$b */
    public static final class b implements V {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AbstractC2815h f23660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f23661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f23662c;

        public b(AbstractC2815h fileHandle, long j8) {
            AbstractC2304t.f(fileHandle, "fileHandle");
            this.f23660a = fileHandle;
            this.f23661b = j8;
        }

        @Override // u7.V, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (this.f23662c) {
                return;
            }
            this.f23662c = true;
            ReentrantLock reentrantLockR = this.f23660a.r();
            reentrantLockR.lock();
            try {
                AbstractC2815h abstractC2815h = this.f23660a;
                abstractC2815h.f23655c--;
                if (this.f23660a.f23655c == 0 && this.f23660a.f23654b) {
                    C2470H c2470h = C2470H.f21956a;
                    reentrantLockR.unlock();
                    this.f23660a.B();
                }
            } finally {
                reentrantLockR.unlock();
            }
        }

        @Override // u7.V
        public long o0(C2811d sink, long j8) {
            AbstractC2304t.f(sink, "sink");
            if (!(!this.f23662c)) {
                throw new IllegalStateException("closed".toString());
            }
            long jN = this.f23660a.N(this.f23661b, sink, j8);
            if (jN != -1) {
                this.f23661b += jN;
            }
            return jN;
        }
    }

    public AbstractC2815h(boolean z7) {
        this.f23653a = z7;
    }

    public static /* synthetic */ T Q(AbstractC2815h abstractC2815h, long j8, int i8, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i8 & 1) != 0) {
            j8 = 0;
        }
        return abstractC2815h.O(j8);
    }

    public abstract void B();

    public abstract void D();

    public abstract int E(long j8, byte[] bArr, int i8, int i9);

    public abstract long K();

    public abstract void M(long j8, byte[] bArr, int i8, int i9);

    public final long N(long j8, C2811d c2811d, long j9) {
        if (j9 < 0) {
            throw new IllegalArgumentException(("byteCount < 0: " + j9).toString());
        }
        long j10 = j9 + j8;
        long j11 = j8;
        while (true) {
            if (j11 >= j10) {
                break;
            }
            P pX0 = c2811d.x0(1);
            int iE = E(j11, pX0.f23595a, pX0.f23597c, (int) Math.min(j10 - j11, 8192 - r7));
            if (iE == -1) {
                if (pX0.f23596b == pX0.f23597c) {
                    c2811d.f23638a = pX0.b();
                    Q.b(pX0);
                }
                if (j8 == j11) {
                    return -1L;
                }
            } else {
                pX0.f23597c += iE;
                long j12 = iE;
                j11 += j12;
                c2811d.r0(c2811d.s0() + j12);
            }
        }
        return j11 - j8;
    }

    public final T O(long j8) {
        if (!this.f23653a) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock reentrantLock = this.f23656d;
        reentrantLock.lock();
        try {
            if (!(!this.f23654b)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f23655c++;
            reentrantLock.unlock();
            return new a(this, j8);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final long R() {
        ReentrantLock reentrantLock = this.f23656d;
        reentrantLock.lock();
        try {
            if (!(!this.f23654b)) {
                throw new IllegalStateException("closed".toString());
            }
            C2470H c2470h = C2470H.f21956a;
            reentrantLock.unlock();
            return K();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final V S(long j8) {
        ReentrantLock reentrantLock = this.f23656d;
        reentrantLock.lock();
        try {
            if (!(!this.f23654b)) {
                throw new IllegalStateException("closed".toString());
            }
            this.f23655c++;
            reentrantLock.unlock();
            return new b(this, j8);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void T(long j8, C2811d c2811d, long j9) {
        AbstractC2809b.b(c2811d.s0(), 0L, j9);
        long j10 = j9 + j8;
        while (j8 < j10) {
            P p8 = c2811d.f23638a;
            AbstractC2304t.c(p8);
            int iMin = (int) Math.min(j10 - j8, p8.f23597c - p8.f23596b);
            M(j8, p8.f23595a, p8.f23596b, iMin);
            p8.f23596b += iMin;
            long j11 = iMin;
            j8 += j11;
            c2811d.r0(c2811d.s0() - j11);
            if (p8.f23596b == p8.f23597c) {
                c2811d.f23638a = p8.b();
                Q.b(p8);
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f23656d;
        reentrantLock.lock();
        try {
            if (this.f23654b) {
                return;
            }
            this.f23654b = true;
            if (this.f23655c != 0) {
                return;
            }
            C2470H c2470h = C2470H.f21956a;
            reentrantLock.unlock();
            B();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() {
        if (!this.f23653a) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        ReentrantLock reentrantLock = this.f23656d;
        reentrantLock.lock();
        try {
            if (!(!this.f23654b)) {
                throw new IllegalStateException("closed".toString());
            }
            C2470H c2470h = C2470H.f21956a;
            reentrantLock.unlock();
            D();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final ReentrantLock r() {
        return this.f23656d;
    }
}
