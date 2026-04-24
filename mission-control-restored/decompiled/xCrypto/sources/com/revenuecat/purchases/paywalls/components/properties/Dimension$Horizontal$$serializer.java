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
public final class Dimension$Horizontal$$serializer implements C {
    public static final Dimension$Horizontal$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        Dimension$Horizontal$$serializer dimension$Horizontal$$serializer = new Dimension$Horizontal$$serializer();
        INSTANCE = dimension$Horizontal$$serializer;
        C0327b0 c0327b0 = new C0327b0("horizontal", dimension$Horizontal$$serializer, 2);
        c0327b0.l("alignment", false);
        c0327b0.l("distribution", false);
        descriptor = c0327b0;
    }

    private Dimension$Horizontal$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{VerticalAlignmentDeserializer.INSTANCE, FlexDistributionDeserializer.INSTANCE};
    }

    @Override // F3.a
    public Dimension.Horizontal deserialize(e decoder) {
        Object objM;
        Object objM2;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        k0 k0Var = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, VerticalAlignmentDeserializer.INSTANCE, null);
            objM2 = cVarD.m(descriptor2, 1, FlexDistributionDeserializer.INSTANCE, null);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            objM = null;
            Object objM3 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM = cVarD.m(descriptor2, 0, VerticalAlignmentDeserializer.INSTANCE, objM);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objM3 = cVarD.m(descriptor2, 1, FlexDistributionDeserializer.INSTANCE, objM3);
                    i5 |= 2;
                }
            }
            objM2 = objM3;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new Dimension.Horizontal(i4, (VerticalAlignment) objM, (FlexDistribution) objM2, k0Var);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Dimension.Horizontal value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        Dimension.Horizontal.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
