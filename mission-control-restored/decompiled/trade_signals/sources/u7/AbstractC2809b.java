package u7;

import kotlin.jvm.internal.AbstractC2304t;
import u7.C2811d;

/* JADX INFO: renamed from: u7.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2809b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2811d.a f23623a = new C2811d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f23624b = -1234567890;

    public static final boolean a(byte[] a8, int i8, byte[] b8, int i9, int i10) {
        AbstractC2304t.f(a8, "a");
        AbstractC2304t.f(b8, "b");
        for (int i11 = 0; i11 < i10; i11++) {
            if (a8[i11 + i8] != b8[i11 + i9]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j8, long j9, long j10) {
        if ((j9 | j10) < 0 || j9 > j8 || j8 - j9 < j10) {
            throw new ArrayIndexOutOfBoundsException("size=" + j8 + " offset=" + j9 + " byteCount=" + j10);
        }
    }

    public static final int c() {
        return f23624b;
    }

    public static final int d(C2814g c2814g, int i8) {
        AbstractC2304t.f(c2814g, "<this>");
        return i8 == f23624b ? c2814g.R() : i8;
    }

    public static final int e(int i8) {
        return ((i8 & 255) << 24) | (((-16777216) & i8) >>> 24) | ((16711680 & i8) >>> 8) | ((65280 & i8) << 8);
    }

    public static final long f(long j8) {
        return ((j8 & 255) << 56) | (((-72057594037927936L) & j8) >>> 56) | ((71776119061217280L & j8) >>> 40) | ((280375465082880L & j8) >>> 24) | ((1095216660480L & j8) >>> 8) | ((4278190080L & j8) << 8) | ((16711680 & j8) << 24) | ((65280 & j8) << 40);
    }

    public static final short g(short s8) {
        return (short) (((s8 & 255) << 8) | ((65280 & s8) >>> 8));
    }

    public static final String h(int i8) {
        int i9 = 0;
        if (i8 == 0) {
            return "0";
        }
        char[] cArr = {v7.b.d()[(i8 >> 28) & 15], v7.b.d()[(i8 >> 24) & 15], v7.b.d()[(i8 >> 20) & 15], v7.b.d()[(i8 >> 16) & 15], v7.b.d()[(i8 >> 12) & 15], v7.b.d()[(i8 >> 8) & 15], v7.b.d()[(i8 >> 4) & 15], v7.b.d()[i8 & 15]};
        while (i9 < 8 && cArr[i9] == '0') {
            i9++;
        }
        return V6.A.s(cArr, i9, 8);
    }
}
