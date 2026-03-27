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
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$Appearance$$serializer implements C {
    public static final CustomerCenterConfigData$Appearance$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$Appearance$$serializer customerCenterConfigData$Appearance$$serializer = new CustomerCenterConfigData$Appearance$$serializer();
        INSTANCE = customerCenterConfigData$Appearance$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Appearance", customerCenterConfigData$Appearance$$serializer, 2);
        c0327b0.l("light", true);
        c0327b0.l("dark", true);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$Appearance$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        CustomerCenterConfigData$Appearance$ColorInformation$$serializer customerCenterConfigData$Appearance$ColorInformation$$serializer = CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE;
        return new b[]{a.p(customerCenterConfigData$Appearance$ColorInformation$$serializer), a.p(customerCenterConfigData$Appearance$ColorInformation$$serializer)};
    }

    @Override // F3.a
    public CustomerCenterConfigData.Appearance deserialize(e decoder) {
        Object objY;
        int i4;
        Object objY2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            CustomerCenterConfigData$Appearance$ColorInformation$$serializer customerCenterConfigData$Appearance$ColorInformation$$serializer = CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE;
            objY2 = cVarD.y(descriptor2, 0, customerCenterConfigData$Appearance$ColorInformation$$serializer, null);
            objY = cVarD.y(descriptor2, 1, customerCenterConfigData$Appearance$ColorInformation$$serializer, null);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            objY = null;
            Object objY3 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objY3 = cVarD.y(descriptor2, 0, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, objY3);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objY = cVarD.y(descriptor2, 1, CustomerCenterConfigData$Appearance$ColorInformation$$serializer.INSTANCE, objY);
                    i5 |= 2;
                }
            }
            i4 = i5;
            objY2 = objY3;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData.Appearance(i4, (CustomerCenterConfigData.Appearance.ColorInformation) objY2, (CustomerCenterConfigData.Appearance.ColorInformation) objY, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData.Appearance value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.Appearance.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
