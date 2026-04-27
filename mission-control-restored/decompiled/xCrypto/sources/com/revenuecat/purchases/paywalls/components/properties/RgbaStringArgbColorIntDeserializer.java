package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import G3.a;
import H3.e;
import I3.f;
import com.revenuecat.purchases.paywalls.ColorUtilsKt;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
final class RgbaStringArgbColorIntDeserializer implements b {
    public static final RgbaStringArgbColorIntDeserializer INSTANCE = new RgbaStringArgbColorIntDeserializer();
    private static final e descriptor = a.A(q.f13431a).getDescriptor();

    private RgbaStringArgbColorIntDeserializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public /* bridge */ /* synthetic */ void serialize(f fVar, Object obj) {
        serialize(fVar, ((Number) obj).intValue());
    }

    @Override // F3.a
    public Integer deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        return Integer.valueOf(ColorUtilsKt.parseRGBAColor(decoder.q()));
    }

    public void serialize(f encoder, int i4) {
        r.f(encoder, "encoder");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.");
    }
}
