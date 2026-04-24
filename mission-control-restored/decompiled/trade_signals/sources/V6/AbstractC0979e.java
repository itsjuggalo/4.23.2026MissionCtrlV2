package V6;

import V6.C0980f;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2480h;
import p5.AbstractC2582d;

/* JADX INFO: renamed from: V6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC0979e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f8972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f8973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f8974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final long[] f8975d;

    static {
        int[] iArr = new int[256];
        int i8 = 0;
        for (int i9 = 0; i9 < 256; i9++) {
            iArr[i9] = "0123456789abcdef".charAt(i9 & 15) | ("0123456789abcdef".charAt(i9 >> 4) << '\b');
        }
        f8972a = iArr;
        int[] iArr2 = new int[256];
        for (int i10 = 0; i10 < 256; i10++) {
            iArr2[i10] = "0123456789ABCDEF".charAt(i10 & 15) | ("0123456789ABCDEF".charAt(i10 >> 4) << '\b');
        }
        f8973b = iArr2;
        int[] iArr3 = new int[256];
        for (int i11 = 0; i11 < 256; i11++) {
            iArr3[i11] = -1;
        }
        int i12 = 0;
        int i13 = 0;
        while (i12 < "0123456789abcdef".length()) {
            iArr3["0123456789abcdef".charAt(i12)] = i13;
            i12++;
            i13++;
        }
        int i14 = 0;
        int i15 = 0;
        while (i14 < "0123456789ABCDEF".length()) {
            iArr3["0123456789ABCDEF".charAt(i14)] = i15;
            i14++;
            i15++;
        }
        f8974c = iArr3;
        long[] jArr = new long[256];
        for (int i16 = 0; i16 < 256; i16++) {
            jArr[i16] = -1;
        }
        int i17 = 0;
        int i18 = 0;
        while (i17 < "0123456789abcdef".length()) {
            jArr["0123456789abcdef".charAt(i17)] = i18;
            i17++;
            i18++;
        }
        int i19 = 0;
        while (i8 < "0123456789ABCDEF".length()) {
            jArr["0123456789ABCDEF".charAt(i8)] = i19;
            i8++;
            i19++;
        }
        f8975d = jArr;
    }

    public static final void a(String str, int i8, int i9, int i10) {
        int i11 = i9 - i8;
        if (i11 < 1) {
            j(str, i8, i9, "at least", 1);
        } else if (i11 > i10) {
            c(str, i8, (i11 + i8) - i10);
        }
    }

    public static final void b(String str, int i8, int i9, String str2, String str3, boolean z7, int i10) {
        if ((i9 - i8) - str2.length() <= str3.length()) {
            k(str, i8, i9, str2, str3);
        }
        if (str2.length() != 0) {
            int length = str2.length();
            for (int i11 = 0; i11 < length; i11++) {
                if (!AbstractC0976b.d(str2.charAt(i11), str.charAt(i8 + i11), z7)) {
                    l(str, i8, i9, str2, "prefix");
                }
            }
            i8 += str2.length();
        }
        int length2 = i9 - str3.length();
        if (str3.length() != 0) {
            int length3 = str3.length();
            for (int i12 = 0; i12 < length3; i12++) {
                if (!AbstractC0976b.d(str3.charAt(i12), str.charAt(length2 + i12), z7)) {
                    l(str, length2, i9, str3, "suffix");
                }
            }
        }
        a(str, i8, length2, i10);
    }

    public static final void c(String str, int i8, int i9) {
        while (i8 < i9) {
            if (str.charAt(i8) != '0') {
                throw new NumberFormatException("Expected the hexadecimal digit '0' at index " + i8 + ", but was '" + str.charAt(i8) + "'.\nThe result won't fit the type being parsed.");
            }
            i8++;
        }
    }

    public static final int[] d() {
        return f8972a;
    }

    public static final long e(String str, int i8, int i9, C0980f format) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(format, "format");
        return g(str, i8, i9, format, 16);
    }

    public static /* synthetic */ long f(String str, int i8, int i9, C0980f c0980f, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i8 = 0;
        }
        if ((i10 & 2) != 0) {
            i9 = str.length();
        }
        if ((i10 & 4) != 0) {
            c0980f = C0980f.f8976d.a();
        }
        return e(str, i8, i9, c0980f);
    }

    public static final long g(String str, int i8, int i9, C0980f c0980f, int i10) {
        AbstractC2582d.f22376a.a(i8, i9, str.length());
        C0980f.c cVarB = c0980f.b();
        if (cVarB.f()) {
            a(str, i8, i9, i10);
        } else {
            String strD = cVarB.d();
            String strE = cVarB.e();
            b(str, i8, i9, strD, strE, cVarB.c(), i10);
            i8 += strD.length();
            i9 -= strE.length();
        }
        return h(str, i8, i9);
    }

    public static final long h(String str, int i8, int i9) {
        long j8 = 0;
        while (i8 < i9) {
            long j9 = j8 << 4;
            char cCharAt = str.charAt(i8);
            if ((cCharAt >>> '\b') == 0) {
                long j10 = f8975d[cCharAt];
                if (j10 >= 0) {
                    j8 = j9 | j10;
                    i8++;
                }
            }
            i(str, i8);
            throw new C2480h();
        }
        return j8;
    }

    public static final Void i(String str, int i8) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i8 + ", but was " + str.charAt(i8));
    }

    public static final void j(String str, int i8, int i9, String str2, int i10) {
        AbstractC2304t.d(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i8, i9);
        AbstractC2304t.e(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i10 + " hexadecimal digits at index " + i8 + ", but was \"" + strSubstring + "\" of length " + (i9 - i8));
    }

    public static final void k(String str, int i8, int i9, String str2, String str3) {
        AbstractC2304t.d(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i8, i9);
        AbstractC2304t.e(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + str2 + "\" and suffix \"" + str3 + "\", but was " + strSubstring);
    }

    public static final void l(String str, int i8, int i9, String str2, String str3) {
        int iD = H5.i.d(str2.length() + i8, i9);
        AbstractC2304t.d(str, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = str.substring(i8, iD);
        AbstractC2304t.e(strSubstring, "substring(...)");
        throw new NumberFormatException("Expected " + str3 + " \"" + str2 + "\" at index " + i8 + ", but was " + strSubstring);
    }
}
