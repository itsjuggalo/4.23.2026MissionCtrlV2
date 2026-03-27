package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ButtonComponent$Destination$Url$$serializer implements C {
    public static final ButtonComponent$Destination$Url$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ButtonComponent$Destination$Url$$serializer buttonComponent$Destination$Url$$serializer = new ButtonComponent$Destination$Url$$serializer();
        INSTANCE = buttonComponent$Destination$Url$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Url", buttonComponent$Destination$Url$$serializer, 2);
        c0327b0.l("urlLid", false);
        c0327b0.l("method", false);
        descriptor = c0327b0;
    }

    private ButtonComponent$Destination$Url$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{LocalizationKey$$serializer.INSTANCE, UrlMethodDeserializer.INSTANCE};
    }

    @Override // F3.a
    public ButtonComponent.Destination.Url deserialize(e decoder) {
        int i4;
        Object objM;
        Object objM2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, null);
            objM2 = cVarD.m(descriptor2, 1, UrlMethodDeserializer.INSTANCE, null);
            i4 = 3;
        } else {
            boolean z4 = true;
            i4 = 0;
            objM = null;
            Object objM3 = null;
            while (z4) {
                int i5 = cVarD.i(descriptor2);
                if (i5 == -1) {
                    z4 = false;
                } else if (i5 == 0) {
                    objM = cVarD.m(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, objM);
                    i4 |= 1;
                } else {
                    if (i5 != 1) {
                        throw new j(i5);
                    }
                    objM3 = cVarD.m(descriptor2, 1, UrlMethodDeserializer.INSTANCE, objM3);
                    i4 |= 2;
                }
            }
            objM2 = objM3;
        }
        cVarD.c(descriptor2);
        LocalizationKey localizationKey = (LocalizationKey) objM;
        return new ButtonComponent.Destination.Url(i4, localizationKey != null ? localizationKey.m199unboximpl() : null, (ButtonComponent.UrlMethod) objM2, null, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ButtonComponent.Destination.Url value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        ButtonComponent.Destination.Url.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
