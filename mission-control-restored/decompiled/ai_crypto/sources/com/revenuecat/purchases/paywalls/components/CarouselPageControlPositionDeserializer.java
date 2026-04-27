package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;

/* JADX INFO: loaded from: classes2.dex */
public final class CarouselPageControlPositionDeserializer extends EnumDeserializerWithDefault<CarouselComponent.PageControl.Position> {
    public static final CarouselPageControlPositionDeserializer INSTANCE = new CarouselPageControlPositionDeserializer();

    private CarouselPageControlPositionDeserializer() {
        super(CarouselComponent.PageControl.Position.BOTTOM, null, 2, null);
    }
}
