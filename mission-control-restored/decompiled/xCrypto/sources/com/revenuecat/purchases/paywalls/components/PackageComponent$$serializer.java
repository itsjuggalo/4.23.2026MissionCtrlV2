package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0335h;
import J3.o0;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PackageComponent$$serializer implements C {
    public static final PackageComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PackageComponent$$serializer packageComponent$$serializer = new PackageComponent$$serializer();
        INSTANCE = packageComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("package", packageComponent$$serializer, 3);
        c0327b0.l("package_id", false);
        c0327b0.l("is_selected_by_default", false);
        c0327b0.l("stack", false);
        descriptor = c0327b0;
    }

    private PackageComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{o0.f952a, C0335h.f929a, StackComponent$$serializer.INSTANCE};
    }

    @Override // F3.a
    public PackageComponent deserialize(e decoder) {
        boolean z4;
        int i4;
        String str;
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            String strV = cVarD.v(descriptor2, 0);
            boolean zN = cVarD.n(descriptor2, 1);
            objM = cVarD.m(descriptor2, 2, StackComponent$$serializer.INSTANCE, null);
            str = strV;
            z4 = zN;
            i4 = 7;
        } else {
            boolean z5 = true;
            boolean zN2 = false;
            String strV2 = null;
            Object objM2 = null;
            int i5 = 0;
            while (z5) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z5 = false;
                } else if (i6 == 0) {
                    strV2 = cVarD.v(descriptor2, 0);
                    i5 |= 1;
                } else if (i6 == 1) {
                    zN2 = cVarD.n(descriptor2, 1);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    objM2 = cVarD.m(descriptor2, 2, StackComponent$$serializer.INSTANCE, objM2);
                    i5 |= 4;
                }
            }
            z4 = zN2;
            i4 = i5;
            str = strV2;
            objM = objM2;
        }
        cVarD.c(descriptor2);
        return new PackageComponent(i4, str, z4, (StackComponent) objM, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PackageComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PackageComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
