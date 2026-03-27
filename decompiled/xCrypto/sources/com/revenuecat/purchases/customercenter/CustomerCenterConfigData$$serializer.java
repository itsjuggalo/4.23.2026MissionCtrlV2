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
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$$serializer implements C {
    public static final CustomerCenterConfigData$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$$serializer customerCenterConfigData$$serializer = new CustomerCenterConfigData$$serializer();
        INSTANCE = customerCenterConfigData$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData", customerCenterConfigData$$serializer, 5);
        c0327b0.l("screens", false);
        c0327b0.l("appearance", false);
        c0327b0.l("localization", false);
        c0327b0.l("support", false);
        c0327b0.l("last_published_app_version", true);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{ScreenMapSerializer.INSTANCE, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, CustomerCenterConfigData$Localization$$serializer.INSTANCE, CustomerCenterConfigData$Support$$serializer.INSTANCE, a.p(EmptyStringToNullSerializer.INSTANCE)};
    }

    @Override // F3.a
    public CustomerCenterConfigData deserialize(e decoder) {
        int i4;
        Object objM;
        Object objM2;
        Object objM3;
        Object objM4;
        Object objY;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objM5 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, ScreenMapSerializer.INSTANCE, null);
            objM2 = cVarD.m(descriptor2, 1, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, null);
            objM3 = cVarD.m(descriptor2, 2, CustomerCenterConfigData$Localization$$serializer.INSTANCE, null);
            objM4 = cVarD.m(descriptor2, 3, CustomerCenterConfigData$Support$$serializer.INSTANCE, null);
            objY = cVarD.y(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, null);
            i4 = 31;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM6 = null;
            Object objM7 = null;
            Object objM8 = null;
            Object objY2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM5 = cVarD.m(descriptor2, 0, ScreenMapSerializer.INSTANCE, objM5);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM6 = cVarD.m(descriptor2, 1, CustomerCenterConfigData$Appearance$$serializer.INSTANCE, objM6);
                    i5 |= 2;
                } else if (i6 == 2) {
                    objM7 = cVarD.m(descriptor2, 2, CustomerCenterConfigData$Localization$$serializer.INSTANCE, objM7);
                    i5 |= 4;
                } else if (i6 == 3) {
                    objM8 = cVarD.m(descriptor2, 3, CustomerCenterConfigData$Support$$serializer.INSTANCE, objM8);
                    i5 |= 8;
                } else {
                    if (i6 != 4) {
                        throw new j(i6);
                    }
                    objY2 = cVarD.y(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, objY2);
                    i5 |= 16;
                }
            }
            Object obj = objM5;
            i4 = i5;
            objM = obj;
            objM2 = objM6;
            objM3 = objM7;
            objM4 = objM8;
            objY = objY2;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData(i4, (Map) objM, (CustomerCenterConfigData.Appearance) objM2, (CustomerCenterConfigData.Localization) objM3, (CustomerCenterConfigData.Support) objM4, (String) objY, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
