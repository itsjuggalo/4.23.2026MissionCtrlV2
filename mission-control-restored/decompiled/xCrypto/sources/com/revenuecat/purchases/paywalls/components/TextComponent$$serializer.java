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
import J3.C0335h;
import J3.H;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
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
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class TextComponent$$serializer implements C {
    public static final TextComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        TextComponent$$serializer textComponent$$serializer = new TextComponent$$serializer();
        INSTANCE = textComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("text", textComponent$$serializer, 13);
        c0327b0.l("text_lid", false);
        c0327b0.l("color", false);
        c0327b0.l("visible", true);
        c0327b0.l("background_color", true);
        c0327b0.l("font_name", true);
        c0327b0.l("font_weight", true);
        c0327b0.l("font_weight_int", true);
        c0327b0.l("font_size", true);
        c0327b0.l("horizontal_alignment", true);
        c0327b0.l("size", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("overrides", true);
        descriptor = c0327b0;
    }

    private TextComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = TextComponent.$childSerializers;
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        b bVarP = a.p(C0335h.f929a);
        b bVarP2 = a.p(colorScheme$$serializer);
        b bVarP3 = a.p(FontAlias$$serializer.INSTANCE);
        b bVarP4 = a.p(H.f874a);
        b bVar = bVarArr[12];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{LocalizationKey$$serializer.INSTANCE, colorScheme$$serializer, bVarP, bVarP2, bVarP3, FontWeightDeserializer.INSTANCE, bVarP4, FontSizeSerializer.INSTANCE, HorizontalAlignmentDeserializer.INSTANCE, Size$$serializer.INSTANCE, padding$$serializer, padding$$serializer, bVar};
    }

    @Override // F3.a
    public TextComponent deserialize(e decoder) {
        Object objM;
        Object objY;
        Object objM2;
        Object objM3;
        Object objM4;
        Object objY2;
        Object obj;
        int i4;
        int i5;
        Object objM5;
        Object objM6;
        Object objY3;
        Object objM7;
        Object objY4;
        Object obj2;
        char c4;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr = TextComponent.$childSerializers;
        int i6 = 9;
        int i7 = 8;
        Object objM8 = null;
        if (cVarD.w()) {
            objM4 = cVarD.m(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, null);
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            Object objM9 = cVarD.m(descriptor2, 1, colorScheme$$serializer, null);
            objY2 = cVarD.y(descriptor2, 2, C0335h.f929a, null);
            objY = cVarD.y(descriptor2, 3, colorScheme$$serializer, null);
            objY4 = cVarD.y(descriptor2, 4, FontAlias$$serializer.INSTANCE, null);
            objM6 = cVarD.m(descriptor2, 5, FontWeightDeserializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 6, H.f874a, null);
            int iIntValue = ((Number) cVarD.m(descriptor2, 7, FontSizeSerializer.INSTANCE, 0)).intValue();
            objM = cVarD.m(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, null);
            objM3 = cVarD.m(descriptor2, 9, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objM5 = cVarD.m(descriptor2, 10, padding$$serializer, null);
            objM2 = cVarD.m(descriptor2, 11, padding$$serializer, null);
            objM7 = cVarD.m(descriptor2, 12, bVarArr[12], null);
            i5 = 8191;
            obj = objM9;
            i4 = iIntValue;
        } else {
            int i8 = 12;
            boolean z4 = true;
            Object objY5 = null;
            Object objM10 = null;
            Object objM11 = null;
            Object objM12 = null;
            Object objM13 = null;
            Object objM14 = null;
            Object objM15 = null;
            Object objY6 = null;
            Object objY7 = null;
            Object objY8 = null;
            Object objM16 = null;
            int i9 = 0;
            int iIntValue2 = 0;
            while (z4) {
                int i10 = cVarD.i(descriptor2);
                switch (i10) {
                    case -1:
                        z4 = false;
                        objY5 = objY5;
                        i7 = 8;
                        i8 = 12;
                        break;
                    case 0:
                        obj2 = objY5;
                        objM11 = cVarD.m(descriptor2, 0, LocalizationKey$$serializer.INSTANCE, objM11);
                        i9 |= 1;
                        objY5 = obj2;
                        i6 = 9;
                        i7 = 8;
                        i8 = 12;
                        break;
                    case 1:
                        obj2 = objY5;
                        objM16 = cVarD.m(descriptor2, 1, ColorScheme$$serializer.INSTANCE, objM16);
                        i9 |= 2;
                        objY5 = obj2;
                        i6 = 9;
                        i7 = 8;
                        i8 = 12;
                        break;
                    case 2:
                        objY6 = cVarD.y(descriptor2, 2, C0335h.f929a, objY6);
                        i9 |= 4;
                        i6 = 9;
                        i7 = 8;
                        i8 = 12;
                        break;
                    case 3:
                        i9 |= 8;
                        objY7 = cVarD.y(descriptor2, 3, ColorScheme$$serializer.INSTANCE, objY7);
                        i6 = 9;
                        i7 = 8;
                        i8 = 12;
                        break;
                    case 4:
                        objY8 = cVarD.y(descriptor2, 4, FontAlias$$serializer.INSTANCE, objY8);
                        i9 |= 16;
                        i6 = 9;
                        i7 = 8;
                        i8 = 12;
                        break;
                    case 5:
                        c4 = 7;
                        objM15 = cVarD.m(descriptor2, 5, FontWeightDeserializer.INSTANCE, objM15);
                        i9 |= 32;
                        i6 = 9;
                        i7 = 8;
                        i8 = 12;
                        break;
                    case 6:
                        c4 = 7;
                        objY5 = cVarD.y(descriptor2, 6, H.f874a, objY5);
                        i9 |= 64;
                        i6 = 9;
                        i7 = 8;
                        i8 = 12;
                        break;
                    case 7:
                        c4 = 7;
                        iIntValue2 = ((Number) cVarD.m(descriptor2, 7, FontSizeSerializer.INSTANCE, Integer.valueOf(iIntValue2))).intValue();
                        i9 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        i6 = 9;
                        i7 = 8;
                        i8 = 12;
                        break;
                    case 8:
                        objM13 = cVarD.m(descriptor2, i7, HorizontalAlignmentDeserializer.INSTANCE, objM13);
                        i9 |= 256;
                        i8 = 12;
                        break;
                    case 9:
                        objM8 = cVarD.m(descriptor2, i6, Size$$serializer.INSTANCE, objM8);
                        i9 |= 512;
                        i8 = 12;
                        break;
                    case 10:
                        objM12 = cVarD.m(descriptor2, 10, Padding$$serializer.INSTANCE, objM12);
                        i9 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        i8 = 12;
                        break;
                    case 11:
                        objM10 = cVarD.m(descriptor2, 11, Padding$$serializer.INSTANCE, objM10);
                        i9 |= 2048;
                        i8 = 12;
                        break;
                    case 12:
                        objM14 = cVarD.m(descriptor2, i8, bVarArr[i8], objM14);
                        i9 |= 4096;
                        break;
                    default:
                        throw new j(i10);
                }
            }
            Object obj3 = objY5;
            objM = objM13;
            objY = objY7;
            objM2 = objM10;
            objM3 = objM8;
            objM4 = objM11;
            objY2 = objY6;
            obj = objM16;
            i4 = iIntValue2;
            i5 = i9;
            objM5 = objM12;
            objM6 = objM15;
            objY3 = obj3;
            objM7 = objM14;
            objY4 = objY8;
        }
        cVarD.c(descriptor2);
        LocalizationKey localizationKey = (LocalizationKey) objM4;
        FontAlias fontAlias = (FontAlias) objY4;
        return new TextComponent(i5, localizationKey != null ? localizationKey.m199unboximpl() : null, (ColorScheme) obj, (Boolean) objY2, (ColorScheme) objY, fontAlias != null ? fontAlias.m66unboximpl() : null, (FontWeight) objM6, (Integer) objY3, i4, (HorizontalAlignment) objM, (Size) objM3, (Padding) objM5, (Padding) objM2, (List) objM7, null, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, TextComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        TextComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
