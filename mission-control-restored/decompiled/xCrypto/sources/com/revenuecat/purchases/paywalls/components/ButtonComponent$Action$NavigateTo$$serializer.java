package com.revenuecat.purchases.paywalls.components;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.revenuecat.purchases.paywalls.components.ButtonComponent;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ButtonComponent$Action$NavigateTo$$serializer implements C {
    public static final ButtonComponent$Action$NavigateTo$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ButtonComponent$Action$NavigateTo$$serializer buttonComponent$Action$NavigateTo$$serializer = new ButtonComponent$Action$NavigateTo$$serializer();
        INSTANCE = buttonComponent$Action$NavigateTo$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.ButtonComponent.Action.NavigateTo", buttonComponent$Action$NavigateTo$$serializer, 1);
        c0327b0.l(FirebaseAnalytics.Param.DESTINATION, false);
        descriptor = c0327b0;
    }

    private ButtonComponent$Action$NavigateTo$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{ButtonComponent.Action.NavigateTo.$childSerializers[0]};
    }

    @Override // F3.a
    public ButtonComponent.Action.NavigateTo deserialize(e decoder) {
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = ButtonComponent.Action.NavigateTo.$childSerializers;
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
        return new ButtonComponent.Action.NavigateTo(i4, (ButtonComponent.Destination) objM, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ButtonComponent.Action.NavigateTo value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, ButtonComponent.Action.NavigateTo.$childSerializers[0], value.destination);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
