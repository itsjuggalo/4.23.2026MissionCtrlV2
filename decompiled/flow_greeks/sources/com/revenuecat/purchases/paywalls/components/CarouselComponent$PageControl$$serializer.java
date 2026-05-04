package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
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
import dh.e0;
import dh.j0;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/CarouselComponent.PageControl.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent$PageControl;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarouselComponent$PageControl$$serializer implements e0 {
    public static final CarouselComponent$PageControl$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CarouselComponent$PageControl$$serializer carouselComponent$PageControl$$serializer = new CarouselComponent$PageControl$$serializer();
        INSTANCE = carouselComponent$PageControl$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.CarouselComponent.PageControl", carouselComponent$PageControl$$serializer, 10);
        j1Var.g("position", false);
        j1Var.g("spacing", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("background_color", true);
        j1Var.g("shape", true);
        j1Var.g("border", true);
        j1Var.g("shadow", true);
        j1Var.g(AppMeasurementSdk.ConditionalUserProperty.ACTIVE, false);
        j1Var.g("default", false);
        descriptor = j1Var;
    }

    private CarouselComponent$PageControl$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(j0.f8162a);
        b bVarP2 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP3 = a.p(ShapeDeserializer.INSTANCE);
        b bVarP4 = a.p(Border$$serializer.INSTANCE);
        b bVarP5 = a.p(Shadow$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
        return new b[]{CarouselPageControlPositionDeserializer.INSTANCE, bVarP, padding$$serializer, padding$$serializer, bVarP2, bVarP3, bVarP4, bVarP5, carouselComponent$PageControl$Indicator$$serializer, carouselComponent$PageControl$Indicator$$serializer};
    }

    @Override // zg.a
    public CarouselComponent.PageControl deserialize(e decoder) {
        int i10;
        CarouselComponent.PageControl.Indicator indicator;
        CarouselComponent.PageControl.Indicator indicator2;
        Border border;
        Shadow shadow;
        Shape shape;
        ColorScheme colorScheme;
        Padding padding;
        CarouselComponent.PageControl.Position position;
        Integer num;
        Padding padding2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 9;
        CarouselComponent.PageControl.Position position2 = null;
        if (cVarB.z()) {
            CarouselComponent.PageControl.Position position3 = (CarouselComponent.PageControl.Position) cVarB.h(descriptor2, 0, CarouselPageControlPositionDeserializer.INSTANCE, null);
            Integer num2 = (Integer) cVarB.n(descriptor2, 1, j0.f8162a, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.h(descriptor2, 2, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.h(descriptor2, 3, padding$$serializer, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Shape shape2 = (Shape) cVarB.n(descriptor2, 5, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) cVarB.n(descriptor2, 6, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) cVarB.n(descriptor2, 7, Shadow$$serializer.INSTANCE, null);
            CarouselComponent$PageControl$Indicator$$serializer carouselComponent$PageControl$Indicator$$serializer = CarouselComponent$PageControl$Indicator$$serializer.INSTANCE;
            CarouselComponent.PageControl.Indicator indicator3 = (CarouselComponent.PageControl.Indicator) cVarB.h(descriptor2, 8, carouselComponent$PageControl$Indicator$$serializer, null);
            position = position3;
            indicator = (CarouselComponent.PageControl.Indicator) cVarB.h(descriptor2, 9, carouselComponent$PageControl$Indicator$$serializer, null);
            shadow = shadow2;
            border = border2;
            shape = shape2;
            padding = padding4;
            indicator2 = indicator3;
            colorScheme = colorScheme2;
            padding2 = padding3;
            num = num2;
            i10 = 1023;
        } else {
            boolean z10 = true;
            int i12 = 0;
            CarouselComponent.PageControl.Indicator indicator4 = null;
            CarouselComponent.PageControl.Indicator indicator5 = null;
            Border border3 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            ColorScheme colorScheme3 = null;
            Padding padding5 = null;
            Integer num3 = null;
            Padding padding6 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        i11 = 9;
                        break;
                    case 0:
                        position2 = (CarouselComponent.PageControl.Position) cVarB.h(descriptor2, 0, CarouselPageControlPositionDeserializer.INSTANCE, position2);
                        i12 |= 1;
                        i11 = 9;
                        break;
                    case 1:
                        num3 = (Integer) cVarB.n(descriptor2, 1, j0.f8162a, num3);
                        i12 |= 2;
                        i11 = 9;
                        break;
                    case 2:
                        padding6 = (Padding) cVarB.h(descriptor2, 2, Padding$$serializer.INSTANCE, padding6);
                        i12 |= 4;
                        i11 = 9;
                        break;
                    case 3:
                        padding5 = (Padding) cVarB.h(descriptor2, 3, Padding$$serializer.INSTANCE, padding5);
                        i12 |= 8;
                        i11 = 9;
                        break;
                    case 4:
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i12 |= 16;
                        i11 = 9;
                        break;
                    case 5:
                        shape3 = (Shape) cVarB.n(descriptor2, 5, ShapeDeserializer.INSTANCE, shape3);
                        i12 |= 32;
                        i11 = 9;
                        break;
                    case 6:
                        border3 = (Border) cVarB.n(descriptor2, 6, Border$$serializer.INSTANCE, border3);
                        i12 |= 64;
                        i11 = 9;
                        break;
                    case 7:
                        shadow3 = (Shadow) cVarB.n(descriptor2, 7, Shadow$$serializer.INSTANCE, shadow3);
                        i12 |= 128;
                        i11 = 9;
                        break;
                    case 8:
                        indicator5 = (CarouselComponent.PageControl.Indicator) cVarB.h(descriptor2, 8, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, indicator5);
                        i12 |= 256;
                        break;
                    case 9:
                        indicator4 = (CarouselComponent.PageControl.Indicator) cVarB.h(descriptor2, i11, CarouselComponent$PageControl$Indicator$$serializer.INSTANCE, indicator4);
                        i12 |= 512;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i12;
            indicator = indicator4;
            indicator2 = indicator5;
            border = border3;
            shadow = shadow3;
            shape = shape3;
            colorScheme = colorScheme3;
            padding = padding5;
            position = position2;
            num = num3;
            padding2 = padding6;
        }
        cVarB.c(descriptor2);
        return new CarouselComponent.PageControl(i10, position, num, padding2, padding, colorScheme, shape, border, shadow, indicator2, indicator, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CarouselComponent.PageControl value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CarouselComponent.PageControl.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
