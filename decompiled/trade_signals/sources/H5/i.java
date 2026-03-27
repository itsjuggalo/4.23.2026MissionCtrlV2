package H5;

import H5.b;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends h {
    public static int b(int i8, int i9) {
        return i8 < i9 ? i9 : i8;
    }

    public static long c(long j8, long j9) {
        return j8 < j9 ? j9 : j8;
    }

    public static int d(int i8, int i9) {
        return i8 > i9 ? i9 : i8;
    }

    public static long e(long j8, long j9) {
        return j8 > j9 ? j9 : j8;
    }

    public static int f(int i8, int i9, int i10) {
        if (i9 <= i10) {
            return i8 < i9 ? i9 : i8 > i10 ? i10 : i8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i10 + " is less than minimum " + i9 + com.amazon.a.a.o.c.a.b.f14112a);
    }

    public static long g(long j8, long j9, long j10) {
        if (j9 <= j10) {
            return j8 < j9 ? j9 : j8 > j10 ? j10 : j8;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j10 + " is less than minimum " + j9 + com.amazon.a.a.o.c.a.b.f14112a);
    }

    public static long h(long j8, a range) {
        Object objD;
        AbstractC2304t.f(range, "range");
        if (range.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + com.amazon.a.a.o.c.a.b.f14112a);
        }
        if (j8 < ((Number) range.a()).longValue()) {
            objD = range.a();
        } else {
            if (j8 <= ((Number) range.d()).longValue()) {
                return j8;
            }
            objD = range.d();
        }
        return ((Number) objD).longValue();
    }

    public static b i(int i8, int i9) {
        return b.f3954d.a(i8, i9, -1);
    }

    public static long j(g gVar, F5.c random) {
        AbstractC2304t.f(gVar, "<this>");
        AbstractC2304t.f(random, "random");
        try {
            return F5.d.d(random, gVar);
        } catch (IllegalArgumentException e8) {
            throw new NoSuchElementException(e8.getMessage());
        }
    }

    public static b k(b bVar, int i8) {
        AbstractC2304t.f(bVar, "<this>");
        h.a(i8 > 0, Integer.valueOf(i8));
        b.a aVar = b.f3954d;
        int iE = bVar.e();
        int iF = bVar.f();
        if (bVar.h() <= 0) {
            i8 = -i8;
        }
        return aVar.a(iE, iF, i8);
    }

    public static d l(int i8, int i9) {
        return i9 <= Integer.MIN_VALUE ? d.f3962e.a() : new d(i8, i9 - 1);
    }
}
