package com.revenuecat.purchases;

import F3.j;
import J3.C;
import J3.C0327b0;
import J3.H;
import J3.k0;
import J3.o0;
import com.revenuecat.purchases.UiConfig;
import com.revenuecat.purchases.paywalls.components.properties.FontStyle;
import com.revenuecat.purchases.paywalls.components.properties.FontStyleDeserializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer implements C {
    public static final UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer uiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer = new UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer();
        INSTANCE = uiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer;
        C0327b0 c0327b0 = new C0327b0("name", uiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer, 6);
        c0327b0.l("value", false);
        c0327b0.l("url", true);
        c0327b0.l("hash", true);
        c0327b0.l("family", true);
        c0327b0.l("weight", true);
        c0327b0.l("style", true);
        descriptor = c0327b0;
    }

    private UiConfig$AppConfig$FontsConfig$FontInfo$Name$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        o0 o0Var = o0.f952a;
        return new F3.b[]{o0Var, G3.a.p(o0Var), G3.a.p(o0Var), G3.a.p(o0Var), G3.a.p(H.f874a), G3.a.p(FontStyleDeserializer.INSTANCE)};
    }

    @Override // F3.a
    public UiConfig.AppConfig.FontsConfig.FontInfo.Name deserialize(I3.e decoder) {
        int i4;
        String str;
        Object objY;
        Object objY2;
        Object objY3;
        Object objY4;
        Object objY5;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        I3.c cVarD = decoder.d(descriptor2);
        String strV = null;
        if (cVarD.w()) {
            String strV2 = cVarD.v(descriptor2, 0);
            o0 o0Var = o0.f952a;
            objY = cVarD.y(descriptor2, 1, o0Var, null);
            objY2 = cVarD.y(descriptor2, 2, o0Var, null);
            objY3 = cVarD.y(descriptor2, 3, o0Var, null);
            objY4 = cVarD.y(descriptor2, 4, H.f874a, null);
            objY5 = cVarD.y(descriptor2, 5, FontStyleDeserializer.INSTANCE, null);
            str = strV2;
            i4 = 63;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objY6 = null;
            Object objY7 = null;
            Object objY8 = null;
            Object objY9 = null;
            Object objY10 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                switch (i6) {
                    case -1:
                        z4 = false;
                        continue;
                    case 0:
                        strV = cVarD.v(descriptor2, 0);
                        i5 |= 1;
                        continue;
                    case 1:
                        objY6 = cVarD.y(descriptor2, 1, o0.f952a, objY6);
                        i5 |= 2;
                        break;
                    case 2:
                        objY7 = cVarD.y(descriptor2, 2, o0.f952a, objY7);
                        i5 |= 4;
                        break;
                    case 3:
                        objY8 = cVarD.y(descriptor2, 3, o0.f952a, objY8);
                        i5 |= 8;
                        break;
                    case 4:
                        objY9 = cVarD.y(descriptor2, 4, H.f874a, objY9);
                        i5 |= 16;
                        break;
                    case 5:
                        objY10 = cVarD.y(descriptor2, 5, FontStyleDeserializer.INSTANCE, objY10);
                        i5 |= 32;
                        break;
                    default:
                        throw new j(i6);
                }
            }
            i4 = i5;
            str = strV;
            objY = objY6;
            objY2 = objY7;
            objY3 = objY8;
            objY4 = objY9;
            objY5 = objY10;
        }
        cVarD.c(descriptor2);
        return new UiConfig.AppConfig.FontsConfig.FontInfo.Name(i4, str, (String) objY, (String) objY2, (String) objY3, (Integer) objY4, (FontStyle) objY5, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(I3.f encoder, UiConfig.AppConfig.FontsConfig.FontInfo.Name value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        I3.d dVarD = encoder.d(descriptor2);
        UiConfig.AppConfig.FontsConfig.FontInfo.Name.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
