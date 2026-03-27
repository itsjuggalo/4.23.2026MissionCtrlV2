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
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class Dimension$ZLayer$$serializer implements C {
    public static final Dimension$ZLayer$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        Dimension$ZLayer$$serializer dimension$ZLayer$$serializer = new Dimension$ZLayer$$serializer();
        INSTANCE = dimension$ZLayer$$serializer;
        C0327b0 c0327b0 = new C0327b0("zlayer", dimension$ZLayer$$serializer, 1);
        c0327b0.l("alignment", false);
        descriptor = c0327b0;
    }

    private Dimension$ZLayer$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{TwoDimensionalAlignmentDeserializer.INSTANCE};
    }

    @Override // F3.a
    public Dimension.ZLayer deserialize(e decoder) {
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i4 = 1;
        k0 k0Var = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, TwoDimensionalAlignmentDeserializer.INSTANCE, null);
        } else {
            boolean z4 = true;
            int i5 = 0;
            objM = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else {
                    if (i6 != 0) {
                        throw new j(i6);
                    }
                    objM = cVarD.m(descriptor2, 0, TwoDimensionalAlignmentDeserializer.INSTANCE, objM);
                    i5 = 1;
                }
            }
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new Dimension.ZLayer(i4, (TwoDimensionalAlignment) objM, k0Var);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Dimension.ZLayer value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, TwoDimensionalAlignmentDeserializer.INSTANCE, value.alignment);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
