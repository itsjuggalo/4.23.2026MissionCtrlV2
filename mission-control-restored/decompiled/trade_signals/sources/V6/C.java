package V6;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import o5.C2489q;
import p5.AbstractC2590l;
import p5.AbstractC2592n;
import p5.AbstractC2594p;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C extends A {

    public static final class a implements U6.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f8954a;

        public a(CharSequence charSequence) {
            this.f8954a = charSequence;
        }

        @Override // U6.h
        public Iterator iterator() {
            return new C0982h(this.f8954a);
        }
    }

    public static final String A0(String str, String delimiter, String missingDelimiterValue) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(delimiter, "delimiter");
        AbstractC2304t.f(missingDelimiterValue, "missingDelimiterValue");
        int iY = Y(str, delimiter, 0, false, 6, null);
        if (iY == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iY + delimiter.length(), str.length());
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String B0(String str, char c8, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = str;
        }
        return z0(str, c8, str2);
    }

    public static /* synthetic */ String C0(String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str3 = str;
        }
        return A0(str, str2, str3);
    }

    public static String D0(String str, char c8, String missingDelimiterValue) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(missingDelimiterValue, "missingDelimiterValue");
        int iD0 = d0(str, c8, 0, false, 6, null);
        if (iD0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iD0 + 1, str.length());
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final String E0(String str, String delimiter, String missingDelimiterValue) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(delimiter, "delimiter");
        AbstractC2304t.f(missingDelimiterValue, "missingDelimiterValue");
        int iE0 = e0(str, delimiter, 0, false, 6, null);
        if (iE0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iE0 + delimiter.length(), str.length());
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String F0(String str, char c8, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = str;
        }
        return D0(str, c8, str2);
    }

    public static /* synthetic */ String G0(String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str3 = str;
        }
        return E0(str, str2, str3);
    }

    public static final String H0(String str, char c8, String missingDelimiterValue) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(missingDelimiterValue, "missingDelimiterValue");
        int iX = X(str, c8, 0, false, 6, null);
        if (iX == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iX);
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean I(CharSequence charSequence, char c8, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        return X(charSequence, c8, 0, z7, 2, null) >= 0;
    }

    public static final String I0(String str, String delimiter, String missingDelimiterValue) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(delimiter, "delimiter");
        AbstractC2304t.f(missingDelimiterValue, "missingDelimiterValue");
        int iY = Y(str, delimiter, 0, false, 6, null);
        if (iY == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iY);
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean J(CharSequence charSequence, CharSequence other, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(other, "other");
        if (other instanceof String) {
            if (Y(charSequence, (String) other, 0, z7, 2, null) < 0) {
                return false;
            }
        } else if (W(charSequence, other, 0, charSequence.length(), z7, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ String J0(String str, char c8, String str2, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str2 = str;
        }
        return H0(str, c8, str2);
    }

    public static /* synthetic */ boolean K(CharSequence charSequence, char c8, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return I(charSequence, c8, z7);
    }

    public static /* synthetic */ String K0(String str, String str2, String str3, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            str3 = str;
        }
        return I0(str, str2, str3);
    }

    public static /* synthetic */ boolean L(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return J(charSequence, charSequence2, z7);
    }

    public static String L0(String str, String delimiter, String missingDelimiterValue) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(delimiter, "delimiter");
        AbstractC2304t.f(missingDelimiterValue, "missingDelimiterValue");
        int iE0 = e0(str, delimiter, 0, false, 6, null);
        if (iE0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iE0);
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean M(CharSequence charSequence, char c8, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC0976b.d(charSequence.charAt(S(charSequence)), c8, z7);
    }

    public static Boolean M0(String str) {
        AbstractC2304t.f(str, "<this>");
        if (AbstractC2304t.b(str, com.amazon.a.a.o.b.af)) {
            return Boolean.TRUE;
        }
        if (AbstractC2304t.b(str, com.amazon.a.a.o.b.ag)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final boolean N(CharSequence charSequence, CharSequence suffix, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(suffix, "suffix");
        return (!z7 && (charSequence instanceof String) && (suffix instanceof String)) ? A.w((String) charSequence, (String) suffix, false, 2, null) : n0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z7);
    }

    public static CharSequence N0(CharSequence charSequence) {
        AbstractC2304t.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i8 = 0;
        boolean z7 = false;
        while (i8 <= length) {
            boolean zC = AbstractC0975a.c(charSequence.charAt(!z7 ? i8 : length));
            if (z7) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i8++;
            } else {
                z7 = true;
            }
        }
        return charSequence.subSequence(i8, length + 1);
    }

    public static /* synthetic */ boolean O(CharSequence charSequence, char c8, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return M(charSequence, c8, z7);
    }

    public static /* synthetic */ boolean P(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return N(charSequence, charSequence2, z7);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0091, code lost:
    
        return o5.w.a(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final o5.C2489q Q(java.lang.CharSequence r10, java.util.Collection r11, int r12, boolean r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 213
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: V6.C.Q(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):o5.q");
    }

    public static H5.d R(CharSequence charSequence) {
        AbstractC2304t.f(charSequence, "<this>");
        return new H5.d(0, charSequence.length() - 1);
    }

    public static int S(CharSequence charSequence) {
        AbstractC2304t.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int T(CharSequence charSequence, char c8, int i8, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        return (z7 || !(charSequence instanceof String)) ? Z(charSequence, new char[]{c8}, i8, z7) : ((String) charSequence).indexOf(c8, i8);
    }

    public static final int U(CharSequence charSequence, String string, int i8, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(string, "string");
        return (z7 || !(charSequence instanceof String)) ? W(charSequence, string, i8, charSequence.length(), z7, false, 16, null) : ((String) charSequence).indexOf(string, i8);
    }

    public static final int V(CharSequence charSequence, CharSequence charSequence2, int i8, int i9, boolean z7, boolean z8) {
        H5.b dVar = !z8 ? new H5.d(H5.i.b(i8, 0), H5.i.d(i9, charSequence.length())) : H5.i.i(H5.i.d(i8, S(charSequence)), H5.i.b(i9, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int iE = dVar.e();
            int iF = dVar.f();
            int iH = dVar.h();
            if ((iH <= 0 || iE > iF) && (iH >= 0 || iF > iE)) {
                return -1;
            }
            while (!n0(charSequence2, 0, charSequence, iE, charSequence2.length(), z7)) {
                if (iE == iF) {
                    return -1;
                }
                iE += iH;
            }
            return iE;
        }
        int iE2 = dVar.e();
        int iF2 = dVar.f();
        int iH2 = dVar.h();
        if ((iH2 <= 0 || iE2 > iF2) && (iH2 >= 0 || iF2 > iE2)) {
            return -1;
        }
        while (true) {
            String str = (String) charSequence2;
            if (A.y(str, 0, (String) charSequence, iE2, str.length(), z7)) {
                return iE2;
            }
            if (iE2 == iF2) {
                return -1;
            }
            iE2 += iH2;
        }
    }

    public static /* synthetic */ int W(CharSequence charSequence, CharSequence charSequence2, int i8, int i9, boolean z7, boolean z8, int i10, Object obj) {
        if ((i10 & 16) != 0) {
            z8 = false;
        }
        return V(charSequence, charSequence2, i8, i9, z7, z8);
    }

    public static /* synthetic */ int X(CharSequence charSequence, char c8, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return T(charSequence, c8, i8, z7);
    }

    public static /* synthetic */ int Y(CharSequence charSequence, String str, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return U(charSequence, str, i8, z7);
    }

    public static final int Z(CharSequence charSequence, char[] chars, int i8, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(chars, "chars");
        if (!z7 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(AbstractC2592n.X(chars), i8);
        }
        int iB = H5.i.b(i8, 0);
        int iS = S(charSequence);
        if (iB > iS) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            for (char c8 : chars) {
                if (AbstractC0976b.d(c8, cCharAt, z7)) {
                    return iB;
                }
            }
            if (iB == iS) {
                return -1;
            }
            iB++;
        }
    }

    public static boolean a0(CharSequence charSequence) {
        AbstractC2304t.f(charSequence, "<this>");
        for (int i8 = 0; i8 < charSequence.length(); i8++) {
            if (!AbstractC0975a.c(charSequence.charAt(i8))) {
                return false;
            }
        }
        return true;
    }

    public static final int b0(CharSequence charSequence, char c8, int i8, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        return (z7 || !(charSequence instanceof String)) ? f0(charSequence, new char[]{c8}, i8, z7) : ((String) charSequence).lastIndexOf(c8, i8);
    }

    public static final int c0(CharSequence charSequence, String string, int i8, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(string, "string");
        return (z7 || !(charSequence instanceof String)) ? V(charSequence, string, i8, 0, z7, true) : ((String) charSequence).lastIndexOf(string, i8);
    }

    public static /* synthetic */ int d0(CharSequence charSequence, char c8, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = S(charSequence);
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return b0(charSequence, c8, i8, z7);
    }

    public static /* synthetic */ int e0(CharSequence charSequence, String str, int i8, boolean z7, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = S(charSequence);
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        return c0(charSequence, str, i8, z7);
    }

    public static final int f0(CharSequence charSequence, char[] chars, int i8, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(chars, "chars");
        if (!z7 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(AbstractC2592n.X(chars), i8);
        }
        for (int iD = H5.i.d(i8, S(charSequence)); -1 < iD; iD--) {
            char cCharAt = charSequence.charAt(iD);
            for (char c8 : chars) {
                if (AbstractC0976b.d(c8, cCharAt, z7)) {
                    return iD;
                }
            }
        }
        return -1;
    }

    public static final U6.h g0(CharSequence charSequence) {
        AbstractC2304t.f(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final List h0(CharSequence charSequence) {
        AbstractC2304t.f(charSequence, "<this>");
        return U6.r.J(g0(charSequence));
    }

    public static final CharSequence i0(CharSequence charSequence, int i8, char c8) {
        AbstractC2304t.f(charSequence, "<this>");
        if (i8 < 0) {
            throw new IllegalArgumentException("Desired length " + i8 + " is less than zero.");
        }
        if (i8 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i8);
        int length = i8 - charSequence.length();
        int i9 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c8);
                if (i9 == length) {
                    break;
                }
                i9++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static String j0(String str, int i8, char c8) {
        AbstractC2304t.f(str, "<this>");
        return i0(str, i8, c8).toString();
    }

    public static final U6.h k0(CharSequence charSequence, String[] strArr, int i8, final boolean z7, int i9) {
        q0(i9);
        final List listD = AbstractC2590l.d(strArr);
        return new C0978d(charSequence, i8, i9, new B5.o() { // from class: V6.B
            @Override // B5.o
            public final Object invoke(Object obj, Object obj2) {
                return C.m0(listD, z7, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ U6.h l0(CharSequence charSequence, String[] strArr, int i8, boolean z7, int i9, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            i8 = 0;
        }
        if ((i10 & 4) != 0) {
            z7 = false;
        }
        if ((i10 & 8) != 0) {
            i9 = 0;
        }
        return k0(charSequence, strArr, i8, z7, i9);
    }

    public static final C2489q m0(List list, boolean z7, CharSequence DelimitedRangesSequence, int i8) {
        AbstractC2304t.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        C2489q c2489qQ = Q(DelimitedRangesSequence, list, i8, z7, false);
        if (c2489qQ != null) {
            return o5.w.a(c2489qQ.c(), Integer.valueOf(((String) c2489qQ.d()).length()));
        }
        return null;
    }

    public static final boolean n0(CharSequence charSequence, int i8, CharSequence other, int i9, int i10, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(other, "other");
        if (i9 < 0 || i8 < 0 || i8 > charSequence.length() - i10 || i9 > other.length() - i10) {
            return false;
        }
        for (int i11 = 0; i11 < i10; i11++) {
            if (!AbstractC0976b.d(charSequence.charAt(i8 + i11), other.charAt(i9 + i11), z7)) {
                return false;
            }
        }
        return true;
    }

    public static String o0(String str, CharSequence prefix) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(prefix, "prefix");
        if (!x0(str, prefix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String p0(String str, CharSequence suffix) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(suffix, "suffix");
        if (!P(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final void q0(int i8) {
        if (i8 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i8).toString());
    }

    public static final List r0(CharSequence charSequence, String[] delimiters, boolean z7, int i8) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return s0(charSequence, str, z7, i8);
            }
        }
        Iterable iterableR = U6.r.r(l0(charSequence, delimiters, 0, z7, i8, 2, null));
        ArrayList arrayList = new ArrayList(p5.r.s(iterableR, 10));
        Iterator it = iterableR.iterator();
        while (it.hasNext()) {
            arrayList.add(y0(charSequence, (H5.d) it.next()));
        }
        return arrayList;
    }

    public static final List s0(CharSequence charSequence, String str, boolean z7, int i8) {
        q0(i8);
        int length = 0;
        int iU = U(charSequence, str, 0, z7);
        if (iU == -1 || i8 == 1) {
            return AbstractC2594p.e(charSequence.toString());
        }
        boolean z8 = i8 > 0;
        ArrayList arrayList = new ArrayList(z8 ? H5.i.d(i8, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iU).toString());
            length = str.length() + iU;
            if (z8 && arrayList.size() == i8 - 1) {
                break;
            }
            iU = U(charSequence, str, length, z7);
        } while (iU != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List t0(CharSequence charSequence, String[] strArr, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            z7 = false;
        }
        if ((i9 & 4) != 0) {
            i8 = 0;
        }
        return r0(charSequence, strArr, z7, i8);
    }

    public static final boolean u0(CharSequence charSequence, char c8, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC0976b.d(charSequence.charAt(0), c8, z7);
    }

    public static final boolean v0(CharSequence charSequence, CharSequence prefix, boolean z7) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(prefix, "prefix");
        return (!z7 && (charSequence instanceof String) && (prefix instanceof String)) ? A.G((String) charSequence, (String) prefix, false, 2, null) : n0(charSequence, 0, prefix, 0, prefix.length(), z7);
    }

    public static /* synthetic */ boolean w0(CharSequence charSequence, char c8, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return u0(charSequence, c8, z7);
    }

    public static /* synthetic */ boolean x0(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        return v0(charSequence, charSequence2, z7);
    }

    public static final String y0(CharSequence charSequence, H5.d range) {
        AbstractC2304t.f(charSequence, "<this>");
        AbstractC2304t.f(range, "range");
        return charSequence.subSequence(range.a().intValue(), range.d().intValue() + 1).toString();
    }

    public static String z0(String str, char c8, String missingDelimiterValue) {
        AbstractC2304t.f(str, "<this>");
        AbstractC2304t.f(missingDelimiterValue, "missingDelimiterValue");
        int iX = X(str, c8, 0, false, 6, null);
        if (iX == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iX + 1, str.length());
        AbstractC2304t.e(strSubstring, "substring(...)");
        return strSubstring;
    }
}
