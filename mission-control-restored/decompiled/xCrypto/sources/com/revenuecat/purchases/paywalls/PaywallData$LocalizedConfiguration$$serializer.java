package com.revenuecat.purchases.paywalls;

import F3.j;
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
import com.revenuecat.purchases.paywalls.PaywallData;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallData$LocalizedConfiguration$$serializer implements C {
    public static final PaywallData$LocalizedConfiguration$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallData$LocalizedConfiguration$$serializer paywallData$LocalizedConfiguration$$serializer = new PaywallData$LocalizedConfiguration$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration", paywallData$LocalizedConfiguration$$serializer, 12);
        c0327b0.l(b.f8745S, false);
        c0327b0.l("subtitle", true);
        c0327b0.l("call_to_action", false);
        c0327b0.l("call_to_action_with_intro_offer", true);
        c0327b0.l("call_to_action_with_multiple_intro_offers", true);
        c0327b0.l("offer_details", true);
        c0327b0.l("offer_details_with_intro_offer", true);
        c0327b0.l("offer_details_with_multiple_intro_offers", true);
        c0327b0.l("offer_name", true);
        c0327b0.l("features", true);
        c0327b0.l("tier_name", true);
        c0327b0.l("offer_overrides", true);
        descriptor = c0327b0;
    }

    private PaywallData$LocalizedConfiguration$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        F3.b[] bVarArr = PaywallData.LocalizedConfiguration.$childSerializers;
        EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
        F3.b bVarP = G3.a.p(emptyStringToNullSerializer);
        F3.b bVarP2 = G3.a.p(emptyStringToNullSerializer);
        F3.b bVarP3 = G3.a.p(emptyStringToNullSerializer);
        F3.b bVarP4 = G3.a.p(emptyStringToNullSerializer);
        F3.b bVarP5 = G3.a.p(emptyStringToNullSerializer);
        F3.b bVarP6 = G3.a.p(emptyStringToNullSerializer);
        F3.b bVarP7 = G3.a.p(emptyStringToNullSerializer);
        F3.b bVar = bVarArr[9];
        F3.b bVarP8 = G3.a.p(emptyStringToNullSerializer);
        F3.b bVar2 = bVarArr[11];
        o0 o0Var = o0.f952a;
        return new F3.b[]{o0Var, bVarP, o0Var, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVarP7, bVar, bVarP8, bVar2};
    }

    @Override // F3.a
    public PaywallData.LocalizedConfiguration deserialize(e decoder) {
        Object objY;
        Object objY2;
        int i4;
        Object objY3;
        Object objY4;
        Object objM;
        Object objY5;
        String str;
        Object objY6;
        Object objM2;
        Object objY7;
        Object objY8;
        String strV;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        F3.b[] bVarArr = PaywallData.LocalizedConfiguration.$childSerializers;
        String strV2 = null;
        if (cVarD.w()) {
            String strV3 = cVarD.v(descriptor2, 0);
            EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
            Object objY9 = cVarD.y(descriptor2, 1, emptyStringToNullSerializer, null);
            strV = cVarD.v(descriptor2, 2);
            objY6 = cVarD.y(descriptor2, 3, emptyStringToNullSerializer, null);
            Object objY10 = cVarD.y(descriptor2, 4, emptyStringToNullSerializer, null);
            objY8 = cVarD.y(descriptor2, 5, emptyStringToNullSerializer, null);
            objY5 = cVarD.y(descriptor2, 6, emptyStringToNullSerializer, null);
            Object objY11 = cVarD.y(descriptor2, 7, emptyStringToNullSerializer, null);
            objY7 = cVarD.y(descriptor2, 8, emptyStringToNullSerializer, null);
            objM = cVarD.m(descriptor2, 9, bVarArr[9], null);
            objY4 = cVarD.y(descriptor2, 10, emptyStringToNullSerializer, null);
            objM2 = cVarD.m(descriptor2, 11, bVarArr[11], null);
            i4 = 4095;
            str = strV3;
            objY = objY9;
            objY3 = objY10;
            objY2 = objY11;
        } else {
            int i5 = 11;
            objY = null;
            Object objY12 = null;
            Object objM3 = null;
            Object objY13 = null;
            Object objY14 = null;
            Object objM4 = null;
            objY2 = null;
            Object objY15 = null;
            String strV4 = null;
            int i6 = 9;
            boolean z4 = true;
            i4 = 0;
            objY3 = null;
            Object objY16 = null;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z4 = false;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 0:
                        strV2 = cVarD.v(descriptor2, 0);
                        i4 |= 1;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 1:
                        objY = cVarD.y(descriptor2, 1, EmptyStringToNullSerializer.INSTANCE, objY);
                        i4 |= 2;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 2:
                        strV4 = cVarD.v(descriptor2, 2);
                        i4 |= 4;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 3:
                        objY16 = cVarD.y(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, objY16);
                        i4 |= 8;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 4:
                        objY3 = cVarD.y(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, objY3);
                        i4 |= 16;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 5:
                        objY15 = cVarD.y(descriptor2, 5, EmptyStringToNullSerializer.INSTANCE, objY15);
                        i4 |= 32;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 6:
                        objY14 = cVarD.y(descriptor2, 6, EmptyStringToNullSerializer.INSTANCE, objY14);
                        i4 |= 64;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 7:
                        objY2 = cVarD.y(descriptor2, 7, EmptyStringToNullSerializer.INSTANCE, objY2);
                        i4 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 8:
                        objY13 = cVarD.y(descriptor2, 8, EmptyStringToNullSerializer.INSTANCE, objY13);
                        i4 |= 256;
                        i5 = 11;
                        i6 = 9;
                        break;
                    case 9:
                        objM3 = cVarD.m(descriptor2, i6, bVarArr[i6], objM3);
                        i4 |= 512;
                        i5 = 11;
                        break;
                    case 10:
                        objY12 = cVarD.y(descriptor2, 10, EmptyStringToNullSerializer.INSTANCE, objY12);
                        i4 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        i5 = 11;
                        break;
                    case 11:
                        objM4 = cVarD.m(descriptor2, i5, bVarArr[i5], objM4);
                        i4 |= 2048;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            objY4 = objY12;
            objM = objM3;
            objY5 = objY14;
            str = strV2;
            objY6 = objY16;
            objM2 = objM4;
            objY7 = objY13;
            objY8 = objY15;
            strV = strV4;
        }
        cVarD.c(descriptor2);
        return new PaywallData.LocalizedConfiguration(i4, str, (String) objY, strV, (String) objY6, (String) objY3, (String) objY8, (String) objY5, (String) objY2, (String) objY7, (List) objM, (String) objY4, (Map) objM2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallData.LocalizedConfiguration value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallData.LocalizedConfiguration.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
