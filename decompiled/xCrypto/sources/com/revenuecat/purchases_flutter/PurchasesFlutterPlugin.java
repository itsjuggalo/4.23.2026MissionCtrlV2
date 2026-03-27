package com.revenuecat.purchases_flutter;

import W2.D;
import W2.E;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.CustomerInfo;
import com.revenuecat.purchases.DangerousSettings;
import com.revenuecat.purchases.Purchases;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.Store;
import com.revenuecat.purchases.common.PlatformInfo;
import com.revenuecat.purchases.hybridcommon.CommonKt;
import com.revenuecat.purchases.hybridcommon.ErrorContainer;
import com.revenuecat.purchases.hybridcommon.OnNullableResult;
import com.revenuecat.purchases.hybridcommon.OnResult;
import com.revenuecat.purchases.hybridcommon.OnResultAny;
import com.revenuecat.purchases.hybridcommon.OnResultList;
import com.revenuecat.purchases.hybridcommon.SubscriberAttributesKt;
import com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import com.revenuecat.purchases.models.InAppMessageType;
import i3.k;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugins.firebase.auth.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class PurchasesFlutterPlugin implements FlutterPlugin, MethodChannel.MethodCallHandler, ActivityAware {
    private static final String CUSTOMER_INFO_UPDATED = "Purchases-CustomerInfoUpdated";
    private static final String INVALID_ARGS_ERROR_CODE = "invalidArgs";
    protected static final String LOG_HANDLER_EVENT = "Purchases-LogHandlerEvent";
    private static final String PLATFORM_NAME = "flutter";
    private static final String PLUGIN_VERSION = "8.11.0";
    private static final String TAG = "PurchasesFlutter";
    private Activity activity;
    private Context applicationContext;
    private MethodChannel channel;
    private final Handler handler = new Handler(Looper.getMainLooper());

    public static /* synthetic */ E a(PurchasesFlutterPlugin purchasesFlutterPlugin, Map map) {
        purchasesFlutterPlugin.invokeChannelMethodOnUiThread(LOG_HANDLER_EVENT, map);
        return null;
    }

    public static /* synthetic */ void b(PurchasesFlutterPlugin purchasesFlutterPlugin, String str, Object obj) {
        MethodChannel methodChannel = purchasesFlutterPlugin.channel;
        if (methodChannel != null) {
            methodChannel.invokeMethod(str, obj);
        }
    }

    public static /* synthetic */ E c(PurchasesFlutterPlugin purchasesFlutterPlugin, Map map) {
        purchasesFlutterPlugin.invokeChannelMethodOnUiThread(CUSTOMER_INFO_UPDATED, map);
        return E.f5463a;
    }

    private void canMakePayments(List<Integer> list, final MethodChannel.Result result) {
        CommonKt.canMakePayments(this.applicationContext, list, new OnResultAny<Boolean>() { // from class: com.revenuecat.purchases_flutter.PurchasesFlutterPlugin.3
            @Override // com.revenuecat.purchases.hybridcommon.OnResultAny
            public void onError(ErrorContainer errorContainer) {
                PurchasesFlutterPlugin.this.reject(errorContainer, result);
            }

            @Override // com.revenuecat.purchases.hybridcommon.OnResultAny
            public void onReceived(Boolean bool) {
                result.success(bool);
            }
        });
    }

    private void checkTrialOrIntroductoryPriceEligibility(ArrayList<String> arrayList, MethodChannel.Result result) {
        result.success(CommonKt.checkTrialOrIntroductoryPriceEligibility(arrayList));
    }

    private void close(MethodChannel.Result result) {
        try {
            Purchases.getSharedInstance().close();
        } catch (D unused) {
        }
        result.success(null);
    }

    private void collectDeviceIdentifiers(MethodChannel.Result result) {
        SubscriberAttributesKt.collectDeviceIdentifiers();
        result.success(null);
    }

    public static /* synthetic */ void d(final PurchasesFlutterPlugin purchasesFlutterPlugin, CustomerInfo customerInfo) {
        purchasesFlutterPlugin.getClass();
        CustomerInfoMapperKt.mapAsync(customerInfo, new k() { // from class: com.revenuecat.purchases_flutter.b
            @Override // i3.k
            public final Object invoke(Object obj) {
                return PurchasesFlutterPlugin.c(this.f11365a, (Map) obj);
            }
        });
    }

    private void getAppUserID(MethodChannel.Result result) {
        result.success(CommonKt.getAppUserID());
    }

    private void getCurrentOfferingForPlacement(String str, MethodChannel.Result result) {
        CommonKt.getCurrentOfferingForPlacement(str, getOnNullableResult(result));
    }

    private void getCustomerInfo(MethodChannel.Result result) {
        CommonKt.getCustomerInfo(getOnResult(result));
    }

    private void getOfferings(MethodChannel.Result result) {
        CommonKt.getOfferings(getOnResult(result));
    }

    private OnNullableResult getOnNullableResult(final MethodChannel.Result result) {
        return new OnNullableResult() { // from class: com.revenuecat.purchases_flutter.PurchasesFlutterPlugin.5
            @Override // com.revenuecat.purchases.hybridcommon.OnNullableResult
            public void onError(ErrorContainer errorContainer) {
                PurchasesFlutterPlugin.this.reject(errorContainer, result);
            }

            @Override // com.revenuecat.purchases.hybridcommon.OnNullableResult
            public void onReceived(Map<String, ?> map) {
                result.success(map);
            }
        };
    }

    private OnResult getOnResult(final MethodChannel.Result result) {
        return new OnResult() { // from class: com.revenuecat.purchases_flutter.PurchasesFlutterPlugin.4
            @Override // com.revenuecat.purchases.hybridcommon.OnResult
            public void onError(ErrorContainer errorContainer) {
                PurchasesFlutterPlugin.this.reject(errorContainer, result);
            }

            @Override // com.revenuecat.purchases.hybridcommon.OnResult
            public void onReceived(Map<String, ?> map) {
                result.success(map);
            }
        };
    }

    private void getProductInfo(ArrayList<String> arrayList, String str, final MethodChannel.Result result) {
        CommonKt.getProductInfo(arrayList, str, new OnResultList() { // from class: com.revenuecat.purchases_flutter.PurchasesFlutterPlugin.1
            @Override // com.revenuecat.purchases.hybridcommon.OnResultList
            public void onError(ErrorContainer errorContainer) {
                PurchasesFlutterPlugin.this.reject(errorContainer, result);
            }

            @Override // com.revenuecat.purchases.hybridcommon.OnResultList
            public void onReceived(List<Map<String, ?>> list) {
                result.success(list);
            }
        });
    }

    private void getStorefront(final MethodChannel.Result result) {
        CommonKt.getStorefront(new k() { // from class: com.revenuecat.purchases_flutter.PurchasesFlutterPlugin.2
            @Override // i3.k
            public E invoke(Map<String, ?> map) {
                result.success(map);
                return null;
            }
        });
    }

    private void invalidateCustomerInfoCache(MethodChannel.Result result) {
        CommonKt.invalidateCustomerInfoCache();
        result.success(null);
    }

    private void invokeChannelMethodOnUiThread(final String str, final Object obj) {
        runOnUiThread(new Runnable() { // from class: com.revenuecat.purchases_flutter.c
            @Override // java.lang.Runnable
            public final void run() {
                PurchasesFlutterPlugin.b(this.f11366a, str, obj);
            }
        });
    }

    private void isAnonymous(MethodChannel.Result result) {
        result.success(Boolean.valueOf(CommonKt.isAnonymous()));
    }

    private void isConfigured(MethodChannel.Result result) {
        result.success(Boolean.valueOf(Purchases.isConfigured()));
    }

    private void isWebPurchaseRedemptionURL(String str, MethodChannel.Result result) {
        if (str == null) {
            result.error(INVALID_ARGS_ERROR_CODE, "Missing urlString argument", null);
        } else {
            result.success(Boolean.valueOf(CommonKt.isWebPurchaseRedemptionURL(str)));
        }
    }

    private void logIn(String str, MethodChannel.Result result) {
        CommonKt.logIn(str, getOnResult(result));
    }

    private void logOut(MethodChannel.Result result) {
        CommonKt.logOut(getOnResult(result));
    }

    private void purchasePackage(String str, Map<String, Object> map, String str2, Integer num, Boolean bool, MethodChannel.Result result) {
        CommonKt.purchasePackage(this.activity, str, map, str2, num, bool, getOnResult(result));
    }

    private void purchaseProduct(String str, String str2, String str3, Integer num, Boolean bool, Map<String, Object> map, MethodChannel.Result result) {
        CommonKt.purchaseProduct(this.activity, str, str2, null, str3, num, bool, map, getOnResult(result));
    }

    private void purchaseSubscriptionOption(String str, String str2, String str3, Integer num, Boolean bool, Map<String, Object> map, MethodChannel.Result result) {
        CommonKt.purchaseSubscriptionOption(this.activity, str, str2, str3, num, bool, map, getOnResult(result));
    }

    private void redeemWebPurchase(String str, MethodChannel.Result result) {
        if (str == null) {
            result.error(INVALID_ARGS_ERROR_CODE, "Missing redemptionLink argument", null);
        } else {
            CommonKt.redeemWebPurchase(str, getOnResult(result));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reject(ErrorContainer errorContainer, MethodChannel.Result result) {
        result.error(String.valueOf(errorContainer.getCode()), errorContainer.getMessage(), errorContainer.getInfo());
    }

    private void restorePurchases(MethodChannel.Result result) {
        CommonKt.restorePurchases(getOnResult(result));
    }

    private void runOnUiThread(Runnable runnable) {
        this.handler.post(runnable);
    }

    private void setAd(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setAd(str);
        result.success(null);
    }

    private void setAdGroup(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setAdGroup(str);
        result.success(null);
    }

    private void setAdjustID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setAdjustID(str);
        result.success(null);
    }

    private void setAirshipChannelID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setAirshipChannelID(str);
        result.success(null);
    }

    private void setAllowSharingAppStoreAccount(Boolean bool, MethodChannel.Result result) {
        if (bool == null) {
            result.error(INVALID_ARGS_ERROR_CODE, "Missing allowSharing argument", null);
        } else {
            CommonKt.setAllowSharingAppStoreAccount(bool.booleanValue());
            result.success(null);
        }
    }

    private void setAppsflyerID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setAppsflyerID(str);
        result.success(null);
    }

    private void setAttributes(Map<String, String> map, MethodChannel.Result result) {
        SubscriberAttributesKt.setAttributes(map);
        result.success(null);
    }

    private void setCampaign(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setCampaign(str);
        result.success(null);
    }

    private void setCleverTapID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setCleverTapID(str);
        result.success(null);
    }

    private void setCreative(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setCreative(str);
        result.success(null);
    }

    private void setDebugLogsEnabled(boolean z4, MethodChannel.Result result) {
        CommonKt.setLogLevel(z4 ? "DEBUG" : "INFO");
        result.success(null);
    }

    private void setDisplayName(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setDisplayName(str);
        result.success(null);
    }

    private void setEmail(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setEmail(str);
        result.success(null);
    }

    private void setFBAnonymousID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setFBAnonymousID(str);
        result.success(null);
    }

    private void setFirebaseAppInstanceID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setFirebaseAppInstanceID(str);
        result.success(null);
    }

    private void setKeyword(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setKeyword(str);
        result.success(null);
    }

    private void setLogHandler(MethodChannel.Result result) {
        CommonKt.setLogHandler(new k() { // from class: com.revenuecat.purchases_flutter.a
            @Override // i3.k
            public final Object invoke(Object obj) {
                return PurchasesFlutterPlugin.a(this.f11364a, (Map) obj);
            }
        });
        result.success(null);
    }

    private void setLogLevel(String str, MethodChannel.Result result) {
        CommonKt.setLogLevel(str);
        result.success(null);
    }

    private void setMediaSource(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setMediaSource(str);
        result.success(null);
    }

    private void setMixpanelDistinctID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setMixpanelDistinctID(str);
        result.success(null);
    }

    private void setMparticleID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setMparticleID(str);
        result.success(null);
    }

    private void setOnesignalID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setOnesignalID(str);
        result.success(null);
    }

    private void setPhoneNumber(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setPhoneNumber(str);
        result.success(null);
    }

    private void setProxyURLString(String str, MethodChannel.Result result) {
        CommonKt.setProxyURLString(str);
        result.success(null);
    }

    private void setPushToken(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setPushToken(str);
        result.success(null);
    }

    private void setTenjinAnalyticsInstallationID(String str, MethodChannel.Result result) {
        SubscriberAttributesKt.setTenjinAnalyticsInstallationID(str);
        result.success(null);
    }

    private void setUpdatedCustomerInfoListener() {
        Purchases.getSharedInstance().setUpdatedCustomerInfoListener(new UpdatedCustomerInfoListener() { // from class: com.revenuecat.purchases_flutter.d
            @Override // com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener
            public final void onReceived(CustomerInfo customerInfo) {
                PurchasesFlutterPlugin.d(this.f11369a, customerInfo);
            }
        });
    }

    private void setupPurchases(String str, String str2, String str3, Boolean bool, Boolean bool2, String str4, Boolean bool3, MethodChannel.Result result) {
        if (this.applicationContext == null) {
            result.error(String.valueOf(PurchasesErrorCode.UnknownError.getCode()), "Purchases can't be setup. There is no Application context", null);
            return;
        }
        PlatformInfo platformInfo = new PlatformInfo(PLATFORM_NAME, PLUGIN_VERSION);
        Store store = Store.PLAY_STORE;
        if (bool != null && bool.booleanValue()) {
            store = Store.AMAZON;
        }
        CommonKt.configure(this.applicationContext, str, str2, str3, platformInfo, store, new DangerousSettings(), bool2, str4, bool3);
        setUpdatedCustomerInfoListener();
        result.success(null);
    }

    private void showInAppMessages(ArrayList<Integer> arrayList, MethodChannel.Result result) {
        if (arrayList == null) {
            CommonKt.showInAppMessagesIfNeeded(this.activity);
        } else {
            ArrayList arrayList2 = new ArrayList();
            InAppMessageType[] inAppMessageTypeArrValues = InAppMessageType.values();
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                int iIntValue = arrayList.get(i4).intValue();
                InAppMessageType inAppMessageType = iIntValue < inAppMessageTypeArrValues.length ? inAppMessageTypeArrValues[iIntValue] : null;
                if (inAppMessageType != null) {
                    arrayList2.add(inAppMessageType);
                } else {
                    Log.e(TAG, "Unsupported in-app message type: " + iIntValue);
                }
            }
            CommonKt.showInAppMessagesIfNeeded(this.activity, arrayList2);
        }
        result.success(null);
    }

    private void syncAmazonPurchase(String str, String str2, String str3, String str4, Double d4, MethodChannel.Result result) {
        Purchases.getSharedInstance().syncAmazonPurchase(str, str2, str3, str4, d4);
        result.success(null);
    }

    private void syncAttributesAndOfferingsIfNeeded(MethodChannel.Result result) {
        CommonKt.syncAttributesAndOfferingsIfNeeded(getOnResult(result));
    }

    private void syncPurchases(MethodChannel.Result result) {
        CommonKt.syncPurchases();
        result.success(null);
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
        this.activity = activityPluginBinding.getActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        onAttachedToEngine(flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getApplicationContext());
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivity() {
        this.activity = null;
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onDetachedFromActivityForConfigChanges() {
        onDetachedFromActivity();
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        MethodChannel methodChannel = this.channel;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
        }
        this.channel = null;
        this.applicationContext = null;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.getClass();
        switch (str) {
            case "setKeyword":
                setKeyword((String) methodCall.argument("keyword"), result);
                break;
            case "getProductInfo":
                getProductInfo((ArrayList) methodCall.argument("productIdentifiers"), (String) methodCall.argument("type"), result);
                break;
            case "restorePurchases":
                restorePurchases(result);
                break;
            case "invalidateCustomerInfoCache":
                invalidateCustomerInfoCache(result);
                break;
            case "checkTrialOrIntroductoryPriceEligibility":
                checkTrialOrIntroductoryPriceEligibility((ArrayList) methodCall.argument("productIdentifiers"), result);
                break;
            case "setOnesignalID":
                setOnesignalID((String) methodCall.argument("onesignalID"), result);
                break;
            case "getPromotionalOffer":
            case "purchaseProductWithWinBackOffer":
            case "beginRefundRequestForEntitlement":
            case "setSimulatesAskToBuyInSandbox":
            case "purchasePackageWithWinBackOffer":
            case "enableAdServicesAttributionTokenCollection":
            case "presentCodeRedemptionSheet":
            case "beginRefundRequestForProduct":
            case "eligibleWinBackOffersForProduct":
            case "beginRefundRequestForActiveEntitlement":
            case "recordPurchaseForProductID":
                result.success(null);
                break;
            case "purchasePackage":
                purchasePackage((String) methodCall.argument("packageIdentifier"), (Map) methodCall.argument("presentedOfferingContext"), (String) methodCall.argument("googleOldProductIdentifier"), (Integer) methodCall.argument("googleProrationMode"), (Boolean) methodCall.argument("googleIsPersonalizedPrice"), result);
                break;
            case "setFirebaseAppInstanceID":
                setFirebaseAppInstanceID((String) methodCall.argument("firebaseAppInstanceID"), result);
                break;
            case "getCustomerInfo":
                getCustomerInfo(result);
                break;
            case "showInAppMessages":
                showInAppMessages((ArrayList) methodCall.argument("types"), result);
                break;
            case "getCurrentOfferingForPlacement":
                getCurrentOfferingForPlacement((String) methodCall.argument("placementIdentifier"), result);
                break;
            case "redeemWebPurchase":
                redeemWebPurchase((String) methodCall.argument("redemptionLink"), result);
                break;
            case "purchaseProduct":
                purchaseProduct((String) methodCall.argument("productIdentifier"), (String) methodCall.argument("type"), (String) methodCall.argument("googleOldProductIdentifier"), (Integer) methodCall.argument("googleProrationMode"), (Boolean) methodCall.argument("googleIsPersonalizedPrice"), (Map) methodCall.argument("presentedOfferingContext"), result);
                break;
            case "isConfigured":
                isConfigured(result);
                break;
            case "logOut":
                logOut(result);
                break;
            case "purchaseSubscriptionOption":
                purchaseSubscriptionOption((String) methodCall.argument("productIdentifier"), (String) methodCall.argument("optionIdentifier"), (String) methodCall.argument("googleOldProductIdentifier"), (Integer) methodCall.argument("googleProrationMode"), (Boolean) methodCall.argument("googleIsPersonalizedPrice"), (Map) methodCall.argument("presentedOfferingContext"), result);
                break;
            case "setFBAnonymousID":
                setFBAnonymousID((String) methodCall.argument("fbAnonymousID"), result);
                break;
            case "isAnonymous":
                isAnonymous(result);
                break;
            case "setLogHandler":
                setLogHandler(result);
                break;
            case "setDisplayName":
                setDisplayName((String) methodCall.argument("displayName"), result);
                break;
            case "setMparticleID":
                setMparticleID((String) methodCall.argument("mparticleID"), result);
                break;
            case "setTenjinAnalyticsInstallationID":
                setTenjinAnalyticsInstallationID((String) methodCall.argument("tenjinAnalyticsInstallationID"), result);
                break;
            case "setDebugLogsEnabled":
                setDebugLogsEnabled(methodCall.argument("enabled") != null && ((Boolean) methodCall.argument("enabled")).booleanValue(), result);
                break;
            case "setCreative":
                setCreative((String) methodCall.argument("creative"), result);
                break;
            case "isWebPurchaseRedemptionURL":
                isWebPurchaseRedemptionURL((String) methodCall.argument("urlString"), result);
                break;
            case "setLogLevel":
                setLogLevel((String) methodCall.argument(FirebaseAnalytics.Param.LEVEL), result);
                break;
            case "syncAmazonPurchase":
                syncAmazonPurchase((String) methodCall.argument("productID"), (String) methodCall.argument("receiptID"), (String) methodCall.argument("amazonUserID"), (String) methodCall.argument("isoCurrencyCode"), (Double) methodCall.argument("price"), result);
                break;
            case "setAllowSharingStoreAccount":
                setAllowSharingAppStoreAccount((Boolean) methodCall.argument("allowSharing"), result);
                break;
            case "close":
                close(result);
                break;
            case "setupPurchases":
                String str2 = (String) methodCall.argument("apiKey");
                String str3 = (String) methodCall.argument("appUserId");
                String str4 = (String) methodCall.argument("purchasesAreCompletedBy");
                Boolean bool = (Boolean) methodCall.argument("useAmazon");
                setupPurchases(str2, str3, str4, bool, (Boolean) methodCall.argument("shouldShowInAppMessagesAutomatically"), (String) methodCall.argument("entitlementVerificationMode"), (Boolean) methodCall.argument("pendingTransactionsForPrepaidPlansEnabled"), result);
                break;
            case "logIn":
                logIn((String) methodCall.argument("appUserID"), result);
                break;
            case "setAd":
                setAd((String) methodCall.argument("ad"), result);
                break;
            case "setAppsflyerID":
                setAppsflyerID((String) methodCall.argument("appsflyerID"), result);
                break;
            case "syncAttributesAndOfferingsIfNeeded":
                syncAttributesAndOfferingsIfNeeded(result);
                break;
            case "setCleverTapID":
                setCleverTapID((String) methodCall.argument("cleverTapID"), result);
                break;
            case "setProxyURLString":
                setProxyURLString((String) methodCall.argument("proxyURLString"), result);
                break;
            case "collectDeviceIdentifiers":
                collectDeviceIdentifiers(result);
                break;
            case "getStorefront":
                getStorefront(result);
                break;
            case "setPhoneNumber":
                setPhoneNumber((String) methodCall.argument("phoneNumber"), result);
                break;
            case "setPushToken":
                setPushToken((String) methodCall.argument("pushToken"), result);
                break;
            case "setAttributes":
                setAttributes((Map) methodCall.argument("attributes"), result);
                break;
            case "setAdjustID":
                setAdjustID((String) methodCall.argument("adjustID"), result);
                break;
            case "setAirshipChannelID":
                setAirshipChannelID((String) methodCall.argument("airshipChannelID"), result);
                break;
            case "syncPurchases":
                syncPurchases(result);
                break;
            case "setEmail":
                setEmail((String) methodCall.argument(Constants.EMAIL), result);
                break;
            case "setMediaSource":
                setMediaSource((String) methodCall.argument("mediaSource"), result);
                break;
            case "getAppUserID":
                getAppUserID(result);
                break;
            case "setAdGroup":
                setAdGroup((String) methodCall.argument("adGroup"), result);
                break;
            case "setCampaign":
                setCampaign((String) methodCall.argument("campaign"), result);
                break;
            case "getOfferings":
                getOfferings(result);
                break;
            case "setMixpanelDistinctID":
                setMixpanelDistinctID((String) methodCall.argument("mixpanelDistinctID"), result);
                break;
            case "canMakePayments":
                canMakePayments((List) methodCall.argument("features"), result);
                break;
            default:
                result.notImplemented();
                break;
        }
    }

    @Override // io.flutter.embedding.engine.plugins.activity.ActivityAware
    public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
        onAttachedToActivity(activityPluginBinding);
    }

    private void onAttachedToEngine(BinaryMessenger binaryMessenger, Context context) {
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "purchases_flutter");
        this.channel = methodChannel;
        this.applicationContext = context;
        methodChannel.setMethodCallHandler(this);
    }
}
