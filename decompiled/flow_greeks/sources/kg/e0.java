package kg;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e0 extends d0 {
    public static String b1(String str, int i10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(vd.l.d(i10, str.length()));
            kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static String c1(String str, int i10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        if (i10 >= 0) {
            return g1(str, vd.l.b(str.length() - i10, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static char d1(CharSequence charSequence) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char e1(CharSequence charSequence) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(c0.W(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char f1(CharSequence charSequence) {
        kotlin.jvm.internal.t.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static String g1(String str, int i10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        if (i10 >= 0) {
            String strSubstring = str.substring(0, vd.l.d(i10, str.length()));
            kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }

    public static String h1(String str, int i10) {
        kotlin.jvm.internal.t.f(str, "<this>");
        if (i10 >= 0) {
            int length = str.length();
            String strSubstring = str.substring(length - vd.l.d(i10, length));
            kotlin.jvm.internal.t.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i10 + " is less than zero.").toString());
    }
}
