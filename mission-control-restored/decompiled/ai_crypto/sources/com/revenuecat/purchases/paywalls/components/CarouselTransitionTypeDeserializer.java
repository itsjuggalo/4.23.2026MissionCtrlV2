package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;

/* JADX INFO: loaded from: classes2.dex */
public final class CarouselTransitionTypeDeserializer extends EnumDeserializerWithDefault<CarouselComponent.AutoAdvancePages.TransitionType> {
    public static final CarouselTransitionTypeDeserializer INSTANCE = new CarouselTransitionTypeDeserializer();

    private CarouselTransitionTypeDeserializer() {
        super(CarouselComponent.AutoAdvancePages.TransitionType.SLIDE, null, 2, null);
    }
}
