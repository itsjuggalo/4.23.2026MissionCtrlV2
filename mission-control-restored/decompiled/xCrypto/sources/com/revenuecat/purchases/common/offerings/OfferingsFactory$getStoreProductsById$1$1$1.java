package com.revenuecat.purchases.common.offerings;

import W2.E;
import W2.t;
import X2.AbstractC0768o;
import X2.AbstractC0770q;
import X2.L;
import com.revenuecat.purchases.common.Dispatcher;
import com.revenuecat.purchases.models.StoreProduct;
import i3.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class OfferingsFactory$getStoreProductsById$1$1$1 extends s implements k {
    final /* synthetic */ k $onCompleted;
    final /* synthetic */ Map<String, List<StoreProduct>> $productsById;
    final /* synthetic */ OfferingsFactory this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfferingsFactory$getStoreProductsById$1$1$1(OfferingsFactory offeringsFactory, Map<String, List<StoreProduct>> map, k kVar) {
        super(1);
        this.this$0 = offeringsFactory;
        this.$productsById = map;
        this.$onCompleted = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void invoke$lambda$1(Map productsById, List inAppProducts, k onCompleted) {
        r.f(productsById, "$productsById");
        r.f(inAppProducts, "$inAppProducts");
        r.f(onCompleted, "$onCompleted");
        ArrayList arrayList = new ArrayList(AbstractC0770q.q(inAppProducts, 10));
        Iterator it = inAppProducts.iterator();
        while (it.hasNext()) {
            StoreProduct storeProduct = (StoreProduct) it.next();
            arrayList.add(t.a(storeProduct.getPurchasingData().getProductId(), AbstractC0768o.b(storeProduct)));
        }
        L.l(productsById, arrayList);
        onCompleted.invoke(productsById);
    }

    @Override // i3.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((List<? extends StoreProduct>) obj);
        return E.f5463a;
    }

    public final void invoke(final List<? extends StoreProduct> inAppProducts) {
        r.f(inAppProducts, "inAppProducts");
        Dispatcher dispatcher = this.this$0.dispatcher;
        final Map<String, List<StoreProduct>> map = this.$productsById;
        final k kVar = this.$onCompleted;
        Dispatcher.enqueue$default(dispatcher, new Runnable() { // from class: com.revenuecat.purchases.common.offerings.b
            @Override // java.lang.Runnable
            public final void run() {
                OfferingsFactory$getStoreProductsById$1$1$1.invoke$lambda$1(map, inAppProducts, kVar);
            }
        }, null, 2, null);
    }
}
