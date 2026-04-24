package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;

/* JADX INFO: loaded from: classes3.dex */
public final class StackOverflowDeserializer extends EnumDeserializerWithDefault<StackComponent.Overflow> {
    public static final StackOverflowDeserializer INSTANCE = new StackOverflowDeserializer();

    private StackOverflowDeserializer() {
        super(StackComponent.Overflow.NONE, null, 2, null);
    }
}
