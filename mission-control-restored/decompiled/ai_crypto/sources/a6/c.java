package a6;

import F5.E;
import W5.g;
import W5.l;
import Z5.t;
import Z5.u;
import Z5.w;
import a6.C0929a;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static final long i(long j7, int i7) {
        return C0929a.l((j7 << 1) + ((long) i7));
    }

    public static final long j(long j7) {
        return C0929a.l((j7 << 1) + 1);
    }

    public static final long k(long j7) {
        return (-4611686018426L > j7 || j7 >= 4611686018427L) ? j(l.g(j7, -4611686018427387903L, 4611686018427387903L)) : l(n(j7));
    }

    public static final long l(long j7) {
        return C0929a.l(j7 << 1);
    }

    public static final long m(long j7) {
        return (-4611686018426999999L > j7 || j7 >= 4611686018427000000L) ? j(o(j7)) : l(j7);
    }

    public static final long n(long j7) {
        return j7 * ((long) 1000000);
    }

    public static final long o(long j7) {
        return j7 / ((long) 1000000);
    }

    public static final long p(String str, boolean z7) {
        long jG;
        char cCharAt;
        char cCharAt2;
        int i7;
        char cCharAt3;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        C0929a.C0116a c0116a = C0929a.f6400b;
        long jB = c0116a.b();
        char cCharAt4 = str.charAt(0);
        boolean z8 = true;
        int length2 = (cCharAt4 == '+' || cCharAt4 == '-') ? 1 : 0;
        boolean z9 = length2 > 0;
        boolean z10 = z9 && u.q0(str, '-', false, 2, null);
        if (length <= length2) {
            throw new IllegalArgumentException("No components");
        }
        char c7 = ':';
        char c8 = '0';
        if (str.charAt(length2) == 'P') {
            int i8 = length2 + 1;
            if (i8 == length) {
                throw new IllegalArgumentException();
            }
            d dVar = null;
            boolean z11 = false;
            while (i8 < length) {
                if (str.charAt(i8) != 'T') {
                    int i9 = i8;
                    while (i9 < str.length() && ((c8 <= (cCharAt3 = str.charAt(i9)) && cCharAt3 < c7) || u.C("+-.", cCharAt3, false, 2, null))) {
                        i9++;
                        c7 = ':';
                        c8 = '0';
                    }
                    r.d(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = str.substring(i8, i9);
                    r.e(strSubstring, "substring(...)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i8 + strSubstring.length();
                    if (length3 < 0 || length3 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value " + strSubstring);
                    }
                    char cCharAt5 = str.charAt(length3);
                    int i10 = length3 + 1;
                    d dVarD = f.d(cCharAt5, z11);
                    if (dVar != null && dVar.compareTo(dVarD) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iM = u.M(strSubstring, com.amazon.a.a.o.c.a.b.f10001a, 0, false, 6, null);
                    if (dVarD != d.f6410e || iM <= 0) {
                        i7 = i10;
                        jB = C0929a.G(jB, t(q(strSubstring), dVarD));
                    } else {
                        r.d(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring2 = strSubstring.substring(0, iM);
                        r.e(strSubstring2, "substring(...)");
                        i7 = i10;
                        long jG2 = C0929a.G(jB, t(q(strSubstring2), dVarD));
                        r.d(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring3 = strSubstring.substring(iM);
                        r.e(strSubstring3, "substring(...)");
                        jB = C0929a.G(jG2, r(Double.parseDouble(strSubstring3), dVarD));
                    }
                    i8 = i7;
                    dVar = dVarD;
                    c7 = ':';
                    c8 = '0';
                    z8 = true;
                } else {
                    if (z11 || (i8 = i8 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z11 = z8;
                }
            }
        } else {
            if (z7) {
                throw new IllegalArgumentException();
            }
            String str2 = "Unexpected order of duration components";
            if (t.s(str, length2, "Infinity", 0, Math.max(length - length2, 8), true)) {
                jB = c0116a.a();
            } else {
                boolean z12 = !z9;
                if (z9 && str.charAt(length2) == '(' && w.E0(str) == ')') {
                    length2++;
                    length--;
                    if (length2 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    jG = jB;
                    z12 = true;
                } else {
                    jG = jB;
                }
                d dVar2 = null;
                boolean z13 = false;
                while (length2 < length) {
                    if (z13 && z12) {
                        while (length2 < str.length() && str.charAt(length2) == ' ') {
                            length2++;
                        }
                    }
                    int i11 = length2;
                    while (i11 < str.length() && (('0' <= (cCharAt2 = str.charAt(i11)) && cCharAt2 < ':') || cCharAt2 == '.')) {
                        i11++;
                    }
                    r.d(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring4 = str.substring(length2, i11);
                    r.e(strSubstring4, "substring(...)");
                    if (strSubstring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length4 = length2 + strSubstring4.length();
                    int i12 = length4;
                    while (i12 < str.length() && 'a' <= (cCharAt = str.charAt(i12)) && cCharAt < '{') {
                        i12++;
                    }
                    r.d(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring5 = str.substring(length4, i12);
                    r.e(strSubstring5, "substring(...)");
                    length2 = length4 + strSubstring5.length();
                    d dVarE = f.e(strSubstring5);
                    if (dVar2 != null && dVar2.compareTo(dVarE) <= 0) {
                        throw new IllegalArgumentException(str2);
                    }
                    String str3 = str2;
                    int iM2 = u.M(strSubstring4, com.amazon.a.a.o.c.a.b.f10001a, 0, false, 6, null);
                    if (iM2 > 0) {
                        r.d(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring6 = strSubstring4.substring(0, iM2);
                        r.e(strSubstring6, "substring(...)");
                        long jG3 = C0929a.G(jG, t(Long.parseLong(strSubstring6), dVarE));
                        r.d(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring7 = strSubstring4.substring(iM2);
                        r.e(strSubstring7, "substring(...)");
                        jG = C0929a.G(jG3, r(Double.parseDouble(strSubstring7), dVarE));
                        length2 = length2;
                        if (length2 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        jG = C0929a.G(jG, t(Long.parseLong(strSubstring4), dVarE));
                    }
                    str2 = str3;
                    dVar2 = dVarE;
                    z13 = true;
                }
                jB = jG;
            }
        }
        return z10 ? C0929a.L(jB) : jB;
    }

    public static final long q(String str) {
        int length = str.length();
        int i7 = (length <= 0 || !u.C("+-", str.charAt(0), false, 2, null)) ? 0 : 1;
        if (length - i7 > 16) {
            Iterable gVar = new g(i7, u.H(str));
            if (!(gVar instanceof Collection) || !((Collection) gVar).isEmpty()) {
                Iterator it = gVar.iterator();
                while (it.hasNext()) {
                    char cCharAt = str.charAt(((E) it).c());
                    if ('0' > cCharAt || cCharAt >= ':') {
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        if (t.y(str, "+", false, 2, null)) {
            str = w.B0(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final long r(double d7, d unit) {
        r.f(unit, "unit");
        double dA = e.a(d7, unit, d.f6407b);
        if (Double.isNaN(dA)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.");
        }
        long jD = S5.b.d(dA);
        return (-4611686018426999999L > jD || jD >= 4611686018427000000L) ? k(S5.b.d(e.a(d7, unit, d.f6409d))) : l(jD);
    }

    public static final long s(int i7, d unit) {
        r.f(unit, "unit");
        return unit.compareTo(d.f6410e) <= 0 ? l(e.c(i7, unit, d.f6407b)) : t(i7, unit);
    }

    public static final long t(long j7, d unit) {
        r.f(unit, "unit");
        d dVar = d.f6407b;
        long jC = e.c(4611686018426999999L, dVar, unit);
        return ((-jC) > j7 || j7 > jC) ? j(l.g(e.b(j7, unit, d.f6409d), -4611686018427387903L, 4611686018427387903L)) : l(e.c(j7, unit, dVar));
    }
}
