package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.w0;
import W2.w;
import com.revenuecat.purchases.paywalls.components.properties.SizeConstraint;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class SizeConstraint$Fixed$$serializer implements C {
    public static final SizeConstraint$Fixed$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        SizeConstraint$Fixed$$serializer sizeConstraint$Fixed$$serializer = new SizeConstraint$Fixed$$serializer();
        INSTANCE = sizeConstraint$Fixed$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.SizeConstraint.Fixed", sizeConstraint$Fixed$$serializer, 1);
        c0327b0.l("value", false);
        descriptor = c0327b0;
    }

    private SizeConstraint$Fixed$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{w0.f990a};
    }

    @Override // F3.a
    public SizeConstraint.Fixed deserialize(e decoder) {
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i4 = 1;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, w0.f990a, null);
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
                    objM = cVarD.m(descriptor2, 0, w0.f990a, objM);
                    i5 = 1;
                }
            }
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new SizeConstraint.Fixed(i4, (w) objM, null, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, SizeConstraint.Fixed value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, w0.f990a, w.a(value.value));
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
