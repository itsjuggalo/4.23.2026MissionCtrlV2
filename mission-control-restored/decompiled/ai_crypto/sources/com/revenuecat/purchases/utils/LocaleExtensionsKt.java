package com.revenuecat.purchases.utils;

import F5.AbstractC0552j;
import M.i;
import Z5.t;
import com.revenuecat.purchases.common.LogUtilsKt;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class LocaleExtensionsKt {
    public static final Locale convertToCorrectlyFormattedLocale(Locale locale) {
        r.f(locale, "<this>");
        String string = locale.toString();
        r.e(string, "toString()");
        return toLocale(string);
    }

    public static final List<Locale> getDefaultLocales() {
        i iVarD = i.d();
        r.e(iVarD, "getDefault()");
        return toList(iVarD);
    }

    private static final String inferScript(Locale locale) {
        String country;
        String script = locale.getScript();
        if (script != null && script.length() != 0) {
            String script2 = locale.getScript();
            r.e(script2, "script");
            return script2;
        }
        if (!r.b(locale.getLanguage(), "zh") || (country = locale.getCountry()) == null) {
            return "";
        }
        int iHashCode = country.hashCode();
        if (iHashCode != 2155) {
            if (iHashCode != 2307) {
                if (iHashCode != 2466) {
                    if (iHashCode != 2644) {
                        if (iHashCode != 2691 || !country.equals("TW")) {
                            return "";
                        }
                    } else if (!country.equals("SG")) {
                        return "";
                    }
                } else if (!country.equals("MO")) {
                    return "";
                }
            } else if (!country.equals("HK")) {
                return "";
            }
            return "Hant";
        }
        if (!country.equals("CN")) {
            return "";
        }
        return "Hans";
    }

    public static final boolean sharedLanguageCodeWith(Locale locale, Locale locale2) {
        r.f(locale, "<this>");
        r.f(locale2, "locale");
        try {
            return r.b(locale.getISO3Language(), locale2.getISO3Language()) && r.b(inferScript(locale), inferScript(locale2));
        } catch (MissingResourceException e7) {
            LogUtilsKt.errorLog$default("Locale " + locale + " or " + locale2 + " can't obtain ISO3 language code (" + e7 + "). Falling back to language.", null, 2, null);
            return r.b(locale.getLanguage(), locale2.getLanguage());
        }
    }

    private static final List<Locale> toList(i iVar) {
        int iG = iVar.g();
        Locale[] localeArr = new Locale[iG];
        for (int i7 = 0; i7 < iG; i7++) {
            localeArr[i7] = iVar.c(i7);
        }
        return AbstractC0552j.s(localeArr);
    }

    public static final Locale toLocale(String str) {
        r.f(str, "<this>");
        Locale localeForLanguageTag = Locale.forLanguageTag(t.w(str, "_", "-", false, 4, null));
        r.e(localeForLanguageTag, "forLanguageTag(replace(\"_\", \"-\"))");
        return localeForLanguageTag;
    }
}
