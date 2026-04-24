package com.revenuecat.purchases.paywalls.components.common;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.o0;
import com.revenuecat.purchases.paywalls.components.common.Background;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class Background$Unknown$$serializer implements C {
    public static final Background$Unknown$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        Background$Unknown$$serializer background$Unknown$$serializer = new Background$Unknown$$serializer();
        INSTANCE = background$Unknown$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.common.Background.Unknown", background$Unknown$$serializer, 1);
        c0327b0.l("type", false);
        descriptor = c0327b0;
    }

    private Background$Unknown$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{o0.f952a};
    }

    @Override // F3.a
    public Background.Unknown deserialize(e decoder) {
        String strV;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i4 = 1;
        if (cVarD.w()) {
            strV = cVarD.v(descriptor2, 0);
        } else {
            boolean z4 = true;
            int i5 = 0;
            strV = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else {
                    if (i6 != 0) {
                        throw new j(i6);
                    }
                    strV = cVarD.v(descriptor2, 0);
                    i5 = 1;
                }
            }
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new Background.Unknown(i4, strV, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, Background.Unknown value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        dVarD.o(descriptor2, 0, value.type);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
