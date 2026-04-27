package com.revenuecat.purchases.hybridcommon.mappers;

import W2.E;
import W2.m;
import W2.q;
import W2.t;
import X2.AbstractC0770q;
import X2.K;
import Z2.e;
import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import b3.l;
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
import i3.k;
import i3.o;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import t3.AbstractC1818i;
import t3.AbstractC1822k;
import t3.I;
import t3.L;

/* JADX INFO: loaded from: classes3.dex */
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

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt$mapAsync$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt$mapAsync$1", f = "StoreProductMapper.kt", l = {72}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        final /* synthetic */ k $callback;
        final /* synthetic */ List<StoreProduct> $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(k kVar, List<? extends StoreProduct> list, e eVar) {
            super(2, eVar);
            this.$callback = kVar;
            this.$this_mapAsync = list;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return new AnonymousClass1(this.$callback, this.$this_mapAsync, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                q.b(obj);
                I mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                StoreProductMapperKt$mapAsync$1$map$1 storeProductMapperKt$mapAsync$1$map$1 = new StoreProductMapperKt$mapAsync$1$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = AbstractC1818i.g(mapperDispatcher, storeProductMapperKt$mapAsync$1$map$1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            this.$callback.invoke((List) obj);
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass1) create(l4, eVar)).invokeSuspend(E.f5463a);
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
        W2.o oVar;
        ArrayList arrayList;
        r.f(storeProduct, "<this>");
        W2.o oVarA = t.a(Constants.IDENTIFIER, storeProduct.getId());
        W2.o oVarA2 = t.a(b.f8755c, storeProduct.getDescription());
        W2.o oVarA3 = t.a(b.f8745S, storeProduct.getTitle());
        W2.o oVarA4 = t.a("price", Double.valueOf(getPriceAmountMicros(storeProduct) / 1000000.0d));
        W2.o oVarA5 = t.a("priceString", getPriceString(storeProduct));
        W2.o oVarA6 = t.a("currencyCode", getPriceCurrencyCode(storeProduct));
        W2.o oVarA7 = t.a("introPrice", mapIntroPrice(storeProduct));
        W2.o oVarA8 = t.a("discounts", null);
        Price pricePricePerWeek$default = StoreProduct.pricePerWeek$default(storeProduct, null, 1, null);
        W2.o oVarA9 = t.a("pricePerWeek", pricePricePerWeek$default != null ? Long.valueOf(pricePricePerWeek$default.getAmountMicros()) : null);
        Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
        W2.o oVarA10 = t.a("pricePerMonth", pricePricePerMonth$default != null ? Long.valueOf(pricePricePerMonth$default.getAmountMicros()) : null);
        Price pricePricePerYear$default = StoreProduct.pricePerYear$default(storeProduct, null, 1, null);
        W2.o oVarA11 = t.a("pricePerYear", pricePricePerYear$default != null ? Long.valueOf(pricePricePerYear$default.getAmountMicros()) : null);
        Price pricePricePerWeek$default2 = StoreProduct.pricePerWeek$default(storeProduct, null, 1, null);
        W2.o oVarA12 = t.a("pricePerWeekString", pricePricePerWeek$default2 != null ? pricePricePerWeek$default2.getFormatted() : null);
        Price pricePricePerMonth$default2 = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
        W2.o oVarA13 = t.a("pricePerMonthString", pricePricePerMonth$default2 != null ? pricePricePerMonth$default2.getFormatted() : null);
        Price pricePricePerYear$default2 = StoreProduct.pricePerYear$default(storeProduct, null, 1, null);
        W2.o oVarA14 = t.a("pricePerYearString", pricePricePerYear$default2 != null ? pricePricePerYear$default2.getFormatted() : null);
        W2.o oVarA15 = t.a("productCategory", mapProductCategory(storeProduct).getValue());
        W2.o oVarA16 = t.a("productType", mapProductType(storeProduct));
        Period period = storeProduct.getPeriod();
        W2.o oVarA17 = t.a(b.f8767o, period != null ? period.getIso8601() : null);
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        W2.o oVarA18 = t.a("defaultOption", defaultOption != null ? mapSubscriptionOption(defaultOption, storeProduct) : null);
        SubscriptionOptions subscriptionOptions = storeProduct.getSubscriptionOptions();
        if (subscriptionOptions != null) {
            oVar = oVarA15;
            arrayList = new ArrayList(AbstractC0770q.q(subscriptionOptions, 10));
            Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
            while (it.hasNext()) {
                arrayList.add(mapSubscriptionOption(it.next(), storeProduct));
            }
        } else {
            oVar = oVarA15;
            arrayList = null;
        }
        W2.o oVarA19 = t.a("subscriptionOptions", arrayList);
        PresentedOfferingContext presentedOfferingContext = storeProduct.getPresentedOfferingContext();
        W2.o oVarA20 = t.a("presentedOfferingIdentifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = storeProduct.getPresentedOfferingContext();
        return X2.L.g(oVarA, oVarA2, oVarA3, oVarA4, oVarA5, oVarA6, oVarA7, oVarA8, oVarA9, oVarA10, oVarA11, oVarA12, oVarA13, oVarA14, oVar, oVarA16, oVarA17, oVarA18, oVarA19, oVarA20, t.a("presentedOfferingContext", presentedOfferingContext2 != null ? OfferingsMapperKt.map(presentedOfferingContext2) : null));
    }

    public static final void mapAsync(List<? extends StoreProduct> list, k callback) {
        r.f(list, "<this>");
        r.f(callback, "callback");
        AbstractC1822k.d(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass1(callback, list, null), 3, null);
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
            W2.o oVarA = t.a("price", 0);
            W2.o oVarA2 = t.a("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0L));
            Period freeTrialPeriod2 = amazonStoreProduct.getFreeTrialPeriod();
            return X2.L.k(X2.L.g(oVarA, oVarA2, t.a("period", freeTrialPeriod2 != null ? freeTrialPeriod2.getIso8601() : null), t.a("cycles", 1)), mapMapPeriodForStoreProduct3);
        }
        if (getGoogleFreeTrialPeriod(storeProduct) == null) {
            if (getGoogleIntroductoryPrice(storeProduct) == null || (googleIntroductoryPricePeriod = getGoogleIntroductoryPricePeriod(storeProduct)) == null || (mapMapPeriodForStoreProduct = mapPeriodForStoreProduct(googleIntroductoryPricePeriod)) == null) {
                return null;
            }
            W2.o oVarA3 = t.a("price", Double.valueOf(getGoogleIntroductoryPriceAmountMicros(storeProduct) / 1000000.0d));
            W2.o oVarA4 = t.a("priceString", getGoogleIntroductoryPrice(storeProduct));
            Period googleIntroductoryPricePeriod2 = getGoogleIntroductoryPricePeriod(storeProduct);
            return X2.L.k(X2.L.g(oVarA3, oVarA4, t.a("period", googleIntroductoryPricePeriod2 != null ? googleIntroductoryPricePeriod2.getIso8601() : null), t.a("cycles", Integer.valueOf(getGoogleIntroductoryPriceCycles(storeProduct)))), mapMapPeriodForStoreProduct);
        }
        Period googleFreeTrialPeriod = getGoogleFreeTrialPeriod(storeProduct);
        if (googleFreeTrialPeriod == null || (mapMapPeriodForStoreProduct2 = mapPeriodForStoreProduct(googleFreeTrialPeriod)) == null) {
            return null;
        }
        W2.o oVarA5 = t.a("price", 0);
        W2.o oVarA6 = t.a("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0L));
        Period googleFreeTrialPeriod2 = getGoogleFreeTrialPeriod(storeProduct);
        W2.o oVarA7 = t.a("period", googleFreeTrialPeriod2 != null ? googleFreeTrialPeriod2.getIso8601() : null);
        Integer googleFreeTrialCycles = getGoogleFreeTrialCycles(storeProduct);
        return X2.L.k(X2.L.g(oVarA5, oVarA6, oVarA7, t.a("cycles", Integer.valueOf(googleFreeTrialCycles != null ? googleFreeTrialCycles.intValue() : 1))), mapMapPeriodForStoreProduct2);
    }

    private static final Map<String, Object> mapPeriod(Period period) {
        Map mapG;
        int i4 = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i4 == 1) {
            mapG = X2.L.g(t.a("unit", "DAY"), t.a("value", Integer.valueOf(period.getValue())));
        } else if (i4 == 2) {
            mapG = X2.L.g(t.a("unit", "DAY"), t.a("value", Integer.valueOf(period.getValue() * 7)));
        } else if (i4 == 3) {
            mapG = X2.L.g(t.a("unit", "MONTH"), t.a("value", Integer.valueOf(period.getValue())));
        } else if (i4 == 4) {
            mapG = X2.L.g(t.a("unit", "YEAR"), t.a("value", Integer.valueOf(period.getValue())));
        } else {
            if (i4 != 5) {
                throw new m();
            }
            mapG = X2.L.g(t.a("unit", "DAY"), t.a("value", 0));
        }
        return X2.L.k(mapG, K.c(t.a("iso8601", period.getIso8601())));
    }

    private static final Map<String, Object> mapPeriodForStoreProduct(Period period) {
        int i4 = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i4 == 1) {
            return X2.L.g(t.a("periodUnit", "DAY"), t.a("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i4 == 2) {
            return X2.L.g(t.a("periodUnit", "DAY"), t.a("periodNumberOfUnits", Integer.valueOf(period.getValue() * 7)));
        }
        if (i4 == 3) {
            return X2.L.g(t.a("periodUnit", "MONTH"), t.a("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i4 == 4) {
            return X2.L.g(t.a("periodUnit", "YEAR"), t.a("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i4 == 5) {
            return X2.L.g(t.a("periodUnit", "DAY"), t.a("periodNumberOfUnits", 0));
        }
        throw new m();
    }

    private static final Map<String, Object> mapPrice(Price price) {
        return X2.L.g(t.a("formatted", price.getFormatted()), t.a("amountMicros", Long.valueOf(price.getAmountMicros())), t.a("currencyCode", price.getCurrencyCode()));
    }

    private static final Map<String, Object> mapPricingPhase(PricingPhase pricingPhase) {
        Period billingPeriod = pricingPhase.getBillingPeriod();
        W2.o oVarA = t.a("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        W2.o oVarA2 = t.a("recurrenceMode", pricingPhase.getRecurrenceMode().getIdentifier());
        W2.o oVarA3 = t.a("billingCycleCount", pricingPhase.getBillingCycleCount());
        W2.o oVarA4 = t.a("price", mapPrice(pricingPhase.getPrice()));
        OfferPaymentMode offerPaymentMode = pricingPhase.getOfferPaymentMode();
        return X2.L.g(oVarA, oVarA2, oVarA3, oVarA4, t.a("offerPaymentMode", offerPaymentMode != null ? offerPaymentMode.toString() : null));
    }

    public static final MappedProductCategory mapProductCategory(StoreProduct storeProduct) {
        r.f(storeProduct, "<this>");
        int i4 = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i4 == 1) {
            return MappedProductCategory.NON_SUBSCRIPTION;
        }
        if (i4 == 2) {
            return MappedProductCategory.SUBSCRIPTION;
        }
        if (i4 == 3) {
            return MappedProductCategory.UNKNOWN;
        }
        throw new m();
    }

    public static final String mapProductType(StoreProduct storeProduct) {
        r.f(storeProduct, "<this>");
        int i4 = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i4 == 1) {
            return "CONSUMABLE";
        }
        if (i4 == 2) {
            SubscriptionOption defaultOption = storeProduct.getDefaultOption();
            return (defaultOption == null || !defaultOption.isPrepaid()) ? "AUTO_RENEWABLE_SUBSCRIPTION" : "PREPAID_SUBSCRIPTION";
        }
        if (i4 == 3) {
            return "UNKNOWN";
        }
        throw new m();
    }

    private static final Map<String, Object> mapSubscriptionOption(SubscriptionOption subscriptionOption, StoreProduct storeProduct) {
        W2.o oVarA = t.a(DiagnosticsEntry.ID_KEY, subscriptionOption.getId());
        W2.o oVarA2 = t.a("storeProductId", storeProduct.getId());
        W2.o oVarA3 = t.a("productId", storeProduct.getPurchasingData().getProductId());
        List<PricingPhase> pricingPhases = subscriptionOption.getPricingPhases();
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(pricingPhases, 10));
        Iterator<T> it = pricingPhases.iterator();
        while (it.hasNext()) {
            arrayList.add(mapPricingPhase((PricingPhase) it.next()));
        }
        W2.o oVarA4 = t.a("pricingPhases", arrayList);
        W2.o oVarA5 = t.a("tags", subscriptionOption.getTags());
        W2.o oVarA6 = t.a("isBasePlan", Boolean.valueOf(subscriptionOption.isBasePlan()));
        Period billingPeriod = subscriptionOption.getBillingPeriod();
        W2.o oVarA7 = t.a("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        W2.o oVarA8 = t.a("isPrepaid", Boolean.valueOf(subscriptionOption.isPrepaid()));
        PricingPhase fullPricePhase = subscriptionOption.getFullPricePhase();
        W2.o oVarA9 = t.a("fullPricePhase", fullPricePhase != null ? mapPricingPhase(fullPricePhase) : null);
        PricingPhase freePhase = subscriptionOption.getFreePhase();
        W2.o oVarA10 = t.a("freePhase", freePhase != null ? mapPricingPhase(freePhase) : null);
        PricingPhase introPhase = subscriptionOption.getIntroPhase();
        W2.o oVarA11 = t.a("introPhase", introPhase != null ? mapPricingPhase(introPhase) : null);
        PresentedOfferingContext presentedOfferingContext = subscriptionOption.getPresentedOfferingContext();
        W2.o oVarA12 = t.a("presentedOfferingIdentifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = subscriptionOption.getPresentedOfferingContext();
        W2.o oVarA13 = t.a("presentedOfferingContext", presentedOfferingContext2 != null ? OfferingsMapperKt.map(presentedOfferingContext2) : null);
        InstallmentsInfo installmentsInfo = subscriptionOption.getInstallmentsInfo();
        return X2.L.g(oVarA, oVarA2, oVarA3, oVarA4, oVarA5, oVarA6, oVarA7, oVarA8, oVarA9, oVarA10, oVarA11, oVarA12, oVarA13, t.a("installmentsInfo", installmentsInfo != null ? map(installmentsInfo) : null));
    }

    private static final Map<String, Object> map(InstallmentsInfo installmentsInfo) {
        return X2.L.g(t.a("commitmentPaymentsCount", Integer.valueOf(installmentsInfo.getCommitmentPaymentsCount())), t.a("renewalCommitmentPaymentsCount", Integer.valueOf(installmentsInfo.getRenewalCommitmentPaymentsCount())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Map<String, Object>> map(List<? extends StoreProduct> list) {
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(map((StoreProduct) it.next()));
        }
        return arrayList;
    }
}
