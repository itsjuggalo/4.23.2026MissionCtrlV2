package W5;

import W5.e;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l extends k {
    public static int b(int i7, int i8) {
        return i7 < i8 ? i8 : i7;
    }

    public static long c(long j7, long j8) {
        return j7 < j8 ? j8 : j7;
    }

    public static int d(int i7, int i8) {
        return i7 > i8 ? i8 : i7;
    }

    public static long e(long j7, long j8) {
        return j7 > j8 ? j8 : j7;
    }

    public static int f(int i7, int i8, int i9) {
        if (i8 <= i9) {
            return i7 < i8 ? i8 : i7 > i9 ? i9 : i7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i9 + " is less than minimum " + i8 + com.amazon.a.a.o.c.a.b.f10001a);
    }

    public static long g(long j7, long j8, long j9) {
        if (j8 <= j9) {
            return j7 < j8 ? j8 : j7 > j9 ? j9 : j7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j9 + " is less than minimum " + j8 + com.amazon.a.a.o.c.a.b.f10001a);
    }

    public static long h(long j7, d range) {
        r.f(range, "range");
        if (!range.isEmpty()) {
            return j7 < ((Number) range.a()).longValue() ? ((Number) range.a()).longValue() : j7 > ((Number) range.c()).longValue() ? ((Number) range.c()).longValue() : j7;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + com.amazon.a.a.o.c.a.b.f10001a);
    }

    public static e i(int i7, int i8) {
        return e.f5449d.a(i7, i8, -1);
    }

    public static long j(j jVar, U5.c random) {
        r.f(jVar, "<this>");
        r.f(random, "random");
        try {
            return U5.d.d(random, jVar);
        } catch (IllegalArgumentException e7) {
            throw new NoSuchElementException(e7.getMessage());
        }
    }

    public static e k(e eVar, int i7) {
        r.f(eVar, "<this>");
        k.a(i7 > 0, Integer.valueOf(i7));
        e.a aVar = e.f5449d;
        int iG = eVar.g();
        int iH = eVar.h();
        if (eVar.j() <= 0) {
            i7 = -i7;
        }
        return aVar.a(iG, iH, i7);
    }

    public static g l(int i7, int i8) {
        return i8 <= Integer.MIN_VALUE ? g.f5457e.a() : new g(i7, i8 - 1);
    }
}
