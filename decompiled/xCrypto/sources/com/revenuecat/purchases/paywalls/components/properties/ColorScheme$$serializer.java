package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.j;
import G3.a;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorScheme$$serializer implements C {
    public static final ColorScheme$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ColorScheme$$serializer colorScheme$$serializer = new ColorScheme$$serializer();
        INSTANCE = colorScheme$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.ColorScheme", colorScheme$$serializer, 2);
        c0327b0.l("light", false);
        c0327b0.l("dark", true);
        descriptor = c0327b0;
    }

    private ColorScheme$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = ColorScheme.$childSerializers;
        return new b[]{bVarArr[0], a.p(bVarArr[1])};
    }

    @Override // F3.a
    public ColorScheme deserialize(e decoder) {
        Object objY;
        Object objM;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = ColorScheme.$childSerializers;
        k0 k0Var = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, bVarArr[0], null);
            objY = cVarD.y(descriptor2, 1, bVarArr[1], null);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objY2 = null;
            Object objM2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM2 = cVarD.m(descriptor2, 0, bVarArr[0], objM2);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objY2 = cVarD.y(descriptor2, 1, bVarArr[1], objY2);
                    i5 |= 2;
                }
            }
            objY = objY2;
            objM = objM2;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new ColorScheme(i4, (ColorInfo) objM, (ColorInfo) objY, k0Var);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ColorScheme value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        ColorScheme.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
