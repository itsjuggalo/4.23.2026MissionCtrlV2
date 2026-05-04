package com.revenuecat.purchases.common;

import cd.o;
import cd.w;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.PricingPhase;
import dd.o0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a!\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0006\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007\"\u0014\u0010\b\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0006\n\u0004\b\b\u0010\u0007\"\u0018\u0010\r\u001a\u00020\n*\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f*H\b\u0000\u0010\u0013\" \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e2 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e*\u0018\b\u0000\u0010\u0015\"\b\u0012\u0004\u0012\u00020\u00020\u00142\b\u0012\u0004\u0012\u00020\u00020\u0014*T\b\u0000\u0010\u0017\"&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e2&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e*T\b\u0000\u0010\u0019\"&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e2&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e*`\b\u0000\u0010\u001c\",\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u001b0\u000e2,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u001b0\u000e*`\b\u0000\u0010\u001e\",\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u001b0\u000e2,\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u001b0\u000e*`\b\u0000\u0010\u001f\",\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e2,\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u001b\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e*l\b\u0000\u0010\"\"2\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00100\u001b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00100\u001b0\u000e22\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u00100\u001b\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00100\u001b0\u000e*T\b\u0000\u0010#\"&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u001b0\u000e2&\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100\u001b0\u000e*R\b\u0000\u0010)\"\u000e\u0012\u0004\u0012\u0002`$\u0012\u0004\u0012\u0002`%0\u000e2<\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100\u0011j\u0002`$\u0012\"\u0012 \u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u00100'j\u0002`%0\u000e*@\b\u0000\u0010*\"\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u00100'2\u001c\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020(\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0004\u0012\u00020\u00100'*$\b\u0000\u0010+\"\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100\u00112\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00100\u0011*T\b\u0000\u0010-\"&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e2&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e*$\b\u0000\u0010/\"\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00100\u00112\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00100\u0011*T\b\u0000\u00101\"&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e2&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e*T\b\u0000\u00103\"&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e2&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u00100\u0011\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00110\u000e¨\u00064"}, d2 = {"Lcom/revenuecat/purchases/models/PricingPhase;", "", "", "", "toMap", "(Lcom/revenuecat/purchases/models/PricingPhase;)Ljava/util/Map;", "ATTRIBUTES_ERROR_RESPONSE_KEY", "Ljava/lang/String;", "ATTRIBUTE_ERRORS_KEY", "Lcom/revenuecat/purchases/models/GoogleReplacementMode;", "Lcom/revenuecat/purchases/common/LegacyProrationMode;", "getAsLegacyProrationMode", "(Lcom/revenuecat/purchases/models/GoogleReplacementMode;)Lcom/revenuecat/purchases/common/LegacyProrationMode;", "asLegacyProrationMode", "Lcd/q;", "Lkotlin/Function0;", "Lcd/h0;", "Lkotlin/Function1;", "Lcom/revenuecat/purchases/PurchasesError;", "AliasCallback", "", "CallbackCacheKey", "", "CreateSupportTicketCallback", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData;", "CustomerCenterCallback", "Lcom/revenuecat/purchases/CustomerInfo;", "Lkotlin/Function2;", "CustomerInfoCallback", "Lorg/json/JSONObject;", "DiagnosticsCallback", "IdentifyCallback", "Lcom/revenuecat/purchases/common/HTTPResponseOriginalSource;", "Lcom/revenuecat/purchases/common/GetOfferingsErrorHandlingBehavior;", "OfferingsCallback", "PaywallEventsCallback", "Lcom/revenuecat/purchases/common/PostReceiptDataSuccessCallback;", "Lcom/revenuecat/purchases/common/PostReceiptDataErrorCallback;", "Lcom/revenuecat/purchases/common/networking/PostReceiptResponse;", "Lkotlin/Function3;", "Lcom/revenuecat/purchases/common/PostReceiptErrorHandlingBehavior;", "PostReceiptCallback", "PostReceiptDataErrorCallback", "PostReceiptDataSuccessCallback", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "ProductEntitlementCallback", "Lcom/revenuecat/purchases/interfaces/RedeemWebPurchaseListener$Result;", "RedeemWebPurchaseCallback", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "VirtualCurrenciesCallback", "Lcom/revenuecat/purchases/common/networking/WebBillingProductsResponse;", "WebBillingProductsCallback", "purchases_defaultsBc8Release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class BackendKt {
    public static final String ATTRIBUTES_ERROR_RESPONSE_KEY = "attributes_error_response";
    public static final String ATTRIBUTE_ERRORS_KEY = "attribute_errors";

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[GoogleReplacementMode.values().length];
            try {
                iArr[GoogleReplacementMode.WITHOUT_PRORATION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[GoogleReplacementMode.WITH_TIME_PRORATION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[GoogleReplacementMode.CHARGE_FULL_PRICE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[GoogleReplacementMode.CHARGE_PRORATED_PRICE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[GoogleReplacementMode.DEFERRED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LegacyProrationMode getAsLegacyProrationMode(GoogleReplacementMode googleReplacementMode) {
        int i10 = WhenMappings.$EnumSwitchMapping$0[googleReplacementMode.ordinal()];
        if (i10 == 1) {
            return LegacyProrationMode.IMMEDIATE_WITHOUT_PRORATION;
        }
        if (i10 == 2) {
            return LegacyProrationMode.IMMEDIATE_WITH_TIME_PRORATION;
        }
        if (i10 == 3) {
            return LegacyProrationMode.IMMEDIATE_AND_CHARGE_FULL_PRICE;
        }
        if (i10 == 4) {
            return LegacyProrationMode.IMMEDIATE_AND_CHARGE_PRORATED_PRICE;
        }
        if (i10 == 5) {
            return LegacyProrationMode.DEFERRED;
        }
        throw new o();
    }

    public static final Map<String, Object> toMap(PricingPhase pricingPhase) {
        t.f(pricingPhase, "<this>");
        return o0.l(w.a("billingPeriod", pricingPhase.getBillingPeriod().getIso8601()), w.a("billingCycleCount", pricingPhase.getBillingCycleCount()), w.a("recurrenceMode", pricingPhase.getRecurrenceMode().getIdentifier()), w.a("formattedPrice", pricingPhase.getPrice().getFormatted()), w.a("priceAmountMicros", Long.valueOf(pricingPhase.getPrice().getAmountMicros())), w.a("priceCurrencyCode", pricingPhase.getPrice().getCurrencyCode()));
    }

    public static /* synthetic */ void CustomerCenterCallback$annotations() {
    }
}
