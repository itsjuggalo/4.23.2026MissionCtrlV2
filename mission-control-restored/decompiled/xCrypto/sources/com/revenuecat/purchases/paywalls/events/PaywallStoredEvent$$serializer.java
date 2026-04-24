package com.revenuecat.purchases.paywalls.events;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.o0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallStoredEvent$$serializer implements C {
    public static final PaywallStoredEvent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallStoredEvent$$serializer paywallStoredEvent$$serializer = new PaywallStoredEvent$$serializer();
        INSTANCE = paywallStoredEvent$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.events.PaywallStoredEvent", paywallStoredEvent$$serializer, 2);
        c0327b0.l("event", false);
        c0327b0.l("userID", false);
        descriptor = c0327b0;
    }

    private PaywallStoredEvent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{PaywallEvent$$serializer.INSTANCE, o0.f952a};
    }

    @Override // F3.a
    public PaywallStoredEvent deserialize(e decoder) {
        Object objM;
        String strV;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, PaywallEvent$$serializer.INSTANCE, null);
            strV = cVarD.v(descriptor2, 1);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            objM = null;
            String strV2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM = cVarD.m(descriptor2, 0, PaywallEvent$$serializer.INSTANCE, objM);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    strV2 = cVarD.v(descriptor2, 1);
                    i5 |= 2;
                }
            }
            strV = strV2;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new PaywallStoredEvent(i4, (PaywallEvent) objM, strV, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallStoredEvent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallStoredEvent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
