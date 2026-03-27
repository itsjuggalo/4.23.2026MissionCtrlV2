package com.revenuecat.purchases.paywalls.components;

import com.revenuecat.purchases.utils.serializers.EnumDeserializerWithDefault;

/* JADX INFO: loaded from: classes2.dex */
final class ActionTypeSurrogateDeserializer extends EnumDeserializerWithDefault<ActionTypeSurrogate> {
    public static final ActionTypeSurrogateDeserializer INSTANCE = new ActionTypeSurrogateDeserializer();

    /* JADX WARN: Multi-variable type inference failed */
    private ActionTypeSurrogateDeserializer() {
        super(ActionTypeSurrogate.unknown, null, 2, 0 == true ? 1 : 0);
    }
}
