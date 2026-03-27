package com.revenuecat.purchases.hybridcommon.mappers;

import E5.m;
import E5.o;
import E5.t;
import F5.AbstractC0557o;
import F5.I;
import F5.J;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.amazon.AmazonStoreProduct;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.models.InstallmentsInfo;
import com.revenuecat.purchases.models.OfferPaymentMode;
import com.revenuecat.purchases.models.Period;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class StoreProductMapperKt {
    private static final int DAYS_PER_WEEK = 7;
    private static final double MICROS_CONVERSION_METRIC = 1000000.0d;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.INAPP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductType.SUBS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProductType.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[Period.Unit.values().length];
            try {
                iArr2[Period.Unit.DAY.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[Period.Unit.WEEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[Period.Unit.MONTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[Period.Unit.YEAR.ordinal()] = 4;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[Period.Unit.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final Integer getGoogleFreeTrialCycles(StoreProduct storeProduct) {
        PricingPhase freePhase;
        r.f(storeProduct, "<this>");
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption == null || (freePhase = defaultOption.getFreePhase()) == null) {
            return null;
        }
        return freePhase.getBillingCycleCount();
    }

    public static final Period getGoogleFreeTrialPeriod(StoreProduct storeProduct) {
        PricingPhase freePhase;
        r.f(storeProduct, "<this>");
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption == null || (freePhase = defaultOption.getFreePhase()) == null) {
            return null;
        }
        return freePhase.getBillingPeriod();
    }

    private static final PricingPhase getGoogleIntroductoryPhase(StoreProduct storeProduct) {
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption != null) {
            return defaultOption.getIntroPhase();
        }
        return null;
    }

    public static final String getGoogleIntroductoryPrice(StoreProduct storeProduct) {
        Price price;
        r.f(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase == null || (price = googleIntroductoryPhase.getPrice()) == null) {
            return null;
        }
        return price.getFormatted();
    }

    public static final long getGoogleIntroductoryPriceAmountMicros(StoreProduct storeProduct) {
        Price price;
        r.f(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase == null || (price = googleIntroductoryPhase.getPrice()) == null) {
            return 0L;
        }
        return price.getAmountMicros();
    }

    public static final int getGoogleIntroductoryPriceCycles(StoreProduct storeProduct) {
        Integer billingCycleCount;
        r.f(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase == null || (billingCycleCount = googleIntroductoryPhase.getBillingCycleCount()) == null) {
            return 0;
        }
        return billingCycleCount.intValue();
    }

    public static final Period getGoogleIntroductoryPricePeriod(StoreProduct storeProduct) {
        r.f(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase != null) {
            return googleIntroductoryPhase.getBillingPeriod();
        }
        return null;
    }

    public static final long getPriceAmountMicros(StoreProduct storeProduct) {
        r.f(storeProduct, "<this>");
        return storeProduct.getPrice().getAmountMicros();
    }

    public static final String getPriceCurrencyCode(StoreProduct storeProduct) {
        r.f(storeProduct, "<this>");
        return storeProduct.getPrice().getCurrencyCode();
    }

    public static final String getPriceString(StoreProduct storeProduct) {
        r.f(storeProduct, "<this>");
        return storeProduct.getPrice().getFormatted();
    }

    public static final Map<String, Object> map(StoreProduct storeProduct) {
        o oVar;
        String iso8601;
        o oVar2;
        Map<String, Object> mapMapSubscriptionOption;
        o oVar3;
        o oVar4;
        ArrayList arrayList;
        r.f(storeProduct, "<this>");
        o oVarA = t.a("identifier", storeProduct.getId());
        o oVarA2 = t.a(b.f9940c, storeProduct.getDescription());
        o oVarA3 = t.a(b.f9930S, storeProduct.getTitle());
        o oVarA4 = t.a(b.f9961x, Double.valueOf(getPriceAmountMicros(storeProduct) / 1000000.0d));
        o oVarA5 = t.a("priceString", getPriceString(storeProduct));
        o oVarA6 = t.a("currencyCode", getPriceCurrencyCode(storeProduct));
        o oVarA7 = t.a("introPrice", mapIntroPrice(storeProduct));
        o oVarA8 = t.a("discounts", null);
        Price pricePricePerWeek$default = StoreProduct.pricePerWeek$default(storeProduct, null, 1, null);
        o oVarA9 = t.a("pricePerWeek", pricePricePerWeek$default != null ? Long.valueOf(pricePricePerWeek$default.getAmountMicros()) : null);
        Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
        o oVarA10 = t.a("pricePerMonth", pricePricePerMonth$default != null ? Long.valueOf(pricePricePerMonth$default.getAmountMicros()) : null);
        Price pricePricePerYear$default = StoreProduct.pricePerYear$default(storeProduct, null, 1, null);
        o oVarA11 = t.a("pricePerYear", pricePricePerYear$default != null ? Long.valueOf(pricePricePerYear$default.getAmountMicros()) : null);
        Price pricePricePerWeek$default2 = StoreProduct.pricePerWeek$default(storeProduct, null, 1, null);
        o oVarA12 = t.a("pricePerWeekString", pricePricePerWeek$default2 != null ? pricePricePerWeek$default2.getFormatted() : null);
        Price pricePricePerMonth$default2 = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
        o oVarA13 = t.a("pricePerMonthString", pricePricePerMonth$default2 != null ? pricePricePerMonth$default2.getFormatted() : null);
        Price pricePricePerYear$default2 = StoreProduct.pricePerYear$default(storeProduct, null, 1, null);
        o oVarA14 = t.a("pricePerYearString", pricePricePerYear$default2 != null ? pricePricePerYear$default2.getFormatted() : null);
        o oVarA15 = t.a("productCategory", mapProductCategory(storeProduct).getValue());
        o oVarA16 = t.a("productType", mapProductType(storeProduct));
        Period period = storeProduct.getPeriod();
        if (period != null) {
            iso8601 = period.getIso8601();
            oVar = oVarA16;
        } else {
            oVar = oVarA16;
            iso8601 = null;
        }
        o oVarA17 = t.a(b.f9952o, iso8601);
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption != null) {
            mapMapSubscriptionOption = mapSubscriptionOption(defaultOption, storeProduct);
            oVar2 = oVarA17;
        } else {
            oVar2 = oVarA17;
            mapMapSubscriptionOption = null;
        }
        o oVarA18 = t.a("defaultOption", mapMapSubscriptionOption);
        SubscriptionOptions subscriptionOptions = storeProduct.getSubscriptionOptions();
        if (subscriptionOptions != null) {
            oVar4 = oVarA18;
            oVar3 = oVarA14;
            arrayList = new ArrayList(AbstractC0557o.q(subscriptionOptions, 10));
            Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
            while (it.hasNext()) {
                arrayList.add(mapSubscriptionOption(it.next(), storeProduct));
            }
        } else {
            oVar3 = oVarA14;
            oVar4 = oVarA18;
            arrayList = null;
        }
        o oVarA19 = t.a("subscriptionOptions", arrayList);
        PresentedOfferingContext presentedOfferingContext = storeProduct.getPresentedOfferingContext();
        o oVarA20 = t.a("presentedOfferingIdentifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = storeProduct.getPresentedOfferingContext();
        return J.g(oVarA, oVarA2, oVarA3, oVarA4, oVarA5, oVarA6, oVarA7, oVarA8, oVarA9, oVarA10, oVarA11, oVarA12, oVarA13, oVar3, oVarA15, oVar, oVar2, oVar4, oVarA19, oVarA20, t.a("presentedOfferingContext", presentedOfferingContext2 != null ? OfferingsMapperKt.map(presentedOfferingContext2) : null));
    }

    public static final Map<String, Object> mapIntroPrice(StoreProduct storeProduct) {
        Period googleIntroductoryPricePeriod;
        Map<String, Object> mapMapPeriodForStoreProduct;
        Map<String, Object> mapMapPeriodForStoreProduct2;
        Map<String, Object> mapMapPeriodForStoreProduct3;
        r.f(storeProduct, "<this>");
        if (storeProduct instanceof AmazonStoreProduct) {
            AmazonStoreProduct amazonStoreProduct = (AmazonStoreProduct) storeProduct;
            Period freeTrialPeriod = amazonStoreProduct.getFreeTrialPeriod();
            if (freeTrialPeriod == null || (mapMapPeriodForStoreProduct3 = mapPeriodForStoreProduct(freeTrialPeriod)) == null) {
                return null;
            }
            o oVarA = t.a(b.f9961x, 0);
            o oVarA2 = t.a("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0L));
            Period freeTrialPeriod2 = amazonStoreProduct.getFreeTrialPeriod();
            return J.k(J.g(oVarA, oVarA2, t.a("period", freeTrialPeriod2 != null ? freeTrialPeriod2.getIso8601() : null), t.a("cycles", 1)), mapMapPeriodForStoreProduct3);
        }
        if (getGoogleFreeTrialPeriod(storeProduct) == null) {
            if (getGoogleIntroductoryPrice(storeProduct) == null || (googleIntroductoryPricePeriod = getGoogleIntroductoryPricePeriod(storeProduct)) == null || (mapMapPeriodForStoreProduct = mapPeriodForStoreProduct(googleIntroductoryPricePeriod)) == null) {
                return null;
            }
            o oVarA3 = t.a(b.f9961x, Double.valueOf(getGoogleIntroductoryPriceAmountMicros(storeProduct) / 1000000.0d));
            o oVarA4 = t.a("priceString", getGoogleIntroductoryPrice(storeProduct));
            Period googleIntroductoryPricePeriod2 = getGoogleIntroductoryPricePeriod(storeProduct);
            return J.k(J.g(oVarA3, oVarA4, t.a("period", googleIntroductoryPricePeriod2 != null ? googleIntroductoryPricePeriod2.getIso8601() : null), t.a("cycles", Integer.valueOf(getGoogleIntroductoryPriceCycles(storeProduct)))), mapMapPeriodForStoreProduct);
        }
        Period googleFreeTrialPeriod = getGoogleFreeTrialPeriod(storeProduct);
        if (googleFreeTrialPeriod == null || (mapMapPeriodForStoreProduct2 = mapPeriodForStoreProduct(googleFreeTrialPeriod)) == null) {
            return null;
        }
        o oVarA5 = t.a(b.f9961x, 0);
        o oVarA6 = t.a("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0L));
        Period googleFreeTrialPeriod2 = getGoogleFreeTrialPeriod(storeProduct);
        o oVarA7 = t.a("period", googleFreeTrialPeriod2 != null ? googleFreeTrialPeriod2.getIso8601() : null);
        Integer googleFreeTrialCycles = getGoogleFreeTrialCycles(storeProduct);
        return J.k(J.g(oVarA5, oVarA6, oVarA7, t.a("cycles", Integer.valueOf(googleFreeTrialCycles != null ? googleFreeTrialCycles.intValue() : 1))), mapMapPeriodForStoreProduct2);
    }

    private static final Map<String, Object> mapPeriod(Period period) {
        Map mapG;
        int i7 = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i7 == 1) {
            mapG = J.g(t.a("unit", "DAY"), t.a("value", Integer.valueOf(period.getValue())));
        } else if (i7 == 2) {
            mapG = J.g(t.a("unit", "DAY"), t.a("value", Integer.valueOf(period.getValue() * 7)));
        } else if (i7 == 3) {
            mapG = J.g(t.a("unit", "MONTH"), t.a("value", Integer.valueOf(period.getValue())));
        } else if (i7 == 4) {
            mapG = J.g(t.a("unit", "YEAR"), t.a("value", Integer.valueOf(period.getValue())));
        } else {
            if (i7 != 5) {
                throw new m();
            }
            mapG = J.g(t.a("unit", "DAY"), t.a("value", 0));
        }
        return J.k(mapG, I.c(t.a("iso8601", period.getIso8601())));
    }

    private static final Map<String, Object> mapPeriodForStoreProduct(Period period) {
        int i7 = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i7 == 1) {
            return J.g(t.a("periodUnit", "DAY"), t.a("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i7 == 2) {
            return J.g(t.a("periodUnit", "DAY"), t.a("periodNumberOfUnits", Integer.valueOf(period.getValue() * 7)));
        }
        if (i7 == 3) {
            return J.g(t.a("periodUnit", "MONTH"), t.a("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i7 == 4) {
            return J.g(t.a("periodUnit", "YEAR"), t.a("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i7 == 5) {
            return J.g(t.a("periodUnit", "DAY"), t.a("periodNumberOfUnits", 0));
        }
        throw new m();
    }

    private static final Map<String, Object> mapPrice(Price price) {
        return J.g(t.a("formatted", price.getFormatted()), t.a("amountMicros", Long.valueOf(price.getAmountMicros())), t.a("currencyCode", price.getCurrencyCode()));
    }

    private static final Map<String, Object> mapPricingPhase(PricingPhase pricingPhase) {
        Period billingPeriod = pricingPhase.getBillingPeriod();
        o oVarA = t.a("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        o oVarA2 = t.a("recurrenceMode", pricingPhase.getRecurrenceMode().getIdentifier());
        o oVarA3 = t.a("billingCycleCount", pricingPhase.getBillingCycleCount());
        o oVarA4 = t.a(b.f9961x, mapPrice(pricingPhase.getPrice()));
        OfferPaymentMode offerPaymentMode = pricingPhase.getOfferPaymentMode();
        return J.g(oVarA, oVarA2, oVarA3, oVarA4, t.a("offerPaymentMode", offerPaymentMode != null ? offerPaymentMode.toString() : null));
    }

    public static final MappedProductCategory mapProductCategory(StoreProduct storeProduct) {
        r.f(storeProduct, "<this>");
        int i7 = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i7 == 1) {
            return MappedProductCategory.NON_SUBSCRIPTION;
        }
        if (i7 == 2) {
            return MappedProductCategory.SUBSCRIPTION;
        }
        if (i7 == 3) {
            return MappedProductCategory.UNKNOWN;
        }
        throw new m();
    }

    public static final String mapProductType(StoreProduct storeProduct) {
        r.f(storeProduct, "<this>");
        int i7 = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i7 == 1) {
            return "CONSUMABLE";
        }
        if (i7 == 2) {
            SubscriptionOption defaultOption = storeProduct.getDefaultOption();
            return (defaultOption == null || !defaultOption.isPrepaid()) ? "AUTO_RENEWABLE_SUBSCRIPTION" : "PREPAID_SUBSCRIPTION";
        }
        if (i7 == 3) {
            return "UNKNOWN";
        }
        throw new m();
    }

    private static final Map<String, Object> mapSubscriptionOption(SubscriptionOption subscriptionOption, StoreProduct storeProduct) {
        o oVarA = t.a(DiagnosticsEntry.ID_KEY, subscriptionOption.getId());
        o oVarA2 = t.a("storeProductId", storeProduct.getId());
        o oVarA3 = t.a("productId", storeProduct.getPurchasingData().getProductId());
        List<PricingPhase> pricingPhases = subscriptionOption.getPricingPhases();
        ArrayList arrayList = new ArrayList(AbstractC0557o.q(pricingPhases, 10));
        Iterator<T> it = pricingPhases.iterator();
        while (it.hasNext()) {
            arrayList.add(mapPricingPhase((PricingPhase) it.next()));
        }
        o oVarA4 = t.a("pricingPhases", arrayList);
        o oVarA5 = t.a("tags", subscriptionOption.getTags());
        o oVarA6 = t.a("isBasePlan", Boolean.valueOf(subscriptionOption.isBasePlan()));
        Period billingPeriod = subscriptionOption.getBillingPeriod();
        o oVarA7 = t.a("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        o oVarA8 = t.a("isPrepaid", Boolean.valueOf(subscriptionOption.isPrepaid()));
        PricingPhase fullPricePhase = subscriptionOption.getFullPricePhase();
        o oVarA9 = t.a("fullPricePhase", fullPricePhase != null ? mapPricingPhase(fullPricePhase) : null);
        PricingPhase freePhase = subscriptionOption.getFreePhase();
        o oVarA10 = t.a("freePhase", freePhase != null ? mapPricingPhase(freePhase) : null);
        PricingPhase introPhase = subscriptionOption.getIntroPhase();
        o oVarA11 = t.a("introPhase", introPhase != null ? mapPricingPhase(introPhase) : null);
        PresentedOfferingContext presentedOfferingContext = subscriptionOption.getPresentedOfferingContext();
        o oVarA12 = t.a("presentedOfferingIdentifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = subscriptionOption.getPresentedOfferingContext();
        o oVarA13 = t.a("presentedOfferingContext", presentedOfferingContext2 != null ? OfferingsMapperKt.map(presentedOfferingContext2) : null);
        InstallmentsInfo installmentsInfo = subscriptionOption.getInstallmentsInfo();
        return J.g(oVarA, oVarA2, oVarA3, oVarA4, oVarA5, oVarA6, oVarA7, oVarA8, oVarA9, oVarA10, oVarA11, oVarA12, oVarA13, t.a("installmentsInfo", installmentsInfo != null ? map(installmentsInfo) : null));
    }

    private static final Map<String, Object> map(InstallmentsInfo installmentsInfo) {
        return J.g(t.a("commitmentPaymentsCount", Integer.valueOf(installmentsInfo.getCommitmentPaymentsCount())), t.a("renewalCommitmentPaymentsCount", Integer.valueOf(installmentsInfo.getRenewalCommitmentPaymentsCount())));
    }

    public static final List<Map<String, Object>> map(List<? extends StoreProduct> list) {
        r.f(list, "<this>");
        ArrayList arrayList = new ArrayList(AbstractC0557o.q(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(map((StoreProduct) it.next()));
        }
        return arrayList;
    }
}
