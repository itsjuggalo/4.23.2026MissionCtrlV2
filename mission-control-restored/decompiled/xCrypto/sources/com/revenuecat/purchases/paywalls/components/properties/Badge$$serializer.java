package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.StackComponent$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class Badge$$serializer implements C {
    public static final Badge$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        Badge$$serializer badge$$serializer = new Badge$$serializer();
        INSTANCE = badge$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.Badge", badge$$serializer, 3);
        c0327b0.l("stack", false);
        c0327b0.l("style", false);
        c0327b0.l("alignment", false);
        descriptor = c0327b0;
    }

    private Badge$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{StackComponent$$serializer.INSTANCE, BadgeStyleSerializer.INSTANCE, TwoDimensionalAlignmentDeserializer.INSTANCE};
    }

    @Override // F3.a
    public Badge deserialize(e decoder) {
        int i4;
        Object objM;
        Object objM2;
        Object objM3;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objM4 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, StackComponent$$serializer.INSTANCE, null);
            objM2 = cVarD.m(descriptor2, 1, BadgeStyleSerializer.INSTANCE, null);
            objM3 = cVarD.m(descriptor2, 2, TwoDimensionalAlignmentDeserializer.INSTANCE, null);
            i4 = 7;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM5 = null;
            Object objM6 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM4 = cVarD.m(descriptor2, 0, StackComponent$$serializer.INSTANCE, objM4);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM5 = cVarD.m(descriptor2, 1, BadgeStyleSerializer.INSTANCE, objM5);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    objM6 = cVarD.m(descriptor2, 2, TwoDimensionalAlignmentDeserializer.INSTANCE, objM6);
                    i5 |= 4;
                }
            }
            Object obj = objM4;
            i4 = i5;
            objM = obj;
            objM2 = objM5;
            objM3 = objM6;
        }
        cVarD.c(descriptor2);
        return new Badge(i4, (StackComponent) objM, (Badge.Style) objM2, (TwoDimensionalAlignment) objM3, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Badge value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        Badge.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
