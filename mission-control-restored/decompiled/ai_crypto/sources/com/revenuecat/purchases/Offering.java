package com.revenuecat.purchases;

import E5.j;
import E5.k;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class Offering {
    private final j annual$delegate;
    private final List<Package> availablePackages;
    private final String identifier;
    private final j lifetime$delegate;
    private final Map<String, Object> metadata;
    private final j monthly$delegate;
    private final PaywallData paywall;
    private final PaywallComponents paywallComponents;
    private final String serverDescription;
    private final j sixMonth$delegate;
    private final j threeMonth$delegate;
    private final j twoMonth$delegate;
    private final j weekly$delegate;

    public static final class PaywallComponents {
        private final PaywallComponentsData data;
        private final UiConfig uiConfig;

        public PaywallComponents(UiConfig uiConfig, PaywallComponentsData data) {
            r.f(uiConfig, "uiConfig");
            r.f(data, "data");
            this.uiConfig = uiConfig;
            this.data = data;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PaywallComponents)) {
                return false;
            }
            PaywallComponents paywallComponents = (PaywallComponents) obj;
            return r.b(this.uiConfig, paywallComponents.uiConfig) && r.b(this.data, paywallComponents.data);
        }

        public final PaywallComponentsData getData() {
            return this.data;
        }

        public final UiConfig getUiConfig() {
            return this.uiConfig;
        }

        public int hashCode() {
            return (this.uiConfig.hashCode() * 31) + this.data.hashCode();
        }

        public String toString() {
            return "PaywallComponents(uiConfig=" + this.uiConfig + ", data=" + this.data + ')';
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages) {
        this(identifier, serverDescription, metadata, availablePackages, null, null, 48, null);
        r.f(identifier, "identifier");
        r.f(serverDescription, "serverDescription");
        r.f(metadata, "metadata");
        r.f(availablePackages, "availablePackages");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Offering copy$default(Offering offering, String str, String str2, Map map, List list, PaywallData paywallData, PaywallComponents paywallComponents, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            str = offering.identifier;
        }
        if ((i7 & 2) != 0) {
            str2 = offering.serverDescription;
        }
        String str3 = str2;
        if ((i7 & 4) != 0) {
            map = offering.metadata;
        }
        Map map2 = map;
        if ((i7 & 8) != 0) {
            list = offering.availablePackages;
        }
        List list2 = list;
        if ((i7 & 16) != 0) {
            paywallData = offering.paywall;
        }
        PaywallData paywallData2 = paywallData;
        if ((i7 & 32) != 0) {
            paywallComponents = offering.paywallComponents;
        }
        return offering.copy(str, str3, map2, list2, paywallData2, paywallComponents);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Package findPackage(PackageType packageType) {
        Object next;
        Iterator<T> it = this.availablePackages.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (r.b(((Package) next).getIdentifier(), packageType.getIdentifier())) {
                break;
            }
        }
        return (Package) next;
    }

    public static /* synthetic */ void getPaywallComponents$annotations() {
    }

    public static /* synthetic */ void hasPaywall$annotations() {
    }

    public final String component1() {
        return this.identifier;
    }

    public final String component2() {
        return this.serverDescription;
    }

    public final Map<String, Object> component3() {
        return this.metadata;
    }

    public final List<Package> component4() {
        return this.availablePackages;
    }

    public final PaywallData component5() {
        return this.paywall;
    }

    public final PaywallComponents component6() {
        return this.paywallComponents;
    }

    public final Offering copy(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages, PaywallData paywallData, PaywallComponents paywallComponents) {
        r.f(identifier, "identifier");
        r.f(serverDescription, "serverDescription");
        r.f(metadata, "metadata");
        r.f(availablePackages, "availablePackages");
        return new Offering(identifier, serverDescription, metadata, availablePackages, paywallData, paywallComponents);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Offering)) {
            return false;
        }
        Offering offering = (Offering) obj;
        return r.b(this.identifier, offering.identifier) && r.b(this.serverDescription, offering.serverDescription) && r.b(this.metadata, offering.metadata) && r.b(this.availablePackages, offering.availablePackages) && r.b(this.paywall, offering.paywall) && r.b(this.paywallComponents, offering.paywallComponents);
    }

    public final Package get(String s7) {
        r.f(s7, "s");
        return getPackage(s7);
    }

    public final Package getAnnual() {
        return (Package) this.annual$delegate.getValue();
    }

    public final List<Package> getAvailablePackages() {
        return this.availablePackages;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Package getLifetime() {
        return (Package) this.lifetime$delegate.getValue();
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getMetadataString(String key, String str) {
        r.f(key, "key");
        r.f(str, "default");
        Object obj = this.metadata.get(key);
        String str2 = obj instanceof String ? (String) obj : null;
        return str2 == null ? str : str2;
    }

    public final Package getMonthly() {
        return (Package) this.monthly$delegate.getValue();
    }

    public final Package getPackage(String identifier) {
        r.f(identifier, "identifier");
        for (Package r12 : this.availablePackages) {
            if (r.b(r12.getIdentifier(), identifier)) {
                return r12;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final PaywallData getPaywall() {
        return this.paywall;
    }

    public final PaywallComponents getPaywallComponents() {
        return this.paywallComponents;
    }

    public final String getServerDescription() {
        return this.serverDescription;
    }

    public final Package getSixMonth() {
        return (Package) this.sixMonth$delegate.getValue();
    }

    public final Package getThreeMonth() {
        return (Package) this.threeMonth$delegate.getValue();
    }

    public final Package getTwoMonth() {
        return (Package) this.twoMonth$delegate.getValue();
    }

    public final Package getWeekly() {
        return (Package) this.weekly$delegate.getValue();
    }

    public final boolean hasPaywall() {
        return (this.paywall == null && this.paywallComponents == null) ? false : true;
    }

    public int hashCode() {
        int iHashCode = ((((((this.identifier.hashCode() * 31) + this.serverDescription.hashCode()) * 31) + this.metadata.hashCode()) * 31) + this.availablePackages.hashCode()) * 31;
        PaywallData paywallData = this.paywall;
        int iHashCode2 = (iHashCode + (paywallData == null ? 0 : paywallData.hashCode())) * 31;
        PaywallComponents paywallComponents = this.paywallComponents;
        return iHashCode2 + (paywallComponents != null ? paywallComponents.hashCode() : 0);
    }

    public String toString() {
        return "Offering(identifier=" + this.identifier + ", serverDescription=" + this.serverDescription + ", metadata=" + this.metadata + ", availablePackages=" + this.availablePackages + ", paywall=" + this.paywall + ", paywallComponents=" + this.paywallComponents + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages, PaywallData paywallData) {
        this(identifier, serverDescription, metadata, availablePackages, paywallData, null, 32, null);
        r.f(identifier, "identifier");
        r.f(serverDescription, "serverDescription");
        r.f(metadata, "metadata");
        r.f(availablePackages, "availablePackages");
    }

    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages, PaywallData paywallData, PaywallComponents paywallComponents) {
        r.f(identifier, "identifier");
        r.f(serverDescription, "serverDescription");
        r.f(metadata, "metadata");
        r.f(availablePackages, "availablePackages");
        this.identifier = identifier;
        this.serverDescription = serverDescription;
        this.metadata = metadata;
        this.availablePackages = availablePackages;
        this.paywall = paywallData;
        this.paywallComponents = paywallComponents;
        this.lifetime$delegate = k.b(new Offering$lifetime$2(this));
        this.annual$delegate = k.b(new Offering$annual$2(this));
        this.sixMonth$delegate = k.b(new Offering$sixMonth$2(this));
        this.threeMonth$delegate = k.b(new Offering$threeMonth$2(this));
        this.twoMonth$delegate = k.b(new Offering$twoMonth$2(this));
        this.monthly$delegate = k.b(new Offering$monthly$2(this));
        this.weekly$delegate = k.b(new Offering$weekly$2(this));
    }

    public /* synthetic */ Offering(String str, String str2, Map map, List list, PaywallData paywallData, PaywallComponents paywallComponents, int i7, AbstractC2148j abstractC2148j) {
        this(str, str2, map, list, (i7 & 16) != 0 ? null : paywallData, (i7 & 32) != 0 ? null : paywallComponents);
    }
}
