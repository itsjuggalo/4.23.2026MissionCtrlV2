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
import J3.k0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class WebBillingPurchaseOption$$serializer implements C {
    public static final WebBillingPurchaseOption$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        WebBillingPurchaseOption$$serializer webBillingPurchaseOption$$serializer = new WebBillingPurchaseOption$$serializer();
        INSTANCE = webBillingPurchaseOption$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.common.networking.WebBillingPurchaseOption", webBillingPurchaseOption$$serializer, 4);
        c0327b0.l("base_price", true);
        c0327b0.l("base", true);
        c0327b0.l("trial", true);
        c0327b0.l("intro_price", true);
        descriptor = c0327b0;
    }

    private WebBillingPurchaseOption$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVarP = a.p(WebBillingPrice$$serializer.INSTANCE);
        WebBillingPhase$$serializer webBillingPhase$$serializer = WebBillingPhase$$serializer.INSTANCE;
        return new b[]{bVarP, a.p(webBillingPhase$$serializer), a.p(webBillingPhase$$serializer), a.p(webBillingPhase$$serializer)};
    }

    @Override // F3.a
    public WebBillingPurchaseOption deserialize(e decoder) {
        int i4;
        Object objY;
        Object objY2;
        Object objY3;
        Object objY4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objY5 = null;
        if (cVarD.w()) {
            objY = cVarD.y(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, null);
            WebBillingPhase$$serializer webBillingPhase$$serializer = WebBillingPhase$$serializer.INSTANCE;
            objY2 = cVarD.y(descriptor2, 1, webBillingPhase$$serializer, null);
            objY3 = cVarD.y(descriptor2, 2, webBillingPhase$$serializer, null);
            objY4 = cVarD.y(descriptor2, 3, webBillingPhase$$serializer, null);
            i4 = 15;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objY6 = null;
            Object objY7 = null;
            Object objY8 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objY5 = cVarD.y(descriptor2, 0, WebBillingPrice$$serializer.INSTANCE, objY5);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objY6 = cVarD.y(descriptor2, 1, WebBillingPhase$$serializer.INSTANCE, objY6);
                    i5 |= 2;
                } else if (i6 == 2) {
                    objY7 = cVarD.y(descriptor2, 2, WebBillingPhase$$serializer.INSTANCE, objY7);
                    i5 |= 4;
                } else {
                    if (i6 != 3) {
                        throw new j(i6);
                    }
                    objY8 = cVarD.y(descriptor2, 3, WebBillingPhase$$serializer.INSTANCE, objY8);
                    i5 |= 8;
                }
            }
            Object obj = objY5;
            i4 = i5;
            objY = obj;
            objY2 = objY6;
            objY3 = objY7;
            objY4 = objY8;
        }
        cVarD.c(descriptor2);
        return new WebBillingPurchaseOption(i4, (WebBillingPrice) objY, (WebBillingPhase) objY2, (WebBillingPhase) objY3, (WebBillingPhase) objY4, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, WebBillingPurchaseOption value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        WebBillingPurchaseOption.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
