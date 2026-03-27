package com.revenuecat.purchases.hybridcommon.mappers;

import Y6.C0994a0;
import Y6.I;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2306v;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"LY6/I;", "invoke", "()LY6/I;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class MappersHelpersKt$mapperDispatcher$2 extends AbstractC2306v implements Function0 {
    public static final MappersHelpersKt$mapperDispatcher$2 INSTANCE = new MappersHelpersKt$mapperDispatcher$2();

    public MappersHelpersKt$mapperDispatcher$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final I invoke() {
        I overrideMapperDispatcher = MappersHelpersKt.getOverrideMapperDispatcher();
        return overrideMapperDispatcher == null ? C0994a0.a() : overrideMapperDispatcher;
    }
}
