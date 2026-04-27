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
import J3.k0;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorInfo$Gradient$Linear$$serializer implements C {
    public static final ColorInfo$Gradient$Linear$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ColorInfo$Gradient$Linear$$serializer colorInfo$Gradient$Linear$$serializer = new ColorInfo$Gradient$Linear$$serializer();
        INSTANCE = colorInfo$Gradient$Linear$$serializer;
        C0327b0 c0327b0 = new C0327b0("linear", colorInfo$Gradient$Linear$$serializer, 2);
        c0327b0.l("degrees", false);
        c0327b0.l("points", false);
        descriptor = c0327b0;
    }

    private ColorInfo$Gradient$Linear$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{B.f862a, ColorInfo.Gradient.Linear.$childSerializers[1]};
    }

    @Override // F3.a
    public ColorInfo.Gradient.Linear deserialize(e decoder) {
        Object objM;
        float fE;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = ColorInfo.Gradient.Linear.$childSerializers;
        k0 k0Var = null;
        if (cVarD.w()) {
            fE = cVarD.E(descriptor2, 0);
            objM = cVarD.m(descriptor2, 1, bVarArr[1], null);
            i4 = 3;
        } else {
            float fE2 = 0.0f;
            boolean z4 = true;
            int i5 = 0;
            Object objM2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    fE2 = cVarD.E(descriptor2, 0);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objM2 = cVarD.m(descriptor2, 1, bVarArr[1], objM2);
                    i5 |= 2;
                }
            }
            objM = objM2;
            fE = fE2;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new ColorInfo.Gradient.Linear(i4, fE, (List) objM, k0Var);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ColorInfo.Gradient.Linear value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        ColorInfo.Gradient.Linear.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
