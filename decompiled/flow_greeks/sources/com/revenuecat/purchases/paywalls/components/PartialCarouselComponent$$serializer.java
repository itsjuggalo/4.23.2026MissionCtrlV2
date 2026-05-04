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
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialCarouselComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialCarouselComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialCarouselComponent$$serializer implements e0 {
    public static final PartialCarouselComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PartialCarouselComponent$$serializer partialCarouselComponent$$serializer = new PartialCarouselComponent$$serializer();
        INSTANCE = partialCarouselComponent$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.PartialCarouselComponent", partialCarouselComponent$$serializer, 16);
        j1Var.g("visible", true);
        j1Var.g("initial_page_index", true);
        j1Var.g("page_alignment", true);
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
        descriptor = j1Var;
    }

    private PartialCarouselComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        h hVar = h.f8149a;
        b bVarP = a.p(hVar);
        j0 j0Var = j0.f8162a;
        b bVarP2 = a.p(j0Var);
        b bVarP3 = a.p(VerticalAlignmentDeserializer.INSTANCE);
        b bVarP4 = a.p(Size$$serializer.INSTANCE);
        b bVarP5 = a.p(j0Var);
        b bVarP6 = a.p(d0.f8131a);
        b bVarP7 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP8 = a.p(BackgroundDeserializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVarP7, bVarP8, a.p(padding$$serializer), a.p(padding$$serializer), a.p(ShapeDeserializer.INSTANCE), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE), a.p(CarouselComponent$PageControl$$serializer.INSTANCE), a.p(hVar), a.p(CarouselComponent$AutoAdvancePages$$serializer.INSTANCE)};
    }

    @Override // zg.a
    public PartialCarouselComponent deserialize(e decoder) {
        int i10;
        Boolean bool;
        Integer num;
        Boolean bool2;
        CarouselComponent.AutoAdvancePages autoAdvancePages;
        Shadow shadow;
        Shape shape;
        Padding padding;
        Padding padding2;
        ColorScheme colorScheme;
        Border border;
        Background background;
        Integer num2;
        VerticalAlignment verticalAlignment;
        Size size;
        Float f10;
        CarouselComponent.PageControl pageControl;
        Integer num3;
        CarouselComponent.PageControl pageControl2;
        Float f11;
        Size size2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        if (cVarB.z()) {
            h hVar = h.f8149a;
            Boolean bool3 = (Boolean) cVarB.n(descriptor2, 0, hVar, null);
            j0 j0Var = j0.f8162a;
            Integer num4 = (Integer) cVarB.n(descriptor2, 1, j0Var, null);
            VerticalAlignment verticalAlignment2 = (VerticalAlignment) cVarB.n(descriptor2, 2, VerticalAlignmentDeserializer.INSTANCE, null);
            Size size3 = (Size) cVarB.n(descriptor2, 3, Size$$serializer.INSTANCE, null);
            Integer num5 = (Integer) cVarB.n(descriptor2, 4, j0Var, null);
            Float f12 = (Float) cVarB.n(descriptor2, 5, d0.f8131a, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 6, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) cVarB.n(descriptor2, 7, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.n(descriptor2, 8, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.n(descriptor2, 9, padding$$serializer, null);
            Shape shape2 = (Shape) cVarB.n(descriptor2, 10, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) cVarB.n(descriptor2, 11, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) cVarB.n(descriptor2, 12, Shadow$$serializer.INSTANCE, null);
            CarouselComponent.PageControl pageControl3 = (CarouselComponent.PageControl) cVarB.n(descriptor2, 13, CarouselComponent$PageControl$$serializer.INSTANCE, null);
            Boolean bool4 = (Boolean) cVarB.n(descriptor2, 14, hVar, null);
            i10 = 65535;
            autoAdvancePages = (CarouselComponent.AutoAdvancePages) cVarB.n(descriptor2, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, null);
            pageControl = pageControl3;
            num2 = num4;
            bool = bool3;
            num = num5;
            size = size3;
            padding = padding4;
            background = background2;
            colorScheme = colorScheme2;
            f10 = f12;
            shape = shape2;
            padding2 = padding3;
            bool2 = bool4;
            shadow = shadow2;
            border = border2;
            verticalAlignment = verticalAlignment2;
        } else {
            boolean z10 = true;
            CarouselComponent.PageControl pageControl4 = null;
            Float f13 = null;
            Integer num6 = null;
            Boolean bool5 = null;
            CarouselComponent.AutoAdvancePages autoAdvancePages2 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            ColorScheme colorScheme3 = null;
            Border border3 = null;
            Background background3 = null;
            Boolean bool6 = null;
            Integer num7 = null;
            VerticalAlignment verticalAlignment3 = null;
            i10 = 0;
            Size size4 = null;
            while (z10) {
                Size size5 = size4;
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        pageControl2 = pageControl4;
                        f11 = f13;
                        size2 = size5;
                        z10 = false;
                        size4 = size2;
                        f13 = f11;
                        pageControl4 = pageControl2;
                        break;
                    case 0:
                        pageControl2 = pageControl4;
                        f11 = f13;
                        size2 = size5;
                        bool6 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, bool6);
                        i10 |= 1;
                        num7 = num7;
                        size4 = size2;
                        f13 = f11;
                        pageControl4 = pageControl2;
                        break;
                    case 1:
                        pageControl2 = pageControl4;
                        f11 = f13;
                        size2 = size5;
                        num7 = (Integer) cVarB.n(descriptor2, 1, j0.f8162a, num7);
                        i10 |= 2;
                        verticalAlignment3 = verticalAlignment3;
                        size4 = size2;
                        f13 = f11;
                        pageControl4 = pageControl2;
                        break;
                    case 2:
                        pageControl2 = pageControl4;
                        f11 = f13;
                        size2 = size5;
                        verticalAlignment3 = (VerticalAlignment) cVarB.n(descriptor2, 2, VerticalAlignmentDeserializer.INSTANCE, verticalAlignment3);
                        i10 |= 4;
                        size4 = size2;
                        f13 = f11;
                        pageControl4 = pageControl2;
                        break;
                    case 3:
                        pageControl2 = pageControl4;
                        f11 = f13;
                        size4 = (Size) cVarB.n(descriptor2, 3, Size$$serializer.INSTANCE, size5);
                        i10 |= 8;
                        f13 = f11;
                        pageControl4 = pageControl2;
                        break;
                    case 4:
                        num6 = (Integer) cVarB.n(descriptor2, 4, j0.f8162a, num6);
                        i10 |= 16;
                        pageControl4 = pageControl4;
                        size4 = size5;
                        break;
                    case 5:
                        num3 = num6;
                        f13 = (Float) cVarB.n(descriptor2, 5, d0.f8131a, f13);
                        i10 |= 32;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 6:
                        num3 = num6;
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 6, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i10 |= 64;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 7:
                        num3 = num6;
                        background3 = (Background) cVarB.n(descriptor2, 7, BackgroundDeserializer.INSTANCE, background3);
                        i10 |= 128;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 8:
                        num3 = num6;
                        padding6 = (Padding) cVarB.n(descriptor2, 8, Padding$$serializer.INSTANCE, padding6);
                        i10 |= 256;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 9:
                        num3 = num6;
                        padding5 = (Padding) cVarB.n(descriptor2, 9, Padding$$serializer.INSTANCE, padding5);
                        i10 |= 512;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 10:
                        num3 = num6;
                        shape3 = (Shape) cVarB.n(descriptor2, 10, ShapeDeserializer.INSTANCE, shape3);
                        i10 |= 1024;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 11:
                        num3 = num6;
                        border3 = (Border) cVarB.n(descriptor2, 11, Border$$serializer.INSTANCE, border3);
                        i10 |= 2048;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 12:
                        num3 = num6;
                        shadow3 = (Shadow) cVarB.n(descriptor2, 12, Shadow$$serializer.INSTANCE, shadow3);
                        i10 |= 4096;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 13:
                        num3 = num6;
                        pageControl4 = (CarouselComponent.PageControl) cVarB.n(descriptor2, 13, CarouselComponent$PageControl$$serializer.INSTANCE, pageControl4);
                        i10 |= 8192;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 14:
                        num3 = num6;
                        bool5 = (Boolean) cVarB.n(descriptor2, 14, h.f8149a, bool5);
                        i10 |= 16384;
                        size4 = size5;
                        num6 = num3;
                        break;
                    case 15:
                        num3 = num6;
                        autoAdvancePages2 = (CarouselComponent.AutoAdvancePages) cVarB.n(descriptor2, 15, CarouselComponent$AutoAdvancePages$$serializer.INSTANCE, autoAdvancePages2);
                        i10 |= 32768;
                        size4 = size5;
                        num6 = num3;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            bool = bool6;
            num = num6;
            bool2 = bool5;
            autoAdvancePages = autoAdvancePages2;
            shadow = shadow3;
            shape = shape3;
            padding = padding5;
            padding2 = padding6;
            colorScheme = colorScheme3;
            border = border3;
            background = background3;
            num2 = num7;
            verticalAlignment = verticalAlignment3;
            size = size4;
            f10 = f13;
            pageControl = pageControl4;
        }
        int i11 = i10;
        cVarB.c(descriptor2);
        return new PartialCarouselComponent(i11, bool, num2, verticalAlignment, size, num, f10, colorScheme, background, padding2, padding, shape, border, shadow, pageControl, bool2, autoAdvancePages, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PartialCarouselComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PartialCarouselComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
