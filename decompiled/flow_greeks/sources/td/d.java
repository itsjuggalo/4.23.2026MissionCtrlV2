package td;

import kotlin.jvm.internal.t;
import vd.j;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final String a(Object from, Object until) {
        t.f(from, "from");
        t.f(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(long j10, long j11) {
        if (j11 <= j10) {
            throw new IllegalArgumentException(a(Long.valueOf(j10), Long.valueOf(j11)).toString());
        }
    }

    public static final int c(int i10) {
        return 31 - Integer.numberOfLeadingZeros(i10);
    }

    public static final long d(c cVar, j range) {
        t.f(cVar, "<this>");
        t.f(range, "range");
        if (!range.isEmpty()) {
            return range.f() < Long.MAX_VALUE ? cVar.f(range.e(), range.f() + 1) : range.e() > Long.MIN_VALUE ? cVar.f(range.e() - 1, range.f()) + 1 : cVar.e();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int e(int i10, int i11) {
        return (i10 >>> (32 - i11)) & ((-i11) >> 31);
    }
}
