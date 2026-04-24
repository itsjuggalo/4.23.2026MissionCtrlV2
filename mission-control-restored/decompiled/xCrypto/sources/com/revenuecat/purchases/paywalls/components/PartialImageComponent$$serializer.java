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
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey;
import com.revenuecat.purchases.paywalls.components.common.LocalizationKey$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Border;
import com.revenuecat.purchases.paywalls.components.properties.Border$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme;
import com.revenuecat.purchases.paywalls.components.properties.ColorScheme$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.FitMode;
import com.revenuecat.purchases.paywalls.components.properties.FitModeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.MaskShape;
import com.revenuecat.purchases.paywalls.components.properties.MaskShapeDeserializer;
import com.revenuecat.purchases.paywalls.components.properties.Padding;
import com.revenuecat.purchases.paywalls.components.properties.Padding$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Shadow;
import com.revenuecat.purchases.paywalls.components.properties.Shadow$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.Size;
import com.revenuecat.purchases.paywalls.components.properties.Size$$serializer;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls;
import com.revenuecat.purchases.paywalls.components.properties.ThemeImageUrls$$serializer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class PartialImageComponent$$serializer implements C {
    public static final PartialImageComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        PartialImageComponent$$serializer partialImageComponent$$serializer = new PartialImageComponent$$serializer();
        INSTANCE = partialImageComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("com.revenuecat.purchases.paywalls.components.PartialImageComponent", partialImageComponent$$serializer, 11);
        c0327b0.l("visible", true);
        c0327b0.l("source", true);
        c0327b0.l("size", true);
        c0327b0.l("override_source_lid", true);
        c0327b0.l("fit_mode", true);
        c0327b0.l("mask_shape", true);
        c0327b0.l("color_overlay", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("border", true);
        c0327b0.l("shadow", true);
        descriptor = c0327b0;
    }

    private PartialImageComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b bVarP = a.p(C0335h.f929a);
        b bVarP2 = a.p(ThemeImageUrls$$serializer.INSTANCE);
        b bVarP3 = a.p(Size$$serializer.INSTANCE);
        b bVarP4 = a.p(LocalizationKey$$serializer.INSTANCE);
        b bVarP5 = a.p(FitModeDeserializer.INSTANCE);
        b bVarP6 = a.p(MaskShapeDeserializer.INSTANCE);
        b bVarP7 = a.p(ColorScheme$$serializer.INSTANCE);
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{bVarP, bVarP2, bVarP3, bVarP4, bVarP5, bVarP6, bVarP7, a.p(padding$$serializer), a.p(padding$$serializer), a.p(Border$$serializer.INSTANCE), a.p(Shadow$$serializer.INSTANCE)};
    }

    @Override // F3.a
    public PartialImageComponent deserialize(e decoder) {
        Object objY;
        Object objY2;
        Object objY3;
        Object objY4;
        Object objY5;
        Object objY6;
        Object objY7;
        Object objY8;
        Object objY9;
        int i4;
        Object objY10;
        Object objY11;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        int i5 = 10;
        int i6 = 9;
        int i7 = 7;
        int i8 = 6;
        int i9 = 8;
        Object objY12 = null;
        if (cVarD.w()) {
            objY = cVarD.y(descriptor2, 0, C0335h.f929a, null);
            objY2 = cVarD.y(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, null);
            objY7 = cVarD.y(descriptor2, 2, Size$$serializer.INSTANCE, null);
            objY6 = cVarD.y(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, null);
            objY10 = cVarD.y(descriptor2, 4, FitModeDeserializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 5, MaskShapeDeserializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 6, ColorScheme$$serializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objY8 = cVarD.y(descriptor2, 7, padding$$serializer, null);
            objY4 = cVarD.y(descriptor2, 8, padding$$serializer, null);
            objY9 = cVarD.y(descriptor2, 9, Border$$serializer.INSTANCE, null);
            objY11 = cVarD.y(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            i4 = 2047;
        } else {
            boolean z4 = true;
            int i10 = 0;
            objY = null;
            Object objY13 = null;
            Object objY14 = null;
            Object objY15 = null;
            Object objY16 = null;
            Object objY17 = null;
            Object objY18 = null;
            Object objY19 = null;
            Object objY20 = null;
            Object objY21 = null;
            while (z4) {
                int i11 = cVarD.i(descriptor2);
                switch (i11) {
                    case -1:
                        z4 = false;
                        i5 = 10;
                        i6 = 9;
                        i7 = 7;
                        i8 = 6;
                        i9 = 8;
                        break;
                    case 0:
                        objY = cVarD.y(descriptor2, 0, C0335h.f929a, objY);
                        i10 |= 1;
                        i5 = 10;
                        i6 = 9;
                        i7 = 7;
                        i8 = 6;
                        i9 = 8;
                        break;
                    case 1:
                        objY21 = cVarD.y(descriptor2, 1, ThemeImageUrls$$serializer.INSTANCE, objY21);
                        i10 |= 2;
                        i5 = 10;
                        i6 = 9;
                        i7 = 7;
                        i8 = 6;
                        i9 = 8;
                        break;
                    case 2:
                        objY20 = cVarD.y(descriptor2, 2, Size$$serializer.INSTANCE, objY20);
                        i10 |= 4;
                        i5 = 10;
                        i6 = 9;
                        i7 = 7;
                        i8 = 6;
                        break;
                    case 3:
                        i10 |= 8;
                        objY18 = cVarD.y(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, objY18);
                        i5 = 10;
                        i6 = 9;
                        i7 = 7;
                        break;
                    case 4:
                        i10 |= 16;
                        objY19 = cVarD.y(descriptor2, 4, FitModeDeserializer.INSTANCE, objY19);
                        i5 = 10;
                        i6 = 9;
                        break;
                    case 5:
                        objY14 = cVarD.y(descriptor2, 5, MaskShapeDeserializer.INSTANCE, objY14);
                        i10 |= 32;
                        i5 = 10;
                        break;
                    case 6:
                        objY15 = cVarD.y(descriptor2, i8, ColorScheme$$serializer.INSTANCE, objY15);
                        i10 |= 64;
                        break;
                    case 7:
                        objY16 = cVarD.y(descriptor2, i7, Padding$$serializer.INSTANCE, objY16);
                        i10 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        break;
                    case 8:
                        objY13 = cVarD.y(descriptor2, i9, Padding$$serializer.INSTANCE, objY13);
                        i10 |= 256;
                        break;
                    case 9:
                        objY12 = cVarD.y(descriptor2, i6, Border$$serializer.INSTANCE, objY12);
                        i10 |= 512;
                        break;
                    case 10:
                        objY17 = cVarD.y(descriptor2, i5, Shadow$$serializer.INSTANCE, objY17);
                        i10 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        break;
                    default:
                        throw new j(i11);
                }
            }
            Object obj = objY15;
            objY2 = objY21;
            objY3 = obj;
            objY4 = objY13;
            objY5 = objY14;
            objY6 = objY18;
            objY7 = objY20;
            objY8 = objY16;
            objY9 = objY12;
            i4 = i10;
            objY10 = objY19;
            objY11 = objY17;
        }
        cVarD.c(descriptor2);
        LocalizationKey localizationKey = (LocalizationKey) objY6;
        return new PartialImageComponent(i4, (Boolean) objY, (ThemeImageUrls) objY2, (Size) objY7, localizationKey != null ? localizationKey.m199unboximpl() : null, (FitMode) objY10, (MaskShape) objY5, (ColorScheme) objY3, (Padding) objY8, (Padding) objY4, (Border) objY9, (Shadow) objY11, null, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, PartialImageComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        PartialImageComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
