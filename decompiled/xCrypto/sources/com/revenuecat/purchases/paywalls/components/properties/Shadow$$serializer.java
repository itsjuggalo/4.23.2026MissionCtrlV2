package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0346t;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class Shadow$$serializer implements C {
    public static final Shadow$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        Shadow$$serializer shadow$$serializer = new Shadow$$serializer();
        INSTANCE = shadow$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.Shadow", shadow$$serializer, 4);
        c0327b0.l("color", false);
        c0327b0.l("radius", false);
        c0327b0.l("x", false);
        c0327b0.l("y", false);
        descriptor = c0327b0;
    }

    private Shadow$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        C0346t c0346t = C0346t.f970a;
        return new b[]{ColorScheme$$serializer.INSTANCE, c0346t, c0346t, c0346t};
    }

    @Override // F3.a
    public Shadow deserialize(e decoder) {
        int i4;
        Object objM;
        double d4;
        double dZ;
        double d5;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objM2 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, ColorScheme$$serializer.INSTANCE, null);
            double dZ2 = cVarD.z(descriptor2, 1);
            double dZ3 = cVarD.z(descriptor2, 2);
            dZ = cVarD.z(descriptor2, 3);
            i4 = 15;
            d5 = dZ3;
            d4 = dZ2;
        } else {
            double dZ4 = 0.0d;
            boolean z4 = true;
            int i5 = 0;
            double dZ5 = 0.0d;
            double dZ6 = 0.0d;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM2 = cVarD.m(descriptor2, 0, ColorScheme$$serializer.INSTANCE, objM2);
                    i5 |= 1;
                } else if (i6 == 1) {
                    dZ5 = cVarD.z(descriptor2, 1);
                    i5 |= 2;
                } else if (i6 == 2) {
                    dZ6 = cVarD.z(descriptor2, 2);
                    i5 |= 4;
                } else {
                    if (i6 != 3) {
                        throw new j(i6);
                    }
                    dZ4 = cVarD.z(descriptor2, 3);
                    i5 |= 8;
                }
            }
            i4 = i5;
            objM = objM2;
            d4 = dZ5;
            dZ = dZ4;
            d5 = dZ6;
        }
        cVarD.c(descriptor2);
        return new Shadow(i4, (ColorScheme) objM, d4, d5, dZ, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Shadow value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        Shadow.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
