package kg;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 extends z {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements jg.h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CharSequence f14863a;

        public a(CharSequence charSequence) {
            this.f14863a = charSequence;
        }

        @Override // jg.h
        public Iterator iterator() {
            return new h(this.f14863a);
        }
    }

    public static final CharSequence A0(CharSequence charSequence, int i10, int i11, CharSequence replacement) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(replacement, "replacement");
        if (i11 >= i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(charSequence, 0, i10);
            kotlin.jvm.internal.t.e(sb2, "append(...)");
            sb2.append(replacement);
            sb2.append(charSequence, i11, charSequence.length());
            kotlin.jvm.internal.t.e(sb2, "append(...)");
            return sb2;
        }
        throw new IndexOutOfBoundsException("End index (" + i11 + ") is less than start index (" + i10 + ").");
    }

    public static final void B0(int i10) {
        if (i10 >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i10).toString());
    }

    public static final List C0(CharSequence charSequence, char[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            return E0(charSequence, String.valueOf(delimiters[0]), z10, i10);
        }
        Iterable iterableU = jg.t.u(t0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(dd.s.u(iterableU, 10));
        Iterator it = iterableU.iterator();
        while (it.hasNext()) {
            arrayList.add(L0(charSequence, (vd.g) it.next()));
        }
        return arrayList;
    }

    public static final List D0(CharSequence charSequence, String[] delimiters, boolean z10, int i10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (str.length() != 0) {
                return E0(charSequence, str, z10, i10);
            }
        }
        Iterable iterableU = jg.t.u(u0(charSequence, delimiters, 0, z10, i10, 2, null));
        ArrayList arrayList = new ArrayList(dd.s.u(iterableU, 10));
        Iterator it = iterableU.iterator();
        while (it.hasNext()) {
            arrayList.add(L0(charSequence, (vd.g) it.next()));
        }
        return arrayList;
    }

    public static final List E0(CharSequence charSequence, String str, boolean z10, int i10) {
        B0(i10);
        int length = 0;
        int iY = Y(charSequence, str, 0, z10);
        if (iY == -1 || i10 == 1) {
            return dd.q.e(charSequence.toString());
        }
        boolean z11 = i10 > 0;
        ArrayList arrayList = new ArrayList(z11 ? vd.l.d(i10, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iY).toString());
            length = str.length() + iY;
            if (z11 && arrayList.size() == i10 - 1) {
                break;
            }
            iY = Y(charSequence, str, length, z10);
        } while (iY != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static /* synthetic */ List F0(CharSequence charSequence, char[] cArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return C0(charSequence, cArr, z10, i10);
    }

    public static /* synthetic */ List G0(CharSequence charSequence, String[] strArr, boolean z10, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = false;
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return D0(charSequence, strArr, z10, i10);
    }

    public static final boolean H0(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        return charSequence.length() > 0 && b.d(charSequence.charAt(0), c10, z10);
    }

    public static final boolean I0(CharSequence charSequence, CharSequence prefix, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        return (!z10 && (charSequence instanceof String) && (prefix instanceof String)) ? z.J((String) charSequence, (String) prefix, false, 2, null) : x0(charSequence, 0, prefix, 0, prefix.length(), z10);
    }

    public static /* synthetic */ boolean J0(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return H0(charSequence, c10, z10);
    }

    public static /* synthetic */ boolean K0(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return I0(charSequence, charSequence2, z10);
    }

    public static final String L0(CharSequence charSequence, vd.g range) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(range, "range");
        return charSequence.subSequence(range.a().intValue(), range.c().intValue() + 1).toString();
    }

    public static final boolean M(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        return b0(charSequence, c10, 0, z10, 2, null) >= 0;
    }

    public static String M0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(missingDelimiterValue, "missingDelimiterValue");
        int iB0 = b0(str, c10, 0, false, 6, null);
        if (iB0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iB0 + 1, str.length());
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean N(CharSequence charSequence, CharSequence other, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(other, "other");
        return other instanceof String ? c0(charSequence, (String) other, 0, z10, 2, null) >= 0 : a0(charSequence, other, 0, charSequence.length(), z10, false, 16, null) >= 0;
    }

    public static String N0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(delimiter, "delimiter");
        kotlin.jvm.internal.t.f(missingDelimiterValue, "missingDelimiterValue");
        int iC0 = c0(str, delimiter, 0, false, 6, null);
        if (iC0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iC0 + delimiter.length(), str.length());
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean O(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return M(charSequence, c10, z10);
    }

    public static /* synthetic */ String O0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return M0(str, c10, str2);
    }

    public static /* synthetic */ boolean P(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return N(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String P0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return N0(str, str2, str3);
    }

    public static final boolean Q(CharSequence charSequence, char c10, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        return charSequence.length() > 0 && b.d(charSequence.charAt(W(charSequence)), c10, z10);
    }

    public static String Q0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(missingDelimiterValue, "missingDelimiterValue");
        int iH0 = h0(str, c10, 0, false, 6, null);
        if (iH0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iH0 + 1, str.length());
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final boolean R(CharSequence charSequence, CharSequence suffix, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(suffix, "suffix");
        return (!z10 && (charSequence instanceof String) && (suffix instanceof String)) ? z.x((String) charSequence, (String) suffix, false, 2, null) : x0(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z10);
    }

    public static final String R0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(delimiter, "delimiter");
        kotlin.jvm.internal.t.f(missingDelimiterValue, "missingDelimiterValue");
        int iI0 = i0(str, delimiter, 0, false, 6, null);
        if (iI0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(iI0 + delimiter.length(), str.length());
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static /* synthetic */ boolean S(CharSequence charSequence, char c10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return Q(charSequence, c10, z10);
    }

    public static /* synthetic */ String S0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return Q0(str, c10, str2);
    }

    public static /* synthetic */ boolean T(CharSequence charSequence, CharSequence charSequence2, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        return R(charSequence, charSequence2, z10);
    }

    public static /* synthetic */ String T0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return R0(str, str2, str3);
    }

    public static final cd.q U(CharSequence charSequence, Collection collection, int i10, boolean z10, boolean z11) {
        CharSequence charSequence2;
        Object next;
        boolean z12;
        Object next2;
        if (!z10 && collection.size() == 1) {
            String str = (String) dd.a0.u0(collection);
            int iC0 = !z11 ? c0(charSequence, str, i10, false, 4, null) : i0(charSequence, str, i10, false, 4, null);
            if (iC0 < 0) {
                return null;
            }
            return cd.w.a(Integer.valueOf(iC0), str);
        }
        CharSequence charSequence3 = charSequence;
        vd.e gVar = !z11 ? new vd.g(vd.l.b(i10, 0), charSequence3.length()) : vd.l.i(vd.l.d(i10, W(charSequence3)), 0);
        if (charSequence3 instanceof String) {
            int iE = gVar.e();
            int iF = gVar.f();
            int iG = gVar.g();
            if ((iG > 0 && iE <= iF) || (iG < 0 && iF <= iE)) {
                int i11 = iE;
                while (true) {
                    Iterator it = collection.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            z12 = z10;
                            next2 = null;
                            break;
                        }
                        next2 = it.next();
                        String str2 = (String) next2;
                        z12 = z10;
                        if (z.z(str2, 0, (String) charSequence3, i11, str2.length(), z12)) {
                            break;
                        }
                        z10 = z12;
                    }
                    String str3 = (String) next2;
                    if (str3 == null) {
                        if (i11 == iF) {
                            break;
                        }
                        i11 += iG;
                        z10 = z12;
                    } else {
                        return cd.w.a(Integer.valueOf(i11), str3);
                    }
                }
            }
        } else {
            boolean z13 = z10;
            int iE2 = gVar.e();
            int iF2 = gVar.f();
            int iG2 = gVar.g();
            if ((iG2 > 0 && iE2 <= iF2) || (iG2 < 0 && iF2 <= iE2)) {
                int i12 = iE2;
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
                        boolean z14 = z13;
                        charSequence2 = charSequence3;
                        z13 = z14;
                        if (x0(str4, 0, charSequence2, i12, str4.length(), z14)) {
                            break;
                        }
                        charSequence3 = charSequence2;
                    }
                    String str5 = (String) next;
                    if (str5 == null) {
                        if (i12 == iF2) {
                            break;
                        }
                        i12 += iG2;
                        charSequence3 = charSequence2;
                    } else {
                        return cd.w.a(Integer.valueOf(i12), str5);
                    }
                }
            }
        }
        return null;
    }

    public static final String U0(String str, char c10, String missingDelimiterValue) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(missingDelimiterValue, "missingDelimiterValue");
        int iB0 = b0(str, c10, 0, false, 6, null);
        if (iB0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iB0);
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static vd.g V(CharSequence charSequence) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        return new vd.g(0, charSequence.length() - 1);
    }

    public static final String V0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(delimiter, "delimiter");
        kotlin.jvm.internal.t.f(missingDelimiterValue, "missingDelimiterValue");
        int iC0 = c0(str, delimiter, 0, false, 6, null);
        if (iC0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iC0);
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static int W(CharSequence charSequence) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static /* synthetic */ String W0(String str, char c10, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = str;
        }
        return U0(str, c10, str2);
    }

    public static final int X(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? d0(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).indexOf(c10, i10);
    }

    public static /* synthetic */ String X0(String str, String str2, String str3, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str3 = str;
        }
        return V0(str, str2, str3);
    }

    public static final int Y(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(string, "string");
        return (z10 || !(charSequence instanceof String)) ? a0(charSequence, string, i10, charSequence.length(), z10, false, 16, null) : ((String) charSequence).indexOf(string, i10);
    }

    public static String Y0(String str, String delimiter, String missingDelimiterValue) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(delimiter, "delimiter");
        kotlin.jvm.internal.t.f(missingDelimiterValue, "missingDelimiterValue");
        int iI0 = i0(str, delimiter, 0, false, 6, null);
        if (iI0 == -1) {
            return missingDelimiterValue;
        }
        String strSubstring = str.substring(0, iI0);
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static final int Z(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11) {
        vd.e gVar = !z11 ? new vd.g(vd.l.b(i10, 0), vd.l.d(i11, charSequence.length())) : vd.l.i(vd.l.d(i10, W(charSequence)), vd.l.b(i11, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iE = gVar.e();
            int iF = gVar.f();
            int iG = gVar.g();
            if ((iG <= 0 || iE > iF) && (iG >= 0 || iF > iE)) {
                return -1;
            }
            int i12 = iE;
            while (true) {
                String str = (String) charSequence2;
                boolean z12 = z10;
                if (z.z(str, 0, (String) charSequence, i12, str.length(), z12)) {
                    return i12;
                }
                if (i12 == iF) {
                    return -1;
                }
                i12 += iG;
                z10 = z12;
            }
        } else {
            boolean z13 = z10;
            int iE2 = gVar.e();
            int iF2 = gVar.f();
            int iG2 = gVar.g();
            if ((iG2 <= 0 || iE2 > iF2) && (iG2 >= 0 || iF2 > iE2)) {
                return -1;
            }
            int i13 = iE2;
            while (true) {
                boolean z14 = z13;
                CharSequence charSequence3 = charSequence;
                CharSequence charSequence4 = charSequence2;
                z13 = z14;
                if (x0(charSequence4, 0, charSequence3, i13, charSequence2.length(), z14)) {
                    return i13;
                }
                if (i13 == iF2) {
                    return -1;
                }
                i13 += iG2;
                charSequence2 = charSequence4;
                charSequence = charSequence3;
            }
        }
    }

    public static Boolean Z0(String str) {
        kotlin.jvm.internal.t.f(str, "<this>");
        if (kotlin.jvm.internal.t.b(str, com.amazon.a.a.o.b.f4545af)) {
            return Boolean.TRUE;
        }
        if (kotlin.jvm.internal.t.b(str, com.amazon.a.a.o.b.f4546ag)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static /* synthetic */ int a0(CharSequence charSequence, CharSequence charSequence2, int i10, int i11, boolean z10, boolean z11, int i12, Object obj) {
        if ((i12 & 16) != 0) {
            z11 = false;
        }
        return Z(charSequence, charSequence2, i10, i11, z10, z11);
    }

    public static CharSequence a1(CharSequence charSequence) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (i10 <= length) {
            boolean zC = kg.a.c(charSequence.charAt(!z10 ? i10 : length));
            if (z10) {
                if (!zC) {
                    break;
                }
                length--;
            } else if (zC) {
                i10++;
            } else {
                z10 = true;
            }
        }
        return charSequence.subSequence(i10, length + 1);
    }

    public static /* synthetic */ int b0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return X(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int c0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return Y(charSequence, str, i10, z10);
    }

    public static final int d0(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(dd.n.m0(chars), i10);
        }
        int iB = vd.l.b(i10, 0);
        int iW = W(charSequence);
        if (iB > iW) {
            return -1;
        }
        while (true) {
            char cCharAt = charSequence.charAt(iB);
            for (char c10 : chars) {
                if (b.d(c10, cCharAt, z10)) {
                    return iB;
                }
            }
            if (iB == iW) {
                return -1;
            }
            iB++;
        }
    }

    public static boolean e0(CharSequence charSequence) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        for (int i10 = 0; i10 < charSequence.length(); i10++) {
            if (!kg.a.c(charSequence.charAt(i10))) {
                return false;
            }
        }
        return true;
    }

    public static final int f0(CharSequence charSequence, char c10, int i10, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        return (z10 || !(charSequence instanceof String)) ? j0(charSequence, new char[]{c10}, i10, z10) : ((String) charSequence).lastIndexOf(c10, i10);
    }

    public static final int g0(CharSequence charSequence, String string, int i10, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(string, "string");
        return (z10 || !(charSequence instanceof String)) ? Z(charSequence, string, i10, 0, z10, true) : ((String) charSequence).lastIndexOf(string, i10);
    }

    public static /* synthetic */ int h0(CharSequence charSequence, char c10, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = W(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return f0(charSequence, c10, i10, z10);
    }

    public static /* synthetic */ int i0(CharSequence charSequence, String str, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            i10 = W(charSequence);
        }
        if ((i11 & 4) != 0) {
            z10 = false;
        }
        return g0(charSequence, str, i10, z10);
    }

    public static final int j0(CharSequence charSequence, char[] chars, int i10, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(chars, "chars");
        if (!z10 && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(dd.n.m0(chars), i10);
        }
        for (int iD = vd.l.d(i10, W(charSequence)); -1 < iD; iD--) {
            char cCharAt = charSequence.charAt(iD);
            for (char c10 : chars) {
                if (b.d(c10, cCharAt, z10)) {
                    return iD;
                }
            }
        }
        return -1;
    }

    public static final jg.h k0(CharSequence charSequence) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        return new a(charSequence);
    }

    public static final List l0(CharSequence charSequence) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        return jg.t.M(k0(charSequence));
    }

    public static final CharSequence m0(CharSequence charSequence, int i10, char c10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        sb2.append(charSequence);
        int length = i10 - charSequence.length();
        int i11 = 1;
        if (1 <= length) {
            while (true) {
                sb2.append(c10);
                if (i11 == length) {
                    break;
                }
                i11++;
            }
        }
        return sb2;
    }

    public static final String n0(String str, int i10, char c10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        return m0(str, i10, c10).toString();
    }

    public static /* synthetic */ String o0(String str, int i10, char c10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            c10 = ' ';
        }
        return n0(str, i10, c10);
    }

    public static final CharSequence p0(CharSequence charSequence, int i10, char c10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        if (i10 < 0) {
            throw new IllegalArgumentException("Desired length " + i10 + " is less than zero.");
        }
        if (i10 <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        }
        StringBuilder sb2 = new StringBuilder(i10);
        int length = i10 - charSequence.length();
        int i11 = 1;
        if (1 <= length) {
            while (true) {
                sb2.append(c10);
                if (i11 == length) {
                    break;
                }
                i11++;
            }
        }
        sb2.append(charSequence);
        return sb2;
    }

    public static String q0(String str, int i10, char c10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        return p0(str, i10, c10).toString();
    }

    public static final jg.h r0(CharSequence charSequence, final char[] cArr, int i10, final boolean z10, int i11) {
        B0(i11);
        return new d(charSequence, i10, i11, new pd.o() { // from class: kg.a0
            @Override // pd.o
            public final Object invoke(Object obj, Object obj2) {
                return c0.v0(cArr, z10, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static final jg.h s0(CharSequence charSequence, String[] strArr, int i10, final boolean z10, int i11) {
        B0(i11);
        final List listD = dd.l.d(strArr);
        return new d(charSequence, i10, i11, new pd.o() { // from class: kg.b0
            @Override // pd.o
            public final Object invoke(Object obj, Object obj2) {
                return c0.w0(listD, z10, (CharSequence) obj, ((Integer) obj2).intValue());
            }
        });
    }

    public static /* synthetic */ jg.h t0(CharSequence charSequence, char[] cArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return r0(charSequence, cArr, i10, z10, i11);
    }

    public static /* synthetic */ jg.h u0(CharSequence charSequence, String[] strArr, int i10, boolean z10, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i10 = 0;
        }
        if ((i12 & 4) != 0) {
            z10 = false;
        }
        if ((i12 & 8) != 0) {
            i11 = 0;
        }
        return s0(charSequence, strArr, i10, z10, i11);
    }

    public static final cd.q v0(char[] cArr, boolean z10, CharSequence DelimitedRangesSequence, int i10) {
        kotlin.jvm.internal.t.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        int iD0 = d0(DelimitedRangesSequence, cArr, i10, z10);
        if (iD0 < 0) {
            return null;
        }
        return cd.w.a(Integer.valueOf(iD0), 1);
    }

    public static final cd.q w0(List list, boolean z10, CharSequence DelimitedRangesSequence, int i10) {
        kotlin.jvm.internal.t.f(DelimitedRangesSequence, "$this$DelimitedRangesSequence");
        cd.q qVarU = U(DelimitedRangesSequence, list, i10, z10, false);
        if (qVarU != null) {
            return cd.w.a(qVarU.c(), Integer.valueOf(((String) qVarU.d()).length()));
        }
        return null;
    }

    public static final boolean x0(CharSequence charSequence, int i10, CharSequence other, int i11, int i12, boolean z10) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        kotlin.jvm.internal.t.f(other, "other");
        if (i11 < 0 || i10 < 0 || i10 > charSequence.length() - i12 || i11 > other.length() - i12) {
            return false;
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (!b.d(charSequence.charAt(i10 + i13), other.charAt(i11 + i13), z10)) {
                return false;
            }
        }
        return true;
    }

    public static String y0(String str, CharSequence prefix) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(prefix, "prefix");
        if (!K0(str, prefix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(prefix.length());
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public static String z0(String str, CharSequence suffix) {
        kotlin.jvm.internal.t.f(str, "<this>");
        kotlin.jvm.internal.t.f(suffix, "suffix");
        if (!T(str, suffix, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - suffix.length());
        kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
        return strSubstring;
    }
}
