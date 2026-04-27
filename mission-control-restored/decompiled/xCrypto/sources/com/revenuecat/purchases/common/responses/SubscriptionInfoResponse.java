package com.revenuecat.purchases.common.responses;

import F3.b;
import H3.e;
import I3.d;
import J3.AbstractC0325a0;
import J3.k0;
import J3.o0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.OwnershipType;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.utils.serializers.ISO8601DateSerializer;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class SubscriptionInfoResponse {
    private final Date autoResumeDate;
    private final Date billingIssuesDetectedAt;
    private final String displayName;
    private final Date expiresDate;
    private final Date gracePeriodExpiresDate;
    private final boolean isSandbox;
    private final String managementURL;
    private final Date originalPurchaseDate;
    private final OwnershipType ownershipType;
    private final PeriodType periodType;
    private final PriceResponse price;
    private final String productPlanIdentifier;
    private final Date purchaseDate;
    private final Date refundedAt;
    private final Store store;
    private final String storeTransactionId;
    private final Date unsubscribeDetectedAt;
    public static final Companion Companion = new Companion(null);
    private static final b[] $childSerializers = {null, null, null, Store.Companion.serializer(), null, null, null, null, OwnershipType.Companion.serializer(), PeriodType.Companion.serializer(), null, null, null, null, null, null, null};

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return SubscriptionInfoResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SubscriptionInfoResponse(int i4, Date date, Date date2, Date date3, Store store, boolean z4, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, k0 k0Var) {
        if (537 != (i4 & 537)) {
            AbstractC0325a0.a(i4, 537, SubscriptionInfoResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.purchaseDate = date;
        if ((i4 & 2) == 0) {
            this.originalPurchaseDate = null;
        } else {
            this.originalPurchaseDate = date2;
        }
        if ((i4 & 4) == 0) {
            this.expiresDate = null;
        } else {
            this.expiresDate = date3;
        }
        this.store = store;
        this.isSandbox = z4;
        if ((i4 & 32) == 0) {
            this.unsubscribeDetectedAt = null;
        } else {
            this.unsubscribeDetectedAt = date4;
        }
        if ((i4 & 64) == 0) {
            this.billingIssuesDetectedAt = null;
        } else {
            this.billingIssuesDetectedAt = date5;
        }
        if ((i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) == 0) {
            this.gracePeriodExpiresDate = null;
        } else {
            this.gracePeriodExpiresDate = date6;
        }
        if ((i4 & 256) == 0) {
            this.ownershipType = OwnershipType.UNKNOWN;
        } else {
            this.ownershipType = ownershipType;
        }
        this.periodType = periodType;
        if ((i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) == 0) {
            this.refundedAt = null;
        } else {
            this.refundedAt = date7;
        }
        if ((i4 & 2048) == 0) {
            this.storeTransactionId = null;
        } else {
            this.storeTransactionId = str;
        }
        if ((i4 & 4096) == 0) {
            this.autoResumeDate = null;
        } else {
            this.autoResumeDate = date8;
        }
        if ((i4 & UserMetadata.MAX_INTERNAL_KEY_SIZE) == 0) {
            this.displayName = null;
        } else {
            this.displayName = str2;
        }
        if ((i4 & 16384) == 0) {
            this.price = null;
        } else {
            this.price = priceResponse;
        }
        if ((32768 & i4) == 0) {
            this.productPlanIdentifier = null;
        } else {
            this.productPlanIdentifier = str3;
        }
        if ((i4 & 65536) == 0) {
            this.managementURL = null;
        } else {
            this.managementURL = str4;
        }
    }

    public static /* synthetic */ SubscriptionInfoResponse copy$default(SubscriptionInfoResponse subscriptionInfoResponse, Date date, Date date2, Date date3, Store store, boolean z4, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, int i4, Object obj) {
        String str5;
        String str6;
        Date date9;
        SubscriptionInfoResponse subscriptionInfoResponse2;
        PriceResponse priceResponse2;
        Date date10;
        Date date11;
        Store store2;
        boolean z5;
        Date date12;
        Date date13;
        Date date14;
        OwnershipType ownershipType2;
        PeriodType periodType2;
        Date date15;
        String str7;
        Date date16;
        String str8;
        Date date17 = (i4 & 1) != 0 ? subscriptionInfoResponse.purchaseDate : date;
        Date date18 = (i4 & 2) != 0 ? subscriptionInfoResponse.originalPurchaseDate : date2;
        Date date19 = (i4 & 4) != 0 ? subscriptionInfoResponse.expiresDate : date3;
        Store store3 = (i4 & 8) != 0 ? subscriptionInfoResponse.store : store;
        boolean z6 = (i4 & 16) != 0 ? subscriptionInfoResponse.isSandbox : z4;
        Date date20 = (i4 & 32) != 0 ? subscriptionInfoResponse.unsubscribeDetectedAt : date4;
        Date date21 = (i4 & 64) != 0 ? subscriptionInfoResponse.billingIssuesDetectedAt : date5;
        Date date22 = (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? subscriptionInfoResponse.gracePeriodExpiresDate : date6;
        OwnershipType ownershipType3 = (i4 & 256) != 0 ? subscriptionInfoResponse.ownershipType : ownershipType;
        PeriodType periodType3 = (i4 & 512) != 0 ? subscriptionInfoResponse.periodType : periodType;
        Date date23 = (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? subscriptionInfoResponse.refundedAt : date7;
        String str9 = (i4 & 2048) != 0 ? subscriptionInfoResponse.storeTransactionId : str;
        Date date24 = (i4 & 4096) != 0 ? subscriptionInfoResponse.autoResumeDate : date8;
        String str10 = (i4 & UserMetadata.MAX_INTERNAL_KEY_SIZE) != 0 ? subscriptionInfoResponse.displayName : str2;
        Date date25 = date17;
        PriceResponse priceResponse3 = (i4 & 16384) != 0 ? subscriptionInfoResponse.price : priceResponse;
        String str11 = (i4 & 32768) != 0 ? subscriptionInfoResponse.productPlanIdentifier : str3;
        if ((i4 & 65536) != 0) {
            str6 = str11;
            str5 = subscriptionInfoResponse.managementURL;
            priceResponse2 = priceResponse3;
            date10 = date18;
            date11 = date19;
            store2 = store3;
            z5 = z6;
            date12 = date20;
            date13 = date21;
            date14 = date22;
            ownershipType2 = ownershipType3;
            periodType2 = periodType3;
            date15 = date23;
            str7 = str9;
            date16 = date24;
            str8 = str10;
            date9 = date25;
            subscriptionInfoResponse2 = subscriptionInfoResponse;
        } else {
            str5 = str4;
            str6 = str11;
            date9 = date25;
            subscriptionInfoResponse2 = subscriptionInfoResponse;
            priceResponse2 = priceResponse3;
            date10 = date18;
            date11 = date19;
            store2 = store3;
            z5 = z6;
            date12 = date20;
            date13 = date21;
            date14 = date22;
            ownershipType2 = ownershipType3;
            periodType2 = periodType3;
            date15 = date23;
            str7 = str9;
            date16 = date24;
            str8 = str10;
        }
        return subscriptionInfoResponse2.copy(date9, date10, date11, store2, z5, date12, date13, date14, ownershipType2, periodType2, date15, str7, date16, str8, priceResponse2, str6, str5);
    }

    public static /* synthetic */ void getAutoResumeDate$annotations() {
    }

    public static /* synthetic */ void getBillingIssuesDetectedAt$annotations() {
    }

    public static /* synthetic */ void getDisplayName$annotations() {
    }

    public static /* synthetic */ void getExpiresDate$annotations() {
    }

    public static /* synthetic */ void getGracePeriodExpiresDate$annotations() {
    }

    public static /* synthetic */ void getManagementURL$annotations() {
    }

    public static /* synthetic */ void getOriginalPurchaseDate$annotations() {
    }

    public static /* synthetic */ void getOwnershipType$annotations() {
    }

    public static /* synthetic */ void getPeriodType$annotations() {
    }

    public static /* synthetic */ void getPrice$annotations() {
    }

    public static /* synthetic */ void getProductPlanIdentifier$annotations() {
    }

    public static /* synthetic */ void getPurchaseDate$annotations() {
    }

    public static /* synthetic */ void getRefundedAt$annotations() {
    }

    public static /* synthetic */ void getStore$annotations() {
    }

    public static /* synthetic */ void getStoreTransactionId$annotations() {
    }

    public static /* synthetic */ void getUnsubscribeDetectedAt$annotations() {
    }

    public static /* synthetic */ void isSandbox$annotations() {
    }

    public static final /* synthetic */ void write$Self(SubscriptionInfoResponse subscriptionInfoResponse, d dVar, e eVar) {
        b[] bVarArr = $childSerializers;
        ISO8601DateSerializer iSO8601DateSerializer = ISO8601DateSerializer.INSTANCE;
        dVar.u(eVar, 0, iSO8601DateSerializer, subscriptionInfoResponse.purchaseDate);
        if (dVar.j(eVar, 1) || subscriptionInfoResponse.originalPurchaseDate != null) {
            dVar.E(eVar, 1, iSO8601DateSerializer, subscriptionInfoResponse.originalPurchaseDate);
        }
        if (dVar.j(eVar, 2) || subscriptionInfoResponse.expiresDate != null) {
            dVar.E(eVar, 2, iSO8601DateSerializer, subscriptionInfoResponse.expiresDate);
        }
        dVar.u(eVar, 3, bVarArr[3], subscriptionInfoResponse.store);
        dVar.y(eVar, 4, subscriptionInfoResponse.isSandbox);
        if (dVar.j(eVar, 5) || subscriptionInfoResponse.unsubscribeDetectedAt != null) {
            dVar.E(eVar, 5, iSO8601DateSerializer, subscriptionInfoResponse.unsubscribeDetectedAt);
        }
        if (dVar.j(eVar, 6) || subscriptionInfoResponse.billingIssuesDetectedAt != null) {
            dVar.E(eVar, 6, iSO8601DateSerializer, subscriptionInfoResponse.billingIssuesDetectedAt);
        }
        if (dVar.j(eVar, 7) || subscriptionInfoResponse.gracePeriodExpiresDate != null) {
            dVar.E(eVar, 7, iSO8601DateSerializer, subscriptionInfoResponse.gracePeriodExpiresDate);
        }
        if (dVar.j(eVar, 8) || subscriptionInfoResponse.ownershipType != OwnershipType.UNKNOWN) {
            dVar.u(eVar, 8, bVarArr[8], subscriptionInfoResponse.ownershipType);
        }
        dVar.u(eVar, 9, bVarArr[9], subscriptionInfoResponse.periodType);
        if (dVar.j(eVar, 10) || subscriptionInfoResponse.refundedAt != null) {
            dVar.E(eVar, 10, iSO8601DateSerializer, subscriptionInfoResponse.refundedAt);
        }
        if (dVar.j(eVar, 11) || subscriptionInfoResponse.storeTransactionId != null) {
            dVar.E(eVar, 11, o0.f952a, subscriptionInfoResponse.storeTransactionId);
        }
        if (dVar.j(eVar, 12) || subscriptionInfoResponse.autoResumeDate != null) {
            dVar.E(eVar, 12, iSO8601DateSerializer, subscriptionInfoResponse.autoResumeDate);
        }
        if (dVar.j(eVar, 13) || subscriptionInfoResponse.displayName != null) {
            dVar.E(eVar, 13, o0.f952a, subscriptionInfoResponse.displayName);
        }
        if (dVar.j(eVar, 14) || subscriptionInfoResponse.price != null) {
            dVar.E(eVar, 14, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE, subscriptionInfoResponse.price);
        }
        if (dVar.j(eVar, 15) || subscriptionInfoResponse.productPlanIdentifier != null) {
            dVar.E(eVar, 15, o0.f952a, subscriptionInfoResponse.productPlanIdentifier);
        }
        if (!dVar.j(eVar, 16) && subscriptionInfoResponse.managementURL == null) {
            return;
        }
        dVar.E(eVar, 16, o0.f952a, subscriptionInfoResponse.managementURL);
    }

    public final Date component1() {
        return this.purchaseDate;
    }

    public final PeriodType component10() {
        return this.periodType;
    }

    public final Date component11() {
        return this.refundedAt;
    }

    public final String component12() {
        return this.storeTransactionId;
    }

    public final Date component13() {
        return this.autoResumeDate;
    }

    public final String component14() {
        return this.displayName;
    }

    public final PriceResponse component15() {
        return this.price;
    }

    public final String component16() {
        return this.productPlanIdentifier;
    }

    public final String component17() {
        return this.managementURL;
    }

    public final Date component2() {
        return this.originalPurchaseDate;
    }

    public final Date component3() {
        return this.expiresDate;
    }

    public final Store component4() {
        return this.store;
    }

    public final boolean component5() {
        return this.isSandbox;
    }

    public final Date component6() {
        return this.unsubscribeDetectedAt;
    }

    public final Date component7() {
        return this.billingIssuesDetectedAt;
    }

    public final Date component8() {
        return this.gracePeriodExpiresDate;
    }

    public final OwnershipType component9() {
        return this.ownershipType;
    }

    public final SubscriptionInfoResponse copy(Date purchaseDate, Date date, Date date2, Store store, boolean z4, Date date3, Date date4, Date date5, OwnershipType ownershipType, PeriodType periodType, Date date6, String str, Date date7, String str2, PriceResponse priceResponse, String str3, String str4) {
        r.f(purchaseDate, "purchaseDate");
        r.f(store, "store");
        r.f(ownershipType, "ownershipType");
        r.f(periodType, "periodType");
        return new SubscriptionInfoResponse(purchaseDate, date, date2, store, z4, date3, date4, date5, ownershipType, periodType, date6, str, date7, str2, priceResponse, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionInfoResponse)) {
            return false;
        }
        SubscriptionInfoResponse subscriptionInfoResponse = (SubscriptionInfoResponse) obj;
        return r.b(this.purchaseDate, subscriptionInfoResponse.purchaseDate) && r.b(this.originalPurchaseDate, subscriptionInfoResponse.originalPurchaseDate) && r.b(this.expiresDate, subscriptionInfoResponse.expiresDate) && this.store == subscriptionInfoResponse.store && this.isSandbox == subscriptionInfoResponse.isSandbox && r.b(this.unsubscribeDetectedAt, subscriptionInfoResponse.unsubscribeDetectedAt) && r.b(this.billingIssuesDetectedAt, subscriptionInfoResponse.billingIssuesDetectedAt) && r.b(this.gracePeriodExpiresDate, subscriptionInfoResponse.gracePeriodExpiresDate) && this.ownershipType == subscriptionInfoResponse.ownershipType && this.periodType == subscriptionInfoResponse.periodType && r.b(this.refundedAt, subscriptionInfoResponse.refundedAt) && r.b(this.storeTransactionId, subscriptionInfoResponse.storeTransactionId) && r.b(this.autoResumeDate, subscriptionInfoResponse.autoResumeDate) && r.b(this.displayName, subscriptionInfoResponse.displayName) && r.b(this.price, subscriptionInfoResponse.price) && r.b(this.productPlanIdentifier, subscriptionInfoResponse.productPlanIdentifier) && r.b(this.managementURL, subscriptionInfoResponse.managementURL);
    }

    public final Date getAutoResumeDate() {
        return this.autoResumeDate;
    }

    public final Date getBillingIssuesDetectedAt() {
        return this.billingIssuesDetectedAt;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final Date getExpiresDate() {
        return this.expiresDate;
    }

    public final Date getGracePeriodExpiresDate() {
        return this.gracePeriodExpiresDate;
    }

    public final String getManagementURL() {
        return this.managementURL;
    }

    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    public final PriceResponse getPrice() {
        return this.price;
    }

    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    public final Date getRefundedAt() {
        return this.refundedAt;
    }

    public final Store getStore() {
        return this.store;
    }

    public final String getStoreTransactionId() {
        return this.storeTransactionId;
    }

    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v51 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v9, types: [int] */
    public int hashCode() {
        int iHashCode = this.purchaseDate.hashCode() * 31;
        Date date = this.originalPurchaseDate;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.expiresDate;
        int iHashCode3 = (((iHashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31) + this.store.hashCode()) * 31;
        boolean z4 = this.isSandbox;
        ?? r12 = z4;
        if (z4) {
            r12 = 1;
        }
        int i4 = (iHashCode3 + r12) * 31;
        Date date3 = this.unsubscribeDetectedAt;
        int iHashCode4 = (i4 + (date3 == null ? 0 : date3.hashCode())) * 31;
        Date date4 = this.billingIssuesDetectedAt;
        int iHashCode5 = (iHashCode4 + (date4 == null ? 0 : date4.hashCode())) * 31;
        Date date5 = this.gracePeriodExpiresDate;
        int iHashCode6 = (((((iHashCode5 + (date5 == null ? 0 : date5.hashCode())) * 31) + this.ownershipType.hashCode()) * 31) + this.periodType.hashCode()) * 31;
        Date date6 = this.refundedAt;
        int iHashCode7 = (iHashCode6 + (date6 == null ? 0 : date6.hashCode())) * 31;
        String str = this.storeTransactionId;
        int iHashCode8 = (iHashCode7 + (str == null ? 0 : str.hashCode())) * 31;
        Date date7 = this.autoResumeDate;
        int iHashCode9 = (iHashCode8 + (date7 == null ? 0 : date7.hashCode())) * 31;
        String str2 = this.displayName;
        int iHashCode10 = (iHashCode9 + (str2 == null ? 0 : str2.hashCode())) * 31;
        PriceResponse priceResponse = this.price;
        int iHashCode11 = (iHashCode10 + (priceResponse == null ? 0 : priceResponse.hashCode())) * 31;
        String str3 = this.productPlanIdentifier;
        int iHashCode12 = (iHashCode11 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.managementURL;
        return iHashCode12 + (str4 != null ? str4.hashCode() : 0);
    }

    public final boolean isSandbox() {
        return this.isSandbox;
    }

    public String toString() {
        return "SubscriptionInfoResponse(purchaseDate=" + this.purchaseDate + ", originalPurchaseDate=" + this.originalPurchaseDate + ", expiresDate=" + this.expiresDate + ", store=" + this.store + ", isSandbox=" + this.isSandbox + ", unsubscribeDetectedAt=" + this.unsubscribeDetectedAt + ", billingIssuesDetectedAt=" + this.billingIssuesDetectedAt + ", gracePeriodExpiresDate=" + this.gracePeriodExpiresDate + ", ownershipType=" + this.ownershipType + ", periodType=" + this.periodType + ", refundedAt=" + this.refundedAt + ", storeTransactionId=" + this.storeTransactionId + ", autoResumeDate=" + this.autoResumeDate + ", displayName=" + this.displayName + ", price=" + this.price + ", productPlanIdentifier=" + this.productPlanIdentifier + ", managementURL=" + this.managementURL + ')';
    }

    public static final class PriceResponse {
        public static final Companion Companion = new Companion(null);
        private final double amount;
        private final String currencyCode;

        public static final class Companion {
            public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
                this();
            }

            public final b serializer() {
                return SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public PriceResponse(double d4, String currencyCode) {
            r.f(currencyCode, "currencyCode");
            this.amount = d4;
            this.currencyCode = currencyCode;
        }

        public static /* synthetic */ PriceResponse copy$default(PriceResponse priceResponse, double d4, String str, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                d4 = priceResponse.amount;
            }
            if ((i4 & 2) != 0) {
                str = priceResponse.currencyCode;
            }
            return priceResponse.copy(d4, str);
        }

        public static /* synthetic */ void getAmount$annotations() {
        }

        public static /* synthetic */ void getCurrencyCode$annotations() {
        }

        public static final /* synthetic */ void write$Self(PriceResponse priceResponse, d dVar, e eVar) {
            dVar.g(eVar, 0, priceResponse.amount);
            dVar.o(eVar, 1, priceResponse.currencyCode);
        }

        public final double component1() {
            return this.amount;
        }

        public final String component2() {
            return this.currencyCode;
        }

        public final PriceResponse copy(double d4, String currencyCode) {
            r.f(currencyCode, "currencyCode");
            return new PriceResponse(d4, currencyCode);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof PriceResponse)) {
                return false;
            }
            PriceResponse priceResponse = (PriceResponse) obj;
            return Double.compare(this.amount, priceResponse.amount) == 0 && r.b(this.currencyCode, priceResponse.currencyCode);
        }

        public final double getAmount() {
            return this.amount;
        }

        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        public int hashCode() {
            return (Double.hashCode(this.amount) * 31) + this.currencyCode.hashCode();
        }

        public final /* synthetic */ Price toPrice(Locale locale) {
            r.f(locale, "locale");
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            currencyInstance.setCurrency(Currency.getInstance(this.currencyCode));
            String formatted = currencyInstance.format(this.amount);
            r.e(formatted, "formatted");
            return new Price(formatted, (long) (this.amount * 1000000.0d), this.currencyCode);
        }

        public String toString() {
            return "PriceResponse(amount=" + this.amount + ", currencyCode=" + this.currencyCode + ')';
        }

        public /* synthetic */ PriceResponse(int i4, double d4, String str, k0 k0Var) {
            if (3 != (i4 & 3)) {
                AbstractC0325a0.a(i4, 3, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE.getDescriptor());
            }
            this.amount = d4;
            this.currencyCode = str;
        }
    }

    public SubscriptionInfoResponse(Date purchaseDate, Date date, Date date2, Store store, boolean z4, Date date3, Date date4, Date date5, OwnershipType ownershipType, PeriodType periodType, Date date6, String str, Date date7, String str2, PriceResponse priceResponse, String str3, String str4) {
        r.f(purchaseDate, "purchaseDate");
        r.f(store, "store");
        r.f(ownershipType, "ownershipType");
        r.f(periodType, "periodType");
        this.purchaseDate = purchaseDate;
        this.originalPurchaseDate = date;
        this.expiresDate = date2;
        this.store = store;
        this.isSandbox = z4;
        this.unsubscribeDetectedAt = date3;
        this.billingIssuesDetectedAt = date4;
        this.gracePeriodExpiresDate = date5;
        this.ownershipType = ownershipType;
        this.periodType = periodType;
        this.refundedAt = date6;
        this.storeTransactionId = str;
        this.autoResumeDate = date7;
        this.displayName = str2;
        this.price = priceResponse;
        this.productPlanIdentifier = str3;
        this.managementURL = str4;
    }

    public /* synthetic */ SubscriptionInfoResponse(Date date, Date date2, Date date3, Store store, boolean z4, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, int i4, AbstractC1585j abstractC1585j) {
        this(date, (i4 & 2) != 0 ? null : date2, (i4 & 4) != 0 ? null : date3, store, z4, (i4 & 32) != 0 ? null : date4, (i4 & 64) != 0 ? null : date5, (i4 & UserMetadata.MAX_ROLLOUT_ASSIGNMENTS) != 0 ? null : date6, (i4 & 256) != 0 ? OwnershipType.UNKNOWN : ownershipType, periodType, (i4 & UserMetadata.MAX_ATTRIBUTE_SIZE) != 0 ? null : date7, (i4 & 2048) != 0 ? null : str, (i4 & 4096) != 0 ? null : date8, (i4 & UserMetadata.MAX_INTERNAL_KEY_SIZE) != 0 ? null : str2, (i4 & 16384) != 0 ? null : priceResponse, (32768 & i4) != 0 ? null : str3, (i4 & 65536) != 0 ? null : str4);
    }
}
