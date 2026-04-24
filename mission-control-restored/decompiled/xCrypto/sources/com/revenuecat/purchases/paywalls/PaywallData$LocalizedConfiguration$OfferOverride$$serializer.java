package com.revenuecat.purchases.paywalls;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import J3.o0;
import com.revenuecat.purchases.paywalls.PaywallData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallData$LocalizedConfiguration$OfferOverride$$serializer implements C {
    public static final PaywallData$LocalizedConfiguration$OfferOverride$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallData$LocalizedConfiguration$OfferOverride$$serializer paywallData$LocalizedConfiguration$OfferOverride$$serializer = new PaywallData$LocalizedConfiguration$OfferOverride$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$OfferOverride$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration.OfferOverride", paywallData$LocalizedConfiguration$OfferOverride$$serializer, 5);
        c0327b0.l("offer_name", false);
        c0327b0.l("offer_details", false);
        c0327b0.l("offer_details_with_intro_offer", true);
        c0327b0.l("offer_details_with_multiple_intro_offers", true);
        c0327b0.l("offer_badge", true);
        descriptor = c0327b0;
    }

    private PaywallData$LocalizedConfiguration$OfferOverride$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
        b bVarP = G3.a.p(emptyStringToNullSerializer);
        b bVarP2 = G3.a.p(emptyStringToNullSerializer);
        b bVarP3 = G3.a.p(emptyStringToNullSerializer);
        o0 o0Var = o0.f952a;
        return new b[]{o0Var, o0Var, bVarP, bVarP2, bVarP3};
    }

    @Override // F3.a
    public PaywallData.LocalizedConfiguration.OfferOverride deserialize(e decoder) {
        int i4;
        String str;
        String str2;
        Object objY;
        Object objY2;
        Object objY3;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        String strV = null;
        if (cVarD.w()) {
            String strV2 = cVarD.v(descriptor2, 0);
            String strV3 = cVarD.v(descriptor2, 1);
            EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
            objY = cVarD.y(descriptor2, 2, emptyStringToNullSerializer, null);
            objY2 = cVarD.y(descriptor2, 3, emptyStringToNullSerializer, null);
            objY3 = cVarD.y(descriptor2, 4, emptyStringToNullSerializer, null);
            str = strV2;
            str2 = strV3;
            i4 = 31;
        } else {
            boolean z4 = true;
            int i5 = 0;
            String strV4 = null;
            Object objY4 = null;
            Object objY5 = null;
            Object objY6 = null;
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
                } else if (i6 == 2) {
                    objY4 = cVarD.y(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, objY4);
                    i5 |= 4;
                } else if (i6 == 3) {
                    objY5 = cVarD.y(descriptor2, 3, EmptyStringToNullSerializer.INSTANCE, objY5);
                    i5 |= 8;
                } else {
                    if (i6 != 4) {
                        throw new j(i6);
                    }
                    objY6 = cVarD.y(descriptor2, 4, EmptyStringToNullSerializer.INSTANCE, objY6);
                    i5 |= 16;
                }
            }
            i4 = i5;
            str = strV;
            str2 = strV4;
            objY = objY4;
            objY2 = objY5;
            objY3 = objY6;
        }
        cVarD.c(descriptor2);
        return new PaywallData.LocalizedConfiguration.OfferOverride(i4, str, str2, (String) objY, (String) objY2, (String) objY3, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallData.LocalizedConfiguration.OfferOverride value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallData.LocalizedConfiguration.OfferOverride.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
