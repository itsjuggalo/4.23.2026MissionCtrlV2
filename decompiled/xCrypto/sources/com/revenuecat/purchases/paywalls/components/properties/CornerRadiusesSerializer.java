package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import H3.e;
import I3.f;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class CornerRadiusesSerializer implements b {
    public static final CornerRadiusesSerializer INSTANCE = new CornerRadiusesSerializer();
    private static final e descriptor;
    private static final b serializer;

    static {
        b bVarSerializer = CornerRadiuses.Dp.Companion.serializer();
        serializer = bVarSerializer;
        descriptor = bVarSerializer.getDescriptor();
    }

    private CornerRadiusesSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CornerRadiuses value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
    }

    @Override // F3.a
    public CornerRadiuses deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        return (CornerRadiuses) decoder.p(serializer);
    }
}
