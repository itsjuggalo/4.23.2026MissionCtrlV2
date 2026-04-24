package Z5;

import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C {
    public static final String a(char c7) {
        String strValueOf = String.valueOf(c7);
        kotlin.jvm.internal.r.d(strValueOf, "null cannot be cast to non-null type java.lang.String");
        Locale locale = Locale.ROOT;
        String upperCase = strValueOf.toUpperCase(locale);
        kotlin.jvm.internal.r.e(upperCase, "toUpperCase(...)");
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c7));
        }
        if (c7 == 329) {
            return upperCase;
        }
        char cCharAt = upperCase.charAt(0);
        kotlin.jvm.internal.r.d(upperCase, "null cannot be cast to non-null type java.lang.String");
        String strSubstring = upperCase.substring(1);
        kotlin.jvm.internal.r.e(strSubstring, "substring(...)");
        kotlin.jvm.internal.r.d(strSubstring, "null cannot be cast to non-null type java.lang.String");
        String lowerCase = strSubstring.toLowerCase(locale);
        kotlin.jvm.internal.r.e(lowerCase, "toLowerCase(...)");
        return cCharAt + lowerCase;
    }
}
