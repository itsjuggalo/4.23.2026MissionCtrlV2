package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.H;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class TabControlButtonComponent$$serializer implements C {
    public static final TabControlButtonComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        TabControlButtonComponent$$serializer tabControlButtonComponent$$serializer = new TabControlButtonComponent$$serializer();
        INSTANCE = tabControlButtonComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("tab_control_button", tabControlButtonComponent$$serializer, 2);
        c0327b0.l("tab_index", false);
        c0327b0.l("stack", false);
        descriptor = c0327b0;
    }

    private TabControlButtonComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{H.f874a, StackComponent$$serializer.INSTANCE};
    }

    @Override // F3.a
    public TabControlButtonComponent deserialize(e decoder) {
        int iH;
        Object objM;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            iH = cVarD.h(descriptor2, 0);
            objM = cVarD.m(descriptor2, 1, StackComponent$$serializer.INSTANCE, null);
            i4 = 3;
        } else {
            boolean z4 = true;
            iH = 0;
            int i5 = 0;
            Object objM2 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    iH = cVarD.h(descriptor2, 0);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objM2 = cVarD.m(descriptor2, 1, StackComponent$$serializer.INSTANCE, objM2);
                    i5 |= 2;
                }
            }
            objM = objM2;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new TabControlButtonComponent(i4, iH, (StackComponent) objM, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, TabControlButtonComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        TabControlButtonComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
