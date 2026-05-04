package kg;

import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class j0 {
    public static final byte a(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        cd.x xVarB = b(str);
        if (xVarB != null) {
            return xVarB.k();
        }
        y.n(str);
        throw new cd.h();
    }

    public static final cd.x b(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        return c(str, 10);
    }

    public static final cd.x c(String str, int i10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        cd.z zVarF = f(str, i10);
        if (zVarF == null) {
            return null;
        }
        int iK = zVarF.k();
        if (Integer.compare(iK ^ Integer.MIN_VALUE, cd.z.b(255) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return cd.x.a(cd.x.b((byte) iK));
    }

    public static final int d(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        cd.z zVarE = e(str);
        if (zVarE != null) {
            return zVarE.k();
        }
        y.n(str);
        throw new cd.h();
    }

    public static final cd.z e(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        return f(str, 10);
    }

    public static final cd.z f(String str, int i10) {
        int i11;
        kotlin.jvm.internal.t.f(str, "<this>");
        a.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i12 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.t.g(cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i11 = 0;
        }
        int iB = cd.z.b(i10);
        int iA = 119304647;
        while (i11 < length) {
            int iB2 = a.b(str.charAt(i11), i10);
            if (iB2 < 0) {
                return null;
            }
            if (Integer.compare(i12 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                if (iA == 119304647) {
                    iA = i0.a(-1, iB);
                    if (Integer.compare(i12 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int iB3 = cd.z.b(i12 * iB);
            int iB4 = cd.z.b(cd.z.b(iB2) + iB3);
            if (Integer.compare(iB4 ^ Integer.MIN_VALUE, iB3 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i11++;
            i12 = iB4;
        }
        return cd.z.a(i12);
    }

    public static final long g(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        cd.b0 b0VarH = h(str);
        if (b0VarH != null) {
            return b0VarH.k();
        }
        y.n(str);
        throw new cd.h();
    }

    public static final cd.b0 h(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        return i(str, 10);
    }

    public static final cd.b0 i(String str, int i10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        a.a(i10);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i11 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.t.g(cCharAt, 48) < 0) {
            i11 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jB = cd.b0.b(i10);
        long j10 = 0;
        long jA = 512409557603043100L;
        while (i11 < length) {
            int iB = a.b(str.charAt(i11), i10);
            if (iB < 0) {
                return null;
            }
            if (Long.compare(j10 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                if (jA == 512409557603043100L) {
                    jA = g0.a(-1L, jB);
                    if (Long.compare(j10 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long jB2 = cd.b0.b(j10 * jB);
            long jB3 = cd.b0.b(cd.b0.b(((long) cd.z.b(iB)) & KeyboardMap.kValueMask) + jB2);
            if (Long.compare(jB3 ^ Long.MIN_VALUE, jB2 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i11++;
            j10 = jB3;
        }
        return cd.b0.a(j10);
    }

    public static final short j(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        cd.e0 e0VarK = k(str);
        if (e0VarK != null) {
            return e0VarK.k();
        }
        y.n(str);
        throw new cd.h();
    }

    public static final cd.e0 k(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        return l(str, 10);
    }

    public static final cd.e0 l(String str, int i10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        cd.z zVarF = f(str, i10);
        if (zVarF == null) {
            return null;
        }
        int iK = zVarF.k();
        if (Integer.compare(iK ^ Integer.MIN_VALUE, cd.z.b(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return cd.e0.a(cd.e0.b((short) iK));
    }
}
