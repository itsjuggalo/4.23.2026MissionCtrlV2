package hh;

import hh.d;
import kg.z;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d.a f11454a = new d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f11455b = -1234567890;

    public static final boolean a(byte[] a10, int i10, byte[] b10, int i11, int i12) {
        kotlin.jvm.internal.t.f(a10, "a");
        kotlin.jvm.internal.t.f(b10, "b");
        for (int i13 = 0; i13 < i12; i13++) {
            if (a10[i13 + i10] != b10[i13 + i11]) {
                return false;
            }
        }
        return true;
    }

    public static final void b(long j10, long j11, long j12) {
        if ((j11 | j12) < 0 || j11 > j10 || j10 - j11 < j12) {
            throw new ArrayIndexOutOfBoundsException("size=" + j10 + " offset=" + j11 + " byteCount=" + j12);
        }
    }

    public static final int c(g gVar, int i10) {
        kotlin.jvm.internal.t.f(gVar, "<this>");
        return i10 == f11455b ? gVar.B() : i10;
    }

    public static final String d(int i10) {
        if (i10 == 0) {
            return "0";
        }
        int i11 = 0;
        char[] cArr = {ih.b.d()[(i10 >> 28) & 15], ih.b.d()[(i10 >> 24) & 15], ih.b.d()[(i10 >> 20) & 15], ih.b.d()[(i10 >> 16) & 15], ih.b.d()[(i10 >> 12) & 15], ih.b.d()[(i10 >> 8) & 15], ih.b.d()[(i10 >> 4) & 15], ih.b.d()[i10 & 15]};
        while (i11 < 8 && cArr[i11] == '0') {
            i11++;
        }
        return z.t(cArr, i11, 8);
    }
}
