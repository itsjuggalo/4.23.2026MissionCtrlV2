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
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.PaywallData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallData$LocalizedConfiguration$Feature$$serializer implements C {
    public static final PaywallData$LocalizedConfiguration$Feature$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallData$LocalizedConfiguration$Feature$$serializer paywallData$LocalizedConfiguration$Feature$$serializer = new PaywallData$LocalizedConfiguration$Feature$$serializer();
        INSTANCE = paywallData$LocalizedConfiguration$Feature$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.PaywallData.LocalizedConfiguration.Feature", paywallData$LocalizedConfiguration$Feature$$serializer, 3);
        c0327b0.l(b.f8745S, false);
        c0327b0.l(FirebaseAnalytics.Param.CONTENT, true);
        c0327b0.l("icon_id", true);
        descriptor = c0327b0;
    }

    private PaywallData$LocalizedConfiguration$Feature$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        o0 o0Var = o0.f952a;
        return new F3.b[]{o0Var, G3.a.p(o0Var), G3.a.p(o0Var)};
    }

    @Override // F3.a
    public PaywallData.LocalizedConfiguration.Feature deserialize(e decoder) {
        int i4;
        String str;
        Object objY;
        Object objY2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        String strV = null;
        if (cVarD.w()) {
            String strV2 = cVarD.v(descriptor2, 0);
            o0 o0Var = o0.f952a;
            objY = cVarD.y(descriptor2, 1, o0Var, null);
            objY2 = cVarD.y(descriptor2, 2, o0Var, null);
            str = strV2;
            i4 = 7;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objY3 = null;
            Object objY4 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    strV = cVarD.v(descriptor2, 0);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objY3 = cVarD.y(descriptor2, 1, o0.f952a, objY3);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    objY4 = cVarD.y(descriptor2, 2, o0.f952a, objY4);
                    i5 |= 4;
                }
            }
            i4 = i5;
            str = strV;
            objY = objY3;
            objY2 = objY4;
        }
        cVarD.c(descriptor2);
        return new PaywallData.LocalizedConfiguration.Feature(i4, str, (String) objY, (String) objY2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallData.LocalizedConfiguration.Feature value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallData.LocalizedConfiguration.Feature.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
