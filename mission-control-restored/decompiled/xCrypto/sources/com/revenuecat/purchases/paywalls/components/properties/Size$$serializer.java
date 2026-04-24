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
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class Size$$serializer implements C {
    public static final Size$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        Size$$serializer size$$serializer = new Size$$serializer();
        INSTANCE = size$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.Size", size$$serializer, 2);
        c0327b0.l("width", false);
        c0327b0.l("height", false);
        descriptor = c0327b0;
    }

    private Size$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        SizeConstraintDeserializer sizeConstraintDeserializer = SizeConstraintDeserializer.INSTANCE;
        return new b[]{sizeConstraintDeserializer, sizeConstraintDeserializer};
    }

    @Override // F3.a
    public Size deserialize(e decoder) {
        Object objM;
        int i4;
        Object objM2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        k0 k0Var = null;
        if (cVarD.w()) {
            SizeConstraintDeserializer sizeConstraintDeserializer = SizeConstraintDeserializer.INSTANCE;
            objM2 = cVarD.m(descriptor2, 0, sizeConstraintDeserializer, null);
            objM = cVarD.m(descriptor2, 1, sizeConstraintDeserializer, null);
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
                    objM3 = cVarD.m(descriptor2, 0, SizeConstraintDeserializer.INSTANCE, objM3);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objM = cVarD.m(descriptor2, 1, SizeConstraintDeserializer.INSTANCE, objM);
                    i5 |= 2;
                }
            }
            i4 = i5;
            objM2 = objM3;
        }
        cVarD.c(descriptor2);
        return new Size(i4, (SizeConstraint) objM2, (SizeConstraint) objM, k0Var);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Size value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        Size.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
