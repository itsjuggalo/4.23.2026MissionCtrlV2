package com.revenuecat.purchases.customercenter;

import F3.b;
import J3.AbstractC0325a0;
import J3.k0;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterRoot {
    public static final Companion Companion = new Companion(null);
    private final CustomerCenterConfigData customerCenter;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final b serializer() {
            return CustomerCenterRoot$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ CustomerCenterRoot(int i4, CustomerCenterConfigData customerCenterConfigData, k0 k0Var) {
        if (1 != (i4 & 1)) {
            AbstractC0325a0.a(i4, 1, CustomerCenterRoot$$serializer.INSTANCE.getDescriptor());
        }
        this.customerCenter = customerCenterConfigData;
    }

    public static /* synthetic */ void getCustomerCenter$annotations() {
    }

    public final CustomerCenterConfigData getCustomerCenter() {
        return this.customerCenter;
    }

    public CustomerCenterRoot(CustomerCenterConfigData customerCenter) {
        r.f(customerCenter, "customerCenter");
        this.customerCenter = customerCenter;
    }
}
