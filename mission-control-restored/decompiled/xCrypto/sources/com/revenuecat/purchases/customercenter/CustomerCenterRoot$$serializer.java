package com.revenuecat.purchases.customercenter;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterRoot$$serializer implements C {
    public static final CustomerCenterRoot$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterRoot$$serializer customerCenterRoot$$serializer = new CustomerCenterRoot$$serializer();
        INSTANCE = customerCenterRoot$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterRoot", customerCenterRoot$$serializer, 1);
        c0327b0.l("customer_center", false);
        descriptor = c0327b0;
    }

    private CustomerCenterRoot$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{CustomerCenterConfigData$$serializer.INSTANCE};
    }

    @Override // F3.a
    public CustomerCenterRoot deserialize(e decoder) {
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i4 = 1;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, CustomerCenterConfigData$$serializer.INSTANCE, null);
        } else {
            boolean z4 = true;
            int i5 = 0;
            objM = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else {
                    if (i6 != 0) {
                        throw new j(i6);
                    }
                    objM = cVarD.m(descriptor2, 0, CustomerCenterConfigData$$serializer.INSTANCE, objM);
                    i5 = 1;
                }
            }
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterRoot(i4, (CustomerCenterConfigData) objM, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterRoot value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, CustomerCenterConfigData$$serializer.INSTANCE, value.customerCenter);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
