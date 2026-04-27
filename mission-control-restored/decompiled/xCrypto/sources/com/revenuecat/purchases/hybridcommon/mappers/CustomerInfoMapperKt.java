package com.revenuecat.purchases.hybridcommon.mappers;

import W2.E;
import W2.q;
import W2.t;
import X2.AbstractC0770q;
import X2.K;
import X2.x;
import Z2.e;
import a3.AbstractC0787c;
import android.net.Uri;
import b3.InterfaceC0868f;
import b3.l;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.SubscriptionInfo;
import com.revenuecat.purchases.common.responses.CustomerInfoResponseJsonKeys;
import com.revenuecat.purchases.models.Transaction;
import i3.k;
import i3.o;
import io.flutter.Build;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import t3.AbstractC1818i;
import t3.AbstractC1822k;
import t3.I;
import t3.L;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomerInfoMapperKt {

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt$mapAsync$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt$mapAsync$1", f = "CustomerInfoMapper.kt", l = {Build.API_LEVELS.API_35}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        final /* synthetic */ k $callback;
        final /* synthetic */ CustomerInfo $this_mapAsync;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(k kVar, CustomerInfo customerInfo, e eVar) {
            super(2, eVar);
            this.$callback = kVar;
            this.$this_mapAsync = customerInfo;
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
                CustomerInfoMapperKt$mapAsync$1$map$1 customerInfoMapperKt$mapAsync$1$map$1 = new CustomerInfoMapperKt$mapAsync$1$map$1(this.$this_mapAsync, null);
                this.label = 1;
                obj = AbstractC1818i.g(mapperDispatcher, customerInfoMapperKt$mapAsync$1$map$1, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            this.$callback.invoke((Map) obj);
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass1) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map<String, Object> map(CustomerInfo customerInfo) {
        W2.o oVarA = t.a(CustomerInfoResponseJsonKeys.ENTITLEMENTS, EntitlementInfosMapperKt.map(customerInfo.getEntitlements()));
        W2.o oVarA2 = t.a("activeSubscriptions", x.g0(customerInfo.getActiveSubscriptions()));
        W2.o oVarA3 = t.a("allPurchasedProductIdentifiers", x.g0(customerInfo.getAllPurchasedProductIds()));
        Date latestExpirationDate = customerInfo.getLatestExpirationDate();
        W2.o oVarA4 = t.a("latestExpirationDate", latestExpirationDate != null ? MappersHelpersKt.toIso8601(latestExpirationDate) : null);
        Date latestExpirationDate2 = customerInfo.getLatestExpirationDate();
        W2.o oVarA5 = t.a("latestExpirationDateMillis", latestExpirationDate2 != null ? Long.valueOf(MappersHelpersKt.toMillis(latestExpirationDate2)) : null);
        W2.o oVarA6 = t.a("firstSeen", MappersHelpersKt.toIso8601(customerInfo.getFirstSeen()));
        W2.o oVarA7 = t.a("firstSeenMillis", Long.valueOf(MappersHelpersKt.toMillis(customerInfo.getFirstSeen())));
        W2.o oVarA8 = t.a("originalAppUserId", customerInfo.getOriginalAppUserId());
        W2.o oVarA9 = t.a("requestDate", MappersHelpersKt.toIso8601(customerInfo.getRequestDate()));
        W2.o oVarA10 = t.a("requestDateMillis", Long.valueOf(MappersHelpersKt.toMillis(customerInfo.getRequestDate())));
        Map<String, Date> allExpirationDatesByProduct = customerInfo.getAllExpirationDatesByProduct();
        LinkedHashMap linkedHashMap = new LinkedHashMap(K.b(allExpirationDatesByProduct.size()));
        Iterator<T> it = allExpirationDatesByProduct.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Date date = (Date) entry.getValue();
            linkedHashMap.put(key, date != null ? MappersHelpersKt.toIso8601(date) : null);
        }
        W2.o oVarA11 = t.a("allExpirationDates", linkedHashMap);
        Map<String, Date> allExpirationDatesByProduct2 = customerInfo.getAllExpirationDatesByProduct();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(K.b(allExpirationDatesByProduct2.size()));
        Iterator<T> it2 = allExpirationDatesByProduct2.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it2.next();
            Object key2 = entry2.getKey();
            Date date2 = (Date) entry2.getValue();
            linkedHashMap2.put(key2, date2 != null ? Long.valueOf(MappersHelpersKt.toMillis(date2)) : null);
        }
        W2.o oVarA12 = t.a("allExpirationDatesMillis", linkedHashMap2);
        Map<String, Date> allPurchaseDatesByProduct = customerInfo.getAllPurchaseDatesByProduct();
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(K.b(allPurchaseDatesByProduct.size()));
        Iterator<T> it3 = allPurchaseDatesByProduct.entrySet().iterator();
        while (it3.hasNext()) {
            Map.Entry entry3 = (Map.Entry) it3.next();
            Object key3 = entry3.getKey();
            Date date3 = (Date) entry3.getValue();
            linkedHashMap3.put(key3, date3 != null ? MappersHelpersKt.toIso8601(date3) : null);
        }
        W2.o oVarA13 = t.a("allPurchaseDates", linkedHashMap3);
        Map<String, Date> allPurchaseDatesByProduct2 = customerInfo.getAllPurchaseDatesByProduct();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap(K.b(allPurchaseDatesByProduct2.size()));
        Iterator it4 = allPurchaseDatesByProduct2.entrySet().iterator();
        while (it4.hasNext()) {
            Map.Entry entry4 = (Map.Entry) it4.next();
            Iterator it5 = it4;
            Object key4 = entry4.getKey();
            Date date4 = (Date) entry4.getValue();
            linkedHashMap4.put(key4, date4 != null ? Long.valueOf(MappersHelpersKt.toMillis(date4)) : null);
            it4 = it5;
        }
        W2.o oVarA14 = t.a("allPurchaseDatesMillis", linkedHashMap4);
        W2.o oVarA15 = t.a("originalApplicationVersion", null);
        Uri managementURL = customerInfo.getManagementURL();
        W2.o oVarA16 = t.a("managementURL", managementURL != null ? managementURL.toString() : null);
        Date originalPurchaseDate = customerInfo.getOriginalPurchaseDate();
        W2.o oVarA17 = t.a("originalPurchaseDate", originalPurchaseDate != null ? MappersHelpersKt.toIso8601(originalPurchaseDate) : null);
        Date originalPurchaseDate2 = customerInfo.getOriginalPurchaseDate();
        W2.o oVarA18 = t.a("originalPurchaseDateMillis", originalPurchaseDate2 != null ? Long.valueOf(MappersHelpersKt.toMillis(originalPurchaseDate2)) : null);
        List<Transaction> nonSubscriptionTransactions = customerInfo.getNonSubscriptionTransactions();
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(nonSubscriptionTransactions, 10));
        Iterator<T> it6 = nonSubscriptionTransactions.iterator();
        while (it6.hasNext()) {
            arrayList.add(TransactionMapperKt.map((Transaction) it6.next()));
        }
        W2.o oVarA19 = t.a("nonSubscriptionTransactions", arrayList);
        Map<String, SubscriptionInfo> subscriptionsByProductIdentifier = customerInfo.getSubscriptionsByProductIdentifier();
        LinkedHashMap linkedHashMap5 = new LinkedHashMap(K.b(subscriptionsByProductIdentifier.size()));
        for (Iterator it7 = subscriptionsByProductIdentifier.entrySet().iterator(); it7.hasNext(); it7 = it7) {
            Map.Entry entry5 = (Map.Entry) it7.next();
            linkedHashMap5.put(entry5.getKey(), SubscriptionInfoMapperKt.map((SubscriptionInfo) entry5.getValue()));
        }
        return X2.L.g(oVarA, oVarA2, oVarA3, oVarA4, oVarA5, oVarA6, oVarA7, oVarA8, oVarA9, oVarA10, oVarA11, oVarA12, oVarA13, oVarA14, oVarA15, oVarA16, oVarA17, oVarA18, oVarA19, t.a("subscriptionsByProductIdentifier", linkedHashMap5));
    }

    public static final void mapAsync(CustomerInfo customerInfo, k callback) {
        r.f(customerInfo, "<this>");
        r.f(callback, "callback");
        AbstractC1822k.d(MappersHelpersKt.getMainScope(), null, null, new AnonymousClass1(callback, customerInfo, null), 3, null);
    }
}
