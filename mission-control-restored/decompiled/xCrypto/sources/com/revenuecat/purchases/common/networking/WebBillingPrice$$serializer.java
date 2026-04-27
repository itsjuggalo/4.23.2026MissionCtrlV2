package com.revenuecat.purchases.common.networking;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.O;
import J3.o0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class WebBillingPrice$$serializer implements C {
    public static final WebBillingPrice$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        WebBillingPrice$$serializer webBillingPrice$$serializer = new WebBillingPrice$$serializer();
        INSTANCE = webBillingPrice$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.common.networking.WebBillingPrice", webBillingPrice$$serializer, 2);
        c0327b0.l("amount_micros", false);
        c0327b0.l("currency", false);
        descriptor = c0327b0;
    }

    private WebBillingPrice$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{O.f882a, o0.f952a};
    }

    @Override // F3.a
    public WebBillingPrice deserialize(e decoder) {
        String strV;
        int i4;
        long j4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            long j5 = cVarD.j(descriptor2, 0);
            strV = cVarD.v(descriptor2, 1);
            i4 = 3;
            j4 = j5;
        } else {
            strV = null;
            boolean z4 = true;
            long j6 = 0;
            int i5 = 0;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    j6 = cVarD.j(descriptor2, 0);
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
            j4 = j6;
        }
        String str = strV;
        cVarD.c(descriptor2);
        return new WebBillingPrice(i4, j4, str, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, WebBillingPrice value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        WebBillingPrice.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
