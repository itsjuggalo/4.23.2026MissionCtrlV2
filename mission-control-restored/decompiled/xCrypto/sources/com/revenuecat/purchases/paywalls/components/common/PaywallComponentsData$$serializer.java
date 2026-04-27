package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.H;
import J3.o0;
import com.revenuecat.purchases.utils.serializers.GoogleListSerializer;
import com.revenuecat.purchases.utils.serializers.URLSerializer;
import java.net.URL;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallComponentsData$$serializer implements C {
    public static final PaywallComponentsData$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallComponentsData$$serializer paywallComponentsData$$serializer = new PaywallComponentsData$$serializer();
        INSTANCE = paywallComponentsData$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.common.PaywallComponentsData", paywallComponentsData$$serializer, 7);
        c0327b0.l("template_name", false);
        c0327b0.l("asset_base_url", false);
        c0327b0.l("components_config", false);
        c0327b0.l("components_localizations", false);
        c0327b0.l("default_locale", false);
        c0327b0.l("revision", true);
        c0327b0.l("zero_decimal_place_countries", true);
        descriptor = c0327b0;
    }

    private PaywallComponentsData$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{o0.f952a, URLSerializer.INSTANCE, ComponentsConfig$$serializer.INSTANCE, PaywallComponentsData.$childSerializers[3], LocaleId$$serializer.INSTANCE, H.f874a, GoogleListSerializer.INSTANCE};
    }

    @Override // F3.a
    public PaywallComponentsData deserialize(e decoder) {
        Object objM;
        Object objM2;
        Object objM3;
        String str;
        Object objM4;
        int i4;
        Object objM5;
        int i5;
        boolean z4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = PaywallComponentsData.$childSerializers;
        int i6 = 6;
        Object objM6 = null;
        if (cVarD.w()) {
            String strV = cVarD.v(descriptor2, 0);
            objM2 = cVarD.m(descriptor2, 1, URLSerializer.INSTANCE, null);
            objM3 = cVarD.m(descriptor2, 2, ComponentsConfig$$serializer.INSTANCE, null);
            objM = cVarD.m(descriptor2, 3, bVarArr[3], null);
            objM5 = cVarD.m(descriptor2, 4, LocaleId$$serializer.INSTANCE, null);
            int iH = cVarD.h(descriptor2, 5);
            objM4 = cVarD.m(descriptor2, 6, GoogleListSerializer.INSTANCE, null);
            i5 = 127;
            i4 = iH;
            str = strV;
        } else {
            boolean z5 = true;
            int iH2 = 0;
            int i7 = 0;
            Object objM7 = null;
            Object objM8 = null;
            String strV2 = null;
            Object objM9 = null;
            Object objM10 = null;
            while (z5) {
                int i8 = cVarD.i(descriptor2);
                switch (i8) {
                    case -1:
                        z5 = false;
                        break;
                    case 0:
                        z4 = true;
                        strV2 = cVarD.v(descriptor2, 0);
                        i7 |= 1;
                        i6 = 6;
                        break;
                    case 1:
                        z4 = true;
                        objM8 = cVarD.m(descriptor2, 1, URLSerializer.INSTANCE, objM8);
                        i7 |= 2;
                        i6 = 6;
                        break;
                    case 2:
                        objM6 = cVarD.m(descriptor2, 2, ComponentsConfig$$serializer.INSTANCE, objM6);
                        i7 |= 4;
                        break;
                    case 3:
                        objM7 = cVarD.m(descriptor2, 3, bVarArr[3], objM7);
                        i7 |= 8;
                        break;
                    case 4:
                        objM10 = cVarD.m(descriptor2, 4, LocaleId$$serializer.INSTANCE, objM10);
                        i7 |= 16;
                        break;
                    case 5:
                        iH2 = cVarD.h(descriptor2, 5);
                        i7 |= 32;
                        break;
                    case 6:
                        objM9 = cVarD.m(descriptor2, i6, GoogleListSerializer.INSTANCE, objM9);
                        i7 |= 64;
                        break;
                    default:
                        throw new j(i8);
                }
            }
            objM = objM7;
            objM2 = objM8;
            objM3 = objM6;
            str = strV2;
            objM4 = objM9;
            i4 = iH2;
            objM5 = objM10;
            i5 = i7;
        }
        cVarD.c(descriptor2);
        LocaleId localeId = (LocaleId) objM5;
        return new PaywallComponentsData(i5, str, (URL) objM2, (ComponentsConfig) objM3, (Map) objM, localeId != null ? localeId.m172unboximpl() : null, i4, (List) objM4, null, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallComponentsData value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallComponentsData.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
