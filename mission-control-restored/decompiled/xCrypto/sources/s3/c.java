package s3;

import X2.G;
import java.util.Collection;
import java.util.Iterator;
import k3.AbstractC1575b;
import kotlin.jvm.internal.r;
import o3.AbstractC1681l;
import o3.C1676g;
import r3.AbstractC1753A;
import r3.C;
import r3.x;
import s3.C1779a;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final long i(long j4, int i4) {
        return C1779a.m((j4 << 1) + ((long) i4));
    }

    public static final long j(long j4) {
        return C1779a.m((j4 << 1) + 1);
    }

    public static final long k(long j4) {
        return (-4611686018426L > j4 || j4 >= 4611686018427L) ? j(AbstractC1681l.g(j4, -4611686018427387903L, 4611686018427387903L)) : l(n(j4));
    }

    public static final long l(long j4) {
        return C1779a.m(j4 << 1);
    }

    public static final long m(long j4) {
        return (-4611686018426999999L > j4 || j4 >= 4611686018427000000L) ? j(o(j4)) : l(j4);
    }

    public static final long n(long j4) {
        return j4 * ((long) 1000000);
    }

    public static final long o(long j4) {
        return j4 / ((long) 1000000);
    }

    public static final long p(String str, boolean z4) {
        boolean z5;
        int i4;
        char cCharAt;
        char cCharAt2;
        int i5;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        C1779a.C0237a c0237a = C1779a.f14679b;
        long jB = c0237a.b();
        char cCharAt3 = str.charAt(0);
        int length2 = (cCharAt3 == '+' || cCharAt3 == '-') ? 1 : 0;
        boolean z6 = length2 > 0;
        boolean z7 = z6 && AbstractC1753A.v0(str, '-', false, 2, null);
        if (length <= length2) {
            throw new IllegalArgumentException("No components");
        }
        char c4 = ':';
        char c5 = '0';
        String str2 = "null cannot be cast to non-null type java.lang.String";
        if (str.charAt(length2) == 'P') {
            int i6 = length2 + 1;
            if (i6 == length) {
                throw new IllegalArgumentException();
            }
            boolean z8 = false;
            d dVar = null;
            while (i6 < length) {
                if (str.charAt(i6) != 'T') {
                    int i7 = i6;
                    while (true) {
                        if (i7 >= str.length()) {
                            i5 = length;
                            break;
                        }
                        char cCharAt4 = str.charAt(i7);
                        if (c5 > cCharAt4 || cCharAt4 >= c4) {
                            i5 = length;
                            if (!AbstractC1753A.H("+-.", cCharAt4, false, 2, null)) {
                                break;
                            }
                        } else {
                            i5 = length;
                        }
                        i7++;
                        length = i5;
                        c5 = '0';
                        c4 = ':';
                    }
                    r.d(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = str.substring(i6, i7);
                    r.e(strSubstring, "substring(...)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i6 + strSubstring.length();
                    if (length3 < 0 || length3 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value " + strSubstring);
                    }
                    char cCharAt5 = str.charAt(length3);
                    i6 = length3 + 1;
                    d dVarD = f.d(cCharAt5, z8);
                    if (dVar != null && dVar.compareTo(dVarD) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iR = AbstractC1753A.R(strSubstring, com.amazon.a.a.o.c.a.b.f8816a, 0, false, 6, null);
                    if (dVarD != d.f14689e || iR <= 0) {
                        jB = C1779a.H(jB, t(q(strSubstring), dVarD));
                    } else {
                        r.d(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring2 = strSubstring.substring(0, iR);
                        r.e(strSubstring2, "substring(...)");
                        long jH = C1779a.H(jB, t(q(strSubstring2), dVarD));
                        r.d(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring3 = strSubstring.substring(iR);
                        r.e(strSubstring3, "substring(...)");
                        jB = C1779a.H(jH, r(Double.parseDouble(strSubstring3), dVarD));
                    }
                    dVar = dVarD;
                    length = i5;
                    c5 = '0';
                    c4 = ':';
                } else {
                    if (z8 || (i6 = i6 + 1) == length) {
                        throw new IllegalArgumentException();
                    }
                    z8 = true;
                }
            }
        } else {
            if (z4) {
                throw new IllegalArgumentException();
            }
            int iMax = Math.max(length - length2, 8);
            char c6 = '0';
            if (x.w(str, length2, "Infinity", 0, iMax, true)) {
                jB = c0237a.a();
            } else {
                boolean z9 = !z6;
                if (z6 && str.charAt(length2) == '(' && C.J0(str) == ')') {
                    length2++;
                    int i8 = length - 1;
                    if (length2 == i8) {
                        throw new IllegalArgumentException("No components");
                    }
                    i4 = i8;
                    z5 = true;
                } else {
                    z5 = z9;
                    i4 = length;
                }
                boolean z10 = false;
                d dVar2 = null;
                while (length2 < i4) {
                    if (z10 && z5) {
                        while (length2 < str.length() && str.charAt(length2) == ' ') {
                            length2++;
                        }
                    }
                    int i9 = length2;
                    while (i9 < str.length() && ((c6 <= (cCharAt2 = str.charAt(i9)) && cCharAt2 < ':') || cCharAt2 == '.')) {
                        i9++;
                    }
                    r.d(str, str2);
                    String strSubstring4 = str.substring(length2, i9);
                    r.e(strSubstring4, "substring(...)");
                    if (strSubstring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length4 = length2 + strSubstring4.length();
                    int i10 = length4;
                    while (i10 < str.length() && 'a' <= (cCharAt = str.charAt(i10)) && cCharAt < '{') {
                        i10++;
                    }
                    r.d(str, str2);
                    String strSubstring5 = str.substring(length4, i10);
                    r.e(strSubstring5, "substring(...)");
                    length2 = length4 + strSubstring5.length();
                    d dVarE = f.e(strSubstring5);
                    if (dVar2 != null && dVar2.compareTo(dVarE) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iR2 = AbstractC1753A.R(strSubstring4, com.amazon.a.a.o.c.a.b.f8816a, 0, false, 6, null);
                    if (iR2 > 0) {
                        r.d(strSubstring4, str2);
                        String strSubstring6 = strSubstring4.substring(0, iR2);
                        r.e(strSubstring6, "substring(...)");
                        String str3 = str2;
                        long jH2 = C1779a.H(jB, t(Long.parseLong(strSubstring6), dVarE));
                        r.d(strSubstring4, str3);
                        String strSubstring7 = strSubstring4.substring(iR2);
                        r.e(strSubstring7, "substring(...)");
                        boolean z11 = z5;
                        jB = C1779a.H(jH2, r(Double.parseDouble(strSubstring7), dVarE));
                        if (length2 < i4) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                        z5 = z11;
                        dVar2 = dVarE;
                        str2 = str3;
                    } else {
                        jB = C1779a.H(jB, t(Long.parseLong(strSubstring4), dVarE));
                        z5 = z5;
                        dVar2 = dVarE;
                    }
                    z10 = true;
                    c6 = '0';
                }
            }
        }
        return z7 ? C1779a.M(jB) : jB;
    }

    public static final long q(String str) {
        int length = str.length();
        int i4 = (length <= 0 || !AbstractC1753A.H("+-", str.charAt(0), false, 2, null)) ? 0 : 1;
        if (length - i4 > 16) {
            Iterable c1676g = new C1676g(i4, AbstractC1753A.M(str));
            if (!(c1676g instanceof Collection) || !((Collection) c1676g).isEmpty()) {
                Iterator it = c1676g.iterator();
                while (it.hasNext()) {
                    char cCharAt = str.charAt(((G) it).b());
                    if ('0' > cCharAt || cCharAt >= ':') {
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        return x.C(str, "+", false, 2, null) ? Long.parseLong(C.G0(str, 1)) : Long.parseLong(str);
    }

    public static final long r(double d4, d unit) {
        r.f(unit, "unit");
        double dA = e.a(d4, unit, d.f14686b);
        if (Double.isNaN(dA)) {
            throw new IllegalArgumentException("Duration value cannot be NaN.");
        }
        long jD = AbstractC1575b.d(dA);
        return (-4611686018426999999L > jD || jD >= 4611686018427000000L) ? k(AbstractC1575b.d(e.a(d4, unit, d.f14688d))) : l(jD);
    }

    public static final long s(int i4, d unit) {
        r.f(unit, "unit");
        return unit.compareTo(d.f14689e) <= 0 ? l(e.c(i4, unit, d.f14686b)) : t(i4, unit);
    }

    public static final long t(long j4, d unit) {
        r.f(unit, "unit");
        d dVar = d.f14686b;
        long jC = e.c(4611686018426999999L, dVar, unit);
        return ((-jC) > j4 || j4 > jC) ? j(AbstractC1681l.g(e.b(j4, unit, d.f14688d), -4611686018427387903L, 4611686018427387903L)) : l(e.c(j4, unit, dVar));
    }
}
