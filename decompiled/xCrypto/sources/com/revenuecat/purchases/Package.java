package com.revenuecat.purchases;

import com.revenuecat.purchases.models.StoreProduct;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class Package {
    private final String identifier;
    private final PackageType packageType;
    private final PresentedOfferingContext presentedOfferingContext;
    private final StoreProduct product;

    public Package(String identifier, PackageType packageType, StoreProduct product, PresentedOfferingContext presentedOfferingContext) {
        r.f(identifier, "identifier");
        r.f(packageType, "packageType");
        r.f(product, "product");
        r.f(presentedOfferingContext, "presentedOfferingContext");
        this.identifier = identifier;
        this.packageType = packageType;
        this.product = product;
        this.presentedOfferingContext = presentedOfferingContext;
    }

    public static /* synthetic */ Package copy$default(Package r02, String str, PackageType packageType, StoreProduct storeProduct, PresentedOfferingContext presentedOfferingContext, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = r02.identifier;
        }
        if ((i4 & 2) != 0) {
            packageType = r02.packageType;
        }
        if ((i4 & 4) != 0) {
            storeProduct = r02.product;
        }
        if ((i4 & 8) != 0) {
            presentedOfferingContext = r02.presentedOfferingContext;
        }
        return r02.copy(str, packageType, storeProduct, presentedOfferingContext);
    }

    public static /* synthetic */ void getOffering$annotations() {
    }

    public final String component1() {
        return this.identifier;
    }

    public final PackageType component2() {
        return this.packageType;
    }

    public final StoreProduct component3() {
        return this.product;
    }

    public final PresentedOfferingContext component4() {
        return this.presentedOfferingContext;
    }

    public final Package copy(String identifier, PackageType packageType, StoreProduct product, PresentedOfferingContext presentedOfferingContext) {
        r.f(identifier, "identifier");
        r.f(packageType, "packageType");
        r.f(product, "product");
        r.f(presentedOfferingContext, "presentedOfferingContext");
        return new Package(identifier, packageType, product, presentedOfferingContext);
    }

    public final Package copy$purchases_defaultsRelease(PresentedOfferingContext presentedOfferingContext) {
        r.f(presentedOfferingContext, "presentedOfferingContext");
        return new Package(this.identifier, this.packageType, this.product.copyWithPresentedOfferingContext(presentedOfferingContext), presentedOfferingContext);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Package)) {
            return false;
        }
        Package r5 = (Package) obj;
        return r.b(this.identifier, r5.identifier) && this.packageType == r5.packageType && r.b(this.product, r5.product) && r.b(this.presentedOfferingContext, r5.presentedOfferingContext);
    }

    public final String getIdentifier() {
        return this.identifier;
    }

    public final String getOffering() {
        String offeringIdentifier = this.presentedOfferingContext.getOfferingIdentifier();
        return offeringIdentifier == null ? "" : offeringIdentifier;
    }

    public final PackageType getPackageType() {
        return this.packageType;
    }

    public final PresentedOfferingContext getPresentedOfferingContext() {
        return this.presentedOfferingContext;
    }

    public final StoreProduct getProduct() {
        return this.product;
    }

    public int hashCode() {
        return (((((this.identifier.hashCode() * 31) + this.packageType.hashCode()) * 31) + this.product.hashCode()) * 31) + this.presentedOfferingContext.hashCode();
    }

    public String toString() {
        return "Package(identifier=" + this.identifier + ", packageType=" + this.packageType + ", product=" + this.product + ", presentedOfferingContext=" + this.presentedOfferingContext + ')';
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Package(String identifier, PackageType packageType, StoreProduct product, String offering) {
        this(identifier, packageType, product, new PresentedOfferingContext(offering));
        r.f(identifier, "identifier");
        r.f(packageType, "packageType");
        r.f(product, "product");
        r.f(offering, "offering");
    }
}
