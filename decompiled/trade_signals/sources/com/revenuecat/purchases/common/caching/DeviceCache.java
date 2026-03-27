package com.revenuecat.purchases.common.caching;

import D3.m;
import V6.A;
import android.content.SharedPreferences;
import com.amazon.a.a.o.c.a.b;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.VerificationResult;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.CustomerInfoFactory;
import com.revenuecat.purchases.common.DateProvider;
import com.revenuecat.purchases.common.DefaultDateProvider;
import com.revenuecat.purchases.common.LogIntent;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.common.UtilsKt;
import com.revenuecat.purchases.common.offlineentitlements.ProductEntitlementMapping;
import com.revenuecat.purchases.interfaces.StorefrontProvider;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.BillingStrings;
import com.revenuecat.purchases.strings.OfflineEntitlementsStrings;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies;
import com.revenuecat.purchases.virtualcurrencies.VirtualCurrenciesFactory;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k7.j;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2484l;
import o5.InterfaceC2483k;
import org.json.JSONException;
import org.json.JSONObject;
import p5.M;
import p5.S;
import p5.z;
import p7.AbstractC2609b;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b<\b\u0010\u0018\u0000 \u009b\u00012\u00020\u0001:\u0002\u009b\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\u000b\u001a\u00020\n*\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\n*\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\fJ\u001b\u0010\u000f\u001a\u00020\n*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001b\u0010\u0015\u001a\u00020\n*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u001b\u0010\u0016\u001a\u00020\n*\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u001d\u0010\u001a\u001a\u00020\u00192\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0011\u0010\u001f\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\n¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b%\u0010$J\u0015\u0010&\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b&\u0010'J\u001d\u0010&\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\n¢\u0006\u0004\b&\u0010)J\u0015\u0010*\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b*\u0010'J\u0015\u0010+\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b+\u0010,J\u0015\u0010-\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b-\u0010,J\u0017\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b/\u00100J\u001d\u00102\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u00101\u001a\u00020.¢\u0006\u0004\b2\u00103J\u001d\u00106\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u0010\u000f\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u000f\u0010'J\u0015\u00108\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b8\u0010'J\u001d\u00108\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u00109\u001a\u00020\n¢\u0006\u0004\b8\u0010:J\u0015\u0010;\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b;\u0010'J\u001d\u0010<\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0011¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0004¢\u0006\u0004\b?\u0010'J\u0011\u0010@\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b@\u0010$J\u0015\u0010A\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\bA\u0010,J\u0015\u0010B\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\bB\u0010,J\u0017\u0010D\u001a\u0004\u0018\u00010C2\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\bD\u0010EJ\u001d\u0010G\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010F\u001a\u00020C¢\u0006\u0004\bG\u0010HJ\u001d\u0010I\u001a\u0002042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u00105\u001a\u000204¢\u0006\u0004\bI\u00107J\u0015\u0010\u0016\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010'J\u001d\u0010\u0016\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u00109\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010:J\u0015\u0010J\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u0004¢\u0006\u0004\bJ\u0010'J\u001d\u0010K\u001a\u00020\u00192\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0011¢\u0006\u0004\bK\u0010=J\r\u0010L\u001a\u00020\u0019¢\u0006\u0004\bL\u0010MJ\u0013\u0010N\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\u0004\bN\u0010OJ\u0015\u0010Q\u001a\u00020\u00192\u0006\u0010P\u001a\u00020\u0004¢\u0006\u0004\bQ\u0010'J\u001b\u0010S\u001a\u00020\u00192\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00040\u0017¢\u0006\u0004\bS\u0010\u001bJ'\u0010W\u001a\b\u0012\u0004\u0012\u00020U0V2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020U0T¢\u0006\u0004\bW\u0010XJ\u000f\u0010Z\u001a\u0004\u0018\u00010Y¢\u0006\u0004\bZ\u0010[J\u0015\u0010]\u001a\u00020\u00192\u0006\u0010\\\u001a\u00020Y¢\u0006\u0004\b]\u0010^J\r\u0010_\u001a\u00020\u0019¢\u0006\u0004\b_\u0010MJ\u0015\u0010b\u001a\u00020\u00192\u0006\u0010a\u001a\u00020`¢\u0006\u0004\bb\u0010cJ\r\u0010d\u001a\u00020\u0019¢\u0006\u0004\bd\u0010MJ\r\u0010e\u001a\u000204¢\u0006\u0004\be\u0010fJ\u000f\u0010g\u001a\u0004\u0018\u00010`¢\u0006\u0004\bg\u0010hJ\u0019\u0010j\u001a\u0004\u0018\u00010Y2\u0006\u0010i\u001a\u00020\u0004H\u0016¢\u0006\u0004\bj\u0010kJ\u001f\u0010n\u001a\u00020\u00192\u0006\u0010l\u001a\u00020\u00042\u0006\u0010m\u001a\u00020\u0004H\u0016¢\u0006\u0004\bn\u0010oJ\u0015\u0010p\u001a\u00020\u00192\u0006\u0010l\u001a\u00020\u0004¢\u0006\u0004\bp\u0010'J\u001b\u0010q\u001a\b\u0012\u0004\u0012\u00020\u00040\u00172\u0006\u0010l\u001a\u00020\u0004¢\u0006\u0004\bq\u0010rJ\u0015\u0010s\u001a\u00020\u00042\u0006\u0010i\u001a\u00020\u0004¢\u0006\u0004\bs\u0010,R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010uR\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010vR\u001b\u0010z\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bw\u0010x\u001a\u0004\by\u0010$R\u001b\u0010}\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b{\u0010x\u001a\u0004\b|\u0010$R\u001c\u0010\u0080\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b~\u0010x\u001a\u0004\b\u007f\u0010$R\u001d\u0010\u0081\u0001\u001a\u00020\u00048\u0000X\u0080D¢\u0006\u000e\n\u0005\b\u0081\u0001\u0010u\u001a\u0005\b\u0082\u0001\u0010$R\u001e\u0010\u0085\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0083\u0001\u0010x\u001a\u0005\b\u0084\u0001\u0010$R\u001e\u0010\u0088\u0001\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\u000e\n\u0005\b\u0086\u0001\u0010x\u001a\u0005\b\u0087\u0001\u0010$R\u001e\u0010\u008b\u0001\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0089\u0001\u0010x\u001a\u0005\b\u008a\u0001\u0010$R\u001e\u0010\u008e\u0001\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008c\u0001\u0010x\u001a\u0005\b\u008d\u0001\u0010$R\u001e\u0010\u0091\u0001\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u008f\u0001\u0010x\u001a\u0005\b\u0090\u0001\u0010$R\u001e\u0010\u0094\u0001\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0092\u0001\u0010x\u001a\u0005\b\u0093\u0001\u0010$R\u001e\u0010\u0097\u0001\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0095\u0001\u0010x\u001a\u0005\b\u0096\u0001\u0010$R\u001e\u0010\u009a\u0001\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\u000e\n\u0005\b\u0098\u0001\u0010x\u001a\u0005\b\u0099\u0001\u0010$¨\u0006\u009c\u0001"}, d2 = {"Lcom/revenuecat/purchases/common/caching/DeviceCache;", "Lcom/revenuecat/purchases/interfaces/StorefrontProvider;", "Landroid/content/SharedPreferences;", "preferences", "", "apiKey", "Lcom/revenuecat/purchases/common/DateProvider;", "dateProvider", "<init>", "(Landroid/content/SharedPreferences;Ljava/lang/String;Lcom/revenuecat/purchases/common/DateProvider;)V", "Landroid/content/SharedPreferences$Editor;", "clearCustomerInfo", "(Landroid/content/SharedPreferences$Editor;)Landroid/content/SharedPreferences$Editor;", "clearAppUserID", "appUserID", "clearCustomerInfoCacheTimestamp", "(Landroid/content/SharedPreferences$Editor;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;", "Ljava/util/Date;", "getCustomerInfoCachesLastUpdated", "(Ljava/lang/String;)Ljava/util/Date;", "getVirtualCurrenciesCacheLastUpdated", "clearVirtualCurrenciesCacheTimestamp", "clearVirtualCurrenciesCache", "", "newSet", "Lo5/H;", "setSavedTokenHashes", "(Ljava/util/Set;)V", "date", "setProductEntitlementMappingCacheTimestamp", "(Ljava/util/Date;)V", "getProductEntitlementMappingLastUpdated", "()Ljava/util/Date;", "startEditing", "()Landroid/content/SharedPreferences$Editor;", "getLegacyCachedAppUserID", "()Ljava/lang/String;", "getCachedAppUserID", "cacheAppUserID", "(Ljava/lang/String;)V", "cacheEditor", "(Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)Landroid/content/SharedPreferences$Editor;", "clearCachesForAppUserID", "customerInfoCacheKey", "(Ljava/lang/String;)Ljava/lang/String;", "customerInfoLastUpdatedCacheKey", "Lcom/revenuecat/purchases/CustomerInfo;", "getCachedCustomerInfo", "(Ljava/lang/String;)Lcom/revenuecat/purchases/CustomerInfo;", "info", "cacheCustomerInfo", "(Ljava/lang/String;Lcom/revenuecat/purchases/CustomerInfo;)V", "", "appInBackground", "isCustomerInfoCacheStale", "(Ljava/lang/String;Z)Z", "clearCustomerInfoCache", "editor", "(Ljava/lang/String;Landroid/content/SharedPreferences$Editor;)V", "setCustomerInfoCacheTimestampToNow", "setCustomerInfoCacheTimestamp", "(Ljava/lang/String;Ljava/util/Date;)V", "countryCode", "setStorefront", "getStorefront", "virtualCurrenciesCacheKey", "virtualCurrenciesLastUpdatedCacheKey", "Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "getCachedVirtualCurrencies", "(Ljava/lang/String;)Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;", "virtualCurrencies", "cacheVirtualCurrencies", "(Ljava/lang/String;Lcom/revenuecat/purchases/virtualcurrencies/VirtualCurrencies;)V", "isVirtualCurrenciesCacheStale", "setVirtualCurrenciesCacheTimestampToNow", "setVirtualCurrenciesCacheTimestamp", "cleanupOldAttributionData", "()V", "getPreviouslySentHashedTokens", "()Ljava/util/Set;", "token", "addSuccessfullyPostedToken", "hashedTokens", "cleanPreviouslySentTokens", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "", "getActivePurchasesNotInCache", "(Ljava/util/Map;)Ljava/util/List;", "Lorg/json/JSONObject;", "getOfferingsResponseCache", "()Lorg/json/JSONObject;", "offeringsResponse", "cacheOfferingsResponse", "(Lorg/json/JSONObject;)V", "clearOfferingsResponseCache", "Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "productEntitlementMapping", "cacheProductEntitlementMapping", "(Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;)V", "setProductEntitlementMappingCacheTimestampToNow", "isProductEntitlementMappingCacheStale", "()Z", "getProductEntitlementMapping", "()Lcom/revenuecat/purchases/common/offlineentitlements/ProductEntitlementMapping;", "key", "getJSONObjectOrNull", "(Ljava/lang/String;)Lorg/json/JSONObject;", "cacheKey", "value", "putString", "(Ljava/lang/String;Ljava/lang/String;)V", "remove", "findKeysThatStartWith", "(Ljava/lang/String;)Ljava/util/Set;", "newKey", "Landroid/content/SharedPreferences;", "Ljava/lang/String;", "Lcom/revenuecat/purchases/common/DateProvider;", "apiKeyPrefix$delegate", "Lo5/k;", "getApiKeyPrefix", "apiKeyPrefix", "legacyAppUserIDCacheKey$delegate", "getLegacyAppUserIDCacheKey", "legacyAppUserIDCacheKey", "appUserIDCacheKey$delegate", "getAppUserIDCacheKey", "appUserIDCacheKey", "attributionCacheKey", "getAttributionCacheKey$purchases_defaultsRelease", "tokensCacheKey$delegate", "getTokensCacheKey", "tokensCacheKey", "storefrontCacheKey$delegate", "getStorefrontCacheKey", "storefrontCacheKey", "productEntitlementMappingCacheKey$delegate", "getProductEntitlementMappingCacheKey", "productEntitlementMappingCacheKey", "productEntitlementMappingLastUpdatedCacheKey$delegate", "getProductEntitlementMappingLastUpdatedCacheKey", "productEntitlementMappingLastUpdatedCacheKey", "customerInfoCachesLastUpdatedCacheBaseKey$delegate", "getCustomerInfoCachesLastUpdatedCacheBaseKey", "customerInfoCachesLastUpdatedCacheBaseKey", "virtualCurrenciesCacheBaseKey$delegate", "getVirtualCurrenciesCacheBaseKey", "virtualCurrenciesCacheBaseKey", "virtualCurrenciesLastUpdatedCacheBaseKey$delegate", "getVirtualCurrenciesLastUpdatedCacheBaseKey", "virtualCurrenciesLastUpdatedCacheBaseKey", "offeringsResponseCacheKey$delegate", "getOfferingsResponseCacheKey", "offeringsResponseCacheKey", "Companion", "purchases_defaultsRelease"}, k = 1, mv = {1, 8, 0})
public class DeviceCache implements StorefrontProvider {
    private static final String CUSTOMER_INFO_REQUEST_DATE_KEY = "customer_info_request_date";
    private static final String CUSTOMER_INFO_SCHEMA_VERSION_KEY = "schema_version";
    private static final String CUSTOMER_INFO_VERIFICATION_RESULT_KEY = "verification_result";
    private final String apiKey;

    /* JADX INFO: renamed from: apiKeyPrefix$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k apiKeyPrefix;

    /* JADX INFO: renamed from: appUserIDCacheKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k appUserIDCacheKey;
    private final String attributionCacheKey;

    /* JADX INFO: renamed from: customerInfoCachesLastUpdatedCacheBaseKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k customerInfoCachesLastUpdatedCacheBaseKey;
    private final DateProvider dateProvider;

    /* JADX INFO: renamed from: legacyAppUserIDCacheKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k legacyAppUserIDCacheKey;

    /* JADX INFO: renamed from: offeringsResponseCacheKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k offeringsResponseCacheKey;
    private final SharedPreferences preferences;

    /* JADX INFO: renamed from: productEntitlementMappingCacheKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k productEntitlementMappingCacheKey;

    /* JADX INFO: renamed from: productEntitlementMappingLastUpdatedCacheKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k productEntitlementMappingLastUpdatedCacheKey;

    /* JADX INFO: renamed from: storefrontCacheKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k storefrontCacheKey;

    /* JADX INFO: renamed from: tokensCacheKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k tokensCacheKey;

    /* JADX INFO: renamed from: virtualCurrenciesCacheBaseKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k virtualCurrenciesCacheBaseKey;

    /* JADX INFO: renamed from: virtualCurrenciesLastUpdatedCacheBaseKey$delegate, reason: from kotlin metadata */
    private final InterfaceC2483k virtualCurrenciesLastUpdatedCacheBaseKey;

    public DeviceCache(SharedPreferences preferences, String apiKey, DateProvider dateProvider) {
        AbstractC2304t.f(preferences, "preferences");
        AbstractC2304t.f(apiKey, "apiKey");
        AbstractC2304t.f(dateProvider, "dateProvider");
        this.preferences = preferences;
        this.apiKey = apiKey;
        this.dateProvider = dateProvider;
        this.apiKeyPrefix = AbstractC2484l.a(new DeviceCache$apiKeyPrefix$2(this));
        this.legacyAppUserIDCacheKey = AbstractC2484l.a(new DeviceCache$legacyAppUserIDCacheKey$2(this));
        this.appUserIDCacheKey = AbstractC2484l.a(new DeviceCache$appUserIDCacheKey$2(this));
        this.attributionCacheKey = "com.revenuecat.purchases..attribution";
        this.tokensCacheKey = AbstractC2484l.a(new DeviceCache$tokensCacheKey$2(this));
        this.storefrontCacheKey = AbstractC2484l.a(DeviceCache$storefrontCacheKey$2.INSTANCE);
        this.productEntitlementMappingCacheKey = AbstractC2484l.a(new DeviceCache$productEntitlementMappingCacheKey$2(this));
        this.productEntitlementMappingLastUpdatedCacheKey = AbstractC2484l.a(new DeviceCache$productEntitlementMappingLastUpdatedCacheKey$2(this));
        this.customerInfoCachesLastUpdatedCacheBaseKey = AbstractC2484l.a(new DeviceCache$customerInfoCachesLastUpdatedCacheBaseKey$2(this));
        this.virtualCurrenciesCacheBaseKey = AbstractC2484l.a(new DeviceCache$virtualCurrenciesCacheBaseKey$2(this));
        this.virtualCurrenciesLastUpdatedCacheBaseKey = AbstractC2484l.a(new DeviceCache$virtualCurrenciesLastUpdatedCacheBaseKey$2(this));
        this.offeringsResponseCacheKey = AbstractC2484l.a(new DeviceCache$offeringsResponseCacheKey$2(this));
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

    private final SharedPreferences.Editor clearVirtualCurrenciesCache(SharedPreferences.Editor editor, String str) {
        editor.remove(virtualCurrenciesCacheKey(str));
        String cachedAppUserID = getCachedAppUserID();
        if (cachedAppUserID != null) {
            editor.remove(virtualCurrenciesCacheKey(cachedAppUserID));
        }
        String legacyCachedAppUserID = getLegacyCachedAppUserID();
        if (legacyCachedAppUserID != null) {
            editor.remove(virtualCurrenciesCacheKey(legacyCachedAppUserID));
        }
        return editor;
    }

    private final SharedPreferences.Editor clearVirtualCurrenciesCacheTimestamp(SharedPreferences.Editor editor, String str) {
        editor.remove(virtualCurrenciesLastUpdatedCacheKey(str));
        String cachedAppUserID = getCachedAppUserID();
        if (cachedAppUserID != null) {
            editor.remove(virtualCurrenciesLastUpdatedCacheKey(cachedAppUserID));
        }
        String legacyCachedAppUserID = getLegacyCachedAppUserID();
        if (legacyCachedAppUserID != null) {
            editor.remove(virtualCurrenciesLastUpdatedCacheKey(legacyCachedAppUserID));
        }
        return editor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getApiKeyPrefix() {
        return (String) this.apiKeyPrefix.getValue();
    }

    private final synchronized Date getCustomerInfoCachesLastUpdated(String appUserID) {
        return new Date(this.preferences.getLong(customerInfoLastUpdatedCacheKey(appUserID), 0L));
    }

    private final String getCustomerInfoCachesLastUpdatedCacheBaseKey() {
        return (String) this.customerInfoCachesLastUpdatedCacheBaseKey.getValue();
    }

    private final String getOfferingsResponseCacheKey() {
        return (String) this.offeringsResponseCacheKey.getValue();
    }

    private final String getProductEntitlementMappingCacheKey() {
        return (String) this.productEntitlementMappingCacheKey.getValue();
    }

    private final Date getProductEntitlementMappingLastUpdated() {
        if (this.preferences.contains(getProductEntitlementMappingLastUpdatedCacheKey())) {
            return new Date(this.preferences.getLong(getProductEntitlementMappingLastUpdatedCacheKey(), -1L));
        }
        return null;
    }

    private final String getProductEntitlementMappingLastUpdatedCacheKey() {
        return (String) this.productEntitlementMappingLastUpdatedCacheKey.getValue();
    }

    private final String getVirtualCurrenciesCacheBaseKey() {
        return (String) this.virtualCurrenciesCacheBaseKey.getValue();
    }

    private final synchronized Date getVirtualCurrenciesCacheLastUpdated(String appUserID) {
        return new Date(this.preferences.getLong(virtualCurrenciesLastUpdatedCacheKey(appUserID), 0L));
    }

    private final String getVirtualCurrenciesLastUpdatedCacheBaseKey() {
        return (String) this.virtualCurrenciesLastUpdatedCacheBaseKey.getValue();
    }

    private final void setProductEntitlementMappingCacheTimestamp(Date date) {
        this.preferences.edit().putLong(getProductEntitlementMappingLastUpdatedCacheKey(), date.getTime()).apply();
    }

    private final synchronized void setSavedTokenHashes(Set<String> newSet) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogHandler currentLogHandler2;
        String str3;
        String str4;
        LogHandler currentLogHandler3;
        String str5;
        String str6;
        LogHandler currentLogHandler4;
        String str7;
        String str8;
        try {
            LogIntent logIntent = LogIntent.DEBUG;
            DeviceCache$setSavedTokenHashes$$inlined$log$1 deviceCache$setSavedTokenHashes$$inlined$log$1 = new DeviceCache$setSavedTokenHashes$$inlined$log$1(logIntent, newSet);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    str3 = "[Purchases] - ERROR";
                    str4 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                    currentLogHandler2.e(str3, str4, null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        str5 = "[Purchases] - " + logLevel2.name();
                        str6 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                        currentLogHandler3.w(str5, str6);
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        str7 = "[Purchases] - " + logLevel3.name();
                        str8 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                        currentLogHandler4.i(str7, str8);
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    str3 = "[Purchases] - ERROR";
                    str4 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                    currentLogHandler2.e(str3, str4, null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        str7 = "[Purchases] - " + logLevel5.name();
                        str8 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                        currentLogHandler4.i(str7, str8);
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        str5 = "[Purchases] - " + logLevel8.name();
                        str6 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                        currentLogHandler3.w(str5, str6);
                    }
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        str5 = "[Purchases] - " + logLevel9.name();
                        str6 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                        currentLogHandler3.w(str5, str6);
                    }
                    break;
                case 12:
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    str3 = "[Purchases] - ERROR";
                    str4 = (String) deviceCache$setSavedTokenHashes$$inlined$log$1.invoke();
                    currentLogHandler2.e(str3, str4, null);
                    break;
            }
            this.preferences.edit().putStringSet(getTokensCacheKey(), newSet).apply();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void addSuccessfullyPostedToken(String token) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogHandler currentLogHandler2;
        String str3;
        String str4;
        LogHandler currentLogHandler3;
        String str5;
        String str6;
        LogHandler currentLogHandler4;
        String str7;
        String str8;
        LogHandler currentLogHandler5;
        String str9;
        String str10;
        LogHandler currentLogHandler6;
        String str11;
        String str12;
        LogHandler currentLogHandler7;
        String str13;
        String str14;
        LogHandler currentLogHandler8;
        String str15;
        String str16;
        try {
            AbstractC2304t.f(token, "token");
            LogIntent logIntent = LogIntent.DEBUG;
            DeviceCache$addSuccessfullyPostedToken$$inlined$log$1 deviceCache$addSuccessfullyPostedToken$$inlined$log$1 = new DeviceCache$addSuccessfullyPostedToken$$inlined$log$1(logIntent, token);
            int[] iArr = LogWrapperKt.WhenMappings.$EnumSwitchMapping$0;
            switch (iArr[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    str3 = "[Purchases] - ERROR";
                    str4 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                    currentLogHandler2.e(str3, str4, null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        str5 = "[Purchases] - " + logLevel2.name();
                        str6 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                        currentLogHandler3.w(str5, str6);
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        str7 = "[Purchases] - " + logLevel3.name();
                        str8 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                        currentLogHandler4.i(str7, str8);
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    str3 = "[Purchases] - ERROR";
                    str4 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                    currentLogHandler2.e(str3, str4, null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        str7 = "[Purchases] - " + logLevel5.name();
                        str8 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                        currentLogHandler4.i(str7, str8);
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        str5 = "[Purchases] - " + logLevel8.name();
                        str6 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                        currentLogHandler3.w(str5, str6);
                    }
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        str5 = "[Purchases] - " + logLevel9.name();
                        str6 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                        currentLogHandler3.w(str5, str6);
                    }
                    break;
                case 12:
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    str3 = "[Purchases] - ERROR";
                    str4 = (String) deviceCache$addSuccessfullyPostedToken$$inlined$log$1.invoke();
                    currentLogHandler2.e(str3, str4, null);
                    break;
            }
            Set<String> previouslySentHashedTokens = getPreviouslySentHashedTokens();
            DeviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1 deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1 = new DeviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1(logIntent, previouslySentHashedTokens);
            switch (iArr[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel10 = LogLevel.DEBUG;
                    currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                        str9 = "[Purchases] - " + logLevel10.name();
                        str10 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                        currentLogHandler5.d(str9, str10);
                    }
                    break;
                case 2:
                    currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    str11 = "[Purchases] - ERROR";
                    str12 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                    currentLogHandler6.e(str11, str12, null);
                    break;
                case 3:
                    LogLevel logLevel11 = LogLevel.WARN;
                    currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                        str13 = "[Purchases] - " + logLevel11.name();
                        str14 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                        currentLogHandler7.w(str13, str14);
                    }
                    break;
                case 4:
                    LogLevel logLevel12 = LogLevel.INFO;
                    currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                        str15 = "[Purchases] - " + logLevel12.name();
                        str16 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                        currentLogHandler8.i(str15, str16);
                    }
                    break;
                case 5:
                    LogLevel logLevel13 = LogLevel.DEBUG;
                    currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                        str9 = "[Purchases] - " + logLevel13.name();
                        str10 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                        currentLogHandler5.d(str9, str10);
                    }
                    break;
                case 6:
                    currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    str11 = "[Purchases] - ERROR";
                    str12 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                    currentLogHandler6.e(str11, str12, null);
                    break;
                case 7:
                    LogLevel logLevel14 = LogLevel.INFO;
                    currentLogHandler8 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                        str15 = "[Purchases] - " + logLevel14.name();
                        str16 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                        currentLogHandler8.i(str15, str16);
                    }
                    break;
                case 8:
                    LogLevel logLevel15 = LogLevel.DEBUG;
                    currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                        str9 = "[Purchases] - " + logLevel15.name();
                        str10 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                        currentLogHandler5.d(str9, str10);
                    }
                    break;
                case 9:
                    LogLevel logLevel16 = LogLevel.DEBUG;
                    currentLogHandler5 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                        str9 = "[Purchases] - " + logLevel16.name();
                        str10 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                        currentLogHandler5.d(str9, str10);
                    }
                    break;
                case 10:
                    LogLevel logLevel17 = LogLevel.WARN;
                    currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                        str13 = "[Purchases] - " + logLevel17.name();
                        str14 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                        currentLogHandler7.w(str13, str14);
                    }
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    LogLevel logLevel18 = LogLevel.WARN;
                    currentLogHandler7 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                        str13 = "[Purchases] - " + logLevel18.name();
                        str14 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                        currentLogHandler7.w(str13, str14);
                    }
                    break;
                case 12:
                    currentLogHandler6 = LogWrapperKt.getCurrentLogHandler();
                    str11 = "[Purchases] - ERROR";
                    str12 = (String) deviceCache$addSuccessfullyPostedToken$lambda$21$$inlined$log$1.invoke();
                    currentLogHandler6.e(str11, str12, null);
                    break;
            }
            Set<String> setJ0 = z.J0(previouslySentHashedTokens);
            setJ0.add(UtilsKt.sha1(token));
            setSavedTokenHashes(setJ0);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized SharedPreferences.Editor cacheAppUserID(String appUserID, SharedPreferences.Editor cacheEditor) {
        SharedPreferences.Editor editorPutString;
        AbstractC2304t.f(appUserID, "appUserID");
        AbstractC2304t.f(cacheEditor, "cacheEditor");
        editorPutString = cacheEditor.putString(getAppUserIDCacheKey(), appUserID);
        AbstractC2304t.e(editorPutString, "cacheEditor.putString(ap…serIDCacheKey, appUserID)");
        return editorPutString;
    }

    public final synchronized void cacheCustomerInfo(String appUserID, CustomerInfo info) {
        AbstractC2304t.f(appUserID, "appUserID");
        AbstractC2304t.f(info, "info");
        JSONObject jsonObject = info.getJsonObject();
        jsonObject.put(CUSTOMER_INFO_SCHEMA_VERSION_KEY, 3);
        jsonObject.put("verification_result", info.getEntitlements().getVerification().name());
        jsonObject.put(CUSTOMER_INFO_REQUEST_DATE_KEY, info.getRequestDate().getTime());
        this.preferences.edit().putString(customerInfoCacheKey(appUserID), jsonObject.toString()).apply();
        setCustomerInfoCacheTimestampToNow(appUserID);
    }

    public final synchronized void cacheOfferingsResponse(JSONObject offeringsResponse) {
        AbstractC2304t.f(offeringsResponse, "offeringsResponse");
        this.preferences.edit().putString(getOfferingsResponseCacheKey(), offeringsResponse.toString()).apply();
    }

    public final synchronized void cacheProductEntitlementMapping(ProductEntitlementMapping productEntitlementMapping) {
        AbstractC2304t.f(productEntitlementMapping, "productEntitlementMapping");
        this.preferences.edit().putString(getProductEntitlementMappingCacheKey(), productEntitlementMapping.toJson().toString()).apply();
        setProductEntitlementMappingCacheTimestampToNow();
    }

    public final synchronized void cacheVirtualCurrencies(String appUserID, VirtualCurrencies virtualCurrencies) {
        AbstractC2304t.f(appUserID, "appUserID");
        AbstractC2304t.f(virtualCurrencies, "virtualCurrencies");
        this.preferences.edit().putString(virtualCurrenciesCacheKey(appUserID), AbstractC2609b.f22439d.b(VirtualCurrencies.INSTANCE.serializer(), virtualCurrencies)).apply();
        setVirtualCurrenciesCacheTimestampToNow(appUserID);
    }

    public final synchronized void cleanPreviouslySentTokens(Set<String> hashedTokens) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogHandler currentLogHandler2;
        String str3;
        String str4;
        LogHandler currentLogHandler3;
        String str5;
        String str6;
        LogHandler currentLogHandler4;
        String str7;
        String str8;
        try {
            AbstractC2304t.f(hashedTokens, "hashedTokens");
            LogIntent logIntent = LogIntent.DEBUG;
            DeviceCache$cleanPreviouslySentTokens$$inlined$log$1 deviceCache$cleanPreviouslySentTokens$$inlined$log$1 = new DeviceCache$cleanPreviouslySentTokens$$inlined$log$1(logIntent);
            switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                case 1:
                    LogLevel logLevel = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                        str = "[Purchases] - " + logLevel.name();
                        str2 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 2:
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    str3 = "[Purchases] - ERROR";
                    str4 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                    currentLogHandler2.e(str3, str4, null);
                    break;
                case 3:
                    LogLevel logLevel2 = LogLevel.WARN;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                        str5 = "[Purchases] - " + logLevel2.name();
                        str6 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                        currentLogHandler3.w(str5, str6);
                    }
                    break;
                case 4:
                    LogLevel logLevel3 = LogLevel.INFO;
                    currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                        str7 = "[Purchases] - " + logLevel3.name();
                        str8 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                        currentLogHandler4.i(str7, str8);
                    }
                    break;
                case 5:
                    LogLevel logLevel4 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                        str = "[Purchases] - " + logLevel4.name();
                        str2 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 6:
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    str3 = "[Purchases] - ERROR";
                    str4 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                    currentLogHandler2.e(str3, str4, null);
                    break;
                case 7:
                    LogLevel logLevel5 = LogLevel.INFO;
                    currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                        str7 = "[Purchases] - " + logLevel5.name();
                        str8 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                        currentLogHandler4.i(str7, str8);
                    }
                    break;
                case 8:
                    LogLevel logLevel6 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                        str = "[Purchases] - " + logLevel6.name();
                        str2 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 9:
                    LogLevel logLevel7 = LogLevel.DEBUG;
                    currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                        str = "[Purchases] - " + logLevel7.name();
                        str2 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                        currentLogHandler.d(str, str2);
                    }
                    break;
                case 10:
                    LogLevel logLevel8 = LogLevel.WARN;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                        str5 = "[Purchases] - " + logLevel8.name();
                        str6 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                        currentLogHandler3.w(str5, str6);
                    }
                    break;
                case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                    LogLevel logLevel9 = LogLevel.WARN;
                    currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                    if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                        str5 = "[Purchases] - " + logLevel9.name();
                        str6 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                        currentLogHandler3.w(str5, str6);
                    }
                    break;
                case 12:
                    currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                    str3 = "[Purchases] - ERROR";
                    str4 = (String) deviceCache$cleanPreviouslySentTokens$$inlined$log$1.invoke();
                    currentLogHandler2.e(str3, str4, null);
                    break;
            }
            setSavedTokenHashes(z.d0(hashedTokens, getPreviouslySentHashedTokens()));
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void cleanupOldAttributionData() {
        try {
            SharedPreferences.Editor editorEdit = this.preferences.edit();
            for (String str : this.preferences.getAll().keySet()) {
                if (str != null && A.G(str, this.attributionCacheKey, false, 2, null)) {
                    editorEdit.remove(str);
                }
            }
            editorEdit.apply();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void clearCachesForAppUserID(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        AbstractC2304t.e(editorEdit, "preferences.edit()");
        clearVirtualCurrenciesCache(clearVirtualCurrenciesCacheTimestamp(clearCustomerInfoCacheTimestamp(clearAppUserID(clearCustomerInfo(editorEdit)), appUserID), appUserID), appUserID).apply();
    }

    public final synchronized void clearCustomerInfoCache(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        SharedPreferences.Editor editor = this.preferences.edit();
        AbstractC2304t.e(editor, "editor");
        clearCustomerInfoCache(appUserID, editor);
        editor.apply();
    }

    public final synchronized void clearOfferingsResponseCache() {
        this.preferences.edit().remove(getOfferingsResponseCacheKey()).apply();
    }

    public final String customerInfoCacheKey(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        return getLegacyAppUserIDCacheKey() + b.f14112a + appUserID;
    }

    public final String customerInfoLastUpdatedCacheKey(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        return getCustomerInfoCachesLastUpdatedCacheBaseKey() + b.f14112a + appUserID;
    }

    public final Set<String> findKeysThatStartWith(String cacheKey) {
        AbstractC2304t.f(cacheKey, "cacheKey");
        try {
            Map<String, ?> all = this.preferences.getAll();
            if (all != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<String, ?> entry : all.entrySet()) {
                    String it = entry.getKey();
                    AbstractC2304t.e(it, "it");
                    if (A.G(it, cacheKey, false, 2, null)) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                Set<String> setKeySet = linkedHashMap.keySet();
                if (setKeySet != null) {
                    return setKeySet;
                }
            }
            return S.d();
        } catch (NullPointerException unused) {
            return S.d();
        }
    }

    public final synchronized List<StoreTransaction> getActivePurchasesNotInCache(Map<String, StoreTransaction> hashedTokens) {
        AbstractC2304t.f(hashedTokens, "hashedTokens");
        return z.G0(M.l(hashedTokens, getPreviouslySentHashedTokens()).values());
    }

    public final String getAppUserIDCacheKey() {
        return (String) this.appUserIDCacheKey.getValue();
    }

    /* JADX INFO: renamed from: getAttributionCacheKey$purchases_defaultsRelease, reason: from getter */
    public final String getAttributionCacheKey() {
        return this.attributionCacheKey;
    }

    public final synchronized String getCachedAppUserID() {
        return this.preferences.getString(getAppUserIDCacheKey(), null);
    }

    public final CustomerInfo getCachedCustomerInfo(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
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
            AbstractC2304t.e(verificationResultString, "verificationResultString");
            VerificationResult verificationResultValueOf = VerificationResult.valueOf(verificationResultString);
            if (iOptInt == 3) {
                return CustomerInfoFactory.INSTANCE.buildCustomerInfo(jSONObject, date, verificationResultValueOf);
            }
            return null;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final synchronized VirtualCurrencies getCachedVirtualCurrencies(String appUserID) {
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogHandler currentLogHandler2;
        String str3;
        String str4;
        LogHandler currentLogHandler3;
        String str5;
        String str6;
        LogHandler currentLogHandler4;
        String str7;
        String str8;
        AbstractC2304t.f(appUserID, "appUserID");
        String string = this.preferences.getString(virtualCurrenciesCacheKey(appUserID), null);
        if (string != null) {
            try {
                return VirtualCurrenciesFactory.INSTANCE.buildVirtualCurrencies(string);
            } catch (j e8) {
                LogIntent logIntent = LogIntent.WARNING;
                DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2 deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2 = new DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2(logIntent, e8);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            str5 = "[Purchases] - " + logLevel2.name();
                            str6 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            str7 = "[Purchases] - " + logLevel3.name();
                            str8 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                            currentLogHandler4.i(str7, str8);
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            str7 = "[Purchases] - " + logLevel5.name();
                            str8 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                            currentLogHandler4.i(str7, str8);
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            str5 = "[Purchases] - " + logLevel8.name();
                            str6 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                        LogLevel logLevel9 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            str5 = "[Purchases] - " + logLevel9.name();
                            str6 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case 12:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$2.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                }
            } catch (IllegalArgumentException e9) {
                LogIntent logIntent2 = LogIntent.WARNING;
                DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3 deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3 = new DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3(logIntent2, e9);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent2.ordinal()]) {
                    case 1:
                        LogLevel logLevel10 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel10) <= 0) {
                            str = "[Purchases] - " + logLevel10.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                    case 3:
                        LogLevel logLevel11 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel11) <= 0) {
                            str5 = "[Purchases] - " + logLevel11.name();
                            str6 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case 4:
                        LogLevel logLevel12 = LogLevel.INFO;
                        currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel12) <= 0) {
                            str7 = "[Purchases] - " + logLevel12.name();
                            str8 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                            currentLogHandler4.i(str7, str8);
                        }
                        break;
                    case 5:
                        LogLevel logLevel13 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel13) <= 0) {
                            str = "[Purchases] - " + logLevel13.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                    case 7:
                        LogLevel logLevel14 = LogLevel.INFO;
                        currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel14) <= 0) {
                            str7 = "[Purchases] - " + logLevel14.name();
                            str8 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                            currentLogHandler4.i(str7, str8);
                        }
                        break;
                    case 8:
                        LogLevel logLevel15 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel15) <= 0) {
                            str = "[Purchases] - " + logLevel15.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel16 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel16) <= 0) {
                            str = "[Purchases] - " + logLevel16.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel17 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel17) <= 0) {
                            str5 = "[Purchases] - " + logLevel17.name();
                            str6 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                        LogLevel logLevel18 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel18) <= 0) {
                            str5 = "[Purchases] - " + logLevel18.name();
                            str6 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case 12:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$3.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                }
            } catch (JSONException e10) {
                LogIntent logIntent3 = LogIntent.WARNING;
                DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1 deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1 = new DeviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1(logIntent3, e10);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent3.ordinal()]) {
                    case 1:
                        LogLevel logLevel19 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel19) <= 0) {
                            str = "[Purchases] - " + logLevel19.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                    case 3:
                        LogLevel logLevel20 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel20) <= 0) {
                            str5 = "[Purchases] - " + logLevel20.name();
                            str6 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case 4:
                        LogLevel logLevel21 = LogLevel.INFO;
                        currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel21) <= 0) {
                            str7 = "[Purchases] - " + logLevel21.name();
                            str8 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                            currentLogHandler4.i(str7, str8);
                        }
                        break;
                    case 5:
                        LogLevel logLevel22 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel22) <= 0) {
                            str = "[Purchases] - " + logLevel22.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                    case 7:
                        LogLevel logLevel23 = LogLevel.INFO;
                        currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel23) <= 0) {
                            str7 = "[Purchases] - " + logLevel23.name();
                            str8 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                            currentLogHandler4.i(str7, str8);
                        }
                        break;
                    case 8:
                        LogLevel logLevel24 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel24) <= 0) {
                            str = "[Purchases] - " + logLevel24.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel25 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel25) <= 0) {
                            str = "[Purchases] - " + logLevel25.name();
                            str2 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel26 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel26) <= 0) {
                            str5 = "[Purchases] - " + logLevel26.name();
                            str6 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                        LogLevel logLevel27 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel27) <= 0) {
                            str5 = "[Purchases] - " + logLevel27.name();
                            str6 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case 12:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getCachedVirtualCurrencies$lambda$11$$inlined$log$1.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                }
            }
        }
        return null;
    }

    public JSONObject getJSONObjectOrNull(String key) {
        AbstractC2304t.f(key, "key");
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
        return (String) this.legacyAppUserIDCacheKey.getValue();
    }

    public final synchronized String getLegacyCachedAppUserID() {
        return this.preferences.getString(getLegacyAppUserIDCacheKey(), null);
    }

    public final synchronized JSONObject getOfferingsResponseCache() {
        return getJSONObjectOrNull(getOfferingsResponseCacheKey());
    }

    public final synchronized Set<String> getPreviouslySentHashedTokens() {
        Set<String> setD;
        LogHandler currentLogHandler;
        String str;
        String str2;
        LogHandler currentLogHandler2;
        String str3;
        String str4;
        LogHandler currentLogHandler3;
        String str5;
        String str6;
        LogHandler currentLogHandler4;
        String str7;
        String str8;
        try {
            try {
                Set<String> stringSet = this.preferences.getStringSet(getTokensCacheKey(), S.d());
                if (stringSet == null || (setD = z.K0(stringSet)) == null) {
                    setD = S.d();
                }
                LogIntent logIntent = LogIntent.DEBUG;
                DeviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1 deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1 = new DeviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1(logIntent, setD);
                switch (LogWrapperKt.WhenMappings.$EnumSwitchMapping$0[logIntent.ordinal()]) {
                    case 1:
                        LogLevel logLevel = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                            str = "[Purchases] - " + logLevel.name();
                            str2 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 2:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                    case 3:
                        LogLevel logLevel2 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel2) <= 0) {
                            str5 = "[Purchases] - " + logLevel2.name();
                            str6 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case 4:
                        LogLevel logLevel3 = LogLevel.INFO;
                        currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel3) <= 0) {
                            str7 = "[Purchases] - " + logLevel3.name();
                            str8 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                            currentLogHandler4.i(str7, str8);
                        }
                        break;
                    case 5:
                        LogLevel logLevel4 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel4) <= 0) {
                            str = "[Purchases] - " + logLevel4.name();
                            str2 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 6:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                    case 7:
                        LogLevel logLevel5 = LogLevel.INFO;
                        currentLogHandler4 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel5) <= 0) {
                            str7 = "[Purchases] - " + logLevel5.name();
                            str8 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                            currentLogHandler4.i(str7, str8);
                        }
                        break;
                    case 8:
                        LogLevel logLevel6 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel6) <= 0) {
                            str = "[Purchases] - " + logLevel6.name();
                            str2 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 9:
                        LogLevel logLevel7 = LogLevel.DEBUG;
                        currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel7) <= 0) {
                            str = "[Purchases] - " + logLevel7.name();
                            str2 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                            currentLogHandler.d(str, str2);
                        }
                        break;
                    case 10:
                        LogLevel logLevel8 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel8) <= 0) {
                            str5 = "[Purchases] - " + logLevel8.name();
                            str6 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                        LogLevel logLevel9 = LogLevel.WARN;
                        currentLogHandler3 = LogWrapperKt.getCurrentLogHandler();
                        if (Config.INSTANCE.getLogLevel().compareTo(logLevel9) <= 0) {
                            str5 = "[Purchases] - " + logLevel9.name();
                            str6 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                            currentLogHandler3.w(str5, str6);
                        }
                        break;
                    case 12:
                        currentLogHandler2 = LogWrapperKt.getCurrentLogHandler();
                        str3 = "[Purchases] - ERROR";
                        str4 = (String) deviceCache$getPreviouslySentHashedTokens$lambda$17$$inlined$log$1.invoke();
                        currentLogHandler2.e(str3, str4, null);
                        break;
                }
            } catch (ClassCastException unused) {
                setD = S.d();
            }
        } finally {
        }
        return setD;
    }

    public final synchronized ProductEntitlementMapping getProductEntitlementMapping() {
        ProductEntitlementMapping productEntitlementMappingFromJson = null;
        String string = this.preferences.getString(getProductEntitlementMappingCacheKey(), null);
        if (string == null) {
            return null;
        }
        try {
            productEntitlementMappingFromJson = ProductEntitlementMapping.INSTANCE.fromJson(new JSONObject(string));
        } catch (JSONException e8) {
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            String str = String.format(OfflineEntitlementsStrings.ERROR_PARSING_PRODUCT_ENTITLEMENT_MAPPING, Arrays.copyOf(new Object[]{string}, 1));
            AbstractC2304t.e(str, "format(...)");
            currentLogHandler.e("[Purchases] - ERROR", str, e8);
            this.preferences.edit().remove(getProductEntitlementMappingCacheKey()).apply();
        }
        return productEntitlementMappingFromJson;
    }

    @Override // com.revenuecat.purchases.interfaces.StorefrontProvider
    public synchronized String getStorefront() {
        String string;
        string = this.preferences.getString(getStorefrontCacheKey(), null);
        if (string == null) {
            LogLevel logLevel = LogLevel.DEBUG;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                currentLogHandler.d("[Purchases] - " + logLevel.name(), BillingStrings.BILLING_STOREFRONT_NULL_FROM_CACHE);
            }
        }
        return string;
    }

    public final String getStorefrontCacheKey() {
        return (String) this.storefrontCacheKey.getValue();
    }

    public final String getTokensCacheKey() {
        return (String) this.tokensCacheKey.getValue();
    }

    public final synchronized boolean isCustomerInfoCacheStale(String appUserID, boolean appInBackground) {
        AbstractC2304t.f(appUserID, "appUserID");
        return DateExtensionsKt.isCacheStale(getCustomerInfoCachesLastUpdated(appUserID), appInBackground, this.dateProvider);
    }

    public final synchronized boolean isProductEntitlementMappingCacheStale() {
        return DateExtensionsKt.m63isCacheStale8Mi8wO0(getProductEntitlementMappingLastUpdated(), DeviceCacheKt.PRODUCT_ENTITLEMENT_MAPPING_CACHE_REFRESH_PERIOD, this.dateProvider);
    }

    public final synchronized boolean isVirtualCurrenciesCacheStale(String appUserID, boolean appInBackground) {
        AbstractC2304t.f(appUserID, "appUserID");
        return DateExtensionsKt.isCacheStale(getVirtualCurrenciesCacheLastUpdated(appUserID), appInBackground, this.dateProvider);
    }

    public final String newKey(String key) {
        AbstractC2304t.f(key, "key");
        return getApiKeyPrefix() + b.f14112a + key;
    }

    public void putString(String cacheKey, String value) {
        AbstractC2304t.f(cacheKey, "cacheKey");
        AbstractC2304t.f(value, "value");
        this.preferences.edit().putString(cacheKey, value).apply();
    }

    public final void remove(String cacheKey) {
        AbstractC2304t.f(cacheKey, "cacheKey");
        this.preferences.edit().remove(cacheKey).apply();
    }

    public final synchronized void setCustomerInfoCacheTimestamp(String appUserID, Date date) {
        AbstractC2304t.f(appUserID, "appUserID");
        AbstractC2304t.f(date, "date");
        this.preferences.edit().putLong(customerInfoLastUpdatedCacheKey(appUserID), date.getTime()).apply();
    }

    public final synchronized void setCustomerInfoCacheTimestampToNow(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        setCustomerInfoCacheTimestamp(appUserID, this.dateProvider.getNow());
    }

    public final synchronized void setProductEntitlementMappingCacheTimestampToNow() {
        setProductEntitlementMappingCacheTimestamp(this.dateProvider.getNow());
    }

    public final synchronized void setStorefront(String countryCode) {
        try {
            AbstractC2304t.f(countryCode, "countryCode");
            LogLevel logLevel = LogLevel.VERBOSE;
            LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
            if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                String str = "[Purchases] - " + logLevel.name();
                String str2 = String.format(BillingStrings.BILLING_STOREFRONT_CACHING, Arrays.copyOf(new Object[]{countryCode}, 1));
                AbstractC2304t.e(str2, "format(...)");
                currentLogHandler.v(str, str2);
            }
            this.preferences.edit().putString(getStorefrontCacheKey(), countryCode).apply();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void setVirtualCurrenciesCacheTimestamp(String appUserID, Date date) {
        AbstractC2304t.f(appUserID, "appUserID");
        AbstractC2304t.f(date, "date");
        this.preferences.edit().putLong(virtualCurrenciesLastUpdatedCacheKey(appUserID), date.getTime()).apply();
    }

    public final synchronized void setVirtualCurrenciesCacheTimestampToNow(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        setVirtualCurrenciesCacheTimestamp(appUserID, this.dateProvider.getNow());
    }

    public final SharedPreferences.Editor startEditing() {
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        AbstractC2304t.e(editorEdit, "preferences.edit()");
        return editorEdit;
    }

    public final String virtualCurrenciesCacheKey(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        return getVirtualCurrenciesCacheBaseKey() + b.f14112a + appUserID;
    }

    public final String virtualCurrenciesLastUpdatedCacheKey(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        return getVirtualCurrenciesLastUpdatedCacheBaseKey() + b.f14112a + appUserID;
    }

    public /* synthetic */ DeviceCache(SharedPreferences sharedPreferences, String str, DateProvider dateProvider, int i8, AbstractC2296k abstractC2296k) {
        this(sharedPreferences, str, (i8 & 4) != 0 ? new DefaultDateProvider() : dateProvider);
    }

    public final synchronized void cacheAppUserID(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        AbstractC2304t.e(editorEdit, "preferences.edit()");
        cacheAppUserID(appUserID, editorEdit).apply();
    }

    public final synchronized void clearCustomerInfoCache(String appUserID, SharedPreferences.Editor editor) {
        AbstractC2304t.f(appUserID, "appUserID");
        AbstractC2304t.f(editor, "editor");
        clearCustomerInfoCacheTimestamp(editor, appUserID);
        editor.remove(customerInfoCacheKey(appUserID));
    }

    public final synchronized void clearCustomerInfoCacheTimestamp(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        SharedPreferences.Editor editorEdit = this.preferences.edit();
        AbstractC2304t.e(editorEdit, "preferences.edit()");
        clearCustomerInfoCacheTimestamp(editorEdit, appUserID).apply();
    }

    public final synchronized void clearVirtualCurrenciesCache(String appUserID) {
        AbstractC2304t.f(appUserID, "appUserID");
        SharedPreferences.Editor editor = this.preferences.edit();
        AbstractC2304t.e(editor, "editor");
        clearVirtualCurrenciesCache(appUserID, editor);
        editor.apply();
    }

    public final synchronized void clearVirtualCurrenciesCache(String appUserID, SharedPreferences.Editor editor) {
        AbstractC2304t.f(appUserID, "appUserID");
        AbstractC2304t.f(editor, "editor");
        clearVirtualCurrenciesCacheTimestamp(editor, appUserID);
        clearVirtualCurrenciesCache(editor, appUserID);
    }
}
