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
public final class Border$$serializer implements C {
    public static final Border$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        Border$$serializer border$$serializer = new Border$$serializer();
        INSTANCE = border$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.Border", border$$serializer, 2);
        c0327b0.l("color", false);
        c0327b0.l("width", false);
        descriptor = c0327b0;
    }

    private Border$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{ColorScheme$$serializer.INSTANCE, C0346t.f970a};
    }

    @Override // F3.a
    public Border deserialize(e decoder) {
        double dZ;
        Object objM;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, ColorScheme$$serializer.INSTANCE, null);
            i4 = 3;
            dZ = cVarD.z(descriptor2, 1);
        } else {
            dZ = 0.0d;
            boolean z4 = true;
            objM = null;
            i4 = 0;
            while (z4) {
                int i5 = cVarD.i(descriptor2);
                if (i5 == -1) {
                    z4 = false;
                } else if (i5 == 0) {
                    objM = cVarD.m(descriptor2, 0, ColorScheme$$serializer.INSTANCE, objM);
                    i4 |= 1;
                } else {
                    if (i5 != 1) {
                        throw new j(i5);
                    }
                    dZ = cVarD.z(descriptor2, 1);
                    i4 |= 2;
                }
            }
        }
        int i6 = i4;
        cVarD.c(descriptor2);
        return new Border(i6, (ColorScheme) objM, dZ, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Border value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        Border.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
