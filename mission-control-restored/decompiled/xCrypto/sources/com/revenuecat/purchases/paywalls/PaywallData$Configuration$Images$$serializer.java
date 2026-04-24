package com.revenuecat.purchases.paywalls;

import F3.b;
import F3.j;
import I3.c;
import I3.d;
import I3.e;
import I3.f;
import J3.C;
import J3.C0327b0;
import J3.k0;
import com.revenuecat.purchases.paywalls.PaywallData;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PaywallData$Configuration$Images$$serializer implements C {
    public static final PaywallData$Configuration$Images$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PaywallData$Configuration$Images$$serializer paywallData$Configuration$Images$$serializer = new PaywallData$Configuration$Images$$serializer();
        INSTANCE = paywallData$Configuration$Images$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.PaywallData.Configuration.Images", paywallData$Configuration$Images$$serializer, 3);
        c0327b0.l("header", true);
        c0327b0.l("background", true);
        c0327b0.l("icon", true);
        descriptor = c0327b0;
    }

    private PaywallData$Configuration$Images$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
        return new b[]{G3.a.p(emptyStringToNullSerializer), G3.a.p(emptyStringToNullSerializer), G3.a.p(emptyStringToNullSerializer)};
    }

    @Override // F3.a
    public PaywallData.Configuration.Images deserialize(e decoder) {
        Object objY;
        int i4;
        Object objY2;
        Object objY3;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objY4 = null;
        if (cVarD.w()) {
            EmptyStringToNullSerializer emptyStringToNullSerializer = EmptyStringToNullSerializer.INSTANCE;
            objY2 = cVarD.y(descriptor2, 0, emptyStringToNullSerializer, null);
            Object objY5 = cVarD.y(descriptor2, 1, emptyStringToNullSerializer, null);
            objY3 = cVarD.y(descriptor2, 2, emptyStringToNullSerializer, null);
            objY = objY5;
            i4 = 7;
        } else {
            boolean z4 = true;
            int i5 = 0;
            objY = null;
            Object objY6 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objY4 = cVarD.y(descriptor2, 0, EmptyStringToNullSerializer.INSTANCE, objY4);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objY = cVarD.y(descriptor2, 1, EmptyStringToNullSerializer.INSTANCE, objY);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    objY6 = cVarD.y(descriptor2, 2, EmptyStringToNullSerializer.INSTANCE, objY6);
                    i5 |= 4;
                }
            }
            i4 = i5;
            objY2 = objY4;
            objY3 = objY6;
        }
        cVarD.c(descriptor2);
        return new PaywallData.Configuration.Images(i4, (String) objY2, (String) objY, (String) objY3, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PaywallData.Configuration.Images value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PaywallData.Configuration.Images.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
