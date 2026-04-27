package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import F3.j;
import G3.a;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent;
import com.revenuecat.purchases.paywalls.components.StickyFooterComponent$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallComponentsConfig$$serializer implements C {
    public static final PaywallComponentsConfig$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallComponentsConfig$$serializer paywallComponentsConfig$$serializer = new PaywallComponentsConfig$$serializer();
        INSTANCE = paywallComponentsConfig$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.common.PaywallComponentsConfig", paywallComponentsConfig$$serializer, 3);
        c0327b0.l("stack", false);
        c0327b0.l("background", false);
        c0327b0.l("sticky_footer", true);
        descriptor = c0327b0;
    }

    private PaywallComponentsConfig$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{StackComponent$$serializer.INSTANCE, BackgroundDeserializer.INSTANCE, a.p(StickyFooterComponent$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public PaywallComponentsConfig deserialize(e decoder) {
        int i4;
        Object objM;
        Object objM2;
        Object objY;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objM3 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, StackComponent$$serializer.INSTANCE, null);
            objM2 = cVarD.m(descriptor2, 1, BackgroundDeserializer.INSTANCE, null);
            objY = cVarD.y(descriptor2, 2, StickyFooterComponent$$serializer.INSTANCE, null);
            i4 = 7;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM4 = null;
            Object objY2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM3 = cVarD.m(descriptor2, 0, StackComponent$$serializer.INSTANCE, objM3);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM4 = cVarD.m(descriptor2, 1, BackgroundDeserializer.INSTANCE, objM4);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    objY2 = cVarD.y(descriptor2, 2, StickyFooterComponent$$serializer.INSTANCE, objY2);
                    i5 |= 4;
                }
            }
            Object obj = objM3;
            i4 = i5;
            objM = obj;
            objM2 = objM4;
            objY = objY2;
        }
        cVarD.c(descriptor2);
        return new PaywallComponentsConfig(i4, (StackComponent) objM, (Background) objM2, (StickyFooterComponent) objY, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallComponentsConfig value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallComponentsConfig.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
