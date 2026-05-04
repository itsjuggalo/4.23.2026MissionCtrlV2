package com.revenuecat.purchases.utils.serializers;

import bh.a;
import cd.h0;
import kotlin.Metadata;
import kotlin.jvm.internal.s0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import pd.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "T", "Lbh/a;", "Lcd/h0;", "invoke", "(Lbh/a;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class SealedDeserializerWithDefault$descriptor$1 extends v implements k {
    final /* synthetic */ SealedDeserializerWithDefault<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SealedDeserializerWithDefault$descriptor$1(SealedDeserializerWithDefault<T> sealedDeserializerWithDefault) {
        super(1);
        this.this$0 = sealedDeserializerWithDefault;
    }

    @Override // pd.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a) obj);
        return h0.f3852a;
    }

    public final void invoke(a buildClassSerialDescriptor) {
        t.f(buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        a.b(buildClassSerialDescriptor, ((SealedDeserializerWithDefault) this.this$0).typeDiscriminator, ah.a.D(s0.f14953a).getDescriptor(), null, false, 12, null);
    }
}
