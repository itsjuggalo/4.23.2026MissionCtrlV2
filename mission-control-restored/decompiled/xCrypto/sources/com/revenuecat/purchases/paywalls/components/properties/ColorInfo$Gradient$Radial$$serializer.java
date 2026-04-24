package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorInfo$Gradient$Radial$$serializer implements C {
    public static final ColorInfo$Gradient$Radial$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ColorInfo$Gradient$Radial$$serializer colorInfo$Gradient$Radial$$serializer = new ColorInfo$Gradient$Radial$$serializer();
        INSTANCE = colorInfo$Gradient$Radial$$serializer;
        C0327b0 c0327b0 = new C0327b0("radial", colorInfo$Gradient$Radial$$serializer, 1);
        c0327b0.l("points", false);
        descriptor = c0327b0;
    }

    private ColorInfo$Gradient$Radial$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{ColorInfo.Gradient.Radial.$childSerializers[0]};
    }

    @Override // F3.a
    public ColorInfo.Gradient.Radial deserialize(e decoder) {
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = ColorInfo.Gradient.Radial.$childSerializers;
        int i4 = 1;
        k0 k0Var = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, bVarArr[0], null);
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else {
                    if (i6 != 0) {
                        throw new j(i6);
                    }
                    objM2 = cVarD.m(descriptor2, 0, bVarArr[0], objM2);
                    i5 = 1;
                }
            }
            objM = objM2;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new ColorInfo.Gradient.Radial(i4, (List) objM, k0Var);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ColorInfo.Gradient.Radial value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, ColorInfo.Gradient.Radial.$childSerializers[0], value.points);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
