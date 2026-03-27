package com.revenuecat.purchases.common;

import E5.m;
import E5.t;
import F5.J;
import com.revenuecat.purchases.models.GoogleReplacementMode;
import com.revenuecat.purchases.models.PricingPhase;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class BackendKt {
    public static final String ATTRIBUTES_ERROR_RESPONSE_KEY = "attributes_error_response";
    public static final String ATTRIBUTE_ERRORS_KEY = "attribute_errors";

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

    public static /* synthetic */ void CustomerCenterCallback$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LegacyProrationMode getAsLegacyProrationMode(GoogleReplacementMode googleReplacementMode) {
        int i7 = WhenMappings.$EnumSwitchMapping$0[googleReplacementMode.ordinal()];
        if (i7 == 1) {
            return LegacyProrationMode.IMMEDIATE_WITHOUT_PRORATION;
        }
        if (i7 == 2) {
            return LegacyProrationMode.IMMEDIATE_WITH_TIME_PRORATION;
        }
        if (i7 == 3) {
            return LegacyProrationMode.IMMEDIATE_AND_CHARGE_FULL_PRICE;
        }
        if (i7 == 4) {
            return LegacyProrationMode.IMMEDIATE_AND_CHARGE_PRORATED_PRICE;
        }
        if (i7 == 5) {
            return LegacyProrationMode.DEFERRED;
        }
        throw new m();
    }

    public static final Map<String, Object> toMap(PricingPhase pricingPhase) {
        r.f(pricingPhase, "<this>");
        return J.g(t.a("billingPeriod", pricingPhase.getBillingPeriod().getIso8601()), t.a("billingCycleCount", pricingPhase.getBillingCycleCount()), t.a("recurrenceMode", pricingPhase.getRecurrenceMode().getIdentifier()), t.a("formattedPrice", pricingPhase.getPrice().getFormatted()), t.a("priceAmountMicros", Long.valueOf(pricingPhase.getPrice().getAmountMicros())), t.a("priceCurrencyCode", pricingPhase.getPrice().getCurrencyCode()));
    }
}
