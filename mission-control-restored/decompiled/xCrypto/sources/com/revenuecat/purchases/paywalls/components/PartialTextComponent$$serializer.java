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
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PartialTextComponent$$serializer implements C {
    public static final PartialTextComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PartialTextComponent$$serializer partialTextComponent$$serializer = new PartialTextComponent$$serializer();
        INSTANCE = partialTextComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.PartialTextComponent", partialTextComponent$$serializer, 12);
        c0327b0.l("visible", true);
        c0327b0.l("text_lid", true);
        c0327b0.l("color", true);
        c0327b0.l("background_color", true);
        c0327b0.l("font_name", true);
        c0327b0.l("font_weight", true);
        c0327b0.l("font_weight_int", true);
        c0327b0.l("font_size", true);
        c0327b0.l("horizontal_alignment", true);
        c0327b0.l("size", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        descriptor = c0327b0;
    }

    private PartialTextComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVarP = a.p(C0335h.f929a);
        b bVarP2 = a.p(LocalizationKey$$serializer.INSTANCE);
        ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
        b bVarP3 = a.p(colorScheme$$serializer);
        b bVarP4 = a.p(colorScheme$$serializer);
        b bVarP5 = a.p(FontAlias$$serializer.INSTANCE);
        b bVarP6 = a.p(FontWeightDeserializer.INSTANCE);
        b bVarP7 = a.p(H.f874a);
        b bVarP8 = a.p(FontSizeSerializer.INSTANCE);
        b bVarP9 = a.p(HorizontalAlignmentDeserializer.INSTANCE);
        b bVarP10 = a.p(Size$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVarP7, bVarP8, bVarP9, bVarP10, a.p(padding$$serializer), a.p(padding$$serializer)};
    }

    @Override // F3.a
    public PartialTextComponent deserialize(e decoder) {
        Object objY;
        Object objY2;
        Object objY3;
        Object objY4;
        int i4;
        Object objY5;
        Object objY6;
        Object objY7;
        Object objY8;
        Object objY9;
        Object objY10;
        Object objY11;
        Object objY12;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i5 = 11;
        int i6 = 10;
        int i7 = 9;
        int i8 = 8;
        Object objY13 = null;
        if (cVarD.w()) {
            objY = cVarD.y(descriptor2, 0, C0335h.f929a, null);
            objY8 = cVarD.y(descriptor2, 1, LocalizationKey$$serializer.INSTANCE, null);
            ColorScheme$$serializer colorScheme$$serializer = ColorScheme$$serializer.INSTANCE;
            objY4 = cVarD.y(descriptor2, 2, colorScheme$$serializer, null);
            objY7 = cVarD.y(descriptor2, 3, colorScheme$$serializer, null);
            objY12 = cVarD.y(descriptor2, 4, FontAlias$$serializer.INSTANCE, null);
            objY11 = cVarD.y(descriptor2, 5, FontWeightDeserializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 6, H.f874a, null);
            objY2 = cVarD.y(descriptor2, 7, FontSizeSerializer.INSTANCE, null);
            objY10 = cVarD.y(descriptor2, 8, HorizontalAlignmentDeserializer.INSTANCE, null);
            objY6 = cVarD.y(descriptor2, 9, Size$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objY9 = cVarD.y(descriptor2, 10, padding$$serializer, null);
            objY3 = cVarD.y(descriptor2, 11, padding$$serializer, null);
            i4 = 4095;
        } else {
            boolean z4 = true;
            int i9 = 0;
            objY = null;
            Object objY14 = null;
            Object objY15 = null;
            Object objY16 = null;
            Object objY17 = null;
            Object objY18 = null;
            Object objY19 = null;
            Object objY20 = null;
            Object objY21 = null;
            Object objY22 = null;
            Object objY23 = null;
            while (z4) {
                int i10 = cVarD.i(descriptor2);
                switch (i10) {
                    case -1:
                        z4 = false;
                        i5 = 11;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                        break;
                    case 0:
                        objY = cVarD.y(descriptor2, 0, C0335h.f929a, objY);
                        i9 |= 1;
                        i5 = 11;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                        break;
                    case 1:
                        objY23 = cVarD.y(descriptor2, 1, LocalizationKey$$serializer.INSTANCE, objY23);
                        i9 |= 2;
                        objY21 = objY21;
                        i5 = 11;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                        break;
                    case 2:
                        objY22 = cVarD.y(descriptor2, 2, ColorScheme$$serializer.INSTANCE, objY22);
                        i9 |= 4;
                        i5 = 11;
                        i6 = 10;
                        i7 = 9;
                        i8 = 8;
                        break;
                    case 3:
                        objY20 = cVarD.y(descriptor2, 3, ColorScheme$$serializer.INSTANCE, objY20);
                        i9 |= 8;
                        i5 = 11;
                        i6 = 10;
                        i7 = 9;
                        break;
                    case 4:
                        objY21 = cVarD.y(descriptor2, 4, FontAlias$$serializer.INSTANCE, objY21);
                        i9 |= 16;
                        i5 = 11;
                        i6 = 10;
                        break;
                    case 5:
                        objY16 = cVarD.y(descriptor2, 5, FontWeightDeserializer.INSTANCE, objY16);
                        i9 |= 32;
                        i5 = 11;
                        break;
                    case 6:
                        objY15 = cVarD.y(descriptor2, 6, H.f874a, objY15);
                        i9 |= 64;
                        i5 = 11;
                        break;
                    case 7:
                        objY17 = cVarD.y(descriptor2, 7, FontSizeSerializer.INSTANCE, objY17);
                        i9 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        i5 = 11;
                        break;
                    case 8:
                        objY14 = cVarD.y(descriptor2, i8, HorizontalAlignmentDeserializer.INSTANCE, objY14);
                        i9 |= 256;
                        break;
                    case 9:
                        objY18 = cVarD.y(descriptor2, i7, Size$$serializer.INSTANCE, objY18);
                        i9 |= 512;
                        break;
                    case 10:
                        objY19 = cVarD.y(descriptor2, i6, Padding$$serializer.INSTANCE, objY19);
                        i9 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        break;
                    case 11:
                        objY13 = cVarD.y(descriptor2, i5, Padding$$serializer.INSTANCE, objY13);
                        i9 |= 2048;
                        break;
                    default:
                        throw new j(i10);
                }
            }
            objY2 = objY17;
            objY3 = objY13;
            objY4 = objY22;
            i4 = i9;
            objY5 = objY15;
            objY6 = objY18;
            objY7 = objY20;
            objY8 = objY23;
            objY9 = objY19;
            objY10 = objY14;
            objY11 = objY16;
            objY12 = objY21;
        }
        cVarD.c(descriptor2);
        LocalizationKey localizationKey = (LocalizationKey) objY8;
        FontAlias fontAlias = (FontAlias) objY12;
        return new PartialTextComponent(i4, (Boolean) objY, localizationKey != null ? localizationKey.m199unboximpl() : null, (ColorScheme) objY4, (ColorScheme) objY7, fontAlias != null ? fontAlias.m66unboximpl() : null, (FontWeight) objY11, (Integer) objY5, (Integer) objY2, (HorizontalAlignment) objY10, (Size) objY6, (Padding) objY9, (Padding) objY3, null, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PartialTextComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PartialTextComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
