package m3;

import kotlin.jvm.internal.r;
import o3.C1679j;

/* JADX INFO: renamed from: m3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1609d {
    public static final String a(Object from, Object until) {
        r.f(from, "from");
        r.f(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(long j4, long j5) {
        if (j5 <= j4) {
            throw new IllegalArgumentException(a(Long.valueOf(j4), Long.valueOf(j5)).toString());
        }
    }

    public static final int c(int i4) {
        return 31 - Integer.numberOfLeadingZeros(i4);
    }

    public static final long d(AbstractC1608c abstractC1608c, C1679j range) {
        r.f(abstractC1608c, "<this>");
        r.f(range, "range");
        if (!range.isEmpty()) {
            return range.l() < Long.MAX_VALUE ? abstractC1608c.f(range.k(), range.l() + 1) : range.k() > Long.MIN_VALUE ? abstractC1608c.f(range.k() - 1, range.l()) + 1 : abstractC1608c.e();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int e(int i4, int i5) {
        return (i4 >>> (32 - i5)) & ((-i5) >> 31);
    }
}
