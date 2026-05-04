package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
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
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialTabsComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/PartialTabsComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialTabsComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialTabsComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialTabsComponent$$serializer implements e0 {
    public static final PartialTabsComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PartialTabsComponent$$serializer partialTabsComponent$$serializer = new PartialTabsComponent$$serializer();
        INSTANCE = partialTabsComponent$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.PartialTabsComponent", partialTabsComponent$$serializer, 9);
        j1Var.g("visible", true);
        j1Var.g("size", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("background_color", true);
        j1Var.g("background", true);
        j1Var.g("shape", true);
        j1Var.g("border", true);
        j1Var.g("shadow", true);
        descriptor = j1Var;
    }

    private PartialTabsComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(h.f8149a);
        b bVarP2 = a.p(Size$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, a.p(padding$$serializer), a.p(padding$$serializer), a.p(ColorScheme$$serializer.INSTANCE), a.p(BackgroundDeserializer.INSTANCE), a.p(ShapeDeserializer.INSTANCE), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE)};
    }

    @Override // zg.a
    public PartialTabsComponent deserialize(e decoder) {
        int i10;
        Border border;
        Shadow shadow;
        Shape shape;
        Background background;
        ColorScheme colorScheme;
        Boolean bool;
        Size size;
        Padding padding;
        Padding padding2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 7;
        Boolean bool2 = null;
        if (cVarB.z()) {
            Boolean bool3 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, null);
            Size size2 = (Size) cVarB.n(descriptor2, 1, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.n(descriptor2, 2, padding$$serializer, null);
            Padding padding4 = (Padding) cVarB.n(descriptor2, 3, padding$$serializer, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, null);
            Background background2 = (Background) cVarB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, null);
            Shape shape2 = (Shape) cVarB.n(descriptor2, 6, ShapeDeserializer.INSTANCE, null);
            bool = bool3;
            border = (Border) cVarB.n(descriptor2, 7, Border$$serializer.INSTANCE, null);
            shape = shape2;
            background = background2;
            padding2 = padding4;
            shadow = (Shadow) cVarB.n(descriptor2, 8, Shadow$$serializer.INSTANCE, null);
            colorScheme = colorScheme2;
            padding = padding3;
            size = size2;
            i10 = 511;
        } else {
            boolean z10 = true;
            int i12 = 0;
            Border border2 = null;
            Shadow shadow2 = null;
            Shape shape3 = null;
            Background background3 = null;
            ColorScheme colorScheme3 = null;
            Size size3 = null;
            Padding padding5 = null;
            Padding padding6 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        i11 = 7;
                        break;
                    case 0:
                        bool2 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, bool2);
                        i12 |= 1;
                        i11 = 7;
                        break;
                    case 1:
                        size3 = (Size) cVarB.n(descriptor2, 1, Size$$serializer.INSTANCE, size3);
                        i12 |= 2;
                        i11 = 7;
                        break;
                    case 2:
                        padding5 = (Padding) cVarB.n(descriptor2, 2, Padding$$serializer.INSTANCE, padding5);
                        i12 |= 4;
                        i11 = 7;
                        break;
                    case 3:
                        padding6 = (Padding) cVarB.n(descriptor2, 3, Padding$$serializer.INSTANCE, padding6);
                        i12 |= 8;
                        i11 = 7;
                        break;
                    case 4:
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 4, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i12 |= 16;
                        i11 = 7;
                        break;
                    case 5:
                        background3 = (Background) cVarB.n(descriptor2, 5, BackgroundDeserializer.INSTANCE, background3);
                        i12 |= 32;
                        i11 = 7;
                        break;
                    case 6:
                        shape3 = (Shape) cVarB.n(descriptor2, 6, ShapeDeserializer.INSTANCE, shape3);
                        i12 |= 64;
                        break;
                    case 7:
                        border2 = (Border) cVarB.n(descriptor2, i11, Border$$serializer.INSTANCE, border2);
                        i12 |= 128;
                        break;
                    case 8:
                        shadow2 = (Shadow) cVarB.n(descriptor2, 8, Shadow$$serializer.INSTANCE, shadow2);
                        i12 |= 256;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i12;
            border = border2;
            shadow = shadow2;
            shape = shape3;
            background = background3;
            colorScheme = colorScheme3;
            bool = bool2;
            size = size3;
            padding = padding5;
            padding2 = padding6;
        }
        cVarB.c(descriptor2);
        return new PartialTabsComponent(i10, bool, size, padding, padding2, colorScheme, background, shape, border, shadow, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PartialTabsComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PartialTabsComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
