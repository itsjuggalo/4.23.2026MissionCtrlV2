package com.revenuecat.purchases.common.networking;

import F3.b;
import F3.j;
import G3.a;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.H;
import J3.k0;
import J3.o0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class WebBillingPhase$$serializer implements C {
    public static final WebBillingPhase$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        WebBillingPhase$$serializer webBillingPhase$$serializer = new WebBillingPhase$$serializer();
        INSTANCE = webBillingPhase$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.common.networking.WebBillingPhase", webBillingPhase$$serializer, 3);
        c0327b0.l("price", true);
        c0327b0.l("period_duration", true);
        c0327b0.l("cycle_count", true);
        descriptor = c0327b0;
    }

    private WebBillingPhase$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{a.p(WebBillingPrice$$serializer.INSTANCE), a.p(o0.f952a), H.f874a};
    }

    @Override // F3.a
    public WebBillingPhase deserialize(e decoder) {
        int iH;
        Object objY;
        int i4;
        Object objY2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            objY = cVarD.y(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 1, o0.f952a, null);
            i4 = 7;
            iH = cVarD.h(descriptor2, 2);
        } else {
            boolean z4 = true;
            int iH2 = 0;
            Object objY3 = null;
            Object objY4 = null;
            int i5 = 0;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objY3 = cVarD.y(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, objY3);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objY4 = cVarD.y(descriptor2, 1, o0.f952a, objY4);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    iH2 = cVarD.h(descriptor2, 2);
                    i5 |= 4;
                }
            }
            Object obj = objY3;
            iH = iH2;
            objY = obj;
            i4 = i5;
            objY2 = objY4;
        }
        cVarD.c(descriptor2);
        return new WebBillingPhase(i4, (WebBillingPrice) objY, (String) objY2, iH, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, WebBillingPhase value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        WebBillingPhase.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
