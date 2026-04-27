package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.B;
import J3.C;
import J3.C0327b0;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorInfo$Gradient$Point$$serializer implements C {
    public static final ColorInfo$Gradient$Point$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ColorInfo$Gradient$Point$$serializer colorInfo$Gradient$Point$$serializer = new ColorInfo$Gradient$Point$$serializer();
        INSTANCE = colorInfo$Gradient$Point$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.ColorInfo.Gradient.Point", colorInfo$Gradient$Point$$serializer, 2);
        c0327b0.l("color", false);
        c0327b0.l("percent", false);
        descriptor = c0327b0;
    }

    private ColorInfo$Gradient$Point$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{RgbaStringArgbColorIntDeserializer.INSTANCE, B.f862a};
    }

    @Override // F3.a
    public ColorInfo.Gradient.Point deserialize(e decoder) {
        int iIntValue;
        float fE;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            iIntValue = ((Number) cVarD.m(descriptor2, 0, RgbaStringArgbColorIntDeserializer.INSTANCE, 0)).intValue();
            fE = cVarD.E(descriptor2, 1);
            i4 = 3;
        } else {
            float fE2 = 0.0f;
            boolean z4 = true;
            iIntValue = 0;
            int i5 = 0;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    iIntValue = ((Number) cVarD.m(descriptor2, 0, RgbaStringArgbColorIntDeserializer.INSTANCE, Integer.valueOf(iIntValue))).intValue();
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    fE2 = cVarD.E(descriptor2, 1);
                    i5 |= 2;
                }
            }
            fE = fE2;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new ColorInfo.Gradient.Point(i4, iIntValue, fE, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ColorInfo.Gradient.Point value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        ColorInfo.Gradient.Point.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
