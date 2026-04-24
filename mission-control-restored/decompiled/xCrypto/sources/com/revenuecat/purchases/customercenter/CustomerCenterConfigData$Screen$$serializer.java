package com.revenuecat.purchases.customercenter;

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
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import com.revenuecat.purchases.paywalls.EmptyStringToNullSerializer;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$Screen$$serializer implements C {
    public static final CustomerCenterConfigData$Screen$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$Screen$$serializer customerCenterConfigData$Screen$$serializer = new CustomerCenterConfigData$Screen$$serializer();
        INSTANCE = customerCenterConfigData$Screen$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.Screen", customerCenterConfigData$Screen$$serializer, 5);
        c0327b0.l("type", false);
        c0327b0.l(b.f8745S, false);
        c0327b0.l("subtitle", true);
        c0327b0.l("paths", false);
        c0327b0.l("offering", true);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$Screen$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        return new F3.b[]{CustomerCenterConfigData.Screen.$childSerializers[0], o0.f952a, a.p(EmptyStringToNullSerializer.INSTANCE), HelpPathsSerializer.INSTANCE, a.p(CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public CustomerCenterConfigData.Screen deserialize(e decoder) {
        Object objY;
        int i4;
        Object objM;
        String str;
        Object objM2;
        Object objY2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        F3.b[] bVarArr = CustomerCenterConfigData.Screen.$childSerializers;
        int i5 = 0;
        Object objM3 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, bVarArr[0], null);
            String strV = cVarD.v(descriptor2, 1);
            Object objY3 = cVarD.y(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, null);
            objM2 = cVarD.m(descriptor2, 3, HelpPathsSerializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, null);
            i4 = 31;
            objY = objY3;
            str = strV;
        } else {
            int i6 = 1;
            int i7 = 0;
            String strV2 = null;
            objY = null;
            Object objM4 = null;
            Object objY4 = null;
            while (i6 != 0) {
                int i8 = cVarD.i(descriptor2);
                int i9 = i5;
                if (i8 == -1) {
                    i5 = i9;
                    i6 = i5;
                } else if (i8 != 0) {
                    if (i8 == 1) {
                        strV2 = cVarD.v(descriptor2, 1);
                        i7 |= 2;
                    } else if (i8 == 2) {
                        objY = cVarD.y(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, objY);
                        i7 |= 4;
                    } else if (i8 == 3) {
                        objM4 = cVarD.m(descriptor2, 3, HelpPathsSerializer.INSTANCE, objM4);
                        i7 |= 8;
                    } else {
                        if (i8 != 4) {
                            throw new j(i8);
                        }
                        objY4 = cVarD.y(descriptor2, 4, CustomerCenterConfigData$ScreenOffering$$serializer.INSTANCE, objY4);
                        i7 |= 16;
                    }
                    i5 = i9;
                } else {
                    objM3 = cVarD.m(descriptor2, i9, bVarArr[i9], objM3);
                    i7 |= 1;
                    i5 = i9;
                }
            }
            i4 = i7;
            objM = objM3;
            str = strV2;
            objM2 = objM4;
            objY2 = objY4;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData.Screen(i4, (CustomerCenterConfigData.Screen.ScreenType) objM, str, (String) objY, (List) objM2, (CustomerCenterConfigData.ScreenOffering) objY2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData.Screen value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.Screen.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
