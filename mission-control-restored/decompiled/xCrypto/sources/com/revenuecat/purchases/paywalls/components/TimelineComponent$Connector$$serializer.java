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
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class TimelineComponent$Connector$$serializer implements C {
    public static final TimelineComponent$Connector$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        TimelineComponent$Connector$$serializer timelineComponent$Connector$$serializer = new TimelineComponent$Connector$$serializer();
        INSTANCE = timelineComponent$Connector$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.TimelineComponent.Connector", timelineComponent$Connector$$serializer, 3);
        c0327b0.l("width", false);
        c0327b0.l("margin", false);
        c0327b0.l("color", false);
        descriptor = c0327b0;
    }

    private TimelineComponent$Connector$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{H.f874a, Padding$$serializer.INSTANCE, ColorScheme$$serializer.INSTANCE};
    }

    @Override // F3.a
    public TimelineComponent.Connector deserialize(e decoder) {
        int iH;
        int i4;
        Object objM;
        Object objM2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            iH = cVarD.h(descriptor2, 0);
            objM = cVarD.m(descriptor2, 1, Padding$$serializer.INSTANCE, null);
            objM2 = cVarD.m(descriptor2, 2, ColorScheme$$serializer.INSTANCE, null);
            i4 = 7;
        } else {
            boolean z4 = true;
            iH = 0;
            Object objM3 = null;
            Object objM4 = null;
            int i5 = 0;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    iH = cVarD.h(descriptor2, 0);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM3 = cVarD.m(descriptor2, 1, Padding$$serializer.INSTANCE, objM3);
                    i5 |= 2;
                } else {
                    if (i6 != 2) {
                        throw new j(i6);
                    }
                    objM4 = cVarD.m(descriptor2, 2, ColorScheme$$serializer.INSTANCE, objM4);
                    i5 |= 4;
                }
            }
            i4 = i5;
            objM = objM3;
            objM2 = objM4;
        }
        int i7 = iH;
        cVarD.c(descriptor2);
        return new TimelineComponent.Connector(i4, i7, (Padding) objM, (ColorScheme) objM2, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, TimelineComponent.Connector value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        TimelineComponent.Connector.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
