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
import J3.H;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class CarouselComponent$AutoAdvancePages$$serializer implements C {
    public static final CarouselComponent$AutoAdvancePages$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CarouselComponent$AutoAdvancePages$$serializer carouselComponent$AutoAdvancePages$$serializer = new CarouselComponent$AutoAdvancePages$$serializer();
        INSTANCE = carouselComponent$AutoAdvancePages$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.CarouselComponent.AutoAdvancePages", carouselComponent$AutoAdvancePages$$serializer, 3);
        c0327b0.l("ms_time_per_page", false);
        c0327b0.l("ms_transition_time", false);
        c0327b0.l("transition_type", false);
        descriptor = c0327b0;
    }

    private CarouselComponent$AutoAdvancePages$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVarP = a.p(CarouselTransitionTypeDeserializer.INSTANCE);
        H h4 = H.f874a;
        return new b[]{h4, h4, bVarP};
    }

    @Override // F3.a
    public CarouselComponent.AutoAdvancePages deserialize(e decoder) {
        int iH;
        int i4;
        int i5;
        Object objY;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        if (cVarD.w()) {
            iH = cVarD.h(descriptor2, 0);
            int iH2 = cVarD.h(descriptor2, 1);
            objY = cVarD.y(descriptor2, 2, CarouselTransitionTypeDeserializer.INSTANCE, null);
            i4 = iH2;
            i5 = 7;
        } else {
            boolean z4 = true;
            iH = 0;
            int i6 = 0;
            Object objY2 = null;
            int iH3 = 0;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                if (i7 == -1) {
                    z4 = false;
                } else if (i7 == 0) {
                    iH = cVarD.h(descriptor2, 0);
                    i6 |= 1;
                } else if (i7 == 1) {
                    iH3 = cVarD.h(descriptor2, 1);
                    i6 |= 2;
                } else {
                    if (i7 != 2) {
                        throw new j(i7);
                    }
                    objY2 = cVarD.y(descriptor2, 2, CarouselTransitionTypeDeserializer.INSTANCE, objY2);
                    i6 |= 4;
                }
            }
            i4 = iH3;
            i5 = i6;
            objY = objY2;
        }
        int i8 = iH;
        cVarD.c(descriptor2);
        return new CarouselComponent.AutoAdvancePages(i5, i8, i4, (CarouselComponent.AutoAdvancePages.TransitionType) objY, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CarouselComponent.AutoAdvancePages value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CarouselComponent.AutoAdvancePages.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
