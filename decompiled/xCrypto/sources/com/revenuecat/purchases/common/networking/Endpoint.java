package com.revenuecat.purchases.common.networking;

import W2.m;
import X2.x;
import android.net.Uri;
import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class Endpoint {
    private final String name;
    private final String pathTemplate;

    public static final class AliasUsers extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AliasUsers(String userId) {
            super("/v1/subscribers/%s/alias", "alias_users", null);
            r.f(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ AliasUsers copy$default(AliasUsers aliasUsers, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = aliasUsers.userId;
            }
            return aliasUsers.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final AliasUsers copy(String userId) {
            r.f(userId, "userId");
            return new AliasUsers(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AliasUsers) && r.b(this.userId, ((AliasUsers) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            r.e(str, "format(this, *args)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "AliasUsers(userId=" + this.userId + ')';
        }
    }

    public static final class GetAmazonReceipt extends Endpoint {
        private final String receiptId;
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetAmazonReceipt(String userId, String receiptId) {
            super("/v1/receipts/amazon/%s/%s", "get_amazon_receipt", null);
            r.f(userId, "userId");
            r.f(receiptId, "receiptId");
            this.userId = userId;
            this.receiptId = receiptId;
        }

        public static /* synthetic */ GetAmazonReceipt copy$default(GetAmazonReceipt getAmazonReceipt, String str, String str2, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = getAmazonReceipt.userId;
            }
            if ((i4 & 2) != 0) {
                str2 = getAmazonReceipt.receiptId;
            }
            return getAmazonReceipt.copy(str, str2);
        }

        public final String component1() {
            return this.userId;
        }

        public final String component2() {
            return this.receiptId;
        }

        public final GetAmazonReceipt copy(String userId, String receiptId) {
            r.f(userId, "userId");
            r.f(receiptId, "receiptId");
            return new GetAmazonReceipt(userId, receiptId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof GetAmazonReceipt)) {
                return false;
            }
            GetAmazonReceipt getAmazonReceipt = (GetAmazonReceipt) obj;
            return r.b(this.userId, getAmazonReceipt.userId) && r.b(this.receiptId, getAmazonReceipt.receiptId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId), this.receiptId}, 2));
            r.e(str, "format(this, *args)");
            return str;
        }

        public final String getReceiptId() {
            return this.receiptId;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.receiptId.hashCode();
        }

        public String toString() {
            return "GetAmazonReceipt(userId=" + this.userId + ", receiptId=" + this.receiptId + ')';
        }
    }

    public static final class GetCustomerCenterConfig extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCustomerCenterConfig(String userId) {
            super("/v1/customercenter/%s", "get_customer_center_config", null);
            r.f(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ GetCustomerCenterConfig copy$default(GetCustomerCenterConfig getCustomerCenterConfig, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = getCustomerCenterConfig.userId;
            }
            return getCustomerCenterConfig.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final GetCustomerCenterConfig copy(String userId) {
            r.f(userId, "userId");
            return new GetCustomerCenterConfig(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetCustomerCenterConfig) && r.b(this.userId, ((GetCustomerCenterConfig) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            r.e(str, "format(this, *args)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetCustomerCenterConfig(userId=" + this.userId + ')';
        }
    }

    public static final class GetCustomerInfo extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetCustomerInfo(String userId) {
            super("/v1/subscribers/%s", "get_customer", null);
            r.f(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ GetCustomerInfo copy$default(GetCustomerInfo getCustomerInfo, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = getCustomerInfo.userId;
            }
            return getCustomerInfo.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final GetCustomerInfo copy(String userId) {
            r.f(userId, "userId");
            return new GetCustomerInfo(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetCustomerInfo) && r.b(this.userId, ((GetCustomerInfo) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            r.e(str, "format(this, *args)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetCustomerInfo(userId=" + this.userId + ')';
        }
    }

    public static final class GetOfferings extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetOfferings(String userId) {
            super("/v1/subscribers/%s/offerings", "get_offerings", null);
            r.f(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ GetOfferings copy$default(GetOfferings getOfferings, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = getOfferings.userId;
            }
            return getOfferings.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final GetOfferings copy(String userId) {
            r.f(userId, "userId");
            return new GetOfferings(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetOfferings) && r.b(this.userId, ((GetOfferings) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            r.e(str, "format(this, *args)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetOfferings(userId=" + this.userId + ')';
        }
    }

    public static final class GetProductEntitlementMapping extends Endpoint {
        public static final GetProductEntitlementMapping INSTANCE = new GetProductEntitlementMapping();

        private GetProductEntitlementMapping() {
            super("/v1/product_entitlement_mapping", "get_product_entitlement_mapping", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    public static final class GetVirtualCurrencies extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetVirtualCurrencies(String userId) {
            super("/v1/subscribers/%s/virtual_currencies", "get_virtual_currencies", null);
            r.f(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ GetVirtualCurrencies copy$default(GetVirtualCurrencies getVirtualCurrencies, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = getVirtualCurrencies.userId;
            }
            return getVirtualCurrencies.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final GetVirtualCurrencies copy(String userId) {
            r.f(userId, "userId");
            return new GetVirtualCurrencies(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof GetVirtualCurrencies) && r.b(this.userId, ((GetVirtualCurrencies) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            r.e(str, "format(this, *args)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "GetVirtualCurrencies(userId=" + this.userId + ')';
        }
    }

    public static final class LogIn extends Endpoint {
        public static final LogIn INSTANCE = new LogIn();

        private LogIn() {
            super("/v1/subscribers/identify", "log_in", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    public static final class PostAttributes extends Endpoint {
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public PostAttributes(String userId) {
            super("/v1/subscribers/%s/attributes", "post_attributes", null);
            r.f(userId, "userId");
            this.userId = userId;
        }

        public static /* synthetic */ PostAttributes copy$default(PostAttributes postAttributes, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = postAttributes.userId;
            }
            return postAttributes.copy(str);
        }

        public final String component1() {
            return this.userId;
        }

        public final PostAttributes copy(String userId) {
            r.f(userId, "userId");
            return new PostAttributes(userId);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PostAttributes) && r.b(this.userId, ((PostAttributes) obj).userId);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId)}, 1));
            r.e(str, "format(this, *args)");
            return str;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return this.userId.hashCode();
        }

        public String toString() {
            return "PostAttributes(userId=" + this.userId + ')';
        }
    }

    public static final class PostDiagnostics extends Endpoint {
        public static final PostDiagnostics INSTANCE = new PostDiagnostics();

        private PostDiagnostics() {
            super("/v1/diagnostics", "post_diagnostics", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    public static final class PostPaywallEvents extends Endpoint {
        public static final PostPaywallEvents INSTANCE = new PostPaywallEvents();

        private PostPaywallEvents() {
            super("/v1/events", "post_paywall_events", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    public static final class PostReceipt extends Endpoint {
        public static final PostReceipt INSTANCE = new PostReceipt();

        private PostReceipt() {
            super("/v1/receipts", "post_receipt", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    public static final class PostRedeemWebPurchase extends Endpoint {
        public static final PostRedeemWebPurchase INSTANCE = new PostRedeemWebPurchase();

        private PostRedeemWebPurchase() {
            super("/v1/subscribers/redeem_purchase", "post_redeem_web_purchase", null);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            return getPathTemplate();
        }
    }

    public static final class WebBillingGetProducts extends Endpoint {
        private final Set<String> productIds;
        private final String userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WebBillingGetProducts(String userId, Set<String> productIds) {
            super("/rcbilling/v1/subscribers/%s/products?id=%s", "web_billing_get_products", null);
            r.f(userId, "userId");
            r.f(productIds, "productIds");
            this.userId = userId;
            this.productIds = productIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ WebBillingGetProducts copy$default(WebBillingGetProducts webBillingGetProducts, String str, Set set, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                str = webBillingGetProducts.userId;
            }
            if ((i4 & 2) != 0) {
                set = webBillingGetProducts.productIds;
            }
            return webBillingGetProducts.copy(str, set);
        }

        public final String component1() {
            return this.userId;
        }

        public final Set<String> component2() {
            return this.productIds;
        }

        public final WebBillingGetProducts copy(String userId, Set<String> productIds) {
            r.f(userId, "userId");
            r.f(productIds, "productIds");
            return new WebBillingGetProducts(userId, productIds);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WebBillingGetProducts)) {
                return false;
            }
            WebBillingGetProducts webBillingGetProducts = (WebBillingGetProducts) obj;
            return r.b(this.userId, webBillingGetProducts.userId) && r.b(this.productIds, webBillingGetProducts.productIds);
        }

        @Override // com.revenuecat.purchases.common.networking.Endpoint
        public String getPath() {
            String str = String.format(getPathTemplate(), Arrays.copyOf(new Object[]{Uri.encode(this.userId), x.Q(this.productIds, "&id=", null, null, 0, null, Endpoint$WebBillingGetProducts$getPath$1.INSTANCE, 30, null)}, 2));
            r.e(str, "format(this, *args)");
            return str;
        }

        public final Set<String> getProductIds() {
            return this.productIds;
        }

        public final String getUserId() {
            return this.userId;
        }

        public int hashCode() {
            return (this.userId.hashCode() * 31) + this.productIds.hashCode();
        }

        public String toString() {
            return "WebBillingGetProducts(userId=" + this.userId + ", productIds=" + this.productIds + ')';
        }
    }

    public /* synthetic */ Endpoint(String str, String str2, AbstractC1585j abstractC1585j) {
        this(str, str2);
    }

    public final String getName() {
        return this.name;
    }

    public final boolean getNeedsNonceToPerformSigning() {
        if (this instanceof GetCustomerInfo ? true : r.b(this, LogIn.INSTANCE) ? true : r.b(this, PostReceipt.INSTANCE) ? true : r.b(this, PostRedeemWebPurchase.INSTANCE) ? true : this instanceof GetVirtualCurrencies) {
            return true;
        }
        if (this instanceof GetAmazonReceipt ? true : this instanceof GetOfferings ? true : this instanceof PostAttributes ? true : r.b(this, PostDiagnostics.INSTANCE) ? true : r.b(this, PostPaywallEvents.INSTANCE) ? true : r.b(this, GetProductEntitlementMapping.INSTANCE) ? true : this instanceof GetCustomerCenterConfig ? true : this instanceof WebBillingGetProducts ? true : this instanceof AliasUsers) {
            return false;
        }
        throw new m();
    }

    public abstract String getPath();

    public final String getPathTemplate() {
        return this.pathTemplate;
    }

    public final boolean getSupportsFallbackBaseURLs() {
        if (this instanceof GetOfferings ? true : r.b(this, GetProductEntitlementMapping.INSTANCE)) {
            return true;
        }
        if (this instanceof LogIn ? true : r.b(this, PostReceipt.INSTANCE) ? true : r.b(this, PostRedeemWebPurchase.INSTANCE) ? true : this instanceof GetAmazonReceipt ? true : this instanceof PostAttributes ? true : r.b(this, PostDiagnostics.INSTANCE) ? true : r.b(this, PostPaywallEvents.INSTANCE) ? true : this instanceof GetCustomerInfo ? true : this instanceof GetCustomerCenterConfig ? true : this instanceof GetVirtualCurrencies ? true : this instanceof WebBillingGetProducts ? true : this instanceof AliasUsers) {
            return false;
        }
        throw new m();
    }

    public final boolean getSupportsSignatureVerification() {
        if (this instanceof GetCustomerInfo ? true : r.b(this, LogIn.INSTANCE) ? true : r.b(this, PostReceipt.INSTANCE) ? true : this instanceof GetOfferings ? true : r.b(this, GetProductEntitlementMapping.INSTANCE) ? true : r.b(this, PostRedeemWebPurchase.INSTANCE) ? true : this instanceof GetVirtualCurrencies) {
            return true;
        }
        if (this instanceof GetAmazonReceipt ? true : this instanceof PostAttributes ? true : r.b(this, PostDiagnostics.INSTANCE) ? true : r.b(this, PostPaywallEvents.INSTANCE) ? true : this instanceof GetCustomerCenterConfig ? true : this instanceof WebBillingGetProducts ? true : this instanceof AliasUsers) {
            return false;
        }
        throw new m();
    }

    private Endpoint(String str, String str2) {
        this.pathTemplate = str;
        this.name = str2;
    }
}
