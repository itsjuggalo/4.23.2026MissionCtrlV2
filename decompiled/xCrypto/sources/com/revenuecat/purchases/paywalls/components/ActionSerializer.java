package com.revenuecat.purchases.paywalls.components;

import F3.b;
import H3.e;
import I3.f;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
final class ActionSerializer implements b {
    public static final ActionSerializer INSTANCE = new ActionSerializer();
    private static final e descriptor = ActionSurrogate.Companion.serializer().getDescriptor();

    private ActionSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.a
    public ButtonComponent.Action deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        return ((ActionSurrogate) decoder.p(ActionSurrogate.Companion.serializer())).toAction();
    }

    @Override // F3.h
    public void serialize(f encoder, ButtonComponent.Action value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        encoder.z(ActionSurrogate.Companion.serializer(), new ActionSurrogate(value));
    }
}
