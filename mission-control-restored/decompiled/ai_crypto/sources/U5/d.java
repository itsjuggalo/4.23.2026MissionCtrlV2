package U5;

import W5.j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static final String a(Object from, Object until) {
        r.f(from, "from");
        r.f(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(long j7, long j8) {
        if (j8 <= j7) {
            throw new IllegalArgumentException(a(Long.valueOf(j7), Long.valueOf(j8)).toString());
        }
    }

    public static final int c(int i7) {
        return 31 - Integer.numberOfLeadingZeros(i7);
    }

    public static final long d(c cVar, j range) {
        r.f(cVar, "<this>");
        r.f(range, "range");
        if (!range.isEmpty()) {
            return range.h() < Long.MAX_VALUE ? cVar.f(range.g(), range.h() + 1) : range.g() > Long.MIN_VALUE ? cVar.f(range.g() - 1, range.h()) + 1 : cVar.e();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int e(int i7, int i8) {
        return (i7 >>> (32 - i8)) & ((-i8) >> 31);
    }
}
