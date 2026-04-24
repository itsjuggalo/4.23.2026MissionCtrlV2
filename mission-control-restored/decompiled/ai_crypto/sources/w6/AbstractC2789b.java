package w6;

import w6.C2792e;

/* JADX INFO: renamed from: w6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2789b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2792e.a f25074a = new C2792e.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f25075b = -1234567890;

    public static final boolean a(byte[] a7, int i7, byte[] b7, int i8, int i9) {
        kotlin.jvm.internal.r.f(a7, "a");
        kotlin.jvm.internal.r.f(b7, "b");
        for (int i10 = 0; i10 < i9; i10++) {
            if (a7[i10 + i7] != b7[i10 + i8]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j7, long j8, long j9) {
        if ((j8 | j9) < 0 || j8 > j7 || j7 - j8 < j9) {
            throw new ArrayIndexOutOfBoundsException("size=" + j7 + " offset=" + j8 + " byteCount=" + j9);
        }
    }

    public static final int c() {
        return f25075b;
    }

    public static final int d(C2795h c2795h, int i7) {
        kotlin.jvm.internal.r.f(c2795h, "<this>");
        return i7 == f25075b ? c2795h.H() : i7;
    }

    public static final C2792e.a e(C2792e.a unsafeCursor) {
        kotlin.jvm.internal.r.f(unsafeCursor, "unsafeCursor");
        return unsafeCursor == f25074a ? new C2792e.a() : unsafeCursor;
    }

    public static final int f(int i7) {
        return ((i7 & 255) << 24) | (((-16777216) & i7) >>> 24) | ((16711680 & i7) >>> 8) | ((65280 & i7) << 8);
    }

    public static final long g(long j7) {
        return ((j7 & 255) << 56) | (((-72057594037927936L) & j7) >>> 56) | ((71776119061217280L & j7) >>> 40) | ((280375465082880L & j7) >>> 24) | ((1095216660480L & j7) >>> 8) | ((4278190080L & j7) << 8) | ((16711680 & j7) << 24) | ((65280 & j7) << 40);
    }

    public static final short h(short s7) {
        return (short) (((s7 & 255) << 8) | ((65280 & s7) >>> 8));
    }

    public static final String i(byte b7) {
        return Z5.t.m(new char[]{x6.b.f()[(b7 >> 4) & 15], x6.b.f()[b7 & 15]});
    }

    public static final String j(int i7) {
        int i8 = 0;
        if (i7 == 0) {
            return "0";
        }
        char[] cArr = {x6.b.f()[(i7 >> 28) & 15], x6.b.f()[(i7 >> 24) & 15], x6.b.f()[(i7 >> 20) & 15], x6.b.f()[(i7 >> 16) & 15], x6.b.f()[(i7 >> 12) & 15], x6.b.f()[(i7 >> 8) & 15], x6.b.f()[(i7 >> 4) & 15], x6.b.f()[i7 & 15]};
        while (i8 < 8 && cArr[i8] == '0') {
            i8++;
        }
        return Z5.t.n(cArr, i8, 8);
    }
}
