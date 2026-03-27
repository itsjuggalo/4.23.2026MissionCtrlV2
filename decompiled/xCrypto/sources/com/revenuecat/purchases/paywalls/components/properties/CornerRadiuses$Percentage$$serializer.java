package com.revenuecat.purchases.paywalls.components.properties;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.H;
import com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class CornerRadiuses$Percentage$$serializer implements C {
    public static final CornerRadiuses$Percentage$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CornerRadiuses$Percentage$$serializer cornerRadiuses$Percentage$$serializer = new CornerRadiuses$Percentage$$serializer();
        INSTANCE = cornerRadiuses$Percentage$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.properties.CornerRadiuses.Percentage", cornerRadiuses$Percentage$$serializer, 4);
        c0327b0.l("top_leading", false);
        c0327b0.l("top_trailing", false);
        c0327b0.l("bottom_leading", false);
        c0327b0.l("bottom_trailing", false);
        descriptor = c0327b0;
    }

    private CornerRadiuses$Percentage$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        H h4 = H.f874a;
        return new b[]{h4, h4, h4, h4};
    }

    @Override // F3.a
    public CornerRadiuses.Percentage deserialize(e decoder) {
        int iH;
        int iH2;
        int i4;
        int i5;
        int i6;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            iH = cVarD.h(descriptor2, 0);
            int iH3 = cVarD.h(descriptor2, 1);
            int iH4 = cVarD.h(descriptor2, 2);
            iH2 = cVarD.h(descriptor2, 3);
            i4 = iH4;
            i5 = iH3;
            i6 = 15;
        } else {
            boolean z4 = true;
            iH = 0;
            int iH5 = 0;
            int iH6 = 0;
            int iH7 = 0;
            int i7 = 0;
            while (z4) {
                int i8 = cVarD.i(descriptor2);
                if (i8 == -1) {
                    z4 = false;
                } else if (i8 == 0) {
                    iH = cVarD.h(descriptor2, 0);
                    i7 |= 1;
                } else if (i8 == 1) {
                    iH7 = cVarD.h(descriptor2, 1);
                    i7 |= 2;
                } else if (i8 == 2) {
                    iH6 = cVarD.h(descriptor2, 2);
                    i7 |= 4;
                } else {
                    if (i8 != 3) {
                        throw new j(i8);
                    }
                    iH5 = cVarD.h(descriptor2, 3);
                    i7 |= 8;
                }
            }
            iH2 = iH5;
            i4 = iH6;
            i5 = iH7;
            i6 = i7;
        }
        int i9 = iH;
        cVarD.c(descriptor2);
        return new CornerRadiuses.Percentage(i6, i9, i5, i4, iH2, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CornerRadiuses.Percentage value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CornerRadiuses.Percentage.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
