package com.revenuecat.purchases.utils.serializers;

import H3.a;
import W2.E;
import i3.k;
import kotlin.jvm.internal.J;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class SealedDeserializerWithDefault$descriptor$1 extends s implements k {
    final /* synthetic */ SealedDeserializerWithDefault<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SealedDeserializerWithDefault$descriptor$1(SealedDeserializerWithDefault<T> sealedDeserializerWithDefault) {
        super(1);
        this.this$0 = sealedDeserializerWithDefault;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return E.f5463a;
    }

    public final void invoke(a buildClassSerialDescriptor) {
        r.f(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        a.b(buildClassSerialDescriptor, ((SealedDeserializerWithDefault) this.this$0).typeDiscriminator, G3.a.D(J.f13414a).getDescriptor(), null, false, 12, null);
    }
}
