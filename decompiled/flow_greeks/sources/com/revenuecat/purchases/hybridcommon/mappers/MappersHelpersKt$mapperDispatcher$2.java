package com.revenuecat.purchases.hybridcommon.mappers;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.v;
import ng.c1;
import ng.k0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lng/k0;", "invoke", "()Lng/k0;", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class MappersHelpersKt$mapperDispatcher$2 extends v implements Function0 {
    public static final MappersHelpersKt$mapperDispatcher$2 INSTANCE = new MappersHelpersKt$mapperDispatcher$2();

    public MappersHelpersKt$mapperDispatcher$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final k0 invoke() {
        k0 overrideMapperDispatcher = MappersHelpersKt.getOverrideMapperDispatcher();
        return overrideMapperDispatcher == null ? c1.a() : overrideMapperDispatcher;
    }
}
