package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;

/* JADX INFO: loaded from: classes2.dex */
public final class FlexDistributionDeserializer extends EnumDeserializerWithDefault<FlexDistribution> {
    public static final FlexDistributionDeserializer INSTANCE = new FlexDistributionDeserializer();

    private FlexDistributionDeserializer() {
        super(FlexDistribution.START, null, 2, null);
    }
}
