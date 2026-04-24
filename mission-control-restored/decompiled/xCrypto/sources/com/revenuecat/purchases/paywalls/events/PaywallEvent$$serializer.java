package com.revenuecat.purchases.paywalls.events;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import com.google.firebase.messaging.Constants;
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallEvent$$serializer implements C {
    public static final PaywallEvent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallEvent$$serializer paywallEvent$$serializer = new PaywallEvent$$serializer();
        INSTANCE = paywallEvent$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.events.PaywallEvent", paywallEvent$$serializer, 3);
        c0327b0.l("creationData", false);
        c0327b0.l(Constants.ScionAnalytics.MessageType.DATA_MESSAGE, false);
        c0327b0.l("type", false);
        descriptor = c0327b0;
    }

    private PaywallEvent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{PaywallEvent$CreationData$$serializer.INSTANCE, PaywallEvent$Data$$serializer.INSTANCE, PaywallEvent.$childSerializers[2]};
    }

    @Override // F3.a
    public PaywallEvent deserialize(e decoder) {
        Object objM;
        int i4;
        Object objM2;
        Object objM3;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = PaywallEvent.$childSerializers;
        Object objM4 = null;
        if (cVarD.w()) {
            objM2 = cVarD.m(descriptor2, 0, PaywallEvent$CreationData$$serializer.INSTANCE, null);
            Object objM5 = cVarD.m(descriptor2, 1, PaywallEvent$Data$$serializer.INSTANCE, null);
            objM3 = cVarD.m(descriptor2, 2, bVarArr[2], null);
            objM = objM5;
            i4 = 7;
        } else {
            boolean z4 = true;
            int i5 = 0;
            objM = null;
            Object objM6 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM4 = cVarD.m(descriptor2, 0, PaywallEvent$CreationData$$serializer.INSTANCE, objM4);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM = cVarD.m(descriptor2, 1, PaywallEvent$Data$$serializer.INSTANCE, objM);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    objM6 = cVarD.m(descriptor2, 2, bVarArr[2], objM6);
                    i5 |= 4;
                }
            }
            i4 = i5;
            objM2 = objM4;
            objM3 = objM6;
        }
        cVarD.c(descriptor2);
        return new PaywallEvent(i4, (PaywallEvent.CreationData) objM2, (PaywallEvent.Data) objM, (PaywallEventType) objM3, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallEvent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallEvent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
