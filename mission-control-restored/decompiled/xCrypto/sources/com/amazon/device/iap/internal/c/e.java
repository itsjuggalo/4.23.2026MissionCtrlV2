package com.amazon.device.iap.internal.c;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.amazon.a.a.o.f;
import com.amazon.device.iap.PurchasingListener;
import com.amazon.device.iap.PurchasingService;
import com.amazon.device.iap.internal.model.ProductBuilder;
import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.model.UserDataBuilder;
import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.Product;
import com.amazon.device.iap.model.ProductDataResponse;
import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.PurchaseResponse;
import com.amazon.device.iap.model.PurchaseUpdatesResponse;
import com.amazon.device.iap.model.Receipt;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserData;
import com.amazon.device.iap.model.UserDataRequest;
import com.amazon.device.iap.model.UserDataResponse;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class e implements com.amazon.device.iap.internal.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9228a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9229b = "com.amazon.sdktestclient";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9230c = "com.amazon.sdktestclient.command.CommandBroker";

    private PurchaseUpdatesResponse b(Intent intent) {
        UserData userDataBuild;
        ArrayList arrayList;
        Exception e4;
        RequestId requestIdFromString;
        boolean zOptBoolean;
        JSONObject jSONObject;
        PurchaseUpdatesResponse.RequestStatus requestStatusValueOf = PurchaseUpdatesResponse.RequestStatus.FAILED;
        ArrayList arrayList2 = null;
        boolean z4 = false;
        z4 = false;
        try {
            jSONObject = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.f8728B));
            try {
                requestStatusValueOf = PurchaseUpdatesResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                zOptBoolean = jSONObject.optBoolean("isMore");
                try {
                    userDataBuild = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.f8765m)).build();
                } catch (Exception e5) {
                    e = e5;
                    userDataBuild = null;
                    arrayList = null;
                }
            } catch (Exception e6) {
                userDataBuild = null;
                arrayList = null;
                e4 = e6;
            }
            try {
            } catch (Exception e7) {
                e = e7;
                arrayList = null;
                e4 = e;
                z4 = zOptBoolean;
                Log.e(f9228a, "Error parsing purchase updates output", e4);
                zOptBoolean = z4;
                arrayList2 = arrayList;
                return new PurchaseUpdatesResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setUserData(userDataBuild).setReceipts(arrayList2).setHasMore(zOptBoolean).build();
            }
        } catch (Exception e8) {
            userDataBuild = null;
            arrayList = null;
            e4 = e8;
            requestIdFromString = null;
        }
        if (requestStatusValueOf == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            arrayList = new ArrayList();
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.amazon.a.a.o.b.f8733G);
                if (jSONArrayOptJSONArray != null) {
                    for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i4);
                        try {
                            arrayList.add(a(jSONObjectOptJSONObject));
                        } catch (Exception unused) {
                            Log.e(f9228a, "Failed to parse receipt from json:" + jSONObjectOptJSONObject);
                        }
                    }
                }
            } catch (Exception e9) {
                e4 = e9;
                z4 = zOptBoolean;
                Log.e(f9228a, "Error parsing purchase updates output", e4);
                zOptBoolean = z4;
                arrayList2 = arrayList;
                return new PurchaseUpdatesResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setUserData(userDataBuild).setReceipts(arrayList2).setHasMore(zOptBoolean).build();
            }
            arrayList2 = arrayList;
        }
        return new PurchaseUpdatesResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setUserData(userDataBuild).setReceipts(arrayList2).setHasMore(zOptBoolean).build();
    }

    private void c(Intent intent) {
        a(d(intent));
    }

    private ProductDataResponse d(Intent intent) {
        LinkedHashSet linkedHashSet;
        HashMap map;
        Exception e4;
        RequestId requestIdFromString;
        ProductDataResponse.RequestStatus requestStatusValueOf;
        ProductDataResponse.RequestStatus requestStatus = ProductDataResponse.RequestStatus.FAILED;
        LinkedHashSet linkedHashSet2 = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("itemDataOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.f8728B));
            try {
                requestStatusValueOf = ProductDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                if (requestStatusValueOf != requestStatus) {
                    try {
                        LinkedHashSet linkedHashSet3 = new LinkedHashSet();
                        try {
                            map = new HashMap();
                            try {
                                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("unavailableSkus");
                                if (jSONArrayOptJSONArray != null) {
                                    for (int i4 = 0; i4 < jSONArrayOptJSONArray.length(); i4++) {
                                        linkedHashSet3.add(jSONArrayOptJSONArray.getString(i4));
                                    }
                                }
                                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(FirebaseAnalytics.Param.ITEMS);
                                if (jSONObjectOptJSONObject != null) {
                                    Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
                                    while (itKeys.hasNext()) {
                                        String next = itKeys.next();
                                        map.put(next, a(next, jSONObjectOptJSONObject.optJSONObject(next)));
                                    }
                                }
                                linkedHashSet2 = linkedHashSet3;
                            } catch (Exception e5) {
                                e4 = e5;
                                linkedHashSet = linkedHashSet3;
                                requestStatus = requestStatusValueOf;
                                Log.e(f9228a, "Error parsing item data output", e4);
                                requestStatusValueOf = requestStatus;
                                linkedHashSet2 = linkedHashSet;
                            }
                        } catch (Exception e6) {
                            map = null;
                            e4 = e6;
                        }
                    } catch (Exception e7) {
                        linkedHashSet = null;
                        map = null;
                        e4 = e7;
                    }
                } else {
                    map = null;
                }
            } catch (Exception e8) {
                map = null;
                e4 = e8;
                linkedHashSet = null;
            }
        } catch (Exception e9) {
            linkedHashSet = null;
            map = null;
            e4 = e9;
            requestIdFromString = null;
        }
        return new ProductDataResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setProductData(map).setUnavailableSkus(linkedHashSet2).build();
    }

    private void e(Intent intent) {
        JSONObject jSONObject;
        UserDataResponse userDataResponseF = f(intent);
        RequestId requestId = userDataResponseF.getRequestId();
        String stringExtra = intent.getStringExtra("userInput");
        try {
            jSONObject = new JSONObject(stringExtra);
        } catch (JSONException e4) {
            Log.e(f9228a, "Unable to parse request data: " + stringExtra, e4);
            jSONObject = null;
        }
        if (requestId == null || jSONObject == null) {
            a(userDataResponseF);
            return;
        }
        if (!jSONObject.optBoolean(b.at, false)) {
            a(userDataResponseF);
            return;
        }
        if (userDataResponseF.getUserData() == null || f.a(userDataResponseF.getUserData().getUserId())) {
            Log.e(f9228a, "No Userid found in userDataResponse" + userDataResponseF);
            a(new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).setUserData(userDataResponseF.getUserData()).setReceipts(new ArrayList()).setHasMore(false).build());
            return;
        }
        Log.i(f9228a, "sendGetPurchaseUpdates with user id" + userDataResponseF.getUserData().getUserId());
        a(requestId.toString(), userDataResponseF.getUserData().getUserId(), jSONObject.optBoolean(b.au, true));
    }

    private UserDataResponse f(Intent intent) {
        RequestId requestIdFromString;
        JSONObject jSONObject;
        UserDataResponse.RequestStatus requestStatusValueOf = UserDataResponse.RequestStatus.FAILED;
        UserData userDataBuild = null;
        try {
            jSONObject = new JSONObject(intent.getStringExtra("userOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.f8728B));
        } catch (Exception e4) {
            e = e4;
            requestIdFromString = null;
        }
        try {
            requestStatusValueOf = UserDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
            if (requestStatusValueOf == UserDataResponse.RequestStatus.SUCCESSFUL) {
                String strOptString = jSONObject.optString("userId");
                userDataBuild = new UserDataBuilder().setUserId(strOptString).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.f8765m)).setLWAConsentStatus(jSONObject.optString("UserDataResponse.LWAConsentStatus")).build();
            }
        } catch (Exception e5) {
            e = e5;
            Log.e(f9228a, "Error parsing userid output", e);
        }
        return new UserDataResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setUserData(userDataBuild).build();
    }

    private void g(Intent intent) {
        a(h(intent));
    }

    private PurchaseResponse h(Intent intent) {
        RequestId requestIdFromString;
        UserData userDataBuild;
        PurchaseResponse.RequestStatus requestStatusSafeValueOf = PurchaseResponse.RequestStatus.FAILED;
        Receipt receiptA = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("purchaseOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.f8728B));
            try {
                userDataBuild = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.f8765m)).build();
            } catch (Exception e4) {
                e = e4;
                userDataBuild = null;
            }
            try {
                requestStatusSafeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.optString("purchaseStatus"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.f8730D);
                if (jSONObjectOptJSONObject != null) {
                    receiptA = a(jSONObjectOptJSONObject);
                }
            } catch (Exception e5) {
                e = e5;
                Log.e(f9228a, "Error parsing purchase output", e);
            }
        } catch (Exception e6) {
            e = e6;
            requestIdFromString = null;
            userDataBuild = null;
        }
        return new PurchaseResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusSafeValueOf).setUserData(userDataBuild).setReceipt(receiptA).build();
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, UserDataRequest userDataRequest) {
        com.amazon.device.iap.internal.util.b.a(f9228a, "sendGetUserDataRequest");
        a(requestId.toString(), false, false, userDataRequest);
    }

    private void a(String str, boolean z4, boolean z5, UserDataRequest userDataRequest) {
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.f8728B, str);
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.f8735I, PurchasingService.SDK_VERSION);
            jSONObject.put(b.at, z4);
            jSONObject.put(b.au, z5);
            if (userDataRequest != null) {
                jSONObject.put("UserDataRequest.fetchLWAConsentStatus", userDataRequest.getFetchLWAConsentStatus());
            }
            bundle.putString("userInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.appUserId");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f9228a, "Error in sendGetUserDataRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str) {
        com.amazon.device.iap.internal.util.b.a(f9228a, "sendPurchaseRequest");
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            boolean zD = com.amazon.device.iap.internal.d.f().d();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", str);
            jSONObject.put(com.amazon.a.a.o.b.ac, zD);
            jSONObject.put(com.amazon.a.a.o.b.f8728B, requestId.toString());
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.f8735I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.purchase");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f9228a, "Error in sendPurchaseRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, Set<String> set) {
        com.amazon.device.iap.internal.util.b.a(f9228a, "sendItemDataRequest");
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray((Collection) set);
            jSONObject.put(com.amazon.a.a.o.b.f8728B, requestId.toString());
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.f8741O, jSONArray);
            jSONObject.put(com.amazon.a.a.o.b.f8735I, PurchasingService.SDK_VERSION);
            bundle.putString("itemDataInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.itemData");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f9228a, "Error in sendItemDataRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, boolean z4) {
        if (requestId == null) {
            requestId = new RequestId();
        }
        com.amazon.device.iap.internal.util.b.a(f9228a, "sendPurchaseUpdatesRequest/sendGetUserData first:" + requestId);
        a(requestId.toString(), true, z4, null);
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        com.amazon.device.iap.internal.util.b.a(f9228a, "sendNotifyPurchaseFulfilled");
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.f8728B, requestId.toString());
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.f8731E, str);
            jSONObject.put("fulfillmentResult", fulfillmentResult);
            jSONObject.put(com.amazon.a.a.o.b.f8735I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseFulfilledInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.purchaseFulfilled");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f9228a, "Error in sendNotifyPurchaseFulfilled.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(Context context, Intent intent) {
        com.amazon.device.iap.internal.util.b.a(f9228a, "handleResponse");
        intent.setComponent(new ComponentName(f9229b, f9230c));
        try {
            String string = intent.getExtras().getString("responseType");
            if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchase")) {
                g(intent);
                return;
            }
            if (string.equalsIgnoreCase("com.amazon.testclient.iap.appUserId")) {
                e(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.itemData")) {
                c(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchaseUpdates")) {
                a(intent);
            }
        } catch (Exception e4) {
            Log.e(f9228a, "Error handling response.", e4);
        }
    }

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(f9229b, f9230c));
        return intent;
    }

    public void a(final Object obj) {
        f.a(obj, "response");
        Context contextB = com.amazon.device.iap.internal.d.f().b();
        final PurchasingListener purchasingListenerA = com.amazon.device.iap.internal.d.f().a();
        if (contextB != null && purchasingListenerA != null) {
            new Handler(contextB.getMainLooper()).post(new Runnable() { // from class: com.amazon.device.iap.internal.c.e.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Object obj2 = obj;
                        if (obj2 instanceof ProductDataResponse) {
                            purchasingListenerA.onProductDataResponse((ProductDataResponse) obj2);
                            return;
                        }
                        if (obj2 instanceof UserDataResponse) {
                            purchasingListenerA.onUserDataResponse((UserDataResponse) obj2);
                            return;
                        }
                        if (obj2 instanceof PurchaseUpdatesResponse) {
                            purchasingListenerA.onPurchaseUpdatesResponse((PurchaseUpdatesResponse) obj2);
                            return;
                        }
                        if (obj2 instanceof PurchaseResponse) {
                            purchasingListenerA.onPurchaseResponse((PurchaseResponse) obj2);
                            return;
                        }
                        com.amazon.device.iap.internal.util.b.b(e.f9228a, "Unknown response type:" + obj.getClass().getName());
                    } catch (Exception e4) {
                        com.amazon.device.iap.internal.util.b.b(e.f9228a, "Error in sendResponse: " + e4);
                    }
                }
            });
            return;
        }
        com.amazon.device.iap.internal.util.b.a(f9228a, "PurchasingListener is not set. Dropping response: " + obj);
    }

    private void a(Intent intent) {
        PurchaseUpdatesResponse purchaseUpdatesResponseB = b(intent);
        if (purchaseUpdatesResponseB.getRequestStatus() == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            String strOptString = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput")).optString(b.as);
            Log.i(f9228a, "Offset for PurchaseUpdatesResponse:" + strOptString);
            com.amazon.device.iap.internal.util.a.a(purchaseUpdatesResponseB.getUserData().getUserId(), strOptString);
        }
        a(purchaseUpdatesResponseB);
    }

    private Product a(String str, JSONObject jSONObject) {
        String str2;
        ProductType productTypeValueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.f8763k));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.f8777y);
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject == JSONObject.NULL) {
            str2 = null;
        } else {
            Currency currency = Currency.getInstance(jSONObjectOptJSONObject.optString("currency"));
            str2 = currency.getSymbol() + jSONObjectOptJSONObject.optString("value");
        }
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.f8745S);
        String strOptString2 = jSONObject.optString(com.amazon.a.a.o.b.f8755c);
        String strOptString3 = jSONObject.optString("smallIconUrl");
        int iOptInt = jSONObject.optInt(com.amazon.a.a.o.b.f8746T, 0);
        return new ProductBuilder().setSku(str).setProductType(productTypeValueOf).setDescription(strOptString2).setPrice(str2).setSmallIconUrl(strOptString3).setTitle(strOptString).setCoinsRewardAmount(iOptInt).setSubscriptionPeriod(jSONObject.isNull(FirebaseAnalytics.Param.TERM) ? null : jSONObject.getString(FirebaseAnalytics.Param.TERM)).setFreeTrialPeriod(jSONObject.isNull(com.amazon.a.a.o.b.f8768p) ? null : jSONObject.getString(com.amazon.a.a.o.b.f8768p)).setPromotions(jSONObject.isNull(com.amazon.a.a.o.b.f8769q) ? null : a.a(jSONObject)).build();
    }

    private void a(String str, String str2, boolean z4) {
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            String strA = com.amazon.device.iap.internal.util.a.a(str2);
            Log.i(f9228a, "send PurchaseUpdates with user id:" + str2 + ";reset flag:" + z4 + ", local cursor:" + strA + ", parsed from old requestId:" + str);
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.f8728B, str.toString());
            if (z4) {
                strA = null;
            }
            jSONObject.put(b.as, strA);
            jSONObject.put(com.amazon.a.a.o.b.f8735I, PurchasingService.SDK_VERSION);
            jSONObject.put("packageName", contextB.getPackageName());
            bundle.putString("purchaseUpdatesInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.purchaseUpdates");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f9228a, "Error in sendPurchaseUpdatesRequest.");
        }
    }

    private Receipt a(JSONObject jSONObject) throws ParseException {
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.f8731E);
        String strOptString2 = jSONObject.optString("sku");
        ProductType productTypeValueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.f8763k));
        String strOptString3 = jSONObject.optString(com.amazon.a.a.o.b.f8743Q);
        DateFormat dateFormat = b.ar;
        Date date = dateFormat.parse(strOptString3);
        String strOptString4 = jSONObject.optString(com.amazon.a.a.o.b.f8757e);
        Date date2 = (strOptString4 == null || strOptString4.length() == 0) ? null : dateFormat.parse(strOptString4);
        String strOptString5 = jSONObject.optString(com.amazon.a.a.o.b.f8744R);
        return new ReceiptBuilder().setReceiptId(strOptString).setSku(strOptString2).setProductType(productTypeValueOf).setPurchaseDate(date).setCancelDate(date2).setDeferredSku(jSONObject.optString(com.amazon.a.a.o.b.f8739M, null)).setDeferredDate((strOptString5 == null || strOptString5.length() == 0) ? null : dateFormat.parse(strOptString5)).setTermSku(jSONObject.optString(com.amazon.a.a.o.b.f8738L, null)).build();
    }
}
