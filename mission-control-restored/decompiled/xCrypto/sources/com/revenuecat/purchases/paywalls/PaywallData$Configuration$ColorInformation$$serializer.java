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
import com.revenuecat.purchases.paywalls.PaywallData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallData$Configuration$ColorInformation$$serializer implements C {
    public static final PaywallData$Configuration$ColorInformation$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallData$Configuration$ColorInformation$$serializer paywallData$Configuration$ColorInformation$$serializer = new PaywallData$Configuration$ColorInformation$$serializer();
        INSTANCE = paywallData$Configuration$ColorInformation$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.PaywallData.Configuration.ColorInformation", paywallData$Configuration$ColorInformation$$serializer, 2);
        c0327b0.l("light", false);
        c0327b0.l("dark", true);
        descriptor = c0327b0;
    }

    private PaywallData$Configuration$ColorInformation$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = PaywallData$Configuration$Colors$$serializer.INSTANCE;
        return new b[]{paywallData$Configuration$Colors$$serializer, G3.a.p(paywallData$Configuration$Colors$$serializer)};
    }

    @Override // F3.a
    public PaywallData.Configuration.ColorInformation deserialize(e decoder) {
        Object objY;
        int i4;
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            PaywallData$Configuration$Colors$$serializer paywallData$Configuration$Colors$$serializer = PaywallData$Configuration$Colors$$serializer.INSTANCE;
            objM = cVarD.m(descriptor2, 0, paywallData$Configuration$Colors$$serializer, null);
            objY = cVarD.y(descriptor2, 1, paywallData$Configuration$Colors$$serializer, null);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            objY = null;
            Object objM2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM2 = cVarD.m(descriptor2, 0, PaywallData$Configuration$Colors$$serializer.INSTANCE, objM2);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objY = cVarD.y(descriptor2, 1, PaywallData$Configuration$Colors$$serializer.INSTANCE, objY);
                    i5 |= 2;
                }
            }
            i4 = i5;
            objM = objM2;
        }
        cVarD.c(descriptor2);
        return new PaywallData.Configuration.ColorInformation(i4, (PaywallData.Configuration.Colors) objM, (PaywallData.Configuration.Colors) objY, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallData.Configuration.ColorInformation value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallData.Configuration.ColorInformation.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
