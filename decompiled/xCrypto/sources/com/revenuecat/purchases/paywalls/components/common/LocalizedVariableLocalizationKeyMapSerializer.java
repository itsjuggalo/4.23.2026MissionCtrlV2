package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import G3.a;
import H3.e;
import I3.f;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class LocalizedVariableLocalizationKeyMapSerializer implements b {
    public static final LocalizedVariableLocalizationKeyMapSerializer INSTANCE = new LocalizedVariableLocalizationKeyMapSerializer();
    private static final b delegate;
    private static final e descriptor;

    static {
        b bVarI = a.i(LocaleId.Companion.serializer(), VariableLocalizationKeyMapSerializer.INSTANCE);
        delegate = bVarI;
        descriptor = bVarI.getDescriptor();
    }

    private LocalizedVariableLocalizationKeyMapSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Map<LocaleId, ? extends Map<VariableLocalizationKey, String>> value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
    }

    @Override // F3.a
    public Map<LocaleId, Map<VariableLocalizationKey, String>> deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        return (Map) delegate.deserialize(decoder);
    }
}
