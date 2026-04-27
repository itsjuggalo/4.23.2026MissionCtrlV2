package F5;

import H5.g;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static final String a(Object from, Object until) {
        AbstractC2304t.f(from, "from");
        AbstractC2304t.f(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(long j8, long j9) {
        if (j9 <= j8) {
            throw new IllegalArgumentException(a(Long.valueOf(j8), Long.valueOf(j9)).toString());
        }
    }

    public static final int c(int i8) {
        return 31 - Integer.numberOfLeadingZeros(i8);
    }

    public static final long d(c cVar, g range) {
        AbstractC2304t.f(cVar, "<this>");
        AbstractC2304t.f(range, "range");
        if (!range.isEmpty()) {
            long jF = range.f();
            long jE = range.e();
            return jF < Long.MAX_VALUE ? cVar.f(jE, range.f() + 1) : jE > Long.MIN_VALUE ? cVar.f(range.e() - 1, range.f()) + 1 : cVar.e();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int e(int i8, int i9) {
        return (i8 >>> (32 - i9)) & ((-i9) >> 31);
    }
}
