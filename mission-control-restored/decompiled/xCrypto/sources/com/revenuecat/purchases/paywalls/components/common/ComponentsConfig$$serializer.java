package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ComponentsConfig$$serializer implements C {
    public static final ComponentsConfig$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ComponentsConfig$$serializer componentsConfig$$serializer = new ComponentsConfig$$serializer();
        INSTANCE = componentsConfig$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.common.ComponentsConfig", componentsConfig$$serializer, 1);
        c0327b0.l("base", false);
        descriptor = c0327b0;
    }

    private ComponentsConfig$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{PaywallComponentsConfig$$serializer.INSTANCE};
    }

    @Override // F3.a
    public ComponentsConfig deserialize(e decoder) {
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i4 = 1;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, PaywallComponentsConfig$$serializer.INSTANCE, null);
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
                    objM = cVarD.m(descriptor2, 0, PaywallComponentsConfig$$serializer.INSTANCE, objM);
                    i5 = 1;
                }
            }
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new ComponentsConfig(i4, (PaywallComponentsConfig) objM, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ComponentsConfig value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, PaywallComponentsConfig$$serializer.INSTANCE, value.base);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
