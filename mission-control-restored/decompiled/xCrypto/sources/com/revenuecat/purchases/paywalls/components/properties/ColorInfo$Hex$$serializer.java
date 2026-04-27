package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorInfo$Hex$$serializer implements C {
    public static final ColorInfo$Hex$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ColorInfo$Hex$$serializer colorInfo$Hex$$serializer = new ColorInfo$Hex$$serializer();
        INSTANCE = colorInfo$Hex$$serializer;
        C0327b0 c0327b0 = new C0327b0("hex", colorInfo$Hex$$serializer, 1);
        c0327b0.l("value", false);
        descriptor = c0327b0;
    }

    private ColorInfo$Hex$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{RgbaStringArgbColorIntDeserializer.INSTANCE};
    }

    @Override // F3.a
    public ColorInfo.Hex deserialize(e decoder) {
        int iIntValue;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i4 = 1;
        if (cVarD.w()) {
            iIntValue = ((Number) cVarD.m(descriptor2, 0, RgbaStringArgbColorIntDeserializer.INSTANCE, 0)).intValue();
        } else {
            boolean z4 = true;
            iIntValue = 0;
            int i5 = 0;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else {
                    if (i6 != 0) {
                        throw new j(i6);
                    }
                    iIntValue = ((Number) cVarD.m(descriptor2, 0, RgbaStringArgbColorIntDeserializer.INSTANCE, Integer.valueOf(iIntValue))).intValue();
                    i5 = 1;
                }
            }
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new ColorInfo.Hex(i4, iIntValue, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ColorInfo.Hex value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, RgbaStringArgbColorIntDeserializer.INSTANCE, Integer.valueOf(value.value));
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
