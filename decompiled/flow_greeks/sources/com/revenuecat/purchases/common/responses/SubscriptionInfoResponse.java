package com.revenuecat.purchases.common.responses;

import bh.e;
import ch.d;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.OwnershipType;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.StoreSerializer;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.utils.serializers.ISO8601DateSerializer;
import dh.e1;
import dh.s1;
import dh.w1;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bP\b\u0081\b\u0018\u0000 s2\u00020\u0001:\u0003tsuBÁ\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001a\u0010\u001bBå\u0001\b\u0011\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0001\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\n\b\u0001\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\n\b\u0001\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0001\u0010\u0015\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0001\u0010\u0019\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0004\b\u001a\u0010 J(\u0010)\u001a\u00020&2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$HÁ\u0001¢\u0006\u0004\b'\u0010(J\u0010\u0010*\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010,\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b,\u0010+J\u0012\u0010-\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b-\u0010+J\u0010\u0010.\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b.\u0010/J\u0010\u00100\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b0\u00101J\u0012\u00102\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b2\u0010+J\u0012\u00103\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b3\u0010+J\u0012\u00104\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b4\u0010+J\u0010\u00105\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b5\u00106J\u0010\u00107\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b7\u00108J\u0012\u00109\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b9\u0010+J\u0012\u0010:\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b:\u0010;J\u0012\u0010<\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b<\u0010+J\u0012\u0010=\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b=\u0010;J\u0012\u0010>\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b>\u0010?J\u0012\u0010@\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\b@\u0010;J\u0012\u0010A\u001a\u0004\u0018\u00010\u0012HÆ\u0003¢\u0006\u0004\bA\u0010;JÒ\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0012HÆ\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\bD\u0010;J\u0010\u0010E\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\bE\u0010FJ\u001a\u0010H\u001a\u00020\b2\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\bH\u0010IR \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010J\u0012\u0004\bL\u0010M\u001a\u0004\bK\u0010+R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0004\u0010J\u0012\u0004\bO\u0010M\u001a\u0004\bN\u0010+R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010J\u0012\u0004\bQ\u0010M\u001a\u0004\bP\u0010+R \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010R\u0012\u0004\bT\u0010M\u001a\u0004\bS\u0010/R \u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010U\u0012\u0004\bV\u0010M\u001a\u0004\b\t\u00101R\"\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\n\u0010J\u0012\u0004\bX\u0010M\u001a\u0004\bW\u0010+R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000b\u0010J\u0012\u0004\bZ\u0010M\u001a\u0004\bY\u0010+R\"\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010J\u0012\u0004\b\\\u0010M\u001a\u0004\b[\u0010+R \u0010\u000e\u001a\u00020\r8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u000e\u0010]\u0012\u0004\b_\u0010M\u001a\u0004\b^\u00106R \u0010\u0010\u001a\u00020\u000f8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0010\u0010`\u0012\u0004\bb\u0010M\u001a\u0004\ba\u00108R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0011\u0010J\u0012\u0004\bd\u0010M\u001a\u0004\bc\u0010+R\"\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0013\u0010e\u0012\u0004\bg\u0010M\u001a\u0004\bf\u0010;R\"\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0014\u0010J\u0012\u0004\bi\u0010M\u001a\u0004\bh\u0010+R\"\u0010\u0015\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0015\u0010e\u0012\u0004\bk\u0010M\u001a\u0004\bj\u0010;R\"\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0017\u0010l\u0012\u0004\bn\u0010M\u001a\u0004\bm\u0010?R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0018\u0010e\u0012\u0004\bp\u0010M\u001a\u0004\bo\u0010;R\"\u0010\u0019\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0019\u0010e\u0012\u0004\br\u0010M\u001a\u0004\bq\u0010;¨\u0006v"}, d2 = {"Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse;", "", "Ljava/util/Date;", b.Q, "originalPurchaseDate", "expiresDate", "Lcom/revenuecat/purchases/Store;", ProductResponseJsonKeys.STORE, "", "isSandbox", "unsubscribeDetectedAt", "billingIssuesDetectedAt", "gracePeriodExpiresDate", "Lcom/revenuecat/purchases/OwnershipType;", "ownershipType", "Lcom/revenuecat/purchases/PeriodType;", "periodType", "refundedAt", "", "storeTransactionId", "autoResumeDate", "displayName", "Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "price", "productPlanIdentifier", "managementURL", "<init>", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;ZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;Ljava/lang/String;Ljava/lang/String;)V", "", "seen1", "Ldh/s1;", "serializationConstructorMarker", "(ILjava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;ZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;Ljava/lang/String;Ljava/lang/String;Ldh/s1;)V", "self", "Lch/d;", "output", "Lbh/e;", "serialDesc", "Lcd/h0;", "write$Self$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse;Lch/d;Lbh/e;)V", "write$Self", "component1", "()Ljava/util/Date;", "component2", "component3", "component4", "()Lcom/revenuecat/purchases/Store;", "component5", "()Z", "component6", "component7", "component8", "component9", "()Lcom/revenuecat/purchases/OwnershipType;", "component10", "()Lcom/revenuecat/purchases/PeriodType;", "component11", "component12", "()Ljava/lang/String;", "component13", "component14", "component15", "()Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "component16", "component17", "copy", "(Ljava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/Store;ZLjava/util/Date;Ljava/util/Date;Ljava/util/Date;Lcom/revenuecat/purchases/OwnershipType;Lcom/revenuecat/purchases/PeriodType;Ljava/util/Date;Ljava/lang/String;Ljava/util/Date;Ljava/lang/String;Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;Ljava/lang/String;Ljava/lang/String;)Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/util/Date;", "getPurchaseDate", "getPurchaseDate$annotations", "()V", "getOriginalPurchaseDate", "getOriginalPurchaseDate$annotations", "getExpiresDate", "getExpiresDate$annotations", "Lcom/revenuecat/purchases/Store;", "getStore", "getStore$annotations", "Z", "isSandbox$annotations", "getUnsubscribeDetectedAt", "getUnsubscribeDetectedAt$annotations", "getBillingIssuesDetectedAt", "getBillingIssuesDetectedAt$annotations", "getGracePeriodExpiresDate", "getGracePeriodExpiresDate$annotations", "Lcom/revenuecat/purchases/OwnershipType;", "getOwnershipType", "getOwnershipType$annotations", "Lcom/revenuecat/purchases/PeriodType;", "getPeriodType", "getPeriodType$annotations", "getRefundedAt", "getRefundedAt$annotations", "Ljava/lang/String;", "getStoreTransactionId", "getStoreTransactionId$annotations", "getAutoResumeDate", "getAutoResumeDate$annotations", "getDisplayName", "getDisplayName$annotations", "Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "getPrice", "getPrice$annotations", "getProductPlanIdentifier", "getProductPlanIdentifier$annotations", "getManagementURL", "getManagementURL$annotations", "Companion", "$serializer", "PriceResponse", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final /* data */ class SubscriptionInfoResponse {
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

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final zg.b[] $childSerializers = {null, null, null, null, null, null, null, null, OwnershipType.INSTANCE.serializer(), PeriodType.INSTANCE.serializer(), null, null, null, null, null, null, null};

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$Companion;", "", "<init>", "()V", "Lzg/b;", "Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse;", "serializer", "()Lzg/b;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(k kVar) {
            this();
        }

        public final zg.b serializer() {
            return SubscriptionInfoResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ SubscriptionInfoResponse(int i10, Date date, Date date2, Date date3, Store store, boolean z10, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, s1 s1Var) {
        if (537 != (i10 & 537)) {
            e1.a(i10, 537, SubscriptionInfoResponse$$serializer.INSTANCE.getDescriptor());
        }
        this.purchaseDate = date;
        if ((i10 & 2) == 0) {
            this.originalPurchaseDate = null;
        } else {
            this.originalPurchaseDate = date2;
        }
        if ((i10 & 4) == 0) {
            this.expiresDate = null;
        } else {
            this.expiresDate = date3;
        }
        this.store = store;
        this.isSandbox = z10;
        if ((i10 & 32) == 0) {
            this.unsubscribeDetectedAt = null;
        } else {
            this.unsubscribeDetectedAt = date4;
        }
        if ((i10 & 64) == 0) {
            this.billingIssuesDetectedAt = null;
        } else {
            this.billingIssuesDetectedAt = date5;
        }
        if ((i10 & 128) == 0) {
            this.gracePeriodExpiresDate = null;
        } else {
            this.gracePeriodExpiresDate = date6;
        }
        if ((i10 & 256) == 0) {
            this.ownershipType = OwnershipType.UNKNOWN;
        } else {
            this.ownershipType = ownershipType;
        }
        this.periodType = periodType;
        if ((i10 & 1024) == 0) {
            this.refundedAt = null;
        } else {
            this.refundedAt = date7;
        }
        if ((i10 & 2048) == 0) {
            this.storeTransactionId = null;
        } else {
            this.storeTransactionId = str;
        }
        if ((i10 & 4096) == 0) {
            this.autoResumeDate = null;
        } else {
            this.autoResumeDate = date8;
        }
        if ((i10 & 8192) == 0) {
            this.displayName = null;
        } else {
            this.displayName = str2;
        }
        if ((i10 & 16384) == 0) {
            this.price = null;
        } else {
            this.price = priceResponse;
        }
        if ((32768 & i10) == 0) {
            this.productPlanIdentifier = null;
        } else {
            this.productPlanIdentifier = str3;
        }
        if ((i10 & 65536) == 0) {
            this.managementURL = null;
        } else {
            this.managementURL = str4;
        }
    }

    public static /* synthetic */ SubscriptionInfoResponse copy$default(SubscriptionInfoResponse subscriptionInfoResponse, Date date, Date date2, Date date3, Store store, boolean z10, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, int i10, Object obj) {
        String str5;
        String str6;
        Date date9;
        SubscriptionInfoResponse subscriptionInfoResponse2;
        PriceResponse priceResponse2;
        Date date10;
        Date date11;
        Store store2;
        boolean z11;
        Date date12;
        Date date13;
        Date date14;
        OwnershipType ownershipType2;
        PeriodType periodType2;
        Date date15;
        String str7;
        Date date16;
        String str8;
        Date date17 = (i10 & 1) != 0 ? subscriptionInfoResponse.purchaseDate : date;
        Date date18 = (i10 & 2) != 0 ? subscriptionInfoResponse.originalPurchaseDate : date2;
        Date date19 = (i10 & 4) != 0 ? subscriptionInfoResponse.expiresDate : date3;
        Store store3 = (i10 & 8) != 0 ? subscriptionInfoResponse.store : store;
        boolean z12 = (i10 & 16) != 0 ? subscriptionInfoResponse.isSandbox : z10;
        Date date20 = (i10 & 32) != 0 ? subscriptionInfoResponse.unsubscribeDetectedAt : date4;
        Date date21 = (i10 & 64) != 0 ? subscriptionInfoResponse.billingIssuesDetectedAt : date5;
        Date date22 = (i10 & 128) != 0 ? subscriptionInfoResponse.gracePeriodExpiresDate : date6;
        OwnershipType ownershipType3 = (i10 & 256) != 0 ? subscriptionInfoResponse.ownershipType : ownershipType;
        PeriodType periodType3 = (i10 & 512) != 0 ? subscriptionInfoResponse.periodType : periodType;
        Date date23 = (i10 & 1024) != 0 ? subscriptionInfoResponse.refundedAt : date7;
        String str9 = (i10 & 2048) != 0 ? subscriptionInfoResponse.storeTransactionId : str;
        Date date24 = (i10 & 4096) != 0 ? subscriptionInfoResponse.autoResumeDate : date8;
        String str10 = (i10 & 8192) != 0 ? subscriptionInfoResponse.displayName : str2;
        Date date25 = date17;
        PriceResponse priceResponse3 = (i10 & 16384) != 0 ? subscriptionInfoResponse.price : priceResponse;
        String str11 = (i10 & 32768) != 0 ? subscriptionInfoResponse.productPlanIdentifier : str3;
        if ((i10 & 65536) != 0) {
            str6 = str11;
            str5 = subscriptionInfoResponse.managementURL;
            priceResponse2 = priceResponse3;
            date10 = date18;
            date11 = date19;
            store2 = store3;
            z11 = z12;
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
            z11 = z12;
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
        return subscriptionInfoResponse2.copy(date9, date10, date11, store2, z11, date12, date13, date14, ownershipType2, periodType2, date15, str7, date16, str8, priceResponse2, str6, str5);
    }

    public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(SubscriptionInfoResponse self, d output, e serialDesc) {
        zg.b[] bVarArr = $childSerializers;
        ISO8601DateSerializer iSO8601DateSerializer = ISO8601DateSerializer.INSTANCE;
        output.n(serialDesc, 0, iSO8601DateSerializer, self.purchaseDate);
        if (output.o(serialDesc, 1) || self.originalPurchaseDate != null) {
            output.e(serialDesc, 1, iSO8601DateSerializer, self.originalPurchaseDate);
        }
        if (output.o(serialDesc, 2) || self.expiresDate != null) {
            output.e(serialDesc, 2, iSO8601DateSerializer, self.expiresDate);
        }
        output.n(serialDesc, 3, StoreSerializer.INSTANCE, self.store);
        output.C(serialDesc, 4, self.isSandbox);
        if (output.o(serialDesc, 5) || self.unsubscribeDetectedAt != null) {
            output.e(serialDesc, 5, iSO8601DateSerializer, self.unsubscribeDetectedAt);
        }
        if (output.o(serialDesc, 6) || self.billingIssuesDetectedAt != null) {
            output.e(serialDesc, 6, iSO8601DateSerializer, self.billingIssuesDetectedAt);
        }
        if (output.o(serialDesc, 7) || self.gracePeriodExpiresDate != null) {
            output.e(serialDesc, 7, iSO8601DateSerializer, self.gracePeriodExpiresDate);
        }
        if (output.o(serialDesc, 8) || self.ownershipType != OwnershipType.UNKNOWN) {
            output.n(serialDesc, 8, bVarArr[8], self.ownershipType);
        }
        output.n(serialDesc, 9, bVarArr[9], self.periodType);
        if (output.o(serialDesc, 10) || self.refundedAt != null) {
            output.e(serialDesc, 10, iSO8601DateSerializer, self.refundedAt);
        }
        if (output.o(serialDesc, 11) || self.storeTransactionId != null) {
            output.e(serialDesc, 11, w1.f8244a, self.storeTransactionId);
        }
        if (output.o(serialDesc, 12) || self.autoResumeDate != null) {
            output.e(serialDesc, 12, iSO8601DateSerializer, self.autoResumeDate);
        }
        if (output.o(serialDesc, 13) || self.displayName != null) {
            output.e(serialDesc, 13, w1.f8244a, self.displayName);
        }
        if (output.o(serialDesc, 14) || self.price != null) {
            output.e(serialDesc, 14, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE, self.price);
        }
        if (output.o(serialDesc, 15) || self.productPlanIdentifier != null) {
            output.e(serialDesc, 15, w1.f8244a, self.productPlanIdentifier);
        }
        if (!output.o(serialDesc, 16) && self.managementURL == null) {
            return;
        }
        output.e(serialDesc, 16, w1.f8244a, self.managementURL);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Date getPurchaseDate() {
        return this.purchaseDate;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final PeriodType getPeriodType() {
        return this.periodType;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Date getRefundedAt() {
        return this.refundedAt;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final String getStoreTransactionId() {
        return this.storeTransactionId;
    }

    /* JADX INFO: renamed from: component13, reason: from getter */
    public final Date getAutoResumeDate() {
        return this.autoResumeDate;
    }

    /* JADX INFO: renamed from: component14, reason: from getter */
    public final String getDisplayName() {
        return this.displayName;
    }

    /* JADX INFO: renamed from: component15, reason: from getter */
    public final PriceResponse getPrice() {
        return this.price;
    }

    /* JADX INFO: renamed from: component16, reason: from getter */
    public final String getProductPlanIdentifier() {
        return this.productPlanIdentifier;
    }

    /* JADX INFO: renamed from: component17, reason: from getter */
    public final String getManagementURL() {
        return this.managementURL;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Date getOriginalPurchaseDate() {
        return this.originalPurchaseDate;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Date getExpiresDate() {
        return this.expiresDate;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Store getStore() {
        return this.store;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getIsSandbox() {
        return this.isSandbox;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Date getUnsubscribeDetectedAt() {
        return this.unsubscribeDetectedAt;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Date getBillingIssuesDetectedAt() {
        return this.billingIssuesDetectedAt;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final Date getGracePeriodExpiresDate() {
        return this.gracePeriodExpiresDate;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final OwnershipType getOwnershipType() {
        return this.ownershipType;
    }

    public final SubscriptionInfoResponse copy(Date purchaseDate, Date originalPurchaseDate, Date expiresDate, Store store, boolean isSandbox, Date unsubscribeDetectedAt, Date billingIssuesDetectedAt, Date gracePeriodExpiresDate, OwnershipType ownershipType, PeriodType periodType, Date refundedAt, String storeTransactionId, Date autoResumeDate, String displayName, PriceResponse price, String productPlanIdentifier, String managementURL) {
        t.f(purchaseDate, "purchaseDate");
        t.f(store, "store");
        t.f(ownershipType, "ownershipType");
        t.f(periodType, "periodType");
        return new SubscriptionInfoResponse(purchaseDate, originalPurchaseDate, expiresDate, store, isSandbox, unsubscribeDetectedAt, billingIssuesDetectedAt, gracePeriodExpiresDate, ownershipType, periodType, refundedAt, storeTransactionId, autoResumeDate, displayName, price, productPlanIdentifier, managementURL);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubscriptionInfoResponse)) {
            return false;
        }
        SubscriptionInfoResponse subscriptionInfoResponse = (SubscriptionInfoResponse) other;
        return t.b(this.purchaseDate, subscriptionInfoResponse.purchaseDate) && t.b(this.originalPurchaseDate, subscriptionInfoResponse.originalPurchaseDate) && t.b(this.expiresDate, subscriptionInfoResponse.expiresDate) && this.store == subscriptionInfoResponse.store && this.isSandbox == subscriptionInfoResponse.isSandbox && t.b(this.unsubscribeDetectedAt, subscriptionInfoResponse.unsubscribeDetectedAt) && t.b(this.billingIssuesDetectedAt, subscriptionInfoResponse.billingIssuesDetectedAt) && t.b(this.gracePeriodExpiresDate, subscriptionInfoResponse.gracePeriodExpiresDate) && this.ownershipType == subscriptionInfoResponse.ownershipType && this.periodType == subscriptionInfoResponse.periodType && t.b(this.refundedAt, subscriptionInfoResponse.refundedAt) && t.b(this.storeTransactionId, subscriptionInfoResponse.storeTransactionId) && t.b(this.autoResumeDate, subscriptionInfoResponse.autoResumeDate) && t.b(this.displayName, subscriptionInfoResponse.displayName) && t.b(this.price, subscriptionInfoResponse.price) && t.b(this.productPlanIdentifier, subscriptionInfoResponse.productPlanIdentifier) && t.b(this.managementURL, subscriptionInfoResponse.managementURL);
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

    public int hashCode() {
        int iHashCode = this.purchaseDate.hashCode() * 31;
        Date date = this.originalPurchaseDate;
        int iHashCode2 = (iHashCode + (date == null ? 0 : date.hashCode())) * 31;
        Date date2 = this.expiresDate;
        int iHashCode3 = (((((iHashCode2 + (date2 == null ? 0 : date2.hashCode())) * 31) + this.store.hashCode()) * 31) + Boolean.hashCode(this.isSandbox)) * 31;
        Date date3 = this.unsubscribeDetectedAt;
        int iHashCode4 = (iHashCode3 + (date3 == null ? 0 : date3.hashCode())) * 31;
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0081\b\u0018\u0000 /2\u00020\u0001:\u00020/B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B1\b\u0011\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ(\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010HÁ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ$\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u001eJ\u0010\u0010\"\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R \u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010(\u0012\u0004\b*\u0010+\u001a\u0004\b)\u0010\u001cR \u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0005\u0010,\u0012\u0004\b.\u0010+\u001a\u0004\b-\u0010\u001e¨\u00061"}, d2 = {"Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "", "", "amount", "", "currencyCode", "<init>", "(DLjava/lang/String;)V", "", "seen1", "Ldh/s1;", "serializationConstructorMarker", "(IDLjava/lang/String;Ldh/s1;)V", "self", "Lch/d;", "output", "Lbh/e;", "serialDesc", "Lcd/h0;", "write$Self$purchases_defaultsBc8Release", "(Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;Lch/d;Lbh/e;)V", "write$Self", "Ljava/util/Locale;", "locale", "Lcom/revenuecat/purchases/models/Price;", "toPrice", "(Ljava/util/Locale;)Lcom/revenuecat/purchases/models/Price;", "component1", "()D", "component2", "()Ljava/lang/String;", "copy", "(DLjava/lang/String;)Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "toString", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "D", "getAmount", "getAmount$annotations", "()V", "Ljava/lang/String;", "getCurrencyCode", "getCurrencyCode$annotations", "Companion", "$serializer", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final /* data */ class PriceResponse {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final double amount;
        private final String currencyCode;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse$Companion;", "", "<init>", "()V", "Lzg/b;", "Lcom/revenuecat/purchases/common/responses/SubscriptionInfoResponse$PriceResponse;", "serializer", "()Lzg/b;", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(k kVar) {
                this();
            }

            public final zg.b serializer() {
                return SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE;
            }

            private Companion() {
            }
        }

        public PriceResponse(double d10, String currencyCode) {
            t.f(currencyCode, "currencyCode");
            this.amount = d10;
            this.currencyCode = currencyCode;
        }

        public static /* synthetic */ PriceResponse copy$default(PriceResponse priceResponse, double d10, String str, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                d10 = priceResponse.amount;
            }
            if ((i10 & 2) != 0) {
                str = priceResponse.currencyCode;
            }
            return priceResponse.copy(d10, str);
        }

        public static final /* synthetic */ void write$Self$purchases_defaultsBc8Release(PriceResponse self, d output, e serialDesc) {
            output.q(serialDesc, 0, self.amount);
            output.w(serialDesc, 1, self.currencyCode);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final double getAmount() {
            return this.amount;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getCurrencyCode() {
            return this.currencyCode;
        }

        public final PriceResponse copy(double amount, String currencyCode) {
            t.f(currencyCode, "currencyCode");
            return new PriceResponse(amount, currencyCode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof PriceResponse)) {
                return false;
            }
            PriceResponse priceResponse = (PriceResponse) other;
            return Double.compare(this.amount, priceResponse.amount) == 0 && t.b(this.currencyCode, priceResponse.currencyCode);
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
            t.f(locale, "locale");
            NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(locale);
            currencyInstance.setCurrency(Currency.getInstance(this.currencyCode));
            String formatted = currencyInstance.format(this.amount);
            t.e(formatted, "formatted");
            return new Price(formatted, (long) (this.amount * 1000000.0d), this.currencyCode);
        }

        public String toString() {
            return "PriceResponse(amount=" + this.amount + ", currencyCode=" + this.currencyCode + ')';
        }

        public /* synthetic */ PriceResponse(int i10, double d10, String str, s1 s1Var) {
            if (3 != (i10 & 3)) {
                e1.a(i10, 3, SubscriptionInfoResponse$PriceResponse$$serializer.INSTANCE.getDescriptor());
            }
            this.amount = d10;
            this.currencyCode = str;
        }

        public static /* synthetic */ void getAmount$annotations() {
        }

        public static /* synthetic */ void getCurrencyCode$annotations() {
        }
    }

    public SubscriptionInfoResponse(Date purchaseDate, Date date, Date date2, Store store, boolean z10, Date date3, Date date4, Date date5, OwnershipType ownershipType, PeriodType periodType, Date date6, String str, Date date7, String str2, PriceResponse priceResponse, String str3, String str4) {
        t.f(purchaseDate, "purchaseDate");
        t.f(store, "store");
        t.f(ownershipType, "ownershipType");
        t.f(periodType, "periodType");
        this.purchaseDate = purchaseDate;
        this.originalPurchaseDate = date;
        this.expiresDate = date2;
        this.store = store;
        this.isSandbox = z10;
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

    public /* synthetic */ SubscriptionInfoResponse(Date date, Date date2, Date date3, Store store, boolean z10, Date date4, Date date5, Date date6, OwnershipType ownershipType, PeriodType periodType, Date date7, String str, Date date8, String str2, PriceResponse priceResponse, String str3, String str4, int i10, k kVar) {
        this(date, (i10 & 2) != 0 ? null : date2, (i10 & 4) != 0 ? null : date3, store, z10, (i10 & 32) != 0 ? null : date4, (i10 & 64) != 0 ? null : date5, (i10 & 128) != 0 ? null : date6, (i10 & 256) != 0 ? OwnershipType.UNKNOWN : ownershipType, periodType, (i10 & 1024) != 0 ? null : date7, (i10 & 2048) != 0 ? null : str, (i10 & 4096) != 0 ? null : date8, (i10 & 8192) != 0 ? null : str2, (i10 & 16384) != 0 ? null : priceResponse, (32768 & i10) != 0 ? null : str3, (i10 & 65536) != 0 ? null : str4);
    }
}
