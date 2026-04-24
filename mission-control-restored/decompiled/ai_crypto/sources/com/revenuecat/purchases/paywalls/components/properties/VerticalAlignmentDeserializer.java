package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;

/* JADX INFO: loaded from: classes2.dex */
public final class VerticalAlignmentDeserializer extends EnumDeserializerWithDefault<VerticalAlignment> {
    public static final VerticalAlignmentDeserializer INSTANCE = new VerticalAlignmentDeserializer();

    private VerticalAlignmentDeserializer() {
        super(VerticalAlignment.TOP, null, 2, null);
    }
}
