package com.revenuecat.purchases.utils;

import P.g;
import V6.A;
import com.revenuecat.purchases.common.LogWrapperKt;
import java.util.List;
import java.util.Locale;
import java.util.MissingResourceException;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0013\u0010\u0001\u001a\u00020\u0000*\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002\u001a\u0013\u0010\u0004\u001a\u00020\u0000*\u00020\u0003H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001b\u0010\b\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\n¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\r\u001a\u00020\u0003*\u00020\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a\u0019\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00000\n*\u00020\u000fH\u0002¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ljava/util/Locale;", "convertToCorrectlyFormattedLocale", "(Ljava/util/Locale;)Ljava/util/Locale;", "", "toLocale", "(Ljava/lang/String;)Ljava/util/Locale;", "locale", "", "sharedLanguageCodeWith", "(Ljava/util/Locale;Ljava/util/Locale;)Z", "", "getDefaultLocales", "()Ljava/util/List;", "inferScript", "(Ljava/util/Locale;)Ljava/lang/String;", "LP/g;", "toList", "(LP/g;)Ljava/util/List;", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0})
public final class LocaleExtensionsKt {
    public static final Locale convertToCorrectlyFormattedLocale(Locale locale) {
        AbstractC2304t.f(locale, "<this>");
        String string = locale.toString();
        AbstractC2304t.e(string, "toString()");
        return toLocale(string);
    }

    public static final List<Locale> getDefaultLocales() {
        g gVarC = g.c();
        AbstractC2304t.e(gVarC, "getDefault()");
        return toList(gVarC);
    }

    private static final String inferScript(Locale locale) {
        String country;
        String script = locale.getScript();
        if (script != null && script.length() != 0) {
            String script2 = locale.getScript();
            AbstractC2304t.e(script2, "script");
            return script2;
        }
        if (!AbstractC2304t.b(locale.getLanguage(), "zh") || (country = locale.getCountry()) == null) {
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
        AbstractC2304t.f(locale, "<this>");
        AbstractC2304t.f(locale2, "locale");
        try {
            return AbstractC2304t.b(locale.getISO3Language(), locale2.getISO3Language()) && AbstractC2304t.b(inferScript(locale), inferScript(locale2));
        } catch (MissingResourceException e8) {
            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", "Locale " + locale + " or " + locale2 + " can't obtain ISO3 language code (" + e8 + "). Falling back to language.", null);
            return AbstractC2304t.b(locale.getLanguage(), locale2.getLanguage());
        }
    }

    private static final List<Locale> toList(g gVar) {
        int iD = gVar.d();
        Locale[] localeArr = new Locale[iD];
        for (int i8 = 0; i8 < iD; i8++) {
            localeArr[i8] = gVar.b(i8);
        }
        return AbstractC2592n.A(localeArr);
    }

    public static final Locale toLocale(String str) {
        AbstractC2304t.f(str, "<this>");
        Locale localeForLanguageTag = Locale.forLanguageTag(A.E(str, "_", "-", false, 4, null));
        AbstractC2304t.e(localeForLanguageTag, "forLanguageTag(replace(\"_\", \"-\"))");
        return localeForLanguageTag;
    }
}
