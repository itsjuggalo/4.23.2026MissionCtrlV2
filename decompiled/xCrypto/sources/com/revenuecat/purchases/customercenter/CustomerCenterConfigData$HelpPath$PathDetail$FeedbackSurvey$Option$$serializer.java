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
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer implements C {
    public static final CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer customerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer = new CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option", customerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer, 3);
        c0327b0.l(DiagnosticsEntry.ID_KEY, false);
        c0327b0.l(b.f8745S, false);
        c0327b0.l("promotional_offer", true);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$Option$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        F3.b bVarP = a.p(CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE);
        o0 o0Var = o0.f952a;
        return new F3.b[]{o0Var, o0Var, bVarP};
    }

    @Override // F3.a
    public CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option deserialize(e decoder) {
        int i4;
        String str;
        String str2;
        Object objY;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        String strV = null;
        if (cVarD.w()) {
            String strV2 = cVarD.v(descriptor2, 0);
            String strV3 = cVarD.v(descriptor2, 1);
            objY = cVarD.y(descriptor2, 2, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, null);
            str = strV2;
            str2 = strV3;
            i4 = 7;
        } else {
            boolean z4 = true;
            int i5 = 0;
            String strV4 = null;
            Object objY2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    strV = cVarD.v(descriptor2, 0);
                    i5 |= 1;
                } else if (i6 == 1) {
                    strV4 = cVarD.v(descriptor2, 1);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    objY2 = cVarD.y(descriptor2, 2, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, objY2);
                    i5 |= 4;
                }
            }
            i4 = i5;
            str = strV;
            str2 = strV4;
            objY = objY2;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option(i4, str, str2, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) objY, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.Option.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
