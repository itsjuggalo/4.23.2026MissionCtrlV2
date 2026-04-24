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
    private static final String f14524a = "e";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f14525b = "com.amazon.sdktestclient";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f14526c = "com.amazon.sdktestclient.command.CommandBroker";

    private Intent a(String str) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(f14525b, f14526c));
        return intent;
    }

    private PurchaseUpdatesResponse b(Intent intent) {
        UserData userDataBuild;
        ArrayList arrayList;
        Exception e8;
        RequestId requestIdFromString;
        boolean zOptBoolean;
        JSONObject jSONObject;
        PurchaseUpdatesResponse.RequestStatus requestStatusValueOf = PurchaseUpdatesResponse.RequestStatus.FAILED;
        ArrayList arrayList2 = null;
        boolean z7 = false;
        z7 = false;
        try {
            jSONObject = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.f14024B));
            try {
                requestStatusValueOf = PurchaseUpdatesResponse.RequestStatus.valueOf(jSONObject.optString("status"));
                zOptBoolean = jSONObject.optBoolean("isMore");
                try {
                    userDataBuild = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.f14061m)).build();
                } catch (Exception e9) {
                    e = e9;
                    userDataBuild = null;
                    arrayList = null;
                }
            } catch (Exception e10) {
                userDataBuild = null;
                arrayList = null;
                e8 = e10;
            }
            try {
            } catch (Exception e11) {
                e = e11;
                arrayList = null;
                e8 = e;
                z7 = zOptBoolean;
                Log.e(f14524a, "Error parsing purchase updates output", e8);
                zOptBoolean = z7;
                arrayList2 = arrayList;
                return new PurchaseUpdatesResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusValueOf).setUserData(userDataBuild).setReceipts(arrayList2).setHasMore(zOptBoolean).build();
            }
        } catch (Exception e12) {
            userDataBuild = null;
            arrayList = null;
            e8 = e12;
            requestIdFromString = null;
        }
        if (requestStatusValueOf == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            arrayList = new ArrayList();
            try {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(com.amazon.a.a.o.b.f14029G);
                if (jSONArrayOptJSONArray != null) {
                    for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i8);
                        try {
                            arrayList.add(a(jSONObjectOptJSONObject));
                        } catch (Exception unused) {
                            Log.e(f14524a, "Failed to parse receipt from json:" + jSONObjectOptJSONObject);
                        }
                    }
                }
            } catch (Exception e13) {
                e8 = e13;
                z7 = zOptBoolean;
                Log.e(f14524a, "Error parsing purchase updates output", e8);
                zOptBoolean = z7;
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
        Exception e8;
        RequestId requestIdFromString;
        ProductDataResponse.RequestStatus requestStatusValueOf;
        ProductDataResponse.RequestStatus requestStatus = ProductDataResponse.RequestStatus.FAILED;
        LinkedHashSet linkedHashSet2 = null;
        try {
            JSONObject jSONObject = new JSONObject(intent.getStringExtra("itemDataOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.f14024B));
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
                                    for (int i8 = 0; i8 < jSONArrayOptJSONArray.length(); i8++) {
                                        linkedHashSet3.add(jSONArrayOptJSONArray.getString(i8));
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
                            } catch (Exception e9) {
                                e8 = e9;
                                linkedHashSet = linkedHashSet3;
                                requestStatus = requestStatusValueOf;
                                Log.e(f14524a, "Error parsing item data output", e8);
                                requestStatusValueOf = requestStatus;
                                linkedHashSet2 = linkedHashSet;
                            }
                        } catch (Exception e10) {
                            map = null;
                            e8 = e10;
                        }
                    } catch (Exception e11) {
                        linkedHashSet = null;
                        map = null;
                        e8 = e11;
                    }
                } else {
                    map = null;
                }
            } catch (Exception e12) {
                map = null;
                e8 = e12;
                linkedHashSet = null;
            }
        } catch (Exception e13) {
            linkedHashSet = null;
            map = null;
            e8 = e13;
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
        } catch (JSONException e8) {
            Log.e(f14524a, "Unable to parse request data: " + stringExtra, e8);
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
            Log.e(f14524a, "No Userid found in userDataResponse" + userDataResponseF);
            a(new PurchaseUpdatesResponseBuilder().setRequestId(requestId).setRequestStatus(PurchaseUpdatesResponse.RequestStatus.FAILED).setUserData(userDataResponseF.getUserData()).setReceipts(new ArrayList()).setHasMore(false).build());
            return;
        }
        Log.i(f14524a, "sendGetPurchaseUpdates with user id" + userDataResponseF.getUserData().getUserId());
        a(requestId.toString(), userDataResponseF.getUserData().getUserId(), jSONObject.optBoolean(b.au, true));
    }

    private UserDataResponse f(Intent intent) {
        RequestId requestIdFromString;
        JSONObject jSONObject;
        UserDataResponse.RequestStatus requestStatusValueOf = UserDataResponse.RequestStatus.FAILED;
        UserData userDataBuild = null;
        try {
            jSONObject = new JSONObject(intent.getStringExtra("userOutput"));
            requestIdFromString = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.f14024B));
        } catch (Exception e8) {
            e = e8;
            requestIdFromString = null;
        }
        try {
            requestStatusValueOf = UserDataResponse.RequestStatus.valueOf(jSONObject.optString("status"));
            if (requestStatusValueOf == UserDataResponse.RequestStatus.SUCCESSFUL) {
                String strOptString = jSONObject.optString("userId");
                userDataBuild = new UserDataBuilder().setUserId(strOptString).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.f14061m)).setLWAConsentStatus(jSONObject.optString("UserDataResponse.LWAConsentStatus")).build();
            }
        } catch (Exception e9) {
            e = e9;
            Log.e(f14524a, "Error parsing userid output", e);
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
            requestIdFromString = RequestId.fromString(jSONObject.optString(com.amazon.a.a.o.b.f14024B));
            try {
                userDataBuild = new UserDataBuilder().setUserId(jSONObject.optString("userId")).setMarketplace(jSONObject.optString(com.amazon.a.a.o.b.f14061m)).build();
            } catch (Exception e8) {
                e = e8;
                userDataBuild = null;
            }
            try {
                requestStatusSafeValueOf = PurchaseResponse.RequestStatus.safeValueOf(jSONObject.optString("purchaseStatus"));
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.f14026D);
                if (jSONObjectOptJSONObject != null) {
                    receiptA = a(jSONObjectOptJSONObject);
                }
            } catch (Exception e9) {
                e = e9;
                Log.e(f14524a, "Error parsing purchase output", e);
            }
        } catch (Exception e10) {
            e = e10;
            requestIdFromString = null;
            userDataBuild = null;
        }
        return new PurchaseResponseBuilder().setRequestId(requestIdFromString).setRequestStatus(requestStatusSafeValueOf).setUserData(userDataBuild).setReceipt(receiptA).build();
    }

    private Product a(String str, JSONObject jSONObject) {
        String str2;
        ProductType productTypeValueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.f14059k));
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.amazon.a.a.o.b.f14073y);
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject == JSONObject.NULL) {
            str2 = null;
        } else {
            Currency currency = Currency.getInstance(jSONObjectOptJSONObject.optString("currency"));
            str2 = currency.getSymbol() + jSONObjectOptJSONObject.optString("value");
        }
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.f14041S);
        String strOptString2 = jSONObject.optString(com.amazon.a.a.o.b.f14051c);
        String strOptString3 = jSONObject.optString("smallIconUrl");
        int iOptInt = jSONObject.optInt(com.amazon.a.a.o.b.f14042T, 0);
        return new ProductBuilder().setSku(str).setProductType(productTypeValueOf).setDescription(strOptString2).setPrice(str2).setSmallIconUrl(strOptString3).setTitle(strOptString).setCoinsRewardAmount(iOptInt).setSubscriptionPeriod(jSONObject.isNull(FirebaseAnalytics.Param.TERM) ? null : jSONObject.getString(FirebaseAnalytics.Param.TERM)).setFreeTrialPeriod(jSONObject.isNull(com.amazon.a.a.o.b.f14064p) ? null : jSONObject.getString(com.amazon.a.a.o.b.f14064p)).setPromotions(jSONObject.isNull(com.amazon.a.a.o.b.f14065q) ? null : a.a(jSONObject)).build();
    }

    private Receipt a(JSONObject jSONObject) throws ParseException {
        String strOptString = jSONObject.optString(com.amazon.a.a.o.b.f14027E);
        String strOptString2 = jSONObject.optString("sku");
        ProductType productTypeValueOf = ProductType.valueOf(jSONObject.optString(com.amazon.a.a.o.b.f14059k));
        String strOptString3 = jSONObject.optString(com.amazon.a.a.o.b.f14039Q);
        DateFormat dateFormat = b.ar;
        Date date = dateFormat.parse(strOptString3);
        String strOptString4 = jSONObject.optString(com.amazon.a.a.o.b.f14053e);
        Date date2 = (strOptString4 == null || strOptString4.length() == 0) ? null : dateFormat.parse(strOptString4);
        String strOptString5 = jSONObject.optString(com.amazon.a.a.o.b.f14040R);
        return new ReceiptBuilder().setReceiptId(strOptString).setSku(strOptString2).setProductType(productTypeValueOf).setPurchaseDate(date).setCancelDate(date2).setDeferredSku(jSONObject.optString(com.amazon.a.a.o.b.f14035M, null)).setDeferredDate((strOptString5 == null || strOptString5.length() == 0) ? null : dateFormat.parse(strOptString5)).setTermSku(jSONObject.optString(com.amazon.a.a.o.b.f14034L, null)).build();
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(Context context, Intent intent) {
        com.amazon.device.iap.internal.util.b.a(f14524a, "handleResponse");
        intent.setComponent(new ComponentName(f14525b, f14526c));
        try {
            String string = intent.getExtras().getString("responseType");
            if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchase")) {
                g(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.appUserId")) {
                e(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.itemData")) {
                c(intent);
            } else if (string.equalsIgnoreCase("com.amazon.testclient.iap.purchaseUpdates")) {
                a(intent);
            }
        } catch (Exception e8) {
            Log.e(f14524a, "Error handling response.", e8);
        }
    }

    private void a(Intent intent) {
        PurchaseUpdatesResponse purchaseUpdatesResponseB = b(intent);
        if (purchaseUpdatesResponseB.getRequestStatus() == PurchaseUpdatesResponse.RequestStatus.SUCCESSFUL) {
            String strOptString = new JSONObject(intent.getStringExtra("purchaseUpdatesOutput")).optString(b.as);
            Log.i(f14524a, "Offset for PurchaseUpdatesResponse:" + strOptString);
            com.amazon.device.iap.internal.util.a.a(purchaseUpdatesResponseB.getUserData().getUserId(), strOptString);
        }
        a(purchaseUpdatesResponseB);
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, UserDataRequest userDataRequest) {
        com.amazon.device.iap.internal.util.b.a(f14524a, "sendGetUserDataRequest");
        a(requestId.toString(), false, false, userDataRequest);
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str) {
        com.amazon.device.iap.internal.util.b.a(f14524a, "sendPurchaseRequest");
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            boolean zD = com.amazon.device.iap.internal.d.f().d();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sku", str);
            jSONObject.put(com.amazon.a.a.o.b.ac, zD);
            jSONObject.put(com.amazon.a.a.o.b.f14024B, requestId.toString());
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.f14031I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.purchase");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f14524a, "Error in sendPurchaseRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        com.amazon.device.iap.internal.util.b.a(f14524a, "sendNotifyPurchaseFulfilled");
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.f14024B, requestId.toString());
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.f14027E, str);
            jSONObject.put("fulfillmentResult", fulfillmentResult);
            jSONObject.put(com.amazon.a.a.o.b.f14031I, PurchasingService.SDK_VERSION);
            bundle.putString("purchaseFulfilledInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.purchaseFulfilled");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f14524a, "Error in sendNotifyPurchaseFulfilled.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, Set<String> set) {
        com.amazon.device.iap.internal.util.b.a(f14524a, "sendItemDataRequest");
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray((Collection) set);
            jSONObject.put(com.amazon.a.a.o.b.f14024B, requestId.toString());
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.f14037O, jSONArray);
            jSONObject.put(com.amazon.a.a.o.b.f14031I, PurchasingService.SDK_VERSION);
            bundle.putString("itemDataInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.itemData");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f14524a, "Error in sendItemDataRequest.");
        }
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, boolean z7) {
        if (requestId == null) {
            requestId = new RequestId();
        }
        com.amazon.device.iap.internal.util.b.a(f14524a, "sendPurchaseUpdatesRequest/sendGetUserData first:" + requestId);
        a(requestId.toString(), true, z7, null);
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
                        } else if (obj2 instanceof UserDataResponse) {
                            purchasingListenerA.onUserDataResponse((UserDataResponse) obj2);
                        } else if (obj2 instanceof PurchaseUpdatesResponse) {
                            purchasingListenerA.onPurchaseUpdatesResponse((PurchaseUpdatesResponse) obj2);
                        } else if (obj2 instanceof PurchaseResponse) {
                            purchasingListenerA.onPurchaseResponse((PurchaseResponse) obj2);
                        } else {
                            com.amazon.device.iap.internal.util.b.b(e.f14524a, "Unknown response type:" + obj.getClass().getName());
                        }
                    } catch (Exception e8) {
                        com.amazon.device.iap.internal.util.b.b(e.f14524a, "Error in sendResponse: " + e8);
                    }
                }
            });
            return;
        }
        com.amazon.device.iap.internal.util.b.a(f14524a, "PurchasingListener is not set. Dropping response: " + obj);
    }

    private void a(String str, String str2, boolean z7) {
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            String strA = com.amazon.device.iap.internal.util.a.a(str2);
            Log.i(f14524a, "send PurchaseUpdates with user id:" + str2 + ";reset flag:" + z7 + ", local cursor:" + strA + ", parsed from old requestId:" + str);
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.f14024B, str.toString());
            if (z7) {
                strA = null;
            }
            jSONObject.put(b.as, strA);
            jSONObject.put(com.amazon.a.a.o.b.f14031I, PurchasingService.SDK_VERSION);
            jSONObject.put("packageName", contextB.getPackageName());
            bundle.putString("purchaseUpdatesInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.purchaseUpdates");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f14524a, "Error in sendPurchaseUpdatesRequest.");
        }
    }

    private void a(String str, boolean z7, boolean z8, UserDataRequest userDataRequest) {
        try {
            Context contextB = com.amazon.device.iap.internal.d.f().b();
            Bundle bundle = new Bundle();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(com.amazon.a.a.o.b.f14024B, str);
            jSONObject.put("packageName", contextB.getPackageName());
            jSONObject.put(com.amazon.a.a.o.b.f14031I, PurchasingService.SDK_VERSION);
            jSONObject.put(b.at, z7);
            jSONObject.put(b.au, z8);
            if (userDataRequest != null) {
                jSONObject.put("UserDataRequest.fetchLWAConsentStatus", userDataRequest.getFetchLWAConsentStatus());
            }
            bundle.putString("userInput", jSONObject.toString());
            Intent intentA = a("com.amazon.testclient.iap.appUserId");
            intentA.addFlags(268435456);
            intentA.putExtras(bundle);
            contextB.startService(intentA);
        } catch (JSONException unused) {
            com.amazon.device.iap.internal.util.b.b(f14524a, "Error in sendGetUserDataRequest.");
        }
    }
}
