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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class CustomerCenterConfigData$HelpPath$$serializer implements C {
    public static final CustomerCenterConfigData$HelpPath$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CustomerCenterConfigData$HelpPath$$serializer customerCenterConfigData$HelpPath$$serializer = new CustomerCenterConfigData$HelpPath$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath", customerCenterConfigData$HelpPath$$serializer, 8);
        c0327b0.l(DiagnosticsEntry.ID_KEY, false);
        c0327b0.l(b.f8745S, false);
        c0327b0.l("type", false);
        c0327b0.l("promotional_offer", true);
        c0327b0.l("feedback_survey", true);
        c0327b0.l("url", true);
        c0327b0.l("open_method", true);
        c0327b0.l("action_identifier", true);
        descriptor = c0327b0;
    }

    private CustomerCenterConfigData$HelpPath$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        F3.b[] bVarArr = CustomerCenterConfigData.HelpPath.$childSerializers;
        o0 o0Var = o0.f952a;
        return new F3.b[]{o0Var, o0Var, bVarArr[2], a.p(CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE), a.p(CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE), a.p(o0Var), a.p(bVarArr[6]), a.p(o0Var)};
    }

    @Override // F3.a
    public CustomerCenterConfigData.HelpPath deserialize(e decoder) {
        Object objY;
        String strV;
        int i4;
        Object objY2;
        Object objY3;
        Object objY4;
        String str;
        Object objM;
        Object objY5;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        F3.b[] bVarArr = CustomerCenterConfigData.HelpPath.$childSerializers;
        int i5 = 7;
        String strV2 = null;
        if (cVarD.w()) {
            String strV3 = cVarD.v(descriptor2, 0);
            String strV4 = cVarD.v(descriptor2, 1);
            objM = cVarD.m(descriptor2, 2, bVarArr[2], null);
            objY5 = cVarD.y(descriptor2, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, null);
            objY4 = cVarD.y(descriptor2, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, null);
            o0 o0Var = o0.f952a;
            Object objY6 = cVarD.y(descriptor2, 5, o0Var, null);
            objY3 = cVarD.y(descriptor2, 6, bVarArr[6], null);
            objY2 = cVarD.y(descriptor2, 7, o0Var, null);
            i4 = 255;
            strV = strV4;
            objY = objY6;
            str = strV3;
        } else {
            boolean z4 = true;
            int i6 = 0;
            Object objY7 = null;
            Object objY8 = null;
            objY = null;
            Object objY9 = null;
            strV = null;
            Object objM2 = null;
            Object objY10 = null;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z4 = false;
                        break;
                    case 0:
                        i6 |= 1;
                        strV2 = cVarD.v(descriptor2, 0);
                        i5 = 7;
                        break;
                    case 1:
                        strV = cVarD.v(descriptor2, 1);
                        i6 |= 2;
                        i5 = 7;
                        break;
                    case 2:
                        objM2 = cVarD.m(descriptor2, 2, bVarArr[2], objM2);
                        i6 |= 4;
                        i5 = 7;
                        break;
                    case 3:
                        objY10 = cVarD.y(descriptor2, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, objY10);
                        i6 |= 8;
                        i5 = 7;
                        break;
                    case 4:
                        objY9 = cVarD.y(descriptor2, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, objY9);
                        i6 |= 16;
                        i5 = 7;
                        break;
                    case 5:
                        objY = cVarD.y(descriptor2, 5, o0.f952a, objY);
                        i6 |= 32;
                        break;
                    case 6:
                        objY8 = cVarD.y(descriptor2, 6, bVarArr[6], objY8);
                        i6 |= 64;
                        break;
                    case 7:
                        objY7 = cVarD.y(descriptor2, i5, o0.f952a, objY7);
                        i6 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            i4 = i6;
            objY2 = objY7;
            objY3 = objY8;
            objY4 = objY9;
            str = strV2;
            objM = objM2;
            objY5 = objY10;
        }
        cVarD.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath(i4, str, strV, (CustomerCenterConfigData.HelpPath.PathType) objM, (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) objY5, (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) objY4, (String) objY, (CustomerCenterConfigData.HelpPath.OpenMethod) objY3, (String) objY2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CustomerCenterConfigData.HelpPath value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CustomerCenterConfigData.HelpPath.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
