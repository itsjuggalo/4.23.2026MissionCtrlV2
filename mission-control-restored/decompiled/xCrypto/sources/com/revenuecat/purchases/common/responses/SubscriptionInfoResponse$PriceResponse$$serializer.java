package com.revenuecat.purchases.common.responses;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0346t;
import J3.o0;
import com.revenuecat.purchases.common.responses.SubscriptionInfoResponse;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class SubscriptionInfoResponse$PriceResponse$$serializer implements C {
    public static final SubscriptionInfoResponse$PriceResponse$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        SubscriptionInfoResponse$PriceResponse$$serializer subscriptionInfoResponse$PriceResponse$$serializer = new SubscriptionInfoResponse$PriceResponse$$serializer();
        INSTANCE = subscriptionInfoResponse$PriceResponse$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.common.responses.SubscriptionInfoResponse.PriceResponse", subscriptionInfoResponse$PriceResponse$$serializer, 2);
        c0327b0.l("amount", false);
        c0327b0.l("currency", false);
        descriptor = c0327b0;
    }

    private SubscriptionInfoResponse$PriceResponse$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{C0346t.f970a, o0.f952a};
    }

    @Override // F3.a
    public SubscriptionInfoResponse.PriceResponse deserialize(e decoder) {
        String strV;
        int i4;
        double d4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            double dZ = cVarD.z(descriptor2, 0);
            strV = cVarD.v(descriptor2, 1);
            i4 = 3;
            d4 = dZ;
        } else {
            strV = null;
            boolean z4 = true;
            double dZ2 = 0.0d;
            int i5 = 0;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    dZ2 = cVarD.z(descriptor2, 0);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    strV = cVarD.v(descriptor2, 1);
                    i5 |= 2;
                }
            }
            i4 = i5;
            d4 = dZ2;
        }
        String str = strV;
        cVarD.c(descriptor2);
        return new SubscriptionInfoResponse.PriceResponse(i4, d4, str, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, SubscriptionInfoResponse.PriceResponse value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        SubscriptionInfoResponse.PriceResponse.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
