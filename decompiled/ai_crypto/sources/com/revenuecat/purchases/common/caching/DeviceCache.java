package com.revenuecat.purchases.common.caching;

import E5.j;
import E5.k;
import F5.J;
import F5.O;
import F5.v;
import Z5.t;
import android.content.SharedPreferences;
import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogUtilsKt;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.strings.ReceiptStrings;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class DeviceCache implements StorefrontProvider {
    private static final String CUSTOMER_INFO_REQUEST_DATE_KEY = "customer_info_request_date";
    private static final String CUSTOMER_INFO_SCHEMA_VERSION_KEY = "schema_version";
    private static final String CUSTOMER_INFO_VERIFICATION_RESULT_KEY = "verification_result";
    public static final Companion Companion = new Companion(null);
    private final String apiKey;
    private final j apiKeyPrefix$delegate;
    private final j appUserIDCacheKey$delegate;
    private final String attributionCacheKey;
    private final j customerInfoCachesLastUpdatedCacheBaseKey$delegate;
    private final DateProvider dateProvider;
    private final j legacyAppUserIDCacheKey$delegate;
    private final j offeringsResponseCacheKey$delegate;
    private final SharedPreferences preferences;
    private final j productEntitlementMappingCacheKey$delegate;
    private final j productEntitlementMappingLastUpdatedCacheKey$delegate;
    private final j storefrontCacheKey$delegate;
    private final j tokensCacheKey$delegate;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC2148j abstractC2148j) {
            this();
        }

        private Companion() {
        }
    }

    public DeviceCache(SharedPreferences preferences, String apiKey, DateProvider dateProvider) {
        r.f(preferences, "preferences");
        r.f(apiKey, "apiKey");
        r.f(dateProvider, "dateProvider");
        this.preferences = preferences;
        this.apiKey = apiKey;
        this.dateProvider = dateProvider;
        this.apiKeyPrefix$delegate = k.b(new DeviceCache$apiKeyPrefix$2(this));
        this.legacyAppUserIDCacheKey$delegate = k.b(new DeviceCache$legacyAppUserIDCacheKey$2(this));
        this.appUserIDCacheKey$delegate = k.b(new DeviceCache$appUserIDCacheKey$2(this));
        this.attributionCacheKey = "com.revenuecat.purchases..attribution";
        this.tokensCacheKey$delegate = k.b(new DeviceCache$tokensCacheKey$2(this));
        this.storefrontCacheKey$delegate = k.b(DeviceCache$storefrontCacheKey$2.INSTANCE);
        this.productEntitlementMappingCacheKey$delegate = k.b(new DeviceCache$productEntitlementMappingCacheKey$2(this));
        this.productEntitlementMappingLastUpdatedCacheKey$delegate = k.b(new DeviceCache$productEntitlementMappingLastUpdatedCacheKey$2(this));
        this.customerInfoCachesLastUpdatedCacheBaseKey$delegate = k.b(new DeviceCache$customerInfoCachesLastUpdatedCacheBaseKey$2(this));
        this.offeringsResponseCacheKey$delegate = k.b(new DeviceCache$offeringsResponseCacheKey$2(this));
    }

    private final SharedPreferences.Editor clearAppUserID(SharedPreferences.Editor editor) {
        editor.remove(getAppUserIDCacheKey());
        editor.remove(getLegacyAppUserIDCacheKey());
        return editor;
    }

    private final SharedPreferences.Editor clearCustomerInfo(SharedPreferences.Editor editor) {
        String cachedAppUserID = getCachedAppUserID();
        if (cachedAppUserID != null) {
            editor.remove(customerInfoCacheKey(cachedAppUserID));
        }
        String legacyCachedAppUserID = getLegacyCachedAppUserID();
        if (legacyCachedAppUserID != null) {
            editor.remove(customerInfoCacheKey(legacyCachedAppUserID));
        }
        return editor;
    }

    private final SharedPreferences.Editor clearCustomerInfoCacheTimestamp(SharedPreferences.Editor editor, String str) {
        editor.remove(customerInfoLastUpdatedCacheKey(str));
        return editor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getApiKeyPrefix() {
        return (String) this.apiKeyPrefix$delegate.getValue();
    }

    private final synchronized Date getCustomerInfoCachesLastUpdated(String str) {
        return new Date(this.preferences.getLong(customerInfoLastUpdatedCacheKey(str), 0L));
    }

    private final String getCustomerInfoCachesLastUpdatedCacheBaseKey() {
        return (String) this.customerInfoCachesLastUpdatedCacheBaseKey$delegate.getValue();
    }

    private final String getOfferingsResponseCacheKey() {
        return (String) this.offeringsResponseCacheKey$delegate.getValue();
    }

    private final String getProductEntitlementMappingCacheKey() {
        return (String) this.productEntitlementMappingCacheKey$delegate.getValue();
    }

    private final Date getProductEntitlementMappingLastUpdated() {
        if (this.preferences.contains(getProductEntitlementMappingLastUpdatedCacheKey())) {
            return new Date(this.preferences.getLong(getProductEntitlementMappingLastUpdatedCacheKey(), -1L));
        }
        return null;
    }

    private final String getProductEntitlementMappingLastUpdatedCacheKey() {
        return (String) this.productEntitlementMappingLastUpdatedCacheKey$delegate.getValue();
    }

    private final void setProductEntitlementMappingCacheTimestamp(Date date) {
        this.preferences.edit().putLong(getProductEntitlementMappingLastUpdatedCacheKey(), date.getTime()).apply();
    }

    private final synchronized void setSavedTokenHashes(Set<String> set) {
        LogIntent logIntent = LogIntent.DEBUG;
        String str = String.format(ReceiptStrings.SAVING_TOKENS, Arrays.copyOf(new Object[]{set}, 1));
        r.e(str, "format(this, *args)");
        LogWrapperKt.log(logIntent, str);
        this.preferences.edit().putStringSet(getTokensCacheKey(), set).apply();
    }

    public final synchronized void addSuccessfullyPostedToken(String token) {
        r.f(token, "token");
        LogIntent logIntent = LogIntent.DEBUG;
        String str = String.format(ReceiptStrings.SAVING_TOKENS_WITH_HASH, Arrays.copyOf(new Object[]{token, UtilsKt.sha1(token)}, 2));
        r.e(str, "format(this, *args)");
        LogWrapperKt.log(logIntent, str);
        Set<String> previouslySentHashedTokens = getPreviouslySentHashedTokens();
        String str2 = String.format(ReceiptStrings.TOKENS_IN_CACHE, Arrays.copyOf(new Object[]{previouslySentHashedTokens}, 1));
        r.e(str2, "format(this, *args)");
        LogWrapperKt.log(logIntent, str2);
        Set<String> setL0 = v.l0(previouslySentHashedTokens);
        setL0.add(UtilsKt.sha1(token));
        setSavedTokenHashes(setL0);
    }

    public final synchronized void cacheAppUserID(String appUserID) {
        r.f(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        r.e(editorEdit, "preferences.edit()");
        cacheAppUserID(appUserID, editorEdit).apply();
    }

    public final synchronized void cacheCustomerInfo(String appUserID, CustomerInfo info) {
        r.f(appUserID, "appUserID");
        r.f(info, "info");
        JSONObject rawData = info.getRawData();
        rawData.put(CUSTOMER_INFO_SCHEMA_VERSION_KEY, 3);
        rawData.put("verification_result", info.getEntitlements().getVerification().name());
        rawData.put(CUSTOMER_INFO_REQUEST_DATE_KEY, info.getRequestDate().getTime());
        this.preferences.edit().putString(customerInfoCacheKey(appUserID), rawData.toString()).apply();
        setCustomerInfoCacheTimestampToNow(appUserID);
    }

    public final synchronized void cacheOfferingsResponse(JSONObject offeringsResponse) {
        r.f(offeringsResponse, "offeringsResponse");
        this.preferences.edit().putString(getOfferingsResponseCacheKey(), offeringsResponse.toString()).apply();
    }

    public final synchronized void cacheProductEntitlementMapping(ProductEntitlementMapping productEntitlementMapping) {
        r.f(productEntitlementMapping, "productEntitlementMapping");
        this.preferences.edit().putString(getProductEntitlementMappingCacheKey(), productEntitlementMapping.toJson().toString()).apply();
        setProductEntitlementMappingCacheTimestampToNow();
    }

    public final synchronized void cleanPreviouslySentTokens(Set<String> hashedTokens) {
        r.f(hashedTokens, "hashedTokens");
        LogWrapperKt.log(LogIntent.DEBUG, ReceiptStrings.CLEANING_PREV_SENT_HASHED_TOKEN);
        setSavedTokenHashes(v.N(hashedTokens, getPreviouslySentHashedTokens()));
    }

    public final synchronized void cleanupOldAttributionData() {
        try {
            SharedPreferences.Editor editorEdit = this.preferences.edit();
            for (String str : this.preferences.getAll().keySet()) {
                if (str != null && t.y(str, this.attributionCacheKey, false, 2, null)) {
                    editorEdit.remove(str);
                }
            }
            editorEdit.apply();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void clearCachesForAppUserID(String appUserID) {
        r.f(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        r.e(editorEdit, "preferences.edit()");
        clearCustomerInfoCacheTimestamp(clearAppUserID(clearCustomerInfo(editorEdit)), appUserID).apply();
    }

    public final synchronized void clearCustomerInfoCache(String appUserID) {
        r.f(appUserID, "appUserID");
        SharedPreferences.Editor editor = this.preferences.edit();
        r.e(editor, "editor");
        clearCustomerInfoCache(appUserID, editor);
        editor.apply();
    }

    public final synchronized void clearOfferingsResponseCache() {
        this.preferences.edit().remove(getOfferingsResponseCacheKey()).apply();
    }

    public final String customerInfoCacheKey(String appUserID) {
        r.f(appUserID, "appUserID");
        return getLegacyAppUserIDCacheKey() + b.f10001a + appUserID;
    }

    public final String customerInfoLastUpdatedCacheKey(String appUserID) {
        r.f(appUserID, "appUserID");
        return getCustomerInfoCachesLastUpdatedCacheBaseKey() + b.f10001a + appUserID;
    }

    public final Set<String> findKeysThatStartWith(String cacheKey) {
        r.f(cacheKey, "cacheKey");
        try {
            Map<String, ?> all = this.preferences.getAll();
            if (all != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String it = entry.getKey();
                    r.e(it, "it");
                    if (t.y(it, cacheKey, false, 2, null)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Set<String> setKeySet = linkedHashMap.keySet();
                if (setKeySet != null) {
                    return setKeySet;
                }
            }
            return O.b();
        } catch (NullPointerException unused) {
            return O.b();
        }
    }

    public final synchronized List<StoreTransaction> getActivePurchasesNotInCache(Map<String, StoreTransaction> hashedTokens) {
        r.f(hashedTokens, "hashedTokens");
        return v.h0(J.h(hashedTokens, getPreviouslySentHashedTokens()).values());
    }

    public final String getAppUserIDCacheKey() {
        return (String) this.appUserIDCacheKey$delegate.getValue();
    }

    public final String getAttributionCacheKey$purchases_defaultsRelease() {
        return this.attributionCacheKey;
    }

    public final synchronized String getCachedAppUserID() {
        return this.preferences.getString(getAppUserIDCacheKey(), null);
    }

    public final CustomerInfo getCachedCustomerInfo(String appUserID) {
        r.f(appUserID, "appUserID");
        String string = this.preferences.getString(customerInfoCacheKey(appUserID), null);
        if (string == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            int iOptInt = jSONObject.optInt(CUSTOMER_INFO_SCHEMA_VERSION_KEY);
            String verificationResultString = jSONObject.has("verification_result") ? jSONObject.getString("verification_result") : "NOT_REQUESTED";
            Long lValueOf = Long.valueOf(jSONObject.optLong(CUSTOMER_INFO_REQUEST_DATE_KEY));
            if (lValueOf.longValue() <= 0) {
                lValueOf = null;
            }
            Date date = lValueOf != null ? new Date(lValueOf.longValue()) : null;
            jSONObject.remove("verification_result");
            jSONObject.remove(CUSTOMER_INFO_REQUEST_DATE_KEY);
            r.e(verificationResultString, "verificationResultString");
            VerificationResult verificationResultValueOf = VerificationResult.valueOf(verificationResultString);
            if (iOptInt == 3) {
                return CustomerInfoFactory.INSTANCE.buildCustomerInfo(jSONObject, date, verificationResultValueOf);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public JSONObject getJSONObjectOrNull(String key) {
        r.f(key, "key");
        String string = this.preferences.getString(key, null);
        if (string == null) {
            return null;
        }
        try {
            return new JSONObject(string);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final String getLegacyAppUserIDCacheKey() {
        return (String) this.legacyAppUserIDCacheKey$delegate.getValue();
    }

    public final synchronized String getLegacyCachedAppUserID() {
        return this.preferences.getString(getLegacyAppUserIDCacheKey(), null);
    }

    public final synchronized JSONObject getOfferingsResponseCache() {
        return getJSONObjectOrNull(getOfferingsResponseCacheKey());
    }

    public final synchronized Set<String> getPreviouslySentHashedTokens() {
        Set<String> setB;
        try {
            try {
                Set<String> stringSet = this.preferences.getStringSet(getTokensCacheKey(), O.b());
                if (stringSet == null || (setB = v.m0(stringSet)) == null) {
                    setB = O.b();
                }
                LogIntent logIntent = LogIntent.DEBUG;
                String str = String.format(ReceiptStrings.TOKENS_ALREADY_POSTED, Arrays.copyOf(new Object[]{setB}, 1));
                r.e(str, "format(this, *args)");
                LogWrapperKt.log(logIntent, str);
            } catch (ClassCastException unused) {
                setB = O.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return setB;
    }

    public final synchronized ProductEntitlementMapping getProductEntitlementMapping() {
        ProductEntitlementMapping productEntitlementMappingFromJson = null;
        String string = this.preferences.getString(getProductEntitlementMappingCacheKey(), null);
        if (string == null) {
            return null;
        }
        try {
            productEntitlementMappingFromJson = ProductEntitlementMapping.Companion.fromJson(new JSONObject(string));
        } catch (JSONException e7) {
            String str = String.format(OfflineEntitlementsStrings.ERROR_PARSING_PRODUCT_ENTITLEMENT_MAPPING, Arrays.copyOf(new Object[]{string}, 1));
            r.e(str, "format(this, *args)");
            LogUtilsKt.errorLog(str, e7);
            this.preferences.edit().remove(getProductEntitlementMappingCacheKey()).apply();
        }
        return productEntitlementMappingFromJson;
    }

    @Override // com.revenuecat.purchases.interfaces.StorefrontProvider
    public synchronized String getStorefront() {
        String string;
        string = this.preferences.getString(getStorefrontCacheKey(), null);
        if (string == null) {
            LogUtilsKt.debugLog(BillingStrings.BILLING_STOREFRONT_NULL_FROM_CACHE);
        }
        return string;
    }

    public final String getStorefrontCacheKey() {
        return (String) this.storefrontCacheKey$delegate.getValue();
    }

    public final String getTokensCacheKey() {
        return (String) this.tokensCacheKey$delegate.getValue();
    }

    public final synchronized boolean isCustomerInfoCacheStale(String appUserID, boolean z7) {
        r.f(appUserID, "appUserID");
        return DateExtensionsKt.isCacheStale(getCustomerInfoCachesLastUpdated(appUserID), z7, this.dateProvider);
    }

    public final synchronized boolean isProductEntitlementMappingCacheStale() {
        return DateExtensionsKt.m66isCacheStale8Mi8wO0(getProductEntitlementMappingLastUpdated(), DeviceCacheKt.PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD, this.dateProvider);
    }

    public final String newKey(String key) {
        r.f(key, "key");
        return getApiKeyPrefix() + b.f10001a + key;
    }

    public void putString(String cacheKey, String value) {
        r.f(cacheKey, "cacheKey");
        r.f(value, "value");
        this.preferences.edit().putString(cacheKey, value).apply();
    }

    public final void remove(String cacheKey) {
        r.f(cacheKey, "cacheKey");
        this.preferences.edit().remove(cacheKey).apply();
    }

    public final synchronized void setCustomerInfoCacheTimestamp(String appUserID, Date date) {
        r.f(appUserID, "appUserID");
        r.f(date, "date");
        this.preferences.edit().putLong(customerInfoLastUpdatedCacheKey(appUserID), date.getTime()).apply();
    }

    public final synchronized void setCustomerInfoCacheTimestampToNow(String appUserID) {
        r.f(appUserID, "appUserID");
        setCustomerInfoCacheTimestamp(appUserID, this.dateProvider.getNow());
    }

    public final synchronized void setProductEntitlementMappingCacheTimestampToNow() {
        setProductEntitlementMappingCacheTimestamp(this.dateProvider.getNow());
    }

    public final synchronized void setStorefront(String countryCode) {
        r.f(countryCode, "countryCode");
        String str = String.format(BillingStrings.BILLING_STOREFRONT_CACHING, Arrays.copyOf(new Object[]{countryCode}, 1));
        r.e(str, "format(this, *args)");
        LogUtilsKt.verboseLog(str);
        this.preferences.edit().putString(getStorefrontCacheKey(), countryCode).apply();
    }

    public final SharedPreferences.Editor startEditing() {
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        r.e(editorEdit, "preferences.edit()");
        return editorEdit;
    }

    public final synchronized void clearCustomerInfoCacheTimestamp(String appUserID) {
        r.f(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        r.e(editorEdit, "preferences.edit()");
        clearCustomerInfoCacheTimestamp(editorEdit, appUserID).apply();
    }

    public final synchronized SharedPreferences.Editor cacheAppUserID(String appUserID, SharedPreferences.Editor cacheEditor) {
        SharedPreferences.Editor editorPutString;
        r.f(appUserID, "appUserID");
        r.f(cacheEditor, "cacheEditor");
        editorPutString = cacheEditor.putString(getAppUserIDCacheKey(), appUserID);
        r.e(editorPutString, "cacheEditor.putString(ap…serIDCacheKey, appUserID)");
        return editorPutString;
    }

    public final synchronized void clearCustomerInfoCache(String appUserID, SharedPreferences.Editor editor) {
        r.f(appUserID, "appUserID");
        r.f(editor, "editor");
        clearCustomerInfoCacheTimestamp(editor, appUserID);
        editor.remove(customerInfoCacheKey(appUserID));
    }

    public /* synthetic */ DeviceCache(SharedPreferences sharedPreferences, String str, DateProvider dateProvider, int i7, AbstractC2148j abstractC2148j) {
        this(sharedPreferences, str, (i7 & 4) != 0 ? new DefaultDateProvider() : dateProvider);
    }
}
