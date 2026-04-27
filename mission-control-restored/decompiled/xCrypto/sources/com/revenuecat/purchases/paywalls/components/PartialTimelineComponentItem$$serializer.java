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
import J3.k0;
import com.revenuecat.purchases.paywalls.components.TimelineComponent;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PartialTimelineComponentItem$$serializer implements C {
    public static final PartialTimelineComponentItem$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PartialTimelineComponentItem$$serializer partialTimelineComponentItem$$serializer = new PartialTimelineComponentItem$$serializer();
        INSTANCE = partialTimelineComponentItem$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.PartialTimelineComponentItem", partialTimelineComponentItem$$serializer, 2);
        c0327b0.l("visible", true);
        c0327b0.l("connector", true);
        descriptor = c0327b0;
    }

    private PartialTimelineComponentItem$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        return new b[]{a.p(C0335h.f929a), a.p(TimelineComponent$Connector$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public PartialTimelineComponentItem deserialize(e decoder) {
        Object objY;
        Object objY2;
        int i4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        k0 k0Var = null;
        if (cVarD.w()) {
            objY = cVarD.y(descriptor2, 0, C0335h.f929a, null);
            objY2 = cVarD.y(descriptor2, 1, TimelineComponent$Connector$$serializer.INSTANCE, null);
            i4 = 3;
        } else {
            boolean z4 = true;
            int i5 = 0;
            objY = null;
            Object objY3 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objY = cVarD.y(descriptor2, 0, C0335h.f929a, objY);
                    i5 |= 1;
                } else {
                    if (i6 != 1) {
                        throw new j(i6);
                    }
                    objY3 = cVarD.y(descriptor2, 1, TimelineComponent$Connector$$serializer.INSTANCE, objY3);
                    i5 |= 2;
                }
            }
            objY2 = objY3;
            i4 = i5;
        }
        cVarD.c(descriptor2);
        return new PartialTimelineComponentItem(i4, (Boolean) objY, (TimelineComponent.Connector) objY2, k0Var);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PartialTimelineComponentItem value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PartialTimelineComponentItem.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
