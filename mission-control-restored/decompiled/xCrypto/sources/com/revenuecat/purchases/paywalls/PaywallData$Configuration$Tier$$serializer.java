package com.revenuecat.purchases.paywalls;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.o0;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.PaywallData;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallData$Configuration$Tier$$serializer implements C {
    public static final PaywallData$Configuration$Tier$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallData$Configuration$Tier$$serializer paywallData$Configuration$Tier$$serializer = new PaywallData$Configuration$Tier$$serializer();
        INSTANCE = paywallData$Configuration$Tier$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Tier", paywallData$Configuration$Tier$$serializer, 3);
        c0327b0.l(DiagnosticsEntry.ID_KEY, false);
        c0327b0.l("packages", false);
        c0327b0.l("default_package", false);
        descriptor = c0327b0;
    }

    private PaywallData$Configuration$Tier$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVar = PaywallData.Configuration.Tier.$childSerializers[1];
        o0 o0Var = o0.f952a;
        return new b[]{o0Var, bVar, o0Var};
    }

    @Override // F3.a
    public PaywallData.Configuration.Tier deserialize(e decoder) {
        int i4;
        String str;
        Object objM;
        String strV;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = PaywallData.Configuration.Tier.$childSerializers;
        String strV2 = null;
        if (cVarD.w()) {
            String strV3 = cVarD.v(descriptor2, 0);
            objM = cVarD.m(descriptor2, 1, bVarArr[1], null);
            strV = cVarD.v(descriptor2, 2);
            i4 = 7;
            str = strV3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM2 = null;
            String strV4 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    strV2 = cVarD.v(descriptor2, 0);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM2 = cVarD.m(descriptor2, 1, bVarArr[1], objM2);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    strV4 = cVarD.v(descriptor2, 2);
                    i5 |= 4;
                }
            }
            i4 = i5;
            str = strV2;
            objM = objM2;
            strV = strV4;
        }
        cVarD.c(descriptor2);
        return new PaywallData.Configuration.Tier(i4, str, (List) objM, strV, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallData.Configuration.Tier value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallData.Configuration.Tier.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
