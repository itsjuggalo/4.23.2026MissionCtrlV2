package com.revenuecat.purchases;

import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2306v;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CustomerInfo$activeSubscriptions$2 extends AbstractC2306v implements Function0 {
    final /* synthetic */ CustomerInfo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerInfo$activeSubscriptions$2(CustomerInfo customerInfo) {
        super(0);
        this.this$0 = customerInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Set<String> invoke() {
        CustomerInfo customerInfo = this.this$0;
        return customerInfo.activeIdentifiers(customerInfo.getAllExpirationDatesByProduct());
    }
}
