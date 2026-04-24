package com.revenuecat.purchases;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2306v;
import p5.z;
import r5.AbstractC2678a;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Ljava/util/Date;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
public final class CustomerInfo$latestExpirationDate$2 extends AbstractC2306v implements Function0 {
    final /* synthetic */ CustomerInfo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CustomerInfo$latestExpirationDate$2(CustomerInfo customerInfo) {
        super(0);
        this.this$0 = customerInfo;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Date invoke() {
        List listZ0 = z.z0(this.this$0.getAllExpirationDatesByProduct().values(), new Comparator() { // from class: com.revenuecat.purchases.CustomerInfo$latestExpirationDate$2$invoke$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t8, T t9) {
                return AbstractC2678a.a((Date) t8, (Date) t9);
            }
        });
        if (listZ0.isEmpty()) {
            listZ0 = null;
        }
        if (listZ0 != null) {
            return (Date) z.j0(listZ0);
        }
        return null;
    }
}
