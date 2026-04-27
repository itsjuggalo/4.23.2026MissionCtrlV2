package V6;

import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2464B;
import o5.C2467E;
import o5.C2480h;

/* JADX INFO: loaded from: classes2.dex */
public abstract class J {
    public static final byte a(String str) {
        AbstractC2304t.f(str, "<this>");
        o5.x xVarB = b(str);
        if (xVarB != null) {
            return xVarB.l();
        }
        z.m(str);
        throw new C2480h();
    }

    public static final o5.x b(String str) {
        AbstractC2304t.f(str, "<this>");
        return c(str, 10);
    }

    public static final o5.x c(String str, int i8) {
        AbstractC2304t.f(str, "<this>");
        o5.z zVarF = f(str, i8);
        if (zVarF == null) {
            return null;
        }
        int iL = zVarF.l();
        if (Integer.compare(iL ^ Integer.MIN_VALUE, o5.z.b(255) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return o5.x.a(o5.x.b((byte) iL));
    }

    public static final int d(String str) {
        AbstractC2304t.f(str, "<this>");
        o5.z zVarE = e(str);
        if (zVarE != null) {
            return zVarE.l();
        }
        z.m(str);
        throw new C2480h();
    }

    public static final o5.z e(String str) {
        AbstractC2304t.f(str, "<this>");
        return f(str, 10);
    }

    public static final o5.z f(String str, int i8) {
        int i9;
        AbstractC2304t.f(str, "<this>");
        AbstractC0975a.a(i8);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i10 = 0;
        char cCharAt = str.charAt(0);
        if (AbstractC2304t.g(cCharAt, 48) < 0) {
            i9 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        } else {
            i9 = 0;
        }
        int iB = o5.z.b(i8);
        int iA = 119304647;
        while (i9 < length) {
            int iB2 = AbstractC0975a.b(str.charAt(i9), i8);
            if (iB2 < 0) {
                return null;
            }
            if (Integer.compare(i10 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                if (iA == 119304647) {
                    iA = I.a(-1, iB);
                    if (Integer.compare(i10 ^ Integer.MIN_VALUE, iA ^ Integer.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            int iB3 = o5.z.b(i10 * iB);
            int iB4 = o5.z.b(o5.z.b(iB2) + iB3);
            if (Integer.compare(iB4 ^ Integer.MIN_VALUE, iB3 ^ Integer.MIN_VALUE) < 0) {
                return null;
            }
            i9++;
            i10 = iB4;
        }
        return o5.z.a(i10);
    }

    public static final long g(String str) {
        AbstractC2304t.f(str, "<this>");
        C2464B c2464bH = h(str);
        if (c2464bH != null) {
            return c2464bH.l();
        }
        z.m(str);
        throw new C2480h();
    }

    public static final C2464B h(String str) {
        AbstractC2304t.f(str, "<this>");
        return i(str, 10);
    }

    public static final C2464B i(String str, int i8) {
        AbstractC2304t.f(str, "<this>");
        AbstractC0975a.a(i8);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i9 = 0;
        char cCharAt = str.charAt(0);
        if (AbstractC2304t.g(cCharAt, 48) < 0) {
            i9 = 1;
            if (length == 1 || cCharAt != '+') {
                return null;
            }
        }
        long jB = C2464B.b(i8);
        long j8 = 0;
        long jA = 512409557603043100L;
        while (i9 < length) {
            int iB = AbstractC0975a.b(str.charAt(i9), i8);
            if (iB < 0) {
                return null;
            }
            if (Long.compare(j8 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                if (jA == 512409557603043100L) {
                    jA = G.a(-1L, jB);
                    if (Long.compare(j8 ^ Long.MIN_VALUE, jA ^ Long.MIN_VALUE) > 0) {
                    }
                }
                return null;
            }
            long jB2 = C2464B.b(j8 * jB);
            long jB3 = C2464B.b(C2464B.b(((long) o5.z.b(iB)) & KeyboardMap.kValueMask) + jB2);
            if (Long.compare(jB3 ^ Long.MIN_VALUE, jB2 ^ Long.MIN_VALUE) < 0) {
                return null;
            }
            i9++;
            j8 = jB3;
        }
        return C2464B.a(j8);
    }

    public static final short j(String str) {
        AbstractC2304t.f(str, "<this>");
        C2467E c2467eK = k(str);
        if (c2467eK != null) {
            return c2467eK.l();
        }
        z.m(str);
        throw new C2480h();
    }

    public static final C2467E k(String str) {
        AbstractC2304t.f(str, "<this>");
        return l(str, 10);
    }

    public static final C2467E l(String str, int i8) {
        AbstractC2304t.f(str, "<this>");
        o5.z zVarF = f(str, i8);
        if (zVarF == null) {
            return null;
        }
        int iL = zVarF.l();
        if (Integer.compare(iL ^ Integer.MIN_VALUE, o5.z.b(65535) ^ Integer.MIN_VALUE) > 0) {
            return null;
        }
        return C2467E.a(C2467E.b((short) iL));
    }
}
