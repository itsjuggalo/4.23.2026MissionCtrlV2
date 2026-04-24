package com.revenuecat.purchases.common.offlineentitlements;

import com.revenuecat.purchases.models.StoreTransaction;
import java.util.Date;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class PurchasedProduct {
    private final String basePlanId;
    private final List<String> entitlements;
    private final Date expiresDate;
    private final String productIdentifier;
    private final StoreTransaction storeTransaction;

    public PurchasedProduct(String productIdentifier, String str, StoreTransaction storeTransaction, List<String> entitlements, Date date) {
        r.f(productIdentifier, "productIdentifier");
        r.f(storeTransaction, "storeTransaction");
        r.f(entitlements, "entitlements");
        this.productIdentifier = productIdentifier;
        this.basePlanId = str;
        this.storeTransaction = storeTransaction;
        this.entitlements = entitlements;
        this.expiresDate = date;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PurchasedProduct copy$default(PurchasedProduct purchasedProduct, String str, String str2, StoreTransaction storeTransaction, List list, Date date, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = purchasedProduct.productIdentifier;
        }
        if ((i4 & 2) != 0) {
            str2 = purchasedProduct.basePlanId;
        }
        if ((i4 & 4) != 0) {
            storeTransaction = purchasedProduct.storeTransaction;
        }
        if ((i4 & 8) != 0) {
            list = purchasedProduct.entitlements;
        }
        if ((i4 & 16) != 0) {
            date = purchasedProduct.expiresDate;
        }
        Date date2 = date;
        StoreTransaction storeTransaction2 = storeTransaction;
        return purchasedProduct.copy(str, str2, storeTransaction2, list, date2);
    }

    public final String component1() {
        return this.productIdentifier;
    }

    public final String component2() {
        return this.basePlanId;
    }

    public final StoreTransaction component3() {
        return this.storeTransaction;
    }

    public final List<String> component4() {
        return this.entitlements;
    }

    public final Date component5() {
        return this.expiresDate;
    }

    public final PurchasedProduct copy(String productIdentifier, String str, StoreTransaction storeTransaction, List<String> entitlements, Date date) {
        r.f(productIdentifier, "productIdentifier");
        r.f(storeTransaction, "storeTransaction");
        r.f(entitlements, "entitlements");
        return new PurchasedProduct(productIdentifier, str, storeTransaction, entitlements, date);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PurchasedProduct)) {
            return false;
        }
        PurchasedProduct purchasedProduct = (PurchasedProduct) obj;
        return r.b(this.productIdentifier, purchasedProduct.productIdentifier) && r.b(this.basePlanId, purchasedProduct.basePlanId) && r.b(this.storeTransaction, purchasedProduct.storeTransaction) && r.b(this.entitlements, purchasedProduct.entitlements) && r.b(this.expiresDate, purchasedProduct.expiresDate);
    }

    public final String getBasePlanId() {
        return this.basePlanId;
    }

    public final List<String> getEntitlements() {
        return this.entitlements;
    }

    public final Date getExpiresDate() {
        return this.expiresDate;
    }

    public final String getProductIdentifier() {
        return this.productIdentifier;
    }

    public final StoreTransaction getStoreTransaction() {
        return this.storeTransaction;
    }

    public int hashCode() {
        int iHashCode = this.productIdentifier.hashCode() * 31;
        String str = this.basePlanId;
        int iHashCode2 = (((((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.storeTransaction.hashCode()) * 31) + this.entitlements.hashCode()) * 31;
        Date date = this.expiresDate;
        return iHashCode2 + (date != null ? date.hashCode() : 0);
    }

    public String toString() {
        return "PurchasedProduct(productIdentifier=" + this.productIdentifier + ", basePlanId=" + this.basePlanId + ", storeTransaction=" + this.storeTransaction + ", entitlements=" + this.entitlements + ", expiresDate=" + this.expiresDate + ')';
    }
}
