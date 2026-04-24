package com.revenuecat.purchases.hybridcommon.mappers;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;
import t3.C1803a0;
import t3.I;

/* JADX INFO: loaded from: classes3.dex */
public final class MappersHelpersKt$mapperDispatcher$2 extends s implements Function0 {
    public static final MappersHelpersKt$mapperDispatcher$2 INSTANCE = new MappersHelpersKt$mapperDispatcher$2();

    public MappersHelpersKt$mapperDispatcher$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final I invoke() {
        I overrideMapperDispatcher = MappersHelpersKt.getOverrideMapperDispatcher();
        return overrideMapperDispatcher == null ? C1803a0.a() : overrideMapperDispatcher;
    }
}
