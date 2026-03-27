package com.revenuecat.purchases.utils;

import D.g;
import X2.AbstractC0765l;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import kotlin.jvm.internal.r;
import r3.x;

/* JADX INFO: loaded from: classes3.dex */
public final class LocaleExtensionsKt {
    public static final Locale convertToCorrectlyFormattedLocale(Locale locale) {
        r.f(locale, "<this>");
        String string = locale.toString();
        r.e(string, "toString()");
        return toLocale(string);
    }

    public static final List<Locale> getDefaultLocales() {
        g gVarD = g.d();
        r.e(gVarD, "getDefault()");
        return toList(gVarD);
    }

    private static final String inferScript(Locale locale) {
        String country;
        String script = locale.getScript();
        if (script != null && script.length() != 0) {
            String script2 = locale.getScript();
            r.e(script2, "script");
            return script2;
        }
        if (r.b(locale.getLanguage(), "zh") && (country = locale.getCountry()) != null) {
            int iHashCode = country.hashCode();
            if (iHashCode != 2155) {
                if (iHashCode != 2307) {
                    if (iHashCode != 2466) {
                        if (iHashCode != 2644) {
                            if (iHashCode == 2691 && country.equals("TW")) {
                                return "Hant";
                            }
                        } else if (country.equals("SG")) {
                            return "Hans";
                        }
                    } else if (country.equals("MO")) {
                        return "Hant";
                    }
                } else if (country.equals("HK")) {
                    return "Hant";
                }
            } else if (country.equals("CN")) {
                return "Hans";
            }
        }
        return "";
    }

    public static final boolean sharedLanguageCodeWith(Locale locale, Locale locale2) {
        r.f(locale, "<this>");
        r.f(locale2, "locale");
        try {
            return r.b(locale.getISO3Language(), locale2.getISO3Language()) && r.b(inferScript(locale), inferScript(locale2));
        } catch (MissingResourceException e4) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Locale " + locale + " or " + locale2 + " can't obtain ISO3 language code (" + e4 + "). Falling back to language.", null);
            return r.b(locale.getLanguage(), locale2.getLanguage());
        }
    }

    private static final List<Locale> toList(g gVar) {
        int iG = gVar.g();
        Locale[] localeArr = new Locale[iG];
        for (int i4 = 0; i4 < iG; i4++) {
            localeArr[i4] = gVar.c(i4);
        }
        return AbstractC0765l.t(localeArr);
    }

    public static final Locale toLocale(String str) {
        r.f(str, "<this>");
        Locale localeForLanguageTag = Locale.forLanguageTag(x.A(str, "_", "-", false, 4, null));
        r.e(localeForLanguageTag, "forLanguageTag(replace(\"_\", \"-\"))");
        return localeForLanguageTag;
    }
}
