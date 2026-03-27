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
import J3.k0;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class CarouselComponent$PageControl$$serializer implements C {
    public static final CarouselComponent$PageControl$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        CarouselComponent$PageControl$$serializer carouselComponent$PageControl$$serializer = new CarouselComponent$PageControl$$serializer();
        INSTANCE = carouselComponent$PageControl$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.CarouselComponent.PageControl", carouselComponent$PageControl$$serializer, 10);
        c0327b0.l("position", false);
        c0327b0.l("spacing", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("background_color", true);
        c0327b0.l("shape", true);
        c0327b0.l("border", true);
        c0327b0.l("shadow", true);
        c0327b0.l("active", false);
        c0327b0.l("default", false);
        descriptor = c0327b0;
    }

    private CarouselComponent$PageControl$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVarP = a.p(H.f874a);
        b bVarP2 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP3 = a.p(ShapeDeserializer.INSTANCE);
        b bVarP4 = a.p(Border$$serializer.INSTANCE);
        b bVarP5 = a.p(Shadow$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
        return new b[]{CarouselPageControlPositionDeserializer.INSTANCE, bVarP, padding$$serializer, padding$$serializer, bVarP2, bVarP3, bVarP4, bVarP5, carouselComponent$PageControl$Indicator$$serializer, carouselComponent$PageControl$Indicator$$serializer};
    }

    @Override // F3.a
    public CarouselComponent.PageControl deserialize(e decoder) {
        int i4;
        Object objM;
        Object objM2;
        Object objM3;
        Object objY;
        Object objY2;
        Object objY3;
        Object objY4;
        Object objM4;
        Object objY5;
        Object objM5;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i5 = 9;
        Object objM6 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, CarouselPageControlPositionDeserializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 1, H.f874a, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objM5 = cVarD.m(descriptor2, 2, padding$$serializer, null);
            objM4 = cVarD.m(descriptor2, 3, padding$$serializer, null);
            objY4 = cVarD.y(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 5, ShapeDeserializer.INSTANCE, null);
            objY = cVarD.y(descriptor2, 6, Border$$serializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 7, Shadow$$serializer.INSTANCE, null);
            CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
            objM3 = cVarD.m(descriptor2, 8, carouselComponent$PageControl$Indicator$$serializer, null);
            objM2 = cVarD.m(descriptor2, 9, carouselComponent$PageControl$Indicator$$serializer, null);
            i4 = 1023;
        } else {
            boolean z4 = true;
            int i6 = 0;
            Object objM7 = null;
            Object objM8 = null;
            Object objY6 = null;
            Object objY7 = null;
            Object objY8 = null;
            Object objY9 = null;
            Object objM9 = null;
            Object objY10 = null;
            Object objM10 = null;
            while (z4) {
                int i7 = cVarD.i(descriptor2);
                switch (i7) {
                    case -1:
                        z4 = false;
                        i5 = 9;
                        break;
                    case 0:
                        objM6 = cVarD.m(descriptor2, 0, CarouselPageControlPositionDeserializer.INSTANCE, objM6);
                        i6 |= 1;
                        i5 = 9;
                        break;
                    case 1:
                        objY10 = cVarD.y(descriptor2, 1, H.f874a, objY10);
                        i6 |= 2;
                        i5 = 9;
                        break;
                    case 2:
                        objM10 = cVarD.m(descriptor2, 2, Padding$$serializer.INSTANCE, objM10);
                        i6 |= 4;
                        i5 = 9;
                        break;
                    case 3:
                        objM9 = cVarD.m(descriptor2, 3, Padding$$serializer.INSTANCE, objM9);
                        i6 |= 8;
                        i5 = 9;
                        break;
                    case 4:
                        objY9 = cVarD.y(descriptor2, 4, ColorScheme$$serializer.INSTANCE, objY9);
                        i6 |= 16;
                        i5 = 9;
                        break;
                    case 5:
                        objY8 = cVarD.y(descriptor2, 5, ShapeDeserializer.INSTANCE, objY8);
                        i6 |= 32;
                        i5 = 9;
                        break;
                    case 6:
                        objY6 = cVarD.y(descriptor2, 6, Border$$serializer.INSTANCE, objY6);
                        i6 |= 64;
                        i5 = 9;
                        break;
                    case 7:
                        objY7 = cVarD.y(descriptor2, 7, Shadow$$serializer.INSTANCE, objY7);
                        i6 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        i5 = 9;
                        break;
                    case 8:
                        objM8 = cVarD.m(descriptor2, 8, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, objM8);
                        i6 |= 256;
                        break;
                    case 9:
                        objM7 = cVarD.m(descriptor2, i5, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, objM7);
                        i6 |= 512;
                        break;
                    default:
                        throw new j(i7);
                }
            }
            Object obj = objM6;
            i4 = i6;
            objM = obj;
            objM2 = objM7;
            objM3 = objM8;
            objY = objY6;
            objY2 = objY7;
            objY3 = objY8;
            objY4 = objY9;
            objM4 = objM9;
            objY5 = objY10;
            objM5 = objM10;
        }
        cVarD.c(descriptor2);
        return new CarouselComponent.PageControl(i4, (CarouselComponent.PageControl.Position) objM, (Integer) objY5, (Padding) objM5, (Padding) objM4, (ColorScheme) objY4, (Shape) objY3, (Border) objY, (Shadow) objY2, (CarouselComponent.PageControl.Indicator) objM3, (CarouselComponent.PageControl.Indicator) objM2, (k0) null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, CarouselComponent.PageControl value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        CarouselComponent.PageControl.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
