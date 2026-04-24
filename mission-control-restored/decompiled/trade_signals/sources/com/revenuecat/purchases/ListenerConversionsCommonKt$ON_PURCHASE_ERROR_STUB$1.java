package com.revenuecat.purchases;

import B5.o;
import kotlin.Metadata;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/revenuecat/purchases/PurchasesError;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "Lo5/H;", "invoke", "(Lcom/revenuecat/purchases/PurchasesError;Z)V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1 extends AbstractC2306v implements o {
    public static final ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1 INSTANCE = new ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1();

    public ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1() {
        super(2);
    }

    @Override // B5.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
        return C2470H.f21956a;
    }

    public final void invoke(PurchasesError purchasesError, boolean z7) {
        AbstractC2304t.f(purchasesError, "<anonymous parameter 0>");
    }
}
