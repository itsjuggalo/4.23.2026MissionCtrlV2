package u5;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: classes.dex */
public final class l implements E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f10534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f10535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f10536c;

    public l(r fileHandle, long j4) {
        kotlin.jvm.internal.j.e(fileHandle, "fileHandle");
        this.f10534a = fileHandle;
        this.f10535b = j4;
    }

    @Override // u5.E
    public final long a(long j4, C1250g sink) {
        long j6;
        long j7;
        int i;
        kotlin.jvm.internal.j.e(sink, "sink");
        if (this.f10536c) {
            throw new IllegalStateException("closed");
        }
        r rVar = this.f10534a;
        long j8 = this.f10535b;
        rVar.getClass();
        if (j4 < 0) {
            throw new IllegalArgumentException(k0.a.f("byteCount < 0: ", j4).toString());
        }
        long j9 = j4 + j8;
        long j10 = j8;
        while (true) {
            if (j10 >= j9) {
                j6 = -1;
                break;
            }
            z zVarW = sink.w(1);
            byte[] array = zVarW.f10558a;
            int i6 = zVarW.f10560c;
            j6 = -1;
            int iMin = (int) Math.min(j9 - j10, 8192 - i6);
            synchronized (rVar) {
                kotlin.jvm.internal.j.e(array, "array");
                rVar.e.seek(j10);
                i = 0;
                while (true) {
                    if (i >= iMin) {
                        break;
                    }
                    int i7 = rVar.e.read(array, i6, iMin - i);
                    if (i7 != -1) {
                        i += i7;
                    } else if (i == 0) {
                        i = -1;
                    }
                }
            }
            if (i == -1) {
                if (zVarW.f10559b == zVarW.f10560c) {
                    sink.f10525a = zVarW.a();
                    A.a(zVarW);
                }
                if (j8 == j10) {
                    j7 = -1;
                }
            } else {
                zVarW.f10560c += i;
                long j11 = i;
                j10 += j11;
                sink.f10526b += j11;
            }
        }
        j7 = j10 - j8;
        if (j7 != j6) {
            this.f10535b += j7;
        }
        return j7;
    }

    @Override // u5.E
    public final G b() {
        return G.f10504d;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f10536c) {
            return;
        }
        this.f10536c = true;
        r rVar = this.f10534a;
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
}
