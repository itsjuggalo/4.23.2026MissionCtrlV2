package com.revenuecat.purchases.hybridcommon;

import B5.k;
import com.revenuecat.purchases.hybridcommon.mappers.StoreProductMapperKt;
import com.revenuecat.purchases.models.StoreProduct;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/revenuecat/purchases/models/StoreProduct;", "it", "Lo5/H;", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class CommonKt$getProductInfo$onReceived$1 extends AbstractC2306v implements k {
    final /* synthetic */ OnResultList $onResult;

    /* JADX INFO: renamed from: com.revenuecat.purchases.hybridcommon.CommonKt$getProductInfo$onReceived$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\b\u001a\u00020\u00052\u001a\u0010\u0004\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0000H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"", "", "", "", "list", "Lo5/H;", "invoke", "(Ljava/util/List;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
    public static final class AnonymousClass1 extends AbstractC2306v implements k {
        final /* synthetic */ OnResultList $onResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OnResultList onResultList) {
            super(1);
            this.$onResult = onResultList;
        }

        @Override // B5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((List<? extends Map<String, ? extends Object>>) obj);
            return C2470H.f21956a;
        }

        public final void invoke(List<? extends Map<String, ? extends Object>> list) {
            AbstractC2304t.f(list, "list");
            this.$onResult.onReceived(list);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonKt$getProductInfo$onReceived$1(OnResultList onResultList) {
        super(1);
        this.$onResult = onResultList;
    }

    @Override // B5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return C2470H.f21956a;
    }

    public final void invoke(List<? extends StoreProduct> it) {
        AbstractC2304t.f(it, "it");
        StoreProductMapperKt.mapAsync(it, new AnonymousClass1(this.$onResult));
    }
}
