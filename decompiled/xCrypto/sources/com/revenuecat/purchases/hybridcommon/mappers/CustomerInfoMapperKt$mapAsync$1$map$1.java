package com.revenuecat.purchases.hybridcommon.mappers;

import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.InterfaceC0868f;
import b3.l;
import com.revenuecat.purchases.CustomerInfo;
import i3.o;
import t3.L;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC0868f(c = "com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt$mapAsync$1$map$1", f = "CustomerInfoMapper.kt", l = {}, m = "invokeSuspend")
public final class CustomerInfoMapperKt$mapAsync$1$map$1 extends l implements o {
    final /* synthetic */ CustomerInfo $this_mapAsync;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerInfoMapperKt$mapAsync$1$map$1(CustomerInfo customerInfo, e eVar) {
        super(2, eVar);
        this.$this_mapAsync = customerInfo;
    }

    @Override // b3.AbstractC0863a
    public final e create(Object obj, e eVar) {
        return new CustomerInfoMapperKt$mapAsync$1$map$1(this.$this_mapAsync, eVar);
    }

    @Override // b3.AbstractC0863a
    public final Object invokeSuspend(Object obj) throws Throwable {
        AbstractC0787c.e();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        q.b(obj);
        return CustomerInfoMapperKt.map(this.$this_mapAsync);
    }

    @Override // i3.o
    public final Object invoke(L l4, e eVar) {
        return ((CustomerInfoMapperKt$mapAsync$1$map$1) create(l4, eVar)).invokeSuspend(E.f5463a);
    }
}
