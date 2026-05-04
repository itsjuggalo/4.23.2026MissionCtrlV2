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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/StackComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/StackComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/StackComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class StackComponent$$serializer implements e0 {
    public static final StackComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        StackComponent$$serializer stackComponent$$serializer = new StackComponent$$serializer();
        INSTANCE = stackComponent$$serializer;
        j1 j1Var = new j1("stack", stackComponent$$serializer, 15);
        j1Var.g("components", false);
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
        j1Var.g("overrides", true);
        descriptor = j1Var;
    }

    private StackComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = StackComponent.$childSerializers;
        b bVar = bVarArr[0];
        b bVarP = a.p(h.f8149a);
        b bVar2 = bVarArr[2];
        b bVarP2 = a.p(d0.f8131a);
        b bVarP3 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP4 = a.p(BackgroundDeserializer.INSTANCE);
        b bVarP5 = a.p(ShapeDeserializer.INSTANCE);
        b bVarP6 = a.p(Border$$serializer.INSTANCE);
        b bVarP7 = a.p(Shadow$$serializer.INSTANCE);
        b bVarP8 = a.p(Badge$$serializer.INSTANCE);
        b bVarP9 = a.p(StackOverflowDeserializer.INSTANCE);
        b bVar3 = bVarArr[14];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVar, bVarP, bVar2, Size$$serializer.INSTANCE, bVarP2, bVarP3, bVarP4, padding$$serializer, padding$$serializer, bVarP5, bVarP6, bVarP7, bVarP8, bVarP9, bVar3};
    }

    @Override // zg.a
    public StackComponent deserialize(e decoder) {
        int i10;
        List list;
        Dimension dimension;
        Shadow shadow;
        Border border;
        Padding padding;
        Padding padding2;
        Background background;
        Float f10;
        Shape shape;
        ColorScheme colorScheme;
        Size size;
        List list2;
        StackComponent.Overflow overflow;
        Badge badge;
        Boolean bool;
        List list3;
        List list4;
        Boolean bool2;
        Boolean bool3;
        List list5;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = StackComponent.$childSerializers;
        if (cVarB.z()) {
            list = (List) cVarB.h(descriptor2, 0, bVarArr[0], null);
            Boolean bool4 = (Boolean) cVarB.n(descriptor2, 1, h.f8149a, null);
            Dimension dimension2 = (Dimension) cVarB.h(descriptor2, 2, bVarArr[2], null);
            Size size2 = (Size) cVarB.h(descriptor2, 3, Size$$serializer.INSTANCE, null);
            Float f11 = (Float) cVarB.n(descriptor2, 4, d0.f8131a, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) cVarB.n(descriptor2, 6, BackgroundDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.h(descriptor2, 7, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.h(descriptor2, 8, padding$$serializer, null);
            Shape shape2 = (Shape) cVarB.n(descriptor2, 9, ShapeDeserializer.INSTANCE, null);
            Border border2 = (Border) cVarB.n(descriptor2, 10, Border$$serializer.INSTANCE, null);
            Shadow shadow2 = (Shadow) cVarB.n(descriptor2, 11, Shadow$$serializer.INSTANCE, null);
            Badge badge2 = (Badge) cVarB.n(descriptor2, 12, Badge$$serializer.INSTANCE, null);
            i10 = 32767;
            overflow = (StackComponent.Overflow) cVarB.n(descriptor2, 13, StackOverflowDeserializer.INSTANCE, null);
            bool = bool4;
            list2 = (List) cVarB.h(descriptor2, 14, bVarArr[14], null);
            border = border2;
            shape = shape2;
            padding2 = padding3;
            background = background2;
            colorScheme = colorScheme2;
            size = size2;
            padding = padding4;
            f10 = f11;
            dimension = dimension2;
            badge = badge2;
            shadow = shadow2;
        } else {
            int i11 = 14;
            boolean z10 = true;
            List list6 = null;
            Dimension dimension3 = null;
            Shadow shadow3 = null;
            Border border3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            Background background3 = null;
            Float f12 = null;
            Shape shape3 = null;
            ColorScheme colorScheme3 = null;
            Badge badge3 = null;
            StackComponent.Overflow overflow2 = null;
            List list7 = null;
            int i12 = 2;
            i10 = 0;
            Boolean bool5 = null;
            Size size3 = null;
            while (z10) {
                int i13 = i11;
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        list3 = list6;
                        list4 = list7;
                        bool2 = bool5;
                        z10 = false;
                        bool5 = bool2;
                        i11 = 14;
                        i12 = 2;
                        list7 = list4;
                        list6 = list3;
                        break;
                    case 0:
                        list3 = list6;
                        List list8 = list7;
                        bool2 = bool5;
                        list4 = (List) cVarB.h(descriptor2, 0, bVarArr[0], list8);
                        i10 |= 1;
                        bool5 = bool2;
                        i11 = 14;
                        i12 = 2;
                        list7 = list4;
                        list6 = list3;
                        break;
                    case 1:
                        bool5 = (Boolean) cVarB.n(descriptor2, 1, h.f8149a, bool5);
                        i10 |= 2;
                        list6 = list6;
                        badge3 = badge3;
                        i11 = 14;
                        i12 = 2;
                        break;
                    case 2:
                        bool3 = bool5;
                        list5 = list6;
                        dimension3 = (Dimension) cVarB.h(descriptor2, i12, bVarArr[i12], dimension3);
                        i10 |= 4;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 3:
                        bool3 = bool5;
                        list5 = list6;
                        size3 = (Size) cVarB.h(descriptor2, 3, Size$$serializer.INSTANCE, size3);
                        i10 |= 8;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 4:
                        bool3 = bool5;
                        list5 = list6;
                        f12 = (Float) cVarB.n(descriptor2, 4, d0.f8131a, f12);
                        i10 |= 16;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 5:
                        bool3 = bool5;
                        list5 = list6;
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i10 |= 32;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 6:
                        bool3 = bool5;
                        list5 = list6;
                        background3 = (Background) cVarB.n(descriptor2, 6, BackgroundDeserializer.INSTANCE, background3);
                        i10 |= 64;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 7:
                        bool3 = bool5;
                        list5 = list6;
                        padding6 = (Padding) cVarB.h(descriptor2, 7, Padding$$serializer.INSTANCE, padding6);
                        i10 |= 128;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 8:
                        bool3 = bool5;
                        list5 = list6;
                        padding5 = (Padding) cVarB.h(descriptor2, 8, Padding$$serializer.INSTANCE, padding5);
                        i10 |= 256;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 9:
                        bool3 = bool5;
                        list5 = list6;
                        shape3 = (Shape) cVarB.n(descriptor2, 9, ShapeDeserializer.INSTANCE, shape3);
                        i10 |= 512;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 10:
                        bool3 = bool5;
                        list5 = list6;
                        border3 = (Border) cVarB.n(descriptor2, 10, Border$$serializer.INSTANCE, border3);
                        i10 |= 1024;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 11:
                        bool3 = bool5;
                        list5 = list6;
                        shadow3 = (Shadow) cVarB.n(descriptor2, 11, Shadow$$serializer.INSTANCE, shadow3);
                        i10 |= 2048;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 12:
                        bool3 = bool5;
                        badge3 = (Badge) cVarB.n(descriptor2, 12, Badge$$serializer.INSTANCE, badge3);
                        i10 |= 4096;
                        list6 = list6;
                        overflow2 = overflow2;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 13:
                        bool3 = bool5;
                        list5 = list6;
                        overflow2 = (StackComponent.Overflow) cVarB.n(descriptor2, 13, StackOverflowDeserializer.INSTANCE, overflow2);
                        i10 |= 8192;
                        list6 = list5;
                        bool5 = bool3;
                        i11 = 14;
                        break;
                    case 14:
                        list6 = (List) cVarB.h(descriptor2, i13, bVarArr[i13], list6);
                        i10 |= 16384;
                        i11 = i13;
                        bool5 = bool5;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            List list9 = list6;
            list = list7;
            dimension = dimension3;
            shadow = shadow3;
            border = border3;
            padding = padding5;
            padding2 = padding6;
            background = background3;
            f10 = f12;
            shape = shape3;
            colorScheme = colorScheme3;
            size = size3;
            list2 = list9;
            overflow = overflow2;
            badge = badge3;
            bool = bool5;
        }
        List list10 = list;
        int i14 = i10;
        cVarB.c(descriptor2);
        return new StackComponent(i14, list10, bool, dimension, size, f10, colorScheme, background, padding2, padding, shape, border, shadow, badge, overflow, list2, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, StackComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        StackComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
