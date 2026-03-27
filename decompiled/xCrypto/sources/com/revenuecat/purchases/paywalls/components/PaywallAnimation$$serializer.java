package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.H;
import com.revenuecat.purchases.paywalls.components.PaywallAnimation;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallAnimation$$serializer implements C {
    public static final PaywallAnimation$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallAnimation$$serializer paywallAnimation$$serializer = new PaywallAnimation$$serializer();
        INSTANCE = paywallAnimation$$serializer;
        C0327b0 c0327b0 = new C0327b0("animation", paywallAnimation$$serializer, 3);
        c0327b0.l("type", false);
        c0327b0.l("ms_delay", false);
        c0327b0.l("ms_duration", false);
        descriptor = c0327b0;
    }

    private PaywallAnimation$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        H h4 = H.f874a;
        return new b[]{AnimationTypeSerializer.INSTANCE, h4, h4};
    }

    @Override // F3.a
    public PaywallAnimation deserialize(e decoder) {
        int iH;
        int i4;
        int iH2;
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, AnimationTypeSerializer.INSTANCE, null);
            int iH3 = cVarD.h(descriptor2, 1);
            iH2 = cVarD.h(descriptor2, 2);
            iH = iH3;
            i4 = 7;
        } else {
            boolean z4 = true;
            int iH4 = 0;
            int i5 = 0;
            Object objM2 = null;
            iH = 0;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM2 = cVarD.m(descriptor2, 0, AnimationTypeSerializer.INSTANCE, objM2);
                    i5 |= 1;
                } else if (i6 == 1) {
                    iH = cVarD.h(descriptor2, 1);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    iH4 = cVarD.h(descriptor2, 2);
                    i5 |= 4;
                }
            }
            i4 = i5;
            iH2 = iH4;
            objM = objM2;
        }
        cVarD.c(descriptor2);
        return new PaywallAnimation(i4, (PaywallAnimation.AnimationType) objM, iH, iH2, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallAnimation value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallAnimation.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
