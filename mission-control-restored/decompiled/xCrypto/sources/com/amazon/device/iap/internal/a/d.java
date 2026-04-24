package com.amazon.device.iap.internal.a;

import android.content.Context;
import android.content.Intent;
import com.amazon.device.iap.model.FulfillmentResult;
import com.amazon.device.iap.model.RequestId;
import com.amazon.device.iap.model.UserDataRequest;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class d implements com.amazon.device.iap.internal.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f9119a = "d";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f9120b = "response_type";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f9121c = "requestId";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String f9122d = "purchase_response";

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, UserDataRequest userDataRequest) {
        com.amazon.device.iap.internal.util.b.a(f9119a, "sendGetUserData");
        new com.amazon.device.iap.internal.a.c.a(requestId, userDataRequest).e();
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str) {
        com.amazon.device.iap.internal.util.b.a(f9119a, "sendPurchaseRequest");
        new com.amazon.device.iap.internal.a.e.d(requestId, str).e();
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, Set<String> set) {
        com.amazon.device.iap.internal.util.b.a(f9119a, "sendGetProductDataRequest");
        new com.amazon.device.iap.internal.a.a.d(requestId, set).e();
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, boolean z4) {
        com.amazon.device.iap.internal.util.b.a(f9119a, "sendGetPurchaseUpdates");
        new com.amazon.device.iap.internal.a.b.a(requestId, z4).e();
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(RequestId requestId, String str, FulfillmentResult fulfillmentResult) {
        com.amazon.device.iap.internal.util.b.a(f9119a, "sendNotifyFulfillment");
        new com.amazon.device.iap.internal.a.d.a(requestId, str, fulfillmentResult).e();
    }

    @Override // com.amazon.device.iap.internal.e
    public void a(Context context, Intent intent) {
        String str = f9119a;
        com.amazon.device.iap.internal.util.b.a(str, "handleResponse");
        String stringExtra = intent.getStringExtra(f9120b);
        if (stringExtra == null) {
            com.amazon.device.iap.internal.util.b.a(str, "Invalid response type: null");
            return;
        }
        com.amazon.device.iap.internal.util.b.a(str, "Found response type: " + stringExtra);
        if (f9122d.equals(stringExtra)) {
            new com.amazon.device.iap.internal.a.f.d(RequestId.fromString(intent.getStringExtra("requestId"))).e();
        }
    }
}
