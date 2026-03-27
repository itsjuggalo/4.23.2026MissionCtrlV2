package com.revenuecat.purchases;

import F5.v;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerInfo$latestExpirationDate$2 extends s implements Function0 {
    final /* synthetic */ CustomerInfo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerInfo$latestExpirationDate$2(CustomerInfo customerInfo) {
        super(0);
        this.this$0 = customerInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Date invoke() {
        List listA0 = v.a0(this.this$0.getAllExpirationDatesByProduct().values(), new Comparator() { // from class: com.revenuecat.purchases.CustomerInfo$latestExpirationDate$2$invoke$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t7, T t8) {
                return G5.a.a((Date) t7, (Date) t8);
            }
        });
        if (listA0.isEmpty()) {
            listA0 = null;
        }
        if (listA0 != null) {
            return (Date) v.S(listA0);
        }
        return null;
    }
}
