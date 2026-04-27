package Z5;

import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public abstract class w extends v {
    public static String B0(String str, int i7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (i7 >= 0) {
            String strSubstring = str.substring(W5.l.d(i7, str.length()));
            kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    public static String C0(String str, int i7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (i7 >= 0) {
            return G0(str, W5.l.b(str.length() - i7, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }

    public static char D0(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char E0(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(u.H(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char F0(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static final String G0(String str, int i7) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (i7 >= 0) {
            String strSubstring = str.substring(0, W5.l.d(i7, str.length()));
            kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i7 + " is less than zero.").toString());
    }
}
