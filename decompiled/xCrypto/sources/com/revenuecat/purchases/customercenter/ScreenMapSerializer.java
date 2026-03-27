package com.revenuecat.purchases.customercenter;

import F3.b;
import G3.a;
import H3.e;
import I3.f;
import K3.g;
import K3.h;
import K3.i;
import com.revenuecat.purchases.LogHandler;
import com.revenuecat.purchases.LogLevel;
import com.revenuecat.purchases.common.Config;
import com.revenuecat.purchases.common.LogWrapperKt;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class ScreenMapSerializer implements b {
    public static final ScreenMapSerializer INSTANCE = new ScreenMapSerializer();
    private static final e descriptor = a.i(CustomerCenterConfigData.Screen.ScreenType.Companion.serializer(), CustomerCenterConfigData.Screen.Companion.serializer()).getDescriptor();

    private ScreenMapSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.a
    public Map<CustomerCenterConfigData.Screen.ScreenType, CustomerCenterConfigData.Screen> deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        g gVar = decoder instanceof g ? (g) decoder : null;
        if (gVar == null) {
            throw new IllegalStateException("Can be deserialized only by JSON");
        }
        for (Map.Entry<String, h> entry : i.n(gVar.k()).entrySet()) {
            String key = entry.getKey();
            try {
                linkedHashMap.put(CustomerCenterConfigData.Screen.ScreenType.valueOf(key), gVar.b().c(CustomerCenterConfigData.Screen.Companion.serializer(), entry.getValue()));
            } catch (IllegalArgumentException unused) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Unknown CustomerCenter ScreenType: " + key + ". Ignoring.");
                }
            }
        }
        return linkedHashMap;
    }

    @Override // F3.h
    public void serialize(f encoder, Map<CustomerCenterConfigData.Screen.ScreenType, CustomerCenterConfigData.Screen> value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        a.i(CustomerCenterConfigData.Screen.ScreenType.Companion.serializer(), CustomerCenterConfigData.Screen.Companion.serializer()).serialize(encoder, value);
    }
}
