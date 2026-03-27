package O3;

import O3.d;
import r3.x;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d.a f3306a = new d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3307b = -1234567890;

    public static final boolean a(byte[] a4, int i4, byte[] b4, int i5, int i6) {
        kotlin.jvm.internal.r.f(a4, "a");
        kotlin.jvm.internal.r.f(b4, "b");
        for (int i7 = 0; i7 < i6; i7++) {
            if (a4[i7 + i4] != b4[i7 + i5]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j4, long j5, long j6) {
        if ((j5 | j6) < 0 || j5 > j4 || j4 - j5 < j6) {
            throw new ArrayIndexOutOfBoundsException("size=" + j4 + " offset=" + j5 + " byteCount=" + j6);
        }
    }

    public static final int c(g gVar, int i4) {
        kotlin.jvm.internal.r.f(gVar, "<this>");
        return i4 == f3307b ? gVar.v() : i4;
    }

    public static final String d(int i4) {
        int i5 = 0;
        if (i4 == 0) {
            return "0";
        }
        char[] cArr = {P3.b.d()[(i4 >> 28) & 15], P3.b.d()[(i4 >> 24) & 15], P3.b.d()[(i4 >> 20) & 15], P3.b.d()[(i4 >> 16) & 15], P3.b.d()[(i4 >> 12) & 15], P3.b.d()[(i4 >> 8) & 15], P3.b.d()[(i4 >> 4) & 15], P3.b.d()[i4 & 15]};
        while (i5 < 8 && cArr[i5] == '0') {
            i5++;
        }
        return x.r(cArr, i5, 8);
    }
}
