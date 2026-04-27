package Z5;

import E5.C0462g;

/* JADX INFO: loaded from: classes2.dex */
public abstract class B {
    public static final byte a(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        E5.u uVarB = b(str);
        if (uVarB != null) {
            return uVarB.j();
        }
        s.h(str);
        throw new C0462g();
    }

    public static final E5.u b(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return c(str, 10);
    }

    public static final E5.u c(String str, int i7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        E5.w wVarF = f(str, i7);
        if (wVarF == null) {
            return null;
        }
        int iJ = wVarF.j();
        if (Integer.compare(iJ ^ Integer.MIN_VALUE, E5.w.b(255) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return E5.u.a(E5.u.b((byte) iJ));
    }

    public static final int d(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        E5.w wVarE = e(str);
        if (wVarE != null) {
            return wVarE.j();
        }
        s.h(str);
        throw new C0462g();
    }

    public static final E5.w e(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return f(str, 10);
    }

    public static final E5.w f(String str, int i7) {
        int i8;
        kotlin.jvm.internal.r.f(str, "<this>");
        AbstractC0794a.a(i7);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.r.g(cCharAt, 48) < 0) {
            i8 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i8 = 0;
        }
        int iB = E5.w.b(i7);
        int iA = 119304647;
        while (i8 < length) {
            int iB2 = AbstractC0794a.b(str.charAt(i8), i7);
            if (iB2 < 0) {
                return null;
            }
            if (Integer.compare(i9 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                if (iA == 119304647) {
                    iA = A.a(-1, iB);
                    if (Integer.compare(i9 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int iB3 = E5.w.b(i9 * iB);
            int iB4 = E5.w.b(E5.w.b(iB2) + iB3);
            if (Integer.compare(iB4 ^ Integer.MIN_VALUE, iB3 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i8++;
            i9 = iB4;
        }
        return E5.w.a(i9);
    }

    public static final long g(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        E5.y yVarH = h(str);
        if (yVarH != null) {
            return yVarH.j();
        }
        s.h(str);
        throw new C0462g();
    }

    public static final E5.y h(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return i(str, 10);
    }

    public static final E5.y i(String str, int i7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        AbstractC0794a.a(i7);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i8 = 0;
        char cCharAt = str.charAt(0);
        if (kotlin.jvm.internal.r.g(cCharAt, 48) < 0) {
            i8 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jB = E5.y.b(i7);
        long j7 = 0;
        long jA = 512409557603043100L;
        while (i8 < length) {
            int iB = AbstractC0794a.b(str.charAt(i8), i7);
            if (iB < 0) {
                return null;
            }
            if (Long.compare(j7 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                if (jA == 512409557603043100L) {
                    jA = y.a(-1L, jB);
                    if (Long.compare(j7 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long jB2 = E5.y.b(j7 * jB);
            long jB3 = E5.y.b(E5.y.b(((long) E5.w.b(iB)) & 4294967295L) + jB2);
            if (Long.compare(jB3 ^ Long.MIN_VALUE, jB2 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i8++;
            j7 = jB3;
        }
        return E5.y.a(j7);
    }

    public static final short j(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        E5.B bK = k(str);
        if (bK != null) {
            return bK.j();
        }
        s.h(str);
        throw new C0462g();
    }

    public static final E5.B k(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return l(str, 10);
    }

    public static final E5.B l(String str, int i7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        E5.w wVarF = f(str, i7);
        if (wVarF == null) {
            return null;
        }
        int iJ = wVarF.j();
        if (Integer.compare(iJ ^ Integer.MIN_VALUE, E5.w.b(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return E5.B.a(E5.B.b((short) iJ));
    }
}
