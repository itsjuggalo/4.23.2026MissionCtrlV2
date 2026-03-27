package com.revenuecat.purchases.paywalls.components.properties;

import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import kotlin.jvm.internal.r;
import n6.b;
import p6.e;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
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

    @Override // n6.b, n6.h, n6.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // n6.h
    public void serialize(f encoder, CornerRadiuses value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
    }

    @Override // n6.a
    public CornerRadiuses deserialize(q6.e decoder) {
        r.f(decoder, "decoder");
        return (CornerRadiuses) decoder.l(serializer);
    }
}
