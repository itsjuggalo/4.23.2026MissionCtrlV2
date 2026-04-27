package com.revenuecat.purchases;

import java.util.Date;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
final class ComparableData {
    private final Map<String, Date> allExpirationDatesByProduct;
    private final Map<String, Date> allPurchaseDatesByProduct;
    private final EntitlementInfos entitlements;
    private final Date firstSeen;
    private final String originalAppUserId;
    private final Date originalPurchaseDate;
    private final int schemaVersion;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparableData(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, int i4, Date firstSeen, String originalAppUserId, Date date) {
        r.f(entitlements, "entitlements");
        r.f(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        r.f(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        r.f(firstSeen, "firstSeen");
        r.f(originalAppUserId, "originalAppUserId");
        this.entitlements = entitlements;
        this.allExpirationDatesByProduct = allExpirationDatesByProduct;
        this.allPurchaseDatesByProduct = allPurchaseDatesByProduct;
        this.schemaVersion = i4;
        this.firstSeen = firstSeen;
        this.originalAppUserId = originalAppUserId;
        this.originalPurchaseDate = date;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ComparableData copy$default(ComparableData comparableData, EntitlementInfos entitlementInfos, Map map, Map map2, int i4, Date date, String str, Date date2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            entitlementInfos = comparableData.entitlements;
        }
        if ((i5 & 2) != 0) {
            map = comparableData.allExpirationDatesByProduct;
        }
        if ((i5 & 4) != 0) {
            map2 = comparableData.allPurchaseDatesByProduct;
        }
        if ((i5 & 8) != 0) {
            i4 = comparableData.schemaVersion;
        }
        if ((i5 & 16) != 0) {
            date = comparableData.firstSeen;
        }
        if ((i5 & 32) != 0) {
            str = comparableData.originalAppUserId;
        }
        if ((i5 & 64) != 0) {
            date2 = comparableData.originalPurchaseDate;
        }
        String str2 = str;
        Date date3 = date2;
        Date date4 = date;
        Map map3 = map2;
        return comparableData.copy(entitlementInfos, map, map3, i4, date4, str2, date3);
    }

    public final EntitlementInfos component1() {
        return this.entitlements;
    }

    public final Map<String, Date> component2() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> component3() {
        return this.allPurchaseDatesByProduct;
    }

    public final int component4() {
        return this.schemaVersion;
    }

    public final Date component5() {
        return this.firstSeen;
    }

    public final String component6() {
        return this.originalAppUserId;
    }

    public final Date component7() {
        return this.originalPurchaseDate;
    }

    public final ComparableData copy(EntitlementInfos entitlements, Map<String, ? extends Date> allExpirationDatesByProduct, Map<String, ? extends Date> allPurchaseDatesByProduct, int i4, Date firstSeen, String originalAppUserId, Date date) {
        r.f(entitlements, "entitlements");
        r.f(allExpirationDatesByProduct, "allExpirationDatesByProduct");
        r.f(allPurchaseDatesByProduct, "allPurchaseDatesByProduct");
        r.f(firstSeen, "firstSeen");
        r.f(originalAppUserId, "originalAppUserId");
        return new ComparableData(entitlements, allExpirationDatesByProduct, allPurchaseDatesByProduct, i4, firstSeen, originalAppUserId, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ComparableData)) {
            return false;
        }
        ComparableData comparableData = (ComparableData) obj;
        return r.b(this.entitlements, comparableData.entitlements) && r.b(this.allExpirationDatesByProduct, comparableData.allExpirationDatesByProduct) && r.b(this.allPurchaseDatesByProduct, comparableData.allPurchaseDatesByProduct) && this.schemaVersion == comparableData.schemaVersion && r.b(this.firstSeen, comparableData.firstSeen) && r.b(this.originalAppUserId, comparableData.originalAppUserId) && r.b(this.originalPurchaseDate, comparableData.originalPurchaseDate);
    }

    public final Map<String, Date> getAllExpirationDatesByProduct() {
        return this.allExpirationDatesByProduct;
    }

    public final Map<String, Date> getAllPurchaseDatesByProduct() {
        return this.allPurchaseDatesByProduct;
    }

    public final EntitlementInfos getEntitlements() {
        return this.entitlements;
    }

    public final Date getFirstSeen() {
        return this.firstSeen;
    }

    public final String getOriginalAppUserId() {
        return this.originalAppUserId;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final int getSchemaVersion() {
        return this.schemaVersion;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.entitlements.hashCode() * 31) + this.allExpirationDatesByProduct.hashCode()) * 31) + this.allPurchaseDatesByProduct.hashCode()) * 31) + Integer.hashCode(this.schemaVersion)) * 31) + this.firstSeen.hashCode()) * 31) + this.originalAppUserId.hashCode()) * 31;
        Date date = this.originalPurchaseDate;
        return iHashCode + (date == null ? 0 : date.hashCode());
    }

    public String toString() {
        return "ComparableData(entitlements=" + this.entitlements + ", allExpirationDatesByProduct=" + this.allExpirationDatesByProduct + ", allPurchaseDatesByProduct=" + this.allPurchaseDatesByProduct + ", schemaVersion=" + this.schemaVersion + ", firstSeen=" + this.firstSeen + ", originalAppUserId=" + this.originalAppUserId + ", originalPurchaseDate=" + this.originalPurchaseDate + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ComparableData(CustomerInfo customerInfo) {
        this(customerInfo.getEntitlements(), customerInfo.getAllExpirationDatesByProduct(), customerInfo.getAllPurchaseDatesByProduct(), customerInfo.getSchemaVersion(), customerInfo.getFirstSeen(), customerInfo.getOriginalAppUserId(), customerInfo.getOriginalPurchaseDate());
        r.f(customerInfo, "customerInfo");
    }
}
