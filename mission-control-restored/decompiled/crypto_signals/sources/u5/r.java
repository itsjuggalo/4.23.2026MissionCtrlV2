package u5;

import java.io.Closeable;
import java.io.RandomAccessFile;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class r implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f10545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f10546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ReentrantLock f10547d = new ReentrantLock();
    public final RandomAccessFile e;

    public r(boolean z6, RandomAccessFile randomAccessFile) {
        this.f10544a = z6;
        this.e = randomAccessFile;
    }

    public static k d(r rVar) {
        if (!rVar.f10544a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = rVar.f10547d;
        reentrantLock.lock();
        try {
            if (rVar.f10545b) {
                throw new IllegalStateException("closed");
            }
            rVar.f10546c++;
            reentrantLock.unlock();
            return new k(rVar);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ReentrantLock reentrantLock = this.f10547d;
        reentrantLock.lock();
        try {
            if (this.f10545b) {
                return;
            }
            this.f10545b = true;
            if (this.f10546c != 0) {
                return;
            }
            synchronized (this) {
                this.e.close();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long f() {
        long length;
        ReentrantLock reentrantLock = this.f10547d;
        reentrantLock.lock();
        try {
            if (this.f10545b) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                length = this.e.length();
            }
            return length;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void flush() {
        if (!this.f10544a) {
            throw new IllegalStateException("file handle is read-only");
        }
        ReentrantLock reentrantLock = this.f10547d;
        reentrantLock.lock();
        try {
            if (this.f10545b) {
                throw new IllegalStateException("closed");
            }
            synchronized (this) {
                this.e.getFD().sync();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final l g(long j4) {
        ReentrantLock reentrantLock = this.f10547d;
        reentrantLock.lock();
        try {
            if (this.f10545b) {
                throw new IllegalStateException("closed");
            }
            this.f10546c++;
            reentrantLock.unlock();
            return new l(this, j4);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
