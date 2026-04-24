package u5;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class k implements C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f10531a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10532b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10533c;

    public k(r fileHandle) {
        kotlin.jvm.internal.j.e(fileHandle, "fileHandle");
        this.f10531a = fileHandle;
        this.f10532b = 0L;
    }

    @Override // u5.C
    public final void c(long j4, C1250g c1250g) {
        if (this.f10533c) {
            throw new IllegalStateException("closed");
        }
        r rVar = this.f10531a;
        long j6 = this.f10532b;
        rVar.getClass();
        AbstractC1245b.d(c1250g.f10526b, 0L, j4);
        long j7 = j6 + j4;
        while (j6 < j7) {
            z zVar = c1250g.f10525a;
            kotlin.jvm.internal.j.b(zVar);
            int iMin = (int) Math.min(j7 - j6, zVar.f10560c - zVar.f10559b);
            byte[] array = zVar.f10558a;
            int i = zVar.f10559b;
            synchronized (rVar) {
                kotlin.jvm.internal.j.e(array, "array");
                rVar.e.seek(j6);
                rVar.e.write(array, i, iMin);
            }
            int i6 = zVar.f10559b + iMin;
            zVar.f10559b = i6;
            long j8 = iMin;
            j6 += j8;
            c1250g.f10526b -= j8;
            if (i6 == zVar.f10560c) {
                c1250g.f10525a = zVar.a();
                A.a(zVar);
            }
        }
        this.f10532b += j4;
    }

    @Override // u5.C, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f10533c) {
            return;
        }
        this.f10533c = true;
        r rVar = this.f10531a;
        ReentrantLock reentrantLock = rVar.f10547d;
        reentrantLock.lock();
        try {
            int i = rVar.f10546c - 1;
            rVar.f10546c = i;
            if (i == 0) {
                if (rVar.f10545b) {
                    synchronized (rVar) {
                        rVar.e.close();
                    }
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // u5.C, java.io.Flushable
    public final void flush() {
        if (this.f10533c) {
            throw new IllegalStateException("closed");
        }
        r rVar = this.f10531a;
        synchronized (rVar) {
            rVar.e.getFD().sync();
        }
    }
}
