package com.revenuecat.purchases.paywalls.components;

import ah.a;
import ch.c;
import ch.d;
import ch.e;
import ch.f;
import com.revenuecat.purchases.FontAlias;
import com.revenuecat.purchases.FontAlias$$serializer;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FontWeight;
import com.revenuecat.purchases.paywalls.components.properties.FontWeightDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignment;
import com.revenuecat.purchases.paywalls.components.properties.HorizontalAlignmentDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import dh.e0;
import dh.h;
import dh.j0;
import dh.j1;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/PartialTextComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/PartialTextComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PartialTextComponent$$serializer implements e0 {
    public static final PartialTextComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        PartialTextComponent$$serializer partialTextComponent$$serializer = new PartialTextComponent$$serializer();
        INSTANCE = partialTextComponent$$serializer;
        j1 j1Var = new j1("com.revenuecat.purchases.paywalls.components.PartialTextComponent", partialTextComponent$$serializer, 12);
        j1Var.g("visible", true);
        j1Var.g("text_lid", true);
        j1Var.g("color", true);
        j1Var.g("background_color", true);
        j1Var.g("font_name", true);
        j1Var.g("font_weight", true);
        j1Var.g("font_weight_int", true);
        j1Var.g("font_size", true);
        j1Var.g("horizontal_alignment", true);
        j1Var.g("size", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        descriptor = j1Var;
    }

    private PartialTextComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b bVarP = a.p(h.f8149a);
        b bVarP2 = a.p(LocalizationKey$$serializer.INSTANCE);
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        b bVarP3 = a.p(colorScheme$$serializer);
        b bVarP4 = a.p(colorScheme$$serializer);
        b bVarP5 = a.p(FontAlias$$serializer.INSTANCE);
        b bVarP6 = a.p(FontWeightDeserializer.INSTANCE);
        b bVarP7 = a.p(j0.f8162a);
        b bVarP8 = a.p(FontSizeSerializer.INSTANCE);
        b bVarP9 = a.p(HorizontalAlignmentDeserializer.INSTANCE);
        b bVarP10 = a.p(Size$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVarP7, bVarP8, bVarP9, bVarP10, a.p(padding$$serializer), a.p(padding$$serializer)};
    }

    @Override // zg.a
    public PartialTextComponent deserialize(e decoder) {
        Boolean bool;
        ColorScheme colorScheme;
        ColorScheme colorScheme2;
        int i10;
        HorizontalAlignment horizontalAlignment;
        Integer num;
        FontWeight fontWeight;
        Integer num2;
        Size size;
        Padding padding;
        Padding padding2;
        String str;
        String str2;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        int i11 = 11;
        int i12 = 10;
        int i13 = 9;
        int i14 = 8;
        Padding padding3 = null;
        if (cVarB.z()) {
            bool = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, null);
            LocalizationKey localizationKey = (LocalizationKey) cVarB.n(descriptor2, 1, LocalizationKey$$serializer.INSTANCE, null);
            String strM228unboximpl = localizationKey != null ? localizationKey.m228unboximpl() : null;
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            ColorScheme colorScheme3 = (ColorScheme) cVarB.n(descriptor2, 2, colorScheme$$serializer, null);
            ColorScheme colorScheme4 = (ColorScheme) cVarB.n(descriptor2, 3, colorScheme$$serializer, null);
            FontAlias fontAlias = (FontAlias) cVarB.n(descriptor2, 4, FontAlias$$serializer.INSTANCE, null);
            String strM44unboximpl = fontAlias != null ? fontAlias.m44unboximpl() : null;
            FontWeight fontWeight2 = (FontWeight) cVarB.n(descriptor2, 5, FontWeightDeserializer.INSTANCE, null);
            Integer num3 = (Integer) cVarB.n(descriptor2, 6, j0.f8162a, null);
            Integer num4 = (Integer) cVarB.n(descriptor2, 7, FontSizeSerializer.INSTANCE, null);
            HorizontalAlignment horizontalAlignment2 = (HorizontalAlignment) cVarB.n(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) cVarB.n(descriptor2, 9, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding4 = (Padding) cVarB.n(descriptor2, 10, padding$$serializer, null);
            padding2 = (Padding) cVarB.n(descriptor2, 11, padding$$serializer, null);
            padding = padding4;
            size = size2;
            num2 = num4;
            num = num3;
            fontWeight = fontWeight2;
            colorScheme2 = colorScheme4;
            horizontalAlignment = horizontalAlignment2;
            str = strM44unboximpl;
            colorScheme = colorScheme3;
            str2 = strM228unboximpl;
            i10 = 4095;
        } else {
            boolean z10 = true;
            int i15 = 0;
            bool = null;
            HorizontalAlignment horizontalAlignment3 = null;
            Integer num5 = null;
            FontWeight fontWeight3 = null;
            Integer num6 = null;
            Size size3 = null;
            Padding padding5 = null;
            ColorScheme colorScheme5 = null;
            String strM44unboximpl2 = null;
            ColorScheme colorScheme6 = null;
            String strM228unboximpl2 = null;
            while (z10) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        z10 = false;
                        i12 = 10;
                        i13 = 9;
                        i14 = 8;
                        break;
                    case 0:
                        bool = (Boolean) cVarB.n(descriptor2, 0, h.f8149a, bool);
                        i15 |= 1;
                        i11 = 11;
                        i12 = 10;
                        i13 = 9;
                        i14 = 8;
                        break;
                    case 1:
                        ColorScheme colorScheme7 = colorScheme5;
                        ColorScheme colorScheme8 = colorScheme6;
                        LocalizationKey localizationKey2 = (LocalizationKey) cVarB.n(descriptor2, 1, LocalizationKey$$serializer.INSTANCE, strM228unboximpl2 != null ? LocalizationKey.m222boximpl(strM228unboximpl2) : null);
                        strM228unboximpl2 = localizationKey2 != null ? localizationKey2.m228unboximpl() : null;
                        i15 |= 2;
                        colorScheme6 = colorScheme8;
                        colorScheme5 = colorScheme7;
                        i11 = 11;
                        i12 = 10;
                        i13 = 9;
                        i14 = 8;
                        break;
                    case 2:
                        colorScheme6 = (ColorScheme) cVarB.n(descriptor2, 2, ColorScheme$$serializer.INSTANCE, colorScheme6);
                        i15 |= 4;
                        i11 = 11;
                        i12 = 10;
                        i13 = 9;
                        break;
                    case 3:
                        colorScheme5 = (ColorScheme) cVarB.n(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme5);
                        i15 |= 8;
                        i11 = 11;
                        i12 = 10;
                        break;
                    case 4:
                        FontAlias fontAlias2 = (FontAlias) cVarB.n(descriptor2, 4, FontAlias$$serializer.INSTANCE, strM44unboximpl2 != null ? FontAlias.m38boximpl(strM44unboximpl2) : null);
                        strM44unboximpl2 = fontAlias2 != null ? fontAlias2.m44unboximpl() : null;
                        i15 |= 16;
                        i11 = 11;
                        i12 = 10;
                        break;
                    case 5:
                        fontWeight3 = (FontWeight) cVarB.n(descriptor2, 5, FontWeightDeserializer.INSTANCE, fontWeight3);
                        i15 |= 32;
                        i11 = 11;
                        break;
                    case 6:
                        num5 = (Integer) cVarB.n(descriptor2, 6, j0.f8162a, num5);
                        i15 |= 64;
                        i11 = 11;
                        break;
                    case 7:
                        num6 = (Integer) cVarB.n(descriptor2, 7, FontSizeSerializer.INSTANCE, num6);
                        i15 |= 128;
                        i11 = 11;
                        break;
                    case 8:
                        horizontalAlignment3 = (HorizontalAlignment) cVarB.n(descriptor2, i14, HorizontalAlignmentDeserializer.INSTANCE, horizontalAlignment3);
                        i15 |= 256;
                        break;
                    case 9:
                        size3 = (Size) cVarB.n(descriptor2, i13, Size$$serializer.INSTANCE, size3);
                        i15 |= 512;
                        break;
                    case 10:
                        padding5 = (Padding) cVarB.n(descriptor2, i12, Padding$$serializer.INSTANCE, padding5);
                        i15 |= 1024;
                        break;
                    case 11:
                        padding3 = (Padding) cVarB.n(descriptor2, i11, Padding$$serializer.INSTANCE, padding3);
                        i15 |= 2048;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            colorScheme = colorScheme6;
            colorScheme2 = colorScheme5;
            i10 = i15;
            horizontalAlignment = horizontalAlignment3;
            num = num5;
            fontWeight = fontWeight3;
            num2 = num6;
            size = size3;
            padding = padding5;
            padding2 = padding3;
            str = strM44unboximpl2;
            str2 = strM228unboximpl2;
        }
        Boolean bool2 = bool;
        cVarB.c(descriptor2);
        return new PartialTextComponent(i10, bool2, str2, colorScheme, colorScheme2, str, fontWeight, num, num2, horizontalAlignment, size, padding, padding2, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, PartialTextComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        PartialTextComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
