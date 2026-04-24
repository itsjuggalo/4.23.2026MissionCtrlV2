package com.revenuecat.purchases.virtualcurrencies;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class VirtualCurrencies$$serializer implements C {
    public static final VirtualCurrencies$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        VirtualCurrencies$$serializer virtualCurrencies$$serializer = new VirtualCurrencies$$serializer();
        INSTANCE = virtualCurrencies$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.virtualcurrencies.VirtualCurrencies", virtualCurrencies$$serializer, 1);
        c0327b0.l("virtual_currencies", false);
        descriptor = c0327b0;
    }

    private VirtualCurrencies$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{VirtualCurrencies.$childSerializers[0]};
    }

    @Override // F3.a
    public VirtualCurrencies deserialize(e decoder) {
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = VirtualCurrencies.$childSerializers;
        int i4 = 1;
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
        return new VirtualCurrencies(i4, (Map) objM, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, VirtualCurrencies value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, VirtualCurrencies.$childSerializers[0], value.all);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
