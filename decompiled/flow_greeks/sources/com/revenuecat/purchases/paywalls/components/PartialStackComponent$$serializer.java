package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.StackComponent;
import com.revenuecat.purchases.paywalls.components.common.Background;
import com.revenuecat.purchases.paywalls.components.common.BackgroundDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Badge;
import com.revenuecat.purchases.paywalls.components.properties.Badge$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Dimension;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shape;
import com.revenuecat.purchases.paywalls.components.properties.ShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import dh.d0;
import dh.e0;
import dh.h;
import dh.j1;
import dh.s1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialStackComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/PartialStackComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialStackComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialStackComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialStackComponent$$serializer implements e0 {
    public static final PartialStackComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PartialStackComponent$$serializer partialStackComponent$$serializer = new PartialStackComponent$$serializer();
        INSTANCE = partialStackComponent$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.PartialStackComponent", partialStackComponent$$serializer, 13);
        j1Var.g("visible", true);
        j1Var.g("dimension", true);
        j1Var.g("size", true);
        j1Var.g("spacing", true);
        j1Var.g("background_color", true);
        j1Var.g("background", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("shape", true);
        j1Var.g("border", true);
        j1Var.g("shadow", true);
        j1Var.g("badge", true);
        j1Var.g("overflow", true);
        descriptor = j1Var;
    }

    private PartialStackComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = PartialStackComponent.$childSerializers;
        b bVarP = a.p(h.f8149a);
        b bVarP2 = a.p(bVarArr[1]);
        b bVarP3 = a.p(Size$$serializer.INSTANCE);
        b bVarP4 = a.p(d0.f8131a);
        b bVarP5 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP6 = a.p(BackgroundDeserializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, a.p(padding$$serializer), a.p(padding$$serializer), a.p(ShapeDeserializer.INSTANCE), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE), a.p(Badge$$serializer.INSTANCE), a.p(StackOverflowDeserializer.INSTANCE)};
    }

    @Override // zg.a
    public PartialStackComponent deserialize(e decoder) {
        int i10;
        Boolean bool;
        Badge badge;
        Shadow shadow;
        Shape shape;
        Padding padding;
        Padding padding2;
        ColorScheme colorScheme;
        Border border;
        Background background;
        Float f10;
        Size size;
        Dimension dimension;
        StackComponent.Overflow overflow;
        Dimension dimension2;
        StackComponent.Overflow overflow2;
        Dimension dimension3;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = PartialStackComponent.$childSerializers;
        if (cVarB.z()) {
            Boolean bool2 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, null);
            Dimension dimension4 = (Dimension) cVarB.n(descriptor2, 1, bVarArr[1], null);
            Size size2 = (Size) cVarB.n(descriptor2, 2, Size$$serializer.INSTANCE, null);
            Float f11 = (Float) cVarB.n(descriptor2, 3, d0.f8131a, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) cVarB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.n(descriptor2, 6, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.n(descriptor2, 7, padding$$serializer, null);
            Shape shape2 = (Shape) cVarB.n(descriptor2, 8, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) cVarB.n(descriptor2, 9, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) cVarB.n(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            Badge badge2 = (Badge) cVarB.n(descriptor2, 11, Badge$$serializer.INSTANCE, null);
            i10 = 8191;
            overflow = (StackComponent.Overflow) cVarB.n(descriptor2, 12, StackOverflowDeserializer.INSTANCE, null);
            bool = bool2;
            size = size2;
            shadow = shadow2;
            border = border2;
            padding = padding4;
            padding2 = padding3;
            background = background2;
            f10 = f11;
            shape = shape2;
            colorScheme = colorScheme2;
            badge = badge2;
            dimension = dimension4;
        } else {
            StackComponent.Overflow overflow3 = null;
            Boolean bool3 = null;
            Badge badge3 = null;
            Shadow shadow3 = null;
            Shape shape3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            ColorScheme colorScheme3 = null;
            Border border3 = null;
            Background background3 = null;
            Float f12 = null;
            int i11 = 1;
            boolean z10 = true;
            i10 = 0;
            Dimension dimension5 = null;
            Size size3 = null;
            while (z10) {
                Boolean bool4 = bool3;
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        overflow2 = overflow3;
                        dimension3 = dimension5;
                        bool3 = bool4;
                        z10 = false;
                        dimension5 = dimension3;
                        overflow3 = overflow2;
                        i11 = 1;
                        break;
                    case 0:
                        overflow2 = overflow3;
                        dimension3 = dimension5;
                        bool3 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, bool4);
                        i10 |= 1;
                        dimension5 = dimension3;
                        overflow3 = overflow2;
                        i11 = 1;
                        break;
                    case 1:
                        Dimension dimension6 = dimension5;
                        int i12 = i11;
                        dimension5 = (Dimension) cVarB.n(descriptor2, i12, bVarArr[i11], dimension6);
                        i10 |= 2;
                        i11 = i12;
                        overflow3 = overflow3;
                        bool3 = bool4;
                        break;
                    case 2:
                        dimension2 = dimension5;
                        size3 = (Size) cVarB.n(descriptor2, 2, Size$$serializer.INSTANCE, size3);
                        i10 |= 4;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 3:
                        dimension2 = dimension5;
                        f12 = (Float) cVarB.n(descriptor2, 3, d0.f8131a, f12);
                        i10 |= 8;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 4:
                        dimension2 = dimension5;
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i10 |= 16;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 5:
                        dimension2 = dimension5;
                        background3 = (Background) cVarB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, background3);
                        i10 |= 32;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 6:
                        dimension2 = dimension5;
                        padding6 = (Padding) cVarB.n(descriptor2, 6, Padding$$serializer.INSTANCE, padding6);
                        i10 |= 64;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 7:
                        dimension2 = dimension5;
                        padding5 = (Padding) cVarB.n(descriptor2, 7, Padding$$serializer.INSTANCE, padding5);
                        i10 |= 128;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 8:
                        dimension2 = dimension5;
                        shape3 = (Shape) cVarB.n(descriptor2, 8, ShapeDeserializer.INSTANCE, shape3);
                        i10 |= 256;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 9:
                        dimension2 = dimension5;
                        border3 = (Border) cVarB.n(descriptor2, 9, Border$$serializer.INSTANCE, border3);
                        i10 |= 512;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 10:
                        dimension2 = dimension5;
                        shadow3 = (Shadow) cVarB.n(descriptor2, 10, Shadow$$serializer.INSTANCE, shadow3);
                        i10 |= 1024;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 11:
                        dimension2 = dimension5;
                        badge3 = (Badge) cVarB.n(descriptor2, 11, Badge$$serializer.INSTANCE, badge3);
                        i10 |= 2048;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    case 12:
                        dimension2 = dimension5;
                        overflow3 = (StackComponent.Overflow) cVarB.n(descriptor2, 12, StackOverflowDeserializer.INSTANCE, overflow3);
                        i10 |= 4096;
                        bool3 = bool4;
                        dimension5 = dimension2;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            bool = bool3;
            badge = badge3;
            shadow = shadow3;
            shape = shape3;
            padding = padding5;
            padding2 = padding6;
            colorScheme = colorScheme3;
            border = border3;
            background = background3;
            f10 = f12;
            size = size3;
            dimension = dimension5;
            overflow = overflow3;
        }
        int i13 = i10;
        cVarB.c(descriptor2);
        return new PartialStackComponent(i13, bool, dimension, size, f10, colorScheme, background, padding2, padding, shape, border, shadow, badge, overflow, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PartialStackComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PartialStackComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
