package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.j;
import G3.a;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.C0335h;
import J3.o0;
import com.revenuecat.purchases.common.diagnostics.DiagnosticsEntry;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ButtonComponent$Destination$Sheet$$serializer implements C {
    public static final ButtonComponent$Destination$Sheet$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ButtonComponent$Destination$Sheet$$serializer buttonComponent$Destination$Sheet$$serializer = new ButtonComponent$Destination$Sheet$$serializer();
        INSTANCE = buttonComponent$Destination$Sheet$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Destination.Sheet", buttonComponent$Destination$Sheet$$serializer, 5);
        c0327b0.l(DiagnosticsEntry.ID_KEY, false);
        c0327b0.l("name", false);
        c0327b0.l("stack", false);
        c0327b0.l("background_blur", false);
        c0327b0.l("size", false);
        descriptor = c0327b0;
    }

    private ButtonComponent$Destination$Sheet$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        o0 o0Var = o0.f952a;
        return new b[]{o0Var, a.p(o0Var), StackComponent$$serializer.INSTANCE, C0335h.f929a, a.p(Size$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public ButtonComponent.Destination.Sheet deserialize(e decoder) {
        boolean z4;
        int i4;
        String str;
        Object objY;
        Object objM;
        Object objY2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            String strV = cVarD.v(descriptor2, 0);
            objY = cVarD.y(descriptor2, 1, o0.f952a, null);
            objM = cVarD.m(descriptor2, 2, StackComponent$$serializer.INSTANCE, null);
            boolean zN = cVarD.n(descriptor2, 3);
            objY2 = cVarD.y(descriptor2, 4, Size$$serializer.INSTANCE, null);
            str = strV;
            z4 = zN;
            i4 = 31;
        } else {
            boolean z5 = true;
            boolean zN2 = false;
            String strV2 = null;
            Object objY3 = null;
            Object objM2 = null;
            Object objY4 = null;
            int i5 = 0;
            while (z5) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z5 = false;
                } else if (i6 == 0) {
                    strV2 = cVarD.v(descriptor2, 0);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objY3 = cVarD.y(descriptor2, 1, o0.f952a, objY3);
                    i5 |= 2;
                } else if (i6 == 2) {
                    objM2 = cVarD.m(descriptor2, 2, StackComponent$$serializer.INSTANCE, objM2);
                    i5 |= 4;
                } else if (i6 == 3) {
                    zN2 = cVarD.n(descriptor2, 3);
                    i5 |= 8;
                } else {
                    if (i6 != 4) {
                        throw new j(i6);
                    }
                    objY4 = cVarD.y(descriptor2, 4, Size$$serializer.INSTANCE, objY4);
                    i5 |= 16;
                }
            }
            z4 = zN2;
            i4 = i5;
            str = strV2;
            objY = objY3;
            objM = objM2;
            objY2 = objY4;
        }
        cVarD.c(descriptor2);
        return new ButtonComponent.Destination.Sheet(i4, str, (String) objY, (StackComponent) objM, z4, (Size) objY2, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ButtonComponent.Destination.Sheet value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        ButtonComponent.Destination.Sheet.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
