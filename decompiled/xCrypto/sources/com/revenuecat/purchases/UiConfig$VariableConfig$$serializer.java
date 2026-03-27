package com.revenuecat.purchases;

import F3.j;
import J3.C;
import J3.C0327b0;
import J3.k0;
import com.revenuecat.purchases.UiConfig;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class UiConfig$VariableConfig$$serializer implements C {
    public static final UiConfig$VariableConfig$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        UiConfig$VariableConfig$$serializer uiConfig$VariableConfig$$serializer = new UiConfig$VariableConfig$$serializer();
        INSTANCE = uiConfig$VariableConfig$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.UiConfig.VariableConfig", uiConfig$VariableConfig$$serializer, 2);
        c0327b0.l("variable_compatibility_map", true);
        c0327b0.l("function_compatibility_map", true);
        descriptor = c0327b0;
    }

    private UiConfig$VariableConfig$$serializer() {
    }

    @Override // J3.C
    public F3.b[] childSerializers() {
        F3.b[] bVarArr = UiConfig.VariableConfig.$childSerializers;
        return new F3.b[]{bVarArr[0], bVarArr[1]};
    }

    @Override // F3.a
    public UiConfig.VariableConfig deserialize(I3.e decoder) {
        Object objM;
        Object objM2;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        I3.c cVarD = decoder.d(descriptor2);
        F3.b[] bVarArr = UiConfig.VariableConfig.$childSerializers;
        if (cVarD.w()) {
            objM2 = cVarD.m(descriptor2, 0, bVarArr[0], null);
            objM = cVarD.m(descriptor2, 1, bVarArr[1], null);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM3 = null;
            Object objM4 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM4 = cVarD.m(descriptor2, 0, bVarArr[0], objM4);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objM3 = cVarD.m(descriptor2, 1, bVarArr[1], objM3);
                    i5 |= 2;
                }
            }
            objM = objM3;
            objM2 = objM4;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new UiConfig.VariableConfig(i4, (Map) objM2, (Map) objM, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(I3.f encoder, UiConfig.VariableConfig value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        I3.d dVarD = encoder.d(descriptor2);
        UiConfig.VariableConfig.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public F3.b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
