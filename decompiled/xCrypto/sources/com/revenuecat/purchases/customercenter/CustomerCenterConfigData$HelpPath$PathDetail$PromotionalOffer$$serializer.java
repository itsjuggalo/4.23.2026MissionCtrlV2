package com.revenuecat.purchases.customercenter;

import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0335h;
import J3.k0;
import J3.o0;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer implements C {
    public static final CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer = new CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer", customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer, 6);
        c0327b0.l("android_offer_id", false);
        c0327b0.l("eligible", false);
        c0327b0.l(b.f8745S, false);
        c0327b0.l("subtitle", false);
        c0327b0.l("product_mapping", false);
        c0327b0.l("cross_product_promotions", true);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        F3.b[] bVarArr = CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$childSerializers;
        F3.b bVar = bVarArr[4];
        F3.b bVar2 = bVarArr[5];
        o0 o0Var = o0.f952a;
        return new F3.b[]{o0Var, C0335h.f929a, o0Var, o0Var, bVar, bVar2};
    }

    @Override // F3.a
    public CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer deserialize(e decoder) {
        Object objM;
        int i4;
        boolean z4;
        String str;
        String str2;
        String str3;
        Object objM2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        F3.b[] bVarArr = CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.$childSerializers;
        if (cVarD.w()) {
            String strV = cVarD.v(descriptor2, 0);
            boolean zN = cVarD.n(descriptor2, 1);
            String strV2 = cVarD.v(descriptor2, 2);
            String strV3 = cVarD.v(descriptor2, 3);
            Object objM3 = cVarD.m(descriptor2, 4, bVarArr[4], null);
            objM2 = cVarD.m(descriptor2, 5, bVarArr[5], null);
            str3 = strV3;
            i4 = 63;
            z4 = zN;
            objM = objM3;
            str2 = strV2;
            str = strV;
        } else {
            boolean z5 = true;
            int i5 = 0;
            String strV4 = null;
            String strV5 = null;
            String strV6 = null;
            objM = null;
            Object objM4 = null;
            boolean zN2 = false;
            while (z5) {
                int i6 = cVarD.i(descriptor2);
                switch (i6) {
                    case -1:
                        z5 = false;
                        continue;
                    case 0:
                        strV4 = cVarD.v(descriptor2, 0);
                        i5 |= 1;
                        continue;
                    case 1:
                        zN2 = cVarD.n(descriptor2, 1);
                        i5 |= 2;
                        break;
                    case 2:
                        strV5 = cVarD.v(descriptor2, 2);
                        i5 |= 4;
                        break;
                    case 3:
                        strV6 = cVarD.v(descriptor2, 3);
                        i5 |= 8;
                        break;
                    case 4:
                        objM = cVarD.m(descriptor2, 4, bVarArr[4], objM);
                        i5 |= 16;
                        break;
                    case 5:
                        objM4 = cVarD.m(descriptor2, 5, bVarArr[5], objM4);
                        i5 |= 32;
                        break;
                    default:
                        throw new j(i6);
                }
            }
            i4 = i5;
            z4 = zN2;
            str = strV4;
            str2 = strV5;
            str3 = strV6;
            objM2 = objM4;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer(i4, str, z4, str2, str3, (Map) objM, (Map) objM2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
