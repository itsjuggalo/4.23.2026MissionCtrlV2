package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import G3.a;
import H3.e;
import I3.f;
import com.revenuecat.purchases.InternalRevenueCatAPI;
import com.revenuecat.purchases.utils.MapExtensionsKt;
import i3.k;
import java.util.Locale;
import java.util.Map;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
@InternalRevenueCatAPI
public final class VariableLocalizationKeyMapSerializer implements b {
    public static final VariableLocalizationKeyMapSerializer INSTANCE = new VariableLocalizationKeyMapSerializer();
    private static final b delegate;
    private static final e descriptor;

    /* JADX INFO: renamed from: com.revenuecat.purchases.paywalls.components.common.VariableLocalizationKeyMapSerializer$deserialize$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // i3.k
        public final VariableLocalizationKey invoke(Map.Entry<String, String> entry) {
            r.f(entry, "<name for destructuring parameter 0>");
            try {
                String upperCase = entry.getKey().toUpperCase(Locale.ROOT);
                r.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                return VariableLocalizationKey.valueOf(upperCase);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
    }

    static {
        J j4 = J.f13414a;
        b bVarI = a.i(a.D(j4), a.D(j4));
        delegate = bVarI;
        descriptor = bVarI.getDescriptor();
    }

    private VariableLocalizationKeyMapSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Map<VariableLocalizationKey, String> value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
    }

    @Override // F3.a
    public Map<VariableLocalizationKey, String> deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        return MapExtensionsKt.mapNotNullKeys((Map) decoder.p(delegate), AnonymousClass1.INSTANCE);
    }
}
