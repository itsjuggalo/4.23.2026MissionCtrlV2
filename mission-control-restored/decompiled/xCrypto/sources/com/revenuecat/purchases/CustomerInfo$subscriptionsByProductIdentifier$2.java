package com.revenuecat.purchases;

import com.revenuecat.purchases.common.CustomerInfoFactory;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerInfo$subscriptionsByProductIdentifier$2 extends s implements Function0 {
    final /* synthetic */ CustomerInfo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerInfo$subscriptionsByProductIdentifier$2(CustomerInfo customerInfo) {
        super(0);
        this.this$0 = customerInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Map<String, SubscriptionInfo> invoke() {
        CustomerInfoFactory customerInfoFactory = CustomerInfoFactory.INSTANCE;
        JSONObject subscriberJSONObject = this.this$0.subscriberJSONObject;
        r.e(subscriberJSONObject, "subscriberJSONObject");
        return customerInfoFactory.parseSubscriptionInfos(subscriberJSONObject, this.this$0.getRequestDate());
    }
}
