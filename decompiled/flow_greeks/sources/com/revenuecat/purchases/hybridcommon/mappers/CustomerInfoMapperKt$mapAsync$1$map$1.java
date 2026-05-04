package com.revenuecat.purchases.hybridcommon.mappers;

import cd.h0;
import cd.s;
import com.revenuecat.purchases.CustomerInfo;
import gd.e;
import hd.c;
import id.f;
import id.m;
import kotlin.Metadata;
import ng.n0;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\u0000H\u008a@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lng/n0;", "", "", "", "<anonymous>", "(Lng/n0;)Ljava/util/Map;"}, k = 3, mv = {1, 8, 0})
@f(c = "com.revenuecat.purchases.hybridcommon.mappers.CustomerInfoMapperKt$mapAsync$1$map$1", f = "CustomerInfoMapper.kt", l = {}, m = "invokeSuspend")
public final class CustomerInfoMapperKt$mapAsync$1$map$1 extends m implements o {
    final /* synthetic */ CustomerInfo $this_mapAsync;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerInfoMapperKt$mapAsync$1$map$1(CustomerInfo customerInfo, e eVar) {
        super(2, eVar);
        this.$this_mapAsync = customerInfo;
    }

    @Override // id.a
    public final e create(Object obj, e eVar) {
        return new CustomerInfoMapperKt$mapAsync$1$map$1(this.$this_mapAsync, eVar);
    }

    @Override // id.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        c.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        s.b(obj);
        return CustomerInfoMapperKt.map(this.$this_mapAsync);
    }

    @Override // pd.o
    public final Object invoke(n0 n0Var, e eVar) {
        return ((CustomerInfoMapperKt$mapAsync$1$map$1) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
    }
}
