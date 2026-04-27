package Z5;

import F5.AbstractC0551i;
import F5.AbstractC0552j;
import F5.AbstractC0555m;
import F5.AbstractC0557o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public abstract class u extends t {

    public static final class a extends kotlin.jvm.internal.s implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ char[] f6050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f6051b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(char[] cArr, boolean z7) {
            super(2);
            this.f6050a = cArr;
            this.f6051b = z7;
        }

        public final E5.o a(CharSequence $receiver, int i7) {
            kotlin.jvm.internal.r.f($receiver, "$this$$receiver");
            int iO = u.O($receiver, this.f6050a, i7, this.f6051b);
            if (iO < 0) {
                return null;
            }
            return E5.t.a(Integer.valueOf(iO), 1);
        }

        @Override // Q5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    public static final class b extends kotlin.jvm.internal.s implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f6052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f6053b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List list, boolean z7) {
            super(2);
            this.f6052a = list;
            this.f6053b = z7;
        }

        public final E5.o a(CharSequence $receiver, int i7) {
            kotlin.jvm.internal.r.f($receiver, "$this$$receiver");
            E5.o oVarG = u.G($receiver, this.f6052a, i7, this.f6053b, false);
            if (oVarG != null) {
                return E5.t.a(oVarG.c(), Integer.valueOf(((String) oVarG.d()).length()));
            }
            return null;
        }

        @Override // Q5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    public static final class c extends kotlin.jvm.internal.s implements Q5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f6054a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence) {
            super(1);
            this.f6054a = charSequence;
        }

        @Override // Q5.k
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(W5.g it) {
            kotlin.jvm.internal.r.f(it, "it");
            return u.r0(this.f6054a, it);
        }
    }

    public static final boolean A(CharSequence charSequence, char c7, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return M(charSequence, c7, 0, z7, 2, null) >= 0;
    }

    public static CharSequence A0(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i7 = 0;
        boolean z7 = false;
        while (i7 <= length) {
            boolean zC = AbstractC0794a.c(charSequence.charAt(!z7 ? i7 : length));
            if (z7) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i7++;
            } else {
                z7 = true;
            }
        }
        return charSequence.subSequence(i7, length + 1);
    }

    public static final boolean B(CharSequence charSequence, CharSequence other, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        if (other instanceof String) {
            if (N(charSequence, (String) other, 0, z7, 2, null) < 0) {
                return false;
            }
        } else if (L(charSequence, other, 0, charSequence.length(), z7, false, 16, null) < 0) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ boolean C(CharSequence charSequence, char c7, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return A(charSequence, c7, z7);
    }

    public static /* synthetic */ boolean D(CharSequence charSequence, CharSequence charSequence2, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return B(charSequence, charSequence2, z7);
    }

    public static final boolean E(CharSequence charSequence, char c7, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC0795b.d(charSequence.charAt(H(charSequence)), c7, z7);
    }

    public static /* synthetic */ boolean F(CharSequence charSequence, char c7, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return E(charSequence, c7, z7);
    }

    public static final E5.o G(CharSequence charSequence, Collection collection, int i7, boolean z7, boolean z8) {
        Object next;
        Object next2;
        if (!z7 && collection.size() == 1) {
            String str = (String) F5.v.X(collection);
            int iN = !z8 ? N(charSequence, str, i7, false, 4, null) : T(charSequence, str, i7, false, 4, null);
            if (iN < 0) {
                return null;
            }
            return E5.t.a(Integer.valueOf(iN), str);
        }
        W5.e gVar = !z8 ? new W5.g(W5.l.b(i7, 0), charSequence.length()) : W5.l.i(W5.l.d(i7, H(charSequence)), 0);
        if (charSequence instanceof String) {
            int iG = gVar.g();
            int iH = gVar.h();
            int iJ = gVar.j();
            if ((iJ > 0 && iG <= iH) || (iJ < 0 && iH <= iG)) {
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        if (t.s(str2, 0, (String) charSequence, iG, str2.length(), z7)) {
                            break;
                        }
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (iG == iH) {
                            break;
                        }
                        iG += iJ;
                    } else {
                        return E5.t.a(Integer.valueOf(iG), str3);
                    }
                }
            }
        } else {
            int iG2 = gVar.g();
            int iH2 = gVar.h();
            int iJ2 = gVar.j();
            if ((iJ2 > 0 && iG2 <= iH2) || (iJ2 < 0 && iH2 <= iG2)) {
                while (true) {
                    Iterator it2 = collection.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            next = null;
                            break;
                        }
                        next = it2.next();
                        String str4 = (String) next;
                        if (g0(str4, 0, charSequence, iG2, str4.length(), z7)) {
                            break;
                        }
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (iG2 == iH2) {
                            break;
                        }
                        iG2 += iJ2;
                    } else {
                        return E5.t.a(Integer.valueOf(iG2), str5);
                    }
                }
            }
        }
        return null;
    }

    public static int H(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int I(CharSequence charSequence, char c7, int i7, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return (z7 || !(charSequence instanceof String)) ? O(charSequence, new char[]{c7}, i7, z7) : ((String) charSequence).indexOf(c7, i7);
    }

    public static final int J(CharSequence charSequence, String string, int i7, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(string, "string");
        return (z7 || !(charSequence instanceof String)) ? L(charSequence, string, i7, charSequence.length(), z7, false, 16, null) : ((String) charSequence).indexOf(string, i7);
    }

    public static final int K(CharSequence charSequence, CharSequence charSequence2, int i7, int i8, boolean z7, boolean z8) {
        W5.e gVar = !z8 ? new W5.g(W5.l.b(i7, 0), W5.l.d(i8, charSequence.length())) : W5.l.i(W5.l.d(i7, H(charSequence)), W5.l.b(i8, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iG = gVar.g();
            int iH = gVar.h();
            int iJ = gVar.j();
            if ((iJ <= 0 || iG > iH) && (iJ >= 0 || iH > iG)) {
                return -1;
            }
            while (!t.s((String) charSequence2, 0, (String) charSequence, iG, charSequence2.length(), z7)) {
                if (iG == iH) {
                    return -1;
                }
                iG += iJ;
            }
            return iG;
        }
        int iG2 = gVar.g();
        int iH2 = gVar.h();
        int iJ2 = gVar.j();
        if ((iJ2 <= 0 || iG2 > iH2) && (iJ2 >= 0 || iH2 > iG2)) {
            return -1;
        }
        while (!g0(charSequence2, 0, charSequence, iG2, charSequence2.length(), z7)) {
            if (iG2 == iH2) {
                return -1;
            }
            iG2 += iJ2;
        }
        return iG2;
    }

    public static /* synthetic */ int L(CharSequence charSequence, CharSequence charSequence2, int i7, int i8, boolean z7, boolean z8, int i9, Object obj) {
        if ((i9 & 16) != 0) {
            z8 = false;
        }
        return K(charSequence, charSequence2, i7, i8, z7, z8);
    }

    public static /* synthetic */ int M(CharSequence charSequence, char c7, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return I(charSequence, c7, i7, z7);
    }

    public static /* synthetic */ int N(CharSequence charSequence, String str, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = 0;
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return J(charSequence, str, i7, z7);
    }

    public static final int O(CharSequence charSequence, char[] chars, int i7, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(chars, "chars");
        if (!z7 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(AbstractC0552j.Z(chars), i7);
        }
        int iB = W5.l.b(i7, 0);
        int iH = H(charSequence);
        if (iB > iH) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            for (char c7 : chars) {
                if (AbstractC0795b.d(c7, cCharAt, z7)) {
                    return iB;
                }
            }
            if (iB == iH) {
                return -1;
            }
            iB++;
        }
    }

    public static boolean P(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        for (int i7 = 0; i7 < charSequence.length(); i7++) {
            if (!AbstractC0794a.c(charSequence.charAt(i7))) {
                return false;
            }
        }
        return true;
    }

    public static final int Q(CharSequence charSequence, char c7, int i7, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return (z7 || !(charSequence instanceof String)) ? U(charSequence, new char[]{c7}, i7, z7) : ((String) charSequence).lastIndexOf(c7, i7);
    }

    public static final int R(CharSequence charSequence, String string, int i7, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(string, "string");
        return (z7 || !(charSequence instanceof String)) ? K(charSequence, string, i7, 0, z7, true) : ((String) charSequence).lastIndexOf(string, i7);
    }

    public static /* synthetic */ int S(CharSequence charSequence, char c7, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = H(charSequence);
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return Q(charSequence, c7, i7, z7);
    }

    public static /* synthetic */ int T(CharSequence charSequence, String str, int i7, boolean z7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            i7 = H(charSequence);
        }
        if ((i8 & 4) != 0) {
            z7 = false;
        }
        return R(charSequence, str, i7, z7);
    }

    public static final int U(CharSequence charSequence, char[] chars, int i7, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(chars, "chars");
        if (!z7 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(AbstractC0552j.Z(chars), i7);
        }
        for (int iD = W5.l.d(i7, H(charSequence)); -1 < iD; iD--) {
            char cCharAt = charSequence.charAt(iD);
            for (char c7 : chars) {
                if (AbstractC0795b.d(c7, cCharAt, z7)) {
                    return iD;
                }
            }
        }
        return -1;
    }

    public static final Y5.f V(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return o0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List W(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return Y5.m.l(V(charSequence));
    }

    public static final CharSequence X(CharSequence charSequence, int i7, char c7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException("Desired length " + i7 + " is less than zero.");
        }
        if (i7 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i7);
        sb.append(charSequence);
        int length = i7 - charSequence.length();
        int i8 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c7);
                if (i8 == length) {
                    break;
                }
                i8++;
            }
        }
        return sb;
    }

    public static final String Y(String str, int i7, char c7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return X(str, i7, c7).toString();
    }

    public static /* synthetic */ String Z(String str, int i7, char c7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            c7 = ' ';
        }
        return Y(str, i7, c7);
    }

    public static final CharSequence a0(CharSequence charSequence, int i7, char c7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        if (i7 < 0) {
            throw new IllegalArgumentException("Desired length " + i7 + " is less than zero.");
        }
        if (i7 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb = new StringBuilder(i7);
        int length = i7 - charSequence.length();
        int i8 = 1;
        if (1 <= length) {
            while (true) {
                sb.append(c7);
                if (i8 == length) {
                    break;
                }
                i8++;
            }
        }
        sb.append(charSequence);
        return sb;
    }

    public static String b0(String str, int i7, char c7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        return a0(str, i7, c7).toString();
    }

    public static final Y5.f c0(CharSequence charSequence, char[] cArr, int i7, boolean z7, int i8) {
        h0(i8);
        return new d(charSequence, i7, i8, new a(cArr, z7));
    }

    public static final Y5.f d0(CharSequence charSequence, String[] strArr, int i7, boolean z7, int i8) {
        h0(i8);
        return new d(charSequence, i7, i8, new b(AbstractC0551i.c(strArr), z7));
    }

    public static /* synthetic */ Y5.f e0(CharSequence charSequence, char[] cArr, int i7, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        if ((i9 & 8) != 0) {
            i8 = 0;
        }
        return c0(charSequence, cArr, i7, z7, i8);
    }

    public static /* synthetic */ Y5.f f0(CharSequence charSequence, String[] strArr, int i7, boolean z7, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i7 = 0;
        }
        if ((i9 & 4) != 0) {
            z7 = false;
        }
        if ((i9 & 8) != 0) {
            i8 = 0;
        }
        return d0(charSequence, strArr, i7, z7, i8);
    }

    public static final boolean g0(CharSequence charSequence, int i7, CharSequence other, int i8, int i9, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(other, "other");
        if (i8 < 0 || i7 < 0 || i7 > charSequence.length() - i9 || i8 > other.length() - i9) {
            return false;
        }
        for (int i10 = 0; i10 < i9; i10++) {
            if (!AbstractC0795b.d(charSequence.charAt(i7 + i10), other.charAt(i8 + i10), z7)) {
                return false;
            }
        }
        return true;
    }

    public static final void h0(int i7) {
        if (i7 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i7).toString());
    }

    public static final List i0(CharSequence charSequence, char[] delimiters, boolean z7, int i7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return k0(charSequence, String.valueOf(delimiters[0]), z7, i7);
        }
        Iterable iterableG = Y5.m.g(e0(charSequence, delimiters, 0, z7, i7, 2, null));
        ArrayList arrayList = new ArrayList(AbstractC0557o.q(iterableG, 10));
        Iterator it = iterableG.iterator();
        while (it.hasNext()) {
            arrayList.add(r0(charSequence, (W5.g) it.next()));
        }
        return arrayList;
    }

    public static final List j0(CharSequence charSequence, String[] delimiters, boolean z7, int i7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return k0(charSequence, str, z7, i7);
            }
        }
        Iterable iterableG = Y5.m.g(f0(charSequence, delimiters, 0, z7, i7, 2, null));
        ArrayList arrayList = new ArrayList(AbstractC0557o.q(iterableG, 10));
        Iterator it = iterableG.iterator();
        while (it.hasNext()) {
            arrayList.add(r0(charSequence, (W5.g) it.next()));
        }
        return arrayList;
    }

    public static final List k0(CharSequence charSequence, String str, boolean z7, int i7) {
        h0(i7);
        int length = 0;
        int iJ = J(charSequence, str, 0, z7);
        if (iJ == -1 || i7 == 1) {
            return AbstractC0555m.b(charSequence.toString());
        }
        boolean z8 = i7 > 0;
        ArrayList arrayList = new ArrayList(z8 ? W5.l.d(i7, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iJ).toString());
            length = str.length() + iJ;
            if (z8 && arrayList.size() == i7 - 1) {
                break;
            }
            iJ = J(charSequence, str, length, z7);
        } while (iJ != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List l0(CharSequence charSequence, char[] cArr, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 0;
        }
        return i0(charSequence, cArr, z7, i7);
    }

    public static /* synthetic */ List m0(CharSequence charSequence, String[] strArr, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 0;
        }
        return j0(charSequence, strArr, z7, i7);
    }

    public static final Y5.f n0(CharSequence charSequence, String[] delimiters, boolean z7, int i7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(delimiters, "delimiters");
        return Y5.m.j(f0(charSequence, delimiters, 0, z7, i7, 2, null), new c(charSequence));
    }

    public static /* synthetic */ Y5.f o0(CharSequence charSequence, String[] strArr, boolean z7, int i7, int i8, Object obj) {
        if ((i8 & 2) != 0) {
            z7 = false;
        }
        if ((i8 & 4) != 0) {
            i7 = 0;
        }
        return n0(charSequence, strArr, z7, i7);
    }

    public static final boolean p0(CharSequence charSequence, char c7, boolean z7) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        return charSequence.length() > 0 && AbstractC0795b.d(charSequence.charAt(0), c7, z7);
    }

    public static /* synthetic */ boolean q0(CharSequence charSequence, char c7, boolean z7, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            z7 = false;
        }
        return p0(charSequence, c7, z7);
    }

    public static final String r0(CharSequence charSequence, W5.g range) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(range, "range");
        return charSequence.subSequence(range.a().intValue(), range.c().intValue() + 1).toString();
    }

    public static final String s0(String str, char c7, String missingDelimiterValue) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(missingDelimiterValue, "missingDelimiterValue");
        int iM = M(str, c7, 0, false, 6, null);
        if (iM == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iM + 1, str.length());
        kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String t0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(delimiter, "delimiter");
        kotlin.jvm.internal.r.f(missingDelimiterValue, "missingDelimiterValue");
        int iN = N(str, delimiter, 0, false, 6, null);
        if (iN == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iN + delimiter.length(), str.length());
        kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String u0(String str, char c7, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return s0(str, c7, str2);
    }

    public static /* synthetic */ String v0(String str, String str2, String str3, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str3 = str;
        }
        return t0(str, str2, str3);
    }

    public static String w0(String str, char c7, String missingDelimiterValue) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(missingDelimiterValue, "missingDelimiterValue");
        int iS = S(str, c7, 0, false, 6, null);
        if (iS == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iS + 1, str.length());
        kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String x0(String str, char c7, String str2, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str2 = str;
        }
        return w0(str, c7, str2);
    }

    public static final String y0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.r.f(str, "<this>");
        kotlin.jvm.internal.r.f(delimiter, "delimiter");
        kotlin.jvm.internal.r.f(missingDelimiterValue, "missingDelimiterValue");
        int iN = N(str, delimiter, 0, false, 6, null);
        if (iN == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iN);
        kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ String z0(String str, String str2, String str3, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            str3 = str;
        }
        return y0(str, str2, str3);
    }
}
