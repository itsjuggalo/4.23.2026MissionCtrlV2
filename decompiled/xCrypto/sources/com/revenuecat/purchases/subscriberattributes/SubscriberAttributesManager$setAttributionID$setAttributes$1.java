package com.revenuecat.purchases.subscriberattributes;

import W2.E;
import W2.t;
import X2.K;
import X2.L;
import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import i3.k;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class SubscriberAttributesManager$setAttributionID$setAttributes$1 extends s implements k {
    final /* synthetic */ String $appUserID;
    final /* synthetic */ SubscriberAttributeKey.AttributionIds $attributionKey;
    final /* synthetic */ String $value;
    final /* synthetic */ SubscriberAttributesManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubscriberAttributesManager$setAttributionID$setAttributes$1(SubscriberAttributeKey.AttributionIds attributionIds, String str, SubscriberAttributesManager subscriberAttributesManager, String str2) {
        super(1);
        this.$attributionKey = attributionIds;
        this.$value = str;
        this.this$0 = subscriberAttributesManager;
        this.$appUserID = str2;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, String>) obj);
        return E.f5463a;
    }

    public final void invoke(Map<String, String> deviceIdentifiers) {
        r.f(deviceIdentifiers, "deviceIdentifiers");
        this.this$0.setAttributes(L.k(K.c(t.a(this.$attributionKey.getBackendKey(), this.$value)), deviceIdentifiers), this.$appUserID);
    }
}
