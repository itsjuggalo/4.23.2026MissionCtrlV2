package com.revenuecat.purchases;

import F3.j;
import J3.C;
import J3.C0327b0;
import com.revenuecat.purchases.UiConfig;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class UiConfig$AppConfig$FontsConfig$$serializer implements C {
    public static final UiConfig$AppConfig$FontsConfig$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        UiConfig$AppConfig$FontsConfig$$serializer uiConfig$AppConfig$FontsConfig$$serializer = new UiConfig$AppConfig$FontsConfig$$serializer();
        INSTANCE = uiConfig$AppConfig$FontsConfig$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.UiConfig.AppConfig.FontsConfig", uiConfig$AppConfig$FontsConfig$$serializer, 1);
        c0327b0.l("android", false);
        descriptor = c0327b0;
    }

    private UiConfig$AppConfig$FontsConfig$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        return new F3.b[]{UiConfig.AppConfig.FontsConfig.$childSerializers[0]};
    }

    @Override // F3.a
    public UiConfig.AppConfig.FontsConfig deserialize(I3.e decoder) {
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        I3.c cVarD = decoder.d(descriptor2);
        F3.b[] bVarArr = UiConfig.AppConfig.FontsConfig.$childSerializers;
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
        return new UiConfig.AppConfig.FontsConfig(i4, (UiConfig.AppConfig.FontsConfig.FontInfo) objM, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(I3.f encoder, UiConfig.AppConfig.FontsConfig value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        I3.d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, UiConfig.AppConfig.FontsConfig.$childSerializers[0], value.f11280android);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
