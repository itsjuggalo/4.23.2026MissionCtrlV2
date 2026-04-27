package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.K;
import J3.k0;
import X2.AbstractC0769p;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class PaywallComponentsData {
    private final URL assetBaseURL;
    private final ComponentsConfig componentsConfig;
    private final Map<LocaleId, Map<LocalizationKey, LocalizationData>> componentsLocalizations;
    private final String defaultLocaleIdentifier;
    private final int revision;
    private final String templateName;
    private final List<String> zeroDecimalPlaceCountries;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {null, null, null, new K(LocaleId$$serializer.INSTANCE, new K(LocalizationKey$$serializer.INSTANCE, LocalizationDataSerializer.INSTANCE)), null, null, null};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return PaywallComponentsData$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ PaywallComponentsData(int i4, String str, URL url, ComponentsConfig componentsConfig, Map map, String str2, int i5, List list, k0 k0Var, AbstractC1585j abstractC1585j) {
        this(i4, str, url, componentsConfig, (Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>>) map, str2, i5, (List<String>) list, k0Var);
    }

    public static /* synthetic */ void getAssetBaseURL$annotations() {
    }

    public static /* synthetic */ void getComponentsConfig$annotations() {
    }

    public static /* synthetic */ void getComponentsLocalizations$annotations() {
    }

    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA$annotations, reason: not valid java name */
    public static /* synthetic */ void m202getDefaultLocaleIdentifieruqtKvyA$annotations() {
    }

    public static /* synthetic */ void getTemplateName$annotations() {
    }

    public static /* synthetic */ void getZeroDecimalPlaceCountries$annotations() {
    }

    public static final /* synthetic */ void write$Self(PaywallComponentsData paywallComponentsData, d dVar, e eVar) {
        b[] bVarArr = $childSerializers;
        dVar.o(eVar, 0, paywallComponentsData.templateName);
        dVar.u(eVar, 1, URLSerializer.INSTANCE, paywallComponentsData.assetBaseURL);
        dVar.u(eVar, 2, ComponentsConfig$$serializer.INSTANCE, paywallComponentsData.componentsConfig);
        dVar.u(eVar, 3, bVarArr[3], paywallComponentsData.componentsLocalizations);
        dVar.u(eVar, 4, LocaleId$$serializer.INSTANCE, LocaleId.m166boximpl(paywallComponentsData.defaultLocaleIdentifier));
        if (dVar.j(eVar, 5) || paywallComponentsData.revision != 0) {
            dVar.k(eVar, 5, paywallComponentsData.revision);
        }
        if (!dVar.j(eVar, 6) && r.b(paywallComponentsData.zeroDecimalPlaceCountries, AbstractC0769p.g())) {
            return;
        }
        dVar.u(eVar, 6, GoogleListSerializer.INSTANCE, paywallComponentsData.zeroDecimalPlaceCountries);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaywallComponentsData)) {
            return false;
        }
        PaywallComponentsData paywallComponentsData = (PaywallComponentsData) obj;
        return r.b(this.templateName, paywallComponentsData.templateName) && r.b(this.assetBaseURL, paywallComponentsData.assetBaseURL) && r.b(this.componentsConfig, paywallComponentsData.componentsConfig) && r.b(this.componentsLocalizations, paywallComponentsData.componentsLocalizations) && LocaleId.m169equalsimpl0(this.defaultLocaleIdentifier, paywallComponentsData.defaultLocaleIdentifier) && this.revision == paywallComponentsData.revision && r.b(this.zeroDecimalPlaceCountries, paywallComponentsData.zeroDecimalPlaceCountries);
    }

    public final /* synthetic */ URL getAssetBaseURL() {
        return this.assetBaseURL;
    }

    public final /* synthetic */ ComponentsConfig getComponentsConfig() {
        return this.componentsConfig;
    }

    public final /* synthetic */ Map getComponentsLocalizations() {
        return this.componentsLocalizations;
    }

    /* JADX INFO: renamed from: getDefaultLocaleIdentifier-uqtKvyA, reason: not valid java name */
    public final /* synthetic */ String m203getDefaultLocaleIdentifieruqtKvyA() {
        return this.defaultLocaleIdentifier;
    }

    public final /* synthetic */ int getRevision() {
        return this.revision;
    }

    public final /* synthetic */ String getTemplateName() {
        return this.templateName;
    }

    public final /* synthetic */ List getZeroDecimalPlaceCountries() {
        return this.zeroDecimalPlaceCountries;
    }

    public int hashCode() {
        return (((((((((((this.templateName.hashCode() * 31) + this.assetBaseURL.hashCode()) * 31) + this.componentsConfig.hashCode()) * 31) + this.componentsLocalizations.hashCode()) * 31) + LocaleId.m170hashCodeimpl(this.defaultLocaleIdentifier)) * 31) + Integer.hashCode(this.revision)) * 31) + this.zeroDecimalPlaceCountries.hashCode();
    }

    public String toString() {
        return "PaywallComponentsData(templateName=" + this.templateName + ", assetBaseURL=" + this.assetBaseURL + ", componentsConfig=" + this.componentsConfig + ", componentsLocalizations=" + this.componentsLocalizations + ", defaultLocaleIdentifier=" + ((Object) LocaleId.m171toStringimpl(this.defaultLocaleIdentifier)) + ", revision=" + this.revision + ", zeroDecimalPlaceCountries=" + this.zeroDecimalPlaceCountries + ')';
    }

    public /* synthetic */ PaywallComponentsData(String str, URL url, ComponentsConfig componentsConfig, Map map, String str2, int i4, List list, AbstractC1585j abstractC1585j) {
        this(str, url, componentsConfig, map, str2, i4, list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaywallComponentsData(int i4, String str, URL url, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> map, String str2, int i5, List<String> list, k0 k0Var) {
        if (31 != (i4 & 31)) {
            AbstractC0325a0.a(i4, 31, PaywallComponentsData$$serializer.INSTANCE.getDescriptor());
        }
        this.templateName = str;
        this.assetBaseURL = url;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = map;
        this.defaultLocaleIdentifier = str2;
        if ((i4 & 32) == 0) {
            this.revision = 0;
        } else {
            this.revision = i5;
        }
        if ((i4 & 64) == 0) {
            this.zeroDecimalPlaceCountries = AbstractC0769p.g();
        } else {
            this.zeroDecimalPlaceCountries = list;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private PaywallComponentsData(String templateName, URL assetBaseURL, ComponentsConfig componentsConfig, Map<LocaleId, ? extends Map<LocalizationKey, ? extends LocalizationData>> componentsLocalizations, String defaultLocaleIdentifier, int i4, List<String> zeroDecimalPlaceCountries) {
        r.f(templateName, "templateName");
        r.f(assetBaseURL, "assetBaseURL");
        r.f(componentsConfig, "componentsConfig");
        r.f(componentsLocalizations, "componentsLocalizations");
        r.f(defaultLocaleIdentifier, "defaultLocaleIdentifier");
        r.f(zeroDecimalPlaceCountries, "zeroDecimalPlaceCountries");
        this.templateName = templateName;
        this.assetBaseURL = assetBaseURL;
        this.componentsConfig = componentsConfig;
        this.componentsLocalizations = componentsLocalizations;
        this.defaultLocaleIdentifier = defaultLocaleIdentifier;
        this.revision = i4;
        this.zeroDecimalPlaceCountries = zeroDecimalPlaceCountries;
    }

    public /* synthetic */ PaywallComponentsData(String str, URL url, ComponentsConfig componentsConfig, Map map, String str2, int i4, List list, int i5, AbstractC1585j abstractC1585j) {
        this(str, url, componentsConfig, map, str2, (i5 & 32) != 0 ? 0 : i4, (i5 & 64) != 0 ? AbstractC0769p.g() : list, null);
    }
}
