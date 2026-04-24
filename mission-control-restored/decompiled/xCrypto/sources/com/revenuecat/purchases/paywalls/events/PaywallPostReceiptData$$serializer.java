package com.revenuecat.purchases.paywalls.events;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0335h;
import J3.H;
import J3.o0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallPostReceiptData$$serializer implements C {
    public static final PaywallPostReceiptData$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallPostReceiptData$$serializer paywallPostReceiptData$$serializer = new PaywallPostReceiptData$$serializer();
        INSTANCE = paywallPostReceiptData$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.events.PaywallPostReceiptData", paywallPostReceiptData$$serializer, 6);
        c0327b0.l("session_id", false);
        c0327b0.l("revision", false);
        c0327b0.l("display_mode", false);
        c0327b0.l("dark_mode", false);
        c0327b0.l("locale", false);
        c0327b0.l("offering_id", false);
        descriptor = c0327b0;
    }

    private PaywallPostReceiptData$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        o0 o0Var = o0.f952a;
        return new b[]{o0Var, H.f874a, o0Var, C0335h.f929a, o0Var, o0Var};
    }

    @Override // F3.a
    public PaywallPostReceiptData deserialize(e decoder) {
        String strV;
        String strV2;
        boolean z4;
        String str;
        String str2;
        int i4;
        int i5;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            strV = cVarD.v(descriptor2, 0);
            int iH = cVarD.h(descriptor2, 1);
            String strV3 = cVarD.v(descriptor2, 2);
            boolean zN = cVarD.n(descriptor2, 3);
            String strV4 = cVarD.v(descriptor2, 4);
            strV2 = cVarD.v(descriptor2, 5);
            z4 = zN;
            str = strV4;
            str2 = strV3;
            i4 = iH;
            i5 = 63;
        } else {
            strV = null;
            String strV5 = null;
            String strV6 = null;
            String strV7 = null;
            boolean z5 = true;
            boolean zN2 = false;
            int iH2 = 0;
            int i6 = 0;
            while (z5) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z5 = false;
                        continue;
                    case 0:
                        strV = cVarD.v(descriptor2, 0);
                        i6 |= 1;
                        continue;
                    case 1:
                        iH2 = cVarD.h(descriptor2, 1);
                        i6 |= 2;
                        break;
                    case 2:
                        strV7 = cVarD.v(descriptor2, 2);
                        i6 |= 4;
                        break;
                    case 3:
                        zN2 = cVarD.n(descriptor2, 3);
                        i6 |= 8;
                        break;
                    case 4:
                        strV6 = cVarD.v(descriptor2, 4);
                        i6 |= 16;
                        break;
                    case 5:
                        strV5 = cVarD.v(descriptor2, 5);
                        i6 |= 32;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            strV2 = strV5;
            z4 = zN2;
            str = strV6;
            str2 = strV7;
            i4 = iH2;
            i5 = i6;
        }
        String str3 = strV;
        cVarD.c(descriptor2);
        return new PaywallPostReceiptData(i5, str3, i4, str2, z4, str, strV2, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallPostReceiptData value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallPostReceiptData.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
