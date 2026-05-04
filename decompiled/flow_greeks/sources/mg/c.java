package mg;

import kg.e;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends b {
    public static final void e(String str, int i10) {
        t.f(str, "<this>");
        if (str.charAt(i10) == '-') {
            return;
        }
        throw new IllegalArgumentException(("Expected '-' (hyphen) at index " + i10 + ", but was '" + str.charAt(i10) + '\'').toString());
    }

    public static final void f(long j10, byte[] dst, int i10, int i11, int i12) {
        t.f(dst, "dst");
        int i13 = 7 - i11;
        int i14 = 8 - i12;
        if (i14 > i13) {
            return;
        }
        while (true) {
            int i15 = e.d()[(int) ((j10 >> (i13 << 3)) & 255)];
            int i16 = i10 + 1;
            dst[i10] = (byte) (i15 >> 8);
            i10 += 2;
            dst[i16] = (byte) i15;
            if (i13 == i14) {
                return;
            } else {
                i13--;
            }
        }
    }

    public static final String g(String str, int i10) {
        if (str.length() <= i10) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder();
        t.d(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(0, i10);
        t.e(strSubstring, "substring(...)");
        sb2.append(strSubstring);
        sb2.append("...");
        return sb2.toString();
    }

    public static final a h(String hexString) {
        t.f(hexString, "hexString");
        return a.f16432c.a(e.f(hexString, 0, 16, null, 4, null), e.f(hexString, 16, 32, null, 4, null));
    }

    public static final a i(String hexDashString) {
        t.f(hexDashString, "hexDashString");
        long jF = e.f(hexDashString, 0, 8, null, 4, null);
        e(hexDashString, 8);
        long jF2 = e.f(hexDashString, 9, 13, null, 4, null);
        e(hexDashString, 13);
        long jF3 = e.f(hexDashString, 14, 18, null, 4, null);
        e(hexDashString, 18);
        long jF4 = e.f(hexDashString, 19, 23, null, 4, null);
        e(hexDashString, 23);
        return a.f16432c.a((jF2 << 16) | (jF << 32) | jF3, (jF4 << 48) | e.f(hexDashString, 24, 36, null, 4, null));
    }
}
