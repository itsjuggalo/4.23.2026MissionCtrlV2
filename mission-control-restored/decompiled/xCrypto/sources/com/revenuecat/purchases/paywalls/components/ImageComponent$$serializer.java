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
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class ImageComponent$$serializer implements C {
    public static final ImageComponent$$serializer INSTANCE;
    private static final /* synthetic */ C0327b0 descriptor;

    static {
        ImageComponent$$serializer imageComponent$$serializer = new ImageComponent$$serializer();
        INSTANCE = imageComponent$$serializer;
        C0327b0 c0327b0 = new C0327b0("image", imageComponent$$serializer, 12);
        c0327b0.l("source", false);
        c0327b0.l("visible", true);
        c0327b0.l("size", true);
        c0327b0.l("override_source_lid", true);
        c0327b0.l("mask_shape", true);
        c0327b0.l("color_overlay", true);
        c0327b0.l("fit_mode", true);
        c0327b0.l("padding", true);
        c0327b0.l("margin", true);
        c0327b0.l("border", true);
        c0327b0.l("shadow", true);
        c0327b0.l("overrides", true);
        descriptor = c0327b0;
    }

    private ImageComponent$$serializer() {
    }

    @Override // J3.C
    public b[] childSerializers() {
        b[] bVarArr = ImageComponent.$childSerializers;
        b bVarP = a.p(C0335h.f929a);
        b bVarP2 = a.p(LocalizationKey$$serializer.INSTANCE);
        b bVarP3 = a.p(MaskShapeDeserializer.INSTANCE);
        b bVarP4 = a.p(ColorScheme$$serializer.INSTANCE);
        b bVarP5 = a.p(Border$$serializer.INSTANCE);
        b bVarP6 = a.p(Shadow$$serializer.INSTANCE);
        b bVar = bVarArr[11];
        Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
        return new b[]{ThemeImageUrls$$serializer.INSTANCE, bVarP, Size$$serializer.INSTANCE, bVarP2, bVarP3, bVarP4, FitModeDeserializer.INSTANCE, padding$$serializer, padding$$serializer, bVarP5, bVarP6, bVar};
    }

    @Override // F3.a
    public ImageComponent deserialize(e decoder) {
        Object objM;
        Object objM2;
        Object objM3;
        Object objM4;
        Object objY;
        Object objY2;
        Object objM5;
        Object objY3;
        Object objY4;
        int i4;
        Object objM6;
        Object objY5;
        Object objY6;
        b[] bVarArr;
        Object objM7;
        r.f(decoder, "decoder");
        H3.e descriptor2 = getDescriptor();
        c cVarD = decoder.d(descriptor2);
        b[] bVarArr2 = ImageComponent.$childSerializers;
        int i5 = 10;
        int i6 = 9;
        int i7 = 8;
        Object objM8 = null;
        if (cVarD.w()) {
            objM = cVarD.m(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, null);
            objY2 = cVarD.y(descriptor2, 1, C0335h.f929a, null);
            objM4 = cVarD.m(descriptor2, 2, Size$$serializer.INSTANCE, null);
            objY5 = cVarD.y(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, null);
            objY4 = cVarD.y(descriptor2, 4, MaskShapeDeserializer.INSTANCE, null);
            objY3 = cVarD.y(descriptor2, 5, ColorScheme$$serializer.INSTANCE, null);
            objM6 = cVarD.m(descriptor2, 6, FitModeDeserializer.INSTANCE, null);
            Padding$$serializer padding$$serializer = Padding$$serializer.INSTANCE;
            objM2 = cVarD.m(descriptor2, 7, padding$$serializer, null);
            objM5 = cVarD.m(descriptor2, 8, padding$$serializer, null);
            objY = cVarD.y(descriptor2, 9, Border$$serializer.INSTANCE, null);
            objY6 = cVarD.y(descriptor2, 10, Shadow$$serializer.INSTANCE, null);
            objM3 = cVarD.m(descriptor2, 11, bVarArr2[11], null);
            i4 = 4095;
        } else {
            int i8 = 11;
            Object objM9 = null;
            Object objM10 = null;
            Object objY7 = null;
            Object objM11 = null;
            Object obj = null;
            Object objY8 = null;
            Object objY9 = null;
            Object objM12 = null;
            Object objY10 = null;
            boolean z4 = true;
            int i9 = 0;
            Object objY11 = null;
            Object objY12 = null;
            while (z4) {
                int i10 = cVarD.i(descriptor2);
                switch (i10) {
                    case -1:
                        bVarArr = bVarArr2;
                        objM7 = obj;
                        z4 = false;
                        i8 = 11;
                        i5 = 10;
                        i6 = 9;
                        i7 = 8;
                        obj = objM7;
                        bVarArr2 = bVarArr;
                        break;
                    case 0:
                        bVarArr = bVarArr2;
                        objM7 = cVarD.m(descriptor2, 0, ThemeImageUrls$$serializer.INSTANCE, obj);
                        i9 |= 1;
                        objY9 = objY9;
                        i8 = 11;
                        i5 = 10;
                        i6 = 9;
                        i7 = 8;
                        obj = objM7;
                        bVarArr2 = bVarArr;
                        break;
                    case 1:
                        objY10 = cVarD.y(descriptor2, 1, C0335h.f929a, objY10);
                        i9 |= 2;
                        bVarArr2 = bVarArr2;
                        i8 = 11;
                        i5 = 10;
                        i6 = 9;
                        i7 = 8;
                        break;
                    case 2:
                        objM12 = cVarD.m(descriptor2, 2, Size$$serializer.INSTANCE, objM12);
                        i9 |= 4;
                        i8 = 11;
                        i5 = 10;
                        i6 = 9;
                        i7 = 8;
                        break;
                    case 3:
                        objY8 = cVarD.y(descriptor2, 3, LocalizationKey$$serializer.INSTANCE, objY8);
                        i9 |= 8;
                        i8 = 11;
                        i5 = 10;
                        i6 = 9;
                        break;
                    case 4:
                        objY9 = cVarD.y(descriptor2, 4, MaskShapeDeserializer.INSTANCE, objY9);
                        i9 |= 16;
                        i8 = 11;
                        i5 = 10;
                        break;
                    case 5:
                        objY7 = cVarD.y(descriptor2, 5, ColorScheme$$serializer.INSTANCE, objY7);
                        i9 |= 32;
                        i8 = 11;
                        break;
                    case 6:
                        objM10 = cVarD.m(descriptor2, 6, FitModeDeserializer.INSTANCE, objM10);
                        i9 |= 64;
                        i8 = 11;
                        break;
                    case 7:
                        objM11 = cVarD.m(descriptor2, 7, Padding$$serializer.INSTANCE, objM11);
                        i9 |= UserMetadata.MAX_ROLLOUT_ASSIGNMENTS;
                        i8 = 11;
                        break;
                    case 8:
                        objM9 = cVarD.m(descriptor2, i7, Padding$$serializer.INSTANCE, objM9);
                        i9 |= 256;
                        break;
                    case 9:
                        objY11 = cVarD.y(descriptor2, i6, Border$$serializer.INSTANCE, objY11);
                        i9 |= 512;
                        break;
                    case 10:
                        objY12 = cVarD.y(descriptor2, i5, Shadow$$serializer.INSTANCE, objY12);
                        i9 |= UserMetadata.MAX_ATTRIBUTE_SIZE;
                        break;
                    case 11:
                        objM8 = cVarD.m(descriptor2, i8, bVarArr2[i8], objM8);
                        i9 |= 2048;
                        break;
                    default:
                        throw new j(i10);
                }
            }
            objM = obj;
            objM2 = objM11;
            objM3 = objM8;
            objM4 = objM12;
            objY = objY11;
            objY2 = objY10;
            objM5 = objM9;
            objY3 = objY7;
            objY4 = objY9;
            i4 = i9;
            objM6 = objM10;
            objY5 = objY8;
            objY6 = objY12;
        }
        cVarD.c(descriptor2);
        LocalizationKey localizationKey = (LocalizationKey) objY5;
        return new ImageComponent(i4, (ThemeImageUrls) objM, (Boolean) objY2, (Size) objM4, localizationKey != null ? localizationKey.m199unboximpl() : null, (MaskShape) objY4, (ColorScheme) objY3, (FitMode) objM6, (Padding) objM2, (Padding) objM5, (Border) objY, (Shadow) objY6, (List) objM3, null, null);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return descriptor;
    }

    @Override // F3.h
    public void serialize(f encoder, ImageComponent value) {
        r.f(encoder, "encoder");
        r.f(value, "value");
        H3.e descriptor2 = getDescriptor();
        d dVarD = encoder.d(descriptor2);
        ImageComponent.write$Self(value, dVarD, descriptor2);
        dVarD.c(descriptor2);
    }

    @Override // J3.C
    public b[] typeParametersSerializers() {
        return C.a.a(this);
    }
}
