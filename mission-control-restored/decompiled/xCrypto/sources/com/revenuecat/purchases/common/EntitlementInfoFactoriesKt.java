package com.revenuecat.purchases.common;

import com.revenuecat.purchases.EntitlementInfo;
import com.revenuecat.purchases.EntitlementInfos;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.OwnershipType;
import com.revenuecat.purchases.PeriodType;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.responses.EntitlementsResponseJsonKeys;
import com.revenuecat.purchases.common.responses.ProductResponseJsonKeys;
import com.revenuecat.purchases.strings.PurchaseStrings;
import com.revenuecat.purchases.utils.DateActive;
import com.revenuecat.purchases.utils.DateHelper;
import com.revenuecat.purchases.utils.EntitlementInfoHelper;
import com.revenuecat.purchases.utils.JSONObjectExtensionsKt;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class EntitlementInfoFactoriesKt {
    public static final EntitlementInfo buildEntitlementInfo(JSONObject jSONObject, String identifier, JSONObject productData, Date requestDate, VerificationResult verificationResult) throws JSONException {
        r.f(jSONObject, "<this>");
        r.f(identifier, "identifier");
        r.f(productData, "productData");
        r.f(requestDate, "requestDate");
        r.f(verificationResult, "verificationResult");
        Date dateOptDate = JSONObjectExtensionsKt.optDate(jSONObject, "expires_date");
        Date dateOptDate2 = JSONObjectExtensionsKt.optDate(productData, ProductResponseJsonKeys.UNSUBSCRIBE_DETECTED_AT);
        Date dateOptDate3 = JSONObjectExtensionsKt.optDate(productData, ProductResponseJsonKeys.BILLING_ISSUES_DETECTED_AT);
        PeriodType periodTypeOptPeriodType = optPeriodType(productData, ProductResponseJsonKeys.PERIOD_TYPE);
        Store store = getStore(productData, ProductResponseJsonKeys.STORE);
        boolean zIsDateActive = isDateActive(identifier, dateOptDate, requestDate);
        boolean willRenew = EntitlementInfoHelper.INSTANCE.getWillRenew(store, dateOptDate, dateOptDate2, dateOptDate3, periodTypeOptPeriodType);
        Date date = JSONObjectExtensionsKt.getDate(jSONObject, "purchase_date");
        Date date2 = JSONObjectExtensionsKt.getDate(productData, "original_purchase_date");
        String string = jSONObject.getString(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER);
        r.e(string, "getString(EntitlementsRe…nKeys.PRODUCT_IDENTIFIER)");
        return new EntitlementInfo(identifier, zIsDateActive, willRenew, periodTypeOptPeriodType, date, date2, dateOptDate, store, string, JSONObjectExtensionsKt.optNullableString(jSONObject, "product_plan_identifier"), productData.getBoolean(ProductResponseJsonKeys.IS_SANDBOX), dateOptDate2, dateOptDate3, optOwnershipType(productData, ProductResponseJsonKeys.OWNERSHIP_TYPE), jSONObject, verificationResult);
    }

    public static final EntitlementInfos buildEntitlementInfos(JSONObject jSONObject, JSONObject subscriptions, JSONObject nonSubscriptionsLatestPurchases, Date requestDate, VerificationResult verificationResult) {
        r.f(jSONObject, "<this>");
        r.f(subscriptions, "subscriptions");
        r.f(nonSubscriptionsLatestPurchases, "nonSubscriptionsLatestPurchases");
        r.f(requestDate, "requestDate");
        r.f(verificationResult, "verificationResult");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        r.e(itKeys, "keys()");
        while (itKeys.hasNext()) {
            String entitlementId = itKeys.next();
            JSONObject entitlement = jSONObject.getJSONObject(entitlementId);
            String it = entitlement.optString(EntitlementsResponseJsonKeys.PRODUCT_IDENTIFIER);
            r.e(it, "it");
            if (it.length() <= 0) {
                it = null;
            }
            if (it != null) {
                if (subscriptions.has(it)) {
                    r.e(entitlementId, "entitlementId");
                    r.e(entitlement, "entitlement");
                    JSONObject jSONObject2 = subscriptions.getJSONObject(it);
                    r.e(jSONObject2, "subscriptions.getJSONObject(productIdentifier)");
                    linkedHashMap.put(entitlementId, buildEntitlementInfo(entitlement, entitlementId, jSONObject2, requestDate, verificationResult));
                } else if (nonSubscriptionsLatestPurchases.has(it)) {
                    r.e(entitlementId, "entitlementId");
                    r.e(entitlement, "entitlement");
                    JSONObject jSONObject3 = nonSubscriptionsLatestPurchases.getJSONObject(it);
                    r.e(jSONObject3, "nonSubscriptionsLatestPu…Object(productIdentifier)");
                    linkedHashMap.put(entitlementId, buildEntitlementInfo(entitlement, entitlementId, jSONObject3, requestDate, verificationResult));
                }
            }
        }
        return new EntitlementInfos(linkedHashMap, verificationResult);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final Store getStore(JSONObject jSONObject, String name) throws JSONException {
        r.f(jSONObject, "<this>");
        r.f(name, "name");
        String string = jSONObject.getString(name);
        if (string != null) {
            switch (string.hashCode()) {
                case -1820761141:
                    if (string.equals("external")) {
                        return Store.EXTERNAL;
                    }
                    break;
                case -1523640723:
                    if (string.equals("rc_billing")) {
                        return Store.RC_BILLING;
                    }
                    break;
                case -1414265340:
                    if (string.equals("amazon")) {
                        return Store.AMAZON;
                    }
                    break;
                case -995842198:
                    if (string.equals("paddle")) {
                        return Store.PADDLE;
                    }
                    break;
                case -891985843:
                    if (string.equals("stripe")) {
                        return Store.STRIPE;
                    }
                    break;
                case 564036179:
                    if (string.equals("mac_app_store")) {
                        return Store.MAC_APP_STORE;
                    }
                    break;
                case 756050958:
                    if (string.equals("promotional")) {
                        return Store.PROMOTIONAL;
                    }
                    break;
                case 1842542915:
                    if (string.equals("app_store")) {
                        return Store.APP_STORE;
                    }
                    break;
                case 1925951510:
                    if (string.equals("play_store")) {
                        return Store.PLAY_STORE;
                    }
                    break;
            }
        }
        return Store.UNKNOWN_STORE;
    }

    private static final boolean isDateActive(String str, Date date, Date date2) {
        DateActive dateActiveM215isDateActiveSxA4cEA$default = DateHelper.Companion.m215isDateActiveSxA4cEA$default(DateHelper.Companion, date, date2, 0L, 4, null);
        if (!dateActiveM215isDateActiveSxA4cEA$default.isActive() && !dateActiveM215isDateActiveSxA4cEA$default.getInGracePeriod()) {
            LogLevel logLevel = LogLevel.WARN;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                String str2 = "[Purchases] - " + logLevel.name();
                String str3 = String.format(PurchaseStrings.ENTITLEMENT_EXPIRED_OUTSIDE_GRACE_PERIOD, Arrays.copyOf(new Object[]{str, date, date2}, 3));
                r.e(str3, "format(this, *args)");
                currentLogHandler.w(str2, str3);
            }
        }
        return dateActiveM215isDateActiveSxA4cEA$default.isActive();
    }

    public static final OwnershipType optOwnershipType(JSONObject jSONObject, String name) {
        r.f(jSONObject, "<this>");
        r.f(name, "name");
        String strOptString = jSONObject.optString(name);
        return r.b(strOptString, "PURCHASED") ? OwnershipType.PURCHASED : r.b(strOptString, "FAMILY_SHARED") ? OwnershipType.FAMILY_SHARED : OwnershipType.UNKNOWN;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static final PeriodType optPeriodType(JSONObject jSONObject, String name) {
        r.f(jSONObject, "<this>");
        r.f(name, "name");
        String strOptString = jSONObject.optString(name);
        if (strOptString != null) {
            switch (strOptString.hashCode()) {
                case -1039745817:
                    if (strOptString.equals("normal")) {
                        return PeriodType.NORMAL;
                    }
                    break;
                case -318370833:
                    if (strOptString.equals("prepaid")) {
                        return PeriodType.PREPAID;
                    }
                    break;
                case 100361836:
                    if (strOptString.equals("intro")) {
                        return PeriodType.INTRO;
                    }
                    break;
                case 110628630:
                    if (strOptString.equals("trial")) {
                        return PeriodType.TRIAL;
                    }
                    break;
            }
        }
        return PeriodType.NORMAL;
    }
}
