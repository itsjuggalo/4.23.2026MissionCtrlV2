package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;

/* JADX INFO: loaded from: classes3.dex */
final class DestinationSurrogateDeserializer extends EnumDeserializerWithDefault<DestinationSurrogate> {
    public static final DestinationSurrogateDeserializer INSTANCE = new DestinationSurrogateDeserializer();

    private DestinationSurrogateDeserializer() {
        super(DestinationSurrogate.unknown, null, 2, null);
    }
}
