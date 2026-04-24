package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import F3.g;
import H3.c;
import H3.e;
import H3.h;
import I3.f;
import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
final class LocalizationDataSerializer implements b {
    public static final LocalizationDataSerializer INSTANCE = new LocalizationDataSerializer();
    private static final e descriptor = h.d("LocalizationData", c.a.f733a, new e[0], null, 8, null);

    private LocalizationDataSerializer() {
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.a
    public LocalizationData deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        try {
            return (LocalizationData) decoder.p(LocalizationData.Text.Companion.serializer());
        } catch (g unused) {
            return (LocalizationData) decoder.p(LocalizationData.Image.Companion.serializer());
        }
    }

    @Override // F3.h
    public void serialize(f encoder, LocalizationData value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.");
    }
}
