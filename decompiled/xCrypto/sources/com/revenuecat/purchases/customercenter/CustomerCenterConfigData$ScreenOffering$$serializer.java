package com.revenuecat.purchases.customercenter;

import F3.b;
import F3.j;
import G3.a;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import J3.o0;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$ScreenOffering$$serializer implements C {
    public static final CustomerCenterConfigData$ScreenOffering$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$ScreenOffering$$serializer customerCenterConfigData$ScreenOffering$$serializer = new CustomerCenterConfigData$ScreenOffering$$serializer();
        INSTANCE = customerCenterConfigData$ScreenOffering$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.ScreenOffering", customerCenterConfigData$ScreenOffering$$serializer, 3);
        c0327b0.l("type", false);
        c0327b0.l("offering_id", true);
        c0327b0.l("button_text", true);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$ScreenOffering$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVar = CustomerCenterConfigData.ScreenOffering.$childSerializers[0];
        o0 o0Var = o0.f952a;
        return new b[]{bVar, a.p(o0Var), a.p(o0Var)};
    }

    @Override // F3.a
    public CustomerCenterConfigData.ScreenOffering deserialize(e decoder) {
        Object objY;
        int i4;
        Object objM;
        Object objY2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = CustomerCenterConfigData.ScreenOffering.$childSerializers;
        Object objM2 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, bVarArr[0], null);
            o0 o0Var = o0.f952a;
            Object objY3 = cVarD.y(descriptor2, 1, o0Var, null);
            objY2 = cVarD.y(descriptor2, 2, o0Var, null);
            objY = objY3;
            i4 = 7;
        } else {
            boolean z4 = true;
            int i5 = 0;
            objY = null;
            Object objY4 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM2 = cVarD.m(descriptor2, 0, bVarArr[0], objM2);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objY = cVarD.y(descriptor2, 1, o0.f952a, objY);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    objY4 = cVarD.y(descriptor2, 2, o0.f952a, objY4);
                    i5 |= 4;
                }
            }
            i4 = i5;
            objM = objM2;
            objY2 = objY4;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData.ScreenOffering(i4, (CustomerCenterConfigData.ScreenOffering.ScreenOfferingType) objM, (String) objY, (String) objY2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData.ScreenOffering value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.ScreenOffering.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
