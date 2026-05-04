package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
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
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.VerticalAlignmentDeserializer;
import dh.d0;
import dh.e0;
import dh.h;
import dh.j0;
import dh.j1;
import dh.s1;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/CarouselComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/CarouselComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CarouselComponent$$serializer implements e0 {
    public static final CarouselComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        CarouselComponent$$serializer carouselComponent$$serializer = new CarouselComponent$$serializer();
        INSTANCE = carouselComponent$$serializer;
        j1 j1Var = new j1("carousel", carouselComponent$$serializer, 18);
        j1Var.g("pages", false);
        j1Var.g("visible", true);
        j1Var.g("initial_page_index", true);
        j1Var.g("page_alignment", false);
        j1Var.g("size", true);
        j1Var.g("page_peek", true);
        j1Var.g("page_spacing", true);
        j1Var.g("background_color", true);
        j1Var.g("background", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("shape", true);
        j1Var.g("border", true);
        j1Var.g("shadow", true);
        j1Var.g("page_control", true);
        j1Var.g("loop", true);
        j1Var.g("auto_advance", true);
        j1Var.g("overrides", true);
        descriptor = j1Var;
    }

    private CarouselComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = CarouselComponent.$childSerializers;
        b bVar = bVarArr[0];
        h hVar = h.f8149a;
        b bVarP = a.p(hVar);
        j0 j0Var = j0.f8162a;
        b bVarP2 = a.p(j0Var);
        b bVarP3 = a.p(j0Var);
        b bVarP4 = a.p(d0.f8131a);
        b bVarP5 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP6 = a.p(BackgroundDeserializer.INSTANCE);
        b bVarP7 = a.p(ShapeDeserializer.INSTANCE);
        b bVarP8 = a.p(Border$$serializer.INSTANCE);
        b bVarP9 = a.p(Shadow$$serializer.INSTANCE);
        b bVarP10 = a.p(CarouselComponent$PageControl$$serializer.INSTANCE);
        b bVarP11 = a.p(hVar);
        b bVarP12 = a.p(CarouselComponent$AutoAdvancePages$$serializer.INSTANCE);
        b bVar2 = bVarArr[17];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVar, bVarP, bVarP2, VerticalAlignmentDeserializer.INSTANCE, Size$$serializer.INSTANCE, bVarP3, bVarP4, bVarP5, bVarP6, padding$$serializer, padding$$serializer, bVarP7, bVarP8, bVarP9, bVarP10, bVarP11, bVarP12, bVar2};
    }

    @Override // zg.a
    public CarouselComponent deserialize(e decoder) {
        Background background;
        int i10;
        List list;
        ColorScheme colorScheme;
        Integer num;
        Size size;
        Border border;
        Integer num2;
        Padding padding;
        Padding padding2;
        Float f10;
        Shape shape;
        CarouselComponent.AutoAdvancePages autoAdvancePages;
        Boolean bool;
        CarouselComponent.PageControl pageControl;
        Boolean bool2;
        Shadow shadow;
        VerticalAlignment verticalAlignment;
        List list2;
        CarouselComponent.AutoAdvancePages autoAdvancePages2;
        List list3;
        Boolean bool3;
        List list4;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = CarouselComponent.$childSerializers;
        if (cVarB.z()) {
            List list5 = (List) cVarB.h(descriptor2, 0, bVarArr[0], null);
            h hVar = h.f8149a;
            Boolean bool4 = (Boolean) cVarB.n(descriptor2, 1, hVar, null);
            j0 j0Var = j0.f8162a;
            Integer num3 = (Integer) cVarB.n(descriptor2, 2, j0Var, null);
            VerticalAlignment verticalAlignment2 = (VerticalAlignment) cVarB.h(descriptor2, 3, VerticalAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) cVarB.h(descriptor2, 4, Size$$serializer.INSTANCE, null);
            Integer num4 = (Integer) cVarB.n(descriptor2, 5, j0Var, null);
            Float f11 = (Float) cVarB.n(descriptor2, 6, d0.f8131a, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 7, ColorScheme$$serializer.INSTANCE, null);
            background = (Background) cVarB.n(descriptor2, 8, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.h(descriptor2, 9, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.h(descriptor2, 10, padding$$serializer, null);
            Shape shape2 = (Shape) cVarB.n(descriptor2, 11, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) cVarB.n(descriptor2, 12, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) cVarB.n(descriptor2, 13, Shadow$$serializer.INSTANCE, null);
            CarouselComponent.PageControl pageControl2 = (CarouselComponent.PageControl) cVarB.n(descriptor2, 14, CarouselComponent$PageControl$$serializer.INSTANCE, null);
            i10 = 262143;
            bool = (Boolean) cVarB.n(descriptor2, 15, hVar, null);
            autoAdvancePages = (CarouselComponent.AutoAdvancePages) cVarB.n(descriptor2, 16, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, null);
            list = list5;
            size = size2;
            num2 = num3;
            bool2 = bool4;
            list2 = (List) cVarB.h(descriptor2, 17, bVarArr[17], null);
            num = num4;
            verticalAlignment = verticalAlignment2;
            colorScheme = colorScheme2;
            f10 = f11;
            padding2 = padding3;
            pageControl = pageControl2;
            shadow = shadow2;
            border = border2;
            shape = shape2;
            padding = padding4;
        } else {
            int i11 = 17;
            int i12 = 0;
            int i13 = 1;
            List list6 = null;
            ColorScheme colorScheme3 = null;
            Integer num5 = null;
            Size size3 = null;
            Boolean bool5 = null;
            Integer num6 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            background = null;
            Float f12 = null;
            Shape shape3 = null;
            Border border3 = null;
            Shadow shadow3 = null;
            CarouselComponent.PageControl pageControl3 = null;
            Boolean bool6 = null;
            CarouselComponent.AutoAdvancePages autoAdvancePages3 = null;
            List list7 = null;
            i10 = 0;
            VerticalAlignment verticalAlignment3 = null;
            while (i13 != 0) {
                int i14 = i11;
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        autoAdvancePages2 = autoAdvancePages3;
                        list3 = list6;
                        i13 = i12;
                        bool5 = bool5;
                        verticalAlignment3 = verticalAlignment3;
                        i11 = 17;
                        i12 = i13;
                        list6 = list3;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 0:
                        VerticalAlignment verticalAlignment4 = verticalAlignment3;
                        autoAdvancePages2 = autoAdvancePages3;
                        list3 = list6;
                        b bVar = bVarArr[i12];
                        int i15 = i12;
                        list7 = (List) cVarB.h(descriptor2, i15, bVar, list7);
                        i10 |= 1;
                        bool5 = bool5;
                        verticalAlignment3 = verticalAlignment4;
                        i11 = 17;
                        i12 = i15;
                        list6 = list3;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 1:
                        autoAdvancePages2 = autoAdvancePages3;
                        list3 = list6;
                        i10 |= 2;
                        verticalAlignment3 = verticalAlignment3;
                        i11 = 17;
                        bool5 = (Boolean) cVarB.n(descriptor2, 1, h.f8149a, bool5);
                        list6 = list3;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 2:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        num6 = (Integer) cVarB.n(descriptor2, 2, j0.f8162a, num6);
                        i10 |= 4;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 3:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        verticalAlignment3 = (VerticalAlignment) cVarB.h(descriptor2, 3, VerticalAlignmentDeserializer.INSTANCE, verticalAlignment3);
                        i10 |= 8;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 4:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        size3 = (Size) cVarB.h(descriptor2, 4, Size$$serializer.INSTANCE, size3);
                        i10 |= 16;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 5:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        num5 = (Integer) cVarB.n(descriptor2, 5, j0.f8162a, num5);
                        i10 |= 32;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 6:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        f12 = (Float) cVarB.n(descriptor2, 6, d0.f8131a, f12);
                        i10 |= 64;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 7:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 7, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i10 |= 128;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 8:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        background = (Background) cVarB.n(descriptor2, 8, BackgroundDeserializer.INSTANCE, background);
                        i10 |= 256;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 9:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        padding6 = (Padding) cVarB.h(descriptor2, 9, Padding$$serializer.INSTANCE, padding6);
                        i10 |= 512;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 10:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        padding5 = (Padding) cVarB.h(descriptor2, 10, Padding$$serializer.INSTANCE, padding5);
                        i10 |= 1024;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 11:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        shape3 = (Shape) cVarB.n(descriptor2, 11, ShapeDeserializer.INSTANCE, shape3);
                        i10 |= 2048;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 12:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        border3 = (Border) cVarB.n(descriptor2, 12, Border$$serializer.INSTANCE, border3);
                        i10 |= 4096;
                        shadow3 = shadow3;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 13:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        shadow3 = (Shadow) cVarB.n(descriptor2, 13, Shadow$$serializer.INSTANCE, shadow3);
                        i10 |= 8192;
                        pageControl3 = pageControl3;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 14:
                        bool3 = bool5;
                        autoAdvancePages2 = autoAdvancePages3;
                        list4 = list6;
                        pageControl3 = (CarouselComponent.PageControl) cVarB.n(descriptor2, 14, CarouselComponent$PageControl$$serializer.INSTANCE, pageControl3);
                        i10 |= 16384;
                        bool6 = bool6;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 15:
                        bool3 = bool5;
                        CarouselComponent.AutoAdvancePages autoAdvancePages4 = autoAdvancePages3;
                        list4 = list6;
                        autoAdvancePages2 = autoAdvancePages4;
                        bool6 = (Boolean) cVarB.n(descriptor2, 15, h.f8149a, bool6);
                        i10 |= 32768;
                        list6 = list4;
                        bool5 = bool3;
                        i11 = 17;
                        autoAdvancePages3 = autoAdvancePages2;
                        break;
                    case 16:
                        i10 |= 65536;
                        list6 = list6;
                        bool5 = bool5;
                        autoAdvancePages3 = (CarouselComponent.AutoAdvancePages) cVarB.n(descriptor2, 16, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, autoAdvancePages3);
                        i11 = 17;
                        break;
                    case bb.d0.STRING_VALUE_FIELD_NUMBER /* 17 */:
                        list6 = (List) cVarB.h(descriptor2, i14, bVarArr[i14], list6);
                        i10 |= 131072;
                        i11 = i14;
                        bool5 = bool5;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            list = list7;
            colorScheme = colorScheme3;
            num = num5;
            size = size3;
            border = border3;
            num2 = num6;
            padding = padding5;
            padding2 = padding6;
            f10 = f12;
            shape = shape3;
            autoAdvancePages = autoAdvancePages3;
            bool = bool6;
            pageControl = pageControl3;
            bool2 = bool5;
            shadow = shadow3;
            verticalAlignment = verticalAlignment3;
            list2 = list6;
        }
        int i16 = i10;
        Background background2 = background;
        cVarB.c(descriptor2);
        return new CarouselComponent(i16, list, bool2, num2, verticalAlignment, size, num, f10, colorScheme, background2, padding2, padding, shape, border, shadow, pageControl, bool, autoAdvancePages, list2, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, CarouselComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        CarouselComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
