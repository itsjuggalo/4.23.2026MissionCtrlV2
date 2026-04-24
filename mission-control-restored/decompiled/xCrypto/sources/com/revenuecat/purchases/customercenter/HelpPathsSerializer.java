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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class HelpPathsSerializer implements b {
    public static final HelpPathsSerializer INSTANCE = new HelpPathsSerializer();
    private static final e descriptor = a.g(CustomerCenterConfigData.HelpPath.Companion.serializer()).getDescriptor();

    private HelpPathsSerializer() {
    }

    @Override // F3.b, F3.h, F3.a
    public e getDescriptor() {
        return descriptor;
    }

    @Override // F3.a
    public List<CustomerCenterConfigData.HelpPath> deserialize(I3.e decoder) {
        r.f(decoder, "decoder");
        ArrayList arrayList = new ArrayList();
        g gVar = decoder instanceof g ? (g) decoder : null;
        if (gVar == null) {
            throw new IllegalStateException("Can be deserialized only by JSON");
        }
        Iterator<h> it = i.m(gVar.k()).iterator();
        while (it.hasNext()) {
            try {
                arrayList.add(gVar.b().c(CustomerCenterConfigData.HelpPath.Companion.serializer(), it.next()));
            } catch (IllegalArgumentException e4) {
                LogLevel logLevel = LogLevel.DEBUG;
                LogHandler currentLogHandler = LogWrapperKt.getCurrentLogHandler();
                if (Config.INSTANCE.getLogLevel().compareTo(logLevel) <= 0) {
                    currentLogHandler.d("[Purchases] - " + logLevel.name(), "Issue deserializing CustomerCenter HelpPath. Ignoring. Error: " + e4);
                }
            }
        }
        return arrayList;
    }

    @Override // F3.h
    public void serialize(f encoder, List<CustomerCenterConfigData.HelpPath> value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        a.g(CustomerCenterConfigData.HelpPath.Companion.serializer()).serialize(encoder, value);
    }
}
