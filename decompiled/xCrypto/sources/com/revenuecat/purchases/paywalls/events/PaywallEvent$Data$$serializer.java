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
import com.revenuecat.purchases.paywalls.events.PaywallEvent;
import com.revenuecat.purchases.utils.serializers.UUIDSerializer;
import java.util.UUID;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallEvent$Data$$serializer implements C {
    public static final PaywallEvent$Data$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallEvent$Data$$serializer paywallEvent$Data$$serializer = new PaywallEvent$Data$$serializer();
        INSTANCE = paywallEvent$Data$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.events.PaywallEvent.Data", paywallEvent$Data$$serializer, 6);
        c0327b0.l("offeringIdentifier", false);
        c0327b0.l("paywallRevision", false);
        c0327b0.l("sessionIdentifier", false);
        c0327b0.l("displayMode", false);
        c0327b0.l("localeIdentifier", false);
        c0327b0.l("darkMode", false);
        descriptor = c0327b0;
    }

    private PaywallEvent$Data$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        o0 o0Var = o0.f952a;
        return new b[]{o0Var, H.f874a, UUIDSerializer.INSTANCE, o0Var, o0Var, C0335h.f929a};
    }

    @Override // F3.a
    public PaywallEvent.Data deserialize(e decoder) {
        boolean zN;
        int i4;
        int i5;
        String str;
        Object objM;
        String str2;
        String str3;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            String strV = cVarD.v(descriptor2, 0);
            int iH = cVarD.h(descriptor2, 1);
            objM = cVarD.m(descriptor2, 2, UUIDSerializer.INSTANCE, null);
            String strV2 = cVarD.v(descriptor2, 3);
            String strV3 = cVarD.v(descriptor2, 4);
            str = strV;
            zN = cVarD.n(descriptor2, 5);
            str2 = strV2;
            str3 = strV3;
            i4 = iH;
            i5 = 63;
        } else {
            boolean z4 = true;
            boolean zN2 = false;
            int i6 = 0;
            String strV4 = null;
            Object objM2 = null;
            String strV5 = null;
            String strV6 = null;
            int iH2 = 0;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z4 = false;
                        continue;
                    case 0:
                        strV4 = cVarD.v(descriptor2, 0);
                        i6 |= 1;
                        continue;
                    case 1:
                        iH2 = cVarD.h(descriptor2, 1);
                        i6 |= 2;
                        break;
                    case 2:
                        objM2 = cVarD.m(descriptor2, 2, UUIDSerializer.INSTANCE, objM2);
                        i6 |= 4;
                        break;
                    case 3:
                        strV5 = cVarD.v(descriptor2, 3);
                        i6 |= 8;
                        break;
                    case 4:
                        strV6 = cVarD.v(descriptor2, 4);
                        i6 |= 16;
                        break;
                    case 5:
                        zN2 = cVarD.n(descriptor2, 5);
                        i6 |= 32;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            zN = zN2;
            i4 = iH2;
            i5 = i6;
            str = strV4;
            objM = objM2;
            str2 = strV5;
            str3 = strV6;
        }
        cVarD.c(descriptor2);
        return new PaywallEvent.Data(i5, str, i4, (UUID) objM, str2, str3, zN, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallEvent.Data value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallEvent.Data.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
