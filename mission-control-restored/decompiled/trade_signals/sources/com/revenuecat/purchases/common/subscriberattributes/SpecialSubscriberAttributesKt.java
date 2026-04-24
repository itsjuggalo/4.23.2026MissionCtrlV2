package com.revenuecat.purchases.common.subscriberattributes;

import com.revenuecat.purchases.common.subscriberattributes.SubscriberAttributeKey;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"getSubscriberAttributeKey", "Lcom/revenuecat/purchases/common/subscriberattributes/SubscriberAttributeKey;", "", "purchases_defaultsRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class SpecialSubscriberAttributesKt {
    public static final SubscriberAttributeKey getSubscriberAttributeKey(String str) {
        AbstractC2304t.f(str, "<this>");
        return AbstractC2304t.b(str, ReservedSubscriberAttribute.EMAIL.getValue()) ? SubscriberAttributeKey.Email.INSTANCE : AbstractC2304t.b(str, ReservedSubscriberAttribute.DISPLAY_NAME.getValue()) ? SubscriberAttributeKey.DisplayName.INSTANCE : AbstractC2304t.b(str, ReservedSubscriberAttribute.PHONE_NUMBER.getValue()) ? SubscriberAttributeKey.PhoneNumber.INSTANCE : AbstractC2304t.b(str, ReservedSubscriberAttribute.FCM_TOKENS.getValue()) ? SubscriberAttributeKey.FCMTokens.INSTANCE : new SubscriberAttributeKey.Custom(str);
    }
}
