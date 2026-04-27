package com.revenuecat.purchases.paywalls;

import E5.o;
import E5.t;
import F5.AbstractC0556n;
import F5.J;
import F5.v;
import com.revenuecat.purchases.paywalls.PaywallColor;
import com.revenuecat.purchases.utils.LocaleExtensionsKt;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.OptionalURLSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import n6.b;
import p6.e;
import q6.d;
import r6.AbstractC2611a0;
import r6.C2618e;
import r6.K;
import r6.k0;
import r6.o0;

/* JADX INFO: loaded from: classes2.dex */
public final class PaywallData {
    private static final b[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final URL assetBaseURL;
    private final Configuration config;
    private final String defaultLocale;
    private final Map<String, LocalizedConfiguration> localization;
    private final Map<String, Map<String, LocalizedConfiguration>> localizationByTier;
    private final int revision;
    private final String templateName;
    private final List<String> zeroDecimalPlaceCountries;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        public final b serializer() {
            return PaywallData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        o0 o0Var = o0.f22909a;
        PaywallData$LocalizedConfiguration$$serializer paywallData$LocalizedConfiguration$$serializer = PaywallData$LocalizedConfiguration$$serializer.INSTANCE;
        $childSerializers = new b[]{null, null, null, null, new K(o0Var, paywallData$LocalizedConfiguration$$serializer), new K(o0Var, new K(o0Var, paywallData$LocalizedConfiguration$$serializer)), null, null};
    }

    public /* synthetic */ PaywallData(int i7, String str, Configuration configuration, URL url, int i8, Map map, Map map2, List list, String str2, k0 k0Var) {
        if (23 != (i7 & 23)) {
            AbstractC2611a0.a(i7, 23, PaywallData$$serializer.INSTANCE.getDescriptor());
        }
        this.templateName = str;
        this.config = configuration;
        this.assetBaseURL = url;
        if ((i7 & 8) == 0) {
            this.revision = 0;
        } else {
            this.revision = i8;
        }
        this.localization = map;
        if ((i7 & 32) == 0) {
            this.localizationByTier = J.e();
        } else {
            this.localizationByTier = map2;
        }
        if ((i7 & 64) == 0) {
            this.zeroDecimalPlaceCountries = AbstractC0556n.g();
        } else {
            this.zeroDecimalPlaceCountries = list;
        }
        if ((i7 & 128) == 0) {
            this.defaultLocale = null;
        } else {
            this.defaultLocale = str2;
        }
    }

    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    public static /* synthetic */ void getDefaultLocale$annotations() {
    }

    public static /* synthetic */ void getLocalization$purchases_defaultsRelease$annotations() {
    }

    public static /* synthetic */ void getLocalizationByTier$purchases_defaultsRelease$annotations() {
    }

    public static /* synthetic */ void getTemplateName$annotations() {
    }

    public static /* synthetic */ void getZeroDecimalPlaceCountries$annotations() {
    }

    private final o tieredConfigForLocales(List<Locale> list) {
        Object next;
        Iterator<Locale> it = list.iterator();
        while (it.hasNext()) {
            Locale localeConvertToCorrectlyFormattedLocale = LocaleExtensionsKt.convertToCorrectlyFormattedLocale(it.next());
            Map<String, LocalizedConfiguration> mapTieredConfigForLocale = tieredConfigForLocale(localeConvertToCorrectlyFormattedLocale);
            if (mapTieredConfigForLocale != null) {
                return t.a(localeConvertToCorrectlyFormattedLocale, mapTieredConfigForLocale);
            }
        }
        String str = this.defaultLocale;
        if (str != null) {
            Iterator<T> it2 = this.localizationByTier.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (r.b(LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()), LocaleExtensionsKt.toLocale(str))) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                return t.a(LocaleExtensionsKt.toLocale((String) entry.getKey()), entry.getValue());
            }
        }
        Map.Entry entry2 = (Map.Entry) v.H(this.localizationByTier.entrySet());
        return t.a(LocaleExtensionsKt.toLocale((String) entry2.getKey()), entry2.getValue());
    }

    public static final /* synthetic */ void write$Self(PaywallData paywallData, d dVar, e eVar) {
        b[] bVarArr = $childSerializers;
        dVar.m(eVar, 0, paywallData.templateName);
        dVar.x(eVar, 1, PaywallData$Configuration$$serializer.INSTANCE, paywallData.config);
        dVar.x(eVar, 2, URLSerializer.INSTANCE, paywallData.assetBaseURL);
        if (dVar.C(eVar, 3) || paywallData.revision != 0) {
            dVar.t(eVar, 3, paywallData.revision);
        }
        dVar.x(eVar, 4, bVarArr[4], paywallData.localization);
        if (dVar.C(eVar, 5) || !r.b(paywallData.localizationByTier, J.e())) {
            dVar.x(eVar, 5, bVarArr[5], paywallData.localizationByTier);
        }
        if (dVar.C(eVar, 6) || !r.b(paywallData.zeroDecimalPlaceCountries, AbstractC0556n.g())) {
            dVar.x(eVar, 6, GoogleListSerializer.INSTANCE, paywallData.zeroDecimalPlaceCountries);
        }
        if (!dVar.C(eVar, 7) && paywallData.defaultLocale == null) {
            return;
        }
        dVar.r(eVar, 7, o0.f22909a, paywallData.defaultLocale);
    }

    public final String component1() {
        return this.templateName;
    }

    public final Configuration component2() {
        return this.config;
    }

    public final URL component3() {
        return this.assetBaseURL;
    }

    public final int component4() {
        return this.revision;
    }

    public final Map<String, LocalizedConfiguration> component5$purchases_defaultsRelease() {
        return this.localization;
    }

    public final Map<String, Map<String, LocalizedConfiguration>> component6$purchases_defaultsRelease() {
        return this.localizationByTier;
    }

    public final List<String> component7() {
        return this.zeroDecimalPlaceCountries;
    }

    public final String component8() {
        return this.defaultLocale;
    }

    public final LocalizedConfiguration configForLocale(Locale requiredLocale) {
        Object next;
        r.f(requiredLocale, "requiredLocale");
        LocalizedConfiguration localizedConfiguration = this.localization.get(requiredLocale.toString());
        if (localizedConfiguration != null) {
            return localizedConfiguration;
        }
        Iterator<T> it = this.localization.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (LocaleExtensionsKt.sharedLanguageCodeWith(requiredLocale, LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()))) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (LocalizedConfiguration) entry.getValue();
        }
        return null;
    }

    public final PaywallData copy(String templateName, Configuration config, URL assetBaseURL, int i7, Map<String, LocalizedConfiguration> localization, Map<String, ? extends Map<String, LocalizedConfiguration>> localizationByTier, List<String> zeroDecimalPlaceCountries, String str) {
        r.f(templateName, "templateName");
        r.f(config, "config");
        r.f(assetBaseURL, "assetBaseURL");
        r.f(localization, "localization");
        r.f(localizationByTier, "localizationByTier");
        r.f(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        return new PaywallData(templateName, config, assetBaseURL, i7, localization, localizationByTier, zeroDecimalPlaceCountries, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallData)) {
            return false;
        }
        PaywallData paywallData = (PaywallData) obj;
        return r.b(this.templateName, paywallData.templateName) && r.b(this.config, paywallData.config) && r.b(this.assetBaseURL, paywallData.assetBaseURL) && this.revision == paywallData.revision && r.b(this.localization, paywallData.localization) && r.b(this.localizationByTier, paywallData.localizationByTier) && r.b(this.zeroDecimalPlaceCountries, paywallData.zeroDecimalPlaceCountries) && r.b(this.defaultLocale, paywallData.defaultLocale);
    }

    public final URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final Configuration getConfig() {
        return this.config;
    }

    public final String getDefaultLocale() {
        return this.defaultLocale;
    }

    public final Map<String, LocalizedConfiguration> getLocalization$purchases_defaultsRelease() {
        return this.localization;
    }

    public final Map<String, Map<String, LocalizedConfiguration>> getLocalizationByTier$purchases_defaultsRelease() {
        return this.localizationByTier;
    }

    public final o getLocalizedConfiguration() {
        return localizedConfiguration(LocaleExtensionsKt.getDefaultLocales());
    }

    public final int getRevision() {
        return this.revision;
    }

    public final String getTemplateName() {
        return this.templateName;
    }

    public final o getTieredLocalizedConfiguration() {
        return tieredConfigForLocales(LocaleExtensionsKt.getDefaultLocales());
    }

    public final List<String> getZeroDecimalPlaceCountries() {
        return this.zeroDecimalPlaceCountries;
    }

    public int hashCode() {
        int iHashCode = ((((((((((((this.templateName.hashCode() * 31) + this.config.hashCode()) * 31) + this.assetBaseURL.hashCode()) * 31) + Integer.hashCode(this.revision)) * 31) + this.localization.hashCode()) * 31) + this.localizationByTier.hashCode()) * 31) + this.zeroDecimalPlaceCountries.hashCode()) * 31;
        String str = this.defaultLocale;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final o localizedConfiguration(List<Locale> locales) {
        Object next;
        r.f(locales, "locales");
        Iterator<Locale> it = locales.iterator();
        while (it.hasNext()) {
            Locale localeConvertToCorrectlyFormattedLocale = LocaleExtensionsKt.convertToCorrectlyFormattedLocale(it.next());
            LocalizedConfiguration localizedConfigurationConfigForLocale = configForLocale(localeConvertToCorrectlyFormattedLocale);
            if (localizedConfigurationConfigForLocale != null) {
                return t.a(localeConvertToCorrectlyFormattedLocale, localizedConfigurationConfigForLocale);
            }
        }
        String str = this.defaultLocale;
        if (str != null) {
            Iterator<T> it2 = this.localization.entrySet().iterator();
            while (true) {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                }
                next = it2.next();
                if (r.b(LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()), LocaleExtensionsKt.toLocale(str))) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) next;
            if (entry != null) {
                return t.a(LocaleExtensionsKt.toLocale((String) entry.getKey()), entry.getValue());
            }
        }
        Map.Entry entry2 = (Map.Entry) v.H(this.localization.entrySet());
        return t.a(LocaleExtensionsKt.toLocale((String) entry2.getKey()), entry2.getValue());
    }

    public final Map<String, LocalizedConfiguration> tieredConfigForLocale(Locale requiredLocale) {
        Object next;
        r.f(requiredLocale, "requiredLocale");
        Map<String, LocalizedConfiguration> map = this.localizationByTier.get(requiredLocale.toString());
        if (map != null) {
            return map;
        }
        Iterator<T> it = this.localizationByTier.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (LocaleExtensionsKt.sharedLanguageCodeWith(requiredLocale, LocaleExtensionsKt.toLocale((String) ((Map.Entry) next).getKey()))) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) next;
        if (entry != null) {
            return (Map) entry.getValue();
        }
        return null;
    }

    public String toString() {
        return "PaywallData(templateName=" + this.templateName + ", config=" + this.config + ", assetBaseURL=" + this.assetBaseURL + ", revision=" + this.revision + ", localization=" + this.localization + ", localizationByTier=" + this.localizationByTier + ", zeroDecimalPlaceCountries=" + this.zeroDecimalPlaceCountries + ", defaultLocale=" + this.defaultLocale + ')';
    }

    public static final class Configuration {
        private static final b[] $childSerializers;
        public static final Companion Companion = new Companion(null);
        private final boolean blurredBackgroundImage;
        private final ColorInformation colors;
        private final Map<String, ColorInformation> colorsByTier;
        private final String defaultPackage;
        private final String defaultTier;
        private final boolean displayRestorePurchases;
        private final Map<String, Images> imagesByTier;
        private final Images imagesWebp;
        private final Images legacyImages;
        private final List<String> packageIds;
        private final URL privacyURL;
        private final URL termsOfServiceURL;
        private final List<Tier> tiers;

        public static final class ColorInformation {
            public static final Companion Companion = new Companion(null);
            private final Colors dark;
            private final Colors light;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return PaywallData$Configuration$ColorInformation$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ ColorInformation(int i7, Colors colors, Colors colors2, k0 k0Var) {
                if (1 != (i7 & 1)) {
                    AbstractC2611a0.a(i7, 1, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE.getDescriptor());
                }
                this.light = colors;
                if ((i7 & 2) == 0) {
                    this.dark = null;
                } else {
                    this.dark = colors2;
                }
            }

            public static /* synthetic */ ColorInformation copy$default(ColorInformation colorInformation, Colors colors, Colors colors2, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    colors = colorInformation.light;
                }
                if ((i7 & 2) != 0) {
                    colors2 = colorInformation.dark;
                }
                return colorInformation.copy(colors, colors2);
            }

            public static final /* synthetic */ void write$Self(ColorInformation colorInformation, d dVar, e eVar) {
                PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = PaywallData$Configuration$Colors$$serializer.INSTANCE;
                dVar.x(eVar, 0, paywallData$Configuration$Colors$$serializer, colorInformation.light);
                if (!dVar.C(eVar, 1) && colorInformation.dark == null) {
                    return;
                }
                dVar.r(eVar, 1, paywallData$Configuration$Colors$$serializer, colorInformation.dark);
            }

            public final Colors component1() {
                return this.light;
            }

            public final Colors component2() {
                return this.dark;
            }

            public final ColorInformation copy(Colors light, Colors colors) {
                r.f(light, "light");
                return new ColorInformation(light, colors);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof ColorInformation)) {
                    return false;
                }
                ColorInformation colorInformation = (ColorInformation) obj;
                return r.b(this.light, colorInformation.light) && r.b(this.dark, colorInformation.dark);
            }

            public final Colors getDark() {
                return this.dark;
            }

            public final Colors getLight() {
                return this.light;
            }

            public int hashCode() {
                int iHashCode = this.light.hashCode() * 31;
                Colors colors = this.dark;
                return iHashCode + (colors == null ? 0 : colors.hashCode());
            }

            public String toString() {
                return "ColorInformation(light=" + this.light + ", dark=" + this.dark + ')';
            }

            public ColorInformation(Colors light, Colors colors) {
                r.f(light, "light");
                this.light = light;
                this.dark = colors;
            }

            public /* synthetic */ ColorInformation(Colors colors, Colors colors2, int i7, AbstractC2148j abstractC2148j) {
                this(colors, (i7 & 2) != 0 ? null : colors2);
            }
        }

        public static final class Colors {
            public static final Companion Companion = new Companion(null);
            private final PaywallColor accent1;
            private final PaywallColor accent2;
            private final PaywallColor accent3;
            private final PaywallColor background;
            private final PaywallColor callToActionBackground;
            private final PaywallColor callToActionForeground;
            private final PaywallColor callToActionSecondaryBackground;
            private final PaywallColor closeButton;
            private final PaywallColor text1;
            private final PaywallColor text2;
            private final PaywallColor text3;
            private final PaywallColor tierControlBackground;
            private final PaywallColor tierControlForeground;
            private final PaywallColor tierControlSelectedBackground;
            private final PaywallColor tierControlSelectedForeground;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return PaywallData$Configuration$Colors$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Colors(int i7, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, PaywallColor paywallColor11, PaywallColor paywallColor12, PaywallColor paywallColor13, PaywallColor paywallColor14, PaywallColor paywallColor15, k0 k0Var) {
                if (51 != (i7 & 51)) {
                    AbstractC2611a0.a(i7, 51, PaywallData$Configuration$Colors$$serializer.INSTANCE.getDescriptor());
                }
                this.background = paywallColor;
                this.text1 = paywallColor2;
                if ((i7 & 4) == 0) {
                    this.text2 = null;
                } else {
                    this.text2 = paywallColor3;
                }
                if ((i7 & 8) == 0) {
                    this.text3 = null;
                } else {
                    this.text3 = paywallColor4;
                }
                this.callToActionBackground = paywallColor5;
                this.callToActionForeground = paywallColor6;
                if ((i7 & 64) == 0) {
                    this.callToActionSecondaryBackground = null;
                } else {
                    this.callToActionSecondaryBackground = paywallColor7;
                }
                if ((i7 & 128) == 0) {
                    this.accent1 = null;
                } else {
                    this.accent1 = paywallColor8;
                }
                if ((i7 & 256) == 0) {
                    this.accent2 = null;
                } else {
                    this.accent2 = paywallColor9;
                }
                if ((i7 & 512) == 0) {
                    this.accent3 = null;
                } else {
                    this.accent3 = paywallColor10;
                }
                if ((i7 & 1024) == 0) {
                    this.closeButton = null;
                } else {
                    this.closeButton = paywallColor11;
                }
                if ((i7 & 2048) == 0) {
                    this.tierControlBackground = null;
                } else {
                    this.tierControlBackground = paywallColor12;
                }
                if ((i7 & 4096) == 0) {
                    this.tierControlForeground = null;
                } else {
                    this.tierControlForeground = paywallColor13;
                }
                if ((i7 & 8192) == 0) {
                    this.tierControlSelectedBackground = null;
                } else {
                    this.tierControlSelectedBackground = paywallColor14;
                }
                if ((i7 & 16384) == 0) {
                    this.tierControlSelectedForeground = null;
                } else {
                    this.tierControlSelectedForeground = paywallColor15;
                }
            }

            public static /* synthetic */ void getAccent1$annotations() {
            }

            public static /* synthetic */ void getAccent2$annotations() {
            }

            public static /* synthetic */ void getAccent3$annotations() {
            }

            public static /* synthetic */ void getBackground$annotations() {
            }

            public static /* synthetic */ void getCallToActionBackground$annotations() {
            }

            public static /* synthetic */ void getCallToActionForeground$annotations() {
            }

            public static /* synthetic */ void getCallToActionSecondaryBackground$annotations() {
            }

            public static /* synthetic */ void getCloseButton$annotations() {
            }

            public static /* synthetic */ void getText1$annotations() {
            }

            public static /* synthetic */ void getText2$annotations() {
            }

            public static /* synthetic */ void getText3$annotations() {
            }

            public static /* synthetic */ void getTierControlBackground$annotations() {
            }

            public static /* synthetic */ void getTierControlForeground$annotations() {
            }

            public static /* synthetic */ void getTierControlSelectedBackground$annotations() {
            }

            public static /* synthetic */ void getTierControlSelectedForeground$annotations() {
            }

            public static final /* synthetic */ void write$Self(Colors colors, d dVar, e eVar) {
                PaywallColor.Serializer serializer = PaywallColor.Serializer.INSTANCE;
                dVar.x(eVar, 0, serializer, colors.background);
                dVar.x(eVar, 1, serializer, colors.text1);
                if (dVar.C(eVar, 2) || colors.text2 != null) {
                    dVar.r(eVar, 2, serializer, colors.text2);
                }
                if (dVar.C(eVar, 3) || colors.text3 != null) {
                    dVar.r(eVar, 3, serializer, colors.text3);
                }
                dVar.x(eVar, 4, serializer, colors.callToActionBackground);
                dVar.x(eVar, 5, serializer, colors.callToActionForeground);
                if (dVar.C(eVar, 6) || colors.callToActionSecondaryBackground != null) {
                    dVar.r(eVar, 6, serializer, colors.callToActionSecondaryBackground);
                }
                if (dVar.C(eVar, 7) || colors.accent1 != null) {
                    dVar.r(eVar, 7, serializer, colors.accent1);
                }
                if (dVar.C(eVar, 8) || colors.accent2 != null) {
                    dVar.r(eVar, 8, serializer, colors.accent2);
                }
                if (dVar.C(eVar, 9) || colors.accent3 != null) {
                    dVar.r(eVar, 9, serializer, colors.accent3);
                }
                if (dVar.C(eVar, 10) || colors.closeButton != null) {
                    dVar.r(eVar, 10, serializer, colors.closeButton);
                }
                if (dVar.C(eVar, 11) || colors.tierControlBackground != null) {
                    dVar.r(eVar, 11, serializer, colors.tierControlBackground);
                }
                if (dVar.C(eVar, 12) || colors.tierControlForeground != null) {
                    dVar.r(eVar, 12, serializer, colors.tierControlForeground);
                }
                if (dVar.C(eVar, 13) || colors.tierControlSelectedBackground != null) {
                    dVar.r(eVar, 13, serializer, colors.tierControlSelectedBackground);
                }
                if (!dVar.C(eVar, 14) && colors.tierControlSelectedForeground == null) {
                    return;
                }
                dVar.r(eVar, 14, serializer, colors.tierControlSelectedForeground);
            }

            public final PaywallColor component1() {
                return this.background;
            }

            public final PaywallColor component10() {
                return this.accent3;
            }

            public final PaywallColor component11() {
                return this.closeButton;
            }

            public final PaywallColor component12() {
                return this.tierControlBackground;
            }

            public final PaywallColor component13() {
                return this.tierControlForeground;
            }

            public final PaywallColor component14() {
                return this.tierControlSelectedBackground;
            }

            public final PaywallColor component15() {
                return this.tierControlSelectedForeground;
            }

            public final PaywallColor component2() {
                return this.text1;
            }

            public final PaywallColor component3() {
                return this.text2;
            }

            public final PaywallColor component4() {
                return this.text3;
            }

            public final PaywallColor component5() {
                return this.callToActionBackground;
            }

            public final PaywallColor component6() {
                return this.callToActionForeground;
            }

            public final PaywallColor component7() {
                return this.callToActionSecondaryBackground;
            }

            public final PaywallColor component8() {
                return this.accent1;
            }

            public final PaywallColor component9() {
                return this.accent2;
            }

            public final Colors copy(PaywallColor background, PaywallColor text1, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor callToActionBackground, PaywallColor callToActionForeground, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, PaywallColor paywallColor11) {
                r.f(background, "background");
                r.f(text1, "text1");
                r.f(callToActionBackground, "callToActionBackground");
                r.f(callToActionForeground, "callToActionForeground");
                return new Colors(background, text1, paywallColor, paywallColor2, callToActionBackground, callToActionForeground, paywallColor3, paywallColor4, paywallColor5, paywallColor6, paywallColor7, paywallColor8, paywallColor9, paywallColor10, paywallColor11);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Colors)) {
                    return false;
                }
                Colors colors = (Colors) obj;
                return r.b(this.background, colors.background) && r.b(this.text1, colors.text1) && r.b(this.text2, colors.text2) && r.b(this.text3, colors.text3) && r.b(this.callToActionBackground, colors.callToActionBackground) && r.b(this.callToActionForeground, colors.callToActionForeground) && r.b(this.callToActionSecondaryBackground, colors.callToActionSecondaryBackground) && r.b(this.accent1, colors.accent1) && r.b(this.accent2, colors.accent2) && r.b(this.accent3, colors.accent3) && r.b(this.closeButton, colors.closeButton) && r.b(this.tierControlBackground, colors.tierControlBackground) && r.b(this.tierControlForeground, colors.tierControlForeground) && r.b(this.tierControlSelectedBackground, colors.tierControlSelectedBackground) && r.b(this.tierControlSelectedForeground, colors.tierControlSelectedForeground);
            }

            public final PaywallColor getAccent1() {
                return this.accent1;
            }

            public final PaywallColor getAccent2() {
                return this.accent2;
            }

            public final PaywallColor getAccent3() {
                return this.accent3;
            }

            public final PaywallColor getBackground() {
                return this.background;
            }

            public final PaywallColor getCallToActionBackground() {
                return this.callToActionBackground;
            }

            public final PaywallColor getCallToActionForeground() {
                return this.callToActionForeground;
            }

            public final PaywallColor getCallToActionSecondaryBackground() {
                return this.callToActionSecondaryBackground;
            }

            public final PaywallColor getCloseButton() {
                return this.closeButton;
            }

            public final PaywallColor getText1() {
                return this.text1;
            }

            public final PaywallColor getText2() {
                return this.text2;
            }

            public final PaywallColor getText3() {
                return this.text3;
            }

            public final PaywallColor getTierControlBackground() {
                return this.tierControlBackground;
            }

            public final PaywallColor getTierControlForeground() {
                return this.tierControlForeground;
            }

            public final PaywallColor getTierControlSelectedBackground() {
                return this.tierControlSelectedBackground;
            }

            public final PaywallColor getTierControlSelectedForeground() {
                return this.tierControlSelectedForeground;
            }

            public int hashCode() {
                int iHashCode = ((this.background.hashCode() * 31) + this.text1.hashCode()) * 31;
                PaywallColor paywallColor = this.text2;
                int iHashCode2 = (iHashCode + (paywallColor == null ? 0 : paywallColor.hashCode())) * 31;
                PaywallColor paywallColor2 = this.text3;
                int iHashCode3 = (((((iHashCode2 + (paywallColor2 == null ? 0 : paywallColor2.hashCode())) * 31) + this.callToActionBackground.hashCode()) * 31) + this.callToActionForeground.hashCode()) * 31;
                PaywallColor paywallColor3 = this.callToActionSecondaryBackground;
                int iHashCode4 = (iHashCode3 + (paywallColor3 == null ? 0 : paywallColor3.hashCode())) * 31;
                PaywallColor paywallColor4 = this.accent1;
                int iHashCode5 = (iHashCode4 + (paywallColor4 == null ? 0 : paywallColor4.hashCode())) * 31;
                PaywallColor paywallColor5 = this.accent2;
                int iHashCode6 = (iHashCode5 + (paywallColor5 == null ? 0 : paywallColor5.hashCode())) * 31;
                PaywallColor paywallColor6 = this.accent3;
                int iHashCode7 = (iHashCode6 + (paywallColor6 == null ? 0 : paywallColor6.hashCode())) * 31;
                PaywallColor paywallColor7 = this.closeButton;
                int iHashCode8 = (iHashCode7 + (paywallColor7 == null ? 0 : paywallColor7.hashCode())) * 31;
                PaywallColor paywallColor8 = this.tierControlBackground;
                int iHashCode9 = (iHashCode8 + (paywallColor8 == null ? 0 : paywallColor8.hashCode())) * 31;
                PaywallColor paywallColor9 = this.tierControlForeground;
                int iHashCode10 = (iHashCode9 + (paywallColor9 == null ? 0 : paywallColor9.hashCode())) * 31;
                PaywallColor paywallColor10 = this.tierControlSelectedBackground;
                int iHashCode11 = (iHashCode10 + (paywallColor10 == null ? 0 : paywallColor10.hashCode())) * 31;
                PaywallColor paywallColor11 = this.tierControlSelectedForeground;
                return iHashCode11 + (paywallColor11 != null ? paywallColor11.hashCode() : 0);
            }

            public String toString() {
                return "Colors(background=" + this.background + ", text1=" + this.text1 + ", text2=" + this.text2 + ", text3=" + this.text3 + ", callToActionBackground=" + this.callToActionBackground + ", callToActionForeground=" + this.callToActionForeground + ", callToActionSecondaryBackground=" + this.callToActionSecondaryBackground + ", accent1=" + this.accent1 + ", accent2=" + this.accent2 + ", accent3=" + this.accent3 + ", closeButton=" + this.closeButton + ", tierControlBackground=" + this.tierControlBackground + ", tierControlForeground=" + this.tierControlForeground + ", tierControlSelectedBackground=" + this.tierControlSelectedBackground + ", tierControlSelectedForeground=" + this.tierControlSelectedForeground + ')';
            }

            public Colors(PaywallColor background, PaywallColor text1, PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor callToActionBackground, PaywallColor callToActionForeground, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, PaywallColor paywallColor11) {
                r.f(background, "background");
                r.f(text1, "text1");
                r.f(callToActionBackground, "callToActionBackground");
                r.f(callToActionForeground, "callToActionForeground");
                this.background = background;
                this.text1 = text1;
                this.text2 = paywallColor;
                this.text3 = paywallColor2;
                this.callToActionBackground = callToActionBackground;
                this.callToActionForeground = callToActionForeground;
                this.callToActionSecondaryBackground = paywallColor3;
                this.accent1 = paywallColor4;
                this.accent2 = paywallColor5;
                this.accent3 = paywallColor6;
                this.closeButton = paywallColor7;
                this.tierControlBackground = paywallColor8;
                this.tierControlForeground = paywallColor9;
                this.tierControlSelectedBackground = paywallColor10;
                this.tierControlSelectedForeground = paywallColor11;
            }

            public /* synthetic */ Colors(PaywallColor paywallColor, PaywallColor paywallColor2, PaywallColor paywallColor3, PaywallColor paywallColor4, PaywallColor paywallColor5, PaywallColor paywallColor6, PaywallColor paywallColor7, PaywallColor paywallColor8, PaywallColor paywallColor9, PaywallColor paywallColor10, PaywallColor paywallColor11, PaywallColor paywallColor12, PaywallColor paywallColor13, PaywallColor paywallColor14, PaywallColor paywallColor15, int i7, AbstractC2148j abstractC2148j) {
                this(paywallColor, paywallColor2, (i7 & 4) != 0 ? null : paywallColor3, (i7 & 8) != 0 ? null : paywallColor4, paywallColor5, paywallColor6, (i7 & 64) != 0 ? null : paywallColor7, (i7 & 128) != 0 ? null : paywallColor8, (i7 & 256) != 0 ? null : paywallColor9, (i7 & 512) != 0 ? null : paywallColor10, (i7 & 1024) != 0 ? null : paywallColor11, (i7 & 2048) != 0 ? null : paywallColor12, (i7 & 4096) != 0 ? null : paywallColor13, (i7 & 8192) != 0 ? null : paywallColor14, (i7 & 16384) != 0 ? null : paywallColor15);
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            public final b serializer() {
                return PaywallData$Configuration$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public static final class Images {
            public static final Companion Companion = new Companion(null);
            private final String background;
            private final String header;
            private final String icon;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return PaywallData$Configuration$Images$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public Images() {
                this((String) null, (String) null, (String) null, 7, (AbstractC2148j) null);
            }

            public static /* synthetic */ Images copy$default(Images images, String str, String str2, String str3, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    str = images.header;
                }
                if ((i7 & 2) != 0) {
                    str2 = images.background;
                }
                if ((i7 & 4) != 0) {
                    str3 = images.icon;
                }
                return images.copy(str, str2, str3);
            }

            public static /* synthetic */ void getBackground$annotations() {
            }

            public static /* synthetic */ void getHeader$annotations() {
            }

            public static /* synthetic */ void getIcon$annotations() {
            }

            public static final /* synthetic */ void write$Self(Images images, d dVar, e eVar) {
                if (dVar.C(eVar, 0) || images.header != null) {
                    dVar.r(eVar, 0, EmptyStringToNullSerializer.INSTANCE, images.header);
                }
                if (dVar.C(eVar, 1) || images.background != null) {
                    dVar.r(eVar, 1, EmptyStringToNullSerializer.INSTANCE, images.background);
                }
                if (!dVar.C(eVar, 2) && images.icon == null) {
                    return;
                }
                dVar.r(eVar, 2, EmptyStringToNullSerializer.INSTANCE, images.icon);
            }

            public final String component1() {
                return this.header;
            }

            public final String component2() {
                return this.background;
            }

            public final String component3() {
                return this.icon;
            }

            public final Images copy(String str, String str2, String str3) {
                return new Images(str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Images)) {
                    return false;
                }
                Images images = (Images) obj;
                return r.b(this.header, images.header) && r.b(this.background, images.background) && r.b(this.icon, images.icon);
            }

            public final List<String> getAll$purchases_defaultsRelease() {
                return AbstractC0556n.l(this.header, this.background, this.icon);
            }

            public final String getBackground() {
                return this.background;
            }

            public final String getHeader() {
                return this.header;
            }

            public final String getIcon() {
                return this.icon;
            }

            public int hashCode() {
                String str = this.header;
                int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
                String str2 = this.background;
                int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.icon;
                return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "Images(header=" + this.header + ", background=" + this.background + ", icon=" + this.icon + ')';
            }

            public /* synthetic */ Images(int i7, String str, String str2, String str3, k0 k0Var) {
                if ((i7 & 1) == 0) {
                    this.header = null;
                } else {
                    this.header = str;
                }
                if ((i7 & 2) == 0) {
                    this.background = null;
                } else {
                    this.background = str2;
                }
                if ((i7 & 4) == 0) {
                    this.icon = null;
                } else {
                    this.icon = str3;
                }
            }

            public Images(String str, String str2, String str3) {
                this.header = str;
                this.background = str2;
                this.icon = str3;
            }

            public /* synthetic */ Images(String str, String str2, String str3, int i7, AbstractC2148j abstractC2148j) {
                this((i7 & 1) != 0 ? null : str, (i7 & 2) != 0 ? null : str2, (i7 & 4) != 0 ? null : str3);
            }
        }

        public static final class Tier {
            private final String defaultPackageId;
            private final String id;
            private final List<String> packageIds;
            public static final Companion Companion = new Companion(null);
            private static final b[] $childSerializers = {null, new C2618e(o0.f22909a), null};

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return PaywallData$Configuration$Tier$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Tier(int i7, String str, List list, String str2, k0 k0Var) {
                if (7 != (i7 & 7)) {
                    AbstractC2611a0.a(i7, 7, PaywallData$Configuration$Tier$$serializer.INSTANCE.getDescriptor());
                }
                this.id = str;
                this.packageIds = list;
                this.defaultPackageId = str2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Tier copy$default(Tier tier, String str, List list, String str2, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    str = tier.id;
                }
                if ((i7 & 2) != 0) {
                    list = tier.packageIds;
                }
                if ((i7 & 4) != 0) {
                    str2 = tier.defaultPackageId;
                }
                return tier.copy(str, list, str2);
            }

            public static /* synthetic */ void getDefaultPackageId$annotations() {
            }

            public static /* synthetic */ void getPackageIds$annotations() {
            }

            public static final /* synthetic */ void write$Self(Tier tier, d dVar, e eVar) {
                b[] bVarArr = $childSerializers;
                dVar.m(eVar, 0, tier.id);
                dVar.x(eVar, 1, bVarArr[1], tier.packageIds);
                dVar.m(eVar, 2, tier.defaultPackageId);
            }

            public final String component1() {
                return this.id;
            }

            public final List<String> component2() {
                return this.packageIds;
            }

            public final String component3() {
                return this.defaultPackageId;
            }

            public final Tier copy(String id, List<String> packageIds, String defaultPackageId) {
                r.f(id, "id");
                r.f(packageIds, "packageIds");
                r.f(defaultPackageId, "defaultPackageId");
                return new Tier(id, packageIds, defaultPackageId);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Tier)) {
                    return false;
                }
                Tier tier = (Tier) obj;
                return r.b(this.id, tier.id) && r.b(this.packageIds, tier.packageIds) && r.b(this.defaultPackageId, tier.defaultPackageId);
            }

            public final String getDefaultPackageId() {
                return this.defaultPackageId;
            }

            public final String getId() {
                return this.id;
            }

            public final List<String> getPackageIds() {
                return this.packageIds;
            }

            public int hashCode() {
                return (((this.id.hashCode() * 31) + this.packageIds.hashCode()) * 31) + this.defaultPackageId.hashCode();
            }

            public String toString() {
                return "Tier(id=" + this.id + ", packageIds=" + this.packageIds + ", defaultPackageId=" + this.defaultPackageId + ')';
            }

            public Tier(String id, List<String> packageIds, String defaultPackageId) {
                r.f(id, "id");
                r.f(packageIds, "packageIds");
                r.f(defaultPackageId, "defaultPackageId");
                this.id = id;
                this.packageIds = packageIds;
                this.defaultPackageId = defaultPackageId;
            }
        }

        static {
            o0 o0Var = o0.f22909a;
            $childSerializers = new b[]{new C2618e(o0Var), null, null, null, new K(o0Var, PaywallData$Configuration$Images$$serializer.INSTANCE), null, null, null, null, null, new K(o0Var, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE), new C2618e(PaywallData$Configuration$Tier$$serializer.INSTANCE), null};
        }

        public /* synthetic */ Configuration(int i7, List list, String str, Images images, Images images2, Map map, boolean z7, boolean z8, URL url, URL url2, ColorInformation colorInformation, Map map2, List list2, String str2, k0 k0Var) {
            if (512 != (i7 & 512)) {
                AbstractC2611a0.a(i7, 512, PaywallData$Configuration$$serializer.INSTANCE.getDescriptor());
            }
            this.packageIds = (i7 & 1) == 0 ? AbstractC0556n.g() : list;
            if ((i7 & 2) == 0) {
                this.defaultPackage = null;
            } else {
                this.defaultPackage = str;
            }
            if ((i7 & 4) == 0) {
                this.imagesWebp = null;
            } else {
                this.imagesWebp = images;
            }
            if ((i7 & 8) == 0) {
                this.legacyImages = null;
            } else {
                this.legacyImages = images2;
            }
            if ((i7 & 16) == 0) {
                this.imagesByTier = null;
            } else {
                this.imagesByTier = map;
            }
            this.blurredBackgroundImage = (i7 & 32) == 0 ? false : z7;
            this.displayRestorePurchases = (i7 & 64) == 0 ? true : z8;
            if ((i7 & 128) == 0) {
                this.termsOfServiceURL = null;
            } else {
                this.termsOfServiceURL = url;
            }
            if ((i7 & 256) == 0) {
                this.privacyURL = null;
            } else {
                this.privacyURL = url2;
            }
            this.colors = colorInformation;
            if ((i7 & 1024) == 0) {
                this.colorsByTier = null;
            } else {
                this.colorsByTier = map2;
            }
            if ((i7 & 2048) == 0) {
                this.tiers = null;
            } else {
                this.tiers = list2;
            }
            if ((i7 & 4096) == 0) {
                this.defaultTier = null;
            } else {
                this.defaultTier = str2;
            }
        }

        public static /* synthetic */ void getBlurredBackgroundImage$annotations() {
        }

        public static /* synthetic */ void getColorsByTier$annotations() {
        }

        public static /* synthetic */ void getDefaultPackage$annotations() {
        }

        public static /* synthetic */ void getDefaultTier$annotations() {
        }

        public static /* synthetic */ void getDisplayRestorePurchases$annotations() {
        }

        public static /* synthetic */ void getImagesByTier$annotations() {
        }

        public static /* synthetic */ void getImagesWebp$purchases_defaultsRelease$annotations() {
        }

        public static /* synthetic */ void getLegacyImages$purchases_defaultsRelease$annotations() {
        }

        public static /* synthetic */ void getPackageIds$annotations() {
        }

        public static /* synthetic */ void getPrivacyURL$annotations() {
        }

        public static /* synthetic */ void getTermsOfServiceURL$annotations() {
        }

        public static final /* synthetic */ void write$Self(Configuration configuration, d dVar, e eVar) {
            b[] bVarArr = $childSerializers;
            if (dVar.C(eVar, 0) || !r.b(configuration.packageIds, AbstractC0556n.g())) {
                dVar.x(eVar, 0, bVarArr[0], configuration.packageIds);
            }
            if (dVar.C(eVar, 1) || configuration.defaultPackage != null) {
                dVar.r(eVar, 1, o0.f22909a, configuration.defaultPackage);
            }
            if (dVar.C(eVar, 2) || configuration.imagesWebp != null) {
                dVar.r(eVar, 2, PaywallData$Configuration$Images$$serializer.INSTANCE, configuration.imagesWebp);
            }
            if (dVar.C(eVar, 3) || configuration.legacyImages != null) {
                dVar.r(eVar, 3, PaywallData$Configuration$Images$$serializer.INSTANCE, configuration.legacyImages);
            }
            if (dVar.C(eVar, 4) || configuration.imagesByTier != null) {
                dVar.r(eVar, 4, bVarArr[4], configuration.imagesByTier);
            }
            if (dVar.C(eVar, 5) || configuration.blurredBackgroundImage) {
                dVar.w(eVar, 5, configuration.blurredBackgroundImage);
            }
            if (dVar.C(eVar, 6) || !configuration.displayRestorePurchases) {
                dVar.w(eVar, 6, configuration.displayRestorePurchases);
            }
            if (dVar.C(eVar, 7) || configuration.termsOfServiceURL != null) {
                dVar.r(eVar, 7, OptionalURLSerializer.INSTANCE, configuration.termsOfServiceURL);
            }
            if (dVar.C(eVar, 8) || configuration.privacyURL != null) {
                dVar.r(eVar, 8, OptionalURLSerializer.INSTANCE, configuration.privacyURL);
            }
            dVar.x(eVar, 9, PaywallData$Configuration$ColorInformation$$serializer.INSTANCE, configuration.colors);
            if (dVar.C(eVar, 10) || configuration.colorsByTier != null) {
                dVar.r(eVar, 10, bVarArr[10], configuration.colorsByTier);
            }
            if (dVar.C(eVar, 11) || configuration.tiers != null) {
                dVar.r(eVar, 11, bVarArr[11], configuration.tiers);
            }
            if (!dVar.C(eVar, 12) && configuration.defaultTier == null) {
                return;
            }
            dVar.r(eVar, 12, o0.f22909a, configuration.defaultTier);
        }

        public final List<String> component1() {
            return this.packageIds;
        }

        public final ColorInformation component10() {
            return this.colors;
        }

        public final Map<String, ColorInformation> component11() {
            return this.colorsByTier;
        }

        public final List<Tier> component12() {
            return this.tiers;
        }

        public final String component13() {
            return this.defaultTier;
        }

        public final String component2() {
            return this.defaultPackage;
        }

        public final Images component3$purchases_defaultsRelease() {
            return this.imagesWebp;
        }

        public final Images component4$purchases_defaultsRelease() {
            return this.legacyImages;
        }

        public final Map<String, Images> component5() {
            return this.imagesByTier;
        }

        public final boolean component6() {
            return this.blurredBackgroundImage;
        }

        public final boolean component7() {
            return this.displayRestorePurchases;
        }

        public final URL component8() {
            return this.termsOfServiceURL;
        }

        public final URL component9() {
            return this.privacyURL;
        }

        public final Configuration copy(List<String> packageIds, String str, Images images, Images images2, Map<String, Images> map, boolean z7, boolean z8, URL url, URL url2, ColorInformation colors, Map<String, ColorInformation> map2, List<Tier> list, String str2) {
            r.f(packageIds, "packageIds");
            r.f(colors, "colors");
            return new Configuration(packageIds, str, images, images2, map, z7, z8, url, url2, colors, map2, list, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Configuration)) {
                return false;
            }
            Configuration configuration = (Configuration) obj;
            return r.b(this.packageIds, configuration.packageIds) && r.b(this.defaultPackage, configuration.defaultPackage) && r.b(this.imagesWebp, configuration.imagesWebp) && r.b(this.legacyImages, configuration.legacyImages) && r.b(this.imagesByTier, configuration.imagesByTier) && this.blurredBackgroundImage == configuration.blurredBackgroundImage && this.displayRestorePurchases == configuration.displayRestorePurchases && r.b(this.termsOfServiceURL, configuration.termsOfServiceURL) && r.b(this.privacyURL, configuration.privacyURL) && r.b(this.colors, configuration.colors) && r.b(this.colorsByTier, configuration.colorsByTier) && r.b(this.tiers, configuration.tiers) && r.b(this.defaultTier, configuration.defaultTier);
        }

        public final boolean getBlurredBackgroundImage() {
            return this.blurredBackgroundImage;
        }

        public final ColorInformation getColors() {
            return this.colors;
        }

        public final Map<String, ColorInformation> getColorsByTier() {
            return this.colorsByTier;
        }

        public final String getDefaultPackage() {
            return this.defaultPackage;
        }

        public final String getDefaultTier() {
            return this.defaultTier;
        }

        public final boolean getDisplayRestorePurchases() {
            return this.displayRestorePurchases;
        }

        public final Images getImages() {
            String header;
            String background;
            String icon;
            Images images = this.imagesWebp;
            String icon2 = null;
            if (images == null || (header = images.getHeader()) == null) {
                Images images2 = this.legacyImages;
                header = images2 != null ? images2.getHeader() : null;
            }
            Images images3 = this.imagesWebp;
            if (images3 == null || (background = images3.getBackground()) == null) {
                Images images4 = this.legacyImages;
                background = images4 != null ? images4.getBackground() : null;
            }
            Images images5 = this.imagesWebp;
            if (images5 == null || (icon = images5.getIcon()) == null) {
                Images images6 = this.legacyImages;
                if (images6 != null) {
                    icon2 = images6.getIcon();
                }
            } else {
                icon2 = icon;
            }
            return new Images(header, background, icon2);
        }

        public final Map<String, Images> getImagesByTier() {
            return this.imagesByTier;
        }

        public final Images getImagesWebp$purchases_defaultsRelease() {
            return this.imagesWebp;
        }

        public final Images getLegacyImages$purchases_defaultsRelease() {
            return this.legacyImages;
        }

        public final List<String> getPackageIds() {
            return this.packageIds;
        }

        public final URL getPrivacyURL() {
            return this.privacyURL;
        }

        public final URL getTermsOfServiceURL() {
            return this.termsOfServiceURL;
        }

        public final List<Tier> getTiers() {
            return this.tiers;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v13, types: [int] */
        /* JADX WARN: Type inference failed for: r1v34 */
        /* JADX WARN: Type inference failed for: r1v39 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            int iHashCode = this.packageIds.hashCode() * 31;
            String str = this.defaultPackage;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            Images images = this.imagesWebp;
            int iHashCode3 = (iHashCode2 + (images == null ? 0 : images.hashCode())) * 31;
            Images images2 = this.legacyImages;
            int iHashCode4 = (iHashCode3 + (images2 == null ? 0 : images2.hashCode())) * 31;
            Map<String, Images> map = this.imagesByTier;
            int iHashCode5 = (iHashCode4 + (map == null ? 0 : map.hashCode())) * 31;
            boolean z7 = this.blurredBackgroundImage;
            ?? r12 = z7;
            if (z7) {
                r12 = 1;
            }
            int i7 = (iHashCode5 + r12) * 31;
            boolean z8 = this.displayRestorePurchases;
            int i8 = (i7 + (z8 ? 1 : z8)) * 31;
            URL url = this.termsOfServiceURL;
            int iHashCode6 = (i8 + (url == null ? 0 : url.hashCode())) * 31;
            URL url2 = this.privacyURL;
            int iHashCode7 = (((iHashCode6 + (url2 == null ? 0 : url2.hashCode())) * 31) + this.colors.hashCode()) * 31;
            Map<String, ColorInformation> map2 = this.colorsByTier;
            int iHashCode8 = (iHashCode7 + (map2 == null ? 0 : map2.hashCode())) * 31;
            List<Tier> list = this.tiers;
            int iHashCode9 = (iHashCode8 + (list == null ? 0 : list.hashCode())) * 31;
            String str2 = this.defaultTier;
            return iHashCode9 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "Configuration(packageIds=" + this.packageIds + ", defaultPackage=" + this.defaultPackage + ", imagesWebp=" + this.imagesWebp + ", legacyImages=" + this.legacyImages + ", imagesByTier=" + this.imagesByTier + ", blurredBackgroundImage=" + this.blurredBackgroundImage + ", displayRestorePurchases=" + this.displayRestorePurchases + ", termsOfServiceURL=" + this.termsOfServiceURL + ", privacyURL=" + this.privacyURL + ", colors=" + this.colors + ", colorsByTier=" + this.colorsByTier + ", tiers=" + this.tiers + ", defaultTier=" + this.defaultTier + ')';
        }

        public Configuration(List<String> packageIds, String str, Images images, Images images2, Map<String, Images> map, boolean z7, boolean z8, URL url, URL url2, ColorInformation colors, Map<String, ColorInformation> map2, List<Tier> list, String str2) {
            r.f(packageIds, "packageIds");
            r.f(colors, "colors");
            this.packageIds = packageIds;
            this.defaultPackage = str;
            this.imagesWebp = images;
            this.legacyImages = images2;
            this.imagesByTier = map;
            this.blurredBackgroundImage = z7;
            this.displayRestorePurchases = z8;
            this.termsOfServiceURL = url;
            this.privacyURL = url2;
            this.colors = colors;
            this.colorsByTier = map2;
            this.tiers = list;
            this.defaultTier = str2;
        }

        public /* synthetic */ Configuration(List list, String str, Images images, Images images2, Map map, boolean z7, boolean z8, URL url, URL url2, ColorInformation colorInformation, Map map2, List list2, String str2, int i7, AbstractC2148j abstractC2148j) {
            this((List<String>) ((i7 & 1) != 0 ? AbstractC0556n.g() : list), (i7 & 2) != 0 ? null : str, (i7 & 4) != 0 ? null : images, (i7 & 8) != 0 ? null : images2, (Map<String, Images>) ((i7 & 16) != 0 ? null : map), (i7 & 32) != 0 ? false : z7, (i7 & 64) != 0 ? true : z8, (i7 & 128) != 0 ? null : url, (i7 & 256) != 0 ? null : url2, colorInformation, (Map<String, ColorInformation>) ((i7 & 1024) != 0 ? null : map2), (List<Tier>) ((i7 & 2048) != 0 ? null : list2), (i7 & 4096) != 0 ? null : str2);
        }

        public /* synthetic */ Configuration(List list, String str, Images images, Map map, ColorInformation colorInformation, Map map2, List list2, boolean z7, boolean z8, URL url, URL url2, int i7, AbstractC2148j abstractC2148j) {
            this(list, (i7 & 2) != 0 ? null : str, images, (i7 & 8) != 0 ? null : map, colorInformation, (i7 & 32) != 0 ? null : map2, (i7 & 64) != 0 ? null : list2, (i7 & 128) != 0 ? false : z7, (i7 & 256) != 0 ? true : z8, (i7 & 512) != 0 ? null : url, (i7 & 1024) != 0 ? null : url2);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public Configuration(List<String> packageIds, String str, Images images, Map<String, Images> map, ColorInformation colors, Map<String, ColorInformation> map2, List<Tier> list, boolean z7, boolean z8, URL url, URL url2) {
            this(packageIds, str, images, (Images) null, map, z7, z8, url, url2, colors, map2, list, (String) null, 4104, (AbstractC2148j) null);
            r.f(packageIds, "packageIds");
            r.f(images, "images");
            r.f(colors, "colors");
        }
    }

    public static final class LocalizedConfiguration {
        private final String callToAction;
        private final String callToActionWithIntroOffer;
        private final String callToActionWithMultipleIntroOffers;
        private final List<Feature> features;
        private final String offerDetails;
        private final String offerDetailsWithIntroOffer;
        private final String offerDetailsWithMultipleIntroOffers;
        private final String offerName;
        private final Map<String, OfferOverride> offerOverrides;
        private final String subtitle;
        private final String tierName;
        private final String title;
        public static final Companion Companion = new Companion(null);
        private static final b[] $childSerializers = {null, null, null, null, null, null, null, null, null, new C2618e(PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE), null, new K(o0.f22909a, PaywallData$LocalizedConfiguration$OfferOverride$$serializer.INSTANCE)};

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                this();
            }

            public final b serializer() {
                return PaywallData$LocalizedConfiguration$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public static final class Feature {
            public static final Companion Companion = new Companion(null);
            private final String content;
            private final String iconID;
            private final String title;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ Feature(int i7, String str, String str2, String str3, k0 k0Var) {
                if (1 != (i7 & 1)) {
                    AbstractC2611a0.a(i7, 1, PaywallData$LocalizedConfiguration$Feature$$serializer.INSTANCE.getDescriptor());
                }
                this.title = str;
                if ((i7 & 2) == 0) {
                    this.content = null;
                } else {
                    this.content = str2;
                }
                if ((i7 & 4) == 0) {
                    this.iconID = null;
                } else {
                    this.iconID = str3;
                }
            }

            public static /* synthetic */ Feature copy$default(Feature feature, String str, String str2, String str3, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    str = feature.title;
                }
                if ((i7 & 2) != 0) {
                    str2 = feature.content;
                }
                if ((i7 & 4) != 0) {
                    str3 = feature.iconID;
                }
                return feature.copy(str, str2, str3);
            }

            public static /* synthetic */ void getIconID$annotations() {
            }

            public static final /* synthetic */ void write$Self(Feature feature, d dVar, e eVar) {
                dVar.m(eVar, 0, feature.title);
                if (dVar.C(eVar, 1) || feature.content != null) {
                    dVar.r(eVar, 1, o0.f22909a, feature.content);
                }
                if (!dVar.C(eVar, 2) && feature.iconID == null) {
                    return;
                }
                dVar.r(eVar, 2, o0.f22909a, feature.iconID);
            }

            public final String component1() {
                return this.title;
            }

            public final String component2() {
                return this.content;
            }

            public final String component3() {
                return this.iconID;
            }

            public final Feature copy(String title, String str, String str2) {
                r.f(title, "title");
                return new Feature(title, str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Feature)) {
                    return false;
                }
                Feature feature = (Feature) obj;
                return r.b(this.title, feature.title) && r.b(this.content, feature.content) && r.b(this.iconID, feature.iconID);
            }

            public final String getContent() {
                return this.content;
            }

            public final String getIconID() {
                return this.iconID;
            }

            public final String getTitle() {
                return this.title;
            }

            public int hashCode() {
                int iHashCode = this.title.hashCode() * 31;
                String str = this.content;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.iconID;
                return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
            }

            public String toString() {
                return "Feature(title=" + this.title + ", content=" + this.content + ", iconID=" + this.iconID + ')';
            }

            public Feature(String title, String str, String str2) {
                r.f(title, "title");
                this.title = title;
                this.content = str;
                this.iconID = str2;
            }

            public /* synthetic */ Feature(String str, String str2, String str3, int i7, AbstractC2148j abstractC2148j) {
                this(str, (i7 & 2) != 0 ? null : str2, (i7 & 4) != 0 ? null : str3);
            }
        }

        public static final class OfferOverride {
            public static final Companion Companion = new Companion(null);
            private final String offerBadge;
            private final String offerDetails;
            private final String offerDetailsWithIntroOffer;
            private final String offerDetailsWithMultipleIntroOffers;
            private final String offerName;

            public static final class Companion {
                public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
                    this();
                }

                public final b serializer() {
                    return PaywallData$LocalizedConfiguration$OfferOverride$$serializer.INSTANCE;
                }

                private Companion() {
                }
            }

            public /* synthetic */ OfferOverride(int i7, String str, String str2, String str3, String str4, String str5, k0 k0Var) {
                if (3 != (i7 & 3)) {
                    AbstractC2611a0.a(i7, 3, PaywallData$LocalizedConfiguration$OfferOverride$$serializer.INSTANCE.getDescriptor());
                }
                this.offerName = str;
                this.offerDetails = str2;
                if ((i7 & 4) == 0) {
                    this.offerDetailsWithIntroOffer = null;
                } else {
                    this.offerDetailsWithIntroOffer = str3;
                }
                if ((i7 & 8) == 0) {
                    this.offerDetailsWithMultipleIntroOffers = null;
                } else {
                    this.offerDetailsWithMultipleIntroOffers = str4;
                }
                if ((i7 & 16) == 0) {
                    this.offerBadge = null;
                } else {
                    this.offerBadge = str5;
                }
            }

            public static /* synthetic */ OfferOverride copy$default(OfferOverride offerOverride, String str, String str2, String str3, String str4, String str5, int i7, Object obj) {
                if ((i7 & 1) != 0) {
                    str = offerOverride.offerName;
                }
                if ((i7 & 2) != 0) {
                    str2 = offerOverride.offerDetails;
                }
                String str6 = str2;
                if ((i7 & 4) != 0) {
                    str3 = offerOverride.offerDetailsWithIntroOffer;
                }
                String str7 = str3;
                if ((i7 & 8) != 0) {
                    str4 = offerOverride.offerDetailsWithMultipleIntroOffers;
                }
                String str8 = str4;
                if ((i7 & 16) != 0) {
                    str5 = offerOverride.offerBadge;
                }
                return offerOverride.copy(str, str6, str7, str8, str5);
            }

            public static /* synthetic */ void getOfferBadge$annotations() {
            }

            public static /* synthetic */ void getOfferDetails$annotations() {
            }

            public static /* synthetic */ void getOfferDetailsWithIntroOffer$annotations() {
            }

            public static /* synthetic */ void getOfferDetailsWithMultipleIntroOffers$annotations() {
            }

            public static /* synthetic */ void getOfferName$annotations() {
            }

            public static final /* synthetic */ void write$Self(OfferOverride offerOverride, d dVar, e eVar) {
                dVar.m(eVar, 0, offerOverride.offerName);
                dVar.m(eVar, 1, offerOverride.offerDetails);
                if (dVar.C(eVar, 2) || offerOverride.offerDetailsWithIntroOffer != null) {
                    dVar.r(eVar, 2, EmptyStringToNullSerializer.INSTANCE, offerOverride.offerDetailsWithIntroOffer);
                }
                if (dVar.C(eVar, 3) || offerOverride.offerDetailsWithMultipleIntroOffers != null) {
                    dVar.r(eVar, 3, EmptyStringToNullSerializer.INSTANCE, offerOverride.offerDetailsWithMultipleIntroOffers);
                }
                if (!dVar.C(eVar, 4) && offerOverride.offerBadge == null) {
                    return;
                }
                dVar.r(eVar, 4, EmptyStringToNullSerializer.INSTANCE, offerOverride.offerBadge);
            }

            public final String component1() {
                return this.offerName;
            }

            public final String component2() {
                return this.offerDetails;
            }

            public final String component3() {
                return this.offerDetailsWithIntroOffer;
            }

            public final String component4() {
                return this.offerDetailsWithMultipleIntroOffers;
            }

            public final String component5() {
                return this.offerBadge;
            }

            public final OfferOverride copy(String offerName, String offerDetails, String str, String str2, String str3) {
                r.f(offerName, "offerName");
                r.f(offerDetails, "offerDetails");
                return new OfferOverride(offerName, offerDetails, str, str2, str3);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof OfferOverride)) {
                    return false;
                }
                OfferOverride offerOverride = (OfferOverride) obj;
                return r.b(this.offerName, offerOverride.offerName) && r.b(this.offerDetails, offerOverride.offerDetails) && r.b(this.offerDetailsWithIntroOffer, offerOverride.offerDetailsWithIntroOffer) && r.b(this.offerDetailsWithMultipleIntroOffers, offerOverride.offerDetailsWithMultipleIntroOffers) && r.b(this.offerBadge, offerOverride.offerBadge);
            }

            public final String getOfferBadge() {
                return this.offerBadge;
            }

            public final String getOfferDetails() {
                return this.offerDetails;
            }

            public final String getOfferDetailsWithIntroOffer() {
                return this.offerDetailsWithIntroOffer;
            }

            public final String getOfferDetailsWithMultipleIntroOffers() {
                return this.offerDetailsWithMultipleIntroOffers;
            }

            public final String getOfferName() {
                return this.offerName;
            }

            public int hashCode() {
                int iHashCode = ((this.offerName.hashCode() * 31) + this.offerDetails.hashCode()) * 31;
                String str = this.offerDetailsWithIntroOffer;
                int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
                String str2 = this.offerDetailsWithMultipleIntroOffers;
                int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
                String str3 = this.offerBadge;
                return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
            }

            public String toString() {
                return "OfferOverride(offerName=" + this.offerName + ", offerDetails=" + this.offerDetails + ", offerDetailsWithIntroOffer=" + this.offerDetailsWithIntroOffer + ", offerDetailsWithMultipleIntroOffers=" + this.offerDetailsWithMultipleIntroOffers + ", offerBadge=" + this.offerBadge + ')';
            }

            public OfferOverride(String offerName, String offerDetails, String str, String str2, String str3) {
                r.f(offerName, "offerName");
                r.f(offerDetails, "offerDetails");
                this.offerName = offerName;
                this.offerDetails = offerDetails;
                this.offerDetailsWithIntroOffer = str;
                this.offerDetailsWithMultipleIntroOffers = str2;
                this.offerBadge = str3;
            }

            public /* synthetic */ OfferOverride(String str, String str2, String str3, String str4, String str5, int i7, AbstractC2148j abstractC2148j) {
                this(str, str2, (i7 & 4) != 0 ? null : str3, (i7 & 8) != 0 ? null : str4, (i7 & 16) != 0 ? null : str5);
            }
        }

        public /* synthetic */ LocalizedConfiguration(int i7, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, String str10, Map map, k0 k0Var) {
            if (5 != (i7 & 5)) {
                AbstractC2611a0.a(i7, 5, PaywallData$LocalizedConfiguration$$serializer.INSTANCE.getDescriptor());
            }
            this.title = str;
            if ((i7 & 2) == 0) {
                this.subtitle = null;
            } else {
                this.subtitle = str2;
            }
            this.callToAction = str3;
            if ((i7 & 8) == 0) {
                this.callToActionWithIntroOffer = null;
            } else {
                this.callToActionWithIntroOffer = str4;
            }
            if ((i7 & 16) == 0) {
                this.callToActionWithMultipleIntroOffers = null;
            } else {
                this.callToActionWithMultipleIntroOffers = str5;
            }
            if ((i7 & 32) == 0) {
                this.offerDetails = null;
            } else {
                this.offerDetails = str6;
            }
            if ((i7 & 64) == 0) {
                this.offerDetailsWithIntroOffer = null;
            } else {
                this.offerDetailsWithIntroOffer = str7;
            }
            if ((i7 & 128) == 0) {
                this.offerDetailsWithMultipleIntroOffers = null;
            } else {
                this.offerDetailsWithMultipleIntroOffers = str8;
            }
            if ((i7 & 256) == 0) {
                this.offerName = null;
            } else {
                this.offerName = str9;
            }
            if ((i7 & 512) == 0) {
                this.features = AbstractC0556n.g();
            } else {
                this.features = list;
            }
            if ((i7 & 1024) == 0) {
                this.tierName = null;
            } else {
                this.tierName = str10;
            }
            if ((i7 & 2048) == 0) {
                this.offerOverrides = J.e();
            } else {
                this.offerOverrides = map;
            }
        }

        public static /* synthetic */ void getCallToAction$annotations() {
        }

        public static /* synthetic */ void getCallToActionWithIntroOffer$annotations() {
        }

        public static /* synthetic */ void getCallToActionWithMultipleIntroOffers$annotations() {
        }

        public static /* synthetic */ void getOfferDetails$annotations() {
        }

        public static /* synthetic */ void getOfferDetailsWithIntroOffer$annotations() {
        }

        public static /* synthetic */ void getOfferDetailsWithMultipleIntroOffers$annotations() {
        }

        public static /* synthetic */ void getOfferName$annotations() {
        }

        public static /* synthetic */ void getOfferOverrides$annotations() {
        }

        public static /* synthetic */ void getSubtitle$annotations() {
        }

        public static /* synthetic */ void getTierName$annotations() {
        }

        public static final /* synthetic */ void write$Self(LocalizedConfiguration localizedConfiguration, d dVar, e eVar) {
            b[] bVarArr = $childSerializers;
            dVar.m(eVar, 0, localizedConfiguration.title);
            if (dVar.C(eVar, 1) || localizedConfiguration.subtitle != null) {
                dVar.r(eVar, 1, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.subtitle);
            }
            dVar.m(eVar, 2, localizedConfiguration.callToAction);
            if (dVar.C(eVar, 3) || localizedConfiguration.callToActionWithIntroOffer != null) {
                dVar.r(eVar, 3, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.callToActionWithIntroOffer);
            }
            if (dVar.C(eVar, 4) || localizedConfiguration.callToActionWithMultipleIntroOffers != null) {
                dVar.r(eVar, 4, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.callToActionWithMultipleIntroOffers);
            }
            if (dVar.C(eVar, 5) || localizedConfiguration.offerDetails != null) {
                dVar.r(eVar, 5, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerDetails);
            }
            if (dVar.C(eVar, 6) || localizedConfiguration.offerDetailsWithIntroOffer != null) {
                dVar.r(eVar, 6, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerDetailsWithIntroOffer);
            }
            if (dVar.C(eVar, 7) || localizedConfiguration.offerDetailsWithMultipleIntroOffers != null) {
                dVar.r(eVar, 7, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerDetailsWithMultipleIntroOffers);
            }
            if (dVar.C(eVar, 8) || localizedConfiguration.offerName != null) {
                dVar.r(eVar, 8, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.offerName);
            }
            if (dVar.C(eVar, 9) || !r.b(localizedConfiguration.features, AbstractC0556n.g())) {
                dVar.x(eVar, 9, bVarArr[9], localizedConfiguration.features);
            }
            if (dVar.C(eVar, 10) || localizedConfiguration.tierName != null) {
                dVar.r(eVar, 10, EmptyStringToNullSerializer.INSTANCE, localizedConfiguration.tierName);
            }
            if (!dVar.C(eVar, 11) && r.b(localizedConfiguration.offerOverrides, J.e())) {
                return;
            }
            dVar.x(eVar, 11, bVarArr[11], localizedConfiguration.offerOverrides);
        }

        public final String component1() {
            return this.title;
        }

        public final List<Feature> component10() {
            return this.features;
        }

        public final String component11() {
            return this.tierName;
        }

        public final Map<String, OfferOverride> component12() {
            return this.offerOverrides;
        }

        public final String component2() {
            return this.subtitle;
        }

        public final String component3() {
            return this.callToAction;
        }

        public final String component4() {
            return this.callToActionWithIntroOffer;
        }

        public final String component5() {
            return this.callToActionWithMultipleIntroOffers;
        }

        public final String component6() {
            return this.offerDetails;
        }

        public final String component7() {
            return this.offerDetailsWithIntroOffer;
        }

        public final String component8() {
            return this.offerDetailsWithMultipleIntroOffers;
        }

        public final String component9() {
            return this.offerName;
        }

        public final LocalizedConfiguration copy(String title, String str, String callToAction, String str2, String str3, String str4, String str5, String str6, String str7, List<Feature> features, String str8, Map<String, OfferOverride> offerOverrides) {
            r.f(title, "title");
            r.f(callToAction, "callToAction");
            r.f(features, "features");
            r.f(offerOverrides, "offerOverrides");
            return new LocalizedConfiguration(title, str, callToAction, str2, str3, str4, str5, str6, str7, features, str8, offerOverrides);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LocalizedConfiguration)) {
                return false;
            }
            LocalizedConfiguration localizedConfiguration = (LocalizedConfiguration) obj;
            return r.b(this.title, localizedConfiguration.title) && r.b(this.subtitle, localizedConfiguration.subtitle) && r.b(this.callToAction, localizedConfiguration.callToAction) && r.b(this.callToActionWithIntroOffer, localizedConfiguration.callToActionWithIntroOffer) && r.b(this.callToActionWithMultipleIntroOffers, localizedConfiguration.callToActionWithMultipleIntroOffers) && r.b(this.offerDetails, localizedConfiguration.offerDetails) && r.b(this.offerDetailsWithIntroOffer, localizedConfiguration.offerDetailsWithIntroOffer) && r.b(this.offerDetailsWithMultipleIntroOffers, localizedConfiguration.offerDetailsWithMultipleIntroOffers) && r.b(this.offerName, localizedConfiguration.offerName) && r.b(this.features, localizedConfiguration.features) && r.b(this.tierName, localizedConfiguration.tierName) && r.b(this.offerOverrides, localizedConfiguration.offerOverrides);
        }

        public final String getCallToAction() {
            return this.callToAction;
        }

        public final String getCallToActionWithIntroOffer() {
            return this.callToActionWithIntroOffer;
        }

        public final String getCallToActionWithMultipleIntroOffers() {
            return this.callToActionWithMultipleIntroOffers;
        }

        public final List<Feature> getFeatures() {
            return this.features;
        }

        public final String getOfferDetails() {
            return this.offerDetails;
        }

        public final String getOfferDetailsWithIntroOffer() {
            return this.offerDetailsWithIntroOffer;
        }

        public final String getOfferDetailsWithMultipleIntroOffers() {
            return this.offerDetailsWithMultipleIntroOffers;
        }

        public final String getOfferName() {
            return this.offerName;
        }

        public final Map<String, OfferOverride> getOfferOverrides() {
            return this.offerOverrides;
        }

        public final String getSubtitle() {
            return this.subtitle;
        }

        public final String getTierName() {
            return this.tierName;
        }

        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            int iHashCode = this.title.hashCode() * 31;
            String str = this.subtitle;
            int iHashCode2 = (((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.callToAction.hashCode()) * 31;
            String str2 = this.callToActionWithIntroOffer;
            int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.callToActionWithMultipleIntroOffers;
            int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.offerDetails;
            int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
            String str5 = this.offerDetailsWithIntroOffer;
            int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
            String str6 = this.offerDetailsWithMultipleIntroOffers;
            int iHashCode7 = (iHashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
            String str7 = this.offerName;
            int iHashCode8 = (((iHashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.features.hashCode()) * 31;
            String str8 = this.tierName;
            return ((iHashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31) + this.offerOverrides.hashCode();
        }

        public String toString() {
            return "LocalizedConfiguration(title=" + this.title + ", subtitle=" + this.subtitle + ", callToAction=" + this.callToAction + ", callToActionWithIntroOffer=" + this.callToActionWithIntroOffer + ", callToActionWithMultipleIntroOffers=" + this.callToActionWithMultipleIntroOffers + ", offerDetails=" + this.offerDetails + ", offerDetailsWithIntroOffer=" + this.offerDetailsWithIntroOffer + ", offerDetailsWithMultipleIntroOffers=" + this.offerDetailsWithMultipleIntroOffers + ", offerName=" + this.offerName + ", features=" + this.features + ", tierName=" + this.tierName + ", offerOverrides=" + this.offerOverrides + ')';
        }

        public LocalizedConfiguration(String title, String str, String callToAction, String str2, String str3, String str4, String str5, String str6, String str7, List<Feature> features, String str8, Map<String, OfferOverride> offerOverrides) {
            r.f(title, "title");
            r.f(callToAction, "callToAction");
            r.f(features, "features");
            r.f(offerOverrides, "offerOverrides");
            this.title = title;
            this.subtitle = str;
            this.callToAction = callToAction;
            this.callToActionWithIntroOffer = str2;
            this.callToActionWithMultipleIntroOffers = str3;
            this.offerDetails = str4;
            this.offerDetailsWithIntroOffer = str5;
            this.offerDetailsWithMultipleIntroOffers = str6;
            this.offerName = str7;
            this.features = features;
            this.tierName = str8;
            this.offerOverrides = offerOverrides;
        }

        public /* synthetic */ LocalizedConfiguration(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, List list, String str10, Map map, int i7, AbstractC2148j abstractC2148j) {
            this(str, (i7 & 2) != 0 ? null : str2, str3, (i7 & 8) != 0 ? null : str4, (i7 & 16) != 0 ? null : str5, (i7 & 32) != 0 ? null : str6, (i7 & 64) != 0 ? null : str7, (i7 & 128) != 0 ? null : str8, (i7 & 256) != 0 ? null : str9, (i7 & 512) != 0 ? AbstractC0556n.g() : list, (i7 & 1024) != 0 ? null : str10, (i7 & 2048) != 0 ? J.e() : map);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PaywallData(String templateName, Configuration config, URL assetBaseURL, int i7, Map<String, LocalizedConfiguration> localization, Map<String, ? extends Map<String, LocalizedConfiguration>> localizationByTier, List<String> zeroDecimalPlaceCountries, String str) {
        r.f(templateName, "templateName");
        r.f(config, "config");
        r.f(assetBaseURL, "assetBaseURL");
        r.f(localization, "localization");
        r.f(localizationByTier, "localizationByTier");
        r.f(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        this.templateName = templateName;
        this.config = config;
        this.assetBaseURL = assetBaseURL;
        this.revision = i7;
        this.localization = localization;
        this.localizationByTier = localizationByTier;
        this.zeroDecimalPlaceCountries = zeroDecimalPlaceCountries;
        this.defaultLocale = str;
    }

    public /* synthetic */ PaywallData(String str, Configuration configuration, URL url, int i7, Map map, Map map2, List list, String str2, int i8, AbstractC2148j abstractC2148j) {
        this(str, configuration, url, (i8 & 8) != 0 ? 0 : i7, map, (i8 & 32) != 0 ? J.e() : map2, (i8 & 64) != 0 ? AbstractC0556n.g() : list, (i8 & 128) != 0 ? null : str2);
    }
}
