package com.revenuecat.purchases.paywalls;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.H;
import J3.k0;
import J3.o0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.PaywallData;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallData$$serializer implements C {
    public static final PaywallData$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallData$$serializer paywallData$$serializer = new PaywallData$$serializer();
        INSTANCE = paywallData$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.PaywallData", paywallData$$serializer, 8);
        c0327b0.l("template_name", false);
        c0327b0.l("config", false);
        c0327b0.l("asset_base_url", false);
        c0327b0.l("revision", true);
        c0327b0.l("localized_strings", false);
        c0327b0.l("localized_strings_by_tier", true);
        c0327b0.l("zero_decimal_place_countries", true);
        c0327b0.l("default_locale", true);
        descriptor = c0327b0;
    }

    private PaywallData$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = PaywallData.$childSerializers;
        o0 o0Var = o0.f952a;
        return new b[]{o0Var, PaywallData$Configuration$$serializer.INSTANCE, URLSerializer.INSTANCE, H.f874a, bVarArr[4], bVarArr[5], GoogleListSerializer.INSTANCE, G3.a.p(o0Var)};
    }

    @Override // F3.a
    public PaywallData deserialize(e decoder) {
        Object objM;
        Object objM2;
        int i4;
        int i5;
        Object objY;
        Object objM3;
        Object objM4;
        String str;
        Object objM5;
        int i6;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = PaywallData.$childSerializers;
        int i7 = 7;
        int i8 = 6;
        int i9 = 4;
        if (cVarD.w()) {
            String strV = cVarD.v(descriptor2, 0);
            objM5 = cVarD.m(descriptor2, 1, PaywallData$Configuration$$serializer.INSTANCE, null);
            Object objM6 = cVarD.m(descriptor2, 2, URLSerializer.INSTANCE, null);
            int iH = cVarD.h(descriptor2, 3);
            objM4 = cVarD.m(descriptor2, 4, bVarArr[4], null);
            objM3 = cVarD.m(descriptor2, 5, bVarArr[5], null);
            Object objM7 = cVarD.m(descriptor2, 6, GoogleListSerializer.INSTANCE, null);
            objY = cVarD.y(descriptor2, 7, o0.f952a, null);
            objM2 = objM6;
            i4 = 255;
            objM = objM7;
            i5 = iH;
            str = strV;
        } else {
            boolean z4 = true;
            int iH2 = 0;
            Object objY2 = null;
            objM = null;
            Object objM8 = null;
            String strV2 = null;
            Object objM9 = null;
            objM2 = null;
            i4 = 0;
            Object objM10 = null;
            while (z4) {
                int i10 = i9;
                int i11 = cVarD.i(descriptor2);
                switch (i11) {
                    case -1:
                        z4 = false;
                        i7 = 7;
                        i9 = 4;
                        break;
                    case 0:
                        strV2 = cVarD.v(descriptor2, 0);
                        i4 |= 1;
                        i7 = 7;
                        i8 = 6;
                        i9 = 4;
                        break;
                    case 1:
                        objM9 = cVarD.m(descriptor2, 1, PaywallData$Configuration$$serializer.INSTANCE, objM9);
                        i4 |= 2;
                        i7 = 7;
                        i8 = 6;
                        i9 = 4;
                        break;
                    case 2:
                        objM2 = cVarD.m(descriptor2, 2, URLSerializer.INSTANCE, objM2);
                        i4 |= 4;
                        i7 = 7;
                        i8 = 6;
                        i9 = 4;
                        break;
                    case 3:
                        i6 = i10;
                        iH2 = cVarD.h(descriptor2, 3);
                        i4 |= 8;
                        i9 = i6;
                        i7 = 7;
                        break;
                    case 4:
                        i6 = i10;
                        objM10 = cVarD.m(descriptor2, i6, bVarArr[i10], objM10);
                        i4 |= 16;
                        i9 = i6;
                        i7 = 7;
                        break;
                    case 5:
                        objM8 = cVarD.m(descriptor2, 5, bVarArr[5], objM8);
                        i4 |= 32;
                        i9 = i10;
                        break;
                    case 6:
                        objM = cVarD.m(descriptor2, i8, GoogleListSerializer.INSTANCE, objM);
                        i4 |= 64;
                        i9 = i10;
                        break;
                    case 7:
                        objY2 = cVarD.y(descriptor2, i7, o0.f952a, objY2);
                        i4 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        i9 = i10;
                        break;
                    default:
                        throw new j(i11);
                }
            }
            i5 = iH2;
            objY = objY2;
            objM3 = objM8;
            objM4 = objM10;
            str = strV2;
            objM5 = objM9;
        }
        cVarD.c(descriptor2);
        return new PaywallData(i4, str, (PaywallData.Configuration) objM5, (URL) objM2, i5, (Map) objM4, (Map) objM3, (List) objM, (String) objY, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallData value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallData.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
