package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;

/* JADX INFO: loaded from: classes3.dex */
public final class TwoDimensionalAlignmentDeserializer extends EnumDeserializerWithDefault<TwoDimensionalAlignment> {
    public static final TwoDimensionalAlignmentDeserializer INSTANCE = new TwoDimensionalAlignmentDeserializer();

    private TwoDimensionalAlignmentDeserializer() {
        super(TwoDimensionalAlignment.TOP, null, 2, null);
    }
}
