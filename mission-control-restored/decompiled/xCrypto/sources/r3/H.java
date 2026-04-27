package r3;

import W2.C0739g;
import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: loaded from: classes3.dex */
public abstract class H {
    public static final byte a(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        W2.u uVarB = b(str);
        if (uVarB != null) {
            return uVarB.k();
        }
        w.l(str);
        throw new C0739g();
    }

    public static final W2.u b(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return c(str, 10);
    }

    public static final W2.u c(String str, int i4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        W2.w wVarF = f(str, i4);
        if (wVarF == null) {
            return null;
        }
        int iK = wVarF.k();
        if (Integer.compare(iK ^ Integer.MIN_VALUE, W2.w.c(255) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return W2.u.a(W2.u.c((byte) iK));
    }

    public static final int d(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        W2.w wVarE = e(str);
        if (wVarE != null) {
            return wVarE.k();
        }
        w.l(str);
        throw new C0739g();
    }

    public static final W2.w e(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return f(str, 10);
    }

    public static final W2.w f(String str, int i4) {
        int i5;
        kotlin.jvm.internal.r.f(str, "<this>");
        AbstractC1754a.a(i4);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i6 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.r.g(cCharAt, 48) < 0) {
            i5 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i5 = 0;
        }
        int iC = W2.w.c(i4);
        int iA = 119304647;
        while (i5 < length) {
            int iB = AbstractC1754a.b(str.charAt(i5), i4);
            if (iB < 0) {
                return null;
            }
            if (Integer.compare(i6 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                if (iA == 119304647) {
                    iA = G.a(-1, iC);
                    if (Integer.compare(i6 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int iC2 = W2.w.c(i6 * iC);
            int iC3 = W2.w.c(W2.w.c(iB) + iC2);
            if (Integer.compare(iC3 ^ Integer.MIN_VALUE, iC2 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i5++;
            i6 = iC3;
        }
        return W2.w.a(i6);
    }

    public static final long g(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        W2.y yVarH = h(str);
        if (yVarH != null) {
            return yVarH.k();
        }
        w.l(str);
        throw new C0739g();
    }

    public static final W2.y h(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return i(str, 10);
    }

    public static final W2.y i(String str, int i4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        AbstractC1754a.a(i4);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i5 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.r.g(cCharAt, 48) < 0) {
            i5 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jC = W2.y.c(i4);
        long j4 = 0;
        long jA = 512409557603043100L;
        while (i5 < length) {
            int iB = AbstractC1754a.b(str.charAt(i5), i4);
            if (iB < 0) {
                return null;
            }
            if (Long.compare(j4 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                if (jA == 512409557603043100L) {
                    jA = E.a(-1L, jC);
                    if (Long.compare(j4 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long jC2 = W2.y.c(j4 * jC);
            long jC3 = W2.y.c(W2.y.c(((long) W2.w.c(iB)) & KeyboardMap.kValueMask) + jC2);
            if (Long.compare(jC3 ^ Long.MIN_VALUE, jC2 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i5++;
            j4 = jC3;
        }
        return W2.y.a(j4);
    }

    public static final short j(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        W2.B bK = k(str);
        if (bK != null) {
            return bK.k();
        }
        w.l(str);
        throw new C0739g();
    }

    public static final W2.B k(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return l(str, 10);
    }

    public static final W2.B l(String str, int i4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        W2.w wVarF = f(str, i4);
        if (wVarF == null) {
            return null;
        }
        int iK = wVarF.k();
        if (Integer.compare(iK ^ Integer.MIN_VALUE, W2.w.c(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return W2.B.a(W2.B.c((short) iK));
    }
}
