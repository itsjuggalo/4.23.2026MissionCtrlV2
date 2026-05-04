package vd;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.t;
import vd.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends k {
    public static int b(int i10, int i11) {
        return i10 < i11 ? i11 : i10;
    }

    public static long c(long j10, long j11) {
        return j10 < j11 ? j11 : j10;
    }

    public static int d(int i10, int i11) {
        return i10 > i11 ? i11 : i10;
    }

    public static long e(long j10, long j11) {
        return j10 > j11 ? j11 : j10;
    }

    public static int f(int i10, int i11, int i12) {
        if (i11 <= i12) {
            return i10 < i11 ? i11 : i10 > i12 ? i12 : i10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i12 + " is less than minimum " + i11 + com.amazon.a.a.o.c.a.b.f4610a);
    }

    public static long g(long j10, long j11, long j12) {
        if (j11 <= j12) {
            return j10 < j11 ? j11 : j10 > j12 ? j12 : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j12 + " is less than minimum " + j11 + com.amazon.a.a.o.c.a.b.f4610a);
    }

    public static long h(long j10, d range) {
        t.f(range, "range");
        if (!range.isEmpty()) {
            return j10 < ((Number) range.a()).longValue() ? ((Number) range.a()).longValue() : j10 > ((Number) range.c()).longValue() ? ((Number) range.c()).longValue() : j10;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: " + range + com.amazon.a.a.o.c.a.b.f4610a);
    }

    public static e i(int i10, int i11) {
        return e.f23386d.a(i10, i11, -1);
    }

    public static long j(j jVar, td.c random) {
        t.f(jVar, "<this>");
        t.f(random, "random");
        try {
            return td.d.d(random, jVar);
        } catch (IllegalArgumentException e10) {
            throw new NoSuchElementException(e10.getMessage());
        }
    }

    public static e k(e eVar, int i10) {
        t.f(eVar, "<this>");
        k.a(i10 > 0, Integer.valueOf(i10));
        e.a aVar = e.f23386d;
        int iE = eVar.e();
        int iF = eVar.f();
        if (eVar.g() <= 0) {
            i10 = -i10;
        }
        return aVar.a(iE, iF, i10);
    }

    public static g l(int i10, int i11) {
        return i11 <= Integer.MIN_VALUE ? g.f23394e.a() : new g(i10, i11 - 1);
    }
}
