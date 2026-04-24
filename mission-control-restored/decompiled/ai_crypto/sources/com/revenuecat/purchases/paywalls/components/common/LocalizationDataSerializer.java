package com.revenuecat.purchases.paywalls.components.common;

import com.revenuecat.purchases.paywalls.components.common.LocalizationData;
import kotlin.jvm.internal.r;
import n6.b;
import n6.g;
import p6.c;
import p6.e;
import p6.h;
import q6.f;

/* JADX INFO: loaded from: classes2.dex */
final class LocalizationDataSerializer implements b {
    public static final LocalizationDataSerializer INSTANCE = new LocalizationDataSerializer();
    private static final e descriptor = h.d("LocalizationData", c.a.f22061a, new e[0], null, 8, null);

    private LocalizationDataSerializer() {
    }

    public static /* synthetic */ void getDescriptor$annotations() {
    }

    @Override // n6.b, n6.h, n6.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // n6.a
    public LocalizationData deserialize(q6.e decoder) {
        r.f(decoder, "decoder");
        try {
            return (LocalizationData) decoder.l(LocalizationData.Text.Companion.serializer());
        } catch (g unused) {
            return (LocalizationData) decoder.l(LocalizationData.Image.Companion.serializer());
        }
    }

    @Override // n6.h
    public void serialize(f encoder, LocalizationData value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        throw new IllegalStateException("Serialization is not implemented as it is not (yet) needed.");
    }
}
