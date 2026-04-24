package com.revenuecat.purchases;

import E5.E;
import com.revenuecat.purchases.interfaces.UpdatedCustomerInfoListener;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerInfoUpdateHandler$notifyListeners$2$2 extends s implements Function0 {
    final /* synthetic */ CustomerInfo $customerInfo;
    final /* synthetic */ UpdatedCustomerInfoListener $listener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerInfoUpdateHandler$notifyListeners$2$2(UpdatedCustomerInfoListener updatedCustomerInfoListener, CustomerInfo customerInfo) {
        super(0);
        this.$listener = updatedCustomerInfoListener;
        this.$customerInfo = customerInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        m30invoke();
        return E.f1657a;
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m30invoke() {
        this.$listener.onReceived(this.$customerInfo);
    }
}
