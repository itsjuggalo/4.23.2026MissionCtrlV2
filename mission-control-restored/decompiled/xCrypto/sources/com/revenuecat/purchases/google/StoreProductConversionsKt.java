package com.revenuecat.purchases.google;

import X2.AbstractC0769p;
import X2.AbstractC0770q;
import X2.L;
import com.android.billingclient.api.f;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.PresentedOfferingContext;
import com.revenuecat.purchases.ProductType;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.models.GoogleStoreProduct;
import com.revenuecat.purchases.models.Price;
import com.revenuecat.purchases.models.PricingPhase;
import com.revenuecat.purchases.models.StoreProduct;
import com.revenuecat.purchases.models.SubscriptionOption;
import com.revenuecat.purchases.models.SubscriptionOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class StoreProductConversionsKt {
    private static final Price createOneTimeProductPrice(com.android.billingclient.api.f fVar) {
        f.b bVarC;
        if (ProductTypeConversionsKt.toRevenueCatProductType(fVar.e()) != ProductType.INAPP || (bVarC = fVar.c()) == null) {
            return null;
        }
        String strA = bVarC.a();
        r.e(strA, "it.formattedPrice");
        long jB = bVarC.b();
        String strC = bVarC.c();
        r.e(strC, "it.priceCurrencyCode");
        return new Price(strA, jB, strC);
    }

    public static final StoreProduct toInAppStoreProduct(com.android.billingclient.api.f fVar) {
        r.f(fVar, "<this>");
        return toStoreProduct(fVar, AbstractC0769p.g());
    }

    public static final GoogleStoreProduct toStoreProduct(com.android.billingclient.api.f fVar, List<f.e> offerDetails) {
        SubscriptionOptions subscriptionOptions;
        PricingPhase fullPricePhase;
        r.f(fVar, "<this>");
        r.f(offerDetails, "offerDetails");
        if (ProductTypeConversionsKt.toRevenueCatProductType(fVar.e()) == ProductType.SUBS) {
            ArrayList arrayList = new ArrayList(AbstractC0770q.q(offerDetails, 10));
            for (f.e eVar : offerDetails) {
                String productId = fVar.d();
                r.e(productId, "productId");
                arrayList.add(SubscriptionOptionConversionsKt.toSubscriptionOption(eVar, productId, fVar));
            }
            subscriptionOptions = new SubscriptionOptions(arrayList);
        } else {
            subscriptionOptions = null;
        }
        SubscriptionOption basePlan = subscriptionOptions != null ? subscriptionOptions.getBasePlan() : null;
        Price price = (basePlan == null || (fullPricePhase = basePlan.getFullPricePhase()) == null) ? null : fullPricePhase.getPrice();
        Price priceCreateOneTimeProductPrice = createOneTimeProductPrice(fVar);
        if (priceCreateOneTimeProductPrice != null) {
            price = priceCreateOneTimeProductPrice;
        } else if (price == null) {
            return null;
        }
        SubscriptionOption subscriptionOption = basePlan;
        Price price2 = price;
        String productId2 = fVar.d();
        r.e(productId2, "productId");
        String id = subscriptionOption != null ? subscriptionOption.getId() : null;
        ProductType revenueCatProductType = ProductTypeConversionsKt.toRevenueCatProductType(fVar.e());
        String name = fVar.b();
        r.e(name, "name");
        String str = id;
        String title = fVar.g();
        r.e(title, "title");
        String description = fVar.a();
        r.e(description, "description");
        return new GoogleStoreProduct(productId2, str, revenueCatProductType, price2, name, title, description, subscriptionOption != null ? subscriptionOption.getBillingPeriod() : null, subscriptionOptions, subscriptionOptions != null ? subscriptionOptions.getDefaultOffer() : null, fVar, (PresentedOfferingContext) null);
    }

    public static final List<StoreProduct> toStoreProducts(List<com.android.billingclient.api.f> list) {
        List listG;
        Map mapE;
        LogHandler currentLogHandler;
        String str;
        Object objInvoke;
        r.f(list, "<this>");
        ArrayList arrayList = new ArrayList();
        for (com.android.billingclient.api.f fVar : list) {
            List subscriptionOfferDetails = fVar.f();
            if (subscriptionOfferDetails != null) {
                r.e(subscriptionOfferDetails, "subscriptionOfferDetails");
                listG = new ArrayList();
                for (Object obj : subscriptionOfferDetails) {
                    f.e it = (f.e) obj;
                    r.e(it, "it");
                    if (SubscriptionOptionConversionsKt.isBasePlan(it)) {
                        listG.add(obj);
                    }
                }
            } else {
                listG = AbstractC0769p.g();
            }
            List subscriptionOfferDetails2 = fVar.f();
            if (subscriptionOfferDetails2 != null) {
                r.e(subscriptionOfferDetails2, "subscriptionOfferDetails");
                mapE = new LinkedHashMap();
                for (Object obj2 : subscriptionOfferDetails2) {
                    String strA = ((f.e) obj2).a();
                    Object arrayList2 = mapE.get(strA);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        mapE.put(strA, arrayList2);
                    }
                    ((List) arrayList2).add(obj2);
                }
            } else {
                mapE = L.e();
            }
            if (listG.isEmpty()) {
                listG = null;
            }
            if (listG == null) {
                StoreProduct inAppStoreProduct = toInAppStoreProduct(fVar);
                if (inAppStoreProduct == null) {
                    LogIntent logIntent = LogIntent.RC_ERROR;
                    StoreProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1 storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1 = new StoreProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1(logIntent, fVar);
                    switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                        case 1:
                            LogLevel logLevel = LogLevel.DEBUG;
                            LogHandler currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                                currentLogHandler2.d("[Purchases] - " + logLevel.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 2:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke(), null);
                            break;
                        case 3:
                            LogLevel logLevel2 = LogLevel.WARN;
                            LogHandler currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                                currentLogHandler3.w("[Purchases] - " + logLevel2.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 4:
                            LogLevel logLevel3 = LogLevel.INFO;
                            LogHandler currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                                currentLogHandler4.i("[Purchases] - " + logLevel3.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 5:
                            LogLevel logLevel4 = LogLevel.DEBUG;
                            LogHandler currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                                currentLogHandler5.d("[Purchases] - " + logLevel4.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 6:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke(), null);
                            break;
                        case 7:
                            LogLevel logLevel5 = LogLevel.INFO;
                            LogHandler currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                                currentLogHandler6.i("[Purchases] - " + logLevel5.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 8:
                            LogLevel logLevel6 = LogLevel.DEBUG;
                            LogHandler currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                                currentLogHandler7.d("[Purchases] - " + logLevel6.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 9:
                            LogLevel logLevel7 = LogLevel.DEBUG;
                            LogHandler currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                                currentLogHandler8.d("[Purchases] - " + logLevel7.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 10:
                            LogLevel logLevel8 = LogLevel.WARN;
                            LogHandler currentLogHandler9 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                                currentLogHandler9.w("[Purchases] - " + logLevel8.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 11:
                            LogLevel logLevel9 = LogLevel.WARN;
                            LogHandler currentLogHandler10 = LogWrapperKt.getCurrentLogHandler();
                            if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                                currentLogHandler10.w("[Purchases] - " + logLevel9.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke());
                            }
                            break;
                        case 12:
                            LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) storeProductConversionsKt$toStoreProducts$lambda$10$$inlined$log$1.invoke(), null);
                            break;
                    }
                } else {
                    arrayList.add(inAppStoreProduct);
                }
            } else {
                Iterator it2 = listG.iterator();
                while (it2.hasNext()) {
                    List listG2 = (List) mapE.get(((f.e) it2.next()).a());
                    if (listG2 == null) {
                        listG2 = AbstractC0769p.g();
                    }
                    GoogleStoreProduct storeProduct = toStoreProduct(fVar, listG2);
                    if (storeProduct == null) {
                        LogIntent logIntent2 = LogIntent.RC_ERROR;
                        StoreProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1 storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1 = new StoreProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1(logIntent2, fVar);
                        switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                            case 1:
                                LogLevel logLevel10 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                                    str = "[Purchases] - " + logLevel10.name();
                                    objInvoke = storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke();
                                    currentLogHandler.d(str, (String) objInvoke);
                                }
                                break;
                            case 2:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke(), null);
                                break;
                            case 3:
                                LogLevel logLevel11 = LogLevel.WARN;
                                LogHandler currentLogHandler11 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                                    currentLogHandler11.w("[Purchases] - " + logLevel11.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 4:
                                LogLevel logLevel12 = LogLevel.INFO;
                                LogHandler currentLogHandler12 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                                    currentLogHandler12.i("[Purchases] - " + logLevel12.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 5:
                                LogLevel logLevel13 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                                    str = "[Purchases] - " + logLevel13.name();
                                    objInvoke = storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke();
                                    currentLogHandler.d(str, (String) objInvoke);
                                }
                                break;
                            case 6:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke(), null);
                                break;
                            case 7:
                                LogLevel logLevel14 = LogLevel.INFO;
                                LogHandler currentLogHandler13 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                                    currentLogHandler13.i("[Purchases] - " + logLevel14.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 8:
                                LogLevel logLevel15 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                                    str = "[Purchases] - " + logLevel15.name();
                                    objInvoke = storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke();
                                    currentLogHandler.d(str, (String) objInvoke);
                                }
                                break;
                            case 9:
                                LogLevel logLevel16 = LogLevel.DEBUG;
                                currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                                    str = "[Purchases] - " + logLevel16.name();
                                    objInvoke = storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke();
                                    currentLogHandler.d(str, (String) objInvoke);
                                }
                                break;
                            case 10:
                                LogLevel logLevel17 = LogLevel.WARN;
                                LogHandler currentLogHandler14 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                                    currentLogHandler14.w("[Purchases] - " + logLevel17.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 11:
                                LogLevel logLevel18 = LogLevel.WARN;
                                LogHandler currentLogHandler15 = LogWrapperKt.getCurrentLogHandler();
                                if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                                    currentLogHandler15.w("[Purchases] - " + logLevel18.name(), (String) storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke());
                                }
                                break;
                            case 12:
                                LogWrapperKt.getCurrentLogHandler().e("[Purchases] - ERROR", (String) storeProductConversionsKt$toStoreProducts$lambda$10$lambda$7$$inlined$log$1.invoke(), null);
                                break;
                        }
                    } else {
                        arrayList.add(storeProduct);
                    }
                }
            }
        }
        return arrayList;
    }
}
