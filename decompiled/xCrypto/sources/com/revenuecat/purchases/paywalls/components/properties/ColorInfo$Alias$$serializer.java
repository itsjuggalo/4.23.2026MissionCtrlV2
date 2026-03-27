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
import com.revenuecat.purchases.ColorAlias;
import com.revenuecat.purchases.ColorAlias$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorInfo;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ColorInfo$Alias$$serializer implements C {
    public static final ColorInfo$Alias$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ColorInfo$Alias$$serializer colorInfo$Alias$$serializer = new ColorInfo$Alias$$serializer();
        INSTANCE = colorInfo$Alias$$serializer;
        C0327b0 c0327b0 = new C0327b0("alias", colorInfo$Alias$$serializer, 1);
        c0327b0.l("value", false);
        descriptor = c0327b0;
    }

    private ColorInfo$Alias$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{ColorAlias$$serializer.INSTANCE};
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // F3.a
    public ColorInfo.Alias deserialize(e decoder) {
        Object objM;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i4 = 1;
        k0 k0Var = null;
        Object[] objArr = 0;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, ColorAlias$$serializer.INSTANCE, null);
        } else {
            Object[] objArr2 = true;
            int i5 = 0;
            objM = null;
            while (objArr2 != false) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    objArr2 = false;
                } else {
                    if (i6 != 0) {
                        throw new j(i6);
                    }
                    objM = cVarD.m(descriptor2, 0, ColorAlias$$serializer.INSTANCE, objM);
                    i5 = 1;
                }
            }
            i4 = i5;
        }
        cVarD.c(descriptor2);
        ColorAlias colorAlias = (ColorAlias) objM;
        return new ColorInfo.Alias(i4, colorAlias != null ? colorAlias.m48unboximpl() : null, k0Var, objArr == true ? 1 : 0);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ColorInfo.Alias value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.u(descriptor2, 0, ColorAlias$$serializer.INSTANCE, ColorAlias.m42boximpl(value.value));
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
