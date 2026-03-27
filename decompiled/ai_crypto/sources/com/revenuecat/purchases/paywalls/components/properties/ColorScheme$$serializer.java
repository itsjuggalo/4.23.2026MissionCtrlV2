package com.revenuecat.purchases.paywalls.components.properties;

import kotlin.jvm.internal.r;
import n6.b;
import n6.j;
import o6.a;
import q6.c;
import q6.d;
import q6.e;
import q6.f;
import r6.C;
import r6.C2613b0;
import r6.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class ColorScheme$$serializer implements C {
    public static final ColorScheme$$serializer INSTANCE;
    private static final /* synthetic */ C2613b0 descriptor;

    static {
        ColorScheme$$serializer colorScheme$$serializer = new ColorScheme$$serializer();
        INSTANCE = colorScheme$$serializer;
        C2613b0 c2613b0 = new C2613b0("com.revenuecat.purchases.paywalls.components.properties.ColorScheme", colorScheme$$serializer, 2);
        c2613b0.l("light", false);
        c2613b0.l("dark", true);
        descriptor = c2613b0;
    }

    private ColorScheme$$serializer() {
    }

    @Override // r6.C
    public b[] childSerializers() {
        b[] bVarArr = ColorScheme.$childSerializers;
        return new b[]{bVarArr[0], a.p(bVarArr[1])};
    }

    @Override // n6.a
    public ColorScheme deserialize(e decoder) {
        Object objY;
        Object objA;
        int i7;
        r.f(decoder, "decoder");
        p6.e descriptor2 = getDescriptor();
        c cVarC = decoder.c(descriptor2);
        b[] bVarArr = ColorScheme.$childSerializers;
        k0 k0Var = null;
        if (cVarC.w()) {
            objA = cVarC.A(descriptor2, 0, bVarArr[0], null);
            objY = cVarC.y(descriptor2, 1, bVarArr[1], null);
            i7 = 3;
        } else {
            boolean z7 = true;
            int i8 = 0;
            Object objY2 = null;
            Object objA2 = null;
            while (z7) {
                int iQ = cVarC.q(descriptor2);
                if (iQ == -1) {
                    z7 = false;
                } else if (iQ == 0) {
                    objA2 = cVarC.A(descriptor2, 0, bVarArr[0], objA2);
                    i8 |= 1;
                } else {
                    if (iQ != 1) {
                        throw new j(iQ);
                    }
                    objY2 = cVarC.y(descriptor2, 1, bVarArr[1], objY2);
                    i8 |= 2;
                }
            }
            objY = objY2;
            objA = objA2;
            i7 = i8;
        }
        cVarC.b(descriptor2);
        return new ColorScheme(i7, (ColorInfo) objA, (ColorInfo) objY, k0Var);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return descriptor;
    }

    @Override // n6.h
    public void serialize(f encoder, ColorScheme value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        p6.e descriptor2 = getDescriptor();
        d dVarC = encoder.c(descriptor2);
        ColorScheme.write$Self(value, dVarC, descriptor2);
        dVarC.b(descriptor2);
    }

    @Override // r6.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
