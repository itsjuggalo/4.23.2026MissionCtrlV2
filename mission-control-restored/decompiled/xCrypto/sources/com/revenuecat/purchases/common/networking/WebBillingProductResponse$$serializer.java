package com.revenuecat.purchases.common.networking;

import F3.j;
import G3.a;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import J3.o0;
import com.amazon.a.a.o.b;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsTracker;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class WebBillingProductResponse$$serializer implements C {
    public static final WebBillingProductResponse$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        WebBillingProductResponse$$serializer webBillingProductResponse$$serializer = new WebBillingProductResponse$$serializer();
        INSTANCE = webBillingProductResponse$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.common.networking.WebBillingProductResponse", webBillingProductResponse$$serializer, 6);
        c0327b0.l(Constants.IDENTIFIER, false);
        c0327b0.l(DiagnosticsTracker.PRODUCT_TYPE_KEY, false);
        c0327b0.l(b.f8745S, false);
        c0327b0.l(b.f8755c, true);
        c0327b0.l("default_purchase_option_id", true);
        c0327b0.l("purchase_options", false);
        descriptor = c0327b0;
    }

    private WebBillingProductResponse$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        F3.b[] bVarArr = WebBillingProductResponse.$childSerializers;
        o0 o0Var = o0.f952a;
        return new F3.b[]{o0Var, o0Var, o0Var, a.p(o0Var), a.p(o0Var), bVarArr[5]};
    }

    @Override // F3.a
    public WebBillingProductResponse deserialize(e decoder) {
        int i4;
        Object objY;
        String str;
        String str2;
        String str3;
        Object objY2;
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        F3.b[] bVarArr = WebBillingProductResponse.$childSerializers;
        String strV = null;
        if (cVarD.w()) {
            String strV2 = cVarD.v(descriptor2, 0);
            String strV3 = cVarD.v(descriptor2, 1);
            String strV4 = cVarD.v(descriptor2, 2);
            o0 o0Var = o0.f952a;
            objY2 = cVarD.y(descriptor2, 3, o0Var, null);
            Object objY3 = cVarD.y(descriptor2, 4, o0Var, null);
            objM = cVarD.m(descriptor2, 5, bVarArr[5], null);
            objY = objY3;
            str = strV2;
            i4 = 63;
            str3 = strV4;
            str2 = strV3;
        } else {
            boolean z4 = true;
            i4 = 0;
            String strV5 = null;
            String strV6 = null;
            Object objY4 = null;
            objY = null;
            Object objM2 = null;
            while (z4) {
                int i5 = cVarD.i(descriptor2);
                switch (i5) {
                    case -1:
                        z4 = false;
                        continue;
                    case 0:
                        strV = cVarD.v(descriptor2, 0);
                        i4 |= 1;
                        continue;
                    case 1:
                        strV5 = cVarD.v(descriptor2, 1);
                        i4 |= 2;
                        break;
                    case 2:
                        strV6 = cVarD.v(descriptor2, 2);
                        i4 |= 4;
                        break;
                    case 3:
                        objY4 = cVarD.y(descriptor2, 3, o0.f952a, objY4);
                        i4 |= 8;
                        break;
                    case 4:
                        objY = cVarD.y(descriptor2, 4, o0.f952a, objY);
                        i4 |= 16;
                        break;
                    case 5:
                        objM2 = cVarD.m(descriptor2, 5, bVarArr[5], objM2);
                        i4 |= 32;
                        break;
                    default:
                        throw new j(i5);
                }
            }
            str = strV;
            str2 = strV5;
            str3 = strV6;
            objY2 = objY4;
            objM = objM2;
        }
        cVarD.c(descriptor2);
        return new WebBillingProductResponse(i4, str, str2, str3, (String) objY2, (String) objY, (Map) objM, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, WebBillingProductResponse value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        WebBillingProductResponse.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
