package o3;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;
import m3.AbstractC1608c;
import m3.AbstractC1609d;
import o3.C1674e;

/* JADX INFO: renamed from: o3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1681l extends AbstractC1680k {
    public static int b(int i4, int i5) {
        return i4 < i5 ? i5 : i4;
    }

    public static long c(long j4, long j5) {
        return j4 < j5 ? j5 : j4;
    }

    public static int d(int i4, int i5) {
        return i4 > i5 ? i5 : i4;
    }

    public static long e(long j4, long j5) {
        return j4 > j5 ? j5 : j4;
    }

    public static int f(int i4, int i5, int i6) {
        if (i5 <= i6) {
            return i4 < i5 ? i5 : i4 > i6 ? i6 : i4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i6 + " is less than minimum " + i5 + com.amazon.a.a.o.c.a.b.f8816a);
    }

    public static long g(long j4, long j5, long j6) {
        if (j5 <= j6) {
            return j4 < j5 ? j5 : j4 > j6 ? j6 : j4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j6 + " is less than minimum " + j5 + com.amazon.a.a.o.c.a.b.f8816a);
    }

    public static long h(long j4, InterfaceC1673d range) {
        r.f(range, "range");
        if (!range.isEmpty()) {
            return j4 < ((Number) range.f()).longValue() ? ((Number) range.f()).longValue() : j4 > ((Number) range.i()).longValue() ? ((Number) range.i()).longValue() : j4;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + com.amazon.a.a.o.c.a.b.f8816a);
    }

    public static C1674e i(int i4, int i5) {
        return C1674e.f13934d.a(i4, i5, -1);
    }

    public static long j(C1679j c1679j, AbstractC1608c random) {
        r.f(c1679j, "<this>");
        r.f(random, "random");
        try {
            return AbstractC1609d.d(random, c1679j);
        } catch (IllegalArgumentException e4) {
            throw new NoSuchElementException(e4.getMessage());
        }
    }

    public static C1674e k(C1674e c1674e, int i4) {
        r.f(c1674e, "<this>");
        AbstractC1680k.a(i4 > 0, Integer.valueOf(i4));
        C1674e.a aVar = C1674e.f13934d;
        int iK = c1674e.k();
        int iL = c1674e.l();
        if (c1674e.m() <= 0) {
            i4 = -i4;
        }
        return aVar.a(iK, iL, i4);
    }

    public static C1676g l(int i4, int i5) {
        return i5 <= Integer.MIN_VALUE ? C1676g.f13942e.a() : new C1676g(i4, i5 - 1);
    }
}
