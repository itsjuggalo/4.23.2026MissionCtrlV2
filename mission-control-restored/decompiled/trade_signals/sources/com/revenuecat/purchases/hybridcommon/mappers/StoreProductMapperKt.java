package com.revenuecat.purchases.hybridcommon.mappers;

import B5.k;
import B5.o;
import Y6.AbstractC1005g;
import Y6.AbstractC1009i;
import Y6.I;
import Y6.L;
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
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2470H;
import o5.C2487o;
import o5.C2489q;
import o5.w;
import p5.M;
import p5.r;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2785l;
import u5.InterfaceC2779f;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u001a\u001a\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a-\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0006*\b\u0012\u0004\u0012\u00020\u00000\u0006H\u0002¢\u0006\u0004\b\u0004\u0010\u0007\u001a?\u0010\u000b\u001a\u00020\t*\b\u0012\u0004\u0012\u00020\u00000\u00062&\u0010\n\u001a\"\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0006\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0000H\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u0010\u001a\u00020\u0002*\u00020\u0000H\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001*\u00020\u0000H\u0001¢\u0006\u0004\b\u0012\u0010\u0005\u001a!\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015\u001a#\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001*\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0015\u001a)\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0000H\u0002¢\u0006\u0004\b\u0019\u0010\u001a\u001a!\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u001bH\u0002¢\u0006\u0004\b\u001c\u0010\u001d\u001a!\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a!\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020!H\u0002¢\u0006\u0004\b\u0004\u0010\"\"\u0014\u0010$\u001a\u00020#8\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010%\"\u0014\u0010'\u001a\u00020&8\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010(\"\u0015\u0010,\u001a\u00020)*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b*\u0010+\"\u0015\u0010.\u001a\u00020\u0002*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b-\u0010\u0011\"\u0015\u00100\u001a\u00020\u0002*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b/\u0010\u0011\"\u0017\u00103\u001a\u0004\u0018\u00010\u0013*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b1\u00102\"\u0017\u00106\u001a\u0004\u0018\u00010#*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b4\u00105\"\u001a\u00109\u001a\u0004\u0018\u00010\u001b*\u00020\u00008BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u00108\"\u0017\u0010;\u001a\u0004\u0018\u00010\u0002*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b:\u0010\u0011\"\u0017\u0010=\u001a\u0004\u0018\u00010\u0013*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b<\u00102\"\u0015\u0010?\u001a\u00020)*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b>\u0010+\"\u0015\u0010B\u001a\u00020#*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b@\u0010A¨\u0006C"}, d2 = {"Lcom/revenuecat/purchases/models/StoreProduct;", "", "", "", "map", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/util/Map;", "", "(Ljava/util/List;)Ljava/util/List;", "Lkotlin/Function1;", "Lo5/H;", "callback", "mapAsync", "(Ljava/util/List;LB5/k;)V", "Lcom/revenuecat/purchases/hybridcommon/mappers/MappedProductCategory;", "mapProductCategory", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/hybridcommon/mappers/MappedProductCategory;", "mapProductType", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/lang/String;", "mapIntroPrice", "Lcom/revenuecat/purchases/models/Period;", "mapPeriodForStoreProduct", "(Lcom/revenuecat/purchases/models/Period;)Ljava/util/Map;", "mapPeriod", "Lcom/revenuecat/purchases/models/SubscriptionOption;", "storeProduct", "mapSubscriptionOption", "(Lcom/revenuecat/purchases/models/SubscriptionOption;Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/util/Map;", "Lcom/revenuecat/purchases/models/PricingPhase;", "mapPricingPhase", "(Lcom/revenuecat/purchases/models/PricingPhase;)Ljava/util/Map;", "Lcom/revenuecat/purchases/models/Price;", "mapPrice", "(Lcom/revenuecat/purchases/models/Price;)Ljava/util/Map;", "Lcom/revenuecat/purchases/models/InstallmentsInfo;", "(Lcom/revenuecat/purchases/models/InstallmentsInfo;)Ljava/util/Map;", "", "DAYS_PER_WEEK", "I", "", "MICROS_CONVERSION_METRIC", "D", "", "getPriceAmountMicros", "(Lcom/revenuecat/purchases/models/StoreProduct;)J", "priceAmountMicros", "getPriceString", "priceString", "getPriceCurrencyCode", "priceCurrencyCode", "getGoogleFreeTrialPeriod", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/models/Period;", "googleFreeTrialPeriod", "getGoogleFreeTrialCycles", "(Lcom/revenuecat/purchases/models/StoreProduct;)Ljava/lang/Integer;", "googleFreeTrialCycles", "getGoogleIntroductoryPhase", "(Lcom/revenuecat/purchases/models/StoreProduct;)Lcom/revenuecat/purchases/models/PricingPhase;", "googleIntroductoryPhase", "getGoogleIntroductoryPrice", "googleIntroductoryPrice", "getGoogleIntroductoryPricePeriod", "googleIntroductoryPricePeriod", "getGoogleIntroductoryPriceAmountMicros", "googleIntroductoryPriceAmountMicros", "getGoogleIntroductoryPriceCycles", "(Lcom/revenuecat/purchases/models/StoreProduct;)I", "googleIntroductoryPriceCycles", "hybridcommon_release"}, k = 2, mv = {1, 8, 0})
public final class StoreProductMapperKt {
    private static final int DAYS_PER_WEEK = 7;
    private static final double MICROS_CONVERSION_METRIC = 1000000.0d;

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
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
    @InterfaceC2779f(c = "com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt$mapAsync$1", f = "StoreProductMapper.kt", l = {72}, m = "invokeSuspend")
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LY6/L;", "Lo5/H;", "<anonymous>", "(LY6/L;)V"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends AbstractC2785l implements o {
        final /* synthetic */ k $callback;
        final /* synthetic */ List<StoreProduct> $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(k kVar, List<? extends StoreProduct> list, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.$callback = kVar;
            this.$this_mapAsync = list;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new AnonymousClass1(this.$callback, this.$this_mapAsync, interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((AnonymousClass1) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.label;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                I mapperDispatcher = MappersHelpersKt.getMapperDispatcher();
                StoreProductMapperKt$mapAsync$1$map$1 storeProductMapperKt$mapAsync$1$map$1 = new StoreProductMapperKt$mapAsync$1$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = AbstractC1005g.g(mapperDispatcher, storeProductMapperKt$mapAsync$1$map$1, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            this.$callback.invoke((List) obj);
            return C2470H.f21956a;
        }
    }

    public static final Integer getGoogleFreeTrialCycles(StoreProduct storeProduct) {
        PricingPhase freePhase;
        AbstractC2304t.f(storeProduct, "<this>");
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption == null || (freePhase = defaultOption.getFreePhase()) == null) {
            return null;
        }
        return freePhase.getBillingCycleCount();
    }

    public static final Period getGoogleFreeTrialPeriod(StoreProduct storeProduct) {
        PricingPhase freePhase;
        AbstractC2304t.f(storeProduct, "<this>");
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
        AbstractC2304t.f(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase == null || (price = googleIntroductoryPhase.getPrice()) == null) {
            return null;
        }
        return price.getFormatted();
    }

    public static final long getGoogleIntroductoryPriceAmountMicros(StoreProduct storeProduct) {
        Price price;
        AbstractC2304t.f(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase == null || (price = googleIntroductoryPhase.getPrice()) == null) {
            return 0L;
        }
        return price.getAmountMicros();
    }

    public static final int getGoogleIntroductoryPriceCycles(StoreProduct storeProduct) {
        Integer billingCycleCount;
        AbstractC2304t.f(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase == null || (billingCycleCount = googleIntroductoryPhase.getBillingCycleCount()) == null) {
            return 0;
        }
        return billingCycleCount.intValue();
    }

    public static final Period getGoogleIntroductoryPricePeriod(StoreProduct storeProduct) {
        AbstractC2304t.f(storeProduct, "<this>");
        PricingPhase googleIntroductoryPhase = getGoogleIntroductoryPhase(storeProduct);
        if (googleIntroductoryPhase != null) {
            return googleIntroductoryPhase.getBillingPeriod();
        }
        return null;
    }

    public static final long getPriceAmountMicros(StoreProduct storeProduct) {
        AbstractC2304t.f(storeProduct, "<this>");
        return storeProduct.getPrice().getAmountMicros();
    }

    public static final String getPriceCurrencyCode(StoreProduct storeProduct) {
        AbstractC2304t.f(storeProduct, "<this>");
        return storeProduct.getPrice().getCurrencyCode();
    }

    public static final String getPriceString(StoreProduct storeProduct) {
        AbstractC2304t.f(storeProduct, "<this>");
        return storeProduct.getPrice().getFormatted();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Map<String, Object>> map(List<? extends StoreProduct> list) {
        ArrayList arrayList = new ArrayList(r.s(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(map((StoreProduct) it.next()));
        }
        return arrayList;
    }

    public static final void mapAsync(List<? extends StoreProduct> list, k callback) {
        AbstractC2304t.f(list, "<this>");
        AbstractC2304t.f(callback, "callback");
        AbstractC1009i.d(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass1(callback, list, null), 3, null);
    }

    public static final Map<String, Object> mapIntroPrice(StoreProduct storeProduct) {
        Period googleIntroductoryPricePeriod;
        Map<String, Object> mapMapPeriodForStoreProduct;
        Map mapK;
        Map<String, Object> mapMapPeriodForStoreProduct2;
        AbstractC2304t.f(storeProduct, "<this>");
        if (storeProduct instanceof AmazonStoreProduct) {
            AmazonStoreProduct amazonStoreProduct = (AmazonStoreProduct) storeProduct;
            Period freeTrialPeriod = amazonStoreProduct.getFreeTrialPeriod();
            if (freeTrialPeriod == null || (mapMapPeriodForStoreProduct2 = mapPeriodForStoreProduct(freeTrialPeriod)) == null) {
                return null;
            }
            C2489q c2489qA = w.a("price", 0);
            C2489q c2489qA2 = w.a("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0L));
            Period freeTrialPeriod2 = amazonStoreProduct.getFreeTrialPeriod();
            return M.o(M.k(c2489qA, c2489qA2, w.a("period", freeTrialPeriod2 != null ? freeTrialPeriod2.getIso8601() : null), w.a("cycles", 1)), mapMapPeriodForStoreProduct2);
        }
        if (getGoogleFreeTrialPeriod(storeProduct) != null) {
            Period googleFreeTrialPeriod = getGoogleFreeTrialPeriod(storeProduct);
            if (googleFreeTrialPeriod == null || (mapMapPeriodForStoreProduct = mapPeriodForStoreProduct(googleFreeTrialPeriod)) == null) {
                return null;
            }
            C2489q c2489qA3 = w.a("price", 0);
            C2489q c2489qA4 = w.a("priceString", MappersHelpersKt.formatUsingDeviceLocale(getPriceCurrencyCode(storeProduct), 0L));
            Period googleFreeTrialPeriod2 = getGoogleFreeTrialPeriod(storeProduct);
            C2489q c2489qA5 = w.a("period", googleFreeTrialPeriod2 != null ? googleFreeTrialPeriod2.getIso8601() : null);
            Integer googleFreeTrialCycles = getGoogleFreeTrialCycles(storeProduct);
            mapK = M.k(c2489qA3, c2489qA4, c2489qA5, w.a("cycles", Integer.valueOf(googleFreeTrialCycles != null ? googleFreeTrialCycles.intValue() : 1)));
        } else {
            if (getGoogleIntroductoryPrice(storeProduct) == null || (googleIntroductoryPricePeriod = getGoogleIntroductoryPricePeriod(storeProduct)) == null || (mapMapPeriodForStoreProduct = mapPeriodForStoreProduct(googleIntroductoryPricePeriod)) == null) {
                return null;
            }
            C2489q c2489qA6 = w.a("price", Double.valueOf(getGoogleIntroductoryPriceAmountMicros(storeProduct) / 1000000.0d));
            C2489q c2489qA7 = w.a("priceString", getGoogleIntroductoryPrice(storeProduct));
            Period googleIntroductoryPricePeriod2 = getGoogleIntroductoryPricePeriod(storeProduct);
            mapK = M.k(c2489qA6, c2489qA7, w.a("period", googleIntroductoryPricePeriod2 != null ? googleIntroductoryPricePeriod2.getIso8601() : null), w.a("cycles", Integer.valueOf(getGoogleIntroductoryPriceCycles(storeProduct))));
        }
        return M.o(mapK, mapMapPeriodForStoreProduct);
    }

    private static final Map<String, Object> mapPeriod(Period period) {
        Map mapK;
        int i8 = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i8 == 1) {
            mapK = M.k(w.a("unit", "DAY"), w.a("value", Integer.valueOf(period.getValue())));
        } else if (i8 == 2) {
            mapK = M.k(w.a("unit", "DAY"), w.a("value", Integer.valueOf(period.getValue() * 7)));
        } else if (i8 == 3) {
            mapK = M.k(w.a("unit", "MONTH"), w.a("value", Integer.valueOf(period.getValue())));
        } else if (i8 == 4) {
            mapK = M.k(w.a("unit", "YEAR"), w.a("value", Integer.valueOf(period.getValue())));
        } else {
            if (i8 != 5) {
                throw new C2487o();
            }
            mapK = M.k(w.a("unit", "DAY"), w.a("value", 0));
        }
        return M.o(mapK, p5.L.e(w.a("iso8601", period.getIso8601())));
    }

    private static final Map<String, Object> mapPeriodForStoreProduct(Period period) {
        int i8 = WhenMappings.$EnumSwitchMapping$1[period.getUnit().ordinal()];
        if (i8 == 1) {
            return M.k(w.a("periodUnit", "DAY"), w.a("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i8 == 2) {
            return M.k(w.a("periodUnit", "DAY"), w.a("periodNumberOfUnits", Integer.valueOf(period.getValue() * 7)));
        }
        if (i8 == 3) {
            return M.k(w.a("periodUnit", "MONTH"), w.a("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i8 == 4) {
            return M.k(w.a("periodUnit", "YEAR"), w.a("periodNumberOfUnits", Integer.valueOf(period.getValue())));
        }
        if (i8 == 5) {
            return M.k(w.a("periodUnit", "DAY"), w.a("periodNumberOfUnits", 0));
        }
        throw new C2487o();
    }

    private static final Map<String, Object> mapPrice(Price price) {
        return M.k(w.a("formatted", price.getFormatted()), w.a("amountMicros", Long.valueOf(price.getAmountMicros())), w.a("currencyCode", price.getCurrencyCode()));
    }

    private static final Map<String, Object> mapPricingPhase(PricingPhase pricingPhase) {
        Period billingPeriod = pricingPhase.getBillingPeriod();
        C2489q c2489qA = w.a("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        C2489q c2489qA2 = w.a("recurrenceMode", pricingPhase.getRecurrenceMode().getIdentifier());
        C2489q c2489qA3 = w.a("billingCycleCount", pricingPhase.getBillingCycleCount());
        C2489q c2489qA4 = w.a("price", mapPrice(pricingPhase.getPrice()));
        OfferPaymentMode offerPaymentMode = pricingPhase.getOfferPaymentMode();
        return M.k(c2489qA, c2489qA2, c2489qA3, c2489qA4, w.a("offerPaymentMode", offerPaymentMode != null ? offerPaymentMode.toString() : null));
    }

    public static final MappedProductCategory mapProductCategory(StoreProduct storeProduct) {
        AbstractC2304t.f(storeProduct, "<this>");
        int i8 = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i8 == 1) {
            return MappedProductCategory.NON_SUBSCRIPTION;
        }
        if (i8 == 2) {
            return MappedProductCategory.SUBSCRIPTION;
        }
        if (i8 == 3) {
            return MappedProductCategory.UNKNOWN;
        }
        throw new C2487o();
    }

    public static final String mapProductType(StoreProduct storeProduct) {
        AbstractC2304t.f(storeProduct, "<this>");
        int i8 = WhenMappings.$EnumSwitchMapping$0[storeProduct.getType().ordinal()];
        if (i8 == 1) {
            return "CONSUMABLE";
        }
        if (i8 == 2) {
            SubscriptionOption defaultOption = storeProduct.getDefaultOption();
            return (defaultOption == null || !defaultOption.isPrepaid()) ? "AUTO_RENEWABLE_SUBSCRIPTION" : "PREPAID_SUBSCRIPTION";
        }
        if (i8 == 3) {
            return "UNKNOWN";
        }
        throw new C2487o();
    }

    private static final Map<String, Object> mapSubscriptionOption(SubscriptionOption subscriptionOption, StoreProduct storeProduct) {
        C2489q c2489qA = w.a(DiagnosticsEntry.ID_KEY, subscriptionOption.getId());
        C2489q c2489qA2 = w.a("storeProductId", storeProduct.getId());
        C2489q c2489qA3 = w.a("productId", storeProduct.getPurchasingData().getProductId());
        List<PricingPhase> pricingPhases = subscriptionOption.getPricingPhases();
        ArrayList arrayList = new ArrayList(r.s(pricingPhases, 10));
        Iterator<T> it = pricingPhases.iterator();
        while (it.hasNext()) {
            arrayList.add(mapPricingPhase((PricingPhase) it.next()));
        }
        C2489q c2489qA4 = w.a("pricingPhases", arrayList);
        C2489q c2489qA5 = w.a("tags", subscriptionOption.getTags());
        C2489q c2489qA6 = w.a("isBasePlan", Boolean.valueOf(subscriptionOption.isBasePlan()));
        Period billingPeriod = subscriptionOption.getBillingPeriod();
        C2489q c2489qA7 = w.a("billingPeriod", billingPeriod != null ? mapPeriod(billingPeriod) : null);
        C2489q c2489qA8 = w.a("isPrepaid", Boolean.valueOf(subscriptionOption.isPrepaid()));
        PricingPhase fullPricePhase = subscriptionOption.getFullPricePhase();
        C2489q c2489qA9 = w.a("fullPricePhase", fullPricePhase != null ? mapPricingPhase(fullPricePhase) : null);
        PricingPhase freePhase = subscriptionOption.getFreePhase();
        C2489q c2489qA10 = w.a("freePhase", freePhase != null ? mapPricingPhase(freePhase) : null);
        PricingPhase introPhase = subscriptionOption.getIntroPhase();
        C2489q c2489qA11 = w.a("introPhase", introPhase != null ? mapPricingPhase(introPhase) : null);
        PresentedOfferingContext presentedOfferingContext = subscriptionOption.getPresentedOfferingContext();
        C2489q c2489qA12 = w.a("presentedOfferingIdentifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = subscriptionOption.getPresentedOfferingContext();
        C2489q c2489qA13 = w.a("presentedOfferingContext", presentedOfferingContext2 != null ? OfferingsMapperKt.map(presentedOfferingContext2) : null);
        InstallmentsInfo installmentsInfo = subscriptionOption.getInstallmentsInfo();
        return M.k(c2489qA, c2489qA2, c2489qA3, c2489qA4, c2489qA5, c2489qA6, c2489qA7, c2489qA8, c2489qA9, c2489qA10, c2489qA11, c2489qA12, c2489qA13, w.a("installmentsInfo", installmentsInfo != null ? map(installmentsInfo) : null));
    }

    private static final Map<String, Object> map(InstallmentsInfo installmentsInfo) {
        return M.k(w.a("commitmentPaymentsCount", Integer.valueOf(installmentsInfo.getCommitmentPaymentsCount())), w.a("renewalCommitmentPaymentsCount", Integer.valueOf(installmentsInfo.getRenewalCommitmentPaymentsCount())));
    }

    public static final Map<String, Object> map(StoreProduct storeProduct) {
        C2489q c2489q;
        String iso8601;
        C2489q c2489q2;
        Map<String, Object> mapMapSubscriptionOption;
        C2489q c2489q3;
        C2489q c2489q4;
        ArrayList arrayList;
        AbstractC2304t.f(storeProduct, "<this>");
        C2489q c2489qA = w.a("identifier", storeProduct.getId());
        C2489q c2489qA2 = w.a(b.f14051c, storeProduct.getDescription());
        C2489q c2489qA3 = w.a(b.f14041S, storeProduct.getTitle());
        C2489q c2489qA4 = w.a("price", Double.valueOf(getPriceAmountMicros(storeProduct) / 1000000.0d));
        C2489q c2489qA5 = w.a("priceString", getPriceString(storeProduct));
        C2489q c2489qA6 = w.a("currencyCode", getPriceCurrencyCode(storeProduct));
        C2489q c2489qA7 = w.a("introPrice", mapIntroPrice(storeProduct));
        C2489q c2489qA8 = w.a("discounts", null);
        Price pricePricePerWeek$default = StoreProduct.pricePerWeek$default(storeProduct, null, 1, null);
        C2489q c2489qA9 = w.a("pricePerWeek", pricePricePerWeek$default != null ? Long.valueOf(pricePricePerWeek$default.getAmountMicros()) : null);
        Price pricePricePerMonth$default = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
        C2489q c2489qA10 = w.a("pricePerMonth", pricePricePerMonth$default != null ? Long.valueOf(pricePricePerMonth$default.getAmountMicros()) : null);
        Price pricePricePerYear$default = StoreProduct.pricePerYear$default(storeProduct, null, 1, null);
        C2489q c2489qA11 = w.a("pricePerYear", pricePricePerYear$default != null ? Long.valueOf(pricePricePerYear$default.getAmountMicros()) : null);
        Price pricePricePerWeek$default2 = StoreProduct.pricePerWeek$default(storeProduct, null, 1, null);
        C2489q c2489qA12 = w.a("pricePerWeekString", pricePricePerWeek$default2 != null ? pricePricePerWeek$default2.getFormatted() : null);
        Price pricePricePerMonth$default2 = StoreProduct.pricePerMonth$default(storeProduct, null, 1, null);
        C2489q c2489qA13 = w.a("pricePerMonthString", pricePricePerMonth$default2 != null ? pricePricePerMonth$default2.getFormatted() : null);
        Price pricePricePerYear$default2 = StoreProduct.pricePerYear$default(storeProduct, null, 1, null);
        C2489q c2489qA14 = w.a("pricePerYearString", pricePricePerYear$default2 != null ? pricePricePerYear$default2.getFormatted() : null);
        C2489q c2489qA15 = w.a("productCategory", mapProductCategory(storeProduct).getValue());
        C2489q c2489qA16 = w.a("productType", mapProductType(storeProduct));
        Period period = storeProduct.getPeriod();
        if (period != null) {
            iso8601 = period.getIso8601();
            c2489q = c2489qA16;
        } else {
            c2489q = c2489qA16;
            iso8601 = null;
        }
        C2489q c2489qA17 = w.a(b.f14063o, iso8601);
        SubscriptionOption defaultOption = storeProduct.getDefaultOption();
        if (defaultOption != null) {
            mapMapSubscriptionOption = mapSubscriptionOption(defaultOption, storeProduct);
            c2489q2 = c2489qA17;
        } else {
            c2489q2 = c2489qA17;
            mapMapSubscriptionOption = null;
        }
        C2489q c2489qA18 = w.a("defaultOption", mapMapSubscriptionOption);
        SubscriptionOptions subscriptionOptions = storeProduct.getSubscriptionOptions();
        if (subscriptionOptions != null) {
            c2489q4 = c2489qA18;
            c2489q3 = c2489qA14;
            arrayList = new ArrayList(r.s(subscriptionOptions, 10));
            Iterator<SubscriptionOption> it = subscriptionOptions.iterator();
            while (it.hasNext()) {
                arrayList.add(mapSubscriptionOption(it.next(), storeProduct));
            }
        } else {
            c2489q3 = c2489qA14;
            c2489q4 = c2489qA18;
            arrayList = null;
        }
        C2489q c2489qA19 = w.a("subscriptionOptions", arrayList);
        PresentedOfferingContext presentedOfferingContext = storeProduct.getPresentedOfferingContext();
        C2489q c2489qA20 = w.a("presentedOfferingIdentifier", presentedOfferingContext != null ? presentedOfferingContext.getOfferingIdentifier() : null);
        PresentedOfferingContext presentedOfferingContext2 = storeProduct.getPresentedOfferingContext();
        return M.k(c2489qA, c2489qA2, c2489qA3, c2489qA4, c2489qA5, c2489qA6, c2489qA7, c2489qA8, c2489qA9, c2489qA10, c2489qA11, c2489qA12, c2489qA13, c2489q3, c2489qA15, c2489q, c2489q2, c2489q4, c2489qA19, c2489qA20, w.a("presentedOfferingContext", presentedOfferingContext2 != null ? OfferingsMapperKt.map(presentedOfferingContext2) : null));
    }
}
