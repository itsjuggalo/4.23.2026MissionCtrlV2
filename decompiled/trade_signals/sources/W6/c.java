package W6;

import H5.i;
import V6.A;
import V6.C;
import V6.E;
import W6.a;
import java.util.Collection;
import java.util.Iterator;
import kotlin.jvm.internal.AbstractC2304t;
import p5.I;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {
    public static final long i(long j8, int i8) {
        return a.n((j8 << 1) + ((long) i8));
    }

    public static final long j(long j8) {
        return a.n((j8 << 1) + 1);
    }

    public static final long k(long j8) {
        return (-4611686018426L > j8 || j8 >= 4611686018427L) ? j(i.g(j8, -4611686018427387903L, 4611686018427387903L)) : l(n(j8));
    }

    public static final long l(long j8) {
        return a.n(j8 << 1);
    }

    public static final long m(long j8) {
        return (-4611686018426999999L > j8 || j8 >= 4611686018427000000L) ? j(o(j8)) : l(j8);
    }

    public static final long n(long j8) {
        return j8 * ((long) 1000000);
    }

    public static final long o(long j8) {
        return j8 / ((long) 1000000);
    }

    public static final long p(String str, boolean z7) {
        long jW;
        char cCharAt;
        char cCharAt2;
        int i8;
        long jT;
        char cCharAt3;
        int length = str.length();
        if (length == 0) {
            throw new IllegalArgumentException("The string is empty");
        }
        a.C0149a c0149a = a.f9306b;
        long jB = c0149a.b();
        char cCharAt4 = str.charAt(0);
        boolean z8 = true;
        int length2 = (cCharAt4 == '+' || cCharAt4 == '-') ? 1 : 0;
        boolean z9 = length2 > 0;
        boolean z10 = z9 && C.w0(str, '-', false, 2, null);
        if (length <= length2) {
            throw new IllegalArgumentException("No components");
        }
        char c8 = ':';
        char c9 = '0';
        if (str.charAt(length2) == 'P') {
            int i9 = length2 + 1;
            if (i9 == length) {
                throw new IllegalArgumentException();
            }
            d dVar = null;
            boolean z11 = false;
            while (i9 < length) {
                if (str.charAt(i9) != 'T') {
                    int i10 = i9;
                    while (i10 < str.length() && ((c9 <= (cCharAt3 = str.charAt(i10)) && cCharAt3 < c8) || C.K("+-.", cCharAt3, false, 2, null))) {
                        i10++;
                        c8 = ':';
                        c9 = '0';
                    }
                    AbstractC2304t.d(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring = str.substring(i9, i10);
                    AbstractC2304t.e(strSubstring, "substring(...)");
                    if (strSubstring.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length3 = i9 + strSubstring.length();
                    if (length3 < 0 || length3 >= str.length()) {
                        throw new IllegalArgumentException("Missing unit for value " + strSubstring);
                    }
                    char cCharAt5 = str.charAt(length3);
                    int i11 = length3 + 1;
                    d dVarD = f.d(cCharAt5, z11);
                    if (dVar != null && dVar.compareTo(dVarD) <= 0) {
                        throw new IllegalArgumentException("Unexpected order of duration components");
                    }
                    int iX = C.X(strSubstring, com.amazon.a.a.o.c.a.b.f14112a, 0, false, 6, null);
                    if (dVarD != d.f9316e || iX <= 0) {
                        i8 = i11;
                        jT = t(q(strSubstring), dVarD);
                    } else {
                        AbstractC2304t.d(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring2 = strSubstring.substring(0, iX);
                        AbstractC2304t.e(strSubstring2, "substring(...)");
                        i8 = i11;
                        jB = a.W(jB, t(q(strSubstring2), dVarD));
                        AbstractC2304t.d(strSubstring, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring3 = strSubstring.substring(iX);
                        AbstractC2304t.e(strSubstring3, "substring(...)");
                        jT = r(Double.parseDouble(strSubstring3), dVarD);
                    }
                    jB = a.W(jB, jT);
                    i9 = i8;
                    dVar = dVarD;
                    c8 = ':';
                    c9 = '0';
                    z8 = true;
                } else {
                    if (z11 || (i9 = i9 + 1) == length) {
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
            if (A.y(str, length2, "Infinity", 0, Math.max(length - length2, 8), true)) {
                jB = c0149a.a();
            } else {
                boolean z12 = !z9;
                if (z9 && str.charAt(length2) == '(' && E.R0(str) == ')') {
                    length2++;
                    length--;
                    if (length2 == length) {
                        throw new IllegalArgumentException("No components");
                    }
                    jW = jB;
                    z12 = true;
                } else {
                    jW = jB;
                }
                d dVar2 = null;
                boolean z13 = false;
                while (length2 < length) {
                    if (z13 && z12) {
                        while (length2 < str.length() && str.charAt(length2) == ' ') {
                            length2++;
                        }
                    }
                    int i12 = length2;
                    while (i12 < str.length() && (('0' <= (cCharAt2 = str.charAt(i12)) && cCharAt2 < ':') || cCharAt2 == '.')) {
                        i12++;
                    }
                    AbstractC2304t.d(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring4 = str.substring(length2, i12);
                    AbstractC2304t.e(strSubstring4, "substring(...)");
                    if (strSubstring4.length() == 0) {
                        throw new IllegalArgumentException();
                    }
                    int length4 = length2 + strSubstring4.length();
                    int i13 = length4;
                    while (i13 < str.length() && 'a' <= (cCharAt = str.charAt(i13)) && cCharAt < '{') {
                        i13++;
                    }
                    AbstractC2304t.d(str, "null cannot be cast to non-null type java.lang.String");
                    String strSubstring5 = str.substring(length4, i13);
                    AbstractC2304t.e(strSubstring5, "substring(...)");
                    length2 = length4 + strSubstring5.length();
                    d dVarE = f.e(strSubstring5);
                    if (dVar2 != null && dVar2.compareTo(dVarE) <= 0) {
                        throw new IllegalArgumentException(str2);
                    }
                    String str3 = str2;
                    int iX2 = C.X(strSubstring4, com.amazon.a.a.o.c.a.b.f14112a, 0, false, 6, null);
                    if (iX2 > 0) {
                        AbstractC2304t.d(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring6 = strSubstring4.substring(0, iX2);
                        AbstractC2304t.e(strSubstring6, "substring(...)");
                        long jW2 = a.W(jW, t(Long.parseLong(strSubstring6), dVarE));
                        AbstractC2304t.d(strSubstring4, "null cannot be cast to non-null type java.lang.String");
                        String strSubstring7 = strSubstring4.substring(iX2);
                        AbstractC2304t.e(strSubstring7, "substring(...)");
                        jW = a.W(jW2, r(Double.parseDouble(strSubstring7), dVarE));
                        length2 = length2;
                        if (length2 < length) {
                            throw new IllegalArgumentException("Fractional component must be last");
                        }
                    } else {
                        jW = a.W(jW, t(Long.parseLong(strSubstring4), dVarE));
                    }
                    str2 = str3;
                    dVar2 = dVarE;
                    z13 = true;
                }
                jB = jW;
            }
        }
        return z10 ? a.b0(jB) : jB;
    }

    public static final long q(String str) {
        int length = str.length();
        int i8 = (length <= 0 || !C.K("+-", str.charAt(0), false, 2, null)) ? 0 : 1;
        if (length - i8 > 16) {
            Iterable dVar = new H5.d(i8, C.S(str));
            if (!(dVar instanceof Collection) || !((Collection) dVar).isEmpty()) {
                Iterator it = dVar.iterator();
                while (it.hasNext()) {
                    char cCharAt = str.charAt(((I) it).c());
                    if ('0' > cCharAt || cCharAt >= ':') {
                    }
                }
            }
            return str.charAt(0) == '-' ? Long.MIN_VALUE : Long.MAX_VALUE;
        }
        if (A.G(str, "+", false, 2, null)) {
            str = E.O0(str, 1);
        }
        return Long.parseLong(str);
    }

    public static final long r(double d8, d unit) {
        AbstractC2304t.f(unit, "unit");
        double dA = e.a(d8, unit, d.f9313b);
        if (!(!Double.isNaN(dA))) {
            throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
        }
        long jD = D5.b.d(dA);
        return (-4611686018426999999L > jD || jD >= 4611686018427000000L) ? k(D5.b.d(e.a(d8, unit, d.f9315d))) : l(jD);
    }

    public static final long s(int i8, d unit) {
        AbstractC2304t.f(unit, "unit");
        return unit.compareTo(d.f9316e) <= 0 ? l(e.c(i8, unit, d.f9313b)) : t(i8, unit);
    }

    public static final long t(long j8, d unit) {
        AbstractC2304t.f(unit, "unit");
        d dVar = d.f9313b;
        long jC = e.c(4611686018426999999L, dVar, unit);
        return ((-jC) > j8 || j8 > jC) ? j(i.g(e.b(j8, unit, d.f9315d), -4611686018427387903L, 4611686018427387903L)) : l(e.c(j8, unit, dVar));
    }
}
