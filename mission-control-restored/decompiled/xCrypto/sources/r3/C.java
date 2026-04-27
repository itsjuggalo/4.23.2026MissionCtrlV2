package r3;

import java.util.NoSuchElementException;
import m3.AbstractC1608c;
import o3.AbstractC1681l;

/* JADX INFO: loaded from: classes3.dex */
public abstract class C extends B {
    public static String G0(String str, int i4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (i4 >= 0) {
            String strSubstring = str.substring(AbstractC1681l.d(i4, str.length()));
            kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i4 + " is less than zero.").toString());
    }

    public static String H0(String str, int i4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (i4 >= 0) {
            return M0(str, AbstractC1681l.b(str.length() - i4, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i4 + " is less than zero.").toString());
    }

    public static char I0(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char J0(CharSequence charSequence) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(AbstractC1753A.M(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char K0(CharSequence charSequence, AbstractC1608c random) {
        kotlin.jvm.internal.r.f(charSequence, "<this>");
        kotlin.jvm.internal.r.f(random, "random");
        if (charSequence.length() != 0) {
            return charSequence.charAt(random.d(charSequence.length()));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char L0(CharSequence charSequence) {
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

    public static final String M0(String str, int i4) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (i4 >= 0) {
            String strSubstring = str.substring(0, AbstractC1681l.d(i4, str.length()));
            kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i4 + " is less than zero.").toString());
    }
}
