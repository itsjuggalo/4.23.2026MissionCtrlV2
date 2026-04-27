package j5;

import java.util.concurrent.atomic.AtomicLong;
import k5.AbstractC2283a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static long a(AtomicLong atomicLong, long j8) {
        long j9;
        do {
            j9 = atomicLong.get();
            if (j9 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j9, c(j9, j8)));
        return j9;
    }

    public static long b(AtomicLong atomicLong, long j8) {
        long j9;
        do {
            j9 = atomicLong.get();
            if (j9 == Long.MIN_VALUE) {
                return Long.MIN_VALUE;
            }
            if (j9 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
        } while (!atomicLong.compareAndSet(j9, c(j9, j8)));
        return j9;
    }

    public static long c(long j8, long j9) {
        long j10 = j8 + j9;
        if (j10 < 0) {
            return Long.MAX_VALUE;
        }
        return j10;
    }

    public static long d(AtomicLong atomicLong, long j8) {
        long j9;
        long j10;
        do {
            j9 = atomicLong.get();
            if (j9 == Long.MAX_VALUE) {
                return Long.MAX_VALUE;
            }
            j10 = j9 - j8;
            if (j10 < 0) {
                AbstractC2283a.q(new IllegalStateException("More produced than requested: " + j10));
                j10 = 0L;
            }
        } while (!atomicLong.compareAndSet(j9, j10));
        return j10;
    }
}
