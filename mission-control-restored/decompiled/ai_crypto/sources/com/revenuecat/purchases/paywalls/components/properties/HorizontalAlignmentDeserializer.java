package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;

/* JADX INFO: loaded from: classes2.dex */
public final class HorizontalAlignmentDeserializer extends EnumDeserializerWithDefault<HorizontalAlignment> {
    public static final HorizontalAlignmentDeserializer INSTANCE = new HorizontalAlignmentDeserializer();

    private HorizontalAlignmentDeserializer() {
        super(HorizontalAlignment.LEADING, null, 2, null);
    }
}
