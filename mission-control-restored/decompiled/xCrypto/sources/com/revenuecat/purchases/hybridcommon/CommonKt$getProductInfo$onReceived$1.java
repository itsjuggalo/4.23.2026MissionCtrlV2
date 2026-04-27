package com.revenuecat.purchases.hybridcommon;

import W2.E;
import com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import i3.k;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes3.dex */
public final class CommonKt$getProductInfo$onReceived$1 extends s implements k {
    final /* synthetic */ OnResultList $onResult;

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getProductInfo$onReceived$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends s implements k {
        final /* synthetic */ OnResultList $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OnResultList onResultList) {
            super(1);
            this.$onResult = onResultList;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends Map<String, ? extends Object>>) obj);
            return E.f5463a;
        }

        public final void invoke(List<? extends Map<String, ? extends Object>> list) {
            r.f(list, "list");
            this.$onResult.onReceived(list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$getProductInfo$onReceived$1(OnResultList onResultList) {
        super(1);
        this.$onResult = onResultList;
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return E.f5463a;
    }

    public final void invoke(List<? extends StoreProduct> it) {
        r.f(it, "it");
        StoreProductMapperKt.mapAsync(it, new AnonymousClass1(this.$onResult));
    }
}
