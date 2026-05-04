package com.revenuecat.purchases.customercenter;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.customercenter.CustomerCenterConfigData;
import dh.e0;
import dh.j1;
import dh.s1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/customercenter/CustomerCenterConfigData.HelpPath.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/customercenter/CustomerCenterConfigData$HelpPath;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CustomerCenterConfigData$HelpPath$$serializer implements e0 {
    public static final CustomerCenterConfigData$HelpPath$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CustomerCenterConfigData$HelpPath$$serializer customerCenterConfigData$HelpPath$$serializer = new CustomerCenterConfigData$HelpPath$$serializer();
        INSTANCE = customerCenterConfigData$HelpPath$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.customercenter.CustomerCenterConfigData.HelpPath", customerCenterConfigData$HelpPath$$serializer, 8);
        j1Var.g(DiagnosticsEntry.ID_KEY, false);
        j1Var.g(b.S, false);
        j1Var.g("type", false);
        j1Var.g("promotional_offer", true);
        j1Var.g("feedback_survey", true);
        j1Var.g("url", true);
        j1Var.g("open_method", true);
        j1Var.g("action_identifier", true);
        descriptor = j1Var;
    }

    private CustomerCenterConfigData$HelpPath$$serializer() {
    }

    @Override // dh.e0
    public zg.b[] childSerializers() {
        zg.b[] bVarArr = CustomerCenterConfigData.HelpPath.$childSerializers;
        w1 w1Var = w1.f8244a;
        return new zg.b[]{w1Var, w1Var, bVarArr[2], a.p(CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE), a.p(CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE), a.p(w1Var), a.p(bVarArr[6]), a.p(w1Var)};
    }

    @Override // zg.a
    public CustomerCenterConfigData.HelpPath deserialize(e decoder) {
        int i10;
        String str;
        CustomerCenterConfigData.HelpPath.OpenMethod openMethod;
        String str2;
        CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey;
        String str3;
        String str4;
        CustomerCenterConfigData.HelpPath.PathType pathType;
        CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        zg.b[] bVarArr = CustomerCenterConfigData.HelpPath.$childSerializers;
        int i11 = 7;
        String strS = null;
        if (cVarB.z()) {
            String strS2 = cVarB.s(descriptor2, 0);
            String strS3 = cVarB.s(descriptor2, 1);
            CustomerCenterConfigData.HelpPath.PathType pathType2 = (CustomerCenterConfigData.HelpPath.PathType) cVarB.h(descriptor2, 2, bVarArr[2], null);
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer2 = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) cVarB.n(descriptor2, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, null);
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey2 = (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) cVarB.n(descriptor2, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, null);
            w1 w1Var = w1.f8244a;
            String str5 = (String) cVarB.n(descriptor2, 5, w1Var, null);
            openMethod = (CustomerCenterConfigData.HelpPath.OpenMethod) cVarB.n(descriptor2, 6, bVarArr[6], null);
            str3 = strS2;
            str = (String) cVarB.n(descriptor2, 7, w1Var, null);
            str2 = str5;
            promotionalOffer = promotionalOffer2;
            feedbackSurvey = feedbackSurvey2;
            i10 = 255;
            pathType = pathType2;
            str4 = strS3;
        } else {
            boolean z10 = true;
            int i12 = 0;
            String str6 = null;
            CustomerCenterConfigData.HelpPath.OpenMethod openMethod2 = null;
            String str7 = null;
            CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey feedbackSurvey3 = null;
            String strS4 = null;
            CustomerCenterConfigData.HelpPath.PathType pathType3 = null;
            CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer promotionalOffer3 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        break;
                    case 0:
                        i12 |= 1;
                        strS = cVarB.s(descriptor2, 0);
                        i11 = 7;
                        break;
                    case 1:
                        strS4 = cVarB.s(descriptor2, 1);
                        i12 |= 2;
                        i11 = 7;
                        break;
                    case 2:
                        pathType3 = (CustomerCenterConfigData.HelpPath.PathType) cVarB.h(descriptor2, 2, bVarArr[2], pathType3);
                        i12 |= 4;
                        i11 = 7;
                        break;
                    case 3:
                        promotionalOffer3 = (CustomerCenterConfigData.HelpPath.PathDetail.PromotionalOffer) cVarB.n(descriptor2, 3, CustomerCenterConfigData$HelpPath$PathDetail$PromotionalOffer$$serializer.INSTANCE, promotionalOffer3);
                        i12 |= 8;
                        i11 = 7;
                        break;
                    case 4:
                        feedbackSurvey3 = (CustomerCenterConfigData.HelpPath.PathDetail.FeedbackSurvey) cVarB.n(descriptor2, 4, CustomerCenterConfigData$HelpPath$PathDetail$FeedbackSurvey$$serializer.INSTANCE, feedbackSurvey3);
                        i12 |= 16;
                        i11 = 7;
                        break;
                    case 5:
                        str7 = (String) cVarB.n(descriptor2, 5, w1.f8244a, str7);
                        i12 |= 32;
                        break;
                    case 6:
                        openMethod2 = (CustomerCenterConfigData.HelpPath.OpenMethod) cVarB.n(descriptor2, 6, bVarArr[6], openMethod2);
                        i12 |= 64;
                        break;
                    case 7:
                        str6 = (String) cVarB.n(descriptor2, i11, w1.f8244a, str6);
                        i12 |= 128;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i12;
            str = str6;
            openMethod = openMethod2;
            str2 = str7;
            feedbackSurvey = feedbackSurvey3;
            str3 = strS;
            str4 = strS4;
            pathType = pathType3;
            promotionalOffer = promotionalOffer3;
        }
        cVarB.c(descriptor2);
        return new CustomerCenterConfigData.HelpPath(i10, str3, str4, pathType, promotionalOffer, feedbackSurvey, str2, openMethod, str, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CustomerCenterConfigData.HelpPath value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CustomerCenterConfigData.HelpPath.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public zg.b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
