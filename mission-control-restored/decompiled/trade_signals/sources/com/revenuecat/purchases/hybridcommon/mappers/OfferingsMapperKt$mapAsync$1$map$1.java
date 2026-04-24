package com.revenuecat.purchases.hybridcommon.mappers;

import B5.o;
import Y6.L;
import com.revenuecat.purchases.Offerings;
import kotlin.Metadata;
import o5.AbstractC2491s;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2785l;
import u5.InterfaceC2779f;

/* JADX INFO: loaded from: classes.dex */
@InterfaceC2779f(c = "com.revenuecat.purchases.hybridcommon.mappers.OfferingsMapperKt$mapAsync$1$map$1", f = "OfferingsMapper.kt", l = {}, m = "invokeSuspend")
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LY6/L;", "", "", "", "<anonymous>", "(LY6/L;)Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
public final class OfferingsMapperKt$mapAsync$1$map$1 extends AbstractC2785l implements o {
    final /* synthetic */ Offerings $this_mapAsync;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferingsMapperKt$mapAsync$1$map$1(Offerings offerings, InterfaceC2707e interfaceC2707e) {
        super(2, interfaceC2707e);
        this.$this_mapAsync = offerings;
    }

    @Override // u5.AbstractC2774a
    public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
        return new OfferingsMapperKt$mapAsync$1$map$1(this.$this_mapAsync, interfaceC2707e);
    }

    @Override // B5.o
    public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
        return ((OfferingsMapperKt$mapAsync$1$map$1) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
    }

    @Override // u5.AbstractC2774a
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC2751c.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        AbstractC2491s.b(obj);
        return OfferingsMapperKt.map(this.$this_mapAsync);
    }
}
