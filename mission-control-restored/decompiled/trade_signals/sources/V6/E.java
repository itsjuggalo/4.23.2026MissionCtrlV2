package V6;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class E extends D {
    public static String O0(String str, int i8) {
        AbstractC2304t.f(str, "<this>");
        if (i8 >= 0) {
            String strSubstring = str.substring(H5.i.d(i8, str.length()));
            AbstractC2304t.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i8 + " is less than zero.").toString());
    }

    public static String P0(String str, int i8) {
        AbstractC2304t.f(str, "<this>");
        if (i8 >= 0) {
            return T0(str, H5.i.b(str.length() - i8, 0));
        }
        throw new IllegalArgumentException(("Requested character count " + i8 + " is less than zero.").toString());
    }

    public static char Q0(CharSequence charSequence) {
        AbstractC2304t.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char R0(CharSequence charSequence) {
        AbstractC2304t.f(charSequence, "<this>");
        if (charSequence.length() != 0) {
            return charSequence.charAt(C.S(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static char S0(CharSequence charSequence) {
        AbstractC2304t.f(charSequence, "<this>");
        int length = charSequence.length();
        if (length == 0) {
            throw new NoSuchElementException("Char sequence is empty.");
        }
        if (length == 1) {
            return charSequence.charAt(0);
        }
        throw new IllegalArgumentException("Char sequence has more than one element.");
    }

    public static final String T0(String str, int i8) {
        AbstractC2304t.f(str, "<this>");
        if (i8 >= 0) {
            String strSubstring = str.substring(0, H5.i.d(i8, str.length()));
            AbstractC2304t.e(strSubstring, "substring(...)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i8 + " is less than zero.").toString());
    }
}
