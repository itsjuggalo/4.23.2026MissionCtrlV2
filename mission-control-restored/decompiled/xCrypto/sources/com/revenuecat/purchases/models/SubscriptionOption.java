package com.revenuecat.purchases.models;

import X2.x;
import com.revenuecat.purchases.PresentedOfferingContext;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface SubscriptionOption {

    public static final class DefaultImpls {
        @Deprecated
        public static Period getBillingPeriod(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getBillingPeriod();
        }

        @Deprecated
        public static PricingPhase getFreePhase(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getFreePhase();
        }

        @Deprecated
        public static PricingPhase getFullPricePhase(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getFullPricePhase();
        }

        @Deprecated
        public static PricingPhase getIntroPhase(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.getIntroPhase();
        }

        public static /* synthetic */ void getPresentedOfferingIdentifier$annotations() {
        }

        @Deprecated
        public static boolean isBasePlan(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.isBasePlan();
        }

        @Deprecated
        public static boolean isPrepaid(SubscriptionOption subscriptionOption) {
            return SubscriptionOption.super.isPrepaid();
        }
    }

    default Period getBillingPeriod() {
        PricingPhase fullPricePhase = getFullPricePhase();
        if (fullPricePhase != null) {
            return fullPricePhase.getBillingPeriod();
        }
        return null;
    }

    default PricingPhase getFreePhase() {
        Object next;
        Iterator it = x.D(getPricingPhases(), 1).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PricingPhase) next).getPrice().getAmountMicros() == 0) {
                break;
            }
        }
        return (PricingPhase) next;
    }

    default PricingPhase getFullPricePhase() {
        return (PricingPhase) x.S(getPricingPhases());
    }

    String getId();

    InstallmentsInfo getInstallmentsInfo();

    default PricingPhase getIntroPhase() {
        Object next;
        Iterator it = x.D(getPricingPhases(), 1).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((PricingPhase) next).getPrice().getAmountMicros() > 0) {
                break;
            }
        }
        return (PricingPhase) next;
    }

    PresentedOfferingContext getPresentedOfferingContext();

    String getPresentedOfferingIdentifier();

    List<PricingPhase> getPricingPhases();

    PurchasingData getPurchasingData();

    List<String> getTags();

    default boolean isBasePlan() {
        return getPricingPhases().size() == 1;
    }

    default boolean isPrepaid() {
        PricingPhase fullPricePhase = getFullPricePhase();
        return (fullPricePhase != null ? fullPricePhase.getRecurrenceMode() : null) == RecurrenceMode.NON_RECURRING;
    }
}
