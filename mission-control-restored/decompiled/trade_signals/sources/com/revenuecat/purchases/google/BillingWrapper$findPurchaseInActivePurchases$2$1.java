package com.revenuecat.purchases.google;

import B5.k;
import com.revenuecat.purchases.PurchasesError;
import com.revenuecat.purchases.PurchasesErrorCode;
import com.revenuecat.purchases.models.StoreTransaction;
import com.revenuecat.purchases.strings.PurchaseStrings;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;
import p5.z;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "", "Lcom/revenuecat/purchases/models/StoreTransaction;", "purchasesByHashedToken", "Lo5/H;", "invoke", "(Ljava/util/Map;)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class BillingWrapper$findPurchaseInActivePurchases$2$1 extends AbstractC2306v implements k {
    final /* synthetic */ k $onCompletion;
    final /* synthetic */ k $onError;
    final /* synthetic */ String $productId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BillingWrapper$findPurchaseInActivePurchases$2$1(k kVar, String str, k kVar2) {
        super(1);
        this.$onCompletion = kVar;
        this.$productId = str;
        this.$onError = kVar2;
    }

    @Override // B5.k
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Map<String, StoreTransaction>) obj);
        return C2470H.f21956a;
    }

    public final void invoke(Map<String, StoreTransaction> purchasesByHashedToken) {
        Object next;
        AbstractC2304t.f(purchasesByHashedToken, "purchasesByHashedToken");
        Collection<StoreTransaction> collectionValues = purchasesByHashedToken.values();
        String str = this.$productId;
        Iterator<T> it = collectionValues.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            } else {
                next = it.next();
                if (AbstractC2304t.b(z.a0(((StoreTransaction) next).getProductIds()), str)) {
                    break;
                }
            }
        }
        StoreTransaction storeTransaction = (StoreTransaction) next;
        if (storeTransaction != null) {
            this.$onCompletion.invoke(storeTransaction);
            return;
        }
        String str2 = String.format(PurchaseStrings.NO_EXISTING_PURCHASE, Arrays.copyOf(new Object[]{this.$productId}, 1));
        AbstractC2304t.e(str2, "format(...)");
        this.$onError.invoke(new PurchasesError(PurchasesErrorCode.PurchaseInvalidError, str2));
    }
}
