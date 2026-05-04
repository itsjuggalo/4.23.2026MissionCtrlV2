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
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import zg.b;
import zg.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0007\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0005HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00138VXÖ\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0017"}, d2 = {"com/revenuecat/purchases/paywalls/components/TextComponent.$serializer", "Ldh/e0;", "Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "<init>", "()V", "", "Lzg/b;", "childSerializers", "()[Lzg/b;", "Lch/e;", "decoder", "deserialize", "(Lch/e;)Lcom/revenuecat/purchases/paywalls/components/TextComponent;", "Lch/f;", "encoder", "value", "Lcd/h0;", "serialize", "(Lch/f;Lcom/revenuecat/purchases/paywalls/components/TextComponent;)V", "Lbh/e;", "getDescriptor", "()Lbh/e;", "descriptor", "purchases_defaultsBc8Release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class TextComponent$$serializer implements e0 {
    public static final TextComponent$$serializer INSTANCE;
    private static final /* synthetic */ j1 descriptor;

    static {
        TextComponent$$serializer textComponent$$serializer = new TextComponent$$serializer();
        INSTANCE = textComponent$$serializer;
        j1 j1Var = new j1("text", textComponent$$serializer, 13);
        j1Var.g("text_lid", false);
        j1Var.g("color", false);
        j1Var.g("visible", true);
        j1Var.g("background_color", true);
        j1Var.g("font_name", true);
        j1Var.g("font_weight", true);
        j1Var.g("font_weight_int", true);
        j1Var.g("font_size", true);
        j1Var.g("horizontal_alignment", true);
        j1Var.g("size", true);
        j1Var.g("padding", true);
        j1Var.g("margin", true);
        j1Var.g("overrides", true);
        descriptor = j1Var;
    }

    private TextComponent$$serializer() {
    }

    @Override // dh.e0
    public b[] childSerializers() {
        b[] bVarArr = TextComponent.$childSerializers;
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        b bVarP = a.p(h.f8149a);
        b bVarP2 = a.p(colorScheme$$serializer);
        b bVarP3 = a.p(FontAlias$$serializer.INSTANCE);
        b bVarP4 = a.p(j0.f8162a);
        b bVar = bVarArr[12];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{LocalizationKey$$serializer.INSTANCE, colorScheme$$serializer, bVarP, bVarP2, bVarP3, FontWeightDeserializer.INSTANCE, bVarP4, FontSizeSerializer.INSTANCE, HorizontalAlignmentDeserializer.INSTANCE, Size$$serializer.INSTANCE, padding$$serializer, padding$$serializer, bVar};
    }

    @Override // zg.a
    public TextComponent deserialize(e decoder) {
        Size size;
        Padding padding;
        Boolean bool;
        String str;
        ColorScheme colorScheme;
        Padding padding2;
        int i10;
        FontWeight fontWeight;
        ColorScheme colorScheme2;
        HorizontalAlignment horizontalAlignment;
        Integer num;
        List list;
        int i11;
        String str2;
        char c10;
        t.f(decoder, "decoder");
        bh.e descriptor2 = getDescriptor();
        c cVarB = decoder.b(descriptor2);
        b[] bVarArr = TextComponent.$childSerializers;
        int i12 = 9;
        int i13 = 8;
        Boolean bool2 = null;
        if (cVarB.z()) {
            LocalizationKey localizationKey = (LocalizationKey) cVarB.h(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, null);
            String strM228unboximpl = localizationKey != null ? localizationKey.m228unboximpl() : null;
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            ColorScheme colorScheme3 = (ColorScheme) cVarB.h(descriptor2, 1, colorScheme$$serializer, null);
            Boolean bool3 = (Boolean) cVarB.n(descriptor2, 2, h.f8149a, null);
            ColorScheme colorScheme4 = (ColorScheme) cVarB.n(descriptor2, 3, colorScheme$$serializer, null);
            FontAlias fontAlias = (FontAlias) cVarB.n(descriptor2, 4, FontAlias$$serializer.INSTANCE, null);
            String strM44unboximpl = fontAlias != null ? fontAlias.m44unboximpl() : null;
            FontWeight fontWeight2 = (FontWeight) cVarB.h(descriptor2, 5, FontWeightDeserializer.INSTANCE, null);
            Integer num2 = (Integer) cVarB.n(descriptor2, 6, j0.f8162a, null);
            int iIntValue = ((Number) cVarB.h(descriptor2, 7, FontSizeSerializer.INSTANCE, 0)).intValue();
            HorizontalAlignment horizontalAlignment2 = (HorizontalAlignment) cVarB.h(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, null);
            Size size2 = (Size) cVarB.h(descriptor2, 9, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            Padding padding3 = (Padding) cVarB.h(descriptor2, 10, padding$$serializer, null);
            padding = (Padding) cVarB.h(descriptor2, 11, padding$$serializer, null);
            str = strM228unboximpl;
            list = (List) cVarB.h(descriptor2, 12, bVarArr[12], null);
            bool = bool3;
            size = size2;
            i11 = iIntValue;
            num = num2;
            fontWeight = fontWeight2;
            colorScheme = colorScheme4;
            horizontalAlignment = horizontalAlignment2;
            str2 = strM44unboximpl;
            i10 = 8191;
            padding2 = padding3;
            colorScheme2 = colorScheme3;
        } else {
            int i14 = 0;
            int i15 = 12;
            int i16 = 1;
            Size size3 = null;
            Padding padding4 = null;
            String strM228unboximpl2 = null;
            Padding padding5 = null;
            FontWeight fontWeight3 = null;
            HorizontalAlignment horizontalAlignment3 = null;
            Integer num3 = null;
            List list2 = null;
            ColorScheme colorScheme5 = null;
            String strM44unboximpl2 = null;
            ColorScheme colorScheme6 = null;
            int i17 = 0;
            int iIntValue2 = 0;
            while (i16 != 0) {
                int iW = cVarB.w(descriptor2);
                switch (iW) {
                    case -1:
                        i16 = i14;
                        i13 = 8;
                        i15 = 12;
                        break;
                    case 0:
                        ColorScheme colorScheme7 = colorScheme5;
                        ColorScheme colorScheme8 = colorScheme6;
                        int i18 = i14;
                        LocalizationKey localizationKey2 = (LocalizationKey) cVarB.h(descriptor2, i18, LocalizationKey$$serializer.INSTANCE, strM228unboximpl2 != null ? LocalizationKey.m222boximpl(strM228unboximpl2) : null);
                        strM228unboximpl2 = localizationKey2 != null ? localizationKey2.m228unboximpl() : null;
                        i17 |= 1;
                        colorScheme5 = colorScheme7;
                        colorScheme6 = colorScheme8;
                        i14 = i18;
                        i12 = 9;
                        i13 = 8;
                        i15 = 12;
                        break;
                    case 1:
                        colorScheme6 = (ColorScheme) cVarB.h(descriptor2, 1, ColorScheme$$serializer.INSTANCE, colorScheme6);
                        i17 |= 2;
                        i12 = 9;
                        i13 = 8;
                        i15 = 12;
                        break;
                    case 2:
                        bool2 = (Boolean) cVarB.n(descriptor2, 2, h.f8149a, bool2);
                        i17 |= 4;
                        i12 = 9;
                        i13 = 8;
                        i15 = 12;
                        break;
                    case 3:
                        colorScheme5 = (ColorScheme) cVarB.n(descriptor2, 3, ColorScheme$$serializer.INSTANCE, colorScheme5);
                        i17 |= 8;
                        i12 = 9;
                        i13 = 8;
                        i15 = 12;
                        break;
                    case 4:
                        FontAlias fontAlias2 = (FontAlias) cVarB.n(descriptor2, 4, FontAlias$$serializer.INSTANCE, strM44unboximpl2 != null ? FontAlias.m38boximpl(strM44unboximpl2) : null);
                        strM44unboximpl2 = fontAlias2 != null ? fontAlias2.m44unboximpl() : null;
                        i17 |= 16;
                        i12 = 9;
                        i13 = 8;
                        i15 = 12;
                        break;
                    case 5:
                        c10 = 7;
                        fontWeight3 = (FontWeight) cVarB.h(descriptor2, 5, FontWeightDeserializer.INSTANCE, fontWeight3);
                        i17 |= 32;
                        i12 = 9;
                        i13 = 8;
                        i15 = 12;
                        break;
                    case 6:
                        c10 = 7;
                        num3 = (Integer) cVarB.n(descriptor2, 6, j0.f8162a, num3);
                        i17 |= 64;
                        i12 = 9;
                        i13 = 8;
                        i15 = 12;
                        break;
                    case 7:
                        c10 = 7;
                        iIntValue2 = ((Number) cVarB.h(descriptor2, 7, FontSizeSerializer.INSTANCE, Integer.valueOf(iIntValue2))).intValue();
                        i17 |= 128;
                        i12 = 9;
                        i13 = 8;
                        i15 = 12;
                        break;
                    case 8:
                        horizontalAlignment3 = (HorizontalAlignment) cVarB.h(descriptor2, i13, HorizontalAlignmentDeserializer.INSTANCE, horizontalAlignment3);
                        i17 |= 256;
                        i15 = 12;
                        break;
                    case 9:
                        size3 = (Size) cVarB.h(descriptor2, i12, Size$$serializer.INSTANCE, size3);
                        i17 |= 512;
                        i15 = 12;
                        break;
                    case 10:
                        padding5 = (Padding) cVarB.h(descriptor2, 10, Padding$$serializer.INSTANCE, padding5);
                        i17 |= 1024;
                        i15 = 12;
                        break;
                    case 11:
                        padding4 = (Padding) cVarB.h(descriptor2, 11, Padding$$serializer.INSTANCE, padding4);
                        i17 |= 2048;
                        i15 = 12;
                        break;
                    case 12:
                        list2 = (List) cVarB.h(descriptor2, i15, bVarArr[i15], list2);
                        i17 |= 4096;
                        break;
                    default:
                        throw new m(iW);
                }
            }
            size = size3;
            padding = padding4;
            bool = bool2;
            str = strM228unboximpl2;
            colorScheme = colorScheme5;
            padding2 = padding5;
            i10 = i17;
            fontWeight = fontWeight3;
            colorScheme2 = colorScheme6;
            horizontalAlignment = horizontalAlignment3;
            num = num3;
            list = list2;
            i11 = iIntValue2;
            str2 = strM44unboximpl2;
        }
        cVarB.c(descriptor2);
        return new TextComponent(i10, str, colorScheme2, bool, colorScheme, str2, fontWeight, num, i11, horizontalAlignment, size, padding2, padding, list, null, null);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return descriptor;
    }

    @Override // zg.k
    public void serialize(f encoder, TextComponent value) {
        t.f(encoder, "encoder");
        t.f(value, "value");
        bh.e descriptor2 = getDescriptor();
        d dVarB = encoder.b(descriptor2);
        TextComponent.write$Self$purchases_defaultsBc8Release(value, dVarB, descriptor2);
        dVarB.c(descriptor2);
    }

    @Override // dh.e0
    public b[] typeParametersSerializers() {
        return e0.a.a(this);
    }
}
