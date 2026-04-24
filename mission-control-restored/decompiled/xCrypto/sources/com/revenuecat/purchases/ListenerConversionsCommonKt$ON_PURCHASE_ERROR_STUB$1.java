package com.revenuecat.purchases;

import W2.E;
import i3.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1 extends s implements o {
    public static final ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1 INSTANCE = new ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1();

    public ListenerConversionsCommonKt$ON_PURCHASE_ERROR_STUB$1() {
        super(2);
    }

    public final void invoke(PurchasesError purchasesError, boolean z4) {
        r.f(purchasesError, "<anonymous parameter 0>");
    }

    @Override // i3.o
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PurchasesError) obj, ((Boolean) obj2).booleanValue());
        return E.f5463a;
    }
}
