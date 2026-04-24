package com.revenuecat.purchases;

import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001KBQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000e\u0010\u000fB;\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0005\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\u000e\u0010\u0010J\u0019\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001d\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0002¢\u0006\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001d\u001a\u0004\b \u0010\u001fR#\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006¢\u0006\f\n\u0004\b\t\u0010$\u001a\u0004\b%\u0010&R\"\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010'\u0012\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\"\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\r\u0010,\u0012\u0004\b/\u0010+\u001a\u0004\b-\u0010.R\u001d\u00104\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b0\u00101\u001a\u0004\b2\u00103R\u001d\u00107\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b5\u00101\u001a\u0004\b6\u00103R\u001d\u0010:\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b8\u00101\u001a\u0004\b9\u00103R\u001d\u0010=\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b;\u00101\u001a\u0004\b<\u00103R\u001d\u0010@\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b>\u00101\u001a\u0004\b?\u00103R\u001d\u0010C\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bA\u00101\u001a\u0004\bB\u00103R\u001d\u0010F\u001a\u0004\u0018\u00010\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bD\u00101\u001a\u0004\bE\u00103R\u0017\u0010H\u001a\u00020G8G¢\u0006\f\u0012\u0004\bJ\u0010+\u001a\u0004\bH\u0010I¨\u0006L"}, d2 = {"Lcom/revenuecat/purchases/Offering;", "", "", "identifier", "serverDescription", "", "metadata", "", "Lcom/revenuecat/purchases/Package;", "availablePackages", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "paywall", "Lcom/revenuecat/purchases/Offering$PaywallComponents;", "paywallComponents", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;Lcom/revenuecat/purchases/paywalls/PaywallData;Lcom/revenuecat/purchases/Offering$PaywallComponents;)V", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/List;)V", "Lcom/revenuecat/purchases/PackageType;", "packageType", "findPackage", "(Lcom/revenuecat/purchases/PackageType;)Lcom/revenuecat/purchases/Package;", "s", com.amazon.a.a.o.b.au, "(Ljava/lang/String;)Lcom/revenuecat/purchases/Package;", "getPackage", "key", "default", "getMetadataString", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "Ljava/lang/String;", "getIdentifier", "()Ljava/lang/String;", "getServerDescription", "Ljava/util/Map;", "getMetadata", "()Ljava/util/Map;", "Ljava/util/List;", "getAvailablePackages", "()Ljava/util/List;", "Lcom/revenuecat/purchases/paywalls/PaywallData;", "getPaywall", "()Lcom/revenuecat/purchases/paywalls/PaywallData;", "getPaywall$annotations", "()V", "Lcom/revenuecat/purchases/Offering$PaywallComponents;", "getPaywallComponents", "()Lcom/revenuecat/purchases/Offering$PaywallComponents;", "getPaywallComponents$annotations", "lifetime$delegate", "Lo5/k;", "getLifetime", "()Lcom/revenuecat/purchases/Package;", "lifetime", "annual$delegate", "getAnnual", "annual", "sixMonth$delegate", "getSixMonth", "sixMonth", "threeMonth$delegate", "getThreeMonth", "threeMonth", "twoMonth$delegate", "getTwoMonth", "twoMonth", "monthly$delegate", "getMonthly", "monthly", "weekly$delegate", "getWeekly", "weekly", "", "hasPaywall", "()Z", "hasPaywall$annotations", "PaywallComponents", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public final class Offering {

    /* JADX INFO: renamed from: annual$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k annual;
    private final List<Package> availablePackages;
    private final String identifier;

    /* JADX INFO: renamed from: lifetime$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k lifetime;
    private final Map<String, Object> metadata;

    /* JADX INFO: renamed from: monthly$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k monthly;
    private final PaywallData paywall;
    private final PaywallComponents paywallComponents;
    private final String serverDescription;

    /* JADX INFO: renamed from: sixMonth$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k sixMonth;

    /* JADX INFO: renamed from: threeMonth$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k threeMonth;

    /* JADX INFO: renamed from: twoMonth$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k twoMonth;

    /* JADX INFO: renamed from: weekly$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k weekly;

    @InternalRevenueCatAPI
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/revenuecat/purchases/Offering$PaywallComponents;", "", "uiConfig", "Lcom/revenuecat/purchases/UiConfig;", "data", "Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "(Lcom/revenuecat/purchases/UiConfig;Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;)V", "getData", "()Lcom/revenuecat/purchases/paywalls/components/common/PaywallComponentsData;", "getUiConfig", "()Lcom/revenuecat/purchases/UiConfig;", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class PaywallComponents {
        private final PaywallComponentsData data;
        private final UiConfig uiConfig;

        public PaywallComponents(UiConfig uiConfig, PaywallComponentsData data) {
            AbstractC2304t.f(uiConfig, "uiConfig");
            AbstractC2304t.f(data, "data");
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
            return AbstractC2304t.b(this.uiConfig, paywallComponents.uiConfig) && AbstractC2304t.b(this.data, paywallComponents.data);
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
        this(identifier, serverDescription, metadata, availablePackages, null, null);
        AbstractC2304t.f(identifier, "identifier");
        AbstractC2304t.f(serverDescription, "serverDescription");
        AbstractC2304t.f(metadata, "metadata");
        AbstractC2304t.f(availablePackages, "availablePackages");
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
            if (AbstractC2304t.b(((Package) next).getIdentifier(), packageType.getIdentifier())) {
                break;
            }
        }
        return (Package) next;
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getPaywall$annotations() {
    }

    @InternalRevenueCatAPI
    public static /* synthetic */ void getPaywallComponents$annotations() {
    }

    public static /* synthetic */ void hasPaywall$annotations() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Offering)) {
            return false;
        }
        Offering offering = (Offering) obj;
        return AbstractC2304t.b(this.identifier, offering.identifier) && AbstractC2304t.b(this.serverDescription, offering.serverDescription) && AbstractC2304t.b(this.metadata, offering.metadata) && AbstractC2304t.b(this.availablePackages, offering.availablePackages) && AbstractC2304t.b(this.paywall, offering.paywall) && AbstractC2304t.b(this.paywallComponents, offering.paywallComponents);
    }

    public final Package get(String s8) {
        AbstractC2304t.f(s8, "s");
        return getPackage(s8);
    }

    public final Package getAnnual() {
        return (Package) this.annual.getValue();
    }

    public final List<Package> getAvailablePackages() {
        return this.availablePackages;
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final Package getLifetime() {
        return (Package) this.lifetime.getValue();
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getMetadataString(String key, String str) {
        AbstractC2304t.f(key, "key");
        AbstractC2304t.f(str, "default");
        Object obj = this.metadata.get(key);
        String str2 = obj instanceof String ? (String) obj : null;
        return str2 == null ? str : str2;
    }

    public final Package getMonthly() {
        return (Package) this.monthly.getValue();
    }

    public final Package getPackage(String identifier) {
        AbstractC2304t.f(identifier, "identifier");
        for (Package r12 : this.availablePackages) {
            if (AbstractC2304t.b(r12.getIdentifier(), identifier)) {
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
        return (Package) this.sixMonth.getValue();
    }

    public final Package getThreeMonth() {
        return (Package) this.threeMonth.getValue();
    }

    public final Package getTwoMonth() {
        return (Package) this.twoMonth.getValue();
    }

    public final Package getWeekly() {
        return (Package) this.weekly.getValue();
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

    public Offering(String identifier, String serverDescription, Map<String, ? extends Object> metadata, List<Package> availablePackages, PaywallData paywallData, PaywallComponents paywallComponents) {
        AbstractC2304t.f(identifier, "identifier");
        AbstractC2304t.f(serverDescription, "serverDescription");
        AbstractC2304t.f(metadata, "metadata");
        AbstractC2304t.f(availablePackages, "availablePackages");
        this.identifier = identifier;
        this.serverDescription = serverDescription;
        this.metadata = metadata;
        this.availablePackages = availablePackages;
        this.paywall = paywallData;
        this.paywallComponents = paywallComponents;
        this.lifetime = AbstractC2484l.a(new Offering$lifetime$2(this));
        this.annual = AbstractC2484l.a(new Offering$annual$2(this));
        this.sixMonth = AbstractC2484l.a(new Offering$sixMonth$2(this));
        this.threeMonth = AbstractC2484l.a(new Offering$threeMonth$2(this));
        this.twoMonth = AbstractC2484l.a(new Offering$twoMonth$2(this));
        this.monthly = AbstractC2484l.a(new Offering$monthly$2(this));
        this.weekly = AbstractC2484l.a(new Offering$weekly$2(this));
    }

    public /* synthetic */ Offering(String str, String str2, Map map, List list, PaywallData paywallData, PaywallComponents paywallComponents, int i8, AbstractC2296k abstractC2296k) {
        this(str, str2, map, list, (i8 & 16) != 0 ? null : paywallData, (i8 & 32) != 0 ? null : paywallComponents);
    }
}
