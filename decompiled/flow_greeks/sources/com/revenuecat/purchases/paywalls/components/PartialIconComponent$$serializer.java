package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.paywalls.components.IconComponent;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import dh.e0;
import dh.h;
import dh.j1;
import dh.s1;
import dh.w1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialIconComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialIconComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialIconComponent$$serializer implements e0 {
    public static final PartialIconComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PartialIconComponent$$serializer partialIconComponent$$serializer = new PartialIconComponent$$serializer();
        INSTANCE = partialIconComponent$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.PartialIconComponent", partialIconComponent$$serializer, 9);
        j1Var.g("visible", true);
        j1Var.g("base_url", true);
        j1Var.g("icon_name", true);
        j1Var.g("formats", true);
        j1Var.g("size", true);
        j1Var.g("color", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("icon_background", true);
        descriptor = j1Var;
    }

    private PartialIconComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(h.f8149a);
        w1 w1Var = w1.f8244a;
        b bVarP2 = a.p(w1Var);
        b bVarP3 = a.p(w1Var);
        b bVarP4 = a.p(IconComponent$Formats$$serializer.INSTANCE);
        b bVarP5 = a.p(Size$$serializer.INSTANCE);
        b bVarP6 = a.p(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, a.p(padding$$serializer), a.p(padding$$serializer), a.p(IconComponent$IconBackground$$serializer.INSTANCE)};
    }

    @Override // zg.a
    public PartialIconComponent deserialize(e decoder) {
        int i10;
        Padding padding;
        IconComponent.IconBackground iconBackground;
        Padding padding2;
        ColorScheme colorScheme;
        Size size;
        Boolean bool;
        String str;
        String str2;
        IconComponent.Formats formats;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 7;
        Boolean bool2 = null;
        if (cVarB.z()) {
            Boolean bool3 = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, null);
            w1 w1Var = w1.f8244a;
            String str3 = (String) cVarB.n(descriptor2, 1, w1Var, null);
            String str4 = (String) cVarB.n(descriptor2, 2, w1Var, null);
            IconComponent.Formats formats2 = (IconComponent.Formats) cVarB.n(descriptor2, 3, IconComponent$Formats$$serializer.INSTANCE, null);
            Size size2 = (Size) cVarB.n(descriptor2, 4, Size$$serializer.INSTANCE, null);
            ColorScheme colorScheme2 = (ColorScheme) cVarB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.n(descriptor2, 6, padding$$serializer, null);
            bool = bool3;
            padding = (Padding) cVarB.n(descriptor2, 7, padding$$serializer, null);
            padding2 = padding3;
            colorScheme = colorScheme2;
            formats = formats2;
            iconBackground = (IconComponent.IconBackground) cVarB.n(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, null);
            size = size2;
            str2 = str4;
            str = str3;
            i10 = 511;
        } else {
            boolean z10 = true;
            int i12 = 0;
            Padding padding4 = null;
            IconComponent.IconBackground iconBackground2 = null;
            Padding padding5 = null;
            ColorScheme colorScheme3 = null;
            Size size3 = null;
            String str5 = null;
            String str6 = null;
            IconComponent.Formats formats3 = null;
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
                        str5 = (String) cVarB.n(descriptor2, 1, w1.f8244a, str5);
                        i12 |= 2;
                        i11 = 7;
                        break;
                    case 2:
                        str6 = (String) cVarB.n(descriptor2, 2, w1.f8244a, str6);
                        i12 |= 4;
                        i11 = 7;
                        break;
                    case 3:
                        formats3 = (IconComponent.Formats) cVarB.n(descriptor2, 3, IconComponent$Formats$$serializer.INSTANCE, formats3);
                        i12 |= 8;
                        i11 = 7;
                        break;
                    case 4:
                        size3 = (Size) cVarB.n(descriptor2, 4, Size$$serializer.INSTANCE, size3);
                        i12 |= 16;
                        i11 = 7;
                        break;
                    case 5:
                        colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 5, ColorScheme$$serializer.INSTANCE, colorScheme3);
                        i12 |= 32;
                        i11 = 7;
                        break;
                    case 6:
                        padding5 = (Padding) cVarB.n(descriptor2, 6, Padding$$serializer.INSTANCE, padding5);
                        i12 |= 64;
                        break;
                    case 7:
                        padding4 = (Padding) cVarB.n(descriptor2, i11, Padding$$serializer.INSTANCE, padding4);
                        i12 |= 128;
                        break;
                    case 8:
                        iconBackground2 = (IconComponent.IconBackground) cVarB.n(descriptor2, 8, IconComponent$IconBackground$$serializer.INSTANCE, iconBackground2);
                        i12 |= 256;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            i10 = i12;
            padding = padding4;
            iconBackground = iconBackground2;
            padding2 = padding5;
            colorScheme = colorScheme3;
            size = size3;
            bool = bool2;
            str = str5;
            str2 = str6;
            formats = formats3;
        }
        cVarB.c(descriptor2);
        return new PartialIconComponent(i10, bool, str, str2, formats, size, colorScheme, padding2, padding, iconBackground, (s1) null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PartialIconComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PartialIconComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
