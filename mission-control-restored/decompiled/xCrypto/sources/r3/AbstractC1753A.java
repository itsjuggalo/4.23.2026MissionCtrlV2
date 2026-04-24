package r3;

import X2.AbstractC0763j;
import X2.AbstractC0765l;
import X2.AbstractC0768o;
import X2.AbstractC0770q;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import o3.AbstractC1681l;
import o3.C1674e;
import o3.C1676g;

/* JADX INFO: renamed from: r3.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1753A extends x {

    /* JADX INFO: renamed from: r3.A$a */
    public static final class a implements q3.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f14561a;

        public a(CharSequence charSequence) {
            this.f14561a = charSequence;
        }

        @Override // q3.e
        public Iterator iterator() {
            return new C1758e(this.f14561a);
        }
    }

    public static /* synthetic */ String A0(String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str3 = str;
        }
        return y0(str, str2, str3);
    }

    public static String B0(String str, char c4, String missingDelimiterValue) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(missingDelimiterValue, "missingDelimiterValue");
        int iX = X(str, c4, 0, false, 6, null);
        if (iX == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iX + 1, str.length());
        kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String C0(String str, char c4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = str;
        }
        return B0(str, c4, str2);
    }

    public static final String D0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(delimiter, "delimiter");
        kotlin.jvm.internal.r.f(missingDelimiterValue, "missingDelimiterValue");
        int iS = S(str, delimiter, 0, false, 6, null);
        if (iS == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iS);
        kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String E0(String str, String str2, String str3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str3 = str;
        }
        return D0(str, str2, str3);
    }

    public static final boolean F(CharSequence charSequence, char c4, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return R(charSequence, c4, 0, z4, 2, null) >= 0;
    }

    public static CharSequence F0(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i4 = 0;
        boolean z4 = false;
        while (i4 <= length) {
            boolean zC = AbstractC1754a.c(charSequence.charAt(!z4 ? i4 : length));
            if (z4) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i4++;
            } else {
                z4 = true;
            }
        }
        return charSequence.subSequence(i4, length + 1);
    }

    public static final boolean G(CharSequence charSequence, CharSequence other, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        return other instanceof String ? S(charSequence, (String) other, 0, z4, 2, null) >= 0 : Q(charSequence, other, 0, charSequence.length(), z4, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean H(CharSequence charSequence, char c4, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return F(charSequence, c4, z4);
    }

    public static /* synthetic */ boolean I(CharSequence charSequence, CharSequence charSequence2, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return G(charSequence, charSequence2, z4);
    }

    public static final boolean J(CharSequence charSequence, char c4, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC1755b.d(charSequence.charAt(M(charSequence)), c4, z4);
    }

    public static /* synthetic */ boolean K(CharSequence charSequence, char c4, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return J(charSequence, c4, z4);
    }

    public static final W2.o L(CharSequence charSequence, Collection collection, int i4, boolean z4, boolean z5) {
        CharSequence charSequence2;
        Object next;
        boolean z6;
        Object next2;
        if (!z4 && collection.size() == 1) {
            String str = (String) X2.x.W(collection);
            int iS = !z5 ? S(charSequence, str, i4, false, 4, null) : Y(charSequence, str, i4, false, 4, null);
            if (iS < 0) {
                return null;
            }
            return W2.t.a(Integer.valueOf(iS), str);
        }
        CharSequence charSequence3 = charSequence;
        C1674e c1676g = !z5 ? new C1676g(AbstractC1681l.b(i4, 0), charSequence3.length()) : AbstractC1681l.i(AbstractC1681l.d(i4, M(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int iK = c1676g.k();
            int iL = c1676g.l();
            int iM = c1676g.m();
            if ((iM > 0 && iK <= iL) || (iM < 0 && iL <= iK)) {
                int i5 = iK;
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z6 = z4;
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        z6 = z4;
                        if (x.w(str2, 0, (String) charSequence3, i5, str2.length(), z6)) {
                            break;
                        }
                        z4 = z6;
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (i5 == iL) {
                            break;
                        }
                        i5 += iM;
                        z4 = z6;
                    } else {
                        return W2.t.a(Integer.valueOf(i5), str3);
                    }
                }
            }
        } else {
            boolean z7 = z4;
            int iK2 = c1676g.k();
            int iL2 = c1676g.l();
            int iM2 = c1676g.m();
            if ((iM2 > 0 && iK2 <= iL2) || (iM2 < 0 && iL2 <= iK2)) {
                int i6 = iK2;
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            charSequence2 = charSequence3;
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        boolean z8 = z7;
                        charSequence2 = charSequence3;
                        z7 = z8;
                        if (n0(str4, 0, charSequence2, i6, str4.length(), z8)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (i6 == iL2) {
                            break;
                        }
                        i6 += iM2;
                        charSequence3 = charSequence2;
                    } else {
                        return W2.t.a(Integer.valueOf(i6), str5);
                    }
                }
            }
        }
        return null;
    }

    public static int M(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int N(CharSequence charSequence, char c4, int i4, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return (z4 || !(charSequence instanceof String)) ? T(charSequence, new char[]{c4}, i4, z4) : ((String) charSequence).indexOf(c4, i4);
    }

    public static final int O(CharSequence charSequence, String string, int i4, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(string, "string");
        return (z4 || !(charSequence instanceof String)) ? Q(charSequence, string, i4, charSequence.length(), z4, false, 16, null) : ((String) charSequence).indexOf(string, i4);
    }

    public static final int P(CharSequence charSequence, CharSequence charSequence2, int i4, int i5, boolean z4, boolean z5) {
        C1674e c1676g = !z5 ? new C1676g(AbstractC1681l.b(i4, 0), AbstractC1681l.d(i5, charSequence.length())) : AbstractC1681l.i(AbstractC1681l.d(i4, M(charSequence)), AbstractC1681l.b(i5, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iK = c1676g.k();
            int iL = c1676g.l();
            int iM = c1676g.m();
            if ((iM <= 0 || iK > iL) && (iM >= 0 || iL > iK)) {
                return -1;
            }
            int i6 = iK;
            while (true) {
                String str = (String) charSequence2;
                boolean z6 = z4;
                if (x.w(str, 0, (String) charSequence, i6, str.length(), z6)) {
                    return i6;
                }
                if (i6 == iL) {
                    return -1;
                }
                i6 += iM;
                z4 = z6;
            }
        } else {
            boolean z7 = z4;
            int iK2 = c1676g.k();
            int iL2 = c1676g.l();
            int iM2 = c1676g.m();
            if ((iM2 <= 0 || iK2 > iL2) && (iM2 >= 0 || iL2 > iK2)) {
                return -1;
            }
            int i7 = iK2;
            while (true) {
                boolean z8 = z7;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z7 = z8;
                if (n0(charSequence4, 0, charSequence3, i7, charSequence2.length(), z8)) {
                    return i7;
                }
                if (i7 == iL2) {
                    return -1;
                }
                i7 += iM2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static /* synthetic */ int Q(CharSequence charSequence, CharSequence charSequence2, int i4, int i5, boolean z4, boolean z5, int i6, Object obj) {
        if ((i6 & 16) != 0) {
            z5 = false;
        }
        return P(charSequence, charSequence2, i4, i5, z4, z5);
    }

    public static /* synthetic */ int R(CharSequence charSequence, char c4, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return N(charSequence, c4, i4, z4);
    }

    public static /* synthetic */ int S(CharSequence charSequence, String str, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return O(charSequence, str, i4, z4);
    }

    public static final int T(CharSequence charSequence, char[] chars, int i4, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(chars, "chars");
        if (!z4 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(AbstractC0765l.a0(chars), i4);
        }
        int iB = AbstractC1681l.b(i4, 0);
        int iM = M(charSequence);
        if (iB > iM) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            for (char c4 : chars) {
                if (AbstractC1755b.d(c4, cCharAt, z4)) {
                    return iB;
                }
            }
            if (iB == iM) {
                return -1;
            }
            iB++;
        }
    }

    public static boolean U(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (!AbstractC1754a.c(charSequence.charAt(i4))) {
                return false;
            }
        }
        return true;
    }

    public static final int V(CharSequence charSequence, char c4, int i4, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return (z4 || !(charSequence instanceof String)) ? Z(charSequence, new char[]{c4}, i4, z4) : ((String) charSequence).lastIndexOf(c4, i4);
    }

    public static final int W(CharSequence charSequence, String string, int i4, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(string, "string");
        return (z4 || !(charSequence instanceof String)) ? P(charSequence, string, i4, 0, z4, true) : ((String) charSequence).lastIndexOf(string, i4);
    }

    public static /* synthetic */ int X(CharSequence charSequence, char c4, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = M(charSequence);
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return V(charSequence, c4, i4, z4);
    }

    public static /* synthetic */ int Y(CharSequence charSequence, String str, int i4, boolean z4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = M(charSequence);
        }
        if ((i5 & 4) != 0) {
            z4 = false;
        }
        return W(charSequence, str, i4, z4);
    }

    public static final int Z(CharSequence charSequence, char[] chars, int i4, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(chars, "chars");
        if (!z4 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(AbstractC0765l.a0(chars), i4);
        }
        for (int iD = AbstractC1681l.d(i4, M(charSequence)); -1 < iD; iD--) {
            char cCharAt = charSequence.charAt(iD);
            for (char c4 : chars) {
                if (AbstractC1755b.d(c4, cCharAt, z4)) {
                    return iD;
                }
            }
        }
        return -1;
    }

    public static final q3.e a0(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final List b0(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return q3.l.k(a0(charSequence));
    }

    public static final CharSequence c0(CharSequence charSequence, int i4, char c4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException("Desired length " + i4 + " is less than zero.");
        }
        if (i4 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i4);
        sb.append(charSequence);
        int length = i4 - charSequence.length();
        int i5 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c4);
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        return sb;
    }

    public static final String d0(String str, int i4, char c4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return c0(str, i4, c4).toString();
    }

    public static /* synthetic */ String e0(String str, int i4, char c4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            c4 = ' ';
        }
        return d0(str, i4, c4);
    }

    public static final CharSequence f0(CharSequence charSequence, int i4, char c4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        if (i4 < 0) {
            throw new IllegalArgumentException("Desired length " + i4 + " is less than zero.");
        }
        if (i4 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i4);
        int length = i4 - charSequence.length();
        int i5 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c4);
                if (i5 == length) {
                    break;
                }
                i5++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static String g0(String str, int i4, char c4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return f0(str, i4, c4).toString();
    }

    public static final q3.e h0(CharSequence charSequence, final char[] cArr, int i4, final boolean z4, int i5) {
        o0(i5);
        return new C1757d(charSequence, i4, i5, new i3.o() { // from class: r3.y
            @Override // i3.o
            public final Object invoke(Object obj, Object obj2) {
                return AbstractC1753A.l0(cArr, z4, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static final q3.e i0(CharSequence charSequence, String[] strArr, int i4, final boolean z4, int i5) {
        o0(i5);
        final List listC = AbstractC0763j.c(strArr);
        return new C1757d(charSequence, i4, i5, new i3.o() { // from class: r3.z
            @Override // i3.o
            public final Object invoke(Object obj, Object obj2) {
                return AbstractC1753A.m0(listC, z4, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ q3.e j0(CharSequence charSequence, char[] cArr, int i4, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return h0(charSequence, cArr, i4, z4, i5);
    }

    public static /* synthetic */ q3.e k0(CharSequence charSequence, String[] strArr, int i4, boolean z4, int i5, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            i4 = 0;
        }
        if ((i6 & 4) != 0) {
            z4 = false;
        }
        if ((i6 & 8) != 0) {
            i5 = 0;
        }
        return i0(charSequence, strArr, i4, z4, i5);
    }

    public static final W2.o l0(char[] cArr, boolean z4, CharSequence DelimitedRangesSequence, int i4) {
        kotlin.jvm.internal.r.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int iT = T(DelimitedRangesSequence, cArr, i4, z4);
        if (iT < 0) {
            return null;
        }
        return W2.t.a(Integer.valueOf(iT), 1);
    }

    public static final W2.o m0(List list, boolean z4, CharSequence DelimitedRangesSequence, int i4) {
        kotlin.jvm.internal.r.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        W2.o oVarL = L(DelimitedRangesSequence, list, i4, z4, false);
        if (oVarL != null) {
            return W2.t.a(oVarL.c(), Integer.valueOf(((String) oVarL.d()).length()));
        }
        return null;
    }

    public static final boolean n0(CharSequence charSequence, int i4, CharSequence other, int i5, int i6, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        if (i5 < 0 || i4 < 0 || i4 > charSequence.length() - i6 || i5 > other.length() - i6) {
            return false;
        }
        for (int i7 = 0; i7 < i6; i7++) {
            if (!AbstractC1755b.d(charSequence.charAt(i4 + i7), other.charAt(i5 + i7), z4)) {
                return false;
            }
        }
        return true;
    }

    public static final void o0(int i4) {
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i4).toString());
    }

    public static final List p0(CharSequence charSequence, char[] delimiters, boolean z4, int i4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return r0(charSequence, String.valueOf(delimiters[0]), z4, i4);
        }
        Iterable iterableF = q3.l.f(j0(charSequence, delimiters, 0, z4, i4, 2, null));
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(iterableF, 10));
        Iterator it = iterableF.iterator();
        while (it.hasNext()) {
            arrayList.add(w0(charSequence, (C1676g) it.next()));
        }
        return arrayList;
    }

    public static final List q0(CharSequence charSequence, String[] delimiters, boolean z4, int i4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return r0(charSequence, str, z4, i4);
            }
        }
        Iterable iterableF = q3.l.f(k0(charSequence, delimiters, 0, z4, i4, 2, null));
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(iterableF, 10));
        Iterator it = iterableF.iterator();
        while (it.hasNext()) {
            arrayList.add(w0(charSequence, (C1676g) it.next()));
        }
        return arrayList;
    }

    public static final List r0(CharSequence charSequence, String str, boolean z4, int i4) {
        o0(i4);
        int length = 0;
        int iO = O(charSequence, str, 0, z4);
        if (iO == -1 || i4 == 1) {
            return AbstractC0768o.b(charSequence.toString());
        }
        boolean z5 = i4 > 0;
        ArrayList arrayList = new ArrayList(z5 ? AbstractC1681l.d(i4, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iO).toString());
            length = str.length() + iO;
            if (z5 && arrayList.size() == i4 - 1) {
                break;
            }
            iO = O(charSequence, str, length, z4);
        } while (iO != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List s0(CharSequence charSequence, char[] cArr, boolean z4, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return p0(charSequence, cArr, z4, i4);
    }

    public static /* synthetic */ List t0(CharSequence charSequence, String[] strArr, boolean z4, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z4 = false;
        }
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return q0(charSequence, strArr, z4, i4);
    }

    public static final boolean u0(CharSequence charSequence, char c4, boolean z4) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC1755b.d(charSequence.charAt(0), c4, z4);
    }

    public static /* synthetic */ boolean v0(CharSequence charSequence, char c4, boolean z4, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            z4 = false;
        }
        return u0(charSequence, c4, z4);
    }

    public static final String w0(CharSequence charSequence, C1676g range) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(range, "range");
        return charSequence.subSequence(range.f().intValue(), range.i().intValue() + 1).toString();
    }

    public static final String x0(String str, char c4, String missingDelimiterValue) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(missingDelimiterValue, "missingDelimiterValue");
        int iR = R(str, c4, 0, false, 6, null);
        if (iR == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iR + 1, str.length());
        kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String y0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(delimiter, "delimiter");
        kotlin.jvm.internal.r.f(missingDelimiterValue, "missingDelimiterValue");
        int iS = S(str, delimiter, 0, false, 6, null);
        if (iS == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iS + delimiter.length(), str.length());
        kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String z0(String str, char c4, String str2, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            str2 = str;
        }
        return x0(str, c4, str2);
    }
}
