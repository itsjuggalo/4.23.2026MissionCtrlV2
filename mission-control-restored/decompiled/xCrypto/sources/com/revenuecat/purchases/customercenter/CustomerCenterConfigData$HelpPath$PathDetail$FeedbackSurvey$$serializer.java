package com.revenuecat.purchases.customercenter;

import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.o0;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer implements C {
    public static final CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer customerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer = new CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey", customerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer, 2);
        c0327b0.l(b.f8745S, false);
        c0327b0.l("options", false);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        return new F3.b[]{o0.f952a, CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.$childSerializers[1]};
    }

    @Override // F3.a
    public CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey deserialize(e decoder) {
        Object objM;
        String strV;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        F3.b[] bVarArr = CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.$childSerializers;
        if (cVarD.w()) {
            strV = cVarD.v(descriptor2, 0);
            objM = cVarD.m(descriptor2, 1, bVarArr[1], null);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM2 = null;
            String strV2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    strV2 = cVarD.v(descriptor2, 0);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objM2 = cVarD.m(descriptor2, 1, bVarArr[1], objM2);
                    i5 |= 2;
                }
            }
            objM = objM2;
            strV = strV2;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey(i4, strV, (List) objM, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
