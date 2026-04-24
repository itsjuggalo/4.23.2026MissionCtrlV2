package com.revenuecat.purchases;

import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2306v;
import o5.C2470H;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lo5/H;", "invoke", "()V", "<anonymous>"}, k = 3, mv = {1, 8, 0})
public final class CustomerInfoUpdateHandler$notifyListeners$2$4 extends AbstractC2306v implements Function0 {
    final /* synthetic */ CustomerInfo $customerInfo;
    final /* synthetic */ UpdatedCustomerInfoListener $listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerInfoUpdateHandler$notifyListeners$2$4(UpdatedCustomerInfoListener updatedCustomerInfoListener, CustomerInfo customerInfo) {
        super(0);
        this.$listener = updatedCustomerInfoListener;
        this.$customerInfo = customerInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m27invoke();
        return C2470H.f21956a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m27invoke() {
        this.$listener.onReceived(this.$customerInfo);
    }
}
