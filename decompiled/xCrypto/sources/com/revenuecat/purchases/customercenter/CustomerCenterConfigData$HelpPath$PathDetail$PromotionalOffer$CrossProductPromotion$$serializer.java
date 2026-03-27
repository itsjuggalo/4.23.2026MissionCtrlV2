package com.revenuecat.purchases.customercenter;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.o0;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer implements C {
    public static final CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer = new CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.CrossProductPromotion", customerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer, 2);
        c0327b0.l("store_offer_identifier", false);
        c0327b0.l("target_product_id", false);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$CrossProductPromotion$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        o0 o0Var = o0.f952a;
        return new b[]{o0Var, o0Var};
    }

    @Override // F3.a
    public CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.CrossProductPromotion deserialize(e decoder) {
        String strV;
        String strV2;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            strV = cVarD.v(descriptor2, 0);
            strV2 = cVarD.v(descriptor2, 1);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            strV = null;
            String strV3 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    strV = cVarD.v(descriptor2, 0);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    strV3 = cVarD.v(descriptor2, 1);
                    i5 |= 2;
                }
            }
            strV2 = strV3;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.CrossProductPromotion(i4, strV, strV2, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.CrossProductPromotion value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer.CrossProductPromotion.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
