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
import J3.w0;
import W2.w;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class CarouselComponent$PageControl$Indicator$$serializer implements C {
    public static final CarouselComponent$PageControl$Indicator$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = new CarouselComponent$PageControl$Indicator$$serializer();
        INSTANCE = carouselComponent$PageControl$Indicator$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.CarouselComponent.PageControl.Indicator", carouselComponent$PageControl$Indicator$$serializer, 5);
        c0327b0.l("width", false);
        c0327b0.l("height", false);
        c0327b0.l("color", false);
        c0327b0.l("stroke_color", true);
        c0327b0.l("stroke_width", true);
        descriptor = c0327b0;
    }

    private CarouselComponent$PageControl$Indicator$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        w0 w0Var = w0.f990a;
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        return new b[]{w0Var, w0Var, colorScheme$$serializer, a.p(colorScheme$$serializer), a.p(w0Var)};
    }

    @Override // F3.a
    public CarouselComponent.PageControl.Indicator deserialize(e decoder) {
        Object objM;
        int i4;
        Object objM2;
        Object objM3;
        Object objY;
        Object objY2;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        Object objM4 = null;
        if (cVarD.w()) {
            w0 w0Var = w0.f990a;
            objM2 = cVarD.m(descriptor2, 0, w0Var, null);
            objM3 = cVarD.m(descriptor2, 1, w0Var, null);
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            Object objM5 = cVarD.m(descriptor2, 2, colorScheme$$serializer, null);
            objY = cVarD.y(descriptor2, 3, colorScheme$$serializer, null);
            objY2 = cVarD.y(descriptor2, 4, w0Var, null);
            objM = objM5;
            i4 = 31;
        } else {
            boolean z4 = true;
            int i5 = 0;
            Object objM6 = null;
            objM = null;
            Object objY3 = null;
            Object objY4 = null;
            while (z4) {
                int i6 = cVarD.i(descriptor2);
                if (i6 == -1) {
                    z4 = false;
                } else if (i6 == 0) {
                    objM4 = cVarD.m(descriptor2, 0, w0.f990a, objM4);
                    i5 |= 1;
                } else if (i6 == 1) {
                    objM6 = cVarD.m(descriptor2, 1, w0.f990a, objM6);
                    i5 |= 2;
                } else if (i6 == 2) {
                    objM = cVarD.m(descriptor2, 2, ColorScheme$$serializer.INSTANCE, objM);
                    i5 |= 4;
                } else if (i6 == 3) {
                    objY3 = cVarD.y(descriptor2, 3, ColorScheme$$serializer.INSTANCE, objY3);
                    i5 |= 8;
                } else {
                    if (i6 != 4) {
                        throw new j(i6);
                    }
                    objY4 = cVarD.y(descriptor2, 4, w0.f990a, objY4);
                    i5 |= 16;
                }
            }
            i4 = i5;
            objM2 = objM4;
            objM3 = objM6;
            objY = objY3;
            objY2 = objY4;
        }
        cVarD.c(descriptor2);
        return new CarouselComponent.PageControl.Indicator(i4, (w) objM2, (w) objM3, (ColorScheme) objM, (ColorScheme) objY, (w) objY2, null, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CarouselComponent.PageControl.Indicator value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CarouselComponent.PageControl.Indicator.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
