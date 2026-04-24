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
import J3.k0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class Padding$$serializer implements C {
    public static final Padding$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        Padding$$serializer padding$$serializer = new Padding$$serializer();
        INSTANCE = padding$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.Padding", padding$$serializer, 4);
        c0327b0.l("top", true);
        c0327b0.l("bottom", true);
        c0327b0.l("leading", true);
        c0327b0.l("trailing", true);
        descriptor = c0327b0;
    }

    private Padding$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        C0346t c0346t = C0346t.f970a;
        return new b[]{c0346t, c0346t, c0346t, c0346t};
    }

    @Override // F3.a
    public Padding deserialize(e decoder) {
        int i4;
        double dZ;
        double d4;
        double d5;
        double d6;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            double dZ2 = cVarD.z(descriptor2, 0);
            double dZ3 = cVarD.z(descriptor2, 1);
            double dZ4 = cVarD.z(descriptor2, 2);
            dZ = cVarD.z(descriptor2, 3);
            d4 = dZ4;
            d5 = dZ2;
            d6 = dZ3;
            i4 = 15;
        } else {
            double dZ5 = 0.0d;
            boolean z4 = true;
            int i5 = 0;
            double dZ6 = 0.0d;
            double dZ7 = 0.0d;
            double dZ8 = 0.0d;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    dZ7 = cVarD.z(descriptor2, 0);
                    i5 |= 1;
                } else if (i6 == 1) {
                    dZ8 = cVarD.z(descriptor2, 1);
                    i5 |= 2;
                } else if (i6 == 2) {
                    dZ6 = cVarD.z(descriptor2, 2);
                    i5 |= 4;
                } else {
                    if (i6 != 3) {
                        throw new j(i6);
                    }
                    dZ5 = cVarD.z(descriptor2, 3);
                    i5 |= 8;
                }
            }
            i4 = i5;
            dZ = dZ5;
            d4 = dZ6;
            d5 = dZ7;
            d6 = dZ8;
        }
        cVarD.c(descriptor2);
        return new Padding(i4, d5, d6, d4, dZ, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Padding value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        Padding.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
